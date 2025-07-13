package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    private static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    boolean mAnimating;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    boolean mNeedsCancel;
    boolean mNeedsReset;
    private Runnable mRunnable;
    final View mTarget;
    final ClampedScroller mScroller = new ClampedScroller();
    private final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
    private float[] mRelativeEdges = {0.0f, 0.0f};
    private float[] mMaximumEdges = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] mRelativeVelocity = {0.0f, 0.0f};
    private float[] mMinimumVelocity = {0.0f, 0.0f};
    private float[] mMaximumVelocity = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class ClampedScroller {
        private int mEffectiveRampDown;
        private int mRampDownDuration;
        private int mRampUpDuration;
        private float mStopValue;
        private float mTargetVelocityX;
        private float mTargetVelocityY;
        private long mStartTime = Long.MIN_VALUE;
        private long mStopTime = -1;
        private long mDeltaTime = 0;
        private int mDeltaX = 0;
        private int mDeltaY = 0;

        private float getValueAt(long j2) {
            long j5 = this.mStartTime;
            if (j2 < j5) {
                return 0.0f;
            }
            long j6 = this.mStopTime;
            if (j6 >= 0 && j2 >= j6) {
                float f4 = this.mStopValue;
                return (AutoScrollHelper.constrain(((float) (j2 - j6)) / this.mEffectiveRampDown, 0.0f, 1.0f) * f4) + (1.0f - f4);
            }
            return AutoScrollHelper.constrain(((float) (j2 - j5)) / this.mRampUpDuration, 0.0f, 1.0f) * 0.5f;
        }

        private float interpolateValue(float f4) {
            return (f4 * 4.0f) + ((-4.0f) * f4 * f4);
        }

        public void computeScrollDelta() {
            if (this.mDeltaTime != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float interpolateValue = interpolateValue(getValueAt(currentAnimationTimeMillis));
                this.mDeltaTime = currentAnimationTimeMillis;
                float f4 = ((float) (currentAnimationTimeMillis - this.mDeltaTime)) * interpolateValue;
                this.mDeltaX = (int) (this.mTargetVelocityX * f4);
                this.mDeltaY = (int) (f4 * this.mTargetVelocityY);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int getDeltaX() {
            return this.mDeltaX;
        }

        public int getDeltaY() {
            return this.mDeltaY;
        }

        public int getHorizontalDirection() {
            float f4 = this.mTargetVelocityX;
            return (int) (f4 / Math.abs(f4));
        }

        public int getVerticalDirection() {
            float f4 = this.mTargetVelocityY;
            return (int) (f4 / Math.abs(f4));
        }

        public boolean isFinished() {
            if (this.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + this.mEffectiveRampDown) {
                return true;
            }
            return false;
        }

        public void requestStop() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mEffectiveRampDown = AutoScrollHelper.constrain((int) (currentAnimationTimeMillis - this.mStartTime), 0, this.mRampDownDuration);
            this.mStopValue = getValueAt(currentAnimationTimeMillis);
            this.mStopTime = currentAnimationTimeMillis;
        }

        public void setRampDownDuration(int i3) {
            this.mRampDownDuration = i3;
        }

        public void setRampUpDuration(int i3) {
            this.mRampUpDuration = i3;
        }

        public void setTargetVelocity(float f4, float f5) {
            this.mTargetVelocityX = f4;
            this.mTargetVelocityY = f5;
        }

        public void start() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = currentAnimationTimeMillis;
            this.mStopTime = -1L;
            this.mDeltaTime = currentAnimationTimeMillis;
            this.mStopValue = 0.5f;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public class ScrollAnimationRunnable implements Runnable {
        public ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (!autoScrollHelper.mAnimating) {
                return;
            }
            if (autoScrollHelper.mNeedsReset) {
                autoScrollHelper.mNeedsReset = false;
                autoScrollHelper.mScroller.start();
            }
            ClampedScroller clampedScroller = AutoScrollHelper.this.mScroller;
            if (!clampedScroller.isFinished() && AutoScrollHelper.this.shouldAnimate()) {
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.mNeedsCancel) {
                    autoScrollHelper2.mNeedsCancel = false;
                    autoScrollHelper2.cancelTargetTouch();
                }
                clampedScroller.computeScrollDelta();
                AutoScrollHelper.this.scrollTargetBy(clampedScroller.getDeltaX(), clampedScroller.getDeltaY());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, this);
                return;
            }
            AutoScrollHelper.this.mAnimating = false;
        }
    }

    public AutoScrollHelper(@NonNull View view) {
        this.mTarget = view;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        float f5 = (int) ((1575.0f * f4) + 0.5f);
        setMaximumVelocity(f5, f5);
        float f6 = (int) ((f4 * 315.0f) + 0.5f);
        setMinimumVelocity(f6, f6);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    private float computeTargetVelocity(int i3, float f4, float f5, float f6) {
        float edgeValue = getEdgeValue(this.mRelativeEdges[i3], f5, this.mMaximumEdges[i3], f4);
        int i5 = (edgeValue > 0.0f ? 1 : (edgeValue == 0.0f ? 0 : -1));
        if (i5 == 0) {
            return 0.0f;
        }
        float f7 = this.mRelativeVelocity[i3];
        float f8 = this.mMinimumVelocity[i3];
        float f9 = this.mMaximumVelocity[i3];
        float f10 = f7 * f6;
        if (i5 > 0) {
            return constrain(edgeValue * f10, f8, f9);
        }
        return -constrain((-edgeValue) * f10, f8, f9);
    }

    public static float constrain(float f4, float f5, float f6) {
        return f4 > f6 ? f6 : f4 < f5 ? f5 : f4;
    }

    private float constrainEdgeValue(float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        int i3 = this.mEdgeType;
        if (i3 != 0 && i3 != 1) {
            if (i3 == 2 && f4 < 0.0f) {
                return f4 / (-f5);
            }
        } else if (f4 < f5) {
            if (f4 >= 0.0f) {
                return 1.0f - (f4 / f5);
            }
            if (this.mAnimating && i3 == 1) {
                return 1.0f;
            }
        }
        return 0.0f;
    }

    private float getEdgeValue(float f4, float f5, float f6, float f7) {
        float interpolation;
        float constrain = constrain(f4 * f5, 0.0f, f6);
        float constrainEdgeValue = constrainEdgeValue(f5 - f7, constrain) - constrainEdgeValue(f7, constrain);
        if (constrainEdgeValue < 0.0f) {
            interpolation = -this.mEdgeInterpolator.getInterpolation(-constrainEdgeValue);
        } else if (constrainEdgeValue <= 0.0f) {
            return 0.0f;
        } else {
            interpolation = this.mEdgeInterpolator.getInterpolation(constrainEdgeValue);
        }
        return constrain(interpolation, -1.0f, 1.0f);
    }

    private void requestStop() {
        if (this.mNeedsReset) {
            this.mAnimating = false;
        } else {
            this.mScroller.requestStop();
        }
    }

    private void startAnimating() {
        int i3;
        if (this.mRunnable == null) {
            this.mRunnable = new ScrollAnimationRunnable();
        }
        this.mAnimating = true;
        this.mNeedsReset = true;
        if (!this.mAlreadyDelayed && (i3 = this.mActivationDelay) > 0) {
            ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, i3);
        } else {
            this.mRunnable.run();
        }
        this.mAlreadyDelayed = true;
    }

    public abstract boolean canTargetScrollHorizontally(int i3);

    public abstract boolean canTargetScrollVertically(int i3);

    public void cancelTargetTouch() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.mTarget.onTouchEvent(obtain);
        obtain.recycle();
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isExclusive() {
        return this.mExclusive;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.mEnabled
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.requestStop()
            goto L58
        L1a:
            r5.mNeedsCancel = r2
            r5.mAlreadyDelayed = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.mTarget
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.computeTargetVelocity(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.mTarget
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.computeTargetVelocity(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$ClampedScroller r7 = r5.mScroller
            r7.setTargetVelocity(r0, r6)
            boolean r6 = r5.mAnimating
            if (r6 != 0) goto L58
            boolean r6 = r5.shouldAnimate()
            if (r6 == 0) goto L58
            r5.startAnimating()
        L58:
            boolean r6 = r5.mExclusive
            if (r6 == 0) goto L61
            boolean r6 = r5.mAnimating
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract void scrollTargetBy(int i3, int i5);

    @NonNull
    public AutoScrollHelper setActivationDelay(int i3) {
        this.mActivationDelay = i3;
        return this;
    }

    @NonNull
    public AutoScrollHelper setEdgeType(int i3) {
        this.mEdgeType = i3;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z3) {
        if (this.mEnabled && !z3) {
            requestStop();
        }
        this.mEnabled = z3;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z3) {
        this.mExclusive = z3;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumEdges(float f4, float f5) {
        float[] fArr = this.mMaximumEdges;
        fArr[0] = f4;
        fArr[1] = f5;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumVelocity(float f4, float f5) {
        float[] fArr = this.mMaximumVelocity;
        fArr[0] = f4 / 1000.0f;
        fArr[1] = f5 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMinimumVelocity(float f4, float f5) {
        float[] fArr = this.mMinimumVelocity;
        fArr[0] = f4 / 1000.0f;
        fArr[1] = f5 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampDownDuration(int i3) {
        this.mScroller.setRampDownDuration(i3);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampUpDuration(int i3) {
        this.mScroller.setRampUpDuration(i3);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeEdges(float f4, float f5) {
        float[] fArr = this.mRelativeEdges;
        fArr[0] = f4;
        fArr[1] = f5;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeVelocity(float f4, float f5) {
        float[] fArr = this.mRelativeVelocity;
        fArr[0] = f4 / 1000.0f;
        fArr[1] = f5 / 1000.0f;
        return this;
    }

    public boolean shouldAnimate() {
        ClampedScroller clampedScroller = this.mScroller;
        int verticalDirection = clampedScroller.getVerticalDirection();
        int horizontalDirection = clampedScroller.getHorizontalDirection();
        if ((verticalDirection != 0 && canTargetScrollVertically(verticalDirection)) || (horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection))) {
            return true;
        }
        return false;
    }

    public static int constrain(int i3, int i5, int i6) {
        return i3 > i6 ? i6 : i3 < i5 ? i5 : i3;
    }
}
