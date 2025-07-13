package f3;

import android.view.ScaleGestureDetector;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements ScaleGestureDetector.OnScaleGestureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1856a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(int i3, Object obj) {
        this.f1856a = i3;
        this.b = obj;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        switch (this.f1856a) {
            case 0:
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (!Float.isNaN(scaleFactor) && !Float.isInfinite(scaleFactor)) {
                    if (scaleFactor >= 0.0f) {
                        ((b3.e) ((b) this.b).f1864k).E(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    }
                    return true;
                }
                return false;
            default:
                float scaleFactor2 = scaleGestureDetector.getScaleFactor();
                if (!Float.isNaN(scaleFactor2) && !Float.isInfinite(scaleFactor2)) {
                    if (scaleFactor2 >= 0.0f) {
                        ((b3.e) ((b) this.b).f1864k).E(scaleFactor2, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    }
                    return true;
                }
                return false;
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        switch (this.f1856a) {
            case 0:
                return true;
            default:
                return true;
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        int i3 = this.f1856a;
    }

    private final void a(ScaleGestureDetector scaleGestureDetector) {
    }

    private final void b(ScaleGestureDetector scaleGestureDetector) {
    }
}
