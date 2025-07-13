package y0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements p0.j {

    /* renamed from: a  reason: collision with root package name */
    public final b f4026a = new b(null, 0);
    public final c0.b b = new c0.b(2786);
    public boolean c;

    @Override // p0.j
    public final void b(p0.k kVar) {
        this.f4026a.d(kVar, new c0(0, 1));
        kVar.c();
        kVar.a(new p0.n(-9223372036854775807L));
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        this.c = false;
        this.f4026a.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
        if ((r5 - r3) < 8192) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
        r14.f3111f = 0;
        r5 = r5 + 1;
     */
    @Override // p0.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(p0.g r14) {
        /*
            r13 = this;
            c0.b r0 = new c0.b
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.f187a
            r14.d(r4, r2, r1, r2)
            r0.y(r2)
            int r4 = r0.p()
            r5 = 4801587(0x494433, float:6.728456E-39)
            r6 = 3
            if (r4 == r5) goto L7d
            r14.f3111f = r2
            r14.a(r3, r2)
            r5 = r3
        L21:
            r4 = 0
        L22:
            byte[] r7 = r0.f187a
            r8 = 6
            r14.d(r7, r2, r8, r2)
            r0.y(r2)
            int r7 = r0.s()
            r9 = 2935(0xb77, float:4.113E-42)
            if (r7 == r9) goto L42
            r14.f3111f = r2
            int r5 = r5 + 1
            int r4 = r5 - r3
            r7 = 8192(0x2000, float:1.148E-41)
            if (r4 < r7) goto L3e
            return r2
        L3e:
            r14.a(r5, r2)
            goto L21
        L42:
            r7 = 1
            int r4 = r4 + r7
            r9 = 4
            if (r4 < r9) goto L48
            return r7
        L48:
            byte[] r10 = r0.f187a
            int r11 = r10.length
            r12 = -1
            if (r11 >= r8) goto L50
            r9 = -1
            goto L74
        L50:
            r11 = 5
            r11 = r10[r11]
            r11 = r11 & 248(0xf8, float:3.48E-43)
            int r11 = r11 >> r6
            if (r11 <= r1) goto L68
            r8 = 2
            r9 = r10[r8]
            r9 = r9 & 7
            int r9 = r9 << 8
            r10 = r10[r6]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r9 = r9 | r10
            int r9 = r9 + r7
            int r9 = r9 * 2
            goto L74
        L68:
            r7 = r10[r9]
            r9 = r7 & 192(0xc0, float:2.69E-43)
            int r8 = r9 >> 6
            r7 = r7 & 63
            int r9 = l0.a.a(r8, r7)
        L74:
            if (r9 != r12) goto L77
            return r2
        L77:
            int r9 = r9 + (-6)
            r14.a(r9, r2)
            goto L22
        L7d:
            r0.z(r6)
            int r4 = r0.m()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r14.a(r4, r2)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.a.f(p0.g):boolean");
    }

    @Override // p0.j
    public final int h(p0.g gVar, p0.m mVar) {
        c0.b bVar = this.b;
        int e5 = gVar.e(bVar.f187a, 0, 2786);
        if (e5 == -1) {
            return -1;
        }
        bVar.y(0);
        bVar.x(e5);
        boolean z3 = this.c;
        b bVar2 = this.f4026a;
        if (!z3) {
            bVar2.f4050m = 0L;
            this.c = true;
        }
        bVar2.a(bVar);
        return 0;
    }
}
