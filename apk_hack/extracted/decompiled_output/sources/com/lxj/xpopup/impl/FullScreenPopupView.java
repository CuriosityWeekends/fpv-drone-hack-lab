package com.lxj.xpopup.impl;

import a1.m;
import a3.j;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.lxj.xpopup.core.BasePopupView;
import z2.b;
import z2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class FullScreenPopupView extends BasePopupView {

    /* renamed from: p  reason: collision with root package name */
    public final FrameLayout f1087p;
    public j q;

    public FullScreenPopupView(@NonNull Context context) {
        super(context);
        new ArgbEvaluator();
        new Paint();
        this.f1087p = (FrameLayout) findViewById(b.fullPopupContainer);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        m mVar = this.f1034a;
        if (mVar != null) {
            mVar.getClass();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getInnerLayoutId() {
        return c._xpopup_fullscreen_popup_view;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [a3.j, a3.b] */
    @Override // com.lxj.xpopup.core.BasePopupView
    public a3.b getPopupAnimator() {
        if (this.q == null) {
            this.q = new a3.b(getPopupContentView(), getAnimationDuration(), 13);
        }
        return this.q;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void j() {
        FrameLayout frameLayout = this.f1087p;
        if (frameLayout.getChildCount() == 0) {
            frameLayout.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) frameLayout, false));
        }
        View popupContentView = getPopupContentView();
        this.f1034a.getClass();
        float f4 = 0;
        popupContentView.setTranslationX(f4);
        View popupContentView2 = getPopupContentView();
        this.f1034a.getClass();
        popupContentView2.setTranslationY(f4);
    }

    @Override // com.lxj.xpopup.core.BasePopupView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (this.f1034a != null && this.q != null) {
            getPopupContentView().setTranslationX(this.q.f94f);
            getPopupContentView().setTranslationY(this.q.f95g);
            this.q.b = true;
        }
        super.onDetachedFromWindow();
    }
}
