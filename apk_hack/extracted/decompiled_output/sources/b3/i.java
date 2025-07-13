package b3;

import android.view.KeyEvent;
import android.view.View;
import com.lxj.xpopup.core.BasePopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasePopupView f175a;

    public i(BasePopupView basePopupView) {
        this.f175a = basePopupView;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
        return this.f175a.n(i3, keyEvent);
    }
}
