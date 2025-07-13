package androidx.constraintlayout.motion.widget;

import a1.i;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    private String mType;
    protected int[] mTimePoints = new int[10];
    protected float[] mValues = new float[10];

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class AlphaSet extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            view.setAlpha(get(f4));
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class CustomSet extends SplineSet {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setPoint(int i3, float f4) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            this.mCurveFit.getPos(f4, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mTempValues);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setup(int i3) {
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[noOfInterpValues];
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, noOfInterpValues);
            for (int i5 = 0; i5 < size; i5++) {
                dArr[i5] = this.mConstraintAttributeList.keyAt(i5) * 0.01d;
                this.mConstraintAttributeList.valueAt(i5).getValuesToInterpolate(this.mTempValues);
                int i6 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i6 < fArr.length) {
                        dArr2[i5][i6] = fArr[i6];
                        i6++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(i3, dArr, dArr2);
        }

        public void setPoint(int i3, ConstraintAttribute constraintAttribute) {
            this.mConstraintAttributeList.append(i3, constraintAttribute);
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class ElevationSet extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            view.setElevation(get(f4));
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class PathRotate extends SplineSet {
        public void setPathRotate(View view, float f4, double d, double d5) {
            view.setRotation(get(f4) + ((float) Math.toDegrees(Math.atan2(d5, d))));
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class PivotXset extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            view.setPivotX(get(f4));
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class PivotYset extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            view.setPivotY(get(f4));
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class ProgressSet extends SplineSet {
        boolean mNoMethod = false;

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f4));
            } else if (this.mNoMethod) {
            } else {
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(get(f4)));
                    } catch (IllegalAccessException e5) {
                        Log.e(SplineSet.TAG, "unable to setProgress", e5);
                    } catch (InvocationTargetException e6) {
                        Log.e(SplineSet.TAG, "unable to setProgress", e6);
                    }
                }
            }
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class RotationSet extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            view.setRotation(get(f4));
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class RotationXset extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            view.setRotationX(get(f4));
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class RotationYset extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            view.setRotationY(get(f4));
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class ScaleXset extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            view.setScaleX(get(f4));
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class ScaleYset extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            view.setScaleY(get(f4));
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Sort {
        private Sort() {
        }

        public static void doubleQuickSort(int[] iArr, float[] fArr, int i3, int i5) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i5;
            iArr2[1] = i3;
            int i6 = 2;
            while (i6 > 0) {
                int i7 = iArr2[i6 - 1];
                int i8 = i6 - 2;
                int i9 = iArr2[i8];
                if (i7 < i9) {
                    int partition = partition(iArr, fArr, i7, i9);
                    iArr2[i8] = partition - 1;
                    iArr2[i6 - 1] = i7;
                    int i10 = i6 + 1;
                    iArr2[i6] = i9;
                    i6 += 2;
                    iArr2[i10] = partition + 1;
                } else {
                    i6 = i8;
                }
            }
        }

        private static int partition(int[] iArr, float[] fArr, int i3, int i5) {
            int i6 = iArr[i5];
            int i7 = i3;
            while (i3 < i5) {
                if (iArr[i3] <= i6) {
                    swap(iArr, fArr, i7, i3);
                    i7++;
                }
                i3++;
            }
            swap(iArr, fArr, i7, i5);
            return i7;
        }

        private static void swap(int[] iArr, float[] fArr, int i3, int i5) {
            int i6 = iArr[i3];
            iArr[i3] = iArr[i5];
            iArr[i5] = i6;
            float f4 = fArr[i3];
            fArr[i3] = fArr[i5];
            fArr[i5] = f4;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class TranslationXset extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            view.setTranslationX(get(f4));
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class TranslationYset extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            view.setTranslationY(get(f4));
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class TranslationZset extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f4) {
            view.setTranslationZ(get(f4));
        }
    }

    public static SplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static SplineSet makeSpline(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                break;
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c = '\b';
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c = '\t';
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\f';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = '\r';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = 15;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new RotationXset();
            case 1:
                return new RotationYset();
            case 2:
                return new TranslationXset();
            case 3:
                return new TranslationYset();
            case 4:
                return new TranslationZset();
            case 5:
                return new ProgressSet();
            case 6:
                return new ScaleXset();
            case 7:
                return new ScaleYset();
            case '\b':
                return new AlphaSet();
            case '\t':
                return new PivotXset();
            case '\n':
                return new PivotYset();
            case 11:
                return new RotationSet();
            case '\f':
                return new ElevationSet();
            case '\r':
                return new PathRotate();
            case 14:
                return new AlphaSet();
            case 15:
                return new AlphaSet();
            default:
                return null;
        }
    }

    public float get(float f4) {
        return (float) this.mCurveFit.getPos(f4, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f4) {
        return (float) this.mCurveFit.getSlope(f4, 0);
    }

    public void setPoint(int i3, float f4) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.count + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i5 = this.count;
        iArr2[i5] = i3;
        this.mValues[i5] = f4;
        this.count = i5 + 1;
    }

    public abstract void setProperty(View view, float f4);

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i3) {
        int i5 = this.count;
        if (i5 == 0) {
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i5 - 1);
        int i6 = 1;
        for (int i7 = 1; i7 < this.count; i7++) {
            int[] iArr = this.mTimePoints;
            if (iArr[i7 - 1] != iArr[i7]) {
                i6++;
            }
        }
        double[] dArr = new double[i6];
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i6, 1);
        int i8 = 0;
        for (int i9 = 0; i9 < this.count; i9++) {
            if (i9 > 0) {
                int[] iArr2 = this.mTimePoints;
                if (iArr2[i9] == iArr2[i9 - 1]) {
                }
            }
            dArr[i8] = this.mTimePoints[i9] * 0.01d;
            dArr2[i8][0] = this.mValues[i9];
            i8++;
        }
        this.mCurveFit = CurveFit.get(i3, dArr, dArr2);
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i3 = 0; i3 < this.count; i3++) {
            StringBuilder o5 = i.o(str, "[");
            o5.append(this.mTimePoints[i3]);
            o5.append(" , ");
            o5.append(decimalFormat.format(this.mValues[i3]));
            o5.append("] ");
            str = o5.toString();
        }
        return str;
    }
}
