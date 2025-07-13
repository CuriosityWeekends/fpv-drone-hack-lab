package b3;

import com.lxj.xpopup.core.BubbleAttachPopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f178a;
    public final /* synthetic */ BubbleAttachPopupView b;

    public /* synthetic */ l(BubbleAttachPopupView bubbleAttachPopupView, int i3) {
        this.f178a = i3;
        this.b = bubbleAttachPopupView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f178a) {
            case 0:
                this.b.p();
                return;
            default:
                this.b.p();
                return;
        }
    }
}
