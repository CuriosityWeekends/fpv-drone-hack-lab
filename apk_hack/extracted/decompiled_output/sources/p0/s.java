package p0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class s {
    public static final s c = new s(0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final long f3129a;
    public final long b;

    public s(long j2, long j5) {
        this.f3129a = j2;
        this.b = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        if (this.f3129a == sVar.f3129a && this.b == sVar.b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f3129a) * 31) + ((int) this.b);
    }

    public final String toString() {
        return "[timeUs=" + this.f3129a + ", position=" + this.b + "]";
    }
}
