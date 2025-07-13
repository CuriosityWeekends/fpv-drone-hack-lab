package c2;

import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.Surface;
import android.widget.EditText;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import com.lxj.xpopup.impl.InputConfirmPopupView;
import j0.k0;
import j0.q0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f201a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(int i3, Object obj) {
        this.f201a = i3;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.b;
        switch (this.f201a) {
            case 0:
                int i3 = DefaultTimeBar.M;
                ((DefaultTimeBar) obj).d(false);
                return;
            case 1:
                Runnable runnable = (Runnable) obj;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            case 2:
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
                Surface surface = sphericalGLSurfaceView.f492h;
                if (surface != null) {
                    k0 k0Var = sphericalGLSurfaceView.f493i;
                    if (k0Var != null) {
                        q0 q0Var = (q0) k0Var;
                        q0Var.P();
                        if (surface == q0Var.q) {
                            q0Var.P();
                            q0Var.F();
                            q0Var.L(null, false);
                            q0Var.D(0, 0);
                        }
                    }
                    SurfaceTexture surfaceTexture = sphericalGLSurfaceView.f491g;
                    Surface surface2 = sphericalGLSurfaceView.f492h;
                    if (surfaceTexture != null) {
                        surfaceTexture.release();
                    }
                    if (surface2 != null) {
                        surface2.release();
                    }
                    sphericalGLSurfaceView.f491g = null;
                    sphericalGLSurfaceView.f492h = null;
                    return;
                }
                return;
            case 3:
                int i5 = InputConfirmPopupView.G;
                InputConfirmPopupView inputConfirmPopupView = (InputConfirmPopupView) obj;
                if (inputConfirmPopupView.C.getMeasuredWidth() > 0) {
                    BitmapDrawable b = com.lxj.xpopup.util.b.b(inputConfirmPopupView.getContext(), inputConfirmPopupView.C.getMeasuredWidth(), Color.parseColor("#888888"));
                    BitmapDrawable b5 = com.lxj.xpopup.util.b.b(inputConfirmPopupView.getContext(), inputConfirmPopupView.C.getMeasuredWidth(), z2.e.f4295a);
                    EditText editText = inputConfirmPopupView.C;
                    StateListDrawable stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842908}, b5);
                    stateListDrawable.addState(new int[0], b);
                    editText.setBackgroundDrawable(stateListDrawable);
                    return;
                }
                return;
            case 4:
                ((q2.a) obj).b.setOnClickListener(null);
                return;
            case 5:
                ((o1.j) obj).g();
                return;
            default:
                ((q1.c) obj).s();
                return;
        }
    }
}
