package i;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f2059a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public com.bumptech.glide.f c;
    public Object d;

    /* renamed from: e  reason: collision with root package name */
    public int f2060e;

    /* renamed from: f  reason: collision with root package name */
    public int f2061f;

    /* renamed from: g  reason: collision with root package name */
    public Class f2062g;

    /* renamed from: h  reason: collision with root package name */
    public r f2063h;

    /* renamed from: i  reason: collision with root package name */
    public g.h f2064i;

    /* renamed from: j  reason: collision with root package name */
    public Map f2065j;

    /* renamed from: k  reason: collision with root package name */
    public Class f2066k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2067l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f2068m;

    /* renamed from: n  reason: collision with root package name */
    public g.e f2069n;

    /* renamed from: o  reason: collision with root package name */
    public com.bumptech.glide.j f2070o;

    /* renamed from: p  reason: collision with root package name */
    public m f2071p;
    public boolean q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f2072r;

    public final ArrayList a() {
        boolean z3 = this.f2068m;
        ArrayList arrayList = this.b;
        if (!z3) {
            this.f2068m = true;
            arrayList.clear();
            ArrayList b = b();
            int size = b.size();
            for (int i3 = 0; i3 < size; i3++) {
                m.p pVar = (m.p) b.get(i3);
                if (!arrayList.contains(pVar.f2748a)) {
                    arrayList.add(pVar.f2748a);
                }
                int i5 = 0;
                while (true) {
                    List list = pVar.b;
                    if (i5 < list.size()) {
                        if (!arrayList.contains(list.get(i5))) {
                            arrayList.add(list.get(i5));
                        }
                        i5++;
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList b() {
        boolean z3 = this.f2067l;
        ArrayList arrayList = this.f2059a;
        if (!z3) {
            this.f2067l = true;
            arrayList.clear();
            List g5 = this.c.b.g(this.d);
            int size = g5.size();
            for (int i3 = 0; i3 < size; i3++) {
                m.p a5 = ((m.q) g5.get(i3)).a(this.d, this.f2060e, this.f2061f, this.f2064i);
                if (a5 != null) {
                    arrayList.add(a5);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e0 c(Class cls) {
        e0 e0Var;
        com.bumptech.glide.m mVar = this.c.b;
        Class cls2 = this.f2062g;
        Class cls3 = this.f2066k;
        x.b bVar = mVar.f280i;
        e0 e0Var2 = null;
        c0.l lVar = (c0.l) bVar.b.getAndSet(null);
        c0.l lVar2 = lVar;
        if (lVar == null) {
            lVar2 = new Object();
        }
        lVar2.f197a = cls;
        lVar2.b = cls2;
        lVar2.c = cls3;
        synchronized (bVar.f3952a) {
            e0Var = (e0) bVar.f3952a.get(lVar2);
        }
        bVar.b.set(lVar2);
        mVar.f280i.getClass();
        if (x.b.c.equals(e0Var)) {
            return null;
        }
        if (e0Var == null) {
            ArrayList e5 = mVar.e(cls, cls2, cls3);
            if (!e5.isEmpty()) {
                e0Var2 = new e0(cls, cls2, cls3, e5, mVar.f281j);
            }
            mVar.f280i.a(cls, cls2, cls3, e0Var2);
            return e0Var2;
        }
        return e0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
        r1 = r3.b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final g.b d(java.lang.Object r6) {
        /*
            r5 = this;
            com.bumptech.glide.f r0 = r5.c
            com.bumptech.glide.m r0 = r0.b
            u.c r0 = r0.b
            java.lang.Class r1 = r6.getClass()
            monitor-enter(r0)
            java.util.ArrayList r2 = r0.f3724a     // Catch: java.lang.Throwable -> L29
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L29
        L11:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L29
            if (r3 == 0) goto L2b
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L29
            x.a r3 = (x.a) r3     // Catch: java.lang.Throwable -> L29
            java.lang.Class r4 = r3.f3951a     // Catch: java.lang.Throwable -> L29
            boolean r4 = r4.isAssignableFrom(r1)     // Catch: java.lang.Throwable -> L29
            if (r4 == 0) goto L11
            g.b r1 = r3.b     // Catch: java.lang.Throwable -> L29
            monitor-exit(r0)
            goto L2d
        L29:
            r6 = move-exception
            goto L48
        L2b:
            monitor-exit(r0)
            r1 = 0
        L2d:
            if (r1 == 0) goto L30
            return r1
        L30:
            com.bumptech.glide.l r0 = new com.bumptech.glide.l
            java.lang.Class r6 = r6.getClass()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to find source encoder for data class: "
            r1.<init>(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L48:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i.h.d(java.lang.Object):g.b");
    }

    public final g.l e(Class cls) {
        g.l lVar = (g.l) this.f2065j.get(cls);
        if (lVar == null) {
            Iterator it = this.f2065j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    lVar = (g.l) entry.getValue();
                    break;
                }
            }
        }
        if (lVar == null) {
            if (this.f2065j.isEmpty() && this.q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return o.e.b;
        }
        return lVar;
    }
}
