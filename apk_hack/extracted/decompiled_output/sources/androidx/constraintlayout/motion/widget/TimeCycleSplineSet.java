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
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = 6.2831855f;
    private int count;
    long last_time;
    protected CurveFit mCurveFit;
    private String mType;
    protected int mWaveShape = 0;
    protected int[] mTimePoints = new int[10];
    protected float[][] mValues = (float[][]) Array.newInstance(Float.TYPE, 10, 3);
    private float[] mCache = new float[3];
    protected boolean mContinue = false;
    float last_cycle = Float.NaN;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class AlphaSet extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j2, KeyCache keyCache) {
            view.setAlpha(get(f4, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setPoint(int i3, float f4, float f5, int i5, float f6) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j2, KeyCache keyCache) {
            boolean z3;
            this.mCurveFit.getPos(f4, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float f7 = (float) (((((j2 - this.last_time) * 1.0E-9d) * f5) + this.last_cycle) % 1.0d);
            this.last_cycle = f7;
            this.last_time = j2;
            float calcWave = calcWave(f7);
            this.mContinue = false;
            int i3 = 0;
            while (true) {
                float[] fArr2 = this.mCache;
                if (i3 >= fArr2.length) {
                    break;
                }
                boolean z5 = this.mContinue;
                float f8 = this.mTempValues[i3];
                if (f8 != 0.0d) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.mContinue = z5 | z3;
                fArr2[i3] = (f8 * calcWave) + f6;
                i3++;
            }
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mCache);
            if (f5 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setup(int i3) {
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            int i5 = noOfInterpValues + 2;
            this.mTempValues = new float[i5];
            this.mCache = new float[noOfInterpValues];
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, i5);
            for (int i6 = 0; i6 < size; i6++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i6);
                float[] valueAt = this.mWaveProperties.valueAt(i6);
                dArr[i6] = keyAt * 0.01d;
                this.mConstraintAttributeList.valueAt(i6).getValuesToInterpolate(this.mTempValues);
                int i7 = 0;
                while (true) {
                    float[] fArr = this.mTempValues;
                    if (i7 < fArr.length) {
                        dArr2[i6][i7] = fArr[i7];
                        i7++;
                    }
                }
                double[] dArr3 = dArr2[i6];
                dArr3[noOfInterpValues] = valueAt[0];
                dArr3[noOfInterpValues + 1] = valueAt[1];
            }
            this.mCurveFit = CurveFit.get(i3, dArr, dArr2);
        }

        public void setPoint(int i3, ConstraintAttribute constraintAttribute, float f4, int i5, float f5) {
            this.mConstraintAttributeList.append(i3, constraintAttribute);
            this.mWaveProperties.append(i3, new float[]{f4, f5});
            this.mWaveShape = Math.max(this.mWaveShape, i5);
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class ElevationSet extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j2, KeyCache keyCache) {
            view.setElevation(get(f4, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class PathRotate extends TimeCycleSplineSet {
        public boolean setPathRotate(View view, KeyCache keyCache, float f4, long j2, double d, double d5) {
            view.setRotation(get(f4, j2, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d5, d))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j2, KeyCache keyCache) {
            return this.mContinue;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class ProgressSet extends TimeCycleSplineSet {
        boolean mNoMethod = false;

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j2, KeyCache keyCache) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f4, j2, view, keyCache));
            } else if (this.mNoMethod) {
                return false;
            } else {
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                    method = null;
                }
                Method method2 = method;
                if (method2 != null) {
                    try {
                        method2.invoke(view, Float.valueOf(get(f4, j2, view, keyCache)));
                    } catch (IllegalAccessException e5) {
                        Log.e(TimeCycleSplineSet.TAG, "unable to setProgress", e5);
                    } catch (InvocationTargetException e6) {
                        Log.e(TimeCycleSplineSet.TAG, "unable to setProgress", e6);
                    }
                }
            }
            return this.mContinue;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class RotationSet extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j2, KeyCache keyCache) {
            view.setRotation(get(f4, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class RotationXset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j2, KeyCache keyCache) {
            view.setRotationX(get(f4, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class RotationYset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j2, KeyCache keyCache) {
            view.setRotationY(get(f4, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class ScaleXset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j2, KeyCache keyCache) {
            view.setScaleX(get(f4, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class ScaleYset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j2, KeyCache keyCache) {
            view.setScaleY(get(f4, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class Sort {
        private Sort() {
        }

        public static void doubleQuickSort(int[] iArr, float[][] fArr, int i3, int i5) {
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

        private static int partition(int[] iArr, float[][] fArr, int i3, int i5) {
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

        private static void swap(int[] iArr, float[][] fArr, int i3, int i5) {
            int i6 = iArr[i3];
            iArr[i3] = iArr[i5];
            iArr[i5] = i6;
            float[] fArr2 = fArr[i3];
            fArr[i3] = fArr[i5];
            fArr[i5] = fArr2;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class TranslationXset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j2, KeyCache keyCache) {
            view.setTranslationX(get(f4, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class TranslationYset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j2, KeyCache keyCache) {
            view.setTranslationY(get(f4, j2, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class TranslationZset extends TimeCycleSplineSet {
        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View view, float f4, long j2, KeyCache keyCache) {
            view.setTranslationZ(get(f4, j2, view, keyCache));
            return this.mContinue;
        }
    }

    public static TimeCycleSplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static TimeCycleSplineSet makeSpline(String str, long j2) {
        TimeCycleSplineSet rotationXset;
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
            case -40300674:
                if (str.equals("rotation")) {
                    c = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                rotationXset = new RotationXset();
                break;
            case 1:
                rotationXset = new RotationYset();
                break;
            case 2:
                rotationXset = new TranslationXset();
                break;
            case 3:
                rotationXset = new TranslationYset();
                break;
            case 4:
                rotationXset = new TranslationZset();
                break;
            case 5:
                rotationXset = new ProgressSet();
                break;
            case 6:
                rotationXset = new ScaleXset();
                break;
            case 7:
                rotationXset = new ScaleYset();
                break;
            case '\b':
                rotationXset = new RotationSet();
                break;
            case '\t':
                rotationXset = new ElevationSet();
                break;
            case '\n':
                rotationXset = new PathRotate();
                break;
            case 11:
                rotationXset = new AlphaSet();
                break;
            default:
                return null;
        }
        rotationXset.setStartTime(j2);
        return rotationXset;
    }

    public float calcWave(float f4) {
        float abs;
        switch (this.mWaveShape) {
            case 1:
                return Math.signum(f4 * VAL_2PI);
            case 2:
                abs = Math.abs(f4);
                break;
            case 3:
                return (((f4 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                abs = ((f4 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f4 * VAL_2PI);
            case 6:
                float abs2 = 1.0f - Math.abs(((f4 * 4.0f) % 4.0f) - 2.0f);
                abs = abs2 * abs2;
                break;
            default:
                return (float) Math.sin(f4 * VAL_2PI);
        }
        return 1.0f - abs;
    }

    public float get(float f4, long j2, View view, KeyCache keyCache) {
        boolean z3;
        this.mCurveFit.getPos(f4, this.mCache);
        float[] fArr = this.mCache;
        float f5 = fArr[1];
        int i3 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
        if (i3 == 0) {
            this.mContinue = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            float floatValue = keyCache.getFloatValue(view, this.mType, 0);
            this.last_cycle = floatValue;
            if (Float.isNaN(floatValue)) {
                this.last_cycle = 0.0f;
            }
        }
        float f6 = (float) (((((j2 - this.last_time) * 1.0E-9d) * f5) + this.last_cycle) % 1.0d);
        this.last_cycle = f6;
        keyCache.setFloatValue(view, this.mType, 0, f6);
        this.last_time = j2;
        float f7 = this.mCache[0];
        float calcWave = (calcWave(this.last_cycle) * f7) + this.mCache[2];
        if (f7 == 0.0f && i3 == 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.mContinue = z3;
        return calcWave;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i3, float f4, float f5, int i5, float f6) {
        int[] iArr = this.mTimePoints;
        int i6 = this.count;
        iArr[i6] = i3;
        float[] fArr = this.mValues[i6];
        fArr[0] = f4;
        fArr[1] = f5;
        fArr[2] = f6;
        this.mWaveShape = Math.max(this.mWaveShape, i5);
        this.count++;
    }

    public abstract boolean setProperty(View view, float f4, long j2, KeyCache keyCache);

    public void setStartTime(long j2) {
        this.last_time = j2;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setup(int i3) {
        int i5 = this.count;
        if (i5 == 0) {
            Log.e(TAG, "Error no points added to " + this.mType);
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i5 - 1);
        int i6 = 1;
        int i7 = 0;
        while (true) {
            int[] iArr = this.mTimePoints;
            if (i6 >= iArr.length) {
                break;
            }
            if (iArr[i6] != iArr[i6 - 1]) {
                i7++;
            }
            i6++;
        }
        if (i7 == 0) {
            i7 = 1;
        }
        double[] dArr = new double[i7];
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, i7, 3);
        int i8 = 0;
        for (int i9 = 0; i9 < this.count; i9++) {
            if (i9 > 0) {
                int[] iArr2 = this.mTimePoints;
                if (iArr2[i9] == iArr2[i9 - 1]) {
                }
            }
            dArr[i8] = this.mTimePoints[i9] * 0.01d;
            double[] dArr3 = dArr2[i8];
            float[] fArr = this.mValues[i9];
            dArr3[0] = fArr[0];
            dArr3[1] = fArr[1];
            dArr3[2] = fArr[2];
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
