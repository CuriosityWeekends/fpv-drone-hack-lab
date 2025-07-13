package x2;

import android.animation.Animator;
import android.util.Log;
import android.view.View;
import com.lg.picturesubmitt.widget.TrackControlPaintView;
import com.lg.picturesubmitt.widget.TrackControlPaintViewJY;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3967a;
    public final /* synthetic */ View b;

    public /* synthetic */ j(View view, int i3) {
        this.f3967a = i3;
        this.b = view;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f3967a) {
            case 0:
                Log.d("trackControlAnimator", "onAnimationCancel");
                return;
            default:
                Log.d("trackControlAnimator", "onAnimationCancel");
                return;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f3967a) {
            case 0:
                Log.d("trackControlAnimator", "onAnimationEnd");
                k kVar = ((TrackControlPaintView) this.b).f966o;
                if (kVar != null) {
                    kVar.a(0.0f, 0.0f);
                    return;
                }
                return;
            default:
                Log.d("trackControlAnimator", "onAnimationEnd");
                m mVar = ((TrackControlPaintViewJY) this.b).f983o;
                if (mVar != null) {
                    mVar.a(0.0f, 0.0f);
                    return;
                }
                return;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        int i3 = this.f3967a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f3967a) {
            case 0:
                Log.d("trackControlAnimator", "onAnimationStart");
                return;
            default:
                Log.d("trackControlAnimator", "onAnimationStart");
                return;
        }
    }

    private final void a(Animator animator) {
    }

    private final void b(Animator animator) {
    }
}
