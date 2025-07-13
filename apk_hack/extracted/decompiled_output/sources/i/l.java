package i;

import android.util.Log;
import androidx.core.util.Pools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final Class f2108a;
    public final List b;
    public final u.a c;
    public final Pools.Pool d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2109e;

    public l(Class cls, Class cls2, Class cls3, List list, u.a aVar, Pools.Pool pool) {
        this.f2108a = cls;
        this.b = list;
        this.c = aVar;
        this.d = pool;
        this.f2109e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final g0 a(int i3, int i5, a1.m mVar, com.bumptech.glide.load.data.g gVar, g.h hVar) {
        f0 f0Var;
        g.l lVar;
        int i6;
        boolean z3;
        boolean z5;
        boolean z6;
        Object eVar;
        String str;
        Pools.Pool pool = this.d;
        Object acquire = pool.acquire();
        c0.g.c(acquire, "Argument must not be null");
        List list = (List) acquire;
        try {
            g0 b = b(gVar, i3, i5, hVar, list);
            pool.release(list);
            k kVar = (k) mVar.b;
            kVar.getClass();
            Class<?> cls = b.get().getClass();
            int i7 = mVar.f39a;
            h hVar2 = kVar.f2087a;
            g.k kVar2 = null;
            if (i7 != 4) {
                g.l e5 = hVar2.e(cls);
                f0Var = e5.a(kVar.f2091h, b, kVar.f2095l, kVar.f2096m);
                lVar = e5;
            } else {
                f0Var = b;
                lVar = null;
            }
            if (!b.equals(f0Var)) {
                b.recycle();
            }
            if (hVar2.c.b.d.a(f0Var.a()) != null) {
                com.bumptech.glide.m mVar2 = hVar2.c.b;
                mVar2.getClass();
                kVar2 = mVar2.d.a(f0Var.a());
                if (kVar2 != null) {
                    i6 = kVar2.h(kVar.f2098o);
                } else {
                    throw new com.bumptech.glide.l(f0Var.a());
                }
            } else {
                i6 = 3;
            }
            g.e eVar2 = kVar.f2103v;
            ArrayList b5 = hVar2.b();
            int size = b5.size();
            int i8 = 0;
            while (true) {
                if (i8 < size) {
                    if (((m.p) b5.get(i8)).f2748a.equals(eVar2)) {
                        z3 = true;
                        break;
                    }
                    i8++;
                } else {
                    z3 = false;
                    break;
                }
            }
            if (kVar.f2097n.d(i7, i6, !z3)) {
                if (kVar2 != null) {
                    int b6 = com.bumptech.glide.i.b(i6);
                    if (b6 != 0) {
                        if (b6 == 1) {
                            z5 = true;
                            eVar = new i0(hVar2.c.f243a, kVar.f2103v, kVar.f2092i, kVar.f2095l, kVar.f2096m, lVar, cls, kVar.f2098o);
                            z6 = false;
                        } else {
                            if (i6 != 1) {
                                if (i6 != 2) {
                                    if (i6 != 3) {
                                        str = "null";
                                    } else {
                                        str = "NONE";
                                    }
                                } else {
                                    str = "TRANSFORMED";
                                }
                            } else {
                                str = "SOURCE";
                            }
                            throw new IllegalArgumentException("Unknown strategy: ".concat(str));
                        }
                    } else {
                        z5 = true;
                        z6 = false;
                        eVar = new e(kVar.f2103v, kVar.f2092i);
                    }
                    f0 f0Var2 = (f0) f0.f2057e.acquire();
                    f0Var2.d = z6;
                    f0Var2.c = z5;
                    f0Var2.b = f0Var;
                    b bVar = kVar.f2089f;
                    bVar.b = eVar;
                    bVar.c = kVar2;
                    bVar.d = f0Var2;
                    f0Var = f0Var2;
                } else {
                    throw new com.bumptech.glide.l(f0Var.get().getClass());
                }
            }
            return this.c.b(f0Var, hVar);
        } catch (Throwable th) {
            pool.release(list);
            throw th;
        }
    }

    public final g0 b(com.bumptech.glide.load.data.g gVar, int i3, int i5, g.h hVar, List list) {
        List list2 = this.b;
        int size = list2.size();
        g0 g0Var = null;
        for (int i6 = 0; i6 < size; i6++) {
            g.j jVar = (g.j) list2.get(i6);
            try {
                if (jVar.b(gVar.a(), hVar)) {
                    g0Var = jVar.a(gVar.a(), i3, i5, hVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e5) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + jVar, e5);
                }
                list.add(e5);
            }
            if (g0Var != null) {
                break;
            }
        }
        if (g0Var != null) {
            return g0Var;
        }
        throw new c0(this.f2109e, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f2108a + ", decoders=" + this.b + ", transcoder=" + this.c + '}';
    }
}
