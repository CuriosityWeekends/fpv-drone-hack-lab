package m;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class y {

    /* renamed from: e  reason: collision with root package name */
    public static final x f2757e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static final c0 f2758f = new c0(2);

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f2759a;
    public final x b;
    public final HashSet c;
    public final Pools.Pool d;

    public y(d0.d dVar) {
        x xVar = f2757e;
        this.f2759a = new ArrayList();
        this.c = new HashSet();
        this.d = dVar;
        this.b = xVar;
    }

    public final synchronized void a(Class cls, Class cls2, r rVar) {
        w wVar = new w(cls, cls2, rVar);
        ArrayList arrayList = this.f2759a;
        arrayList.add(arrayList.size(), wVar);
    }

    public final synchronized ArrayList b(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            Iterator it = this.f2759a.iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                if (!this.c.contains(wVar) && wVar.f2756a.isAssignableFrom(cls)) {
                    this.c.add(wVar);
                    arrayList.add(wVar.c.n(this));
                    this.c.remove(wVar);
                }
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
        return arrayList;
    }

    public final synchronized q c(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f2759a.iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                w wVar = (w) it.next();
                if (this.c.contains(wVar)) {
                    z3 = true;
                } else if (wVar.f2756a.isAssignableFrom(cls) && wVar.b.isAssignableFrom(cls2)) {
                    this.c.add(wVar);
                    arrayList.add(d(wVar));
                    this.c.remove(wVar);
                }
            }
            if (arrayList.size() > 1) {
                x xVar = this.b;
                Pools.Pool pool = this.d;
                xVar.getClass();
                return new v(arrayList, pool);
            } else if (arrayList.size() == 1) {
                return (q) arrayList.get(0);
            } else if (z3) {
                return f2758f;
            } else {
                throw new RuntimeException("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
    }

    public final q d(w wVar) {
        return wVar.c.n(this);
    }

    public final synchronized ArrayList e(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f2759a.iterator();
        while (it.hasNext()) {
            w wVar = (w) it.next();
            if (!arrayList.contains(wVar.b) && wVar.f2756a.isAssignableFrom(cls)) {
                arrayList.add(wVar.b);
            }
        }
        return arrayList;
    }
}
