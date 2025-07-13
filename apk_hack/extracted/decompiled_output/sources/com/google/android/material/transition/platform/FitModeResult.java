package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;
@RequiresApi(21)
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class FitModeResult {
    final float currentEndHeight;
    final float currentEndWidth;
    final float currentStartHeight;
    final float currentStartWidth;
    final float endScale;
    final float startScale;

    public FitModeResult(float f4, float f5, float f6, float f7, float f8, float f9) {
        this.startScale = f4;
        this.endScale = f5;
        this.currentStartWidth = f6;
        this.currentStartHeight = f7;
        this.currentEndWidth = f8;
        this.currentEndHeight = f9;
    }
}
