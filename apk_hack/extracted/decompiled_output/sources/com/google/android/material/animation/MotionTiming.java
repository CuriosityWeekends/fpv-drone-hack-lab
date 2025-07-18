package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MotionTiming {
    private long delay;
    private long duration;
    @Nullable
    private TimeInterpolator interpolator;
    private int repeatCount;
    private int repeatMode;

    public MotionTiming(long j2, long j5) {
        this.interpolator = null;
        this.repeatCount = 0;
        this.repeatMode = 1;
        this.delay = j2;
        this.duration = j5;
    }

    @NonNull
    public static MotionTiming createFromAnimator(@NonNull ValueAnimator valueAnimator) {
        MotionTiming motionTiming = new MotionTiming(valueAnimator.getStartDelay(), valueAnimator.getDuration(), getInterpolatorCompat(valueAnimator));
        motionTiming.repeatCount = valueAnimator.getRepeatCount();
        motionTiming.repeatMode = valueAnimator.getRepeatMode();
        return motionTiming;
    }

    private static TimeInterpolator getInterpolatorCompat(@NonNull ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
            if (interpolator instanceof AccelerateInterpolator) {
                return AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            }
            if (interpolator instanceof DecelerateInterpolator) {
                return AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            }
            return interpolator;
        }
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public void apply(@NonNull Animator animator) {
        animator.setStartDelay(getDelay());
        animator.setDuration(getDuration());
        animator.setInterpolator(getInterpolator());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(getRepeatCount());
            valueAnimator.setRepeatMode(getRepeatMode());
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionTiming)) {
            return false;
        }
        MotionTiming motionTiming = (MotionTiming) obj;
        if (getDelay() != motionTiming.getDelay() || getDuration() != motionTiming.getDuration() || getRepeatCount() != motionTiming.getRepeatCount() || getRepeatMode() != motionTiming.getRepeatMode()) {
            return false;
        }
        return getInterpolator().getClass().equals(motionTiming.getInterpolator().getClass());
    }

    public long getDelay() {
        return this.delay;
    }

    public long getDuration() {
        return this.duration;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        TimeInterpolator timeInterpolator = this.interpolator;
        if (timeInterpolator == null) {
            return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        }
        return timeInterpolator;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public int getRepeatMode() {
        return this.repeatMode;
    }

    public int hashCode() {
        int hashCode = getInterpolator().getClass().hashCode();
        int repeatCount = getRepeatCount();
        return getRepeatMode() + ((repeatCount + ((hashCode + (((((int) (getDelay() ^ (getDelay() >>> 32))) * 31) + ((int) (getDuration() ^ (getDuration() >>> 32)))) * 31)) * 31)) * 31);
    }

    @NonNull
    public String toString() {
        return "\n" + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + getDelay() + " duration: " + getDuration() + " interpolator: " + getInterpolator().getClass() + " repeatCount: " + getRepeatCount() + " repeatMode: " + getRepeatMode() + "}\n";
    }

    public MotionTiming(long j2, long j5, @NonNull TimeInterpolator timeInterpolator) {
        this.repeatCount = 0;
        this.repeatMode = 1;
        this.delay = j2;
        this.duration = j5;
        this.interpolator = timeInterpolator;
    }
}
