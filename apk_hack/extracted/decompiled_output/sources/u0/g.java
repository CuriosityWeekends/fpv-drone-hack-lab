package u0;

import g2.w;
import p0.q;
import p0.s;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g implements e {

    /* renamed from: a  reason: collision with root package name */
    public final long f3743a;
    public final int b;
    public final long c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final long f3744e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f3745f;

    public g(long j2, int i3, long j5, long j6, long[] jArr) {
        this.f3743a = j2;
        this.b = i3;
        this.c = j5;
        this.f3745f = jArr;
        this.d = j6;
        this.f3744e = j6 != -1 ? j2 + j6 : -1L;
    }

    @Override // u0.e
    public final long a(long j2) {
        long j5;
        double d;
        long j6 = j2 - this.f3743a;
        if (e() && j6 > this.b) {
            long[] jArr = this.f3745f;
            jArr.getClass();
            double d5 = (j6 * 256.0d) / this.d;
            int d6 = w.d(jArr, (long) d5, true);
            long j7 = this.c;
            long j8 = (d6 * j7) / 100;
            long j9 = jArr[d6];
            int i3 = d6 + 1;
            long j10 = (j7 * i3) / 100;
            if (d6 == 99) {
                j5 = 256;
            } else {
                j5 = jArr[i3];
            }
            if (j9 == j5) {
                d = 0.0d;
            } else {
                d = (d5 - j9) / (j5 - j9);
            }
            return Math.round(d * (j10 - j8)) + j8;
        }
        return 0L;
    }

    @Override // u0.e
    public final long c() {
        return this.f3744e;
    }

    @Override // p0.r
    public final boolean e() {
        if (this.f3745f != null) {
            return true;
        }
        return false;
    }

    @Override // p0.r
    public final q g(long j2) {
        double d;
        double d5;
        boolean e5 = e();
        int i3 = this.b;
        long j5 = this.f3743a;
        if (!e5) {
            s sVar = new s(0L, j5 + i3);
            return new q(sVar, sVar);
        }
        long i5 = w.i(j2, 0L, this.c);
        double d6 = (i5 * 100.0d) / this.c;
        double d7 = 0.0d;
        if (d6 > 0.0d) {
            if (d6 >= 100.0d) {
                d5 = 256.0d;
                d7 = 256.0d;
                double d8 = d7 / d5;
                long j6 = this.d;
                s sVar2 = new s(i5, j5 + w.i(Math.round(d8 * j6), i3, j6 - 1));
                return new q(sVar2, sVar2);
            }
            int i6 = (int) d6;
            long[] jArr = this.f3745f;
            jArr.getClass();
            double d9 = jArr[i6];
            if (i6 == 99) {
                d = 256.0d;
            } else {
                d = jArr[i6 + 1];
            }
            d7 = ((d - d9) * (d6 - i6)) + d9;
        }
        d5 = 256.0d;
        double d82 = d7 / d5;
        long j62 = this.d;
        s sVar22 = new s(i5, j5 + w.i(Math.round(d82 * j62), i3, j62 - 1));
        return new q(sVar22, sVar22);
    }

    @Override // p0.r
    public final long i() {
        return this.c;
    }
}
