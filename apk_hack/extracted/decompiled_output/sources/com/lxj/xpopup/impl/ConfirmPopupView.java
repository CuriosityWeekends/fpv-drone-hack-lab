package com.lxj.xpopup.impl;

import a1.m;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.lxj.xpopup.core.CenterPopupView;
import e3.b;
import z2.a;
import z2.c;
import z2.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ConfirmPopupView extends CenterPopupView implements View.OnClickListener {
    public CharSequence A;
    public CharSequence B;
    public EditText C;
    public View D;
    public View E;
    public boolean F;
    public b s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f1081t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f1082u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f1083v;
    public TextView w;

    /* renamed from: x  reason: collision with root package name */
    public CharSequence f1084x;

    /* renamed from: y  reason: collision with root package name */
    public CharSequence f1085y;

    /* renamed from: z  reason: collision with root package name */
    public CharSequence f1086z;

    public TextView getCancelTextView() {
        return (TextView) findViewById(z2.b.tv_cancel);
    }

    public TextView getConfirmTextView() {
        return (TextView) findViewById(z2.b.tv_confirm);
    }

    public TextView getContentTextView() {
        return (TextView) findViewById(z2.b.tv_content);
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        int i3 = this.q;
        if (i3 == 0) {
            return c._xpopup_center_impl_confirm;
        }
        return i3;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getMaxHeight() {
        m mVar = this.f1034a;
        if (mVar == null) {
            return 0;
        }
        mVar.getClass();
        return (int) (com.lxj.xpopup.util.b.f(getContext()) * 0.8d);
    }

    public TextView getTitleTextView() {
        return (TextView) findViewById(z2.b.tv_title);
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public void k() {
        this.f1081t = (TextView) findViewById(z2.b.tv_title);
        this.f1082u = (TextView) findViewById(z2.b.tv_content);
        this.f1083v = (TextView) findViewById(z2.b.tv_cancel);
        this.w = (TextView) findViewById(z2.b.tv_confirm);
        this.f1082u.setMovementMethod(LinkMovementMethod.getInstance());
        this.C = (EditText) findViewById(z2.b.et_input);
        this.D = findViewById(z2.b.xpopup_divider1);
        this.E = findViewById(z2.b.xpopup_divider2);
        this.f1083v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        if (!TextUtils.isEmpty(this.f1084x)) {
            this.f1081t.setText(this.f1084x);
        } else {
            com.lxj.xpopup.util.b.o(this.f1081t, false);
        }
        if (!TextUtils.isEmpty(this.f1085y)) {
            this.f1082u.setText(this.f1085y);
        } else {
            com.lxj.xpopup.util.b.o(this.f1082u, false);
        }
        if (!TextUtils.isEmpty(this.A)) {
            this.f1083v.setText(this.A);
        }
        if (!TextUtils.isEmpty(this.B)) {
            this.w.setText(this.B);
        }
        if (this.F) {
            com.lxj.xpopup.util.b.o(this.f1083v, false);
            com.lxj.xpopup.util.b.o(this.E, false);
        }
        if (this.q == 0) {
            this.f1034a.getClass();
            q();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f1083v) {
            b();
        } else if (view == this.w) {
            b bVar = this.s;
            if (bVar != null) {
                bVar.b();
            }
            this.f1034a.getClass();
            b();
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView
    public void q() {
        super.q();
        TextView textView = this.f1081t;
        Resources resources = getResources();
        int i3 = a._xpopup_content_color;
        textView.setTextColor(resources.getColor(i3));
        this.f1082u.setTextColor(getResources().getColor(i3));
        this.f1083v.setTextColor(Color.parseColor("#666666"));
        this.w.setTextColor(e.f4295a);
        View view = this.D;
        if (view != null) {
            view.setBackgroundColor(getResources().getColor(a._xpopup_list_divider));
        }
        View view2 = this.E;
        if (view2 != null) {
            view2.setBackgroundColor(getResources().getColor(a._xpopup_list_divider));
        }
    }
}
