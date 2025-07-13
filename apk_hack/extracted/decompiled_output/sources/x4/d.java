package x4;

import android.animation.ValueAnimator;
import moe.codeest.enviews.ENPlayView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3978a;
    public final /* synthetic */ ENPlayView b;

    public /* synthetic */ d(ENPlayView eNPlayView, int i3) {
        this.f3978a = i3;
        this.b = eNPlayView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f3978a) {
            case 0:
                float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
                ENPlayView eNPlayView = this.b;
                eNPlayView.f2895k = animatedFraction;
                eNPlayView.invalidate();
                return;
            default:
                float animatedFraction2 = valueAnimator.getAnimatedFraction();
                ENPlayView eNPlayView2 = this.b;
                eNPlayView2.f2895k = animatedFraction2;
                eNPlayView2.invalidate();
                return;
        }
    }
}
