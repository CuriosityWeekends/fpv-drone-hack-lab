package l1;

import com.google.android.exoplayer2.Format;
import e2.k0;
import g2.w;
import j1.i0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i extends a {

    /* renamed from: t  reason: collision with root package name */
    public static final p0.m f2670t = new Object();

    /* renamed from: n  reason: collision with root package name */
    public final int f2671n;

    /* renamed from: o  reason: collision with root package name */
    public final long f2672o;

    /* renamed from: p  reason: collision with root package name */
    public final d f2673p;
    public long q;

    /* renamed from: r  reason: collision with root package name */
    public volatile boolean f2674r;
    public boolean s;

    public i(e2.i iVar, e2.l lVar, Format format, int i3, Object obj, long j2, long j5, long j6, long j7, long j8, int i5, long j9, d dVar) {
        super(iVar, lVar, format, i3, obj, j2, j5, j6, j7, j8);
        this.f2671n = i5;
        this.f2672o = j9;
        this.f2673p = dVar;
    }

    @Override // e2.c0
    public final void a() {
        i0[] i0VarArr;
        long j2;
        long j5;
        boolean z3 = false;
        if (this.q == 0) {
            c1.b bVar = this.f2635l;
            long j6 = this.f2672o;
            for (i0 i0Var : (i0[]) bVar.c) {
                if (i0Var != null && i0Var.C != j6) {
                    i0Var.C = j6;
                    i0Var.A = true;
                }
            }
            d dVar = this.f2673p;
            long j7 = this.f2633j;
            if (j7 == -9223372036854775807L) {
                j2 = -9223372036854775807L;
            } else {
                j2 = j7 - this.f2672o;
            }
            long j8 = this.f2634k;
            if (j8 == -9223372036854775807L) {
                j5 = -9223372036854775807L;
            } else {
                j5 = j8 - this.f2672o;
            }
            dVar.b(bVar, j2, j5);
        }
        try {
            e2.l b = this.f2637a.b(this.q);
            k0 k0Var = this.f2641h;
            p0.g gVar = new p0.g(k0Var, b.f1695e, k0Var.open(b));
            p0.j jVar = this.f2673p.f2645a;
            int i3 = 0;
            while (i3 == 0 && !this.f2674r) {
                i3 = jVar.h(gVar, f2670t);
            }
            if (i3 != 1) {
                z3 = true;
            }
            g2.b.h(z3);
            this.q = gVar.d - this.f2637a.f1695e;
            w.f(this.f2641h);
            this.s = true;
        } catch (Throwable th) {
            w.f(this.f2641h);
            throw th;
        }
    }

    @Override // e2.c0
    public final void b() {
        this.f2674r = true;
    }

    @Override // l1.k
    public final long c() {
        return this.f2680i + this.f2671n;
    }

    @Override // l1.k
    public final boolean d() {
        return this.s;
    }
}
