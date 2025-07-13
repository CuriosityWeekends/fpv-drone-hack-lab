package x2;

import android.view.View;
import com.lg.picturesubmitt.widget.VTrimView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3973a;
    public final /* synthetic */ VTrimView b;

    public /* synthetic */ o(VTrimView vTrimView, int i3) {
        this.f3973a = i3;
        this.b = vTrimView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3973a) {
            case 0:
                this.b.a(false);
                return;
            default:
                this.b.a(true);
                return;
        }
    }
}
