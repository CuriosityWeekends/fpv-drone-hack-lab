package g2;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1945a;
    public byte[] b;
    public int c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f1946e;

    public n() {
        this.f1945a = 0;
        this.b = w.f1962f;
    }

    public void a() {
        boolean z3;
        int i3;
        boolean z5;
        int i5;
        switch (this.f1945a) {
            case 0:
                int i6 = this.c;
                if (i6 >= 0 && (i6 < (i3 = this.f1946e) || (i6 == i3 && this.d == 0))) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                b.h(z3);
                return;
            default:
                int i7 = this.d;
                if (i7 >= 0 && (i7 < (i5 = this.c) || (i7 == i5 && this.f1946e == 0))) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                b.h(z5);
                return;
        }
    }

    public int b() {
        return ((this.f1946e - this.c) * 8) - this.d;
    }

    public void c() {
        if (this.d == 0) {
            return;
        }
        this.d = 0;
        this.c++;
        a();
    }

    public boolean d(int i3) {
        int i5 = this.d;
        int i6 = i3 / 8;
        int i7 = i5 + i6;
        int i8 = (this.f1946e + i3) - (i6 * 8);
        if (i8 > 7) {
            i7++;
            i8 -= 8;
        }
        while (true) {
            i5++;
            if (i5 > i7 || i7 >= this.c) {
                break;
            } else if (m(i5)) {
                i7++;
                i5 += 2;
            }
        }
        int i9 = this.c;
        if (i7 < i9) {
            return true;
        }
        if (i7 == i9 && i8 == 0) {
            return true;
        }
        return false;
    }

    public boolean e() {
        boolean z3;
        int i3 = this.d;
        int i5 = this.f1946e;
        int i6 = 0;
        while (this.d < this.c && !f()) {
            i6++;
        }
        if (this.d == this.c) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.d = i3;
        this.f1946e = i5;
        if (z3 || !d((i6 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public boolean f() {
        boolean z3;
        boolean z5;
        boolean z6;
        switch (this.f1945a) {
            case 0:
                if ((this.b[this.c] & (128 >> this.d)) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                n();
                return z3;
            case 1:
                if ((this.b[this.d] & (128 >> this.f1946e)) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                n();
                return z5;
            default:
                if ((((this.b[this.d] & 255) >> this.f1946e) & 1) == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                o(1);
                return z6;
        }
    }

    public int g(int i3) {
        switch (this.f1945a) {
            case 0:
                if (i3 == 0) {
                    return 0;
                }
                this.d += i3;
                int i5 = 0;
                while (true) {
                    int i6 = this.d;
                    if (i6 > 8) {
                        int i7 = i6 - 8;
                        this.d = i7;
                        byte[] bArr = this.b;
                        int i8 = this.c;
                        this.c = i8 + 1;
                        i5 |= (bArr[i8] & 255) << i7;
                    } else {
                        byte[] bArr2 = this.b;
                        int i9 = this.c;
                        int i10 = ((-1) >>> (32 - i3)) & (i5 | ((bArr2[i9] & 255) >> (8 - i6)));
                        if (i6 == 8) {
                            this.d = 0;
                            this.c = i9 + 1;
                        }
                        a();
                        return i10;
                    }
                }
            case 1:
                this.f1946e += i3;
                int i11 = 0;
                while (true) {
                    int i12 = this.f1946e;
                    int i13 = 2;
                    if (i12 > 8) {
                        int i14 = i12 - 8;
                        this.f1946e = i14;
                        byte[] bArr3 = this.b;
                        int i15 = this.d;
                        i11 |= (bArr3[i15] & 255) << i14;
                        if (!m(i15 + 1)) {
                            i13 = 1;
                        }
                        this.d = i15 + i13;
                    } else {
                        byte[] bArr4 = this.b;
                        int i16 = this.d;
                        int i17 = ((-1) >>> (32 - i3)) & (i11 | ((bArr4[i16] & 255) >> (8 - i12)));
                        if (i12 == 8) {
                            this.f1946e = 0;
                            if (!m(i16 + 1)) {
                                i13 = 1;
                            }
                            this.d = i16 + i13;
                        }
                        a();
                        return i17;
                    }
                }
            default:
                int i18 = this.d;
                int min = Math.min(i3, 8 - this.f1946e);
                int i19 = i18 + 1;
                byte[] bArr5 = this.b;
                int i20 = ((bArr5[i18] & 255) >> this.f1946e) & (255 >> (8 - min));
                while (min < i3) {
                    i20 |= (bArr5[i19] & 255) << min;
                    min += 8;
                    i19++;
                }
                int i21 = i20 & ((-1) >>> (32 - i3));
                o(i3);
                return i21;
        }
    }

    public void h(byte[] bArr, int i3) {
        int i5 = i3 >> 3;
        for (int i6 = 0; i6 < i5; i6++) {
            byte[] bArr2 = this.b;
            int i7 = this.c;
            int i8 = i7 + 1;
            this.c = i8;
            byte b = bArr2[i7];
            int i9 = this.d;
            byte b5 = (byte) (b << i9);
            bArr[i6] = b5;
            bArr[i6] = (byte) (((255 & bArr2[i8]) >> (8 - i9)) | b5);
        }
        int i10 = i3 & 7;
        if (i10 == 0) {
            return;
        }
        byte b6 = (byte) (bArr[i5] & (255 >> i10));
        bArr[i5] = b6;
        int i11 = this.d;
        if (i11 + i10 > 8) {
            byte[] bArr3 = this.b;
            int i12 = this.c;
            this.c = i12 + 1;
            bArr[i5] = (byte) (b6 | ((bArr3[i12] & 255) << i11));
            this.d = i11 - 8;
        }
        int i13 = this.d + i10;
        this.d = i13;
        byte[] bArr4 = this.b;
        int i14 = this.c;
        bArr[i5] = (byte) (((byte) (((255 & bArr4[i14]) >> (8 - i13)) << (8 - i10))) | bArr[i5]);
        if (i13 == 8) {
            this.d = 0;
            this.c = i14 + 1;
        }
        a();
    }

    public int i() {
        int i3 = 0;
        int i5 = 0;
        while (!f()) {
            i5++;
        }
        int i6 = (1 << i5) - 1;
        if (i5 > 0) {
            i3 = g(i5);
        }
        return i6 + i3;
    }

    public int j() {
        int i3;
        int i5 = i();
        if (i5 % 2 == 0) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        return ((i5 + 1) / 2) * i3;
    }

    public void k(byte[] bArr, int i3) {
        this.b = bArr;
        this.c = 0;
        this.d = 0;
        this.f1946e = i3;
    }

    public void l(int i3) {
        int i5 = i3 / 8;
        this.c = i5;
        this.d = i3 - (i5 * 8);
        a();
    }

    public boolean m(int i3) {
        if (2 <= i3 && i3 < this.c) {
            byte[] bArr = this.b;
            if (bArr[i3] == 3 && bArr[i3 - 2] == 0 && bArr[i3 - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    public void n() {
        switch (this.f1945a) {
            case 0:
                int i3 = this.d + 1;
                this.d = i3;
                if (i3 == 8) {
                    this.d = 0;
                    this.c++;
                }
                a();
                return;
            default:
                int i5 = 1;
                int i6 = this.f1946e + 1;
                this.f1946e = i6;
                if (i6 == 8) {
                    this.f1946e = 0;
                    int i7 = this.d;
                    if (m(i7 + 1)) {
                        i5 = 2;
                    }
                    this.d = i7 + i5;
                }
                a();
                return;
        }
    }

    public void o(int i3) {
        int i5;
        switch (this.f1945a) {
            case 0:
                int i6 = i3 / 8;
                int i7 = this.c + i6;
                this.c = i7;
                int i8 = (i3 - (i6 * 8)) + this.d;
                this.d = i8;
                if (i8 > 7) {
                    this.c = i7 + 1;
                    this.d = i8 - 8;
                }
                a();
                return;
            case 1:
                int i9 = this.d;
                int i10 = i3 / 8;
                int i11 = i9 + i10;
                this.d = i11;
                int i12 = (i3 - (i10 * 8)) + this.f1946e;
                this.f1946e = i12;
                if (i12 > 7) {
                    this.d = i11 + 1;
                    this.f1946e = i12 - 8;
                }
                while (true) {
                    i9++;
                    if (i9 <= this.d) {
                        if (m(i9)) {
                            this.d++;
                            i9 += 2;
                        }
                    } else {
                        a();
                        return;
                    }
                }
            default:
                int i13 = i3 / 8;
                int i14 = this.d + i13;
                this.d = i14;
                int i15 = (i3 - (i13 * 8)) + this.f1946e;
                this.f1946e = i15;
                boolean z3 = true;
                if (i15 > 7) {
                    this.d = i14 + 1;
                    this.f1946e = i15 - 8;
                }
                int i16 = this.d;
                if (i16 < 0 || (i16 >= (i5 = this.c) && (i16 != i5 || this.f1946e != 0))) {
                    z3 = false;
                }
                b.h(z3);
                return;
        }
    }

    public n(byte[] bArr) {
        this.f1945a = 2;
        this.b = bArr;
        this.c = bArr.length;
    }

    public n(byte[] bArr, int i3, int i5) {
        this.f1945a = 1;
        this.b = bArr;
        this.d = i3;
        this.c = i5;
        this.f1946e = 0;
        a();
    }

    public n(byte[] bArr, int i3) {
        this.f1945a = 0;
        this.b = bArr;
        this.f1946e = i3;
    }

    public n(int i3, int i5) {
        this.f1945a = 3;
        this.c = i3;
        this.d = i5;
        this.b = new byte[(i5 * 2) - 1];
        this.f1946e = 0;
    }
}
