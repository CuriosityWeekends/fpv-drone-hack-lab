package j1;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f2375a;
    public final boolean b;

    public c0(int i3, boolean z3) {
        this.f2375a = i3;
        this.b = z3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c0.class != obj.getClass()) {
            return false;
        }
        c0 c0Var = (c0) obj;
        if (this.f2375a == c0Var.f2375a && this.b == c0Var.b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f2375a * 31) + (this.b ? 1 : 0);
    }
}
