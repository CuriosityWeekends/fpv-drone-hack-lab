package b3;

import androidx.lifecycle.Lifecycle;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.impl.FullScreenPopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasePopupView f173a;

    public g(BasePopupView basePopupView) {
        this.f173a = basePopupView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BasePopupView basePopupView = this.f173a;
        basePopupView.f1035e = 1;
        basePopupView.f1039i.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        basePopupView.m();
        if (basePopupView instanceof FullScreenPopupView) {
            basePopupView.h();
        }
        if (basePopupView.getHostWindow() != null && com.lxj.xpopup.util.b.h(basePopupView.getHostWindow()) > 0 && !basePopupView.f1037g) {
            com.lxj.xpopup.util.b.f1113x = com.lxj.xpopup.util.b.h(basePopupView.getHostWindow());
            basePopupView.post(new c(basePopupView, 3));
        }
    }
}
