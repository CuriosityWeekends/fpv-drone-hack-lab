package androidx.appcompat.graphics.drawable;

import a1.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    private static final float ARROW_HEAD_ANGLE = (float) Math.toRadians(45.0d);
    private float mArrowHeadLength;
    private float mArrowShaftLength;
    private float mBarGap;
    private float mBarLength;
    private int mDirection;
    private float mMaxCutForBarSize;
    private final Paint mPaint;
    private final Path mPath;
    private float mProgress;
    private final int mSize;
    private boolean mSpin;
    private boolean mVerticalMirror;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mPath = new Path();
        this.mVerticalMirror = false;
        this.mDirection = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize(Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.mBarLength = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.mArrowHeadLength = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.mArrowShaftLength = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float lerp(float f4, float f5, float f6) {
        return i.b(f5, f4, f6, f4);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f4;
        float f5;
        int i3;
        Rect bounds = getBounds();
        int i5 = this.mDirection;
        boolean z3 = false;
        if (i5 != 0 && (i5 == 1 || (i5 == 3 ? DrawableCompat.getLayoutDirection(this) == 0 : DrawableCompat.getLayoutDirection(this) == 1))) {
            z3 = true;
        }
        float f6 = this.mArrowHeadLength;
        float lerp = lerp(this.mBarLength, (float) Math.sqrt(f6 * f6 * 2.0f), this.mProgress);
        float lerp2 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
        float round = Math.round(lerp(0.0f, this.mMaxCutForBarSize, this.mProgress));
        float lerp3 = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
        if (z3) {
            f4 = 0.0f;
        } else {
            f4 = -180.0f;
        }
        if (z3) {
            f5 = 180.0f;
        } else {
            f5 = 0.0f;
        }
        float lerp4 = lerp(f4, f5, this.mProgress);
        double d = lerp;
        double d5 = lerp3;
        boolean z5 = z3;
        float round2 = (float) Math.round(Math.cos(d5) * d);
        float round3 = (float) Math.round(Math.sin(d5) * d);
        this.mPath.rewind();
        float lerp5 = lerp(this.mPaint.getStrokeWidth() + this.mBarGap, -this.mMaxCutForBarSize, this.mProgress);
        float f7 = (-lerp2) / 2.0f;
        this.mPath.moveTo(f7 + round, 0.0f);
        this.mPath.rLineTo(lerp2 - (round * 2.0f), 0.0f);
        this.mPath.moveTo(f7, lerp5);
        this.mPath.rLineTo(round2, round3);
        this.mPath.moveTo(f7, -lerp5);
        this.mPath.rLineTo(round2, -round3);
        this.mPath.close();
        canvas.save();
        float strokeWidth = this.mPaint.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        float f8 = this.mBarGap;
        canvas.translate(bounds.centerX(), (strokeWidth * 1.5f) + f8 + ((((int) (height - (2.0f * f8))) / 4) * 2));
        if (this.mSpin) {
            if (this.mVerticalMirror ^ z5) {
                i3 = -1;
            } else {
                i3 = 1;
            }
            canvas.rotate(lerp4 * i3);
        } else if (z5) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.restore();
    }

    public float getArrowHeadLength() {
        return this.mArrowHeadLength;
    }

    public float getArrowShaftLength() {
        return this.mArrowShaftLength;
    }

    public float getBarLength() {
        return this.mBarLength;
    }

    public float getBarThickness() {
        return this.mPaint.getStrokeWidth();
    }

    @ColorInt
    public int getColor() {
        return this.mPaint.getColor();
    }

    public int getDirection() {
        return this.mDirection;
    }

    public float getGapSize() {
        return this.mBarGap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.mProgress;
    }

    public boolean isSpinEnabled() {
        return this.mSpin;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i3);
            invalidateSelf();
        }
    }

    public void setArrowHeadLength(float f4) {
        if (this.mArrowHeadLength != f4) {
            this.mArrowHeadLength = f4;
            invalidateSelf();
        }
    }

    public void setArrowShaftLength(float f4) {
        if (this.mArrowShaftLength != f4) {
            this.mArrowShaftLength = f4;
            invalidateSelf();
        }
    }

    public void setBarLength(float f4) {
        if (this.mBarLength != f4) {
            this.mBarLength = f4;
            invalidateSelf();
        }
    }

    public void setBarThickness(float f4) {
        if (this.mPaint.getStrokeWidth() != f4) {
            this.mPaint.setStrokeWidth(f4);
            this.mMaxCutForBarSize = (float) (Math.cos(ARROW_HEAD_ANGLE) * (f4 / 2.0f));
            invalidateSelf();
        }
    }

    public void setColor(@ColorInt int i3) {
        if (i3 != this.mPaint.getColor()) {
            this.mPaint.setColor(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDirection(int i3) {
        if (i3 != this.mDirection) {
            this.mDirection = i3;
            invalidateSelf();
        }
    }

    public void setGapSize(float f4) {
        if (f4 != this.mBarGap) {
            this.mBarGap = f4;
            invalidateSelf();
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (this.mProgress != f4) {
            this.mProgress = f4;
            invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean z3) {
        if (this.mSpin != z3) {
            this.mSpin = z3;
            invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean z3) {
        if (this.mVerticalMirror != z3) {
            this.mVerticalMirror = z3;
            invalidateSelf();
        }
    }
}
