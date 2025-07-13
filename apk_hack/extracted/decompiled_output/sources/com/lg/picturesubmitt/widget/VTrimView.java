package com.lg.picturesubmitt.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import b3.d;
import com.bumptech.glide.c;
import s2.f;
import x2.o;
import x2.p;
import x2.q;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class VTrimView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f989a;
    public int b;
    public final Handler c;
    public boolean d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f990e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f991f;

    /* renamed from: g  reason: collision with root package name */
    public final int f992g;

    /* renamed from: h  reason: collision with root package name */
    public final int f993h;

    /* renamed from: i  reason: collision with root package name */
    public float f994i;

    /* renamed from: j  reason: collision with root package name */
    public volatile int f995j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f996k;

    /* renamed from: l  reason: collision with root package name */
    public final d f997l;

    /* renamed from: m  reason: collision with root package name */
    public int f998m;

    /* renamed from: n  reason: collision with root package name */
    public int f999n;

    /* renamed from: o  reason: collision with root package name */
    public f f1000o;

    public VTrimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f989a = 0;
        this.b = 0;
        this.c = new Handler();
        this.d = false;
        this.f995j = 0;
        this.f996k = false;
        this.f997l = new d(20, this);
        View.inflate(context, 2131427517, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s2.d.VTrimView);
        this.f993h = obtainStyledAttributes.getInt(5, 0);
        this.f992g = obtainStyledAttributes.getInt(4, 32);
        int dimension = (int) obtainStyledAttributes.getDimension(3, (int) TypedValue.applyDimension(1, 30.0f, context.getResources().getDisplayMetrics()));
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(6);
        Drawable drawable3 = obtainStyledAttributes.getDrawable(2);
        Drawable drawable4 = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        CustomButton customButton = (CustomButton) findViewById(2131231445);
        CustomButton customButton2 = (CustomButton) findViewById(2131230831);
        ImageView imageView = (ImageView) findViewById(2131230821);
        this.f990e = imageView;
        ImageView imageView2 = (ImageView) findViewById(2131230822);
        this.f991f = imageView2;
        imageView2.setImageDrawable(drawable);
        imageView.setBackground(drawable4);
        customButton.setBackground(drawable2);
        customButton2.setBackground(drawable3);
        customButton.getLayoutParams().height = dimension;
        customButton2.getLayoutParams().height = dimension;
        customButton2.setOnClickListener(new o(this, 0));
        customButton2.setOnLongClickListener(new p(this, 0));
        customButton2.setOnTouchListener(new q(this, 0));
        customButton.setOnClickListener(new o(this, 1));
        customButton.setOnLongClickListener(new p(this, 1));
        customButton.setOnTouchListener(new q(this, 1));
        this.f998m = 2131689474;
        this.f999n = 2131689475;
    }

    public final void a(boolean z3) {
        if (z3 && this.f995j < this.f992g) {
            this.f995j++;
            this.f991f.setY(this.f994i + ((16 - this.f995j) * this.b));
            b();
            this.f1000o.c(this.f995j);
        } else if (!z3 && this.f995j > this.f993h) {
            this.f995j--;
            this.f991f.setY(this.f994i + ((16 - this.f995j) * this.b));
            b();
            this.f1000o.c(this.f995j);
        }
    }

    public final void b() {
        if (this.f999n != 0) {
            if (this.f998m != 0 && this.f995j == this.f989a) {
                c.i(getContext(), this.f998m);
            } else {
                c.i(getContext(), this.f999n);
            }
        }
    }

    public int getMax() {
        return this.f992g;
    }

    public int getPosition() {
        return this.f995j;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i5, int i6, int i7) {
        super.onLayout(z3, i3, i5, i6, i7);
        int height = this.f990e.getHeight();
        int i8 = this.f992g;
        int i9 = this.f993h;
        this.b = height / (i8 - i9);
        this.f995j = (i8 + i9) / 2;
        this.f989a = this.f995j;
        if (this.f995j == 16) {
            this.f994i = this.f991f.getY();
        }
    }

    public void setOnTrimViewInterface(f fVar) {
        this.f1000o = fVar;
    }

    public void setPosition(int i3) {
        this.f995j = i3;
        this.f991f.setY(this.f994i + ((this.f995j - 16) * this.b));
    }

    public void setSoundCentre(int i3) {
        this.f998m = i3;
    }

    public void setSoundClick(int i3) {
        this.f999n = i3;
    }
}
