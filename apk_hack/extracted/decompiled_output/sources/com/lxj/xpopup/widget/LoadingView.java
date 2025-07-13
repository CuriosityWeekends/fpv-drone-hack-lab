package com.lxj.xpopup.widget;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.lxj.xpopup.util.b;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class LoadingView extends View {
    private ArgbEvaluator argbEvaluator;
    float avgAngle;
    float centerX;
    float centerY;
    private int endColor;
    float endX;
    private Runnable increaseTask;
    int lineCount;
    private Paint paint;
    private float radius;
    private float radiusOffset;
    private int startColor;
    float startX;
    private float stokeWidth;
    int time;

    public LoadingView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        start();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.increaseTask);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        for (int i5 = this.lineCount - 1; i5 >= 0; i5--) {
            int abs = Math.abs(this.time + i5);
            this.paint.setColor(((Integer) this.argbEvaluator.evaluate((((abs % i3) + 1) * 1.0f) / this.lineCount, Integer.valueOf(this.startColor), Integer.valueOf(this.endColor))).intValue());
            float f4 = this.startX;
            float f5 = this.centerY;
            canvas.drawLine(f4, f5, this.endX, f5, this.paint);
            canvas.drawCircle(this.startX, this.centerY, this.stokeWidth / 2.0f, this.paint);
            canvas.drawCircle(this.endX, this.centerY, this.stokeWidth / 2.0f, this.paint);
            canvas.rotate(this.avgAngle, this.centerX, this.centerY);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i5, int i6, int i7) {
        super.onSizeChanged(i3, i5, i6, i7);
        float measuredWidth = getMeasuredWidth() / 2.0f;
        this.radius = measuredWidth;
        this.radiusOffset = measuredWidth / 2.5f;
        this.centerX = getMeasuredWidth() / 2.0f;
        this.centerY = getMeasuredHeight() / 2.0f;
        float d = b.d(getContext(), 2.0f);
        this.stokeWidth = d;
        this.paint.setStrokeWidth(d);
        float f4 = this.centerX + this.radiusOffset;
        this.startX = f4;
        this.endX = (this.radius / 3.0f) + f4;
    }

    public void start() {
        removeCallbacks(this.increaseTask);
        postDelayed(this.increaseTask, 80L);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.stokeWidth = 2.0f;
        this.argbEvaluator = new ArgbEvaluator();
        this.startColor = Color.parseColor("#EEEEEE");
        this.endColor = Color.parseColor("#111111");
        this.lineCount = 10;
        this.avgAngle = 360.0f / 10;
        this.time = 0;
        this.increaseTask = new Runnable() { // from class: com.lxj.xpopup.widget.LoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                LoadingView loadingView = LoadingView.this;
                loadingView.time++;
                loadingView.postInvalidate(0, 0, loadingView.getMeasuredWidth(), LoadingView.this.getMeasuredHeight());
                LoadingView loadingView2 = LoadingView.this;
                loadingView2.postDelayed(loadingView2.increaseTask, 80L);
            }
        };
        this.paint = new Paint(1);
        float d = b.d(context, this.stokeWidth);
        this.stokeWidth = d;
        this.paint.setStrokeWidth(d);
    }
}
