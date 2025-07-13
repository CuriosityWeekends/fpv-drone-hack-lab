package t;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import g.l;
import i.g0;
import java.security.MessageDigest;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements l {
    public final l b;

    public c(l lVar) {
        c0.g.c(lVar, "Argument must not be null");
        this.b = lVar;
    }

    @Override // g.l
    public final g0 a(Context context, g0 g0Var, int i3, int i5) {
        GifDrawable gifDrawable = (GifDrawable) g0Var.get();
        g0 cVar = new p.c(gifDrawable.f267a.f3551a.f3565l, com.bumptech.glide.b.b(context).f234a);
        l lVar = this.b;
        g0 a5 = lVar.a(context, cVar, i3, i5);
        if (!cVar.equals(a5)) {
            cVar.recycle();
        }
        gifDrawable.f267a.f3551a.c(lVar, (Bitmap) a5.get());
        return g0Var;
    }

    @Override // g.e
    public final void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    @Override // g.e
    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.b.equals(((c) obj).b);
        }
        return false;
    }

    @Override // g.e
    public final int hashCode() {
        return this.b.hashCode();
    }
}
