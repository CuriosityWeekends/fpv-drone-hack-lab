package com.lxj.xpopup.core;

import a1.m;
import android.content.Context;
import android.graphics.PointF;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.lxj.xpopup.util.b;
import com.lxj.xpopup.widget.BubbleLayout;
import z2.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BubbleHorizontalAttachPopupView extends BubbleAttachPopupView {

    /* renamed from: z  reason: collision with root package name */
    public static final /* synthetic */ int f1053z = 0;

    /* renamed from: x  reason: collision with root package name */
    public float f1054x;

    /* renamed from: y  reason: collision with root package name */
    public float f1055y;

    public BubbleHorizontalAttachPopupView(@NonNull Context context) {
        super(context);
        this.f1054x = 0.0f;
        this.f1055y = 0.0f;
    }

    @Override // com.lxj.xpopup.core.BubbleAttachPopupView, com.lxj.xpopup.core.BasePopupView
    public final void j() {
        this.q.setLook(BubbleLayout.Look.LEFT);
        super.j();
        this.f1034a.getClass();
        this.f1034a.getClass();
        this.f1048p = b.d(getContext(), 2.0f);
    }

    @Override // com.lxj.xpopup.core.BubbleAttachPopupView
    public final void p() {
        boolean z3;
        float g5;
        boolean m5 = b.m(getContext());
        m mVar = this.f1034a;
        int i3 = this.w;
        ((PointF) mVar.b).getClass();
        int i5 = e.f4295a;
        ((PointF) mVar.b).x -= getActivityContentLeft();
        if (((PointF) this.f1034a.b).x > b.g(getContext()) / 2.0f) {
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
                g5 = b.g(getContext()) - ((PointF) this.f1034a.b).x;
            }
        } else if (this.s) {
            g5 = ((PointF) this.f1034a.b).x;
        } else {
            g5 = b.g(getContext()) - ((PointF) this.f1034a.b).x;
        }
        int i6 = (int) (g5 - i3);
        if (getPopupContentView().getMeasuredWidth() > i6) {
            layoutParams.width = Math.max(i6, getPopupWidth());
        }
        getPopupContentView().setLayoutParams(layoutParams);
        getPopupContentView().post(new b3.b(this, m5, 1));
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
