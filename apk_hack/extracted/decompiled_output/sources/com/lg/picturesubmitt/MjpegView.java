package com.lg.picturesubmitt;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import f2.p;
import s2.b;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MjpegView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    public p f540a;
    public Paint b;

    public MjpegView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        this.f540a = new p(this, holder);
        setFocusable(true);
        Paint paint = new Paint();
        this.b = paint;
        paint.setTextAlign(Paint.Align.LEFT);
        this.b.setTextSize(12.0f);
        this.b.setTypeface(Typeface.DEFAULT);
        getWidth();
        getHeight();
    }

    public void setDisplayMode(int i3) {
    }

    public void setOverlayBackgroundColor(int i3) {
    }

    public void setOverlayPaint(Paint paint) {
        this.b = paint;
    }

    public void setOverlayPosition(int i3) {
    }

    public void setOverlayTextColor(int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i5, int i6) {
        p pVar = this.f540a;
        synchronized (((SurfaceHolder) pVar.b)) {
            ((MjpegView) pVar.c).getClass();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean z3 = true;
        while (z3) {
            try {
                this.f540a.join();
                z3 = false;
            } catch (InterruptedException unused) {
            }
        }
    }

    public MjpegView(Context context) {
        super(context);
        a();
    }

    public void setSource(b bVar) {
    }
}
