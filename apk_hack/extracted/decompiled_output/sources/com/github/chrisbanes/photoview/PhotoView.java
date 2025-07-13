package com.github.chrisbanes.photoview;

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
import i0.a;
import i0.c;
import i0.d;
import i0.e;
import i0.f;
import i0.g;
import i0.i;
import i0.j;
import j4.b;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PhotoView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    public final i f305a;
    public ImageView.ScaleType b;

    public PhotoView(Context context) {
        this(context, null);
    }

    public i getAttacher() {
        return this.f305a;
    }

    public RectF getDisplayRect() {
        i iVar = this.f305a;
        iVar.b();
        Matrix c = iVar.c();
        Drawable drawable = iVar.f2162h.getDrawable();
        if (drawable != null) {
            RectF rectF = iVar.f2168n;
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            c.mapRect(rectF);
            return rectF;
        }
        return null;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f305a.f2166l;
    }

    public float getMaximumScale() {
        return this.f305a.f2159e;
    }

    public float getMediumScale() {
        return this.f305a.d;
    }

    public float getMinimumScale() {
        return this.f305a.c;
    }

    public float getScale() {
        return this.f305a.d();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f305a.f2174v;
    }

    public void setAllowParentInterceptOnEdge(boolean z3) {
        this.f305a.f2160f = z3;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i3, int i5, int i6, int i7) {
        boolean frame = super.setFrame(i3, i5, i6, i7);
        if (frame) {
            this.f305a.f();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        i iVar = this.f305a;
        if (iVar != null) {
            iVar.f();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        i iVar = this.f305a;
        if (iVar != null) {
            iVar.f();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        i iVar = this.f305a;
        if (iVar != null) {
            iVar.f();
        }
    }

    public void setMaximumScale(float f4) {
        i iVar = this.f305a;
        b.f(iVar.c, iVar.d, f4);
        iVar.f2159e = f4;
    }

    public void setMediumScale(float f4) {
        i iVar = this.f305a;
        b.f(iVar.c, f4, iVar.f2159e);
        iVar.d = f4;
    }

    public void setMinimumScale(float f4) {
        i iVar = this.f305a;
        b.f(f4, iVar.d, iVar.f2159e);
        iVar.c = f4;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f305a.f2170p = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f305a.f2163i.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f305a.q = onLongClickListener;
    }

    public void setOnMatrixChangeListener(a aVar) {
        this.f305a.getClass();
    }

    public void setOnOutsidePhotoTapListener(i0.b bVar) {
        this.f305a.getClass();
    }

    public void setOnPhotoTapListener(c cVar) {
        this.f305a.getClass();
    }

    public void setOnScaleChangeListener(d dVar) {
        this.f305a.getClass();
    }

    public void setOnSingleFlingListener(e eVar) {
        this.f305a.getClass();
    }

    public void setOnViewDragListener(f fVar) {
        this.f305a.getClass();
    }

    public void setOnViewTapListener(g gVar) {
        this.f305a.getClass();
    }

    public void setRotationBy(float f4) {
        i iVar = this.f305a;
        iVar.f2167m.postRotate(f4 % 360.0f);
        iVar.a();
    }

    public void setRotationTo(float f4) {
        i iVar = this.f305a;
        iVar.f2167m.setRotate(f4 % 360.0f);
        iVar.a();
    }

    public void setScale(float f4) {
        i iVar = this.f305a;
        ImageView imageView = iVar.f2162h;
        iVar.e(f4, imageView.getRight() / 2, imageView.getBottom() / 2, false);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        i iVar = this.f305a;
        if (iVar == null) {
            this.b = scaleType;
            return;
        }
        iVar.getClass();
        if (scaleType != null) {
            if (j.f2175a[scaleType.ordinal()] != 1) {
                if (scaleType != iVar.f2174v) {
                    iVar.f2174v = scaleType;
                    iVar.f();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Matrix scale type is not supported");
        }
    }

    public void setZoomTransitionDuration(int i3) {
        this.f305a.b = i3;
    }

    public void setZoomable(boolean z3) {
        i iVar = this.f305a;
        iVar.f2173u = z3;
        iVar.f();
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f305a = new i(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.b = null;
        }
    }
}
