package com.shuyu.gsyvideoplayer.utils;

import androidx.core.app.FrameMetricsAggregator;
import java.io.OutputStream;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class LZWEncoder {
    static final int BITS = 12;
    private static final int EOF = -1;
    static final int HSIZE = 5003;
    int ClearCode;
    int EOFCode;
    int a_count;
    private int curPixel;
    int g_init_bits;
    private int imgH;
    private int imgW;
    private int initCodeSize;
    int maxcode;
    int n_bits;
    private byte[] pixAry;
    private int remaining;
    int maxbits = 12;
    int maxmaxcode = 4096;
    int[] htab = new int[HSIZE];
    int[] codetab = new int[HSIZE];
    int hsize = HSIZE;
    int free_ent = 0;
    boolean clear_flg = false;
    int cur_accum = 0;
    int cur_bits = 0;
    int[] masks = {0, 1, 3, 7, 15, 31, 63, 127, 255, FrameMetricsAggregator.EVERY_DURATION, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    byte[] accum = new byte[256];

    public LZWEncoder(int i3, int i5, byte[] bArr, int i6) {
        this.imgW = i3;
        this.imgH = i5;
        this.pixAry = bArr;
        this.initCodeSize = Math.max(2, i6);
    }

    private int nextPixel() {
        int i3 = this.remaining;
        if (i3 == 0) {
            return -1;
        }
        this.remaining = i3 - 1;
        byte[] bArr = this.pixAry;
        int i5 = this.curPixel;
        this.curPixel = i5 + 1;
        return bArr[i5] & 255;
    }

    public final int MAXCODE(int i3) {
        return (1 << i3) - 1;
    }

    public void char_out(byte b, OutputStream outputStream) {
        byte[] bArr = this.accum;
        int i3 = this.a_count;
        int i5 = i3 + 1;
        this.a_count = i5;
        bArr[i3] = b;
        if (i5 >= 254) {
            flush_char(outputStream);
        }
    }

    public void cl_block(OutputStream outputStream) {
        cl_hash(this.hsize);
        int i3 = this.ClearCode;
        this.free_ent = i3 + 2;
        this.clear_flg = true;
        output(i3, outputStream);
    }

    public void cl_hash(int i3) {
        for (int i5 = 0; i5 < i3; i5++) {
            this.htab[i5] = -1;
        }
    }

    public void compress(int i3, OutputStream outputStream) {
        int i5;
        this.g_init_bits = i3;
        int i6 = 0;
        this.clear_flg = false;
        this.n_bits = i3;
        this.maxcode = MAXCODE(i3);
        int i7 = 1 << (i3 - 1);
        this.ClearCode = i7;
        this.EOFCode = i7 + 1;
        this.free_ent = i7 + 2;
        this.a_count = 0;
        int nextPixel = nextPixel();
        for (int i8 = this.hsize; i8 < 65536; i8 *= 2) {
            i6++;
        }
        int i9 = 8 - i6;
        int i10 = this.hsize;
        cl_hash(i10);
        output(this.ClearCode, outputStream);
        while (true) {
            int nextPixel2 = nextPixel();
            if (nextPixel2 != -1) {
                int i11 = (nextPixel2 << this.maxbits) + nextPixel;
                int i12 = (nextPixel2 << i9) ^ nextPixel;
                int i13 = this.htab[i12];
                if (i13 == i11) {
                    nextPixel = this.codetab[i12];
                } else {
                    if (i13 >= 0) {
                        int i14 = i10 - i12;
                        if (i12 == 0) {
                            i14 = 1;
                        }
                        do {
                            i12 -= i14;
                            if (i12 < 0) {
                                i12 += i10;
                            }
                            i5 = this.htab[i12];
                            if (i5 == i11) {
                                nextPixel = this.codetab[i12];
                                break;
                            }
                        } while (i5 >= 0);
                    }
                    output(nextPixel, outputStream);
                    int i15 = this.free_ent;
                    if (i15 < this.maxmaxcode) {
                        int[] iArr = this.codetab;
                        this.free_ent = i15 + 1;
                        iArr[i12] = i15;
                        this.htab[i12] = i11;
                    } else {
                        cl_block(outputStream);
                    }
                    nextPixel = nextPixel2;
                }
            } else {
                output(nextPixel, outputStream);
                output(this.EOFCode, outputStream);
                return;
            }
        }
    }

    public void encode(OutputStream outputStream) {
        outputStream.write(this.initCodeSize);
        this.remaining = this.imgW * this.imgH;
        this.curPixel = 0;
        compress(this.initCodeSize + 1, outputStream);
        outputStream.write(0);
    }

    public void flush_char(OutputStream outputStream) {
        int i3 = this.a_count;
        if (i3 > 0) {
            outputStream.write(i3);
            outputStream.write(this.accum, 0, this.a_count);
            this.a_count = 0;
        }
    }

    public void output(int i3, OutputStream outputStream) {
        int i5 = this.cur_accum;
        int[] iArr = this.masks;
        int i6 = this.cur_bits;
        int i7 = i5 & iArr[i6];
        this.cur_accum = i7;
        if (i6 > 0) {
            this.cur_accum = i7 | (i3 << i6);
        } else {
            this.cur_accum = i3;
        }
        this.cur_bits = i6 + this.n_bits;
        while (this.cur_bits >= 8) {
            char_out((byte) (this.cur_accum & 255), outputStream);
            this.cur_accum >>= 8;
            this.cur_bits -= 8;
        }
        if (this.free_ent > this.maxcode || this.clear_flg) {
            if (this.clear_flg) {
                int i8 = this.g_init_bits;
                this.n_bits = i8;
                this.maxcode = MAXCODE(i8);
                this.clear_flg = false;
            } else {
                int i9 = this.n_bits + 1;
                this.n_bits = i9;
                if (i9 == this.maxbits) {
                    this.maxcode = this.maxmaxcode;
                } else {
                    this.maxcode = MAXCODE(i9);
                }
            }
        }
        if (i3 == this.EOFCode) {
            while (this.cur_bits > 0) {
                char_out((byte) (this.cur_accum & 255), outputStream);
                this.cur_accum >>= 8;
                this.cur_bits -= 8;
            }
            flush_char(outputStream);
        }
    }
}
