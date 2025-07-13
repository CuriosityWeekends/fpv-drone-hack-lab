package p0;

import g2.w;
import java.io.EOFException;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g {
    public final e2.i b;
    public final long c;
    public long d;

    /* renamed from: f  reason: collision with root package name */
    public int f3111f;

    /* renamed from: g  reason: collision with root package name */
    public int f3112g;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f3110e = new byte[65536];

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f3109a = new byte[4096];

    public g(e2.i iVar, long j2, long j5) {
        this.b = iVar;
        this.d = j2;
        this.c = j5;
    }

    public final boolean a(int i3, boolean z3) {
        b(i3);
        int i5 = this.f3112g - this.f3111f;
        while (i5 < i3) {
            i5 = f(this.f3110e, this.f3111f, z3, i3, i5);
            if (i5 == -1) {
                return false;
            }
            this.f3112g = this.f3111f + i5;
        }
        this.f3111f += i3;
        return true;
    }

    public final void b(int i3) {
        int i5 = this.f3111f + i3;
        byte[] bArr = this.f3110e;
        if (i5 > bArr.length) {
            this.f3110e = Arrays.copyOf(this.f3110e, w.h(bArr.length * 2, 65536 + i5, i5 + 524288));
        }
    }

    public final long c() {
        return this.d + this.f3111f;
    }

    public final boolean d(byte[] bArr, int i3, int i5, boolean z3) {
        if (!a(i5, z3)) {
            return false;
        }
        System.arraycopy(this.f3110e, this.f3111f - i5, bArr, i3, i5);
        return true;
    }

    public final int e(byte[] bArr, int i3, int i5) {
        int i6 = this.f3112g;
        int i7 = 0;
        if (i6 != 0) {
            int min = Math.min(i6, i5);
            System.arraycopy(this.f3110e, 0, bArr, i3, min);
            i(min);
            i7 = min;
        }
        if (i7 == 0) {
            i7 = f(bArr, i3, true, i5, 0);
        }
        if (i7 != -1) {
            this.d += i7;
        }
        return i7;
    }

    public final int f(byte[] bArr, int i3, boolean z3, int i5, int i6) {
        if (!Thread.interrupted()) {
            int read = this.b.read(bArr, i3 + i6, i5 - i6);
            if (read == -1) {
                if (i6 == 0 && z3) {
                    return -1;
                }
                throw new EOFException();
            }
            return i6 + read;
        }
        throw new InterruptedException();
    }

    public final boolean g(byte[] bArr, int i3, int i5, boolean z3) {
        int min;
        int i6 = this.f3112g;
        if (i6 == 0) {
            min = 0;
        } else {
            min = Math.min(i6, i5);
            System.arraycopy(this.f3110e, 0, bArr, i3, min);
            i(min);
        }
        int i7 = min;
        while (i7 < i5 && i7 != -1) {
            i7 = f(bArr, i3, z3, i5, i7);
        }
        if (i7 != -1) {
            this.d += i7;
        }
        if (i7 == -1) {
            return false;
        }
        return true;
    }

    public final void h(int i3) {
        int min = Math.min(this.f3112g, i3);
        i(min);
        int i5 = min;
        while (i5 < i3 && i5 != -1) {
            i5 = f(this.f3109a, -i5, false, Math.min(i3, this.f3109a.length + i5), i5);
        }
        if (i5 != -1) {
            this.d += i5;
        }
    }

    public final void i(int i3) {
        byte[] bArr;
        int i5 = this.f3112g - i3;
        this.f3112g = i5;
        this.f3111f = 0;
        byte[] bArr2 = this.f3110e;
        if (i5 < bArr2.length - 524288) {
            bArr = new byte[65536 + i5];
        } else {
            bArr = bArr2;
        }
        System.arraycopy(bArr2, i3, bArr, 0, i5);
        this.f3110e = bArr;
    }
}
