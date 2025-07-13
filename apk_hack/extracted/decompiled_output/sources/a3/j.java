package a3;

import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j extends b {

    /* renamed from: f  reason: collision with root package name */
    public float f94f;

    /* renamed from: g  reason: collision with root package name */
    public float f95g;

    /* renamed from: h  reason: collision with root package name */
    public float f96h;

    /* renamed from: i  reason: collision with root package name */
    public float f97i;

    @Override // a3.b
    public final void a() {
        ViewPropertyAnimator translationX;
        if (this.f83a) {
            return;
        }
        switch (com.bumptech.glide.i.b(this.f84e)) {
            case 9:
                this.f94f = -this.c.getRight();
                translationX = this.c.animate().translationX(this.f94f);
                break;
            case 10:
                this.f94f = ((View) this.c.getParent()).getMeasuredWidth() - this.c.getLeft();
                translationX = this.c.animate().translationX(this.f94f);
                break;
            case 11:
                this.f95g = -this.c.getBottom();
                translationX = this.c.animate().translationY(this.f95g);
                break;
            case 12:
                this.f95g = ((View) this.c.getParent()).getMeasuredHeight() - this.c.getTop();
                translationX = this.c.animate().translationY(this.f95g);
                break;
            default:
                translationX = null;
                break;
        }
        if (translationX != null) {
            ViewPropertyAnimator withLayer = translationX.setInterpolator(new FastOutSlowInInterpolator()).setDuration((long) (this.d * 0.8d)).withLayer();
            withLayer.setListener(new a(1, this));
            withLayer.start();
        }
    }

    @Override // a3.b
    public final void b() {
        ViewPropertyAnimator translationX;
        switch (com.bumptech.glide.i.b(this.f84e)) {
            case 9:
            case 10:
                translationX = this.c.animate().translationX(this.f96h);
                break;
            case 11:
            case 12:
                translationX = this.c.animate().translationY(this.f97i);
                break;
            default:
                translationX = null;
                break;
        }
        if (translationX != null) {
            translationX.setInterpolator(new FastOutSlowInInterpolator()).setDuration(this.d).withLayer().start();
        }
        Log.e("part", "start: " + this.c.getTranslationY() + "  endy: " + this.f97i);
    }

    @Override // a3.b
    public final void c() {
        if (!this.b) {
            this.f96h = this.c.getTranslationX();
            this.f97i = this.c.getTranslationY();
            switch (com.bumptech.glide.i.b(this.f84e)) {
                case 9:
                    View view = this.c;
                    view.setTranslationX(this.c.getTranslationX() + (-view.getRight()));
                    break;
                case 10:
                    View view2 = this.c;
                    view2.setTranslationX(this.c.getTranslationX() + (((View) view2.getParent()).getMeasuredWidth() - this.c.getLeft()));
                    break;
                case 11:
                    View view3 = this.c;
                    view3.setTranslationY(this.c.getTranslationY() + (-view3.getBottom()));
                    break;
                case 12:
                    View view4 = this.c;
                    view4.setTranslationY(this.c.getTranslationY() + (((View) view4.getParent()).getMeasuredHeight() - this.c.getTop()));
                    break;
            }
            this.f94f = this.c.getTranslationX();
            this.f95g = this.c.getTranslationY();
        }
    }
}
