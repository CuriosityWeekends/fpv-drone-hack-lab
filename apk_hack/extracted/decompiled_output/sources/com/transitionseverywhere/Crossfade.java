package com.transitionseverywhere;

import a4.c;
import a4.d;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.RectEvaluator;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;
@TargetApi(18)
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class Crossfade extends Transition {
    public static RectEvaluator c;

    /* renamed from: a  reason: collision with root package name */
    public final int f1550a = 1;
    public final int b = 1;

    public final void a(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getWidth() > 0 && view.getHeight() > 0) {
            Rect rect = new Rect(0, 0, view.getWidth(), view.getHeight());
            if (this.f1550a != 1) {
                rect.offset(view.getLeft(), view.getTop());
            }
            transitionValues.values.put("android:crossfade:bounds", rect);
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            if (view instanceof TextureView) {
                createBitmap = ((TextureView) view).getBitmap();
            } else {
                view.draw(new Canvas(createBitmap));
            }
            transitionValues.values.put("android:crossfade:bitmap", createBitmap);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(view.getResources(), createBitmap);
            bitmapDrawable.setBounds(rect);
            transitionValues.values.put("android:crossfade:drawable", bitmapDrawable);
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
        boolean z3;
        ViewOverlay overlay;
        ObjectAnimator ofInt;
        ObjectAnimator objectAnimator = null;
        if (transitionValues != null && transitionValues2 != null) {
            if (c == null) {
                c = new RectEvaluator();
            }
            int i3 = this.f1550a;
            if (i3 != 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            View view = transitionValues2.view;
            Map<String, Object> map = transitionValues.values;
            Map<String, Object> map2 = transitionValues2.values;
            Rect rect = (Rect) map.get("android:crossfade:bounds");
            Rect rect2 = (Rect) map2.get("android:crossfade:bounds");
            if (rect != null && rect2 != null) {
                Bitmap bitmap = (Bitmap) map.get("android:crossfade:bitmap");
                Bitmap bitmap2 = (Bitmap) map2.get("android:crossfade:bitmap");
                BitmapDrawable bitmapDrawable = (BitmapDrawable) map.get("android:crossfade:drawable");
                BitmapDrawable bitmapDrawable2 = (BitmapDrawable) map2.get("android:crossfade:drawable");
                if (bitmapDrawable != null && bitmapDrawable2 != null && !bitmap.sameAs(bitmap2)) {
                    if (z3) {
                        overlay = ((ViewGroup) view.getParent()).getOverlay();
                    } else {
                        overlay = view.getOverlay();
                    }
                    if (i3 == 1) {
                        overlay.add(bitmapDrawable2);
                    }
                    overlay.add(bitmapDrawable);
                    if (i3 == 2) {
                        ofInt = ObjectAnimator.ofInt(bitmapDrawable, "alpha", 255, 0, 0);
                    } else {
                        ofInt = ObjectAnimator.ofInt(bitmapDrawable, "alpha", 0);
                    }
                    ObjectAnimator objectAnimator2 = ofInt;
                    objectAnimator2.addUpdateListener(new c(view, bitmapDrawable));
                    if (i3 == 2) {
                        objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 0.0f, 1.0f);
                    } else if (i3 == 0) {
                        objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 1.0f);
                    }
                    ObjectAnimator objectAnimator3 = objectAnimator;
                    objectAnimator2.addListener(new d(this, z3, view, bitmapDrawable, bitmapDrawable2));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(objectAnimator2);
                    if (objectAnimator3 != null) {
                        animatorSet.playTogether(objectAnimator3);
                    }
                    int i5 = this.b;
                    if (i5 == 1 && !rect.equals(rect2)) {
                        animatorSet.playTogether(ObjectAnimator.ofObject(bitmapDrawable, "bounds", c, rect, rect2));
                        if (i5 == 1) {
                            animatorSet.playTogether(ObjectAnimator.ofObject(bitmapDrawable2, "bounds", c, rect, rect2));
                        }
                    }
                    return animatorSet;
                }
            }
        }
        return null;
    }
}
