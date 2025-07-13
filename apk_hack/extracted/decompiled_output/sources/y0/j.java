package y0;

import com.google.android.exoplayer2.Format;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j implements h {
    public static final double[] q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a  reason: collision with root package name */
    public String f4092a;
    public p0.u b;
    public boolean c;
    public long d;

    /* renamed from: e  reason: collision with root package name */
    public final y f4093e;

    /* renamed from: f  reason: collision with root package name */
    public final c0.b f4094f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean[] f4095g = new boolean[4];

    /* renamed from: h  reason: collision with root package name */
    public final i f4096h;

    /* renamed from: i  reason: collision with root package name */
    public final r f4097i;

    /* renamed from: j  reason: collision with root package name */
    public long f4098j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4099k;

    /* renamed from: l  reason: collision with root package name */
    public long f4100l;

    /* renamed from: m  reason: collision with root package name */
    public long f4101m;

    /* renamed from: n  reason: collision with root package name */
    public long f4102n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f4103o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f4104p;

    /* JADX WARN: Type inference failed for: r0v2, types: [y0.i, java.lang.Object] */
    public j(y yVar) {
        this.f4093e = yVar;
        ?? obj = new Object();
        obj.d = new byte[128];
        this.f4096h = obj;
        if (yVar != null) {
            this.f4097i = new r(178);
            this.f4094f = new c0.b();
            return;
        }
        this.f4097i = null;
        this.f4094f = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01fb  */
    @Override // y0.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(c0.b r35) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.j.a(c0.b):void");
    }

    @Override // y0.h
    public final void b() {
        g2.b.j(this.f4095g);
        i iVar = this.f4096h;
        iVar.f4091a = false;
        iVar.b = 0;
        iVar.c = 0;
        if (this.f4093e != null) {
            this.f4097i.c();
        }
        this.f4098j = 0L;
        this.f4099k = false;
    }

    @Override // y0.h
    public final void c(int i3, long j2) {
        this.f4100l = j2;
    }

    @Override // y0.h
    public final void d(p0.k kVar, c0 c0Var) {
        boolean z3;
        c0Var.a();
        c0Var.b();
        this.f4092a = c0Var.f4054e;
        c0Var.b();
        this.b = kVar.g(c0Var.d, 2);
        y yVar = this.f4093e;
        if (yVar != null) {
            int i3 = 0;
            while (true) {
                p0.u[] uVarArr = yVar.b;
                if (i3 < uVarArr.length) {
                    c0Var.a();
                    c0Var.b();
                    p0.u g5 = kVar.g(c0Var.d, 3);
                    Format format = (Format) yVar.f4221a.get(i3);
                    String str = format.f311i;
                    if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    g2.b.d("Invalid closed caption mime type provided: " + str, z3);
                    c0Var.b();
                    g5.d(Format.q(c0Var.f4054e, str, format.c, format.A, format.B, null, Long.MAX_VALUE, format.f313k));
                    uVarArr[i3] = g5;
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // y0.h
    public final void e() {
    }
}
