package j1;

import j0.s0;
import j0.u0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m0 extends u0 {

    /* renamed from: j  reason: collision with root package name */
    public static final Object f2448j = new Object();
    public final long b;
    public final long c;
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2449e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f2450f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f2451g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f2452h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f2453i;

    public m0(long j2, long j5, long j6, long j7, long j8, long j9, boolean z3, boolean z5, boolean z6, Object obj, Object obj2) {
        this.b = j6;
        this.c = j7;
        this.d = j8;
        this.f2449e = j9;
        this.f2450f = z3;
        this.f2451g = z5;
        this.f2453i = obj;
        this.f2452h = obj2;
    }

    @Override // j0.u0
    public final int b(Object obj) {
        if (f2448j.equals(obj)) {
            return 0;
        }
        return -1;
    }

    @Override // j0.u0
    public final s0 f(int i3, s0 s0Var, boolean z3) {
        Object obj;
        g2.b.g(i3, 1);
        if (z3) {
            obj = f2448j;
        } else {
            obj = null;
        }
        s0Var.getClass();
        k1.b bVar = k1.b.f2501e;
        s0Var.f2305a = null;
        s0Var.b = obj;
        s0Var.c = 0;
        s0Var.d = this.b;
        s0Var.f2306e = -this.d;
        s0Var.f2307f = bVar;
        return s0Var;
    }

    @Override // j0.u0
    public final int h() {
        return 1;
    }

    @Override // j0.u0
    public final Object l(int i3) {
        g2.b.g(i3, 1);
        return f2448j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
        if (r2 > r0) goto L7;
     */
    @Override // j0.u0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j0.t0 m(int r8, j0.t0 r9, long r10) {
        /*
            r7 = this;
            r0 = 1
            g2.b.g(r8, r0)
            long r0 = r7.c
            long r2 = r7.f2449e
            boolean r8 = r7.f2451g
            if (r8 == 0) goto L23
            r4 = 0
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 == 0) goto L23
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 != 0) goto L1d
        L1b:
            r2 = r4
            goto L23
        L1d:
            long r2 = r2 + r10
            int r10 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r10 <= 0) goto L23
            goto L1b
        L23:
            java.lang.Object r10 = j0.t0.f2319k
            r9.f2320a = r10
            java.lang.Object r10 = r7.f2452h
            r9.b = r10
            java.lang.Object r10 = r7.f2453i
            r9.c = r10
            boolean r10 = r7.f2450f
            r9.d = r10
            r9.f2321e = r8
            r9.f2324h = r2
            r9.f2325i = r0
            r8 = 0
            r9.f2322f = r8
            r9.f2323g = r8
            long r10 = r7.d
            r9.f2326j = r10
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.m0.m(int, j0.t0, long):j0.t0");
    }

    @Override // j0.u0
    public final int n() {
        return 1;
    }

    public m0(long j2, long j5, long j6, long j7, boolean z3, boolean z5, boolean z6, Object obj, Object obj2) {
        this(-9223372036854775807L, -9223372036854775807L, j2, j5, j6, j7, z3, z5, z6, obj, obj2);
    }
}
