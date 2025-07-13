package r4;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends AtomicReference {
    private static final long serialVersionUID = 3949248817947090603L;

    public final boolean a(Throwable th) {
        Throwable cVar;
        c cVar2 = d.f3456a;
        while (true) {
            Throwable th2 = (Throwable) get();
            if (th2 == d.f3456a) {
                com.bumptech.glide.d.i(th);
                return false;
            }
            if (th2 == null) {
                cVar = th;
            } else {
                cVar = new j4.c(th2, th);
            }
            while (!compareAndSet(th2, cVar)) {
                if (get() != th2) {
                    break;
                }
            }
            return true;
        }
    }

    public final void b(h4.c cVar) {
        c cVar2 = d.f3456a;
        Throwable th = (Throwable) get();
        c cVar3 = d.f3456a;
        if (th != cVar3) {
            th = (Throwable) getAndSet(cVar3);
        }
        if (th == null) {
            cVar.onComplete();
        } else if (th != cVar3) {
            cVar.b(th);
        }
    }
}
