package m;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class v implements q {

    /* renamed from: a  reason: collision with root package name */
    public final List f2755a;
    public final Pools.Pool b;

    public v(ArrayList arrayList, Pools.Pool pool) {
        this.f2755a = arrayList;
        this.b = pool;
    }

    @Override // m.q
    public final p a(Object obj, int i3, int i5, g.h hVar) {
        p a5;
        List list = this.f2755a;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        g.e eVar = null;
        for (int i6 = 0; i6 < size; i6++) {
            q qVar = (q) list.get(i6);
            if (qVar.b(obj) && (a5 = qVar.a(obj, i3, i5, hVar)) != null) {
                arrayList.add(a5.c);
                eVar = a5.f2748a;
            }
        }
        if (arrayList.isEmpty() || eVar == null) {
            return null;
        }
        return new p(eVar, new u(arrayList, this.b));
    }

    @Override // m.q
    public final boolean b(Object obj) {
        for (q qVar : this.f2755a) {
            if (qVar.b(obj)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f2755a.toArray()) + '}';
    }
}
