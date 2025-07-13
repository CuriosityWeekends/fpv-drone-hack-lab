package q1;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import b3.e;
import e2.a0;
import e2.c0;
import e2.f0;
import e2.g0;
import e2.h;
import e2.h0;
import e2.i;
import e2.i0;
import e2.k0;
import e2.l;
import e2.m0;
import e2.z;
import g2.w;
import j1.m;
import j1.n;
import j1.u;
import java.io.IOException;
import java.util.ArrayList;
import l1.g;
import m1.k;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends j1.a implements z {

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3340f;

    /* renamed from: g  reason: collision with root package name */
    public final Uri f3341g;

    /* renamed from: h  reason: collision with root package name */
    public final h f3342h;

    /* renamed from: i  reason: collision with root package name */
    public final k f3343i;

    /* renamed from: j  reason: collision with root package name */
    public final j3.a f3344j;

    /* renamed from: k  reason: collision with root package name */
    public final n0.b f3345k;

    /* renamed from: l  reason: collision with root package name */
    public final j3.a f3346l;

    /* renamed from: m  reason: collision with root package name */
    public final long f3347m;

    /* renamed from: n  reason: collision with root package name */
    public final u f3348n;

    /* renamed from: o  reason: collision with root package name */
    public final h0 f3349o;

    /* renamed from: p  reason: collision with root package name */
    public final ArrayList f3350p;
    public final Object q;

    /* renamed from: r  reason: collision with root package name */
    public i f3351r;
    public f0 s;

    /* renamed from: t  reason: collision with root package name */
    public g0 f3352t;

    /* renamed from: u  reason: collision with root package name */
    public m0 f3353u;

    /* renamed from: v  reason: collision with root package name */
    public long f3354v;
    public r1.c w;

    /* renamed from: x  reason: collision with root package name */
    public Handler f3355x;

    static {
        j0.z.a("goog.exo.smoothstreaming");
    }

    public c(Uri uri, h hVar, e eVar, k kVar, j3.a aVar, j3.a aVar2, long j2) {
        n0.b bVar = n0.b.f2912a;
        this.w = null;
        String lastPathSegment = uri.getLastPathSegment();
        this.f3341g = (lastPathSegment == null || !w.E(lastPathSegment).matches("manifest(\\(.+\\))?")) ? Uri.withAppendedPath(uri, "Manifest") : uri;
        this.f3342h = hVar;
        this.f3349o = eVar;
        this.f3343i = kVar;
        this.f3344j = aVar;
        this.f3345k = bVar;
        this.f3346l = aVar2;
        this.f3347m = j2;
        this.f3348n = d(null);
        this.q = null;
        this.f3340f = false;
        this.f3350p = new ArrayList();
    }

    @Override // j1.p
    public final m a(n nVar, e2.m mVar, long j2) {
        u d = d(nVar);
        r1.c cVar = this.w;
        m0 m0Var = this.f3353u;
        g0 g0Var = this.f3352t;
        b bVar = new b(cVar, this.f3343i, m0Var, this.f3344j, this.f3345k, this.f3346l, d, g0Var, mVar);
        this.f3350p.add(bVar);
        return bVar;
    }

    @Override // j1.p
    public final void b() {
        this.f3352t.a();
    }

    @Override // j1.p
    public final void c(m mVar) {
        b bVar = (b) mVar;
        for (g gVar : bVar.f3337l) {
            gVar.x(null);
        }
        bVar.f3335j = null;
        bVar.f3331f.o();
        this.f3350p.remove(mVar);
    }

    @Override // e2.z
    public final void f(c0 c0Var, long j2, long j5, boolean z3) {
        i0 i0Var = (i0) c0Var;
        l lVar = i0Var.f1688a;
        Uri uri = i0Var.c.c;
        this.f3348n.d(i0Var.b, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    @Override // e2.z
    public final a0 k(c0 c0Var, long j2, long j5, IOException iOException, int i3) {
        a0 a0Var;
        i0 i0Var = (i0) c0Var;
        this.f3346l.getClass();
        long m5 = j3.a.m(i3, iOException);
        if (m5 == -9223372036854775807L) {
            a0Var = f0.f1685e;
        } else {
            a0Var = new a0(0, m5);
        }
        l lVar = i0Var.f1688a;
        k0 k0Var = i0Var.c;
        Uri uri = k0Var.c;
        this.f3348n.j(i0Var.b, j2, j5, k0Var.b, iOException, !a0Var.a());
        return a0Var;
    }

    @Override // e2.z
    public final void l(c0 c0Var, long j2, long j5) {
        i0 i0Var = (i0) c0Var;
        u uVar = this.f3348n;
        l lVar = i0Var.f1688a;
        k0 k0Var = i0Var.c;
        Uri uri = k0Var.c;
        uVar.g(i0Var.b, j2, j5, k0Var.b);
        this.w = (r1.c) i0Var.f1689e;
        this.f3354v = j2 - j5;
        r();
        if (this.w.f3388a) {
            this.f3355x.postDelayed(new c2.b(6, this), Math.max(0L, (this.f3354v + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    @Override // j1.a
    public final void m(m0 m0Var) {
        this.f3353u = m0Var;
        this.f3345k.getClass();
        if (this.f3340f) {
            this.f3352t = new j3.a(4);
            r();
            return;
        }
        this.f3351r = this.f3342h.createDataSource();
        f0 f0Var = new f0("Loader:Manifest");
        this.s = f0Var;
        this.f3352t = f0Var;
        this.f3355x = new Handler();
        s();
    }

    @Override // j1.a
    public final void p() {
        r1.c cVar;
        if (this.f3340f) {
            cVar = this.w;
        } else {
            cVar = null;
        }
        this.w = cVar;
        this.f3351r = null;
        this.f3354v = 0L;
        f0 f0Var = this.s;
        if (f0Var != null) {
            f0Var.d(null);
            this.s = null;
        }
        Handler handler = this.f3355x;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3355x = null;
        }
        this.f3345k.getClass();
    }

    public final void r() {
        r1.b[] bVarArr;
        long j2;
        j1.m0 m0Var;
        long j5;
        g[] gVarArr;
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f3350p;
            if (i3 >= arrayList.size()) {
                break;
            }
            b bVar = (b) arrayList.get(i3);
            r1.c cVar = this.w;
            bVar.f3336k = cVar;
            g[] gVarArr2 = bVar.f3337l;
            int length = gVarArr2.length;
            int i5 = 0;
            while (i5 < length) {
                a aVar = (a) gVarArr2[i5].f2654e;
                r1.b[] bVarArr2 = aVar.f3326f.c;
                int i6 = aVar.b;
                r1.b bVar2 = bVarArr2[i6];
                int i7 = bVar2.d;
                r1.b bVar3 = cVar.c[i6];
                if (i7 == 0 || bVar3.d == 0) {
                    gVarArr = gVarArr2;
                    aVar.f3327g += i7;
                } else {
                    int i8 = i7 - 1;
                    long[] jArr = bVar2.f3386h;
                    long j6 = jArr[i8];
                    gVarArr = gVarArr2;
                    long j7 = bVar3.f3386h[0];
                    if (bVar2.a(i8) + j6 <= j7) {
                        aVar.f3327g += i7;
                    } else {
                        aVar.f3327g = w.d(jArr, j7, true) + aVar.f3327g;
                    }
                }
                aVar.f3326f = cVar;
                i5++;
                gVarArr2 = gVarArr;
            }
            bVar.f3335j.e(bVar);
            i3++;
        }
        long j8 = Long.MIN_VALUE;
        long j9 = Long.MAX_VALUE;
        for (r1.b bVar4 : this.w.c) {
            if (bVar4.d > 0) {
                long[] jArr2 = bVar4.f3386h;
                j9 = Math.min(j9, jArr2[0]);
                int i9 = bVar4.d - 1;
                j8 = Math.max(j8, bVar4.a(i9) + jArr2[i9]);
            }
        }
        if (j9 == Long.MAX_VALUE) {
            r1.c cVar2 = this.w;
            boolean z3 = cVar2.f3388a;
            if (z3) {
                j5 = -9223372036854775807L;
            } else {
                j5 = 0;
            }
            m0Var = new j1.m0(j5, 0L, 0L, 0L, true, z3, z3, cVar2, this.q);
        } else {
            r1.c cVar3 = this.w;
            if (cVar3.f3388a) {
                long j10 = cVar3.f3389e;
                if (j10 != -9223372036854775807L && j10 > 0) {
                    j9 = Math.max(j9, j8 - j10);
                }
                long j11 = j9;
                long j12 = j8 - j11;
                long a5 = j12 - j0.i.a(this.f3347m);
                if (a5 < 5000000) {
                    a5 = Math.min(5000000L, j12 / 2);
                }
                m0Var = new j1.m0(-9223372036854775807L, j12, j11, a5, true, true, true, this.w, this.q);
            } else {
                long j13 = cVar3.d;
                if (j13 != -9223372036854775807L) {
                    j2 = j13;
                } else {
                    j2 = j8 - j9;
                }
                m0Var = new j1.m0(j9 + j2, j2, j9, 0L, true, false, false, cVar3, this.q);
            }
        }
        n(m0Var);
    }

    public final void s() {
        if (this.s.b()) {
            return;
        }
        i0 i0Var = new i0(this.f3351r, this.f3341g, 4, this.f3349o);
        f0 f0Var = this.s;
        j3.a aVar = this.f3346l;
        int i3 = i0Var.b;
        f0Var.e(i0Var, this, aVar.l(i3));
        this.f3348n.l(i0Var.f1688a, i3, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
}
