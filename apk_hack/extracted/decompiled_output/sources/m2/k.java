package m2;

import com.google.gson.s;
import com.google.gson.t;
import java.util.Calendar;
import java.util.GregorianCalendar;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k implements t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2850a;
    public final /* synthetic */ Class b;
    public final /* synthetic */ Class c;
    public final /* synthetic */ s d;

    public k(Class cls, Class cls2, s sVar) {
        this.f2850a = 0;
        this.b = cls;
        this.c = cls2;
        this.d = sVar;
    }

    @Override // com.google.gson.t
    public final s a(com.google.gson.j jVar, o2.a aVar) {
        switch (this.f2850a) {
            case 0:
                Class cls = aVar.f3050a;
                if (cls != this.b && cls != this.c) {
                    return null;
                }
                return this.d;
            default:
                Class cls2 = aVar.f3050a;
                if (cls2 != this.b && cls2 != this.c) {
                    return null;
                }
                return this.d;
        }
    }

    public final String toString() {
        switch (this.f2850a) {
            case 0:
                return "Factory[type=" + this.c.getName() + "+" + this.b.getName() + ",adapter=" + this.d + "]";
            default:
                return "Factory[type=" + this.b.getName() + "+" + this.c.getName() + ",adapter=" + this.d + "]";
        }
    }

    public k(e eVar) {
        this.f2850a = 1;
        this.b = Calendar.class;
        this.c = GregorianCalendar.class;
        this.d = eVar;
    }
}
