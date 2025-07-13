package moe.codeest.enviews;

import a1.i;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import l3.l;
import x4.d;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ENPlayView extends View {

    /* renamed from: a  reason: collision with root package name */
    public int f2888a;
    public final Paint b;
    public final Paint c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f2889e;

    /* renamed from: f  reason: collision with root package name */
    public int f2890f;

    /* renamed from: g  reason: collision with root package name */
    public int f2891g;

    /* renamed from: h  reason: collision with root package name */
    public int f2892h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f2893i;

    /* renamed from: j  reason: collision with root package name */
    public RectF f2894j;

    /* renamed from: k  reason: collision with root package name */
    public float f2895k;

    /* renamed from: l  reason: collision with root package name */
    public final Path f2896l;

    /* renamed from: m  reason: collision with root package name */
    public final Path f2897m;

    /* renamed from: n  reason: collision with root package name */
    public final PathMeasure f2898n;

    /* renamed from: o  reason: collision with root package name */
    public float f2899o;

    /* renamed from: p  reason: collision with root package name */
    public int f2900p;

    public ENPlayView(Context context) {
        super(context);
        this.f2888a = 1;
        this.f2895k = 1.0f;
    }

    public final void a() {
        if (this.f2888a == 1) {
            return;
        }
        this.f2888a = 1;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 100.0f);
        ofFloat.setDuration(this.f2900p);
        ofFloat.setInterpolator(new AnticipateInterpolator());
        ofFloat.addUpdateListener(new d(this, 1));
        if (!ofFloat.isRunning()) {
            ofFloat.start();
        }
    }

    public int getCurrentState() {
        return this.f2888a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.f2890f, this.f2891g, this.d / 2, this.c);
        float f4 = this.f2895k;
        Paint paint = this.b;
        if (f4 < 0.0f) {
            int i3 = this.f2890f;
            int i5 = this.f2892h;
            int i6 = this.f2891g;
            canvas.drawLine(i3 + i5, (i6 - (i5 * 1.6f)) + (i5 * 10 * f4), i3 + i5, (i5 * 1.6f) + i6 + (i5 * 10 * f4), paint);
            int i7 = this.f2890f;
            int i8 = this.f2892h;
            int i9 = this.f2891g;
            canvas.drawLine(i7 - i8, i9 - (i8 * 1.6f), i7 - i8, (i8 * 1.6f) + i9, paint);
            canvas.drawArc(this.f2894j, -105.0f, 360.0f, false, paint);
        } else if (f4 <= 0.3d) {
            int i10 = this.f2890f;
            int i11 = this.f2892h;
            int i12 = this.f2891g;
            canvas.drawLine(i10 + i11, (i12 - (i11 * 1.6f)) + (((i11 * 3.2f) / 0.3f) * f4), i10 + i11, (i11 * 1.6f) + i12, paint);
            int i13 = this.f2890f;
            int i14 = this.f2892h;
            int i15 = this.f2891g;
            canvas.drawLine(i13 - i14, i15 - (i14 * 1.6f), i13 - i14, (i14 * 1.6f) + i15, paint);
            float f5 = this.f2895k;
            if (f5 != 0.0f) {
                canvas.drawArc(this.f2893i, 0.0f, f5 * 600.0f, false, paint);
            }
            RectF rectF = this.f2894j;
            float f6 = this.f2895k;
            canvas.drawArc(rectF, (f6 * 360.0f) - 105.0f, (1.0f - f6) * 360.0f, false, paint);
        } else {
            PathMeasure pathMeasure = this.f2898n;
            Path path = this.f2897m;
            if (f4 <= 0.6d) {
                canvas.drawArc(this.f2893i, (f4 - 0.3f) * 600.0f, 180.0f - ((f4 - 0.3f) * 600.0f), false, paint);
                path.reset();
                float f7 = this.f2899o;
                float f8 = this.f2895k;
                pathMeasure.getSegment(0.02f * f7, i.b(f8, 0.3f, (f7 * 0.42f) / 0.3f, 0.38f * f7), path, true);
                canvas.drawPath(path, paint);
                RectF rectF2 = this.f2894j;
                float f9 = this.f2895k;
                canvas.drawArc(rectF2, (f9 * 360.0f) - 105.0f, (1.0f - f9) * 360.0f, false, paint);
            } else if (f4 <= 0.8d) {
                path.reset();
                float f10 = this.f2899o;
                float f11 = this.f2895k;
                pathMeasure.getSegment(i.b(f11, 0.6f, (f10 * 0.2f) / 0.2f, 0.02f * f10), i.b(f11, 0.6f, (f10 * 0.2f) / 0.2f, 0.8f * f10), path, true);
                canvas.drawPath(path, paint);
                RectF rectF3 = this.f2894j;
                float f12 = this.f2895k;
                canvas.drawArc(rectF3, (f12 * 360.0f) - 105.0f, (1.0f - f12) * 360.0f, false, paint);
            } else {
                path.reset();
                pathMeasure.getSegment((this.f2895k - 1.0f) * this.f2892h * 10, this.f2899o, path, true);
                canvas.drawPath(path, paint);
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i5, int i6, int i7) {
        int i8;
        int i9;
        super.onSizeChanged(i3, i5, i6, i7);
        int i10 = (i3 * 9) / 10;
        this.d = i10;
        this.f2889e = (i5 * 9) / 10;
        this.f2892h = i10 / ((int) TypedValue.applyDimension(1, 4, getContext().getResources().getDisplayMetrics()));
        this.f2890f = i3 / 2;
        this.f2891g = i5 / 2;
        int i11 = this.f2890f;
        int i12 = this.f2892h;
        float f4 = this.f2891g;
        float f5 = i12;
        this.f2893i = new RectF(i11 - i12, (0.6f * f5) + f4, i11 + i12, (f5 * 2.6f) + f4);
        int i13 = this.f2890f;
        int i14 = this.d / 2;
        int i15 = this.f2891g;
        int i16 = this.f2889e / 2;
        this.f2894j = new RectF(i13 - i14, i15 - i16, i14 + i13, i16 + i15);
        Path path = this.f2896l;
        int i17 = this.f2890f;
        path.moveTo(i17 - i8, (this.f2892h * 1.8f) + this.f2891g);
        int i18 = this.f2890f;
        path.lineTo(i18 - i9, this.f2891g - (this.f2892h * 1.8f));
        path.lineTo(this.f2890f + this.f2892h, this.f2891g);
        path.close();
        PathMeasure pathMeasure = this.f2898n;
        pathMeasure.setPath(path, false);
        this.f2899o = pathMeasure.getLength();
    }

    public void setDuration(int i3) {
        this.f2900p = i3;
    }

    public ENPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2888a = 1;
        this.f2895k = 1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.play);
        int color = obtainStyledAttributes.getColor(l.play_play_line_color, -1);
        int color2 = obtainStyledAttributes.getColor(l.play_play_bg_line_color, -328966);
        float f4 = 4;
        int integer = obtainStyledAttributes.getInteger(l.play_play_line_width, (int) TypedValue.applyDimension(1, f4, getContext().getResources().getDisplayMetrics()));
        int integer2 = obtainStyledAttributes.getInteger(l.play_play_bg_line_width, (int) TypedValue.applyDimension(1, f4, getContext().getResources().getDisplayMetrics()));
        obtainStyledAttributes.recycle();
        setLayerType(1, null);
        Paint paint = new Paint(1);
        this.b = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint.setColor(color);
        paint.setStrokeWidth(integer);
        paint.setPathEffect(new CornerPathEffect(1.0f));
        Paint paint2 = new Paint(1);
        this.c = paint2;
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        paint2.setColor(color2);
        paint2.setStrokeWidth(integer2);
        this.f2896l = new Path();
        this.f2897m = new Path();
        this.f2898n = new PathMeasure();
        this.f2900p = 1200;
    }
}
