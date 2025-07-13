package t0;

import p0.g;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f {
    public static final long[] d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f3626a = new byte[8];
    public int b;
    public int c;

    public static long a(byte[] bArr, int i3, boolean z3) {
        long j2 = bArr[0] & 255;
        if (z3) {
            j2 &= ~d[i3 - 1];
        }
        for (int i5 = 1; i5 < i3; i5++) {
            j2 = (j2 << 8) | (bArr[i5] & 255);
        }
        return j2;
    }

    public static int b(int i3) {
        for (int i5 = 0; i5 < 8; i5++) {
            if ((d[i5] & i3) != 0) {
                return i5 + 1;
            }
        }
        return -1;
    }

    public final long c(g gVar, boolean z3, boolean z5, int i3) {
        int i5 = this.b;
        byte[] bArr = this.f3626a;
        if (i5 == 0) {
            if (!gVar.g(bArr, 0, 1, z3)) {
                return -1L;
            }
            int b = b(bArr[0] & 255);
            this.c = b;
            if (b != -1) {
                this.b = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i6 = this.c;
        if (i6 > i3) {
            this.b = 0;
            return -2L;
        }
        if (i6 != 1) {
            gVar.g(bArr, 1, i6 - 1, false);
        }
        this.b = 0;
        return a(bArr, this.c, z5);
    }
}
