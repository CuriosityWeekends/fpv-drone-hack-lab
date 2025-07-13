package j1;

import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b0 implements j0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f2373a;
    public final /* synthetic */ d0 b;

    public b0(d0 d0Var, int i3) {
        this.b = d0Var;
        this.f2373a = i3;
    }

    @Override // j1.j0
    public final void a() {
        d0 d0Var = this.b;
        b3.e eVar = d0Var.s[this.f2373a].f2420f;
        if (eVar == null) {
            int l5 = d0Var.d.l(d0Var.f2396y);
            e2.f0 f0Var = d0Var.f2384j;
            IOException iOException = (IOException) f0Var.c;
            if (iOException == null) {
                e2.b0 b0Var = (e2.b0) f0Var.b;
                if (b0Var != null) {
                    if (l5 == Integer.MIN_VALUE) {
                        l5 = b0Var.f1673a;
                    }
                    IOException iOException2 = b0Var.f1674e;
                    if (iOException2 != null && b0Var.f1675f > l5) {
                        throw iOException2;
                    }
                    return;
                }
                return;
            }
            throw iOException;
        }
        e2.b bVar = (e2.b) eVar.b;
        bVar.getClass();
        throw bVar;
    }

    @Override // j1.j0
    public final int c(j0.b bVar, m0.d dVar, boolean z3) {
        d0 d0Var = this.b;
        if (d0Var.C()) {
            return -3;
        }
        int i3 = this.f2373a;
        d0Var.r(i3);
        int y3 = d0Var.s[i3].y(bVar, dVar, z3, d0Var.K, d0Var.G);
        if (y3 == -3) {
            d0Var.v(i3);
        }
        return y3;
    }

    @Override // j1.j0
    public final int g(long j2) {
        int e5;
        d0 d0Var = this.b;
        if (d0Var.C()) {
            return 0;
        }
        int i3 = this.f2373a;
        d0Var.r(i3);
        i0 i0Var = d0Var.s[i3];
        if (d0Var.K && j2 > i0Var.o()) {
            e5 = i0Var.f();
        } else {
            e5 = i0Var.e(j2);
        }
        if (e5 == 0) {
            d0Var.v(i3);
            return e5;
        }
        return e5;
    }

    @Override // j1.j0
    public final boolean isReady() {
        d0 d0Var = this.b;
        if (!d0Var.C() && d0Var.s[this.f2373a].u(d0Var.K)) {
            return true;
        }
        return false;
    }
}
