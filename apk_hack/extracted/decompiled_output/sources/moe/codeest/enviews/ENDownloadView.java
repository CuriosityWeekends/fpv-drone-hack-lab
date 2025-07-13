package moe.codeest.enviews;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;
import l3.l;
import x4.a;
import x4.b;
import x4.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ENDownloadView extends View {

    /* renamed from: t  reason: collision with root package name */
    public static final /* synthetic */ int f2873t = 0;

    /* renamed from: a  reason: collision with root package name */
    public int f2874a;
    public float b;
    public final int c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f2875e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f2876f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f2877g;

    /* renamed from: h  reason: collision with root package name */
    public final Path f2878h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f2879i;

    /* renamed from: j  reason: collision with root package name */
    public RectF f2880j;

    /* renamed from: k  reason: collision with root package name */
    public ValueAnimator f2881k;

    /* renamed from: l  reason: collision with root package name */
    public float f2882l;

    /* renamed from: m  reason: collision with root package name */
    public float f2883m;

    /* renamed from: n  reason: collision with root package name */
    public float f2884n;

    /* renamed from: o  reason: collision with root package name */
    public float f2885o;

    /* renamed from: p  reason: collision with root package name */
    public float f2886p;
    public float q;

    /* renamed from: r  reason: collision with root package name */
    public float f2887r;
    public final int s;

    public ENDownloadView(Context context) {
        super(context);
    }

    public static void a(ENDownloadView eNDownloadView) {
        ValueAnimator valueAnimator = eNDownloadView.f2881k;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            eNDownloadView.f2881k.removeAllUpdateListeners();
            if (eNDownloadView.f2881k.isRunning()) {
                eNDownloadView.f2881k.cancel();
            }
            eNDownloadView.f2881k = null;
        }
        if (eNDownloadView.f2874a == 1) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 100.0f);
            eNDownloadView.f2881k = ofFloat;
            ofFloat.setDuration(eNDownloadView.d);
            eNDownloadView.f2881k.setInterpolator(new LinearInterpolator());
            eNDownloadView.f2881k.addUpdateListener(new a(eNDownloadView, 1));
            eNDownloadView.f2881k.addListener(new b(eNDownloadView, 1));
            eNDownloadView.f2881k.start();
        }
    }

    public final void b() {
        this.f2882l = 0.0f;
        this.f2874a = 0;
        ValueAnimator valueAnimator = this.f2881k;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f2881k.removeAllUpdateListeners();
            if (this.f2881k.isRunning()) {
                this.f2881k.cancel();
            }
            this.f2881k = null;
        }
    }

    public final void c() {
        ValueAnimator valueAnimator = this.f2881k;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f2881k.removeAllUpdateListeners();
            if (this.f2881k.isRunning()) {
                this.f2881k.cancel();
            }
            this.f2881k = null;
        }
        this.f2874a = 1;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 100.0f);
        this.f2881k = ofFloat;
        ofFloat.setDuration(1500L);
        this.f2881k.setInterpolator(new OvershootInterpolator());
        this.f2881k.addUpdateListener(new a(this, 0));
        this.f2881k.addListener(new b(this, 0));
        this.f2881k.start();
    }

    public int getCurrentState() {
        return this.f2874a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i3 = this.f2874a;
        Paint paint = this.f2876f;
        Paint paint2 = this.f2875e;
        if (i3 != 0) {
            int i5 = this.c;
            Paint paint3 = this.f2877g;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        canvas.drawCircle(this.f2884n, this.f2885o, this.q, paint);
                        float f4 = this.f2884n;
                        float f5 = this.f2886p;
                        float f6 = this.f2885o;
                        float f7 = f5 * 0.5f;
                        float f8 = this.f2882l;
                        canvas.drawLine(f4 - f5, f6, (f7 * f8) + (f4 - f7), (f5 * 0.35f * f8) + (f5 * 0.65f) + f6, paint2);
                        float f9 = this.f2884n;
                        float f10 = this.f2886p;
                        float f11 = f10 * 0.5f;
                        float f12 = this.f2882l;
                        float f13 = this.f2885o;
                        float f14 = f10 * 1.3f;
                        canvas.drawLine((f11 * f12) + (f9 - f11), (f10 * 0.65f) + f13 + (f10 * 0.35f * f12), ((1.2f * f10) + f9) - ((0.2f * f10) * f12), (f14 * f12) + (f13 - f14), paint2);
                        float f15 = this.f2884n;
                        float f16 = this.f2886p;
                        float f17 = 0.5f * f16;
                        float f18 = this.f2882l;
                        float f19 = (f17 * f18) + (f15 - f17);
                        float f20 = (0.65f * f16) + this.f2885o;
                        canvas.drawLine(f19, (0.35f * f16 * f18) + f20, f19, f20 - ((f16 * 2.25f) * f18), paint2);
                        return;
                    }
                    return;
                }
                canvas.drawCircle(this.f2884n, this.f2885o, this.q, paint2);
                float f21 = this.f2882l;
                if (f21 <= 0.5d) {
                    float f22 = i5;
                    paint3.setTextSize(f22 - ((f22 / 0.2f) * f21));
                } else {
                    paint3.setTextSize(0.0f);
                }
                float f23 = this.f2884n;
                float f24 = this.f2886p;
                float f25 = this.f2882l;
                float f26 = this.f2885o;
                float f27 = f24 * 0.5f;
                canvas.drawLine((f23 - (f24 * 2.2f)) + (1.2f * f24 * f25), f26, f23 - f27, (f27 * f25 * 1.3f) + f26, paint2);
                float f28 = this.f2884n;
                float f29 = this.f2886p;
                float f30 = 0.5f * f29;
                float f31 = this.f2885o;
                float f32 = this.f2882l;
                float f33 = f29 * f32;
                canvas.drawLine(f28 - f30, (f30 * f32 * 1.3f) + f31, ((2.2f * f29) + f28) - f33, f31 - (f33 * 1.3f), paint2);
                return;
            }
            float f34 = this.f2882l;
            if (f34 <= 0.2d) {
                paint3.setTextSize((i5 / 0.2f) * f34);
            }
            canvas.drawCircle(this.f2884n, this.f2885o, this.q, paint);
            canvas.drawArc(this.f2879i, -90.0f, this.f2882l * 359.99f, false, paint2);
            Path path = this.f2878h;
            path.reset();
            float f35 = this.b + 2.0f;
            this.b = f35;
            float f36 = this.f2884n;
            float f37 = this.f2887r;
            if (f35 > f36 - (6.0f * f37)) {
                this.b = f36 - (f37 * 10.0f);
            }
            path.moveTo(this.b, this.f2885o);
            for (int i6 = 0; i6 < 4; i6++) {
                float f38 = this.f2887r;
                path.rQuadTo(f38, (-(1.0f - this.f2882l)) * f38, f38 * 2.0f, 0.0f);
                float f39 = this.f2887r;
                path.rQuadTo(f39, (1.0f - this.f2882l) * f39, f39 * 2.0f, 0.0f);
            }
            canvas.save();
            canvas.clipRect(this.f2880j);
            canvas.drawPath(path, paint2);
            canvas.restore();
            return;
        }
        float f40 = this.f2882l;
        double d = f40;
        if (d <= 0.4d) {
            canvas.drawCircle(this.f2884n, this.f2885o, this.q, paint);
            float f41 = this.f2884n;
            float f42 = this.f2886p;
            float f43 = this.f2885o;
            canvas.drawLine(f41 - f42, f43, f41, f43 + f42, paint2);
            float f44 = this.f2884n;
            float f45 = this.f2885o;
            float f46 = this.f2886p;
            canvas.drawLine(f44, f45 + f46, f44 + f46, f45, paint2);
            float f47 = this.f2884n;
            float f48 = this.f2885o;
            float f49 = this.f2886p;
            float f50 = ((1.3f * f49) / 0.4f) * this.f2882l;
            canvas.drawLine(f47, (f48 + f49) - f50, f47, (f48 - (f49 * 1.6f)) + f50, paint2);
        } else if (d <= 0.6d) {
            canvas.drawCircle(this.f2884n, this.f2885o, this.q, paint);
            canvas.drawCircle(this.f2884n, this.f2885o - (this.f2886p * 0.3f), 2.0f, paint2);
            float f51 = this.f2884n;
            float f52 = this.f2886p;
            float f53 = this.f2882l - 0.4f;
            float f54 = this.f2885o;
            canvas.drawLine((f51 - f52) - (((f52 * 1.2f) / 0.2f) * f53), f54, f51, (f54 + f52) - ((f52 / 0.2f) * f53), paint2);
            float f55 = this.f2884n;
            float f56 = this.f2885o;
            float f57 = this.f2886p;
            float f58 = this.f2882l - 0.4f;
            canvas.drawLine(f55, (f56 + f57) - ((f57 / 0.2f) * f58), f55 + f57 + (((f57 * 1.2f) / 0.2f) * f58), f56, paint2);
        } else if (f40 <= 1.0f) {
            canvas.drawCircle(this.f2884n, this.f2885o, this.q, paint);
            float f59 = this.f2884n;
            float f60 = this.f2885o;
            float f61 = this.f2886p * 0.3f;
            canvas.drawCircle(f59, (f60 - f61) - ((this.f2882l - 0.6f) * ((this.q - f61) / 0.4f)), 2.0f, paint2);
            float f62 = this.f2884n;
            float f63 = this.f2886p * 2.2f;
            float f64 = this.f2885o;
            canvas.drawLine(f62 - f63, f64, f63 + f62, f64, paint2);
        } else {
            canvas.drawCircle(this.f2884n, this.f2885o, this.q, paint);
            canvas.drawCircle(this.f2884n, (this.f2885o - this.q) - ((this.f2882l - 1.0f) * (this.f2886p * 3.0f)), 3.0f, paint2);
            float f65 = this.f2884n;
            float f66 = this.f2886p * 2.2f;
            float f67 = this.f2885o;
            canvas.drawLine(f65 - f66, f67, f66 + f65, f67, paint2);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i5, int i6, int i7) {
        super.onSizeChanged(i3, i5, i6, i7);
        float f4 = i3;
        float f5 = i5;
        this.f2883m = f5;
        float f6 = f4 / 2.0f;
        this.f2884n = f6;
        this.f2885o = f5 / 2.0f;
        float f7 = (f4 * 5.0f) / 12.0f;
        this.q = f7;
        float f8 = f7 / 3.0f;
        this.f2886p = f8;
        float f9 = (f8 * 4.4f) / 12.0f;
        this.f2887r = f9;
        this.b = f6 - (f9 * 10.0f);
        float f10 = this.f2884n;
        float f11 = this.q;
        float f12 = this.f2885o;
        this.f2879i = new RectF(f10 - f11, f12 - f11, f10 + f11, f12 + f11);
        float f13 = this.f2884n;
        float f14 = this.f2887r * 6.0f;
        this.f2880j = new RectF(f13 - f14, 0.0f, f14 + f13, this.f2883m);
    }

    public ENDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.download);
        int color = obtainStyledAttributes.getColor(l.download_download_line_color, -1);
        int color2 = obtainStyledAttributes.getColor(l.download_download_bg_line_color, -12959931);
        int color3 = obtainStyledAttributes.getColor(l.download_download_text_color, -1);
        int integer = obtainStyledAttributes.getInteger(l.download_download_line_width, 9);
        int integer2 = obtainStyledAttributes.getInteger(l.download_download_bg_line_width, 9);
        int integer3 = obtainStyledAttributes.getInteger(l.download_download_text_size, 14);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.f2875e = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint.setStrokeWidth(integer);
        paint.setColor(color);
        Paint paint2 = new Paint(1);
        this.f2876f = paint2;
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        paint2.setStrokeWidth(integer2);
        paint2.setColor(color2);
        Paint paint3 = new Paint(1);
        this.f2877g = paint3;
        paint3.setColor(color3);
        paint3.setTextSize(integer3);
        paint3.setTextAlign(Paint.Align.CENTER);
        this.f2878h = new Path();
        this.c = integer3;
        this.f2874a = 0;
        this.s = 4;
        this.d = GSYVideoView.CHANGE_DELAY_TIME;
    }

    public void setOnDownloadStateListener(c cVar) {
    }
}
