package c0;

import g2.w;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p0.r;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class j implements w0.g {

    /* renamed from: a  reason: collision with root package name */
    public long f195a;
    public long b;
    public final Object c;

    public j(long j2) {
        this.c = new LinkedHashMap(100, 0.75f, true);
        this.f195a = j2;
    }

    @Override // w0.g
    public long a(p0.g gVar) {
        long j2 = this.b;
        if (j2 < 0) {
            return -1L;
        }
        long j5 = -(j2 + 2);
        this.b = -1L;
        return j5;
    }

    @Override // w0.g
    public r b() {
        boolean z3;
        if (this.f195a != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.h(z3);
        return new p0.n(((w0.c) this.c).f3911n, this.f195a);
    }

    @Override // w0.g
    public void c(long j2) {
        w0.c cVar = (w0.c) this.c;
        cVar.f3911n.f1931k.getClass();
        long[] jArr = (long[]) cVar.f3911n.f1931k.b;
        this.b = jArr[w.d(jArr, j2, true)];
    }

    public synchronized Object d(Object obj) {
        Object obj2;
        i iVar = (i) ((LinkedHashMap) this.c).get(obj);
        if (iVar != null) {
            obj2 = iVar.f194a;
        } else {
            obj2 = null;
        }
        return obj2;
    }

    public int e(Object obj) {
        return 1;
    }

    public synchronized Object g(Object obj, Object obj2) {
        i iVar;
        int e5 = e(obj2);
        long j2 = e5;
        Object obj3 = null;
        if (j2 >= this.f195a) {
            f(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.b += j2;
        }
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.c;
        if (obj2 == null) {
            iVar = null;
        } else {
            iVar = new i(e5, obj2);
        }
        i iVar2 = (i) linkedHashMap.put(obj, iVar);
        if (iVar2 != null) {
            this.b -= iVar2.b;
            if (!iVar2.f194a.equals(obj2)) {
                f(obj, iVar2.f194a);
            }
        }
        h(this.f195a);
        if (iVar2 != null) {
            obj3 = iVar2.f194a;
        }
        return obj3;
    }

    public synchronized void h(long j2) {
        while (this.b > j2) {
            Iterator it = ((LinkedHashMap) this.c).entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            i iVar = (i) entry.getValue();
            this.b -= iVar.b;
            Object key = entry.getKey();
            it.remove();
            f(key, iVar.f194a);
        }
    }

    public j(w0.c cVar) {
        this.c = cVar;
        this.f195a = -1L;
        this.b = -1L;
    }

    public void f(Object obj, Object obj2) {
    }
}
