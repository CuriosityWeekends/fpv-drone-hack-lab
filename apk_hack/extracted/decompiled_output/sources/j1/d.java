package j1;

import com.google.android.exoplayer2.source.TrackGroupArray;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements m, l {

    /* renamed from: a  reason: collision with root package name */
    public final m f2376a;
    public l b;
    public c[] c = new c[0];
    public long d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final long f2377e;

    public d(m mVar, long j2) {
        this.f2376a = mVar;
        this.f2377e = j2;
    }

    @Override // j1.l0
    public final void A(long j2) {
        this.f2376a.A(j2);
    }

    public final boolean a() {
        if (this.d != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    @Override // j1.m
    public final long b(long j2, j0.o0 o0Var) {
        long j5;
        if (j2 == 0) {
            return 0L;
        }
        long i3 = g2.w.i(o0Var.f2277a, 0L, j2);
        long j6 = this.f2377e;
        if (j6 == Long.MIN_VALUE) {
            j5 = Long.MAX_VALUE;
        } else {
            j5 = j6 - j2;
        }
        long i5 = g2.w.i(o0Var.b, 0L, j5);
        if (i3 != o0Var.f2277a || i5 != o0Var.b) {
            o0Var = new j0.o0(i3, i5);
        }
        return this.f2376a.b(j2, o0Var);
    }

    @Override // j1.l
    public final void c(m mVar) {
        l lVar = this.b;
        lVar.getClass();
        lVar.c(this);
    }

    @Override // j1.l0
    public final boolean d() {
        return this.f2376a.d();
    }

    @Override // j1.k0
    public final void e(l0 l0Var) {
        m mVar = (m) l0Var;
        l lVar = this.b;
        lVar.getClass();
        lVar.e(this);
    }

    @Override // j1.l0
    public final long i() {
        long i3 = this.f2376a.i();
        if (i3 != Long.MIN_VALUE) {
            long j2 = this.f2377e;
            if (j2 == Long.MIN_VALUE || i3 < j2) {
                return i3;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // j1.m
    public final long j() {
        boolean z3;
        if (a()) {
            long j2 = this.d;
            this.d = -9223372036854775807L;
            long j5 = j();
            if (j5 != -9223372036854775807L) {
                return j5;
            }
            return j2;
        }
        long j6 = this.f2376a.j();
        if (j6 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z5 = false;
        if (j6 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.h(z3);
        long j7 = this.f2377e;
        g2.b.h((j7 == Long.MIN_VALUE || j6 <= j7) ? true : true);
        return j6;
    }

    @Override // j1.m
    public final TrackGroupArray o() {
        return this.f2376a.o();
    }

    @Override // j1.m
    public final void q(l lVar, long j2) {
        this.b = lVar;
        this.f2376a.q(this, j2);
    }

    @Override // j1.l0
    public final long s() {
        long s = this.f2376a.s();
        if (s != Long.MIN_VALUE) {
            long j2 = this.f2377e;
            if (j2 == Long.MIN_VALUE || s < j2) {
                return s;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // j1.m
    public final void t() {
        this.f2376a.t();
    }

    @Override // j1.m
    public final void u(long j2, boolean z3) {
        this.f2376a.u(j2, z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r0 > r7) goto L18;
     */
    @Override // j1.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long w(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.d = r0
            j1.c[] r0 = r6.c
            int r1 = r0.length
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L17
            r4 = r0[r3]
            if (r4 == 0) goto L14
            r4.b = r2
        L14:
            int r3 = r3 + 1
            goto Lc
        L17:
            j1.m r0 = r6.f2376a
            long r0 = r0.w(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L33
            r7 = 0
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L34
            long r7 = r6.f2377e
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L33
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L34
        L33:
            r2 = 1
        L34:
            g2.b.h(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.d.w(long):long");
    }

    @Override // j1.l0
    public final boolean y(long j2) {
        return this.f2376a.y(j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (r3 > r5) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    @Override // j1.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long z(b2.n[] r13, boolean[] r14, j1.j0[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            j1.c[] r2 = new j1.c[r2]
            r0.c = r2
            int r2 = r1.length
            j1.j0[] r2 = new j1.j0[r2]
            r10 = 0
            r3 = 0
        Lc:
            int r4 = r1.length
            r11 = 0
            if (r3 >= r4) goto L21
            j1.c[] r4 = r0.c
            r5 = r1[r3]
            j1.c r5 = (j1.c) r5
            r4[r3] = r5
            if (r5 == 0) goto L1c
            j1.j0 r11 = r5.f2374a
        L1c:
            r2[r3] = r11
            int r3 = r3 + 1
            goto Lc
        L21:
            j1.m r3 = r0.f2376a
            r4 = r13
            r5 = r14
            r6 = r2
            r7 = r16
            r8 = r17
            long r3 = r3.z(r4, r5, r6, r7, r8)
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.d = r5
            int r5 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r5 == 0) goto L4e
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L4c
            long r5 = r0.f2377e
            r7 = -9223372036854775808
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L4e
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L4c
            goto L4e
        L4c:
            r5 = 0
            goto L4f
        L4e:
            r5 = 1
        L4f:
            g2.b.h(r5)
        L52:
            int r5 = r1.length
            if (r10 >= r5) goto L78
            r5 = r2[r10]
            if (r5 != 0) goto L5e
            j1.c[] r5 = r0.c
            r5[r10] = r11
            goto L6f
        L5e:
            j1.c[] r6 = r0.c
            r7 = r6[r10]
            if (r7 == 0) goto L68
            j1.j0 r7 = r7.f2374a
            if (r7 == r5) goto L6f
        L68:
            j1.c r7 = new j1.c
            r7.<init>(r12, r5)
            r6[r10] = r7
        L6f:
            j1.c[] r5 = r0.c
            r5 = r5[r10]
            r1[r10] = r5
            int r10 = r10 + 1
            goto L52
        L78:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.d.z(b2.n[], boolean[], j1.j0[], boolean[], long):long");
    }
}
