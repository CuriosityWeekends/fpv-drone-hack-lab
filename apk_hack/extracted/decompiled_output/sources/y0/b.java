package y0;

import com.google.android.exoplayer2.Format;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f4041a;
    public final g2.n b;
    public final c0.b c;
    public final String d;

    /* renamed from: e  reason: collision with root package name */
    public String f4042e;

    /* renamed from: f  reason: collision with root package name */
    public p0.u f4043f;

    /* renamed from: g  reason: collision with root package name */
    public int f4044g;

    /* renamed from: h  reason: collision with root package name */
    public int f4045h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4046i;

    /* renamed from: j  reason: collision with root package name */
    public long f4047j;

    /* renamed from: k  reason: collision with root package name */
    public Format f4048k;

    /* renamed from: l  reason: collision with root package name */
    public int f4049l;

    /* renamed from: m  reason: collision with root package name */
    public long f4050m;

    public b(String str, int i3) {
        this.f4041a = i3;
        switch (i3) {
            case 1:
                byte[] bArr = new byte[16];
                this.b = new g2.n(bArr, 16);
                this.c = new c0.b(bArr);
                this.f4044g = 0;
                this.f4045h = 0;
                this.f4046i = false;
                this.d = str;
                return;
            default:
                byte[] bArr2 = new byte[128];
                this.b = new g2.n(bArr2, 128);
                this.c = new c0.b(bArr2);
                this.f4044g = 0;
                this.d = str;
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:194:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0373  */
    @Override // y0.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(c0.b r33) {
        /*
            Method dump skipped, instructions count: 1168
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.b.a(c0.b):void");
    }

    @Override // y0.h
    public final void b() {
        switch (this.f4041a) {
            case 0:
                this.f4044g = 0;
                this.f4045h = 0;
                this.f4046i = false;
                return;
            default:
                this.f4044g = 0;
                this.f4045h = 0;
                this.f4046i = false;
                return;
        }
    }

    @Override // y0.h
    public final void c(int i3, long j2) {
        switch (this.f4041a) {
            case 0:
                this.f4050m = j2;
                return;
            default:
                this.f4050m = j2;
                return;
        }
    }

    @Override // y0.h
    public final void d(p0.k kVar, c0 c0Var) {
        switch (this.f4041a) {
            case 0:
                c0Var.a();
                c0Var.b();
                this.f4042e = c0Var.f4054e;
                c0Var.b();
                this.f4043f = kVar.g(c0Var.d, 1);
                return;
            default:
                c0Var.a();
                c0Var.b();
                this.f4042e = c0Var.f4054e;
                c0Var.b();
                this.f4043f = kVar.g(c0Var.d, 1);
                return;
        }
    }

    @Override // y0.h
    public final void e() {
        int i3 = this.f4041a;
    }

    private final void f() {
    }

    private final void g() {
    }
}
