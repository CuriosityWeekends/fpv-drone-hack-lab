package com.lxj.xpopup.core;

import a1.m;
import a3.j;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import b3.h;
import b3.k;
import com.lxj.xpopup.widget.SmartDragLayout;
import z2.b;
import z2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BottomPopupView extends BasePopupView {

    /* renamed from: p  reason: collision with root package name */
    public final SmartDragLayout f1047p;
    public j q;

    public BottomPopupView(@NonNull Context context) {
        super(context);
        this.f1047p = (SmartDragLayout) findViewById(b.bottomPopupContainer);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void b() {
        m mVar = this.f1034a;
        if (mVar == null || this.f1035e == 4) {
            return;
        }
        this.f1035e = 4;
        mVar.getClass();
        clearFocus();
        this.f1047p.close();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void c() {
        m mVar = this.f1034a;
        if (mVar == null) {
            return;
        }
        mVar.getClass();
        Handler handler = this.f1038h;
        h hVar = this.f1043m;
        handler.removeCallbacks(hVar);
        handler.postDelayed(hVar, 0L);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void e() {
        m mVar = this.f1034a;
        if (mVar == null) {
            return;
        }
        mVar.getClass();
        this.f1034a.getClass();
        this.f1047p.close();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void f() {
        super.f();
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), null);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void g() {
        m mVar = this.f1034a;
        if (mVar == null) {
            return;
        }
        mVar.getClass();
        this.f1034a.getClass();
        this.f1047p.open();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final int getInnerLayoutId() {
        return c._xpopup_bottom_popup_view;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [a3.j, a3.b] */
    @Override // com.lxj.xpopup.core.BasePopupView
    public a3.b getPopupAnimator() {
        if (this.f1034a == null) {
            return null;
        }
        if (this.q == null) {
            this.q = new a3.b(getPopupContentView(), getAnimationDuration(), 13);
        }
        this.f1034a.getClass();
        return null;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void j() {
        SmartDragLayout smartDragLayout = this.f1047p;
        if (smartDragLayout.getChildCount() == 0) {
            smartDragLayout.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) smartDragLayout, false));
        }
        smartDragLayout.setDuration(getAnimationDuration());
        this.f1034a.getClass();
        smartDragLayout.enableDrag(true);
        this.f1034a.getClass();
        this.f1034a.getClass();
        View popupImplView = getPopupImplView();
        this.f1034a.getClass();
        float f4 = 0;
        popupImplView.setTranslationX(f4);
        View popupImplView2 = getPopupImplView();
        this.f1034a.getClass();
        popupImplView2.setTranslationY(f4);
        this.f1034a.getClass();
        smartDragLayout.dismissOnTouchOutside(true);
        this.f1034a.getClass();
        smartDragLayout.isThreeDrag(false);
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), null);
        smartDragLayout.setOnCloseListener(new b3.j(this));
        smartDragLayout.setOnClickListener(new k(0, this));
    }

    @Override // com.lxj.xpopup.core.BasePopupView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        m mVar = this.f1034a;
        if (mVar != null) {
            mVar.getClass();
        }
        super.onDetachedFromWindow();
    }
}
