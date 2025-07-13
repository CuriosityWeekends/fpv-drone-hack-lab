package a4;

import android.animation.ValueAnimator;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f106a;
    public final /* synthetic */ BitmapDrawable b;

    public c(View view, BitmapDrawable bitmapDrawable) {
        this.f106a = view;
        this.b = bitmapDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f106a.invalidate(this.b.getBounds());
    }
}
