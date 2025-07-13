package androidx.transition;

import a1.i;
import android.animation.TypeEvaluator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {
    private float[] mArray;

    public FloatArrayEvaluator(float[] fArr) {
        this.mArray = fArr;
    }

    @Override // android.animation.TypeEvaluator
    public float[] evaluate(float f4, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.mArray;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i3 = 0; i3 < fArr3.length; i3++) {
            float f5 = fArr[i3];
            fArr3[i3] = i.b(fArr2[i3], f5, f4, f5);
        }
        return fArr3;
    }
}
