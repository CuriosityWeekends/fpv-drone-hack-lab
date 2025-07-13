package p;

import android.content.Context;
import android.graphics.Bitmap;
import i.g0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class d implements g.l {
    @Override // g.l
    public final g0 a(Context context, g0 g0Var, int i3, int i5) {
        if (c0.n.h(i3, i5)) {
            j.b bVar = com.bumptech.glide.b.b(context).f234a;
            Bitmap bitmap = (Bitmap) g0Var.get();
            if (i3 == Integer.MIN_VALUE) {
                i3 = bitmap.getWidth();
            }
            if (i5 == Integer.MIN_VALUE) {
                i5 = bitmap.getHeight();
            }
            Bitmap c = c(bVar, bitmap, i3, i5);
            if (!bitmap.equals(c)) {
                return c.b(c, bVar);
            }
            return g0Var;
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i3 + " or height: " + i5 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    public abstract Bitmap c(j.b bVar, Bitmap bitmap, int i3, int i5);
}
