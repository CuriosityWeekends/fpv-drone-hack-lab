package c0;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    public final long f189a;
    public int b;

    public d(InputStream inputStream, long j2) {
        super(inputStream);
        this.f189a = j2;
    }

    public final void a(int i3) {
        if (i3 >= 0) {
            this.b += i3;
            return;
        }
        long j2 = this.f189a;
        if (j2 - this.b <= 0) {
            return;
        }
        throw new IOException("Failed to read all expected data, expected: " + j2 + ", but read: " + this.b);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        return (int) Math.max(this.f189a - this.b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i3, int i5) {
        int read;
        read = super.read(bArr, i3, i5);
        a(read);
        return read;
    }
}
