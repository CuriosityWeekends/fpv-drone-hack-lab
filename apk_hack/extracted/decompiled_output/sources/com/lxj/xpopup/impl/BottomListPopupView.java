package com.lxj.xpopup.impl;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b3.k;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.widget.VerticalRecyclerView;
import d3.a;
import java.util.Arrays;
import z2.b;
import z2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BottomListPopupView extends BottomPopupView {
    public static final /* synthetic */ int w = 0;

    /* renamed from: r  reason: collision with root package name */
    public RecyclerView f1074r;
    public TextView s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f1075t;

    /* renamed from: u  reason: collision with root package name */
    public View f1076u;

    /* renamed from: v  reason: collision with root package name */
    public int f1077v;

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return c._xpopup_bottom_impl_list;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void k() {
        this.f1074r = (RecyclerView) findViewById(b.recyclerView);
        this.s = (TextView) findViewById(b.tv_title);
        this.f1075t = (TextView) findViewById(b.tv_cancel);
        this.f1076u = findViewById(b.vv_divider);
        TextView textView = this.f1075t;
        if (textView != null) {
            textView.setOnClickListener(new k(3, this));
        }
        if (this.s != null) {
            if (TextUtils.isEmpty(null)) {
                this.s.setVisibility(8);
                int i3 = b.xpopup_divider;
                if (findViewById(i3) != null) {
                    findViewById(i3).setVisibility(8);
                }
            } else {
                this.s.setText((CharSequence) null);
            }
        }
        a aVar = new a(this, Arrays.asList(null), c._xpopup_adapter_text_match, 1);
        aVar.f1026e = new d3.c(this, aVar);
        this.f1074r.setAdapter(aVar);
        this.f1034a.getClass();
        ((VerticalRecyclerView) this.f1074r).setupDivider(Boolean.FALSE);
        TextView textView2 = this.s;
        Resources resources = getResources();
        int i5 = z2.a._xpopup_dark_color;
        textView2.setTextColor(resources.getColor(i5));
        TextView textView3 = this.f1075t;
        if (textView3 != null) {
            textView3.setTextColor(getResources().getColor(i5));
        }
        findViewById(b.xpopup_divider).setBackgroundColor(getResources().getColor(z2.a._xpopup_list_divider));
        View view = this.f1076u;
        if (view != null) {
            view.setBackgroundColor(getResources().getColor(z2.a._xpopup_white_color));
        }
        View popupImplView = getPopupImplView();
        int color = getResources().getColor(z2.a._xpopup_light_color);
        this.f1034a.getClass();
        this.f1034a.getClass();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadii(new float[]{15.0f, 15.0f, 15.0f, 15.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        popupImplView.setBackground(gradientDrawable);
    }
}
