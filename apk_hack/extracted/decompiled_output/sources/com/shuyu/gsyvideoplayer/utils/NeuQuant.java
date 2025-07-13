package com.shuyu.gsyvideoplayer.utils;

import a1.i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class NeuQuant {
    protected static final int alphabiasshift = 10;
    protected static final int alpharadbias = 262144;
    protected static final int alpharadbshift = 18;
    protected static final int beta = 64;
    protected static final int betagamma = 65536;
    protected static final int betashift = 10;
    protected static final int gamma = 1024;
    protected static final int gammashift = 10;
    protected static final int initalpha = 1024;
    protected static final int initrad = 32;
    protected static final int initradius = 2048;
    protected static final int intbias = 65536;
    protected static final int intbiasshift = 16;
    protected static final int maxnetpos = 255;
    protected static final int minpicturebytes = 1509;
    protected static final int ncycles = 100;
    protected static final int netbiasshift = 4;
    protected static final int netsize = 256;
    protected static final int prime1 = 499;
    protected static final int prime2 = 491;
    protected static final int prime3 = 487;
    protected static final int prime4 = 503;
    protected static final int radbias = 256;
    protected static final int radbiasshift = 8;
    protected static final int radiusbias = 64;
    protected static final int radiusbiasshift = 6;
    protected static final int radiusdec = 30;
    protected int alphadec;
    protected int lengthcount;
    protected int samplefac;
    protected byte[] thepicture;
    protected int[] netindex = new int[256];
    protected int[] bias = new int[256];
    protected int[] freq = new int[256];
    protected int[] radpower = new int[32];
    protected int[][] network = new int[256];

    public NeuQuant(byte[] bArr, int i3, int i5) {
        this.thepicture = bArr;
        this.lengthcount = i3;
        this.samplefac = i5;
        for (int i6 = 0; i6 < 256; i6++) {
            int[] iArr = new int[4];
            this.network[i6] = iArr;
            int i7 = (i6 << 12) / 256;
            iArr[2] = i7;
            iArr[1] = i7;
            iArr[0] = i7;
            this.freq[i6] = 256;
            this.bias[i6] = 0;
        }
    }

    public void alterneigh(int i3, int i5, int i6, int i7, int i8) {
        int i9 = i5 - i3;
        if (i9 < -1) {
            i9 = -1;
        }
        int i10 = i5 + i3;
        if (i10 > 256) {
            i10 = 256;
        }
        int i11 = i5 + 1;
        int i12 = i5 - 1;
        int i13 = 1;
        while (true) {
            if (i11 >= i10 && i12 <= i9) {
                return;
            }
            int i14 = i13 + 1;
            int i15 = this.radpower[i13];
            if (i11 < i10) {
                int i16 = i11 + 1;
                int[] iArr = this.network[i11];
                try {
                    int i17 = iArr[0];
                    iArr[0] = i17 - (((i17 - i6) * i15) / 262144);
                    int i18 = iArr[1];
                    iArr[1] = i18 - (((i18 - i7) * i15) / 262144);
                    int i19 = iArr[2];
                    iArr[2] = i19 - (((i19 - i8) * i15) / 262144);
                } catch (Exception unused) {
                }
                i11 = i16;
            }
            if (i12 > i9) {
                int i20 = i12 - 1;
                int[] iArr2 = this.network[i12];
                try {
                    int i21 = iArr2[0];
                    iArr2[0] = i21 - (((i21 - i6) * i15) / 262144);
                    int i22 = iArr2[1];
                    iArr2[1] = i22 - (((i22 - i7) * i15) / 262144);
                    int i23 = iArr2[2];
                    iArr2[2] = i23 - (((i23 - i8) * i15) / 262144);
                } catch (Exception unused2) {
                }
                i13 = i14;
                i12 = i20;
            } else {
                i13 = i14;
            }
        }
    }

    public void altersingle(int i3, int i5, int i6, int i7, int i8) {
        int[] iArr = this.network[i5];
        int i9 = iArr[0];
        iArr[0] = i.d(i9, i6, i3, 1024, i9);
        int i10 = iArr[1];
        iArr[1] = i.d(i10, i7, i3, 1024, i10);
        int i11 = iArr[2];
        iArr[2] = i.d(i11, i8, i3, 1024, i11);
    }

    public byte[] colorMap() {
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (int i3 = 0; i3 < 256; i3++) {
            iArr[this.network[i3][3]] = i3;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            int[] iArr2 = this.network[iArr[i6]];
            bArr[i5] = (byte) iArr2[0];
            int i7 = i5 + 2;
            bArr[i5 + 1] = (byte) iArr2[1];
            i5 += 3;
            bArr[i7] = (byte) iArr2[2];
        }
        return bArr;
    }

    public int contest(int i3, int i5, int i6) {
        int i7 = Integer.MAX_VALUE;
        int i8 = Integer.MAX_VALUE;
        int i9 = -1;
        int i10 = -1;
        for (int i11 = 0; i11 < 256; i11++) {
            int[] iArr = this.network[i11];
            int i12 = iArr[0] - i3;
            if (i12 < 0) {
                i12 = -i12;
            }
            int i13 = iArr[1] - i5;
            if (i13 < 0) {
                i13 = -i13;
            }
            int i14 = i12 + i13;
            int i15 = iArr[2] - i6;
            if (i15 < 0) {
                i15 = -i15;
            }
            int i16 = i14 + i15;
            if (i16 < i7) {
                i9 = i11;
                i7 = i16;
            }
            int[] iArr2 = this.bias;
            int i17 = i16 - (iArr2[i11] >> 12);
            if (i17 < i8) {
                i10 = i11;
                i8 = i17;
            }
            int[] iArr3 = this.freq;
            int i18 = iArr3[i11];
            int i19 = i18 >> 10;
            iArr3[i11] = i18 - i19;
            iArr2[i11] = iArr2[i11] + (i19 << 10);
        }
        int[] iArr4 = this.freq;
        iArr4[i9] = iArr4[i9] + 64;
        int[] iArr5 = this.bias;
        iArr5[i9] = iArr5[i9] - 65536;
        return i10;
    }

    public void inxbuild() {
        int i3 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < 256) {
            int[] iArr = this.network[i3];
            int i7 = iArr[1];
            int i8 = i3 + 1;
            int i9 = i3;
            for (int i10 = i8; i10 < 256; i10++) {
                int i11 = this.network[i10][1];
                if (i11 < i7) {
                    i9 = i10;
                    i7 = i11;
                }
            }
            int[] iArr2 = this.network[i9];
            if (i3 != i9) {
                int i12 = iArr2[0];
                iArr2[0] = iArr[0];
                iArr[0] = i12;
                int i13 = iArr2[1];
                iArr2[1] = iArr[1];
                iArr[1] = i13;
                int i14 = iArr2[2];
                iArr2[2] = iArr[2];
                iArr[2] = i14;
                int i15 = iArr2[3];
                iArr2[3] = iArr[3];
                iArr[3] = i15;
            }
            if (i7 != i5) {
                this.netindex[i5] = (i6 + i3) >> 1;
                while (true) {
                    i5++;
                    if (i5 >= i7) {
                        break;
                    }
                    this.netindex[i5] = i3;
                }
                i6 = i3;
                i5 = i7;
            }
            i3 = i8;
        }
        this.netindex[i5] = (i6 + 255) >> 1;
        for (int i16 = i5 + 1; i16 < 256; i16++) {
            this.netindex[i16] = 255;
        }
    }

    public void learn() {
        int i3;
        int i5 = this.lengthcount;
        if (i5 < minpicturebytes) {
            this.samplefac = 1;
        }
        int i6 = this.samplefac;
        this.alphadec = i.c(i6, 1, 3, 30);
        byte[] bArr = this.thepicture;
        int i7 = i5 / (i6 * 3);
        int i8 = i7 / 100;
        for (int i9 = 0; i9 < 32; i9++) {
            this.radpower[i9] = (((1024 - (i9 * i9)) * 256) / 1024) * 1024;
        }
        int i10 = this.lengthcount;
        if (i10 < minpicturebytes) {
            i3 = 3;
        } else if (i10 % prime1 != 0) {
            i3 = 1497;
        } else if (i10 % prime2 != 0) {
            i3 = 1473;
        } else if (i10 % prime3 != 0) {
            i3 = 1461;
        } else {
            i3 = minpicturebytes;
        }
        int i11 = i8;
        int i12 = 0;
        int i13 = 2048;
        int i14 = 1024;
        int i15 = 32;
        int i16 = 0;
        while (i12 < i7) {
            int i17 = (bArr[i16] & 255) << 4;
            int i18 = (bArr[i16 + 1] & 255) << 4;
            int i19 = (bArr[i16 + 2] & 255) << 4;
            int contest = contest(i17, i18, i19);
            int i20 = i12;
            altersingle(i14, contest, i17, i18, i19);
            if (i15 != 0) {
                alterneigh(i15, contest, i17, i18, i19);
            }
            int i21 = i16 + i3;
            if (i21 >= i5) {
                i21 -= this.lengthcount;
            }
            i16 = i21;
            i12 = i20 + 1;
            if (i11 == 0) {
                i11 = 1;
            }
            if (i12 % i11 == 0) {
                i14 -= i14 / this.alphadec;
                i13 -= i13 / 30;
                int i22 = i13 >> 6;
                if (i22 <= 1) {
                    i22 = 0;
                }
                for (int i23 = 0; i23 < i22; i23++) {
                    int i24 = i22 * i22;
                    this.radpower[i23] = (((i24 - (i23 * i23)) * 256) / i24) * i14;
                }
                i15 = i22;
            }
        }
    }

    public int map(int i3, int i5, int i6) {
        int i7 = this.netindex[i5];
        int i8 = i7 - 1;
        int i9 = 1000;
        int i10 = -1;
        while (true) {
            if (i7 >= 256 && i8 < 0) {
                return i10;
            }
            if (i7 < 256) {
                int[] iArr = this.network[i7];
                int i11 = iArr[1] - i5;
                if (i11 >= i9) {
                    i7 = 256;
                } else {
                    i7++;
                    if (i11 < 0) {
                        i11 = -i11;
                    }
                    int i12 = iArr[0] - i3;
                    if (i12 < 0) {
                        i12 = -i12;
                    }
                    int i13 = i11 + i12;
                    if (i13 < i9) {
                        int i14 = iArr[2] - i6;
                        if (i14 < 0) {
                            i14 = -i14;
                        }
                        int i15 = i13 + i14;
                        if (i15 < i9) {
                            i10 = iArr[3];
                            i9 = i15;
                        }
                    }
                }
            }
            if (i8 >= 0) {
                int[] iArr2 = this.network[i8];
                int i16 = i5 - iArr2[1];
                if (i16 >= i9) {
                    i8 = -1;
                } else {
                    i8--;
                    if (i16 < 0) {
                        i16 = -i16;
                    }
                    int i17 = iArr2[0] - i3;
                    if (i17 < 0) {
                        i17 = -i17;
                    }
                    int i18 = i16 + i17;
                    if (i18 < i9) {
                        int i19 = iArr2[2] - i6;
                        if (i19 < 0) {
                            i19 = -i19;
                        }
                        int i20 = i19 + i18;
                        if (i20 < i9) {
                            i10 = iArr2[3];
                            i9 = i20;
                        }
                    }
                }
            }
        }
    }

    public byte[] process() {
        learn();
        unbiasnet();
        inxbuild();
        return colorMap();
    }

    public void unbiasnet() {
        for (int i3 = 0; i3 < 256; i3++) {
            int[] iArr = this.network[i3];
            iArr[0] = iArr[0] >> 4;
            iArr[1] = iArr[1] >> 4;
            iArr[2] = iArr[2] >> 4;
            iArr[3] = i3;
        }
    }
}
