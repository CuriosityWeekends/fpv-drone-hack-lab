package b3;

import android.graphics.PointF;
import com.lxj.xpopup.core.BubbleAttachPopupView;
import com.lxj.xpopup.widget.BubbleLayout;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f179a;
    public final /* synthetic */ BubbleAttachPopupView b;

    public m(BubbleAttachPopupView bubbleAttachPopupView, boolean z3) {
        this.b = bubbleAttachPopupView;
        this.f179a = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BubbleAttachPopupView bubbleAttachPopupView = this.b;
        a1.m mVar = bubbleAttachPopupView.f1034a;
        if (mVar == null) {
            return;
        }
        if (this.f179a) {
            bubbleAttachPopupView.f1050t = -(((com.lxj.xpopup.util.b.g(bubbleAttachPopupView.getContext()) - ((PointF) bubbleAttachPopupView.f1034a.b).x) - bubbleAttachPopupView.f1048p) - (bubbleAttachPopupView.getPopupContentView().getMeasuredWidth() / 2.0f));
        } else {
            bubbleAttachPopupView.f1050t = ((((PointF) mVar.b).x + bubbleAttachPopupView.f1048p) - bubbleAttachPopupView.getPopupContentView().getMeasuredWidth()) + bubbleAttachPopupView.q.getShadowRadius();
        }
        if (bubbleAttachPopupView.q()) {
            bubbleAttachPopupView.f1051u = (((PointF) bubbleAttachPopupView.f1034a.b).y - bubbleAttachPopupView.getPopupContentView().getMeasuredHeight()) - 0;
        } else {
            bubbleAttachPopupView.f1051u = ((PointF) bubbleAttachPopupView.f1034a.b).y + 0;
        }
        bubbleAttachPopupView.f1034a.getClass();
        if (bubbleAttachPopupView.q()) {
            bubbleAttachPopupView.q.setLook(BubbleLayout.Look.BOTTOM);
        } else {
            bubbleAttachPopupView.q.setLook(BubbleLayout.Look.TOP);
        }
        BubbleLayout bubbleLayout = bubbleAttachPopupView.q;
        bubbleLayout.setLookPosition(Math.max(0, (int) (((((PointF) bubbleAttachPopupView.f1034a.b).x - bubbleAttachPopupView.f1048p) - bubbleAttachPopupView.f1050t) - (bubbleLayout.mLookWidth / 2))));
        bubbleAttachPopupView.q.invalidate();
        bubbleAttachPopupView.getPopupContentView().setTranslationX(bubbleAttachPopupView.f1050t);
        bubbleAttachPopupView.getPopupContentView().setTranslationY(bubbleAttachPopupView.f1051u);
        bubbleAttachPopupView.i();
        bubbleAttachPopupView.g();
        bubbleAttachPopupView.d();
    }
}
