package a3;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i extends b {

    /* renamed from: f  reason: collision with root package name */
    public ArgbEvaluator f92f;

    /* renamed from: g  reason: collision with root package name */
    public int f93g;

    @Override // a3.b
    public final void a() {
        if (this.f83a) {
            return;
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f92f, Integer.valueOf(this.f93g), 0);
        ofObject.addUpdateListener(new h(this, 1));
        ofObject.removeAllListeners();
        ofObject.addListener(new a(0, this));
        ofObject.setInterpolator(new FastOutSlowInInterpolator());
        ofObject.setDuration(this.d).start();
    }

    @Override // a3.b
    public final void b() {
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f92f, 0, Integer.valueOf(this.f93g));
        ofObject.addUpdateListener(new h(this, 0));
        ofObject.setInterpolator(new FastOutSlowInInterpolator());
        ofObject.setDuration(this.d).start();
    }

    @Override // a3.b
    public final void c() {
        this.c.setBackgroundColor(0);
    }
}
