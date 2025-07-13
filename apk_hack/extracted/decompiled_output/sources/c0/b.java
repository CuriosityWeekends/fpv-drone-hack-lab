package c0;

import g2.w;
import java.nio.charset.Charset;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f187a;
    public int b;
    public int c;

    public b() {
        this.f187a = w.f1962f;
    }

    public int a() {
        return this.c - this.b;
    }

    public void b(byte[] bArr, int i3, int i5) {
        System.arraycopy(this.f187a, this.b, bArr, i3, i5);
        this.b += i5;
    }

    public int c() {
        byte[] bArr = this.f187a;
        int i3 = this.b;
        int i5 = ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3] & 255) << 24);
        this.b = i3 + 4;
        return (bArr[i3 + 3] & 255) | i5 | ((bArr[i3 + 2] & 255) << 8);
    }

    public String d() {
        if (a() == 0) {
            return null;
        }
        int i3 = this.b;
        while (i3 < this.c) {
            byte b = this.f187a[i3];
            int i5 = w.f1960a;
            if (b == 10 || b == 13) {
                break;
            }
            i3++;
        }
        int i6 = this.b;
        if (i3 - i6 >= 3) {
            byte[] bArr = this.f187a;
            if (bArr[i6] == -17 && bArr[i6 + 1] == -69 && bArr[i6 + 2] == -65) {
                this.b = i6 + 3;
            }
        }
        byte[] bArr2 = this.f187a;
        int i7 = this.b;
        String k5 = w.k(bArr2, i7, i3 - i7);
        this.b = i3;
        int i8 = this.c;
        if (i3 == i8) {
            return k5;
        }
        byte[] bArr3 = this.f187a;
        if (bArr3[i3] == 13) {
            int i9 = i3 + 1;
            this.b = i9;
            if (i9 == i8) {
                return k5;
            }
        }
        int i10 = this.b;
        if (bArr3[i10] == 10) {
            this.b = i10 + 1;
        }
        return k5;
    }

    public int e() {
        byte[] bArr = this.f187a;
        int i3 = this.b;
        int i5 = ((bArr[i3 + 1] & 255) << 8) | (bArr[i3] & 255);
        this.b = i3 + 4;
        return ((bArr[i3 + 3] & 255) << 24) | i5 | ((bArr[i3 + 2] & 255) << 16);
    }

    public long f() {
        byte[] bArr = this.f187a;
        int i3 = this.b;
        this.b = i3 + 4;
        return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
    }

    public int g() {
        byte[] bArr = this.f187a;
        int i3 = this.b;
        this.b = i3 + 2;
        return ((bArr[i3 + 1] & 255) << 8) | (bArr[i3] & 255);
    }

    public long h() {
        byte[] bArr = this.f187a;
        int i3 = this.b;
        long j2 = ((bArr[i3] & 255) << 56) | ((bArr[i3 + 1] & 255) << 48) | ((bArr[i3 + 2] & 255) << 40) | ((bArr[i3 + 3] & 255) << 32) | ((bArr[i3 + 4] & 255) << 24);
        this.b = i3 + 8;
        return (bArr[i3 + 7] & 255) | j2 | ((bArr[i3 + 5] & 255) << 16) | ((bArr[i3 + 6] & 255) << 8);
    }

    public String i() {
        if (a() == 0) {
            return null;
        }
        int i3 = this.b;
        while (i3 < this.c && this.f187a[i3] != 0) {
            i3++;
        }
        byte[] bArr = this.f187a;
        int i5 = this.b;
        String k5 = w.k(bArr, i5, i3 - i5);
        this.b = i3;
        if (i3 < this.c) {
            this.b = i3 + 1;
        }
        return k5;
    }

    public String j(int i3) {
        int i5;
        if (i3 == 0) {
            return "";
        }
        int i6 = this.b;
        int i7 = (i6 + i3) - 1;
        if (i7 < this.c && this.f187a[i7] == 0) {
            i5 = i3 - 1;
        } else {
            i5 = i3;
        }
        String k5 = w.k(this.f187a, i6, i5);
        this.b += i3;
        return k5;
    }

    public String k(int i3) {
        return l(i3, Charset.forName("UTF-8"));
    }

    public String l(int i3, Charset charset) {
        String str = new String(this.f187a, this.b, i3, charset);
        this.b += i3;
        return str;
    }

    public int m() {
        return (n() << 21) | (n() << 14) | (n() << 7) | n();
    }

    public int n() {
        byte[] bArr = this.f187a;
        int i3 = this.b;
        this.b = i3 + 1;
        return bArr[i3] & 255;
    }

    public long o() {
        byte[] bArr = this.f187a;
        int i3 = this.b;
        this.b = i3 + 4;
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    public int p() {
        byte[] bArr = this.f187a;
        int i3 = this.b;
        int i5 = (bArr[i3 + 1] & 255) << 8;
        this.b = i3 + 3;
        return (bArr[i3 + 2] & 255) | i5 | ((bArr[i3] & 255) << 16);
    }

    public int q() {
        int c = c();
        if (c >= 0) {
            return c;
        }
        throw new IllegalStateException(a1.i.e(c, "Top bit not zero: "));
    }

    public long r() {
        long h5 = h();
        if (h5 >= 0) {
            return h5;
        }
        throw new IllegalStateException("Top bit not zero: " + h5);
    }

    public int s() {
        byte[] bArr = this.f187a;
        int i3 = this.b;
        this.b = i3 + 2;
        return (bArr[i3 + 1] & 255) | ((bArr[i3] & 255) << 8);
    }

    public long t() {
        int i3;
        int i5;
        byte b;
        int i6;
        long j2 = this.f187a[this.b];
        int i7 = 7;
        while (true) {
            if (i7 < 0) {
                break;
            }
            if (((1 << i7) & j2) != 0) {
                i7--;
            } else if (i7 < 6) {
                j2 &= i6 - 1;
                i5 = 7 - i7;
            } else if (i7 == 7) {
                i5 = 1;
            }
        }
        i5 = 0;
        if (i5 != 0) {
            for (i3 = 1; i3 < i5; i3++) {
                if ((this.f187a[this.b + i3] & 192) == 128) {
                    j2 = (j2 << 6) | (b & 63);
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j2);
                }
            }
            this.b += i5;
            return j2;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j2);
    }

    public void u() {
        this.b = 0;
        this.c = 0;
    }

    public void v(int i3) {
        byte[] bArr = this.f187a;
        if (bArr.length < i3) {
            bArr = new byte[i3];
        }
        w(bArr, i3);
    }

    public void w(byte[] bArr, int i3) {
        this.f187a = bArr;
        this.c = i3;
        this.b = 0;
    }

    public void x(int i3) {
        boolean z3;
        if (i3 >= 0 && i3 <= this.f187a.length) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.e(z3);
        this.c = i3;
    }

    public void y(int i3) {
        boolean z3;
        if (i3 >= 0 && i3 <= this.c) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.e(z3);
        this.b = i3;
    }

    public void z(int i3) {
        y(this.b + i3);
    }

    public b(int i3) {
        this.f187a = new byte[i3];
        this.c = i3;
    }

    public b(byte[] bArr) {
        this.f187a = bArr;
        this.c = bArr.length;
    }

    public b(byte[] bArr, int i3) {
        this.f187a = bArr;
        this.c = i3;
    }
}
