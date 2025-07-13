package n1;

import com.google.android.exoplayer2.Format;
import g2.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public final Format f2937a;
    public final String b;
    public final long c;
    public final List d;

    /* renamed from: e  reason: collision with root package name */
    public final i f2938e;

    public l(Format format, String str, r rVar, ArrayList arrayList) {
        this.f2937a = format;
        this.b = str;
        this.d = Collections.unmodifiableList(arrayList);
        this.f2938e = rVar.a(this);
        this.c = w.B(rVar.c, 1000000L, rVar.b);
    }

    public abstract String b();

    public abstract m1.i d();

    public abstract i f();
}
