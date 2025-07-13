package i;

import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k implements f, Runnable, Comparable, d0.e {
    public volatile boolean A;
    public volatile boolean B;
    public boolean C;
    public int D;
    public int E;
    public int F;
    public final r d;

    /* renamed from: e  reason: collision with root package name */
    public final Pools.Pool f2088e;

    /* renamed from: h  reason: collision with root package name */
    public com.bumptech.glide.f f2091h;

    /* renamed from: i  reason: collision with root package name */
    public g.e f2092i;

    /* renamed from: j  reason: collision with root package name */
    public com.bumptech.glide.j f2093j;

    /* renamed from: k  reason: collision with root package name */
    public y f2094k;

    /* renamed from: l  reason: collision with root package name */
    public int f2095l;

    /* renamed from: m  reason: collision with root package name */
    public int f2096m;

    /* renamed from: n  reason: collision with root package name */
    public m f2097n;

    /* renamed from: o  reason: collision with root package name */
    public g.h f2098o;

    /* renamed from: p  reason: collision with root package name */
    public i f2099p;
    public int q;

    /* renamed from: r  reason: collision with root package name */
    public long f2100r;
    public boolean s;

    /* renamed from: t  reason: collision with root package name */
    public Object f2101t;

    /* renamed from: u  reason: collision with root package name */
    public Thread f2102u;

    /* renamed from: v  reason: collision with root package name */
    public g.e f2103v;
    public g.e w;

    /* renamed from: x  reason: collision with root package name */
    public Object f2104x;

    /* renamed from: y  reason: collision with root package name */
    public com.bumptech.glide.load.data.e f2105y;

    /* renamed from: z  reason: collision with root package name */
    public volatile g f2106z;

    /* renamed from: a  reason: collision with root package name */
    public final h f2087a = new h();
    public final ArrayList b = new ArrayList();
    public final d0.h c = new Object();

    /* renamed from: f  reason: collision with root package name */
    public final b f2089f = new b(2);

    /* renamed from: g  reason: collision with root package name */
    public final j f2090g = new Object();

    /* JADX WARN: Type inference failed for: r0v2, types: [d0.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4, types: [i.j, java.lang.Object] */
    public k(r rVar, d0.d dVar) {
        this.d = rVar;
        this.f2088e = dVar;
    }

    @Override // i.f
    public final void a() {
        l.b bVar;
        this.E = 2;
        w wVar = (w) this.f2099p;
        if (wVar.f2142n) {
            bVar = wVar.f2137i;
        } else if (wVar.f2143o) {
            bVar = wVar.f2138j;
        } else {
            bVar = wVar.f2136h;
        }
        bVar.execute(this);
    }

    @Override // i.f
    public final void b(g.e eVar, Object obj, com.bumptech.glide.load.data.e eVar2, int i3, g.e eVar3) {
        l.b bVar;
        this.f2103v = eVar;
        this.f2104x = obj;
        this.f2105y = eVar2;
        this.F = i3;
        this.w = eVar3;
        boolean z3 = false;
        if (eVar != this.f2087a.a().get(0)) {
            z3 = true;
        }
        this.C = z3;
        if (Thread.currentThread() != this.f2102u) {
            this.E = 3;
            w wVar = (w) this.f2099p;
            if (wVar.f2142n) {
                bVar = wVar.f2137i;
            } else if (wVar.f2143o) {
                bVar = wVar.f2138j;
            } else {
                bVar = wVar.f2136h;
            }
            bVar.execute(this);
            return;
        }
        g();
    }

    @Override // d0.e
    public final d0.h c() {
        return this.c;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        k kVar = (k) obj;
        int ordinal = this.f2093j.ordinal() - kVar.f2093j.ordinal();
        if (ordinal == 0) {
            return this.q - kVar.q;
        }
        return ordinal;
    }

    @Override // i.f
    public final void d(g.e eVar, Exception exc, com.bumptech.glide.load.data.e eVar2, int i3) {
        l.b bVar;
        eVar2.b();
        c0 c0Var = new c0("Fetching data failed", Collections.singletonList(exc));
        Class a5 = eVar2.a();
        c0Var.b = eVar;
        c0Var.c = i3;
        c0Var.d = a5;
        this.b.add(c0Var);
        if (Thread.currentThread() != this.f2102u) {
            this.E = 2;
            w wVar = (w) this.f2099p;
            if (wVar.f2142n) {
                bVar = wVar.f2137i;
            } else if (wVar.f2143o) {
                bVar = wVar.f2138j;
            } else {
                bVar = wVar.f2136h;
            }
            bVar.execute(this);
            return;
        }
        p();
    }

    public final g0 e(com.bumptech.glide.load.data.e eVar, Object obj, int i3) {
        if (obj == null) {
            return null;
        }
        try {
            int i5 = c0.h.b;
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            g0 f4 = f(i3, obj);
            if (Log.isLoggable("DecodeJob", 2)) {
                j(elapsedRealtimeNanos, "Decoded result " + f4, null);
            }
            return f4;
        } finally {
            eVar.b();
        }
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [a1.m, java.lang.Object] */
    public final g0 f(int i3, Object obj) {
        boolean z3;
        com.bumptech.glide.load.data.g b;
        e0 c = this.f2087a.c(obj.getClass());
        g.h hVar = this.f2098o;
        if (Build.VERSION.SDK_INT >= 26) {
            if (i3 != 4 && !this.f2087a.f2072r) {
                z3 = false;
            } else {
                z3 = true;
            }
            g.g gVar = p.o.f3076i;
            Boolean bool = (Boolean) hVar.c(gVar);
            if (bool == null || (bool.booleanValue() && !z3)) {
                hVar = new g.h();
                hVar.b.putAll((SimpleArrayMap) this.f2098o.b);
                hVar.b.put(gVar, Boolean.valueOf(z3));
            }
        }
        g.h hVar2 = hVar;
        com.bumptech.glide.load.data.i iVar = this.f2091h.b.f276e;
        synchronized (iVar) {
            try {
                com.bumptech.glide.load.data.f fVar = (com.bumptech.glide.load.data.f) ((HashMap) iVar.b).get(obj.getClass());
                if (fVar == null) {
                    Iterator it = ((HashMap) iVar.b).values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.bumptech.glide.load.data.f fVar2 = (com.bumptech.glide.load.data.f) it.next();
                        if (fVar2.a().isAssignableFrom(obj.getClass())) {
                            fVar = fVar2;
                            break;
                        }
                    }
                }
                if (fVar == null) {
                    fVar = com.bumptech.glide.load.data.i.c;
                }
                b = fVar.b(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            int i5 = this.f2095l;
            int i6 = this.f2096m;
            ?? obj2 = new Object();
            obj2.b = this;
            obj2.f39a = i3;
            return c.a(i5, i6, obj2, b, hVar2);
        } finally {
            b.b();
        }
    }

    public final void g() {
        f0 f0Var;
        if (Log.isLoggable("DecodeJob", 2)) {
            j(this.f2100r, "Retrieved data", "data: " + this.f2104x + ", cache key: " + this.f2103v + ", fetcher: " + this.f2105y);
        }
        f0 f0Var2 = null;
        try {
            f0Var = e(this.f2105y, this.f2104x, this.F);
        } catch (c0 e5) {
            g.e eVar = this.w;
            int i3 = this.F;
            e5.b = eVar;
            e5.c = i3;
            e5.d = null;
            this.b.add(e5);
            f0Var = null;
        }
        if (f0Var != null) {
            int i5 = this.F;
            boolean z3 = this.C;
            if (f0Var instanceof d0) {
                ((d0) f0Var).initialize();
            }
            if (((f0) this.f2089f.d) != null) {
                f0Var2 = (f0) f0.f2057e.acquire();
                f0Var2.d = false;
                f0Var2.c = true;
                f0Var2.b = f0Var;
                f0Var = f0Var2;
            }
            r();
            w wVar = (w) this.f2099p;
            synchronized (wVar) {
                wVar.q = f0Var;
                wVar.f2145r = i5;
                wVar.f2150y = z3;
            }
            wVar.h();
            this.D = 5;
            try {
                b bVar = this.f2089f;
                if (((f0) bVar.d) != null) {
                    r rVar = this.d;
                    g.h hVar = this.f2098o;
                    bVar.getClass();
                    rVar.a().e((g.e) bVar.b, new b((g.k) bVar.c, (f0) bVar.d, hVar, 1));
                    ((f0) bVar.d).b();
                }
                l();
                return;
            } finally {
                if (f0Var2 != null) {
                    f0Var2.b();
                }
            }
        }
        p();
    }

    public final g h() {
        int b = com.bumptech.glide.i.b(this.D);
        h hVar = this.f2087a;
        if (b != 1) {
            if (b != 2) {
                if (b != 3) {
                    if (b == 5) {
                        return null;
                    }
                    throw new IllegalStateException("Unrecognized stage: ".concat(a1.i.A(this.D)));
                }
                return new l0(hVar, this);
            }
            return new d(hVar.a(), hVar, this);
        }
        return new h0(hVar, this);
    }

    public final int i(int i3) {
        int b = com.bumptech.glide.i.b(i3);
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    if (b == 3 || b == 5) {
                        return 6;
                    }
                    throw new IllegalArgumentException("Unrecognized stage: ".concat(a1.i.A(i3)));
                } else if (this.s) {
                    return 6;
                } else {
                    return 4;
                }
            } else if (this.f2097n.a()) {
                return 3;
            } else {
                return i(3);
            }
        } else if (this.f2097n.b()) {
            return 2;
        } else {
            return i(2);
        }
    }

    public final void j(long j2, String str, String str2) {
        String str3;
        StringBuilder o5 = a1.i.o(str, " in ");
        o5.append(c0.h.a(j2));
        o5.append(", load key: ");
        o5.append(this.f2094k);
        if (str2 != null) {
            str3 = ", ".concat(str2);
        } else {
            str3 = "";
        }
        o5.append(str3);
        o5.append(", thread: ");
        o5.append(Thread.currentThread().getName());
        Log.v("DecodeJob", o5.toString());
    }

    public final void k() {
        r();
        c0 c0Var = new c0("Failed to load resource", new ArrayList(this.b));
        w wVar = (w) this.f2099p;
        synchronized (wVar) {
            wVar.f2146t = c0Var;
        }
        wVar.g();
        m();
    }

    public final void l() {
        boolean a5;
        j jVar = this.f2090g;
        synchronized (jVar) {
            jVar.b = true;
            a5 = jVar.a();
        }
        if (a5) {
            o();
        }
    }

    public final void m() {
        boolean a5;
        j jVar = this.f2090g;
        synchronized (jVar) {
            jVar.c = true;
            a5 = jVar.a();
        }
        if (a5) {
            o();
        }
    }

    public final void n() {
        boolean a5;
        j jVar = this.f2090g;
        synchronized (jVar) {
            jVar.f2086a = true;
            a5 = jVar.a();
        }
        if (a5) {
            o();
        }
    }

    public final void o() {
        j jVar = this.f2090g;
        synchronized (jVar) {
            jVar.b = false;
            jVar.f2086a = false;
            jVar.c = false;
        }
        b bVar = this.f2089f;
        bVar.b = null;
        bVar.c = null;
        bVar.d = null;
        h hVar = this.f2087a;
        hVar.c = null;
        hVar.d = null;
        hVar.f2069n = null;
        hVar.f2062g = null;
        hVar.f2066k = null;
        hVar.f2064i = null;
        hVar.f2070o = null;
        hVar.f2065j = null;
        hVar.f2071p = null;
        hVar.f2059a.clear();
        hVar.f2067l = false;
        hVar.b.clear();
        hVar.f2068m = false;
        this.A = false;
        this.f2091h = null;
        this.f2092i = null;
        this.f2098o = null;
        this.f2093j = null;
        this.f2094k = null;
        this.f2099p = null;
        this.D = 0;
        this.f2106z = null;
        this.f2102u = null;
        this.f2103v = null;
        this.f2104x = null;
        this.F = 0;
        this.f2105y = null;
        this.f2100r = 0L;
        this.B = false;
        this.b.clear();
        this.f2088e.release(this);
    }

    public final void p() {
        this.f2102u = Thread.currentThread();
        int i3 = c0.h.b;
        this.f2100r = SystemClock.elapsedRealtimeNanos();
        boolean z3 = false;
        while (!this.B && this.f2106z != null && !(z3 = this.f2106z.c())) {
            this.D = i(this.D);
            this.f2106z = h();
            if (this.D == 4) {
                a();
                return;
            }
        }
        if ((this.D == 6 || this.B) && !z3) {
            k();
        }
    }

    public final void q() {
        String str;
        int b = com.bumptech.glide.i.b(this.E);
        if (b != 0) {
            if (b != 1) {
                if (b == 2) {
                    g();
                    return;
                }
                int i3 = this.E;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            str = "null";
                        } else {
                            str = "DECODE_DATA";
                        }
                    } else {
                        str = "SWITCH_TO_SOURCE_SERVICE";
                    }
                } else {
                    str = "INITIALIZE";
                }
                throw new IllegalStateException("Unrecognized run reason: ".concat(str));
            }
            p();
            return;
        }
        this.D = i(1);
        this.f2106z = h();
        p();
    }

    public final void r() {
        Throwable th;
        this.c.d();
        if (this.A) {
            if (this.b.isEmpty()) {
                th = null;
            } else {
                ArrayList arrayList = this.b;
                th = (Throwable) arrayList.get(arrayList.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.A = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bumptech.glide.load.data.e eVar = this.f2105y;
        try {
            try {
                if (this.B) {
                    k();
                    if (eVar != null) {
                        eVar.b();
                        return;
                    }
                    return;
                }
                q();
                if (eVar != null) {
                    eVar.b();
                }
            } catch (Throwable th) {
                if (eVar != null) {
                    eVar.b();
                }
                throw th;
            }
        } catch (c e5) {
            throw e5;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.B + ", stage: " + a1.i.A(this.D), th2);
            }
            if (this.D != 5) {
                this.b.add(th2);
                k();
            }
            if (!this.B) {
                throw th2;
            }
            throw th2;
        }
    }
}
