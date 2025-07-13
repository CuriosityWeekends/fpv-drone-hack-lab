package androidx.core.view;

import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimationController;
import android.view.animation.Interpolator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract /* synthetic */ class c {
    public static /* synthetic */ WindowInsetsAnimation g(int i3, Interpolator interpolator, long j2) {
        return new WindowInsetsAnimation(i3, interpolator, j2);
    }

    public static /* bridge */ /* synthetic */ WindowInsetsAnimation h(Object obj) {
        return (WindowInsetsAnimation) obj;
    }

    public static /* bridge */ /* synthetic */ Class i() {
        return WindowInsetsAnimationController.class;
    }
}
