package m1;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2791a;
    public final long b;
    public final long c;

    public g(boolean z3, long j2, long j5) {
        this.f2791a = z3;
        this.b = j2;
        this.c = j5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        r0 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static m1.g a(n1.g r20, long r21) {
        /*
            r0 = r20
            r4 = r21
            java.util.List r1 = r0.c
            int r1 = r1.size()
            r2 = 0
            r3 = 0
        Lc:
            r6 = 1
            java.util.List r7 = r0.c
            if (r3 >= r1) goto L24
            java.lang.Object r8 = r7.get(r3)
            n1.a r8 = (n1.a) r8
            int r8 = r8.b
            if (r8 == r6) goto L22
            r9 = 2
            if (r8 != r9) goto L1f
            goto L22
        L1f:
            int r3 = r3 + 1
            goto Lc
        L22:
            r0 = 1
            goto L25
        L24:
            r0 = 0
        L25:
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L2f:
            if (r3 >= r1) goto La2
            java.lang.Object r16 = r7.get(r3)
            r6 = r16
            n1.a r6 = (n1.a) r6
            if (r0 == 0) goto L43
            int r8 = r6.b
            r9 = 3
            if (r8 != r9) goto L43
        L40:
            r16 = r3
            goto L9d
        L43:
            java.util.List r6 = r6.c
            java.lang.Object r6 = r6.get(r2)
            n1.l r6 = (n1.l) r6
            m1.i r6 = r6.d()
            if (r6 != 0) goto L5d
            m1.g r6 = new m1.g
            r1 = 1
            r2 = 0
            r0 = r6
            r4 = r21
            r0.<init>(r1, r2, r4)
            return r6
        L5d:
            boolean r8 = r6.p()
            r13 = r13 | r8
            int r8 = r6.v(r4)
            if (r8 != 0) goto L70
            r16 = r3
            r10 = 0
            r12 = 1
            r14 = 0
            goto L9d
        L70:
            if (r12 != 0) goto L40
            r16 = r3
            long r2 = r6.r()
            r18 = r10
            long r9 = r6.a(r2)
            long r14 = java.lang.Math.max(r14, r9)
            r9 = -1
            if (r8 == r9) goto L9b
            long r8 = (long) r8
            long r2 = r2 + r8
            r8 = 1
            long r2 = r2 - r8
            long r8 = r6.a(r2)
            long r2 = r6.e(r2, r4)
            long r2 = r2 + r8
            r10 = r18
            long r2 = java.lang.Math.min(r10, r2)
            r10 = r2
            goto L9d
        L9b:
            r10 = r18
        L9d:
            int r3 = r16 + 1
            r2 = 0
            r6 = 1
            goto L2f
        La2:
            m1.g r0 = new m1.g
            r12 = r0
            r16 = r10
            r12.<init>(r13, r14, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.g.a(n1.g, long):m1.g");
    }
}
