package d0;

import android.util.Log;
import androidx.core.util.Pools;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements Pools.Pool {

    /* renamed from: a  reason: collision with root package name */
    public final c f1597a;
    public final f b;
    public final Pools.Pool c;

    public d(Pools.SynchronizedPool synchronizedPool, c cVar, f fVar) {
        this.c = synchronizedPool;
        this.f1597a = cVar;
        this.b = fVar;
    }

    @Override // androidx.core.util.Pools.Pool
    public final Object acquire() {
        Object acquire = this.c.acquire();
        if (acquire == null) {
            acquire = this.f1597a.g();
            if (Log.isLoggable("FactoryPools", 2)) {
                Log.v("FactoryPools", "Created new " + acquire.getClass());
            }
        }
        if (acquire instanceof e) {
            ((e) acquire).c().f1599a = false;
        }
        return acquire;
    }

    @Override // androidx.core.util.Pools.Pool
    public final boolean release(Object obj) {
        if (obj instanceof e) {
            ((e) obj).c().f1599a = true;
        }
        this.b.a(obj);
        return this.c.release(obj);
    }
}
