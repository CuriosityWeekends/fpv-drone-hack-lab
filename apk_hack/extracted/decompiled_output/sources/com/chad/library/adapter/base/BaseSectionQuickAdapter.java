package com.chad.library.adapter.base;

import android.view.ViewGroup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bumptech.glide.i;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class BaseSectionQuickAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final int c(int i3) {
        i.a(this.f299h.get(i3));
        throw null;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final boolean d(int i3) {
        if (!super.d(i3) && i3 != 1092) {
            return false;
        }
        return true;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public final void onBindViewHolder(BaseViewHolder baseViewHolder, int i3) {
        Object obj;
        if (baseViewHolder.getItemViewType() != 1092) {
            super.onBindViewHolder(baseViewHolder, i3);
            return;
        }
        if (baseViewHolder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) baseViewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
        List list = this.f299h;
        if (i3 < list.size()) {
            obj = list.get(i3);
        } else {
            obj = null;
        }
        i.a(obj);
        g();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final BaseViewHolder f(ViewGroup viewGroup, int i3) {
        if (i3 == 1092) {
            return b(this.f298g.inflate(0, viewGroup, false));
        }
        return b(this.f298g.inflate(this.f297f, viewGroup, false));
    }

    public abstract void g();
}
