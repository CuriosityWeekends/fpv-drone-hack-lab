package j0;

import android.os.Handler;
import android.util.Log;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m0 {

    /* renamed from: a  reason: collision with root package name */
    public final h f2270a;
    public final y b;
    public int c;
    public Object d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f2271e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2272f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2273g;

    public m0(y yVar, h hVar, u0 u0Var, int i3, Handler handler) {
        this.b = yVar;
        this.f2270a = hVar;
        this.f2271e = handler;
    }

    public final synchronized void a(boolean z3) {
        this.f2273g = true;
        notifyAll();
    }

    public final void b() {
        g2.b.h(!this.f2272f);
        this.f2272f = true;
        y yVar = this.b;
        synchronized (yVar) {
            if (!yVar.w && yVar.f2352h.isAlive()) {
                ((Handler) yVar.f2351g.b).obtainMessage(15, this).sendToTarget();
                return;
            }
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            a(false);
        }
    }

    public final void c(Object obj) {
        g2.b.h(!this.f2272f);
        this.d = obj;
    }

    public final void d(int i3) {
        g2.b.h(!this.f2272f);
        this.c = i3;
    }
}
