package j0;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class y implements Handler.Callback, j1.l, j1.o {
    public int A;
    public boolean B;
    public boolean C;
    public int D;
    public x E;
    public long F;
    public int G;
    public boolean H;

    /* renamed from: a  reason: collision with root package name */
    public final h[] f2348a;
    public final h[] b;
    public final b2.l c;
    public final a2.l d;

    /* renamed from: e  reason: collision with root package name */
    public final b0 f2349e;

    /* renamed from: f  reason: collision with root package name */
    public final e2.d f2350f;

    /* renamed from: g  reason: collision with root package name */
    public final b3.e f2351g;

    /* renamed from: h  reason: collision with root package name */
    public final HandlerThread f2352h;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f2353i;

    /* renamed from: j  reason: collision with root package name */
    public final t0 f2354j;

    /* renamed from: k  reason: collision with root package name */
    public final s0 f2355k;

    /* renamed from: l  reason: collision with root package name */
    public final long f2356l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f2357m;

    /* renamed from: n  reason: collision with root package name */
    public final l f2358n;

    /* renamed from: o  reason: collision with root package name */
    public final w f2359o;

    /* renamed from: p  reason: collision with root package name */
    public final ArrayList f2360p;
    public final g2.t q;

    /* renamed from: r  reason: collision with root package name */
    public final e0 f2361r;
    public o0 s;

    /* renamed from: t  reason: collision with root package name */
    public g0 f2362t;

    /* renamed from: u  reason: collision with root package name */
    public j1.p f2363u;

    /* renamed from: v  reason: collision with root package name */
    public h[] f2364v;
    public boolean w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f2365x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f2366y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f2367z;

    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object, j0.w] */
    public y(h[] hVarArr, b2.l lVar, a2.l lVar2, b0 b0Var, e2.d dVar, boolean z3, int i3, boolean z5, s sVar) {
        g2.t tVar = g2.t.f1957a;
        this.f2348a = hVarArr;
        this.c = lVar;
        this.d = lVar2;
        this.f2349e = b0Var;
        this.f2350f = dVar;
        this.f2365x = z3;
        this.A = i3;
        this.B = z5;
        this.f2353i = sVar;
        this.q = tVar;
        this.f2361r = new e0();
        k kVar = (k) b0Var;
        this.f2356l = kVar.f2262i;
        kVar.getClass();
        this.f2357m = false;
        this.s = o0.d;
        r0 r0Var = u0.f2344a;
        j1.n nVar = g0.f2235n;
        this.f2362t = new g0(r0Var, nVar, -9223372036854775807L, -9223372036854775807L, 1, null, false, TrackGroupArray.d, lVar2, nVar, -9223372036854775807L, 0L, -9223372036854775807L);
        this.f2359o = new Object();
        this.b = new h[hVarArr.length];
        for (int i5 = 0; i5 < hVarArr.length; i5++) {
            h hVar = hVarArr[i5];
            hVar.d = i5;
            this.b[i5] = hVar;
        }
        this.f2358n = new l(this);
        this.f2360p = new ArrayList();
        this.f2364v = new h[0];
        this.f2354j = new t0();
        this.f2355k = new s0();
        lVar.f164a = dVar;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f2352h = handlerThread;
        handlerThread.start();
        this.f2351g = new b3.e(6, new Handler(handlerThread.getLooper(), this));
        this.H = true;
    }

    public final long A(j1.n nVar, long j2, boolean z3) {
        K();
        this.f2366y = false;
        g0 g0Var = this.f2362t;
        if (g0Var.f2237e != 1 && !g0Var.f2236a.o()) {
            H(2);
        }
        e0 e0Var = this.f2361r;
        c0 c0Var = e0Var.f2228g;
        c0 c0Var2 = c0Var;
        while (true) {
            if (c0Var2 == null) {
                break;
            }
            if (nVar.equals(c0Var2.f2209f.f2219a) && c0Var2.d) {
                e0Var.h(c0Var2);
                break;
            }
            c0Var2 = e0Var.a();
        }
        if (z3 || c0Var != c0Var2 || (c0Var2 != null && c0Var2.f2217n + j2 < 0)) {
            for (h hVar : this.f2364v) {
                d(hVar);
            }
            this.f2364v = new h[0];
            if (c0Var2 != null) {
                c0Var2.f2217n = 0L;
            }
            c0Var = null;
        }
        if (c0Var2 != null) {
            O(c0Var);
            if (c0Var2.f2208e) {
                j1.m mVar = c0Var2.f2207a;
                j2 = mVar.w(j2);
                mVar.u(j2 - this.f2356l, this.f2357m);
            }
            v(j2);
            o();
        } else {
            e0Var.b(true);
            this.f2362t = this.f2362t.c(TrackGroupArray.d, this.d);
            v(j2);
        }
        i(false);
        this.f2351g.H(2);
        return j2;
    }

    public final void B(m0 m0Var) {
        Handler handler = m0Var.f2271e;
        if (!handler.getLooper().getThread().isAlive()) {
            Log.w("TAG", "Trying to send message on a dead thread.");
            m0Var.a(false);
            return;
        }
        handler.post(new d2.h(6, this, m0Var));
    }

    public final void C(boolean z3, AtomicBoolean atomicBoolean) {
        h[] hVarArr;
        if (this.C != z3) {
            this.C = z3;
            if (!z3) {
                for (h hVar : this.f2348a) {
                    if (hVar.f2247e == 0) {
                        hVar.s();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    public final void D(boolean z3) {
        this.f2366y = false;
        this.f2365x = z3;
        if (!z3) {
            K();
            N();
            return;
        }
        int i3 = this.f2362t.f2237e;
        b3.e eVar = this.f2351g;
        if (i3 == 3) {
            I();
            eVar.H(2);
        } else if (i3 == 2) {
            eVar.H(2);
        }
    }

    public final void E(h0 h0Var) {
        l lVar = this.f2358n;
        lVar.b(h0Var);
        ((Handler) this.f2351g.b).obtainMessage(17, 1, 0, lVar.a()).sendToTarget();
    }

    public final void F(int i3) {
        this.A = i3;
        e0 e0Var = this.f2361r;
        e0Var.f2226e = i3;
        if (!e0Var.k()) {
            y(true);
        }
        i(false);
    }

    public final void G(boolean z3) {
        this.B = z3;
        e0 e0Var = this.f2361r;
        e0Var.f2227f = z3;
        if (!e0Var.k()) {
            y(true);
        }
        i(false);
    }

    public final void H(int i3) {
        g0 g0Var = this.f2362t;
        if (g0Var.f2237e != i3) {
            this.f2362t = new g0(g0Var.f2236a, g0Var.b, g0Var.c, g0Var.d, i3, g0Var.f2238f, g0Var.f2239g, g0Var.f2240h, g0Var.f2241i, g0Var.f2242j, g0Var.f2243k, g0Var.f2244l, g0Var.f2245m);
        }
    }

    public final void I() {
        h[] hVarArr;
        boolean z3;
        this.f2366y = false;
        l lVar = this.f2358n;
        lVar.f2268f = true;
        lVar.f2266a.e();
        for (h hVar : this.f2364v) {
            if (hVar.f2247e == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            g2.b.h(z3);
            hVar.f2247e = 2;
            hVar.n();
        }
    }

    public final void J(boolean z3, boolean z5, boolean z6) {
        boolean z7;
        if (!z3 && this.C) {
            z7 = false;
        } else {
            z7 = true;
        }
        u(z7, true, z5, z5, z5);
        this.f2359o.b += this.D + (z6 ? 1 : 0);
        this.D = 0;
        ((k) this.f2349e).b(true);
        H(1);
    }

    public final void K() {
        h[] hVarArr;
        boolean z3;
        l lVar = this.f2358n;
        lVar.f2268f = false;
        g2.s sVar = lVar.f2266a;
        if (sVar.c) {
            sVar.d(sVar.c());
            sVar.c = false;
        }
        for (h hVar : this.f2364v) {
            int i3 = hVar.f2247e;
            if (i3 == 2) {
                if (i3 == 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                g2.b.h(z3);
                hVar.f2247e = 1;
                hVar.o();
            }
        }
    }

    public final void L() {
        boolean z3;
        c0 c0Var = this.f2361r.f2230i;
        if (!this.f2367z && (c0Var == null || !c0Var.f2207a.d())) {
            z3 = false;
        } else {
            z3 = true;
        }
        g0 g0Var = this.f2362t;
        if (z3 != g0Var.f2239g) {
            this.f2362t = new g0(g0Var.f2236a, g0Var.b, g0Var.c, g0Var.d, g0Var.f2237e, g0Var.f2238f, z3, g0Var.f2240h, g0Var.f2241i, g0Var.f2242j, g0Var.f2243k, g0Var.f2244l, g0Var.f2245m);
        }
    }

    public final void M(a2.l lVar) {
        h[] hVarArr;
        boolean z3;
        b2.o oVar = (b2.o) lVar.c;
        k kVar = (k) this.f2349e;
        kVar.getClass();
        int i3 = 0;
        while (true) {
            hVarArr = this.f2348a;
            if (i3 < hVarArr.length) {
                if (hVarArr[i3].f2246a == 2 && oVar.b[i3] != null) {
                    z3 = true;
                    break;
                }
                i3++;
            } else {
                z3 = false;
                break;
            }
        }
        kVar.f2265l = z3;
        int i5 = kVar.f2260g;
        if (i5 == -1) {
            i5 = 0;
            for (int i6 = 0; i6 < hVarArr.length; i6++) {
                if (oVar.b[i6] != null) {
                    int i7 = 131072;
                    switch (hVarArr[i6].f2246a) {
                        case 0:
                            i7 = 36438016;
                            break;
                        case 1:
                            i7 = 3538944;
                            break;
                        case 2:
                            i7 = 32768000;
                            break;
                        case 3:
                        case 4:
                        case 5:
                            break;
                        case 6:
                            i7 = 0;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    i5 += i7;
                }
            }
        }
        kVar.f2263j = i5;
        kVar.f2257a.b(i5);
    }

    public final void N() {
        long j2;
        boolean z3;
        c0 c0Var = this.f2361r.f2228g;
        if (c0Var == null) {
            return;
        }
        if (c0Var.d) {
            j2 = c0Var.f2207a.j();
        } else {
            j2 = -9223372036854775807L;
        }
        if (j2 != -9223372036854775807L) {
            v(j2);
            if (j2 != this.f2362t.f2245m) {
                g0 g0Var = this.f2362t;
                this.f2362t = b(g0Var.b, j2, g0Var.d);
                this.f2359o.a(4);
            }
        } else {
            l lVar = this.f2358n;
            if (c0Var != this.f2361r.f2229h) {
                z3 = true;
            } else {
                z3 = false;
            }
            h hVar = lVar.c;
            g2.s sVar = lVar.f2266a;
            if (hVar != null && !hVar.h() && (lVar.c.i() || (!z3 && !lVar.c.g()))) {
                long c = lVar.d.c();
                if (lVar.f2267e) {
                    if (c < sVar.c()) {
                        if (sVar.c) {
                            sVar.d(sVar.c());
                            sVar.c = false;
                        }
                    } else {
                        lVar.f2267e = false;
                        if (lVar.f2268f) {
                            sVar.e();
                        }
                    }
                }
                sVar.d(c);
                h0 a5 = lVar.d.a();
                if (!a5.equals((h0) sVar.f1956e)) {
                    sVar.b(a5);
                    ((Handler) lVar.b.f2351g.b).obtainMessage(17, 0, 0, a5).sendToTarget();
                }
            } else {
                lVar.f2267e = true;
                if (lVar.f2268f) {
                    sVar.e();
                }
            }
            long c5 = lVar.c();
            this.F = c5;
            long j5 = c5 - c0Var.f2217n;
            long j6 = this.f2362t.f2245m;
            if (!this.f2360p.isEmpty() && !this.f2362t.b.a()) {
                g0 g0Var2 = this.f2362t;
                if (g0Var2.c == j6) {
                    boolean z5 = this.H;
                }
                this.H = false;
                g0Var2.f2236a.b(g0Var2.b.f2454a);
                int i3 = this.G;
                if (i3 > 0) {
                    com.bumptech.glide.i.a(this.f2360p.get(i3 - 1));
                }
                if (this.G < this.f2360p.size()) {
                    com.bumptech.glide.i.a(this.f2360p.get(this.G));
                }
            }
            this.f2362t.f2245m = j5;
        }
        this.f2362t.f2243k = this.f2361r.f2230i.d();
        g0 g0Var3 = this.f2362t;
        long j7 = g0Var3.f2243k;
        c0 c0Var2 = this.f2361r.f2230i;
        long j8 = 0;
        if (c0Var2 != null) {
            j8 = Math.max(0L, j7 - (this.F - c0Var2.f2217n));
        }
        g0Var3.f2244l = j8;
    }

    public final void O(c0 c0Var) {
        boolean z3;
        c0 c0Var2 = this.f2361r.f2228g;
        if (c0Var2 != null && c0Var != c0Var2) {
            h[] hVarArr = this.f2348a;
            boolean[] zArr = new boolean[hVarArr.length];
            int i3 = 0;
            for (int i5 = 0; i5 < hVarArr.length; i5++) {
                h hVar = hVarArr[i5];
                if (hVar.f2247e != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zArr[i5] = z3;
                if (c0Var2.f2216m.d(i5)) {
                    i3++;
                }
                if (zArr[i5] && (!c0Var2.f2216m.d(i5) || (hVar.f2252j && hVar.f2248f == c0Var.c[i5]))) {
                    d(hVar);
                }
            }
            this.f2362t = this.f2362t.c(c0Var2.f2215l, c0Var2.f2216m);
            g(zArr, i3);
        }
    }

    @Override // j1.o
    public final void a(j1.p pVar, u0 u0Var) {
        ((Handler) this.f2351g.b).obtainMessage(8, new v(pVar, u0Var)).sendToTarget();
    }

    public final g0 b(j1.n nVar, long j2, long j5) {
        long max;
        this.H = true;
        g0 g0Var = this.f2362t;
        long j6 = g0Var.f2243k;
        c0 c0Var = this.f2361r.f2230i;
        if (c0Var == null) {
            max = 0;
        } else {
            max = Math.max(0L, j6 - (this.F - c0Var.f2217n));
        }
        return g0Var.a(nVar, j2, j5, max);
    }

    @Override // j1.l
    public final void c(j1.m mVar) {
        ((Handler) this.f2351g.b).obtainMessage(9, mVar).sendToTarget();
    }

    public final void d(h hVar) {
        boolean z3;
        l lVar = this.f2358n;
        boolean z5 = true;
        if (hVar == lVar.c) {
            lVar.d = null;
            lVar.c = null;
            lVar.f2267e = true;
        }
        int i3 = hVar.f2247e;
        if (i3 == 2) {
            if (i3 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            g2.b.h(z3);
            hVar.f2247e = 1;
            hVar.o();
        }
        if (hVar.f2247e != 1) {
            z5 = false;
        }
        g2.b.h(z5);
        hVar.b.b();
        hVar.f2247e = 0;
        hVar.f2248f = null;
        hVar.f2249g = null;
        hVar.f2252j = false;
        hVar.j();
    }

    @Override // j1.k0
    public final void e(j1.l0 l0Var) {
        ((Handler) this.f2351g.b).obtainMessage(10, (j1.m) l0Var).sendToTarget();
    }

    /* JADX WARN: Code restructure failed: missing block: B:281:0x040c, code lost:
        if (r0 >= r4.f2263j) goto L92;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            Method dump skipped, instructions count: 1193
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.y.f():void");
    }

    public final void g(boolean[] zArr, int i3) {
        h[] hVarArr;
        int i5;
        int i6;
        boolean z3;
        boolean z5;
        boolean z6;
        boolean z7;
        g2.j jVar;
        this.f2364v = new h[i3];
        e0 e0Var = this.f2361r;
        a2.l lVar = e0Var.f2228g.f2216m;
        int i7 = 0;
        while (true) {
            hVarArr = this.f2348a;
            if (i7 >= hVarArr.length) {
                break;
            }
            if (!lVar.d(i7)) {
                hVarArr[i7].s();
            }
            i7++;
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < hVarArr.length) {
            if (lVar.d(i8)) {
                boolean z8 = zArr[i8];
                int i10 = i9 + 1;
                c0 c0Var = e0Var.f2228g;
                h hVar = hVarArr[i8];
                this.f2364v[i9] = hVar;
                if (hVar.f2247e == 0) {
                    a2.l lVar2 = c0Var.f2216m;
                    n0 n0Var = ((n0[]) lVar2.b)[i8];
                    b2.n nVar = ((b2.o) lVar2.c).b[i8];
                    if (nVar != null) {
                        i6 = ((b2.d) nVar).c.length;
                    } else {
                        i6 = 0;
                    }
                    Format[] formatArr = new Format[i6];
                    for (int i11 = 0; i11 < i6; i11++) {
                        formatArr[i11] = ((b2.d) nVar).d[i11];
                    }
                    if (this.f2365x && this.f2362t.f2237e == 3) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z8 && z3) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    j1.j0 j0Var = c0Var.c[i8];
                    i5 = i8;
                    long j2 = this.F;
                    long j5 = c0Var.f2217n;
                    if (hVar.f2247e == 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    g2.b.h(z6);
                    hVar.c = n0Var;
                    hVar.f2247e = 1;
                    hVar.k(z5);
                    g2.b.h(!hVar.f2252j);
                    hVar.f2248f = j0Var;
                    hVar.f2251i = j5;
                    hVar.f2249g = formatArr;
                    hVar.f2250h = j5;
                    hVar.p(formatArr, j5);
                    hVar.l(j2, z5);
                    l lVar3 = this.f2358n;
                    lVar3.getClass();
                    g2.j e5 = hVar.e();
                    if (e5 != null && e5 != (jVar = lVar3.d)) {
                        if (jVar == null) {
                            lVar3.d = e5;
                            lVar3.c = hVar;
                            ((l0.w) e5).b((h0) lVar3.f2266a.f1956e);
                        } else {
                            throw new n(2, new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                    }
                    if (z3) {
                        if (hVar.f2247e == 1) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        g2.b.h(z7);
                        hVar.f2247e = 2;
                        hVar.n();
                    }
                } else {
                    i5 = i8;
                }
                i9 = i10;
            } else {
                i5 = i8;
            }
            i8 = i5 + 1;
        }
    }

    public final void h(j1.m mVar) {
        boolean z3;
        c0 c0Var = this.f2361r.f2230i;
        if (c0Var != null && c0Var.f2207a == mVar) {
            long j2 = this.F;
            if (c0Var != null) {
                if (c0Var.f2214k == null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                g2.b.h(z3);
                if (c0Var.d) {
                    c0Var.f2207a.A(j2 - c0Var.f2217n);
                }
            }
            o();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011a  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r11) {
        /*
            Method dump skipped, instructions count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.y.handleMessage(android.os.Message):boolean");
    }

    public final void i(boolean z3) {
        j1.n nVar;
        c0 c0Var;
        boolean z5;
        long d;
        y yVar = this;
        c0 c0Var2 = yVar.f2361r.f2230i;
        if (c0Var2 == null) {
            nVar = yVar.f2362t.b;
        } else {
            nVar = c0Var2.f2209f.f2219a;
        }
        j1.n nVar2 = nVar;
        boolean z6 = !yVar.f2362t.f2242j.equals(nVar2);
        if (z6) {
            g0 g0Var = yVar.f2362t;
            z5 = z6;
            c0Var = c0Var2;
            yVar = this;
            yVar.f2362t = new g0(g0Var.f2236a, g0Var.b, g0Var.c, g0Var.d, g0Var.f2237e, g0Var.f2238f, g0Var.f2239g, g0Var.f2240h, g0Var.f2241i, nVar2, g0Var.f2243k, g0Var.f2244l, g0Var.f2245m);
        } else {
            c0Var = c0Var2;
            z5 = z6;
        }
        g0 g0Var2 = yVar.f2362t;
        if (c0Var == null) {
            d = g0Var2.f2245m;
        } else {
            d = c0Var.d();
        }
        g0Var2.f2243k = d;
        g0 g0Var3 = yVar.f2362t;
        long j2 = g0Var3.f2243k;
        c0 c0Var3 = yVar.f2361r.f2230i;
        long j5 = 0;
        if (c0Var3 != null) {
            j5 = Math.max(0L, j2 - (yVar.F - c0Var3.f2217n));
        }
        g0Var3.f2244l = j5;
        if ((z5 || z3) && c0Var != null) {
            c0 c0Var4 = c0Var;
            if (c0Var4.d) {
                yVar.M(c0Var4.f2216m);
            }
        }
    }

    public final void j(j1.m mVar) {
        e0 e0Var = this.f2361r;
        c0 c0Var = e0Var.f2230i;
        if (c0Var != null && c0Var.f2207a == mVar) {
            float f4 = this.f2358n.a().f2255a;
            u0 u0Var = this.f2362t.f2236a;
            c0Var.d = true;
            c0Var.f2215l = c0Var.f2207a.o();
            long a5 = c0Var.a(c0Var.f(f4), c0Var.f2209f.b, false, new boolean[c0Var.f2211h.length]);
            long j2 = c0Var.f2217n;
            d0 d0Var = c0Var.f2209f;
            long j5 = d0Var.b;
            c0Var.f2217n = (j5 - a5) + j2;
            if (a5 != j5) {
                d0Var = new d0(d0Var.f2219a, a5, d0Var.c, d0Var.d, d0Var.f2220e, d0Var.f2221f, d0Var.f2222g);
            }
            c0Var.f2209f = d0Var;
            M(c0Var.f2216m);
            if (c0Var == e0Var.f2228g) {
                v(c0Var.f2209f.b);
                O(null);
            }
            o();
        }
    }

    public final void k(h0 h0Var, boolean z3) {
        h[] hVarArr;
        b2.n[] nVarArr;
        this.f2353i.obtainMessage(1, z3 ? 1 : 0, 0, h0Var).sendToTarget();
        float f4 = h0Var.f2255a;
        for (c0 c0Var = this.f2361r.f2228g; c0Var != null; c0Var = c0Var.f2214k) {
            for (b2.n nVar : (b2.n[]) ((b2.o) c0Var.f2216m.c).b.clone()) {
                if (nVar != null) {
                    nVar.e(f4);
                }
            }
        }
        for (h hVar : this.f2348a) {
            if (hVar != null) {
                hVar.t(h0Var.f2255a);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x0258, code lost:
        r0 = r0.h(r1);
        r4 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0272 A[LOOP:2: B:119:0x0272->B:149:0x0272, LOOP_START, PHI: r0 
      PHI: (r0v27 j0.c0) = (r0v21 j0.c0), (r0v28 j0.c0) binds: [B:118:0x0270, B:149:0x0272] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x029c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(j0.v r37) {
        /*
            Method dump skipped, instructions count: 695
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.y.l(j0.v):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m() {
        /*
            r6 = this;
            j0.e0 r0 = r6.f2361r
            j0.c0 r0 = r0.f2229h
            boolean r1 = r0.d
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            r1 = 0
        Lb:
            j0.h[] r3 = r6.f2348a
            int r4 = r3.length
            if (r1 >= r4) goto L27
            r3 = r3[r1]
            j1.j0[] r4 = r0.c
            r4 = r4[r1]
            j1.j0 r5 = r3.f2248f
            if (r5 != r4) goto L26
            if (r4 == 0) goto L23
            boolean r3 = r3.g()
            if (r3 != 0) goto L23
            goto L26
        L23:
            int r1 = r1 + 1
            goto Lb
        L26:
            return r2
        L27:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.y.m():boolean");
    }

    public final boolean n() {
        c0 c0Var = this.f2361r.f2228g;
        long j2 = c0Var.f2209f.f2220e;
        if (c0Var.d && (j2 == -9223372036854775807L || this.f2362t.f2245m < j2)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o() {
        /*
            Method dump skipped, instructions count: 192
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.y.o():void");
    }

    public final void p() {
        int i3;
        g0 g0Var = this.f2362t;
        w wVar = this.f2359o;
        if (g0Var != wVar.f2346a || wVar.b > 0 || wVar.c) {
            int i5 = wVar.b;
            if (wVar.c) {
                i3 = wVar.d;
            } else {
                i3 = -1;
            }
            this.f2353i.obtainMessage(0, i5, i3, g0Var).sendToTarget();
            wVar.f2346a = this.f2362t;
            wVar.b = 0;
            wVar.c = false;
        }
    }

    public final void q(j1.p pVar, boolean z3, boolean z5) {
        this.D++;
        u(false, true, z3, z5, true);
        ((k) this.f2349e).b(false);
        this.f2363u = pVar;
        H(2);
        e2.q qVar = (e2.q) this.f2350f;
        qVar.getClass();
        ((j1.a) pVar).j(this, qVar);
        this.f2351g.H(2);
    }

    public final synchronized void r() {
        if (!this.w && this.f2352h.isAlive()) {
            this.f2351g.H(7);
            boolean z3 = false;
            while (!this.w) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z3 = true;
                }
            }
            if (z3) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final void s() {
        u(true, true, true, true, false);
        ((k) this.f2349e).b(true);
        H(1);
        this.f2352h.quit();
        synchronized (this) {
            this.w = true;
            notifyAll();
        }
    }

    public final void t() {
        int i3;
        boolean[] zArr;
        boolean z3;
        float f4 = this.f2358n.a().f2255a;
        e0 e0Var = this.f2361r;
        c0 c0Var = e0Var.f2228g;
        c0 c0Var2 = e0Var.f2229h;
        boolean z5 = true;
        for (c0 c0Var3 = c0Var; c0Var3 != null && c0Var3.d; c0Var3 = c0Var3.f2214k) {
            u0 u0Var = this.f2362t.f2236a;
            a2.l f5 = c0Var3.f(f4);
            a2.l lVar = c0Var3.f2216m;
            if (lVar != null) {
                int i5 = ((b2.o) lVar.c).f166a;
                b2.o oVar = (b2.o) f5.c;
                if (i5 == oVar.f166a) {
                    for (int i6 = 0; i6 < oVar.f166a; i6++) {
                        if (f5.c(lVar, i6)) {
                        }
                    }
                    if (c0Var3 == c0Var2) {
                        z5 = false;
                    }
                }
            }
            if (z5) {
                e0 e0Var2 = this.f2361r;
                c0 c0Var4 = e0Var2.f2228g;
                boolean h5 = e0Var2.h(c0Var4);
                boolean[] zArr2 = new boolean[this.f2348a.length];
                long a5 = c0Var4.a(f5, this.f2362t.f2245m, h5, zArr2);
                g0 g0Var = this.f2362t;
                if (g0Var.f2237e != 4 && a5 != g0Var.f2245m) {
                    g0 g0Var2 = this.f2362t;
                    zArr = zArr2;
                    i3 = 4;
                    this.f2362t = b(g0Var2.b, a5, g0Var2.d);
                    this.f2359o.a(4);
                    v(a5);
                } else {
                    zArr = zArr2;
                    i3 = 4;
                }
                boolean[] zArr3 = new boolean[this.f2348a.length];
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    h[] hVarArr = this.f2348a;
                    if (i7 >= hVarArr.length) {
                        break;
                    }
                    h hVar = hVarArr[i7];
                    if (hVar.f2247e != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zArr3[i7] = z3;
                    j1.j0 j0Var = c0Var4.c[i7];
                    if (j0Var != null) {
                        i8++;
                    }
                    if (z3) {
                        if (j0Var != hVar.f2248f) {
                            d(hVar);
                        } else if (zArr[i7]) {
                            long j2 = this.F;
                            hVar.f2252j = false;
                            hVar.f2251i = j2;
                            hVar.l(j2, false);
                        }
                    }
                    i7++;
                }
                this.f2362t = this.f2362t.c(c0Var4.f2215l, c0Var4.f2216m);
                g(zArr3, i8);
            } else {
                i3 = 4;
                this.f2361r.h(c0Var3);
                if (c0Var3.d) {
                    c0Var3.a(f5, Math.max(c0Var3.f2209f.b, this.F - c0Var3.f2217n), false, new boolean[c0Var3.f2211h.length]);
                }
            }
            i(true);
            if (this.f2362t.f2237e != i3) {
                o();
                N();
                this.f2351g.H(2);
                return;
            }
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(boolean r25, boolean r26, boolean r27, boolean r28, boolean r29) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.y.u(boolean, boolean, boolean, boolean, boolean):void");
    }

    public final void v(long j2) {
        e0 e0Var;
        h[] hVarArr;
        b2.n[] nVarArr;
        c0 c0Var = this.f2361r.f2228g;
        if (c0Var != null) {
            j2 += c0Var.f2217n;
        }
        this.F = j2;
        this.f2358n.f2266a.d(j2);
        for (h hVar : this.f2364v) {
            long j5 = this.F;
            hVar.f2252j = false;
            hVar.f2251i = j5;
            hVar.l(j5, false);
        }
        for (c0 c0Var2 = e0Var.f2228g; c0Var2 != null; c0Var2 = c0Var2.f2214k) {
            for (b2.n nVar : (b2.n[]) ((b2.o) c0Var2.f2216m.c).b.clone()) {
            }
        }
    }

    public final Pair w(x xVar, boolean z3) {
        Pair i3;
        Object x3;
        u0 u0Var = this.f2362t.f2236a;
        u0 u0Var2 = xVar.f2347a;
        if (u0Var.o()) {
            return null;
        }
        if (u0Var2.o()) {
            u0Var2 = u0Var;
        }
        try {
            i3 = u0Var2.i(this.f2354j, this.f2355k, xVar.b, xVar.c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (u0Var == u0Var2) {
            return i3;
        }
        if (u0Var.b(i3.first) != -1) {
            return i3;
        }
        if (z3 && (x3 = x(i3.first, u0Var2, u0Var)) != null) {
            return u0Var.i(this.f2354j, this.f2355k, u0Var.g(x3, this.f2355k).c, -9223372036854775807L);
        }
        return null;
    }

    public final Object x(Object obj, u0 u0Var, u0 u0Var2) {
        int b = u0Var.b(obj);
        int h5 = u0Var.h();
        int i3 = b;
        int i5 = -1;
        for (int i6 = 0; i6 < h5 && i5 == -1; i6++) {
            i3 = u0Var.d(i3, this.f2355k, this.f2354j, this.A, this.B);
            if (i3 == -1) {
                break;
            }
            i5 = u0Var2.b(u0Var.l(i3));
        }
        if (i5 == -1) {
            return null;
        }
        return u0Var2.l(i5);
    }

    public final void y(boolean z3) {
        j1.n nVar = this.f2361r.f2228g.f2209f.f2219a;
        long A = A(nVar, this.f2362t.f2245m, true);
        if (A != this.f2362t.f2245m) {
            this.f2362t = b(nVar, A, this.f2362t.d);
            if (z3) {
                this.f2359o.a(4);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(j0.x r17) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.y.z(j0.x):void");
    }
}
