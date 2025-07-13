package j0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final j1.n f2219a;
    public final long b;
    public final long c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2220e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f2221f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f2222g;

    public d0(j1.n nVar, long j2, long j5, long j6, long j7, boolean z3, boolean z5) {
        this.f2219a = nVar;
        this.b = j2;
        this.c = j5;
        this.d = j6;
        this.f2220e = j7;
        this.f2221f = z3;
        this.f2222g = z5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d0.class != obj.getClass()) {
            return false;
        }
        d0 d0Var = (d0) obj;
        if (this.b == d0Var.b && this.c == d0Var.c && this.d == d0Var.d && this.f2220e == d0Var.f2220e && this.f2221f == d0Var.f2221f && this.f2222g == d0Var.f2222g && g2.w.a(this.f2219a, d0Var.f2219a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((this.f2219a.hashCode() + 527) * 31) + ((int) this.b)) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + ((int) this.f2220e)) * 31) + (this.f2221f ? 1 : 0)) * 31) + (this.f2222g ? 1 : 0);
    }
}
