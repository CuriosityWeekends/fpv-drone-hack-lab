package z;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import c0.g;
import com.bumptech.glide.k;
import java.util.ArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends a {

    /* renamed from: e  reason: collision with root package name */
    public static final int f4262e = k.glide_custom_view_target_tag;

    /* renamed from: a  reason: collision with root package name */
    public final View f4263a;
    public final f b;
    public Animatable c;
    public final /* synthetic */ int d;

    public b(ImageView imageView, int i3) {
        this.d = i3;
        g.c(imageView, "Argument must not be null");
        this.f4263a = imageView;
        this.b = new f(imageView);
    }

    @Override // z.d
    public final void a(c cVar) {
        int i3;
        f fVar = this.b;
        View view = fVar.f4265a;
        int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i5 = 0;
        if (layoutParams != null) {
            i3 = layoutParams.width;
        } else {
            i3 = 0;
        }
        int a5 = fVar.a(view.getWidth(), i3, paddingRight);
        View view2 = fVar.f4265a;
        int paddingBottom = view2.getPaddingBottom() + view2.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
        if (layoutParams2 != null) {
            i5 = layoutParams2.height;
        }
        int a6 = fVar.a(view2.getHeight(), i5, paddingBottom);
        if ((a5 <= 0 && a5 != Integer.MIN_VALUE) || (a6 <= 0 && a6 != Integer.MIN_VALUE)) {
            ArrayList arrayList = fVar.b;
            if (!arrayList.contains(cVar)) {
                arrayList.add(cVar);
            }
            if (fVar.c == null) {
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                e eVar = new e(fVar);
                fVar.c = eVar;
                viewTreeObserver.addOnPreDrawListener(eVar);
                return;
            }
            return;
        }
        ((y.g) cVar).m(a5, a6);
    }

    @Override // z.d
    public final void b(Drawable drawable) {
        j(null);
        this.c = null;
        ((ImageView) this.f4263a).setImageDrawable(drawable);
    }

    @Override // z.d
    public final void c(Drawable drawable) {
        j(null);
        this.c = null;
        ((ImageView) this.f4263a).setImageDrawable(drawable);
    }

    @Override // z.d
    public final void d(y.c cVar) {
        this.f4263a.setTag(f4262e, cVar);
    }

    @Override // z.d
    public final y.c e() {
        Object tag = this.f4263a.getTag(f4262e);
        if (tag != null) {
            if (tag instanceof y.c) {
                return (y.c) tag;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }

    @Override // z.d
    public final void f(Drawable drawable) {
        f fVar = this.b;
        ViewTreeObserver viewTreeObserver = fVar.f4265a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(fVar.c);
        }
        fVar.c = null;
        fVar.b.clear();
        Animatable animatable = this.c;
        if (animatable != null) {
            animatable.stop();
        }
        j(null);
        this.c = null;
        ((ImageView) this.f4263a).setImageDrawable(drawable);
    }

    @Override // z.d
    public final void g(Object obj) {
        j(obj);
        if (obj instanceof Animatable) {
            Animatable animatable = (Animatable) obj;
            this.c = animatable;
            animatable.start();
            return;
        }
        this.c = null;
    }

    @Override // z.d
    public final void h(c cVar) {
        this.b.b.remove(cVar);
    }

    public final void j(Object obj) {
        switch (this.d) {
            case 0:
                ((ImageView) this.f4263a).setImageBitmap((Bitmap) obj);
                return;
            default:
                ((ImageView) this.f4263a).setImageDrawable((Drawable) obj);
                return;
        }
    }

    @Override // v.f
    public final void onStart() {
        Animatable animatable = this.c;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // v.f
    public final void onStop() {
        Animatable animatable = this.c;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public final String toString() {
        return "Target for: " + this.f4263a;
    }
}
