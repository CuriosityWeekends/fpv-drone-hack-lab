package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class MotionInterpolator implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public abstract float getInterpolation(float f4);

    public abstract float getVelocity();
}
