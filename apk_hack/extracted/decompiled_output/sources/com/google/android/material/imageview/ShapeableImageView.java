package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ShapeableImageView extends AppCompatImageView implements Shapeable {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_ShapeableImageView;
    private static final int UNDEFINED_PADDING = Integer.MIN_VALUE;
    private final Paint borderPaint;
    @Dimension
    private int bottomContentPadding;
    private final Paint clearPaint;
    private final RectF destination;
    @Dimension
    private int endContentPadding;
    private boolean hasAdjustedPaddingAfterLayoutDirectionResolved;
    @Dimension
    private int leftContentPadding;
    private Path maskPath;
    private final RectF maskRect;
    private final Path path;
    private final ShapeAppearancePathProvider pathProvider;
    @Dimension
    private int rightContentPadding;
    @Nullable
    private MaterialShapeDrawable shadowDrawable;
    private ShapeAppearanceModel shapeAppearanceModel;
    @Dimension
    private int startContentPadding;
    @Nullable
    private ColorStateList strokeColor;
    @Dimension
    private float strokeWidth;
    @Dimension
    private int topContentPadding;

    @TargetApi(21)
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public class OutlineProvider extends ViewOutlineProvider {
        private final Rect rect = new Rect();

        public OutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.shapeAppearanceModel == null) {
                return;
            }
            if (ShapeableImageView.this.shadowDrawable == null) {
                ShapeableImageView.this.shadowDrawable = new MaterialShapeDrawable(ShapeableImageView.this.shapeAppearanceModel);
            }
            ShapeableImageView.this.destination.round(this.rect);
            ShapeableImageView.this.shadowDrawable.setBounds(this.rect);
            ShapeableImageView.this.shadowDrawable.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    private void drawStroke(Canvas canvas) {
        if (this.strokeColor == null) {
            return;
        }
        this.borderPaint.setStrokeWidth(this.strokeWidth);
        int colorForState = this.strokeColor.getColorForState(getDrawableState(), this.strokeColor.getDefaultColor());
        if (this.strokeWidth > 0.0f && colorForState != 0) {
            this.borderPaint.setColor(colorForState);
            canvas.drawPath(this.path, this.borderPaint);
        }
    }

    private boolean isContentPaddingRelative() {
        if (this.startContentPadding == Integer.MIN_VALUE && this.endContentPadding == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private boolean isRtl() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private void updateShapeMask(int i3, int i5) {
        this.destination.set(getPaddingLeft(), getPaddingTop(), i3 - getPaddingRight(), i5 - getPaddingBottom());
        this.pathProvider.calculatePath(this.shapeAppearanceModel, 1.0f, this.destination, this.path);
        this.maskPath.rewind();
        this.maskPath.addPath(this.path);
        this.maskRect.set(0.0f, 0.0f, i3, i5);
        this.maskPath.addRect(this.maskRect, Path.Direction.CCW);
    }

    @Dimension
    public int getContentPaddingBottom() {
        return this.bottomContentPadding;
    }

    @Dimension
    public final int getContentPaddingEnd() {
        int i3 = this.endContentPadding;
        if (i3 != Integer.MIN_VALUE) {
            return i3;
        }
        if (isRtl()) {
            return this.leftContentPadding;
        }
        return this.rightContentPadding;
    }

    @Dimension
    public int getContentPaddingLeft() {
        int i3;
        int i5;
        if (isContentPaddingRelative()) {
            if (isRtl() && (i5 = this.endContentPadding) != Integer.MIN_VALUE) {
                return i5;
            }
            if (!isRtl() && (i3 = this.startContentPadding) != Integer.MIN_VALUE) {
                return i3;
            }
        }
        return this.leftContentPadding;
    }

    @Dimension
    public int getContentPaddingRight() {
        int i3;
        int i5;
        if (isContentPaddingRelative()) {
            if (isRtl() && (i5 = this.startContentPadding) != Integer.MIN_VALUE) {
                return i5;
            }
            if (!isRtl() && (i3 = this.endContentPadding) != Integer.MIN_VALUE) {
                return i3;
            }
        }
        return this.rightContentPadding;
    }

    @Dimension
    public final int getContentPaddingStart() {
        int i3 = this.startContentPadding;
        if (i3 != Integer.MIN_VALUE) {
            return i3;
        }
        if (isRtl()) {
            return this.rightContentPadding;
        }
        return this.leftContentPadding;
    }

    @Dimension
    public int getContentPaddingTop() {
        return this.topContentPadding;
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.maskPath, this.clearPaint);
        drawStroke(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i3, int i5) {
        super.onMeasure(i3, i5);
        if (this.hasAdjustedPaddingAfterLayoutDirectionResolved || !isLayoutDirectionResolved()) {
            return;
        }
        this.hasAdjustedPaddingAfterLayoutDirectionResolved = true;
        if (!isPaddingRelative() && !isContentPaddingRelative()) {
            setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
        } else {
            setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i5, int i6, int i7) {
        super.onSizeChanged(i3, i5, i6, i7);
        updateShapeMask(i3, i5);
    }

    public void setContentPadding(@Dimension int i3, @Dimension int i5, @Dimension int i6, @Dimension int i7) {
        this.startContentPadding = Integer.MIN_VALUE;
        this.endContentPadding = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.leftContentPadding) + i3, (super.getPaddingTop() - this.topContentPadding) + i5, (super.getPaddingRight() - this.rightContentPadding) + i6, (super.getPaddingBottom() - this.bottomContentPadding) + i7);
        this.leftContentPadding = i3;
        this.topContentPadding = i5;
        this.rightContentPadding = i6;
        this.bottomContentPadding = i7;
    }

    @RequiresApi(17)
    public void setContentPaddingRelative(@Dimension int i3, @Dimension int i5, @Dimension int i6, @Dimension int i7) {
        int i8;
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + i3, (super.getPaddingTop() - this.topContentPadding) + i5, (super.getPaddingEnd() - getContentPaddingEnd()) + i6, (super.getPaddingBottom() - this.bottomContentPadding) + i7);
        if (isRtl()) {
            i8 = i6;
        } else {
            i8 = i3;
        }
        this.leftContentPadding = i8;
        this.topContentPadding = i5;
        if (!isRtl()) {
            i3 = i6;
        }
        this.rightContentPadding = i3;
        this.bottomContentPadding = i7;
    }

    @Override // android.view.View
    public void setPadding(@Dimension int i3, @Dimension int i5, @Dimension int i6, @Dimension int i7) {
        super.setPadding(getContentPaddingLeft() + i3, getContentPaddingTop() + i5, getContentPaddingRight() + i6, getContentPaddingBottom() + i7);
    }

    @Override // android.view.View
    public void setPaddingRelative(@Dimension int i3, @Dimension int i5, @Dimension int i6, @Dimension int i7) {
        super.setPaddingRelative(getContentPaddingStart() + i3, getContentPaddingTop() + i5, getContentPaddingEnd() + i6, getContentPaddingBottom() + i7);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.shadowDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        updateShapeMask(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.strokeColor = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int i3) {
        setStrokeColor(AppCompatResources.getColorStateList(getContext(), i3));
    }

    public void setStrokeWidth(@Dimension float f4) {
        if (this.strokeWidth != f4) {
            this.strokeWidth = f4;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@DimenRes int i3) {
        setStrokeWidth(getResources().getDimensionPixelSize(i3));
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ShapeableImageView(android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r0 = com.google.android.material.imageview.ShapeableImageView.DEF_STYLE_RES
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r7, r8, r9, r0)
            r6.<init>(r7, r8, r9)
            com.google.android.material.shape.ShapeAppearancePathProvider r7 = com.google.android.material.shape.ShapeAppearancePathProvider.getInstance()
            r6.pathProvider = r7
            android.graphics.Path r7 = new android.graphics.Path
            r7.<init>()
            r6.path = r7
            r7 = 0
            r6.hasAdjustedPaddingAfterLayoutDirectionResolved = r7
            android.content.Context r1 = r6.getContext()
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r6.clearPaint = r2
            r3 = 1
            r2.setAntiAlias(r3)
            r4 = -1
            r2.setColor(r4)
            android.graphics.PorterDuffXfermode r4 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.DST_OUT
            r4.<init>(r5)
            r2.setXfermode(r4)
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.destination = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.maskRect = r2
            android.graphics.Path r2 = new android.graphics.Path
            r2.<init>()
            r6.maskPath = r2
            int[] r2 = com.google.android.material.R.styleable.ShapeableImageView
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r8, r2, r9, r0)
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_strokeColor
            android.content.res.ColorStateList r4 = com.google.android.material.resources.MaterialResources.getColorStateList(r1, r2, r4)
            r6.strokeColor = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_strokeWidth
            int r4 = r2.getDimensionPixelSize(r4, r7)
            float r4 = (float) r4
            r6.strokeWidth = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPadding
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.leftContentPadding = r7
            r6.topContentPadding = r7
            r6.rightContentPadding = r7
            r6.bottomContentPadding = r7
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingLeft
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.leftContentPadding = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingTop
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.topContentPadding = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingRight
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.rightContentPadding = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingBottom
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.bottomContentPadding = r7
            int r7 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingStart
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.startContentPadding = r7
            int r7 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingEnd
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.endContentPadding = r7
            r2.recycle()
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            r6.borderPaint = r7
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE
            r7.setStyle(r2)
            r7.setAntiAlias(r3)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r7 = com.google.android.material.shape.ShapeAppearanceModel.builder(r1, r8, r9, r0)
            com.google.android.material.shape.ShapeAppearanceModel r7 = r7.build()
            r6.shapeAppearanceModel = r7
            com.google.android.material.imageview.ShapeableImageView$OutlineProvider r7 = new com.google.android.material.imageview.ShapeableImageView$OutlineProvider
            r7.<init>()
            r6.setOutlineProvider(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.imageview.ShapeableImageView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
