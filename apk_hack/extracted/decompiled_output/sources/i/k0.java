package i;

import android.os.Handler;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2107a;
    public Object b;

    public synchronized void a(g0 g0Var, boolean z3) {
        try {
            if (!this.f2107a && !z3) {
                this.f2107a = true;
                g0Var.recycle();
                this.f2107a = false;
            }
            ((Handler) this.b).obtainMessage(1, g0Var).sendToTarget();
        } catch (Throwable th) {
            throw th;
        }
    }
}
