package androidx.core.math;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static double clamp(double d, double d5, double d6) {
        return d < d5 ? d5 : d > d6 ? d6 : d;
    }

    public static float clamp(float f4, float f5, float f6) {
        return f4 < f5 ? f5 : f4 > f6 ? f6 : f4;
    }

    public static int clamp(int i3, int i5, int i6) {
        return i3 < i5 ? i5 : i3 > i6 ? i6 : i3;
    }

    public static long clamp(long j2, long j5, long j6) {
        return j2 < j5 ? j5 : j2 > j6 ? j6 : j2;
    }
}
