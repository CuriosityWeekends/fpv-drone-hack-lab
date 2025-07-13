package com.chad.library.adapter.base;

import com.chad.library.adapter.base.BaseViewHolder;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class BaseItemDraggableAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public final void onBindViewHolder(BaseViewHolder baseViewHolder, int i3) {
        super.onBindViewHolder(baseViewHolder, i3);
        baseViewHolder.getItemViewType();
    }
}
