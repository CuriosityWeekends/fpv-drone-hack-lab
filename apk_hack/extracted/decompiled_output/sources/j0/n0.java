package j0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n0 {
    public static final n0 b = new n0(0);

    /* renamed from: a  reason: collision with root package name */
    public final int f2275a;

    public n0(int i3) {
        this.f2275a = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n0.class == obj.getClass() && this.f2275a == ((n0) obj).f2275a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f2275a;
    }
}
