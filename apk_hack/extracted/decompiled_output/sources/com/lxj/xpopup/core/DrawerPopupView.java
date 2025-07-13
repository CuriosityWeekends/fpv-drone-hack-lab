package com.lxj.xpopup.core;

import a1.m;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import b3.h;
import b3.k;
import b3.n;
import com.lxj.xpopup.widget.PopupDrawerLayout;
import z2.b;
import z2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class DrawerPopupView extends BasePopupView {

    /* renamed from: p  reason: collision with root package name */
    public final PopupDrawerLayout f1058p;
    public final FrameLayout q;

    public DrawerPopupView(@NonNull Context context) {
        super(context);
        new Paint();
        new ArgbEvaluator();
        this.f1058p = (PopupDrawerLayout) findViewById(b.drawerLayout);
        this.q = (FrameLayout) findViewById(b.drawerContentContainer);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void b() {
        if (this.f1034a == null || this.f1035e == 4) {
            return;
        }
        this.f1035e = 4;
        clearFocus();
        this.f1058p.close();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void c() {
        Handler handler = this.f1038h;
        h hVar = this.f1043m;
        handler.removeCallbacks(hVar);
        handler.postDelayed(hVar, 0L);
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
    public final void e() {
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void f() {
        super.f();
        View childAt = this.q.getChildAt(0);
        if (childAt == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        if (this.f1034a != null) {
            layoutParams.height = -1;
            if (getPopupWidth() > 0) {
                layoutParams.width = getPopupWidth();
            }
            if (getMaxWidth() > 0) {
                layoutParams.width = Math.min(layoutParams.width, getMaxWidth());
            }
            childAt.setLayoutParams(layoutParams);
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void g() {
        this.f1058p.open();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final int getInnerLayoutId() {
        return c._xpopup_drawer_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public a3.b getPopupAnimator() {
        return null;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public View getPopupImplView() {
        return this.q.getChildAt(0);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void j() {
        FrameLayout frameLayout = this.q;
        if (frameLayout.getChildCount() == 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) frameLayout, false);
            frameLayout.addView(inflate);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            if (this.f1034a != null) {
                layoutParams.height = -1;
                if (getPopupWidth() > 0) {
                    layoutParams.width = getPopupWidth();
                }
                if (getMaxWidth() > 0) {
                    layoutParams.width = Math.min(layoutParams.width, getMaxWidth());
                }
                inflate.setLayoutParams(layoutParams);
            }
        }
        this.f1034a.getClass();
        PopupDrawerLayout popupDrawerLayout = this.f1058p;
        popupDrawerLayout.isDismissOnTouchOutside = true;
        popupDrawerLayout.setOnCloseListener(new n(this));
        View popupImplView = getPopupImplView();
        this.f1034a.getClass();
        float f4 = 0;
        popupImplView.setTranslationX(f4);
        View popupImplView2 = getPopupImplView();
        this.f1034a.getClass();
        popupImplView2.setTranslationY(f4);
        this.f1034a.getClass();
        popupDrawerLayout.setDrawerPosition(c3.c.f229a);
        this.f1034a.getClass();
        popupDrawerLayout.enableDrag = true;
        popupDrawerLayout.getChildAt(0).setOnClickListener(new k(1, this));
    }
}
