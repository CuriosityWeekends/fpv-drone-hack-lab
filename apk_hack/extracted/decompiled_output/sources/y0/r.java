package y0;

import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final int f4189a;
    public boolean b;
    public boolean c;
    public byte[] d;

    /* renamed from: e  reason: collision with root package name */
    public int f4190e;

    public r(int i3) {
        this.f4189a = i3;
        byte[] bArr = new byte[131];
        this.d = bArr;
        bArr[2] = 1;
    }

    public final void a(byte[] bArr, int i3, int i5) {
        if (!this.b) {
            return;
        }
        int i6 = i5 - i3;
        byte[] bArr2 = this.d;
        int length = bArr2.length;
        int i7 = this.f4190e;
        if (length < i7 + i6) {
            this.d = Arrays.copyOf(bArr2, (i7 + i6) * 2);
        }
        System.arraycopy(bArr, i3, this.d, this.f4190e, i6);
        this.f4190e += i6;
    }

    public final boolean b(int i3) {
        if (!this.b) {
            return false;
        }
        this.f4190e -= i3;
        this.b = false;
        this.c = true;
        return true;
    }

    public final void c() {
        this.b = false;
        this.c = false;
    }

    public final void d(int i3) {
        boolean z3 = true;
        g2.b.h(!this.b);
        if (i3 != this.f4189a) {
            z3 = false;
        }
        this.b = z3;
        if (z3) {
            this.f4190e = 3;
            this.c = false;
        }
    }
}
