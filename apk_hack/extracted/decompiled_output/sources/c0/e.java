package c0;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e extends InputStream {
    public static final ArrayDeque c;

    /* renamed from: a  reason: collision with root package name */
    public InputStream f190a;
    public IOException b;

    static {
        char[] cArr = n.f199a;
        c = new ArrayDeque(0);
    }

    public final void a() {
        this.b = null;
        this.f190a = null;
        ArrayDeque arrayDeque = c;
        synchronized (arrayDeque) {
            arrayDeque.offer(this);
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f190a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f190a.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i3) {
        this.f190a.mark(i3);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f190a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() {
        try {
            return this.f190a.read();
        } catch (IOException e5) {
            this.b = e5;
            throw e5;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.f190a.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        try {
            return this.f190a.skip(j2);
        } catch (IOException e5) {
            this.b = e5;
            throw e5;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        try {
            return this.f190a.read(bArr);
        } catch (IOException e5) {
            this.b = e5;
            throw e5;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i5) {
        try {
            return this.f190a.read(bArr, i3, i5);
        } catch (IOException e5) {
            this.b = e5;
            throw e5;
        }
    }
}
