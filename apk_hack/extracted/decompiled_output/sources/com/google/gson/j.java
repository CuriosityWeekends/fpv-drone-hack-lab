package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadLocal f507a;
    public final ConcurrentHashMap b;
    public final List c;
    public final com.bumptech.glide.h d;

    /* renamed from: e  reason: collision with root package name */
    public final m2.c f508e;

    static {
        new o2.a(Object.class);
    }

    public j() {
        l2.f fVar = l2.f.c;
        Map emptyMap = Collections.emptyMap();
        List emptyList = Collections.emptyList();
        this.f507a = new ThreadLocal();
        this.b = new ConcurrentHashMap();
        com.bumptech.glide.h hVar = new com.bumptech.glide.h(emptyMap);
        this.d = hVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(m2.l.A);
        arrayList.add(m2.e.b);
        arrayList.add(fVar);
        arrayList.addAll(emptyList);
        arrayList.add(m2.l.f2863p);
        arrayList.add(m2.l.f2854g);
        arrayList.add(m2.l.d);
        arrayList.add(m2.l.f2852e);
        arrayList.add(m2.l.f2853f);
        m2.e eVar = m2.l.f2858k;
        arrayList.add(new m2.k(Long.TYPE, Long.class, eVar));
        arrayList.add(new m2.k(Double.TYPE, Double.class, new g(0)));
        arrayList.add(new m2.k(Float.TYPE, Float.class, new g(1)));
        arrayList.add(m2.l.f2859l);
        arrayList.add(m2.l.f2855h);
        arrayList.add(m2.l.f2856i);
        arrayList.add(new m2.j(AtomicLong.class, new h(new h(eVar, 0), 2), 0));
        arrayList.add(new m2.j(AtomicLongArray.class, new h(new h(eVar, 1), 2), 0));
        arrayList.add(m2.l.f2857j);
        arrayList.add(m2.l.f2860m);
        arrayList.add(m2.l.q);
        arrayList.add(m2.l.f2864r);
        arrayList.add(new m2.j(BigDecimal.class, m2.l.f2861n, 0));
        arrayList.add(new m2.j(BigInteger.class, m2.l.f2862o, 0));
        arrayList.add(m2.l.s);
        arrayList.add(m2.l.f2865t);
        arrayList.add(m2.l.f2867v);
        arrayList.add(m2.l.w);
        arrayList.add(m2.l.f2870z);
        arrayList.add(m2.l.f2866u);
        arrayList.add(m2.l.b);
        arrayList.add(m2.b.f2839e);
        arrayList.add(m2.l.f2869y);
        arrayList.add(m2.h.d);
        arrayList.add(m2.h.c);
        arrayList.add(m2.l.f2868x);
        arrayList.add(m2.b.d);
        arrayList.add(m2.l.f2851a);
        arrayList.add(new m2.c(hVar, 0));
        arrayList.add(new m2.c(hVar, 2));
        m2.c cVar = new m2.c(hVar, 1);
        this.f508e = cVar;
        arrayList.add(cVar);
        arrayList.add(m2.l.B);
        arrayList.add(new m2.g(hVar, fVar, cVar));
        this.c = Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.gson.i, java.lang.Object] */
    public final s a(o2.a aVar) {
        boolean z3;
        ConcurrentHashMap concurrentHashMap = this.b;
        s sVar = (s) concurrentHashMap.get(aVar);
        if (sVar != null) {
            return sVar;
        }
        ThreadLocal threadLocal = this.f507a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z3 = true;
        } else {
            z3 = false;
        }
        i iVar = (i) map.get(aVar);
        if (iVar != null) {
            return iVar;
        }
        try {
            ?? obj = new Object();
            map.put(aVar, obj);
            for (t tVar : this.c) {
                s a5 = tVar.a(this, aVar);
                if (a5 != null) {
                    if (obj.f506a == null) {
                        obj.f506a = a5;
                        concurrentHashMap.put(aVar, a5);
                        map.remove(aVar);
                        if (z3) {
                            threadLocal.remove();
                        }
                        return a5;
                    }
                    throw new AssertionError();
                }
            }
            throw new IllegalArgumentException("GSON cannot handle " + aVar);
        } catch (Throwable th) {
            map.remove(aVar);
            if (z3) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.c + ",instanceCreators:" + this.d + "}";
    }
}
