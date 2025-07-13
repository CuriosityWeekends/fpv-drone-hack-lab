package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r extends s {
    @Override // pl.droidsonroids.gif.s
    public final void a() {
        c cVar = this.f3310a;
        long p5 = cVar.f3285g.p(cVar.f3284f);
        if (p5 >= 0) {
            this.f3310a.c = SystemClock.uptimeMillis() + p5;
            if (this.f3310a.isVisible() && this.f3310a.b) {
                c cVar2 = this.f3310a;
                if (!cVar2.f3290l) {
                    cVar2.f3282a.remove(this);
                    c cVar3 = this.f3310a;
                    cVar3.f3294p = cVar3.f3282a.schedule(this, p5, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.f3310a.f3286h.isEmpty() && this.f3310a.f3285g.b() == this.f3310a.f3285g.i() - 1) {
                c cVar4 = this.f3310a;
                j0.s sVar = cVar4.f3291m;
                GifInfoHandle gifInfoHandle = cVar4.f3285g;
                int c = gifInfoHandle.c();
                if (c != 0 && c >= gifInfoHandle.g()) {
                    c--;
                }
                sVar.sendEmptyMessageAtTime(c, this.f3310a.c);
            }
        } else {
            c cVar5 = this.f3310a;
            cVar5.c = Long.MIN_VALUE;
            cVar5.b = false;
        }
        if (this.f3310a.isVisible() && !this.f3310a.f3291m.hasMessages(-1)) {
            this.f3310a.f3291m.sendEmptyMessageAtTime(-1, 0L);
        }
    }
}
