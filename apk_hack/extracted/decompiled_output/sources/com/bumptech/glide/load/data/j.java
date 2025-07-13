package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.InputStream;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j extends FilterInputStream {
    public static final byte[] c = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
    public static final int d = 31;

    /* renamed from: a  reason: collision with root package name */
    public final byte f261a;
    public int b;

    public j(InputStream inputStream, int i3) {
        super(inputStream);
        if (i3 >= -1 && i3 <= 8) {
            this.f261a = (byte) i3;
            return;
        }
        throw new IllegalArgumentException(a1.i.e(i3, "Cannot add invalid orientation: "));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int read;
        int i3;
        int i5 = this.b;
        if (i5 < 2 || i5 > (i3 = d)) {
            read = super.read();
        } else if (i5 == i3) {
            read = this.f261a;
        } else {
            read = c[i5 - 2] & 255;
        }
        if (read != -1) {
            this.b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) {
        long skip = super.skip(j2);
        if (skip > 0) {
            this.b = (int) (this.b + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i3, int i5) {
        int i6;
        int i7 = this.b;
        int i8 = d;
        if (i7 > i8) {
            i6 = super.read(bArr, i3, i5);
        } else if (i7 == i8) {
            bArr[i3] = this.f261a;
            i6 = 1;
        } else if (i7 < 2) {
            i6 = super.read(bArr, i3, 2 - i7);
        } else {
            int min = Math.min(i8 - i7, i5);
            System.arraycopy(c, this.b - 2, bArr, i3, min);
            i6 = min;
        }
        if (i6 > 0) {
            this.b += i6;
        }
        return i6;
    }
}
