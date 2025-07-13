package m;

import java.util.ArrayDeque;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n extends c0.j {
    @Override // c0.j
    public final void f(Object obj, Object obj2) {
        o oVar = (o) obj;
        oVar.getClass();
        ArrayDeque arrayDeque = o.d;
        synchronized (arrayDeque) {
            arrayDeque.offer(oVar);
        }
    }
}
