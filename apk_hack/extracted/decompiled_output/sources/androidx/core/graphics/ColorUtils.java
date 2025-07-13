package androidx.core.graphics;

import a1.i;
import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import java.util.Objects;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] fArr) {
        int round;
        int round2;
        int round3;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = fArr[2];
        float abs = (1.0f - Math.abs((f6 * 2.0f) - 1.0f)) * f5;
        float f7 = f6 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f4 / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f4) / 60) {
            case 0:
                round = Math.round((abs + f7) * 255.0f);
                round2 = Math.round((abs2 + f7) * 255.0f);
                round3 = Math.round(f7 * 255.0f);
                break;
            case 1:
                round = Math.round((abs2 + f7) * 255.0f);
                round2 = Math.round((abs + f7) * 255.0f);
                round3 = Math.round(f7 * 255.0f);
                break;
            case 2:
                round = Math.round(f7 * 255.0f);
                round2 = Math.round((abs + f7) * 255.0f);
                round3 = Math.round((abs2 + f7) * 255.0f);
                break;
            case 3:
                round = Math.round(f7 * 255.0f);
                round2 = Math.round((abs2 + f7) * 255.0f);
                round3 = Math.round((abs + f7) * 255.0f);
                break;
            case 4:
                round = Math.round((abs2 + f7) * 255.0f);
                round2 = Math.round(f7 * 255.0f);
                round3 = Math.round((abs + f7) * 255.0f);
                break;
            case 5:
            case 6:
                round = Math.round((abs + f7) * 255.0f);
                round2 = Math.round(f7 * 255.0f);
                round3 = Math.round((abs2 + f7) * 255.0f);
                break;
            default:
                round3 = 0;
                round = 0;
                round2 = 0;
                break;
        }
        return Color.rgb(constrain(round, 0, 255), constrain(round2, 0, 255), constrain(round3, 0, 255));
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = 100.0d) double d, @FloatRange(from = -128.0d, to = 127.0d) double d5, @FloatRange(from = -128.0d, to = 127.0d) double d6) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d, d5, d6, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = 100.0d) double d, @FloatRange(from = -128.0d, to = 127.0d) double d5, @FloatRange(from = -128.0d, to = 127.0d) double d6, @NonNull double[] dArr) {
        double d7;
        double d8 = (d + 16.0d) / 116.0d;
        double d9 = (d5 / 500.0d) + d8;
        double d10 = d8 - (d6 / 200.0d);
        double pow = Math.pow(d9, 3.0d);
        if (pow <= XYZ_EPSILON) {
            pow = ((d9 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        if (d > 7.9996247999999985d) {
            d7 = Math.pow(d8, 3.0d);
        } else {
            d7 = d / XYZ_KAPPA;
        }
        double pow2 = Math.pow(d10, 3.0d);
        if (pow2 <= XYZ_EPSILON) {
            pow2 = ((d10 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = pow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = d7 * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = pow2 * XYZ_WHITE_REFERENCE_Z;
    }

    public static void RGBToHSL(@IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i5, @IntRange(from = 0, to = 255) int i6, @NonNull float[] fArr) {
        float f4;
        float abs;
        float f5 = i3 / 255.0f;
        float f6 = i5 / 255.0f;
        float f7 = i6 / 255.0f;
        float max = Math.max(f5, Math.max(f6, f7));
        float min = Math.min(f5, Math.min(f6, f7));
        float f8 = max - min;
        float f9 = (max + min) / 2.0f;
        if (max == min) {
            f4 = 0.0f;
            abs = 0.0f;
        } else {
            if (max == f5) {
                f4 = ((f6 - f7) / f8) % 6.0f;
            } else if (max == f6) {
                f4 = ((f7 - f5) / f8) + 2.0f;
            } else {
                f4 = 4.0f + ((f5 - f6) / f8);
            }
            abs = f8 / (1.0f - Math.abs((2.0f * f9) - 1.0f));
        }
        float f10 = (f4 * 60.0f) % 360.0f;
        if (f10 < 0.0f) {
            f10 += 360.0f;
        }
        fArr[0] = constrain(f10, 0.0f, 360.0f);
        fArr[1] = constrain(abs, 0.0f, 1.0f);
        fArr[2] = constrain(f9, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i5, @IntRange(from = 0, to = 255) int i6, @NonNull double[] dArr) {
        RGBToXYZ(i3, i5, i6, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i5, @IntRange(from = 0, to = 255) int i6, @NonNull double[] dArr) {
        double pow;
        double pow2;
        double pow3;
        if (dArr.length == 3) {
            double d = i3 / 255.0d;
            if (d < 0.04045d) {
                pow = d / 12.92d;
            } else {
                pow = Math.pow((d + 0.055d) / 1.055d, 2.4d);
            }
            double d5 = i5 / 255.0d;
            if (d5 < 0.04045d) {
                pow2 = d5 / 12.92d;
            } else {
                pow2 = Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
            }
            double d6 = i6 / 255.0d;
            if (d6 < 0.04045d) {
                pow3 = d6 / 12.92d;
            } else {
                pow3 = Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
            }
            dArr[0] = ((0.1805d * pow3) + (0.3576d * pow2) + (0.4124d * pow)) * XYZ_WHITE_REFERENCE_Y;
            dArr[1] = ((0.0722d * pow3) + (0.7152d * pow2) + (0.2126d * pow)) * XYZ_WHITE_REFERENCE_Y;
            double d7 = pow3 * 0.9505d;
            dArr[2] = (d7 + (pow2 * 0.1192d) + (pow * 0.0193d)) * XYZ_WHITE_REFERENCE_Y;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = 95.047d) double d, @FloatRange(from = 0.0d, to = 100.0d) double d5, @FloatRange(from = 0.0d, to = 108.883d) double d6) {
        double d7;
        double d8;
        double d9;
        double d10 = (((-0.4986d) * d6) + (((-1.5372d) * d5) + (3.2406d * d))) / XYZ_WHITE_REFERENCE_Y;
        double d11 = ((0.0415d * d6) + ((1.8758d * d5) + ((-0.9689d) * d))) / XYZ_WHITE_REFERENCE_Y;
        double d12 = ((1.057d * d6) + (((-0.204d) * d5) + (0.0557d * d))) / XYZ_WHITE_REFERENCE_Y;
        if (d10 > 0.0031308d) {
            d7 = (Math.pow(d10, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d7 = d10 * 12.92d;
        }
        if (d11 > 0.0031308d) {
            d8 = (Math.pow(d11, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d8 = d11 * 12.92d;
        }
        if (d12 > 0.0031308d) {
            d9 = (Math.pow(d12, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d9 = 12.92d * d12;
        }
        return Color.rgb(constrain((int) Math.round(d7 * 255.0d), 0, 255), constrain((int) Math.round(d8 * 255.0d), 0, 255), constrain((int) Math.round(d9 * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = 95.047d) double d, @FloatRange(from = 0.0d, to = 100.0d) double d5, @FloatRange(from = 0.0d, to = 108.883d) double d6, @NonNull double[] dArr) {
        if (dArr.length == 3) {
            double pivotXyzComponent = pivotXyzComponent(d / XYZ_WHITE_REFERENCE_X);
            double pivotXyzComponent2 = pivotXyzComponent(d5 / XYZ_WHITE_REFERENCE_Y);
            double pivotXyzComponent3 = pivotXyzComponent(d6 / XYZ_WHITE_REFERENCE_Z);
            dArr[0] = Math.max(0.0d, (116.0d * pivotXyzComponent2) - 16.0d);
            dArr[1] = (pivotXyzComponent - pivotXyzComponent2) * 500.0d;
            dArr[2] = (pivotXyzComponent2 - pivotXyzComponent3) * 200.0d;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    @ColorInt
    public static int blendARGB(@ColorInt int i3, @ColorInt int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        float f5 = 1.0f - f4;
        return Color.argb((int) ((Color.alpha(i5) * f4) + (Color.alpha(i3) * f5)), (int) ((Color.red(i5) * f4) + (Color.red(i3) * f5)), (int) ((Color.green(i5) * f4) + (Color.green(i3) * f5)), (int) ((Color.blue(i5) * f4) + (Color.blue(i3) * f5)));
    }

    public static void blendHSL(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, to = 1.0d) float f4, @NonNull float[] fArr3) {
        if (fArr3.length == 3) {
            float f5 = 1.0f - f4;
            fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f4);
            fArr3[1] = (fArr2[1] * f4) + (fArr[1] * f5);
            fArr3[2] = (fArr2[2] * f4) + (fArr[2] * f5);
            return;
        }
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, to = 1.0d) double d, @NonNull double[] dArr3) {
        if (dArr3.length == 3) {
            double d5 = 1.0d - d;
            dArr3[0] = (dArr2[0] * d) + (dArr[0] * d5);
            dArr3[1] = (dArr2[1] * d) + (dArr[1] * d5);
            dArr3[2] = (dArr2[2] * d) + (dArr[2] * d5);
            return;
        }
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static double calculateContrast(@ColorInt int i3, @ColorInt int i5) {
        if (Color.alpha(i5) == 255) {
            if (Color.alpha(i3) < 255) {
                i3 = compositeColors(i3, i5);
            }
            double calculateLuminance = calculateLuminance(i3) + 0.05d;
            double calculateLuminance2 = calculateLuminance(i5) + 0.05d;
            return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i5));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static double calculateLuminance(@ColorInt int i3) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i3, tempDouble3Array);
        return tempDouble3Array[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static int calculateMinimumAlpha(@ColorInt int i3, @ColorInt int i5, float f4) {
        int i6 = 255;
        if (Color.alpha(i5) == 255) {
            double d = f4;
            if (calculateContrast(setAlphaComponent(i3, 255), i5) < d) {
                return -1;
            }
            int i7 = 0;
            for (int i8 = 0; i8 <= 10 && i6 - i7 > 1; i8++) {
                int i9 = (i7 + i6) / 2;
                if (calculateContrast(setAlphaComponent(i3, i9), i5) < d) {
                    i7 = i9;
                } else {
                    i6 = i9;
                }
            }
            return i6;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i5));
    }

    @VisibleForTesting
    public static float circularInterpolate(float f4, float f5, float f6) {
        if (Math.abs(f5 - f4) > 180.0f) {
            if (f5 > f4) {
                f4 += 360.0f;
            } else {
                f5 += 360.0f;
            }
        }
        return (((f5 - f4) * f6) + f4) % 360.0f;
    }

    public static void colorToHSL(@ColorInt int i3, @NonNull float[] fArr) {
        RGBToHSL(Color.red(i3), Color.green(i3), Color.blue(i3), fArr);
    }

    public static void colorToLAB(@ColorInt int i3, @NonNull double[] dArr) {
        RGBToLAB(Color.red(i3), Color.green(i3), Color.blue(i3), dArr);
    }

    public static void colorToXYZ(@ColorInt int i3, @NonNull double[] dArr) {
        RGBToXYZ(Color.red(i3), Color.green(i3), Color.blue(i3), dArr);
    }

    private static int compositeAlpha(int i3, int i5) {
        return i.d(255, i3, 255 - i5, 255, 255);
    }

    public static int compositeColors(@ColorInt int i3, @ColorInt int i5) {
        int alpha = Color.alpha(i5);
        int alpha2 = Color.alpha(i3);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i3), alpha2, Color.red(i5), alpha, compositeAlpha), compositeComponent(Color.green(i3), alpha2, Color.green(i5), alpha, compositeAlpha), compositeComponent(Color.blue(i3), alpha2, Color.blue(i5), alpha, compositeAlpha));
    }

    private static int compositeComponent(int i3, int i5, int i6, int i7, int i8) {
        if (i8 == 0) {
            return 0;
        }
        return i.v(255, i5, i6 * i7, (i3 * 255) * i5) / (i8 * 255);
    }

    private static float constrain(float f4, float f5, float f6) {
        return f4 < f5 ? f5 : f4 > f6 ? f6 : f4;
    }

    public static double distanceEuclidean(@NonNull double[] dArr, @NonNull double[] dArr2) {
        double pow = Math.pow(dArr[0] - dArr2[0], 2.0d);
        return Math.sqrt(Math.pow(dArr[2] - dArr2[2], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + pow);
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr == null) {
            double[] dArr2 = new double[3];
            threadLocal.set(dArr2);
            return dArr2;
        }
        return dArr;
    }

    private static double pivotXyzComponent(double d) {
        if (d > XYZ_EPSILON) {
            return Math.pow(d, 0.3333333333333333d);
        }
        return ((d * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i3, @IntRange(from = 0, to = 255) int i5) {
        if (i5 >= 0 && i5 <= 255) {
            return (i3 & ViewCompat.MEASURED_SIZE_MASK) | (i5 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static int constrain(int i3, int i5, int i6) {
        return i3 < i5 ? i5 : i3 > i6 ? i6 : i3;
    }

    @NonNull
    @RequiresApi(26)
    public static Color compositeColors(@NonNull Color color, @NonNull Color color2) {
        ColorSpace.Model model;
        ColorSpace.Model model2;
        ColorSpace.Model model3;
        ColorSpace.Model model4;
        ColorSpace colorSpace;
        ColorSpace colorSpace2;
        float[] components;
        float[] components2;
        float alpha;
        float alpha2;
        int componentCount;
        ColorSpace colorSpace3;
        Color valueOf;
        ColorSpace colorSpace4;
        model = color.getModel();
        model2 = color2.getModel();
        if (Objects.equals(model, model2)) {
            colorSpace = color2.getColorSpace();
            colorSpace2 = color.getColorSpace();
            if (!Objects.equals(colorSpace, colorSpace2)) {
                colorSpace4 = color2.getColorSpace();
                color = color.convert(colorSpace4);
            }
            components = color.getComponents();
            components2 = color2.getComponents();
            alpha = color.alpha();
            alpha2 = color2.alpha();
            float f4 = (1.0f - alpha) * alpha2;
            componentCount = color2.getComponentCount();
            int i3 = componentCount - 1;
            float f5 = alpha + f4;
            components2[i3] = f5;
            if (f5 > 0.0f) {
                alpha /= f5;
                f4 /= f5;
            }
            for (int i5 = 0; i5 < i3; i5++) {
                components2[i5] = (components2[i5] * f4) + (components[i5] * alpha);
            }
            colorSpace3 = color2.getColorSpace();
            valueOf = Color.valueOf(components2, colorSpace3);
            return valueOf;
        }
        StringBuilder sb = new StringBuilder("Color models must match (");
        model3 = color.getModel();
        sb.append(model3);
        sb.append(" vs. ");
        model4 = color2.getModel();
        sb.append(model4);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }
}
