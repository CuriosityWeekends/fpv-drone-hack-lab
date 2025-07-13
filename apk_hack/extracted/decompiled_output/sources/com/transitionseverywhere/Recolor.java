package com.transitionseverywhere;

import a4.f;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import c4.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class Recolor extends Transition {

    /* renamed from: a  reason: collision with root package name */
    public static final a f1551a = new a(new f(0));
    public static final a b = new a(new f(1));

    public Recolor() {
    }

    public static void a(TransitionValues transitionValues) {
        transitionValues.values.put("android:recolor:background", transitionValues.view.getBackground());
        View view = transitionValues.view;
        if (view instanceof TextView) {
            transitionValues.values.put("android:recolor:textColor", Integer.valueOf(((TextView) view).getCurrentTextColor()));
        }
    }

    @Override // androidx.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        a(transitionValues);
    }

    @Override // androidx.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        a(transitionValues);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0095  */
    @Override // androidx.transition.Transition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator createAnimator(android.view.ViewGroup r6, androidx.transition.TransitionValues r7, androidx.transition.TransitionValues r8) {
        /*
            r5 = this;
            r6 = 0
            if (r7 == 0) goto Lab
            if (r8 != 0) goto L7
            goto Lab
        L7:
            android.view.View r0 = r8.view
            java.util.Map<java.lang.String, java.lang.Object> r1 = r7.values
            java.lang.String r2 = "android:recolor:background"
            java.lang.Object r1 = r1.get(r2)
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            java.util.Map<java.lang.String, java.lang.Object> r3 = r8.values
            java.lang.Object r2 = r3.get(r2)
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2
            boolean r3 = r1 instanceof android.graphics.drawable.ColorDrawable
            if (r3 == 0) goto L59
            boolean r3 = r2 instanceof android.graphics.drawable.ColorDrawable
            if (r3 == 0) goto L59
            android.graphics.drawable.ColorDrawable r1 = (android.graphics.drawable.ColorDrawable) r1
            android.graphics.drawable.ColorDrawable r2 = (android.graphics.drawable.ColorDrawable) r2
            int r3 = r1.getColor()
            int r4 = r2.getColor()
            if (r3 == r4) goto L59
            int r3 = r2.getColor()
            android.graphics.drawable.Drawable r2 = r2.mutate()
            android.graphics.drawable.ColorDrawable r2 = (android.graphics.drawable.ColorDrawable) r2
            int r4 = r1.getColor()
            r2.setColor(r4)
            int r1 = r1.getColor()
            int[] r1 = new int[]{r1, r3}
            c4.a r3 = com.transitionseverywhere.Recolor.b
            android.animation.ObjectAnimator r1 = android.animation.ObjectAnimator.ofInt(r2, r3, r1)
            android.animation.ArgbEvaluator r2 = new android.animation.ArgbEvaluator
            r2.<init>()
            r1.setEvaluator(r2)
            goto L5a
        L59:
            r1 = r6
        L5a:
            boolean r2 = r0 instanceof android.widget.TextView
            if (r2 == 0) goto L91
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.util.Map<java.lang.String, java.lang.Object> r7 = r7.values
            java.lang.String r2 = "android:recolor:textColor"
            java.lang.Object r7 = r7.get(r2)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.util.Map<java.lang.String, java.lang.Object> r8 = r8.values
            java.lang.Object r8 = r8.get(r2)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r7 == r8) goto L91
            r0.setTextColor(r8)
            c4.a r6 = com.transitionseverywhere.Recolor.f1551a
            int[] r7 = new int[]{r7, r8}
            android.animation.ObjectAnimator r6 = android.animation.ObjectAnimator.ofInt(r0, r6, r7)
            android.animation.ArgbEvaluator r7 = new android.animation.ArgbEvaluator
            r7.<init>()
            r6.setEvaluator(r7)
        L91:
            if (r1 != 0) goto L95
            r1 = r6
            goto Laa
        L95:
            if (r6 != 0) goto L98
            goto Laa
        L98:
            android.animation.AnimatorSet r7 = new android.animation.AnimatorSet
            r7.<init>()
            r8 = 2
            android.animation.Animator[] r8 = new android.animation.Animator[r8]
            r0 = 0
            r8[r0] = r1
            r0 = 1
            r8[r0] = r6
            r7.playTogether(r8)
            r1 = r7
        Laa:
            return r1
        Lab:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transitionseverywhere.Recolor.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    public Recolor(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
