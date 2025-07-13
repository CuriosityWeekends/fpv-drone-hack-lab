package b4;

import android.view.View;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends TransitionListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f185a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;

    public a(View view, float f4, float f5) {
        this.f185a = view;
        this.b = f4;
        this.c = f5;
    }

    @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        float f4 = this.b;
        View view = this.f185a;
        view.setScaleX(f4);
        view.setScaleY(this.c);
        transition.removeListener(this);
    }
}
