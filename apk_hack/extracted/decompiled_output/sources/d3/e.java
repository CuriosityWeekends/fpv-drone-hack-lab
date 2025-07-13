package d3;

import com.lxj.xpopup.impl.PartShadowPopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1646a;
    public final /* synthetic */ PartShadowPopupView b;

    public /* synthetic */ e(PartShadowPopupView partShadowPopupView, int i3) {
        this.f1646a = i3;
        this.b = partShadowPopupView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1646a) {
            case 0:
                this.b.p();
                return;
            default:
                this.b.p();
                return;
        }
    }
}
