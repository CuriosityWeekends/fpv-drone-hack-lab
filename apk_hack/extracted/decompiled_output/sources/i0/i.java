package i0;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import f3.k;
import f3.m;
import f3.n;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f2162h;

    /* renamed from: i  reason: collision with root package name */
    public final GestureDetector f2163i;

    /* renamed from: j  reason: collision with root package name */
    public final f3.b f2164j;

    /* renamed from: p  reason: collision with root package name */
    public View.OnClickListener f2170p;
    public View.OnLongClickListener q;

    /* renamed from: r  reason: collision with root package name */
    public n f2171r;
    public final b3.e w;

    /* renamed from: a  reason: collision with root package name */
    public final AccelerateDecelerateInterpolator f2158a = new AccelerateDecelerateInterpolator();
    public int b = 200;
    public float c = 1.0f;
    public float d = 1.75f;

    /* renamed from: e  reason: collision with root package name */
    public float f2159e = 3.0f;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2160f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2161g = false;

    /* renamed from: k  reason: collision with root package name */
    public final Matrix f2165k = new Matrix();

    /* renamed from: l  reason: collision with root package name */
    public final Matrix f2166l = new Matrix();

    /* renamed from: m  reason: collision with root package name */
    public final Matrix f2167m = new Matrix();

    /* renamed from: n  reason: collision with root package name */
    public final RectF f2168n = new RectF();

    /* renamed from: o  reason: collision with root package name */
    public final float[] f2169o = new float[9];
    public int s = 2;

    /* renamed from: t  reason: collision with root package name */
    public int f2172t = 2;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2173u = true;

    /* renamed from: v  reason: collision with root package name */
    public ImageView.ScaleType f2174v = ImageView.ScaleType.FIT_CENTER;

    public i(ImageView imageView) {
        b3.e eVar = new b3.e(9, this);
        this.w = eVar;
        this.f2162h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f2164j = new f3.b(imageView.getContext(), eVar, (byte) 0);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new f3.j(1, this));
        this.f2163i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new k(1, this));
    }

    public final void a() {
        if (b()) {
            this.f2162h.setImageMatrix(c());
        }
    }

    public final boolean b() {
        Drawable drawable;
        RectF rectF;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        Matrix c = c();
        float f9 = 0.0f;
        if (this.f2162h.getDrawable() != null) {
            rectF = this.f2168n;
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            c.mapRect(rectF);
        } else {
            rectF = null;
        }
        if (rectF == null) {
            return false;
        }
        float height = rectF.height();
        float width = rectF.width();
        ImageView imageView = this.f2162h;
        float height2 = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
        if (height <= height2) {
            int i3 = h.f2157a[this.f2174v.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f7 = (height2 - height) / 2.0f;
                    f8 = rectF.top;
                } else {
                    f7 = height2 - height;
                    f8 = rectF.top;
                }
                f4 = f7 - f8;
            } else {
                f4 = -rectF.top;
            }
            this.f2172t = 2;
        } else {
            float f10 = rectF.top;
            if (f10 > 0.0f) {
                this.f2172t = 0;
                f4 = -f10;
            } else {
                float f11 = rectF.bottom;
                if (f11 < height2) {
                    this.f2172t = 1;
                    f4 = height2 - f11;
                } else {
                    this.f2172t = -1;
                    f4 = 0.0f;
                }
            }
        }
        float width2 = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
        if (width <= width2) {
            int i5 = h.f2157a[this.f2174v.ordinal()];
            if (i5 != 2) {
                if (i5 != 3) {
                    f5 = (width2 - width) / 2.0f;
                    f6 = rectF.left;
                } else {
                    f5 = width2 - width;
                    f6 = rectF.left;
                }
                f9 = f5 - f6;
            } else {
                f9 = -rectF.left;
            }
            this.s = 2;
        } else {
            float f12 = rectF.left;
            if (f12 > 0.0f) {
                this.s = 0;
                f9 = -f12;
            } else {
                float f13 = rectF.right;
                if (f13 < width2) {
                    f9 = width2 - f13;
                    this.s = 1;
                } else {
                    this.s = -1;
                }
            }
        }
        this.f2167m.postTranslate(f9, f4);
        return true;
    }

    public final Matrix c() {
        Matrix matrix = this.f2166l;
        matrix.set(this.f2165k);
        matrix.postConcat(this.f2167m);
        return matrix;
    }

    public final float d() {
        Matrix matrix = this.f2167m;
        float[] fArr = this.f2169o;
        matrix.getValues(fArr);
        matrix.getValues(fArr);
        return (float) Math.sqrt(((float) Math.pow(fArr[0], 2.0d)) + ((float) Math.pow(fArr[3], 2.0d)));
    }

    public final void e(float f4, float f5, float f6, boolean z3) {
        if (f4 >= this.c && f4 <= this.f2159e) {
            if (z3) {
                this.f2162h.post(new m(this, d(), f4, f5, f6));
                return;
            }
            this.f2167m.setScale(f4, f4, f5, f6);
            a();
            return;
        }
        throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
    }

    public final void f() {
        if (this.f2173u) {
            g(this.f2162h.getDrawable());
            return;
        }
        Matrix matrix = this.f2167m;
        matrix.reset();
        matrix.postRotate(0.0f);
        a();
        this.f2162h.setImageMatrix(c());
        b();
    }

    public final void g(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        ImageView imageView = this.f2162h;
        float width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
        float height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Matrix matrix = this.f2165k;
        matrix.reset();
        float f4 = intrinsicWidth;
        float f5 = width / f4;
        float f6 = intrinsicHeight;
        float f7 = height / f6;
        ImageView.ScaleType scaleType = this.f2174v;
        if (scaleType == ImageView.ScaleType.CENTER) {
            matrix.postTranslate((width - f4) / 2.0f, (height - f6) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f5, f7);
            matrix.postScale(max, max);
            matrix.postTranslate((width - (f4 * max)) / 2.0f, (height - (f6 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f5, f7));
            matrix.postScale(min, min);
            matrix.postTranslate((width - (f4 * min)) / 2.0f, (height - (f6 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f4, f6);
            RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
            if (((int) 0.0f) % SubsamplingScaleImageView.ORIENTATION_180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f6, f4);
            }
            int i3 = h.f2157a[this.f2174v.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        }
                    } else {
                        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                    }
                } else {
                    matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                }
            } else {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        Matrix matrix2 = this.f2167m;
        matrix2.reset();
        matrix2.postRotate(0.0f);
        a();
        this.f2162h.setImageMatrix(c());
        b();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i3, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        if (i3 != i8 || i5 != i9 || i6 != i10 || i7 != i11) {
            g(this.f2162h.getDrawable());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f1  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.i.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
