package l0;

import android.media.AudioTrack;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final m f2540a;
    public int b;
    public long c;
    public long d;

    /* renamed from: e  reason: collision with root package name */
    public long f2541e;

    /* renamed from: f  reason: collision with root package name */
    public long f2542f;

    public n(AudioTrack audioTrack) {
        if (g2.w.f1960a >= 19) {
            this.f2540a = new m(audioTrack);
            a();
            return;
        }
        this.f2540a = null;
        b(3);
    }

    public final void a() {
        if (this.f2540a != null) {
            b(0);
        }
    }

    public final void b(int i3) {
        this.b = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2 && i3 != 3) {
                    if (i3 == 4) {
                        this.d = 500000L;
                        return;
                    }
                    throw new IllegalStateException();
                }
                this.d = 10000000L;
                return;
            }
            this.d = 5000L;
            return;
        }
        this.f2541e = 0L;
        this.f2542f = -1L;
        this.c = System.nanoTime() / 1000;
        this.d = 5000L;
    }
}
