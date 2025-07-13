package com.jaygoo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import j4.b;
import r2.d;
import r2.g;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class VerticalRangeSeekBar extends RangeSeekBar {

    /* renamed from: b0  reason: collision with root package name */
    public int f536b0;

    /* renamed from: c0  reason: collision with root package name */
    public int f537c0;

    /* renamed from: d0  reason: collision with root package name */
    public int f538d0;

    public VerticalRangeSeekBar(Context context) {
        this(context, null);
    }

    @Override // com.jaygoo.widget.RangeSeekBar
    public final float c(MotionEvent motionEvent) {
        if (this.f536b0 == 1) {
            return getHeight() - motionEvent.getY();
        }
        return motionEvent.getY();
    }

    @Override // com.jaygoo.widget.RangeSeekBar
    public final float d(MotionEvent motionEvent) {
        if (this.f536b0 == 1) {
            return motionEvent.getX();
        }
        return (-motionEvent.getX()) + getWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0111 A[SYNTHETIC] */
    @Override // com.jaygoo.widget.RangeSeekBar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(android.graphics.Canvas r14, android.graphics.Paint r15) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jaygoo.widget.VerticalRangeSeekBar.g(android.graphics.Canvas, android.graphics.Paint):void");
    }

    public int getOrientation() {
        return this.f536b0;
    }

    public int getTickMarkDirection() {
        return this.f537c0;
    }

    @Override // com.jaygoo.widget.RangeSeekBar
    public int getTickMarkRawHeight() {
        int tickMarkTextMargin;
        int i3;
        if (this.f538d0 > 0) {
            tickMarkTextMargin = getTickMarkTextMargin();
            i3 = this.f538d0;
        } else if (getTickMarkTextArray() == null || getTickMarkTextArray().length <= 0) {
            return 0;
        } else {
            int length = getTickMarkTextArray().length;
            this.f538d0 = b.o(String.valueOf(getTickMarkTextArray()[0]), getTickMarkTextSize()).width();
            for (int i5 = 1; i5 < length; i5++) {
                int width = b.o(String.valueOf(getTickMarkTextArray()[i5]), getTickMarkTextSize()).width();
                if (this.f538d0 < width) {
                    this.f538d0 = width;
                }
            }
            tickMarkTextMargin = getTickMarkTextMargin();
            i3 = this.f538d0;
        }
        return tickMarkTextMargin + i3;
    }

    @Override // com.jaygoo.widget.RangeSeekBar, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.f536b0 == 1) {
            canvas.rotate(-90.0f);
            canvas.translate(-getHeight(), 0.0f);
        } else {
            canvas.rotate(90.0f);
            canvas.translate(0.0f, -getWidth());
        }
        super.onDraw(canvas);
    }

    @Override // com.jaygoo.widget.RangeSeekBar, android.view.View
    public final void onMeasure(int i3, int i5) {
        int rawHeight;
        int makeMeasureSpec;
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == 1073741824) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY);
        } else if (mode == Integer.MIN_VALUE && (getParent() instanceof ViewGroup) && size == -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(((ViewGroup) getParent()).getMeasuredHeight(), Integer.MIN_VALUE);
        } else {
            if (getGravity() == 2) {
                rawHeight = getProgressHeight() + (getProgressTop() * 2);
            } else {
                rawHeight = (int) getRawHeight();
            }
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(rawHeight, BasicMeasure.EXACTLY);
        }
        super.onMeasure(makeMeasureSpec, i5);
    }

    @Override // com.jaygoo.widget.RangeSeekBar, android.view.View
    public final void onSizeChanged(int i3, int i5, int i6, int i7) {
        super.onSizeChanged(i5, i3, i7, i6);
    }

    public void setOrientation(int i3) {
        this.f536b0 = i3;
    }

    public void setTickMarkDirection(int i3) {
        this.f537c0 = i3;
    }

    @Override // com.jaygoo.widget.RangeSeekBar
    public void setTickMarkTextArray(CharSequence[] charSequenceArr) {
        super.setTickMarkTextArray(charSequenceArr);
        this.f538d0 = 0;
    }

    @Override // com.jaygoo.widget.RangeSeekBar
    public void setTickMarkTextSize(int i3) {
        super.setTickMarkTextSize(i3);
        this.f538d0 = 0;
    }

    public VerticalRangeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f536b0 = 1;
        this.f537c0 = 1;
        try {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.VerticalRangeSeekBar);
            this.f536b0 = obtainStyledAttributes.getInt(d.VerticalRangeSeekBar_rsb_orientation, 1);
            this.f537c0 = obtainStyledAttributes.getInt(d.VerticalRangeSeekBar_rsb_tick_mark_orientation, 1);
            obtainStyledAttributes.recycle();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        this.P = new g(this, attributeSet, true);
        g gVar = new g(this, attributeSet, false);
        this.Q = gVar;
        gVar.H = getSeekBarMode() != 1;
    }

    @Override // com.jaygoo.widget.RangeSeekBar
    public g getLeftSeekBar() {
        return (g) this.P;
    }

    @Override // com.jaygoo.widget.RangeSeekBar
    public g getRightSeekBar() {
        return (g) this.Q;
    }
}
