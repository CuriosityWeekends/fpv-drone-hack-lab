package o1;

import android.os.SystemClock;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e extends b2.d {

    /* renamed from: g  reason: collision with root package name */
    public int f2960g;

    @Override // b2.n
    public final int b() {
        return 0;
    }

    @Override // b2.n
    public final int c() {
        return this.f2960g;
    }

    @Override // b2.n
    public final void d(long j2, long j5) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!k(this.f2960g, elapsedRealtime)) {
            return;
        }
        for (int i3 = this.b - 1; i3 >= 0; i3--) {
            if (!k(i3, elapsedRealtime)) {
                this.f2960g = i3;
                return;
            }
        }
        throw new IllegalStateException();
    }

    @Override // b2.n
    public final Object f() {
        return null;
    }
}
