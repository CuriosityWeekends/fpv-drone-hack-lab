package com.transitionseverywhere.extra;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import b4.b;
@TargetApi(14)
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class Translation extends Transition {

    /* renamed from: a  reason: collision with root package name */
    public static final b f1553a = new Property(PointF.class, "translation");

    public Translation() {
    }

    public static void a(TransitionValues transitionValues) {
        transitionValues.values.put("Translation:translationX", Float.valueOf(transitionValues.view.getTranslationX()));
        transitionValues.values.put("Translation:translationY", Float.valueOf(transitionValues.view.getTranslationY()));
    }

    @Override // androidx.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        a(transitionValues);
    }

    @Override // androidx.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        a(transitionValues);
    }

    @Override // androidx.transition.Transition
    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator ofFloat;
        ObjectAnimator objectAnimator = null;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        float floatValue = ((Float) transitionValues.values.get("Translation:translationX")).floatValue();
        float floatValue2 = ((Float) transitionValues.values.get("Translation:translationY")).floatValue();
        float floatValue3 = ((Float) transitionValues2.values.get("Translation:translationX")).floatValue();
        float floatValue4 = ((Float) transitionValues2.values.get("Translation:translationY")).floatValue();
        transitionValues2.view.setTranslationX(floatValue);
        transitionValues2.view.setTranslationY(floatValue2);
        b bVar = f1553a;
        if (bVar != null) {
            return ObjectAnimator.ofObject(transitionValues2.view, bVar, (TypeConverter) null, getPathMotion().getPath(floatValue, floatValue2, floatValue3, floatValue4));
        }
        if (floatValue == floatValue3) {
            ofFloat = null;
        } else {
            ofFloat = ObjectAnimator.ofFloat(transitionValues2.view, View.TRANSLATION_X, floatValue, floatValue3);
        }
        if (floatValue2 != floatValue4) {
            objectAnimator = ObjectAnimator.ofFloat(transitionValues2.view, View.TRANSLATION_Y, floatValue2, floatValue4);
        }
        if (ofFloat == null) {
            return objectAnimator;
        }
        if (objectAnimator != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, objectAnimator);
            return animatorSet;
        }
        return ofFloat;
    }

    public Translation(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
