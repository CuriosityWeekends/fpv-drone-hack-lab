package com.lg.picturesubmitt.widget;

import a1.i;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import j0.s;
import x2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class FlyPathView extends View {

    /* renamed from: t  reason: collision with root package name */
    public static final /* synthetic */ int f895t = 0;

    /* renamed from: a  reason: collision with root package name */
    public boolean f896a;
    public int b;
    public int c;
    public Paint d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f897e;

    /* renamed from: f  reason: collision with root package name */
    public Path f898f;

    /* renamed from: g  reason: collision with root package name */
    public Canvas f899g;

    /* renamed from: h  reason: collision with root package name */
    public PathMeasure f900h;

    /* renamed from: i  reason: collision with root package name */
    public float[] f901i;

    /* renamed from: j  reason: collision with root package name */
    public float[] f902j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f903k;

    /* renamed from: l  reason: collision with root package name */
    public Rect f904l;

    /* renamed from: m  reason: collision with root package name */
    public int f905m;

    /* renamed from: n  reason: collision with root package name */
    public float f906n;

    /* renamed from: o  reason: collision with root package name */
    public float f907o;

    /* renamed from: p  reason: collision with root package name */
    public volatile float f908p;
    public volatile float q;

    /* renamed from: r  reason: collision with root package name */
    public float f909r;
    public final s s;

    public FlyPathView(Context context) {
        super(context);
        this.f896a = false;
        this.f903k = false;
        this.f905m = 3;
        this.f907o = 0.0f;
        this.f908p = 0.0f;
        this.q = 0.0f;
        this.f909r = 0.0f;
        this.s = new s(this, 11);
        a();
    }

    public final void a() {
        Log.d("FlyPathView", "initView");
        Paint paint = new Paint(1);
        this.d = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.d.setStrokeWidth(20.0f);
        this.d.setColor(SupportMenu.CATEGORY_MASK);
        this.d.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setStrokeJoin(Paint.Join.ROUND);
        this.d.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint(1);
        this.f897e = paint2;
        paint2.setStyle(style);
        this.f897e.setStrokeWidth(1.0f);
        this.f897e.setColor(-16711936);
        this.f897e.setAntiAlias(true);
        this.f900h = new PathMeasure();
        this.f898f = new Path();
        this.f899g = new Canvas();
        this.f901i = new float[2];
        this.f902j = new float[2];
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        BitmapFactory.decodeResource(getResources(), 2131558595, options);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("FlyPathView", "onDraw");
        canvas.drawPath(this.f898f, this.d);
        if (this.f903k) {
            Log.d("FlyPathView", "drawCircle doing circleX=" + this.f908p + " circleY=" + this.q);
            if (this.f906n == this.f908p && this.f907o == this.q) {
                Log.d("FlyPathView", "drawCircle doing circleX=" + this.f908p + " circleY=" + this.q + "   相同");
                return;
            }
            canvas.drawCircle(this.f908p, this.q, 30.0f, this.f897e);
            this.f906n = this.f908p;
            this.f907o = this.q;
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i5) {
        int i6;
        int i7;
        super.onMeasure(i3, i5);
        this.b = getMeasuredWidth();
        this.c = getMeasuredHeight();
        StringBuilder sb = new StringBuilder("onMeasure-mWidth1=");
        sb.append(this.b);
        sb.append("  mHeight=");
        i.u(sb, this.c, "FlyPathView");
        if (!this.f896a && (i6 = this.b) != 0 && (i7 = this.c) != 0) {
            this.f896a = true;
            int min = Math.min(i6, i7);
            i.x("onMeasure-value=", min, "FlyPathView");
            this.f899g.setBitmap(Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888));
            this.f904l = new Rect(0, 0, min, min);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.f904l.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    Log.d("FlyPathView", "onTouchEvent ACTION_MOVE");
                    this.f898f.lineTo(motionEvent.getX(), motionEvent.getY());
                    postInvalidate();
                }
            } else {
                this.f900h.setPath(this.f898f, false);
                if (this.f900h.getLength() > 0.0f) {
                    Log.d("FlyPathView", "onTouchEvent ACTION_UP  --" + this.f900h.getLength());
                    this.f903k = true;
                    this.f909r = 0.0f;
                    this.s.sendEmptyMessage(1);
                }
            }
        } else {
            this.f903k = false;
            this.s.removeMessages(1);
            if (this.f904l.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.f909r = 0.0f;
                this.f898f.reset();
                postInvalidate();
                this.f898f.moveTo(motionEvent.getX(), motionEvent.getY());
                Log.d("FlyPathView", "onTouchEvent ACTION_DOWN");
            }
        }
        return true;
    }

    public void setSpeed(int i3) {
        this.f905m = i3;
    }

    public FlyPathView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f896a = false;
        this.f903k = false;
        this.f905m = 3;
        this.f907o = 0.0f;
        this.f908p = 0.0f;
        this.q = 0.0f;
        this.f909r = 0.0f;
        this.s = new s(this, 11);
        a();
    }

    public FlyPathView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f896a = false;
        this.f903k = false;
        this.f905m = 3;
        this.f907o = 0.0f;
        this.f908p = 0.0f;
        this.q = 0.0f;
        this.f909r = 0.0f;
        this.s = new s(this, 11);
        a();
    }

    public void setOnLocaListener(c cVar) {
    }
}
