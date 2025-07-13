package m2;

import com.google.gson.s;
import com.google.gson.t;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2838a;

    public /* synthetic */ a(int i3) {
        this.f2838a = i3;
    }

    @Override // com.google.gson.t
    public final s a(com.google.gson.j jVar, o2.a aVar) {
        Type componentType;
        switch (this.f2838a) {
            case 0:
                Type type = aVar.b;
                boolean z3 = type instanceof GenericArrayType;
                if (!z3 && (!(type instanceof Class) || !((Class) type).isArray())) {
                    return null;
                }
                if (z3) {
                    componentType = ((GenericArrayType) type).getGenericComponentType();
                } else {
                    componentType = ((Class) type).getComponentType();
                }
                return new b(jVar, jVar.a(new o2.a(componentType)), l2.d.g(componentType));
            case 1:
                if (aVar.f3050a == Date.class) {
                    return new b();
                }
                return null;
            case 2:
                if (aVar.f3050a == Object.class) {
                    return new e(jVar);
                }
                return null;
            case 3:
                if (aVar.f3050a == java.sql.Date.class) {
                    return new h(0);
                }
                return null;
            case 4:
                if (aVar.f3050a == Time.class) {
                    return new h(1);
                }
                return null;
            case 5:
                if (aVar.f3050a != Timestamp.class) {
                    return null;
                }
                jVar.getClass();
                return new i(jVar.a(new o2.a(Date.class)));
            default:
                Class cls = aVar.f3050a;
                if (Enum.class.isAssignableFrom(cls) && cls != Enum.class) {
                    if (!cls.isEnum()) {
                        cls = cls.getSuperclass();
                    }
                    return new b(cls);
                }
                return null;
        }
    }
}
