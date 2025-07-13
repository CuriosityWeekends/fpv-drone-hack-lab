package com.zhouyou.view.seekbar;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import d4.a;
import d4.b;
import d4.c;
import d4.d;
import d4.e;
import d4.f;
import d4.g;
import d4.h;
import java.math.BigDecimal;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SignSeekBar extends View {
    public final int A;
    public final boolean B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final float G;
    public final float H;
    public float I;
    public float J;
    public float K;
    public boolean L;
    public final int M;
    public boolean N;
    public f O;
    public float P;
    public float Q;
    public final Paint R;
    public final Rect S;
    public boolean T;
    public float U;
    public c V;
    public final String[] W;

    /* renamed from: a  reason: collision with root package name */
    public final float f1554a;
    public final float b;

    /* renamed from: b0  reason: collision with root package name */
    public final boolean f1555b0;
    public float c;

    /* renamed from: c0  reason: collision with root package name */
    public final float f1556c0;
    public final boolean d;

    /* renamed from: d0  reason: collision with root package name */
    public final float f1557d0;

    /* renamed from: e  reason: collision with root package name */
    public final int f1558e;

    /* renamed from: e0  reason: collision with root package name */
    public final boolean f1559e0;

    /* renamed from: f  reason: collision with root package name */
    public final int f1560f;

    /* renamed from: f0  reason: collision with root package name */
    public final boolean f1561f0;

    /* renamed from: g  reason: collision with root package name */
    public final int f1562g;

    /* renamed from: g0  reason: collision with root package name */
    public final boolean f1563g0;

    /* renamed from: h  reason: collision with root package name */
    public final int f1564h;

    /* renamed from: h0  reason: collision with root package name */
    public final Rect f1565h0;

    /* renamed from: i  reason: collision with root package name */
    public final int f1566i;

    /* renamed from: i0  reason: collision with root package name */
    public final RectF f1567i0;

    /* renamed from: j  reason: collision with root package name */
    public final int f1568j;

    /* renamed from: j0  reason: collision with root package name */
    public final int f1569j0;

    /* renamed from: k  reason: collision with root package name */
    public final int f1570k;

    /* renamed from: k0  reason: collision with root package name */
    public final int f1571k0;

    /* renamed from: l  reason: collision with root package name */
    public final int f1572l;

    /* renamed from: l0  reason: collision with root package name */
    public final int f1573l0;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f1574m;

    /* renamed from: m0  reason: collision with root package name */
    public int f1575m0;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f1576n;

    /* renamed from: n0  reason: collision with root package name */
    public final Point f1577n0;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f1578o;

    /* renamed from: o0  reason: collision with root package name */
    public final Point f1579o0;

    /* renamed from: p  reason: collision with root package name */
    public final int f1580p;

    /* renamed from: p0  reason: collision with root package name */
    public final Point f1581p0;
    public final int q;

    /* renamed from: q0  reason: collision with root package name */
    public final Paint f1582q0;

    /* renamed from: r  reason: collision with root package name */
    public final int f1583r;

    /* renamed from: r0  reason: collision with root package name */
    public final Paint f1584r0;
    public final int s;

    /* renamed from: s0  reason: collision with root package name */
    public StaticLayout f1585s0;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f1586t;

    /* renamed from: t0  reason: collision with root package name */
    public final Path f1587t0;

    /* renamed from: u  reason: collision with root package name */
    public final int f1588u;

    /* renamed from: u0  reason: collision with root package name */
    public final Path f1589u0;

    /* renamed from: v  reason: collision with root package name */
    public final int f1590v;

    /* renamed from: v0  reason: collision with root package name */
    public String f1591v0;
    public final boolean w;

    /* renamed from: w0  reason: collision with root package name */
    public final TextPaint f1592w0;

    /* renamed from: x  reason: collision with root package name */
    public final boolean f1593x;

    /* renamed from: x0  reason: collision with root package name */
    public float f1594x0;

    /* renamed from: y  reason: collision with root package name */
    public final boolean f1595y;

    /* renamed from: z  reason: collision with root package name */
    public final long f1596z;

    public SignSeekBar(Context context) {
        this(context, null);
    }

    private String getMaxText() {
        if (this.d) {
            return String.valueOf(BigDecimal.valueOf(this.b).setScale(1, 4).floatValue());
        }
        return String.valueOf((int) this.b);
    }

    private String getMinText() {
        if (this.d) {
            return String.valueOf(BigDecimal.valueOf(this.f1554a).setScale(1, 4).floatValue());
        }
        return String.valueOf((int) this.f1554a);
    }

    public final void a() {
        boolean z3;
        ValueAnimator valueAnimator;
        float f4 = 0.0f;
        int i3 = 0;
        while (i3 <= this.f1572l) {
            float f5 = this.K;
            f4 = (i3 * f5) + this.P;
            float f6 = this.I;
            if (f4 <= f6 && f6 - f4 <= f5) {
                break;
            }
            i3++;
        }
        if (BigDecimal.valueOf(this.I).setScale(1, 4).floatValue() == f4) {
            z3 = true;
        } else {
            z3 = false;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        if (!z3) {
            float f7 = this.I;
            float f8 = this.K;
            if (f7 - f4 <= f8 / 2.0f) {
                valueAnimator = ValueAnimator.ofFloat(f7, f4);
            } else {
                valueAnimator = ValueAnimator.ofFloat(f7, ((i3 + 1) * f8) + this.P);
            }
            valueAnimator.setInterpolator(new LinearInterpolator());
            valueAnimator.addUpdateListener(new a3.f(2, this));
        } else {
            valueAnimator = null;
        }
        if (!z3) {
            animatorSet.setDuration(this.f1596z).playTogether(valueAnimator);
        }
        animatorSet.addListener(new e(this, 1));
        animatorSet.start();
    }

    public final void b() {
        String valueOf;
        String str;
        if (this.w) {
            valueOf = String.valueOf(getProgressFloat());
        } else {
            valueOf = String.valueOf(getProgress());
        }
        if (valueOf != null && (str = this.f1591v0) != null && !str.isEmpty()) {
            String str2 = this.f1591v0;
            valueOf = valueOf.concat(" <small>" + str2 + "</small> ");
        }
        this.f1585s0 = new StaticLayout(Html.fromHtml(valueOf), this.f1592w0, this.F, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    /* JADX WARN: Type inference failed for: r0v48, types: [java.lang.Object, d4.c] */
    public c getConfigBuilder() {
        if (this.V == null) {
            this.V = new Object();
        }
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        this.V.getClass();
        return this.V;
    }

    public float getMax() {
        return this.b;
    }

    public float getMin() {
        return this.f1554a;
    }

    public int getProgress() {
        if (this.f1595y && this.N) {
            float f4 = this.H;
            float f5 = f4 / 2.0f;
            float f6 = this.c;
            float f7 = this.U;
            if (f6 >= f7) {
                if (f6 >= f5 + f7) {
                    float f8 = f7 + f4;
                    this.U = f8;
                    return Math.round(f8);
                }
                return Math.round(f7);
            } else if (f6 >= f7 - f5) {
                return Math.round(f7);
            } else {
                float f9 = f7 - f4;
                this.U = f9;
                return Math.round(f9);
            }
        }
        return Math.round(this.c);
    }

    public float getProgressFloat() {
        return BigDecimal.valueOf(this.c).setScale(1, 4).floatValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x02cf, code lost:
        if (r2 != r35.b) goto L118;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDraw(android.graphics.Canvas r36) {
        /*
            Method dump skipped, instructions count: 1372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zhouyou.view.seekbar.SignSeekBar.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i5) {
        String minText;
        String maxText;
        super.onMeasure(i3, i5);
        int i6 = this.f1564h * 2;
        String str = "j";
        int i7 = this.M;
        Paint paint = this.R;
        Rect rect = this.S;
        boolean z3 = this.f1586t;
        if (z3) {
            paint.setTextSize(this.f1588u);
            paint.getTextBounds("j", 0, 1, rect);
            i6 += rect.height() + i7;
        }
        boolean z5 = this.f1578o;
        int i8 = this.f1580p;
        String[] strArr = this.W;
        boolean z6 = this.f1555b0;
        if (z5 && this.f1583r >= 1) {
            if (z6) {
                str = strArr[0];
            }
            paint.setTextSize(i8);
            paint.getTextBounds(str, 0, str.length(), rect);
            i6 = Math.max(i6, rect.height() + (this.f1564h * 2) + i7);
        }
        int i9 = i6 + this.E;
        boolean z7 = this.B;
        int i10 = this.A;
        if (z7) {
            i9 += i10;
        }
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i3), i9);
        this.P = getPaddingLeft() + this.f1564h;
        this.Q = (getMeasuredWidth() - getPaddingRight()) - this.f1564h;
        if (this.f1578o) {
            paint.setTextSize(i8);
            int i11 = this.f1583r;
            if (i11 == 0) {
                String minText2 = getMinText();
                paint.getTextBounds(minText2, 0, minText2.length(), rect);
                this.P += rect.width() + i7;
                String maxText2 = getMaxText();
                paint.getTextBounds(maxText2, 0, maxText2.length(), rect);
                this.Q -= rect.width() + i7;
            } else if (i11 >= 1) {
                if (z6) {
                    minText = strArr[0];
                } else {
                    minText = getMinText();
                }
                paint.getTextBounds(minText, 0, minText.length(), rect);
                this.P = getPaddingLeft() + Math.max(this.f1564h, rect.width() / 2.0f) + i7;
                if (z6) {
                    maxText = strArr[strArr.length - 1];
                } else {
                    maxText = getMaxText();
                }
                paint.getTextBounds(maxText, 0, maxText.length(), rect);
                this.Q = ((getMeasuredWidth() - getPaddingRight()) - Math.max(this.f1564h, rect.width() / 2.0f)) - i7;
            }
        } else if (z3 && this.f1583r == -1) {
            paint.setTextSize(this.f1588u);
            String minText3 = getMinText();
            paint.getTextBounds(minText3, 0, minText3.length(), rect);
            this.P = getPaddingLeft() + Math.max(this.f1564h, rect.width() / 2.0f) + i7;
            String maxText3 = getMaxText();
            paint.getTextBounds(maxText3, 0, maxText3.length(), rect);
            this.Q = ((getMeasuredWidth() - getPaddingRight()) - Math.max(this.f1564h, rect.width() / 2.0f)) - i7;
        }
        if (this.f1561f0 && !this.f1563g0) {
            float f4 = this.P;
            int paddingLeft = getPaddingLeft();
            int i12 = this.F;
            this.P = Math.max(f4, (i12 / 2) + paddingLeft + i10);
            this.Q = Math.min(this.Q, ((getMeasuredWidth() - getPaddingRight()) - (i12 / 2)) - i10);
        }
        float f5 = this.Q - this.P;
        this.J = f5;
        this.K = (f5 * 1.0f) / this.f1572l;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.c = bundle.getFloat(NotificationCompat.CATEGORY_PROGRESS);
            super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
            setProgress(this.c);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat(NotificationCompat.CATEGORY_PROGRESS, this.c);
        return bundle;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i5, int i6, int i7) {
        super.onSizeChanged(i3, i5, i6, i7);
        post(new d(this, 0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
        if (r0 != 3) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zhouyou.view.seekbar.SignSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnProgressChangedListener(f fVar) {
        this.O = fVar;
    }

    public void setProgress(float f4) {
        this.c = f4;
        if (this.O != null) {
            getProgress();
            getProgressFloat();
            f fVar = this.O;
            getProgress();
            getProgressFloat();
            fVar.getClass();
        }
        postInvalidate();
    }

    public void setUnit(String str) {
        this.f1591v0 = str;
        b();
        invalidate();
        requestLayout();
    }

    public SignSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignSeekBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int i5;
        this.f1583r = -1;
        this.T = true;
        this.f1575m0 = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.SignSeekBar, i3, 0);
        this.f1554a = obtainStyledAttributes.getFloat(b.SignSeekBar_ssb_min, 0.0f);
        this.b = obtainStyledAttributes.getFloat(b.SignSeekBar_ssb_max, 100.0f);
        this.c = obtainStyledAttributes.getFloat(b.SignSeekBar_ssb_progress, this.f1554a);
        this.d = obtainStyledAttributes.getBoolean(b.SignSeekBar_ssb_is_float_type, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(b.SignSeekBar_ssb_track_size, h.a(2));
        this.f1558e = dimensionPixelSize;
        this.M = obtainStyledAttributes.getDimensionPixelSize(b.SignSeekBar_ssb_text_space, h.a(2));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(b.SignSeekBar_ssb_second_track_size, h.a(2) + dimensionPixelSize);
        this.f1560f = dimensionPixelSize2;
        int i6 = b.SignSeekBar_ssb_thumb_radius;
        this.f1562g = obtainStyledAttributes.getDimensionPixelSize(i6, h.a(2) + dimensionPixelSize2);
        this.f1564h = obtainStyledAttributes.getDimensionPixelSize(i6, this.f1560f * 2);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(b.SignSeekBar_ssb_sign_border_size, h.a(1));
        this.A = dimensionPixelSize3;
        this.f1572l = obtainStyledAttributes.getInteger(b.SignSeekBar_ssb_section_count, 10);
        int color = obtainStyledAttributes.getColor(b.SignSeekBar_ssb_track_color, ContextCompat.getColor(context, a.colorPrimary));
        this.f1566i = color;
        int color2 = obtainStyledAttributes.getColor(b.SignSeekBar_ssb_second_track_color, ContextCompat.getColor(context, a.colorAccent));
        this.f1568j = color2;
        this.f1570k = obtainStyledAttributes.getColor(b.SignSeekBar_ssb_thumb_color, color2);
        this.f1578o = obtainStyledAttributes.getBoolean(b.SignSeekBar_ssb_show_section_text, false);
        float f4 = 14;
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(b.SignSeekBar_ssb_section_text_size, (int) TypedValue.applyDimension(2, f4, Resources.getSystem().getDisplayMetrics()));
        this.f1580p = dimensionPixelSize4;
        this.q = obtainStyledAttributes.getColor(b.SignSeekBar_ssb_section_text_color, color);
        boolean z3 = obtainStyledAttributes.getBoolean(b.SignSeekBar_ssb_seek_by_section, false);
        this.f1595y = z3;
        int integer = obtainStyledAttributes.getInteger(b.SignSeekBar_ssb_section_text_position, -1);
        if (integer == 0) {
            this.f1583r = 0;
        } else if (integer == 1) {
            this.f1583r = 1;
        } else if (integer == 2) {
            this.f1583r = 2;
        } else {
            this.f1583r = -1;
        }
        this.s = obtainStyledAttributes.getInteger(b.SignSeekBar_ssb_section_text_interval, 1);
        this.f1586t = obtainStyledAttributes.getBoolean(b.SignSeekBar_ssb_show_thumb_text, false);
        this.f1588u = obtainStyledAttributes.getDimensionPixelSize(b.SignSeekBar_ssb_thumb_text_size, (int) TypedValue.applyDimension(2, f4, Resources.getSystem().getDisplayMetrics()));
        this.f1590v = obtainStyledAttributes.getColor(b.SignSeekBar_ssb_thumb_text_color, color2);
        int color3 = obtainStyledAttributes.getColor(b.SignSeekBar_ssb_sign_color, color2);
        int color4 = obtainStyledAttributes.getColor(b.SignSeekBar_ssb_sign_border_color, color2);
        this.C = color4;
        this.D = obtainStyledAttributes.getColor(b.SignSeekBar_ssb_unusable_color, -7829368);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(b.SignSeekBar_ssb_sign_text_size, (int) TypedValue.applyDimension(2, f4, Resources.getSystem().getDisplayMetrics()));
        this.E = obtainStyledAttributes.getDimensionPixelSize(b.SignSeekBar_ssb_sign_height, h.a(32));
        this.F = obtainStyledAttributes.getDimensionPixelSize(b.SignSeekBar_ssb_sign_width, h.a(72));
        this.f1569j0 = obtainStyledAttributes.getDimensionPixelSize(b.SignSeekBar_ssb_sign_arrow_height, h.a(3));
        this.f1571k0 = obtainStyledAttributes.getDimensionPixelSize(b.SignSeekBar_ssb_sign_arrow_width, h.a(5));
        this.f1573l0 = obtainStyledAttributes.getDimensionPixelSize(b.SignSeekBar_ssb_sign_round, h.a(3));
        int color5 = obtainStyledAttributes.getColor(b.SignSeekBar_ssb_sign_text_color, -1);
        this.f1574m = obtainStyledAttributes.getBoolean(b.SignSeekBar_ssb_show_section_mark, false);
        this.f1576n = obtainStyledAttributes.getBoolean(b.SignSeekBar_ssb_auto_adjust_section_mark, false);
        this.w = obtainStyledAttributes.getBoolean(b.SignSeekBar_ssb_show_progress_in_float, false);
        int integer2 = obtainStyledAttributes.getInteger(b.SignSeekBar_ssb_anim_duration, -1);
        this.f1596z = integer2 < 0 ? 200L : integer2;
        this.f1593x = obtainStyledAttributes.getBoolean(b.SignSeekBar_ssb_touch_to_seek, false);
        this.B = obtainStyledAttributes.getBoolean(b.SignSeekBar_ssb_sign_show_border, false);
        int resourceId = obtainStyledAttributes.getResourceId(b.SignSeekBar_ssb_sides_labels, 0);
        this.f1556c0 = obtainStyledAttributes.getFloat(b.SignSeekBar_ssb_thumb_bg_alpha, 0.2f);
        this.f1557d0 = obtainStyledAttributes.getFloat(b.SignSeekBar_ssb_thumb_ratio, 0.7f);
        this.f1559e0 = obtainStyledAttributes.getBoolean(b.SignSeekBar_ssb_show_thumb_shadow, false);
        this.f1561f0 = obtainStyledAttributes.getBoolean(b.SignSeekBar_ssb_show_sign, false);
        this.f1563g0 = obtainStyledAttributes.getBoolean(b.SignSeekBar_ssb_sign_arrow_autofloat, true);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.R = paint;
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setTextAlign(Paint.Align.CENTER);
        this.S = new Rect();
        if (resourceId > 0) {
            this.W = getResources().getStringArray(resourceId);
        }
        String[] strArr = this.W;
        this.f1555b0 = strArr != null && strArr.length > 0;
        this.f1567i0 = new RectF();
        this.f1565h0 = new Rect();
        this.f1577n0 = new Point();
        this.f1579o0 = new Point();
        this.f1581p0 = new Point();
        Path path = new Path();
        this.f1587t0 = path;
        path.setFillType(Path.FillType.EVEN_ODD);
        this.f1589u0 = new Path();
        Paint paint2 = new Paint(1);
        this.f1582q0 = paint2;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        paint2.setAntiAlias(true);
        paint2.setColor(color3);
        Paint paint3 = new Paint(1);
        this.f1584r0 = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(dimensionPixelSize3);
        paint3.setColor(color4);
        paint3.setAntiAlias(true);
        TextPaint textPaint = new TextPaint(1);
        this.f1592w0 = textPaint;
        textPaint.setStyle(style);
        textPaint.setTextSize(dimensionPixelSize5);
        textPaint.setColor(color5);
        if (this.f1554a == this.b) {
            this.f1554a = 0.0f;
            this.b = 100.0f;
        }
        float f5 = this.f1554a;
        float f6 = this.b;
        if (f5 > f6) {
            this.b = f5;
            this.f1554a = f6;
        }
        float f7 = this.c;
        float f8 = this.f1554a;
        if (f7 < f8) {
            this.c = f8;
        }
        float f9 = this.c;
        float f10 = this.b;
        if (f9 > f10) {
            this.c = f10;
        }
        if (this.f1560f < dimensionPixelSize) {
            i5 = 2;
            this.f1560f = h.a(2) + dimensionPixelSize;
        } else {
            i5 = 2;
        }
        int i7 = this.f1562g;
        int i8 = this.f1560f;
        if (i7 <= i8) {
            this.f1562g = h.a(i5) + i8;
        }
        int i9 = this.f1564h;
        int i10 = this.f1560f;
        if (i9 <= i10) {
            this.f1564h = i10 * 2;
        }
        if (this.f1572l <= 0) {
            this.f1572l = 10;
        }
        float f11 = this.b;
        float f12 = this.f1554a;
        float f13 = f11 - f12;
        this.G = f13;
        float f14 = f13 / this.f1572l;
        this.H = f14;
        if (f14 < 1.0f) {
            this.d = true;
        }
        if (this.d) {
            this.w = true;
        }
        int i11 = this.f1583r;
        if (i11 != -1) {
            this.f1578o = true;
        }
        if (this.f1578o) {
            if (i11 == -1) {
                this.f1583r = 0;
            }
            if (this.f1583r == 2) {
                this.f1574m = true;
            }
        }
        if (this.s < 1) {
            this.s = 1;
        }
        if (this.f1576n && !this.f1574m) {
            this.f1576n = false;
        }
        if (z3) {
            this.U = f12;
            if (this.c != f12) {
                this.U = f14;
            }
            this.f1574m = true;
            this.f1576n = true;
            this.f1593x = false;
        }
        setProgress(this.c);
        if (!this.d && !z3 && (!this.f1578o || this.f1583r != 2)) {
            dimensionPixelSize4 = this.f1588u;
        }
        this.f1588u = dimensionPixelSize4;
    }

    public void setValueFormatListener(g gVar) {
    }
}
