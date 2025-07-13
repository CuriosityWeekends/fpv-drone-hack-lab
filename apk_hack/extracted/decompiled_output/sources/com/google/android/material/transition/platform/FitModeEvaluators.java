package com.google.android.material.transition.platform;

import a1.i;
import android.graphics.RectF;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class FitModeEvaluators {
    private static final FitModeEvaluator WIDTH = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.1
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void applyMask(RectF rectF, float f4, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f4;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult evaluate(float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
            float lerp = TransitionUtils.lerp(f7, f9, f5, f6, f4, true);
            float f11 = lerp / f7;
            float f12 = lerp / f9;
            return new FitModeResult(f11, f12, lerp, f8 * f11, lerp, f10 * f12);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            if (fitModeResult.currentStartHeight > fitModeResult.currentEndHeight) {
                return true;
            }
            return false;
        }
    };
    private static final FitModeEvaluator HEIGHT = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.2
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void applyMask(RectF rectF, float f4, FitModeResult fitModeResult) {
            float abs = (Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f4;
            rectF.left += abs;
            rectF.right -= abs;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult evaluate(float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
            float lerp = TransitionUtils.lerp(f8, f10, f5, f6, f4, true);
            float f11 = lerp / f8;
            float f12 = lerp / f10;
            return new FitModeResult(f11, f12, f7 * f11, lerp, f9 * f12, lerp);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            if (fitModeResult.currentStartWidth > fitModeResult.currentEndWidth) {
                return true;
            }
            return false;
        }
    };

    private FitModeEvaluators() {
    }

    public static FitModeEvaluator get(int i3, boolean z3, RectF rectF, RectF rectF2) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return HEIGHT;
                }
                throw new IllegalArgumentException(i.e(i3, "Invalid fit mode: "));
            }
            return WIDTH;
        } else if (shouldAutoFitToWidth(z3, rectF, rectF2)) {
            return WIDTH;
        } else {
            return HEIGHT;
        }
    }

    private static boolean shouldAutoFitToWidth(boolean z3, RectF rectF, RectF rectF2) {
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        float f4 = (height2 * width) / width2;
        float f5 = (width2 * height) / width;
        if (z3) {
            if (f4 < height) {
                return false;
            }
        } else if (f5 < height2) {
            return false;
        }
        return true;
    }
}
