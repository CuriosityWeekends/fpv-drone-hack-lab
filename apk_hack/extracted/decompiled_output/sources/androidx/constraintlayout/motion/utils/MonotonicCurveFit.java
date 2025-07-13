package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        int i3 = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance(cls, i3, length2);
        double[][] dArr4 = (double[][]) Array.newInstance(cls, length, length2);
        for (int i5 = 0; i5 < length2; i5++) {
            int i6 = 0;
            while (i6 < i3) {
                int i7 = i6 + 1;
                double d = dArr[i7] - dArr[i6];
                double[] dArr5 = dArr3[i6];
                double d5 = (dArr2[i7][i5] - dArr2[i6][i5]) / d;
                dArr5[i5] = d5;
                if (i6 == 0) {
                    dArr4[i6][i5] = d5;
                } else {
                    dArr4[i6][i5] = (dArr3[i6 - 1][i5] + d5) * 0.5d;
                }
                i6 = i7;
            }
            dArr4[i3][i5] = dArr3[length - 2][i5];
        }
        for (int i8 = 0; i8 < i3; i8++) {
            for (int i9 = 0; i9 < length2; i9++) {
                double d6 = dArr3[i8][i9];
                if (d6 == 0.0d) {
                    dArr4[i8][i9] = 0.0d;
                    dArr4[i8 + 1][i9] = 0.0d;
                } else {
                    double d7 = dArr4[i8][i9] / d6;
                    int i10 = i8 + 1;
                    double d8 = dArr4[i10][i9] / d6;
                    double hypot = Math.hypot(d7, d8);
                    if (hypot > 9.0d) {
                        double d9 = 3.0d / hypot;
                        double[] dArr6 = dArr4[i8];
                        double[] dArr7 = dArr3[i8];
                        dArr6[i9] = d7 * d9 * dArr7[i9];
                        dArr4[i10][i9] = d9 * d8 * dArr7[i9];
                    }
                }
            }
        }
        this.mT = dArr;
        this.mY = dArr2;
        this.mTangent = dArr4;
    }

    private static double diff(double d, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d5 * d5;
        double d11 = d5 * 6.0d;
        double d12 = 6.0d * d10 * d6;
        double d13 = 3.0d * d;
        double d14 = d13 * d8 * d10;
        return (d * d8) + (((d14 + (((d13 * d9) * d10) + ((d12 + ((d11 * d7) + (((-6.0d) * d10) * d7))) - (d11 * d6)))) - (((2.0d * d) * d9) * d5)) - (((4.0d * d) * d8) * d5));
    }

    private static double interpolate(double d, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d5 * d5;
        double d11 = d10 * d5;
        double d12 = 3.0d * d10;
        double d13 = d12 * d7;
        double d14 = d * d9;
        double d15 = d14 * d11;
        double d16 = d * d8;
        return (d16 * d5) + ((((d11 * d16) + (d15 + (((((d11 * 2.0d) * d6) + (d13 + (((-2.0d) * d11) * d7))) - (d12 * d6)) + d6))) - (d14 * d10)) - (((2.0d * d) * d8) * d10));
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i3 = 0;
        int length2 = this.mY[0].length;
        if (d <= dArr2[0]) {
            for (int i5 = 0; i5 < length2; i5++) {
                dArr[i5] = this.mY[0][i5];
            }
            return;
        }
        int i6 = length - 1;
        if (d >= dArr2[i6]) {
            while (i3 < length2) {
                dArr[i3] = this.mY[i6][i3];
                i3++;
            }
            return;
        }
        int i7 = 0;
        while (i7 < i6) {
            if (d == this.mT[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    dArr[i8] = this.mY[i7][i8];
                }
            }
            double[] dArr3 = this.mT;
            int i9 = i7 + 1;
            double d5 = dArr3[i9];
            if (d < d5) {
                double d6 = dArr3[i7];
                double d7 = d5 - d6;
                double d8 = (d - d6) / d7;
                while (i3 < length2) {
                    double[][] dArr4 = this.mY;
                    double d9 = dArr4[i7][i3];
                    double d10 = dArr4[i9][i3];
                    double[][] dArr5 = this.mTangent;
                    dArr[i3] = interpolate(d7, d8, d9, d10, dArr5[i7][i3], dArr5[i9][i3]);
                    i3++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        double d5 = dArr2[0];
        if (d > d5) {
            d5 = dArr2[length - 1];
            if (d < d5) {
                d5 = d;
            }
        }
        int i3 = 0;
        while (i3 < length - 1) {
            double[] dArr3 = this.mT;
            int i5 = i3 + 1;
            double d6 = dArr3[i5];
            if (d5 <= d6) {
                double d7 = dArr3[i3];
                double d8 = d6 - d7;
                double d9 = (d5 - d7) / d8;
                for (int i6 = 0; i6 < length2; i6++) {
                    double[][] dArr4 = this.mY;
                    double d10 = dArr4[i3][i6];
                    double d11 = dArr4[i5][i6];
                    double[][] dArr5 = this.mTangent;
                    dArr[i6] = diff(d8, d9, d10, d11, dArr5[i3][i6], dArr5[i5][i6]) / d8;
                }
                return;
            }
            i3 = i5;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d, int i3) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i5 = 0;
        double d5 = dArr[0];
        if (d >= d5) {
            d5 = dArr[length - 1];
            if (d < d5) {
                d5 = d;
            }
        }
        while (i5 < length - 1) {
            double[] dArr2 = this.mT;
            int i6 = i5 + 1;
            double d6 = dArr2[i6];
            if (d5 <= d6) {
                double d7 = dArr2[i5];
                double d8 = d6 - d7;
                double[][] dArr3 = this.mY;
                double d9 = dArr3[i5][i3];
                double d10 = dArr3[i6][i3];
                double[][] dArr4 = this.mTangent;
                return diff(d8, (d5 - d7) / d8, d9, d10, dArr4[i5][i3], dArr4[i6][i3]) / d8;
            }
            i5 = i6;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i3 = 0;
        int length2 = this.mY[0].length;
        if (d <= dArr[0]) {
            for (int i5 = 0; i5 < length2; i5++) {
                fArr[i5] = (float) this.mY[0][i5];
            }
            return;
        }
        int i6 = length - 1;
        if (d >= dArr[i6]) {
            while (i3 < length2) {
                fArr[i3] = (float) this.mY[i6][i3];
                i3++;
            }
            return;
        }
        int i7 = 0;
        while (i7 < i6) {
            if (d == this.mT[i7]) {
                for (int i8 = 0; i8 < length2; i8++) {
                    fArr[i8] = (float) this.mY[i7][i8];
                }
            }
            double[] dArr2 = this.mT;
            int i9 = i7 + 1;
            double d5 = dArr2[i9];
            if (d < d5) {
                double d6 = dArr2[i7];
                double d7 = d5 - d6;
                double d8 = (d - d6) / d7;
                while (i3 < length2) {
                    double[][] dArr3 = this.mY;
                    double d9 = dArr3[i7][i3];
                    double d10 = dArr3[i9][i3];
                    double[][] dArr4 = this.mTangent;
                    fArr[i3] = (float) interpolate(d7, d8, d9, d10, dArr4[i7][i3], dArr4[i9][i3]);
                    i3++;
                }
                return;
            }
            i7 = i9;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d, int i3) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i5 = 0;
        if (d <= dArr[0]) {
            return this.mY[0][i3];
        }
        int i6 = length - 1;
        if (d >= dArr[i6]) {
            return this.mY[i6][i3];
        }
        while (i5 < i6) {
            double[] dArr2 = this.mT;
            double d5 = dArr2[i5];
            if (d == d5) {
                return this.mY[i5][i3];
            }
            int i7 = i5 + 1;
            double d6 = dArr2[i7];
            if (d < d6) {
                double d7 = d6 - d5;
                double d8 = (d - d5) / d7;
                double[][] dArr3 = this.mY;
                double d9 = dArr3[i5][i3];
                double d10 = dArr3[i7][i3];
                double[][] dArr4 = this.mTangent;
                return interpolate(d7, d8, d9, d10, dArr4[i5][i3], dArr4[i7][i3]);
            }
            i5 = i7;
        }
        return 0.0d;
    }
}
