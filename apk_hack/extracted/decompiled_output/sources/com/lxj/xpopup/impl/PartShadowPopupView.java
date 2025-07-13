package com.lxj.xpopup.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.widget.PartShadowContainer;
import d3.e;
import z2.b;
import z2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class PartShadowPopupView extends BasePopupView {

    /* renamed from: p  reason: collision with root package name */
    public final PartShadowContainer f1091p;

    public PartShadowPopupView(@NonNull Context context) {
        super(context);
        PartShadowContainer partShadowContainer = (PartShadowContainer) findViewById(b.attachPopupContainer);
        this.f1091p = partShadowContainer;
        partShadowContainer.popupView = this;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void f() {
        super.f();
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new e(this, 1));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final int getInnerLayoutId() {
        return c._xpopup_partshadow_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public a3.b getPopupAnimator() {
        return new a3.b(getPopupImplView(), getAnimationDuration(), 12);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void j() {
        PartShadowContainer partShadowContainer = this.f1091p;
        if (partShadowContainer.getChildCount() == 0) {
            partShadowContainer.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) partShadowContainer, false));
        }
        this.f1034a.getClass();
        this.c.c = getPopupContentView();
        View popupImplView = getPopupImplView();
        this.f1034a.getClass();
        float f4 = 0;
        popupImplView.setTranslationX(f4);
        View popupImplView2 = getPopupImplView();
        this.f1034a.getClass();
        popupImplView2.setTranslationY(f4);
        getPopupImplView().setAlpha(0.0f);
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new e(this, 0));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void l() {
    }

    public final void p() {
        this.f1034a.getClass();
        throw new IllegalArgumentException("atView() must be called before show()！");
    }
}
