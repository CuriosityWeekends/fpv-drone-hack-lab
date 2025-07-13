package m1;

import j0.s0;
import j0.t0;
import j0.u0;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d extends u0 {
    public final int b;
    public final long c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2786e;

    /* renamed from: f  reason: collision with root package name */
    public final n1.b f2787f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f2788g;

    public d(long j2, long j5, int i3, long j6, long j7, long j8, n1.b bVar, Object obj) {
        this.b = i3;
        this.c = j6;
        this.d = j7;
        this.f2786e = j8;
        this.f2787f = bVar;
        this.f2788g = obj;
    }

    @Override // j0.u0
    public final int b(Object obj) {
        int intValue;
        if (!(obj instanceof Integer) || (intValue = ((Integer) obj).intValue() - this.b) < 0 || intValue >= h()) {
            return -1;
        }
        return intValue;
    }

    @Override // j0.u0
    public final s0 f(int i3, s0 s0Var, boolean z3) {
        String str;
        g2.b.g(i3, h());
        Integer num = null;
        n1.b bVar = this.f2787f;
        if (z3) {
            str = bVar.a(i3).f2929a;
        } else {
            str = null;
        }
        if (z3) {
            num = Integer.valueOf(this.b + i3);
        }
        long c = bVar.c(i3);
        s0Var.getClass();
        k1.b bVar2 = k1.b.f2501e;
        s0Var.f2305a = str;
        s0Var.b = num;
        s0Var.c = 0;
        s0Var.d = c;
        s0Var.f2306e = j0.i.a(bVar.a(i3).b - bVar.a(0).b) - this.c;
        s0Var.f2307f = bVar2;
        return s0Var;
    }

    @Override // j0.u0
    public final int h() {
        return this.f2787f.f2922j.size();
    }

    @Override // j0.u0
    public final Object l(int i3) {
        g2.b.g(i3, h());
        return Integer.valueOf(this.b + i3);
    }

    @Override // j0.u0
    public final t0 m(int i3, t0 t0Var, long j2) {
        boolean z3;
        long j5;
        int i5;
        i d;
        boolean z5;
        g2.b.g(i3, 1);
        n1.b bVar = this.f2787f;
        if (bVar.c && bVar.d != -9223372036854775807L && bVar.b == -9223372036854775807L) {
            z3 = true;
        } else {
            z3 = false;
        }
        long j6 = this.c;
        long j7 = this.d;
        long j8 = this.f2786e;
        if (z3) {
            if (j2 > 0) {
                j8 += j2;
                if (j8 > j7) {
                    j8 = -9223372036854775807L;
                }
            }
            long j9 = j6 + j8;
            long c = bVar.c(0);
            int i6 = 0;
            while (i6 < bVar.f2922j.size() - 1 && j9 >= c) {
                j9 -= c;
                i6++;
                c = bVar.c(i6);
            }
            n1.g a5 = bVar.a(i6);
            List list = a5.c;
            int size = list.size();
            j5 = j6;
            int i7 = 0;
            while (true) {
                if (i7 < size) {
                    int i8 = size;
                    if (((n1.a) list.get(i7)).b == 2) {
                        i5 = -1;
                        break;
                    }
                    i7++;
                    size = i8;
                } else {
                    i5 = -1;
                    i7 = -1;
                    break;
                }
            }
            if (i7 != i5 && (d = ((n1.l) ((n1.a) a5.c.get(i7)).c.get(0)).d()) != null && d.v(c) != 0) {
                j8 = (d.a(d.c(j9, c)) + j8) - j9;
            }
            if (!bVar.c && bVar.d != -9223372036854775807L && bVar.b == -9223372036854775807L) {
                z5 = true;
            } else {
                z5 = false;
            }
            t0Var.f2320a = t0.f2319k;
            t0Var.b = this.f2788g;
            t0Var.c = bVar;
            t0Var.d = true;
            t0Var.f2321e = z5;
            t0Var.f2324h = j8;
            t0Var.f2325i = j7;
            t0Var.f2322f = 0;
            t0Var.f2323g = h() - 1;
            t0Var.f2326j = j5;
            return t0Var;
        }
        j5 = j6;
        if (!bVar.c) {
        }
        z5 = false;
        t0Var.f2320a = t0.f2319k;
        t0Var.b = this.f2788g;
        t0Var.c = bVar;
        t0Var.d = true;
        t0Var.f2321e = z5;
        t0Var.f2324h = j8;
        t0Var.f2325i = j7;
        t0Var.f2322f = 0;
        t0Var.f2323g = h() - 1;
        t0Var.f2326j = j5;
        return t0Var;
    }

    @Override // j0.u0
    public final int n() {
        return 1;
    }
}
