package androidx.core.view;

import android.view.VelocityTracker;
@Deprecated
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class VelocityTrackerCompat {
    private VelocityTrackerCompat() {
    }

    @Deprecated
    public static float getXVelocity(VelocityTracker velocityTracker, int i3) {
        return velocityTracker.getXVelocity(i3);
    }

    @Deprecated
    public static float getYVelocity(VelocityTracker velocityTracker, int i3) {
        return velocityTracker.getYVelocity(i3);
    }
}
