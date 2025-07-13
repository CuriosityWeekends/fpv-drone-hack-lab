package m2;

import com.google.gson.s;
import com.google.gson.t;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j implements t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2849a;
    public final /* synthetic */ Class b;
    public final /* synthetic */ s c;

    public /* synthetic */ j(Class cls, s sVar, int i3) {
        this.f2849a = i3;
        this.b = cls;
        this.c = sVar;
    }

    @Override // com.google.gson.t
    public final s a(com.google.gson.j jVar, o2.a aVar) {
        switch (this.f2849a) {
            case 0:
                if (aVar.f3050a == this.b) {
                    return this.c;
                }
                return null;
            default:
                Class<?> cls = aVar.f3050a;
                if (!this.b.isAssignableFrom(cls)) {
                    return null;
                }
                return new b(this, cls);
        }
    }

    public final String toString() {
        switch (this.f2849a) {
            case 0:
                return "Factory[type=" + this.b.getName() + ",adapter=" + this.c + "]";
            default:
                return "Factory[typeHierarchy=" + this.b.getName() + ",adapter=" + this.c + "]";
        }
    }
}
