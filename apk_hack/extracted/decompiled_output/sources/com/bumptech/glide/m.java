package com.bumptech.glide;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import m.q;
import m.r;
import m.s;
import m.t;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final t f275a;
    public final u.c b;
    public final f2.l c;
    public final u.c d;

    /* renamed from: e  reason: collision with root package name */
    public final com.bumptech.glide.load.data.i f276e;

    /* renamed from: f  reason: collision with root package name */
    public final u.c f277f;

    /* renamed from: g  reason: collision with root package name */
    public final u.c f278g;

    /* renamed from: h  reason: collision with root package name */
    public final c1.b f279h = new c1.b(23);

    /* renamed from: i  reason: collision with root package name */
    public final x.b f280i = new x.b();

    /* renamed from: j  reason: collision with root package name */
    public final d0.d f281j;

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, d0.c] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, d0.f] */
    public m() {
        d0.d dVar = new d0.d(new Pools.SynchronizedPool(20), new Object(), new Object());
        this.f281j = dVar;
        this.f275a = new t(dVar);
        this.b = new u.c(1);
        this.c = new f2.l(1);
        this.d = new u.c(3);
        this.f276e = new com.bumptech.glide.load.data.i();
        this.f277f = new u.c(0);
        this.f278g = new u.c(2);
        List<String> asList = Arrays.asList("Gif", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(asList.size());
        arrayList.add("legacy_prepend_all");
        for (String str : asList) {
            arrayList.add(str);
        }
        arrayList.add("legacy_append");
        f2.l lVar = this.c;
        synchronized (lVar) {
            try {
                ArrayList arrayList2 = new ArrayList(lVar.f1841a);
                lVar.f1841a.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    lVar.f1841a.add((String) it.next());
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    String str2 = (String) it2.next();
                    if (!arrayList.contains(str2)) {
                        lVar.f1841a.add(str2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(Class cls, g.b bVar) {
        u.c cVar = this.b;
        synchronized (cVar) {
            cVar.f3724a.add(new x.a(cls, bVar));
        }
    }

    public final void b(Class cls, g.k kVar) {
        u.c cVar = this.d;
        synchronized (cVar) {
            cVar.f3724a.add(new x.d(cls, kVar));
        }
    }

    public final void c(Class cls, Class cls2, r rVar) {
        t tVar = this.f275a;
        synchronized (tVar) {
            tVar.f2750a.a(cls, cls2, rVar);
            tVar.b.f250a.clear();
        }
    }

    public final void d(String str, Class cls, Class cls2, g.j jVar) {
        f2.l lVar = this.c;
        synchronized (lVar) {
            lVar.b(str).add(new x.c(cls, cls2, jVar));
        }
    }

    public final ArrayList e(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.c.c(cls, cls2).iterator();
        while (it.hasNext()) {
            Class cls4 = (Class) it.next();
            Iterator it2 = this.f277f.c(cls4, cls3).iterator();
            while (it2.hasNext()) {
                Class cls5 = (Class) it2.next();
                f2.l lVar = this.c;
                synchronized (lVar) {
                    arrayList = new ArrayList();
                    Iterator it3 = lVar.f1841a.iterator();
                    while (it3.hasNext()) {
                        List<x.c> list = (List) lVar.b.get((String) it3.next());
                        if (list != null) {
                            for (x.c cVar : list) {
                                if (cVar.f3953a.isAssignableFrom(cls) && cls4.isAssignableFrom(cVar.b)) {
                                    arrayList.add(cVar.c);
                                }
                            }
                        }
                    }
                }
                arrayList2.add(new i.l(cls, cls4, cls5, arrayList, this.f277f.b(cls4, cls5), this.f281j));
            }
        }
        return arrayList2;
    }

    public final ArrayList f() {
        ArrayList arrayList;
        u.c cVar = this.f278g;
        synchronized (cVar) {
            arrayList = cVar.f3724a;
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        throw new RuntimeException("Failed to find image header parser.");
    }

    public final List g(Object obj) {
        List list;
        t tVar = this.f275a;
        tVar.getClass();
        Class<?> cls = obj.getClass();
        synchronized (tVar) {
            s sVar = (s) tVar.b.f250a.get(cls);
            if (sVar == null) {
                list = null;
            } else {
                list = sVar.f2749a;
            }
            if (list == null) {
                list = Collections.unmodifiableList(tVar.f2750a.b(cls));
                if (((s) tVar.b.f250a.put(cls, new s(list))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (!list.isEmpty()) {
            int size = list.size();
            List emptyList = Collections.emptyList();
            boolean z3 = true;
            for (int i3 = 0; i3 < size; i3++) {
                q qVar = (q) list.get(i3);
                if (qVar.b(obj)) {
                    if (z3) {
                        emptyList = new ArrayList(size - i3);
                        z3 = false;
                    }
                    emptyList.add(qVar);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new RuntimeException("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + obj);
        }
        throw new RuntimeException("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
    }

    public final void h(com.bumptech.glide.load.data.f fVar) {
        com.bumptech.glide.load.data.i iVar = this.f276e;
        synchronized (iVar) {
            ((HashMap) iVar.b).put(fVar.a(), fVar);
        }
    }

    public final void i(g.d dVar) {
        u.c cVar = this.f278g;
        synchronized (cVar) {
            cVar.f3724a.add(dVar);
        }
    }

    public final void j(Class cls, Class cls2, u.a aVar) {
        u.c cVar = this.f277f;
        synchronized (cVar) {
            cVar.f3724a.add(new u.b(cls, cls2, aVar));
        }
    }
}
