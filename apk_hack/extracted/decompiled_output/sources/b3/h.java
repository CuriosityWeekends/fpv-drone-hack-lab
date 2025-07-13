package b3;

import androidx.lifecycle.Lifecycle;
import com.lxj.xpopup.core.BasePopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasePopupView f174a;

    public h(BasePopupView basePopupView) {
        this.f174a = basePopupView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BasePopupView basePopupView = this.f174a;
        basePopupView.f1035e = 3;
        basePopupView.f1039i.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        if (basePopupView.f1034a == null) {
            return;
        }
        basePopupView.l();
        int i3 = z2.e.f4295a;
        basePopupView.f1034a.getClass();
        basePopupView.f1034a.getClass();
        basePopupView.f1034a.getClass();
        o oVar = basePopupView.f1040j;
        if (oVar != null) {
            oVar.dismiss();
        }
    }
}
