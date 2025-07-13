package com.shuyu.gsyvideoplayer.video.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.shuyu.gsyvideoplayer.render.view.GSYSurfaceView;
import com.shuyu.gsyvideoplayer.render.view.GSYTextureView;
import com.shuyu.gsyvideoplayer.render.view.GSYVideoGLView;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.utils.MeasureHelper;
import r3.a;
import s3.b;
import t3.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class GSYTextureRenderView extends FrameLayout implements c, MeasureHelper.MeasureFormVideoParamsListener {
    protected b mEffectFilter;
    protected Bitmap mFullPauseBitmap;
    protected float[] mMatrixGL;
    protected int mMode;
    protected a mRenderer;
    protected int mRotate;
    protected Surface mSurface;
    protected p3.a mTextureView;
    protected ViewGroup mTextureViewContainer;

    public GSYTextureRenderView(@NonNull Context context) {
        super(context);
        this.mEffectFilter = new j3.b(23);
        this.mMatrixGL = null;
        this.mMode = 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [p3.a, java.lang.Object] */
    public void addTextureView() {
        ?? obj = new Object();
        this.mTextureView = obj;
        Context context = getContext();
        ViewGroup viewGroup = this.mTextureViewContainer;
        int i3 = this.mRotate;
        b bVar = this.mEffectFilter;
        float[] fArr = this.mMatrixGL;
        a aVar = this.mRenderer;
        int i5 = this.mMode;
        if (GSYVideoType.getRenderType() == 1) {
            int i6 = GSYSurfaceView.d;
            if (viewGroup.getChildCount() > 0) {
                viewGroup.removeAllViews();
            }
            GSYSurfaceView gSYSurfaceView = new GSYSurfaceView(context);
            gSYSurfaceView.setIGSYSurfaceListener(this);
            gSYSurfaceView.setVideoParamsListener(this);
            gSYSurfaceView.setRotation(i3);
            p3.a.a(viewGroup, gSYSurfaceView);
            obj.f3226a = gSYSurfaceView;
        } else if (GSYVideoType.getRenderType() == 2) {
            obj.f3226a = GSYVideoGLView.e(context, viewGroup, i3, this, this, bVar, fArr, aVar, i5);
        } else {
            int i7 = GSYTextureView.f1136f;
            if (viewGroup.getChildCount() > 0) {
                viewGroup.removeAllViews();
            }
            GSYTextureView gSYTextureView = new GSYTextureView(context);
            gSYTextureView.setIGSYSurfaceListener(this);
            gSYTextureView.setVideoParamsListener(this);
            gSYTextureView.setRotation(i3);
            p3.a.a(viewGroup, gSYTextureView);
            obj.f3226a = gSYTextureView;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [s3.c, android.view.View] */
    /* JADX WARN: Type inference failed for: r1v1, types: [s3.c, android.view.View] */
    public void changeTextureViewShowType() {
        if (this.mTextureView != null) {
            int textureParams = getTextureParams();
            ViewGroup.LayoutParams layoutParams = this.mTextureView.f3226a.getRenderView().getLayoutParams();
            layoutParams.width = textureParams;
            layoutParams.height = textureParams;
            ?? r02 = this.mTextureView.f3226a;
            if (r02 != 0) {
                r02.getRenderView().setLayoutParams(layoutParams);
            }
        }
    }

    public b getEffectFilter() {
        return this.mEffectFilter;
    }

    public p3.a getRenderProxy() {
        return this.mTextureView;
    }

    public int getTextureParams() {
        if (GSYVideoType.getShowType() != 0) {
            return -2;
        }
        return -1;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [s3.c, android.view.View] */
    public void initCover() {
        Bitmap bitmap;
        p3.a aVar = this.mTextureView;
        if (aVar != null) {
            ?? r02 = aVar.f3226a;
            if (r02 != 0) {
                bitmap = r02.a();
            } else {
                bitmap = null;
            }
            this.mFullPauseBitmap = bitmap;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [s3.c, android.view.View] */
    @Override // t3.c
    public void onSurfaceAvailable(Surface surface) {
        boolean z3;
        View view;
        p3.a aVar = this.mTextureView;
        if (aVar != null) {
            ?? r02 = aVar.f3226a;
            if (r02 != 0) {
                view = r02.getRenderView();
            } else {
                view = null;
            }
            if (view instanceof TextureView) {
                z3 = true;
                pauseLogic(surface, z3);
            }
        }
        z3 = false;
        pauseLogic(surface, z3);
    }

    @Override // t3.c
    public boolean onSurfaceDestroyed(Surface surface) {
        setDisplay(null);
        releaseSurface(surface);
        return true;
    }

    @Override // t3.c
    public void onSurfaceSizeChanged(Surface surface, int i3, int i5) {
    }

    @Override // t3.c
    public void onSurfaceUpdated(Surface surface) {
        releasePauseCover();
    }

    public void pauseLogic(Surface surface, boolean z3) {
        this.mSurface = surface;
        if (z3) {
            showPauseCover();
        }
        setDisplay(this.mSurface);
    }

    public abstract void releasePauseCover();

    public abstract void releaseSurface(Surface surface);

    /* JADX WARN: Type inference failed for: r0v1, types: [s3.c, android.view.View] */
    public void setCustomGLRenderer(a aVar) {
        ?? r02;
        this.mRenderer = aVar;
        p3.a aVar2 = this.mTextureView;
        if (aVar2 != null && (r02 = aVar2.f3226a) != 0) {
            r02.setGLRenderer(aVar);
        }
    }

    public abstract void setDisplay(Surface surface);

    /* JADX WARN: Type inference failed for: r0v1, types: [s3.c, android.view.View] */
    public void setEffectFilter(b bVar) {
        ?? r02;
        this.mEffectFilter = bVar;
        p3.a aVar = this.mTextureView;
        if (aVar != null && (r02 = aVar.f3226a) != 0) {
            r02.setGLEffectFilter(bVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [s3.c, android.view.View] */
    public void setGLRenderMode(int i3) {
        ?? r02;
        this.mMode = i3;
        p3.a aVar = this.mTextureView;
        if (aVar != null && (r02 = aVar.f3226a) != 0) {
            r02.setRenderMode(i3);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [s3.c, android.view.View] */
    public void setMatrixGL(float[] fArr) {
        ?? r02;
        this.mMatrixGL = fArr;
        p3.a aVar = this.mTextureView;
        if (aVar != null && (r02 = aVar.f3226a) != 0) {
            r02.setGLMVPMatrix(fArr);
        }
    }

    public abstract void setSmallVideoTextureView();

    public void setSmallVideoTextureView(View.OnTouchListener onTouchListener) {
        this.mTextureViewContainer.setOnTouchListener(onTouchListener);
        this.mTextureViewContainer.setOnClickListener(null);
        setSmallVideoTextureView();
    }

    public abstract void showPauseCover();

    public GSYTextureRenderView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEffectFilter = new j3.b(23);
        this.mMatrixGL = null;
        this.mMode = 0;
    }

    public GSYTextureRenderView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i3) {
        super(context, attributeSet, i3);
        this.mEffectFilter = new j3.b(23);
        this.mMatrixGL = null;
        this.mMode = 0;
    }
}
