package com.lg.picturesubmitt.widget;

import a1.i;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import x2.g;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MyCloudPlatformView extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f928a;
    public int b;
    public float c;
    public Paint d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f929e;

    public MyCloudPlatformView(Context context) {
        super(context);
        this.c = 0.0f;
        this.f929e = false;
        a();
    }

    public final void a() {
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.d.setColor(-1);
        this.d.setStrokeWidth(3.0f);
        this.d.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("MyCloudPlatformView", "onDraw");
        float f4 = this.c;
        canvas.drawOval(new RectF(0.0f, f4 - 20.0f, this.f928a, f4 + 20.0f), this.d);
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i5) {
        super.onMeasure(i3, i5);
        this.f928a = View.MeasureSpec.getSize(i3);
        this.b = View.MeasureSpec.getSize(i5);
        StringBuilder sb = new StringBuilder("parentWidth=");
        sb.append(this.f928a);
        sb.append("--parentHeight=");
        i.u(sb, this.b, "MyCloudPlatformView");
        this.c = this.b / 2;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    Log.d("MyCloudPlatformView", "ACTION_MOVE");
                    if (this.f929e) {
                        float y3 = motionEvent.getY();
                        this.c = y3;
                        int i3 = this.b;
                        if (y3 > i3 - 20) {
                            this.c = i3 - 20;
                        } else if (y3 < 20.0f) {
                            this.c = 20.0f;
                        }
                        if (this.c > i3 / 2) {
                            throw null;
                        }
                        throw null;
                    }
                }
            } else {
                this.c = this.b / 2;
                throw null;
            }
        } else {
            this.f929e = true;
        }
        return true;
    }

    public MyCloudPlatformView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0.0f;
        this.f929e = false;
        a();
    }

    public MyCloudPlatformView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.c = 0.0f;
        this.f929e = false;
        a();
    }

    public void setOnLocaListener(g gVar) {
    }
}
