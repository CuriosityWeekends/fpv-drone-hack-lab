package com.lxj.xpopup.impl;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import b3.d;
import com.lxj.xpopup.core.CenterPopupView;
import z2.b;
import z2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class LoadingPopupView extends CenterPopupView {
    public TextView s;

    /* renamed from: t  reason: collision with root package name */
    public View f1088t;

    /* renamed from: u  reason: collision with root package name */
    public View f1089u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f1090v;

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        int i3 = this.q;
        if (i3 == 0) {
            return c._xpopup_center_impl_loading;
        }
        return i3;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void k() {
        this.s = (TextView) findViewById(b.tv_title);
        this.f1088t = findViewById(b.loadProgress);
        this.f1089u = findViewById(b.loadview);
        getPopupImplView().setElevation(10.0f);
        if (this.q == 0) {
            View popupImplView = getPopupImplView();
            int parseColor = Color.parseColor("#212121");
            this.f1034a.getClass();
            popupImplView.setBackground(com.lxj.xpopup.util.b.c(parseColor));
        }
        post(new d(5, this));
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void l() {
        this.f1090v = true;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void m() {
        this.f1090v = false;
    }
}
