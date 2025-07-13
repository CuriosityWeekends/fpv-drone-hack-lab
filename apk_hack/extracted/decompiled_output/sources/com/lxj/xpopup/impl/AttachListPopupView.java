package com.lxj.xpopup.impl;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.widget.VerticalRecyclerView;
import d3.a;
import java.util.Arrays;
import z2.b;
import z2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class AttachListPopupView extends AttachPopupView {

    /* renamed from: y  reason: collision with root package name */
    public static final /* synthetic */ int f1072y = 0;

    /* renamed from: x  reason: collision with root package name */
    public RecyclerView f1073x;

    @Override // com.lxj.xpopup.core.BasePopupView
    public int getImplLayoutId() {
        return c._xpopup_attach_impl_list;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    public final void k() {
        this.f1073x = (RecyclerView) findViewById(b.recyclerView);
        a aVar = new a(this, Arrays.asList(null), c._xpopup_adapter_text, 0);
        aVar.f1026e = new d3.b(this, aVar);
        this.f1073x.setAdapter(aVar);
        this.f1034a.getClass();
        ((VerticalRecyclerView) this.f1073x).setupDivider(Boolean.FALSE);
        Resources resources = getResources();
        this.f1034a.getClass();
        int color = resources.getColor(z2.a._xpopup_light_color);
        this.f1034a.getClass();
        this.q.setBackground(com.lxj.xpopup.util.b.c(color));
    }
}
