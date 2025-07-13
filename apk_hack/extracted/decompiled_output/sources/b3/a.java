package b3;

import com.lxj.xpopup.core.AttachPopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f167a;
    public final /* synthetic */ AttachPopupView b;

    public /* synthetic */ a(AttachPopupView attachPopupView, int i3) {
        this.f167a = i3;
        this.b = attachPopupView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f167a) {
            case 0:
                this.b.p();
                return;
            default:
                this.b.p();
                return;
        }
    }
}
