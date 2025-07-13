package com.transitionseverywhere;

import a4.a;
import a4.b;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ChangeText extends Transition {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f1549a = {"android:textchange:text", "android:textchange:textSelectionStart", "android:textchange:textSelectionEnd"};

    public static void a(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            transitionValues.values.put("android:textchange:text", textView.getText());
            if (textView instanceof EditText) {
                transitionValues.values.put("android:textchange:textSelectionStart", Integer.valueOf(textView.getSelectionStart()));
                transitionValues.values.put("android:textchange:textSelectionEnd", Integer.valueOf(textView.getSelectionEnd()));
            }
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

    @Override // androidx.transition.Transition
    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        CharSequence charSequence;
        CharSequence charSequence2;
        int i3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (transitionValues != null && transitionValues2 != null && (transitionValues.view instanceof TextView)) {
            View view = transitionValues2.view;
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                Map<String, Object> map = transitionValues.values;
                Map<String, Object> map2 = transitionValues2.values;
                if (map.get("android:textchange:text") == null) {
                    charSequence = "";
                } else {
                    charSequence = (CharSequence) map.get("android:textchange:text");
                }
                if (map2.get("android:textchange:text") == null) {
                    charSequence2 = "";
                } else {
                    charSequence2 = (CharSequence) map2.get("android:textchange:text");
                }
                int i10 = -1;
                if (textView instanceof EditText) {
                    if (map.get("android:textchange:textSelectionStart") != null) {
                        i8 = ((Integer) map.get("android:textchange:textSelectionStart")).intValue();
                    } else {
                        i8 = -1;
                    }
                    if (map.get("android:textchange:textSelectionEnd") != null) {
                        i9 = ((Integer) map.get("android:textchange:textSelectionEnd")).intValue();
                    } else {
                        i9 = i8;
                    }
                    if (map2.get("android:textchange:textSelectionStart") != null) {
                        i10 = ((Integer) map2.get("android:textchange:textSelectionStart")).intValue();
                    }
                    if (map2.get("android:textchange:textSelectionEnd") != null) {
                        i5 = ((Integer) map2.get("android:textchange:textSelectionEnd")).intValue();
                    } else {
                        i5 = i10;
                    }
                    i7 = i9;
                    i3 = i10;
                    i6 = i8;
                } else {
                    i3 = -1;
                    i5 = -1;
                    i6 = -1;
                    i7 = -1;
                }
                if (charSequence.equals(charSequence2)) {
                    return null;
                }
                textView.setText(charSequence);
                if (textView instanceof EditText) {
                    EditText editText = (EditText) textView;
                    if (i6 >= 0 && i7 >= 0) {
                        editText.setSelection(i6, i7);
                    }
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.addListener(new a(this, charSequence, textView, charSequence2, i3, i5));
                addListener(new b(this, textView, charSequence2, i3, i5, charSequence, i6, i7));
                return ofFloat;
            }
        }
        return null;
    }

    @Override // androidx.transition.Transition
    public final String[] getTransitionProperties() {
        return f1549a;
    }
}
