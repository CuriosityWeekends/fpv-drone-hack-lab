package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.MaterialAttributes;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int i3, @IntRange(from = 0, to = 255) int i5) {
        return ColorUtils.setAlphaComponent(i3, (Color.alpha(i3) * i5) / 255);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i3) {
        return MaterialAttributes.resolveOrThrow(view, i3);
    }

    public static boolean isColorLight(@ColorInt int i3) {
        if (i3 != 0 && ColorUtils.calculateLuminance(i3) > 0.5d) {
            return true;
        }
        return false;
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i3, @AttrRes int i5) {
        return layer(view, i3, i5, 1.0f);
    }

    @ColorInt
    public static int getColor(Context context, @AttrRes int i3, String str) {
        return MaterialAttributes.resolveOrThrow(context, i3, str);
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i3, @AttrRes int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return layer(getColor(view, i3), getColor(view, i5), f4);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i3, @ColorInt int i5) {
        return getColor(view.getContext(), i3, i5);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int i3, @ColorInt int i5) {
        TypedValue resolve = MaterialAttributes.resolve(context, i3);
        return resolve != null ? resolve.data : i5;
    }

    @ColorInt
    public static int layer(@ColorInt int i3, @ColorInt int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return layer(i3, ColorUtils.setAlphaComponent(i5, Math.round(Color.alpha(i5) * f4)));
    }

    @ColorInt
    public static int layer(@ColorInt int i3, @ColorInt int i5) {
        return ColorUtils.compositeColors(i5, i3);
    }
}
