package y0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o implements h {

    /* renamed from: a  reason: collision with root package name */
    public final y f4154a;
    public String b;
    public p0.u c;
    public n d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4155e;

    /* renamed from: l  reason: collision with root package name */
    public long f4162l;

    /* renamed from: m  reason: collision with root package name */
    public long f4163m;

    /* renamed from: f  reason: collision with root package name */
    public final boolean[] f4156f = new boolean[3];

    /* renamed from: g  reason: collision with root package name */
    public final r f4157g = new r(32);

    /* renamed from: h  reason: collision with root package name */
    public final r f4158h = new r(33);

    /* renamed from: i  reason: collision with root package name */
    public final r f4159i = new r(34);

    /* renamed from: j  reason: collision with root package name */
    public final r f4160j = new r(39);

    /* renamed from: k  reason: collision with root package name */
    public final r f4161k = new r(40);

    /* renamed from: n  reason: collision with root package name */
    public final c0.b f4164n = new c0.b();

    public o(y yVar) {
        this.f4154a = yVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03bf  */
    @Override // y0.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(c0.b r45) {
        /*
            Method dump skipped, instructions count: 991
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.o.a(c0.b):void");
    }

    @Override // y0.h
    public final void b() {
        g2.b.j(this.f4156f);
        this.f4157g.c();
        this.f4158h.c();
        this.f4159i.c();
        this.f4160j.c();
        this.f4161k.c();
        n nVar = this.d;
        nVar.f4146f = false;
        nVar.f4147g = false;
        nVar.f4148h = false;
        nVar.f4149i = false;
        nVar.f4150j = false;
        this.f4162l = 0L;
    }

    @Override // y0.h
    public final void c(int i3, long j2) {
        this.f4163m = j2;
    }

    @Override // y0.h
    public final void d(p0.k kVar, c0 c0Var) {
        c0Var.a();
        c0Var.b();
        this.b = c0Var.f4054e;
        c0Var.b();
        p0.u g5 = kVar.g(c0Var.d, 2);
        this.c = g5;
        this.d = new n(g5);
        this.f4154a.a(kVar, c0Var);
    }

    public final void f(byte[] bArr, int i3, int i5) {
        boolean z3;
        if (this.f4155e) {
            n nVar = this.d;
            if (nVar.f4146f) {
                int i6 = nVar.d;
                int i7 = (i3 + 2) - i6;
                if (i7 < i5) {
                    if ((bArr[i7] & 128) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    nVar.f4147g = z3;
                    nVar.f4146f = false;
                } else {
                    nVar.d = (i5 - i3) + i6;
                }
            }
        } else {
            this.f4157g.a(bArr, i3, i5);
            this.f4158h.a(bArr, i3, i5);
            this.f4159i.a(bArr, i3, i5);
        }
        this.f4160j.a(bArr, i3, i5);
        this.f4161k.a(bArr, i3, i5);
    }

    @Override // y0.h
    public final void e() {
    }
}
