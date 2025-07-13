package j0;

import com.google.android.exoplayer2.source.TrackGroupArray;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g0 {

    /* renamed from: n  reason: collision with root package name */
    public static final j1.n f2235n = new j1.n(-1, new Object());

    /* renamed from: a  reason: collision with root package name */
    public final u0 f2236a;
    public final j1.n b;
    public final long c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2237e;

    /* renamed from: f  reason: collision with root package name */
    public final n f2238f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f2239g;

    /* renamed from: h  reason: collision with root package name */
    public final TrackGroupArray f2240h;

    /* renamed from: i  reason: collision with root package name */
    public final a2.l f2241i;

    /* renamed from: j  reason: collision with root package name */
    public final j1.n f2242j;

    /* renamed from: k  reason: collision with root package name */
    public volatile long f2243k;

    /* renamed from: l  reason: collision with root package name */
    public volatile long f2244l;

    /* renamed from: m  reason: collision with root package name */
    public volatile long f2245m;

    public g0(u0 u0Var, j1.n nVar, long j2, long j5, int i3, n nVar2, boolean z3, TrackGroupArray trackGroupArray, a2.l lVar, j1.n nVar3, long j6, long j7, long j8) {
        this.f2236a = u0Var;
        this.b = nVar;
        this.c = j2;
        this.d = j5;
        this.f2237e = i3;
        this.f2238f = nVar2;
        this.f2239g = z3;
        this.f2240h = trackGroupArray;
        this.f2241i = lVar;
        this.f2242j = nVar3;
        this.f2243k = j6;
        this.f2244l = j7;
        this.f2245m = j8;
    }

    public final g0 a(j1.n nVar, long j2, long j5, long j6) {
        long j7;
        u0 u0Var = this.f2236a;
        if (nVar.a()) {
            j7 = j5;
        } else {
            j7 = -9223372036854775807L;
        }
        return new g0(u0Var, nVar, j2, j7, this.f2237e, this.f2238f, this.f2239g, this.f2240h, this.f2241i, this.f2242j, this.f2243k, j6, j2);
    }

    public final g0 b(n nVar) {
        return new g0(this.f2236a, this.b, this.c, this.d, this.f2237e, nVar, this.f2239g, this.f2240h, this.f2241i, this.f2242j, this.f2243k, this.f2244l, this.f2245m);
    }

    public final g0 c(TrackGroupArray trackGroupArray, a2.l lVar) {
        return new g0(this.f2236a, this.b, this.c, this.d, this.f2237e, this.f2238f, this.f2239g, trackGroupArray, lVar, this.f2242j, this.f2243k, this.f2244l, this.f2245m);
    }

    public final j1.n d(boolean z3, t0 t0Var, s0 s0Var) {
        long j2;
        u0 u0Var = this.f2236a;
        if (u0Var.o()) {
            return f2235n;
        }
        int a5 = u0Var.a(z3);
        int i3 = u0Var.m(a5, t0Var, 0L).f2322f;
        j1.n nVar = this.b;
        int b = u0Var.b(nVar.f2454a);
        if (b != -1 && a5 == u0Var.f(b, s0Var, false).c) {
            j2 = nVar.d;
        } else {
            j2 = -1;
        }
        return new j1.n(j2, u0Var.l(i3));
    }
}
