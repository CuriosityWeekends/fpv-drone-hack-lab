package f0;

import androidx.recyclerview.widget.GridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GridLayoutManager f1798a;
    public final /* synthetic */ BaseQuickAdapter b;

    public a(BaseQuickAdapter baseQuickAdapter, GridLayoutManager gridLayoutManager) {
        this.b = baseQuickAdapter;
        this.f1798a = gridLayoutManager;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public final int getSpanSize(int i3) {
        BaseQuickAdapter baseQuickAdapter = this.b;
        if (baseQuickAdapter.d(baseQuickAdapter.getItemViewType(i3))) {
            return this.f1798a.getSpanCount();
        }
        return 1;
    }
}
