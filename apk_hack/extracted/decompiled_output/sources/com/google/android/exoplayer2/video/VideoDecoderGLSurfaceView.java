package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import h2.i;
import h2.j;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class VideoDecoderGLSurfaceView extends GLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    public final j f500a;

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    public i getVideoDecoderOutputBufferRenderer() {
        return this.f500a;
    }

    public VideoDecoderGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j jVar = new j();
        this.f500a = jVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(jVar);
        setRenderMode(0);
    }
}
