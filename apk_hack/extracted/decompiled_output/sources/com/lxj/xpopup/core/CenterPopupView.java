package com.lxj.xpopup.core;

import a1.m;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import z2.a;
import z2.b;
import z2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class CenterPopupView extends BasePopupView {

    /* renamed from: p  reason: collision with root package name */
    public final FrameLayout f1056p;
    public int q;

    /* renamed from: r  reason: collision with root package name */
    public View f1057r;

    public CenterPopupView(@NonNull Context context) {
        super(context);
        this.f1056p = (FrameLayout) findViewById(b.centerPopupContainer);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void f() {
        super.f();
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), null);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final int getInnerLayoutId() {
        return c._xpopup_center_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getMaxWidth() {
        m mVar = this.f1034a;
        if (mVar == null) {
            return 0;
        }
        mVar.getClass();
        return (int) (com.lxj.xpopup.util.b.g(getContext()) * 0.85f);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public a3.b getPopupAnimator() {
        return new a3.b(getPopupContentView(), getAnimationDuration(), 1);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void j() {
        if (this.f1056p.getChildCount() == 0) {
            p();
        }
        View popupContentView = getPopupContentView();
        this.f1034a.getClass();
        float f4 = 0;
        popupContentView.setTranslationX(f4);
        View popupContentView2 = getPopupContentView();
        this.f1034a.getClass();
        popupContentView2.setTranslationY(f4);
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), null);
    }

    public final void p() {
        LayoutInflater from = LayoutInflater.from(getContext());
        int implLayoutId = getImplLayoutId();
        ViewGroup viewGroup = this.f1056p;
        View inflate = from.inflate(implLayoutId, viewGroup, false);
        this.f1057r = inflate;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) inflate.getLayoutParams();
        layoutParams.gravity = 17;
        viewGroup.addView(this.f1057r, layoutParams);
    }

    public void q() {
        int color = getResources().getColor(a._xpopup_light_color);
        this.f1034a.getClass();
        this.f1056p.setBackground(com.lxj.xpopup.util.b.c(color));
    }
}
