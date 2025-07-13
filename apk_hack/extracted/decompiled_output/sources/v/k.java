package v;

import c0.n;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k implements f {

    /* renamed from: a  reason: collision with root package name */
    public final Set f3790a = Collections.newSetFromMap(new WeakHashMap());

    @Override // v.f
    public final void i() {
        Iterator it = n.d(this.f3790a).iterator();
        while (it.hasNext()) {
            ((z.d) it.next()).i();
        }
    }

    @Override // v.f
    public final void onStart() {
        Iterator it = n.d(this.f3790a).iterator();
        while (it.hasNext()) {
            ((z.d) it.next()).onStart();
        }
    }

    @Override // v.f
    public final void onStop() {
        Iterator it = n.d(this.f3790a).iterator();
        while (it.hasNext()) {
            ((z.d) it.next()).onStop();
        }
    }
}
