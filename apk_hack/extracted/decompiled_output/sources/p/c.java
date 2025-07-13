package p;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import i.g0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements g0, i.d0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3059a = 1;
    public final Object b;
    public final Object c;

    public c(Bitmap bitmap, j.b bVar) {
        c0.g.c(bitmap, "Bitmap must not be null");
        this.b = bitmap;
        c0.g.c(bVar, "BitmapPool must not be null");
        this.c = bVar;
    }

    public static c b(Bitmap bitmap, j.b bVar) {
        if (bitmap == null) {
            return null;
        }
        return new c(bitmap, bVar);
    }

    @Override // i.g0
    public final Class a() {
        switch (this.f3059a) {
            case 0:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    @Override // i.g0
    public final Object get() {
        switch (this.f3059a) {
            case 0:
                return (Bitmap) this.b;
            default:
                return new BitmapDrawable((Resources) this.b, (Bitmap) ((g0) this.c).get());
        }
    }

    @Override // i.g0
    public final int getSize() {
        switch (this.f3059a) {
            case 0:
                return c0.n.c((Bitmap) this.b);
            default:
                return ((g0) this.c).getSize();
        }
    }

    @Override // i.d0
    public final void initialize() {
        switch (this.f3059a) {
            case 0:
                ((Bitmap) this.b).prepareToDraw();
                return;
            default:
                g0 g0Var = (g0) this.c;
                if (g0Var instanceof i.d0) {
                    ((i.d0) g0Var).initialize();
                    return;
                }
                return;
        }
    }

    @Override // i.g0
    public final void recycle() {
        switch (this.f3059a) {
            case 0:
                ((j.b) this.c).e((Bitmap) this.b);
                return;
            default:
                ((g0) this.c).recycle();
                return;
        }
    }

    public c(Resources resources, g0 g0Var) {
        c0.g.c(resources, "Argument must not be null");
        this.b = resources;
        c0.g.c(g0Var, "Argument must not be null");
        this.c = g0Var;
    }
}
