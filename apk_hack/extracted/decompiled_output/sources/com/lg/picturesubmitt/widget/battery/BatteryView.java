package com.lg.picturesubmitt.widget.battery;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import s2.d;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BatteryView extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f1002a;
    public int b;
    public final PaintFlagsDrawFilter c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1003e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1004f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1005g;

    /* renamed from: h  reason: collision with root package name */
    public final int f1006h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1007i;

    /* renamed from: j  reason: collision with root package name */
    public int f1008j;

    /* renamed from: k  reason: collision with root package name */
    public final int f1009k;

    /* renamed from: l  reason: collision with root package name */
    public final Paint f1010l;

    /* renamed from: m  reason: collision with root package name */
    public final RectF f1011m;

    /* renamed from: n  reason: collision with root package name */
    public final RectF f1012n;

    /* renamed from: o  reason: collision with root package name */
    public final Paint f1013o;

    /* renamed from: p  reason: collision with root package name */
    public final RectF f1014p;
    public final int q;

    /* renamed from: r  reason: collision with root package name */
    public final int f1015r;
    public final int s;

    public BatteryView(Context context) {
        super(context);
        this.f1008j = 100;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i3;
        int i5;
        super.onDraw(canvas);
        canvas.setDrawFilter(this.c);
        RectF rectF = this.f1012n;
        int i6 = this.f1002a / 2;
        int i7 = this.f1005g / 2;
        rectF.left = i6 - i7;
        rectF.top = 0.0f;
        rectF.right = i7 + i6;
        int i8 = this.f1006h;
        rectF.bottom = i8;
        RectF rectF2 = this.f1011m;
        int i9 = this.d;
        rectF2.left = i9 / 2;
        rectF2.top = i5 + i8;
        rectF2.right = i3 - i5;
        int i10 = this.b;
        rectF2.bottom = i10 - i5;
        RectF rectF3 = this.f1014p;
        int i11 = this.f1009k;
        rectF3.left = i9 + i11;
        rectF3.top = i8 + i9 + i11 + (((100 - this.f1008j) * (((i10 - i8) - (i11 * 2)) - i9)) / 100);
        rectF3.right = (i3 - i9) - i11;
        rectF3.bottom = (i10 - i9) - i11;
        Paint paint = this.f1010l;
        paint.setStyle(Paint.Style.FILL);
        float f4 = this.f1004f;
        canvas.drawRoundRect(rectF, f4, f4, paint);
        float f5 = rectF.left;
        float f6 = rectF.bottom;
        float f7 = this.f1004f;
        canvas.drawRect(f5, f6 - f7, f5 + f7, f6, paint);
        float f8 = rectF.right;
        float f9 = this.f1004f;
        float f10 = rectF.bottom;
        canvas.drawRect(f8 - f9, f10 - f9, f8, f10, paint);
        paint.setStyle(Paint.Style.STROKE);
        float f11 = this.f1003e;
        canvas.drawRoundRect(rectF2, f11, f11, paint);
        canvas.drawRect(rectF3, this.f1013o);
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i5) {
        super.onMeasure(i3, i5);
        this.f1002a = getMeasuredWidth();
        this.b = getMeasuredHeight();
    }

    public void setLevelHeight(int i3) {
        this.f1008j = i3;
        if (i3 < 0) {
            this.f1008j = 100;
        } else if (i3 > 100) {
            this.f1008j = 100;
        }
        postInvalidate();
    }

    public BatteryView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1008j = 100;
        this.c = new PaintFlagsDrawFilter(0, 3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.BatteryView);
        this.q = obtainStyledAttributes.getColor(3, getResources().getColor(2131034234));
        this.f1015r = obtainStyledAttributes.getColor(5, getResources().getColor(2131034326));
        this.s = obtainStyledAttributes.getColor(4, getResources().getColor(2131034325));
        this.f1003e = obtainStyledAttributes.getDimensionPixelOffset(6, getResources().getDimensionPixelOffset(2131100072));
        obtainStyledAttributes.getDimensionPixelOffset(12, getResources().getDimensionPixelOffset(2131100075));
        obtainStyledAttributes.getDimensionPixelOffset(10, getResources().getDimensionPixelOffset(2131100073));
        this.d = obtainStyledAttributes.getDimensionPixelOffset(11, getResources().getDimensionPixelOffset(2131100074));
        this.f1004f = obtainStyledAttributes.getDimensionPixelOffset(7, getResources().getDimensionPixelOffset(2131100068));
        this.f1005g = obtainStyledAttributes.getDimensionPixelOffset(9, getResources().getDimensionPixelOffset(2131100070));
        this.f1006h = obtainStyledAttributes.getDimensionPixelOffset(8, getResources().getDimensionPixelOffset(2131100069));
        obtainStyledAttributes.getDimensionPixelOffset(1, getResources().getDimensionPixelOffset(2131100065));
        this.f1007i = obtainStyledAttributes.getDimensionPixelOffset(2, getResources().getDimensionPixelOffset(2131100066));
        this.f1009k = obtainStyledAttributes.getDimensionPixelOffset(0, getResources().getDimensionPixelOffset(2131100067));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f1010l = paint;
        paint.setAntiAlias(true);
        paint.setColor(this.f1015r);
        paint.setStrokeWidth(this.d);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f1013o = paint2;
        paint2.setColor(this.f1015r);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeWidth(this.f1007i);
        this.f1011m = new RectF();
        this.f1012n = new RectF();
        this.f1014p = new RectF();
    }
}
