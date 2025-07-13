package d3;

import com.lxj.easyadapter.EasyAdapter;
import com.lxj.xpopup.impl.BottomListPopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends com.bumptech.glide.e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ EasyAdapter f1642e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ BottomListPopupView f1643f;

    public c(BottomListPopupView bottomListPopupView, a aVar) {
        this.f1643f = bottomListPopupView;
        this.f1642e = aVar;
    }

    @Override // com.bumptech.glide.e
    public final void e(int i3) {
        int i5 = BottomListPopupView.w;
        BottomListPopupView bottomListPopupView = this.f1643f;
        bottomListPopupView.getClass();
        if (bottomListPopupView.f1077v != -1) {
            bottomListPopupView.f1077v = i3;
            this.f1642e.notifyDataSetChanged();
        }
        bottomListPopupView.f1034a.getClass();
        bottomListPopupView.b();
    }
}
