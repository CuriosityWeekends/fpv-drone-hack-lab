package i;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends WeakReference {

    /* renamed from: a  reason: collision with root package name */
    public final g.e f2040a;
    public final boolean b;
    public g0 c;

    public a(g.e eVar, a0 a0Var, ReferenceQueue referenceQueue) {
        super(a0Var, referenceQueue);
        c0.g.c(eVar, "Argument must not be null");
        this.f2040a = eVar;
        boolean z3 = a0Var.f2041a;
        this.c = null;
        this.b = z3;
    }
}
