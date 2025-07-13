package com.google.android.material.math;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static float dist(float f4, float f5, float f6, float f7) {
        return (float) Math.hypot(f6 - f4, f7 - f5);
    }

    public static float distanceToFurthestCorner(float f4, float f5, float f6, float f7, float f8, float f9) {
        return max(dist(f4, f5, f6, f7), dist(f4, f5, f8, f7), dist(f4, f5, f8, f9), dist(f4, f5, f6, f9));
    }

    public static float floorMod(float f4, int i3) {
        float f5 = i3;
        int i5 = (int) (f4 / f5);
        if (Math.signum(f4) * f5 < 0.0f && i5 * i3 != f4) {
            i5--;
        }
        return f4 - (i5 * i3);
    }

    public static boolean geq(float f4, float f5, float f6) {
        return f4 + f6 >= f5;
    }

    public static float lerp(float f4, float f5, float f6) {
        return (f6 * f5) + ((1.0f - f6) * f4);
    }

    private static float max(float f4, float f5, float f6, float f7) {
        return (f4 <= f5 || f4 <= f6 || f4 <= f7) ? (f5 <= f6 || f5 <= f7) ? f6 > f7 ? f6 : f7 : f5 : f4;
    }

    public static int floorMod(int i3, int i5) {
        int i6 = i3 / i5;
        if ((i3 ^ i5) < 0 && i6 * i5 != i3) {
            i6--;
        }
        return i3 - (i6 * i5);
    }
}
