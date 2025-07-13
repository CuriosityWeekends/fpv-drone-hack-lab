package com.lxj.xpopup.util;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.SparseArray;
import android.view.inputmethod.InputMethodManager;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
class KeyboardUtils$SoftInputReceiver extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public Context f1093a;

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int i3, Bundle bundle) {
        InputMethodManager inputMethodManager;
        super.onReceiveResult(i3, bundle);
        if (i3 == 1 || i3 == 3) {
            Context context = this.f1093a;
            SparseArray sparseArray = d.f1115a;
            if (context != null && (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) != null) {
                inputMethodManager.toggleSoftInput(0, 0);
            }
        }
        this.f1093a = null;
    }
}
