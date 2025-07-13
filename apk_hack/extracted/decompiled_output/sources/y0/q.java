package y0;

import com.google.android.exoplayer2.Format;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class q implements h {

    /* renamed from: a  reason: collision with root package name */
    public final c0.b f4180a;
    public final p0.p b;
    public final String c;
    public String d;

    /* renamed from: e  reason: collision with root package name */
    public p0.u f4181e;

    /* renamed from: f  reason: collision with root package name */
    public int f4182f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f4183g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4184h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4185i;

    /* renamed from: j  reason: collision with root package name */
    public long f4186j;

    /* renamed from: k  reason: collision with root package name */
    public int f4187k;

    /* renamed from: l  reason: collision with root package name */
    public long f4188l;

    /* JADX WARN: Type inference failed for: r0v1, types: [p0.p, java.lang.Object] */
    public q(String str) {
        c0.b bVar = new c0.b(4);
        this.f4180a = bVar;
        bVar.f187a[0] = -1;
        this.b = new Object();
        this.c = str;
    }

    @Override // y0.h
    public final void a(c0.b bVar) {
        boolean z3;
        boolean z5;
        while (bVar.a() > 0) {
            int i3 = this.f4182f;
            c0.b bVar2 = this.f4180a;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        int min = Math.min(bVar.a(), this.f4187k - this.f4183g);
                        this.f4181e.b(min, bVar);
                        int i5 = this.f4183g + min;
                        this.f4183g = i5;
                        int i6 = this.f4187k;
                        if (i5 >= i6) {
                            this.f4181e.c(this.f4188l, 1, i6, 0, null);
                            this.f4188l += this.f4186j;
                            this.f4183g = 0;
                            this.f4182f = 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    int min2 = Math.min(bVar.a(), 4 - this.f4183g);
                    bVar.b(bVar2.f187a, this.f4183g, min2);
                    int i7 = this.f4183g + min2;
                    this.f4183g = i7;
                    if (i7 >= 4) {
                        bVar2.y(0);
                        int c = bVar2.c();
                        p0.p pVar = this.b;
                        if (!p0.p.b(c, pVar)) {
                            this.f4183g = 0;
                            this.f4182f = 1;
                        } else {
                            this.f4187k = pVar.c;
                            if (!this.f4184h) {
                                int i8 = pVar.d;
                                this.f4186j = (pVar.f3127g * 1000000) / i8;
                                this.f4181e.d(Format.k(this.d, pVar.b, -1, 4096, pVar.f3125e, i8, -1, null, null, 0, this.c));
                                this.f4184h = true;
                            }
                            bVar2.y(0);
                            this.f4181e.b(4, bVar2);
                            this.f4182f = 2;
                        }
                    }
                }
            } else {
                byte[] bArr = bVar.f187a;
                int i9 = bVar.b;
                int i10 = bVar.c;
                while (true) {
                    if (i9 < i10) {
                        byte b = bArr[i9];
                        if ((b & 255) == 255) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (this.f4185i && (b & 224) == 224) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        this.f4185i = z3;
                        if (z5) {
                            bVar.y(i9 + 1);
                            this.f4185i = false;
                            bVar2.f187a[1] = bArr[i9];
                            this.f4183g = 2;
                            this.f4182f = 1;
                            break;
                        }
                        i9++;
                    } else {
                        bVar.y(i10);
                        break;
                    }
                }
            }
        }
    }

    @Override // y0.h
    public final void b() {
        this.f4182f = 0;
        this.f4183g = 0;
        this.f4185i = false;
    }

    @Override // y0.h
    public final void c(int i3, long j2) {
        this.f4188l = j2;
    }

    @Override // y0.h
    public final void d(p0.k kVar, c0 c0Var) {
        c0Var.a();
        c0Var.b();
        this.d = c0Var.f4054e;
        c0Var.b();
        this.f4181e = kVar.g(c0Var.d, 1);
    }

    @Override // y0.h
    public final void e() {
    }
}
