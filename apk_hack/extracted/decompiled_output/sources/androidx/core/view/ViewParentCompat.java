package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] iArr = sTempNestedScrollConsumed;
        if (iArr == null) {
            sTempNestedScrollConsumed = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i3) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i3);
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f4, float f5, boolean z3) {
        try {
            return viewParent.onNestedFling(view, f4, f5, z3);
        } catch (AbstractMethodError e5) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e5);
            return false;
        }
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f4, float f5) {
        try {
            return viewParent.onNestedPreFling(view, f4, f5);
        } catch (AbstractMethodError e5) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e5);
            return false;
        }
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i3, int i5, int[] iArr) {
        onNestedPreScroll(viewParent, view, i3, i5, iArr, 0);
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i3, int i5, int i6, int i7) {
        onNestedScroll(viewParent, view, i3, i5, i6, i7, 0, getTempNestedScrollConsumed());
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i3) {
        onNestedScrollAccepted(viewParent, view, view2, i3, 0);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i3) {
        return onStartNestedScroll(viewParent, view, view2, i3, 0);
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        onStopNestedScroll(viewParent, view, 0);
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i3, int i5, int[] iArr, int i6) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i3, i5, iArr, i6);
        } else if (i6 == 0) {
            try {
                viewParent.onNestedPreScroll(view, i3, i5, iArr);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e5);
            }
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i3, int i5) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i3, i5);
        } else if (i5 == 0) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i3);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e5);
            }
        }
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i3, int i5) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i3, i5);
        }
        if (i5 == 0) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i3);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e5);
                return false;
            }
        }
        return false;
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i3);
        } else if (i3 == 0) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e5);
            }
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i3, int i5, int i6, int i7, int i8) {
        onNestedScroll(viewParent, view, i3, i5, i6, i7, i8, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i3, int i5, int i6, int i7, int i8, @NonNull int[] iArr) {
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent).onNestedScroll(view, i3, i5, i6, i7, i8, iArr);
            return;
        }
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view, i3, i5, i6, i7, i8);
        } else if (i8 == 0) {
            try {
                viewParent.onNestedScroll(view, i3, i5, i6, i7);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e5);
            }
        }
    }
}
