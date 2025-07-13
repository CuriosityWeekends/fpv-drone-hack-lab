package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 3;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;

    /* renamed from: x  reason: collision with root package name */
    float f118x;

    /* renamed from: y  reason: collision with root package name */
    float f119y;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f4, float f5) {
        if (!Float.isNaN(f4) && !Float.isNaN(f5)) {
            if (Math.abs(f4 - f5) <= 1.0E-6f) {
                return false;
            }
            return true;
        } else if (Float.isNaN(f4) == Float.isNaN(f5)) {
            return false;
        } else {
            return true;
        }
    }

    private static final float xRotate(float f4, float f5, float f6, float f7, float f8, float f9) {
        return (((f8 - f6) * f5) - ((f9 - f7) * f4)) + f6;
    }

    private static final float yRotate(float f4, float f5, float f6, float f7, float f8, float f9) {
        return ((f9 - f7) * f5) + ((f8 - f6) * f4) + f7;
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        ConstraintSet.Motion motion = constraint.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mProgress = constraint.propertySet.mProgress;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z3) {
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        zArr[1] = zArr[1] | diff(this.f118x, motionPaths.f118x) | z3;
        zArr[2] = z3 | diff(this.f119y, motionPaths.f119y) | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.f118x, this.f119y, this.width, this.height, this.mPathRotate};
        int i3 = 0;
        for (int i5 : iArr) {
            if (i5 < 6) {
                dArr[i3] = fArr[i5];
                i3++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i3) {
        float f4 = this.width;
        float f5 = this.height;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f6 = (float) dArr[i5];
            int i6 = iArr[i5];
            if (i6 != 3) {
                if (i6 == 4) {
                    f5 = f6;
                }
            } else {
                f4 = f6;
            }
        }
        fArr[i3] = f4;
        fArr[i3 + 1] = f5;
    }

    public void getCenter(int[] iArr, double[] dArr, float[] fArr, int i3) {
        float f4 = this.f118x;
        float f5 = this.f119y;
        float f6 = this.width;
        float f7 = this.height;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f8 = (float) dArr[i5];
            int i6 = iArr[i5];
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 == 4) {
                            f7 = f8;
                        }
                    } else {
                        f6 = f8;
                    }
                } else {
                    f5 = f8;
                }
            } else {
                f4 = f8;
            }
        }
        fArr[i3] = (f6 / 2.0f) + f4 + 0.0f;
        fArr[i3 + 1] = (f7 / 2.0f) + f5 + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i3) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        if (constraintAttribute.noOfInterpValues() == 1) {
            dArr[i3] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int noOfInterpValues = constraintAttribute.noOfInterpValues();
        float[] fArr = new float[noOfInterpValues];
        constraintAttribute.getValuesToInterpolate(fArr);
        int i5 = 0;
        while (i5 < noOfInterpValues) {
            dArr[i3] = fArr[i5];
            i5++;
            i3++;
        }
        return noOfInterpValues;
    }

    public int getCustomDataCount(String str) {
        return this.attributes.get(str).noOfInterpValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i3) {
        float f4 = this.f118x;
        float f5 = this.f119y;
        float f6 = this.width;
        float f7 = this.height;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            float f8 = (float) dArr[i5];
            int i6 = iArr[i5];
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 == 4) {
                            f7 = f8;
                        }
                    } else {
                        f6 = f8;
                    }
                } else {
                    f5 = f8;
                }
            } else {
                f4 = f8;
            }
        }
        float f9 = f6 + f4;
        float f10 = f7 + f5;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i3] = f4 + 0.0f;
        fArr[i3 + 1] = f5 + 0.0f;
        fArr[i3 + 2] = f9 + 0.0f;
        fArr[i3 + 3] = f5 + 0.0f;
        fArr[i3 + 4] = f9 + 0.0f;
        int i7 = i3 + 6;
        fArr[i3 + 5] = f10 + 0.0f;
        fArr[i7] = f4 + 0.0f;
        fArr[i3 + 7] = f10 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    public void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8 = keyPosition.mFramePosition / 100.0f;
        this.time = f8;
        this.mDrawPath = keyPosition.mDrawPath;
        if (Float.isNaN(keyPosition.mPercentWidth)) {
            f4 = f8;
        } else {
            f4 = keyPosition.mPercentWidth;
        }
        if (Float.isNaN(keyPosition.mPercentHeight)) {
            f5 = f8;
        } else {
            f5 = keyPosition.mPercentHeight;
        }
        float f9 = motionPaths2.width;
        float f10 = motionPaths.width;
        float f11 = f9 - f10;
        float f12 = motionPaths2.height;
        float f13 = motionPaths.height;
        float f14 = f12 - f13;
        this.position = this.time;
        float f15 = motionPaths.f118x;
        float f16 = motionPaths.f119y;
        float f17 = (f9 / 2.0f) + motionPaths2.f118x;
        float f18 = f17 - ((f10 / 2.0f) + f15);
        float f19 = ((f12 / 2.0f) + motionPaths2.f119y) - ((f13 / 2.0f) + f16);
        float f20 = f11 * f4;
        float f21 = f20 / 2.0f;
        this.f118x = (int) (((f18 * f8) + f15) - f21);
        float f22 = (f19 * f8) + f16;
        float f23 = f14 * f5;
        float f24 = f23 / 2.0f;
        this.f119y = (int) (f22 - f24);
        this.width = (int) (f10 + f20);
        this.height = (int) (f13 + f23);
        if (Float.isNaN(keyPosition.mPercentX)) {
            f6 = f8;
        } else {
            f6 = keyPosition.mPercentX;
        }
        float f25 = 0.0f;
        if (Float.isNaN(keyPosition.mAltPercentY)) {
            f7 = 0.0f;
        } else {
            f7 = keyPosition.mAltPercentY;
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f8 = keyPosition.mPercentY;
        }
        if (!Float.isNaN(keyPosition.mAltPercentX)) {
            f25 = keyPosition.mAltPercentX;
        }
        this.mMode = 2;
        float f26 = f25 * f19;
        this.f118x = (int) ((f26 + ((f6 * f18) + motionPaths.f118x)) - f21);
        float f27 = f19 * f8;
        this.f119y = (int) ((f27 + ((f18 * f7) + motionPaths.f119y)) - f24);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9 = keyPosition.mFramePosition / 100.0f;
        this.time = f9;
        this.mDrawPath = keyPosition.mDrawPath;
        if (Float.isNaN(keyPosition.mPercentWidth)) {
            f4 = f9;
        } else {
            f4 = keyPosition.mPercentWidth;
        }
        if (Float.isNaN(keyPosition.mPercentHeight)) {
            f5 = f9;
        } else {
            f5 = keyPosition.mPercentHeight;
        }
        float f10 = motionPaths2.width - motionPaths.width;
        float f11 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            f9 = keyPosition.mPercentX;
        }
        float f12 = motionPaths.f118x;
        float f13 = motionPaths.width;
        float f14 = motionPaths.f119y;
        float f15 = motionPaths.height;
        float f16 = ((motionPaths2.width / 2.0f) + motionPaths2.f118x) - ((f13 / 2.0f) + f12);
        float f17 = ((motionPaths2.height / 2.0f) + motionPaths2.f119y) - ((f15 / 2.0f) + f14);
        float f18 = f16 * f9;
        float f19 = (f10 * f4) / 2.0f;
        this.f118x = (int) ((f12 + f18) - f19);
        float f20 = f9 * f17;
        float f21 = (f11 * f5) / 2.0f;
        this.f119y = (int) ((f14 + f20) - f21);
        this.width = (int) (f13 + f6);
        this.height = (int) (f15 + f7);
        if (Float.isNaN(keyPosition.mPercentY)) {
            f8 = 0.0f;
        } else {
            f8 = keyPosition.mPercentY;
        }
        this.mMode = 1;
        float f22 = (int) ((motionPaths.f118x + f18) - f19);
        float f23 = (int) ((motionPaths.f119y + f20) - f21);
        this.f118x = f22 + ((-f17) * f8);
        this.f119y = f23 + (f16 * f8);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void initScreen(int i3, int i5, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f4;
        float f5;
        float f6 = keyPosition.mFramePosition / 100.0f;
        this.time = f6;
        this.mDrawPath = keyPosition.mDrawPath;
        if (Float.isNaN(keyPosition.mPercentWidth)) {
            f4 = f6;
        } else {
            f4 = keyPosition.mPercentWidth;
        }
        if (Float.isNaN(keyPosition.mPercentHeight)) {
            f5 = f6;
        } else {
            f5 = keyPosition.mPercentHeight;
        }
        float f7 = motionPaths2.width;
        float f8 = motionPaths.width;
        float f9 = f7 - f8;
        float f10 = motionPaths2.height;
        float f11 = motionPaths.height;
        float f12 = f10 - f11;
        this.position = this.time;
        float f13 = motionPaths.f118x;
        float f14 = motionPaths.f119y;
        float f15 = (f7 / 2.0f) + motionPaths2.f118x;
        float f16 = (f10 / 2.0f) + motionPaths2.f119y;
        float f17 = f9 * f4;
        this.f118x = (int) ((((f15 - ((f8 / 2.0f) + f13)) * f6) + f13) - (f17 / 2.0f));
        float f18 = f12 * f5;
        this.f119y = (int) ((((f16 - ((f11 / 2.0f) + f14)) * f6) + f14) - (f18 / 2.0f));
        this.width = (int) (f8 + f17);
        this.height = (int) (f11 + f18);
        this.mMode = 3;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            this.f118x = (int) (keyPosition.mPercentX * ((int) (i3 - this.width)));
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            this.f119y = (int) (keyPosition.mPercentY * ((int) (i5 - this.height)));
        }
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void setBounds(float f4, float f5, float f6, float f7) {
        this.f118x = f4;
        this.f119y = f5;
        this.width = f6;
        this.height = f7;
    }

    public void setDpDt(float f4, float f5, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f10 = (float) dArr[i3];
            double d = dArr2[i3];
            int i5 = iArr[i3];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 == 4) {
                            f9 = f10;
                        }
                    } else {
                        f7 = f10;
                    }
                } else {
                    f8 = f10;
                }
            } else {
                f6 = f10;
            }
        }
        float f11 = f6 - ((0.0f * f7) / 2.0f);
        float f12 = f8 - ((0.0f * f9) / 2.0f);
        fArr[0] = (((f7 * 1.0f) + f11) * f4) + ((1.0f - f4) * f11) + 0.0f;
        fArr[1] = (((f9 * 1.0f) + f12) * f5) + ((1.0f - f5) * f12) + 0.0f;
    }

    public void setView(View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f4;
        float f5 = this.f118x;
        float f6 = this.f119y;
        float f7 = this.width;
        float f8 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i3 = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i3];
            this.mTempDelta = new double[i3];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        int i5 = 0;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            double[] dArr4 = this.mTempValue;
            int i7 = iArr[i6];
            dArr4[i7] = dArr[i6];
            this.mTempDelta[i7] = dArr2[i6];
        }
        float f9 = Float.NaN;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i5 >= dArr5.length) {
                break;
            }
            boolean isNaN = Double.isNaN(dArr5[i5]);
            double d = 0.0d;
            if (isNaN && (dArr3 == null || dArr3[i5] == 0.0d)) {
                f4 = f9;
            } else {
                if (dArr3 != null) {
                    d = dArr3[i5];
                }
                if (!Double.isNaN(this.mTempValue[i5])) {
                    d = this.mTempValue[i5] + d;
                }
                f4 = f9;
                float f14 = (float) d;
                float f15 = (float) this.mTempDelta[i5];
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 != 4) {
                                if (i5 == 5) {
                                    f9 = f14;
                                }
                            } else {
                                f9 = f4;
                                f8 = f14;
                                f13 = f15;
                            }
                        } else {
                            f9 = f4;
                            f7 = f14;
                            f11 = f15;
                        }
                    } else {
                        f9 = f4;
                        f6 = f14;
                        f12 = f15;
                    }
                } else {
                    f9 = f4;
                    f5 = f14;
                    f10 = f15;
                }
                i5++;
            }
            f9 = f4;
            i5++;
        }
        float f16 = f9;
        if (Float.isNaN(f16)) {
            if (!Float.isNaN(Float.NaN)) {
                view.setRotation(Float.NaN);
            }
        } else {
            float f17 = Float.NaN;
            if (Float.isNaN(Float.NaN)) {
                f17 = 0.0f;
            }
            view.setRotation((float) (Math.toDegrees(Math.atan2((f13 / 2.0f) + f12, (f11 / 2.0f) + f10)) + f16 + f17));
        }
        float f18 = f5 + 0.5f;
        int i8 = (int) f18;
        float f19 = f6 + 0.5f;
        int i9 = (int) f19;
        int i10 = (int) (f18 + f7);
        int i11 = (int) (f19 + f8);
        int i12 = i10 - i8;
        int i13 = i11 - i9;
        if (i12 != view.getMeasuredWidth() || i13 != view.getMeasuredHeight()) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i12, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i13, BasicMeasure.EXACTLY));
        }
        view.layout(i8, i9, i10, i11);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public MotionPaths(int i3, int i5, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        int i6 = keyPosition.mPositionType;
        if (i6 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
        } else if (i6 != 2) {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i3, i5, keyPosition, motionPaths, motionPaths2);
        }
    }
}
