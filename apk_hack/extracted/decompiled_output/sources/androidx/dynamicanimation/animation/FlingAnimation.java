package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.dynamicanimation.animation.DynamicAnimation;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
        private float mVelocityThreshold;

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float f4, float f5) {
            return f5 * this.mFriction;
        }

        public float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float f4, float f5) {
            if (Math.abs(f5) < this.mVelocityThreshold) {
                return true;
            }
            return false;
        }

        public void setFrictionScalar(float f4) {
            this.mFriction = f4 * DEFAULT_FRICTION;
        }

        public void setValueThreshold(float f4) {
            this.mVelocityThreshold = f4 * VELOCITY_THRESHOLD_MULTIPLIER;
        }

        public DynamicAnimation.MassState updateValueAndVelocity(float f4, float f5, long j2) {
            float f6 = (float) j2;
            this.mMassState.mVelocity = (float) (Math.exp((f6 / 1000.0f) * this.mFriction) * f5);
            DynamicAnimation.MassState massState = this.mMassState;
            float f7 = this.mFriction;
            massState.mValue = (float) ((Math.exp((f7 * f6) / 1000.0f) * (f5 / f7)) + (f4 - (f5 / f7)));
            DynamicAnimation.MassState massState2 = this.mMassState;
            if (isAtEquilibrium(massState2.mValue, massState2.mVelocity)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public float getAcceleration(float f4, float f5) {
        return this.mFlingForce.getAcceleration(f4, f5);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean isAtEquilibrium(float f4, float f5) {
        if (f4 < this.mMaxValue && f4 > this.mMinValue && !this.mFlingForce.isAtEquilibrium(f4, f5)) {
            return false;
        }
        return true;
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float f4) {
        if (f4 > 0.0f) {
            this.mFlingForce.setFrictionScalar(f4);
            return this;
        }
        throw new IllegalArgumentException("Friction must be positive");
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void setValueThreshold(float f4) {
        this.mFlingForce.setValueThreshold(f4);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean updateValueAndVelocity(long j2) {
        DynamicAnimation.MassState updateValueAndVelocity = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, j2);
        float f4 = updateValueAndVelocity.mValue;
        this.mValue = f4;
        float f5 = updateValueAndVelocity.mVelocity;
        this.mVelocity = f5;
        float f6 = this.mMinValue;
        if (f4 < f6) {
            this.mValue = f6;
            return true;
        }
        float f7 = this.mMaxValue;
        if (f4 > f7) {
            this.mValue = f7;
            return true;
        } else if (isAtEquilibrium(f4, f5)) {
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMaxValue(float f4) {
        super.setMaxValue(f4);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setMinValue(float f4) {
        super.setMinValue(f4);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public FlingAnimation setStartVelocity(float f4) {
        super.setStartVelocity(f4);
        return this;
    }

    public <K> FlingAnimation(K k5, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k5, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.mFlingForce = dragForce;
        dragForce.setValueThreshold(getValueThreshold());
    }
}
