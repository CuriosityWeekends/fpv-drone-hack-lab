package c0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public Class f197a;
    public Class b;
    public Class c;

    public l(Class cls, Class cls2, Class cls3) {
        this.f197a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f197a.equals(lVar.f197a) && this.b.equals(lVar.b) && n.a(this.c, lVar.c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        int hashCode = (this.b.hashCode() + (this.f197a.hashCode() * 31)) * 31;
        Class cls = this.c;
        if (cls != null) {
            i3 = cls.hashCode();
        } else {
            i3 = 0;
        }
        return hashCode + i3;
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f197a + ", second=" + this.b + '}';
    }
}
