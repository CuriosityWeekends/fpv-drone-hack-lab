package x4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import moe.codeest.enviews.ENDownloadView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3977a;
    public final /* synthetic */ ENDownloadView b;

    public /* synthetic */ b(ENDownloadView eNDownloadView, int i3) {
        this.f3977a = i3;
        this.b = eNDownloadView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f3977a) {
            case 0:
                ENDownloadView eNDownloadView = this.b;
                eNDownloadView.f2874a = 1;
                ENDownloadView.a(eNDownloadView);
                return;
            default:
                ENDownloadView eNDownloadView2 = this.b;
                eNDownloadView2.f2874a = 1;
                ENDownloadView.a(eNDownloadView2);
                return;
        }
    }
}
