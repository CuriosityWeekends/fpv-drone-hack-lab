package f3;

import android.content.Context;
import android.widget.OverScroller;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1872a = 0;
    public final OverScroller b;
    public int c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f1873e;

    public n(i0.i iVar, Context context) {
        this.f1873e = iVar;
        this.b = new OverScroller(context);
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1872a) {
            case 0:
                OverScroller overScroller = this.b;
                if (!overScroller.isFinished() && overScroller.computeScrollOffset()) {
                    int currX = overScroller.getCurrX();
                    int currY = overScroller.getCurrY();
                    o oVar = (o) this.f1873e;
                    oVar.f1883m.postTranslate(this.c - currX, this.d - currY);
                    oVar.a();
                    this.c = currX;
                    this.d = currY;
                    oVar.f1878h.postOnAnimation(this);
                    return;
                }
                return;
            default:
                OverScroller overScroller2 = this.b;
                if (!overScroller2.isFinished() && overScroller2.computeScrollOffset()) {
                    int currX2 = overScroller2.getCurrX();
                    int currY2 = overScroller2.getCurrY();
                    i0.i iVar = (i0.i) this.f1873e;
                    iVar.f2167m.postTranslate(this.c - currX2, this.d - currY2);
                    iVar.a();
                    this.c = currX2;
                    this.d = currY2;
                    iVar.f2162h.postOnAnimation(this);
                    return;
                }
                return;
        }
    }

    public n(o oVar, Context context) {
        this.f1873e = oVar;
        this.b = new OverScroller(context);
    }
}
