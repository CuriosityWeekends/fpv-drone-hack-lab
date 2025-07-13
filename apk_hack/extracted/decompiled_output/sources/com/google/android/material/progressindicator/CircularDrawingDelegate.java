package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private float adjustedRadius;
    private int arcDirectionFactor;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.arcDirectionFactor = 1;
    }

    private void drawRoundedEnd(Canvas canvas, Paint paint, float f4, float f5, float f6, boolean z3, RectF rectF) {
        float f7;
        if (z3) {
            f7 = -1.0f;
        } else {
            f7 = 1.0f;
        }
        canvas.save();
        canvas.rotate(f6);
        float f8 = f4 / 2.0f;
        float f9 = f7 * f5;
        canvas.drawRect((this.adjustedRadius - f8) + f5, Math.min(0.0f, this.arcDirectionFactor * f9), (this.adjustedRadius + f8) - f5, Math.max(0.0f, f9 * this.arcDirectionFactor), paint);
        canvas.translate((this.adjustedRadius - f8) + f5, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f7) * 90.0f * this.arcDirectionFactor, true, paint);
        canvas.translate(f4 - (f5 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f7 * 90.0f * this.arcDirectionFactor, true, paint);
        canvas.restore();
    }

    private int getSize() {
        S s = this.spec;
        return (((CircularProgressIndicatorSpec) s).indicatorInset * 2) + ((CircularProgressIndicatorSpec) s).indicatorSize;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        S s;
        int i3;
        S s5 = this.spec;
        float f5 = (((CircularProgressIndicatorSpec) s5).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) s5).indicatorInset;
        canvas.translate(f5, f5);
        canvas.rotate(-90.0f);
        float f6 = -f5;
        canvas.clipRect(f6, f6, f5, f5);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection == 0) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        this.arcDirectionFactor = i3;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) s).trackThickness * f4;
        this.displayedCornerRadius = ((CircularProgressIndicatorSpec) s).trackCornerRadius * f4;
        this.adjustedRadius = (((CircularProgressIndicatorSpec) s).indicatorSize - ((CircularProgressIndicatorSpec) s).trackThickness) / 2.0f;
        if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
            this.adjustedRadius = (((1.0f - f4) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f) + this.adjustedRadius;
        } else if ((this.drawable.isShowing() && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (this.drawable.isHiding() && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
            this.adjustedRadius -= ((1.0f - f4) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @ColorInt int i3) {
        float f6;
        if (f4 == f5) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i3);
        paint.setStrokeWidth(this.displayedTrackThickness);
        int i5 = this.arcDirectionFactor;
        float f7 = f4 * 360.0f * i5;
        if (f5 >= f4) {
            f6 = f5 - f4;
        } else {
            f6 = (f5 + 1.0f) - f4;
        }
        float f8 = f6 * 360.0f * i5;
        float f9 = this.adjustedRadius;
        canvas.drawArc(new RectF(-f9, -f9, f9, f9), f7, f8, false, paint);
        if (this.displayedCornerRadius > 0.0f && Math.abs(f8) < 360.0f) {
            paint.setStyle(Paint.Style.FILL);
            float f10 = this.displayedCornerRadius;
            RectF rectF = new RectF(-f10, -f10, f10, f10);
            drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f7, true, rectF);
            drawRoundedEnd(canvas, paint, this.displayedTrackThickness, this.displayedCornerRadius, f7 + f8, false, rectF);
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(compositeARGBWithAlpha);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f4 = this.adjustedRadius;
        canvas.drawArc(new RectF(-f4, -f4, f4, f4), 0.0f, 360.0f, false, paint);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }
}
