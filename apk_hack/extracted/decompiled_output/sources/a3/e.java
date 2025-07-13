package a3;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f86a;
    public final /* synthetic */ g b;

    public /* synthetic */ e(g gVar, int i3) {
        this.f86a = i3;
        this.b = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar = this.b;
        switch (this.f86a) {
            case 0:
                switch (com.bumptech.glide.i.b(gVar.f84e)) {
                    case 13:
                        gVar.c.setPivotX(0.0f);
                        View view = gVar.c;
                        view.setPivotY(view.getMeasuredHeight() / 2);
                        gVar.f89g = gVar.c.getMeasuredWidth();
                        gVar.f90h = 0;
                        gVar.c.setScaleX(0.0f);
                        break;
                    case 14:
                        gVar.c.setPivotX(0.0f);
                        gVar.c.setPivotY(0.0f);
                        gVar.f89g = gVar.c.getMeasuredWidth();
                        gVar.f90h = gVar.c.getMeasuredHeight();
                        gVar.c.setScaleX(0.0f);
                        gVar.c.setScaleY(0.0f);
                        break;
                    case 15:
                        View view2 = gVar.c;
                        view2.setPivotX(view2.getMeasuredWidth() / 2);
                        gVar.c.setPivotY(0.0f);
                        gVar.f90h = gVar.c.getMeasuredHeight();
                        gVar.c.setScaleY(0.0f);
                        break;
                    case 16:
                        View view3 = gVar.c;
                        view3.setPivotX(view3.getMeasuredWidth());
                        gVar.c.setPivotY(0.0f);
                        gVar.f89g = -gVar.c.getMeasuredWidth();
                        gVar.f90h = gVar.c.getMeasuredHeight();
                        gVar.c.setScaleX(0.0f);
                        gVar.c.setScaleY(0.0f);
                        break;
                    case 17:
                        View view4 = gVar.c;
                        view4.setPivotX(view4.getMeasuredWidth());
                        View view5 = gVar.c;
                        view5.setPivotY(view5.getMeasuredHeight() / 2);
                        gVar.f89g = -gVar.c.getMeasuredWidth();
                        gVar.c.setScaleX(0.0f);
                        break;
                    case 18:
                        View view6 = gVar.c;
                        view6.setPivotX(view6.getMeasuredWidth());
                        View view7 = gVar.c;
                        view7.setPivotY(view7.getMeasuredHeight());
                        gVar.f89g = -gVar.c.getMeasuredWidth();
                        gVar.f90h = -gVar.c.getMeasuredHeight();
                        gVar.c.setScaleX(0.0f);
                        gVar.c.setScaleY(0.0f);
                        break;
                    case 19:
                        View view8 = gVar.c;
                        view8.setPivotX(view8.getMeasuredWidth() / 2);
                        View view9 = gVar.c;
                        view9.setPivotY(view9.getMeasuredHeight());
                        gVar.f90h = -gVar.c.getMeasuredHeight();
                        gVar.c.setScaleY(0.0f);
                        break;
                    case 20:
                        gVar.c.setPivotX(0.0f);
                        View view10 = gVar.c;
                        view10.setPivotY(view10.getMeasuredHeight());
                        gVar.f89g = gVar.c.getMeasuredWidth();
                        gVar.f90h = -gVar.c.getMeasuredHeight();
                        gVar.c.setScaleX(0.0f);
                        gVar.c.setScaleY(0.0f);
                        break;
                }
                gVar.c.scrollTo(gVar.f89g, gVar.f90h);
                return;
            default:
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.addUpdateListener(new f(0, this));
                ofFloat.setDuration(gVar.d).setInterpolator(new FastOutSlowInInterpolator());
                ofFloat.start();
                return;
        }
    }
}
