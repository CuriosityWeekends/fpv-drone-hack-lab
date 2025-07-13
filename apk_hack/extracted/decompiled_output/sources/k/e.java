package k;

import c0.j;
import i.g0;
import i.s;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e extends j {
    public f d;

    @Override // c0.j
    public final int e(Object obj) {
        g0 g0Var = (g0) obj;
        if (g0Var == null) {
            return 1;
        }
        return g0Var.getSize();
    }

    @Override // c0.j
    public final void f(Object obj, Object obj2) {
        g.e eVar = (g.e) obj;
        g0 g0Var = (g0) obj2;
        f fVar = this.d;
        if (fVar != null && g0Var != null) {
            ((s) fVar).f2125e.a(g0Var, true);
        }
    }

    public final void i(int i3) {
        long j2;
        if (i3 >= 40) {
            h(0L);
        } else if (i3 >= 20 || i3 == 15) {
            synchronized (this) {
                j2 = this.f195a;
            }
            h(j2 / 2);
        }
    }
}
