package androidx.constraintlayout.motion.utils;

import android.util.Log;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    String str = "identity";
    static Easing sDefault = new Easing();
    private static final String STANDARD_NAME = "standard";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals(ACCELERATE_NAME)) {
                    c = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals(DECELERATE_NAME)) {
                    c = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals(LINEAR_NAME)) {
                    c = 2;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals(STANDARD_NAME)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new CubicEasing(ACCELERATE);
            case 1:
                return new CubicEasing(DECELERATE);
            case 2:
                return new CubicEasing(LINEAR);
            case 3:
                return new CubicEasing(STANDARD);
            default:
                Log.e("ConstraintSet", "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double get(double d) {
        return d;
    }

    public double getDiff(double d) {
        return 1.0d;
    }

    public String toString() {
        return this.str;
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class CubicEasing extends Easing {
        private static double d_error = 1.0E-4d;
        private static double error = 0.01d;

        /* renamed from: x1  reason: collision with root package name */
        double f112x1;

        /* renamed from: x2  reason: collision with root package name */
        double f113x2;

        /* renamed from: y1  reason: collision with root package name */
        double f114y1;

        /* renamed from: y2  reason: collision with root package name */
        double f115y2;

        public CubicEasing(String str) {
            this.str = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f112x1 = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i3 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i3);
            this.f114y1 = Double.parseDouble(str.substring(i3, indexOf3).trim());
            int i5 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i5);
            this.f113x2 = Double.parseDouble(str.substring(i5, indexOf4).trim());
            int i6 = indexOf4 + 1;
            this.f115y2 = Double.parseDouble(str.substring(i6, str.indexOf(41, i6)).trim());
        }

        private double getDiffX(double d) {
            double d5 = 1.0d - d;
            double d6 = this.f112x1;
            double d7 = d5 * 3.0d * d5 * d6;
            double d8 = this.f113x2;
            return ((1.0d - d8) * 3.0d * d * d) + ((d8 - d6) * d5 * 6.0d * d) + d7;
        }

        private double getDiffY(double d) {
            double d5 = 1.0d - d;
            double d6 = this.f114y1;
            double d7 = d5 * 3.0d * d5 * d6;
            double d8 = this.f115y2;
            return ((1.0d - d8) * 3.0d * d * d) + ((d8 - d6) * d5 * 6.0d * d) + d7;
        }

        private double getX(double d) {
            double d5 = 1.0d - d;
            double d6 = 3.0d * d5;
            double d7 = d5 * d6 * d;
            double d8 = d6 * d * d;
            return (this.f113x2 * d8) + (this.f112x1 * d7) + (d * d * d);
        }

        private double getY(double d) {
            double d5 = 1.0d - d;
            double d6 = 3.0d * d5;
            double d7 = d5 * d6 * d;
            double d8 = d6 * d * d;
            return (this.f115y2 * d8) + (this.f114y1 * d7) + (d * d * d);
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double get(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double d5 = 0.5d;
            double d6 = 0.5d;
            while (d5 > error) {
                d5 *= 0.5d;
                if (getX(d6) < d) {
                    d6 += d5;
                } else {
                    d6 -= d5;
                }
            }
            double d7 = d6 - d5;
            double x3 = getX(d7);
            double d8 = d6 + d5;
            double x5 = getX(d8);
            double y3 = getY(d7);
            return (((d - x3) * (getY(d8) - y3)) / (x5 - x3)) + y3;
        }

        @Override // androidx.constraintlayout.motion.utils.Easing
        public double getDiff(double d) {
            double d5 = 0.5d;
            double d6 = 0.5d;
            while (d5 > d_error) {
                d5 *= 0.5d;
                if (getX(d6) < d) {
                    d6 += d5;
                } else {
                    d6 -= d5;
                }
            }
            double d7 = d6 - d5;
            double x3 = getX(d7);
            double d8 = d6 + d5;
            return (getY(d8) - getY(d7)) / (getX(d8) - x3);
        }

        public void setup(double d, double d5, double d6, double d7) {
            this.f112x1 = d;
            this.f114y1 = d5;
            this.f113x2 = d6;
            this.f115y2 = d7;
        }

        public CubicEasing(double d, double d5, double d6, double d7) {
            setup(d, d5, d6, d7);
        }
    }
}
