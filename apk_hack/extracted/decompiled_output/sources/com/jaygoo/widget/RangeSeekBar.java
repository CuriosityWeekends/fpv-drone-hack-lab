package com.jaygoo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import j4.b;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import r2.a;
import r2.d;
import r2.e;
import r2.f;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class RangeSeekBar extends View {
    public int A;
    public boolean B;
    public int C;
    public float D;
    public float E;
    public boolean F;
    public float G;
    public float H;
    public boolean I;
    public final Paint J;
    public final RectF K;
    public final RectF L;
    public final Rect M;
    public final RectF N;
    public final Rect O;
    public e P;
    public e Q;
    public e R;
    public Bitmap S;
    public Bitmap T;
    public final ArrayList U;
    public int V;
    public a W;

    /* renamed from: a  reason: collision with root package name */
    public int f513a;
    public int b;
    public int c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f514e;

    /* renamed from: f  reason: collision with root package name */
    public int f515f;

    /* renamed from: g  reason: collision with root package name */
    public int f516g;

    /* renamed from: h  reason: collision with root package name */
    public int f517h;

    /* renamed from: i  reason: collision with root package name */
    public int f518i;

    /* renamed from: j  reason: collision with root package name */
    public int f519j;

    /* renamed from: k  reason: collision with root package name */
    public int f520k;

    /* renamed from: l  reason: collision with root package name */
    public int f521l;

    /* renamed from: m  reason: collision with root package name */
    public CharSequence[] f522m;

    /* renamed from: n  reason: collision with root package name */
    public float f523n;

    /* renamed from: o  reason: collision with root package name */
    public int f524o;

    /* renamed from: p  reason: collision with root package name */
    public int f525p;
    public int q;

    /* renamed from: r  reason: collision with root package name */
    public int f526r;
    public int s;

    /* renamed from: t  reason: collision with root package name */
    public int f527t;

    /* renamed from: u  reason: collision with root package name */
    public float f528u;

    /* renamed from: v  reason: collision with root package name */
    public int f529v;
    public int w;

    /* renamed from: x  reason: collision with root package name */
    public float f530x;

    /* renamed from: y  reason: collision with root package name */
    public float f531y;

    /* renamed from: z  reason: collision with root package name */
    public float f532z;

    public RangeSeekBar(Context context) {
        this(context, null);
    }

    public final float a(float f4) {
        float f5 = 0.0f;
        if (this.R == null) {
            return 0.0f;
        }
        float progressLeft = ((f4 - getProgressLeft()) * 1.0f) / this.f527t;
        if (f4 >= getProgressLeft()) {
            if (f4 > getProgressRight()) {
                f5 = 1.0f;
            } else {
                f5 = progressLeft;
            }
        }
        if (this.f514e == 2) {
            e eVar = this.R;
            e eVar2 = this.P;
            if (eVar == eVar2) {
                float f6 = this.Q.f3434x;
                float f7 = this.H;
                if (f5 > f6 - f7) {
                    return f6 - f7;
                }
                return f5;
            } else if (eVar == this.Q) {
                float f8 = eVar2.f3434x;
                float f9 = this.H;
                if (f5 < f8 + f9) {
                    return f8 + f9;
                }
                return f5;
            } else {
                return f5;
            }
        }
        return f5;
    }

    public final void b(boolean z3) {
        e eVar;
        boolean z5 = false;
        if (z3 && (eVar = this.R) != null) {
            e eVar2 = this.P;
            if (eVar == eVar2) {
                z5 = true;
            }
            eVar2.G = z5;
            if (this.f514e == 2) {
                this.Q.G = !z5;
                return;
            }
            return;
        }
        this.P.G = false;
        if (this.f514e == 2) {
            this.Q.G = false;
        }
    }

    public float c(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    public float d(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    public final void e() {
        if (this.S == null) {
            this.S = b.k(getContext(), this.f527t, this.s, this.q);
        }
        if (this.T == null) {
            this.T = b.k(getContext(), this.f527t, this.s, this.f526r);
        }
    }

    public final void f() {
        if (l() && this.C != 0) {
            ArrayList arrayList = this.U;
            if (arrayList.isEmpty()) {
                Bitmap k5 = b.k(getContext(), (int) this.f530x, (int) this.f531y, this.C);
                for (int i3 = 0; i3 <= this.A; i3++) {
                    arrayList.add(k5);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(android.graphics.Canvas r13, android.graphics.Paint r14) {
        /*
            r12 = this;
            java.lang.CharSequence[] r0 = r12.f522m
            if (r0 == 0) goto Lc0
            int r1 = r12.f527t
            int r0 = r0.length
            r2 = 1
            int r0 = r0 - r2
            int r1 = r1 / r0
            r0 = 0
            r3 = 0
        Lc:
            java.lang.CharSequence[] r4 = r12.f522m
            int r5 = r4.length
            if (r3 >= r5) goto Lc0
            r4 = r4[r3]
            java.lang.String r4 = r4.toString()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L1f
            goto Lbc
        L1f:
            int r5 = r4.length()
            android.graphics.Rect r6 = r12.O
            r14.getTextBounds(r4, r0, r5, r6)
            int r5 = r12.f520k
            r14.setColor(r5)
            int r5 = r12.f515f
            r7 = 1073741824(0x40000000, float:2.0)
            r8 = 2
            if (r5 != r2) goto L60
            int r5 = r12.f518i
            if (r5 != r8) goto L46
            int r5 = r12.getProgressLeft()
            int r7 = r3 * r1
            int r7 = r7 + r5
            int r5 = r6.width()
            int r7 = r7 - r5
        L44:
            float r5 = (float) r7
            goto L9f
        L46:
            if (r5 != r2) goto L58
            int r5 = r12.getProgressLeft()
            int r8 = r3 * r1
            int r8 = r8 + r5
            float r5 = (float) r8
            int r8 = r6.width()
        L54:
            float r8 = (float) r8
            float r8 = r8 / r7
            float r5 = r5 - r8
            goto L9f
        L58:
            int r5 = r12.getProgressLeft()
            int r7 = r3 * r1
            int r7 = r7 + r5
            goto L44
        L60:
            float r5 = java.lang.Float.parseFloat(r4)     // Catch: java.lang.NumberFormatException -> L65
            goto L66
        L65:
            r5 = 0
        L66:
            r2.f[] r9 = r12.getRangeSeekBarState()
            r10 = r9[r0]
            float r10 = r10.b
            int r10 = j4.b.g(r5, r10)
            r11 = -1
            if (r10 == r11) goto L88
            r9 = r9[r2]
            float r9 = r9.b
            int r9 = j4.b.g(r5, r9)
            if (r9 == r2) goto L88
            int r9 = r12.f514e
            if (r9 != r8) goto L88
            int r8 = r12.f521l
            r14.setColor(r8)
        L88:
            int r8 = r12.getProgressLeft()
            float r8 = (float) r8
            int r9 = r12.f527t
            float r9 = (float) r9
            float r10 = r12.D
            float r5 = r5 - r10
            float r5 = r5 * r9
            float r9 = r12.E
            float r9 = r9 - r10
            float r5 = r5 / r9
            float r5 = r5 + r8
            int r8 = r6.width()
            goto L54
        L9f:
            int r7 = r12.f519j
            if (r7 != 0) goto Lac
            int r6 = r12.getProgressTop()
            int r7 = r12.f516g
            int r6 = r6 - r7
        Laa:
            float r6 = (float) r6
            goto Lb9
        Lac:
            int r7 = r12.getProgressBottom()
            int r8 = r12.f516g
            int r7 = r7 + r8
            int r6 = r6.height()
            int r6 = r6 + r7
            goto Laa
        Lb9:
            r13.drawText(r4, r5, r6, r14)
        Lbc:
            int r3 = r3 + 1
            goto Lc
        Lc0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jaygoo.widget.RangeSeekBar.g(android.graphics.Canvas, android.graphics.Paint):void");
    }

    public int getGravity() {
        return this.f529v;
    }

    public e getLeftSeekBar() {
        return this.P;
    }

    public float getMaxProgress() {
        return this.E;
    }

    public float getMinInterval() {
        return this.f528u;
    }

    public float getMinProgress() {
        return this.D;
    }

    public int getProgressBottom() {
        return this.b;
    }

    public int getProgressColor() {
        return this.f524o;
    }

    public int getProgressDefaultColor() {
        return this.f525p;
    }

    public int getProgressDefaultDrawableId() {
        return this.f526r;
    }

    public int getProgressDrawableId() {
        return this.q;
    }

    public int getProgressHeight() {
        return this.s;
    }

    public int getProgressLeft() {
        return this.c;
    }

    public int getProgressPaddingRight() {
        return this.V;
    }

    public float getProgressRadius() {
        return this.f523n;
    }

    public int getProgressRight() {
        return this.d;
    }

    public int getProgressTop() {
        return this.f513a;
    }

    public int getProgressWidth() {
        return this.f527t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, r2.f] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object, r2.f] */
    public f[] getRangeSeekBarState() {
        ?? obj = new Object();
        e eVar = this.P;
        RangeSeekBar rangeSeekBar = eVar.I;
        float maxProgress = ((rangeSeekBar.getMaxProgress() - rangeSeekBar.getMinProgress()) * eVar.f3434x) + rangeSeekBar.getMinProgress();
        obj.b = maxProgress;
        obj.f3437a = String.valueOf(maxProgress);
        if (b.g(obj.b, this.D) == 0) {
            obj.c = true;
        } else if (b.g(obj.b, this.E) == 0) {
            obj.d = true;
        }
        ?? obj2 = new Object();
        if (this.f514e == 2) {
            e eVar2 = this.Q;
            RangeSeekBar rangeSeekBar2 = eVar2.I;
            float maxProgress2 = ((rangeSeekBar2.getMaxProgress() - rangeSeekBar2.getMinProgress()) * eVar2.f3434x) + rangeSeekBar2.getMinProgress();
            obj2.b = maxProgress2;
            obj2.f3437a = String.valueOf(maxProgress2);
            if (b.g(this.Q.f3434x, this.D) == 0) {
                obj2.c = true;
            } else if (b.g(this.Q.f3434x, this.E) == 0) {
                obj2.d = true;
            }
        }
        return new f[]{obj, obj2};
    }

    public float getRawHeight() {
        if (this.f514e == 1) {
            float d = this.P.d();
            if (this.f519j == 1 && this.f522m != null) {
                return (this.s / 2.0f) + (d - (this.P.f() / 2.0f)) + Math.max((this.P.f() - this.s) / 2.0f, getTickMarkRawHeight());
            }
            return d;
        }
        float max = Math.max(this.P.d(), this.Q.d());
        if (this.f519j == 1 && this.f522m != null) {
            float max2 = Math.max(this.P.f(), this.Q.f());
            return (this.s / 2.0f) + (max - (max2 / 2.0f)) + Math.max((max2 - this.s) / 2.0f, getTickMarkRawHeight());
        }
        return max;
    }

    public e getRightSeekBar() {
        return this.Q;
    }

    public int getSeekBarMode() {
        return this.f514e;
    }

    public int getSteps() {
        return this.A;
    }

    public List<Bitmap> getStepsBitmaps() {
        return this.U;
    }

    public int getStepsColor() {
        return this.w;
    }

    public int getStepsDrawableId() {
        return this.C;
    }

    public float getStepsHeight() {
        return this.f531y;
    }

    public float getStepsRadius() {
        return this.f532z;
    }

    public float getStepsWidth() {
        return this.f530x;
    }

    public int getTickMarkGravity() {
        return this.f518i;
    }

    public int getTickMarkInRangeTextColor() {
        return this.f521l;
    }

    public int getTickMarkLayoutGravity() {
        return this.f519j;
    }

    public int getTickMarkMode() {
        return this.f515f;
    }

    public int getTickMarkRawHeight() {
        CharSequence[] charSequenceArr = this.f522m;
        if (charSequenceArr == null || charSequenceArr.length <= 0) {
            return 0;
        }
        return b.o(String.valueOf(charSequenceArr[0]), this.f517h).height() + this.f516g + 3;
    }

    public CharSequence[] getTickMarkTextArray() {
        return this.f522m;
    }

    public int getTickMarkTextColor() {
        return this.f520k;
    }

    public int getTickMarkTextMargin() {
        return this.f516g;
    }

    public int getTickMarkTextSize() {
        return this.f517h;
    }

    public final void h() {
        e eVar = this.R;
        if (eVar != null && eVar.s > 1.0f && this.I) {
            this.I = false;
            eVar.P = eVar.q;
            eVar.Q = eVar.f3430r;
            int progressBottom = eVar.I.getProgressBottom();
            int i3 = eVar.Q;
            int i5 = i3 / 2;
            eVar.f3433v = progressBottom - i5;
            eVar.w = i5 + progressBottom;
            eVar.n(eVar.f3428o, eVar.P, i3);
        }
    }

    public final void i() {
        e eVar = this.R;
        if (eVar != null && eVar.s > 1.0f && !this.I) {
            this.I = true;
            eVar.P = (int) eVar.g();
            eVar.Q = (int) eVar.f();
            int progressBottom = eVar.I.getProgressBottom();
            int i3 = eVar.Q;
            int i5 = i3 / 2;
            eVar.f3433v = progressBottom - i5;
            eVar.w = i5 + progressBottom;
            eVar.n(eVar.f3428o, eVar.P, i3);
        }
    }

    public final void j(float f4, float f5) {
        float min = Math.min(f4, f5);
        float max = Math.max(min, f5);
        float f6 = this.f528u;
        if (max - min < f6) {
            min = max - f6;
        }
        float f7 = this.D;
        if (min >= f7) {
            float f8 = this.E;
            if (max <= f8) {
                float f9 = f8 - f7;
                this.P.f3434x = Math.abs(min - f7) / f9;
                if (this.f514e == 2) {
                    this.Q.f3434x = Math.abs(max - this.D) / f9;
                }
                a aVar = this.W;
                if (aVar != null) {
                    aVar.c(min, max);
                }
                invalidate();
                return;
            }
            throw new IllegalArgumentException("setProgress() max > (preset max - offsetValue) . #max:" + max + " #preset max:" + max);
        }
        throw new IllegalArgumentException("setProgress() min < (preset min - offsetValue) . #min:" + min + " #preset min:" + max);
    }

    public final void k(float f4, float f5, float f6) {
        if (f5 > f4) {
            if (f6 >= 0.0f) {
                float f7 = f5 - f4;
                if (f6 < f7) {
                    this.E = f5;
                    this.D = f4;
                    this.f528u = f6;
                    float f8 = f6 / f7;
                    this.H = f8;
                    if (this.f514e == 2) {
                        e eVar = this.P;
                        float f9 = eVar.f3434x;
                        if (f9 + f8 <= 1.0f) {
                            e eVar2 = this.Q;
                            if (f9 + f8 > eVar2.f3434x) {
                                eVar2.f3434x = f9 + f8;
                            }
                        }
                        float f10 = this.Q.f3434x;
                        if (f10 - f8 >= 0.0f && f10 - f8 < f9) {
                            eVar.f3434x = f10 - f8;
                        }
                    }
                    invalidate();
                    return;
                }
                throw new IllegalArgumentException("setRange() interval must be less than (max - min) ! #minInterval:" + f6 + " #max - min:" + f7);
            }
            throw new IllegalArgumentException("setRange() interval must be greater than zero ! #minInterval:" + f6);
        }
        throw new IllegalArgumentException("setRange() max must be greater than min ! #max:" + f5 + " #min:" + f4);
    }

    public final boolean l() {
        if (this.A >= 1 && this.f531y > 0.0f && this.f530x > 0.0f) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean z3;
        e eVar;
        e eVar2;
        boolean z5;
        e eVar3;
        e eVar4;
        super.onDraw(canvas);
        Paint paint = this.J;
        g(canvas, paint);
        Bitmap bitmap = this.T;
        if (bitmap != null && !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        RectF rectF = this.K;
        if (z3) {
            canvas.drawBitmap(this.T, (Rect) null, rectF, paint);
        } else {
            paint.setColor(this.f525p);
            float f4 = this.f523n;
            canvas.drawRoundRect(rectF, f4, f4, paint);
        }
        int i3 = this.f514e;
        RectF rectF2 = this.L;
        if (i3 == 2) {
            rectF2.top = getProgressTop();
            rectF2.left = (this.f527t * this.P.f3434x) + (this.P.g() / 2.0f) + eVar3.f3431t;
            rectF2.right = (this.f527t * this.Q.f3434x) + (this.Q.g() / 2.0f) + eVar4.f3431t;
            rectF2.bottom = getProgressBottom();
        } else {
            rectF2.top = getProgressTop();
            rectF2.left = (this.P.g() / 2.0f) + eVar.f3431t;
            rectF2.right = (this.f527t * this.P.f3434x) + (this.P.g() / 2.0f) + eVar2.f3431t;
            rectF2.bottom = getProgressBottom();
        }
        Bitmap bitmap2 = this.S;
        if (bitmap2 != null && !bitmap2.isRecycled() && bitmap2.getWidth() > 0 && bitmap2.getHeight() > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            Rect rect = this.M;
            rect.top = 0;
            rect.bottom = this.S.getHeight();
            int width = this.S.getWidth();
            if (this.f514e == 2) {
                float f5 = width;
                rect.left = (int) (this.P.f3434x * f5);
                rect.right = (int) (f5 * this.Q.f3434x);
            } else {
                rect.left = 0;
                rect.right = (int) (width * this.P.f3434x);
            }
            canvas.drawBitmap(this.S, rect, rectF2, (Paint) null);
        } else {
            paint.setColor(this.f524o);
            float f6 = this.f523n;
            canvas.drawRoundRect(rectF2, f6, f6, paint);
        }
        if (l()) {
            int progressWidth = getProgressWidth() / this.A;
            float progressHeight = (this.f531y - getProgressHeight()) / 2.0f;
            for (int i5 = 0; i5 <= this.A; i5++) {
                float progressLeft = ((i5 * progressWidth) + getProgressLeft()) - (this.f530x / 2.0f);
                RectF rectF3 = this.N;
                rectF3.set(progressLeft, getProgressTop() - progressHeight, this.f530x + progressLeft, getProgressBottom() + progressHeight);
                ArrayList arrayList = this.U;
                if (!arrayList.isEmpty() && arrayList.size() > i5) {
                    canvas.drawBitmap((Bitmap) arrayList.get(i5), (Rect) null, rectF3, paint);
                } else {
                    paint.setColor(this.w);
                    float f7 = this.f532z;
                    canvas.drawRoundRect(rectF3, f7, f7, paint);
                }
            }
        }
        e eVar5 = this.P;
        if (eVar5.f3417a == 3) {
            eVar5.m(true);
        }
        this.P.b(canvas);
        if (this.f514e == 2) {
            e eVar6 = this.Q;
            if (eVar6.f3417a == 3) {
                eVar6.m(true);
            }
            this.Q.b(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i5) {
        float rawHeight;
        int makeMeasureSpec;
        float rawHeight2;
        float max;
        int size = View.MeasureSpec.getSize(i5);
        int mode = View.MeasureSpec.getMode(i5);
        if (mode == 1073741824) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY);
        } else if (mode == Integer.MIN_VALUE && (getParent() instanceof ViewGroup) && size == -1) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(((ViewGroup) getParent()).getMeasuredHeight(), Integer.MIN_VALUE);
        } else {
            if (this.f529v == 2) {
                if (this.f522m != null && this.f519j == 1) {
                    rawHeight2 = getRawHeight();
                    max = getTickMarkRawHeight();
                } else {
                    rawHeight2 = getRawHeight();
                    max = Math.max(this.P.f(), this.Q.f()) / 2.0f;
                }
                rawHeight = (rawHeight2 - max) * 2.0f;
            } else {
                rawHeight = getRawHeight();
            }
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) rawHeight, BasicMeasure.EXACTLY);
        }
        super.onMeasure(i3, makeMeasureSpec);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        try {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            k(savedState.f533a, savedState.b, savedState.c);
            j(savedState.f534e, savedState.f535f);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$BaseSavedState, android.os.Parcelable, com.jaygoo.widget.SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        baseSavedState.f533a = this.D;
        baseSavedState.b = this.E;
        baseSavedState.c = this.f528u;
        f[] rangeSeekBarState = getRangeSeekBarState();
        baseSavedState.f534e = rangeSeekBarState[0].b;
        baseSavedState.f535f = rangeSeekBarState[1].b;
        return baseSavedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i5, int i6, int i7) {
        float max;
        super.onSizeChanged(i3, i5, i6, i7);
        int paddingBottom = (i5 - getPaddingBottom()) - getPaddingTop();
        if (i5 > 0) {
            int i8 = this.f529v;
            if (i8 == 0) {
                e eVar = this.P;
                if (eVar.f3417a == 1 && this.Q.f3417a == 1) {
                    max = 0.0f;
                } else {
                    max = Math.max(eVar.c(), this.Q.c());
                }
                float max2 = Math.max(this.P.f(), this.Q.f());
                float f4 = this.s;
                float f5 = max2 - (f4 / 2.0f);
                this.f513a = (int) (((f5 - f4) / 2.0f) + max);
                if (this.f522m != null && this.f519j == 0) {
                    this.f513a = (int) Math.max(getTickMarkRawHeight(), ((f5 - this.s) / 2.0f) + max);
                }
                this.b = this.f513a + this.s;
            } else if (i8 == 1) {
                if (this.f522m != null && this.f519j == 1) {
                    this.b = paddingBottom - getTickMarkRawHeight();
                } else {
                    this.b = (int) ((this.s / 2.0f) + (paddingBottom - (Math.max(this.P.f(), this.Q.f()) / 2.0f)));
                }
                this.f513a = this.b - this.s;
            } else {
                int i9 = this.s;
                int i10 = (paddingBottom - i9) / 2;
                this.f513a = i10;
                this.b = i10 + i9;
            }
            int max3 = ((int) Math.max(this.P.g(), this.Q.g())) / 2;
            this.c = getPaddingLeft() + max3;
            int paddingRight = (i3 - max3) - getPaddingRight();
            this.d = paddingRight;
            this.f527t = paddingRight - this.c;
            this.K.set(getProgressLeft(), getProgressTop(), getProgressRight(), getProgressBottom());
            this.V = i3 - this.d;
            if (this.f523n <= 0.0f) {
                this.f523n = (int) ((getProgressBottom() - getProgressTop()) * 0.45f);
            }
            e();
        }
        k(this.D, this.E, this.f528u);
        int progressTop = (getProgressTop() + getProgressBottom()) / 2;
        this.P.l(getProgressLeft(), progressTop);
        if (this.f514e == 2) {
            this.Q.l(getProgressLeft(), progressTop);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.F) {
            return true;
        }
        int action = motionEvent.getAction();
        float f4 = 1.0f;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        if (this.f514e == 2) {
                            this.Q.m(false);
                        }
                        e eVar = this.R;
                        if (eVar == this.P) {
                            h();
                        } else if (eVar == this.Q) {
                            h();
                        }
                        this.P.m(false);
                        if (this.W != null) {
                            f[] rangeSeekBarState = getRangeSeekBarState();
                            this.W.c(rangeSeekBarState[0].b, rangeSeekBarState[1].b);
                        }
                        if (getParent() != null) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                        b(false);
                    }
                } else {
                    float c = c(motionEvent);
                    if (this.f514e == 2 && this.P.f3434x == this.Q.f3434x) {
                        this.R.j();
                        if (c - this.G > 0.0f) {
                            e eVar2 = this.R;
                            if (eVar2 != this.Q) {
                                eVar2.m(false);
                                h();
                                this.R = this.Q;
                            }
                        } else {
                            e eVar3 = this.R;
                            if (eVar3 != this.P) {
                                eVar3.m(false);
                                h();
                                this.R = this.P;
                            }
                        }
                    }
                    i();
                    e eVar4 = this.R;
                    float f5 = eVar4.f3435y;
                    if (f5 < 1.0f) {
                        f4 = 0.1f + f5;
                    }
                    eVar4.f3435y = f4;
                    this.G = c;
                    eVar4.o(a(c));
                    this.R.m(true);
                    if (this.W != null) {
                        f[] rangeSeekBarState2 = getRangeSeekBarState();
                        this.W.c(rangeSeekBarState2[0].b, rangeSeekBarState2[1].b);
                    }
                    invalidate();
                    if (getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    b(true);
                }
            } else {
                if (l() && this.B) {
                    float a5 = a(c(motionEvent));
                    float f6 = 1.0f / this.A;
                    this.R.o(new BigDecimal(a5 / f6).setScale(0, RoundingMode.HALF_UP).intValue() * f6);
                }
                if (this.f514e == 2) {
                    this.Q.m(false);
                }
                this.P.m(false);
                this.R.j();
                h();
                if (this.W != null) {
                    f[] rangeSeekBarState3 = getRangeSeekBarState();
                    this.W.c(rangeSeekBarState3[0].b, rangeSeekBarState3[1].b);
                }
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                b(false);
            }
            return super.onTouchEvent(motionEvent);
        }
        this.G = c(motionEvent);
        d(motionEvent);
        if (this.f514e == 2) {
            if (this.Q.f3434x >= 1.0f && this.P.a(c(motionEvent), d(motionEvent))) {
                this.R = this.P;
                i();
            } else if (this.Q.a(c(motionEvent), d(motionEvent))) {
                this.R = this.Q;
                i();
            } else {
                float progressLeft = ((this.G - getProgressLeft()) * 1.0f) / this.f527t;
                if (Math.abs(this.P.f3434x - progressLeft) < Math.abs(this.Q.f3434x - progressLeft)) {
                    this.R = this.P;
                } else {
                    this.R = this.Q;
                }
                this.R.o(a(this.G));
            }
        } else {
            this.R = this.P;
            i();
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        b(true);
        return true;
    }

    public void setEnableThumbOverlap(boolean z3) {
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        this.F = z3;
    }

    public void setGravity(int i3) {
        this.f529v = i3;
    }

    public void setIndicatorText(String str) {
        this.P.F = str;
        if (this.f514e == 2) {
            this.Q.F = str;
        }
    }

    public void setIndicatorTextDecimalFormat(String str) {
        e eVar = this.P;
        eVar.getClass();
        eVar.O = new DecimalFormat(str);
        if (this.f514e == 2) {
            e eVar2 = this.Q;
            eVar2.getClass();
            eVar2.O = new DecimalFormat(str);
        }
    }

    public void setIndicatorTextStringFormat(String str) {
        this.P.J = str;
        if (this.f514e == 2) {
            this.Q.J = str;
        }
    }

    public void setOnRangeChangedListener(a aVar) {
        this.W = aVar;
    }

    public void setProgress(float f4) {
        j(f4, this.E);
    }

    public void setProgressBottom(int i3) {
        this.b = i3;
    }

    public void setProgressColor(@ColorInt int i3) {
        this.f524o = i3;
    }

    public void setProgressDefaultColor(@ColorInt int i3) {
        this.f525p = i3;
    }

    public void setProgressDefaultDrawableId(@DrawableRes int i3) {
        this.f526r = i3;
        this.T = null;
        e();
    }

    public void setProgressDrawableId(@DrawableRes int i3) {
        this.q = i3;
        this.S = null;
        e();
    }

    public void setProgressHeight(int i3) {
        this.s = i3;
    }

    public void setProgressLeft(int i3) {
        this.c = i3;
    }

    public void setProgressRadius(float f4) {
        this.f523n = f4;
    }

    public void setProgressRight(int i3) {
        this.d = i3;
    }

    public void setProgressTop(int i3) {
        this.f513a = i3;
    }

    public void setProgressWidth(int i3) {
        this.f527t = i3;
    }

    public void setSeekBarMode(int i3) {
        this.f514e = i3;
        e eVar = this.Q;
        boolean z3 = true;
        if (i3 == 1) {
            z3 = false;
        }
        eVar.H = z3;
    }

    public void setSteps(int i3) {
        this.A = i3;
    }

    public void setStepsAutoBonding(boolean z3) {
        this.B = z3;
    }

    public void setStepsBitmaps(List<Bitmap> list) {
        if (list != null && !list.isEmpty() && list.size() > this.A) {
            ArrayList arrayList = this.U;
            arrayList.clear();
            arrayList.addAll(list);
            return;
        }
        throw new IllegalArgumentException("stepsBitmaps must > steps !");
    }

    public void setStepsColor(@ColorInt int i3) {
        this.w = i3;
    }

    public void setStepsDrawable(List<Integer> list) {
        if (list != null && !list.isEmpty() && list.size() > this.A) {
            if (l()) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    arrayList.add(b.k(getContext(), (int) this.f530x, (int) this.f531y, list.get(i3).intValue()));
                }
                setStepsBitmaps(arrayList);
                return;
            }
            throw new IllegalArgumentException("stepsWidth must > 0, stepsHeight must > 0,steps must > 0 First!!");
        }
        throw new IllegalArgumentException("stepsDrawableIds must > steps !");
    }

    public void setStepsDrawableId(@DrawableRes int i3) {
        this.U.clear();
        this.C = i3;
        f();
    }

    public void setStepsHeight(float f4) {
        this.f531y = f4;
    }

    public void setStepsRadius(float f4) {
        this.f532z = f4;
    }

    public void setStepsWidth(float f4) {
        this.f530x = f4;
    }

    public void setTickMarkGravity(int i3) {
        this.f518i = i3;
    }

    public void setTickMarkInRangeTextColor(@ColorInt int i3) {
        this.f521l = i3;
    }

    public void setTickMarkLayoutGravity(int i3) {
        this.f519j = i3;
    }

    public void setTickMarkMode(int i3) {
        this.f515f = i3;
    }

    public void setTickMarkTextArray(CharSequence[] charSequenceArr) {
        this.f522m = charSequenceArr;
    }

    public void setTickMarkTextColor(@ColorInt int i3) {
        this.f520k = i3;
    }

    public void setTickMarkTextMargin(int i3) {
        this.f516g = i3;
    }

    public void setTickMarkTextSize(int i3) {
        this.f517h = i3;
    }

    public void setTypeface(Typeface typeface) {
        this.J.setTypeface(typeface);
    }

    public RangeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = true;
        this.I = false;
        this.J = new Paint();
        this.K = new RectF();
        this.L = new RectF();
        this.M = new Rect();
        this.N = new RectF();
        this.O = new Rect();
        this.U = new ArrayList();
        try {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.RangeSeekBar);
            this.f514e = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_mode, 2);
            this.D = obtainStyledAttributes.getFloat(d.RangeSeekBar_rsb_min, 0.0f);
            this.E = obtainStyledAttributes.getFloat(d.RangeSeekBar_rsb_max, 100.0f);
            this.f528u = obtainStyledAttributes.getFloat(d.RangeSeekBar_rsb_min_interval, 0.0f);
            this.f529v = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_gravity, 0);
            this.f524o = obtainStyledAttributes.getColor(d.RangeSeekBar_rsb_progress_color, -11806366);
            this.f523n = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_progress_radius, -1.0f);
            this.f525p = obtainStyledAttributes.getColor(d.RangeSeekBar_rsb_progress_default_color, -2631721);
            this.q = obtainStyledAttributes.getResourceId(d.RangeSeekBar_rsb_progress_drawable, 0);
            this.f526r = obtainStyledAttributes.getResourceId(d.RangeSeekBar_rsb_progress_drawable_default, 0);
            this.s = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_progress_height, b.i(getContext(), 2.0f));
            this.f515f = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_tick_mark_mode, 0);
            this.f518i = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_tick_mark_gravity, 1);
            this.f519j = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_tick_mark_layout_gravity, 0);
            this.f522m = obtainStyledAttributes.getTextArray(d.RangeSeekBar_rsb_tick_mark_text_array);
            this.f516g = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_tick_mark_text_margin, b.i(getContext(), 7.0f));
            this.f517h = (int) obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_tick_mark_text_size, b.i(getContext(), 12.0f));
            int i3 = d.RangeSeekBar_rsb_tick_mark_text_color;
            this.f520k = obtainStyledAttributes.getColor(i3, this.f525p);
            this.f521l = obtainStyledAttributes.getColor(i3, this.f524o);
            this.A = obtainStyledAttributes.getInt(d.RangeSeekBar_rsb_steps, 0);
            this.w = obtainStyledAttributes.getColor(d.RangeSeekBar_rsb_step_color, -6447715);
            this.f532z = obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_step_radius, 0.0f);
            this.f530x = obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_step_width, 0.0f);
            this.f531y = obtainStyledAttributes.getDimension(d.RangeSeekBar_rsb_step_height, 0.0f);
            this.C = obtainStyledAttributes.getResourceId(d.RangeSeekBar_rsb_step_drawable, 0);
            this.B = obtainStyledAttributes.getBoolean(d.RangeSeekBar_rsb_step_auto_bonding, true);
            obtainStyledAttributes.recycle();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        Paint.Style style = Paint.Style.FILL;
        Paint paint = this.J;
        paint.setStyle(style);
        paint.setColor(this.f525p);
        paint.setTextSize(this.f517h);
        this.P = new e(this, attributeSet, true);
        e eVar = new e(this, attributeSet, false);
        this.Q = eVar;
        eVar.H = this.f514e != 1;
        f();
    }
}
