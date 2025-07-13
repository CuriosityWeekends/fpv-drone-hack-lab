package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    private GravityCompat() {
    }

    public static void apply(int i3, int i5, int i6, Rect rect, Rect rect2, int i7) {
        Gravity.apply(i3, i5, i6, rect, rect2, i7);
    }

    public static void applyDisplay(int i3, Rect rect, Rect rect2, int i5) {
        Gravity.applyDisplay(i3, rect, rect2, i5);
    }

    public static int getAbsoluteGravity(int i3, int i5) {
        return Gravity.getAbsoluteGravity(i3, i5);
    }

    public static void apply(int i3, int i5, int i6, Rect rect, int i7, int i8, Rect rect2, int i9) {
        Gravity.apply(i3, i5, i6, rect, i7, i8, rect2, i9);
    }
}
