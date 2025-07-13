package g2;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    public final FileOutputStream f1912a;
    public boolean b = false;

    public a(File file) {
        this.f1912a = new FileOutputStream(file);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        FileOutputStream fileOutputStream = this.f1912a;
        if (this.b) {
            return;
        }
        this.b = true;
        flush();
        try {
            fileOutputStream.getFD().sync();
        } catch (IOException e5) {
            Log.w("AtomicFile", "Failed to sync file descriptor:", e5);
        }
        fileOutputStream.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        this.f1912a.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i3) {
        this.f1912a.write(i3);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f1912a.write(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i3, int i5) {
        this.f1912a.write(bArr, i3, i5);
    }
}
