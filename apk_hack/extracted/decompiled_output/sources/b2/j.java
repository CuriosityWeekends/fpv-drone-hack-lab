package b2;

import com.google.android.exoplayer2.source.TrackGroup;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j extends d {

    /* renamed from: g  reason: collision with root package name */
    public final int f158g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f159h;

    public j(TrackGroup trackGroup, int i3, int i5, Integer num) {
        super(trackGroup, i3);
        this.f158g = i5;
        this.f159h = num;
    }

    @Override // b2.n
    public final int b() {
        return this.f158g;
    }

    @Override // b2.n
    public final int c() {
        return 0;
    }

    @Override // b2.n
    public final Object f() {
        return this.f159h;
    }

    @Override // b2.n
    public final void d(long j2, long j5) {
    }
}
