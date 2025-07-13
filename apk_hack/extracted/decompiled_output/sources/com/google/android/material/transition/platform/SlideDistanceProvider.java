package com.google.android.material.transition.platform;

import a1.i;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@RequiresApi(21)
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;
    @Px
    private int slideDistance = -1;
    private int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i3) {
        this.slideEdge = i3;
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i3, @Px int i5) {
        float f4;
        float f5;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 != 48) {
                    if (i3 != 80) {
                        if (i3 != 8388611) {
                            if (i3 == 8388613) {
                                if (isRtl(view)) {
                                    f5 = translationX - i5;
                                } else {
                                    f5 = i5 + translationX;
                                }
                                return createTranslationXAnimator(view2, f5, translationX, translationX);
                            }
                            throw new IllegalArgumentException(i.e(i3, "Invalid slide direction: "));
                        }
                        if (isRtl(view)) {
                            f4 = i5 + translationX;
                        } else {
                            f4 = translationX - i5;
                        }
                        return createTranslationXAnimator(view2, f4, translationX, translationX);
                    }
                    return createTranslationYAnimator(view2, i5 + translationY, translationY, translationY);
                }
                return createTranslationYAnimator(view2, translationY - i5, translationY, translationY);
            }
            return createTranslationXAnimator(view2, translationX - i5, translationX, translationX);
        }
        return createTranslationXAnimator(view2, i5 + translationX, translationX, translationX);
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i3, @Px int i5) {
        float f4;
        float f5;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i3 != 3) {
            if (i3 != 5) {
                if (i3 != 48) {
                    if (i3 != 80) {
                        if (i3 != 8388611) {
                            if (i3 == 8388613) {
                                if (isRtl(view)) {
                                    f5 = i5 + translationX;
                                } else {
                                    f5 = translationX - i5;
                                }
                                return createTranslationXAnimator(view2, translationX, f5, translationX);
                            }
                            throw new IllegalArgumentException(i.e(i3, "Invalid slide direction: "));
                        }
                        if (isRtl(view)) {
                            f4 = translationX - i5;
                        } else {
                            f4 = i5 + translationX;
                        }
                        return createTranslationXAnimator(view2, translationX, f4, translationX);
                    }
                    return createTranslationYAnimator(view2, translationY, translationY - i5, translationY);
                }
                return createTranslationYAnimator(view2, translationY, i5 + translationY, translationY);
            }
            return createTranslationXAnimator(view2, translationX, i5 + translationX, translationX);
        }
        return createTranslationXAnimator(view2, translationX, translationX - i5, translationX);
    }

    private static Animator createTranslationXAnimator(final View view, float f4, float f5, final float f6) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f4, f5));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.platform.SlideDistanceProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationX(f6);
            }
        });
        return ofPropertyValuesHolder;
    }

    private static Animator createTranslationYAnimator(final View view, float f4, float f5, final float f6) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f4, f5));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.platform.SlideDistanceProvider.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationY(f6);
            }
        });
        return ofPropertyValuesHolder;
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i3 = this.slideDistance;
        if (i3 != -1) {
            return i3;
        }
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean isRtl(View view) {
        if (ViewCompat.getLayoutDirection(view) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int i3) {
        if (i3 >= 0) {
            this.slideDistance = i3;
            return;
        }
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int i3) {
        this.slideEdge = i3;
    }
}
