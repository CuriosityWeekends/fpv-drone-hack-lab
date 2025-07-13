package y0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class x implements d0 {

    /* renamed from: a  reason: collision with root package name */
    public final w f4218a;
    public final c0.b b = new c0.b(32);
    public int c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4219e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4220f;

    public x(w wVar) {
        this.f4218a = wVar;
    }

    @Override // y0.d0
    public final void a(int i3, c0.b bVar) {
        boolean z3;
        int i5;
        boolean z5;
        if ((i3 & 1) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            i5 = bVar.b + bVar.n();
        } else {
            i5 = -1;
        }
        if (this.f4220f) {
            if (!z3) {
                return;
            }
            this.f4220f = false;
            bVar.y(i5);
            this.d = 0;
        }
        while (bVar.a() > 0) {
            int i6 = this.d;
            c0.b bVar2 = this.b;
            if (i6 < 3) {
                if (i6 == 0) {
                    int n5 = bVar.n();
                    bVar.y(bVar.b - 1);
                    if (n5 == 255) {
                        this.f4220f = true;
                        return;
                    }
                }
                int min = Math.min(bVar.a(), 3 - this.d);
                bVar.b(bVar2.f187a, this.d, min);
                int i7 = this.d + min;
                this.d = i7;
                if (i7 == 3) {
                    bVar2.v(3);
                    bVar2.z(1);
                    int n6 = bVar2.n();
                    int n7 = bVar2.n();
                    if ((n6 & 128) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    this.f4219e = z5;
                    int i8 = (((n6 & 15) << 8) | n7) + 3;
                    this.c = i8;
                    byte[] bArr = bVar2.f187a;
                    if (bArr.length < i8) {
                        bVar2.v(Math.min(4098, Math.max(i8, bArr.length * 2)));
                        System.arraycopy(bArr, 0, bVar2.f187a, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(bVar.a(), this.c - this.d);
                bVar.b(bVar2.f187a, this.d, min2);
                int i9 = this.d + min2;
                this.d = i9;
                int i10 = this.c;
                if (i9 != i10) {
                    continue;
                } else {
                    if (this.f4219e) {
                        byte[] bArr2 = bVar2.f187a;
                        int i11 = g2.w.f1960a;
                        int i12 = -1;
                        for (int i13 = 0; i13 < i10; i13++) {
                            i12 = g2.w.f1969m[((i12 >>> 24) ^ (bArr2[i13] & 255)) & 255] ^ (i12 << 8);
                        }
                        if (i12 != 0) {
                            this.f4220f = true;
                            return;
                        }
                        bVar2.v(this.c - 4);
                    } else {
                        bVar2.v(i10);
                    }
                    this.f4218a.a(bVar2);
                    this.d = 0;
                }
            }
        }
    }

    @Override // y0.d0
    public final void b() {
        this.f4220f = true;
    }

    @Override // y0.d0
    public final void c(g2.u uVar, p0.k kVar, c0 c0Var) {
        this.f4218a.c(uVar, kVar, c0Var);
        this.f4220f = true;
    }
}
