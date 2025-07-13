package e2;

import java.io.InputStream;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final i f1691a;
    public final l b;
    public boolean d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1692e = false;
    public final byte[] c = new byte[1];

    public k(i iVar, l lVar) {
        this.f1691a = iVar;
        this.b = lVar;
    }

    public final void a() {
        if (!this.d) {
            this.f1691a.open(this.b);
            this.d = true;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (!this.f1692e) {
            this.f1691a.close();
            this.f1692e = true;
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.c;
        if (read(bArr, 0, bArr.length) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i5) {
        g2.b.h(!this.f1692e);
        a();
        int read = this.f1691a.read(bArr, i3, i5);
        if (read == -1) {
            return -1;
        }
        return read;
    }
}
