package r;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import c0.g;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.p;
import f.d;
import i.d0;
import i.g0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements g0, d0 {

    /* renamed from: a  reason: collision with root package name */
    public final Drawable f3367a;
    public final /* synthetic */ int b;

    public a(Drawable drawable, int i3) {
        this.b = i3;
        g.c(drawable, "Argument must not be null");
        this.f3367a = drawable;
    }

    @Override // i.g0
    public final Class a() {
        switch (this.b) {
            case 0:
                return this.f3367a.getClass();
            default:
                return GifDrawable.class;
        }
    }

    public final void b() {
        Drawable drawable = this.f3367a;
        if (drawable instanceof BitmapDrawable) {
            ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
        } else if (drawable instanceof GifDrawable) {
            ((GifDrawable) drawable).f267a.f3551a.f3565l.prepareToDraw();
        }
    }

    @Override // i.g0
    public final Object get() {
        Drawable drawable = this.f3367a;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            return constantState.newDrawable();
        }
        return drawable;
    }

    @Override // i.g0
    public final int getSize() {
        switch (this.b) {
            case 0:
                Drawable drawable = this.f3367a;
                return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
            default:
                t.g gVar = ((GifDrawable) this.f3367a).f267a.f3551a;
                d dVar = gVar.f3557a;
                return (dVar.f1789j.length * 4) + dVar.d.limit() + dVar.f1788i.length + gVar.f3567n;
        }
    }

    @Override // i.d0
    public void initialize() {
        switch (this.b) {
            case 1:
                ((GifDrawable) this.f3367a).f267a.f3551a.f3565l.prepareToDraw();
                return;
            default:
                b();
                return;
        }
    }

    @Override // i.g0
    public final void recycle() {
        j.g gVar;
        j.g gVar2;
        j.g gVar3;
        switch (this.b) {
            case 0:
                return;
            default:
                GifDrawable gifDrawable = (GifDrawable) this.f3367a;
                gifDrawable.stop();
                gifDrawable.d = true;
                t.g gVar4 = gifDrawable.f267a.f3551a;
                gVar4.c.clear();
                Bitmap bitmap = gVar4.f3565l;
                if (bitmap != null) {
                    gVar4.f3558e.e(bitmap);
                    gVar4.f3565l = null;
                }
                gVar4.f3559f = false;
                t.d dVar = gVar4.f3562i;
                p pVar = gVar4.d;
                if (dVar != null) {
                    pVar.j(dVar);
                    gVar4.f3562i = null;
                }
                t.d dVar2 = gVar4.f3564k;
                if (dVar2 != null) {
                    pVar.j(dVar2);
                    gVar4.f3564k = null;
                }
                t.d dVar3 = gVar4.f3566m;
                if (dVar3 != null) {
                    pVar.j(dVar3);
                    gVar4.f3566m = null;
                }
                d dVar4 = gVar4.f3557a;
                dVar4.f1791l = null;
                byte[] bArr = dVar4.f1788i;
                c1.b bVar = dVar4.c;
                if (bArr != null && (gVar3 = (j.g) bVar.c) != null) {
                    gVar3.h(bArr);
                }
                int[] iArr = dVar4.f1789j;
                if (iArr != null && (gVar2 = (j.g) bVar.c) != null) {
                    gVar2.h(iArr);
                }
                Bitmap bitmap2 = dVar4.f1792m;
                if (bitmap2 != null) {
                    ((j.b) bVar.b).e(bitmap2);
                }
                dVar4.f1792m = null;
                dVar4.d = null;
                dVar4.s = null;
                byte[] bArr2 = dVar4.f1784e;
                if (bArr2 != null && (gVar = (j.g) bVar.c) != null) {
                    gVar.h(bArr2);
                }
                gVar4.f3563j = true;
                return;
        }
    }

    private final void c() {
    }
}
