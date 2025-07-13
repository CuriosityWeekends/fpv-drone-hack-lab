package x2;

import android.view.View;
import com.lg.picturesubmitt.widget.VTrimView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3974a;
    public final /* synthetic */ VTrimView b;

    public /* synthetic */ p(VTrimView vTrimView, int i3) {
        this.f3974a = i3;
        this.b = vTrimView;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        switch (this.f3974a) {
            case 0:
                VTrimView vTrimView = this.b;
                vTrimView.d = true;
                vTrimView.c.post(vTrimView.f997l);
                return true;
            default:
                VTrimView vTrimView2 = this.b;
                vTrimView2.f996k = true;
                vTrimView2.c.post(vTrimView2.f997l);
                return true;
        }
    }
}
