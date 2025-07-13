package com.showview;

import a1.i;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MyGLRender implements GLSurfaceView.Renderer {
    static final String TAG = "MyGLRender";
    private GLSurfaceView mTargetSurface;

    /* renamed from: u  reason: collision with root package name */
    private ByteBuffer f1131u;

    /* renamed from: v  reason: collision with root package name */
    private ByteBuffer f1132v;

    /* renamed from: y  reason: collision with root package name */
    private ByteBuffer f1133y;
    private GLProgram prog = new GLProgram(1);
    private int mVideoWidth = -1;
    private int mVideoHeight = -1;

    public MyGLRender(GLSurfaceView gLSurfaceView) {
        this.mTargetSurface = gLSurfaceView;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        synchronized (this) {
            try {
                ByteBuffer byteBuffer = this.f1133y;
                if (byteBuffer != null) {
                    byteBuffer.position(0);
                    this.f1131u.position(0);
                    this.f1132v.position(0);
                    this.prog.buildTextures(this.f1133y, this.f1131u, this.f1132v, this.mVideoWidth, this.mVideoHeight);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16384);
                    this.prog.drawFrame();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i3, int i5) {
        i.s("GLFrameRenderer :: onSurfaceChanged width=", i3, "height=", i5, TAG);
        GLES20.glViewport(0, 0, i3, i5);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.d(TAG, "GLFrameRenderer :: onSurfaceCreated");
        if (!this.prog.isProgramBuilt()) {
            this.prog.buildProgram();
            Log.d(TAG, "GLFrameRenderer :: buildProgram done");
        }
    }

    public void update(int i3, int i5) {
        if (i3 <= 0 || i5 <= 0 || i3 == this.mVideoWidth || i5 == this.mVideoHeight) {
            return;
        }
        this.mVideoWidth = i3;
        this.mVideoHeight = i5;
        int i6 = i3 * i5;
        int i7 = i6 / 4;
        synchronized (this) {
            this.f1133y = ByteBuffer.allocate(i6);
            this.f1131u = ByteBuffer.allocate(i7);
            this.f1132v = ByteBuffer.allocate(i7);
        }
    }

    public void update(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        synchronized (this) {
            this.f1133y.clear();
            this.f1131u.clear();
            this.f1132v.clear();
            this.f1133y.put(bArr, 0, bArr.length);
            this.f1131u.put(bArr2, 0, bArr2.length);
            this.f1132v.put(bArr3, 0, bArr3.length);
        }
        this.mTargetSurface.requestRender();
    }

    public void update(byte[] bArr, int i3, int i5) {
        synchronized (this) {
            int i6 = i3 * i5;
            try {
                int i7 = i6 / 4;
                if (i3 != this.mVideoWidth) {
                    this.mVideoWidth = i3;
                    this.mVideoHeight = i5;
                    this.f1133y = ByteBuffer.allocate(i6);
                    this.f1131u = ByteBuffer.allocate(i7);
                    this.f1132v = ByteBuffer.allocate(i7);
                } else {
                    this.f1133y.clear();
                    this.f1131u.clear();
                    this.f1132v.clear();
                }
                this.f1133y.put(bArr, 0, i6);
                this.f1131u.put(bArr, i6, i6 / 4);
                this.f1132v.put(bArr, (i6 * 5) / 4, i6 / 4);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mTargetSurface.requestRender();
    }

    public void update(byte[] bArr) {
        synchronized (this) {
            int i3 = this.mVideoHeight * this.mVideoWidth;
            this.f1133y.clear();
            this.f1131u.clear();
            this.f1132v.clear();
            this.f1133y.put(bArr, 0, i3);
            this.f1131u.put(bArr, i3, i3 / 4);
            this.f1132v.put(bArr, (i3 * 5) / 4, i3 / 4);
        }
        this.mTargetSurface.requestRender();
    }
}
