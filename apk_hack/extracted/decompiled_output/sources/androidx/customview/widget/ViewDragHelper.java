package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new Interpolator() { // from class: androidx.customview.widget.ViewDragHelper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f5 = f4 - 1.0f;
            return (f5 * f5 * f5 * f5 * f5) + 1.0f;
        }
    };
    private final Callback mCallback;
    private View mCapturedView;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;
    private int mActivePointerId = -1;
    private final Runnable mSetIdleRunnable = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    };

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static abstract class Callback {
        public int clampViewPositionHorizontal(@NonNull View view, int i3, int i5) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View view, int i3, int i5) {
            return 0;
        }

        public int getOrderedChildIndex(int i3) {
            return i3;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i3, int i5) {
        }

        public boolean onEdgeLock(int i3) {
            return false;
        }

        public void onEdgeTouched(int i3, int i5) {
        }

        public void onViewCaptured(@NonNull View view, int i3) {
        }

        public void onViewDragStateChanged(int i3) {
        }

        public void onViewPositionChanged(@NonNull View view, int i3, int i5, @Px int i6, @Px int i7) {
        }

        public void onViewReleased(@NonNull View view, float f4, float f5) {
        }

        public abstract boolean tryCaptureView(@NonNull View view, int i3);
    }

    private ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        if (viewGroup != null) {
            if (callback != null) {
                this.mParentView = viewGroup;
                this.mCallback = callback;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                this.mEdgeSize = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
                this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
                this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mScroller = new OverScroller(context, sInterpolator);
                return;
            }
            throw new IllegalArgumentException("Callback may not be null");
        }
        throw new IllegalArgumentException("Parent view may not be null");
    }

    private boolean checkNewEdgeDrag(float f4, float f5, int i3, int i5) {
        float abs = Math.abs(f4);
        float abs2 = Math.abs(f5);
        if ((this.mInitialEdgesTouched[i3] & i5) != i5 || (this.mTrackingEdges & i5) == 0 || (this.mEdgeDragsLocked[i3] & i5) == i5 || (this.mEdgeDragsInProgress[i3] & i5) == i5) {
            return false;
        }
        int i6 = this.mTouchSlop;
        if (abs <= i6 && abs2 <= i6) {
            return false;
        }
        if (abs < abs2 * 0.5f && this.mCallback.onEdgeLock(i5)) {
            int[] iArr = this.mEdgeDragsLocked;
            iArr[i3] = iArr[i3] | i5;
            return false;
        } else if ((this.mEdgeDragsInProgress[i3] & i5) != 0 || abs <= this.mTouchSlop) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkTouchSlop(View view, float f4, float f5) {
        if (view == null) {
            return false;
        }
        boolean z3 = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean z5 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (!z3 || !z5) {
            return z3 ? Math.abs(f4) > ((float) this.mTouchSlop) : z5 && Math.abs(f5) > ((float) this.mTouchSlop);
        }
        float f6 = f5 * f5;
        int i3 = this.mTouchSlop;
        return f6 + (f4 * f4) > ((float) (i3 * i3));
    }

    private int clampMag(int i3, int i5, int i6) {
        int abs = Math.abs(i3);
        if (abs < i5) {
            return 0;
        }
        return abs > i6 ? i3 > 0 ? i6 : -i6 : i3;
    }

    private void clearMotionHistory() {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private int computeAxisDuration(int i3, int i5, int i6) {
        int abs;
        if (i3 == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        float f4 = width / 2;
        float distanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(i3) / width)) * f4) + f4;
        int abs2 = Math.abs(i5);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i3) / i6) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private int computeSettleDuration(View view, int i3, int i5, int i6, int i7) {
        float f4;
        float f5;
        float f6;
        float f7;
        int clampMag = clampMag(i6, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int clampMag2 = clampMag(i7, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int abs = Math.abs(i3);
        int abs2 = Math.abs(i5);
        int abs3 = Math.abs(clampMag);
        int abs4 = Math.abs(clampMag2);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        if (clampMag != 0) {
            f4 = abs3;
            f5 = i8;
        } else {
            f4 = abs;
            f5 = i9;
        }
        float f8 = f4 / f5;
        if (clampMag2 != 0) {
            f6 = abs4;
            f7 = i8;
        } else {
            f6 = abs2;
            f7 = i9;
        }
        return (int) ((computeAxisDuration(i5, clampMag2, this.mCallback.getViewVerticalDragRange(view)) * (f6 / f7)) + (computeAxisDuration(i3, clampMag, this.mCallback.getViewHorizontalDragRange(view)) * f8));
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f4, float f5) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f4, f5);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f4) {
        return (float) Math.sin((f4 - 0.5f) * 0.47123894f);
    }

    private void dragTo(int i3, int i5, int i6, int i7) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i6 != 0) {
            i3 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i3, i6);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, i3 - left);
        }
        int i8 = i3;
        if (i7 != 0) {
            i5 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i5, i7);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, i5 - top);
        }
        int i9 = i5;
        if (i6 != 0 || i7 != 0) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, i8, i9, i8 - left, i9 - top);
        }
    }

    private void ensureMotionHistorySizeForId(int i3) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i3) {
            int i5 = i3 + 1;
            float[] fArr2 = new float[i5];
            float[] fArr3 = new float[i5];
            float[] fArr4 = new float[i5];
            float[] fArr5 = new float[i5];
            int[] iArr = new int[i5];
            int[] iArr2 = new int[i5];
            int[] iArr3 = new int[i5];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.mInitialMotionY;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.mLastMotionX;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionY;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i3, int i5, int i6, int i7) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i8 = i3 - left;
        int i9 = i5 - top;
        if (i8 == 0 && i9 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i8, i9, computeSettleDuration(this.mCapturedView, i8, i9, i6, i7));
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i3, int i5) {
        int i6;
        if (i3 < this.mParentView.getLeft() + this.mEdgeSize) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        if (i5 < this.mParentView.getTop() + this.mEdgeSize) {
            i6 |= 4;
        }
        if (i3 > this.mParentView.getRight() - this.mEdgeSize) {
            i6 |= 2;
        }
        if (i5 > this.mParentView.getBottom() - this.mEdgeSize) {
            return i6 | 8;
        }
        return i6;
    }

    private boolean isValidPointerForActionMove(int i3) {
        if (!isPointerDown(i3)) {
            Log.e(TAG, "Ignoring pointerId=" + i3 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
            return false;
        }
        return true;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    private void reportNewEdgeDrags(float f4, float f5, int i3) {
        boolean checkNewEdgeDrag = checkNewEdgeDrag(f4, f5, i3, 1);
        boolean z3 = checkNewEdgeDrag;
        if (checkNewEdgeDrag(f5, f4, i3, 4)) {
            z3 = checkNewEdgeDrag | true;
        }
        boolean z5 = z3;
        if (checkNewEdgeDrag(f4, f5, i3, 2)) {
            z5 = (z3 ? 1 : 0) | true;
        }
        ?? r02 = z5;
        if (checkNewEdgeDrag(f5, f4, i3, 8)) {
            r02 = (z5 ? 1 : 0) | true;
        }
        if (r02 != 0) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i3] = iArr[i3] | r02;
            this.mCallback.onEdgeDragStarted(r02, i3);
        }
    }

    private void saveInitialMotion(float f4, float f5, int i3) {
        ensureMotionHistorySizeForId(i3);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i3] = f4;
        fArr[i3] = f4;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i3] = f5;
        fArr2[i3] = f5;
        this.mInitialEdgesTouched[i3] = getEdgesTouched((int) f4, (int) f5);
        this.mPointersDown |= 1 << i3;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            int pointerId = motionEvent.getPointerId(i3);
            if (isValidPointerForActionMove(pointerId)) {
                float x3 = motionEvent.getX(i3);
                float y3 = motionEvent.getY(i3);
                this.mLastMotionX[pointerId] = x3;
                this.mLastMotionY[pointerId] = y3;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    public boolean canScroll(@NonNull View view, boolean z3, int i3, int i5, int i6, int i7) {
        int i8;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i9 = i6 + scrollX;
                if (i9 >= childAt.getLeft() && i9 < childAt.getRight() && (i8 = i7 + scrollY) >= childAt.getTop() && i8 < childAt.getBottom() && canScroll(childAt, true, i3, i5, i9 - childAt.getLeft(), i8 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z3 && (view.canScrollHorizontally(-i3) || view.canScrollVertically(-i5))) {
            return true;
        }
        return false;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(@NonNull View view, int i3) {
        if (view.getParent() == this.mParentView) {
            this.mCapturedView = view;
            this.mActivePointerId = i3;
            this.mCallback.onViewCaptured(view, i3);
            setDragState(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
    }

    public boolean continueSettling(boolean z3) {
        if (this.mDragState == 2) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, top);
            }
            if (left != 0 || top != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z3) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        if (this.mDragState != 2) {
            return false;
        }
        return true;
    }

    @Nullable
    public View findTopChildUnder(int i3, int i5) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i3 >= childAt.getLeft() && i3 < childAt.getRight() && i5 >= childAt.getTop() && i5 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i3, int i5, int i6, int i7) {
        if (this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), i3, i6, i5, i7);
            setDragState(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    @Nullable
    public View getCapturedView() {
        return this.mCapturedView;
    }

    @Px
    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    @Px
    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i3, int i5) {
        return isViewUnder(this.mCapturedView, i3, i5);
    }

    public boolean isEdgeTouched(int i3) {
        int length = this.mInitialEdgesTouched.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (isEdgeTouched(i3, i5)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i3) {
        if (((1 << i3) & this.mPointersDown) != 0) {
            return true;
        }
        return false;
    }

    public boolean isViewUnder(@Nullable View view, int i3, int i5) {
        if (view == null || i3 < view.getLeft() || i3 >= view.getRight() || i5 < view.getTop() || i5 >= view.getBottom()) {
            return false;
        }
        return true;
    }

    public void processTouchEvent(@NonNull MotionEvent motionEvent) {
        int i3;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i5 = 0;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                if (this.mDragState == 1 && pointerId == this.mActivePointerId) {
                                    int pointerCount = motionEvent.getPointerCount();
                                    while (true) {
                                        if (i5 < pointerCount) {
                                            int pointerId2 = motionEvent.getPointerId(i5);
                                            if (pointerId2 != this.mActivePointerId) {
                                                View findTopChildUnder = findTopChildUnder((int) motionEvent.getX(i5), (int) motionEvent.getY(i5));
                                                View view = this.mCapturedView;
                                                if (findTopChildUnder == view && tryCaptureViewForDrag(view, pointerId2)) {
                                                    i3 = this.mActivePointerId;
                                                    break;
                                                }
                                            }
                                            i5++;
                                        } else {
                                            i3 = -1;
                                            break;
                                        }
                                    }
                                    if (i3 == -1) {
                                        releaseViewForPointerUp();
                                    }
                                }
                                clearMotionHistory(pointerId);
                                return;
                            }
                            return;
                        }
                        int pointerId3 = motionEvent.getPointerId(actionIndex);
                        float x3 = motionEvent.getX(actionIndex);
                        float y3 = motionEvent.getY(actionIndex);
                        saveInitialMotion(x3, y3, pointerId3);
                        if (this.mDragState == 0) {
                            tryCaptureViewForDrag(findTopChildUnder((int) x3, (int) y3), pointerId3);
                            int i6 = this.mInitialEdgesTouched[pointerId3];
                            int i7 = this.mTrackingEdges;
                            if ((i6 & i7) != 0) {
                                this.mCallback.onEdgeTouched(i6 & i7, pointerId3);
                                return;
                            }
                            return;
                        } else if (isCapturedViewUnder((int) x3, (int) y3)) {
                            tryCaptureViewForDrag(this.mCapturedView, pointerId3);
                            return;
                        } else {
                            return;
                        }
                    }
                    if (this.mDragState == 1) {
                        dispatchViewReleased(0.0f, 0.0f);
                    }
                    cancel();
                    return;
                } else if (this.mDragState == 1) {
                    if (isValidPointerForActionMove(this.mActivePointerId)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        float x5 = motionEvent.getX(findPointerIndex);
                        float y4 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.mLastMotionX;
                        int i8 = this.mActivePointerId;
                        int i9 = (int) (x5 - fArr[i8]);
                        int i10 = (int) (y4 - this.mLastMotionY[i8]);
                        dragTo(this.mCapturedView.getLeft() + i9, this.mCapturedView.getTop() + i10, i9, i10);
                        saveLastMotion(motionEvent);
                        return;
                    }
                    return;
                } else {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (i5 < pointerCount2) {
                        int pointerId4 = motionEvent.getPointerId(i5);
                        if (isValidPointerForActionMove(pointerId4)) {
                            float x6 = motionEvent.getX(i5);
                            float y5 = motionEvent.getY(i5);
                            float f4 = x6 - this.mInitialMotionX[pointerId4];
                            float f5 = y5 - this.mInitialMotionY[pointerId4];
                            reportNewEdgeDrags(f4, f5, pointerId4);
                            if (this.mDragState != 1) {
                                View findTopChildUnder2 = findTopChildUnder((int) x6, (int) y5);
                                if (checkTouchSlop(findTopChildUnder2, f4, f5) && tryCaptureViewForDrag(findTopChildUnder2, pointerId4)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        i5++;
                    }
                    saveLastMotion(motionEvent);
                    return;
                }
            }
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
            return;
        }
        float x7 = motionEvent.getX();
        float y6 = motionEvent.getY();
        int pointerId5 = motionEvent.getPointerId(0);
        View findTopChildUnder3 = findTopChildUnder((int) x7, (int) y6);
        saveInitialMotion(x7, y6, pointerId5);
        tryCaptureViewForDrag(findTopChildUnder3, pointerId5);
        int i11 = this.mInitialEdgesTouched[pointerId5];
        int i12 = this.mTrackingEdges;
        if ((i11 & i12) != 0) {
            this.mCallback.onEdgeTouched(i11 & i12, pointerId5);
        }
    }

    public void setDragState(int i3) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i3) {
            this.mDragState = i3;
            this.mCallback.onViewDragStateChanged(i3);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeTrackingEnabled(int i3) {
        this.mTrackingEdges = i3;
    }

    public void setMinVelocity(float f4) {
        this.mMinVelocity = f4;
    }

    public boolean settleCapturedViewAt(int i3, int i5) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i3, i5, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00dd, code lost:
        if (r12 != r11) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean shouldInterceptTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(@NonNull View view, int i3, int i5) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i3, i5, 0, 0);
        if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    public boolean tryCaptureViewForDrag(View view, int i3) {
        if (view == this.mCapturedView && this.mActivePointerId == i3) {
            return true;
        }
        if (view != null && this.mCallback.tryCaptureView(view, i3)) {
            this.mActivePointerId = i3;
            captureChildView(view, i3);
            return true;
        }
        return false;
    }

    private float clampMag(float f4, float f5, float f6) {
        float abs = Math.abs(f4);
        if (abs < f5) {
            return 0.0f;
        }
        return abs > f6 ? f4 > 0.0f ? f6 : -f6 : f4;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, float f4, @NonNull Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.mTouchSlop = (int) ((1.0f / f4) * create.mTouchSlop);
        return create;
    }

    public boolean isEdgeTouched(int i3, int i5) {
        return isPointerDown(i5) && (i3 & this.mInitialEdgesTouched[i5]) != 0;
    }

    public boolean checkTouchSlop(int i3) {
        int length = this.mInitialMotionX.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (checkTouchSlop(i3, i5)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i3, int i5) {
        if (isPointerDown(i5)) {
            boolean z3 = (i3 & 1) == 1;
            boolean z5 = (i3 & 2) == 2;
            float f4 = this.mLastMotionX[i5] - this.mInitialMotionX[i5];
            float f5 = this.mLastMotionY[i5] - this.mInitialMotionY[i5];
            if (!z3 || !z5) {
                return z3 ? Math.abs(f4) > ((float) this.mTouchSlop) : z5 && Math.abs(f5) > ((float) this.mTouchSlop);
            }
            float f6 = f5 * f5;
            int i6 = this.mTouchSlop;
            return f6 + (f4 * f4) > ((float) (i6 * i6));
        }
        return false;
    }

    private void clearMotionHistory(int i3) {
        if (this.mInitialMotionX == null || !isPointerDown(i3)) {
            return;
        }
        this.mInitialMotionX[i3] = 0.0f;
        this.mInitialMotionY[i3] = 0.0f;
        this.mLastMotionX[i3] = 0.0f;
        this.mLastMotionY[i3] = 0.0f;
        this.mInitialEdgesTouched[i3] = 0;
        this.mEdgeDragsInProgress[i3] = 0;
        this.mEdgeDragsLocked[i3] = 0;
        this.mPointersDown = (~(1 << i3)) & this.mPointersDown;
    }
}
