package com.shuyu.gsyvideoplayer.render.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import c1.b;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.FileUtils;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.utils.MeasureHelper;
import java.io.File;
import n3.d;
import n3.e;
import r3.a;
import s3.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GSYTextureView extends TextureView implements TextureView.SurfaceTextureListener, c, MeasureHelper.MeasureFormVideoParamsListener {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ int f1136f = 0;

    /* renamed from: a  reason: collision with root package name */
    public t3.c f1137a;
    public MeasureHelper.MeasureFormVideoParamsListener b;
    public final MeasureHelper c;
    public SurfaceTexture d;

    /* renamed from: e  reason: collision with root package name */
    public Surface f1138e;

    public GSYTextureView(Context context) {
        super(context);
        this.c = new MeasureHelper(this, this);
    }

    @Override // s3.c
    public final Bitmap a() {
        return getBitmap(Bitmap.createBitmap(getSizeW(), getSizeH(), Bitmap.Config.RGB_565));
    }

    @Override // s3.c
    public final void b(d dVar, boolean z3) {
        if (z3) {
            ((b) dVar).s(getBitmap(Bitmap.createBitmap(getSizeW(), getSizeH(), Bitmap.Config.ARGB_8888)));
            return;
        }
        ((b) dVar).s(a());
    }

    @Override // s3.c
    public final void c(File file, boolean z3, e eVar) {
        if (z3) {
            Bitmap bitmap = getBitmap(Bitmap.createBitmap(getSizeW(), getSizeH(), Bitmap.Config.ARGB_8888));
            if (bitmap == null) {
                eVar.result(false, file);
                return;
            }
            FileUtils.saveBitmap(bitmap, file);
            eVar.result(true, file);
            return;
        }
        Bitmap a5 = a();
        if (a5 == null) {
            eVar.result(false, file);
            return;
        }
        FileUtils.saveBitmap(a5, file);
        eVar.result(true, file);
    }

    @Override // s3.c
    public final void d() {
        Debuger.printfLog(getClass().getSimpleName().concat(" not support onRenderResume now"));
    }

    @Override // com.shuyu.gsyvideoplayer.utils.MeasureHelper.MeasureFormVideoParamsListener
    public int getCurrentVideoHeight() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.b;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getCurrentVideoHeight();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.utils.MeasureHelper.MeasureFormVideoParamsListener
    public int getCurrentVideoWidth() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.b;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getCurrentVideoWidth();
        }
        return 0;
    }

    public t3.c getIGSYSurfaceListener() {
        return this.f1137a;
    }

    @Override // s3.c
    public View getRenderView() {
        return this;
    }

    public int getSizeH() {
        return getHeight();
    }

    public int getSizeW() {
        return getWidth();
    }

    @Override // com.shuyu.gsyvideoplayer.utils.MeasureHelper.MeasureFormVideoParamsListener
    public int getVideoSarDen() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.b;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getVideoSarDen();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.utils.MeasureHelper.MeasureFormVideoParamsListener
    public int getVideoSarNum() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.b;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getVideoSarNum();
        }
        return 0;
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i5) {
        this.c.prepareMeasure(i3, i5, (int) getRotation());
        setMeasuredDimension(this.c.getMeasuredWidth(), this.c.getMeasuredHeight());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i5) {
        if (GSYVideoType.isMediaCodecTexture()) {
            SurfaceTexture surfaceTexture2 = this.d;
            if (surfaceTexture2 == null) {
                this.d = surfaceTexture;
                this.f1138e = new Surface(surfaceTexture);
            } else {
                setSurfaceTexture(surfaceTexture2);
            }
            t3.c cVar = this.f1137a;
            if (cVar != null) {
                cVar.onSurfaceAvailable(this.f1138e);
                return;
            }
            return;
        }
        Surface surface = new Surface(surfaceTexture);
        this.f1138e = surface;
        t3.c cVar2 = this.f1137a;
        if (cVar2 != null) {
            cVar2.onSurfaceAvailable(surface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        t3.c cVar = this.f1137a;
        if (cVar != null) {
            cVar.onSurfaceDestroyed(this.f1138e);
        }
        if (!GSYVideoType.isMediaCodecTexture() || this.d == null) {
            return true;
        }
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i5) {
        t3.c cVar = this.f1137a;
        if (cVar != null) {
            cVar.onSurfaceSizeChanged(this.f1138e, i3, i5);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        t3.c cVar = this.f1137a;
        if (cVar != null) {
            cVar.onSurfaceUpdated(this.f1138e);
        }
    }

    @Override // s3.c
    public void setGLEffectFilter(s3.b bVar) {
        Debuger.printfLog(getClass().getSimpleName().concat(" not support setGLEffectFilter now"));
    }

    @Override // s3.c
    public void setGLMVPMatrix(float[] fArr) {
        Debuger.printfLog(getClass().getSimpleName().concat(" not support setGLMVPMatrix now"));
    }

    @Override // s3.c
    public void setGLRenderer(a aVar) {
        Debuger.printfLog(getClass().getSimpleName().concat(" not support setGLRenderer now"));
    }

    public void setIGSYSurfaceListener(t3.c cVar) {
        setSurfaceTextureListener(this);
        this.f1137a = cVar;
    }

    @Override // s3.c
    public void setRenderMode(int i3) {
        Debuger.printfLog(getClass().getSimpleName().concat(" not support setRenderMode now"));
    }

    public void setRenderTransform(Matrix matrix) {
        setTransform(matrix);
    }

    public void setVideoParamsListener(MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener) {
        this.b = measureFormVideoParamsListener;
    }

    public GSYTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new MeasureHelper(this, this);
    }
}
