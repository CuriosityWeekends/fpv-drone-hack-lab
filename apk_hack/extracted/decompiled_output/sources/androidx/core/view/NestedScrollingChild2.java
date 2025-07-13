package androidx.core.view;

import androidx.annotation.Nullable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i3, int i5, @Nullable int[] iArr, @Nullable int[] iArr2, int i6);

    boolean dispatchNestedScroll(int i3, int i5, int i6, int i7, @Nullable int[] iArr, int i8);

    boolean hasNestedScrollingParent(int i3);

    boolean startNestedScroll(int i3, int i5);

    void stopNestedScroll(int i3);
}
