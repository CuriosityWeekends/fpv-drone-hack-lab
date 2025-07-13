package b3;

import android.graphics.PointF;
import com.lxj.xpopup.core.HorizontalAttachPopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f182a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ HorizontalAttachPopupView d;

    public p(HorizontalAttachPopupView horizontalAttachPopupView, boolean z3, int i3, int i5) {
        this.d = horizontalAttachPopupView;
        this.f182a = z3;
        this.b = i3;
        this.c = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float f4;
        float g5;
        boolean z3 = this.f182a;
        HorizontalAttachPopupView horizontalAttachPopupView = this.d;
        if (z3) {
            if (horizontalAttachPopupView.s) {
                g5 = (com.lxj.xpopup.util.b.g(horizontalAttachPopupView.getContext()) - ((PointF) horizontalAttachPopupView.f1034a.b).x) + horizontalAttachPopupView.f1029p;
            } else {
                g5 = ((com.lxj.xpopup.util.b.g(horizontalAttachPopupView.getContext()) - ((PointF) horizontalAttachPopupView.f1034a.b).x) - horizontalAttachPopupView.getPopupContentView().getMeasuredWidth()) - horizontalAttachPopupView.f1029p;
            }
            horizontalAttachPopupView.f1060x = -g5;
        } else {
            int i3 = HorizontalAttachPopupView.f1059z;
            if (horizontalAttachPopupView.r()) {
                f4 = (((PointF) horizontalAttachPopupView.f1034a.b).x - this.b) - horizontalAttachPopupView.f1029p;
            } else {
                f4 = ((PointF) horizontalAttachPopupView.f1034a.b).x + horizontalAttachPopupView.f1029p;
            }
            horizontalAttachPopupView.f1060x = f4;
        }
        horizontalAttachPopupView.f1061y = (((PointF) horizontalAttachPopupView.f1034a.b).y - (this.c * 0.5f)) + 0;
        horizontalAttachPopupView.getPopupContentView().setTranslationX(horizontalAttachPopupView.f1060x);
        horizontalAttachPopupView.getPopupContentView().setTranslationY(horizontalAttachPopupView.f1061y);
        horizontalAttachPopupView.i();
        horizontalAttachPopupView.g();
        horizontalAttachPopupView.d();
    }
}
