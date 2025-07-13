package r2;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.jaygoo.widget.RangeSeekBar;
import com.jaygoo.widget.VerticalRangeSeekBar;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g extends e {
    public final int R;
    public final VerticalRangeSeekBar S;

    public g(RangeSeekBar rangeSeekBar, AttributeSet attributeSet, boolean z3) {
        super(rangeSeekBar, attributeSet, z3);
        try {
            TypedArray obtainStyledAttributes = this.I.getContext().obtainStyledAttributes(attributeSet, d.VerticalRangeSeekBar);
            this.R = obtainStyledAttributes.getInt(d.VerticalRangeSeekBar_rsb_indicator_text_orientation, 1);
            obtainStyledAttributes.recycle();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        this.S = (VerticalRangeSeekBar) rangeSeekBar;
    }

    @Override // r2.e
    public final void k(Canvas canvas, Paint paint, String str) {
        if (str == null) {
            return;
        }
        if (this.R == 1) {
            paint.setTextSize(this.f3420g);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.f3423j);
            int length = str.length();
            Rect rect = this.L;
            int i3 = 0;
            paint.getTextBounds(str, 0, length, rect);
            int height = rect.height() + this.f3424k + this.f3425l;
            int i5 = this.c;
            if (i5 > height) {
                height = i5;
            }
            int width = rect.width() + this.f3426m + this.f3427n;
            int i6 = this.b;
            if (i6 > width) {
                width = i6;
            }
            int i7 = this.P / 2;
            int i8 = i7 - (height / 2);
            Rect rect2 = this.M;
            rect2.left = i8;
            int i9 = ((this.w - width) - this.Q) - this.d;
            rect2.top = i9;
            rect2.right = i8 + height;
            int i10 = i9 + width;
            rect2.bottom = i10;
            if (this.D == null) {
                int i11 = this.f3419f;
                int i12 = i7 - i11;
                int i13 = i10 - i11;
                int i14 = i11 + i7;
                Path path = this.K;
                path.reset();
                path.moveTo(i7, i10);
                float f4 = i13;
                path.lineTo(i12, f4);
                path.lineTo(i14, f4);
                path.close();
                canvas.drawPath(path, paint);
                int i15 = rect2.bottom;
                int i16 = this.f3419f;
                rect2.bottom = i15 - i16;
                rect2.top -= i16;
            }
            RangeSeekBar rangeSeekBar = this.I;
            int i17 = j4.b.i(rangeSeekBar.getContext(), 1.0f);
            int width2 = (((rect2.width() / 2) - ((int) (rangeSeekBar.getProgressWidth() * this.f3434x))) - rangeSeekBar.getProgressLeft()) + i17;
            int width3 = (((rect2.width() / 2) - ((int) ((1.0f - this.f3434x) * rangeSeekBar.getProgressWidth()))) - rangeSeekBar.getProgressPaddingRight()) + i17;
            if (width2 > 0) {
                rect2.left += width2;
                rect2.right += width2;
            } else if (width3 > 0) {
                rect2.left -= width3;
                rect2.right -= width3;
            }
            Bitmap bitmap = this.D;
            if (bitmap != null) {
                j4.b.j(canvas, paint, bitmap, rect2);
            } else if (this.f3422i > 0.0f) {
                RectF rectF = new RectF(rect2);
                float f5 = this.f3422i;
                canvas.drawRoundRect(rectF, f5, f5, paint);
            } else {
                canvas.drawRect(rect2, paint);
            }
            int width4 = ((((rect2.width() - rect.width()) / 2) + rect2.left) + this.f3424k) - this.f3425l;
            int height2 = ((rect2.bottom - ((rect2.height() - rect.height()) / 2)) + this.f3426m) - this.f3427n;
            paint.setColor(this.f3421h);
            float f6 = width4;
            float width5 = (rect.width() / 2.0f) + f6;
            float f7 = height2;
            float height3 = f7 - (rect.height() / 2.0f);
            if (this.R == 1) {
                VerticalRangeSeekBar verticalRangeSeekBar = this.S;
                if (verticalRangeSeekBar.getOrientation() == 1) {
                    i3 = 90;
                } else if (verticalRangeSeekBar.getOrientation() == 2) {
                    i3 = -90;
                }
            }
            if (i3 != 0) {
                canvas.rotate(i3, width5, height3);
            }
            canvas.drawText(str, f6, f7, paint);
            if (i3 != 0) {
                canvas.rotate(-i3, width5, height3);
                return;
            }
            return;
        }
        super.k(canvas, paint, str);
    }
}
