package h4;

import java.util.Objects;
import p4.h;
import p4.k;
import p4.m;
import p4.o;
import p4.q;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class b {
    public static o f(Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return new o(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object, k4.b] */
    public final b d(v3.b bVar) {
        b f4;
        v3.c cVar = bVar.b;
        cVar.getClass();
        String[] strArr = bVar.f3898a;
        if (strArr != null && strArr.length != 0) {
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                Object obj = v3.c.b;
                if (i3 < length) {
                    if (!cVar.f3899a.e().f1145a.containsKey(strArr[i3])) {
                        f4 = h.f3243a;
                        break;
                    }
                    i3++;
                } else {
                    f4 = f(obj);
                    break;
                }
            }
            b e5 = new m(0, new b[]{this, f4}).e(m4.a.f2871a, 2).e(new v3.b(cVar, strArr), Integer.MAX_VALUE);
            int length2 = strArr.length;
            m4.a.a(length2, "count");
            m4.a.a(length2, "skip");
            return new p4.d(e5, length2, length2).e(new Object(), Integer.MAX_VALUE);
        }
        throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
    }

    public final b e(k4.b bVar, int i3) {
        int i5 = a.f2039a;
        m4.a.a(i3, "maxConcurrency");
        m4.a.a(i5, "bufferSize");
        if (this instanceof n4.b) {
            Object obj = ((n4.b) this).get();
            if (obj == null) {
                return h.f3243a;
            }
            return new q(obj, bVar);
        }
        return new k(this, bVar, i3, i5);
    }

    public final void g(c cVar) {
        Objects.requireNonNull(cVar, "observer is null");
        try {
            h(cVar);
        } catch (NullPointerException e5) {
            throw e5;
        } catch (Throwable th) {
            com.bumptech.glide.c.l(th);
            com.bumptech.glide.d.i(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void h(c cVar);
}
