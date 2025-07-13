package h2;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer2.video.DummySurface;
import g2.w;
import java.util.Locale;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends HandlerThread implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public g2.f f1988a;
    public Handler b;
    public Error c;
    public RuntimeException d;

    /* renamed from: e  reason: collision with root package name */
    public DummySurface f1989e;

    public final void a(int i3) {
        EGLConfig eGLConfig;
        EGLSurface eglCreatePbufferSurface;
        this.f1988a.getClass();
        g2.f fVar = this.f1988a;
        fVar.getClass();
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay != null) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                fVar.c = eglGetDisplay;
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr2 = new int[1];
                boolean eglChooseConfig = EGL14.eglChooseConfig(eglGetDisplay, g2.f.f1919g, 0, eGLConfigArr, 0, 1, iArr2, 0);
                if (eglChooseConfig && iArr2[0] > 0 && (eGLConfig = eGLConfigArr[0]) != null) {
                    EGLContext eglCreateContext = EGL14.eglCreateContext(fVar.c, eGLConfig, EGL14.EGL_NO_CONTEXT, i3 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
                    if (eglCreateContext != null) {
                        fVar.d = eglCreateContext;
                        EGLDisplay eGLDisplay = fVar.c;
                        if (i3 == 1) {
                            eglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
                        } else {
                            eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i3 == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                            if (eglCreatePbufferSurface == null) {
                                throw new RuntimeException("eglCreatePbufferSurface failed");
                            }
                        }
                        if (EGL14.eglMakeCurrent(eGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext)) {
                            fVar.f1921e = eglCreatePbufferSurface;
                            int[] iArr3 = fVar.b;
                            GLES20.glGenTextures(1, iArr3, 0);
                            g2.b.f();
                            SurfaceTexture surfaceTexture = new SurfaceTexture(iArr3[0]);
                            fVar.f1922f = surfaceTexture;
                            surfaceTexture.setOnFrameAvailableListener(fVar);
                            SurfaceTexture surfaceTexture2 = this.f1988a.f1922f;
                            surfaceTexture2.getClass();
                            this.f1989e = new DummySurface(this, surfaceTexture2);
                            return;
                        }
                        throw new RuntimeException("eglMakeCurrent failed");
                    }
                    throw new RuntimeException("eglCreateContext failed");
                }
                Object[] objArr = {Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr2[0]), eGLConfigArr[0]};
                int i5 = w.f1960a;
                throw new RuntimeException(String.format(Locale.US, "eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", objArr));
            }
            throw new RuntimeException("eglInitialize failed");
        }
        throw new RuntimeException("eglGetDisplay failed");
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.opengl.EGLContext, android.graphics.SurfaceTexture, android.opengl.EGLSurface, android.opengl.EGLDisplay] */
    public final void b() {
        this.f1988a.getClass();
        g2.f fVar = this.f1988a;
        fVar.f1920a.removeCallbacks(fVar);
        try {
            SurfaceTexture surfaceTexture = fVar.f1922f;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, fVar.b, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = fVar.c;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = fVar.c;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = fVar.f1921e;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(fVar.c, fVar.f1921e);
            }
            EGLContext eGLContext = fVar.d;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(fVar.c, eGLContext);
            }
            if (w.f1960a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = fVar.c;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(fVar.c);
            }
            fVar.c = null;
            fVar.d = null;
            fVar.f1921e = null;
            fVar.f1922f = null;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i3 = message.what;
        try {
            if (i3 != 1) {
                if (i3 != 2) {
                    return true;
                }
                try {
                    b();
                } finally {
                    try {
                        return true;
                    } finally {
                    }
                }
                return true;
            }
            try {
                a(message.arg1);
                synchronized (this) {
                    notify();
                }
            } catch (Error e5) {
                Log.e("DummySurface", "Failed to initialize dummy surface", e5);
                this.c = e5;
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e6) {
                Log.e("DummySurface", "Failed to initialize dummy surface", e6);
                this.d = e6;
                synchronized (this) {
                    notify();
                }
            }
            return true;
        } catch (Throwable th) {
            synchronized (this) {
                notify();
                throw th;
            }
        }
    }
}
