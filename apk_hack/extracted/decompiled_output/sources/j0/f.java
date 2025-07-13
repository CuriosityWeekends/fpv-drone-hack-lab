package j0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final j0 f2234a;
    public boolean b;

    public f(j0 j0Var) {
        this.f2234a = j0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            return this.f2234a.equals(((f) obj).f2234a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2234a.hashCode();
    }
}
