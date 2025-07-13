package com.lxj.xpopup.core;

import a1.m;
import a3.b;
import a3.g;
import android.content.Context;
import android.graphics.PointF;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import b3.p;
import z2.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class HorizontalAttachPopupView extends AttachPopupView {

    /* renamed from: z  reason: collision with root package name */
    public static final /* synthetic */ int f1059z = 0;

    /* renamed from: x  reason: collision with root package name */
    public float f1060x;

    /* renamed from: y  reason: collision with root package name */
    public float f1061y;

    public HorizontalAttachPopupView(@NonNull Context context) {
        super(context);
        this.f1060x = 0.0f;
        this.f1061y = 0.0f;
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    public b getPopupAnimator() {
        if (r()) {
            return new g(getPopupContentView(), getAnimationDuration(), 18);
        }
        return new g(getPopupContentView(), getAnimationDuration(), 14);
    }

    @Override // com.lxj.xpopup.core.AttachPopupView, com.lxj.xpopup.core.BasePopupView
    public final void j() {
        super.j();
        this.f1034a.getClass();
        this.f1034a.getClass();
        this.f1029p = com.lxj.xpopup.util.b.d(getContext(), 2.0f);
    }

    @Override // com.lxj.xpopup.core.AttachPopupView
    public final void p() {
        boolean z3;
        float g5;
        if (this.f1034a == null) {
            return;
        }
        boolean m5 = com.lxj.xpopup.util.b.m(getContext());
        int measuredWidth = getPopupContentView().getMeasuredWidth();
        int measuredHeight = getPopupContentView().getMeasuredHeight();
        m mVar = this.f1034a;
        int i3 = this.w;
        ((PointF) mVar.b).getClass();
        int i5 = e.f4295a;
        ((PointF) mVar.b).x -= getActivityContentLeft();
        if (((PointF) this.f1034a.b).x > com.lxj.xpopup.util.b.g(getContext()) / 2.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.s = z3;
        ViewGroup.LayoutParams layoutParams = getPopupContentView().getLayoutParams();
        if (m5) {
            if (this.s) {
                g5 = ((PointF) this.f1034a.b).x;
            } else {
                g5 = com.lxj.xpopup.util.b.g(getContext()) - ((PointF) this.f1034a.b).x;
            }
        } else if (this.s) {
            g5 = ((PointF) this.f1034a.b).x;
        } else {
            g5 = com.lxj.xpopup.util.b.g(getContext()) - ((PointF) this.f1034a.b).x;
        }
        int i6 = (int) (g5 - i3);
        if (getPopupContentView().getMeasuredWidth() > i6) {
            layoutParams.width = Math.max(i6, getPopupWidth());
        }
        getPopupContentView().setLayoutParams(layoutParams);
        getPopupContentView().post(new p(this, m5, measuredWidth, measuredHeight));
    }

    public final boolean r() {
        if (!this.s) {
            this.f1034a.getClass();
            return false;
        }
        this.f1034a.getClass();
        return true;
    }
}
