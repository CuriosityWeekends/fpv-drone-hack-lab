package c0;

import java.io.FilterInputStream;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public int f196a;

    public k(e eVar) {
        super(eVar);
        this.f196a = Integer.MIN_VALUE;
    }

    public final long a(long j2) {
        int i3 = this.f196a;
        if (i3 == 0) {
            return -1L;
        }
        if (i3 != Integer.MIN_VALUE && j2 > i3) {
            return i3;
        }
        return j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        int i3 = this.f196a;
        if (i3 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i3, super.available());
    }

    public final void b(long j2) {
        int i3 = this.f196a;
        if (i3 != Integer.MIN_VALUE && j2 != -1) {
            this.f196a = (int) (i3 - j2);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i3) {
        super.mark(i3);
        this.f196a = i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        if (a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        super.reset();
        this.f196a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) {
        long a5 = a(j2);
        if (a5 == -1) {
            return 0L;
        }
        long skip = super.skip(a5);
        b(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i3, int i5) {
        int a5 = (int) a(i5);
        if (a5 == -1) {
            return -1;
        }
        int read = super.read(bArr, i3, a5);
        b(read);
        return read;
    }
}
