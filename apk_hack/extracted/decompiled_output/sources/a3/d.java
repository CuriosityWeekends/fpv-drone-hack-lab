package a3;

import android.view.ViewPropertyAnimator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d extends b {
    @Override // a3.b
    public final void a() {
        if (this.f83a) {
            return;
        }
        ViewPropertyAnimator interpolator = this.c.animate().scaleX(0.95f).scaleY(0.95f).alpha(0.0f).setDuration(this.d).setInterpolator(new FastOutSlowInInterpolator());
        interpolator.setListener(new a(1, this));
        interpolator.start();
    }

    @Override // a3.b
    public final void b() {
        this.c.post(new c(this, 1));
    }

    @Override // a3.b
    public final void c() {
        this.c.setScaleX(0.95f);
        this.c.setScaleY(0.95f);
        this.c.setAlpha(0.0f);
        this.c.post(new c(this, 0));
    }
}
