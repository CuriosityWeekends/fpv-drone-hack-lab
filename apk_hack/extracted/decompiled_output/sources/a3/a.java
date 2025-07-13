package a3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.jaygoo.widget.RangeSeekBar;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f82a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(int i3, Object obj) {
        this.f82a = i3;
        this.b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f82a) {
            case 0:
                super.onAnimationEnd(animator);
                ((b) this.b).f83a = false;
                return;
            case 1:
                super.onAnimationEnd(animator);
                ((b) this.b).f83a = false;
                return;
            default:
                r2.e eVar = (r2.e) this.b;
                eVar.f3435y = 0.0f;
                RangeSeekBar rangeSeekBar = eVar.I;
                if (rangeSeekBar != null) {
                    rangeSeekBar.invalidate();
                    return;
                }
                return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f82a) {
            case 0:
                super.onAnimationStart(animator);
                ((b) this.b).f83a = true;
                return;
            case 1:
                super.onAnimationStart(animator);
                ((b) this.b).f83a = true;
                return;
            default:
                super.onAnimationStart(animator);
                return;
        }
    }
}
