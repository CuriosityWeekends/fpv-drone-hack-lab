package d4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.zhouyou.view.seekbar.SignSeekBar;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1648a;
    public final /* synthetic */ SignSeekBar b;

    public /* synthetic */ e(SignSeekBar signSeekBar, int i3) {
        this.f1648a = i3;
        this.b = signSeekBar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f1648a) {
            case 0:
                SignSeekBar signSeekBar = this.b;
                signSeekBar.L = false;
                signSeekBar.invalidate();
                return;
            default:
                SignSeekBar signSeekBar2 = this.b;
                signSeekBar2.c = (((signSeekBar2.I - signSeekBar2.P) * signSeekBar2.G) / signSeekBar2.J) + signSeekBar2.f1554a;
                signSeekBar2.L = false;
                signSeekBar2.T = true;
                signSeekBar2.invalidate();
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f1648a) {
            case 0:
                SignSeekBar signSeekBar = this.b;
                signSeekBar.L = false;
                signSeekBar.invalidate();
                if (signSeekBar.O != null) {
                    signSeekBar.getProgress();
                    signSeekBar.getProgressFloat();
                    return;
                }
                return;
            default:
                SignSeekBar signSeekBar2 = this.b;
                signSeekBar2.c = (((signSeekBar2.I - signSeekBar2.P) * signSeekBar2.G) / signSeekBar2.J) + signSeekBar2.f1554a;
                signSeekBar2.L = false;
                signSeekBar2.T = true;
                signSeekBar2.invalidate();
                if (signSeekBar2.O != null) {
                    signSeekBar2.getProgress();
                    signSeekBar2.getProgressFloat();
                    return;
                }
                return;
        }
    }
}
