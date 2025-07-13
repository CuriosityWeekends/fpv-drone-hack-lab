package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {
    private final FrameLayout.LayoutParams layoutParams;

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
    }

    private int makeSharedHeightSpec(int i3, int i5, int i6) {
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), i5 / Math.max(1, i6)), 0);
    }

    private int measureChildHeight(View view, int i3, int i5) {
        if (view.getVisibility() != 8) {
            view.measure(i3, i5);
            return view.getMeasuredHeight();
        }
        return 0;
    }

    private int measureSharedChildHeights(int i3, int i5, int i6, View view) {
        int makeMeasureSpec;
        makeSharedHeightSpec(i3, i5, i6);
        if (view == null) {
            makeMeasureSpec = makeSharedHeightSpec(i3, i5, i6);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt != view) {
                i7 += measureChildHeight(childAt, i3, makeMeasureSpec);
            }
        }
        return i7;
    }

    private int measureShiftingChildHeights(int i3, int i5, int i6) {
        int i7;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i7 = measureChildHeight(childAt, i3, makeSharedHeightSpec(i3, i5, i6));
            i5 -= i7;
            i6--;
        } else {
            i7 = 0;
        }
        return i7 + measureSharedChildHeights(i3, i5, i6, childAt);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new NavigationRailItemView(context);
    }

    public int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    public boolean isTopGravity() {
        if ((this.layoutParams.gravity & 112) == 48) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i3, int i5, int i6, int i7) {
        int childCount = getChildCount();
        int i8 = i6 - i3;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i9;
                childAt.layout(0, i9, i8, measuredHeight);
                i9 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i5) {
        int measureSharedChildHeights;
        int size = View.MeasureSpec.getSize(i5);
        int size2 = getMenu().getVisibleItems().size();
        if (size2 > 1 && isShifting(getLabelVisibilityMode(), size2)) {
            measureSharedChildHeights = measureShiftingChildHeights(i3, size, size2);
        } else {
            measureSharedChildHeights = measureSharedChildHeights(i3, size, size2, null);
        }
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i3), i3, 0), View.resolveSizeAndState(measureSharedChildHeights, i5, 0));
    }

    public void setMenuGravity(int i3) {
        FrameLayout.LayoutParams layoutParams = this.layoutParams;
        if (layoutParams.gravity != i3) {
            layoutParams.gravity = i3;
            setLayoutParams(layoutParams);
        }
    }
}
