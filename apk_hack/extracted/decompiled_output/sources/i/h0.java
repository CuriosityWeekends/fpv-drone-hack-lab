package i;

import androidx.collection.ArrayMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h0 implements g, com.bumptech.glide.load.data.d {

    /* renamed from: a  reason: collision with root package name */
    public final f f2073a;
    public final h b;
    public int c;
    public int d = -1;

    /* renamed from: e  reason: collision with root package name */
    public g.e f2074e;

    /* renamed from: f  reason: collision with root package name */
    public List f2075f;

    /* renamed from: g  reason: collision with root package name */
    public int f2076g;

    /* renamed from: h  reason: collision with root package name */
    public volatile m.p f2077h;

    /* renamed from: i  reason: collision with root package name */
    public File f2078i;

    /* renamed from: j  reason: collision with root package name */
    public i0 f2079j;

    public h0(h hVar, f fVar) {
        this.b = hVar;
        this.f2073a = fVar;
    }

    @Override // i.g
    public final boolean c() {
        List list;
        ArrayList a5 = this.b.a();
        boolean z3 = false;
        if (a5.isEmpty()) {
            return false;
        }
        h hVar = this.b;
        com.bumptech.glide.m mVar = hVar.c.b;
        Class<?> cls = hVar.d.getClass();
        Class cls2 = hVar.f2062g;
        Class cls3 = hVar.f2066k;
        c1.b bVar = mVar.f279h;
        c0.l lVar = (c0.l) ((AtomicReference) bVar.b).getAndSet(null);
        if (lVar == null) {
            lVar = new c0.l(cls, cls2, cls3);
        } else {
            lVar.f197a = cls;
            lVar.b = cls2;
            lVar.c = cls3;
        }
        synchronized (((ArrayMap) bVar.c)) {
            list = (List) ((ArrayMap) bVar.c).get(lVar);
        }
        ((AtomicReference) bVar.b).set(lVar);
        ArrayList arrayList = list;
        if (list == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = mVar.f275a.a(cls).iterator();
            while (it.hasNext()) {
                Iterator it2 = mVar.c.c((Class) it.next(), cls2).iterator();
                while (it2.hasNext()) {
                    Class cls4 = (Class) it2.next();
                    if (!mVar.f277f.c(cls4, cls3).isEmpty() && !arrayList2.contains(cls4)) {
                        arrayList2.add(cls4);
                    }
                }
            }
            mVar.f279h.v(cls, cls2, cls3, Collections.unmodifiableList(arrayList2));
            arrayList = arrayList2;
        }
        if (arrayList.isEmpty()) {
            if (File.class.equals(this.b.f2066k)) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.b.d.getClass() + " to " + this.b.f2066k);
        }
        while (true) {
            List list2 = this.f2075f;
            if (list2 != null && this.f2076g < list2.size()) {
                this.f2077h = null;
                while (!z3 && this.f2076g < this.f2075f.size()) {
                    List list3 = this.f2075f;
                    int i3 = this.f2076g;
                    this.f2076g = i3 + 1;
                    File file = this.f2078i;
                    h hVar2 = this.b;
                    this.f2077h = ((m.q) list3.get(i3)).a(file, hVar2.f2060e, hVar2.f2061f, hVar2.f2064i);
                    if (this.f2077h != null && this.b.c(this.f2077h.c.a()) != null) {
                        this.f2077h.c.c(this.b.f2070o, this);
                        z3 = true;
                    }
                }
                return z3;
            }
            int i5 = this.d + 1;
            this.d = i5;
            if (i5 >= arrayList.size()) {
                int i6 = this.c + 1;
                this.c = i6;
                if (i6 >= a5.size()) {
                    return false;
                }
                this.d = 0;
            }
            g.e eVar = (g.e) a5.get(this.c);
            Class cls5 = (Class) arrayList.get(this.d);
            g.l e5 = this.b.e(cls5);
            h hVar3 = this.b;
            this.f2079j = new i0(hVar3.c.f243a, eVar, hVar3.f2069n, hVar3.f2060e, hVar3.f2061f, e5, cls5, hVar3.f2064i);
            File d = hVar3.f2063h.a().d(this.f2079j);
            this.f2078i = d;
            if (d != null) {
                this.f2074e = eVar;
                this.f2075f = this.b.c.b.g(d);
                this.f2076g = 0;
            }
        }
    }

    @Override // i.g
    public final void cancel() {
        m.p pVar = this.f2077h;
        if (pVar != null) {
            pVar.c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(Exception exc) {
        this.f2073a.d(this.f2079j, exc, this.f2077h.c, 4);
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(Object obj) {
        this.f2073a.b(this.f2074e, obj, this.f2077h.c, 4, this.f2079j);
    }
}
