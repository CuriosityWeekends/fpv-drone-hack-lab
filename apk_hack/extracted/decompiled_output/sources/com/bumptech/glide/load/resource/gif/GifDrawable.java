package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import c0.g;
import java.util.ArrayList;
import t.b;
import t.d;
import t.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GifDrawable extends Drawable implements e, Animatable, Animatable2Compat {

    /* renamed from: a  reason: collision with root package name */
    public final b f267a;
    public boolean b;
    public boolean c;
    public boolean d;

    /* renamed from: f  reason: collision with root package name */
    public int f269f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f271h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f272i;

    /* renamed from: j  reason: collision with root package name */
    public Rect f273j;

    /* renamed from: k  reason: collision with root package name */
    public ArrayList f274k;

    /* renamed from: e  reason: collision with root package name */
    public boolean f268e = true;

    /* renamed from: g  reason: collision with root package name */
    public final int f270g = -1;

    public GifDrawable(b bVar) {
        g.c(bVar, "Argument must not be null");
        this.f267a = bVar;
    }

    public final void a() {
        g.a("You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.", !this.d);
        t.g gVar = this.f267a.f3551a;
        if (gVar.f3557a.f1791l.c == 1) {
            invalidateSelf();
        } else if (!this.b) {
            this.b = true;
            if (!gVar.f3563j) {
                ArrayList arrayList = gVar.c;
                if (!arrayList.contains(this)) {
                    boolean isEmpty = arrayList.isEmpty();
                    arrayList.add(this);
                    if (isEmpty && !gVar.f3559f) {
                        gVar.f3559f = true;
                        gVar.f3563j = false;
                        gVar.a();
                    }
                    invalidateSelf();
                    return;
                }
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public final void clearAnimationCallbacks() {
        ArrayList arrayList = this.f274k;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Bitmap bitmap;
        if (this.d) {
            return;
        }
        if (this.f271h) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.f273j == null) {
                this.f273j = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f273j);
            this.f271h = false;
        }
        t.g gVar = this.f267a.f3551a;
        d dVar = gVar.f3562i;
        if (dVar != null) {
            bitmap = dVar.f3555g;
        } else {
            bitmap = gVar.f3565l;
        }
        if (this.f273j == null) {
            this.f273j = new Rect();
        }
        Rect rect = this.f273j;
        if (this.f272i == null) {
            this.f272i = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.f272i);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f267a;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f267a.f3551a.f3569p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f267a.f3551a.f3568o;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f271h = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public final void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f274k == null) {
            this.f274k = new ArrayList();
        }
        this.f274k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        if (this.f272i == null) {
            this.f272i = new Paint(2);
        }
        this.f272i.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f272i == null) {
            this.f272i = new Paint(2);
        }
        this.f272i.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z3, boolean z5) {
        g.a("Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.", !this.d);
        this.f268e = z3;
        if (!z3) {
            this.b = false;
            t.g gVar = this.f267a.f3551a;
            ArrayList arrayList = gVar.c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                gVar.f3559f = false;
            }
        } else if (this.c) {
            a();
        }
        return super.setVisible(z3, z5);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.c = true;
        this.f269f = 0;
        if (this.f268e) {
            a();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.c = false;
        this.b = false;
        t.g gVar = this.f267a.f3551a;
        ArrayList arrayList = gVar.c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            gVar.f3559f = false;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public final boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        ArrayList arrayList = this.f274k;
        if (arrayList != null && animationCallback != null) {
            return arrayList.remove(animationCallback);
        }
        return false;
    }
}
