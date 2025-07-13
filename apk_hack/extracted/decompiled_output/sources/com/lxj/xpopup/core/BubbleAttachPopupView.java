package com.lxj.xpopup.core;

import a1.m;
import android.content.Context;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import b3.l;
import com.lxj.xpopup.util.b;
import com.lxj.xpopup.widget.BubbleLayout;
import z2.c;
import z2.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class BubbleAttachPopupView extends BasePopupView {

    /* renamed from: p  reason: collision with root package name */
    public int f1048p;
    public final BubbleLayout q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f1049r;
    public boolean s;

    /* renamed from: t  reason: collision with root package name */
    public float f1050t;

    /* renamed from: u  reason: collision with root package name */
    public float f1051u;

    /* renamed from: v  reason: collision with root package name */
    public float f1052v;
    public final int w;

    public BubbleAttachPopupView(@NonNull Context context) {
        super(context);
        this.f1048p = 0;
        this.f1050t = 0.0f;
        this.f1051u = 0.0f;
        this.f1052v = b.f(getContext());
        this.w = b.d(getContext(), 10.0f);
        this.q = (BubbleLayout) findViewById(z2.b.bubbleContainer);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void f() {
        super.f();
        b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new l(this, 1));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final int getInnerLayoutId() {
        return c._xpopup_bubble_attach_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public a3.b getPopupAnimator() {
        return new a3.b(getPopupContentView(), getAnimationDuration(), 1);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void j() {
        BubbleLayout bubbleLayout = this.q;
        if (bubbleLayout.getChildCount() == 0) {
            bubbleLayout.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) bubbleLayout, false));
        }
        m mVar = this.f1034a;
        mVar.getClass();
        if (((PointF) mVar.b) != null) {
            bubbleLayout.setElevation(b.d(getContext(), 10.0f));
            bubbleLayout.setShadowRadius(b.d(getContext(), 0.0f));
            this.f1034a.getClass();
            this.f1034a.getClass();
            this.f1048p = 0;
            b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new l(this, 0));
            return;
        }
        throw new IllegalArgumentException("atView() or watchView() must be called for BubbleAttachPopupView before show()！");
    }

    public void p() {
        float k5;
        float f4;
        float g5;
        boolean z3;
        if (this.f1034a == null) {
            return;
        }
        int f5 = b.f(getContext());
        int i3 = this.w;
        this.f1052v = f5 - i3;
        boolean m5 = b.m(getContext());
        m mVar = this.f1034a;
        ((PointF) mVar.b).getClass();
        int i5 = e.f4295a;
        ((PointF) mVar.b).x -= getActivityContentLeft();
        boolean z5 = true;
        if (((PointF) this.f1034a.b).y + getPopupContentView().getMeasuredHeight() > this.f1052v) {
            if (((PointF) this.f1034a.b).y > b.k(getContext()) / 2.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f1049r = z3;
        } else {
            this.f1049r = false;
        }
        if (((PointF) this.f1034a.b).x <= b.g(getContext()) / 2.0f) {
            z5 = false;
        }
        this.s = z5;
        ViewGroup.LayoutParams layoutParams = getPopupContentView().getLayoutParams();
        if (q()) {
            k5 = ((PointF) this.f1034a.b).y;
            f4 = getStatusBarHeight();
        } else {
            k5 = b.k(getContext());
            f4 = ((PointF) this.f1034a.b).y;
        }
        int i6 = (int) ((k5 - f4) - i3);
        if (this.s) {
            g5 = ((PointF) this.f1034a.b).x;
        } else {
            g5 = b.g(getContext()) - ((PointF) this.f1034a.b).x;
        }
        int i7 = (int) (g5 - i3);
        if (getPopupContentView().getMeasuredHeight() > i6) {
            layoutParams.height = i6;
        }
        if (getPopupContentView().getMeasuredWidth() > i7) {
            layoutParams.width = i7;
        }
        getPopupContentView().setLayoutParams(layoutParams);
        getPopupContentView().post(new b3.m(this, m5));
    }

    public final boolean q() {
        this.f1034a.getClass();
        if (!this.f1049r) {
            this.f1034a.getClass();
            return false;
        }
        this.f1034a.getClass();
        return true;
    }
}
