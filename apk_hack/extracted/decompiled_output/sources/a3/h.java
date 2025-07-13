package a3;

import android.animation.ValueAnimator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f91a;
    public final /* synthetic */ i b;

    public /* synthetic */ h(i iVar, int i3) {
        this.f91a = i3;
        this.b = iVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f91a) {
            case 0:
                this.b.c.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                return;
            default:
                this.b.c.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                return;
        }
    }
}
