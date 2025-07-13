package x2;

import android.view.MotionEvent;
import android.view.View;
import com.lg.picturesubmitt.widget.VTrimView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class q implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3975a;
    public final /* synthetic */ VTrimView b;

    public /* synthetic */ q(VTrimView vTrimView, int i3) {
        this.f3975a = i3;
        this.b = vTrimView;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f3975a) {
            case 0:
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    VTrimView vTrimView = this.b;
                    if (vTrimView.d) {
                        vTrimView.d = false;
                    }
                    vTrimView.c.removeCallbacks(vTrimView.f997l);
                }
                return false;
            default:
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    VTrimView vTrimView2 = this.b;
                    if (vTrimView2.f996k) {
                        vTrimView2.f996k = false;
                    }
                    vTrimView2.c.removeCallbacks(vTrimView2.f997l);
                }
                return false;
        }
    }
}
