package i;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class v implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    public final List f2130a;

    public v(ArrayList arrayList) {
        this.f2130a = arrayList;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f2130a.iterator();
    }
}
