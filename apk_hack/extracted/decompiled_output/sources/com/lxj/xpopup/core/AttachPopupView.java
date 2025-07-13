package com.lxj.xpopup.core;

import a1.m;
import a3.g;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import b3.a;
import com.lxj.xpopup.util.b;
import z2.c;
import z2.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class AttachPopupView extends BasePopupView {

    /* renamed from: p  reason: collision with root package name */
    public int f1029p;
    public final FrameLayout q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f1030r;
    public boolean s;

    /* renamed from: t  reason: collision with root package name */
    public float f1031t;

    /* renamed from: u  reason: collision with root package name */
    public float f1032u;

    /* renamed from: v  reason: collision with root package name */
    public float f1033v;
    public final int w;

    public AttachPopupView(@NonNull Context context) {
        super(context);
        this.f1029p = 0;
        this.f1031t = 0.0f;
        this.f1032u = 0.0f;
        this.f1033v = b.f(getContext());
        this.w = b.d(getContext(), 10.0f);
        this.q = (FrameLayout) findViewById(z2.b.attachPopupContainer);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void f() {
        super.f();
        b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new a(this, 1));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final int getInnerLayoutId() {
        return c._xpopup_attach_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public a3.b getPopupAnimator() {
        g gVar;
        int i3;
        int i5;
        if (q()) {
            View popupContentView = getPopupContentView();
            int animationDuration = getAnimationDuration();
            if (this.s) {
                i5 = 21;
            } else {
                i5 = 19;
            }
            gVar = new g(popupContentView, animationDuration, i5);
        } else {
            View popupContentView2 = getPopupContentView();
            int animationDuration2 = getAnimationDuration();
            if (this.s) {
                i3 = 15;
            } else {
                i3 = 17;
            }
            gVar = new g(popupContentView2, animationDuration2, i3);
        }
        return gVar;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void j() {
        Drawable.ConstantState constantState;
        FrameLayout frameLayout = this.q;
        if (frameLayout.getChildCount() == 0) {
            frameLayout.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) frameLayout, false));
        }
        m mVar = this.f1034a;
        mVar.getClass();
        if (((PointF) mVar.b) != null) {
            this.f1034a.getClass();
            this.f1029p = 0;
            this.f1034a.getClass();
            float f4 = 0;
            frameLayout.setTranslationX(f4);
            this.f1034a.getClass();
            frameLayout.setTranslationY(f4);
            if (!this.f1036f) {
                if (getPopupImplView().getBackground() != null && (constantState = getPopupImplView().getBackground().getConstantState()) != null) {
                    frameLayout.setBackground(constantState.newDrawable(getResources()));
                    getPopupImplView().setBackground(null);
                }
                frameLayout.setElevation(b.d(getContext(), 10.0f));
            }
            b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new a(this, 0));
            return;
        }
        throw new IllegalArgumentException("atView() or watchView() must be called for AttachPopupView before show()！");
    }

    public void p() {
        float k5;
        float f4;
        boolean z3;
        if (this.f1034a == null) {
            return;
        }
        int navBarHeight = getNavBarHeight();
        int f5 = b.f(getContext());
        int i3 = this.w;
        this.f1033v = (f5 - i3) - navBarHeight;
        boolean m5 = b.m(getContext());
        m mVar = this.f1034a;
        ((PointF) mVar.b).getClass();
        int i5 = e.f4295a;
        ((PointF) mVar.b).x -= getActivityContentLeft();
        boolean z5 = true;
        if (((PointF) this.f1034a.b).y + getPopupContentView().getMeasuredHeight() > this.f1033v) {
            if (((PointF) this.f1034a.b).y > b.k(getContext()) / 2.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f1030r = z3;
        } else {
            this.f1030r = false;
        }
        if (((PointF) this.f1034a.b).x >= b.g(getContext()) / 2.0f) {
            z5 = false;
        }
        this.s = z5;
        ViewGroup.LayoutParams layoutParams = getPopupContentView().getLayoutParams();
        if (q()) {
            k5 = (((PointF) this.f1034a.b).y - getStatusBarHeight()) - i3;
        } else {
            k5 = ((b.k(getContext()) - ((PointF) this.f1034a.b).y) - i3) - navBarHeight;
        }
        int i6 = (int) k5;
        if (this.s) {
            f4 = b.g(getContext()) - ((PointF) this.f1034a.b).x;
        } else {
            f4 = ((PointF) this.f1034a.b).x;
        }
        int i7 = (int) (f4 - i3);
        if (getPopupContentView().getMeasuredHeight() > i6) {
            layoutParams.height = i6;
        }
        if (getPopupContentView().getMeasuredWidth() > i7) {
            layoutParams.width = Math.max(i7, getPopupWidth());
        }
        getPopupContentView().setLayoutParams(layoutParams);
        getPopupContentView().post(new b3.b(this, m5, 0));
    }

    public final boolean q() {
        this.f1034a.getClass();
        if (!this.f1030r) {
            this.f1034a.getClass();
            return false;
        }
        this.f1034a.getClass();
        return true;
    }
}
