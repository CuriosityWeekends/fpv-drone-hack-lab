package com.lg.picturesubmitt.widget.roundimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import s2.d;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class RoundImageView extends AbsRoundImageView {

    /* renamed from: h  reason: collision with root package name */
    public float f1020h;

    /* renamed from: i  reason: collision with root package name */
    public float f1021i;

    /* renamed from: j  reason: collision with root package name */
    public float f1022j;

    /* renamed from: k  reason: collision with root package name */
    public float f1023k;

    public RoundImageView(Context context) {
        this(context, null, 0);
    }

    @Override // com.lg.picturesubmitt.widget.roundimage.AbsRoundImageView
    public final void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.RoundImageView);
            this.f1020h = obtainStyledAttributes.getDimension(1, 0.0f);
            this.f1021i = obtainStyledAttributes.getDimension(3, 0.0f);
            this.f1022j = obtainStyledAttributes.getDimension(2, 0.0f);
            this.f1023k = obtainStyledAttributes.getDimension(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // com.lg.picturesubmitt.widget.roundimage.AbsRoundImageView
    public final void b() {
        Path path = this.c;
        path.reset();
        float f4 = this.d * 0.35f;
        int width = getWidth();
        int height = getHeight();
        this.f1020h = Math.min(this.f1020h, Math.min(width, height) * 0.5f);
        this.f1021i = Math.min(this.f1021i, Math.min(width, height) * 0.5f);
        this.f1022j = Math.min(this.f1022j, Math.min(width, height) * 0.5f);
        this.f1023k = Math.min(this.f1023k, Math.min(width, height) * 0.5f);
        RectF rectF = new RectF(f4, f4, width - f4, height - f4);
        float f5 = this.f1020h;
        float f6 = this.f1021i;
        float f7 = this.f1022j;
        float f8 = this.f1023k;
        path.addRoundRect(rectF, new float[]{f5, f5, f6, f6, f7, f7, f8, f8}, Path.Direction.CW);
    }

    @Override // com.lg.picturesubmitt.widget.roundimage.AbsRoundImageView
    public final void c() {
        Path path = this.b;
        path.reset();
        int width = getWidth();
        int height = getHeight();
        this.f1020h = Math.min(this.f1020h, Math.min(width, height) * 0.5f);
        this.f1021i = Math.min(this.f1021i, Math.min(width, height) * 0.5f);
        this.f1022j = Math.min(this.f1022j, Math.min(width, height) * 0.5f);
        this.f1023k = Math.min(this.f1023k, Math.min(width, height) * 0.5f);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        float f4 = this.f1020h;
        float f5 = this.f1021i;
        float f6 = this.f1022j;
        float f7 = this.f1023k;
        path.addRoundRect(rectF, new float[]{f4, f4, f5, f5, f6, f6, f7, f7}, Path.Direction.CW);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(attributeSet);
    }
}
