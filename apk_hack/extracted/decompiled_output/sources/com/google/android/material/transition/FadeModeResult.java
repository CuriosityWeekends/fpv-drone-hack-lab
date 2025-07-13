package com.google.android.material.transition;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    private FadeModeResult(int i3, int i5, boolean z3) {
        this.startAlpha = i3;
        this.endAlpha = i5;
        this.endOnTop = z3;
    }

    public static FadeModeResult endOnTop(int i3, int i5) {
        return new FadeModeResult(i3, i5, true);
    }

    public static FadeModeResult startOnTop(int i3, int i5) {
        return new FadeModeResult(i3, i5, false);
    }
}
