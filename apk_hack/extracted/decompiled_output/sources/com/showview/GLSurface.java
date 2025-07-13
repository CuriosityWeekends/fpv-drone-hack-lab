package com.showview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GLSurface extends GLSurfaceView {
    static final String TAG = "GLSuface";

    public GLSurface(Context context) {
        super(context);
        setEGLContextClientVersion(2);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onAttachedToWindow() {
        Log.d(TAG, "surface onAttachedToWindow()");
        super.onAttachedToWindow();
        setRenderMode(0);
        Log.d(TAG, "surface setRenderMode RENDERMODE_WHEN_DIRTY");
    }

    public GLSurface(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setEGLContextClientVersion(2);
    }
}
