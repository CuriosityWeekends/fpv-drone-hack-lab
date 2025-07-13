package a3;

import android.view.View;
import android.view.animation.OvershootInterpolator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f85a;
    public final /* synthetic */ d b;

    public /* synthetic */ c(d dVar, int i3) {
        this.f85a = i3;
        this.b = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f85a) {
            case 0:
                d dVar = this.b;
                int b = com.bumptech.glide.i.b(dVar.f84e);
                if (b != 0) {
                    if (b != 1) {
                        if (b != 2) {
                            if (b != 3) {
                                if (b == 4) {
                                    View view = dVar.c;
                                    view.setPivotX(view.getMeasuredWidth());
                                    View view2 = dVar.c;
                                    view2.setPivotY(view2.getMeasuredHeight());
                                    return;
                                }
                                return;
                            }
                            dVar.c.setPivotX(0.0f);
                            View view3 = dVar.c;
                            view3.setPivotY(view3.getMeasuredHeight());
                            return;
                        }
                        View view4 = dVar.c;
                        view4.setPivotX(view4.getMeasuredWidth());
                        dVar.c.setPivotY(0.0f);
                        return;
                    }
                    dVar.c.setPivotX(0.0f);
                    dVar.c.setPivotY(0.0f);
                    return;
                }
                View view5 = dVar.c;
                view5.setPivotX(view5.getMeasuredWidth() / 2.0f);
                View view6 = dVar.c;
                view6.setPivotY(view6.getMeasuredHeight() / 2.0f);
                return;
            default:
                d dVar2 = this.b;
                dVar2.c.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(dVar2.d).setInterpolator(new OvershootInterpolator(1.0f)).start();
                return;
        }
    }
}
