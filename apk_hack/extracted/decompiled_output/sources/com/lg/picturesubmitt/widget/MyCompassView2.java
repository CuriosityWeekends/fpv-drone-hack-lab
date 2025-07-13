package com.lg.picturesubmitt.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import s2.d;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MyCompassView2 extends View {

    /* renamed from: a  reason: collision with root package name */
    public Paint f930a;
    public Paint b;
    public Paint c;
    public Paint d;

    /* renamed from: e  reason: collision with root package name */
    public final int f931e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f932f;

    /* renamed from: g  reason: collision with root package name */
    public float f933g;

    /* renamed from: h  reason: collision with root package name */
    public float f934h;

    /* renamed from: i  reason: collision with root package name */
    public double f935i;

    /* renamed from: j  reason: collision with root package name */
    public double f936j;

    /* renamed from: k  reason: collision with root package name */
    public double f937k;

    public MyCompassView2(Context context) {
        super(context);
        this.f931e = 10;
        this.f935i = 0.0d;
        this.f936j = 0.0d;
        this.f937k = 0.0d;
        a(null, 0);
    }

    public final void a(AttributeSet attributeSet, int i3) {
        setFocusable(true);
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setColor(-1);
        this.d.setStrokeWidth(2.0f);
        this.d.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint2 = new Paint(1);
        this.f930a = paint2;
        paint2.setColor(-1);
        this.f930a.setStrokeWidth(1.0f);
        Paint paint3 = this.f930a;
        Paint.Style style = Paint.Style.STROKE;
        paint3.setStyle(style);
        Paint paint4 = new Paint(1);
        this.b = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.b.setStrokeWidth(8.0f);
        this.b.setTextSize(16.0f);
        this.b.setColor(-1);
        this.b.setTextAlign(Paint.Align.CENTER);
        Paint paint5 = new Paint(1);
        this.c = paint5;
        paint5.setStrokeWidth(4.0f);
        this.c.setColor(SupportMenu.CATEGORY_MASK);
        this.c.setStyle(style);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.MyCompassView2, i3, 0);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) obtainStyledAttributes.getDrawable(0);
        this.f932f = bitmapDrawable.getBitmap();
        this.f933g = bitmapDrawable.getIntrinsicWidth();
        this.f934h = bitmapDrawable.getIntrinsicHeight();
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth() / 2;
        int measuredHeight = getMeasuredHeight() / 2;
        Math.min(measuredWidth, measuredHeight);
        this.f930a.setColor(550292684);
        Paint paint = this.f930a;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        int i3 = this.f931e;
        int i5 = measuredWidth * 2;
        int i6 = measuredHeight * 2;
        canvas.drawArc(new RectF(i3, i3, i5 - i3, i6 - i3), 0.0f, -180.0f, true, this.f930a);
        this.f930a.setColor(1358954495);
        Paint paint2 = this.f930a;
        Paint.Style style2 = Paint.Style.STROKE;
        paint2.setStyle(style2);
        canvas.drawArc(new RectF(i3, i3, i5 - i3, i6 - i3), 0.0f, -180.0f, false, this.f930a);
        this.f930a.setColor(542478771);
        this.f930a.setStyle(style);
        canvas.drawArc(new RectF(i3, i3, i5 - i3, i6 - i3), 0.0f, 180.0f, true, this.f930a);
        this.f930a.setColor(1358954495);
        this.f930a.setStyle(style2);
        canvas.drawArc(new RectF(i3, i3, i5 - i3, i6 - i3), 0.0f, 180.0f, false, this.f930a);
        this.f930a.setColor(1358954495);
        float f4 = measuredWidth;
        canvas.drawLine(f4, i3, f4, i6 - i3, this.f930a);
        float f5 = measuredHeight;
        canvas.drawLine(i3, f5, i5 - i3, f5, this.f930a);
        Point point = new Point(measuredWidth - 3, i3);
        Point point2 = new Point(measuredWidth + 3, i3);
        Point point3 = new Point(measuredWidth, i3 + 5);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(point2.x, point2.y);
        path.lineTo(point3.x, point3.y);
        path.lineTo(point.x, point.y);
        path.close();
        canvas.drawPath(path, this.c);
        double d = this.f936j;
        double d5 = this.f935i;
        this.f937k = d + d5;
        this.f935i = Math.toRadians(d5);
        double d6 = measuredWidth;
        double d7 = measuredHeight;
        RectF rectF = new RectF(((float) ((Math.cos(this.f935i) * (measuredWidth - i3)) + d6)) - i3, ((float) ((Math.sin(this.f935i) * (measuredHeight - i3)) + d7)) - i3, (float) ((Math.cos(this.f935i) * (measuredWidth - i3)) + d6 + i3), ((float) ((Math.sin(this.f935i) * (measuredHeight - i3)) + d7)) + i3);
        this.f930a.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f930a.setStyle(style);
        canvas.drawCircle((float) ((Math.cos(this.f935i) * (measuredWidth - i3)) + d6), (float) ((Math.sin(this.f935i) * (measuredHeight - i3)) + d7), i3, this.f930a);
        Paint.FontMetrics fontMetrics = this.b.getFontMetrics();
        float f6 = fontMetrics.bottom;
        canvas.drawText("N", rectF.centerX(), rectF.centerY() + (((f6 - fontMetrics.top) / 2.0f) - f6), this.b);
        canvas.save();
        canvas.rotate((float) this.f937k, f4, f5);
        Bitmap bitmap = this.f932f;
        float f7 = this.f933g;
        float f8 = this.f934h;
        canvas.drawBitmap(bitmap, (Rect) null, new RectF((f4 - (f7 / 2.0f)) + 26.0f, f5 - (f8 / 2.0f), (f7 / 2.0f) + f4 + 26.0f, (f8 / 2.0f) + f5), (Paint) null);
        canvas.restore();
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i5) {
        View.MeasureSpec.getMode(i3);
        View.MeasureSpec.getSize(i3);
        View.MeasureSpec.getMode(i5);
        View.MeasureSpec.getSize(i5);
        int min = Math.min(200, 200);
        setMeasuredDimension(min, min);
    }

    public void setFlyDistance(double d) {
        invalidate();
    }

    public void setFlyRotate(double d) {
        this.f936j = d;
        invalidate();
    }

    public void setSensorRotate(double d) {
        this.f935i = d + 180.0d;
        invalidate();
    }

    public MyCompassView2(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f931e = 10;
        this.f935i = 0.0d;
        this.f936j = 0.0d;
        this.f937k = 0.0d;
        a(attributeSet, 0);
    }

    public MyCompassView2(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f931e = 10;
        this.f935i = 0.0d;
        this.f936j = 0.0d;
        this.f937k = 0.0d;
        a(attributeSet, i3);
    }
}
