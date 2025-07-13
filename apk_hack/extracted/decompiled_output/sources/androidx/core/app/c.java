package androidx.core.app;

import android.graphics.Insets;
import android.graphics.Rect;
import android.view.DisplayCutout;
import android.view.WindowInsetsAnimation;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract /* synthetic */ class c {
    public static /* synthetic */ DisplayCutout i(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, Insets insets2) {
        return new DisplayCutout(insets, rect, rect2, rect3, rect4, insets2);
    }

    public static /* synthetic */ WindowInsetsAnimation.Bounds j(Insets insets, Insets insets2) {
        return new WindowInsetsAnimation.Bounds(insets, insets2);
    }

    public static /* synthetic */ void p() {
    }
}
