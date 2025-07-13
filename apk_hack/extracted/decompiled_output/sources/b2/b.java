package b2;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import e2.q;
import g2.t;
import g2.w;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends d {

    /* renamed from: g  reason: collision with root package name */
    public final a f128g;

    /* renamed from: h  reason: collision with root package name */
    public final long f129h;

    /* renamed from: i  reason: collision with root package name */
    public final long f130i;

    /* renamed from: j  reason: collision with root package name */
    public final long f131j;

    /* renamed from: k  reason: collision with root package name */
    public final float f132k;

    /* renamed from: l  reason: collision with root package name */
    public final long f133l;

    /* renamed from: m  reason: collision with root package name */
    public final t f134m;

    /* renamed from: n  reason: collision with root package name */
    public float f135n;

    /* renamed from: o  reason: collision with root package name */
    public int f136o;

    /* renamed from: p  reason: collision with root package name */
    public int f137p;
    public long q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TrackGroup trackGroup, int[] iArr, a aVar, long j2, long j5, long j6) {
        super(trackGroup, iArr);
        t tVar = t.f1957a;
        this.f128g = aVar;
        this.f129h = j2 * 1000;
        this.f130i = j5 * 1000;
        this.f131j = j6 * 1000;
        this.f132k = 0.75f;
        this.f133l = 2000L;
        this.f134m = tVar;
        this.f135n = 1.0f;
        this.f137p = 0;
        this.q = -9223372036854775807L;
    }

    public static void m(long[][][] jArr, int i3, long[][] jArr2, int[] iArr) {
        long j2 = 0;
        for (int i5 = 0; i5 < jArr.length; i5++) {
            long[] jArr3 = jArr[i5][i3];
            long j5 = jArr2[i5][iArr[i5]];
            jArr3[1] = j5;
            j2 += j5;
        }
        for (long[][] jArr4 : jArr) {
            jArr4[i3][0] = j2;
        }
    }

    @Override // b2.d, b2.n
    public final void a() {
        this.q = -9223372036854775807L;
    }

    @Override // b2.n
    public final int b() {
        return this.f137p;
    }

    @Override // b2.n
    public final int c() {
        return this.f136o;
    }

    @Override // b2.n
    public final void d(long j2, long j5) {
        this.f134m.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f137p == 0) {
            this.f137p = 1;
            this.f136o = l(elapsedRealtime);
            return;
        }
        int i3 = this.f136o;
        int l5 = l(elapsedRealtime);
        this.f136o = l5;
        if (l5 == i3) {
            return;
        }
        if (!k(i3, elapsedRealtime)) {
            Format[] formatArr = this.d;
            Format format = formatArr[i3];
            int i5 = formatArr[this.f136o].f307e;
            int i6 = format.f307e;
            if (i5 > i6) {
                long j6 = this.f129h;
                if (j5 != -9223372036854775807L && j5 <= j6) {
                    j6 = ((float) j5) * this.f132k;
                }
                if (j2 < j6) {
                    this.f136o = i3;
                }
            }
            if (i5 < i6 && j2 >= this.f130i) {
                this.f136o = i3;
            }
        }
        if (this.f136o != i3) {
            this.f137p = 3;
        }
    }

    @Override // b2.d, b2.n
    public final void e(float f4) {
        this.f135n = f4;
    }

    @Override // b2.n
    public final Object f() {
        return null;
    }

    @Override // b2.d, b2.n
    public final int g(List list, long j2) {
        int i3;
        int i5;
        this.f134m.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = this.q;
        if (j5 != -9223372036854775807L && elapsedRealtime - j5 < this.f133l) {
            return list.size();
        }
        this.q = elapsedRealtime;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long j6 = ((l1.k) list.get(size - 1)).f2639f - j2;
        float f4 = this.f135n;
        int i6 = w.f1960a;
        if (f4 != 1.0f) {
            j6 = Math.round(j6 / f4);
        }
        long j7 = this.f131j;
        if (j6 < j7) {
            return size;
        }
        Format format = this.d[l(elapsedRealtime)];
        for (int i7 = 0; i7 < size; i7++) {
            l1.k kVar = (l1.k) list.get(i7);
            Format format2 = kVar.c;
            long j8 = kVar.f2639f - j2;
            float f5 = this.f135n;
            if (f5 != 1.0f) {
                j8 = Math.round(j8 / f5);
            }
            if (j8 >= j7 && format2.f307e < format.f307e && (i3 = format2.f317o) != -1 && i3 < 720 && (i5 = format2.f316n) != -1 && i5 < 1280 && i3 < format.f317o) {
                return i7;
            }
        }
        return size;
    }

    public final int l(long j2) {
        long j5;
        long[][] jArr;
        a aVar = this.f128g;
        q qVar = (q) aVar.f127a;
        synchronized (qVar) {
            j5 = qVar.f1728l;
        }
        long max = Math.max(0L, (((float) j5) * aVar.b) - aVar.c);
        if (aVar.d != null) {
            int i3 = 1;
            while (true) {
                jArr = aVar.d;
                if (i3 >= jArr.length - 1 || jArr[i3][0] >= max) {
                    break;
                }
                i3++;
            }
            long[] jArr2 = jArr[i3 - 1];
            long[] jArr3 = jArr[i3];
            long j6 = jArr2[0];
            long j7 = jArr2[1];
            max = j7 + ((((float) (max - j6)) / ((float) (jArr3[0] - j6))) * ((float) (jArr3[1] - j7)));
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.b; i6++) {
            if (j2 == Long.MIN_VALUE || !k(i6, j2)) {
                if (Math.round(this.d[i6].f307e * this.f135n) <= max) {
                    return i6;
                }
                i5 = i6;
            }
        }
        return i5;
    }
}
