package androidx.viewpager2.widget;

import a1.i;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    private static final int NO_POSITION = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
    private static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
    private static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
    private static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
    private int mAdapterState;
    private ViewPager2.OnPageChangeCallback mCallback;
    private boolean mDataSetChangeHappened;
    private boolean mDispatchSelected;
    private int mDragStartPosition;
    private boolean mFakeDragging;
    @NonNull
    private final LinearLayoutManager mLayoutManager;
    @NonNull
    private final RecyclerView mRecyclerView;
    private boolean mScrollHappened;
    private int mScrollState;
    private ScrollEventValues mScrollValues;
    private int mTarget;
    @NonNull
    private final ViewPager2 mViewPager;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static final class ScrollEventValues {
        float mOffset;
        int mOffsetPx;
        int mPosition;

        public void reset() {
            this.mPosition = -1;
            this.mOffset = 0.0f;
            this.mOffsetPx = 0;
        }
    }

    public ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.mViewPager = viewPager2;
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        this.mRecyclerView = recyclerView;
        this.mLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.mScrollValues = new ScrollEventValues();
        resetState();
    }

    private void dispatchScrolled(int i3, float f4, int i5) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i3, f4, i5);
        }
    }

    private void dispatchSelected(int i3) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i3);
        }
    }

    private void dispatchStateChanged(int i3) {
        if ((this.mAdapterState == 3 && this.mScrollState == 0) || this.mScrollState == i3) {
            return;
        }
        this.mScrollState = i3;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i3);
        }
    }

    private int getPosition() {
        return this.mLayoutManager.findFirstVisibleItemPosition();
    }

    private boolean isInAnyDraggingState() {
        int i3 = this.mAdapterState;
        if (i3 == 1 || i3 == 4) {
            return true;
        }
        return false;
    }

    private void resetState() {
        this.mAdapterState = 0;
        this.mScrollState = 0;
        this.mScrollValues.reset();
        this.mDragStartPosition = -1;
        this.mTarget = -1;
        this.mDispatchSelected = false;
        this.mScrollHappened = false;
        this.mFakeDragging = false;
        this.mDataSetChangeHappened = false;
    }

    private void startDrag(boolean z3) {
        int i3;
        this.mFakeDragging = z3;
        if (z3) {
            i3 = 4;
        } else {
            i3 = 1;
        }
        this.mAdapterState = i3;
        int i5 = this.mTarget;
        if (i5 != -1) {
            this.mDragStartPosition = i5;
            this.mTarget = -1;
        } else if (this.mDragStartPosition == -1) {
            this.mDragStartPosition = getPosition();
        }
        dispatchStateChanged(1);
    }

    private void updateScrollEventValues() {
        int top;
        float f4;
        ScrollEventValues scrollEventValues = this.mScrollValues;
        int findFirstVisibleItemPosition = this.mLayoutManager.findFirstVisibleItemPosition();
        scrollEventValues.mPosition = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.reset();
            return;
        }
        View findViewByPosition = this.mLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.reset();
            return;
        }
        int leftDecorationWidth = this.mLayoutManager.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.mLayoutManager.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.mLayoutManager.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.mLayoutManager.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.mLayoutManager.getOrientation() == 0) {
            top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.mRecyclerView.getPaddingLeft();
            if (this.mViewPager.isRtl()) {
                top = -top;
            }
            height = width;
        } else {
            top = (findViewByPosition.getTop() - topDecorationHeight) - this.mRecyclerView.getPaddingTop();
        }
        int i3 = -top;
        scrollEventValues.mOffsetPx = i3;
        if (i3 < 0) {
            if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            Locale locale = Locale.US;
            throw new IllegalStateException(i.e(scrollEventValues.mOffsetPx, "Page can only be offset by a positive amount, not by "));
        }
        if (height == 0) {
            f4 = 0.0f;
        } else {
            f4 = i3 / height;
        }
        scrollEventValues.mOffset = f4;
    }

    public double getRelativeScrollPosition() {
        updateScrollEventValues();
        ScrollEventValues scrollEventValues = this.mScrollValues;
        return scrollEventValues.mPosition + scrollEventValues.mOffset;
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean isDragging() {
        if (this.mScrollState == 1) {
            return true;
        }
        return false;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public boolean isIdle() {
        if (this.mScrollState == 0) {
            return true;
        }
        return false;
    }

    public void notifyBeginFakeDrag() {
        this.mAdapterState = 4;
        startDrag(true);
    }

    public void notifyDataSetChangeHappened() {
        this.mDataSetChangeHappened = true;
    }

    public void notifyEndFakeDrag() {
        if (isDragging() && !this.mFakeDragging) {
            return;
        }
        this.mFakeDragging = false;
        updateScrollEventValues();
        ScrollEventValues scrollEventValues = this.mScrollValues;
        if (scrollEventValues.mOffsetPx == 0) {
            int i3 = scrollEventValues.mPosition;
            if (i3 != this.mDragStartPosition) {
                dispatchSelected(i3);
            }
            dispatchStateChanged(0);
            resetState();
            return;
        }
        dispatchStateChanged(2);
    }

    public void notifyProgrammaticScroll(int i3, boolean z3) {
        int i5;
        if (z3) {
            i5 = 2;
        } else {
            i5 = 3;
        }
        this.mAdapterState = i5;
        boolean z5 = false;
        this.mFakeDragging = false;
        if (this.mTarget != i3) {
            z5 = true;
        }
        this.mTarget = i3;
        dispatchStateChanged(2);
        if (z5) {
            dispatchSelected(i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
        if ((this.mAdapterState != 1 || this.mScrollState != 1) && i3 == 1) {
            startDrag(false);
        } else if (isInAnyDraggingState() && i3 == 2) {
            if (this.mScrollHappened) {
                dispatchStateChanged(2);
                this.mDispatchSelected = true;
            }
        } else {
            if (isInAnyDraggingState() && i3 == 0) {
                updateScrollEventValues();
                if (!this.mScrollHappened) {
                    int i5 = this.mScrollValues.mPosition;
                    if (i5 != -1) {
                        dispatchScrolled(i5, 0.0f, 0);
                    }
                } else {
                    ScrollEventValues scrollEventValues = this.mScrollValues;
                    if (scrollEventValues.mOffsetPx == 0) {
                        int i6 = this.mDragStartPosition;
                        int i7 = scrollEventValues.mPosition;
                        if (i6 != i7) {
                            dispatchSelected(i7);
                        }
                    }
                }
                dispatchStateChanged(0);
                resetState();
            }
            if (this.mAdapterState == 2 && i3 == 0 && this.mDataSetChangeHappened) {
                updateScrollEventValues();
                ScrollEventValues scrollEventValues2 = this.mScrollValues;
                if (scrollEventValues2.mOffsetPx == 0) {
                    int i8 = this.mTarget;
                    int i9 = scrollEventValues2.mPosition;
                    if (i8 != i9) {
                        if (i9 == -1) {
                            i9 = 0;
                        }
                        dispatchSelected(i9);
                    }
                    dispatchStateChanged(0);
                    resetState();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r5 == r3.mViewPager.isRtl()) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onScrolled(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.mScrollHappened = r4
            r3.updateScrollEventValues()
            boolean r0 = r3.mDispatchSelected
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L37
            r3.mDispatchSelected = r2
            if (r6 > 0) goto L1f
            if (r6 != 0) goto L29
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.mViewPager
            boolean r6 = r6.isRtl()
            if (r5 != r6) goto L29
        L1f:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.mScrollValues
            int r6 = r5.mOffsetPx
            if (r6 == 0) goto L29
            int r5 = r5.mPosition
            int r5 = r5 + r4
            goto L2d
        L29:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.mScrollValues
            int r5 = r5.mPosition
        L2d:
            r3.mTarget = r5
            int r6 = r3.mDragStartPosition
            if (r6 == r5) goto L45
            r3.dispatchSelected(r5)
            goto L45
        L37:
            int r5 = r3.mAdapterState
            if (r5 != 0) goto L45
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.mScrollValues
            int r5 = r5.mPosition
            if (r5 != r1) goto L42
            r5 = 0
        L42:
            r3.dispatchSelected(r5)
        L45:
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.mScrollValues
            int r6 = r5.mPosition
            if (r6 != r1) goto L4c
            r6 = 0
        L4c:
            float r0 = r5.mOffset
            int r5 = r5.mOffsetPx
            r3.dispatchScrolled(r6, r0, r5)
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.mScrollValues
            int r6 = r5.mPosition
            int r0 = r3.mTarget
            if (r6 == r0) goto L5d
            if (r0 != r1) goto L6b
        L5d:
            int r5 = r5.mOffsetPx
            if (r5 != 0) goto L6b
            int r5 = r3.mScrollState
            if (r5 == r4) goto L6b
            r3.dispatchStateChanged(r2)
            r3.resetState()
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.mCallback = onPageChangeCallback;
    }
}
