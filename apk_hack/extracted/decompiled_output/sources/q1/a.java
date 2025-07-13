package q1;

import android.net.Uri;
import b2.n;
import com.google.android.exoplayer2.Format;
import e2.g0;
import e2.i;
import g2.w;
import i.k0;
import j0.o0;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import l1.d;
import l1.h;
import l1.l;
import v0.k;
import v0.p;
import v0.q;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements h {

    /* renamed from: a  reason: collision with root package name */
    public final g0 f3324a;
    public final int b;
    public final d[] c;
    public final i d;

    /* renamed from: e  reason: collision with root package name */
    public n f3325e;

    /* renamed from: f  reason: collision with root package name */
    public r1.c f3326f;

    /* renamed from: g  reason: collision with root package name */
    public int f3327g;

    /* renamed from: h  reason: collision with root package name */
    public j1.b f3328h;

    public a(g0 g0Var, r1.c cVar, int i3, n nVar, i iVar) {
        q[] qVarArr;
        int i5;
        this.f3324a = g0Var;
        this.f3326f = cVar;
        this.b = i3;
        this.f3325e = nVar;
        this.d = iVar;
        r1.b bVar = cVar.c[i3];
        this.c = new d[((b2.d) nVar).c.length];
        for (int i6 = 0; i6 < this.c.length; i6++) {
            int i7 = ((b2.d) nVar).c[i6];
            Format format = bVar.c[i7];
            if (format.f314l != null) {
                qVarArr = cVar.b.c;
            } else {
                qVarArr = null;
            }
            q[] qVarArr2 = qVarArr;
            int i8 = bVar.f3382a;
            if (i8 == 2) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            this.c[i6] = new d(new k(3, null, new p(i7, i8, bVar.b, -9223372036854775807L, cVar.d, format, 0, qVarArr2, i5, null, null), Collections.emptyList(), null), bVar.f3382a, format);
        }
    }

    @Override // l1.h
    public final void a() {
        j1.b bVar = this.f3328h;
        if (bVar == null) {
            this.f3324a.a();
            return;
        }
        throw bVar;
    }

    @Override // l1.h
    public final long b(long j2, o0 o0Var) {
        long j5;
        r1.b bVar = this.f3326f.c[this.b];
        int d = w.d(bVar.f3386h, j2, true);
        long[] jArr = bVar.f3386h;
        long j6 = jArr[d];
        if (j6 < j2 && d < bVar.d - 1) {
            j5 = jArr[d + 1];
        } else {
            j5 = j6;
        }
        return w.A(j2, o0Var, j6, j5);
    }

    @Override // l1.h
    public final boolean c(l1.b bVar, boolean z3, Exception exc, long j2) {
        if (z3 && j2 != -9223372036854775807L) {
            b2.d dVar = (b2.d) this.f3325e;
            if (dVar.h(dVar.j(bVar.c), j2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.IOException, j1.b] */
    @Override // l1.h
    public final void e(long j2, long j5, List list, k0 k0Var) {
        int c;
        long a5;
        long j6;
        boolean z3;
        boolean z5;
        boolean z6;
        if (this.f3328h != null) {
            return;
        }
        r1.c cVar = this.f3326f;
        r1.b[] bVarArr = cVar.c;
        int i3 = this.b;
        r1.b bVar = bVarArr[i3];
        if (bVar.d == 0) {
            k0Var.f2107a = !cVar.f3388a;
            return;
        }
        boolean isEmpty = list.isEmpty();
        long[] jArr = bVar.f3386h;
        if (isEmpty) {
            c = w.d(jArr, j5, true);
        } else {
            c = (int) (((l1.k) list.get(list.size() - 1)).c() - this.f3327g);
            if (c < 0) {
                this.f3328h = new IOException();
                return;
            }
        }
        if (c >= bVar.d) {
            k0Var.f2107a = !this.f3326f.f3388a;
            return;
        }
        long j7 = j5 - j2;
        r1.c cVar2 = this.f3326f;
        if (!cVar2.f3388a) {
            a5 = -9223372036854775807L;
        } else {
            r1.b bVar2 = cVar2.c[i3];
            int i5 = bVar2.d - 1;
            a5 = (bVar2.a(i5) + bVar2.f3386h[i5]) - j2;
        }
        int length = ((b2.d) this.f3325e).c.length;
        l[] lVarArr = new l[length];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = ((b2.d) this.f3325e).c[i6];
            lVarArr[i6] = new Object();
        }
        this.f3325e.d(j7, a5);
        long j8 = jArr[c];
        long a6 = bVar.a(c) + j8;
        if (list.isEmpty()) {
            j6 = j5;
        } else {
            j6 = -9223372036854775807L;
        }
        int i8 = this.f3327g + c;
        int c5 = this.f3325e.c();
        d dVar = this.c[c5];
        int i9 = ((b2.d) this.f3325e).c[c5];
        Format[] formatArr = bVar.c;
        if (formatArr != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.h(z3);
        List list2 = bVar.f3385g;
        if (list2 != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        g2.b.h(z5);
        if (c < list2.size()) {
            z6 = true;
        } else {
            z6 = false;
        }
        g2.b.h(z6);
        String num = Integer.toString(formatArr[i9].f307e);
        String l5 = ((Long) list2.get(c)).toString();
        Uri y3 = g2.b.y(bVar.f3383e, bVar.f3384f.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l5).replace("{start_time}", l5));
        b2.d dVar2 = (b2.d) this.f3325e;
        Format format = dVar2.d[dVar2.c()];
        int b = this.f3325e.b();
        Object f4 = this.f3325e.f();
        k0Var.b = new l1.i(this.d, new e2.l(y3, 0L, 0L, -1L, null, 0), format, b, f4, j8, a6, j6, -9223372036854775807L, i8, 1, j8, dVar);
    }

    @Override // l1.h
    public final int f(List list, long j2) {
        if (this.f3328h == null) {
            n nVar = this.f3325e;
            if (((b2.d) nVar).c.length >= 2) {
                return nVar.g(list, j2);
            }
        }
        return list.size();
    }

    @Override // l1.h
    public final void d(l1.b bVar) {
    }
}
