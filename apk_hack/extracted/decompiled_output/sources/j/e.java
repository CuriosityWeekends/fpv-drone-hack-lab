package j;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements j {

    /* renamed from: a  reason: collision with root package name */
    public final f f2186a;
    public int b;
    public Class c;

    public e(f fVar) {
        this.f2186a = fVar;
    }

    @Override // j.j
    public final void a() {
        this.f2186a.C(this);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.b != eVar.b || this.c != eVar.c) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i3;
        int i5 = this.b * 31;
        Class cls = this.c;
        if (cls != null) {
            i3 = cls.hashCode();
        } else {
            i3 = 0;
        }
        return i5 + i3;
    }

    public final String toString() {
        return "Key{size=" + this.b + "array=" + this.c + '}';
    }
}
