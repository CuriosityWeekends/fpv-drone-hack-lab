package b3;

import com.lxj.xpopup.core.PositionPopupView;
import com.lxj.xpopup.widget.PositionPopupContainer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r implements PositionPopupContainer.OnPositionDragListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PositionPopupView f184a;

    public r(PositionPopupView positionPopupView) {
        this.f184a = positionPopupView;
    }

    @Override // com.lxj.xpopup.widget.PositionPopupContainer.OnPositionDragListener
    public final void onDismiss() {
        this.f184a.b();
    }
}
