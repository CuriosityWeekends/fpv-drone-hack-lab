package j0;

import android.util.Pair;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e0 {
    public long c;

    /* renamed from: e  reason: collision with root package name */
    public int f2226e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2227f;

    /* renamed from: g  reason: collision with root package name */
    public c0 f2228g;

    /* renamed from: h  reason: collision with root package name */
    public c0 f2229h;

    /* renamed from: i  reason: collision with root package name */
    public c0 f2230i;

    /* renamed from: j  reason: collision with root package name */
    public int f2231j;

    /* renamed from: k  reason: collision with root package name */
    public Object f2232k;

    /* renamed from: l  reason: collision with root package name */
    public long f2233l;

    /* renamed from: a  reason: collision with root package name */
    public final s0 f2225a = new s0();
    public final t0 b = new t0();
    public u0 d = u0.f2344a;

    public final c0 a() {
        c0 c0Var = this.f2228g;
        if (c0Var == null) {
            return null;
        }
        if (c0Var == this.f2229h) {
            this.f2229h = c0Var.f2214k;
        }
        c0Var.e();
        int i3 = this.f2231j - 1;
        this.f2231j = i3;
        if (i3 == 0) {
            this.f2230i = null;
            c0 c0Var2 = this.f2228g;
            this.f2232k = c0Var2.b;
            this.f2233l = c0Var2.f2209f.f2219a.d;
        }
        c0 c0Var3 = this.f2228g.f2214k;
        this.f2228g = c0Var3;
        return c0Var3;
    }

    public final void b(boolean z3) {
        Object obj;
        c0 c0Var = this.f2228g;
        if (c0Var != null) {
            if (z3) {
                obj = c0Var.b;
            } else {
                obj = null;
            }
            this.f2232k = obj;
            this.f2233l = c0Var.f2209f.f2219a.d;
            h(c0Var);
            c0Var.e();
        } else if (!z3) {
            this.f2232k = null;
        }
        this.f2228g = null;
        this.f2230i = null;
        this.f2229h = null;
        this.f2231j = 0;
    }

    public final d0 c(c0 c0Var, long j2) {
        int i3;
        Object obj;
        long j5;
        long j6;
        d0 d0Var = c0Var.f2209f;
        long j7 = (c0Var.f2217n + d0Var.f2220e) - j2;
        boolean z3 = d0Var.f2221f;
        s0 s0Var = this.f2225a;
        j1.n nVar = d0Var.f2219a;
        if (z3) {
            int d = this.d.d(this.d.b(nVar.f2454a), this.f2225a, this.b, this.f2226e, this.f2227f);
            if (d == -1) {
                return null;
            }
            int i5 = this.d.f(d, s0Var, true).c;
            Object obj2 = s0Var.b;
            long j8 = 0;
            if (this.d.m(i5, this.b, 0L).f2322f == d) {
                Pair j9 = this.d.j(this.b, this.f2225a, i5, -9223372036854775807L, Math.max(0L, j7));
                if (j9 == null) {
                    return null;
                }
                Object obj3 = j9.first;
                j8 = ((Long) j9.second).longValue();
                c0 c0Var2 = c0Var.f2214k;
                if (c0Var2 != null && c0Var2.b.equals(obj3)) {
                    j6 = c0Var2.f2209f.f2219a.d;
                } else {
                    j6 = this.c;
                    this.c = 1 + j6;
                }
                j5 = j6;
                obj = obj3;
            } else {
                obj = obj2;
                j5 = nVar.d;
            }
            return d(j(obj, j8, j5), j8);
        }
        this.d.g(nVar.f2454a, s0Var);
        if (nVar.a()) {
            s0Var.f2307f.c[nVar.b].getClass();
            return null;
        }
        int b = s0Var.b(d0Var.d);
        if (b == -1) {
            return e(nVar.f2454a, d0Var.f2220e, nVar.d);
        }
        k1.a aVar = s0Var.f2307f.c[b];
        int i6 = 0;
        while (true) {
            int[] iArr = aVar.b;
            if (i6 >= iArr.length || (i3 = iArr[i6]) == 0 || i3 == 1) {
                break;
            }
            i6++;
        }
        s0Var.f2307f.c[b].getClass();
        return null;
    }

    public final d0 d(j1.n nVar, long j2) {
        u0 u0Var = this.d;
        Object obj = nVar.f2454a;
        s0 s0Var = this.f2225a;
        u0Var.g(obj, s0Var);
        if (nVar.a()) {
            s0Var.f2307f.c[nVar.b].getClass();
            return null;
        }
        return e(nVar.f2454a, j2, nVar.d);
    }

    public final d0 e(Object obj, long j2, long j5) {
        boolean z3;
        long j6;
        long j7;
        s0 s0Var = this.f2225a;
        int a5 = s0Var.a(j2);
        j1.n nVar = new j1.n(obj, j5, a5);
        if (!nVar.a() && a5 == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean g5 = g(nVar, z3);
        if (a5 != -1) {
            j6 = s0Var.f2307f.b[a5];
        } else {
            j6 = -9223372036854775807L;
        }
        if (j6 != -9223372036854775807L && j6 != Long.MIN_VALUE) {
            j7 = j6;
        } else {
            j7 = s0Var.d;
        }
        return new d0(nVar, j2, -9223372036854775807L, j6, j7, z3, g5);
    }

    public final d0 f(d0 d0Var) {
        boolean z3;
        long j2;
        j1.n nVar = d0Var.f2219a;
        if (!nVar.a() && nVar.f2455e == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean g5 = g(nVar, z3);
        u0 u0Var = this.d;
        Object obj = d0Var.f2219a.f2454a;
        s0 s0Var = this.f2225a;
        u0Var.g(obj, s0Var);
        if (nVar.a()) {
            s0Var.f2307f.c[nVar.b].getClass();
            j2 = -9223372036854775807L;
        } else {
            long j5 = d0Var.d;
            if (j5 != -9223372036854775807L && j5 != Long.MIN_VALUE) {
                j2 = j5;
            } else {
                j2 = s0Var.d;
            }
        }
        return new d0(nVar, d0Var.b, d0Var.c, d0Var.d, j2, z3, g5);
    }

    public final boolean g(j1.n nVar, boolean z3) {
        int b = this.d.b(nVar.f2454a);
        if (this.d.m(this.d.f(b, this.f2225a, false).c, this.b, 0L).f2321e) {
            return false;
        }
        if (this.d.d(b, this.f2225a, this.b, this.f2226e, this.f2227f) != -1 || !z3) {
            return false;
        }
        return true;
    }

    public final boolean h(c0 c0Var) {
        boolean z3;
        boolean z5 = false;
        if (c0Var != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.h(z3);
        this.f2230i = c0Var;
        while (true) {
            c0Var = c0Var.f2214k;
            if (c0Var == null) {
                break;
            }
            if (c0Var == this.f2229h) {
                this.f2229h = this.f2228g;
                z5 = true;
            }
            c0Var.e();
            this.f2231j--;
        }
        c0 c0Var2 = this.f2230i;
        if (c0Var2.f2214k != null) {
            c0Var2.b();
            c0Var2.f2214k = null;
            c0Var2.c();
        }
        return z5;
    }

    public final j1.n i(long j2, Object obj) {
        long j5;
        int b;
        u0 u0Var = this.d;
        s0 s0Var = this.f2225a;
        int i3 = u0Var.g(obj, s0Var).c;
        Object obj2 = this.f2232k;
        if (obj2 != null && (b = this.d.b(obj2)) != -1 && this.d.f(b, s0Var, false).c == i3) {
            j5 = this.f2233l;
        } else {
            c0 c0Var = this.f2228g;
            while (true) {
                if (c0Var != null) {
                    if (c0Var.b.equals(obj)) {
                        j5 = c0Var.f2209f.f2219a.d;
                        break;
                    }
                    c0Var = c0Var.f2214k;
                } else {
                    c0 c0Var2 = this.f2228g;
                    while (true) {
                        if (c0Var2 != null) {
                            int b5 = this.d.b(c0Var2.b);
                            if (b5 != -1 && this.d.f(b5, s0Var, false).c == i3) {
                                j5 = c0Var2.f2209f.f2219a.d;
                                break;
                            }
                            c0Var2 = c0Var2.f2214k;
                        } else {
                            j5 = this.c;
                            this.c = 1 + j5;
                            if (this.f2228g == null) {
                                this.f2232k = obj;
                                this.f2233l = j5;
                            }
                        }
                    }
                }
            }
        }
        return j(obj, j2, j5);
    }

    public final j1.n j(Object obj, long j2, long j5) {
        int i3;
        u0 u0Var = this.d;
        s0 s0Var = this.f2225a;
        u0Var.g(obj, s0Var);
        int b = s0Var.b(j2);
        if (b == -1) {
            return new j1.n(obj, j5, s0Var.a(j2));
        }
        k1.a aVar = s0Var.f2307f.c[b];
        int i5 = 0;
        while (true) {
            int[] iArr = aVar.b;
            if (i5 >= iArr.length || (i3 = iArr[i5]) == 0 || i3 == 1) {
                break;
            }
            i5++;
        }
        return new j1.n(obj, b, i5, j5, -1);
    }

    public final boolean k() {
        c0 c0Var;
        c0 c0Var2 = this.f2228g;
        if (c0Var2 == null) {
            return true;
        }
        int b = this.d.b(c0Var2.b);
        while (true) {
            b = this.d.d(b, this.f2225a, this.b, this.f2226e, this.f2227f);
            while (true) {
                c0Var = c0Var2.f2214k;
                if (c0Var == null || c0Var2.f2209f.f2221f) {
                    break;
                }
                c0Var2 = c0Var;
            }
            if (b == -1 || c0Var == null || this.d.b(c0Var.b) != b) {
                break;
            }
            c0Var2 = c0Var;
        }
        boolean h5 = h(c0Var2);
        c0Var2.f2209f = f(c0Var2.f2209f);
        return !h5;
    }
}
