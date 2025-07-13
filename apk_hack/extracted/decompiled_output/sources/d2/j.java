package d2;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.ui.PlayerView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, a {
    public final i c;

    /* renamed from: e  reason: collision with root package name */
    public final GestureDetector f1636e;

    /* renamed from: g  reason: collision with root package name */
    public g f1638g;

    /* renamed from: a  reason: collision with root package name */
    public final PointF f1635a = new PointF();
    public final PointF b = new PointF();
    public final float d = 25.0f;

    /* renamed from: f  reason: collision with root package name */
    public volatile float f1637f = 3.1415927f;

    public j(Context context, i iVar) {
        this.c = iVar;
        this.f1636e = new GestureDetector(context, this);
    }

    @Override // d2.a
    public final void a(float[] fArr, float f4) {
        this.f1637f = -f4;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.f1635a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        float x3 = (motionEvent2.getX() - this.f1635a.x) / this.d;
        float y3 = motionEvent2.getY();
        PointF pointF = this.f1635a;
        float f6 = (y3 - pointF.y) / this.d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d = this.f1637f;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        PointF pointF2 = this.b;
        pointF2.x -= (cos * x3) - (sin * f6);
        float f7 = (cos * f6) + (sin * x3) + pointF2.y;
        pointF2.y = f7;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f7));
        i iVar = this.c;
        PointF pointF3 = this.b;
        synchronized (iVar) {
            float f8 = pointF3.y;
            iVar.f1630g = f8;
            Matrix.setRotateM(iVar.f1628e, 0, -f8, (float) Math.cos(iVar.f1631h), (float) Math.sin(iVar.f1631h), 0.0f);
            Matrix.setRotateM(iVar.f1629f, 0, -pointF3.x, 0.0f, 1.0f, 0.0f);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        g gVar = this.f1638g;
        if (gVar != null) {
            c2.g gVar2 = (c2.g) gVar;
            gVar2.getClass();
            int i3 = PlayerView.f460z;
            return gVar2.f204a.g();
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f1636e.onTouchEvent(motionEvent);
    }
}
