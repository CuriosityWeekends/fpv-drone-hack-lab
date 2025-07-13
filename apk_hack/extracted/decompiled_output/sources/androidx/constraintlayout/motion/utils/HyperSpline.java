package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Cubic {
        public static final double HALF = 0.5d;
        public static final double THIRD = 0.3333333333333333d;
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double d, double d5, double d6, double d7) {
            this.mA = d;
            this.mB = d5;
            this.mC = d6;
            this.mD = d7;
        }

        public double eval(double d) {
            return (((((this.mD * d) + this.mC) * d) + this.mB) * d) + this.mA;
        }

        public double vel(double d) {
            return (((this.mC * 0.5d) + (this.mD * 0.3333333333333333d * d)) * d) + this.mB;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    public static Cubic[] calcNaturalCubic(int i3, double[] dArr) {
        double[] dArr2 = new double[i3];
        double[] dArr3 = new double[i3];
        double[] dArr4 = new double[i3];
        int i5 = i3 - 1;
        int i6 = 0;
        dArr2[0] = 0.5d;
        int i7 = 1;
        for (int i8 = 1; i8 < i5; i8++) {
            dArr2[i8] = 1.0d / (4.0d - dArr2[i8 - 1]);
        }
        int i9 = i3 - 2;
        dArr2[i5] = 1.0d / (2.0d - dArr2[i9]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i7 < i5) {
            int i10 = i7 + 1;
            int i11 = i7 - 1;
            dArr3[i7] = (((dArr[i10] - dArr[i11]) * 3.0d) - dArr3[i11]) * dArr2[i7];
            i7 = i10;
        }
        double d = (((dArr[i5] - dArr[i9]) * 3.0d) - dArr3[i9]) * dArr2[i5];
        dArr3[i5] = d;
        dArr4[i5] = d;
        while (i9 >= 0) {
            dArr4[i9] = dArr3[i9] - (dArr2[i9] * dArr4[i9 + 1]);
            i9--;
        }
        Cubic[] cubicArr = new Cubic[i5];
        while (i6 < i5) {
            double d5 = dArr[i6];
            double d6 = dArr4[i6];
            int i12 = i6 + 1;
            double d7 = dArr[i12];
            double d8 = dArr4[i12];
            cubicArr[i6] = new Cubic((float) d5, d6, (((d7 - d5) * 3.0d) - (d6 * 2.0d)) - d8, ((d5 - d7) * 2.0d) + d6 + d8);
            i6 = i12;
        }
        return cubicArr;
    }

    public double approxLength(Cubic[] cubicArr) {
        int i3;
        int length = cubicArr.length;
        double[] dArr = new double[cubicArr.length];
        double d = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        while (true) {
            i3 = 0;
            if (d5 >= 1.0d) {
                break;
            }
            double d7 = 0.0d;
            while (i3 < cubicArr.length) {
                double d8 = dArr[i3];
                double eval = cubicArr[i3].eval(d5);
                dArr[i3] = eval;
                double d9 = d8 - eval;
                d7 += d9 * d9;
                i3++;
            }
            if (d5 > 0.0d) {
                d6 += Math.sqrt(d7);
            }
            d5 += 0.1d;
        }
        while (i3 < cubicArr.length) {
            double d10 = dArr[i3];
            double eval2 = cubicArr[i3].eval(1.0d);
            dArr[i3] = eval2;
            double d11 = d10 - eval2;
            d += d11 * d11;
            i3++;
        }
        return Math.sqrt(d) + d6;
    }

    public void getPos(double d, double[] dArr) {
        double d5 = d * this.mTotalLength;
        int i3 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i3 >= dArr2.length - 1) {
                break;
            }
            double d6 = dArr2[i3];
            if (d6 >= d5) {
                break;
            }
            d5 -= d6;
            i3++;
        }
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr[i5] = this.mCurve[i5][i3].eval(d5 / this.mCurveLength[i3]);
        }
    }

    public void getVelocity(double d, double[] dArr) {
        double d5 = d * this.mTotalLength;
        int i3 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i3 >= dArr2.length - 1) {
                break;
            }
            double d6 = dArr2[i3];
            if (d6 >= d5) {
                break;
            }
            d5 -= d6;
            i3++;
        }
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr[i5] = this.mCurve[i5][i3].vel(d5 / this.mCurveLength[i3]);
        }
    }

    public void setup(double[][] dArr) {
        int i3;
        int length = dArr[0].length;
        this.mDimensionality = length;
        int length2 = dArr.length;
        this.mPoints = length2;
        this.mCtl = (double[][]) Array.newInstance(Double.TYPE, length, length2);
        this.mCurve = new Cubic[this.mDimensionality];
        for (int i5 = 0; i5 < this.mDimensionality; i5++) {
            for (int i6 = 0; i6 < this.mPoints; i6++) {
                this.mCtl[i5][i6] = dArr[i6][i5];
            }
        }
        int i7 = 0;
        while (true) {
            i3 = this.mDimensionality;
            if (i7 >= i3) {
                break;
            }
            Cubic[][] cubicArr = this.mCurve;
            double[] dArr2 = this.mCtl[i7];
            cubicArr[i7] = calcNaturalCubic(dArr2.length, dArr2);
            i7++;
        }
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i3];
        for (int i8 = 0; i8 < this.mCurveLength.length; i8++) {
            for (int i9 = 0; i9 < this.mDimensionality; i9++) {
                cubicArr2[i9] = this.mCurve[i9][i8];
            }
            double d = this.mTotalLength;
            double[] dArr3 = this.mCurveLength;
            double approxLength = approxLength(cubicArr2);
            dArr3[i8] = approxLength;
            this.mTotalLength = d + approxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d, float[] fArr) {
        double d5 = d * this.mTotalLength;
        int i3 = 0;
        while (true) {
            double[] dArr = this.mCurveLength;
            if (i3 >= dArr.length - 1) {
                break;
            }
            double d6 = dArr[i3];
            if (d6 >= d5) {
                break;
            }
            d5 -= d6;
            i3++;
        }
        for (int i5 = 0; i5 < fArr.length; i5++) {
            fArr[i5] = (float) this.mCurve[i5][i3].eval(d5 / this.mCurveLength[i3]);
        }
    }

    public double getPos(double d, int i3) {
        double[] dArr;
        double d5 = d * this.mTotalLength;
        int i5 = 0;
        while (true) {
            dArr = this.mCurveLength;
            if (i5 >= dArr.length - 1) {
                break;
            }
            double d6 = dArr[i5];
            if (d6 >= d5) {
                break;
            }
            d5 -= d6;
            i5++;
        }
        return this.mCurve[i3][i5].eval(d5 / dArr[i5]);
    }
}
