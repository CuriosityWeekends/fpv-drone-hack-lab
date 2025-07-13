package o1;

import android.net.Uri;
import android.os.Handler;
import e2.f0;
import e2.i0;
import e2.m0;
import j0.z;
import j1.u;
import java.io.IOException;
import java.util.HashMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k extends j1.a implements p1.j {

    /* renamed from: f  reason: collision with root package name */
    public final h f3007f;

    /* renamed from: g  reason: collision with root package name */
    public final Uri f3008g;

    /* renamed from: h  reason: collision with root package name */
    public final m1.k f3009h;

    /* renamed from: i  reason: collision with root package name */
    public final j3.a f3010i;

    /* renamed from: j  reason: collision with root package name */
    public final n0.b f3011j;

    /* renamed from: k  reason: collision with root package name */
    public final j3.a f3012k;

    /* renamed from: l  reason: collision with root package name */
    public final int f3013l;

    /* renamed from: m  reason: collision with root package name */
    public final p1.b f3014m;

    /* renamed from: n  reason: collision with root package name */
    public final Object f3015n = null;

    /* renamed from: o  reason: collision with root package name */
    public m0 f3016o;

    static {
        z.a("goog.exo.hls");
    }

    public k(Uri uri, m1.k kVar, b bVar, j3.a aVar, n0.b bVar2, j3.a aVar2, p1.b bVar3, int i3) {
        this.f3008g = uri;
        this.f3009h = kVar;
        this.f3007f = bVar;
        this.f3010i = aVar;
        this.f3011j = bVar2;
        this.f3012k = aVar2;
        this.f3014m = bVar3;
        this.f3013l = i3;
    }

    @Override // j1.p
    public final j1.m a(j1.n nVar, e2.m mVar, long j2) {
        u d = d(nVar);
        m0 m0Var = this.f3016o;
        return new j((b) this.f3007f, this.f3014m, this.f3009h, m0Var, this.f3011j, this.f3012k, d, mVar, this.f3010i, this.f3013l);
    }

    @Override // j1.p
    public final void b() {
        p1.b bVar = this.f3014m;
        f0 f0Var = bVar.f3147h;
        if (f0Var != null) {
            f0Var.a();
        }
        Uri uri = bVar.f3151l;
        if (uri != null) {
            p1.a aVar = (p1.a) bVar.d.get(uri);
            aVar.b.a();
            IOException iOException = aVar.f3140j;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    @Override // j1.p
    public final void c(j1.m mVar) {
        p[] pVarArr;
        o[] oVarArr;
        j jVar = (j) mVar;
        jVar.b.f3144e.remove(jVar);
        for (p pVar : jVar.f3004r) {
            if (pVar.A) {
                for (o oVar : pVar.s) {
                    oVar.j();
                    if (oVar.f2420f != null) {
                        oVar.f2420f = null;
                        oVar.f2419e = null;
                    }
                }
            }
            pVar.f3028h.d(pVar);
            pVar.f3036p.removeCallbacksAndMessages(null);
            pVar.E = true;
            pVar.q.clear();
        }
        jVar.f3002o = null;
        jVar.f2994g.o();
    }

    @Override // j1.a
    public final void m(m0 m0Var) {
        boolean z3;
        this.f3016o = m0Var;
        this.f3011j.getClass();
        u d = d(null);
        p1.b bVar = this.f3014m;
        bVar.getClass();
        bVar.f3148i = new Handler();
        bVar.f3146g = d;
        bVar.f3149j = this;
        e2.i createDataSource = bVar.f3143a.f2811a.createDataSource();
        bVar.b.getClass();
        i0 i0Var = new i0(createDataSource, this.f3008g, 4, new p1.i(p1.e.f3159l));
        if (bVar.f3147h == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.h(z3);
        f0 f0Var = new f0("DefaultHlsPlaylistTracker:MasterPlaylist");
        bVar.f3147h = f0Var;
        j3.a aVar = bVar.c;
        int i3 = i0Var.b;
        f0Var.e(i0Var, bVar, aVar.l(i3));
        d.l(i0Var.f1688a, i3, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    @Override // j1.a
    public final void p() {
        p1.b bVar = this.f3014m;
        bVar.f3151l = null;
        bVar.f3152m = null;
        bVar.f3150k = null;
        bVar.f3154o = -9223372036854775807L;
        bVar.f3147h.d(null);
        bVar.f3147h = null;
        HashMap hashMap = bVar.d;
        for (p1.a aVar : hashMap.values()) {
            aVar.b.d(null);
        }
        bVar.f3148i.removeCallbacksAndMessages(null);
        bVar.f3148i = null;
        hashMap.clear();
        this.f3011j.getClass();
    }
}
