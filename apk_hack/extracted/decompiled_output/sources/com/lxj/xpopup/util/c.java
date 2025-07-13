package com.lxj.xpopup.util;

import android.view.ViewTreeObserver;
import android.view.Window;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.impl.PartShadowPopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Window f1114a;
    public final /* synthetic */ int[] b;
    public final /* synthetic */ b3.e c;

    public c(Window window, int[] iArr, b3.e eVar) {
        this.f1114a = window;
        this.b = iArr;
        this.c = eVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int a5 = d.a(this.f1114a);
        int[] iArr = this.b;
        if (iArr[0] != a5) {
            b3.e eVar = this.c;
            BasePopupView basePopupView = (BasePopupView) eVar.b;
            basePopupView.getClass();
            if (a5 == 0) {
                basePopupView.post(new b3.d(0, eVar));
                basePopupView.f1037g = false;
            } else if (!(basePopupView instanceof PartShadowPopupView) || basePopupView.f1035e != 2) {
                b.f1113x = a5;
                basePopupView.post(new b3.c(basePopupView, 3));
                basePopupView.f1037g = true;
            }
            iArr[0] = a5;
        }
    }
}
