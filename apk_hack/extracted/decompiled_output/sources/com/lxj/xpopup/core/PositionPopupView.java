package com.lxj.xpopup.core;

import a1.m;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import b3.q;
import b3.r;
import c3.a;
import com.lxj.xpopup.widget.PositionPopupContainer;
import z2.b;
import z2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class PositionPopupView extends BasePopupView {

    /* renamed from: p  reason: collision with root package name */
    public final PositionPopupContainer f1071p;

    public PositionPopupView(@NonNull Context context) {
        super(context);
        PositionPopupContainer positionPopupContainer = (PositionPopupContainer) findViewById(b.positionPopupContainer);
        this.f1071p = positionPopupContainer;
        positionPopupContainer.addView(LayoutInflater.from(getContext()).inflate(getImplLayoutId(), (ViewGroup) positionPopupContainer, false));
    }

    public static void p(PositionPopupView positionPopupView) {
        m mVar = positionPopupView.f1034a;
        if (mVar != null) {
            mVar.getClass();
            float f4 = 0;
            PositionPopupContainer positionPopupContainer = positionPopupView.f1071p;
            positionPopupContainer.setTranslationX(f4);
            positionPopupView.f1034a.getClass();
            positionPopupContainer.setTranslationY(f4);
            positionPopupView.i();
            positionPopupView.g();
            positionPopupView.d();
        }
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void f() {
        super.f();
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new q(this, 1));
    }

    public a getDragOrientation() {
        return a.f225a;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final int getInnerLayoutId() {
        return c._xpopup_position_popup_view;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public a3.b getPopupAnimator() {
        return new a3.b(getPopupContentView(), getAnimationDuration(), 1);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void j() {
        setClipChildren(false);
        setClipToPadding(false);
        this.f1034a.getClass();
        PositionPopupContainer positionPopupContainer = this.f1071p;
        positionPopupContainer.enableDrag = true;
        positionPopupContainer.dragOrientation = getDragOrientation();
        com.lxj.xpopup.util.b.a((ViewGroup) getPopupContentView(), getMaxWidth(), getMaxHeight(), getPopupWidth(), getPopupHeight(), new q(this, 0));
        positionPopupContainer.setOnPositionDragChangeListener(new r(this));
    }
}
