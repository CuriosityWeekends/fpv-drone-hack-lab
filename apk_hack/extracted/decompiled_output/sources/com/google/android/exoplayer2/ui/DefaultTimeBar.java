package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import c2.b;
import c2.d;
import c2.n;
import c2.p;
import g2.w;
import j0.i;
import j0.l0;
import j0.u0;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class DefaultTimeBar extends View implements p {
    public static final /* synthetic */ int M = 0;
    public int A;
    public long B;
    public int C;
    public Rect D;
    public boolean E;
    public long F;
    public long G;
    public long H;
    public long I;
    public int J;
    public long[] K;
    public boolean[] L;

    /* renamed from: a  reason: collision with root package name */
    public final Rect f418a;
    public final Rect b;
    public final Rect c;
    public final Rect d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f419e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f420f;

    /* renamed from: g  reason: collision with root package name */
    public final Paint f421g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f422h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f423i;

    /* renamed from: j  reason: collision with root package name */
    public final Paint f424j;

    /* renamed from: k  reason: collision with root package name */
    public final Drawable f425k;

    /* renamed from: l  reason: collision with root package name */
    public final int f426l;

    /* renamed from: m  reason: collision with root package name */
    public final int f427m;

    /* renamed from: n  reason: collision with root package name */
    public final int f428n;

    /* renamed from: o  reason: collision with root package name */
    public final int f429o;

    /* renamed from: p  reason: collision with root package name */
    public final int f430p;
    public final int q;

    /* renamed from: r  reason: collision with root package name */
    public final int f431r;
    public final int s;

    /* renamed from: t  reason: collision with root package name */
    public final StringBuilder f432t;

    /* renamed from: u  reason: collision with root package name */
    public final Formatter f433u;

    /* renamed from: v  reason: collision with root package name */
    public final b f434v;
    public final CopyOnWriteArraySet w;

    /* renamed from: x  reason: collision with root package name */
    public final int[] f435x;

    /* renamed from: y  reason: collision with root package name */
    public final Point f436y;

    /* renamed from: z  reason: collision with root package name */
    public final float f437z;

    public DefaultTimeBar(Context context) {
        this(context, null);
    }

    public static int a(float f4, int i3) {
        return (int) ((i3 * f4) + 0.5f);
    }

    private long getPositionIncrement() {
        long j2 = this.B;
        if (j2 == -9223372036854775807L) {
            long j5 = this.G;
            if (j5 == -9223372036854775807L) {
                return 0L;
            }
            return j5 / this.A;
        }
        return j2;
    }

    private String getProgressText() {
        return w.p(this.f432t, this.f433u, this.H);
    }

    private long getScrubberPosition() {
        Rect rect = this.b;
        if (rect.width() > 0 && this.G != -9223372036854775807L) {
            return (this.d.width() * this.G) / rect.width();
        }
        return 0L;
    }

    public final boolean b(long j2) {
        long j5;
        long j6 = this.G;
        if (j6 <= 0) {
            return false;
        }
        if (this.E) {
            j5 = this.F;
        } else {
            j5 = this.H;
        }
        long j7 = j5;
        long i3 = w.i(j7 + j2, 0L, j6);
        if (i3 == j7) {
            return false;
        }
        if (!this.E) {
            c(i3);
        } else {
            f(i3);
        }
        e();
        return true;
    }

    public final void c(long j2) {
        this.F = j2;
        this.E = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            PlayerControlView playerControlView = ((d) it.next()).f203a;
            playerControlView.L = true;
            TextView textView = playerControlView.f449m;
            if (textView != null) {
                textView.setText(w.p(playerControlView.f451o, playerControlView.f452p, j2));
            }
        }
    }

    public final void d(boolean z3) {
        l0 l0Var;
        int w;
        removeCallbacks(this.f434v);
        this.E = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            long j2 = this.F;
            PlayerControlView playerControlView = ((d) it.next()).f203a;
            playerControlView.L = false;
            if (!z3 && (l0Var = playerControlView.G) != null) {
                u0 r5 = l0Var.r();
                if (playerControlView.K && !r5.o()) {
                    int n5 = r5.n();
                    w = 0;
                    while (true) {
                        long b = i.b(r5.m(w, playerControlView.f453r, 0L).f2325i);
                        if (j2 < b) {
                            break;
                        } else if (w == n5 - 1) {
                            j2 = b;
                            break;
                        } else {
                            j2 -= b;
                            w++;
                        }
                    }
                } else {
                    w = l0Var.w();
                }
                playerControlView.g(l0Var, w, j2);
            }
        }
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f425k;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final void e() {
        long j2;
        Rect rect = this.c;
        Rect rect2 = this.b;
        rect.set(rect2);
        Rect rect3 = this.d;
        rect3.set(rect2);
        if (this.E) {
            j2 = this.F;
        } else {
            j2 = this.H;
        }
        if (this.G > 0) {
            rect.right = Math.min(rect2.left + ((int) ((rect2.width() * this.I) / this.G)), rect2.right);
            rect3.right = Math.min(rect2.left + ((int) ((rect2.width() * j2) / this.G)), rect2.right);
        } else {
            int i3 = rect2.left;
            rect.right = i3;
            rect3.right = i3;
        }
        invalidate(this.f418a);
    }

    public final void f(long j2) {
        if (this.F == j2) {
            return;
        }
        this.F = j2;
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            PlayerControlView playerControlView = ((d) it.next()).f203a;
            TextView textView = playerControlView.f449m;
            if (textView != null) {
                textView.setText(w.p(playerControlView.f451o, playerControlView.f452p, j2));
            }
        }
    }

    @Override // c2.p
    public long getPreferredUpdateDelay() {
        int width = (int) (this.b.width() / this.f437z);
        if (width != 0) {
            long j2 = this.G;
            if (j2 != 0 && j2 != -9223372036854775807L) {
                return j2 / width;
            }
        }
        return Long.MAX_VALUE;
    }

    @Override // android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f425k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Paint paint;
        int i3;
        canvas.save();
        Rect rect = this.b;
        int height = rect.height();
        int centerY = rect.centerY() - (height / 2);
        int i5 = centerY + height;
        long j2 = this.G;
        Paint paint2 = this.f421g;
        Rect rect2 = this.d;
        if (j2 <= 0) {
            canvas.drawRect(rect.left, centerY, rect.right, i5, paint2);
        } else {
            Rect rect3 = this.c;
            int i6 = rect3.left;
            int i7 = rect3.right;
            int max = Math.max(Math.max(rect.left, i7), rect2.right);
            int i8 = rect.right;
            if (max < i8) {
                canvas.drawRect(max, centerY, i8, i5, paint2);
            }
            int max2 = Math.max(i6, rect2.right);
            if (i7 > max2) {
                canvas.drawRect(max2, centerY, i7, i5, this.f420f);
            }
            if (rect2.width() > 0) {
                canvas.drawRect(rect2.left, centerY, rect2.right, i5, this.f419e);
            }
            if (this.J != 0) {
                long[] jArr = this.K;
                jArr.getClass();
                boolean[] zArr = this.L;
                zArr.getClass();
                int i9 = this.f428n;
                int i10 = i9 / 2;
                int i11 = 0;
                int i12 = 0;
                while (i12 < this.J) {
                    long i13 = w.i(jArr[i12], 0L, this.G);
                    int min = Math.min(rect.width() - i9, Math.max(i11, ((int) ((rect.width() * i13) / this.G)) - i10)) + rect.left;
                    if (zArr[i12]) {
                        paint = this.f423i;
                    } else {
                        paint = this.f422h;
                    }
                    canvas.drawRect(min, centerY, min + i9, i5, paint);
                    i12++;
                    i9 = i9;
                    i11 = 0;
                }
            }
        }
        if (this.G > 0) {
            int h5 = w.h(rect2.right, rect2.left, rect.right);
            int centerY2 = rect2.centerY();
            Drawable drawable = this.f425k;
            if (drawable == null) {
                if (!this.E && !isFocused()) {
                    if (isEnabled()) {
                        i3 = this.f429o;
                    } else {
                        i3 = this.f430p;
                    }
                } else {
                    i3 = this.q;
                }
                canvas.drawCircle(h5, centerY2, i3 / 2, this.f424j);
            } else {
                int intrinsicWidth = drawable.getIntrinsicWidth() / 2;
                int intrinsicHeight = drawable.getIntrinsicHeight() / 2;
                drawable.setBounds(h5 - intrinsicWidth, centerY2 - intrinsicHeight, h5 + intrinsicWidth, centerY2 + intrinsicHeight);
                drawable.draw(canvas);
            }
        }
        canvas.restore();
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z3, int i3, Rect rect) {
        super.onFocusChanged(z3, i3, rect);
        if (this.E && !z3) {
            d(false);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.G <= 0) {
            return;
        }
        if (w.f1960a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            return;
        }
        accessibilityNodeInfo.addAction(4096);
        accessibilityNodeInfo.addAction(8192);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L2e
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L25
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L25;
                default: goto L12;
            }
        L12:
            goto L2e
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.b(r0)
            if (r0 == 0) goto L2e
            c2.b r5 = r4.f434v
            r4.removeCallbacks(r5)
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L25:
            boolean r0 = r4.E
            if (r0 == 0) goto L2e
            r5 = 0
            r4.d(r5)
            return r3
        L2e:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final void onLayout(boolean z3, int i3, int i5, int i6, int i7) {
        Rect rect;
        int i8 = i6 - i3;
        int i9 = i7 - i5;
        int i10 = this.f427m;
        int i11 = (i9 - i10) / 2;
        int i12 = this.f426l;
        int c = a1.i.c(i10, i12, 2, i11);
        Rect rect2 = this.f418a;
        rect2.set(getPaddingLeft(), i11, i8 - getPaddingRight(), i10 + i11);
        int i13 = rect2.left;
        int i14 = this.f431r;
        this.b.set(i13 + i14, c, rect2.right - i14, i12 + c);
        if (w.f1960a >= 29 && ((rect = this.D) == null || rect.width() != i8 || this.D.height() != i9)) {
            Rect rect3 = new Rect(0, 0, i8, i9);
            this.D = rect3;
            setSystemGestureExclusionRects(Collections.singletonList(rect3));
        }
        e();
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i5) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int i6 = this.f427m;
        if (mode == 0) {
            size = i6;
        } else if (mode != 1073741824) {
            size = Math.min(i6, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i3), size);
        Drawable drawable = this.f425k;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i3) {
        boolean layoutDirection;
        Drawable drawable = this.f425k;
        if (drawable != null && w.f1960a >= 23) {
            layoutDirection = drawable.setLayoutDirection(i3);
            if (layoutDirection) {
                invalidate();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r3 != 3) goto L32;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.isEnabled()
            r1 = 0
            if (r0 == 0) goto Lad
            long r2 = r9.G
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L11
            goto Lad
        L11:
            int[] r0 = r9.f435x
            r9.getLocationOnScreen(r0)
            android.graphics.Point r2 = r9.f436y
            float r3 = r10.getRawX()
            int r3 = (int) r3
            r4 = r0[r1]
            int r3 = r3 - r4
            float r4 = r10.getRawY()
            int r4 = (int) r4
            r5 = 1
            r0 = r0[r5]
            int r4 = r4 - r0
            r2.set(r3, r4)
            int r0 = r2.x
            int r2 = r2.y
            int r3 = r10.getAction()
            android.graphics.Rect r4 = r9.d
            android.graphics.Rect r6 = r9.b
            if (r3 == 0) goto L89
            r7 = 3
            if (r3 == r5) goto L7a
            r8 = 2
            if (r3 == r8) goto L43
            if (r3 == r7) goto L7a
            goto Lad
        L43:
            boolean r10 = r9.E
            if (r10 == 0) goto Lad
            int r10 = r9.s
            if (r2 >= r10) goto L5e
            int r10 = r9.C
            int r10 = a1.i.c(r0, r10, r7, r10)
            float r10 = (float) r10
            int r10 = (int) r10
            int r0 = r6.left
            int r1 = r6.right
            int r10 = g2.w.h(r10, r0, r1)
            r4.right = r10
            goto L6c
        L5e:
            r9.C = r0
            float r10 = (float) r0
            int r10 = (int) r10
            int r0 = r6.left
            int r1 = r6.right
            int r10 = g2.w.h(r10, r0, r1)
            r4.right = r10
        L6c:
            long r0 = r9.getScrubberPosition()
            r9.f(r0)
            r9.e()
            r9.invalidate()
            return r5
        L7a:
            boolean r0 = r9.E
            if (r0 == 0) goto Lad
            int r10 = r10.getAction()
            if (r10 != r7) goto L85
            r1 = 1
        L85:
            r9.d(r1)
            return r5
        L89:
            float r10 = (float) r0
            float r0 = (float) r2
            int r10 = (int) r10
            int r0 = (int) r0
            android.graphics.Rect r2 = r9.f418a
            boolean r0 = r2.contains(r10, r0)
            if (r0 == 0) goto Lad
            int r0 = r6.left
            int r1 = r6.right
            int r10 = g2.w.h(r10, r0, r1)
            r4.right = r10
            long r0 = r9.getScrubberPosition()
            r9.c(r0)
            r9.e()
            r9.invalidate()
            return r5
        Lad:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i3, Bundle bundle) {
        if (super.performAccessibilityAction(i3, bundle)) {
            return true;
        }
        if (this.G <= 0) {
            return false;
        }
        if (i3 == 8192) {
            if (b(-getPositionIncrement())) {
                d(false);
            }
        } else if (i3 != 4096) {
            return false;
        } else {
            if (b(getPositionIncrement())) {
                d(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void setAdMarkerColor(@ColorInt int i3) {
        this.f422h.setColor(i3);
        invalidate(this.f418a);
    }

    public void setBufferedColor(@ColorInt int i3) {
        this.f420f.setColor(i3);
        invalidate(this.f418a);
    }

    @Override // c2.p
    public void setBufferedPosition(long j2) {
        this.I = j2;
        e();
    }

    @Override // c2.p
    public void setDuration(long j2) {
        this.G = j2;
        if (this.E && j2 == -9223372036854775807L) {
            d(true);
        }
        e();
    }

    @Override // android.view.View, c2.p
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        if (this.E && !z3) {
            d(true);
        }
    }

    public void setKeyCountIncrement(int i3) {
        boolean z3;
        if (i3 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.e(z3);
        this.A = i3;
        this.B = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j2) {
        boolean z3;
        if (j2 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.e(z3);
        this.A = -1;
        this.B = j2;
    }

    public void setPlayedAdMarkerColor(@ColorInt int i3) {
        this.f423i.setColor(i3);
        invalidate(this.f418a);
    }

    public void setPlayedColor(@ColorInt int i3) {
        this.f419e.setColor(i3);
        invalidate(this.f418a);
    }

    @Override // c2.p
    public void setPosition(long j2) {
        this.H = j2;
        setContentDescription(getProgressText());
        e();
    }

    public void setScrubberColor(@ColorInt int i3) {
        this.f424j.setColor(i3);
        invalidate(this.f418a);
    }

    public void setUnplayedColor(@ColorInt int i3) {
        this.f421g.setColor(i3);
        invalidate(this.f418a);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v12 */
    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i3, AttributeSet attributeSet2) {
        super(context, attributeSet, i3);
        ?? r22;
        Paint paint;
        this.f418a = new Rect();
        this.b = new Rect();
        this.c = new Rect();
        this.d = new Rect();
        Paint paint2 = new Paint();
        this.f419e = paint2;
        Paint paint3 = new Paint();
        this.f420f = paint3;
        Paint paint4 = new Paint();
        this.f421g = paint4;
        Paint paint5 = new Paint();
        this.f422h = paint5;
        Paint paint6 = new Paint();
        this.f423i = paint6;
        Paint paint7 = new Paint();
        this.f424j = paint7;
        paint7.setAntiAlias(true);
        this.w = new CopyOnWriteArraySet();
        this.f435x = new int[2];
        this.f436y = new Point();
        float f4 = context.getResources().getDisplayMetrics().density;
        this.f437z = f4;
        this.s = a(f4, -50);
        int a5 = a(f4, 4);
        int a6 = a(f4, 26);
        int a7 = a(f4, 4);
        int a8 = a(f4, 12);
        int a9 = a(f4, 0);
        int a10 = a(f4, 16);
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, n.DefaultTimeBar, 0, 0);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(n.DefaultTimeBar_scrubber_drawable);
                this.f425k = drawable;
                if (drawable != null) {
                    int i5 = w.f1960a;
                    if (i5 >= 23) {
                        paint = paint5;
                        int layoutDirection = getLayoutDirection();
                        if (i5 >= 23) {
                            drawable.setLayoutDirection(layoutDirection);
                        }
                    } else {
                        paint = paint5;
                    }
                    a6 = Math.max(drawable.getMinimumHeight(), a6);
                } else {
                    paint = paint5;
                }
                this.f426l = obtainStyledAttributes.getDimensionPixelSize(n.DefaultTimeBar_bar_height, a5);
                this.f427m = obtainStyledAttributes.getDimensionPixelSize(n.DefaultTimeBar_touch_target_height, a6);
                this.f428n = obtainStyledAttributes.getDimensionPixelSize(n.DefaultTimeBar_ad_marker_width, a7);
                this.f429o = obtainStyledAttributes.getDimensionPixelSize(n.DefaultTimeBar_scrubber_enabled_size, a8);
                this.f430p = obtainStyledAttributes.getDimensionPixelSize(n.DefaultTimeBar_scrubber_disabled_size, a9);
                this.q = obtainStyledAttributes.getDimensionPixelSize(n.DefaultTimeBar_scrubber_dragged_size, a10);
                int i6 = obtainStyledAttributes.getInt(n.DefaultTimeBar_played_color, -1);
                int i7 = obtainStyledAttributes.getInt(n.DefaultTimeBar_scrubber_color, -1);
                int i8 = obtainStyledAttributes.getInt(n.DefaultTimeBar_buffered_color, -855638017);
                int i9 = obtainStyledAttributes.getInt(n.DefaultTimeBar_unplayed_color, 872415231);
                int i10 = obtainStyledAttributes.getInt(n.DefaultTimeBar_ad_marker_color, -1291845888);
                int i11 = obtainStyledAttributes.getInt(n.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint2.setColor(i6);
                paint7.setColor(i7);
                paint3.setColor(i8);
                paint4.setColor(i9);
                paint.setColor(i10);
                paint6.setColor(i11);
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.f426l = a5;
            this.f427m = a6;
            this.f428n = a7;
            this.f429o = a8;
            this.f430p = a9;
            this.q = a10;
            paint2.setColor(-1);
            paint7.setColor(-1);
            paint3.setColor(-855638017);
            paint4.setColor(872415231);
            paint5.setColor(-1291845888);
            paint6.setColor(872414976);
            this.f425k = null;
        }
        StringBuilder sb = new StringBuilder();
        this.f432t = sb;
        this.f433u = new Formatter(sb, Locale.getDefault());
        this.f434v = new b(0, this);
        Drawable drawable2 = this.f425k;
        if (drawable2 != null) {
            r22 = 1;
            this.f431r = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            r22 = 1;
            this.f431r = (Math.max(this.f430p, Math.max(this.f429o, this.q)) + 1) / 2;
        }
        this.G = -9223372036854775807L;
        this.B = -9223372036854775807L;
        this.A = 20;
        setFocusable((boolean) r22);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(r22);
        }
    }
}
