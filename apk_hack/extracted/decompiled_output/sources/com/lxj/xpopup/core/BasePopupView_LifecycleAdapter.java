package com.lxj.xpopup.core;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BasePopupView_LifecycleAdapter implements GeneratedAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final BasePopupView f1046a;

    public BasePopupView_LifecycleAdapter(BasePopupView basePopupView) {
        this.f1046a = basePopupView;
    }

    @Override // androidx.lifecycle.GeneratedAdapter
    public final void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z3, MethodCallsLogger methodCallsLogger) {
        boolean z5;
        if (methodCallsLogger != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z3 && event == Lifecycle.Event.ON_DESTROY) {
            if (!z5 || methodCallsLogger.approveCall("onDestroy", 1)) {
                this.f1046a.onDestroy();
            }
        }
    }
}
