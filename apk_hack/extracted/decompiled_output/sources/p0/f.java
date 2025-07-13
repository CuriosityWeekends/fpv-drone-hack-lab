package p0;

import g2.w;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements r {

    /* renamed from: a  reason: collision with root package name */
    public final int f3106a;
    public final int[] b;
    public final long[] c;
    public final long[] d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f3107e;

    /* renamed from: f  reason: collision with root package name */
    public final long f3108f;

    public f(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.f3107e = jArr3;
        int length = iArr.length;
        this.f3106a = length;
        if (length > 0) {
            this.f3108f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f3108f = 0L;
        }
    }

    @Override // p0.r
    public final boolean e() {
        return true;
    }

    @Override // p0.r
    public final q g(long j2) {
        long[] jArr = this.f3107e;
        int d = w.d(jArr, j2, true);
        long j5 = jArr[d];
        long[] jArr2 = this.c;
        s sVar = new s(j5, jArr2[d]);
        if (j5 < j2 && d != this.f3106a - 1) {
            int i3 = d + 1;
            return new q(sVar, new s(jArr[i3], jArr2[i3]));
        }
        return new q(sVar, sVar);
    }

    @Override // p0.r
    public final long i() {
        return this.f3108f;
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.f3106a + ", sizes=" + Arrays.toString(this.b) + ", offsets=" + Arrays.toString(this.c) + ", timeUs=" + Arrays.toString(this.f3107e) + ", durationsUs=" + Arrays.toString(this.d) + ")";
    }
}
