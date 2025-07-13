package w0;

import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final f f3914a = new f();
    public final c0.b b = new c0.b(new byte[65025], 0);
    public int c = -1;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3915e;

    public final int a(int i3) {
        int i5;
        int i6 = 0;
        this.d = 0;
        do {
            int i7 = this.d;
            int i8 = i3 + i7;
            f fVar = this.f3914a;
            if (i8 >= fVar.c) {
                break;
            }
            int[] iArr = fVar.f3918f;
            this.d = i7 + 1;
            i5 = iArr[i7 + i3];
            i6 += i5;
        } while (i5 == 255);
        return i6;
    }

    public final boolean b(p0.g gVar) {
        int i3;
        boolean z3 = this.f3915e;
        c0.b bVar = this.b;
        if (z3) {
            this.f3915e = false;
            bVar.u();
        }
        while (true) {
            boolean z5 = true;
            if (this.f3915e) {
                return true;
            }
            int i5 = this.c;
            f fVar = this.f3914a;
            if (i5 < 0) {
                if (!fVar.a(gVar, true)) {
                    return false;
                }
                int i6 = fVar.d;
                if ((fVar.f3916a & 1) == 1 && bVar.c == 0) {
                    i6 += a(0);
                    i3 = this.d;
                } else {
                    i3 = 0;
                }
                gVar.h(i6);
                this.c = i3;
            }
            int a5 = a(this.c);
            int i7 = this.c + this.d;
            if (a5 > 0) {
                byte[] bArr = bVar.f187a;
                int length = bArr.length;
                int i8 = bVar.c + a5;
                if (length < i8) {
                    bVar.f187a = Arrays.copyOf(bArr, i8);
                }
                gVar.g(bVar.f187a, bVar.c, a5, false);
                bVar.x(bVar.c + a5);
                if (fVar.f3918f[i7 - 1] == 255) {
                    z5 = false;
                }
                this.f3915e = z5;
            }
            if (i7 == fVar.c) {
                i7 = -1;
            }
            this.c = i7;
        }
    }
}
