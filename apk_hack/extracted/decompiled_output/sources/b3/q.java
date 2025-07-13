package b3;

import com.lxj.xpopup.core.PositionPopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f183a;
    public final /* synthetic */ PositionPopupView b;

    public /* synthetic */ q(PositionPopupView positionPopupView, int i3) {
        this.f183a = i3;
        this.b = positionPopupView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f183a) {
            case 0:
                PositionPopupView.p(this.b);
                return;
            default:
                PositionPopupView.p(this.b);
                return;
        }
    }
}
