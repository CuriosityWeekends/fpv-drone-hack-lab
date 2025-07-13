package b3;

import android.graphics.PointF;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.BubbleHorizontalAttachPopupView;
import com.lxj.xpopup.widget.BubbleLayout;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f168a;
    public boolean b;
    public final /* synthetic */ FrameLayout c;

    public /* synthetic */ b(BasePopupView basePopupView, boolean z3, int i3) {
        this.f168a = i3;
        this.c = basePopupView;
        this.b = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float measuredWidth;
        float g5;
        float f4;
        float g6;
        FrameLayout frameLayout = this.c;
        switch (this.f168a) {
            case 0:
                AttachPopupView attachPopupView = (AttachPopupView) frameLayout;
                a1.m mVar = attachPopupView.f1034a;
                if (mVar != null) {
                    if (this.b) {
                        if (attachPopupView.s) {
                            g5 = ((com.lxj.xpopup.util.b.g(attachPopupView.getContext()) - ((PointF) attachPopupView.f1034a.b).x) - attachPopupView.getPopupContentView().getMeasuredWidth()) - attachPopupView.f1029p;
                        } else {
                            g5 = (com.lxj.xpopup.util.b.g(attachPopupView.getContext()) - ((PointF) attachPopupView.f1034a.b).x) + attachPopupView.f1029p;
                        }
                        attachPopupView.f1031t = -g5;
                    } else {
                        boolean z3 = attachPopupView.s;
                        float f5 = ((PointF) mVar.b).x;
                        if (z3) {
                            measuredWidth = f5 + attachPopupView.f1029p;
                        } else {
                            measuredWidth = (f5 - attachPopupView.getPopupContentView().getMeasuredWidth()) - attachPopupView.f1029p;
                        }
                        attachPopupView.f1031t = measuredWidth;
                    }
                    attachPopupView.f1034a.getClass();
                    if (attachPopupView.q()) {
                        attachPopupView.f1032u = (((PointF) attachPopupView.f1034a.b).y - attachPopupView.getPopupContentView().getMeasuredHeight()) - 0;
                    } else {
                        attachPopupView.f1032u = ((PointF) attachPopupView.f1034a.b).y + 0;
                    }
                    attachPopupView.getPopupContentView().setTranslationX(attachPopupView.f1031t);
                    attachPopupView.getPopupContentView().setTranslationY(attachPopupView.f1032u);
                    attachPopupView.i();
                    attachPopupView.g();
                    attachPopupView.d();
                    return;
                }
                return;
            case 1:
                BubbleHorizontalAttachPopupView bubbleHorizontalAttachPopupView = (BubbleHorizontalAttachPopupView) frameLayout;
                if (bubbleHorizontalAttachPopupView.f1034a != null) {
                    if (this.b) {
                        if (bubbleHorizontalAttachPopupView.s) {
                            g6 = (com.lxj.xpopup.util.b.g(bubbleHorizontalAttachPopupView.getContext()) - ((PointF) bubbleHorizontalAttachPopupView.f1034a.b).x) + bubbleHorizontalAttachPopupView.f1048p;
                        } else {
                            g6 = ((com.lxj.xpopup.util.b.g(bubbleHorizontalAttachPopupView.getContext()) - ((PointF) bubbleHorizontalAttachPopupView.f1034a.b).x) - bubbleHorizontalAttachPopupView.getPopupContentView().getMeasuredWidth()) - bubbleHorizontalAttachPopupView.f1048p;
                        }
                        bubbleHorizontalAttachPopupView.f1054x = -g6;
                    } else {
                        int i3 = BubbleHorizontalAttachPopupView.f1053z;
                        if (bubbleHorizontalAttachPopupView.r()) {
                            f4 = (((PointF) bubbleHorizontalAttachPopupView.f1034a.b).x - bubbleHorizontalAttachPopupView.getPopupContentView().getMeasuredWidth()) - bubbleHorizontalAttachPopupView.f1048p;
                        } else {
                            f4 = ((PointF) bubbleHorizontalAttachPopupView.f1034a.b).x + bubbleHorizontalAttachPopupView.f1048p;
                        }
                        bubbleHorizontalAttachPopupView.f1054x = f4;
                    }
                    bubbleHorizontalAttachPopupView.getClass();
                    bubbleHorizontalAttachPopupView.f1055y = (((PointF) bubbleHorizontalAttachPopupView.f1034a.b).y - (bubbleHorizontalAttachPopupView.getPopupContentView().getMeasuredHeight() * 0.5f)) + 0;
                    boolean r5 = bubbleHorizontalAttachPopupView.r();
                    BubbleLayout bubbleLayout = bubbleHorizontalAttachPopupView.q;
                    if (r5) {
                        bubbleLayout.setLook(BubbleLayout.Look.RIGHT);
                    } else {
                        bubbleLayout.setLook(BubbleLayout.Look.LEFT);
                    }
                    bubbleLayout.setLookPositionCenter(true);
                    bubbleLayout.invalidate();
                    bubbleHorizontalAttachPopupView.getPopupContentView().setTranslationX(bubbleHorizontalAttachPopupView.f1054x);
                    bubbleHorizontalAttachPopupView.getPopupContentView().setTranslationY(bubbleHorizontalAttachPopupView.f1055y);
                    bubbleHorizontalAttachPopupView.i();
                    bubbleHorizontalAttachPopupView.g();
                    bubbleHorizontalAttachPopupView.d();
                    return;
                }
                return;
            default:
                this.b = false;
                int i5 = AspectRatioFrameLayout.d;
                ((AspectRatioFrameLayout) frameLayout).getClass();
                return;
        }
    }

    public b(AspectRatioFrameLayout aspectRatioFrameLayout) {
        this.f168a = 2;
        this.c = aspectRatioFrameLayout;
    }
}
