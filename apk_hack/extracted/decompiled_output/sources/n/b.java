package n;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import m.q;
import m.r;
import m.y;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements r {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2902a;
    public final Class b;

    public b(Context context, Class cls) {
        this.f2902a = context;
        this.b = cls;
    }

    @Override // m.r
    public final q n(y yVar) {
        Class cls = this.b;
        return new d(this.f2902a, yVar.c(File.class, cls), yVar.c(Uri.class, cls), cls);
    }
}
