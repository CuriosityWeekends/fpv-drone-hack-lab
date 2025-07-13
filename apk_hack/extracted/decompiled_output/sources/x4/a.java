package x4;

import android.animation.ValueAnimator;
import moe.codeest.enviews.ENDownloadView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3976a;
    public final /* synthetic */ ENDownloadView b;

    public /* synthetic */ a(ENDownloadView eNDownloadView, int i3) {
        this.f3976a = i3;
        this.b = eNDownloadView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ENDownloadView eNDownloadView = this.b;
        switch (this.f3976a) {
            case 0:
                eNDownloadView.f2882l = valueAnimator.getAnimatedFraction();
                eNDownloadView.invalidate();
                return;
            default:
                eNDownloadView.f2882l = valueAnimator.getAnimatedFraction();
                if (eNDownloadView.s != 5) {
                    int i3 = ENDownloadView.f2873t;
                }
                eNDownloadView.invalidate();
                return;
        }
    }
}
