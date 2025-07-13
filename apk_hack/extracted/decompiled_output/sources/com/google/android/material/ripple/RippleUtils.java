package com.google.android.material.ripple;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class RippleUtils {
    @VisibleForTesting
    static final String TRANSPARENT_DEFAULT_COLOR_WARNING = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";
    public static final boolean USE_FRAMEWORK_RIPPLE = true;
    private static final int[] PRESSED_STATE_SET = {16842919};
    private static final int[] HOVERED_FOCUSED_STATE_SET = {16843623, 16842908};
    private static final int[] FOCUSED_STATE_SET = {16842908};
    private static final int[] HOVERED_STATE_SET = {16843623};
    private static final int[] SELECTED_PRESSED_STATE_SET = {16842913, 16842919};
    private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET = {16842913, 16843623, 16842908};
    private static final int[] SELECTED_FOCUSED_STATE_SET = {16842913, 16842908};
    private static final int[] SELECTED_HOVERED_STATE_SET = {16842913, 16843623};
    private static final int[] SELECTED_STATE_SET = {16842913};
    private static final int[] ENABLED_PRESSED_STATE_SET = {16842910, 16842919};
    @VisibleForTesting
    static final String LOG_TAG = "RippleUtils";

    private RippleUtils() {
    }

    @NonNull
    public static ColorStateList convertToRippleDrawableColor(@Nullable ColorStateList colorStateList) {
        if (USE_FRAMEWORK_RIPPLE) {
            return new ColorStateList(new int[][]{SELECTED_STATE_SET, StateSet.NOTHING}, new int[]{getColorForState(colorStateList, SELECTED_PRESSED_STATE_SET), getColorForState(colorStateList, PRESSED_STATE_SET)});
        }
        int[] iArr = SELECTED_PRESSED_STATE_SET;
        int[] iArr2 = SELECTED_HOVERED_FOCUSED_STATE_SET;
        int[] iArr3 = SELECTED_FOCUSED_STATE_SET;
        int[] iArr4 = SELECTED_HOVERED_STATE_SET;
        int[] iArr5 = PRESSED_STATE_SET;
        int[] iArr6 = HOVERED_FOCUSED_STATE_SET;
        int[] iArr7 = FOCUSED_STATE_SET;
        int[] iArr8 = HOVERED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, SELECTED_STATE_SET, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{getColorForState(colorStateList, iArr), getColorForState(colorStateList, iArr2), getColorForState(colorStateList, iArr3), getColorForState(colorStateList, iArr4), 0, getColorForState(colorStateList, iArr5), getColorForState(colorStateList, iArr6), getColorForState(colorStateList, iArr7), getColorForState(colorStateList, iArr8), 0});
    }

    @ColorInt
    @TargetApi(21)
    private static int doubleAlpha(@ColorInt int i3) {
        return ColorUtils.setAlphaComponent(i3, Math.min(Color.alpha(i3) * 2, 255));
    }

    @ColorInt
    private static int getColorForState(@Nullable ColorStateList colorStateList, int[] iArr) {
        int i3;
        if (colorStateList != null) {
            i3 = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i3 = 0;
        }
        if (USE_FRAMEWORK_RIPPLE) {
            return doubleAlpha(i3);
        }
        return i3;
    }

    @NonNull
    public static ColorStateList sanitizeRippleDrawableColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 22 && i3 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(ENABLED_PRESSED_STATE_SET, 0)) != 0) {
                Log.w(LOG_TAG, TRANSPARENT_DEFAULT_COLOR_WARNING);
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean shouldDrawRippleCompat(@NonNull int[] iArr) {
        boolean z3 = false;
        boolean z5 = false;
        for (int i3 : iArr) {
            if (i3 == 16842910) {
                z3 = true;
            } else if (i3 == 16842908 || i3 == 16842919 || i3 == 16843623) {
                z5 = true;
            }
        }
        if (!z3 || !z5) {
            return false;
        }
        return true;
    }
}
