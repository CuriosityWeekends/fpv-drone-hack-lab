package com.lxj.xpopup.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import f3.c;
import f3.d;
import f3.e;
import f3.f;
import f3.g;
import f3.h;
import f3.i;
import f3.o;
import f3.p;
import j4.b;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PhotoView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    public final o f1092a;
    public ImageView.ScaleType b;

    public PhotoView(Context context) {
        this(context, null);
    }

    public o getAttacher() {
        return this.f1092a;
    }

    public RectF getDisplayRect() {
        o oVar = this.f1092a;
        oVar.b();
        Matrix c = oVar.c();
        Drawable drawable = oVar.f1878h.getDrawable();
        if (drawable != null) {
            RectF rectF = oVar.f1884n;
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            c.mapRect(rectF);
            return rectF;
        }
        return null;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f1092a.f1882l;
    }

    public float getMaximumScale() {
        return this.f1092a.f1875e;
    }

    public float getMediumScale() {
        return this.f1092a.d;
    }

    public float getMinimumScale() {
        return this.f1092a.c;
    }

    public float getScale() {
        return this.f1092a.d();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f1092a.A;
    }

    public void setAllowParentInterceptOnEdge(boolean z3) {
        this.f1092a.f1876f = z3;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i3, int i5, int i6, int i7) {
        boolean frame = super.setFrame(i3, i5, i6, i7);
        if (frame) {
            this.f1092a.f();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        o oVar = this.f1092a;
        if (oVar != null) {
            oVar.f();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        o oVar = this.f1092a;
        if (oVar != null) {
            oVar.f();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        o oVar = this.f1092a;
        if (oVar != null) {
            oVar.f();
        }
    }

    public void setMaximumScale(float f4) {
        o oVar = this.f1092a;
        b.e(oVar.c, oVar.d, f4);
        oVar.f1875e = f4;
    }

    public void setMediumScale(float f4) {
        o oVar = this.f1092a;
        b.e(oVar.c, f4, oVar.f1875e);
        oVar.d = f4;
    }

    public void setMinimumScale(float f4) {
        o oVar = this.f1092a;
        b.e(f4, oVar.d, oVar.f1875e);
        oVar.c = f4;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f1092a.f1886p = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f1092a.f1879i.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f1092a.q = onLongClickListener;
    }

    public void setOnMatrixChangeListener(c cVar) {
        this.f1092a.getClass();
    }

    public void setOnOutsidePhotoTapListener(d dVar) {
        this.f1092a.getClass();
    }

    public void setOnPhotoTapListener(e eVar) {
        this.f1092a.getClass();
    }

    public void setOnScaleChangeListener(f fVar) {
        this.f1092a.getClass();
    }

    public void setOnSingleFlingListener(g gVar) {
        this.f1092a.getClass();
    }

    public void setOnViewDragListener(h hVar) {
        this.f1092a.getClass();
    }

    public void setOnViewTapListener(i iVar) {
        this.f1092a.getClass();
    }

    public void setRotationBy(float f4) {
        o oVar = this.f1092a;
        oVar.f1883m.postRotate(f4 % 360.0f);
        oVar.a();
    }

    public void setRotationTo(float f4) {
        o oVar = this.f1092a;
        oVar.f1883m.setRotate(f4 % 360.0f);
        oVar.a();
    }

    public void setScale(float f4) {
        o oVar = this.f1092a;
        ImageView imageView = oVar.f1878h;
        oVar.e(f4, imageView.getRight() / 2, imageView.getBottom() / 2, false);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        o oVar = this.f1092a;
        if (oVar == null) {
            this.b = scaleType;
            return;
        }
        oVar.getClass();
        if (scaleType != null && p.f1894a[scaleType.ordinal()] != 1 && scaleType != oVar.A) {
            oVar.A = scaleType;
            oVar.f();
        }
    }

    public void setZoomTransitionDuration(int i3) {
        this.f1092a.b = i3;
    }

    public void setZoomable(boolean z3) {
        o oVar = this.f1092a;
        oVar.f1892y = z3;
        oVar.f();
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1092a = new o(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.b = null;
        }
    }
}
