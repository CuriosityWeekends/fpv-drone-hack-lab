package n;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import g.h;
import m.p;
import m.q;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements q {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2911a;
    public final q b;
    public final q c;
    public final Class d;

    public d(Context context, q qVar, q qVar2, Class cls) {
        this.f2911a = context.getApplicationContext();
        this.b = qVar;
        this.c = qVar2;
        this.d = cls;
    }

    @Override // m.q
    public final p a(Object obj, int i3, int i5, h hVar) {
        Uri uri = (Uri) obj;
        return new p(new b0.b(uri), new c(this.f2911a, this.b, this.c, uri, i3, i5, hVar, this.d));
    }

    @Override // m.q
    public final boolean b(Object obj) {
        Uri uri = (Uri) obj;
        if (Build.VERSION.SDK_INT >= 29 && com.bumptech.glide.d.g(uri)) {
            return true;
        }
        return false;
    }
}
