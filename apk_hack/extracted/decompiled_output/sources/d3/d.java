package d3;

import com.lxj.easyadapter.EasyAdapter;
import com.lxj.xpopup.impl.CenterListPopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d extends com.bumptech.glide.e {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ EasyAdapter f1644e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ CenterListPopupView f1645f;

    public d(CenterListPopupView centerListPopupView, a aVar) {
        this.f1645f = centerListPopupView;
        this.f1644e = aVar;
    }

    @Override // com.bumptech.glide.e
    public final void e(int i3) {
        int i5 = CenterListPopupView.f1078v;
        CenterListPopupView centerListPopupView = this.f1645f;
        centerListPopupView.getClass();
        if (centerListPopupView.f1080u != -1) {
            centerListPopupView.f1080u = i3;
            this.f1644e.notifyDataSetChanged();
        }
        centerListPopupView.f1034a.getClass();
        centerListPopupView.b();
    }
}
