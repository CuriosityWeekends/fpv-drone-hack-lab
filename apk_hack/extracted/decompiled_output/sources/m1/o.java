package m1;

import com.google.android.exoplayer2.Format;
import g2.w;
import j1.j0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o implements j0 {

    /* renamed from: a  reason: collision with root package name */
    public final Format f2824a;
    public long[] c;
    public boolean d;

    /* renamed from: e  reason: collision with root package name */
    public n1.f f2825e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2826f;

    /* renamed from: g  reason: collision with root package name */
    public int f2827g;
    public final c1.b b = new c1.b(0);

    /* renamed from: h  reason: collision with root package name */
    public long f2828h = -9223372036854775807L;

    public o(n1.f fVar, Format format, boolean z3) {
        this.f2824a = format;
        this.f2825e = fVar;
        this.c = fVar.b;
        b(fVar, z3);
    }

    public final void b(n1.f fVar, boolean z3) {
        long j2;
        int i3 = this.f2827g;
        long j5 = -9223372036854775807L;
        if (i3 == 0) {
            j2 = -9223372036854775807L;
        } else {
            j2 = this.c[i3 - 1];
        }
        this.d = z3;
        this.f2825e = fVar;
        long[] jArr = fVar.b;
        this.c = jArr;
        long j6 = this.f2828h;
        if (j6 != -9223372036854775807L) {
            int b = w.b(jArr, j6, true, false);
            this.f2827g = b;
            if (this.d && b == this.c.length) {
                j5 = j6;
            }
            this.f2828h = j5;
        } else if (j2 != -9223372036854775807L) {
            this.f2827g = w.b(jArr, j2, false, false);
        }
    }

    @Override // j1.j0
    public final int c(j0.b bVar, m0.d dVar, boolean z3) {
        if (!z3 && this.f2826f) {
            int i3 = this.f2827g;
            if (i3 == this.c.length) {
                if (this.d) {
                    return -3;
                }
                dVar.setFlags(4);
                return -4;
            }
            this.f2827g = i3 + 1;
            byte[] q = this.b.q(this.f2825e.f2928a[i3]);
            if (q == null) {
                return -3;
            }
            dVar.c(q.length);
            dVar.b.put(q);
            dVar.c = this.c[i3];
            dVar.setFlags(1);
            return -4;
        }
        bVar.d = this.f2824a;
        this.f2826f = true;
        return -5;
    }

    @Override // j1.j0
    public final int g(long j2) {
        int max = Math.max(this.f2827g, w.b(this.c, j2, true, false));
        int i3 = max - this.f2827g;
        this.f2827g = max;
        return i3;
    }

    @Override // j1.j0
    public final boolean isReady() {
        return true;
    }

    @Override // j1.j0
    public final void a() {
    }
}
