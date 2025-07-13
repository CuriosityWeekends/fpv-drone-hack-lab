package b3;

import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.widget.SmartDragLayout;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j implements SmartDragLayout.OnCloseListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BottomPopupView f176a;

    public j(BottomPopupView bottomPopupView) {
        this.f176a = bottomPopupView;
    }

    @Override // com.lxj.xpopup.widget.SmartDragLayout.OnCloseListener
    public final void onClose() {
        BottomPopupView bottomPopupView = this.f176a;
        bottomPopupView.getClass();
        a1.m mVar = bottomPopupView.f1034a;
        if (mVar != null) {
            mVar.getClass();
        }
        bottomPopupView.c();
    }

    @Override // com.lxj.xpopup.widget.SmartDragLayout.OnCloseListener
    public final void onDrag(int i3, float f4, boolean z3) {
        BottomPopupView bottomPopupView = this.f176a;
        a1.m mVar = bottomPopupView.f1034a;
        if (mVar == null) {
            return;
        }
        mVar.getClass();
        bottomPopupView.f1034a.getClass();
        a3.i iVar = bottomPopupView.c;
        bottomPopupView.setBackgroundColor(((Integer) iVar.f92f.evaluate(f4, 0, Integer.valueOf(iVar.f93g))).intValue());
    }

    @Override // com.lxj.xpopup.widget.SmartDragLayout.OnCloseListener
    public final void onOpen() {
    }
}
