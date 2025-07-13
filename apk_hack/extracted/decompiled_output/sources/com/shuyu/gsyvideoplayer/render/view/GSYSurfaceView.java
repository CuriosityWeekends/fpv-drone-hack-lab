package com.shuyu.gsyvideoplayer.render.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.MeasureHelper;
import java.io.File;
import n3.d;
import n3.e;
import r3.a;
import s3.b;
import s3.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GSYSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, c, MeasureHelper.MeasureFormVideoParamsListener {
    public static final /* synthetic */ int d = 0;

    /* renamed from: a  reason: collision with root package name */
    public t3.c f1135a;
    public MeasureHelper.MeasureFormVideoParamsListener b;
    public final MeasureHelper c;

    public GSYSurfaceView(Context context) {
        super(context);
        this.c = new MeasureHelper(this, this);
    }

    @Override // s3.c
    public final Bitmap a() {
        Debuger.printfLog(getClass().getSimpleName().concat(" not support initCover now"));
        return null;
    }

    @Override // s3.c
    public final void b(d dVar, boolean z3) {
        Debuger.printfLog(getClass().getSimpleName().concat(" not support taskShotPic now"));
    }

    @Override // s3.c
    public final void c(File file, boolean z3, e eVar) {
        Debuger.printfLog(getClass().getSimpleName().concat(" not support saveFrame now"));
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
        return this.f1135a;
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

    @Override // android.view.SurfaceView, android.view.View
    public final void onMeasure(int i3, int i5) {
        this.c.prepareMeasure(i3, i5, (int) getRotation());
        setMeasuredDimension(this.c.getMeasuredWidth(), this.c.getMeasuredHeight());
    }

    @Override // s3.c
    public void setGLEffectFilter(b bVar) {
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
        getHolder().addCallback(this);
        this.f1135a = cVar;
    }

    @Override // s3.c
    public void setRenderMode(int i3) {
        Debuger.printfLog(getClass().getSimpleName().concat(" not support setRenderMode now"));
    }

    public void setRenderTransform(Matrix matrix) {
        Debuger.printfLog(getClass().getSimpleName().concat(" not support setRenderTransform now"));
    }

    public void setVideoParamsListener(MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener) {
        this.b = measureFormVideoParamsListener;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i5, int i6) {
        t3.c cVar = this.f1135a;
        if (cVar != null) {
            cVar.onSurfaceSizeChanged(surfaceHolder.getSurface(), i5, i6);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        t3.c cVar = this.f1135a;
        if (cVar != null) {
            cVar.onSurfaceAvailable(surfaceHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        t3.c cVar = this.f1135a;
        if (cVar != null) {
            cVar.onSurfaceDestroyed(surfaceHolder.getSurface());
        }
    }

    @Override // android.view.SurfaceHolder.Callback2
    public final void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    public GSYSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new MeasureHelper(this, this);
    }
}
