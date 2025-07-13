package j1;

import j0.s0;
import j0.t0;
import j0.u0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i extends u0 {
    public final u0 b;

    public i(u0 u0Var) {
        this.b = u0Var;
    }

    @Override // j0.u0
    public final int a(boolean z3) {
        return this.b.a(z3);
    }

    @Override // j0.u0
    public final int b(Object obj) {
        return this.b.b(obj);
    }

    @Override // j0.u0
    public final int c(boolean z3) {
        return this.b.c(z3);
    }

    @Override // j0.u0
    public final int e(int i3, int i5, boolean z3) {
        u0 u0Var = this.b;
        int e5 = u0Var.e(i3, i5, z3);
        if (e5 == -1) {
            return u0Var.a(z3);
        }
        return e5;
    }

    @Override // j0.u0
    public final s0 f(int i3, s0 s0Var, boolean z3) {
        return this.b.f(i3, s0Var, z3);
    }

    @Override // j0.u0
    public final int h() {
        return this.b.h();
    }

    @Override // j0.u0
    public final int k(int i3, int i5, boolean z3) {
        u0 u0Var = this.b;
        int k5 = u0Var.k(i3, i5, z3);
        if (k5 == -1) {
            return u0Var.c(z3);
        }
        return k5;
    }

    @Override // j0.u0
    public final Object l(int i3) {
        return this.b.l(i3);
    }

    @Override // j0.u0
    public final t0 m(int i3, t0 t0Var, long j2) {
        return this.b.m(i3, t0Var, j2);
    }

    @Override // j0.u0
    public final int n() {
        return this.b.n();
    }
}
