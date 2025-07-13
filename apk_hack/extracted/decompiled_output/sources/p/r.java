package p;

import android.content.Context;
import android.graphics.drawable.Drawable;
import i.g0;
import java.security.MessageDigest;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r implements g.l {
    public final g.l b;
    public final boolean c;

    public r(g.l lVar, boolean z3) {
        this.b = lVar;
        this.c = z3;
    }

    @Override // g.l
    public final g0 a(Context context, g0 g0Var, int i3, int i5) {
        j.b bVar = com.bumptech.glide.b.b(context).f234a;
        Drawable drawable = (Drawable) g0Var.get();
        c a5 = q.a(bVar, drawable, i3, i5);
        if (a5 == null) {
            if (!this.c) {
                return g0Var;
            }
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
        g0 a6 = this.b.a(context, a5, i3, i5);
        if (a6.equals(a5)) {
            a6.recycle();
            return g0Var;
        }
        return new c(context.getResources(), a6);
    }

    @Override // g.e
    public final void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    @Override // g.e
    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.b.equals(((r) obj).b);
        }
        return false;
    }

    @Override // g.e
    public final int hashCode() {
        return this.b.hashCode();
    }
}
