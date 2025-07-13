package b2;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import g2.w;
import java.util.Arrays;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class d implements n {

    /* renamed from: a  reason: collision with root package name */
    public final TrackGroup f139a;
    public final int b;
    public final int[] c;
    public final Format[] d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f140e;

    /* renamed from: f  reason: collision with root package name */
    public int f141f;

    public d(TrackGroup trackGroup, int... iArr) {
        boolean z3;
        int i3 = 0;
        if (iArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.h(z3);
        trackGroup.getClass();
        this.f139a = trackGroup;
        int length = iArr.length;
        this.b = length;
        this.d = new Format[length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            this.d[i5] = trackGroup.b[iArr[i5]];
        }
        Arrays.sort(this.d, new c(0));
        this.c = new int[this.b];
        while (true) {
            int i6 = this.b;
            if (i3 < i6) {
                this.c[i3] = trackGroup.c(this.d[i3]);
                i3++;
            } else {
                this.f140e = new long[i6];
                return;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f139a == dVar.f139a && Arrays.equals(this.c, dVar.c)) {
            return true;
        }
        return false;
    }

    @Override // b2.n
    public int g(List list, long j2) {
        return list.size();
    }

    public final boolean h(int i3, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean k5 = k(i3, elapsedRealtime);
        for (int i5 = 0; i5 < this.b && !k5; i5++) {
            if (i5 != i3 && !k(i5, elapsedRealtime)) {
                k5 = true;
            } else {
                k5 = false;
            }
        }
        if (!k5) {
            return false;
        }
        long[] jArr = this.f140e;
        long j5 = jArr[i3];
        int i6 = w.f1960a;
        long j6 = elapsedRealtime + j2;
        if (((j2 ^ j6) & (elapsedRealtime ^ j6)) < 0) {
            j6 = Long.MAX_VALUE;
        }
        jArr[i3] = Math.max(j5, j6);
        return true;
    }

    public final int hashCode() {
        if (this.f141f == 0) {
            this.f141f = Arrays.hashCode(this.c) + (System.identityHashCode(this.f139a) * 31);
        }
        return this.f141f;
    }

    public final int i(int i3) {
        for (int i5 = 0; i5 < this.b; i5++) {
            if (this.c[i5] == i3) {
                return i5;
            }
        }
        return -1;
    }

    public final int j(Format format) {
        for (int i3 = 0; i3 < this.b; i3++) {
            if (this.d[i3] == format) {
                return i3;
            }
        }
        return -1;
    }

    public final boolean k(int i3, long j2) {
        if (this.f140e[i3] > j2) {
            return true;
        }
        return false;
    }

    @Override // b2.n
    public void a() {
    }

    @Override // b2.n
    public void e(float f4) {
    }
}
