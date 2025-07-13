package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View view, int i3, int i5, @NonNull int[] iArr, int i6);

    void onNestedScroll(@NonNull View view, int i3, int i5, int i6, int i7, int i8);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3, int i5);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3, int i5);

    void onStopNestedScroll(@NonNull View view, int i3);
}
