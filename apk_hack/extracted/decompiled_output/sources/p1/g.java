package p1;

import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g extends h {
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final long f3175e;

    /* renamed from: f  reason: collision with root package name */
    public final long f3176f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3177g;

    /* renamed from: h  reason: collision with root package name */
    public final int f3178h;

    /* renamed from: i  reason: collision with root package name */
    public final long f3179i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3180j;

    /* renamed from: k  reason: collision with root package name */
    public final long f3181k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f3182l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f3183m;

    /* renamed from: n  reason: collision with root package name */
    public final DrmInitData f3184n;

    /* renamed from: o  reason: collision with root package name */
    public final List f3185o;

    /* renamed from: p  reason: collision with root package name */
    public final long f3186p;

    public g(int i3, String str, List list, long j2, long j5, boolean z3, int i5, long j6, int i6, long j7, boolean z5, boolean z6, boolean z7, DrmInitData drmInitData, List list2) {
        super(str, list, z5);
        long j8;
        this.d = i3;
        this.f3176f = j5;
        this.f3177g = z3;
        this.f3178h = i5;
        this.f3179i = j6;
        this.f3180j = i6;
        this.f3181k = j7;
        this.f3182l = z6;
        this.f3183m = z7;
        this.f3184n = drmInitData;
        this.f3185o = Collections.unmodifiableList(list2);
        if (!list2.isEmpty()) {
            f fVar = (f) list2.get(list2.size() - 1);
            this.f3186p = fVar.f3168e + fVar.c;
        } else {
            this.f3186p = 0L;
        }
        if (j2 == -9223372036854775807L) {
            j8 = -9223372036854775807L;
        } else {
            j8 = j2 >= 0 ? j2 : this.f3186p + j2;
        }
        this.f3175e = j8;
    }
}
