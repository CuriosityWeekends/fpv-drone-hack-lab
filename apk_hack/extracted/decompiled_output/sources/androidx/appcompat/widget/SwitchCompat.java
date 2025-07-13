package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SwitchCompat extends CompoundButton {
    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 250;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private final AppCompatTextHelper mTextHelper;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
    private final TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList;
    private PorterDuff.Mode mTrackTintMode;
    private VelocityTracker mVelocityTracker;
    private static final Property<SwitchCompat, Float> THUMB_POS = new Property<SwitchCompat, Float>(Float.class, "thumbPos") { // from class: androidx.appcompat.widget.SwitchCompat.1
        @Override // android.util.Property
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.mThumbPosition);
        }

        @Override // android.util.Property
        public void set(SwitchCompat switchCompat, Float f4) {
            switchCompat.setThumbPosition(f4.floatValue());
        }
    };
    private static final int[] CHECKED_STATE_SET = {16842912};

    public SwitchCompat(@NonNull Context context) {
        this(context, null);
    }

    private void animateThumbToCheckedState(boolean z3) {
        float f4;
        if (z3) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, THUMB_POS, f4);
        this.mPositionAnimator = ofFloat;
        ofFloat.setDuration(250L);
        this.mPositionAnimator.setAutoCancel(true);
        this.mPositionAnimator.start();
    }

    private void applyThumbTint() {
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            if (this.mHasThumbTint || this.mHasThumbTintMode) {
                Drawable mutate = DrawableCompat.wrap(drawable).mutate();
                this.mThumbDrawable = mutate;
                if (this.mHasThumbTint) {
                    DrawableCompat.setTintList(mutate, this.mThumbTintList);
                }
                if (this.mHasThumbTintMode) {
                    DrawableCompat.setTintMode(this.mThumbDrawable, this.mThumbTintMode);
                }
                if (this.mThumbDrawable.isStateful()) {
                    this.mThumbDrawable.setState(getDrawableState());
                }
            }
        }
    }

    private void applyTrackTint() {
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            if (this.mHasTrackTint || this.mHasTrackTintMode) {
                Drawable mutate = DrawableCompat.wrap(drawable).mutate();
                this.mTrackDrawable = mutate;
                if (this.mHasTrackTint) {
                    DrawableCompat.setTintList(mutate, this.mTrackTintList);
                }
                if (this.mHasTrackTintMode) {
                    DrawableCompat.setTintMode(this.mTrackDrawable, this.mTrackTintMode);
                }
                if (this.mTrackDrawable.isStateful()) {
                    this.mTrackDrawable.setState(getDrawableState());
                }
            }
        }
    }

    private void cancelPositionAnimator() {
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void cancelSuperTouch(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float constrain(float f4, float f5, float f6) {
        return f4 < f5 ? f5 : f4 > f6 ? f6 : f4;
    }

    private boolean getTargetCheckedState() {
        if (this.mThumbPosition > 0.5f) {
            return true;
        }
        return false;
    }

    private int getThumbOffset() {
        float f4;
        if (ViewUtils.isLayoutRtl(this)) {
            f4 = 1.0f - this.mThumbPosition;
        } else {
            f4 = this.mThumbPosition;
        }
        return (int) ((f4 * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            Rect rect2 = this.mTempRect;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.mThumbDrawable;
            if (drawable2 != null) {
                rect = DrawableUtils.getOpticalBounds(drawable2);
            } else {
                rect = DrawableUtils.INSETS_NONE;
            }
            return ((((this.mSwitchWidth - this.mThumbWidth) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    private boolean hitThumb(float f4, float f5) {
        if (this.mThumbDrawable == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int i3 = this.mSwitchTop;
        int i5 = this.mTouchSlop;
        int i6 = i3 - i5;
        int i7 = (this.mSwitchLeft + thumbOffset) - i5;
        Rect rect = this.mTempRect;
        int i8 = this.mThumbWidth + i7 + rect.left + rect.right + i5;
        int i9 = this.mSwitchBottom + i5;
        if (f4 <= i7 || f4 >= i8 || f5 <= i6 || f5 >= i9) {
            return false;
        }
        return true;
    }

    private Layout makeLayout(CharSequence charSequence) {
        int i3;
        TransformationMethod transformationMethod = this.mSwitchTransformationMethod;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.mTextPaint;
        if (charSequence2 != null) {
            i3 = (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint));
        } else {
            i3 = 0;
        }
        return new StaticLayout(charSequence2, textPaint, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void setOffStateDescriptionOnRAndAbove() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.mTextOff;
            if (charSequence == null) {
                charSequence = getResources().getString(R.string.abc_capital_off);
            }
            ViewCompat.setStateDescription(this, charSequence);
        }
    }

    private void setOnStateDescriptionOnRAndAbove() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.mTextOn;
            if (charSequence == null) {
                charSequence = getResources().getString(R.string.abc_capital_on);
            }
            ViewCompat.setStateDescription(this, charSequence);
        }
    }

    private void setSwitchTypefaceByIndex(int i3, int i5) {
        Typeface typeface;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    typeface = null;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
            } else {
                typeface = Typeface.SERIF;
            }
        } else {
            typeface = Typeface.SANS_SERIF;
        }
        setSwitchTypeface(typeface, i5);
    }

    private void stopDrag(MotionEvent motionEvent) {
        boolean z3;
        this.mTouchMode = 0;
        boolean z5 = true;
        if (motionEvent.getAction() == 1 && isEnabled()) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean isChecked = isChecked();
        if (z3) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xVelocity) > this.mMinFlingVelocity) {
                if (!ViewUtils.isLayoutRtl(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z5 = false;
                }
            } else {
                z5 = getTargetCheckedState();
            }
        } else {
            z5 = isChecked;
        }
        if (z5 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z5);
        cancelSuperTouch(motionEvent);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i3;
        int i5;
        Rect rect2 = this.mTempRect;
        int i6 = this.mSwitchLeft;
        int i7 = this.mSwitchTop;
        int i8 = this.mSwitchRight;
        int i9 = this.mSwitchBottom;
        int thumbOffset = getThumbOffset() + i6;
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            rect = DrawableUtils.getOpticalBounds(drawable);
        } else {
            rect = DrawableUtils.INSETS_NONE;
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i10 = rect2.left;
            thumbOffset += i10;
            if (rect != null) {
                int i11 = rect.left;
                if (i11 > i10) {
                    i6 += i11 - i10;
                }
                int i12 = rect.top;
                int i13 = rect2.top;
                if (i12 > i13) {
                    i3 = (i12 - i13) + i7;
                } else {
                    i3 = i7;
                }
                int i14 = rect.right;
                int i15 = rect2.right;
                if (i14 > i15) {
                    i8 -= i14 - i15;
                }
                int i16 = rect.bottom;
                int i17 = rect2.bottom;
                if (i16 > i17) {
                    i5 = i9 - (i16 - i17);
                    this.mTrackDrawable.setBounds(i6, i3, i8, i5);
                }
            } else {
                i3 = i7;
            }
            i5 = i9;
            this.mTrackDrawable.setBounds(i6, i3, i8, i5);
        }
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i18 = thumbOffset - rect2.left;
            int i19 = thumbOffset + this.mThumbWidth + rect2.right;
            this.mThumbDrawable.setBounds(i18, i7, i19, i9);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, i18, i7, i19, i9);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f4, float f5) {
        super.drawableHotspotChanged(f4, f5);
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f4, f5);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            DrawableCompat.setHotspot(drawable2, f4, f5);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        boolean z3;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null && drawable.isStateful()) {
            z3 = drawable.setState(drawableState);
        } else {
            z3 = false;
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null && drawable2.isStateful()) {
            z3 |= drawable2.setState(drawableState);
        }
        if (z3) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.mSwitchPadding;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.mSwitchPadding;
        }
        return compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    @Nullable
    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    @Nullable
    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    @Nullable
    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    @Nullable
    public PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.mPositionAnimator.end();
            this.mPositionAnimator = null;
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Layout layout;
        int width;
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.mSwitchTop;
        int i5 = this.mSwitchBottom;
        int i6 = i3 + rect.top;
        int i7 = i5 - rect.bottom;
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable != null) {
            if (this.mSplitTrack && drawable2 != null) {
                Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable2);
                drawable2.copyBounds(rect);
                rect.left += opticalBounds.left;
                rect.right -= opticalBounds.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        if (getTargetCheckedState()) {
            layout = this.mOnLayout;
        } else {
            layout = this.mOffLayout;
        }
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.mTextColors;
            if (colorStateList != null) {
                this.mTextPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.mTextPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i6 + i7) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        CharSequence charSequence;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
        if (Build.VERSION.SDK_INT < 30) {
            if (isChecked()) {
                charSequence = this.mTextOn;
            } else {
                charSequence = this.mTextOff;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text);
                sb.append(' ');
                sb.append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z3, int i3, int i5, int i6, int i7) {
        int i8;
        int width;
        int i9;
        int i10;
        int i11;
        super.onLayout(z3, i3, i5, i6, i7);
        int i12 = 0;
        if (this.mThumbDrawable != null) {
            Rect rect = this.mTempRect;
            Drawable drawable = this.mTrackDrawable;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect opticalBounds = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
            i8 = Math.max(0, opticalBounds.left - rect.left);
            i12 = Math.max(0, opticalBounds.right - rect.right);
        } else {
            i8 = 0;
        }
        if (ViewUtils.isLayoutRtl(this)) {
            i9 = getPaddingLeft() + i8;
            width = ((this.mSwitchWidth + i9) - i8) - i12;
        } else {
            width = (getWidth() - getPaddingRight()) - i12;
            i9 = (width - this.mSwitchWidth) + i8 + i12;
        }
        int gravity = getGravity() & 112;
        if (gravity != 16) {
            if (gravity != 80) {
                i11 = getPaddingTop();
                i10 = this.mSwitchHeight + i11;
            } else {
                i10 = getHeight() - getPaddingBottom();
                i11 = i10 - this.mSwitchHeight;
            }
        } else {
            int paddingTop = getPaddingTop();
            int i13 = this.mSwitchHeight;
            int height = (((getHeight() + paddingTop) - getPaddingBottom()) / 2) - (i13 / 2);
            i10 = i13 + height;
            i11 = height;
        }
        this.mSwitchLeft = i9;
        this.mSwitchTop = i11;
        this.mSwitchBottom = i10;
        this.mSwitchRight = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i5) {
        int i6;
        int i7;
        int i8;
        if (this.mShowText) {
            if (this.mOnLayout == null) {
                this.mOnLayout = makeLayout(this.mTextOn);
            }
            if (this.mOffLayout == null) {
                this.mOffLayout = makeLayout(this.mTextOff);
            }
        }
        Rect rect = this.mTempRect;
        Drawable drawable = this.mThumbDrawable;
        int i9 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i6 = (this.mThumbDrawable.getIntrinsicWidth() - rect.left) - rect.right;
            i7 = this.mThumbDrawable.getIntrinsicHeight();
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (this.mShowText) {
            i8 = (this.mThumbTextPadding * 2) + Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth());
        } else {
            i8 = 0;
        }
        this.mThumbWidth = Math.max(i8, i6);
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i9 = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i10 = rect.left;
        int i11 = rect.right;
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable3);
            i10 = Math.max(i10, opticalBounds.left);
            i11 = Math.max(i11, opticalBounds.right);
        }
        int max = Math.max(this.mSwitchMinWidth, (this.mThumbWidth * 2) + i10 + i11);
        int max2 = Math.max(i9, i7);
        this.mSwitchWidth = max;
        this.mSwitchHeight = max2;
        super.onMeasure(i3, i5);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        CharSequence charSequence;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (isChecked()) {
            charSequence = this.mTextOn;
        } else {
            charSequence = this.mTextOff;
        }
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9f
            r2 = 2
            if (r0 == r1) goto L8b
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L8b
            goto Lb9
        L16:
            int r0 = r6.mTouchMode
            if (r0 == r1) goto L57
            if (r0 == r2) goto L1e
            goto Lb9
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.mTouchX
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3d
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L39
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L3d
        L39:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L3d:
            boolean r0 = androidx.appcompat.widget.ViewUtils.isLayoutRtl(r6)
            if (r0 == 0) goto L44
            float r2 = -r2
        L44:
            float r0 = r6.mThumbPosition
            float r0 = r0 + r2
            float r0 = constrain(r0, r4, r3)
            float r2 = r6.mThumbPosition
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L56
            r6.mTouchX = r7
            r6.setThumbPosition(r0)
        L56:
            return r1
        L57:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.mTouchX
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7d
            float r4 = r6.mTouchY
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.mTouchSlop
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb9
        L7d:
            r6.mTouchMode = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.mTouchX = r0
            r6.mTouchY = r3
            return r1
        L8b:
            int r0 = r6.mTouchMode
            if (r0 != r2) goto L96
            r6.stopDrag(r7)
            super.onTouchEvent(r7)
            return r1
        L96:
            r0 = 0
            r6.mTouchMode = r0
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.clear()
            goto Lb9
        L9f:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb9
            boolean r3 = r6.hitThumb(r0, r2)
            if (r3 == 0) goto Lb9
            r6.mTouchMode = r1
            r6.mTouchX = r0
            r6.mTouchY = r2
        Lb9:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z3) {
        float f4;
        super.setChecked(z3);
        boolean isChecked = isChecked();
        if (isChecked) {
            setOnStateDescriptionOnRAndAbove();
        } else {
            setOffStateDescriptionOnRAndAbove();
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
            animateThumbToCheckedState(isChecked);
            return;
        }
        cancelPositionAnimator();
        if (isChecked) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        setThumbPosition(f4);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setShowText(boolean z3) {
        if (this.mShowText != z3) {
            this.mShowText = z3;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z3) {
        this.mSplitTrack = z3;
        invalidate();
    }

    public void setSwitchMinWidth(int i3) {
        this.mSwitchMinWidth = i3;
        requestLayout();
    }

    public void setSwitchPadding(int i3) {
        this.mSwitchPadding = i3;
        requestLayout();
    }

    public void setSwitchTextAppearance(Context context, int i3) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i3, R.styleable.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.mTextColors = colorStateList;
        } else {
            this.mTextColors = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
        if (dimensionPixelSize != 0) {
            float f4 = dimensionPixelSize;
            if (f4 != this.mTextPaint.getTextSize()) {
                this.mTextPaint.setTextSize(f4);
                requestLayout();
            }
        }
        setSwitchTypefaceByIndex(obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, -1), obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, -1));
        if (obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false)) {
            this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
        } else {
            this.mSwitchTransformationMethod = null;
        }
        obtainStyledAttributes.recycle();
    }

    public void setSwitchTypeface(Typeface typeface, int i3) {
        Typeface create;
        if (i3 > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i3);
            } else {
                create = Typeface.create(typeface, i3);
            }
            setSwitchTypeface(create);
            int i5 = (~(create != null ? create.getStyle() : 0)) & i3;
            this.mTextPaint.setFakeBoldText((i5 & 1) != 0);
            this.mTextPaint.setTextSkewX((i5 & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setTextOff(CharSequence charSequence) {
        this.mTextOff = charSequence;
        requestLayout();
        if (!isChecked()) {
            setOffStateDescriptionOnRAndAbove();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        this.mTextOn = charSequence;
        requestLayout();
        if (isChecked()) {
            setOnStateDescriptionOnRAndAbove();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f4) {
        this.mThumbPosition = f4;
        invalidate();
    }

    public void setThumbResource(int i3) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), i3));
    }

    public void setThumbTextPadding(int i3) {
        this.mThumbTextPadding = i3;
        requestLayout();
    }

    public void setThumbTintList(@Nullable ColorStateList colorStateList) {
        this.mThumbTintList = colorStateList;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public void setThumbTintMode(@Nullable PorterDuff.Mode mode) {
        this.mThumbTintMode = mode;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.mTrackDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i3) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), i3));
    }

    public void setTrackTintList(@Nullable ColorStateList colorStateList) {
        this.mTrackTintList = colorStateList;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public void setTrackTintMode(@Nullable PorterDuff.Mode mode) {
        this.mTrackTintMode = mode;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.mThumbDrawable && drawable != this.mTrackDrawable) {
            return false;
        }
        return true;
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    public SwitchCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = R.styleable.SwitchCompat;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i3, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i3, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.SwitchCompat_android_thumb);
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.SwitchCompat_track);
        this.mTrackDrawable = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.mTextOn = obtainStyledAttributes.getText(R.styleable.SwitchCompat_android_textOn);
        this.mTextOff = obtainStyledAttributes.getText(R.styleable.SwitchCompat_android_textOff);
        this.mShowText = obtainStyledAttributes.getBoolean(R.styleable.SwitchCompat_showText, true);
        this.mThumbTextPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.mSwitchMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
        this.mSwitchPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
        this.mSplitTrack = obtainStyledAttributes.getBoolean(R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.SwitchCompat_thumbTint);
        if (colorStateList != null) {
            this.mThumbTintList = colorStateList;
            this.mHasThumbTint = true;
        }
        PorterDuff.Mode parseTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.mThumbTintMode != parseTintMode) {
            this.mThumbTintMode = parseTintMode;
            this.mHasThumbTintMode = true;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            applyThumbTint();
        }
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.SwitchCompat_trackTint);
        if (colorStateList2 != null) {
            this.mTrackTintList = colorStateList2;
            this.mHasTrackTint = true;
        }
        PorterDuff.Mode parseTintMode2 = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.mTrackTintMode != parseTintMode2) {
            this.mTrackTintMode = parseTintMode2;
            this.mHasTrackTintMode = true;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            applyTrackTint();
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, i3);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.mTextPaint.getTypeface() == null || this.mTextPaint.getTypeface().equals(typeface)) && (this.mTextPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        this.mTextPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }
}
