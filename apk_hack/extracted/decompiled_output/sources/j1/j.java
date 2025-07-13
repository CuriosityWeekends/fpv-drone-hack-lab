package j1;

import android.util.Pair;
import j0.s0;
import j0.t0;
import j0.u0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j extends u0 {
    public final int b;
    public final h0.a c;
    public final u0 d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2438e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2439f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2440g;

    public j(u0 u0Var, int i3) {
        boolean z3;
        this.c = new h0.a(i3);
        this.b = i3;
        this.d = u0Var;
        int h5 = u0Var.h();
        this.f2438e = h5;
        this.f2439f = u0Var.n();
        this.f2440g = i3;
        if (h5 > 0) {
            if (i3 <= Integer.MAX_VALUE / h5) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                throw new IllegalStateException("LoopingMediaSource contains too many periods");
            }
        }
    }

    @Override // j0.u0
    public final int a(boolean z3) {
        if (this.b == 0) {
            return -1;
        }
        int i3 = 0;
        if (z3 && this.c.f1984a <= 0) {
            i3 = -1;
        }
        do {
            u0 u0Var = this.d;
            if (u0Var.o()) {
                i3 = p(i3, z3);
            } else {
                return u0Var.a(z3) + (i3 * this.f2439f);
            }
        } while (i3 != -1);
        return -1;
    }

    @Override // j0.u0
    public final int b(Object obj) {
        int intValue;
        int b;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        if (!(obj2 instanceof Integer)) {
            intValue = -1;
        } else {
            intValue = ((Integer) obj2).intValue();
        }
        if (intValue == -1 || (b = this.d.b(obj3)) == -1) {
            return -1;
        }
        return (intValue * this.f2438e) + b;
    }

    @Override // j0.u0
    public final int c(boolean z3) {
        int i3;
        int i5 = this.b;
        if (i5 == 0) {
            return -1;
        }
        if (!z3 || (i5 = this.c.f1984a) > 0) {
            i3 = i5 - 1;
        } else {
            i3 = -1;
        }
        do {
            u0 u0Var = this.d;
            if (u0Var.o()) {
                i3 = q(i3, z3);
            } else {
                return u0Var.c(z3) + (i3 * this.f2439f);
            }
        } while (i3 != -1);
        return -1;
    }

    @Override // j0.u0
    public final int e(int i3, int i5, boolean z3) {
        int i6;
        int i7 = this.f2439f;
        int i8 = i3 / i7;
        int i9 = i8 * i7;
        int i10 = i3 - i9;
        if (i5 == 2) {
            i6 = 0;
        } else {
            i6 = i5;
        }
        u0 u0Var = this.d;
        int e5 = u0Var.e(i10, i6, z3);
        if (e5 != -1) {
            return i9 + e5;
        }
        int p5 = p(i8, z3);
        while (p5 != -1 && u0Var.o()) {
            p5 = p(p5, z3);
        }
        if (p5 != -1) {
            return u0Var.a(z3) + (p5 * i7);
        } else if (i5 != 2) {
            return -1;
        } else {
            return a(z3);
        }
    }

    @Override // j0.u0
    public final s0 f(int i3, s0 s0Var, boolean z3) {
        int i5 = this.f2438e;
        int i6 = i3 / i5;
        this.d.f(i3 - (i5 * i6), s0Var, z3);
        s0Var.c += this.f2439f * i6;
        if (z3) {
            Integer valueOf = Integer.valueOf(i6);
            Object obj = s0Var.b;
            obj.getClass();
            s0Var.b = Pair.create(valueOf, obj);
        }
        return s0Var;
    }

    @Override // j0.u0
    public final s0 g(Object obj, s0 s0Var) {
        int intValue;
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        if (!(obj2 instanceof Integer)) {
            intValue = -1;
        } else {
            intValue = ((Integer) obj2).intValue();
        }
        int i3 = intValue * this.f2439f;
        this.d.g(obj3, s0Var);
        s0Var.c += i3;
        s0Var.b = obj;
        return s0Var;
    }

    @Override // j0.u0
    public final int h() {
        return this.f2438e * this.f2440g;
    }

    @Override // j0.u0
    public final int k(int i3, int i5, boolean z3) {
        int i6;
        int i7 = this.f2439f;
        int i8 = i3 / i7;
        int i9 = i8 * i7;
        int i10 = i3 - i9;
        if (i5 == 2) {
            i6 = 0;
        } else {
            i6 = i5;
        }
        u0 u0Var = this.d;
        int k5 = u0Var.k(i10, i6, z3);
        if (k5 != -1) {
            return i9 + k5;
        }
        int q = q(i8, z3);
        while (q != -1 && u0Var.o()) {
            q = q(q, z3);
        }
        if (q != -1) {
            return u0Var.c(z3) + (q * i7);
        } else if (i5 != 2) {
            return -1;
        } else {
            return c(z3);
        }
    }

    @Override // j0.u0
    public final Object l(int i3) {
        int i5 = this.f2438e;
        int i6 = i3 / i5;
        return Pair.create(Integer.valueOf(i6), this.d.l(i3 - (i5 * i6)));
    }

    @Override // j0.u0
    public final t0 m(int i3, t0 t0Var, long j2) {
        int i5 = this.f2439f;
        int i6 = i3 / i5;
        int i7 = this.f2438e * i6;
        this.d.m(i3 - (i5 * i6), t0Var, j2);
        Object valueOf = Integer.valueOf(i6);
        if (!t0.f2319k.equals(t0Var.f2320a)) {
            valueOf = Pair.create(valueOf, t0Var.f2320a);
        }
        t0Var.f2320a = valueOf;
        t0Var.f2322f += i7;
        t0Var.f2323g += i7;
        return t0Var;
    }

    @Override // j0.u0
    public final int n() {
        return this.f2439f * this.f2440g;
    }

    public final int p(int i3, boolean z3) {
        if (z3) {
            int i5 = i3 + 1;
            if (i5 >= this.c.f1984a) {
                return -1;
            }
            return i5;
        } else if (i3 >= this.b - 1) {
            return -1;
        } else {
            return i3 + 1;
        }
    }

    public final int q(int i3, boolean z3) {
        if (z3) {
            this.c.getClass();
            int i5 = i3 - 1;
            if (i5 < 0) {
                return -1;
            }
            return i5;
        } else if (i3 <= 0) {
            return -1;
        } else {
            return i3 - 1;
        }
    }
}
