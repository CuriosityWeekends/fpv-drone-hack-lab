package p1;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e extends h {

    /* renamed from: l  reason: collision with root package name */
    public static final e f3159l = new e("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());
    public final List d;

    /* renamed from: e  reason: collision with root package name */
    public final List f3160e;

    /* renamed from: f  reason: collision with root package name */
    public final List f3161f;

    /* renamed from: g  reason: collision with root package name */
    public final List f3162g;

    /* renamed from: h  reason: collision with root package name */
    public final Format f3163h;

    /* renamed from: i  reason: collision with root package name */
    public final List f3164i;

    /* renamed from: j  reason: collision with root package name */
    public final Map f3165j;

    /* renamed from: k  reason: collision with root package name */
    public final List f3166k;

    public e(String str, List list, List list2, List list3, List list4, List list5, List list6, Format format, List list7, boolean z3, Map map, List list8) {
        super(str, list, z3);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list2.size(); i3++) {
            Uri uri = ((d) list2.get(i3)).f3156a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        a(arrayList, list3);
        a(arrayList, list4);
        a(arrayList, list5);
        a(arrayList, list6);
        this.d = Collections.unmodifiableList(arrayList);
        this.f3160e = Collections.unmodifiableList(list2);
        Collections.unmodifiableList(list3);
        this.f3161f = Collections.unmodifiableList(list4);
        this.f3162g = Collections.unmodifiableList(list5);
        Collections.unmodifiableList(list6);
        this.f3163h = format;
        this.f3164i = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f3165j = Collections.unmodifiableMap(map);
        this.f3166k = Collections.unmodifiableList(list8);
    }

    public static void a(ArrayList arrayList, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            Uri uri = ((c) list.get(i3)).f3155a;
            if (uri != null && !arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
    }
}
