package m1;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import e2.f0;
import e2.g0;
import e2.h0;
import e2.i0;
import e2.m0;
import j0.z;
import j1.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h extends j1.a {
    public e2.b A;
    public Handler B;
    public final Uri C;
    public Uri D;
    public n1.b E;
    public boolean F;
    public long G;
    public long H;
    public long I;
    public int J;
    public long K;
    public int L;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f2792f;

    /* renamed from: g  reason: collision with root package name */
    public final e2.h f2793g;

    /* renamed from: h  reason: collision with root package name */
    public final k f2794h;

    /* renamed from: i  reason: collision with root package name */
    public final j3.a f2795i;

    /* renamed from: j  reason: collision with root package name */
    public final n0.b f2796j;

    /* renamed from: k  reason: collision with root package name */
    public final j3.a f2797k;

    /* renamed from: l  reason: collision with root package name */
    public final long f2798l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f2799m;

    /* renamed from: n  reason: collision with root package name */
    public final u f2800n;

    /* renamed from: o  reason: collision with root package name */
    public final h0 f2801o;

    /* renamed from: p  reason: collision with root package name */
    public final e f2802p;
    public final Object q;

    /* renamed from: r  reason: collision with root package name */
    public final SparseArray f2803r;
    public final c s;

    /* renamed from: t  reason: collision with root package name */
    public final c f2804t;

    /* renamed from: u  reason: collision with root package name */
    public final e f2805u;

    /* renamed from: v  reason: collision with root package name */
    public final g0 f2806v;
    public final Object w;

    /* renamed from: x  reason: collision with root package name */
    public e2.i f2807x;

    /* renamed from: y  reason: collision with root package name */
    public f0 f2808y;

    /* renamed from: z  reason: collision with root package name */
    public m0 f2809z;

    static {
        z.a("goog.exo.dash");
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [m1.c] */
    /* JADX WARN: Type inference failed for: r3v9, types: [m1.c] */
    public h(Uri uri, e2.h hVar, n1.d dVar, k kVar, j3.a aVar, j3.a aVar2, long j2) {
        n0.b bVar = n0.b.f2912a;
        this.C = uri;
        this.E = null;
        this.D = uri;
        this.f2793g = hVar;
        this.f2801o = dVar;
        this.f2794h = kVar;
        this.f2796j = bVar;
        this.f2797k = aVar2;
        this.f2798l = j2;
        this.f2799m = false;
        this.f2795i = aVar;
        this.w = null;
        this.f2792f = false;
        this.f2800n = d(null);
        this.q = new Object();
        this.f2803r = new SparseArray();
        this.f2805u = new e(this, 0);
        this.K = -9223372036854775807L;
        this.f2802p = new e(this, 1);
        this.f2806v = new e(this, 2);
        this.s = new Runnable(this) { // from class: m1.c
            public final /* synthetic */ h b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (r2) {
                    case 0:
                        this.b.s();
                        return;
                    default:
                        this.b.r(false);
                        return;
                }
            }
        };
        this.f2804t = new Runnable(this) { // from class: m1.c
            public final /* synthetic */ h b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (r2) {
                    case 0:
                        this.b.s();
                        return;
                    default:
                        this.b.r(false);
                        return;
                }
            }
        };
    }

    @Override // j1.p
    public final j1.m a(j1.n nVar, e2.m mVar, long j2) {
        int intValue = ((Integer) nVar.f2454a).intValue() - this.L;
        u uVar = new u(this.c.c, 0, nVar, this.E.a(intValue).b);
        int i3 = this.L + intValue;
        n1.b bVar = this.E;
        m0 m0Var = this.f2809z;
        long j5 = this.I;
        g0 g0Var = this.f2806v;
        b bVar2 = new b(i3, bVar, intValue, this.f2794h, m0Var, this.f2796j, this.f2797k, uVar, j5, g0Var, mVar, this.f2795i, this.f2805u);
        this.f2803r.put(i3, bVar2);
        return bVar2;
    }

    @Override // j1.p
    public final void b() {
        this.f2806v.a();
    }

    @Override // j1.p
    public final void c(j1.m mVar) {
        b bVar = (b) mVar;
        r rVar = bVar.f2776l;
        rVar.f2837j = true;
        rVar.d.removeCallbacksAndMessages(null);
        for (l1.g gVar : bVar.f2780p) {
            gVar.x(bVar);
        }
        bVar.f2779o = null;
        bVar.f2778n.o();
        this.f2803r.remove(bVar.f2768a);
    }

    @Override // j1.a
    public final void m(m0 m0Var) {
        this.f2809z = m0Var;
        this.f2796j.getClass();
        if (this.f2792f) {
            r(false);
            return;
        }
        this.f2807x = this.f2793g.createDataSource();
        this.f2808y = new f0("Loader:DashMediaSource");
        this.B = new Handler();
        s();
    }

    @Override // j1.a
    public final void p() {
        n1.b bVar;
        this.F = false;
        this.f2807x = null;
        f0 f0Var = this.f2808y;
        if (f0Var != null) {
            f0Var.d(null);
            this.f2808y = null;
        }
        this.G = 0L;
        this.H = 0L;
        if (this.f2792f) {
            bVar = this.E;
        } else {
            bVar = null;
        }
        this.E = bVar;
        this.D = this.C;
        this.A = null;
        Handler handler = this.B;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.B = null;
        }
        this.I = 0L;
        this.J = 0;
        this.K = -9223372036854775807L;
        this.L = 0;
        this.f2803r.clear();
        this.f2796j.getClass();
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x01bb, code lost:
        if (r2 != (-9223372036854775807L)) goto L88;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(boolean r31) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.h.r(boolean):void");
    }

    public final void s() {
        Uri uri;
        this.B.removeCallbacks(this.s);
        if (this.f2808y.b()) {
            return;
        }
        if (this.f2808y.c()) {
            this.F = true;
            return;
        }
        synchronized (this.q) {
            uri = this.D;
        }
        this.F = false;
        i0 i0Var = new i0(this.f2807x, uri, 4, this.f2801o);
        e eVar = this.f2802p;
        this.f2797k.getClass();
        this.f2808y.e(i0Var, eVar, 3);
        this.f2800n.l(i0Var.f1688a, i0Var.b, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
}
