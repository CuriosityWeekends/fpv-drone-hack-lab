package x;

import androidx.collection.ArrayMap;
import i.e0;
import i.l;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {
    public static final e0 c = new e0(Object.class, Object.class, Object.class, Collections.singletonList(new l(Object.class, Object.class, Object.class, Collections.emptyList(), new u.d(0), null)), null);

    /* renamed from: a  reason: collision with root package name */
    public final ArrayMap f3952a = new ArrayMap();
    public final AtomicReference b = new AtomicReference();

    public final void a(Class cls, Class cls2, Class cls3, e0 e0Var) {
        synchronized (this.f3952a) {
            ArrayMap arrayMap = this.f3952a;
            c0.l lVar = new c0.l(cls, cls2, cls3);
            if (e0Var == null) {
                e0Var = c;
            }
            arrayMap.put(lVar, e0Var);
        }
    }
}
