package c2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o {
    public float A;
    public int B;
    public int C;
    public int D;
    public int E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;

    /* renamed from: a  reason: collision with root package name */
    public final float f205a;
    public final float b;
    public final float c;
    public final float d;

    /* renamed from: e  reason: collision with root package name */
    public final float f206e;

    /* renamed from: f  reason: collision with root package name */
    public final TextPaint f207f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f208g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f209h;

    /* renamed from: i  reason: collision with root package name */
    public Layout.Alignment f210i;

    /* renamed from: j  reason: collision with root package name */
    public Bitmap f211j;

    /* renamed from: k  reason: collision with root package name */
    public float f212k;

    /* renamed from: l  reason: collision with root package name */
    public int f213l;

    /* renamed from: m  reason: collision with root package name */
    public int f214m;

    /* renamed from: n  reason: collision with root package name */
    public float f215n;

    /* renamed from: o  reason: collision with root package name */
    public int f216o;

    /* renamed from: p  reason: collision with root package name */
    public float f217p;
    public float q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f218r;
    public boolean s;

    /* renamed from: t  reason: collision with root package name */
    public int f219t;

    /* renamed from: u  reason: collision with root package name */
    public int f220u;

    /* renamed from: v  reason: collision with root package name */
    public int f221v;
    public int w;

    /* renamed from: x  reason: collision with root package name */
    public int f222x;

    /* renamed from: y  reason: collision with root package name */
    public float f223y;

    /* renamed from: z  reason: collision with root package name */
    public float f224z;

    public o(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16843287, 16843288}, 0, 0);
        this.f206e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f205a = round;
        this.b = round;
        this.c = round;
        TextPaint textPaint = new TextPaint();
        this.f207f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f208g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    public final void a(Canvas canvas, boolean z3) {
        int i3;
        if (z3) {
            StaticLayout staticLayout = this.F;
            if (staticLayout != null) {
                int save = canvas.save();
                canvas.translate(this.G, this.H);
                if (Color.alpha(this.f221v) > 0) {
                    Paint paint = this.f208g;
                    paint.setColor(this.f221v);
                    canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), paint);
                }
                int i5 = this.f222x;
                TextPaint textPaint = this.f207f;
                boolean z5 = true;
                if (i5 == 1) {
                    textPaint.setStrokeJoin(Paint.Join.ROUND);
                    textPaint.setStrokeWidth(this.f205a);
                    textPaint.setColor(this.w);
                    textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
                    staticLayout.draw(canvas);
                } else {
                    float f4 = this.b;
                    if (i5 == 2) {
                        float f5 = this.c;
                        textPaint.setShadowLayer(f4, f5, f5, this.w);
                    } else if (i5 == 3 || i5 == 4) {
                        if (i5 != 3) {
                            z5 = false;
                        }
                        int i6 = -1;
                        if (z5) {
                            i3 = -1;
                        } else {
                            i3 = this.w;
                        }
                        if (z5) {
                            i6 = this.w;
                        }
                        float f6 = f4 / 2.0f;
                        textPaint.setColor(this.f219t);
                        textPaint.setStyle(Paint.Style.FILL);
                        float f7 = -f6;
                        textPaint.setShadowLayer(f4, f7, f7, i3);
                        staticLayout.draw(canvas);
                        textPaint.setShadowLayer(f4, f6, f6, i6);
                    }
                }
                textPaint.setColor(this.f219t);
                textPaint.setStyle(Paint.Style.FILL);
                staticLayout.draw(canvas);
                textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                canvas.restoreToCount(save);
                return;
            }
            return;
        }
        this.J.getClass();
        this.f211j.getClass();
        canvas.drawBitmap(this.f211j, (Rect) null, this.J, (Paint) null);
    }
}
