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
import x2.k;
import x2.l;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class TrackControlPaintView extends View implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final Paint f955a;
    public final Path b;
    public final Bitmap c;
    public final Canvas d;

    /* renamed from: e  reason: collision with root package name */
    public final Bitmap f956e;

    /* renamed from: f  reason: collision with root package name */
    public final int f957f;

    /* renamed from: g  reason: collision with root package name */
    public final int f958g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f959h;

    /* renamed from: i  reason: collision with root package name */
    public final PathMeasure f960i;

    /* renamed from: j  reason: collision with root package name */
    public float f961j;

    /* renamed from: k  reason: collision with root package name */
    public float f962k;

    /* renamed from: l  reason: collision with root package name */
    public final float f963l;

    /* renamed from: m  reason: collision with root package name */
    public ObjectAnimator f964m;

    /* renamed from: n  reason: collision with root package name */
    public ObjectAnimator f965n;

    /* renamed from: o  reason: collision with root package name */
    public k f966o;

    /* renamed from: p  reason: collision with root package name */
    public float f967p;
    public float q;

    /* renamed from: r  reason: collision with root package name */
    public l f968r;
    public float s;

    /* renamed from: t  reason: collision with root package name */
    public float f969t;

    /* renamed from: u  reason: collision with root package name */
    public float f970u;

    /* renamed from: v  reason: collision with root package name */
    public final f f971v;

    public TrackControlPaintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f957f = 0;
        this.f958g = 0;
        this.f959h = false;
        this.f967p = 0.0f;
        this.q = 0.0f;
        this.f968r = l.CONTROL_RANGE_GRADE1;
        this.f969t = 0.0f;
        this.f970u = 0.0f;
        this.f971v = new f(4, this);
        new DisplayMetrics();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        Paint paint = new Paint();
        this.f955a = paint;
        paint.setAntiAlias(true);
        this.f955a.setStrokeWidth(15.0f);
        this.f955a.setDither(true);
        this.f955a.setStyle(Paint.Style.STROKE);
        this.f955a.setColor(SupportMenu.CATEGORY_MASK);
        this.b = new Path();
        this.c = Bitmap.createBitmap(i3, i5, Bitmap.Config.ARGB_8888);
        this.d = new Canvas(this.c);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), 2131558642);
        this.f956e = decodeResource;
        this.f957f = decodeResource.getWidth();
        this.f958g = this.f956e.getHeight();
        this.f960i = new PathMeasure();
        this.f963l = i3 / IjkMediaCodecInfo.RANK_SECURE;
    }

    public final void a() {
        if (this.d != null) {
            ObjectAnimator objectAnimator = this.f965n;
            if (objectAnimator != null) {
                objectAnimator.end();
                this.f965n = null;
            }
            ObjectAnimator objectAnimator2 = this.f964m;
            if (objectAnimator2 != null) {
                this.f959h = false;
                objectAnimator2.end();
                this.f964m = null;
            }
            this.b.reset();
            this.d.drawColor(0, PorterDuff.Mode.CLEAR);
            postInvalidate();
        }
    }

    public float getControlChangePrecetageX() {
        return this.f969t;
    }

    public float getControlChangePrecetageY() {
        return this.f970u;
    }

    public float getPhase() {
        return this.f967p;
    }

    public float getPhase2() {
        return this.q;
    }

    public l getTrackControlGrade() {
        return this.f968r;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.drawPath(this.b, this.f955a);
        if (this.f959h) {
            float[] fArr = new float[2];
            this.f960i.setPath(this.b, false);
            PathMeasure pathMeasure = this.f960i;
            pathMeasure.getPosTan(pathMeasure.getLength() * this.f967p, fArr, null);
            canvas.drawBitmap(this.f956e, fArr[0] - (this.f957f / 2), fArr[1] - (this.f958g / 2), this.f955a);
            if (this.f967p == 1.0f) {
                this.f959h = false;
                this.b.reset();
                this.d.drawColor(0, PorterDuff.Mode.CLEAR);
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        float f4 = this.f963l;
        PathMeasure pathMeasure = this.f960i;
        Path path = this.b;
        Log.e("TrackControlPaintView", "TrackControlPaintView OnTouchEvent");
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    path.quadTo(this.f961j, this.f962k, x3, y3);
                    this.f961j = x3;
                    this.f962k = y3;
                }
            } else {
                this.f959h = true;
                pathMeasure.setPath(path, false);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phase", 0.0f, 1.0f);
                this.f964m = ofFloat;
                ofFloat.setDuration((pathMeasure.getLength() / f4) * this.f968r.f3971a);
                this.f964m.addUpdateListener(this);
                this.f964m.setInterpolator(new LinearInterpolator());
                this.f964m.start();
                ObjectAnimator objectAnimator = this.f965n;
                if (objectAnimator != null) {
                    objectAnimator.end();
                    this.f965n = null;
                }
                PathMeasure pathMeasure2 = new PathMeasure();
                pathMeasure2.setPath(path, false);
                float length = pathMeasure2.getLength();
                this.s = length;
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "phase2", 0.0f, 1.0f);
                this.f965n = ofFloat2;
                ofFloat2.setDuration((length / f4) * this.f968r.f3971a);
                this.f965n.addUpdateListener(this.f971v);
                this.f965n.addListener(new j(this, 0));
                this.f965n.setInterpolator(new LinearInterpolator());
                this.f965n.start();
                pathMeasure.setPath(path, false);
            }
        } else {
            this.f959h = false;
            a();
            this.f961j = x3;
            this.f962k = y3;
            path.moveTo(x3, y3);
        }
        invalidate();
        return true;
    }

    public void setOnLocaListener(k kVar) {
        this.f966o = kVar;
    }

    public void setPhase(float f4) {
        this.f967p = f4;
    }

    public void setPhase2(float f4) {
        this.q = f4;
    }

    public void setTrackColor(int i3) {
        this.f955a.setColor(i3);
    }

    public void setTrackControlGrade(l lVar) {
        this.f968r = lVar;
    }
}
