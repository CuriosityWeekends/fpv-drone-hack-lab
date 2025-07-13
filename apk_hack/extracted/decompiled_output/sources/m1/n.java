package m1;

import com.google.android.exoplayer2.Format;
import e2.g0;
import g2.w;
import j0.o0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n implements l1.h {

    /* renamed from: a  reason: collision with root package name */
    public final g0 f2814a;
    public final int[] b;
    public final int c;
    public final e2.i d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2815e;

    /* renamed from: f  reason: collision with root package name */
    public final q f2816f;

    /* renamed from: g  reason: collision with root package name */
    public final l[] f2817g;

    /* renamed from: h  reason: collision with root package name */
    public b2.n f2818h;

    /* renamed from: i  reason: collision with root package name */
    public n1.b f2819i;

    /* renamed from: j  reason: collision with root package name */
    public int f2820j;

    /* renamed from: k  reason: collision with root package name */
    public j1.b f2821k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2822l;

    /* renamed from: m  reason: collision with root package name */
    public long f2823m;

    public n(g0 g0Var, n1.b bVar, int i3, int[] iArr, b2.n nVar, int i5, e2.i iVar, long j2, boolean z3, ArrayList arrayList, q qVar) {
        l1.d dVar;
        p0.j eVar;
        int i6;
        this.f2814a = g0Var;
        this.f2819i = bVar;
        this.b = iArr;
        this.f2818h = nVar;
        this.c = i5;
        this.d = iVar;
        this.f2820j = i3;
        this.f2815e = j2;
        this.f2816f = qVar;
        long c = bVar.c(i3);
        this.f2823m = -9223372036854775807L;
        ArrayList g5 = g();
        int[] iArr2 = ((b2.d) nVar).c;
        this.f2817g = new l[iArr2.length];
        int i7 = 0;
        while (i7 < this.f2817g.length) {
            n1.l lVar = (n1.l) g5.get(iArr2[i7]);
            l[] lVarArr = this.f2817g;
            String str = lVar.f2937a.f310h;
            if (!"text".equals(g2.k.d(str)) && !"application/ttml+xml".equals(str)) {
                boolean equals = "application/x-rawcc".equals(str);
                Format format = lVar.f2937a;
                if (equals) {
                    eVar = new x0.a(format);
                } else if (!str.startsWith("video/webm") && !str.startsWith("audio/webm") && !str.startsWith("application/webm")) {
                    if (z3) {
                        i6 = 4;
                    } else {
                        i6 = 0;
                    }
                    eVar = new v0.k(i6, null, null, arrayList, qVar);
                } else {
                    eVar = new t0.e(1);
                }
                dVar = new l1.d(eVar, i5, format);
            } else {
                dVar = null;
            }
            int i8 = i7;
            lVarArr[i8] = new l(c, lVar, dVar, 0L, lVar.d());
            i7 = i8 + 1;
            g5 = g5;
        }
    }

    @Override // l1.h
    public final void a() {
        j1.b bVar = this.f2821k;
        if (bVar == null) {
            this.f2814a.a();
            return;
        }
        throw bVar;
    }

    @Override // l1.h
    public final long b(long j2, o0 o0Var) {
        l[] lVarArr;
        long j5;
        long j6;
        for (l lVar : this.f2817g) {
            i iVar = lVar.c;
            if (iVar != null) {
                long c = iVar.c(j2, lVar.d) + lVar.f2813e;
                long e5 = lVar.e(c);
                if (e5 < j2 && c < lVar.c.v(j5) - 1) {
                    j6 = lVar.e(c + 1);
                } else {
                    j6 = e5;
                }
                return w.A(j2, o0Var, e5, j6);
            }
        }
        return j2;
    }

    @Override // l1.h
    public final boolean c(l1.b bVar, boolean z3, Exception exc, long j2) {
        if (!z3) {
            return false;
        }
        q qVar = this.f2816f;
        if (qVar != null) {
            r rVar = qVar.d;
            if (rVar.f2833f.c) {
                if (!rVar.f2836i) {
                    long j5 = rVar.f2834g;
                    if (j5 != -9223372036854775807L && j5 < bVar.f2639f) {
                        rVar.a();
                    }
                }
                return true;
            }
        }
        if (!this.f2819i.c && (bVar instanceof l1.k) && (exc instanceof e2.w) && ((e2.w) exc).f1754a == 404) {
            l lVar = this.f2817g[((b2.d) this.f2818h).j(bVar.c)];
            int v5 = lVar.c.v(lVar.d);
            if (v5 != -1 && v5 != 0) {
                if (((l1.k) bVar).c() > ((lVar.c.r() + lVar.f2813e) + v5) - 1) {
                    this.f2822l = true;
                    return true;
                }
            }
        }
        if (j2 == -9223372036854775807L) {
            return false;
        }
        b2.d dVar = (b2.d) this.f2818h;
        if (!dVar.h(dVar.j(bVar.c), j2)) {
            return false;
        }
        return true;
    }

    @Override // l1.h
    public final void d(l1.b bVar) {
        l1.d dVar;
        p0.r rVar;
        if (bVar instanceof l1.j) {
            int j2 = ((b2.d) this.f2818h).j(((l1.j) bVar).c);
            l[] lVarArr = this.f2817g;
            l lVar = lVarArr[j2];
            if (lVar.c == null && (rVar = (dVar = lVar.f2812a).f2649h) != null) {
                n1.l lVar2 = lVar.b;
                lVarArr[j2] = new l(lVar.d, lVar2, dVar, lVar.f2813e, new j((p0.f) rVar, lVar2.c));
            }
        }
        q qVar = this.f2816f;
        if (qVar != null) {
            r rVar2 = qVar.d;
            long j5 = rVar2.f2834g;
            if (j5 != -9223372036854775807L || bVar.f2640g > j5) {
                rVar2.f2834g = bVar.f2640g;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0124 A[EDGE_INSN: B:143:0x0124->B:58:0x0124 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01be  */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.IOException, j1.b] */
    @Override // l1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(long r46, long r48, java.util.List r50, i.k0 r51) {
        /*
            Method dump skipped, instructions count: 814
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.n.e(long, long, java.util.List, i.k0):void");
    }

    @Override // l1.h
    public final int f(List list, long j2) {
        if (this.f2821k == null) {
            b2.n nVar = this.f2818h;
            if (((b2.d) nVar).c.length >= 2) {
                return nVar.g(list, j2);
            }
        }
        return list.size();
    }

    public final ArrayList g() {
        List list = this.f2819i.a(this.f2820j).c;
        ArrayList arrayList = new ArrayList();
        for (int i3 : this.b) {
            arrayList.addAll(((n1.a) list.get(i3)).c);
        }
        return arrayList;
    }
}
