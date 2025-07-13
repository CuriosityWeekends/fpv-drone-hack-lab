package j0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o0 {
    public static final o0 c;
    public static final o0 d;

    /* renamed from: a  reason: collision with root package name */
    public final long f2277a;
    public final long b;

    static {
        o0 o0Var = new o0(0L, 0L);
        c = o0Var;
        new o0(Long.MAX_VALUE, Long.MAX_VALUE);
        new o0(Long.MAX_VALUE, 0L);
        new o0(0L, Long.MAX_VALUE);
        d = o0Var;
    }

    public o0(long j2, long j5) {
        boolean z3;
        if (j2 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.e(z3);
        g2.b.e(j5 >= 0);
        this.f2277a = j2;
        this.b = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o0.class != obj.getClass()) {
            return false;
        }
        o0 o0Var = (o0) obj;
        if (this.f2277a == o0Var.f2277a && this.b == o0Var.b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f2277a) * 31) + ((int) this.b);
    }
}
