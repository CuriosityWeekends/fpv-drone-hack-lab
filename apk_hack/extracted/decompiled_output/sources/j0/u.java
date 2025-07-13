package j0;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.source.TrackGroupArray;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class u extends j.a {
    public final a2.l b;
    public final h[] c;
    public final b2.l d;

    /* renamed from: e  reason: collision with root package name */
    public final s f2327e;

    /* renamed from: f  reason: collision with root package name */
    public final y f2328f;

    /* renamed from: g  reason: collision with root package name */
    public final Handler f2329g;

    /* renamed from: h  reason: collision with root package name */
    public final CopyOnWriteArrayList f2330h;

    /* renamed from: i  reason: collision with root package name */
    public final s0 f2331i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayDeque f2332j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2333k;

    /* renamed from: l  reason: collision with root package name */
    public int f2334l;

    /* renamed from: m  reason: collision with root package name */
    public int f2335m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2336n;

    /* renamed from: o  reason: collision with root package name */
    public int f2337o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2338p;
    public boolean q;

    /* renamed from: r  reason: collision with root package name */
    public int f2339r;
    public h0 s;

    /* renamed from: t  reason: collision with root package name */
    public o0 f2340t;

    /* renamed from: u  reason: collision with root package name */
    public g0 f2341u;

    /* renamed from: v  reason: collision with root package name */
    public int f2342v;
    public int w;

    /* renamed from: x  reason: collision with root package name */
    public long f2343x;

    public u(h[] hVarArr, b2.l lVar, b0 b0Var, e2.d dVar, Looper looper) {
        super(1);
        boolean z3;
        Log.i("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.11.3] [" + g2.w.f1961e + "]");
        if (hVarArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.h(z3);
        this.c = hVarArr;
        lVar.getClass();
        this.d = lVar;
        this.f2333k = false;
        this.f2335m = 0;
        this.f2336n = false;
        this.f2330h = new CopyOnWriteArrayList();
        a2.l lVar2 = new a2.l(new n0[hVarArr.length], new b2.n[hVarArr.length], null);
        this.b = lVar2;
        this.f2331i = new s0();
        this.s = h0.f2254e;
        this.f2340t = o0.d;
        this.f2334l = 0;
        s sVar = new s(this, looper, 0);
        this.f2327e = sVar;
        r0 r0Var = u0.f2344a;
        j1.n nVar = g0.f2235n;
        this.f2341u = new g0(r0Var, nVar, 0L, -9223372036854775807L, 1, null, false, TrackGroupArray.d, lVar2, nVar, 0L, 0L, 0L);
        this.f2332j = new ArrayDeque();
        y yVar = new y(hVarArr, lVar, lVar2, b0Var, dVar, this.f2333k, this.f2335m, this.f2336n, sVar);
        this.f2328f = yVar;
        this.f2329g = new Handler(yVar.f2352h.getLooper());
    }

    public final m0 D(h hVar) {
        return new m0(this.f2328f, hVar, this.f2341u.f2236a, w(), this.f2329g);
    }

    public final g0 E(boolean z3, boolean z5, boolean z6, int i3) {
        int b;
        j1.n nVar;
        long j2;
        u0 u0Var;
        n nVar2;
        TrackGroupArray trackGroupArray;
        a2.l lVar;
        long j5 = 0;
        boolean z7 = false;
        if (z3) {
            this.f2342v = 0;
            this.w = 0;
            this.f2343x = 0L;
        } else {
            this.f2342v = w();
            if (I()) {
                b = this.w;
            } else {
                g0 g0Var = this.f2341u;
                b = g0Var.f2236a.b(g0Var.b.f2454a);
            }
            this.w = b;
            this.f2343x = getCurrentPosition();
        }
        z7 = (z3 || z5) ? true : true;
        if (z7) {
            nVar = this.f2341u.d(this.f2336n, (t0) this.f2183a, this.f2331i);
        } else {
            nVar = this.f2341u.b;
        }
        j1.n nVar3 = nVar;
        if (!z7) {
            j5 = this.f2341u.f2245m;
        }
        long j6 = j5;
        if (z7) {
            j2 = -9223372036854775807L;
        } else {
            j2 = this.f2341u.d;
        }
        long j7 = j2;
        if (z5) {
            u0Var = u0.f2344a;
        } else {
            u0Var = this.f2341u.f2236a;
        }
        u0 u0Var2 = u0Var;
        if (z6) {
            nVar2 = null;
        } else {
            nVar2 = this.f2341u.f2238f;
        }
        n nVar4 = nVar2;
        if (z5) {
            trackGroupArray = TrackGroupArray.d;
        } else {
            trackGroupArray = this.f2341u.f2240h;
        }
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        if (z5) {
            lVar = this.b;
        } else {
            lVar = this.f2341u.f2241i;
        }
        return new g0(u0Var2, nVar3, j6, j7, i3, nVar4, false, trackGroupArray2, lVar, nVar3, j6, 0L, j6);
    }

    public final void F(g gVar) {
        G(new d2.h(5, new CopyOnWriteArrayList(this.f2330h), gVar));
    }

    public final void G(Runnable runnable) {
        ArrayDeque arrayDeque = this.f2332j;
        boolean z3 = !arrayDeque.isEmpty();
        arrayDeque.addLast(runnable);
        if (z3) {
            return;
        }
        while (!arrayDeque.isEmpty()) {
            ((Runnable) arrayDeque.peekFirst()).run();
            arrayDeque.removeFirst();
        }
    }

    public final void H(final int i3, final boolean z3) {
        int i5;
        int i6;
        final boolean z5;
        final boolean z6;
        final boolean z7;
        boolean B = B();
        if (this.f2333k && this.f2334l == 0) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (z3 && i3 == 0) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        if (i5 != i6) {
            ((Handler) this.f2328f.f2351g.b).obtainMessage(1, i6, 0).sendToTarget();
        }
        if (this.f2333k != z3) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.f2334l != i3) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.f2333k = z3;
        this.f2334l = i3;
        final boolean B2 = B();
        if (B != B2) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z5 || z6 || z7) {
            final int i7 = this.f2341u.f2237e;
            F(new g() { // from class: j0.p
                @Override // j0.g
                public final void a(j0 j0Var) {
                    if (z5) {
                        j0Var.onPlayerStateChanged(z3, i7);
                    }
                    if (z6) {
                        j0Var.onPlaybackSuppressionReasonChanged(i3);
                    }
                    if (z7) {
                        j0Var.onIsPlayingChanged(B2);
                    }
                }
            });
        }
    }

    public final boolean I() {
        if (!this.f2341u.f2236a.o() && this.f2337o <= 0) {
            return false;
        }
        return true;
    }

    public final void J(g0 g0Var, boolean z3, int i3, int i5, boolean z5) {
        boolean z6;
        boolean B = B();
        g0 g0Var2 = this.f2341u;
        this.f2341u = g0Var;
        boolean B2 = B();
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2330h;
        boolean z7 = this.f2333k;
        if (B != B2) {
            z6 = true;
        } else {
            z6 = false;
        }
        G(new t(g0Var, g0Var2, copyOnWriteArrayList, this.d, z3, i3, i5, z5, z7, z6));
    }

    @Override // j0.l0
    public final h0 a() {
        return this.s;
    }

    @Override // j0.l0
    public final void b(j0 j0Var) {
        this.f2330h.addIfAbsent(new f(j0Var));
    }

    @Override // j0.l0
    public final void c(boolean z3) {
        H(0, z3);
    }

    @Override // j0.l0
    public final k0 d() {
        return null;
    }

    @Override // j0.l0
    public final boolean e() {
        if (!I() && this.f2341u.b.a()) {
            return true;
        }
        return false;
    }

    @Override // j0.l0
    public final long f() {
        if (e()) {
            g0 g0Var = this.f2341u;
            u0 u0Var = g0Var.f2236a;
            Object obj = g0Var.b.f2454a;
            s0 s0Var = this.f2331i;
            u0Var.g(obj, s0Var);
            g0 g0Var2 = this.f2341u;
            if (g0Var2.d == -9223372036854775807L) {
                return i.b(g0Var2.f2236a.m(w(), (t0) this.f2183a, 0L).f2324h);
            }
            return i.b(s0Var.f2306e) + i.b(this.f2341u.d);
        }
        return getCurrentPosition();
    }

    @Override // j0.l0
    public final long g() {
        return i.b(this.f2341u.f2244l);
    }

    @Override // j0.l0
    public final long getCurrentPosition() {
        if (I()) {
            return this.f2343x;
        }
        if (this.f2341u.b.a()) {
            return i.b(this.f2341u.f2245m);
        }
        g0 g0Var = this.f2341u;
        j1.n nVar = g0Var.b;
        long b = i.b(g0Var.f2245m);
        u0 u0Var = this.f2341u.f2236a;
        Object obj = nVar.f2454a;
        s0 s0Var = this.f2331i;
        u0Var.g(obj, s0Var);
        return i.b(s0Var.f2306e) + b;
    }

    @Override // j0.l0
    public final long getDuration() {
        if (e()) {
            g0 g0Var = this.f2341u;
            j1.n nVar = g0Var.b;
            Object obj = nVar.f2454a;
            u0 u0Var = g0Var.f2236a;
            s0 s0Var = this.f2331i;
            u0Var.g(obj, s0Var);
            s0Var.f2307f.c[nVar.b].getClass();
            return i.b(-9223372036854775807L);
        }
        u0 u0Var2 = this.f2341u.f2236a;
        if (u0Var2.o()) {
            return -9223372036854775807L;
        }
        return i.b(u0Var2.m(w(), (t0) this.f2183a, 0L).f2325i);
    }

    @Override // j0.l0
    public final int getPlaybackState() {
        return this.f2341u.f2237e;
    }

    @Override // j0.l0
    public final int getRepeatMode() {
        return this.f2335m;
    }

    @Override // j0.l0
    public final void h(int i3, long j2) {
        long a5;
        u0 u0Var = this.f2341u.f2236a;
        if (i3 >= 0 && (u0Var.o() || i3 < u0Var.n())) {
            this.q = true;
            this.f2337o++;
            if (e()) {
                Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                this.f2327e.obtainMessage(0, 1, -1, this.f2341u).sendToTarget();
                return;
            }
            this.f2342v = i3;
            long j5 = 0;
            if (u0Var.o()) {
                if (j2 != -9223372036854775807L) {
                    j5 = j2;
                }
                this.f2343x = j5;
                this.w = 0;
            } else {
                if (j2 == -9223372036854775807L) {
                    a5 = u0Var.m(i3, (t0) this.f2183a, 0L).f2324h;
                } else {
                    a5 = i.a(j2);
                }
                long j6 = a5;
                Pair i5 = u0Var.i((t0) this.f2183a, this.f2331i, i3, j6);
                this.f2343x = i.b(j6);
                this.w = u0Var.b(i5.first);
            }
            long a6 = i.a(j2);
            y yVar = this.f2328f;
            yVar.getClass();
            ((Handler) yVar.f2351g.b).obtainMessage(3, new x(u0Var, i3, a6)).sendToTarget();
            F(new a1.f(3));
            return;
        }
        throw new IllegalStateException();
    }

    @Override // j0.l0
    public final long i() {
        if (e()) {
            g0 g0Var = this.f2341u;
            if (g0Var.f2242j.equals(g0Var.b)) {
                return i.b(this.f2341u.f2243k);
            }
            return getDuration();
        }
        return v();
    }

    @Override // j0.l0
    public final boolean j() {
        return this.f2333k;
    }

    @Override // j0.l0
    public final void k(final boolean z3) {
        if (this.f2336n != z3) {
            this.f2336n = z3;
            ((Handler) this.f2328f.f2351g.b).obtainMessage(13, z3 ? 1 : 0, 0).sendToTarget();
            F(new g() { // from class: j0.r
                @Override // j0.g
                public final void a(j0 j0Var) {
                    j0Var.onShuffleModeEnabledChanged(z3);
                }
            });
        }
    }

    @Override // j0.l0
    public final n l() {
        return this.f2341u.f2238f;
    }

    @Override // j0.l0
    public final int m() {
        if (e()) {
            return this.f2341u.b.b;
        }
        return -1;
    }

    @Override // j0.l0
    public final int o() {
        if (e()) {
            return this.f2341u.b.c;
        }
        return -1;
    }

    @Override // j0.l0
    public final int p() {
        return this.f2334l;
    }

    @Override // j0.l0
    public final TrackGroupArray q() {
        return this.f2341u.f2240h;
    }

    @Override // j0.l0
    public final u0 r() {
        return this.f2341u.f2236a;
    }

    @Override // j0.l0
    public final Looper s() {
        return this.f2327e.getLooper();
    }

    @Override // j0.l0
    public final void setRepeatMode(final int i3) {
        if (this.f2335m != i3) {
            this.f2335m = i3;
            ((Handler) this.f2328f.f2351g.b).obtainMessage(12, i3, 0).sendToTarget();
            F(new g() { // from class: j0.q
                @Override // j0.g
                public final void a(j0 j0Var) {
                    j0Var.onRepeatModeChanged(i3);
                }
            });
        }
    }

    @Override // j0.l0
    public final boolean t() {
        return this.f2336n;
    }

    @Override // j0.l0
    public final void u(j0 j0Var) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2330h;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.f2234a.equals(j0Var)) {
                fVar.b = true;
                copyOnWriteArrayList.remove(fVar);
            }
        }
    }

    @Override // j0.l0
    public final long v() {
        if (I()) {
            return this.f2343x;
        }
        g0 g0Var = this.f2341u;
        if (g0Var.f2242j.d != g0Var.b.d) {
            return i.b(g0Var.f2236a.m(w(), (t0) this.f2183a, 0L).f2325i);
        }
        long j2 = g0Var.f2243k;
        if (this.f2341u.f2242j.a()) {
            g0 g0Var2 = this.f2341u;
            s0 g5 = g0Var2.f2236a.g(g0Var2.f2242j.f2454a, this.f2331i);
            long j5 = g5.f2307f.b[this.f2341u.f2242j.b];
            if (j5 == Long.MIN_VALUE) {
                j2 = g5.d;
            } else {
                j2 = j5;
            }
        }
        j1.n nVar = this.f2341u.f2242j;
        long b = i.b(j2);
        u0 u0Var = this.f2341u.f2236a;
        Object obj = nVar.f2454a;
        s0 s0Var = this.f2331i;
        u0Var.g(obj, s0Var);
        return i.b(s0Var.f2306e) + b;
    }

    @Override // j0.l0
    public final int w() {
        if (I()) {
            return this.f2342v;
        }
        g0 g0Var = this.f2341u;
        return g0Var.f2236a.g(g0Var.b.f2454a, this.f2331i).c;
    }

    @Override // j0.l0
    public final b2.o x() {
        return (b2.o) this.f2341u.f2241i.c;
    }

    @Override // j0.l0
    public final int y(int i3) {
        return this.c[i3].f2246a;
    }

    @Override // j0.l0
    public final q0 z() {
        return null;
    }
}
