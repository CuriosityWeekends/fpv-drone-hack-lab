package androidx.constraintlayout.motion.utils;

import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double[] mArea;
    int mType;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    double PI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d, float f4) {
        int length = this.mPeriod.length + 1;
        int binarySearch = Arrays.binarySearch(this.mPosition, d);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.mPosition[binarySearch] = d;
        this.mPeriod[binarySearch] = f4;
        this.mNormalized = false;
    }

    public double getDP(double d) {
        if (d <= 0.0d) {
            d = 1.0E-5d;
        } else if (d >= 1.0d) {
            d = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i3 = -binarySearch;
        int i5 = i3 - 1;
        float[] fArr = this.mPeriod;
        float f4 = fArr[i5];
        int i6 = i3 - 2;
        float f5 = fArr[i6];
        double[] dArr = this.mPosition;
        double d5 = dArr[i5];
        double d6 = dArr[i6];
        double d7 = (f4 - f5) / (d5 - d6);
        return (f5 - (d7 * d6)) + (d * d7);
    }

    public double getP(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i3 = -binarySearch;
        int i5 = i3 - 1;
        float[] fArr = this.mPeriod;
        float f4 = fArr[i5];
        int i6 = i3 - 2;
        float f5 = fArr[i6];
        double[] dArr = this.mPosition;
        double d5 = dArr[i5];
        double d6 = dArr[i6];
        double d7 = (f4 - f5) / (d5 - d6);
        return ((((d * d) - (d6 * d6)) * d7) / 2.0d) + ((d - d6) * (f5 - (d7 * d6))) + this.mArea[i6];
    }

    public double getSlope(double d) {
        switch (this.mType) {
            case 1:
                return 0.0d;
            case 2:
                return Math.signum((((getP(d) * 4.0d) + 3.0d) % 4.0d) - 2.0d) * getDP(d) * 4.0d;
            case 3:
                return getDP(d) * 2.0d;
            case 4:
                return (-getDP(d)) * 2.0d;
            case 5:
                return Math.sin(getP(d) * this.PI2) * getDP(d) * (-this.PI2);
            case 6:
                return ((((getP(d) * 4.0d) + 2.0d) % 4.0d) - 2.0d) * getDP(d) * 4.0d;
            default:
                return Math.cos(getP(d) * this.PI2) * getDP(d) * this.PI2;
        }
    }

    public double getValue(double d) {
        double abs;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (getP(d) % 1.0d));
            case 2:
                abs = Math.abs((((getP(d) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((getP(d) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((getP(d) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(getP(d) * this.PI2);
            case 6:
                double abs2 = 1.0d - Math.abs(((getP(d) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(getP(d) * this.PI2);
        }
        return 1.0d - abs;
    }

    public void normalize() {
        float[] fArr;
        float[] fArr2;
        float[] fArr3;
        int i3;
        double d = 0.0d;
        int i5 = 0;
        while (true) {
            if (i5 >= this.mPeriod.length) {
                break;
            }
            d += fArr[i5];
            i5++;
        }
        double d5 = 0.0d;
        int i6 = 1;
        while (true) {
            if (i6 >= this.mPeriod.length) {
                break;
            }
            double[] dArr = this.mPosition;
            d5 += (dArr[i6] - dArr[i6 - 1]) * ((fArr2[i3] + fArr2[i6]) / 2.0f);
            i6++;
        }
        int i7 = 0;
        while (true) {
            float[] fArr4 = this.mPeriod;
            if (i7 >= fArr4.length) {
                break;
            }
            fArr4[i7] = (float) (fArr4[i7] * (d / d5));
            i7++;
        }
        this.mArea[0] = 0.0d;
        int i8 = 1;
        while (true) {
            if (i8 < this.mPeriod.length) {
                int i9 = i8 - 1;
                double[] dArr2 = this.mPosition;
                double d6 = dArr2[i8] - dArr2[i9];
                double[] dArr3 = this.mArea;
                dArr3[i8] = (d6 * ((fArr3[i9] + fArr3[i8]) / 2.0f)) + dArr3[i9];
                i8++;
            } else {
                this.mNormalized = true;
                return;
            }
        }
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
