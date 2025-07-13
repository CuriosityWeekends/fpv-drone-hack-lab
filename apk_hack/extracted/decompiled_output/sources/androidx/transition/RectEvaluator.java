package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    public RectEvaluator() {
    }

    public RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f4, Rect rect, Rect rect2) {
        int i3 = rect.left;
        int i5 = i3 + ((int) ((rect2.left - i3) * f4));
        int i6 = rect.top;
        int i7 = i6 + ((int) ((rect2.top - i6) * f4));
        int i8 = rect.right;
        int i9 = i8 + ((int) ((rect2.right - i8) * f4));
        int i10 = rect.bottom;
        int i11 = i10 + ((int) ((rect2.bottom - i10) * f4));
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new Rect(i5, i7, i9, i11);
        }
        rect3.set(i5, i7, i9, i11);
        return this.mRect;
    }
}
