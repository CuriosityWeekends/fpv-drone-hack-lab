package j1;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2454a;
    public final int b;
    public final int c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2455e;

    public n(long j2, Object obj) {
        this(obj, -1, -1, j2, -1);
    }

    public final boolean a() {
        if (this.b != -1) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f2454a.equals(nVar.f2454a) && this.b == nVar.b && this.c == nVar.c && this.d == nVar.d && this.f2455e == nVar.f2455e) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.f2454a.hashCode() + 527) * 31) + this.b) * 31) + this.c) * 31) + ((int) this.d)) * 31) + this.f2455e;
    }

    public n(Object obj, long j2, int i3) {
        this(obj, -1, -1, j2, i3);
    }

    public n(Object obj, int i3, int i5, long j2, int i6) {
        this.f2454a = obj;
        this.b = i3;
        this.c = i5;
        this.d = j2;
        this.f2455e = i6;
    }
}
