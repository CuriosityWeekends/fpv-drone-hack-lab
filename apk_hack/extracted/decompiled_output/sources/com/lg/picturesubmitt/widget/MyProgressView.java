package com.lg.picturesubmitt.widget;

import a1.i;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MyProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    public Paint f938a;
    public float b;
    public String c;
    public RectF d;

    public MyProgressView(Context context) {
        super(context);
        this.b = 0.0f;
        this.c = "0%";
        a();
    }

    public final void a() {
        Log.d("MyProgressView", "w=" + getWidth() + "--h=" + getHeight());
        Paint paint = new Paint();
        this.f938a = paint;
        paint.setAntiAlias(true);
        this.f938a.setColor(-3355444);
        this.f938a.setStyle(Paint.Style.FILL);
        this.f938a.setStrokeWidth(8.0f);
        this.f938a.setTextSize(50.0f);
        this.f938a.setTextAlign(Paint.Align.CENTER);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f938a.setColor(Color.argb(44, 88, 88, 88));
        canvas.drawArc(this.d, -90.0f, (this.b / 100.0f) * 360.0f, true, this.f938a);
        this.f938a.setColor(SupportMenu.CATEGORY_MASK);
        canvas.drawText(this.c, getWidth() / 2, getHeight() / 2, this.f938a);
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i5) {
        super.onMeasure(i3, i5);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i5);
        float hypot = (float) Math.hypot(size, size2);
        Log.d("MyProgressView", "parentWidth=" + size + "--parentHeight=" + size2);
        float f4 = (float) (size / 2);
        float f5 = (float) (size2 / 2);
        this.d = new RectF(f4 - hypot, f5 - hypot, f4 + hypot, f5 + hypot);
    }

    public void setProgressValue(int i3) {
        i.x("progress=", i3, "MyProgressView");
        this.b = i3;
        this.c = "图片接收中：" + i3 + "%";
        invalidate();
    }

    public MyProgressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0.0f;
        this.c = "0%";
        a();
    }

    public MyProgressView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.b = 0.0f;
        this.c = "0%";
        a();
    }
}
