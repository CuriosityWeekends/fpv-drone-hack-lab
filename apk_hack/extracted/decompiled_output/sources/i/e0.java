package i;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    public final Pools.Pool f2056a;
    public final List b;
    public final String c;

    public e0(Class cls, Class cls2, Class cls3, List list, Pools.Pool pool) {
        this.f2056a = pool;
        if (!list.isEmpty()) {
            this.b = list;
            this.c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
            return;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public final g0 a(int i3, int i5, a1.m mVar, com.bumptech.glide.load.data.g gVar, g.h hVar) {
        Pools.Pool pool = this.f2056a;
        Object acquire = pool.acquire();
        c0.g.c(acquire, "Argument must not be null");
        List list = (List) acquire;
        try {
            List list2 = this.b;
            int size = list2.size();
            g0 g0Var = null;
            for (int i6 = 0; i6 < size; i6++) {
                try {
                    g0Var = ((l) list2.get(i6)).a(i3, i5, mVar, gVar, hVar);
                } catch (c0 e5) {
                    list.add(e5);
                }
                if (g0Var != null) {
                    break;
                }
            }
            if (g0Var != null) {
                return g0Var;
            }
            throw new c0(this.c, new ArrayList(list));
        } finally {
            pool.release(list);
        }
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.b.toArray()) + '}';
    }
}
