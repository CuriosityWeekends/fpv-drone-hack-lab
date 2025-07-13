package com.lxj.xpopup.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager.widget.ViewPager;
import com.lxj.xpopup.core.ImageViewerPopupView;
import com.lxj.xpopup.photoview.PhotoView;
import e3.c;
import f3.o;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PhotoViewContainer extends FrameLayout {
    private static final String TAG = "PhotoViewContainer";
    private int HideTopThreshold;
    ViewDragHelper.Callback cb;
    private c dragChangeListener;
    private ViewDragHelper dragHelper;
    public boolean isReleasing;
    boolean isVertical;
    private int maxOffset;
    private float touchX;
    private float touchY;
    public ViewPager viewPager;

    public PhotoViewContainer(@NonNull Context context) {
        this(context, null);
    }

    private View getCurrentImageView() {
        ViewPager viewPager = this.viewPager;
        FrameLayout frameLayout = (FrameLayout) viewPager.getChildAt(viewPager.getCurrentItem());
        if (frameLayout == null) {
            return null;
        }
        return frameLayout.getChildAt(0);
    }

    private void init() {
        this.HideTopThreshold = dip2px(this.HideTopThreshold);
        this.dragHelper = ViewDragHelper.create(this, this.cb);
        setBackgroundColor(0);
    }

    private boolean isTopOrBottomEnd() {
        View currentImageView = getCurrentImageView();
        if (!(currentImageView instanceof PhotoView)) {
            return false;
        }
        o oVar = ((PhotoView) currentImageView).f1092a;
        if (!oVar.f1889u && !oVar.f1890v) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.dragHelper.continueSettling(false)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public int dip2px(float f4) {
        return (int) ((f4 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z3 = true;
        if (motionEvent.getPointerCount() > 1) {
            return super.dispatchTouchEvent(motionEvent);
        }
        try {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                        }
                    } else {
                        float x3 = motionEvent.getX() - this.touchX;
                        float y3 = motionEvent.getY() - this.touchY;
                        this.viewPager.dispatchTouchEvent(motionEvent);
                        if (Math.abs(y3) <= Math.abs(x3)) {
                            z3 = false;
                        }
                        this.isVertical = z3;
                        this.touchX = motionEvent.getX();
                        this.touchY = motionEvent.getY();
                    }
                }
                this.touchX = 0.0f;
                this.touchY = 0.0f;
                this.isVertical = false;
            } else {
                this.touchX = motionEvent.getX();
                this.touchY = motionEvent.getY();
            }
        } catch (Exception unused) {
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isReleasing = false;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.viewPager = (ViewPager) getChildAt(0);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean shouldInterceptTouchEvent = this.dragHelper.shouldInterceptTouchEvent(motionEvent);
        if (motionEvent.getPointerCount() > 1 && motionEvent.getAction() == 2) {
            return false;
        }
        if (isTopOrBottomEnd() && this.isVertical) {
            return true;
        }
        if (!shouldInterceptTouchEvent || !this.isVertical) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i5, int i6, int i7) {
        super.onSizeChanged(i3, i5, i6, i7);
        this.maxOffset = getHeight() / 3;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() > 1) {
            return false;
        }
        try {
            this.dragHelper.processTouchEvent(motionEvent);
        } catch (Exception unused) {
        }
        return true;
    }

    public void setOnDragChangeListener(c cVar) {
        this.dragChangeListener = cVar;
    }

    public PhotoViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.HideTopThreshold = 80;
        this.isReleasing = false;
        this.isVertical = false;
        this.cb = new ViewDragHelper.Callback() { // from class: com.lxj.xpopup.widget.PhotoViewContainer.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view, int i5, int i6) {
                int top = (i6 / 2) + PhotoViewContainer.this.viewPager.getTop();
                if (top >= 0) {
                    return Math.min(top, PhotoViewContainer.this.maxOffset);
                }
                return -Math.min(-top, PhotoViewContainer.this.maxOffset);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(@NonNull View view) {
                return 1;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i5, int i6, int i7, int i8) {
                super.onViewPositionChanged(view, i5, i6, i7, i8);
                ViewPager viewPager = PhotoViewContainer.this.viewPager;
                if (view != viewPager) {
                    viewPager.offsetTopAndBottom(i8);
                }
                float abs = (Math.abs(i6) * 1.0f) / PhotoViewContainer.this.maxOffset;
                float f4 = 1.0f - (0.2f * abs);
                PhotoViewContainer.this.viewPager.setScaleX(f4);
                PhotoViewContainer.this.viewPager.setScaleY(f4);
                view.setScaleX(f4);
                view.setScaleY(f4);
                if (PhotoViewContainer.this.dragChangeListener != null) {
                    ImageViewerPopupView imageViewerPopupView = (ImageViewerPopupView) PhotoViewContainer.this.dragChangeListener;
                    float f5 = 1.0f - abs;
                    imageViewerPopupView.s.setAlpha(f5);
                    View view2 = imageViewerPopupView.A;
                    if (view2 != null) {
                        view2.setAlpha(f5);
                    }
                    if (imageViewerPopupView.f1068y) {
                        imageViewerPopupView.f1064t.setAlpha(f5);
                    }
                    imageViewerPopupView.q.setBackgroundColor(((Integer) imageViewerPopupView.f1066v.evaluate(abs * 0.8f, Integer.valueOf(imageViewerPopupView.B), 0)).intValue());
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view, float f4, float f5) {
                super.onViewReleased(view, f4, f5);
                if (Math.abs(view.getTop()) > PhotoViewContainer.this.HideTopThreshold) {
                    if (PhotoViewContainer.this.dragChangeListener != null) {
                        ((ImageViewerPopupView) PhotoViewContainer.this.dragChangeListener).b();
                        return;
                    }
                    return;
                }
                PhotoViewContainer.this.dragHelper.smoothSlideViewTo(PhotoViewContainer.this.viewPager, 0, 0);
                PhotoViewContainer.this.dragHelper.smoothSlideViewTo(view, 0, 0);
                ViewCompat.postInvalidateOnAnimation(PhotoViewContainer.this);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view, int i5) {
                return !PhotoViewContainer.this.isReleasing;
            }
        };
        init();
    }
}
