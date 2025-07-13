package com.google.android.material.bottomsheet;

import a1.i;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_WIDTH = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    int activePointerId;
    @NonNull
    private final ArrayList<BottomSheetCallback> callbacks;
    private int childHeight;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    float elevation;
    private int expandHalfwayActionId;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    boolean hideable;
    private boolean ignoreEvents;
    @Nullable
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;
    @Nullable
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    private MaterialShapeDrawable materialShapeDrawable;
    private int maxWidth;
    private float maximumVelocity;
    private boolean nestedScrolled;
    @Nullable
    WeakReference<View> nestedScrollingChildRef;
    private boolean paddingBottomSystemWindowInsets;
    private boolean paddingLeftSystemWindowInsets;
    private boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private BottomSheetBehavior<V>.SettleRunnable settleRunnable;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    private boolean skipCollapsed;
    int state;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    @Nullable
    private VelocityTracker velocityTracker;
    @Nullable
    ViewDragHelper viewDragHelper;
    @Nullable
    WeakReference<V> viewRef;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static abstract class BottomSheetCallback {
        public abstract void onSlide(@NonNull View view, float f4);

        public abstract void onStateChanged(@NonNull View view, int i3);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public @interface SaveFlags {
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = ((BottomSheetBehavior) bottomSheetBehavior).peekHeight;
            this.fitToContents = ((BottomSheetBehavior) bottomSheetBehavior).fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = ((BottomSheetBehavior) bottomSheetBehavior).skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i3) {
            super(parcelable);
            this.state = i3;
        }
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public class SettleRunnable implements Runnable {
        private boolean isPosted;
        int targetState;
        private final View view;

        public SettleRunnable(View view, int i3) {
            this.view = view;
            this.targetState = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.viewDragHelper;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.view, this);
            } else {
                BottomSheetBehavior.this.setStateInternal(this.targetState);
            }
            this.isPosted = false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public @interface State {
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList<>();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
            private boolean releasedLow(@NonNull View view) {
                int top = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (top > (bottomSheetBehavior.getExpandedOffset() + bottomSheetBehavior.parentHeight) / 2) {
                    return true;
                }
                return false;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view, int i3, int i5) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view, int i3, int i5) {
                int i6;
                int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.hideable) {
                    i6 = bottomSheetBehavior.parentHeight;
                } else {
                    i6 = bottomSheetBehavior.collapsedOffset;
                }
                return MathUtils.clamp(i3, expandedOffset, i6);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(@NonNull View view) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.hideable) {
                    return bottomSheetBehavior.parentHeight;
                }
                return bottomSheetBehavior.collapsedOffset;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i3) {
                if (i3 == 1 && BottomSheetBehavior.this.draggable) {
                    BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i3, int i5, int i6, int i7) {
                BottomSheetBehavior.this.dispatchOnSlide(i5);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view, float f4, float f5) {
                int i3;
                int i5 = 6;
                if (f5 < 0.0f) {
                    if (BottomSheetBehavior.this.fitToContents) {
                        i3 = BottomSheetBehavior.this.fitToContentsOffset;
                    } else {
                        int top = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                        int i6 = bottomSheetBehavior.halfExpandedOffset;
                        if (top > i6) {
                            i3 = i6;
                        } else {
                            i3 = bottomSheetBehavior.getExpandedOffset();
                        }
                    }
                    i5 = 3;
                } else {
                    BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior2.hideable && bottomSheetBehavior2.shouldHide(view, f5)) {
                        if ((Math.abs(f4) < Math.abs(f5) && f5 > 500.0f) || releasedLow(view)) {
                            i3 = BottomSheetBehavior.this.parentHeight;
                            i5 = 5;
                        } else {
                            if (BottomSheetBehavior.this.fitToContents) {
                                i3 = BottomSheetBehavior.this.fitToContentsOffset;
                            } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.getExpandedOffset()) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                                i3 = BottomSheetBehavior.this.getExpandedOffset();
                            } else {
                                i3 = BottomSheetBehavior.this.halfExpandedOffset;
                            }
                            i5 = 3;
                        }
                    } else if (f5 != 0.0f && Math.abs(f4) <= Math.abs(f5)) {
                        if (BottomSheetBehavior.this.fitToContents) {
                            i3 = BottomSheetBehavior.this.collapsedOffset;
                        } else {
                            int top2 = view.getTop();
                            if (Math.abs(top2 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                                i3 = BottomSheetBehavior.this.halfExpandedOffset;
                            } else {
                                i3 = BottomSheetBehavior.this.collapsedOffset;
                            }
                        }
                        i5 = 4;
                    } else {
                        int top3 = view.getTop();
                        if (BottomSheetBehavior.this.fitToContents) {
                            if (Math.abs(top3 - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset)) {
                                i3 = BottomSheetBehavior.this.fitToContentsOffset;
                                i5 = 3;
                            } else {
                                i3 = BottomSheetBehavior.this.collapsedOffset;
                                i5 = 4;
                            }
                        } else {
                            BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                            int i7 = bottomSheetBehavior3.halfExpandedOffset;
                            if (top3 < i7) {
                                if (top3 < Math.abs(top3 - bottomSheetBehavior3.collapsedOffset)) {
                                    i3 = BottomSheetBehavior.this.getExpandedOffset();
                                    i5 = 3;
                                } else {
                                    i3 = BottomSheetBehavior.this.halfExpandedOffset;
                                }
                            } else if (Math.abs(top3 - i7) < Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset)) {
                                i3 = BottomSheetBehavior.this.halfExpandedOffset;
                            } else {
                                i3 = BottomSheetBehavior.this.collapsedOffset;
                                i5 = 4;
                            }
                        }
                    }
                }
                BottomSheetBehavior.this.startSettlingAnimation(view, i5, i3, true);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view, int i3) {
                View view2;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i5 = bottomSheetBehavior.state;
                if (i5 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i5 == 3 && bottomSheetBehavior.activePointerId == i3) {
                    WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
                if (weakReference2 == null || weakReference2.get() != view) {
                    return false;
                }
                return true;
            }
        };
    }

    private int addAccessibilityActionForState(V v5, @StringRes int i3, int i5) {
        return ViewCompat.addAccessibilityAction(v5, v5.getResources().getString(i3), createAccessibilityViewCommandForState(i5));
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) ((1.0f - this.halfExpandedRatio) * this.parentHeight);
    }

    private int calculatePeekHeight() {
        int i3;
        if (this.peekHeightAuto) {
            return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight) + this.insetBottom;
        }
        if (!this.gestureInsetBottomIgnored && !this.paddingBottomSystemWindowInsets && (i3 = this.gestureInsetBottom) > 0) {
            return Math.max(this.peekHeight, i3 + this.peekHeightGestureInsetBuffer);
        }
        return this.peekHeight + this.insetBottom;
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int i3) {
        return new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.6
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                BottomSheetBehavior.this.setState(i3);
                return true;
            }
        };
    }

    private void createMaterialShapeDrawable(@NonNull Context context, AttributeSet attributeSet, boolean z3) {
        createMaterialShapeDrawable(context, attributeSet, z3, null);
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                    BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(floatValue);
                }
            }
        });
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> from(@NonNull V v5) {
        ViewGroup.LayoutParams layoutParams = v5.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void replaceAccessibilityActionForState(V v5, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i3) {
        ViewCompat.replaceAccessibilityAction(v5, accessibilityActionCompat, null, createAccessibilityViewCommandForState(i3));
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(@NonNull SavedState savedState) {
        int i3 = this.saveFlags;
        if (i3 == 0) {
            return;
        }
        if (i3 == -1 || (i3 & 1) == 1) {
            this.peekHeight = savedState.peekHeight;
        }
        if (i3 == -1 || (i3 & 2) == 2) {
            this.fitToContents = savedState.fitToContents;
        }
        if (i3 == -1 || (i3 & 4) == 4) {
            this.hideable = savedState.hideable;
        }
        if (i3 == -1 || (i3 & 8) == 8) {
            this.skipCollapsed = savedState.skipCollapsed;
        }
    }

    private void setWindowInsetsListener(@NonNull View view) {
        final boolean z3;
        if (Build.VERSION.SDK_INT >= 29 && !isGestureInsetBottomIgnored() && !this.peekHeightAuto) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!this.paddingBottomSystemWindowInsets && !this.paddingLeftSystemWindowInsets && !this.paddingRightSystemWindowInsets && !z3) {
            return;
        }
        ViewUtils.doOnApplyWindowInsets(view, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                int i3;
                int i5;
                BottomSheetBehavior.this.insetTop = windowInsetsCompat.getSystemWindowInsetTop();
                boolean isLayoutRtl = ViewUtils.isLayoutRtl(view2);
                int paddingBottom = view2.getPaddingBottom();
                int paddingLeft = view2.getPaddingLeft();
                int paddingRight = view2.getPaddingRight();
                if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets) {
                    BottomSheetBehavior.this.insetBottom = windowInsetsCompat.getSystemWindowInsetBottom();
                    paddingBottom = relativePadding.bottom + BottomSheetBehavior.this.insetBottom;
                }
                if (BottomSheetBehavior.this.paddingLeftSystemWindowInsets) {
                    if (isLayoutRtl) {
                        i5 = relativePadding.end;
                    } else {
                        i5 = relativePadding.start;
                    }
                    paddingLeft = i5 + windowInsetsCompat.getSystemWindowInsetLeft();
                }
                if (BottomSheetBehavior.this.paddingRightSystemWindowInsets) {
                    if (isLayoutRtl) {
                        i3 = relativePadding.start;
                    } else {
                        i3 = relativePadding.end;
                    }
                    paddingRight = windowInsetsCompat.getSystemWindowInsetRight() + i3;
                }
                view2.setPadding(paddingLeft, view2.getPaddingTop(), paddingRight, paddingBottom);
                if (z3) {
                    BottomSheetBehavior.this.gestureInsetBottom = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
                }
                if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets || z3) {
                    BottomSheetBehavior.this.updatePeekHeight(false);
                }
                return windowInsetsCompat;
            }
        });
    }

    private void settleToStatePendingLayout(final int i3) {
        final V v5 = this.viewRef.get();
        if (v5 == null) {
            return;
        }
        ViewParent parent = v5.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v5)) {
            v5.post(new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
                @Override // java.lang.Runnable
                public void run() {
                    BottomSheetBehavior.this.settleToState(v5, i3);
                }
            });
        } else {
            settleToState(v5, i3);
        }
    }

    private void updateAccessibilityActions() {
        V v5;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v5 = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v5, 524288);
        ViewCompat.removeAccessibilityAction(v5, 262144);
        ViewCompat.removeAccessibilityAction(v5, 1048576);
        int i3 = this.expandHalfwayActionId;
        if (i3 != -1) {
            ViewCompat.removeAccessibilityAction(v5, i3);
        }
        int i5 = 6;
        if (!this.fitToContents && this.state != 6) {
            this.expandHalfwayActionId = addAccessibilityActionForState(v5, R.string.bottomsheet_action_expand_halfway, 6);
        }
        if (this.hideable && this.state != 5) {
            replaceAccessibilityActionForState(v5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i6 = this.state;
        if (i6 != 3) {
            if (i6 != 4) {
                if (i6 == 6) {
                    replaceAccessibilityActionForState(v5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
                    replaceAccessibilityActionForState(v5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
                    return;
                }
                return;
            }
            if (this.fitToContents) {
                i5 = 3;
            }
            replaceAccessibilityActionForState(v5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, i5);
            return;
        }
        if (this.fitToContents) {
            i5 = 4;
        }
        replaceAccessibilityActionForState(v5, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, i5);
    }

    private void updateDrawableForTargetState(int i3) {
        boolean z3;
        ValueAnimator valueAnimator;
        float f4;
        if (i3 == 2) {
            return;
        }
        if (i3 == 3) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.isShapeExpanded != z3) {
            this.isShapeExpanded = z3;
            if (this.materialShapeDrawable != null && (valueAnimator = this.interpolatorAnimator) != null) {
                if (valueAnimator.isRunning()) {
                    this.interpolatorAnimator.reverse();
                    return;
                }
                if (z3) {
                    f4 = 0.0f;
                } else {
                    f4 = 1.0f;
                }
                this.interpolatorAnimator.setFloatValues(1.0f - f4, f4);
                this.interpolatorAnimator.start();
            }
        }
    }

    private void updateImportantForAccessibility(boolean z3) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z3) {
            if (this.importantForAccessibilityMap == null) {
                this.importantForAccessibilityMap = new HashMap(childCount);
            } else {
                return;
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = coordinatorLayout.getChildAt(i3);
            if (childAt != this.viewRef.get()) {
                if (z3) {
                    this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    if (this.updateImportantForAccessibilityOnSiblings) {
                        ViewCompat.setImportantForAccessibility(childAt, 4);
                    }
                } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                    ViewCompat.setImportantForAccessibility(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                }
            }
        }
        if (!z3) {
            this.importantForAccessibilityMap = null;
        } else if (this.updateImportantForAccessibilityOnSiblings) {
            this.viewRef.get().sendAccessibilityEvent(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePeekHeight(boolean z3) {
        V v5;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state == 4 && (v5 = this.viewRef.get()) != null) {
                if (z3) {
                    settleToStatePendingLayout(this.state);
                } else {
                    v5.requestLayout();
                }
            }
        }
    }

    public void addBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        if (!this.callbacks.contains(bottomSheetCallback)) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    public void dispatchOnSlide(int i3) {
        float f4;
        float f5;
        V v5 = this.viewRef.get();
        if (v5 != null && !this.callbacks.isEmpty()) {
            int i5 = this.collapsedOffset;
            if (i3 <= i5 && i5 != getExpandedOffset()) {
                int i6 = this.collapsedOffset;
                f4 = i6 - i3;
                f5 = i6 - getExpandedOffset();
            } else {
                int i7 = this.collapsedOffset;
                f4 = i7 - i3;
                f5 = this.parentHeight - i7;
            }
            float f6 = f4 / f5;
            for (int i8 = 0; i8 < this.callbacks.size(); i8++) {
                this.callbacks.get(i8).onSlide(v5, f6);
            }
        }
    }

    @Nullable
    @VisibleForTesting
    public View findScrollingChild(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i3));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
            return null;
        }
        return null;
    }

    public int getExpandedOffset() {
        int i3;
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        int i5 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets) {
            i3 = 0;
        } else {
            i3 = this.insetTop;
        }
        return Math.max(i5, i3);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    @Px
    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    @VisibleForTesting
    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull MotionEvent motionEvent) {
        boolean z3;
        View view;
        ViewDragHelper viewDragHelper;
        if (v5.isShown() && this.draggable) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                reset();
            }
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.addMovement(motionEvent);
            View view2 = null;
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    this.touchingScrollingChild = false;
                    this.activePointerId = -1;
                    if (this.ignoreEvents) {
                        this.ignoreEvents = false;
                        return false;
                    }
                }
            } else {
                int x3 = (int) motionEvent.getX();
                this.initialY = (int) motionEvent.getY();
                if (this.state != 2) {
                    WeakReference<View> weakReference = this.nestedScrollingChildRef;
                    if (weakReference != null) {
                        view = weakReference.get();
                    } else {
                        view = null;
                    }
                    if (view != null && coordinatorLayout.isPointInChildBounds(view, x3, this.initialY)) {
                        this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.touchingScrollingChild = true;
                    }
                }
                if (this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v5, x3, this.initialY)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.ignoreEvents = z3;
            }
            if (!this.ignoreEvents && (viewDragHelper = this.viewDragHelper) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                return true;
            }
            WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
            if (weakReference2 != null) {
                view2 = weakReference2.get();
            }
            if (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || Math.abs(this.initialY - motionEvent.getY()) <= this.viewDragHelper.getTouchSlop()) {
                return false;
            }
            return true;
        }
        this.ignoreEvents = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull final V v5, int i3) {
        boolean z3;
        float f4;
        MaterialShapeDrawable materialShapeDrawable;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v5)) {
            v5.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            setWindowInsetsListener(v5);
            this.viewRef = new WeakReference<>(v5);
            if (this.shapeThemingEnabled && (materialShapeDrawable = this.materialShapeDrawable) != null) {
                ViewCompat.setBackground(v5, materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
            if (materialShapeDrawable2 != null) {
                float f5 = this.elevation;
                if (f5 == -1.0f) {
                    f5 = ViewCompat.getElevation(v5);
                }
                materialShapeDrawable2.setElevation(f5);
                if (this.state == 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.isShapeExpanded = z3;
                MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
                if (z3) {
                    f4 = 0.0f;
                } else {
                    f4 = 1.0f;
                }
                materialShapeDrawable3.setInterpolation(f4);
            }
            updateAccessibilityActions();
            if (ViewCompat.getImportantForAccessibility(v5) == 0) {
                ViewCompat.setImportantForAccessibility(v5, 1);
            }
            int measuredWidth = v5.getMeasuredWidth();
            int i5 = this.maxWidth;
            if (measuredWidth > i5 && i5 != -1) {
                final ViewGroup.LayoutParams layoutParams = v5.getLayoutParams();
                layoutParams.width = this.maxWidth;
                v5.post(new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                    @Override // java.lang.Runnable
                    public void run() {
                        v5.setLayoutParams(layoutParams);
                    }
                });
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        int top = v5.getTop();
        coordinatorLayout.onLayoutChild(v5, i3);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = v5.getHeight();
        this.childHeight = height;
        int i6 = this.parentHeight;
        int i7 = i6 - height;
        int i8 = this.insetTop;
        if (i7 < i8) {
            if (this.paddingTopSystemWindowInsets) {
                this.childHeight = i6;
            } else {
                this.childHeight = i6 - i8;
            }
        }
        this.fitToContentsOffset = Math.max(0, i6 - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i9 = this.state;
        if (i9 == 3) {
            ViewCompat.offsetTopAndBottom(v5, getExpandedOffset());
        } else if (i9 == 6) {
            ViewCompat.offsetTopAndBottom(v5, this.halfExpandedOffset);
        } else if (this.hideable && i9 == 5) {
            ViewCompat.offsetTopAndBottom(v5, this.parentHeight);
        } else if (i9 == 4) {
            ViewCompat.offsetTopAndBottom(v5, this.collapsedOffset);
        } else if (i9 == 1 || i9 == 2) {
            ViewCompat.offsetTopAndBottom(v5, top - v5.getTop());
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v5));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, float f4, float f5) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        if (this.state == 3 && !super.onNestedPreFling(coordinatorLayout, v5, view, f4, f5)) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, int i3, int i5, @NonNull int[] iArr, int i6) {
        View view2;
        if (i6 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null) {
            view2 = weakReference.get();
        } else {
            view2 = null;
        }
        if (view != view2) {
            return;
        }
        int top = v5.getTop();
        int i7 = top - i5;
        if (i5 > 0) {
            if (i7 < getExpandedOffset()) {
                int expandedOffset = top - getExpandedOffset();
                iArr[1] = expandedOffset;
                ViewCompat.offsetTopAndBottom(v5, -expandedOffset);
                setStateInternal(3);
            } else if (!this.draggable) {
                return;
            } else {
                iArr[1] = i5;
                ViewCompat.offsetTopAndBottom(v5, -i5);
                setStateInternal(1);
            }
        } else if (i5 < 0 && !view.canScrollVertically(-1)) {
            int i8 = this.collapsedOffset;
            if (i7 > i8 && !this.hideable) {
                int i9 = top - i8;
                iArr[1] = i9;
                ViewCompat.offsetTopAndBottom(v5, -i9);
                setStateInternal(4);
            } else if (!this.draggable) {
                return;
            } else {
                iArr[1] = i5;
                ViewCompat.offsetTopAndBottom(v5, -i5);
                setStateInternal(1);
            }
        }
        dispatchOnSlide(v5.getTop());
        this.lastNestedScrollDy = i5;
        this.nestedScrolled = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, int i3, int i5, int i6, int i7, int i8, @NonNull int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v5, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i3 = savedState.state;
        if (i3 != 1 && i3 != 2) {
            this.state = i3;
        } else {
            this.state = 4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v5), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, @NonNull View view2, int i3, int i5) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i3 & 2) == 0) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull View view, int i3) {
        int i5;
        int i6 = 3;
        if (v5.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    i5 = this.fitToContentsOffset;
                } else {
                    int top = v5.getTop();
                    int i7 = this.halfExpandedOffset;
                    if (top > i7) {
                        i5 = i7;
                        i6 = 6;
                    } else {
                        i5 = getExpandedOffset();
                    }
                }
            } else if (this.hideable && shouldHide(v5, getYVelocity())) {
                i5 = this.parentHeight;
                i6 = 5;
            } else if (this.lastNestedScrollDy == 0) {
                int top2 = v5.getTop();
                if (this.fitToContents) {
                    if (Math.abs(top2 - this.fitToContentsOffset) < Math.abs(top2 - this.collapsedOffset)) {
                        i5 = this.fitToContentsOffset;
                    } else {
                        i5 = this.collapsedOffset;
                        i6 = 4;
                    }
                } else {
                    int i8 = this.halfExpandedOffset;
                    if (top2 < i8) {
                        if (top2 < Math.abs(top2 - this.collapsedOffset)) {
                            i5 = getExpandedOffset();
                        } else {
                            i5 = this.halfExpandedOffset;
                        }
                    } else if (Math.abs(top2 - i8) < Math.abs(top2 - this.collapsedOffset)) {
                        i5 = this.halfExpandedOffset;
                    } else {
                        i5 = this.collapsedOffset;
                        i6 = 4;
                    }
                    i6 = 6;
                }
            } else {
                if (this.fitToContents) {
                    i5 = this.collapsedOffset;
                } else {
                    int top3 = v5.getTop();
                    if (Math.abs(top3 - this.halfExpandedOffset) < Math.abs(top3 - this.collapsedOffset)) {
                        i5 = this.halfExpandedOffset;
                        i6 = 6;
                    } else {
                        i5 = this.collapsedOffset;
                    }
                }
                i6 = 4;
            }
            startSettlingAnimation(v5, i6, i5, false);
            this.nestedScrolled = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v5, @NonNull MotionEvent motionEvent) {
        if (!v5.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (this.viewDragHelper != null && actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.getTouchSlop()) {
            this.viewDragHelper.captureChildView(v5, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(@NonNull BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (bottomSheetCallback != null) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void setDraggable(boolean z3) {
        this.draggable = z3;
    }

    public void setExpandedOffset(int i3) {
        if (i3 >= 0) {
            this.expandedOffset = i3;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean z3) {
        int i3;
        if (this.fitToContents == z3) {
            return;
        }
        this.fitToContents = z3;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
        }
        if (this.fitToContents && this.state == 6) {
            i3 = 3;
        } else {
            i3 = this.state;
        }
        setStateInternal(i3);
        updateAccessibilityActions();
    }

    public void setGestureInsetBottomIgnored(boolean z3) {
        this.gestureInsetBottomIgnored = z3;
    }

    public void setHalfExpandedRatio(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (f4 > 0.0f && f4 < 1.0f) {
            this.halfExpandedRatio = f4;
            if (this.viewRef != null) {
                calculateHalfExpandedOffset();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void setHideable(boolean z3) {
        if (this.hideable != z3) {
            this.hideable = z3;
            if (!z3 && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public void setMaxWidth(@Px int i3) {
        this.maxWidth = i3;
    }

    public void setPeekHeight(int i3) {
        setPeekHeight(i3, false);
    }

    public void setSaveFlags(int i3) {
        this.saveFlags = i3;
    }

    public void setSkipCollapsed(boolean z3) {
        this.skipCollapsed = z3;
    }

    public void setState(int i3) {
        if (i3 == this.state) {
            return;
        }
        if (this.viewRef == null) {
            if (i3 == 4 || i3 == 3 || i3 == 6 || (this.hideable && i3 == 5)) {
                this.state = i3;
                return;
            }
            return;
        }
        settleToStatePendingLayout(i3);
    }

    public void setStateInternal(int i3) {
        V v5;
        if (this.state == i3) {
            return;
        }
        this.state = i3;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || (v5 = weakReference.get()) == null) {
            return;
        }
        if (i3 == 3) {
            updateImportantForAccessibility(true);
        } else if (i3 == 6 || i3 == 5 || i3 == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(i3);
        for (int i5 = 0; i5 < this.callbacks.size(); i5++) {
            this.callbacks.get(i5).onStateChanged(v5, i3);
        }
        updateAccessibilityActions();
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z3) {
        this.updateImportantForAccessibilityOnSiblings = z3;
    }

    public void settleToState(@NonNull View view, int i3) {
        int i5;
        int i6;
        if (i3 == 4) {
            i5 = this.collapsedOffset;
        } else if (i3 == 6) {
            i5 = this.halfExpandedOffset;
            if (this.fitToContents && i5 <= (i6 = this.fitToContentsOffset)) {
                i5 = i6;
                i3 = 3;
            }
        } else if (i3 == 3) {
            i5 = getExpandedOffset();
        } else if (this.hideable && i3 == 5) {
            i5 = this.parentHeight;
        } else {
            throw new IllegalArgumentException(i.e(i3, "Illegal state argument: "));
        }
        startSettlingAnimation(view, i3, i5, false);
    }

    public boolean shouldHide(@NonNull View view, float f4) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs(((f4 * 0.1f) + view.getTop()) - this.collapsedOffset) / calculatePeekHeight() > 0.5f) {
            return true;
        }
        return false;
    }

    public void startSettlingAnimation(View view, int i3, int i5, boolean z3) {
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null && (!z3 ? viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i5) : viewDragHelper.settleCapturedViewAt(view.getLeft(), i5))) {
            setStateInternal(2);
            updateDrawableForTargetState(i3);
            if (this.settleRunnable == null) {
                this.settleRunnable = new SettleRunnable(view, i3);
            }
            if (!((SettleRunnable) this.settleRunnable).isPosted) {
                BottomSheetBehavior<V>.SettleRunnable settleRunnable = this.settleRunnable;
                settleRunnable.targetState = i3;
                ViewCompat.postOnAnimation(view, settleRunnable);
                ((SettleRunnable) this.settleRunnable).isPosted = true;
                return;
            }
            this.settleRunnable.targetState = i3;
            return;
        }
        setStateInternal(i3);
    }

    private void createMaterialShapeDrawable(@NonNull Context context, AttributeSet attributeSet, boolean z3, @Nullable ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = materialShapeDrawable;
            materialShapeDrawable.initializeElevationOverlay(context);
            if (z3 && colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    public final void setPeekHeight(int i3, boolean z3) {
        if (i3 == -1) {
            if (this.peekHeightAuto) {
                return;
            }
            this.peekHeightAuto = true;
        } else if (!this.peekHeightAuto && this.peekHeight == i3) {
            return;
        } else {
            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, i3);
        }
        updatePeekHeight(z3);
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i3;
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.settleRunnable = null;
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.state = 4;
        this.callbacks = new ArrayList<>();
        this.expandHalfwayActionId = -1;
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
            private boolean releasedLow(@NonNull View view) {
                int top = view.getTop();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (top > (bottomSheetBehavior.getExpandedOffset() + bottomSheetBehavior.parentHeight) / 2) {
                    return true;
                }
                return false;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view, int i32, int i5) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view, int i32, int i5) {
                int i6;
                int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.hideable) {
                    i6 = bottomSheetBehavior.parentHeight;
                } else {
                    i6 = bottomSheetBehavior.collapsedOffset;
                }
                return MathUtils.clamp(i32, expandedOffset, i6);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(@NonNull View view) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.hideable) {
                    return bottomSheetBehavior.parentHeight;
                }
                return bottomSheetBehavior.collapsedOffset;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i32) {
                if (i32 == 1 && BottomSheetBehavior.this.draggable) {
                    BottomSheetBehavior.this.setStateInternal(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i32, int i5, int i6, int i7) {
                BottomSheetBehavior.this.dispatchOnSlide(i5);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view, float f4, float f5) {
                int i32;
                int i5 = 6;
                if (f5 < 0.0f) {
                    if (BottomSheetBehavior.this.fitToContents) {
                        i32 = BottomSheetBehavior.this.fitToContentsOffset;
                    } else {
                        int top = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                        int i6 = bottomSheetBehavior.halfExpandedOffset;
                        if (top > i6) {
                            i32 = i6;
                        } else {
                            i32 = bottomSheetBehavior.getExpandedOffset();
                        }
                    }
                    i5 = 3;
                } else {
                    BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior2.hideable && bottomSheetBehavior2.shouldHide(view, f5)) {
                        if ((Math.abs(f4) < Math.abs(f5) && f5 > 500.0f) || releasedLow(view)) {
                            i32 = BottomSheetBehavior.this.parentHeight;
                            i5 = 5;
                        } else {
                            if (BottomSheetBehavior.this.fitToContents) {
                                i32 = BottomSheetBehavior.this.fitToContentsOffset;
                            } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.getExpandedOffset()) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                                i32 = BottomSheetBehavior.this.getExpandedOffset();
                            } else {
                                i32 = BottomSheetBehavior.this.halfExpandedOffset;
                            }
                            i5 = 3;
                        }
                    } else if (f5 != 0.0f && Math.abs(f4) <= Math.abs(f5)) {
                        if (BottomSheetBehavior.this.fitToContents) {
                            i32 = BottomSheetBehavior.this.collapsedOffset;
                        } else {
                            int top2 = view.getTop();
                            if (Math.abs(top2 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                                i32 = BottomSheetBehavior.this.halfExpandedOffset;
                            } else {
                                i32 = BottomSheetBehavior.this.collapsedOffset;
                            }
                        }
                        i5 = 4;
                    } else {
                        int top3 = view.getTop();
                        if (BottomSheetBehavior.this.fitToContents) {
                            if (Math.abs(top3 - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset)) {
                                i32 = BottomSheetBehavior.this.fitToContentsOffset;
                                i5 = 3;
                            } else {
                                i32 = BottomSheetBehavior.this.collapsedOffset;
                                i5 = 4;
                            }
                        } else {
                            BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                            int i7 = bottomSheetBehavior3.halfExpandedOffset;
                            if (top3 < i7) {
                                if (top3 < Math.abs(top3 - bottomSheetBehavior3.collapsedOffset)) {
                                    i32 = BottomSheetBehavior.this.getExpandedOffset();
                                    i5 = 3;
                                } else {
                                    i32 = BottomSheetBehavior.this.halfExpandedOffset;
                                }
                            } else if (Math.abs(top3 - i7) < Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset)) {
                                i32 = BottomSheetBehavior.this.halfExpandedOffset;
                            } else {
                                i32 = BottomSheetBehavior.this.collapsedOffset;
                                i5 = 4;
                            }
                        }
                    }
                }
                BottomSheetBehavior.this.startSettlingAnimation(view, i5, i32, true);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view, int i32) {
                View view2;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i5 = bottomSheetBehavior.state;
                if (i5 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                    return false;
                }
                if (i5 == 3 && bottomSheetBehavior.activePointerId == i32) {
                    WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                    if (weakReference != null) {
                        view2 = weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
                if (weakReference2 == null || weakReference2.get() != view) {
                    return false;
                }
                return true;
            }
        };
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i5 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i5);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, MaterialResources.getColorStateList(context, obtainStyledAttributes, i5));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue);
        }
        createShapeValueAnimator();
        this.elevation = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i6 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (obtainStyledAttributes.hasValue(i6)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(i6, -1));
        }
        int i7 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i7);
        if (peekValue != null && (i3 = peekValue.data) == -1) {
            setPeekHeight(i3);
        } else {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i7, -1));
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i8 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i8);
        if (peekValue2 != null && peekValue2.type == 16) {
            setExpandedOffset(peekValue2.data);
        } else {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(i8, 0));
        }
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
