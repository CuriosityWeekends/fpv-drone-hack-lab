package x2;

import android.view.MotionEvent;
import android.view.View;
import com.lg.picturesubmitt.widget.HTrimView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3966a;
    public final /* synthetic */ HTrimView b;

    public /* synthetic */ f(HTrimView hTrimView, int i3) {
        this.f3966a = i3;
        this.b = hTrimView;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f3966a) {
            case 0:
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    HTrimView hTrimView = this.b;
                    if (hTrimView.d) {
                        hTrimView.d = false;
                    }
                    hTrimView.c.removeCallbacks(hTrimView.f919l);
                }
                return false;
            default:
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    HTrimView hTrimView2 = this.b;
                    if (hTrimView2.f918k) {
                        hTrimView2.f918k = false;
                    }
                    hTrimView2.c.removeCallbacks(hTrimView2.f919l);
                }
                return false;
        }
    }
}
