package j0;

import android.util.Pair;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class u0 {

    /* renamed from: a  reason: collision with root package name */
    public static final r0 f2344a = new Object();

    public int a(boolean z3) {
        if (o()) {
            return -1;
        }
        return 0;
    }

    public abstract int b(Object obj);

    public int c(boolean z3) {
        if (o()) {
            return -1;
        }
        return n() - 1;
    }

    public final int d(int i3, s0 s0Var, t0 t0Var, int i5, boolean z3) {
        int i6 = f(i3, s0Var, false).c;
        if (m(i6, t0Var, 0L).f2323g == i3) {
            int e5 = e(i6, i5, z3);
            if (e5 == -1) {
                return -1;
            }
            return m(e5, t0Var, 0L).f2322f;
        }
        return i3 + 1;
    }

    public int e(int i3, int i5, boolean z3) {
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    if (i3 == c(z3)) {
                        return a(z3);
                    }
                    return i3 + 1;
                }
                throw new IllegalStateException();
            }
            return i3;
        } else if (i3 == c(z3)) {
            return -1;
        } else {
            return i3 + 1;
        }
    }

    public abstract s0 f(int i3, s0 s0Var, boolean z3);

    public s0 g(Object obj, s0 s0Var) {
        return f(b(obj), s0Var, true);
    }

    public abstract int h();

    public final Pair i(t0 t0Var, s0 s0Var, int i3, long j2) {
        Pair j5 = j(t0Var, s0Var, i3, j2, 0L);
        j5.getClass();
        return j5;
    }

    public final Pair j(t0 t0Var, s0 s0Var, int i3, long j2, long j5) {
        g2.b.g(i3, n());
        m(i3, t0Var, j5);
        if (j2 == -9223372036854775807L) {
            j2 = t0Var.f2324h;
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        int i5 = t0Var.f2322f;
        long j6 = t0Var.f2326j + j2;
        long j7 = f(i5, s0Var, true).d;
        while (j7 != -9223372036854775807L && j6 >= j7 && i5 < t0Var.f2323g) {
            j6 -= j7;
            i5++;
            j7 = f(i5, s0Var, true).d;
        }
        Object obj = s0Var.b;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(j6));
    }

    public int k(int i3, int i5, boolean z3) {
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    if (i3 == a(z3)) {
                        return c(z3);
                    }
                    return i3 - 1;
                }
                throw new IllegalStateException();
            }
            return i3;
        } else if (i3 == a(z3)) {
            return -1;
        } else {
            return i3 - 1;
        }
    }

    public abstract Object l(int i3);

    public abstract t0 m(int i3, t0 t0Var, long j2);

    public abstract int n();

    public final boolean o() {
        if (n() == 0) {
            return true;
        }
        return false;
    }
}
