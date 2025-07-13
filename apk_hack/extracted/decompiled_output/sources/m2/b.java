package m2;

import com.google.gson.s;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends s {
    public static final a d = new a(0);

    /* renamed from: e  reason: collision with root package name */
    public static final a f2839e = new a(1);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2840a;
    public final Object b;
    public final Object c;

    public b() {
        this.f2840a = 1;
        this.b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
        this.c = DateFormat.getDateTimeInstance(2, 2);
    }

    @Override // com.google.gson.s
    public final Object a(p2.a aVar) {
        Date parse;
        switch (this.f2840a) {
            case 0:
                if (aVar.u() == 9) {
                    aVar.q();
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.h()) {
                    arrayList.add(((i) this.c).b.a(aVar));
                }
                aVar.e();
                int size = arrayList.size();
                Object newInstance = Array.newInstance((Class) this.b, size);
                for (int i3 = 0; i3 < size; i3++) {
                    Array.set(newInstance, i3, arrayList.get(i3));
                }
                return newInstance;
            case 1:
                if (aVar.u() == 9) {
                    aVar.q();
                    return null;
                }
                String s = aVar.s();
                synchronized (this) {
                    try {
                        try {
                            try {
                                parse = ((DateFormat) this.c).parse(s);
                            } catch (ParseException unused) {
                                return ((DateFormat) this.b).parse(s);
                            }
                        } catch (ParseException e5) {
                            throw new RuntimeException(s, e5);
                        }
                    } catch (ParseException unused2) {
                        return n2.a.b(s, new ParsePosition(0));
                    }
                }
                return parse;
            case 2:
                if (aVar.u() == 9) {
                    aVar.q();
                    return null;
                }
                Collection collection = (Collection) ((l2.l) this.b).x();
                aVar.a();
                while (aVar.h()) {
                    collection.add(((i) this.c).b.a(aVar));
                }
                aVar.e();
                return collection;
            case 3:
                if (aVar.u() == 9) {
                    aVar.q();
                    return null;
                }
                Object x3 = ((l2.l) this.b).x();
                try {
                    aVar.b();
                    while (aVar.h()) {
                        f fVar = (f) ((Map) this.c).get(aVar.o());
                        if (fVar != null && fVar.b) {
                            Object a5 = fVar.d.a(aVar);
                            if (a5 != null || !fVar.f2845e) {
                                fVar.c.set(x3, a5);
                            }
                        }
                        aVar.z();
                    }
                    aVar.f();
                    return x3;
                } catch (IllegalAccessException e6) {
                    throw new AssertionError(e6);
                } catch (IllegalStateException e7) {
                    throw new RuntimeException(e7);
                }
            case 4:
                Object a6 = ((j) this.c).c.a(aVar);
                if (a6 != null) {
                    Class cls = (Class) this.b;
                    if (!cls.isInstance(a6)) {
                        throw new RuntimeException("Expected a " + cls.getName() + " but was " + a6.getClass().getName());
                    }
                }
                return a6;
            default:
                if (aVar.u() == 9) {
                    aVar.q();
                    return null;
                }
                return (Enum) ((HashMap) this.b).get(aVar.s());
        }
    }

    public b(com.google.gson.j jVar, s sVar, Class cls) {
        this.f2840a = 0;
        this.c = new i(jVar, sVar, cls);
        this.b = cls;
    }

    public b(com.google.gson.j jVar, Type type, s sVar, l2.l lVar) {
        this.f2840a = 2;
        this.c = new i(jVar, sVar, type);
        this.b = lVar;
    }

    public b(Class cls) {
        Enum[] enumArr;
        this.f2840a = 5;
        this.b = new HashMap();
        this.c = new HashMap();
        try {
            for (Enum r42 : (Enum[]) cls.getEnumConstants()) {
                String name = r42.name();
                k2.b bVar = (k2.b) cls.getField(name).getAnnotation(k2.b.class);
                if (bVar != null) {
                    name = bVar.value();
                    for (String str : bVar.alternate()) {
                        ((HashMap) this.b).put(str, r42);
                    }
                }
                ((HashMap) this.b).put(name, r42);
                ((HashMap) this.c).put(r42, name);
            }
        } catch (NoSuchFieldException e5) {
            throw new AssertionError(e5);
        }
    }

    public b(l2.l lVar, LinkedHashMap linkedHashMap) {
        this.f2840a = 3;
        this.b = lVar;
        this.c = linkedHashMap;
    }

    public b(j jVar, Class cls) {
        this.f2840a = 4;
        this.c = jVar;
        this.b = cls;
    }
}
