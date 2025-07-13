package com.google.android.exoplayer2.ui.spherical;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import d2.b;
import d2.f;
import d2.g;
import d2.i;
import d2.j;
import g2.w;
import j0.h;
import j0.k0;
import j0.m0;
import j0.q0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    public final SensorManager f488a;
    public final Sensor b;
    public final b c;
    public final Handler d;

    /* renamed from: e  reason: collision with root package name */
    public final j f489e;

    /* renamed from: f  reason: collision with root package name */
    public final f f490f;

    /* renamed from: g  reason: collision with root package name */
    public SurfaceTexture f491g;

    /* renamed from: h  reason: collision with root package name */
    public Surface f492h;

    /* renamed from: i  reason: collision with root package name */
    public k0 f493i;

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d.post(new c2.b(2, this));
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        if (this.b != null) {
            this.f488a.unregisterListener(this.c);
        }
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        Sensor sensor = this.b;
        if (sensor != null) {
            this.f488a.registerListener(this.c, sensor, 0);
        }
    }

    public void setDefaultStereoMode(int i3) {
        this.f490f.f1623k = i3;
    }

    public void setSingleTapListener(@Nullable g gVar) {
        this.f489e.f1638g = gVar;
    }

    public void setVideoComponent(@Nullable k0 k0Var) {
        h[] hVarArr;
        h[] hVarArr2;
        h[] hVarArr3;
        h[] hVarArr4;
        k0 k0Var2 = this.f493i;
        if (k0Var == k0Var2) {
            return;
        }
        f fVar = this.f490f;
        if (k0Var2 != null) {
            Surface surface = this.f492h;
            if (surface != null) {
                q0 q0Var = (q0) k0Var2;
                q0Var.P();
                if (surface == q0Var.q) {
                    q0Var.P();
                    q0Var.F();
                    q0Var.L(null, false);
                    q0Var.D(0, 0);
                }
            }
            q0 q0Var2 = (q0) this.f493i;
            q0Var2.P();
            if (q0Var2.A == fVar) {
                for (h hVar : q0Var2.b) {
                    if (hVar.f2246a == 2) {
                        m0 D = q0Var2.c.D(hVar);
                        D.d(6);
                        D.c(null);
                        D.b();
                    }
                }
            }
            q0 q0Var3 = (q0) this.f493i;
            q0Var3.P();
            if (q0Var3.B == fVar) {
                for (h hVar2 : q0Var3.b) {
                    if (hVar2.f2246a == 5) {
                        m0 D2 = q0Var3.c.D(hVar2);
                        D2.d(7);
                        D2.c(null);
                        D2.b();
                    }
                }
            }
        }
        this.f493i = k0Var;
        if (k0Var != null) {
            q0 q0Var4 = (q0) k0Var;
            q0Var4.P();
            q0Var4.A = fVar;
            for (h hVar3 : q0Var4.b) {
                if (hVar3.f2246a == 2) {
                    m0 D3 = q0Var4.c.D(hVar3);
                    D3.d(6);
                    D3.c(fVar);
                    D3.b();
                }
            }
            q0 q0Var5 = (q0) this.f493i;
            q0Var5.P();
            q0Var5.B = fVar;
            for (h hVar4 : q0Var5.b) {
                if (hVar4.f2246a == 5) {
                    m0 D4 = q0Var5.c.D(hVar4);
                    D4.d(7);
                    D4.c(fVar);
                    D4.b();
                }
            }
            ((q0) this.f493i).J(this.f492h);
        }
    }

    public SphericalGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("sensor");
        systemService.getClass();
        SensorManager sensorManager = (SensorManager) systemService;
        this.f488a = sensorManager;
        Sensor defaultSensor = w.f1960a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.b = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        f fVar = new f();
        this.f490f = fVar;
        i iVar = new i(this, fVar);
        j jVar = new j(context, iVar);
        this.f489e = jVar;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getClass();
        this.c = new b(windowManager.getDefaultDisplay(), jVar, iVar);
        setEGLContextClientVersion(2);
        setRenderer(iVar);
        setOnTouchListener(jVar);
    }
}
