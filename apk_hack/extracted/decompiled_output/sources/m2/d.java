package m2;

import com.google.gson.s;
import java.lang.reflect.Type;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d extends s {

    /* renamed from: a  reason: collision with root package name */
    public final i f2842a;
    public final i b;
    public final l2.l c;

    public d(c cVar, com.google.gson.j jVar, Type type, s sVar, Type type2, s sVar2, l2.l lVar) {
        this.f2842a = new i(jVar, sVar, type);
        this.b = new i(jVar, sVar2, type2);
        this.c = lVar;
    }

    @Override // com.google.gson.s
    public final Object a(p2.a aVar) {
        int u5 = aVar.u();
        if (u5 == 9) {
            aVar.q();
            return null;
        }
        Map map = (Map) this.c.x();
        i iVar = this.b;
        i iVar2 = this.f2842a;
        if (u5 == 1) {
            aVar.a();
            while (aVar.h()) {
                aVar.a();
                Object a5 = iVar2.b.a(aVar);
                if (map.put(a5, iVar.b.a(aVar)) == null) {
                    aVar.e();
                } else {
                    throw new RuntimeException("duplicate key: " + a5);
                }
            }
            aVar.e();
        } else {
            aVar.b();
            while (aVar.h()) {
                j3.a.c.getClass();
                int i3 = aVar.f3213h;
                if (i3 == 0) {
                    i3 = aVar.d();
                }
                if (i3 == 13) {
                    aVar.f3213h = 9;
                } else if (i3 == 12) {
                    aVar.f3213h = 8;
                } else if (i3 == 14) {
                    aVar.f3213h = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + a1.i.B(aVar.u()) + aVar.j());
                }
                Object a6 = iVar2.b.a(aVar);
                if (map.put(a6, iVar.b.a(aVar)) != null) {
                    throw new RuntimeException("duplicate key: " + a6);
                }
            }
            aVar.f();
        }
        return map;
    }
}
