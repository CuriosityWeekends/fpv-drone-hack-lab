package com.lg.picturesubmitt.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.bugly.proguard.c0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class FFSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    public String f894a;

    static {
        System.loadLibrary("ffplay-lib");
    }

    public FFSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    private native int isPlaying();

    private native void pause();

    private native void resume();

    private native void setSurface(Surface surface);

    private native void start(String str);

    private native void stop();

    public abstract void a(Canvas canvas);

    public final void b() {
        pause();
    }

    public final void c() {
        resume();
    }

    public final void d(String str) {
        this.f894a = str;
        start(str);
    }

    public final void e() {
        stop();
    }

    public int getStatus() {
        return isPlaying();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i5, int i6) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        new Thread(new c0(11, this, surfaceHolder)).start();
        setSurface(surfaceHolder.getSurface());
        if (!TextUtils.isEmpty(this.f894a)) {
            d(this.f894a);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        stop();
    }

    public FFSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getHolder().addCallback(this);
    }

    public FFSurfaceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        getHolder().addCallback(this);
    }
}
