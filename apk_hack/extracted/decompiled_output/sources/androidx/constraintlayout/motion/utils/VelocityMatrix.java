package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class VelocityMatrix {
    private static String TAG = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    public void applyTransform(float f4, float f5, int i3, int i5, float[] fArr) {
        float f6;
        float f7 = fArr[0];
        float f8 = fArr[1];
        float f9 = (f5 - 0.5f) * 2.0f;
        float f10 = f7 + this.mDTranslateX;
        float f11 = f8 + this.mDTranslateY;
        float f12 = (this.mDScaleX * (f4 - 0.5f) * 2.0f) + f10;
        float f13 = (this.mDScaleY * f9) + f11;
        float radians = (float) Math.toRadians(this.mRotate);
        float radians2 = (float) Math.toRadians(this.mDRotate);
        double d = radians;
        double sin = Math.sin(d);
        double d5 = i5 * f9;
        double cos = Math.cos(d);
        fArr[0] = (((float) ((sin * ((-i3) * f6)) - (Math.cos(d) * d5))) * radians2) + f12;
        fArr[1] = (radians2 * ((float) ((cos * (i3 * f6)) - (Math.sin(d) * d5)))) + f13;
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(SplineSet splineSet, float f4) {
        if (splineSet != null) {
            this.mDRotate = splineSet.getSlope(f4);
            this.mRotate = splineSet.get(f4);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f4) {
        if (splineSet != null) {
            this.mDScaleX = splineSet.getSlope(f4);
        }
        if (splineSet2 != null) {
            this.mDScaleY = splineSet2.getSlope(f4);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f4) {
        if (splineSet != null) {
            this.mDTranslateX = splineSet.getSlope(f4);
        }
        if (splineSet2 != null) {
            this.mDTranslateY = splineSet2.getSlope(f4);
        }
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f4) {
        if (keyCycleOscillator != null) {
            this.mDRotate = keyCycleOscillator.getSlope(f4);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f4) {
        if (keyCycleOscillator == null && keyCycleOscillator2 == null) {
            return;
        }
        if (keyCycleOscillator == null) {
            this.mDScaleX = keyCycleOscillator.getSlope(f4);
        }
        if (keyCycleOscillator2 == null) {
            this.mDScaleY = keyCycleOscillator2.getSlope(f4);
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f4) {
        if (keyCycleOscillator != null) {
            this.mDTranslateX = keyCycleOscillator.getSlope(f4);
        }
        if (keyCycleOscillator2 != null) {
            this.mDTranslateY = keyCycleOscillator2.getSlope(f4);
        }
    }
}
