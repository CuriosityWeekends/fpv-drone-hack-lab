package u0;

import android.util.Pair;
import g2.w;
import j0.i;
import p0.q;
import p0.s;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public final long[] f3729a;
    public final long[] b;
    public final long c;

    public b(long[] jArr, long[] jArr2) {
        this.f3729a = jArr;
        this.b = jArr2;
        this.c = i.a(jArr2[jArr2.length - 1]);
    }

    public static Pair b(long j2, long[] jArr, long[] jArr2) {
        double d;
        int d5 = w.d(jArr, j2, true);
        long j5 = jArr[d5];
        long j6 = jArr2[d5];
        int i3 = d5 + 1;
        if (i3 == jArr.length) {
            return Pair.create(Long.valueOf(j5), Long.valueOf(j6));
        }
        long j7 = jArr[i3];
        long j8 = jArr2[i3];
        if (j7 == j5) {
            d = 0.0d;
        } else {
            d = (j2 - j5) / (j7 - j5);
        }
        return Pair.create(Long.valueOf(j2), Long.valueOf(((long) (d * (j8 - j6))) + j6));
    }

    @Override // u0.e
    public final long a(long j2) {
        return i.a(((Long) b(j2, this.f3729a, this.b).second).longValue());
    }

    @Override // u0.e
    public final long c() {
        return -1L;
    }

    @Override // p0.r
    public final boolean e() {
        return true;
    }

    @Override // p0.r
    public final q g(long j2) {
        Pair b = b(i.b(w.i(j2, 0L, this.c)), this.b, this.f3729a);
        s sVar = new s(i.a(((Long) b.first).longValue()), ((Long) b.second).longValue());
        return new q(sVar, sVar);
    }

    @Override // p0.r
    public final long i() {
        return this.c;
    }
}
