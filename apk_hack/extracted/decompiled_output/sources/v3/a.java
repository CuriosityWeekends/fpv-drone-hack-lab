package v3;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f3897a;
    public final boolean b;
    public final boolean c;

    public a(String str, boolean z3, boolean z5) {
        this.f3897a = str;
        this.b = z3;
        this.c = z5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.b != aVar.b || this.c != aVar.c) {
            return false;
        }
        return this.f3897a.equals(aVar.f3897a);
    }

    public final int hashCode() {
        return (((this.f3897a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0);
    }

    public final String toString() {
        return "Permission{name='" + this.f3897a + "', granted=" + this.b + ", shouldShowRequestPermissionRationale=" + this.c + '}';
    }
}
