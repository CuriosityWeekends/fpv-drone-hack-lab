package b3;

import com.lxj.xpopup.core.DrawerPopupView;
import com.lxj.xpopup.widget.PopupDrawerLayout;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n implements PopupDrawerLayout.OnCloseListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrawerPopupView f180a;

    public n(DrawerPopupView drawerPopupView) {
        this.f180a = drawerPopupView;
    }

    @Override // com.lxj.xpopup.widget.PopupDrawerLayout.OnCloseListener
    public final void onClose() {
        DrawerPopupView drawerPopupView = this.f180a;
        drawerPopupView.getClass();
        a1.m mVar = drawerPopupView.f1034a;
        if (mVar != null) {
            mVar.getClass();
        }
        drawerPopupView.c();
    }

    @Override // com.lxj.xpopup.widget.PopupDrawerLayout.OnCloseListener
    public final void onDrag(int i3, float f4, boolean z3) {
        DrawerPopupView drawerPopupView = this.f180a;
        a1.m mVar = drawerPopupView.f1034a;
        if (mVar == null) {
            return;
        }
        mVar.getClass();
        a3.i iVar = drawerPopupView.c;
        iVar.c.setBackgroundColor(((Integer) iVar.f92f.evaluate(f4, 0, Integer.valueOf(iVar.f93g))).intValue());
        drawerPopupView.postInvalidate();
    }

    @Override // com.lxj.xpopup.widget.PopupDrawerLayout.OnCloseListener
    public final void onOpen() {
    }
}
