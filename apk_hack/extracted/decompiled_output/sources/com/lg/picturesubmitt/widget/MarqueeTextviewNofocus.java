package com.lg.picturesubmitt.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MarqueeTextviewNofocus extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    public int f924a;
    public float b;
    public float c;
    public final Paint d;

    /* renamed from: e  reason: collision with root package name */
    public float f925e;

    /* renamed from: f  reason: collision with root package name */
    public float f926f;

    /* renamed from: g  reason: collision with root package name */
    public String f927g;

    public MarqueeTextviewNofocus(Context context) {
        this(context, null);
        setSingleLine(true);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int i3 = this.f924a;
        Paint paint = this.d;
        if (i3 == 1) {
            float f4 = this.b;
            if (f4 <= this.f925e + 0.0f) {
                canvas.drawText(this.f927g, 0.0f - f4, 0.0f, paint);
            } else {
                this.b = 0.0f;
            }
        } else {
            float f5 = this.b;
            if (f5 <= this.f926f) {
                canvas.drawText(this.f927g, (-this.f925e) + f5, 0.0f, paint);
            } else {
                this.b = 0.0f;
            }
        }
        this.b += this.c;
        invalidate();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i3, int i5) {
        super.onMeasure(i3, i5);
        StringBuilder sb = new StringBuilder("onMeasure-parentWidth=");
        sb.append(View.MeasureSpec.getSize(i3));
        sb.append("--parentHeight=");
        sb.append(View.MeasureSpec.getSize(i5));
        Log.d("MarqueeTextView", sb.toString());
    }

    public void setScrollDirection(int i3) {
        this.f924a = i3;
    }

    public void setScrollMode(int i3) {
        if (i3 == 0) {
            this.c = 1.0f;
        } else if (i3 == 1) {
            this.c = 2.0f;
        } else {
            this.c = 4.0f;
        }
    }

    public void setTextValue(String str) {
        setText(str);
        this.f927g = str;
        Paint paint = this.d;
        this.f925e = paint.measureText(str);
        this.f926f = paint.measureText(this.f927g) + 0.0f;
        Log.d("MarqueeTextView", "setTextValue--textLength=" + this.f925e + "--viewWidth=0.0--viewTextWidth=" + this.f926f + "--getLeft()=" + getLeft());
    }

    public MarqueeTextviewNofocus(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        setSingleLine(true);
    }

    public MarqueeTextviewNofocus(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f924a = 1;
        this.b = 0.0f;
        this.c = 6.0f;
        this.d = new Paint(1);
        this.f925e = 0.0f;
        this.f926f = 0.0f;
        this.f927g = "";
        setSingleLine(true);
    }
}
