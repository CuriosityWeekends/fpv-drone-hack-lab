package com.shuyu.gsyvideoplayer.render.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.MeasureHelper;
import java.io.File;
import n3.d;
import n3.e;
import s3.b;
import s3.c;
import t3.a;
@SuppressLint({"ViewConstructor"})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GSYVideoGLView extends GLSurfaceView implements a, c, MeasureHelper.MeasureFormVideoParamsListener {

    /* renamed from: a  reason: collision with root package name */
    public r3.a f1139a;
    public b b;
    public MeasureHelper.MeasureFormVideoParamsListener c;
    public final MeasureHelper d;

    /* renamed from: e  reason: collision with root package name */
    public t3.c f1140e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f1141f;

    /* renamed from: g  reason: collision with root package name */
    public int f1142g;

    public GSYVideoGLView(Context context) {
        super(context);
        this.b = new j3.b(23);
        this.f1142g = 0;
        setEGLContextClientVersion(2);
        this.f1139a = new r3.b();
        this.d = new MeasureHelper(this, this);
        this.f1139a.c = this;
    }

    public static GSYVideoGLView e(Context context, ViewGroup viewGroup, int i3, t3.c cVar, MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener, b bVar, float[] fArr, r3.a aVar, int i5) {
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        GSYVideoGLView gSYVideoGLView = new GSYVideoGLView(context);
        if (aVar != null) {
            gSYVideoGLView.setCustomRenderer(aVar);
        }
        gSYVideoGLView.setEffect(bVar);
        gSYVideoGLView.setVideoParamsListener(measureFormVideoParamsListener);
        gSYVideoGLView.setRenderMode(i5);
        gSYVideoGLView.setIGSYSurfaceListener(cVar);
        gSYVideoGLView.setRotation(i3);
        gSYVideoGLView.setRenderer(gSYVideoGLView.f1139a);
        gSYVideoGLView.setGSYVideoGLRenderErrorListener(new s3.a(context, viewGroup, i3, cVar, measureFormVideoParamsListener, i5));
        if (fArr != null && fArr.length == 16) {
            gSYVideoGLView.setMVPMatrix(fArr);
        }
        p3.a.a(viewGroup, gSYVideoGLView);
        return gSYVideoGLView;
    }

    @Override // s3.c
    public final Bitmap a() {
        Debuger.printfLog(getClass().getSimpleName().concat(" not support initCover now"));
        return null;
    }

    @Override // s3.c
    public final void b(d dVar, boolean z3) {
        if (dVar != null) {
            r3.a aVar = this.f1139a;
            r3.b bVar = (r3.b) aVar;
            bVar.f3454v = dVar;
            bVar.f3438a = z3;
            ((r3.b) aVar).s = true;
        }
    }

    @Override // s3.c
    public final void c(File file, boolean z3, e eVar) {
        c1.b bVar = new c1.b(18, eVar, file, false);
        r3.a aVar = this.f1139a;
        r3.b bVar2 = (r3.b) aVar;
        bVar2.f3454v = bVar;
        bVar2.f3438a = z3;
        ((r3.b) aVar).s = true;
    }

    @Override // s3.c
    public final void d() {
        requestLayout();
        onResume();
    }

    public final void f() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.c;
        if (measureFormVideoParamsListener != null && this.f1142g == 1) {
            try {
                measureFormVideoParamsListener.getCurrentVideoWidth();
                this.c.getCurrentVideoHeight();
                r3.a aVar = this.f1139a;
                if (aVar != null) {
                    aVar.f3440f = this.d.getMeasuredWidth();
                    this.f1139a.f3441g = this.d.getMeasuredHeight();
                    this.f1139a.getClass();
                    this.f1139a.getClass();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    @Override // com.shuyu.gsyvideoplayer.utils.MeasureHelper.MeasureFormVideoParamsListener
    public int getCurrentVideoHeight() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.c;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getCurrentVideoHeight();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.utils.MeasureHelper.MeasureFormVideoParamsListener
    public int getCurrentVideoWidth() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.c;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getCurrentVideoWidth();
        }
        return 0;
    }

    public b getEffect() {
        return this.b;
    }

    public t3.c getIGSYSurfaceListener() {
        return this.f1140e;
    }

    public float[] getMVPMatrix() {
        return this.f1141f;
    }

    public int getMode() {
        return this.f1142g;
    }

    @Override // s3.c
    public View getRenderView() {
        return this;
    }

    public r3.a getRenderer() {
        return this.f1139a;
    }

    public int getSizeH() {
        return getHeight();
    }

    public int getSizeW() {
        return getWidth();
    }

    @Override // com.shuyu.gsyvideoplayer.utils.MeasureHelper.MeasureFormVideoParamsListener
    public int getVideoSarDen() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.c;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getVideoSarDen();
        }
        return 0;
    }

    @Override // com.shuyu.gsyvideoplayer.utils.MeasureHelper.MeasureFormVideoParamsListener
    public int getVideoSarNum() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.c;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getVideoSarNum();
        }
        return 0;
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onMeasure(int i3, int i5) {
        if (this.f1142g == 1) {
            super.onMeasure(i3, i5);
            this.d.prepareMeasure(i3, i5, (int) getRotation());
            f();
            return;
        }
        this.d.prepareMeasure(i3, i5, (int) getRotation());
        setMeasuredDimension(this.d.getMeasuredWidth(), this.d.getMeasuredHeight());
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        int i3;
        super.onResume();
        r3.a aVar = this.f1139a;
        if (aVar != null && (i3 = aVar.f3440f) != 0 && aVar.f3441g != 0) {
            Matrix.scaleM(aVar.d, 0, i3 / aVar.c.getWidth(), aVar.f3441g / aVar.c.getHeight(), 1.0f);
        }
    }

    public void setCustomRenderer(r3.a aVar) {
        this.f1139a = aVar;
        aVar.c = this;
        f();
    }

    public void setEffect(b bVar) {
        if (bVar != null) {
            this.b = bVar;
            r3.b bVar2 = (r3.b) this.f1139a;
            bVar2.w = bVar;
            bVar2.f3442h = true;
            bVar2.f3443i = true;
        }
    }

    @Override // s3.c
    public void setGLEffectFilter(b bVar) {
        setEffect(bVar);
    }

    @Override // s3.c
    public void setGLMVPMatrix(float[] fArr) {
        setMVPMatrix(fArr);
    }

    @Override // s3.c
    public void setGLRenderer(r3.a aVar) {
        setCustomRenderer(aVar);
    }

    public void setGSYVideoGLRenderErrorListener(t3.b bVar) {
        this.f1139a.f3444j = bVar;
    }

    public void setIGSYSurfaceListener(t3.c cVar) {
        setOnGSYSurfaceListener(this);
        this.f1140e = cVar;
    }

    public void setMVPMatrix(float[] fArr) {
        if (fArr != null) {
            this.f1141f = fArr;
            this.f1139a.d = fArr;
        }
    }

    public void setMode(int i3) {
        this.f1142g = i3;
    }

    public void setOnGSYSurfaceListener(a aVar) {
        this.f1139a.b = aVar;
    }

    @Override // android.opengl.GLSurfaceView, s3.c
    public void setRenderMode(int i3) {
        setMode(i3);
    }

    public void setRenderTransform(android.graphics.Matrix matrix) {
        Debuger.printfLog(getClass().getSimpleName().concat(" not support setRenderTransform now"));
    }

    public void setVideoParamsListener(MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener) {
        this.c = measureFormVideoParamsListener;
    }

    public GSYVideoGLView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new j3.b(23);
        this.f1142g = 0;
        setEGLContextClientVersion(2);
        this.f1139a = new r3.b();
        this.d = new MeasureHelper(this, this);
        this.f1139a.c = this;
    }
}
