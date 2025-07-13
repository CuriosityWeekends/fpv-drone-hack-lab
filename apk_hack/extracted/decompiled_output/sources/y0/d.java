package y0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements p0.j {
    public final c0.b c;
    public final g2.n d;

    /* renamed from: e  reason: collision with root package name */
    public p0.k f4056e;

    /* renamed from: f  reason: collision with root package name */
    public long f4057f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4059h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4060i;

    /* renamed from: a  reason: collision with root package name */
    public final e f4055a = new e(null, true);
    public final c0.b b = new c0.b(2048);

    /* renamed from: g  reason: collision with root package name */
    public long f4058g = -1;

    public d() {
        c0.b bVar = new c0.b(10);
        this.c = bVar;
        byte[] bArr = bVar.f187a;
        this.d = new g2.n(bArr, bArr.length);
    }

    public final int a(p0.g gVar) {
        int i3 = 0;
        while (true) {
            c0.b bVar = this.c;
            gVar.d(bVar.f187a, 0, 10, false);
            bVar.y(0);
            if (bVar.p() != 4801587) {
                break;
            }
            bVar.z(3);
            int m5 = bVar.m();
            i3 += m5 + 10;
            gVar.a(m5, false);
        }
        gVar.f3111f = 0;
        gVar.a(i3, false);
        if (this.f4058g == -1) {
            this.f4058g = i3;
        }
        return i3;
    }

    @Override // p0.j
    public final void b(p0.k kVar) {
        this.f4056e = kVar;
        this.f4055a.d(kVar, new c0(0, 1));
        kVar.c();
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        this.f4059h = false;
        e eVar = this.f4055a;
        eVar.f4070l = false;
        eVar.f4066h = 0;
        eVar.f4067i = 0;
        eVar.f4068j = 256;
        this.f4057f = j5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        r10.f3111f = 0;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        if ((r3 - r0) < 8192) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
        return false;
     */
    @Override // p0.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(p0.g r10) {
        /*
            r9 = this;
            int r0 = r9.a(r10)
            r1 = 0
            r3 = r0
        L6:
            r2 = 0
            r4 = 0
        L8:
            c0.b r5 = r9.c
            byte[] r6 = r5.f187a
            r7 = 2
            r10.d(r6, r1, r7, r1)
            r5.y(r1)
            int r6 = r5.s()
            r7 = 65526(0xfff6, float:9.1821E-41)
            r6 = r6 & r7
            r7 = 65520(0xfff0, float:9.1813E-41)
            if (r6 != r7) goto L47
            r6 = 1
            int r2 = r2 + r6
            r7 = 4
            if (r2 < r7) goto L2a
            r8 = 188(0xbc, float:2.63E-43)
            if (r4 <= r8) goto L2a
            return r6
        L2a:
            byte[] r5 = r5.f187a
            r10.d(r5, r1, r7, r1)
            g2.n r5 = r9.d
            r6 = 14
            r5.l(r6)
            r6 = 13
            int r5 = r5.g(r6)
            r6 = 6
            if (r5 > r6) goto L40
            return r1
        L40:
            int r6 = r5 + (-6)
            r10.a(r6, r1)
            int r4 = r4 + r5
            goto L8
        L47:
            r10.f3111f = r1
            int r3 = r3 + 1
            int r2 = r3 - r0
            r4 = 8192(0x2000, float:1.148E-41)
            if (r2 < r4) goto L52
            return r1
        L52:
            r10.a(r3, r1)
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.d.f(p0.g):boolean");
    }

    @Override // p0.j
    public final int h(p0.g gVar, p0.m mVar) {
        boolean z3;
        c0.b bVar = this.b;
        int e5 = gVar.e(bVar.f187a, 0, 2048);
        if (e5 == -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!this.f4060i) {
            p0.k kVar = this.f4056e;
            kVar.getClass();
            kVar.a(new p0.n(-9223372036854775807L));
            this.f4060i = true;
        }
        if (z3) {
            return -1;
        }
        bVar.y(0);
        bVar.x(e5);
        boolean z5 = this.f4059h;
        e eVar = this.f4055a;
        if (!z5) {
            eVar.s = this.f4057f;
            this.f4059h = true;
        }
        eVar.a(bVar);
        return 0;
    }
}
