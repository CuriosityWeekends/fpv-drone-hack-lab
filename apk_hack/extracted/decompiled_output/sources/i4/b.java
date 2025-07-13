package i4;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class b extends AtomicReference implements a {
    private static final long serialVersionUID = 6537757548749041217L;

    @Override // i4.a
    public final void dispose() {
        Object andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            ((Runnable) andSet).run();
        }
    }
}
