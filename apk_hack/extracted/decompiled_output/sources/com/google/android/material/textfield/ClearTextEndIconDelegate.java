package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.textfield.TextInputLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ClearTextEndIconDelegate extends EndIconDelegate {
    private static final int ANIMATION_FADE_DURATION = 100;
    private static final int ANIMATION_SCALE_DURATION = 150;
    private static final float ANIMATION_SCALE_FROM_VALUE = 0.8f;
    private final TextWatcher clearTextEndIconTextWatcher;
    private final TextInputLayout.OnEditTextAttachedListener clearTextOnEditTextAttachedListener;
    private final TextInputLayout.OnEndIconChangedListener endIconChangedListener;
    private AnimatorSet iconInAnim;
    private ValueAnimator iconOutAnim;
    private final View.OnFocusChangeListener onFocusChangeListener;

    public ClearTextEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.clearTextEndIconTextWatcher = new TextWatcher() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NonNull Editable editable) {
                boolean z3;
                if (ClearTextEndIconDelegate.this.textInputLayout.getSuffixText() != null) {
                    return;
                }
                ClearTextEndIconDelegate clearTextEndIconDelegate = ClearTextEndIconDelegate.this;
                if (clearTextEndIconDelegate.textInputLayout.hasFocus() && ClearTextEndIconDelegate.hasText(editable)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                clearTextEndIconDelegate.animateIcon(z3);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i5, int i6) {
            }
        };
        this.onFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z3) {
                boolean z5 = true;
                ClearTextEndIconDelegate.this.animateIcon(((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z3) ? false : false);
            }
        };
        this.clearTextOnEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.3
            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public void onEditTextAttached(@NonNull TextInputLayout textInputLayout2) {
                boolean z3;
                EditText editText = textInputLayout2.getEditText();
                if (editText.hasFocus() && ClearTextEndIconDelegate.hasText(editText.getText())) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                textInputLayout2.setEndIconVisible(z3);
                textInputLayout2.setEndIconCheckable(false);
                editText.setOnFocusChangeListener(ClearTextEndIconDelegate.this.onFocusChangeListener);
                editText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
                editText.addTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
            }
        };
        this.endIconChangedListener = new TextInputLayout.OnEndIconChangedListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.4
            @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
            public void onEndIconChanged(@NonNull TextInputLayout textInputLayout2, int i3) {
                final EditText editText = textInputLayout2.getEditText();
                if (editText != null && i3 == 2) {
                    editText.post(new Runnable() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            editText.removeTextChangedListener(ClearTextEndIconDelegate.this.clearTextEndIconTextWatcher);
                        }
                    });
                    if (editText.getOnFocusChangeListener() == ClearTextEndIconDelegate.this.onFocusChangeListener) {
                        editText.setOnFocusChangeListener(null);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateIcon(boolean z3) {
        boolean z5;
        if (this.textInputLayout.isEndIconVisible() == z3) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z3 && !this.iconInAnim.isRunning()) {
            this.iconOutAnim.cancel();
            this.iconInAnim.start();
            if (z5) {
                this.iconInAnim.end();
            }
        } else if (!z3) {
            this.iconInAnim.cancel();
            this.iconOutAnim.start();
            if (z5) {
                this.iconOutAnim.end();
            }
        }
    }

    private ValueAnimator getAlphaAnimator(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                ClearTextEndIconDelegate.this.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    private ValueAnimator getScaleAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(ANIMATION_SCALE_FROM_VALUE, 1.0f);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ClearTextEndIconDelegate.this.endIconView.setScaleX(floatValue);
                ClearTextEndIconDelegate.this.endIconView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasText(@NonNull Editable editable) {
        if (editable.length() > 0) {
            return true;
        }
        return false;
    }

    private void initAnimators() {
        ValueAnimator scaleAnimator = getScaleAnimator();
        ValueAnimator alphaAnimator = getAlphaAnimator(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.iconInAnim = animatorSet;
        animatorSet.playTogether(scaleAnimator, alphaAnimator);
        this.iconInAnim.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(true);
            }
        });
        ValueAnimator alphaAnimator2 = getAlphaAnimator(1.0f, 0.0f);
        this.iconOutAnim = alphaAnimator2;
        alphaAnimator2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ClearTextEndIconDelegate.this.textInputLayout.setEndIconVisible(false);
            }
        });
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void initialize() {
        this.textInputLayout.setEndIconDrawable(AppCompatResources.getDrawable(this.context, R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.textInputLayout;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Editable text = ClearTextEndIconDelegate.this.textInputLayout.getEditText().getText();
                if (text != null) {
                    text.clear();
                }
                ClearTextEndIconDelegate.this.textInputLayout.refreshEndIconDrawableState();
            }
        });
        this.textInputLayout.addOnEditTextAttachedListener(this.clearTextOnEditTextAttachedListener);
        this.textInputLayout.addOnEndIconChangedListener(this.endIconChangedListener);
        initAnimators();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void onSuffixVisibilityChanged(boolean z3) {
        if (this.textInputLayout.getSuffixText() == null) {
            return;
        }
        animateIcon(z3);
    }
}
