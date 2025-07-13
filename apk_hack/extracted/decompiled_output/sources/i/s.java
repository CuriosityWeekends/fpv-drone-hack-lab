package i;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class s implements x, k.f, z {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f2123h = Log.isLoggable("Engine", 2);

    /* renamed from: a  reason: collision with root package name */
    public final c1.b f2124a;
    public final j3.a b;
    public final k.e c;
    public final q d;

    /* renamed from: e  reason: collision with root package name */
    public final k0 f2125e;

    /* renamed from: f  reason: collision with root package name */
    public final o f2126f;

    /* renamed from: g  reason: collision with root package name */
    public final b f2127g;

    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object, i.k0] */
    /* JADX WARN: Type inference failed for: r14v1, types: [android.os.Handler$Callback, java.lang.Object] */
    public s(k.e eVar, b3.e eVar2, l.b bVar, l.b bVar2, l.b bVar3, l.b bVar4) {
        this.c = eVar;
        r rVar = new r(eVar2);
        b bVar5 = new b(0);
        this.f2127g = bVar5;
        synchronized (this) {
            synchronized (bVar5) {
                bVar5.d = this;
            }
        }
        this.b = new j3.a(6);
        this.f2124a = new c1.b(7);
        this.d = new q(bVar, bVar2, bVar3, bVar4, this, this);
        this.f2126f = new o(rVar);
        ?? obj = new Object();
        obj.b = new Handler(Looper.getMainLooper(), new Object());
        this.f2125e = obj;
        eVar.d = this;
    }

    public static void d(String str, long j2, g.e eVar) {
        StringBuilder o5 = a1.i.o(str, " in ");
        o5.append(c0.h.a(j2));
        o5.append("ms, key: ");
        o5.append(eVar);
        Log.v("Engine", o5.toString());
    }

    public static void g(g0 g0Var) {
        if (g0Var instanceof a0) {
            ((a0) g0Var).c();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public final b a(com.bumptech.glide.f fVar, Object obj, g.e eVar, int i3, int i5, Class cls, Class cls2, com.bumptech.glide.j jVar, m mVar, CachedHashCodeArrayMap cachedHashCodeArrayMap, boolean z3, boolean z5, g.h hVar, boolean z6, boolean z7, boolean z8, boolean z9, y.f fVar2, Executor executor) {
        long j2;
        if (f2123h) {
            int i6 = c0.h.b;
            j2 = SystemClock.elapsedRealtimeNanos();
        } else {
            j2 = 0;
        }
        long j5 = j2;
        this.b.getClass();
        y yVar = new y(obj, eVar, i3, i5, cachedHashCodeArrayMap, cls, cls2, hVar);
        synchronized (this) {
            try {
                a0 c = c(yVar, z6, j5);
                if (c == null) {
                    return h(fVar, obj, eVar, i3, i5, cls, cls2, jVar, mVar, cachedHashCodeArrayMap, z3, z5, hVar, z6, z7, z8, z9, fVar2, executor, yVar, j5);
                }
                ((y.g) fVar2).k(c, 5, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final a0 b(g.e eVar) {
        a0 a0Var;
        Object obj;
        k.e eVar2 = this.c;
        synchronized (eVar2) {
            c0.i iVar = (c0.i) ((LinkedHashMap) eVar2.c).remove(eVar);
            a0Var = null;
            if (iVar == null) {
                obj = null;
            } else {
                eVar2.b -= iVar.b;
                obj = iVar.f194a;
            }
        }
        g0 g0Var = (g0) obj;
        if (g0Var != null) {
            if (g0Var instanceof a0) {
                a0Var = (a0) g0Var;
            } else {
                a0Var = new a0(g0Var, true, true, eVar, this);
            }
        }
        if (a0Var != null) {
            a0Var.b();
            this.f2127g.a(eVar, a0Var);
        }
        return a0Var;
    }

    public final a0 c(y yVar, boolean z3, long j2) {
        a0 a0Var;
        if (!z3) {
            return null;
        }
        b bVar = this.f2127g;
        synchronized (bVar) {
            a aVar = (a) ((HashMap) bVar.b).get(yVar);
            if (aVar == null) {
                a0Var = null;
            } else {
                a0Var = (a0) aVar.get();
                if (a0Var == null) {
                    bVar.c(aVar);
                }
            }
        }
        if (a0Var != null) {
            a0Var.b();
        }
        if (a0Var != null) {
            if (f2123h) {
                d("Loaded resource from active resources", j2, yVar);
            }
            return a0Var;
        }
        a0 b = b(yVar);
        if (b == null) {
            return null;
        }
        if (f2123h) {
            d("Loaded resource from cache", j2, yVar);
        }
        return b;
    }

    public final synchronized void e(w wVar, g.e eVar, a0 a0Var) {
        Object obj;
        if (a0Var != null) {
            try {
                if (a0Var.f2041a) {
                    this.f2127g.a(eVar, a0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        c1.b bVar = this.f2124a;
        bVar.getClass();
        if (wVar.f2144p) {
            obj = bVar.c;
        } else {
            obj = bVar.b;
        }
        HashMap hashMap = (HashMap) obj;
        if (wVar.equals(hashMap.get(eVar))) {
            hashMap.remove(eVar);
        }
    }

    public final void f(g.e eVar, a0 a0Var) {
        b bVar = this.f2127g;
        synchronized (bVar) {
            a aVar = (a) ((HashMap) bVar.b).remove(eVar);
            if (aVar != null) {
                aVar.c = null;
                aVar.clear();
            }
        }
        if (a0Var.f2041a) {
            g0 g0Var = (g0) this.c.g(eVar, a0Var);
        } else {
            this.f2125e.a(a0Var, false);
        }
    }

    public final b h(com.bumptech.glide.f fVar, Object obj, g.e eVar, int i3, int i5, Class cls, Class cls2, com.bumptech.glide.j jVar, m mVar, CachedHashCodeArrayMap cachedHashCodeArrayMap, boolean z3, boolean z5, g.h hVar, boolean z6, boolean z7, boolean z8, boolean z9, y.f fVar2, Executor executor, y yVar, long j2) {
        c1.b bVar = this.f2124a;
        w wVar = (w) ((HashMap) (z9 ? bVar.c : bVar.b)).get(yVar);
        if (wVar != null) {
            wVar.a(fVar2, executor);
            if (f2123h) {
                d("Added to existing load", j2, yVar);
            }
            return new b(this, fVar2, wVar);
        }
        w wVar2 = (w) this.d.f2121g.acquire();
        synchronized (wVar2) {
            wVar2.f2140l = yVar;
            wVar2.f2141m = z6;
            wVar2.f2142n = z7;
            wVar2.f2143o = z8;
            wVar2.f2144p = z9;
        }
        o oVar = this.f2126f;
        k kVar = (k) oVar.b.acquire();
        int i6 = oVar.c;
        oVar.c = i6 + 1;
        h hVar2 = kVar.f2087a;
        hVar2.c = fVar;
        hVar2.d = obj;
        hVar2.f2069n = eVar;
        hVar2.f2060e = i3;
        hVar2.f2061f = i5;
        hVar2.f2071p = mVar;
        hVar2.f2062g = cls;
        hVar2.f2063h = kVar.d;
        hVar2.f2066k = cls2;
        hVar2.f2070o = jVar;
        hVar2.f2064i = hVar;
        hVar2.f2065j = cachedHashCodeArrayMap;
        hVar2.q = z3;
        hVar2.f2072r = z5;
        kVar.f2091h = fVar;
        kVar.f2092i = eVar;
        kVar.f2093j = jVar;
        kVar.f2094k = yVar;
        kVar.f2095l = i3;
        kVar.f2096m = i5;
        kVar.f2097n = mVar;
        kVar.s = z9;
        kVar.f2098o = hVar;
        kVar.f2099p = wVar2;
        kVar.q = i6;
        kVar.E = 1;
        kVar.f2101t = obj;
        c1.b bVar2 = this.f2124a;
        bVar2.getClass();
        ((HashMap) (wVar2.f2144p ? bVar2.c : bVar2.b)).put(yVar, wVar2);
        wVar2.a(fVar2, executor);
        wVar2.k(kVar);
        if (f2123h) {
            d("Started new load", j2, yVar);
        }
        return new b(this, fVar2, wVar2);
    }
}
