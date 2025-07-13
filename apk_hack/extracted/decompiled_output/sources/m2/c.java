package m2;

import com.google.gson.s;
import com.google.gson.t;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2841a;
    public final com.bumptech.glide.h b;

    public /* synthetic */ c(com.bumptech.glide.h hVar, int i3) {
        this.f2841a = i3;
        this.b = hVar;
    }

    public static s b(com.bumptech.glide.h hVar, com.google.gson.j jVar, o2.a aVar, k2.a aVar2) {
        s a5;
        Object x3 = hVar.a(new o2.a(aVar2.value())).x();
        if (x3 instanceof s) {
            a5 = (s) x3;
        } else if (x3 instanceof t) {
            a5 = ((t) x3).a(jVar, aVar);
        } else {
            throw new IllegalArgumentException("Invalid attempt to bind an instance of " + x3.getClass().getName() + " as a @JsonAdapter for " + l2.d.j(aVar.b) + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        }
        if (a5 != null && aVar2.nullSafe()) {
            return new com.google.gson.h(a5, 2);
        }
        return a5;
    }

    @Override // com.google.gson.t
    public final s a(com.google.gson.j jVar, o2.a aVar) {
        Type[] typeArr;
        s sVar;
        Type type = Object.class;
        com.bumptech.glide.h hVar = this.b;
        switch (this.f2841a) {
            case 0:
                Type type2 = aVar.b;
                Class cls = aVar.f3050a;
                if (!Collection.class.isAssignableFrom(cls)) {
                    return null;
                }
                l2.d.c(Collection.class.isAssignableFrom(cls));
                Type i3 = l2.d.i(type2, cls, l2.d.f(type2, cls, Collection.class), new HashSet());
                if (i3 instanceof WildcardType) {
                    i3 = ((WildcardType) i3).getUpperBounds()[0];
                }
                if (i3 instanceof ParameterizedType) {
                    type = ((ParameterizedType) i3).getActualTypeArguments()[0];
                }
                return new b(jVar, type, jVar.a(new o2.a(type)), hVar.a(aVar));
            case 1:
                k2.a aVar2 = (k2.a) aVar.f3050a.getAnnotation(k2.a.class);
                if (aVar2 == null) {
                    return null;
                }
                return b(hVar, jVar, aVar, aVar2);
            default:
                Type type3 = aVar.b;
                if (!Map.class.isAssignableFrom(aVar.f3050a)) {
                    return null;
                }
                Class g5 = l2.d.g(type3);
                if (type3 == Properties.class) {
                    typeArr = new Type[]{String.class, String.class};
                } else {
                    l2.d.c(Map.class.isAssignableFrom(g5));
                    Type i5 = l2.d.i(type3, g5, l2.d.f(type3, g5, Map.class), new HashSet());
                    if (i5 instanceof ParameterizedType) {
                        typeArr = ((ParameterizedType) i5).getActualTypeArguments();
                    } else {
                        typeArr = new Type[]{type, type};
                    }
                }
                Type type4 = typeArr[0];
                if (type4 != Boolean.TYPE && type4 != Boolean.class) {
                    sVar = jVar.a(new o2.a(type4));
                } else {
                    sVar = l.c;
                }
                return new d(this, jVar, typeArr[0], sVar, typeArr[1], jVar.a(new o2.a(typeArr[1])), hVar.a(aVar));
        }
    }
}
