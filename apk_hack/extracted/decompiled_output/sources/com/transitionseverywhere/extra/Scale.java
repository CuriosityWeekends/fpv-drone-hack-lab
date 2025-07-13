package com.transitionseverywhere.extra;

import a4.e;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import b4.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class Scale extends Visibility {

    /* renamed from: a  reason: collision with root package name */
    public final float f1552a;

    public Scale() {
        this.f1552a = 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Animator a(View view, float f4, float f5, TransitionValues transitionValues) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        float f6 = scaleX * f4;
        float f7 = scaleX * f5;
        float f8 = f4 * scaleY;
        float f9 = f5 * scaleY;
        if (transitionValues != null) {
            Float f10 = (Float) transitionValues.values.get("scale:scaleX");
            Float f11 = (Float) transitionValues.values.get("scale:scaleY");
            if (f10 != null && f10.floatValue() != scaleX) {
                f6 = f10.floatValue();
            }
            if (f11 != null && f11.floatValue() != scaleY) {
                f8 = f11.floatValue();
            }
        }
        view.setScaleX(f6);
        view.setScaleY(f8);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.SCALE_X, f6, f7);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, View.SCALE_Y, f8, f9);
        if (ofFloat == null) {
            ofFloat = ofFloat2;
        } else if (ofFloat2 != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2);
            ofFloat = animatorSet;
        }
        addListener(new a(view, scaleX, scaleY));
        return ofFloat;
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.values.put("scale:scaleX", Float.valueOf(transitionValues.view.getScaleX()));
        transitionValues.values.put("scale:scaleY", Float.valueOf(transitionValues.view.getScaleY()));
    }

    @Override // androidx.transition.Visibility
    public final Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return a(view, this.f1552a, 1.0f, transitionValues);
    }

    @Override // androidx.transition.Visibility
    public final Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return a(view, 1.0f, this.f1552a, transitionValues);
    }

    public Scale(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1552a = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.Scale);
        float f4 = obtainStyledAttributes.getFloat(e.Scale_disappearedScale, this.f1552a);
        if (f4 >= 0.0f) {
            this.f1552a = f4;
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("disappearedScale cannot be negative!");
    }
}
