package y0;

import android.util.Log;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class s implements d0 {

    /* renamed from: a  reason: collision with root package name */
    public final h f4191a;
    public final g2.n b = new g2.n(new byte[10], 10);
    public int c = 0;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public g2.u f4192e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4193f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4194g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f4195h;

    /* renamed from: i  reason: collision with root package name */
    public int f4196i;

    /* renamed from: j  reason: collision with root package name */
    public int f4197j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4198k;

    /* renamed from: l  reason: collision with root package name */
    public long f4199l;

    public s(h hVar) {
        this.f4191a = hVar;
    }

    @Override // y0.d0
    public final void a(int i3, c0.b bVar) {
        int i5;
        int i6;
        int i7 = i3 & 1;
        h hVar = this.f4191a;
        int i8 = -1;
        int i9 = 3;
        int i10 = 2;
        if (i7 != 0) {
            int i11 = this.c;
            if (i11 != 0 && i11 != 1) {
                if (i11 != 2) {
                    if (i11 == 3) {
                        if (this.f4197j != -1) {
                            Log.w("PesReader", "Unexpected start indicator: expected " + this.f4197j + " more bytes");
                        }
                        hVar.e();
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            this.c = 1;
            this.d = 0;
        }
        int i12 = i3;
        while (bVar.a() > 0) {
            int i13 = this.c;
            if (i13 != 0) {
                g2.n nVar = this.b;
                if (i13 != 1) {
                    if (i13 != i10) {
                        if (i13 == i9) {
                            int a5 = bVar.a();
                            int i14 = this.f4197j;
                            if (i14 == i8) {
                                i6 = 0;
                            } else {
                                i6 = a5 - i14;
                            }
                            if (i6 > 0) {
                                a5 -= i6;
                                bVar.x(bVar.b + a5);
                            }
                            hVar.a(bVar);
                            int i15 = this.f4197j;
                            if (i15 != i8) {
                                int i16 = i15 - a5;
                                this.f4197j = i16;
                                if (i16 == 0) {
                                    hVar.e();
                                    this.c = 1;
                                    this.d = 0;
                                }
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        if (d(bVar, nVar.b, Math.min(10, this.f4196i)) && d(bVar, null, this.f4196i)) {
                            nVar.l(0);
                            this.f4199l = -9223372036854775807L;
                            int i17 = 4;
                            if (this.f4193f) {
                                nVar.o(4);
                                nVar.o(1);
                                long g5 = nVar.g(15) << 15;
                                nVar.o(1);
                                long g6 = g5 | (nVar.g(i9) << 30) | nVar.g(15);
                                nVar.o(1);
                                if (!this.f4195h && this.f4194g) {
                                    nVar.o(4);
                                    nVar.o(1);
                                    nVar.o(1);
                                    nVar.o(1);
                                    this.f4192e.b((nVar.g(3) << 30) | (nVar.g(15) << 15) | nVar.g(15));
                                    this.f4195h = true;
                                }
                                this.f4199l = this.f4192e.b(g6);
                            }
                            if (!this.f4198k) {
                                i17 = 0;
                            }
                            i12 |= i17;
                            hVar.c(i12, this.f4199l);
                            this.c = 3;
                            this.d = 0;
                        }
                    }
                } else if (d(bVar, nVar.b, 9)) {
                    nVar.l(0);
                    int g7 = nVar.g(24);
                    if (g7 != 1) {
                        a1.i.r("Unexpected start code prefix: ", g7, "PesReader");
                        this.f4197j = -1;
                        i5 = 0;
                    } else {
                        nVar.o(8);
                        int g8 = nVar.g(16);
                        nVar.o(5);
                        this.f4198k = nVar.f();
                        nVar.o(2);
                        this.f4193f = nVar.f();
                        this.f4194g = nVar.f();
                        nVar.o(6);
                        int g9 = nVar.g(8);
                        this.f4196i = g9;
                        if (g8 == 0) {
                            this.f4197j = -1;
                        } else {
                            this.f4197j = (g8 - 3) - g9;
                        }
                        i5 = 2;
                    }
                    this.c = i5;
                    this.d = 0;
                }
            } else {
                bVar.z(bVar.a());
            }
            i8 = -1;
            i9 = 3;
            i10 = 2;
        }
    }

    @Override // y0.d0
    public final void b() {
        this.c = 0;
        this.d = 0;
        this.f4195h = false;
        this.f4191a.b();
    }

    @Override // y0.d0
    public final void c(g2.u uVar, p0.k kVar, c0 c0Var) {
        this.f4192e = uVar;
        this.f4191a.d(kVar, c0Var);
    }

    public final boolean d(c0.b bVar, byte[] bArr, int i3) {
        int min = Math.min(bVar.a(), i3 - this.d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            bVar.z(min);
        } else {
            bVar.b(bArr, this.d, min);
        }
        int i5 = this.d + min;
        this.d = i5;
        if (i5 == i3) {
            return true;
        }
        return false;
    }
}
