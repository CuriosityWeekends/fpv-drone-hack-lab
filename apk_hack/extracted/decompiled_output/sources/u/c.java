package u;

import g.k;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f3724a;

    public c(int i3) {
        switch (i3) {
            case 1:
                this.f3724a = new ArrayList();
                return;
            case 2:
                this.f3724a = new ArrayList();
                return;
            case 3:
                this.f3724a = new ArrayList();
                return;
            default:
                this.f3724a = new ArrayList();
                return;
        }
    }

    public synchronized k a(Class cls) {
        int size = this.f3724a.size();
        for (int i3 = 0; i3 < size; i3++) {
            x.d dVar = (x.d) this.f3724a.get(i3);
            if (dVar.f3954a.isAssignableFrom(cls)) {
                return dVar.b;
            }
        }
        return null;
    }

    public synchronized a b(Class cls, Class cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return d.b;
        }
        Iterator it = this.f3724a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f3723a.isAssignableFrom(cls) && cls2.isAssignableFrom(bVar.b)) {
                return bVar.c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public synchronized ArrayList c(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator it = this.f3724a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f3723a.isAssignableFrom(cls) && cls2.isAssignableFrom(bVar.b)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }
}
