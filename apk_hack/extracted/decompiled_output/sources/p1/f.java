package p1;

import com.google.android.exoplayer2.drm.DrmInitData;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    public final String f3167a;
    public final f b;
    public final long c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final long f3168e;

    /* renamed from: f  reason: collision with root package name */
    public final DrmInitData f3169f;

    /* renamed from: g  reason: collision with root package name */
    public final String f3170g;

    /* renamed from: h  reason: collision with root package name */
    public final String f3171h;

    /* renamed from: i  reason: collision with root package name */
    public final long f3172i;

    /* renamed from: j  reason: collision with root package name */
    public final long f3173j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f3174k;

    public f(String str, f fVar, long j2, int i3, long j5, DrmInitData drmInitData, String str2, String str3, long j6, long j7, boolean z3) {
        this.f3167a = str;
        this.b = fVar;
        this.c = j2;
        this.d = i3;
        this.f3168e = j5;
        this.f3169f = drmInitData;
        this.f3170g = str2;
        this.f3171h = str3;
        this.f3172i = j6;
        this.f3173j = j7;
        this.f3174k = z3;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        Long l5 = (Long) obj;
        long longValue = l5.longValue();
        long j2 = this.f3168e;
        if (j2 > longValue) {
            return 1;
        }
        if (j2 < l5.longValue()) {
            return -1;
        }
        return 0;
    }
}
