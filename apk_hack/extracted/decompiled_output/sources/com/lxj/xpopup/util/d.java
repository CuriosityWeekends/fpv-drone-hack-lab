package com.lxj.xpopup.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.lxj.xpopup.impl.ConfirmPopupView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseArray f1115a = new SparseArray();
    public static int b = 0;

    public static int a(Window window) {
        View decorView = window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        Log.d("KeyboardUtils", "getDecorViewInvisibleHeight: " + (decorView.getBottom() - rect.bottom));
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        int i3 = b.i(window);
        Resources system = Resources.getSystem();
        if (abs <= system.getDimensionPixelSize(system.getIdentifier("status_bar_height", "dimen", "android")) + i3) {
            b = abs;
            return 0;
        }
        return abs - b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.lxj.xpopup.util.KeyboardUtils$SoftInputReceiver, android.os.ResultReceiver] */
    public static void b(ConfirmPopupView confirmPopupView) {
        InputMethodManager inputMethodManager;
        if (confirmPopupView == null || (inputMethodManager = (InputMethodManager) confirmPopupView.getContext().getSystemService("input_method")) == 0) {
            return;
        }
        confirmPopupView.setFocusable(true);
        confirmPopupView.setFocusableInTouchMode(true);
        confirmPopupView.requestFocus();
        Context context = confirmPopupView.getContext();
        ?? resultReceiver = new ResultReceiver(new Handler());
        resultReceiver.f1093a = context;
        inputMethodManager.showSoftInput(confirmPopupView, 0, resultReceiver);
        inputMethodManager.toggleSoftInput(2, 1);
    }
}
