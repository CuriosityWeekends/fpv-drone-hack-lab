package g4;

import android.os.Handler;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements Runnable, i4.a {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1979a;
    public final Runnable b;

    public d(Handler handler, c2.b bVar) {
        this.f1979a = handler;
        this.b = bVar;
    }

    @Override // i4.a
    public final void dispose() {
        this.f1979a.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.run();
        } catch (Throwable th) {
            com.bumptech.glide.d.i(th);
        }
    }
}
