package m1;

import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j implements i {

    /* renamed from: a  reason: collision with root package name */
    public final p0.f f2810a;
    public final long b;

    public j(p0.f fVar, long j2) {
        this.f2810a = fVar;
        this.b = j2;
    }

    @Override // m1.i
    public final long a(long j2) {
        return this.f2810a.f3107e[(int) j2] - this.b;
    }

    @Override // m1.i
    public final long c(long j2, long j5) {
        return w.d(this.f2810a.f3107e, j2 + this.b, true);
    }

    @Override // m1.i
    public final long e(long j2, long j5) {
        return this.f2810a.d[(int) j2];
    }

    @Override // m1.i
    public final n1.i l(long j2) {
        p0.f fVar = this.f2810a;
        int i3 = (int) j2;
        return new n1.i(fVar.c[i3], fVar.b[i3], null);
    }

    @Override // m1.i
    public final boolean p() {
        return true;
    }

    @Override // m1.i
    public final long r() {
        return 0L;
    }

    @Override // m1.i
    public final int v(long j2) {
        return this.f2810a.f3106a;
    }
}
