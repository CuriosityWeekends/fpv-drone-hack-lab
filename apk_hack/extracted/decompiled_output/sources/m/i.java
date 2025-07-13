package m;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final String f2743a;

    public i(String str) {
        this.f2743a = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f2743a.equals(((i) obj).f2743a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2743a.hashCode();
    }

    public final String toString() {
        return a1.i.k(new StringBuilder("StringHeaderFactory{value='"), this.f2743a, "'}");
    }
}
