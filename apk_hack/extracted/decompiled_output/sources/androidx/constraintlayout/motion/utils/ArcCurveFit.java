package androidx.constraintlayout.motion.utils;

import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private final double[] mTime;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent = new double[91];
        boolean linear;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        public Arc(int i3, double d, double d5, double d6, double d7, double d8, double d9) {
            int i5;
            double d10;
            double d11;
            this.linear = false;
            this.mVertical = i3 == 1;
            this.mTime1 = d;
            this.mTime2 = d5;
            this.mOneOverDeltaTime = 1.0d / (d5 - d);
            if (3 == i3) {
                this.linear = true;
            }
            double d12 = d8 - d6;
            double d13 = d9 - d7;
            if (!this.linear && Math.abs(d12) >= EPSILON && Math.abs(d13) >= EPSILON) {
                this.mLut = new double[101];
                boolean z3 = this.mVertical;
                if (z3) {
                    i5 = -1;
                } else {
                    i5 = 1;
                }
                this.mEllipseA = d12 * i5;
                this.mEllipseB = d13 * (z3 ? 1 : -1);
                if (z3) {
                    d10 = d8;
                } else {
                    d10 = d6;
                }
                this.mEllipseCenterX = d10;
                if (z3) {
                    d11 = d7;
                } else {
                    d11 = d9;
                }
                this.mEllipseCenterY = d11;
                buildTable(d6, d7, d8, d9);
                this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
                return;
            }
            this.linear = true;
            this.mX1 = d6;
            this.mX2 = d8;
            this.mY1 = d7;
            this.mY2 = d9;
            double hypot = Math.hypot(d13, d12);
            this.mArcDistance = hypot;
            this.mArcVelocity = hypot * this.mOneOverDeltaTime;
            double d14 = this.mTime2;
            double d15 = this.mTime1;
            this.mEllipseCenterX = d12 / (d14 - d15);
            this.mEllipseCenterY = d13 / (d14 - d15);
        }

        private void buildTable(double d, double d5, double d6, double d7) {
            double[] dArr;
            double[] dArr2;
            double d8;
            double d9 = d6 - d;
            double d10 = d5 - d7;
            int i3 = 0;
            double d11 = 0.0d;
            double d12 = 0.0d;
            double d13 = 0.0d;
            while (true) {
                if (i3 >= ourPercent.length) {
                    break;
                }
                double d14 = d11;
                double radians = Math.toRadians((i3 * 90.0d) / (dArr.length - 1));
                double sin = Math.sin(radians) * d9;
                double cos = Math.cos(radians) * d10;
                if (i3 > 0) {
                    d8 = Math.hypot(sin - d12, cos - d13) + d14;
                    ourPercent[i3] = d8;
                } else {
                    d8 = d14;
                }
                i3++;
                d13 = cos;
                d11 = d8;
                d12 = sin;
            }
            double d15 = d11;
            this.mArcDistance = d15;
            int i5 = 0;
            while (true) {
                double[] dArr3 = ourPercent;
                if (i5 >= dArr3.length) {
                    break;
                }
                dArr3[i5] = dArr3[i5] / d15;
                i5++;
            }
            int i6 = 0;
            while (true) {
                if (i6 < this.mLut.length) {
                    double length = i6 / (dArr2.length - 1);
                    int binarySearch = Arrays.binarySearch(ourPercent, length);
                    if (binarySearch >= 0) {
                        this.mLut[i6] = binarySearch / (ourPercent.length - 1);
                    } else if (binarySearch == -1) {
                        this.mLut[i6] = 0.0d;
                    } else {
                        int i7 = -binarySearch;
                        int i8 = i7 - 2;
                        double[] dArr4 = ourPercent;
                        double d16 = dArr4[i8];
                        this.mLut[i6] = (((length - d16) / (dArr4[i7 - 1] - d16)) + i8) / (dArr4.length - 1);
                    }
                    i6++;
                } else {
                    return;
                }
            }
        }

        public double getDX() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d, (-this.mEllipseB) * this.mTmpSinAngle);
            if (this.mVertical) {
                d = -d;
            }
            return d * hypot;
        }

        public double getDY() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double d5 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d, d5);
            if (this.mVertical) {
                return (-d5) * hypot;
            }
            return d5 * hypot;
        }

        public double getLinearDX(double d) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double d) {
            double d5 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d6 = this.mX1;
            return ((this.mX2 - d6) * d5) + d6;
        }

        public double getLinearY(double d) {
            double d5 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d6 = this.mY1;
            return ((this.mY2 - d6) * d5) + d6;
        }

        public double getX() {
            return (this.mEllipseA * this.mTmpSinAngle) + this.mEllipseCenterX;
        }

        public double getY() {
            return (this.mEllipseB * this.mTmpCosAngle) + this.mEllipseCenterY;
        }

        public double lookup(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d * (dArr.length - 1);
            int i3 = (int) length;
            double d5 = length - i3;
            double d6 = dArr[i3];
            return ((dArr[i3 + 1] - d6) * d5) + d6;
        }

        public void setPoint(double d) {
            double d5;
            if (this.mVertical) {
                d5 = this.mTime2 - d;
            } else {
                d5 = d - this.mTime1;
            }
            double lookup = lookup(d5 * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(lookup);
            this.mTmpCosAngle = Math.cos(lookup);
        }
    }

    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i3 = 0;
        int i5 = 1;
        int i6 = 1;
        while (true) {
            Arc[] arcArr = this.mArcs;
            if (i3 < arcArr.length) {
                int i7 = iArr[i3];
                if (i7 != 0) {
                    if (i7 != 1) {
                        if (i7 != 2) {
                            if (i7 == 3) {
                                if (i5 == 1) {
                                    i5 = 2;
                                } else {
                                    i5 = 1;
                                }
                                i6 = i5;
                            }
                        } else {
                            i5 = 2;
                            i6 = 2;
                        }
                    } else {
                        i5 = 1;
                        i6 = 1;
                    }
                } else {
                    i6 = 3;
                }
                double d = dArr[i3];
                int i8 = i3 + 1;
                double d5 = dArr[i8];
                double[] dArr3 = dArr2[i3];
                double d6 = dArr3[0];
                double d7 = dArr3[1];
                double[] dArr4 = dArr2[i8];
                arcArr[i3] = new Arc(i6, d, d5, d6, d7, dArr4[0], dArr4[1]);
                i3 = i8;
            } else {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d5 = arcArr[0].mTime1;
        if (d < d5) {
            d = d5;
        }
        if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        int i3 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i3 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i3];
            if (d <= arc.mTime2) {
                if (arc.linear) {
                    dArr[0] = arc.getLinearX(d);
                    dArr[1] = this.mArcs[i3].getLinearY(d);
                    return;
                }
                arc.setPoint(d);
                dArr[0] = this.mArcs[i3].getX();
                dArr[1] = this.mArcs[i3].getY();
                return;
            }
            i3++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        Arc[] arcArr = this.mArcs;
        double d5 = arcArr[0].mTime1;
        if (d < d5) {
            d = d5;
        } else if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        int i3 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i3 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i3];
            if (d <= arc.mTime2) {
                if (arc.linear) {
                    dArr[0] = arc.getLinearDX(d);
                    dArr[1] = this.mArcs[i3].getLinearDY(d);
                    return;
                }
                arc.setPoint(d);
                dArr[0] = this.mArcs[i3].getDX();
                dArr[1] = this.mArcs[i3].getDY();
                return;
            }
            i3++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        Arc[] arcArr = this.mArcs;
        double d5 = arcArr[0].mTime1;
        if (d < d5) {
            d = d5;
        } else if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        int i3 = 0;
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i3 >= arcArr2.length) {
                return;
            }
            Arc arc = arcArr2[i3];
            if (d <= arc.mTime2) {
                if (arc.linear) {
                    fArr[0] = (float) arc.getLinearX(d);
                    fArr[1] = (float) this.mArcs[i3].getLinearY(d);
                    return;
                }
                arc.setPoint(d);
                fArr[0] = (float) this.mArcs[i3].getX();
                fArr[1] = (float) this.mArcs[i3].getY();
                return;
            }
            i3++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d, int i3) {
        Arc[] arcArr = this.mArcs;
        int i5 = 0;
        double d5 = arcArr[0].mTime1;
        if (d < d5) {
            d = d5;
        }
        if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i5 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i5];
            if (d <= arc.mTime2) {
                if (arc.linear) {
                    if (i3 == 0) {
                        return arc.getLinearDX(d);
                    }
                    return arc.getLinearDY(d);
                }
                arc.setPoint(d);
                if (i3 == 0) {
                    return this.mArcs[i5].getDX();
                }
                return this.mArcs[i5].getDY();
            }
            i5++;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d, int i3) {
        Arc[] arcArr = this.mArcs;
        int i5 = 0;
        double d5 = arcArr[0].mTime1;
        if (d < d5) {
            d = d5;
        } else if (d > arcArr[arcArr.length - 1].mTime2) {
            d = arcArr[arcArr.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr2 = this.mArcs;
            if (i5 >= arcArr2.length) {
                return Double.NaN;
            }
            Arc arc = arcArr2[i5];
            if (d <= arc.mTime2) {
                if (arc.linear) {
                    if (i3 == 0) {
                        return arc.getLinearX(d);
                    }
                    return arc.getLinearY(d);
                }
                arc.setPoint(d);
                if (i3 == 0) {
                    return this.mArcs[i5].getX();
                }
                return this.mArcs[i5].getY();
            }
            i5++;
        }
    }
}
