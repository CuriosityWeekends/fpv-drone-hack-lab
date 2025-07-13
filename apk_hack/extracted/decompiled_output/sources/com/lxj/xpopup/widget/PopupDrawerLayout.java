package com.lxj.xpopup.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsSeekBar;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import c3.b;
import c3.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PopupDrawerLayout extends FrameLayout {
    ViewDragHelper.Callback callback;
    boolean canChildScrollLeft;
    float downX;
    float downY;
    ViewDragHelper dragHelper;
    public boolean enableDrag;
    float fraction;
    boolean hasLayout;
    public boolean isDismissOnTouchOutside;
    boolean isIntercept;
    boolean isToLeft;
    private OnCloseListener listener;
    View mChild;
    View placeHolder;
    public c position;
    b status;
    float ty;

    /* renamed from: x  reason: collision with root package name */
    float f1129x;

    /* renamed from: y  reason: collision with root package name */
    float f1130y;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface OnCloseListener {
        void onClose();

        void onDrag(int i3, float f4, boolean z3);

        void onOpen();
    }

    public PopupDrawerLayout(Context context) {
        this(context, null);
    }

    private boolean canScroll(ViewGroup viewGroup, float f4, float f5, int i3) {
        for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
            View childAt = viewGroup.getChildAt(i5);
            int[] iArr = new int[2];
            childAt.getLocationInWindow(iArr);
            int i6 = iArr[0];
            if (com.lxj.xpopup.util.b.l(f4, f5, new Rect(i6, iArr[1], childAt.getWidth() + i6, childAt.getHeight() + iArr[1]))) {
                if (childAt instanceof ViewGroup) {
                    if (childAt instanceof ViewPager) {
                        ViewPager viewPager = (ViewPager) childAt;
                        if (i3 == 0) {
                            if (!viewPager.canScrollHorizontally(-1)) {
                                viewPager.canScrollHorizontally(1);
                            }
                            return viewPager.canScrollHorizontally(-1) || viewPager.canScrollHorizontally(1);
                        }
                        return viewPager.canScrollHorizontally(i3);
                    } else if (childAt instanceof HorizontalScrollView) {
                        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) childAt;
                        if (i3 == 0) {
                            return horizontalScrollView.canScrollHorizontally(-1) || horizontalScrollView.canScrollHorizontally(1);
                        }
                        return horizontalScrollView.canScrollHorizontally(i3);
                    } else if (childAt instanceof ViewPager2) {
                        RecyclerView recyclerView = (RecyclerView) ((ViewPager2) childAt).getChildAt(0);
                        return recyclerView.canScrollHorizontally(-1) || recyclerView.canScrollHorizontally(1);
                    } else {
                        return canScroll((ViewGroup) childAt, f4, f5, i3);
                    }
                } else if ((childAt instanceof AbsSeekBar) && childAt.isEnabled()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fixLeft(int i3) {
        c cVar = this.position;
        if (cVar == c.f229a) {
            if (i3 < (-this.mChild.getMeasuredWidth())) {
                i3 = -this.mChild.getMeasuredWidth();
            }
            if (i3 > 0) {
                return 0;
            }
            return i3;
        } else if (cVar == c.b) {
            if (i3 < getMeasuredWidth() - this.mChild.getMeasuredWidth()) {
                i3 = getMeasuredWidth() - this.mChild.getMeasuredWidth();
            }
            if (i3 > getMeasuredWidth()) {
                return getMeasuredWidth();
            }
            return i3;
        } else {
            return i3;
        }
    }

    public void close() {
        post(new Runnable() { // from class: com.lxj.xpopup.widget.PopupDrawerLayout.3
            @Override // java.lang.Runnable
            public void run() {
                int measuredWidth;
                PopupDrawerLayout.this.dragHelper.abort();
                PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                ViewDragHelper viewDragHelper = popupDrawerLayout.dragHelper;
                View view = popupDrawerLayout.mChild;
                if (popupDrawerLayout.position == c.f229a) {
                    measuredWidth = -view.getMeasuredWidth();
                } else {
                    measuredWidth = popupDrawerLayout.getMeasuredWidth();
                }
                viewDragHelper.smoothSlideViewTo(view, measuredWidth, 0);
                ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
            }
        });
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.dragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ty = getTranslationY();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.placeHolder = getChildAt(0);
        this.mChild = getChildAt(1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
        if (r0 != 3) goto L20;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.enableDrag
            if (r0 != 0) goto L9
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        L9:
            androidx.customview.widget.ViewDragHelper r0 = r5.dragHelper
            r1 = 1
            boolean r0 = r0.continueSettling(r1)
            if (r0 != 0) goto La3
            c3.b r0 = r5.status
            c3.b r2 = c3.b.b
            if (r0 != r2) goto L1a
            goto La3
        L1a:
            float r0 = r6.getX()
            float r2 = r5.f1129x
            r3 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L27
            r0 = 1
            goto L28
        L27:
            r0 = 0
        L28:
            r5.isToLeft = r0
            float r0 = r6.getX()
            r5.f1129x = r0
            float r0 = r6.getY()
            r5.f1130y = r0
            int r0 = r6.getAction()
            if (r0 == 0) goto L62
            if (r0 == r1) goto L5c
            r2 = 2
            if (r0 == r2) goto L45
            r2 = 3
            if (r0 == r2) goto L5c
            goto L6e
        L45:
            float r0 = r5.f1129x
            float r2 = r5.downX
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r5.f1130y
            float r4 = r5.downY
            float r2 = r2 - r4
            float r2 = java.lang.Math.abs(r2)
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L6e
            return r3
        L5c:
            r0 = 0
            r5.f1129x = r0
            r5.f1130y = r0
            goto L6e
        L62:
            float r0 = r6.getX()
            r5.downX = r0
            float r0 = r6.getY()
            r5.downY = r0
        L6e:
            float r0 = r6.getX()
            float r2 = r6.getY()
            boolean r0 = r5.canScroll(r5, r0, r2, r1)
            r5.canChildScrollLeft = r0
            androidx.customview.widget.ViewDragHelper r0 = r5.dragHelper
            boolean r0 = r0.shouldInterceptTouchEvent(r6)
            r5.isIntercept = r0
            boolean r1 = r5.isToLeft
            if (r1 == 0) goto L8d
            boolean r1 = r5.canChildScrollLeft
            if (r1 != 0) goto L8d
            return r0
        L8d:
            float r0 = r6.getX()
            float r1 = r6.getY()
            boolean r0 = r5.canScroll(r5, r0, r1)
            if (r0 != 0) goto L9e
            boolean r6 = r5.isIntercept
            return r6
        L9e:
            boolean r6 = super.onInterceptTouchEvent(r6)
            return r6
        La3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lxj.xpopup.widget.PopupDrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i3, int i5, int i6, int i7) {
        this.placeHolder.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        if (!this.hasLayout) {
            if (this.position == c.f229a) {
                View view = this.mChild;
                view.layout(-view.getMeasuredWidth(), 0, 0, getMeasuredHeight());
            } else {
                this.mChild.layout(getMeasuredWidth(), 0, this.mChild.getMeasuredWidth() + getMeasuredWidth(), getMeasuredHeight());
            }
            this.hasLayout = true;
            return;
        }
        View view2 = this.mChild;
        view2.layout(view2.getLeft(), this.mChild.getTop(), this.mChild.getRight(), this.mChild.getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.enableDrag) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.dragHelper.continueSettling(true)) {
            return true;
        }
        this.dragHelper.processTouchEvent(motionEvent);
        return true;
    }

    public void open() {
        post(new Runnable() { // from class: com.lxj.xpopup.widget.PopupDrawerLayout.2
            @Override // java.lang.Runnable
            public void run() {
                int left;
                PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                ViewDragHelper viewDragHelper = popupDrawerLayout.dragHelper;
                View view = popupDrawerLayout.mChild;
                if (popupDrawerLayout.position == c.f229a) {
                    left = 0;
                } else {
                    left = view.getLeft() - PopupDrawerLayout.this.mChild.getMeasuredWidth();
                }
                viewDragHelper.smoothSlideViewTo(view, left, 0);
                ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
            }
        });
    }

    public void setDrawerPosition(c cVar) {
        this.position = cVar;
    }

    public void setOnCloseListener(OnCloseListener onCloseListener) {
        this.listener = onCloseListener;
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PopupDrawerLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.status = null;
        this.position = c.f229a;
        this.fraction = 0.0f;
        this.enableDrag = true;
        this.hasLayout = false;
        this.isIntercept = false;
        ViewDragHelper.Callback callback = new ViewDragHelper.Callback() { // from class: com.lxj.xpopup.widget.PopupDrawerLayout.1
            private void calcFraction(int i5, int i6) {
                boolean z3;
                PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                c cVar = popupDrawerLayout.position;
                c cVar2 = c.f229a;
                b bVar = b.b;
                if (cVar == cVar2) {
                    popupDrawerLayout.fraction = ((popupDrawerLayout.mChild.getMeasuredWidth() + i5) * 1.0f) / PopupDrawerLayout.this.mChild.getMeasuredWidth();
                    if (i5 == (-PopupDrawerLayout.this.mChild.getMeasuredWidth()) && PopupDrawerLayout.this.listener != null) {
                        PopupDrawerLayout popupDrawerLayout2 = PopupDrawerLayout.this;
                        if (popupDrawerLayout2.status != bVar) {
                            popupDrawerLayout2.status = bVar;
                            popupDrawerLayout2.listener.onClose();
                        }
                    }
                } else if (cVar == c.b) {
                    popupDrawerLayout.fraction = ((popupDrawerLayout.getMeasuredWidth() - i5) * 1.0f) / PopupDrawerLayout.this.mChild.getMeasuredWidth();
                    if (i5 == PopupDrawerLayout.this.getMeasuredWidth() && PopupDrawerLayout.this.listener != null) {
                        PopupDrawerLayout popupDrawerLayout3 = PopupDrawerLayout.this;
                        if (popupDrawerLayout3.status != bVar) {
                            popupDrawerLayout3.status = bVar;
                            popupDrawerLayout3.listener.onClose();
                        }
                    }
                }
                if (PopupDrawerLayout.this.listener != null) {
                    OnCloseListener onCloseListener = PopupDrawerLayout.this.listener;
                    float f4 = PopupDrawerLayout.this.fraction;
                    if (i6 < 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    onCloseListener.onDrag(i5, f4, z3);
                    PopupDrawerLayout popupDrawerLayout4 = PopupDrawerLayout.this;
                    if (popupDrawerLayout4.fraction == 1.0f) {
                        b bVar2 = popupDrawerLayout4.status;
                        b bVar3 = b.f227a;
                        if (bVar2 != bVar3) {
                            popupDrawerLayout4.status = bVar3;
                            popupDrawerLayout4.listener.onOpen();
                        }
                    }
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view, int i5, int i6) {
                PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                if (view != popupDrawerLayout.placeHolder) {
                    return popupDrawerLayout.fixLeft(i5);
                }
                return i5;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewHorizontalDragRange(@NonNull View view) {
                return 1;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i5, int i6, int i7, int i8) {
                super.onViewPositionChanged(view, i5, i6, i7, i8);
                View view2 = PopupDrawerLayout.this.placeHolder;
                if (view == view2) {
                    view2.layout(0, 0, view2.getMeasuredWidth(), PopupDrawerLayout.this.placeHolder.getMeasuredHeight());
                    PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                    int fixLeft = popupDrawerLayout.fixLeft(popupDrawerLayout.mChild.getLeft() + i7);
                    View view3 = PopupDrawerLayout.this.mChild;
                    view3.layout(fixLeft, view3.getTop(), PopupDrawerLayout.this.mChild.getMeasuredWidth() + fixLeft, PopupDrawerLayout.this.mChild.getBottom());
                    calcFraction(fixLeft, i7);
                    return;
                }
                calcFraction(i5, i7);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view, float f4, float f5) {
                int measuredWidth;
                int measuredWidth2;
                super.onViewReleased(view, f4, f5);
                PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                if (view == popupDrawerLayout.placeHolder && f4 == 0.0f) {
                    if (popupDrawerLayout.isDismissOnTouchOutside) {
                        popupDrawerLayout.close();
                        return;
                    }
                    return;
                }
                View view2 = popupDrawerLayout.mChild;
                if (view == view2 && popupDrawerLayout.isToLeft && !popupDrawerLayout.canChildScrollLeft && f4 < -500.0f) {
                    popupDrawerLayout.close();
                    return;
                }
                if (popupDrawerLayout.position == c.f229a) {
                    if (f4 < -1000.0f) {
                        measuredWidth2 = view2.getMeasuredWidth();
                    } else {
                        if (PopupDrawerLayout.this.mChild.getLeft() < (-view2.getMeasuredWidth()) / 2) {
                            measuredWidth2 = PopupDrawerLayout.this.mChild.getMeasuredWidth();
                        } else {
                            measuredWidth = 0;
                        }
                    }
                    measuredWidth = -measuredWidth2;
                } else if (f4 > 1000.0f) {
                    measuredWidth = popupDrawerLayout.getMeasuredWidth();
                } else {
                    if (view.getLeft() < popupDrawerLayout.getMeasuredWidth() - (PopupDrawerLayout.this.mChild.getMeasuredWidth() / 2)) {
                        measuredWidth = PopupDrawerLayout.this.getMeasuredWidth() - PopupDrawerLayout.this.mChild.getMeasuredWidth();
                    } else {
                        measuredWidth = PopupDrawerLayout.this.getMeasuredWidth();
                    }
                }
                PopupDrawerLayout popupDrawerLayout2 = PopupDrawerLayout.this;
                popupDrawerLayout2.dragHelper.smoothSlideViewTo(popupDrawerLayout2.mChild, measuredWidth, view.getTop());
                ViewCompat.postInvalidateOnAnimation(PopupDrawerLayout.this);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view, int i5) {
                PopupDrawerLayout popupDrawerLayout = PopupDrawerLayout.this;
                if (popupDrawerLayout.enableDrag && !popupDrawerLayout.dragHelper.continueSettling(true) && PopupDrawerLayout.this.status != b.b) {
                    return true;
                }
                return false;
            }
        };
        this.callback = callback;
        this.isDismissOnTouchOutside = true;
        this.dragHelper = ViewDragHelper.create(this, callback);
    }

    private boolean canScroll(ViewGroup viewGroup, float f4, float f5) {
        return canScroll(viewGroup, f4, f5, 0);
    }
}
