package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
final class StaticLayoutBuilderCompat {
    static final int DEFAULT_HYPHENATION_FREQUENCY;
    static final float DEFAULT_LINE_SPACING_ADD = 0.0f;
    static final float DEFAULT_LINE_SPACING_MULTIPLIER = 1.0f;
    private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final String TEXT_DIR_CLASS_LTR = "LTR";
    private static final String TEXT_DIR_CLASS_RTL = "RTL";
    @Nullable
    private static Constructor<StaticLayout> constructor;
    private static boolean initialized;
    @Nullable
    private static Object textDirection;
    private int end;
    private boolean isRtl;
    private final TextPaint paint;
    private CharSequence source;
    private final int width;
    private int start = 0;
    private Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
    private int maxLines = Integer.MAX_VALUE;
    private float lineSpacingAdd = 0.0f;
    private float lineSpacingMultiplier = 1.0f;
    private int hyphenationFrequency = DEFAULT_HYPHENATION_FREQUENCY;
    private boolean includePad = true;
    @Nullable
    private TextUtils.TruncateAt ellipsize = null;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class StaticLayoutBuilderCompatException extends Exception {
        public StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    static {
        int i3;
        if (Build.VERSION.SDK_INT >= 23) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        DEFAULT_HYPHENATION_FREQUENCY = i3;
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i3) {
        this.source = charSequence;
        this.paint = textPaint;
        this.width = i3;
        this.end = charSequence.length();
    }

    private void createConstructorWithReflection() {
        boolean z3;
        TextDirectionHeuristic textDirectionHeuristic;
        if (initialized) {
            return;
        }
        try {
            if (this.isRtl && Build.VERSION.SDK_INT >= 23) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
            textDirection = textDirectionHeuristic;
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
            constructor = declaredConstructor;
            declaredConstructor.setAccessible(true);
            initialized = true;
        } catch (Exception e5) {
            throw new StaticLayoutBuilderCompatException(e5);
        }
    }

    @NonNull
    public static StaticLayoutBuilderCompat obtain(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i3) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i3);
    }

    public StaticLayout build() {
        StaticLayout.Builder obtain;
        TextDirectionHeuristic textDirectionHeuristic;
        StaticLayout build;
        if (this.source == null) {
            this.source = "";
        }
        int max = Math.max(0, this.width);
        CharSequence charSequence = this.source;
        if (this.maxLines == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.paint, max, this.ellipsize);
        }
        int min = Math.min(charSequence.length(), this.end);
        this.end = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.isRtl && this.maxLines == 1) {
                this.alignment = Layout.Alignment.ALIGN_OPPOSITE;
            }
            obtain = StaticLayout.Builder.obtain(charSequence, this.start, min, this.paint, max);
            obtain.setAlignment(this.alignment);
            obtain.setIncludePad(this.includePad);
            if (this.isRtl) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
            obtain.setTextDirection(textDirectionHeuristic);
            TextUtils.TruncateAt truncateAt = this.ellipsize;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.maxLines);
            float f4 = this.lineSpacingAdd;
            if (f4 != 0.0f || this.lineSpacingMultiplier != 1.0f) {
                obtain.setLineSpacing(f4, this.lineSpacingMultiplier);
            }
            if (this.maxLines > 1) {
                obtain.setHyphenationFrequency(this.hyphenationFrequency);
            }
            build = obtain.build();
            return build;
        }
        createConstructorWithReflection();
        try {
            return (StaticLayout) ((Constructor) Preconditions.checkNotNull(constructor)).newInstance(charSequence, Integer.valueOf(this.start), Integer.valueOf(this.end), this.paint, Integer.valueOf(max), this.alignment, Preconditions.checkNotNull(textDirection), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.includePad), null, Integer.valueOf(max), Integer.valueOf(this.maxLines));
        } catch (Exception e5) {
            throw new StaticLayoutBuilderCompatException(e5);
        }
    }

    @NonNull
    public StaticLayoutBuilderCompat setAlignment(@NonNull Layout.Alignment alignment) {
        this.alignment = alignment;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEllipsize(@Nullable TextUtils.TruncateAt truncateAt) {
        this.ellipsize = truncateAt;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setEnd(@IntRange(from = 0) int i3) {
        this.end = i3;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setHyphenationFrequency(int i3) {
        this.hyphenationFrequency = i3;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setIncludePad(boolean z3) {
        this.includePad = z3;
        return this;
    }

    public StaticLayoutBuilderCompat setIsRtl(boolean z3) {
        this.isRtl = z3;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setLineSpacing(float f4, float f5) {
        this.lineSpacingAdd = f4;
        this.lineSpacingMultiplier = f5;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setMaxLines(@IntRange(from = 0) int i3) {
        this.maxLines = i3;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat setStart(@IntRange(from = 0) int i3) {
        this.start = i3;
        return this;
    }
}
