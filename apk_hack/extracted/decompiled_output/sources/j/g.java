package j;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final c1.b f2187a = new c1.b(9);
    public final f b = new f(0);
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final int f2188e;

    /* renamed from: f  reason: collision with root package name */
    public int f2189f;

    public g(int i3) {
        this.f2188e = i3;
    }

    public final synchronized void a() {
        c(0);
    }

    public final void b(Class cls, int i3) {
        NavigableMap g5 = g(cls);
        Integer num = (Integer) g5.get(Integer.valueOf(i3));
        if (num != null) {
            if (num.intValue() == 1) {
                g5.remove(Integer.valueOf(i3));
                return;
            } else {
                g5.put(Integer.valueOf(i3), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i3 + ", this: " + this);
    }

    public final void c(int i3) {
        while (this.f2189f > i3) {
            Object x3 = this.f2187a.x();
            c0.g.b(x3);
            c e5 = e(x3.getClass());
            this.f2189f -= e5.b() * e5.a(x3);
            b(x3.getClass(), e5.a(x3));
            if (Log.isLoggable(e5.c(), 2)) {
                Log.v(e5.c(), "evicted: " + e5.a(x3));
            }
        }
    }

    public final synchronized Object d(Class cls, int i3) {
        e eVar;
        int i5;
        try {
            Integer num = (Integer) g(cls).ceilingKey(Integer.valueOf(i3));
            if (num == null || ((i5 = this.f2189f) != 0 && this.f2188e / i5 < 2 && num.intValue() > i3 * 8)) {
                f fVar = this.b;
                j jVar = (j) ((ArrayDeque) fVar.f2183a).poll();
                if (jVar == null) {
                    jVar = fVar.D();
                }
                eVar = (e) jVar;
                eVar.b = i3;
                eVar.c = cls;
            }
            f fVar2 = this.b;
            int intValue = num.intValue();
            j jVar2 = (j) ((ArrayDeque) fVar2.f2183a).poll();
            if (jVar2 == null) {
                jVar2 = fVar2.D();
            }
            eVar = (e) jVar2;
            eVar.b = intValue;
            eVar.c = cls;
        } catch (Throwable th) {
            throw th;
        }
        return f(eVar, cls);
    }

    public final c e(Class cls) {
        HashMap hashMap = this.d;
        c cVar = (c) hashMap.get(cls);
        if (cVar == null) {
            if (cls.equals(int[].class)) {
                cVar = new c(1);
            } else if (cls.equals(byte[].class)) {
                cVar = new c(0);
            } else {
                throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
            }
            hashMap.put(cls, cVar);
        }
        return cVar;
    }

    public final Object f(e eVar, Class cls) {
        c e5 = e(cls);
        Object r5 = this.f2187a.r(eVar);
        if (r5 != null) {
            this.f2189f -= e5.b() * e5.a(r5);
            b(cls, e5.a(r5));
        }
        if (r5 == null) {
            if (Log.isLoggable(e5.c(), 2)) {
                Log.v(e5.c(), "Allocated " + eVar.b + " bytes");
            }
            return e5.d(eVar.b);
        }
        return r5;
    }

    public final NavigableMap g(Class cls) {
        HashMap hashMap = this.c;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            hashMap.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    public final synchronized void h(Object obj) {
        Class<?> cls = obj.getClass();
        c e5 = e(cls);
        int a5 = e5.a(obj);
        int b = e5.b() * a5;
        if (b <= this.f2188e / 2) {
            f fVar = this.b;
            j jVar = (j) ((ArrayDeque) fVar.f2183a).poll();
            if (jVar == null) {
                jVar = fVar.D();
            }
            e eVar = (e) jVar;
            eVar.b = a5;
            eVar.c = cls;
            this.f2187a.u(eVar, obj);
            NavigableMap g5 = g(cls);
            Integer num = (Integer) g5.get(Integer.valueOf(eVar.b));
            Integer valueOf = Integer.valueOf(eVar.b);
            int i3 = 1;
            if (num != null) {
                i3 = 1 + num.intValue();
            }
            g5.put(valueOf, Integer.valueOf(i3));
            this.f2189f += b;
            c(this.f2188e);
        }
    }

    public final synchronized void i(int i3) {
        try {
            if (i3 >= 40) {
                a();
            } else if (i3 >= 20 || i3 == 15) {
                c(this.f2188e / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
