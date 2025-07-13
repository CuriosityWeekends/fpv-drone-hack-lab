package m1;

import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final l1.d f2812a;
    public final n1.l b;
    public final i c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2813e;

    public l(long j2, n1.l lVar, l1.d dVar, long j5, i iVar) {
        this.d = j2;
        this.b = lVar;
        this.f2813e = j5;
        this.f2812a = dVar;
        this.c = iVar;
    }

    public final l a(long j2, n1.l lVar) {
        long c;
        long j5;
        i d = this.b.d();
        i d5 = lVar.d();
        if (d == null) {
            return new l(j2, lVar, this.f2812a, this.f2813e, d);
        }
        if (!d.p()) {
            return new l(j2, lVar, this.f2812a, this.f2813e, d5);
        }
        int v5 = d.v(j2);
        if (v5 == 0) {
            return new l(j2, lVar, this.f2812a, this.f2813e, d5);
        }
        long r5 = d.r();
        long a5 = d.a(r5);
        long j6 = v5 + r5;
        long j7 = j6 - 1;
        long e5 = d.e(j7, j2) + d.a(j7);
        long r6 = d5.r();
        long a6 = d5.a(r6);
        long j8 = this.f2813e;
        int i3 = (e5 > a6 ? 1 : (e5 == a6 ? 0 : -1));
        if (i3 == 0) {
            j5 = (j6 - r6) + j8;
        } else if (i3 >= 0) {
            if (a6 < a5) {
                c = j8 - (d5.c(a5, j2) - r5);
            } else {
                c = (d.c(a6, j2) - r6) + j8;
            }
            j5 = c;
        } else {
            throw new IOException();
        }
        return new l(j2, lVar, this.f2812a, j5, d5);
    }

    public final long b(n1.b bVar, int i3, long j2) {
        i iVar = this.c;
        long j5 = this.d;
        int v5 = iVar.v(j5);
        long j6 = this.f2813e;
        if (v5 == -1 && bVar.f2917e != -9223372036854775807L) {
            return Math.max(iVar.r() + j6, iVar.c(((j2 - j0.i.a(bVar.f2916a)) - j0.i.a(bVar.a(i3).b)) - j0.i.a(bVar.f2917e), j5) + j6);
        }
        return iVar.r() + j6;
    }

    public final long c(n1.b bVar, int i3, long j2) {
        i iVar = this.c;
        long j5 = this.d;
        int v5 = iVar.v(j5);
        long j6 = this.f2813e;
        if (v5 == -1) {
            return (iVar.c((j2 - j0.i.a(bVar.f2916a)) - j0.i.a(bVar.a(i3).b), j5) + j6) - 1;
        }
        return ((iVar.r() + j6) + v5) - 1;
    }

    public final long d(long j2) {
        return this.c.e(j2 - this.f2813e, this.d) + e(j2);
    }

    public final long e(long j2) {
        return this.c.a(j2 - this.f2813e);
    }
}
