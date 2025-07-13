package q1;

import b2.d;
import b2.n;
import b3.e;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import e2.g0;
import e2.i;
import e2.m0;
import j0.o0;
import j1.j0;
import j1.k0;
import j1.l;
import j1.l0;
import j1.m;
import j1.u;
import java.util.ArrayList;
import l1.g;
import m1.k;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements m, k0 {

    /* renamed from: a  reason: collision with root package name */
    public final k f3329a;
    public final m0 b;
    public final g0 c;
    public final n0.b d;

    /* renamed from: e  reason: collision with root package name */
    public final j3.a f3330e;

    /* renamed from: f  reason: collision with root package name */
    public final u f3331f;

    /* renamed from: g  reason: collision with root package name */
    public final e2.m f3332g;

    /* renamed from: h  reason: collision with root package name */
    public final TrackGroupArray f3333h;

    /* renamed from: i  reason: collision with root package name */
    public final j3.a f3334i;

    /* renamed from: j  reason: collision with root package name */
    public l f3335j;

    /* renamed from: k  reason: collision with root package name */
    public r1.c f3336k;

    /* renamed from: l  reason: collision with root package name */
    public g[] f3337l;

    /* renamed from: m  reason: collision with root package name */
    public e f3338m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3339n;

    public b(r1.c cVar, k kVar, m0 m0Var, j3.a aVar, n0.b bVar, j3.a aVar2, u uVar, g0 g0Var, e2.m mVar) {
        this.f3336k = cVar;
        this.f3329a = kVar;
        this.b = m0Var;
        this.c = g0Var;
        this.d = bVar;
        this.f3330e = aVar2;
        this.f3331f = uVar;
        this.f3332g = mVar;
        this.f3334i = aVar;
        TrackGroup[] trackGroupArr = new TrackGroup[cVar.c.length];
        int i3 = 0;
        while (true) {
            r1.b[] bVarArr = cVar.c;
            if (i3 < bVarArr.length) {
                Format[] formatArr = bVarArr[i3].c;
                Format[] formatArr2 = new Format[formatArr.length];
                for (int i5 = 0; i5 < formatArr.length; i5++) {
                    Format format = formatArr[i5];
                    if (format.f314l != null) {
                        bVar.getClass();
                        format = format.d();
                    }
                    formatArr2[i5] = format;
                }
                trackGroupArr[i3] = new TrackGroup(formatArr2);
                i3++;
            } else {
                this.f3333h = new TrackGroupArray(trackGroupArr);
                g[] gVarArr = new g[0];
                this.f3337l = gVarArr;
                aVar.getClass();
                this.f3338m = new e(10, gVarArr);
                uVar.n();
                return;
            }
        }
    }

    @Override // j1.l0
    public final void A(long j2) {
        this.f3338m.A(j2);
    }

    @Override // j1.m
    public final long b(long j2, o0 o0Var) {
        g[] gVarArr;
        for (g gVar : this.f3337l) {
            if (gVar.f2653a == 2) {
                return gVar.f2654e.b(j2, o0Var);
            }
        }
        return j2;
    }

    @Override // j1.l0
    public final boolean d() {
        return this.f3338m.d();
    }

    @Override // j1.k0
    public final void e(l0 l0Var) {
        g gVar = (g) l0Var;
        this.f3335j.e(this);
    }

    @Override // j1.l0
    public final long i() {
        return this.f3338m.i();
    }

    @Override // j1.m
    public final long j() {
        if (!this.f3339n) {
            this.f3331f.q();
            this.f3339n = true;
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    @Override // j1.m
    public final TrackGroupArray o() {
        return this.f3333h;
    }

    @Override // j1.m
    public final void q(l lVar, long j2) {
        this.f3335j = lVar;
        lVar.c(this);
    }

    @Override // j1.l0
    public final long s() {
        return this.f3338m.s();
    }

    @Override // j1.m
    public final void t() {
        this.c.a();
    }

    @Override // j1.m
    public final void u(long j2, boolean z3) {
        for (g gVar : this.f3337l) {
            gVar.u(j2, z3);
        }
    }

    @Override // j1.m
    public final long w(long j2) {
        for (g gVar : this.f3337l) {
            gVar.B(j2);
        }
        return j2;
    }

    @Override // j1.l0
    public final boolean y(long j2) {
        return this.f3338m.y(j2);
    }

    @Override // j1.m
    public final long z(n[] nVarArr, boolean[] zArr, j0[] j0VarArr, boolean[] zArr2, long j2) {
        n nVar;
        n[] nVarArr2 = nVarArr;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < nVarArr2.length) {
            j0 j0Var = j0VarArr[i3];
            if (j0Var != null) {
                g gVar = (g) j0Var;
                n nVar2 = nVarArr2[i3];
                if (nVar2 != null && zArr[i3]) {
                    ((a) gVar.f2654e).f3325e = nVar2;
                    arrayList.add(gVar);
                } else {
                    gVar.x(null);
                    j0VarArr[i3] = null;
                }
            }
            if (j0VarArr[i3] == null && (nVar = nVarArr2[i3]) != null) {
                int c = this.f3333h.c(((d) nVar).f139a);
                r1.c cVar = this.f3336k;
                i createDataSource = this.f3329a.f2811a.createDataSource();
                m0 m0Var = this.b;
                if (m0Var != null) {
                    createDataSource.addTransferListener(m0Var);
                }
                a aVar = new a(this.c, cVar, c, nVar, createDataSource);
                g gVar2 = new g(this.f3336k.c[c].f3382a, null, null, aVar, this, this.f3332g, j2, this.d, this.f3330e, this.f3331f);
                arrayList.add(gVar2);
                j0VarArr[i3] = gVar2;
                zArr2[i3] = true;
            }
            i3++;
            nVarArr2 = nVarArr;
        }
        g[] gVarArr = new g[arrayList.size()];
        this.f3337l = gVarArr;
        arrayList.toArray(gVarArr);
        g[] gVarArr2 = this.f3337l;
        this.f3334i.getClass();
        this.f3338m = new e(10, gVarArr2);
        return j2;
    }
}
