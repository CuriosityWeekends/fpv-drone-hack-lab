package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BlankView extends View {
    public int color;
    private Paint paint;
    public int radius;
    private RectF rect;
    public int strokeColor;

    public BlankView(Context context) {
        super(context);
        this.paint = new Paint();
        this.rect = null;
        this.radius = 0;
        this.color = -1;
        this.strokeColor = Color.parseColor("#DDDDDD");
    }

    private void init() {
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(1.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setColor(this.color);
        RectF rectF = this.rect;
        int i3 = this.radius;
        canvas.drawRoundRect(rectF, i3, i3, this.paint);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(this.strokeColor);
        RectF rectF2 = this.rect;
        int i5 = this.radius;
        canvas.drawRoundRect(rectF2, i5, i5, this.paint);
        this.paint.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i5, int i6, int i7) {
        super.onSizeChanged(i3, i5, i6, i7);
        this.rect = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    public BlankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint = new Paint();
        this.rect = null;
        this.radius = 0;
        this.color = -1;
        this.strokeColor = Color.parseColor("#DDDDDD");
        init();
    }

    public BlankView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.paint = new Paint();
        this.rect = null;
        this.radius = 0;
        this.color = -1;
        this.strokeColor = Color.parseColor("#DDDDDD");
        init();
    }
}
