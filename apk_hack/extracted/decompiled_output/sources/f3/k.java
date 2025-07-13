package f3;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k implements GestureDetector.OnDoubleTapListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1866a;
    public final /* synthetic */ Object b;

    public /* synthetic */ k(int i3, Object obj) {
        this.f1866a = i3;
        this.b = obj;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        switch (this.f1866a) {
            case 0:
                o oVar = (o) this.b;
                try {
                    float d = oVar.d();
                    float x3 = motionEvent.getX();
                    float y3 = motionEvent.getY();
                    float f4 = oVar.d;
                    if (d < f4) {
                        oVar.e(f4, x3, y3, true);
                    } else {
                        if (d >= f4) {
                            float f5 = oVar.f1875e;
                            if (d < f5) {
                                oVar.e(f5, x3, y3, true);
                            }
                        }
                        oVar.e(oVar.c, x3, y3, true);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                return true;
            default:
                i0.i iVar = (i0.i) this.b;
                try {
                    float d5 = iVar.d();
                    float x5 = motionEvent.getX();
                    float y4 = motionEvent.getY();
                    float f6 = iVar.d;
                    if (d5 < f6) {
                        iVar.e(f6, x5, y4, true);
                    } else {
                        if (d5 >= f6) {
                            float f7 = iVar.f2159e;
                            if (d5 < f7) {
                                iVar.e(f7, x5, y4, true);
                            }
                        }
                        iVar.e(iVar.c, x5, y4, true);
                    }
                } catch (ArrayIndexOutOfBoundsException unused2) {
                }
                return true;
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        switch (this.f1866a) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF rectF;
        RectF rectF2;
        switch (this.f1866a) {
            case 0:
                o oVar = (o) this.b;
                View.OnClickListener onClickListener = oVar.f1886p;
                if (onClickListener != null) {
                    onClickListener.onClick(oVar.f1878h);
                }
                oVar.b();
                Matrix c = oVar.c();
                Drawable drawable = oVar.f1878h.getDrawable();
                if (drawable != null) {
                    rectF = oVar.f1884n;
                    rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    c.mapRect(rectF);
                } else {
                    rectF = null;
                }
                float x3 = motionEvent.getX();
                float y3 = motionEvent.getY();
                if (rectF != null && rectF.contains(x3, y3)) {
                    rectF.width();
                    rectF.height();
                    return true;
                }
                return false;
            default:
                i0.i iVar = (i0.i) this.b;
                View.OnClickListener onClickListener2 = iVar.f2170p;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(iVar.f2162h);
                }
                iVar.b();
                Matrix c5 = iVar.c();
                Drawable drawable2 = iVar.f2162h.getDrawable();
                if (drawable2 != null) {
                    rectF2 = iVar.f2168n;
                    rectF2.set(0.0f, 0.0f, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                    c5.mapRect(rectF2);
                } else {
                    rectF2 = null;
                }
                float x5 = motionEvent.getX();
                float y4 = motionEvent.getY();
                if (rectF2 != null && rectF2.contains(x5, y4)) {
                    rectF2.width();
                    rectF2.height();
                    return true;
                }
                return false;
        }
    }
}
