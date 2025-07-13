package r2;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.jaygoo.widget.RangeSeekBar;
import java.text.DecimalFormat;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class e {
    public final boolean A;
    public Bitmap B;
    public Bitmap C;
    public Bitmap D;
    public ValueAnimator E;
    public String F;
    public final RangeSeekBar I;
    public String J;
    public DecimalFormat O;
    public int P;
    public int Q;

    /* renamed from: a  reason: collision with root package name */
    public final int f3417a;
    public int b;
    public final int c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public int f3418e;

    /* renamed from: f  reason: collision with root package name */
    public int f3419f;

    /* renamed from: g  reason: collision with root package name */
    public final int f3420g;

    /* renamed from: h  reason: collision with root package name */
    public final int f3421h;

    /* renamed from: i  reason: collision with root package name */
    public final float f3422i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3423j;

    /* renamed from: k  reason: collision with root package name */
    public final int f3424k;

    /* renamed from: l  reason: collision with root package name */
    public final int f3425l;

    /* renamed from: m  reason: collision with root package name */
    public final int f3426m;

    /* renamed from: n  reason: collision with root package name */
    public final int f3427n;

    /* renamed from: o  reason: collision with root package name */
    public int f3428o;

    /* renamed from: p  reason: collision with root package name */
    public int f3429p;
    public final int q;

    /* renamed from: r  reason: collision with root package name */
    public final int f3430r;
    public final float s;

    /* renamed from: t  reason: collision with root package name */
    public int f3431t;

    /* renamed from: u  reason: collision with root package name */
    public int f3432u;

    /* renamed from: v  reason: collision with root package name */
    public int f3433v;
    public int w;

    /* renamed from: x  reason: collision with root package name */
    public float f3434x;

    /* renamed from: z  reason: collision with root package name */
    public boolean f3436z;

    /* renamed from: y  reason: collision with root package name */
    public float f3435y = 0.0f;
    public boolean G = false;
    public boolean H = true;
    public final Path K = new Path();
    public final Rect L = new Rect();
    public final Rect M = new Rect();
    public final Paint N = new Paint(1);

    public e(RangeSeekBar rangeSeekBar, AttributeSet attributeSet, boolean z3) {
        this.I = rangeSeekBar;
        this.A = z3;
        TypedArray obtainStyledAttributes = rangeSeekBar.getContext().obtainStyledAttributes(attributeSet, d.RangeSeekBar);
        if (obtainStyledAttributes != null) {
            this.d = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_margin, 0.0f);
            this.f3418e = obtainStyledAttributes.getResourceId(d.RangeSeekBar_rsb_indicator_drawable, 0);
            this.f3417a = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_indicator_show_mode, 1);
            this.b = obtainStyledAttributes.getLayoutDimension(d.RangeSeekBar_rsb_indicator_height, -1);
            this.c = obtainStyledAttributes.getLayoutDimension(d.RangeSeekBar_rsb_indicator_width, -1);
            this.f3420g = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_text_size, j4.b.i(rangeSeekBar.getContext(), 14.0f));
            this.f3421h = obtainStyledAttributes.getColor(d.RangeSeekBar_rsb_indicator_text_color, -1);
            this.f3423j = obtainStyledAttributes.getColor(d.RangeSeekBar_rsb_indicator_background_color, ContextCompat.getColor(rangeSeekBar.getContext(), b.colorAccent));
            this.f3424k = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_padding_left, 0.0f);
            this.f3425l = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_padding_right, 0.0f);
            this.f3426m = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_padding_top, 0.0f);
            this.f3427n = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_padding_bottom, 0.0f);
            this.f3419f = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_arrow_size, 0.0f);
            this.f3428o = obtainStyledAttributes.getResourceId(d.RangeSeekBar_rsb_thumb_drawable, c.rsb_default_thumb);
            this.f3429p = obtainStyledAttributes.getResourceId(d.RangeSeekBar_rsb_thumb_inactivated_drawable, 0);
            this.q = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_thumb_width, j4.b.i(rangeSeekBar.getContext(), 26.0f));
            this.f3430r = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_thumb_height, j4.b.i(rangeSeekBar.getContext(), 26.0f));
            this.s = obtainStyledAttributes.getFloat(d.RangeSeekBar_rsb_thumb_scale_ratio, 1.0f);
            this.f3422i = obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_indicator_radius, 0.0f);
            obtainStyledAttributes.recycle();
        }
        h();
        i();
    }

    public final boolean a(float f4, float f5) {
        int progressWidth = (int) (this.I.getProgressWidth() * this.f3434x);
        if (f4 > this.f3431t + progressWidth && f4 < this.f3432u + progressWidth && f5 > this.f3433v && f5 < this.w) {
            return true;
        }
        return false;
    }

    public final void b(Canvas canvas) {
        if (!this.H) {
            return;
        }
        RangeSeekBar rangeSeekBar = this.I;
        canvas.save();
        canvas.translate((int) (rangeSeekBar.getProgressWidth() * this.f3434x), 0.0f);
        canvas.translate(this.f3431t, 0.0f);
        if (this.f3436z) {
            Paint paint = this.N;
            String str = this.F;
            f[] rangeSeekBarState = rangeSeekBar.getRangeSeekBarState();
            if (TextUtils.isEmpty(str)) {
                if (this.A) {
                    DecimalFormat decimalFormat = this.O;
                    if (decimalFormat != null) {
                        str = decimalFormat.format(rangeSeekBarState[0].b);
                    } else {
                        str = rangeSeekBarState[0].f3437a;
                    }
                } else {
                    DecimalFormat decimalFormat2 = this.O;
                    if (decimalFormat2 != null) {
                        str = decimalFormat2.format(rangeSeekBarState[1].b);
                    } else {
                        str = rangeSeekBarState[1].f3437a;
                    }
                }
            }
            String str2 = this.J;
            if (str2 != null) {
                str = String.format(str2, str);
            }
            k(canvas, paint, str);
        }
        Bitmap bitmap = this.C;
        if (bitmap != null && !this.G) {
            canvas.drawBitmap(bitmap, 0.0f, ((rangeSeekBar.getProgressHeight() - this.Q) / 2.0f) + rangeSeekBar.getProgressTop(), (Paint) null);
        } else {
            Bitmap bitmap2 = this.B;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, 0.0f, ((rangeSeekBar.getProgressHeight() - this.Q) / 2.0f) + rangeSeekBar.getProgressTop(), (Paint) null);
            }
        }
        canvas.restore();
    }

    public final int c() {
        int i3;
        int i5 = this.b;
        if (i5 > 0) {
            if (this.D != null) {
                i3 = this.d;
            } else {
                i5 += this.f3419f;
                i3 = this.d;
            }
        } else if (this.D != null) {
            i5 = j4.b.o("8", this.f3420g).height() + this.f3426m + this.f3427n;
            i3 = this.d;
        } else {
            i5 = j4.b.o("8", this.f3420g).height() + this.f3426m + this.f3427n + this.d;
            i3 = this.f3419f;
        }
        return i5 + i3;
    }

    public final float d() {
        return f() + this.b + this.f3419f + this.d;
    }

    public final Resources e() {
        RangeSeekBar rangeSeekBar = this.I;
        if (rangeSeekBar.getContext() != null) {
            return rangeSeekBar.getContext().getResources();
        }
        return null;
    }

    public final float f() {
        return this.f3430r * this.s;
    }

    public final float g() {
        return this.q * this.s;
    }

    public final void h() {
        int i3 = this.f3418e;
        if (i3 != 0) {
            this.f3418e = i3;
            this.D = BitmapFactory.decodeResource(e(), i3);
        }
        n(this.f3428o, this.q, this.f3430r);
        int i5 = this.f3429p;
        int i6 = this.q;
        int i7 = this.f3430r;
        if (i5 != 0 && e() != null) {
            this.f3429p = i5;
            this.C = j4.b.l(e().getDrawable(i5, null), i6, i7);
        }
    }

    public final void i() {
        this.P = this.q;
        this.Q = this.f3430r;
        if (this.b == -1) {
            this.b = j4.b.o("8", this.f3420g).height() + this.f3426m + this.f3427n;
        }
        if (this.f3419f <= 0) {
            this.f3419f = this.q / 4;
        }
    }

    public final void j() {
        ValueAnimator valueAnimator = this.E;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f3435y, 0.0f);
        this.E = ofFloat;
        ofFloat.addUpdateListener(new a3.f(3, this));
        this.E.addListener(new a3.a(2, this));
        this.E.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k(android.graphics.Canvas r12, android.graphics.Paint r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.e.k(android.graphics.Canvas, android.graphics.Paint, java.lang.String):void");
    }

    public final void l(int i3, int i5) {
        i();
        h();
        float f4 = i3;
        this.f3431t = (int) (f4 - (g() / 2.0f));
        this.f3432u = (int) ((g() / 2.0f) + f4);
        int i6 = this.f3430r / 2;
        this.f3433v = i5 - i6;
        this.w = i6 + i5;
    }

    public final void m(boolean z3) {
        int i3 = this.f3417a;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2 || i3 == 3) {
                    this.f3436z = true;
                    return;
                }
                return;
            }
            this.f3436z = false;
            return;
        }
        this.f3436z = z3;
    }

    public final void n(int i3, int i5, int i6) {
        if (i3 != 0 && e() != null && i5 > 0 && i6 > 0) {
            this.f3428o = i3;
            this.B = j4.b.l(e().getDrawable(i3, null), i5, i6);
        }
    }

    public final void o(float f4) {
        if (f4 < 0.0f) {
            f4 = 0.0f;
        } else if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        this.f3434x = f4;
    }
}
