package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    private boolean mHasTickMarkTint;
    private boolean mHasTickMarkTintMode;
    private Drawable mTickMark;
    private ColorStateList mTickMarkTintList;
    private PorterDuff.Mode mTickMarkTintMode;
    private final SeekBar mView;

    public AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.mTickMarkTintList = null;
        this.mTickMarkTintMode = null;
        this.mHasTickMarkTint = false;
        this.mHasTickMarkTintMode = false;
        this.mView = seekBar;
    }

    private void applyTickMarkTint() {
        Drawable drawable = this.mTickMark;
        if (drawable != null) {
            if (this.mHasTickMarkTint || this.mHasTickMarkTintMode) {
                Drawable wrap = DrawableCompat.wrap(drawable.mutate());
                this.mTickMark = wrap;
                if (this.mHasTickMarkTint) {
                    DrawableCompat.setTintList(wrap, this.mTickMarkTintList);
                }
                if (this.mHasTickMarkTintMode) {
                    DrawableCompat.setTintMode(this.mTickMark, this.mTickMarkTintMode);
                }
                if (this.mTickMark.isStateful()) {
                    this.mTickMark.setState(this.mView.getDrawableState());
                }
            }
        }
    }

    public void drawTickMarks(Canvas canvas) {
        int i3;
        if (this.mTickMark != null) {
            int max = this.mView.getMax();
            int i5 = 1;
            if (max > 1) {
                int intrinsicWidth = this.mTickMark.getIntrinsicWidth();
                int intrinsicHeight = this.mTickMark.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i3 = intrinsicWidth / 2;
                } else {
                    i3 = 1;
                }
                if (intrinsicHeight >= 0) {
                    i5 = intrinsicHeight / 2;
                }
                this.mTickMark.setBounds(-i3, -i5, i3, i5);
                float width = ((this.mView.getWidth() - this.mView.getPaddingLeft()) - this.mView.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.mView.getPaddingLeft(), this.mView.getHeight() / 2);
                for (int i6 = 0; i6 <= max; i6++) {
                    this.mTickMark.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public void drawableStateChanged() {
        Drawable drawable = this.mTickMark;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.mView.getDrawableState())) {
            this.mView.invalidateDrawable(drawable);
        }
    }

    @Nullable
    public Drawable getTickMark() {
        return this.mTickMark;
    }

    @Nullable
    public ColorStateList getTickMarkTintList() {
        return this.mTickMarkTintList;
    }

    @Nullable
    public PorterDuff.Mode getTickMarkTintMode() {
        return this.mTickMarkTintMode;
    }

    public void jumpDrawablesToCurrentState() {
        Drawable drawable = this.mTickMark;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    public void loadFromAttributes(AttributeSet attributeSet, int i3) {
        super.loadFromAttributes(attributeSet, i3);
        Context context = this.mView.getContext();
        int[] iArr = R.styleable.AppCompatSeekBar;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i3, 0);
        SeekBar seekBar = this.mView;
        ViewCompat.saveAttributeDataForStyleable(seekBar, seekBar.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i3, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            this.mView.setThumb(drawableIfKnown);
        }
        setTickMark(obtainStyledAttributes.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
        int i5 = R.styleable.AppCompatSeekBar_tickMarkTintMode;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.mTickMarkTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i5, -1), this.mTickMarkTintMode);
            this.mHasTickMarkTintMode = true;
        }
        int i6 = R.styleable.AppCompatSeekBar_tickMarkTint;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.mTickMarkTintList = obtainStyledAttributes.getColorStateList(i6);
            this.mHasTickMarkTint = true;
        }
        obtainStyledAttributes.recycle();
        applyTickMarkTint();
    }

    public void setTickMark(@Nullable Drawable drawable) {
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTickMark = drawable;
        if (drawable != null) {
            drawable.setCallback(this.mView);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.mView));
            if (drawable.isStateful()) {
                drawable.setState(this.mView.getDrawableState());
            }
            applyTickMarkTint();
        }
        this.mView.invalidate();
    }

    public void setTickMarkTintList(@Nullable ColorStateList colorStateList) {
        this.mTickMarkTintList = colorStateList;
        this.mHasTickMarkTint = true;
        applyTickMarkTint();
    }

    public void setTickMarkTintMode(@Nullable PorterDuff.Mode mode) {
        this.mTickMarkTintMode = mode;
        this.mHasTickMarkTintMode = true;
        applyTickMarkTint();
    }
}
