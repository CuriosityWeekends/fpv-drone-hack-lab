package p;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class w extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public volatile byte[] f3091a;
    public int b;
    public int c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f3092e;

    /* renamed from: f  reason: collision with root package name */
    public final j.g f3093f;

    public w(InputStream inputStream, j.g gVar) {
        super(inputStream);
        this.d = -1;
        this.f3093f = gVar;
        this.f3091a = (byte[]) gVar.d(byte[].class, 65536);
    }

    public static void c() {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) {
        int i3 = this.d;
        if (i3 != -1) {
            int i5 = this.f3092e - i3;
            int i6 = this.c;
            if (i5 < i6) {
                if (i3 == 0 && i6 > bArr.length && this.b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i6) {
                        i6 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f3093f.d(byte[].class, i6);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f3091a = bArr2;
                    this.f3093f.h(bArr);
                    bArr = bArr2;
                } else if (i3 > 0) {
                    System.arraycopy(bArr, i3, bArr, 0, bArr.length - i3);
                }
                int i7 = this.f3092e - this.d;
                this.f3092e = i7;
                this.d = 0;
                this.b = 0;
                int read = inputStream.read(bArr, i7, bArr.length - i7);
                int i8 = this.f3092e;
                if (read > 0) {
                    i8 += read;
                }
                this.b = i8;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.d = -1;
            this.f3092e = 0;
            this.b = read2;
        }
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f3091a != null && inputStream != null) {
        } else {
            c();
            throw null;
        }
        return (this.b - this.f3092e) + inputStream.available();
    }

    public final synchronized void b() {
        if (this.f3091a != null) {
            this.f3093f.h(this.f3091a);
            this.f3091a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f3091a != null) {
            this.f3093f.h(this.f3091a);
            this.f3091a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i3) {
        this.c = Math.max(this.c, i3);
        this.d = this.f3092e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = this.f3091a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.f3092e < this.b || a(inputStream, bArr) != -1) {
                if (bArr != this.f3091a && (bArr = this.f3091a) == null) {
                    c();
                    throw null;
                }
                int i3 = this.b;
                int i5 = this.f3092e;
                if (i3 - i5 > 0) {
                    this.f3092e = i5 + 1;
                    return bArr[i5] & 255;
                }
                return -1;
            }
            return -1;
        }
        c();
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (this.f3091a != null) {
            int i3 = this.d;
            if (-1 != i3) {
                this.f3092e = i3;
            } else {
                throw new IOException("Mark has been invalidated, pos: " + this.f3092e + " markLimit: " + this.c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j2) {
        if (j2 < 1) {
            return 0L;
        }
        byte[] bArr = this.f3091a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i3 = this.b;
                int i5 = this.f3092e;
                if (i3 - i5 >= j2) {
                    this.f3092e = (int) (i5 + j2);
                    return j2;
                }
                long j5 = i3 - i5;
                this.f3092e = i3;
                if (this.d != -1 && j2 <= this.c) {
                    if (a(inputStream, bArr) == -1) {
                        return j5;
                    }
                    int i6 = this.b;
                    int i7 = this.f3092e;
                    if (i6 - i7 >= j2 - j5) {
                        this.f3092e = (int) ((i7 + j2) - j5);
                        return j2;
                    }
                    long j6 = (j5 + i6) - i7;
                    this.f3092e = i6;
                    return j6;
                }
                long skip = inputStream.skip(j2 - j5);
                if (skip > 0) {
                    this.d = -1;
                }
                return j5 + skip;
            }
            c();
            throw null;
        }
        c();
        throw null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i3, int i5) {
        int i6;
        int i7;
        byte[] bArr2 = this.f3091a;
        if (bArr2 == null) {
            c();
            throw null;
        } else if (i5 == 0) {
            return 0;
        } else {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i8 = this.f3092e;
                int i9 = this.b;
                if (i8 < i9) {
                    int i10 = i9 - i8;
                    if (i10 >= i5) {
                        i10 = i5;
                    }
                    System.arraycopy(bArr2, i8, bArr, i3, i10);
                    this.f3092e += i10;
                    if (i10 == i5 || inputStream.available() == 0) {
                        return i10;
                    }
                    i3 += i10;
                    i6 = i5 - i10;
                } else {
                    i6 = i5;
                }
                while (true) {
                    if (this.d == -1 && i6 >= bArr2.length) {
                        i7 = inputStream.read(bArr, i3, i6);
                        if (i7 == -1) {
                            return i6 != i5 ? i5 - i6 : -1;
                        }
                    } else if (a(inputStream, bArr2) == -1) {
                        return i6 != i5 ? i5 - i6 : -1;
                    } else {
                        if (bArr2 != this.f3091a && (bArr2 = this.f3091a) == null) {
                            c();
                            throw null;
                        }
                        int i11 = this.b;
                        int i12 = this.f3092e;
                        i7 = i11 - i12;
                        if (i7 >= i6) {
                            i7 = i6;
                        }
                        System.arraycopy(bArr2, i12, bArr, i3, i7);
                        this.f3092e += i7;
                    }
                    i6 -= i7;
                    if (i6 == 0) {
                        return i5;
                    }
                    if (inputStream.available() == 0) {
                        return i5 - i6;
                    }
                    i3 += i7;
                }
            } else {
                c();
                throw null;
            }
        }
    }
}
