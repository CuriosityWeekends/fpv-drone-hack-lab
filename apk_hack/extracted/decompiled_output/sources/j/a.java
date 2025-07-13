package j;

import c0.n;
import g2.w;
import j0.l0;
import j0.t0;
import java.util.ArrayDeque;
import m.b0;
import m.q;
import m.r;
import m.y;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class a implements l0, r {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2183a;

    public int A() {
        long i3 = i();
        long duration = getDuration();
        if (i3 == -9223372036854775807L || duration == -9223372036854775807L) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return w.h((int) ((i3 * 100) / duration), 0, 100);
    }

    public boolean B() {
        if (getPlaybackState() == 3 && j() && p() == 0) {
            return true;
        }
        return false;
    }

    public void C(j jVar) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f2183a;
        if (arrayDeque.size() < 20) {
            arrayDeque.offer(jVar);
        }
    }

    @Override // m.r
    public q n(y yVar) {
        return new m.c(2, (b0) this.f2183a);
    }

    public a(int i3) {
        switch (i3) {
            case 1:
                this.f2183a = new t0();
                return;
            default:
                char[] cArr = n.f199a;
                this.f2183a = new ArrayDeque(20);
                return;
        }
    }
}
