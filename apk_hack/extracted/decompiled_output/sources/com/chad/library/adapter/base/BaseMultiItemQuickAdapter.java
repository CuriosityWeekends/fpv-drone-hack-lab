package com.chad.library.adapter.base;

import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class BaseMultiItemQuickAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final int c(int i3) {
        this.f299h.get(i3);
        return -255;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final BaseViewHolder f(ViewGroup viewGroup, int i3) {
        throw null;
    }
}
