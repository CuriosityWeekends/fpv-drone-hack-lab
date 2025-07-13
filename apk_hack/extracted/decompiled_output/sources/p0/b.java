package p0;

import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final long f3100a;
    public final long b;
    public final long c;
    public long d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f3101e;

    /* renamed from: f  reason: collision with root package name */
    public long f3102f;

    /* renamed from: g  reason: collision with root package name */
    public long f3103g;

    /* renamed from: h  reason: collision with root package name */
    public long f3104h;

    public b(long j2, long j5, long j6, long j7, long j8, long j9) {
        this.f3100a = j2;
        this.b = j5;
        this.f3101e = j6;
        this.f3102f = j7;
        this.f3103g = j8;
        this.c = j9;
        this.f3104h = a(j5, 0L, j6, j7, j8, j9);
    }

    public static long a(long j2, long j5, long j6, long j7, long j8, long j9) {
        if (j7 + 1 < j8 && j5 + 1 < j6) {
            long j10 = ((float) (j2 - j5)) * (((float) (j8 - j7)) / ((float) (j6 - j5)));
            return w.i(((j10 + j7) - j9) - (j10 / 20), j7, j8 - 1);
        }
        return j7;
    }
}
