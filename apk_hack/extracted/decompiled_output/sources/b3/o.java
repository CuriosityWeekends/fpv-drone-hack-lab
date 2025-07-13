package b3;

import android.app.Dialog;
import android.os.Bundle;
import android.view.WindowManager;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.impl.ConfirmPopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public BasePopupView f181a;

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        BasePopupView basePopupView;
        a1.m mVar;
        super.onCreate(bundle);
        if (getWindow() != null && (basePopupView = this.f181a) != null && (mVar = basePopupView.f1034a) != null) {
            mVar.getClass();
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().getAttributes().format = -2;
            getWindow().setFlags(16777216, 16777216);
            getWindow().setSoftInputMode(16);
            getWindow().setLayout(-1, -1);
            getWindow().getDecorView().setSystemUiVisibility(1280);
            getWindow().setBackgroundDrawable(null);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags &= -201326593;
            getWindow().setAttributes(attributes);
            getWindow().setStatusBarColor(0);
            this.f181a.f1034a.getClass();
            int i3 = z2.e.f4295a;
            getWindow().addFlags(Integer.MIN_VALUE);
            this.f181a.f1034a.getClass();
            this.f181a.f1034a.getClass();
            this.f181a.f1034a.getClass();
            this.f181a.f1034a.getClass();
            this.f181a.f1034a.getClass();
            this.f181a.f1034a.getClass();
            setContentView(this.f181a);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        BasePopupView basePopupView;
        super.onWindowFocusChanged(z3);
        this.f181a.f1034a.getClass();
        this.f181a.f1034a.getClass();
        int i3 = z2.e.f4295a;
        this.f181a.f1034a.getClass();
        this.f181a.f1034a.getClass();
        if (z3 && (basePopupView = this.f181a) != null && basePopupView.f1037g && basePopupView.f1035e == 1) {
            basePopupView.h();
            com.lxj.xpopup.util.d.b((ConfirmPopupView) this.f181a);
        }
    }
}
