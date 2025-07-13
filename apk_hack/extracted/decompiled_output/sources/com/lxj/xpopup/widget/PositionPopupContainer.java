package com.lxj.xpopup.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import c3.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PositionPopupContainer extends FrameLayout {
    private static final String TAG = "PositionPopupContainer";
    boolean canIntercept;
    ViewDragHelper.Callback cb;
    public View child;
    private ViewDragHelper dragHelper;
    public a dragOrientation;
    public float dragRatio;
    public boolean enableDrag;
    private OnPositionDragListener positionDragListener;
    int touchSlop;
    private float touchX;
    private float touchY;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface OnPositionDragListener {
        void onDismiss();
    }

    public PositionPopupContainer(@NonNull Context context) {
        this(context, null);
    }

    private void init() {
        this.dragHelper = ViewDragHelper.create(this, this.cb);
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.dragHelper.continueSettling(false)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z3 = true;
        if (motionEvent.getPointerCount() <= 1 && this.enableDrag) {
            try {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 3) {
                            }
                        } else {
                            if (Math.sqrt(Math.pow(motionEvent.getX() - this.touchX, 2.0d) + Math.pow(motionEvent.getY() - this.touchY, 2.0d)) <= this.touchSlop) {
                                z3 = false;
                            }
                            this.canIntercept = z3;
                            this.touchX = motionEvent.getX();
                            this.touchY = motionEvent.getY();
                        }
                    }
                    this.touchX = 0.0f;
                    this.touchY = 0.0f;
                } else {
                    this.touchX = motionEvent.getX();
                    this.touchY = motionEvent.getY();
                }
            } catch (Exception unused) {
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.enableDrag) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.dragHelper.shouldInterceptTouchEvent(motionEvent);
        if (!this.dragHelper.shouldInterceptTouchEvent(motionEvent) && !this.canIntercept) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i5, int i6, int i7) {
        super.onSizeChanged(i3, i5, i6, i7);
        this.child = getChildAt(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() <= 1 && this.enableDrag) {
            try {
                this.dragHelper.processTouchEvent(motionEvent);
            } catch (Exception unused) {
            }
            return true;
        }
        return false;
    }

    public void setOnPositionDragChangeListener(OnPositionDragListener onPositionDragListener) {
        this.positionDragListener = onPositionDragListener;
    }

    public PositionPopupContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PositionPopupContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.dragRatio = 0.2f;
        this.enableDrag = false;
        this.dragOrientation = a.f225a;
        this.canIntercept = false;
        this.cb = new ViewDragHelper.Callback() { // from class: com.lxj.xpopup.widget.PositionPopupContainer.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view, int i5, int i6) {
                a aVar = PositionPopupContainer.this.dragOrientation;
                if (aVar == a.c) {
                    if (i6 >= 0) {
                        return 0;
                    }
                    return i5;
                } else if (aVar != a.d || i6 <= 0) {
                    return 0;
                } else {
                    return i5;
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view, int i5, int i6) {
                a aVar = PositionPopupContainer.this.dragOrientation;
                if (aVar == a.f225a) {
                    if (i6 >= 0) {
                        return 0;
                    }
                    return i5;
                } else if (aVar != a.b || i6 <= 0) {
                    return 0;
                } else {
                    return i5;
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewHorizontalDragRange(@NonNull View view) {
                a aVar = PositionPopupContainer.this.dragOrientation;
                if (aVar != a.c && aVar != a.d) {
                    return 0;
                }
                return 1;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(@NonNull View view) {
                a aVar = PositionPopupContainer.this.dragOrientation;
                if (aVar != a.f225a && aVar != a.b) {
                    return 0;
                }
                return 1;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i5, int i6, int i7, int i8) {
                super.onViewPositionChanged(view, i5, i6, i7, i8);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view, float f4, float f5) {
                super.onViewReleased(view, f4, f5);
                float measuredWidth = view.getMeasuredWidth() * PositionPopupContainer.this.dragRatio;
                PositionPopupContainer positionPopupContainer = PositionPopupContainer.this;
                float measuredHeight = view.getMeasuredHeight() * positionPopupContainer.dragRatio;
                if ((positionPopupContainer.dragOrientation == a.c && view.getLeft() < (-measuredWidth)) || ((PositionPopupContainer.this.dragOrientation == a.d && view.getRight() > view.getMeasuredWidth() + measuredWidth) || ((PositionPopupContainer.this.dragOrientation == a.f225a && view.getTop() < (-measuredHeight)) || (PositionPopupContainer.this.dragOrientation == a.b && view.getBottom() > view.getMeasuredHeight() + measuredHeight)))) {
                    PositionPopupContainer.this.positionDragListener.onDismiss();
                    return;
                }
                PositionPopupContainer.this.dragHelper.smoothSlideViewTo(view, 0, 0);
                ViewCompat.postInvalidateOnAnimation(PositionPopupContainer.this);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view, int i5) {
                PositionPopupContainer positionPopupContainer = PositionPopupContainer.this;
                if (view == positionPopupContainer.child && positionPopupContainer.enableDrag) {
                    return true;
                }
                return false;
            }
        };
        init();
    }
}
