package p;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import i.g0;
import java.io.InputStream;
import java.util.ArrayDeque;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements g.j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3056a;
    public final Object b;
    public final Object c;

    public /* synthetic */ a(int i3, Object obj, Object obj2) {
        this.f3056a = i3;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStream] */
    @Override // g.j
    public final g0 a(Object obj, int i3, int i5, g.h hVar) {
        w wVar;
        boolean z3;
        c0.e eVar;
        c0.e eVar2;
        switch (this.f3056a) {
            case 0:
                g0 a5 = ((g.j) this.b).a(obj, i3, i5, hVar);
                if (a5 == null) {
                    return null;
                }
                return new c((Resources) this.c, a5);
            case 1:
                return c(androidx.core.view.accessibility.a.d(obj), i3, i5, hVar);
            case 2:
                g0 c = ((r.b) this.b).c((Uri) obj);
                if (c == null) {
                    return null;
                }
                return q.a((j.b) this.c, (Drawable) ((r.a) c).get(), i3, i5);
            default:
                InputStream inputStream = (InputStream) obj;
                if (inputStream instanceof w) {
                    wVar = (w) inputStream;
                    z3 = false;
                } else {
                    wVar = new w(inputStream, (j.g) this.c);
                    z3 = true;
                }
                ArrayDeque arrayDeque = c0.e.c;
                synchronized (arrayDeque) {
                    eVar = (c0.e) arrayDeque.poll();
                    eVar2 = eVar;
                }
                if (eVar == null) {
                    eVar2 = new InputStream();
                }
                eVar2.f190a = wVar;
                c0.k kVar = new c0.k(eVar2);
                c1.b bVar = new c1.b(17, wVar, eVar2, false);
                try {
                    o oVar = (o) this.b;
                    return oVar.a(new i.b(oVar.c, kVar, oVar.d), i3, i5, hVar, bVar);
                } finally {
                    eVar2.a();
                    if (z3) {
                        wVar.b();
                    }
                }
        }
    }

    @Override // g.j
    public final boolean b(Object obj, g.h hVar) {
        switch (this.f3056a) {
            case 0:
                return ((g.j) this.b).b(obj, hVar);
            case 1:
                androidx.core.view.accessibility.a.s(obj);
                return true;
            case 2:
                return "android.resource".equals(((Uri) obj).getScheme());
            default:
                InputStream inputStream = (InputStream) obj;
                ((o) this.b).getClass();
                return true;
        }
    }

    public c c(ImageDecoder.Source source, int i3, int i5, g.h hVar) {
        boolean z3;
        Bitmap decodeBitmap;
        g.a aVar = (g.a) hVar.c(o.f3073f);
        m mVar = (m) hVar.c(m.f3070g);
        g.g gVar = o.f3076i;
        if (hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue()) {
            z3 = true;
        } else {
            z3 = false;
        }
        decodeBitmap = ImageDecoder.decodeBitmap(source, new o.d(this, i3, i5, z3, aVar, mVar, (g.i) hVar.c(o.f3074g)));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i3 + "x" + i5 + "]");
        }
        return new c(decodeBitmap, (j3.a) this.c);
    }

    public a() {
        this.f3056a = 1;
        this.b = u.a();
        this.c = new j3.a(7);
    }

    public a(Resources resources, g.j jVar) {
        this.f3056a = 0;
        this.c = resources;
        this.b = jVar;
    }
}
