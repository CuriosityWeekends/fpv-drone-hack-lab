package v0;

import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public final p f3873a;
    public final int b;
    public final long[] c;
    public final int[] d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3874e;

    /* renamed from: f  reason: collision with root package name */
    public final long[] f3875f;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f3876g;

    /* renamed from: h  reason: collision with root package name */
    public final long f3877h;

    public s(p pVar, long[] jArr, int[] iArr, int i3, long[] jArr2, int[] iArr2, long j2) {
        boolean z3;
        boolean z5;
        if (iArr.length == jArr2.length) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.e(z3);
        if (jArr.length == jArr2.length) {
            z5 = true;
        } else {
            z5 = false;
        }
        g2.b.e(z5);
        g2.b.e(iArr2.length == jArr2.length);
        this.f3873a = pVar;
        this.c = jArr;
        this.d = iArr;
        this.f3874e = i3;
        this.f3875f = jArr2;
        this.f3876g = iArr2;
        this.f3877h = j2;
        this.b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public final int a(long j2) {
        long[] jArr = this.f3875f;
        for (int b = w.b(jArr, j2, true, false); b < jArr.length; b++) {
            if ((this.f3876g[b] & 1) != 0) {
                return b;
            }
        }
        return -1;
    }
}
