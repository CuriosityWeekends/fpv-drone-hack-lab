package m;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements com.bumptech.glide.load.data.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2733a;
    public final Object b;

    public /* synthetic */ d(int i3, Object obj) {
        this.f2733a = i3;
        this.b = obj;
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        switch (this.f2733a) {
            case 0:
                return ByteBuffer.class;
            default:
                return this.b.getClass();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        int i3 = this.f2733a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(com.bumptech.glide.j jVar, com.bumptech.glide.load.data.d dVar) {
        switch (this.f2733a) {
            case 0:
                try {
                    dVar.f(c0.c.a((File) this.b));
                    return;
                } catch (IOException e5) {
                    if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                        Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e5);
                    }
                    dVar.d(e5);
                    return;
                }
            default:
                dVar.f(this.b);
                return;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        int i3 = this.f2733a;
    }

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        switch (this.f2733a) {
            case 0:
                return 1;
            default:
                return 1;
        }
    }

    private final void d() {
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void g() {
    }
}
