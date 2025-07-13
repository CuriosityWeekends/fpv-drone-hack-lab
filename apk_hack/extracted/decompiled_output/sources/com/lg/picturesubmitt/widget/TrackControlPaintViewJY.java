package com.lg.picturesubmitt.widget;

import a3.f;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.internal.view.SupportMenu;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import x2.j;
import x2.m;
import x2.n;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class TrackControlPaintViewJY extends View implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f972a;
    public final Path b;
    public final Bitmap c;
    public final Canvas d;

    /* renamed from: e  reason: collision with root package name */
    public final Bitmap f973e;

    /* renamed from: f  reason: collision with root package name */
    public final int f974f;

    /* renamed from: g  reason: collision with root package name */
    public final int f975g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f976h;

    /* renamed from: i  reason: collision with root package name */
    public final PathMeasure f977i;

    /* renamed from: j  reason: collision with root package name */
    public float f978j;

    /* renamed from: k  reason: collision with root package name */
    public float f979k;

    /* renamed from: l  reason: collision with root package name */
    public final float f980l;

    /* renamed from: m  reason: collision with root package name */
    public ObjectAnimator f981m;

    /* renamed from: n  reason: collision with root package name */
    public ObjectAnimator f982n;

    /* renamed from: o  reason: collision with root package name */
    public m f983o;

    /* renamed from: p  reason: collision with root package name */
    public float f984p;
    public float q;

    /* renamed from: r  reason: collision with root package name */
    public n f985r;
    public float s;

    /* renamed from: t  reason: collision with root package name */
    public float f986t;

    /* renamed from: u  reason: collision with root package name */
    public float f987u;

    /* renamed from: v  reason: collision with root package name */
    public final f f988v;

    public TrackControlPaintViewJY(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f974f = 0;
        this.f975g = 0;
        this.f976h = false;
        this.f984p = 0.0f;
        this.q = 0.0f;
        this.f985r = n.CONTROL_RANGE_GRADE1;
        this.f986t = 0.0f;
        this.f987u = 0.0f;
        this.f988v = new f(5, this);
        new DisplayMetrics();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        Paint paint = new Paint();
        this.f972a = paint;
        paint.setAntiAlias(true);
        this.f972a.setStrokeWidth(15.0f);
        this.f972a.setDither(true);
        this.f972a.setStyle(Paint.Style.STROKE);
        this.f972a.setColor(SupportMenu.CATEGORY_MASK);
        this.b = new Path();
        this.c = Bitmap.createBitmap(i3, i5, Bitmap.Config.ARGB_8888);
        this.d = new Canvas(this.c);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), 2131558642);
        this.f973e = decodeResource;
        this.f974f = decodeResource.getWidth();
        this.f975g = this.f973e.getHeight();
        this.f977i = new PathMeasure();
        this.f980l = i3 / IjkMediaCodecInfo.RANK_SECURE;
    }

    public final void a() {
        if (this.d != null) {
            ObjectAnimator objectAnimator = this.f982n;
            if (objectAnimator != null) {
                objectAnimator.end();
                this.f982n = null;
            }
            ObjectAnimator objectAnimator2 = this.f981m;
            if (objectAnimator2 != null) {
                this.f976h = false;
                objectAnimator2.end();
                this.f981m = null;
            }
            this.b.reset();
            this.d.drawColor(0, PorterDuff.Mode.CLEAR);
            postInvalidate();
        }
    }

    public float getControlChangePrecetageX() {
        return this.f986t;
    }

    public float getControlChangePrecetageY() {
        return this.f987u;
    }

    public float getPhase() {
        return this.f984p;
    }

    public float getPhase2() {
        return this.q;
    }

    public n getTrackControlGrade() {
        return this.f985r;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.drawPath(this.b, this.f972a);
        if (this.f976h) {
            float[] fArr = new float[2];
            this.f977i.setPath(this.b, false);
            PathMeasure pathMeasure = this.f977i;
            pathMeasure.getPosTan(pathMeasure.getLength() * this.f984p, fArr, null);
            canvas.drawBitmap(this.f973e, fArr[0] - (this.f974f / 2), fArr[1] - (this.f975g / 2), this.f972a);
            if (this.f984p == 1.0f) {
                this.f976h = false;
                this.b.reset();
                this.d.drawColor(0, PorterDuff.Mode.CLEAR);
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        float f4 = this.f980l;
        PathMeasure pathMeasure = this.f977i;
        Path path = this.b;
        Log.e("TrackControlPaintView", "TrackControlPaintView OnTouchEvent");
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    path.quadTo(this.f978j, this.f979k, x3, y3);
                    this.f978j = x3;
                    this.f979k = y3;
                }
            } else {
                this.f976h = true;
                pathMeasure.setPath(path, false);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phase", 0.0f, 1.0f);
                this.f981m = ofFloat;
                ofFloat.setDuration((pathMeasure.getLength() / f4) * this.f985r.f3972a);
                this.f981m.addUpdateListener(this);
                this.f981m.setInterpolator(new LinearInterpolator());
                this.f981m.start();
                ObjectAnimator objectAnimator = this.f982n;
                if (objectAnimator != null) {
                    objectAnimator.end();
                    this.f982n = null;
                }
                PathMeasure pathMeasure2 = new PathMeasure();
                pathMeasure2.setPath(path, false);
                float length = pathMeasure2.getLength();
                this.s = length;
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "phase2", 0.0f, 1.0f);
                this.f982n = ofFloat2;
                ofFloat2.setDuration((length / f4) * this.f985r.f3972a);
                this.f982n.addUpdateListener(this.f988v);
                this.f982n.addListener(new j(this, 1));
                this.f982n.setInterpolator(new LinearInterpolator());
                this.f982n.start();
                pathMeasure.setPath(path, false);
            }
        } else {
            this.f976h = false;
            a();
            this.f978j = x3;
            this.f979k = y3;
            path.moveTo(x3, y3);
        }
        invalidate();
        return true;
    }

    public void setOnLocaListener(m mVar) {
        this.f983o = mVar;
    }

    public void setPhase(float f4) {
        this.f984p = f4;
    }

    public void setPhase2(float f4) {
        this.q = f4;
    }

    public void setTrackColor(int i3) {
        this.f972a.setColor(i3);
    }

    public void setTrackControlGrade(n nVar) {
        this.f985r = nVar;
    }
}
