package i;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class w implements i, d0.e {

    /* renamed from: z  reason: collision with root package name */
    public static final j3.b f2131z = new j3.b(5);

    /* renamed from: a  reason: collision with root package name */
    public final v f2132a;
    public final d0.h b;
    public final z c;
    public final Pools.Pool d;

    /* renamed from: e  reason: collision with root package name */
    public final j3.b f2133e;

    /* renamed from: f  reason: collision with root package name */
    public final x f2134f;

    /* renamed from: g  reason: collision with root package name */
    public final l.b f2135g;

    /* renamed from: h  reason: collision with root package name */
    public final l.b f2136h;

    /* renamed from: i  reason: collision with root package name */
    public final l.b f2137i;

    /* renamed from: j  reason: collision with root package name */
    public final l.b f2138j;

    /* renamed from: k  reason: collision with root package name */
    public final AtomicInteger f2139k;

    /* renamed from: l  reason: collision with root package name */
    public g.e f2140l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f2141m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2142n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f2143o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2144p;
    public g0 q;

    /* renamed from: r  reason: collision with root package name */
    public int f2145r;
    public boolean s;

    /* renamed from: t  reason: collision with root package name */
    public c0 f2146t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2147u;

    /* renamed from: v  reason: collision with root package name */
    public a0 f2148v;
    public k w;

    /* renamed from: x  reason: collision with root package name */
    public volatile boolean f2149x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f2150y;

    /* JADX WARN: Type inference failed for: r1v1, types: [d0.h, java.lang.Object] */
    public w(l.b bVar, l.b bVar2, l.b bVar3, l.b bVar4, x xVar, z zVar, d0.d dVar) {
        j3.b bVar5 = f2131z;
        this.f2132a = new v(new ArrayList(2));
        this.b = new Object();
        this.f2139k = new AtomicInteger();
        this.f2135g = bVar;
        this.f2136h = bVar2;
        this.f2137i = bVar3;
        this.f2138j = bVar4;
        this.f2134f = xVar;
        this.c = zVar;
        this.d = dVar;
        this.f2133e = bVar5;
    }

    public final synchronized void a(y.f fVar, Executor executor) {
        try {
            this.b.d();
            v vVar = this.f2132a;
            vVar.getClass();
            vVar.f2130a.add(new u(fVar, executor));
            if (this.s) {
                e(1);
                executor.execute(new t(this, fVar, 1));
            } else if (this.f2147u) {
                e(1);
                executor.execute(new t(this, fVar, 0));
            } else {
                c0.g.a("Cannot add callbacks to a cancelled EngineJob", !this.f2149x);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b() {
        Object obj;
        if (f()) {
            return;
        }
        this.f2149x = true;
        k kVar = this.w;
        kVar.B = true;
        g gVar = kVar.f2106z;
        if (gVar != null) {
            gVar.cancel();
        }
        x xVar = this.f2134f;
        g.e eVar = this.f2140l;
        s sVar = (s) xVar;
        synchronized (sVar) {
            c1.b bVar = sVar.f2124a;
            bVar.getClass();
            if (this.f2144p) {
                obj = bVar.c;
            } else {
                obj = bVar.b;
            }
            HashMap hashMap = (HashMap) obj;
            if (equals(hashMap.get(eVar))) {
                hashMap.remove(eVar);
            }
        }
    }

    @Override // d0.e
    public final d0.h c() {
        return this.b;
    }

    public final void d() {
        boolean z3;
        a0 a0Var;
        synchronized (this) {
            try {
                this.b.d();
                c0.g.a("Not yet complete!", f());
                int decrementAndGet = this.f2139k.decrementAndGet();
                if (decrementAndGet >= 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                c0.g.a("Can't decrement below 0", z3);
                if (decrementAndGet == 0) {
                    a0Var = this.f2148v;
                    i();
                } else {
                    a0Var = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (a0Var != null) {
            a0Var.c();
        }
    }

    public final synchronized void e(int i3) {
        a0 a0Var;
        c0.g.a("Not yet complete!", f());
        if (this.f2139k.getAndAdd(i3) == 0 && (a0Var = this.f2148v) != null) {
            a0Var.b();
        }
    }

    public final boolean f() {
        if (!this.f2147u && !this.s && !this.f2149x) {
            return false;
        }
        return true;
    }

    public final void g() {
        synchronized (this) {
            try {
                this.b.d();
                if (this.f2149x) {
                    i();
                } else if (!this.f2132a.f2130a.isEmpty()) {
                    if (!this.f2147u) {
                        this.f2147u = true;
                        g.e eVar = this.f2140l;
                        v vVar = this.f2132a;
                        vVar.getClass();
                        ArrayList<u> arrayList = new ArrayList(vVar.f2130a);
                        e(arrayList.size() + 1);
                        ((s) this.f2134f).e(this, eVar, null);
                        for (u uVar : arrayList) {
                            uVar.b.execute(new t(this, uVar.f2129a, 0));
                        }
                        d();
                        return;
                    }
                    throw new IllegalStateException("Already failed once");
                } else {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        synchronized (this) {
            try {
                this.b.d();
                if (this.f2149x) {
                    this.q.recycle();
                    i();
                } else if (!this.f2132a.f2130a.isEmpty()) {
                    if (!this.s) {
                        j3.b bVar = this.f2133e;
                        g0 g0Var = this.q;
                        boolean z3 = this.f2141m;
                        g.e eVar = this.f2140l;
                        z zVar = this.c;
                        bVar.getClass();
                        this.f2148v = new a0(g0Var, z3, true, eVar, zVar);
                        this.s = true;
                        v vVar = this.f2132a;
                        vVar.getClass();
                        ArrayList<u> arrayList = new ArrayList(vVar.f2130a);
                        e(arrayList.size() + 1);
                        ((s) this.f2134f).e(this, this.f2140l, this.f2148v);
                        for (u uVar : arrayList) {
                            uVar.b.execute(new t(this, uVar.f2129a, 1));
                        }
                        d();
                        return;
                    }
                    throw new IllegalStateException("Already have resource");
                } else {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void i() {
        if (this.f2140l != null) {
            this.f2132a.f2130a.clear();
            this.f2140l = null;
            this.f2148v = null;
            this.q = null;
            this.f2147u = false;
            this.f2149x = false;
            this.s = false;
            this.f2150y = false;
            this.w.n();
            this.w = null;
            this.f2146t = null;
            this.f2145r = 0;
            this.d.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final synchronized void j(y.f fVar) {
        try {
            this.b.d();
            v vVar = this.f2132a;
            vVar.f2130a.remove(new u(fVar, c0.g.b));
            if (this.f2132a.f2130a.isEmpty()) {
                b();
                if (!this.s) {
                    if (this.f2147u) {
                    }
                }
                if (this.f2139k.get() == 0) {
                    i();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void k(k kVar) {
        l.b bVar;
        this.w = kVar;
        int i3 = kVar.i(1);
        if (i3 != 2 && i3 != 3) {
            if (this.f2142n) {
                bVar = this.f2137i;
            } else if (this.f2143o) {
                bVar = this.f2138j;
            } else {
                bVar = this.f2136h;
            }
            bVar.execute(kVar);
        }
        bVar = this.f2135g;
        bVar.execute(kVar);
    }
}
