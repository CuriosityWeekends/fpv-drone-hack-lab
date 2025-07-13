package com.bumptech.glide;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f251a = 0;
    public final Map b;

    public h(g gVar) {
        this.b = Collections.unmodifiableMap(new HashMap(gVar.f250a));
    }

    public l2.l a(o2.a aVar) {
        b3.e eVar;
        Type type = aVar.b;
        Map map = this.b;
        i.a(map.get(type));
        Class cls = aVar.f3050a;
        i.a(map.get(cls));
        l2.l lVar = null;
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            eVar = new b3.e(15, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            eVar = null;
        }
        if (eVar != null) {
            return eVar;
        }
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                lVar = new j3.a(13);
            } else if (EnumSet.class.isAssignableFrom(cls)) {
                lVar = new b3.e(16, type);
            } else if (Set.class.isAssignableFrom(cls)) {
                lVar = new j3.b(13);
            } else if (Queue.class.isAssignableFrom(cls)) {
                lVar = new j3.a(14);
            } else {
                lVar = new j3.b(14);
            }
        } else if (Map.class.isAssignableFrom(cls)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                lVar = new j3.a(15);
            } else if (ConcurrentMap.class.isAssignableFrom(cls)) {
                lVar = new j3.a(11);
            } else if (SortedMap.class.isAssignableFrom(cls)) {
                lVar = new j3.b(11);
            } else {
                if (type instanceof ParameterizedType) {
                    Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                    type2.getClass();
                    Type b = l2.d.b(type2);
                    Class g5 = l2.d.g(b);
                    b.hashCode();
                    if (!String.class.isAssignableFrom(g5)) {
                        lVar = new j3.a(12);
                    }
                }
                lVar = new j3.b(12);
            }
        }
        if (lVar != null) {
            return lVar;
        }
        return new i.b(cls, type);
    }

    public String toString() {
        switch (this.f251a) {
            case 1:
                return this.b.toString();
            default:
                return super.toString();
        }
    }

    public h(Map map) {
        this.b = map;
    }
}
