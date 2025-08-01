package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class ViewUtilsBase {
    private static final String TAG = "ViewUtilsBase";
    private static final int VISIBILITY_MASK = 12;
    private static boolean sSetFrameFetched;
    private static Method sSetFrameMethod;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;
    private float[] mMatrixValues;

    @SuppressLint({"PrivateApi"})
    private void fetchSetFrame() {
        if (!sSetFrameFetched) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
                sSetFrameMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e5) {
                Log.i(TAG, "Failed to retrieve setFrame method", e5);
            }
            sSetFrameFetched = true;
        }
    }

    public void clearNonTransitionAlpha(@NonNull View view) {
        if (view.getVisibility() == 0) {
            view.setTag(R.id.save_non_transition_alpha, null);
        }
    }

    public float getTransitionAlpha(@NonNull View view) {
        Float f4 = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f4 != null) {
            return view.getAlpha() / f4.floatValue();
        }
        return view.getAlpha();
    }

    public void saveNonTransitionAlpha(@NonNull View view) {
        int i3 = R.id.save_non_transition_alpha;
        if (view.getTag(i3) == null) {
            view.setTag(i3, Float.valueOf(view.getAlpha()));
        }
    }

    public void setAnimationMatrix(@NonNull View view, @Nullable Matrix matrix) {
        int i3;
        if (matrix != null && !matrix.isIdentity()) {
            float[] fArr = this.mMatrixValues;
            if (fArr == null) {
                fArr = new float[9];
                this.mMatrixValues = fArr;
            }
            matrix.getValues(fArr);
            float f4 = fArr[3];
            float sqrt = (float) Math.sqrt(1.0f - (f4 * f4));
            if (fArr[0] < 0.0f) {
                i3 = -1;
            } else {
                i3 = 1;
            }
            float f5 = sqrt * i3;
            float degrees = (float) Math.toDegrees(Math.atan2(f4, f5));
            float f6 = fArr[0] / f5;
            float f7 = fArr[4] / f5;
            float f8 = fArr[2];
            float f9 = fArr[5];
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setTranslationX(f8);
            view.setTranslationY(f9);
            view.setRotation(degrees);
            view.setScaleX(f6);
            view.setScaleY(f7);
            return;
        }
        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight() / 2);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotation(0.0f);
    }

    public void setLeftTopRightBottom(@NonNull View view, int i3, int i5, int i6, int i7) {
        fetchSetFrame();
        Method method = sSetFrameMethod;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e5) {
                throw new RuntimeException(e5.getCause());
            }
        }
    }

    public void setTransitionAlpha(@NonNull View view, float f4) {
        Float f5 = (Float) view.getTag(R.id.save_non_transition_alpha);
        if (f5 != null) {
            view.setAlpha(f5.floatValue() * f4);
        } else {
            view.setAlpha(f4);
        }
    }

    public void setTransitionVisibility(@NonNull View view, int i3) {
        if (!sViewFlagsFieldFetched) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                sViewFlagsField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i(TAG, "fetchViewFlagsField: ");
            }
            sViewFlagsFieldFetched = true;
        }
        Field field = sViewFlagsField;
        if (field != null) {
            try {
                sViewFlagsField.setInt(view, i3 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            transformMatrixToGlobal(view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    public void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            transformMatrixToLocal(view2, matrix);
            matrix.postTranslate(view2.getScrollX(), view2.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }
}
