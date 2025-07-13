package p0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final s f3128a;
    public final s b;

    public q(s sVar, s sVar2) {
        this.f3128a = sVar;
        this.b = sVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f3128a.equals(qVar.f3128a) && this.b.equals(qVar.b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f3128a.hashCode() * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("[");
        s sVar = this.f3128a;
        sb.append(sVar);
        s sVar2 = this.b;
        if (sVar.equals(sVar2)) {
            str = "";
        } else {
            str = ", " + sVar2;
        }
        return a1.i.k(sb, str, "]");
    }
}
