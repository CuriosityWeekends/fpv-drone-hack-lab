package com.lxj.xpopup.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ViewCompat;
import c3.b;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SmartDragLayout extends LinearLayout implements NestedScrollingParent {
    private View child;
    boolean dismissOnTouchOutside;
    int duration;
    boolean enableDrag;
    boolean isScrollUp;
    boolean isThreeDrag;
    boolean isUserClose;
    int lastHeight;
    private OnCloseListener listener;
    int maxY;
    int minY;
    OverScroller scroller;
    b status;
    float touchX;
    float touchY;
    VelocityTracker tracker;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface OnCloseListener {
        void onClose();

        void onDrag(int i3, float f4, boolean z3);

        void onOpen();
    }

    public SmartDragLayout(Context context) {
        this(context, null);
    }

    private void finishScroll() {
        int i3;
        int i5;
        int scrollY;
        if (this.enableDrag) {
            if (this.isScrollUp) {
                i3 = this.maxY - this.minY;
            } else {
                i3 = (this.maxY - this.minY) * 2;
            }
            if (getScrollY() > i3 / 3) {
                i5 = this.maxY;
            } else {
                i5 = this.minY;
            }
            int scrollY2 = i5 - getScrollY();
            if (this.isThreeDrag) {
                int i6 = this.maxY / 3;
                float f4 = i6;
                float f5 = 2.5f * f4;
                if (getScrollY() > f5) {
                    i6 = this.maxY;
                    scrollY = getScrollY();
                } else if (getScrollY() <= f5 && getScrollY() > f4 * 1.5f) {
                    i6 *= 2;
                    scrollY = getScrollY();
                } else if (getScrollY() > i6) {
                    scrollY = getScrollY();
                } else {
                    i6 = this.minY;
                    scrollY = getScrollY();
                }
                scrollY2 = i6 - scrollY;
            }
            this.scroller.startScroll(getScrollX(), getScrollY(), 0, scrollY2, this.duration);
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScroll(int i3, boolean z3) {
        float f4;
        OverScroller overScroller = this.scroller;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (z3) {
            f4 = this.duration;
        } else {
            f4 = this.duration * 0.8f;
        }
        overScroller.startScroll(scrollX, scrollY, 0, i3, (int) f4);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public void close() {
        this.isUserClose = true;
        post(new Runnable() { // from class: com.lxj.xpopup.widget.SmartDragLayout.2
            @Override // java.lang.Runnable
            public void run() {
                SmartDragLayout.this.scroller.abortAnimation();
                SmartDragLayout smartDragLayout = SmartDragLayout.this;
                smartDragLayout.smoothScroll(smartDragLayout.minY - smartDragLayout.getScrollY(), false);
                SmartDragLayout.this.status = b.d;
            }
        });
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.scroller.computeScrollOffset()) {
            scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void dismissOnTouchOutside(boolean z3) {
        this.dismissOnTouchOutside = z3;
    }

    public void enableDrag(boolean z3) {
        this.enableDrag = z3;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return 2;
    }

    public void isThreeDrag(boolean z3) {
        this.isThreeDrag = z3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isScrollUp = false;
        this.isUserClose = false;
        setTranslationY(0.0f);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.isUserClose = true;
        b bVar = this.status;
        if (bVar != b.d && bVar != b.c) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i3, int i5, int i6, int i7) {
        if (this.enableDrag) {
            View view = this.child;
            if (view == null) {
                return;
            }
            this.maxY = view.getMeasuredHeight();
            this.minY = 0;
            int measuredWidth = (getMeasuredWidth() / 2) - (this.child.getMeasuredWidth() / 2);
            this.child.layout(measuredWidth, getMeasuredHeight(), this.child.getMeasuredWidth() + measuredWidth, getMeasuredHeight() + this.maxY);
            if (this.status == b.f227a) {
                if (this.isThreeDrag) {
                    scrollTo(getScrollX(), getScrollY() - (this.lastHeight - this.maxY));
                } else {
                    scrollTo(getScrollX(), getScrollY() - (this.lastHeight - this.maxY));
                }
            }
            this.lastHeight = this.maxY;
            return;
        }
        int measuredWidth2 = (getMeasuredWidth() / 2) - (this.child.getMeasuredWidth() / 2);
        this.child.layout(measuredWidth2, getMeasuredHeight() - this.child.getMeasuredHeight(), this.child.getMeasuredWidth() + measuredWidth2, getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f4, float f5, boolean z3) {
        if (getScrollY() > this.minY && getScrollY() < this.maxY && f5 < -1500.0f && !this.isThreeDrag) {
            close();
            return false;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f4, float f5) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i3, int i5, int[] iArr) {
        if (i5 > 0) {
            int scrollY = getScrollY() + i5;
            if (scrollY < this.maxY) {
                iArr[1] = i5;
            }
            scrollTo(getScrollX(), scrollY);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i3, int i5, int i6, int i7) {
        scrollTo(getScrollX(), getScrollY() + i7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        this.scroller.abortAnimation();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        if (i3 == 2 && this.enableDrag) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        finishScroll();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
        if (r0 != 3) goto L21;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.widget.SmartDragLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        this.child = view;
    }

    public void open() {
        post(new Runnable() { // from class: com.lxj.xpopup.widget.SmartDragLayout.1
            @Override // java.lang.Runnable
            public void run() {
                SmartDragLayout smartDragLayout = SmartDragLayout.this;
                int scrollY = smartDragLayout.maxY - smartDragLayout.getScrollY();
                SmartDragLayout smartDragLayout2 = SmartDragLayout.this;
                if (smartDragLayout2.enableDrag && smartDragLayout2.isThreeDrag) {
                    scrollY /= 3;
                }
                smartDragLayout2.smoothScroll(scrollY, true);
                SmartDragLayout.this.status = b.c;
            }
        });
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i5) {
        boolean z3;
        int i6 = this.maxY;
        if (i5 > i6) {
            i5 = i6;
        }
        int i7 = this.minY;
        if (i5 < i7) {
            i5 = i7;
        }
        float f4 = ((i5 - i7) * 1.0f) / (i6 - i7);
        if (i5 > getScrollY()) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.isScrollUp = z3;
        OnCloseListener onCloseListener = this.listener;
        if (onCloseListener != null) {
            if (this.isUserClose && f4 == 0.0f) {
                b bVar = this.status;
                b bVar2 = b.b;
                if (bVar != bVar2) {
                    this.status = bVar2;
                    onCloseListener.onClose();
                    this.listener.onDrag(i5, f4, this.isScrollUp);
                }
            }
            if (f4 == 1.0f) {
                b bVar3 = this.status;
                b bVar4 = b.f227a;
                if (bVar3 != bVar4) {
                    this.status = bVar4;
                    onCloseListener.onOpen();
                }
            }
            this.listener.onDrag(i5, f4, this.isScrollUp);
        }
        super.scrollTo(i3, i5);
    }

    public void setDuration(int i3) {
        this.duration = i3;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.listener = onCloseListener;
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartDragLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.enableDrag = true;
        this.dismissOnTouchOutside = true;
        this.isUserClose = false;
        this.isThreeDrag = false;
        this.status = b.b;
        this.duration = 400;
        this.scroller = new OverScroller(context);
    }
}
