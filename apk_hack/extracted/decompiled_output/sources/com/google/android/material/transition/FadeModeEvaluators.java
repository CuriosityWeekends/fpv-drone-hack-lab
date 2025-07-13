package com.google.android.material.transition;

import a1.i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class FadeModeEvaluators {
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f4, float f5, float f6, float f7) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f5, f6, f4));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f4, float f5, float f6, float f7) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f5, f6, f4), 255);
        }
    };
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f4, float f5, float f6, float f7) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f5, f6, f4), TransitionUtils.lerp(0, 255, f5, f6, f4));
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f4, float f5, float f6, float f7) {
            float b = i.b(f6, f5, f7, f5);
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f5, b, f4), TransitionUtils.lerp(0, 255, b, f6, f4));
        }
    };

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int i3, boolean z3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        return THROUGH;
                    }
                    throw new IllegalArgumentException(i.e(i3, "Invalid fade mode: "));
                }
                return CROSS;
            } else if (z3) {
                return OUT;
            } else {
                return IN;
            }
        } else if (z3) {
            return IN;
        } else {
            return OUT;
        }
    }
}
