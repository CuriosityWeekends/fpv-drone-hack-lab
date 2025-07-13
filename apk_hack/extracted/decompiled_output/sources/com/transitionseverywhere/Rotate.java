package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class Rotate extends Transition {
    @Override // androidx.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        transitionValues.values.put("android:rotate:rotation", Float.valueOf(transitionValues.view.getRotation()));
    }

    @Override // androidx.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        transitionValues.values.put("android:rotate:rotation", Float.valueOf(transitionValues.view.getRotation()));
    }

    @Override // androidx.transition.Transition
    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        View view = transitionValues2.view;
        float floatValue = ((Float) transitionValues.values.get("android:rotate:rotation")).floatValue();
        float floatValue2 = ((Float) transitionValues2.values.get("android:rotate:rotation")).floatValue();
        if (floatValue == floatValue2) {
            return null;
        }
        view.setRotation(floatValue);
        return ObjectAnimator.ofFloat(view, View.ROTATION, floatValue, floatValue2);
    }
}
