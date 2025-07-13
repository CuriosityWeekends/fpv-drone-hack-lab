package com.lxj.xpopup.impl;

import a1.m;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.widget.VerticalRecyclerView;
import d3.a;
import d3.d;
import java.util.Arrays;
import z2.b;
import z2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class CenterListPopupView extends CenterPopupView {

    /* renamed from: v  reason: collision with root package name */
    public static final /* synthetic */ int f1078v = 0;
    public RecyclerView s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f1079t;

    /* renamed from: u  reason: collision with root package name */
    public int f1080u;

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        int i3 = this.q;
        if (i3 == 0) {
            return c._xpopup_center_impl_list;
        }
        return i3;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    public int getMaxWidth() {
        m mVar = this.f1034a;
        if (mVar == null) {
            return 0;
        }
        mVar.getClass();
        return super.getMaxWidth();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void k() {
        RecyclerView recyclerView = (RecyclerView) findViewById(b.recyclerView);
        this.s = recyclerView;
        if (this.q != 0) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        TextView textView = (TextView) findViewById(b.tv_title);
        this.f1079t = textView;
        if (textView != null) {
            if (TextUtils.isEmpty(null)) {
                this.f1079t.setVisibility(8);
                int i3 = b.xpopup_divider;
                if (findViewById(i3) != null) {
                    findViewById(i3).setVisibility(8);
                }
            } else {
                this.f1079t.setText((CharSequence) null);
            }
        }
        a aVar = new a(this, Arrays.asList(null), c._xpopup_adapter_text_match, 2);
        aVar.f1026e = new d(this, aVar);
        this.s.setAdapter(aVar);
        if (this.q == 0) {
            this.f1034a.getClass();
            q();
        }
    }

    @Override // com.lxj.xpopup.core.CenterPopupView
    public final void q() {
        super.q();
        ((VerticalRecyclerView) this.s).setupDivider(Boolean.FALSE);
        this.f1079t.setTextColor(getResources().getColor(z2.a._xpopup_dark_color));
        findViewById(b.xpopup_divider).setBackgroundColor(getResources().getColor(z2.a._xpopup_list_divider));
    }
}
