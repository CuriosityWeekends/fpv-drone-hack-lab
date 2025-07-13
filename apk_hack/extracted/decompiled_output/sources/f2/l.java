package f2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1841a;
    public final HashMap b;

    public l(int i3) {
        switch (i3) {
            case 1:
                this.f1841a = new ArrayList();
                this.b = new HashMap();
                return;
            default:
                this.b = new HashMap();
                this.f1841a = new ArrayList();
                return;
        }
    }

    public void a(Object obj, String str) {
        HashMap hashMap = this.b;
        obj.getClass();
        hashMap.put(str, obj);
        this.f1841a.remove(str);
    }

    public synchronized List b(String str) {
        List list;
        try {
            if (!this.f1841a.contains(str)) {
                this.f1841a.add(str);
            }
            list = (List) this.b.get(str);
            if (list == null) {
                list = new ArrayList();
                this.b.put(str, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return list;
    }

    public synchronized ArrayList c(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f1841a.iterator();
        while (it.hasNext()) {
            List<x.c> list = (List) this.b.get((String) it.next());
            if (list != null) {
                for (x.c cVar : list) {
                    if (cVar.f3953a.isAssignableFrom(cls) && cls2.isAssignableFrom(cVar.b) && !arrayList.contains(cVar.b)) {
                        arrayList.add(cVar.b);
                    }
                }
            }
        }
        return arrayList;
    }
}
