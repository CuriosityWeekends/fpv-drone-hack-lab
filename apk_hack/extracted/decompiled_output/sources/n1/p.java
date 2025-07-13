package n1;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final long f2945a;
    public final long b;

    public p(long j2, long j5) {
        this.f2945a = j2;
        this.b = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f2945a == pVar.f2945a && this.b == pVar.b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f2945a) * 31) + ((int) this.b);
    }
}
