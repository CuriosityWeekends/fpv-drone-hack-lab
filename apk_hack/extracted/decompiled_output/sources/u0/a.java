package u0;

import g2.w;
import p0.q;
import p0.r;
import p0.s;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements e, r {

    /* renamed from: a  reason: collision with root package name */
    public final long f3726a;
    public final long b;
    public final int c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3727e;

    /* renamed from: f  reason: collision with root package name */
    public final long f3728f;

    public a(long j2, long j5, int i3, int i5) {
        this.f3726a = j2;
        this.b = j5;
        this.c = i5 == -1 ? 1 : i5;
        this.f3727e = i3;
        if (j2 == -1) {
            this.d = -1L;
            this.f3728f = -9223372036854775807L;
            return;
        }
        long j6 = j2 - j5;
        this.d = j6;
        this.f3728f = (Math.max(0L, j6) * 8000000) / i3;
    }

    @Override // u0.e
    public final long a(long j2) {
        return (Math.max(0L, j2 - this.b) * 8000000) / this.f3727e;
    }

    @Override // u0.e
    public final long c() {
        return -1L;
    }

    @Override // p0.r
    public final boolean e() {
        if (this.d != -1) {
            return true;
        }
        return false;
    }

    @Override // p0.r
    public final q g(long j2) {
        long j5 = this.b;
        long j6 = this.d;
        if (j6 == -1) {
            s sVar = new s(0L, j5);
            return new q(sVar, sVar);
        }
        int i3 = this.f3727e;
        long j7 = this.c;
        long i5 = w.i((((i3 * j2) / 8000000) / j7) * j7, 0L, j6 - j7) + j5;
        long max = (Math.max(0L, i5 - j5) * 8000000) / i3;
        s sVar2 = new s(max, i5);
        if (max < j2) {
            long j8 = i5 + j7;
            if (j8 < this.f3726a) {
                return new q(sVar2, new s((Math.max(0L, j8 - j5) * 8000000) / i3, j8));
            }
        }
        return new q(sVar2, sVar2);
    }

    @Override // p0.r
    public final long i() {
        return this.f3728f;
    }
}
