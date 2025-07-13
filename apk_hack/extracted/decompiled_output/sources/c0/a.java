package c0;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f186a;
    public int b = -1;

    public a(ByteBuffer byteBuffer) {
        this.f186a = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f186a.remaining();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i3) {
        this.b = this.f186a.position();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        ByteBuffer byteBuffer = this.f186a;
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        int i3 = this.b;
        if (i3 != -1) {
            this.f186a.position(i3);
        } else {
            throw new IOException("Cannot reset to unset mark position");
        }
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        ByteBuffer byteBuffer = this.f186a;
        if (!byteBuffer.hasRemaining()) {
            return -1L;
        }
        long min = Math.min(j2, byteBuffer.remaining());
        byteBuffer.position((int) (byteBuffer.position() + min));
        return min;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i5) {
        ByteBuffer byteBuffer = this.f186a;
        if (byteBuffer.hasRemaining()) {
            int min = Math.min(i5, byteBuffer.remaining());
            byteBuffer.get(bArr, i3, min);
            return min;
        }
        return -1;
    }
}
