package com.lxj.xpopup.impl;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.lxj.xpopup.util.b;
import z2.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class InputConfirmPopupView extends ConfirmPopupView implements View.OnClickListener {
    public static final /* synthetic */ int G = 0;

    public EditText getEditText() {
        return this.C;
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView
    public final void k() {
        super.k();
        b.o(this.C, true);
        if (!TextUtils.isEmpty(this.f1086z)) {
            this.C.setHint(this.f1086z);
        }
        if (TextUtils.isEmpty(null)) {
            EditText editText = this.C;
            int i3 = e.f4295a;
            if (this.q == 0) {
                editText.post(new c2.b(3, this));
                return;
            }
            return;
        }
        this.C.setText((CharSequence) null);
        throw null;
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f1083v) {
            b();
        } else if (view == this.w) {
            this.f1034a.getClass();
            b();
        }
    }

    @Override // com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.CenterPopupView
    public final void q() {
        super.q();
        this.C.setHintTextColor(Color.parseColor("#888888"));
        this.C.setTextColor(Color.parseColor("#333333"));
    }
}
