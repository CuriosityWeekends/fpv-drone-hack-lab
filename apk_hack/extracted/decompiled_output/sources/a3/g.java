package a3;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g extends b {

    /* renamed from: f  reason: collision with root package name */
    public final IntEvaluator f88f;

    /* renamed from: g  reason: collision with root package name */
    public int f89g;

    /* renamed from: h  reason: collision with root package name */
    public int f90h;

    public g(View view, int i3, int i5) {
        super(view, i3, i5);
        this.f88f = new IntEvaluator();
    }

    public static void d(g gVar, float f4) {
        switch (com.bumptech.glide.i.b(gVar.f84e)) {
            case 13:
            case 17:
                gVar.c.setScaleX(f4);
                return;
            case 14:
            case 16:
            case 18:
            case 20:
                gVar.c.setScaleX(f4);
                gVar.c.setScaleY(f4);
                return;
            case 15:
            case 19:
                gVar.c.setScaleY(f4);
                return;
            default:
                return;
        }
    }

    @Override // a3.b
    public final void a() {
        if (this.f83a) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.removeAllListeners();
        ofFloat.addListener(new a(0, this));
        ofFloat.addUpdateListener(new f(1, this));
        ofFloat.setDuration(this.d).setInterpolator(new FastOutSlowInInterpolator());
        ofFloat.start();
    }

    @Override // a3.b
    public final void b() {
        this.c.post(new e(this, 1));
    }

    @Override // a3.b
    public final void c() {
        this.c.setAlpha(0.0f);
        this.c.post(new e(this, 0));
    }
}
