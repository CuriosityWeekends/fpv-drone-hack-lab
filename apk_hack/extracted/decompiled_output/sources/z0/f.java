package z0;

import g2.w;
import p0.q;
import p0.r;
import p0.s;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements r {

    /* renamed from: a  reason: collision with root package name */
    public final e f4287a;
    public final int b;
    public final long c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final long f4288e;

    public f(e eVar, int i3, long j2, long j5) {
        this.f4287a = eVar;
        this.b = i3;
        this.c = j2;
        long j6 = (j5 - j2) / eVar.d;
        this.d = j6;
        this.f4288e = w.B(j6 * i3, 1000000L, eVar.c);
    }

    @Override // p0.r
    public final boolean e() {
        return true;
    }

    @Override // p0.r
    public final q g(long j2) {
        e eVar = this.f4287a;
        int i3 = this.b;
        long j5 = (eVar.c * j2) / (i3 * 1000000);
        long j6 = this.d - 1;
        long i5 = w.i(j5, 0L, j6);
        int i6 = eVar.d;
        long j7 = this.c;
        long B = w.B(i5 * i3, 1000000L, eVar.c);
        s sVar = new s(B, (i6 * i5) + j7);
        if (B < j2 && i5 != j6) {
            long j8 = i5 + 1;
            return new q(sVar, new s(w.B(j8 * i3, 1000000L, eVar.c), (i6 * j8) + j7));
        }
        return new q(sVar, sVar);
    }

    @Override // p0.r
    public final long i() {
        return this.f4288e;
    }
}
