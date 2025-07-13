package com.chad.library.adapter.base.listener;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class OnItemChildLongClickListener extends SimpleClickListener {
    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public final void d(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public final void e(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        h();
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public final void f(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public final void g(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
    }

    public abstract void h();
}
