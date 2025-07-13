package l1;

import com.google.android.exoplayer2.Format;
import e2.k0;
import g2.w;
import j1.i0;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m extends a {

    /* renamed from: n  reason: collision with root package name */
    public final int f2682n;

    /* renamed from: o  reason: collision with root package name */
    public final Format f2683o;

    /* renamed from: p  reason: collision with root package name */
    public long f2684p;
    public boolean q;

    public m(e2.i iVar, e2.l lVar, Format format, int i3, Object obj, long j2, long j5, long j6, int i5, Format format2) {
        super(iVar, lVar, format, i3, obj, j2, j5, -9223372036854775807L, -9223372036854775807L, j6);
        this.f2682n = i5;
        this.f2683o = format2;
    }

    @Override // e2.c0
    public final void a() {
        i0[] i0VarArr;
        k0 k0Var = this.f2641h;
        c1.b bVar = this.f2635l;
        for (i0 i0Var : (i0[]) bVar.c) {
            if (i0Var != null && i0Var.C != 0) {
                i0Var.C = 0L;
                i0Var.A = true;
            }
        }
        u B = bVar.B(this.f2682n);
        B.d(this.f2683o);
        try {
            long open = k0Var.open(this.f2637a.b(this.f2684p));
            if (open != -1) {
                open += this.f2684p;
            }
            p0.g gVar = new p0.g(this.f2641h, this.f2684p, open);
            for (int i3 = 0; i3 != -1; i3 = B.a(gVar, Integer.MAX_VALUE, true)) {
                this.f2684p += i3;
            }
            B.c(this.f2639f, 1, (int) this.f2684p, 0, null);
            w.f(k0Var);
            this.q = true;
        } catch (Throwable th) {
            w.f(k0Var);
            throw th;
        }
    }

    @Override // l1.k
    public final boolean d() {
        return this.q;
    }

    @Override // e2.c0
    public final void b() {
    }
}
