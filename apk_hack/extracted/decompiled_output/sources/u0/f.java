package u0;

import g2.w;
import p0.q;
import p0.s;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f3742a;
    public final long[] b;
    public final long c;
    public final long d;

    public f(long[] jArr, long[] jArr2, long j2, long j5) {
        this.f3742a = jArr;
        this.b = jArr2;
        this.c = j2;
        this.d = j5;
    }

    @Override // u0.e
    public final long a(long j2) {
        return this.f3742a[w.d(this.b, j2, true)];
    }

    @Override // u0.e
    public final long c() {
        return this.d;
    }

    @Override // p0.r
    public final boolean e() {
        return true;
    }

    @Override // p0.r
    public final q g(long j2) {
        long[] jArr = this.f3742a;
        int d = w.d(jArr, j2, true);
        long j5 = jArr[d];
        long[] jArr2 = this.b;
        s sVar = new s(j5, jArr2[d]);
        if (j5 < j2 && d != jArr.length - 1) {
            int i3 = d + 1;
            return new q(sVar, new s(jArr[i3], jArr2[i3]));
        }
        return new q(sVar, sVar);
    }

    @Override // p0.r
    public final long i() {
        return this.c;
    }
}
