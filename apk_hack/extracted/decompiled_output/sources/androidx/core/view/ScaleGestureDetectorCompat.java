package androidx.core.view;

import android.view.ScaleGestureDetector;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ScaleGestureDetectorCompat {
    private ScaleGestureDetectorCompat() {
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object obj) {
        return isQuickScaleEnabled((ScaleGestureDetector) obj);
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object obj, boolean z3) {
        setQuickScaleEnabled((ScaleGestureDetector) obj, z3);
    }

    public static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector) {
        return scaleGestureDetector.isQuickScaleEnabled();
    }

    public static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector, boolean z3) {
        scaleGestureDetector.setQuickScaleEnabled(z3);
    }
}
