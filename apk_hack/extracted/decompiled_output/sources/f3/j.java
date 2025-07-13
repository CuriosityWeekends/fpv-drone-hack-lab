package f3;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1865a;
    public final /* synthetic */ Object b;

    public /* synthetic */ j(int i3, Object obj) {
        this.f1865a = i3;
        this.b = obj;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        switch (this.f1865a) {
            case 0:
                ((o) this.b).getClass();
                return false;
            default:
                ((i0.i) this.b).getClass();
                return false;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        switch (this.f1865a) {
            case 0:
                o oVar = (o) this.b;
                View.OnLongClickListener onLongClickListener = oVar.q;
                if (onLongClickListener != null) {
                    onLongClickListener.onLongClick(oVar.f1878h);
                    return;
                }
                return;
            default:
                i0.i iVar = (i0.i) this.b;
                View.OnLongClickListener onLongClickListener2 = iVar.q;
                if (onLongClickListener2 != null) {
                    onLongClickListener2.onLongClick(iVar.f2162h);
                    return;
                }
                return;
        }
    }
}
