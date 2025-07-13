package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import g2.f;
import g2.w;
import h2.b;
@TargetApi(17)
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class DummySurface extends Surface {
    public static int c;
    public static boolean d;

    /* renamed from: a  reason: collision with root package name */
    public final b f499a;
    public boolean b;

    public DummySurface(b bVar, SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
        this.f499a = bVar;
    }

    public static int c(Context context) {
        String eglQueryString;
        String eglQueryString2;
        int i3 = w.f1960a;
        if (i3 < 24 || ((i3 < 26 && ("samsung".equals(w.c) || "XT1650".equals(w.d))) || ((i3 < 26 && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) || (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) == null || !eglQueryString.contains("EGL_EXT_protected_content")))) {
            return 0;
        }
        if (i3 >= 17 && (eglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString2.contains("EGL_KHR_surfaceless_context")) {
            return 1;
        }
        return 2;
    }

    public static synchronized boolean d(Context context) {
        boolean z3;
        synchronized (DummySurface.class) {
            try {
                z3 = true;
                if (!d) {
                    c = c(context);
                    d = true;
                }
                if (c == 0) {
                    z3 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z3;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [android.os.HandlerThread, java.lang.Thread, android.os.Handler$Callback, java.lang.Object, h2.b] */
    public static DummySurface e(Context context, boolean z3) {
        boolean z5;
        int i3;
        if (w.f1960a >= 17) {
            boolean z6 = false;
            if (z3 && !d(context)) {
                z5 = false;
            } else {
                z5 = true;
            }
            g2.b.h(z5);
            ?? handlerThread = new HandlerThread("dummySurface");
            if (z3) {
                i3 = c;
            } else {
                i3 = 0;
            }
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper(), handlerThread);
            handlerThread.b = handler;
            handlerThread.f1988a = new f(handler);
            synchronized (handlerThread) {
                handlerThread.b.obtainMessage(1, i3, 0).sendToTarget();
                while (handlerThread.f1989e == null && handlerThread.d == null && handlerThread.c == null) {
                    try {
                        handlerThread.wait();
                    } catch (InterruptedException unused) {
                        z6 = true;
                    }
                }
            }
            if (z6) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = handlerThread.d;
            if (runtimeException == null) {
                Error error = handlerThread.c;
                if (error == null) {
                    DummySurface dummySurface = handlerThread.f1989e;
                    dummySurface.getClass();
                    return dummySurface;
                }
                throw error;
            }
            throw runtimeException;
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.f499a) {
            try {
                if (!this.b) {
                    b bVar = this.f499a;
                    bVar.b.getClass();
                    bVar.b.sendEmptyMessage(2);
                    this.b = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
