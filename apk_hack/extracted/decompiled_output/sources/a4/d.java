package a4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import com.transitionseverywhere.Crossfade;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f107a;
    public final /* synthetic */ View b;
    public final /* synthetic */ BitmapDrawable c;
    public final /* synthetic */ BitmapDrawable d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Crossfade f108e;

    public d(Crossfade crossfade, boolean z3, View view, BitmapDrawable bitmapDrawable, BitmapDrawable bitmapDrawable2) {
        this.f108e = crossfade;
        this.f107a = z3;
        this.b = view;
        this.c = bitmapDrawable;
        this.d = bitmapDrawable2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewOverlay overlay;
        boolean z3 = this.f107a;
        View view = this.b;
        if (z3) {
            overlay = ((ViewGroup) view.getParent()).getOverlay();
        } else {
            overlay = view.getOverlay();
        }
        overlay.remove(this.c);
        if (this.f108e.f1550a == 1) {
            overlay.remove(this.d);
        }
    }
}
