package j1;

import android.net.Uri;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e0 extends a {

    /* renamed from: f  reason: collision with root package name */
    public final Uri f2399f;

    /* renamed from: g  reason: collision with root package name */
    public final e2.h f2400g;

    /* renamed from: h  reason: collision with root package name */
    public final p0.l f2401h;

    /* renamed from: i  reason: collision with root package name */
    public final n0.b f2402i;

    /* renamed from: j  reason: collision with root package name */
    public final j3.a f2403j;

    /* renamed from: k  reason: collision with root package name */
    public final int f2404k;

    /* renamed from: l  reason: collision with root package name */
    public final Object f2405l;

    /* renamed from: m  reason: collision with root package name */
    public long f2406m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f2407n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f2408o;

    /* renamed from: p  reason: collision with root package name */
    public e2.m0 f2409p;

    public e0(Uri uri, e2.h hVar, p0.h hVar2, j3.a aVar) {
        n0.b bVar = n0.b.f2912a;
        this.f2399f = uri;
        this.f2400g = hVar;
        this.f2401h = hVar2;
        this.f2402i = bVar;
        this.f2403j = aVar;
        this.f2404k = 1048576;
        this.f2406m = -9223372036854775807L;
        this.f2405l = null;
    }

    @Override // j1.p
    public final m a(n nVar, e2.m mVar, long j2) {
        e2.i createDataSource = this.f2400g.createDataSource();
        e2.m0 m0Var = this.f2409p;
        if (m0Var != null) {
            createDataSource.addTransferListener(m0Var);
        }
        p0.j[] a5 = this.f2401h.a();
        u d = d(nVar);
        j3.a aVar = this.f2403j;
        return new d0(this.f2399f, createDataSource, a5, this.f2402i, aVar, d, this, mVar, this.f2404k);
    }

    @Override // j1.p
    public final void c(m mVar) {
        i0[] i0VarArr;
        d0 d0Var = (d0) mVar;
        if (d0Var.f2394v) {
            for (i0 i0Var : d0Var.s) {
                i0Var.j();
                if (i0Var.f2420f != null) {
                    i0Var.f2420f = null;
                    i0Var.f2419e = null;
                }
            }
        }
        d0Var.f2384j.d(d0Var);
        d0Var.f2389o.removeCallbacksAndMessages(null);
        d0Var.f2390p = null;
        d0Var.L = true;
        d0Var.f2379e.o();
    }

    @Override // j1.a
    public final void m(e2.m0 m0Var) {
        this.f2409p = m0Var;
        this.f2402i.getClass();
        long j2 = this.f2406m;
        boolean z3 = this.f2407n;
        boolean z5 = this.f2408o;
        this.f2406m = j2;
        this.f2407n = z3;
        this.f2408o = z5;
        n(new m0(j2, j2, 0L, 0L, z3, false, z5, null, this.f2405l));
    }

    @Override // j1.a
    public final void p() {
        this.f2402i.getClass();
    }

    public final void r(long j2, boolean z3, boolean z5) {
        long j5;
        if (j2 == -9223372036854775807L) {
            j5 = this.f2406m;
        } else {
            j5 = j2;
        }
        if (this.f2406m == j5 && this.f2407n == z3 && this.f2408o == z5) {
            return;
        }
        this.f2406m = j5;
        this.f2407n = z3;
        this.f2408o = z5;
        n(new m0(j5, j5, 0L, 0L, z3, false, z5, null, this.f2405l));
    }

    @Override // j1.p
    public final void b() {
    }
}
