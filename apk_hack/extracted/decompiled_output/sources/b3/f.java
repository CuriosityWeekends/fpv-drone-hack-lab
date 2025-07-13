package b3;

import androidx.lifecycle.Lifecycle;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.BubbleAttachPopupView;
import com.lxj.xpopup.core.PositionPopupView;
import com.lxj.xpopup.impl.FullScreenPopupView;
import com.lxj.xpopup.impl.PartShadowPopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasePopupView f172a;

    public f(BasePopupView basePopupView) {
        this.f172a = basePopupView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BasePopupView basePopupView = this.f172a;
        if (basePopupView.getHostWindow() == null) {
            return;
        }
        a1.m mVar = basePopupView.f1034a;
        if (mVar != null) {
            mVar.getClass();
        }
        basePopupView.getClass();
        basePopupView.f1039i.handleLifecycleEvent(Lifecycle.Event.ON_START);
        if (!(basePopupView instanceof FullScreenPopupView)) {
            basePopupView.h();
        }
        if (!(basePopupView instanceof AttachPopupView) && !(basePopupView instanceof BubbleAttachPopupView) && !(basePopupView instanceof PositionPopupView) && !(basePopupView instanceof PartShadowPopupView)) {
            basePopupView.i();
            basePopupView.g();
            basePopupView.d();
        }
    }
}
