package n1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f2914a;
    public final int b;
    public final List c;
    public final List d;

    /* renamed from: e  reason: collision with root package name */
    public final List f2915e;

    public a(int i3, int i5, ArrayList arrayList, List list, List list2) {
        List unmodifiableList;
        List unmodifiableList2;
        this.f2914a = i3;
        this.b = i5;
        this.c = Collections.unmodifiableList(arrayList);
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.d = unmodifiableList;
        if (list2 == null) {
            unmodifiableList2 = Collections.emptyList();
        } else {
            unmodifiableList2 = Collections.unmodifiableList(list2);
        }
        this.f2915e = unmodifiableList2;
    }
}
