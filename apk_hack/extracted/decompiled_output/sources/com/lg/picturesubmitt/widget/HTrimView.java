package com.lg.picturesubmitt.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import b3.d;
import com.bumptech.glide.c;
import s2.f;
import x2.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class HTrimView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f911a;
    public int b;
    public final Handler c;
    public boolean d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f912e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f913f;

    /* renamed from: g  reason: collision with root package name */
    public final int f914g;

    /* renamed from: h  reason: collision with root package name */
    public final int f915h;

    /* renamed from: i  reason: collision with root package name */
    public float f916i;

    /* renamed from: j  reason: collision with root package name */
    public volatile int f917j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f918k;

    /* renamed from: l  reason: collision with root package name */
    public final d f919l;

    /* renamed from: m  reason: collision with root package name */
    public int f920m;

    /* renamed from: n  reason: collision with root package name */
    public int f921n;

    /* renamed from: o  reason: collision with root package name */
    public f f922o;

    public HTrimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f911a = 0;
        this.b = 0;
        this.c = new Handler();
        this.d = false;
        this.f917j = 0;
        this.f918k = false;
        this.f919l = new d(18, this);
        View.inflate(context, 2131427516, this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s2.d.HTrimView);
        this.f915h = obtainStyledAttributes.getInt(5, 0);
        this.f914g = obtainStyledAttributes.getInt(4, 32);
        int dimension = (int) obtainStyledAttributes.getDimension(2, (int) TypedValue.applyDimension(1, 30.0f, context.getResources().getDisplayMetrics()));
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(3);
        Drawable drawable3 = obtainStyledAttributes.getDrawable(6);
        Drawable drawable4 = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        CustomButton customButton = (CustomButton) findViewById(2131231098);
        CustomButton customButton2 = (CustomButton) findViewById(2131231307);
        ImageView imageView = (ImageView) findViewById(2131230821);
        this.f912e = imageView;
        ImageView imageView2 = (ImageView) findViewById(2131230822);
        this.f913f = imageView2;
        imageView2.setImageDrawable(drawable);
        imageView.setBackground(drawable4);
        customButton.setBackground(drawable2);
        customButton2.setBackground(drawable3);
        customButton.getLayoutParams().width = dimension;
        customButton2.getLayoutParams().width = dimension;
        customButton.setOnClickListener(new x2.d(this, 0));
        customButton.setOnLongClickListener(new e(this, 0));
        customButton.setOnTouchListener(new x2.f(this, 0));
        customButton2.setOnClickListener(new x2.d(this, 1));
        customButton2.setOnLongClickListener(new e(this, 1));
        customButton2.setOnTouchListener(new x2.f(this, 1));
        this.f920m = 2131689474;
        this.f921n = 2131689475;
    }

    public final void a(boolean z3) {
        if (z3 && this.f917j < this.f914g) {
            this.f917j++;
            this.f913f.setX(this.f916i + ((this.f917j - 16) * this.b));
            b();
            this.f922o.c(this.f917j);
        } else if (!z3 && this.f917j > this.f915h) {
            this.f917j--;
            this.f913f.setX(this.f916i + ((this.f917j - 16) * this.b));
            b();
            this.f922o.c(this.f917j);
        }
    }

    public final void b() {
        if (this.f921n != 0) {
            if (this.f920m != 0 && this.f917j == this.f911a) {
                c.i(getContext(), this.f920m);
            } else {
                c.i(getContext(), this.f921n);
            }
        }
    }

    public int getPosition() {
        return this.f917j;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i5, int i6, int i7) {
        super.onLayout(z3, i3, i5, i6, i7);
        int width = this.f912e.getWidth();
        int i8 = this.f914g;
        int i9 = this.f915h;
        this.b = width / (i8 - i9);
        this.f917j = (i8 + i9) / 2;
        this.f911a = this.f917j;
        if (this.f917j == 16) {
            this.f916i = this.f913f.getX();
        }
    }

    public void setOnTrimViewInterface(f fVar) {
        this.f922o = fVar;
    }

    public void setPosition(int i3) {
        this.f917j = i3;
        this.f913f.setX(this.f916i + ((this.f917j - 16) * this.b));
    }

    public void setSoundCentre(int i3) {
        this.f920m = i3;
    }

    public void setSoundClick(int i3) {
        this.f921n = i3;
    }
}
