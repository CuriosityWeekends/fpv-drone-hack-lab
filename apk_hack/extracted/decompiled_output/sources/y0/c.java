package y0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements p0.j {

    /* renamed from: a  reason: collision with root package name */
    public final b f4052a = new b(null, 1);
    public final c0.b b = new c0.b(16384);
    public boolean c;

    @Override // p0.j
    public final void b(p0.k kVar) {
        this.f4052a.d(kVar, new c0(0, 1));
        kVar.c();
        kVar.a(new p0.n(-9223372036854775807L));
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        this.c = false;
        this.f4052a.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
        r15.f3111f = 0;
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
        if ((r4 - r3) < 8192) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0043, code lost:
        return false;
     */
    @Override // p0.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(p0.g r15) {
        /*
            r14 = this;
            c0.b r0 = new c0.b
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.f187a
            r15.d(r4, r2, r1, r2)
            r0.y(r2)
            int r4 = r0.p()
            r5 = 4801587(0x494433, float:6.728456E-39)
            r6 = 3
            if (r4 == r5) goto L8c
            r15.f3111f = r2
            r15.a(r3, r2)
            r4 = r3
        L21:
            r1 = 0
        L22:
            byte[] r5 = r0.f187a
            r7 = 7
            r15.d(r5, r2, r7, r2)
            r0.y(r2)
            int r5 = r0.s()
            r8 = 44096(0xac40, float:6.1792E-41)
            r9 = 44097(0xac41, float:6.1793E-41)
            if (r5 == r8) goto L48
            if (r5 == r9) goto L48
            r15.f3111f = r2
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.148E-41)
            if (r1 < r5) goto L44
            return r2
        L44:
            r15.a(r4, r2)
            goto L21
        L48:
            r8 = 1
            int r1 = r1 + r8
            r10 = 4
            if (r1 < r10) goto L4e
            return r8
        L4e:
            byte[] r8 = r0.f187a
            int r11 = r8.length
            r12 = -1
            if (r11 >= r7) goto L56
            r11 = -1
            goto L83
        L56:
            r11 = 2
            r11 = r8[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r13 = r8[r6]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r11 = r11 | r13
            r13 = 65535(0xffff, float:9.1834E-41)
            if (r11 != r13) goto L7d
            r10 = r8[r10]
            r10 = r10 & 255(0xff, float:3.57E-43)
            int r10 = r10 << 16
            r11 = 5
            r11 = r8[r11]
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r11 = r11 << 8
            r10 = r10 | r11
            r11 = 6
            r8 = r8[r11]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r11 = r10 | r8
            goto L7e
        L7d:
            r7 = 4
        L7e:
            if (r5 != r9) goto L82
            int r7 = r7 + 2
        L82:
            int r11 = r11 + r7
        L83:
            if (r11 != r12) goto L86
            return r2
        L86:
            int r11 = r11 + (-7)
            r15.a(r11, r2)
            goto L22
        L8c:
            r0.z(r6)
            int r4 = r0.m()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r15.a(r4, r2)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.c.f(p0.g):boolean");
    }

    @Override // p0.j
    public final int h(p0.g gVar, p0.m mVar) {
        c0.b bVar = this.b;
        int e5 = gVar.e(bVar.f187a, 0, 16384);
        if (e5 == -1) {
            return -1;
        }
        bVar.y(0);
        bVar.x(e5);
        boolean z3 = this.c;
        b bVar2 = this.f4052a;
        if (!z3) {
            bVar2.f4050m = 0L;
            this.c = true;
        }
        bVar2.a(bVar);
        return 0;
    }
}
