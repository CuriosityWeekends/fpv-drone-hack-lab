package com.lg.picturesubmitt.widget.roundimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import s2.d;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class AbsRoundImageView extends ImageView {

    /* renamed from: g  reason: collision with root package name */
    public static final PorterDuffXfermode f1016g = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    /* renamed from: a  reason: collision with root package name */
    public final Paint f1017a;
    public final Path b;
    public final Path c;
    public float d;

    /* renamed from: e  reason: collision with root package name */
    public int f1018e;

    /* renamed from: f  reason: collision with root package name */
    public final Paint f1019f;

    public AbsRoundImageView(Context context) {
        this(context, null, 0);
    }

    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.AbsRoundImageView);
            this.d = obtainStyledAttributes.getDimension(1, 0.0f);
            this.f1018e = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public abstract void b();

    public abstract void c();

    public Bitmap getRoundBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawPath(this.b, paint);
        return createBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        Bitmap createBitmap;
        Drawable drawable = getDrawable();
        if (!isInEditMode() && drawable != null) {
            try {
                if (drawable instanceof ColorDrawable) {
                    createBitmap = Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888);
                } else {
                    createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                }
                Canvas canvas2 = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas2.getWidth(), canvas2.getHeight());
                drawable.draw(canvas2);
                Bitmap roundBitmap = getRoundBitmap();
                this.f1017a.reset();
                this.f1017a.setFilterBitmap(false);
                this.f1017a.setXfermode(f1016g);
                canvas2.drawBitmap(roundBitmap, 0.0f, 0.0f, this.f1017a);
                this.f1017a.setXfermode(null);
                canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.f1017a);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        this.f1019f.setStyle(Paint.Style.STROKE);
        this.f1019f.setColor(this.f1018e);
        canvas.drawPath(this.c, this.f1019f);
    }

    @Override // android.view.View
    public final void onLayout(boolean z3, int i3, int i5, int i6, int i7) {
        super.onLayout(z3, i3, i5, i6, i7);
        if (z3) {
            b();
            c();
        }
    }

    public AbsRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsRoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(attributeSet);
        this.f1017a = new Paint(1);
        this.b = new Path();
        this.c = new Path();
        Paint paint = new Paint(1);
        this.f1019f = paint;
        paint.setStrokeWidth(this.d);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
