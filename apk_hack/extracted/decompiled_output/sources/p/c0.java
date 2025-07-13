package p;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c0 extends MediaDataSource {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f3060a;

    public c0(ByteBuffer byteBuffer) {
        this.f3060a = byteBuffer;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f3060a.limit();
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j2, byte[] bArr, int i3, int i5) {
        if (j2 >= this.f3060a.limit()) {
            return -1;
        }
        this.f3060a.position((int) j2);
        int min = Math.min(i5, this.f3060a.remaining());
        this.f3060a.get(bArr, i3, min);
        return min;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
