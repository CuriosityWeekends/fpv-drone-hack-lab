package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.TextureView;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GifTextureView extends TextureView {

    /* renamed from: g  reason: collision with root package name */
    public static final ImageView.ScaleType[] f3277g = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: a  reason: collision with root package name */
    public ImageView.ScaleType f3278a;
    public final Matrix b;
    public p c;
    public i d;

    /* renamed from: e  reason: collision with root package name */
    public float f3279e;

    /* renamed from: f  reason: collision with root package name */
    public l f3280f;

    public GifTextureView(Context context) {
        super(context);
        this.f3278a = ImageView.ScaleType.FIT_CENTER;
        this.b = new Matrix();
        this.f3279e = 1.0f;
        b(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuperSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }

    public final void b(AttributeSet attributeSet, int i3) {
        p nVar;
        p pVar;
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                ImageView.ScaleType[] scaleTypeArr = f3277g;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.f3278a = scaleTypeArr[attributeIntValue];
                }
            }
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, q.GifTextureView, i3, 0);
            TypedValue typedValue = new TypedValue();
            if (!obtainStyledAttributes.getValue(q.GifTextureView_gifSource, typedValue)) {
                pVar = null;
            } else {
                if (typedValue.resourceId != 0) {
                    String resourceTypeName = obtainStyledAttributes.getResources().getResourceTypeName(typedValue.resourceId);
                    if (m.f3307a.contains(resourceTypeName)) {
                        nVar = new o(obtainStyledAttributes.getResources(), typedValue.resourceId);
                        pVar = nVar;
                    } else if (!"string".equals(resourceTypeName)) {
                        throw new IllegalArgumentException(a1.i.i("Expected string, drawable, mipmap or raw resource type. '", resourceTypeName, "' is not supported"));
                    }
                }
                nVar = new n(obtainStyledAttributes.getResources().getAssets(), typedValue.string.toString());
                pVar = nVar;
            }
            this.c = pVar;
            super.setOpaque(obtainStyledAttributes.getBoolean(q.GifTextureView_isOpaque, false));
            obtainStyledAttributes.recycle();
            this.f3280f = new l(this, attributeSet, i3);
        } else {
            super.setOpaque(false);
            this.f3280f = new l();
        }
        if (!isInEditMode()) {
            i iVar = new i(this);
            this.d = iVar;
            if (this.c != null) {
                iVar.start();
            }
        }
    }

    public final synchronized void c(p pVar) {
        i iVar = this.d;
        iVar.f3303a.b();
        setSuperSurfaceTextureListener(null);
        iVar.b.n();
        iVar.interrupt();
        try {
            this.d.join();
        } catch (InterruptedException e5) {
            e5.printStackTrace();
        }
        this.c = pVar;
        i iVar2 = new i(this);
        this.d = iVar2;
        if (pVar != null) {
            iVar2.start();
        }
    }

    public final void d(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = getWidth();
        float height = getHeight();
        float k5 = gifInfoHandle.k() / width;
        float f4 = gifInfoHandle.f() / height;
        RectF rectF = new RectF(0.0f, 0.0f, gifInfoHandle.k(), gifInfoHandle.f());
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        float f5 = 1.0f;
        switch (g.f3301a[this.f3278a.ordinal()]) {
            case 1:
                matrix.setScale(k5, f4, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float min = 1.0f / Math.min(k5, f4);
                matrix.setScale(k5 * min, min * f4, width / 2.0f, height / 2.0f);
                break;
            case 3:
                if (gifInfoHandle.k() > width || gifInfoHandle.f() > height) {
                    f5 = Math.min(1.0f / k5, 1.0f / f4);
                }
                matrix.setScale(k5 * f5, f5 * f4, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                matrix.preScale(k5, f4);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                matrix.preScale(k5, f4);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                matrix.preScale(k5, f4);
                break;
            case 7:
                return;
            case 8:
                matrix.set(this.b);
                matrix.preScale(k5, f4);
                break;
        }
        super.setTransform(matrix);
    }

    @Nullable
    public IOException getIOException() {
        i iVar = this.d;
        IOException iOException = iVar.c;
        if (iOException != null) {
            return iOException;
        }
        int h5 = iVar.b.h();
        int i3 = GifIOException.c;
        if (h5 == d.NO_ERROR.b) {
            return null;
        }
        return new GifIOException(h5, null);
    }

    public ImageView.ScaleType getScaleType() {
        return this.f3278a;
    }

    @Override // android.view.TextureView
    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    @Override // android.view.TextureView
    public final Matrix getTransform(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.set(this.b);
        return matrix;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        i iVar = this.d;
        iVar.f3303a.b();
        setSuperSurfaceTextureListener(null);
        iVar.b.n();
        iVar.interrupt();
        super.onDetachedFromWindow();
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        this.d.d = gifViewSavedState.f3281a[0];
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        long[] jArr;
        i iVar = this.d;
        iVar.d = iVar.b.j();
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (this.f3280f.f3306a) {
            jArr = this.d.d;
        } else {
            jArr = null;
        }
        return new GifViewSavedState(onSaveInstanceState, jArr);
    }

    public void setFreezesAnimation(boolean z3) {
        this.f3280f.f3306a = z3;
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    public synchronized void setInputSource(@Nullable p pVar) {
        c(pVar);
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean z3) {
        if (z3 != isOpaque()) {
            super.setOpaque(z3);
            setInputSource(this.c);
        }
    }

    public void setScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f3278a = scaleType;
        d(this.d.b);
    }

    public void setSpeed(@FloatRange(from = 0.0d, fromInclusive = false) float f4) {
        this.f3279e = f4;
        this.d.b.x(f4);
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    @Override // android.view.TextureView
    public void setTransform(Matrix matrix) {
        this.b.set(matrix);
        d(this.d.b);
    }

    public GifTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3278a = ImageView.ScaleType.FIT_CENTER;
        this.b = new Matrix();
        this.f3279e = 1.0f;
        b(attributeSet, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f3278a = ImageView.ScaleType.FIT_CENTER;
        this.b = new Matrix();
        this.f3279e = 1.0f;
        b(attributeSet, i3);
    }
}
