package androidx.core.view;

import androidx.annotation.Nullable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float f4, float f5, boolean z3);

    boolean dispatchNestedPreFling(float f4, float f5);

    boolean dispatchNestedPreScroll(int i3, int i5, @Nullable int[] iArr, @Nullable int[] iArr2);

    boolean dispatchNestedScroll(int i3, int i5, int i6, int i7, @Nullable int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z3);

    boolean startNestedScroll(int i3);

    void stopNestedScroll();
}
