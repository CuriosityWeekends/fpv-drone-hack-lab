package androidx.constraintlayout.motion.widget;

import a1.i;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MotionController {
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private KeyTrigger[] mKeyTriggers;
    private CurveFit[] mSpline;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    View mView;
    private int mCurveFitType = -1;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int MAX_DIMENSION = 4;
    private float[] mValuesBuff = new float[4];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<Key> mKeyList = new ArrayList<>();
    private int mPathMotionArc = Key.UNSET;

    public MotionController(View view) {
        setView(view);
    }

    private float getAdjustedPosition(float f4, float[] fArr) {
        float f5 = 0.0f;
        float f6 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f7 = this.mStaggerScale;
            if (f7 != 1.0d) {
                float f8 = this.mStaggerOffset;
                if (f4 < f8) {
                    f4 = 0.0f;
                }
                if (f4 > f8 && f4 < 1.0d) {
                    f4 = (f4 - f8) * f7;
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        float f9 = Float.NaN;
        while (it.hasNext()) {
            MotionPaths next = it.next();
            Easing easing2 = next.mKeyFrameEasing;
            if (easing2 != null) {
                float f10 = next.time;
                if (f10 < f4) {
                    easing = easing2;
                    f5 = f10;
                } else if (Float.isNaN(f9)) {
                    f9 = next.time;
                }
            }
        }
        if (easing != null) {
            if (!Float.isNaN(f9)) {
                f6 = f9;
            }
            float f11 = f6 - f5;
            double d = (f4 - f5) / f11;
            f4 = (((float) easing.get(d)) * f11) + f5;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d);
            }
        }
        return f4;
    }

    private float getPreCycleDistance() {
        float f4;
        float[] fArr = new float[2];
        float f5 = 1.0f / 99;
        double d = 0.0d;
        double d5 = 0.0d;
        int i3 = 0;
        float f6 = 0.0f;
        while (i3 < 100) {
            float f7 = i3 * f5;
            double d6 = f7;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f8 = Float.NaN;
            float f9 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                float f10 = f5;
                if (easing2 != null) {
                    float f11 = next.time;
                    if (f11 < f7) {
                        f9 = f11;
                        easing = easing2;
                    } else if (Float.isNaN(f8)) {
                        f8 = next.time;
                    }
                }
                f5 = f10;
            }
            float f12 = f5;
            if (easing != null) {
                if (Float.isNaN(f8)) {
                    f8 = 1.0f;
                }
                d6 = (((float) easing.get((f7 - f9) / f4)) * (f8 - f9)) + f9;
            }
            this.mSpline[0].getPos(d6, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i3 > 0) {
                f6 = (float) (Math.hypot(d5 - fArr[1], d - fArr[0]) + f6);
            }
            d = fArr[0];
            d5 = fArr[1];
            i3++;
            f5 = f12;
        }
        return f6;
    }

    private void insertKey(MotionPaths motionPaths) {
        int binarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (binarySearch == 0) {
            Log.e(TAG, " KeyPath positon \"" + motionPaths.position + "\" outside of range");
        }
        this.mMotionPaths.add((-binarySearch) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i3) {
        float f4;
        float f5 = 1.0f / (i3 - 1);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            hashMap4.get("translationY");
        }
        for (int i5 = 0; i5 < i3; i5++) {
            float f6 = i5 * f5;
            float f7 = this.mStaggerScale;
            float f8 = 0.0f;
            if (f7 != 1.0f) {
                float f9 = this.mStaggerOffset;
                if (f6 < f9) {
                    f6 = 0.0f;
                }
                if (f6 > f9 && f6 < 1.0d) {
                    f6 = (f6 - f9) * f7;
                }
            }
            double d = f6;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f10 = Float.NaN;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                Easing easing2 = next.mKeyFrameEasing;
                if (easing2 != null) {
                    float f11 = next.time;
                    if (f11 < f6) {
                        easing = easing2;
                        f8 = f11;
                    } else if (Float.isNaN(f10)) {
                        f10 = next.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f10)) {
                    f10 = 1.0f;
                }
                d = (((float) easing.get((f6 - f8) / f4)) * (f10 - f8)) + f8;
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i5 * 2);
        }
    }

    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                iArr[i3] = it.next().mMode;
                i3++;
            }
        }
        int i5 = 0;
        for (double d : timePoints) {
            this.mSpline[0].getPos(d, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i5);
            i5 += 2;
        }
        return i5 / 2;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                iArr[i3] = it.next().mMode;
                i3++;
            }
        }
        int i5 = 0;
        for (double d : timePoints) {
            this.mSpline[0].getPos(d, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i5);
            i5 += 2;
        }
        return i5 / 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void buildPath(float[] r22, int r23) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionController.buildPath(float[], int):void");
    }

    public void buildRect(float f4, float[] fArr, int i3) {
        this.mSpline[0].getPos(getAdjustedPosition(f4, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
    }

    public void buildRectangles(float[] fArr, int i3) {
        float f4 = 1.0f / (i3 - 1);
        for (int i5 = 0; i5 < i3; i5++) {
            this.mSpline[0].getPos(getAdjustedPosition(i5 * f4, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i5 * 8);
        }
    }

    public int getAttributeValues(String str, float[] fArr, int i3) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i5 = 0; i5 < fArr.length; i5++) {
            fArr[i5] = splineSet.get(i5 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void getDpDt(float f4, float f5, float f6, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f4, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i3 = 0;
        if (curveFitArr != null) {
            double d = adjustedPosition;
            curveFitArr[0].getSlope(d, this.mInterpolateVelocity);
            this.mSpline[0].getPos(d, this.mInterpolateData);
            float f7 = this.mVelocity[0];
            while (true) {
                dArr = this.mInterpolateVelocity;
                if (i3 >= dArr.length) {
                    break;
                }
                dArr[i3] = dArr[i3] * f7;
                i3++;
            }
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr2 = this.mInterpolateData;
                if (dArr2.length > 0) {
                    curveFit.getPos(d, dArr2);
                    this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(f5, f6, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                    return;
                }
                return;
            }
            this.mStartMotionPath.setDpDt(f5, f6, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        MotionPaths motionPaths = this.mEndMotionPath;
        float f8 = motionPaths.f118x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f9 = f8 - motionPaths2.f118x;
        float f10 = motionPaths.f119y - motionPaths2.f119y;
        fArr[0] = (((motionPaths.width - motionPaths2.width) + f9) * f5) + ((1.0f - f5) * f9);
        fArr[1] = (((motionPaths.height - motionPaths2.height) + f10) * f6) + ((1.0f - f6) * f10);
    }

    public int getDrawPath() {
        int i3 = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            i3 = Math.max(i3, it.next().mDrawPath);
        }
        return Math.max(i3, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalX() {
        return this.mEndMotionPath.f118x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.f119y;
    }

    public MotionPaths getKeyFrame(int i3) {
        return this.mMotionPaths.get(i3);
    }

    public int getKeyFrameInfo(int i3, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<Key> it = this.mKeyList.iterator();
        int i5 = 0;
        int i6 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            int i7 = next.mType;
            if (i7 == i3 || i3 != -1) {
                iArr[i6] = 0;
                iArr[i6 + 1] = i7;
                int i8 = next.mFramePosition;
                iArr[i6 + 2] = i8;
                this.mSpline[0].getPos(i8 / 100.0f, this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i6 + 3] = Float.floatToIntBits(fArr[0]);
                int i9 = i6 + 4;
                iArr[i9] = Float.floatToIntBits(fArr[1]);
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    iArr[i6 + 5] = keyPosition.mPositionType;
                    iArr[i6 + 6] = Float.floatToIntBits(keyPosition.mPercentX);
                    i9 = i6 + 7;
                    iArr[i9] = Float.floatToIntBits(keyPosition.mPercentY);
                }
                int i10 = i9 + 1;
                iArr[i6] = i10 - i6;
                i5++;
                i6 = i10;
            }
        }
        return i5;
    }

    public float getKeyFrameParameter(int i3, float f4, float f5) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f6 = motionPaths.f118x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f7 = motionPaths2.f118x;
        float f8 = f6 - f7;
        float f9 = motionPaths.f119y;
        float f10 = motionPaths2.f119y;
        float f11 = f9 - f10;
        float f12 = (motionPaths2.width / 2.0f) + f7;
        float f13 = (motionPaths2.height / 2.0f) + f10;
        float hypot = (float) Math.hypot(f8, f11);
        if (hypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f14 = f4 - f12;
        float f15 = f5 - f13;
        if (((float) Math.hypot(f14, f15)) == 0.0f) {
            return 0.0f;
        }
        float f16 = (f15 * f11) + (f14 * f8);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return 0.0f;
                            }
                            return f15 / f11;
                        }
                        return f14 / f11;
                    }
                    return f15 / f8;
                }
                return f14 / f8;
            }
            return (float) Math.sqrt((hypot * hypot) - (f16 * f16));
        }
        return f16 / hypot;
    }

    public KeyPositionBase getPositionKeyframe(int i3, int i5, float f4, float f5) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f6 = motionPaths.f118x;
        rectF.left = f6;
        float f7 = motionPaths.f119y;
        rectF.top = f7;
        rectF.right = f6 + motionPaths.width;
        rectF.bottom = f7 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f8 = motionPaths2.f118x;
        rectF2.left = f8;
        float f9 = motionPaths2.f119y;
        rectF2.top = f9;
        rectF2.right = f8 + motionPaths2.width;
        rectF2.bottom = f9 + motionPaths2.height;
        Iterator<Key> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            Key next = it.next();
            if (next instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) next;
                if (keyPositionBase.intersects(i3, i5, rectF, rectF2, f4, f5)) {
                    return keyPositionBase;
                }
            }
        }
        return null;
    }

    public void getPostLayoutDvDp(float f4, int i3, int i5, float f5, float f6, float[] fArr) {
        SplineSet splineSet;
        SplineSet splineSet2;
        SplineSet splineSet3;
        SplineSet splineSet4;
        SplineSet splineSet5;
        KeyCycleOscillator keyCycleOscillator;
        KeyCycleOscillator keyCycleOscillator2;
        KeyCycleOscillator keyCycleOscillator3;
        KeyCycleOscillator keyCycleOscillator4;
        float adjustedPosition = getAdjustedPosition(f4, this.mVelocity);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator5 = null;
        if (hashMap == null) {
            splineSet = null;
        } else {
            splineSet = hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 == null) {
            splineSet2 = null;
        } else {
            splineSet2 = hashMap2.get("translationY");
        }
        HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
        if (hashMap3 == null) {
            splineSet3 = null;
        } else {
            splineSet3 = hashMap3.get("rotation");
        }
        HashMap<String, SplineSet> hashMap4 = this.mAttributesMap;
        if (hashMap4 == null) {
            splineSet4 = null;
        } else {
            splineSet4 = hashMap4.get("scaleX");
        }
        HashMap<String, SplineSet> hashMap5 = this.mAttributesMap;
        if (hashMap5 == null) {
            splineSet5 = null;
        } else {
            splineSet5 = hashMap5.get("scaleY");
        }
        HashMap<String, KeyCycleOscillator> hashMap6 = this.mCycleMap;
        if (hashMap6 == null) {
            keyCycleOscillator = null;
        } else {
            keyCycleOscillator = hashMap6.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap7 = this.mCycleMap;
        if (hashMap7 == null) {
            keyCycleOscillator2 = null;
        } else {
            keyCycleOscillator2 = hashMap7.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap8 = this.mCycleMap;
        if (hashMap8 == null) {
            keyCycleOscillator3 = null;
        } else {
            keyCycleOscillator3 = hashMap8.get("rotation");
        }
        HashMap<String, KeyCycleOscillator> hashMap9 = this.mCycleMap;
        if (hashMap9 == null) {
            keyCycleOscillator4 = null;
        } else {
            keyCycleOscillator4 = hashMap9.get("scaleX");
        }
        HashMap<String, KeyCycleOscillator> hashMap10 = this.mCycleMap;
        if (hashMap10 != null) {
            keyCycleOscillator5 = hashMap10.get("scaleY");
        }
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d = adjustedPosition;
                curveFit.getPos(d, dArr);
                this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f5, f6, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f5, f6, i3, i5, fArr);
            return;
        }
        int i6 = 0;
        if (this.mSpline != null) {
            double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
            this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
            float f7 = this.mVelocity[0];
            while (true) {
                double[] dArr2 = this.mInterpolateVelocity;
                if (i6 < dArr2.length) {
                    dArr2[i6] = dArr2[i6] * f7;
                    i6++;
                } else {
                    this.mStartMotionPath.setDpDt(f5, f6, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                    velocityMatrix.applyTransform(f5, f6, i3, i5, fArr);
                    return;
                }
            }
        } else {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f8 = motionPaths.f118x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f9 = f8 - motionPaths2.f118x;
            float f10 = motionPaths.f119y - motionPaths2.f119y;
            KeyCycleOscillator keyCycleOscillator6 = keyCycleOscillator4;
            fArr[0] = (((motionPaths.width - motionPaths2.width) + f9) * f5) + ((1.0f - f5) * f9);
            fArr[1] = (((motionPaths.height - motionPaths2.height) + f10) * f6) + ((1.0f - f6) * f10);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator6, keyCycleOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f5, f6, i3, i5, fArr);
        }
    }

    public float getStartX() {
        return this.mStartMotionPath.f118x;
    }

    public float getStartY() {
        return this.mStartMotionPath.f119y;
    }

    public int getkeyFramePositions(int[] iArr, float[] fArr) {
        Iterator<Key> it = this.mKeyList.iterator();
        int i3 = 0;
        int i5 = 0;
        while (it.hasNext()) {
            Key next = it.next();
            int i6 = next.mFramePosition;
            iArr[i3] = (next.mType * 1000) + i6;
            this.mSpline[0].getPos(i6 / 100.0f, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArr, i5);
            i5 += 2;
            i3++;
        }
        return i3;
    }

    public boolean interpolate(View view, float f4, long j2, KeyCache keyCache) {
        TimeCycleSplineSet.PathRotate pathRotate;
        boolean z3;
        double d;
        float adjustedPosition = getAdjustedPosition(f4, null);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            for (SplineSet splineSet : hashMap.values()) {
                splineSet.setProperty(view, adjustedPosition);
            }
        }
        HashMap<String, TimeCycleSplineSet> hashMap2 = this.mTimeCycleAttributesMap;
        if (hashMap2 != null) {
            pathRotate = null;
            boolean z5 = false;
            for (TimeCycleSplineSet timeCycleSplineSet : hashMap2.values()) {
                if (timeCycleSplineSet instanceof TimeCycleSplineSet.PathRotate) {
                    pathRotate = (TimeCycleSplineSet.PathRotate) timeCycleSplineSet;
                } else {
                    z5 |= timeCycleSplineSet.setProperty(view, adjustedPosition, j2, keyCache);
                }
            }
            z3 = z5;
        } else {
            pathRotate = null;
            z3 = false;
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d5 = adjustedPosition;
            curveFitArr[0].getPos(d5, this.mInterpolateData);
            this.mSpline[0].getSlope(d5, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d5, dArr);
                    this.mArcSpline.getSlope(d5, this.mInterpolateVelocity);
                }
            }
            this.mStartMotionPath.setView(view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
            HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
            if (hashMap3 != null) {
                for (SplineSet splineSet2 : hashMap3.values()) {
                    if (splineSet2 instanceof SplineSet.PathRotate) {
                        double[] dArr2 = this.mInterpolateVelocity;
                        ((SplineSet.PathRotate) splineSet2).setPathRotate(view, adjustedPosition, dArr2[0], dArr2[1]);
                    }
                }
            }
            if (pathRotate != null) {
                double[] dArr3 = this.mInterpolateVelocity;
                d = d5;
                z3 |= pathRotate.setPathRotate(view, keyCache, adjustedPosition, j2, dArr3[0], dArr3[1]);
            } else {
                d = d5;
            }
            int i3 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i3 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i3].getPos(d, this.mValuesBuff);
                this.mStartMotionPath.attributes.get(this.mAttributeNames[i3 - 1]).setInterpolatedValue(view, this.mValuesBuff);
                i3++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (adjustedPosition <= 0.0f) {
                    view.setVisibility(motionConstrainedPoint.visibility);
                } else if (adjustedPosition >= 1.0f) {
                    view.setVisibility(this.mEndPoint.visibility);
                } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                    view.setVisibility(0);
                }
            }
            if (this.mKeyTriggers != null) {
                int i5 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                    if (i5 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i5].conditionallyFire(adjustedPosition, view);
                    i5++;
                }
            }
        } else {
            MotionPaths motionPaths = this.mStartMotionPath;
            float f5 = motionPaths.f118x;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float b = i.b(motionPaths2.f118x, f5, adjustedPosition, f5);
            float f6 = motionPaths.f119y;
            float b5 = i.b(motionPaths2.f119y, f6, adjustedPosition, f6);
            float f7 = motionPaths.width;
            float f8 = motionPaths2.width;
            float b6 = i.b(f8, f7, adjustedPosition, f7);
            float f9 = motionPaths.height;
            float f10 = motionPaths2.height;
            float f11 = b + 0.5f;
            int i6 = (int) f11;
            float f12 = b5 + 0.5f;
            int i7 = (int) f12;
            int i8 = (int) (f11 + b6);
            int b7 = (int) (f12 + i.b(f10, f9, adjustedPosition, f9));
            int i9 = i8 - i6;
            int i10 = b7 - i7;
            if (f8 != f7 || f10 != f9) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i9, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i10, BasicMeasure.EXACTLY));
            }
            view.layout(i6, i7, i8, b7);
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            for (KeyCycleOscillator keyCycleOscillator : hashMap4.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    double[] dArr4 = this.mInterpolateVelocity;
                    ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(view, adjustedPosition, dArr4[0], dArr4[1]);
                } else {
                    keyCycleOscillator.setProperty(view, adjustedPosition);
                }
            }
        }
        return z3;
    }

    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f4, float f5, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f6 = motionPaths.f118x;
        rectF.left = f6;
        float f7 = motionPaths.f119y;
        rectF.top = f7;
        rectF.right = f6 + motionPaths.width;
        rectF.bottom = f7 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f8 = motionPaths2.f118x;
        rectF2.left = f8;
        float f9 = motionPaths2.f119y;
        rectF2.top = f9;
        rectF2.right = f8 + motionPaths2.width;
        rectF2.bottom = f9 + motionPaths2.height;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f4, f5, strArr, fArr);
    }

    public void setDrawPath(int i3) {
        this.mStartMotionPath.mDrawPath = i3;
    }

    public void setEndState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.time = 1.0f;
        motionPaths.position = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setPathMotionArc(int i3) {
        this.mPathMotionArc = i3;
    }

    public void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    public void setStartState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        readView(motionPaths);
        this.mStartMotionPath.setBounds(constraintWidget.getX(), constraintWidget.getY(), constraintWidget.getWidth(), constraintWidget.getHeight());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(parameters);
        this.mMotionStagger = parameters.motion.mMotionStagger;
        this.mStartPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void setup(int i3, int i5, float f4, long j2) {
        ArrayList arrayList;
        String[] strArr;
        boolean z3;
        HashSet<String> hashSet;
        int i6;
        TimeCycleSplineSet makeSpline;
        ConstraintAttribute constraintAttribute;
        int i7;
        SplineSet makeSpline2;
        ConstraintAttribute constraintAttribute2;
        new HashSet();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashSet<String> hashSet4 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        int i8 = this.mPathMotionArc;
        if (i8 != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = i8;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet3);
        ArrayList<Key> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                Key next = it.next();
                if (next instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) next;
                    insertKey(new MotionPaths(i3, i5, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i9 = keyPosition.mCurveFit;
                    if (i9 != Key.UNSET) {
                        this.mCurveFitType = i9;
                    }
                } else if (next instanceof KeyCycle) {
                    next.getAttributeNames(hashSet4);
                } else if (next instanceof KeyTimeCycle) {
                    next.getAttributeNames(hashSet2);
                } else if (next instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) next);
                } else {
                    next.setInterpolation(hashMap);
                    next.getAttributeNames(hashSet3);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        char c = 1;
        if (!hashSet3.isEmpty()) {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it2 = hashSet3.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next2.split(",")[1];
                    Iterator<Key> it3 = this.mKeyList.iterator();
                    while (it3.hasNext()) {
                        Key next3 = it3.next();
                        HashMap<String, ConstraintAttribute> hashMap2 = next3.mCustomConstraints;
                        if (hashMap2 != null && (constraintAttribute2 = hashMap2.get(str)) != null) {
                            sparseArray.append(next3.mFramePosition, constraintAttribute2);
                        }
                    }
                    makeSpline2 = SplineSet.makeCustomSpline(next2, sparseArray);
                } else {
                    makeSpline2 = SplineSet.makeSpline(next2);
                }
                if (makeSpline2 != null) {
                    makeSpline2.setType(next2);
                    this.mAttributesMap.put(next2, makeSpline2);
                }
            }
            ArrayList<Key> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                Iterator<Key> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    Key next4 = it4.next();
                    if (next4 instanceof KeyAttributes) {
                        next4.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                if (hashMap.containsKey(str2)) {
                    i7 = hashMap.get(str2).intValue();
                } else {
                    i7 = 0;
                }
                this.mAttributesMap.get(str2).setup(i7);
            }
        }
        if (!hashSet2.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator<String> it5 = hashSet2.iterator();
            while (it5.hasNext()) {
                String next5 = it5.next();
                if (!this.mTimeCycleAttributesMap.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next5.split(",")[1];
                        Iterator<Key> it6 = this.mKeyList.iterator();
                        while (it6.hasNext()) {
                            Key next6 = it6.next();
                            HashMap<String, ConstraintAttribute> hashMap3 = next6.mCustomConstraints;
                            if (hashMap3 != null && (constraintAttribute = hashMap3.get(str3)) != null) {
                                sparseArray2.append(next6.mFramePosition, constraintAttribute);
                            }
                        }
                        makeSpline = TimeCycleSplineSet.makeCustomSpline(next5, sparseArray2);
                    } else {
                        makeSpline = TimeCycleSplineSet.makeSpline(next5, j2);
                    }
                    if (makeSpline != null) {
                        makeSpline.setType(next5);
                        this.mTimeCycleAttributesMap.put(next5, makeSpline);
                    }
                }
            }
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                Iterator<Key> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    Key next7 = it7.next();
                    if (next7 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) next7).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                if (hashMap.containsKey(str4)) {
                    i6 = hashMap.get(str4).intValue();
                } else {
                    i6 = 0;
                }
                this.mTimeCycleAttributesMap.get(str4).setup(i6);
            }
        }
        int size = this.mMotionPaths.size();
        int i10 = size + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i10];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it8 = this.mMotionPaths.iterator();
        int i11 = 1;
        while (it8.hasNext()) {
            motionPathsArr[i11] = it8.next();
            i11++;
        }
        HashSet hashSet5 = new HashSet();
        for (String str5 : this.mEndMotionPath.attributes.keySet()) {
            if (this.mStartMotionPath.attributes.containsKey(str5)) {
                if (!hashSet3.contains("CUSTOM," + str5)) {
                    hashSet5.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet5.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpCount = new int[strArr2.length];
        int i12 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i12 >= strArr.length) {
                break;
            }
            String str6 = strArr[i12];
            this.mAttributeInterpCount[i12] = 0;
            int i13 = 0;
            while (true) {
                if (i13 >= i10) {
                    break;
                } else if (motionPathsArr[i13].attributes.containsKey(str6)) {
                    int[] iArr = this.mAttributeInterpCount;
                    iArr[i12] = motionPathsArr[i13].attributes.get(str6).noOfInterpValues() + iArr[i12];
                    break;
                } else {
                    i13++;
                }
            }
            i12++;
        }
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            z3 = true;
        } else {
            z3 = false;
        }
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i14 = 1; i14 < i10; i14++) {
            motionPathsArr[i14].different(motionPathsArr[i14 - 1], zArr, this.mAttributeNames, z3);
        }
        int i15 = 0;
        for (int i16 = 1; i16 < length; i16++) {
            if (zArr[i16]) {
                i15++;
            }
        }
        int[] iArr2 = new int[i15];
        this.mInterpolateVariables = iArr2;
        this.mInterpolateData = new double[iArr2.length];
        this.mInterpolateVelocity = new double[iArr2.length];
        int i17 = 0;
        for (int i18 = 1; i18 < length; i18++) {
            if (zArr[i18]) {
                this.mInterpolateVariables[i17] = i18;
                i17++;
            }
        }
        int i19 = 2;
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, i10, this.mInterpolateVariables.length);
        double[] dArr2 = new double[i10];
        for (int i20 = 0; i20 < i10; i20++) {
            motionPathsArr[i20].fillStandard(dArr[i20], this.mInterpolateVariables);
            dArr2[i20] = motionPathsArr[i20].time;
        }
        int i21 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i21 >= iArr3.length) {
                break;
            }
            if (iArr3[i21] < MotionPaths.names.length) {
                String k5 = i.k(new StringBuilder(), MotionPaths.names[this.mInterpolateVariables[i21]], " [");
                for (int i22 = 0; i22 < i10; i22++) {
                    StringBuilder l5 = i.l(k5);
                    l5.append(dArr[i22][i21]);
                    k5 = l5.toString();
                }
            }
            i21++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i23 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i23 >= strArr3.length) {
                break;
            }
            String str7 = strArr3[i23];
            int i24 = 0;
            double[] dArr3 = null;
            int i25 = 0;
            double[][] dArr4 = null;
            while (i24 < i10) {
                if (motionPathsArr[i24].hasCustomData(str7)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i10];
                        int[] iArr4 = new int[i19];
                        iArr4[c] = motionPathsArr[i24].getCustomDataCount(str7);
                        iArr4[0] = i10;
                        dArr4 = (double[][]) Array.newInstance(Double.TYPE, iArr4);
                    }
                    MotionPaths motionPaths = motionPathsArr[i24];
                    hashSet = hashSet4;
                    dArr3[i25] = motionPaths.time;
                    motionPaths.getCustomData(str7, dArr4[i25], 0);
                    i25++;
                } else {
                    hashSet = hashSet4;
                }
                i24++;
                hashSet4 = hashSet;
                i19 = 2;
                c = 1;
            }
            i23++;
            this.mSpline[i23] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i25), (double[][]) Arrays.copyOf(dArr4, i25));
            hashSet4 = hashSet4;
            i19 = 2;
            c = 1;
        }
        HashSet<String> hashSet6 = hashSet4;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            int[] iArr5 = new int[i10];
            double[] dArr5 = new double[i10];
            double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, i10, 2);
            for (int i26 = 0; i26 < i10; i26++) {
                MotionPaths motionPaths2 = motionPathsArr[i26];
                iArr5[i26] = motionPaths2.mPathMotionArc;
                dArr5[i26] = motionPaths2.time;
                double[] dArr7 = dArr6[i26];
                dArr7[0] = motionPaths2.f118x;
                dArr7[1] = motionPaths2.f119y;
            }
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it9 = hashSet6.iterator();
            float f5 = Float.NaN;
            while (it9.hasNext()) {
                String next8 = it9.next();
                KeyCycleOscillator makeSpline3 = KeyCycleOscillator.makeSpline(next8);
                if (makeSpline3 != null) {
                    if (makeSpline3.variesByPath() && Float.isNaN(f5)) {
                        f5 = getPreCycleDistance();
                    }
                    makeSpline3.setType(next8);
                    this.mCycleMap.put(next8, makeSpline3);
                }
            }
            Iterator<Key> it10 = this.mKeyList.iterator();
            while (it10.hasNext()) {
                Key next9 = it10.next();
                if (next9 instanceof KeyCycle) {
                    ((KeyCycle) next9).addCycleValues(this.mCycleMap);
                }
            }
            for (KeyCycleOscillator keyCycleOscillator : this.mCycleMap.values()) {
                keyCycleOscillator.setup(f5);
            }
        }
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f118x + " y: " + this.mStartMotionPath.f119y + " end: x: " + this.mEndMotionPath.f118x + " y: " + this.mEndMotionPath.f119y;
    }
}
