package com.google.android.material.slider;

import androidx.annotation.NonNull;
import java.util.Locale;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class BasicLabelFormatter implements LabelFormatter {
    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;
    private static final long TRILLION = 1000000000000L;

    @Override // com.google.android.material.slider.LabelFormatter
    @NonNull
    public String getFormattedValue(float f4) {
        if (f4 >= 1.0E12f) {
            return String.format(Locale.US, "%.1fT", Float.valueOf(f4 / 1.0E12f));
        }
        if (f4 >= 1.0E9f) {
            return String.format(Locale.US, "%.1fB", Float.valueOf(f4 / 1.0E9f));
        }
        if (f4 >= 1000000.0f) {
            return String.format(Locale.US, "%.1fM", Float.valueOf(f4 / 1000000.0f));
        }
        if (f4 >= 1000.0f) {
            return String.format(Locale.US, "%.1fK", Float.valueOf(f4 / 1000.0f));
        }
        return String.format(Locale.US, "%.0f", Float.valueOf(f4));
    }
}
