package com.lxj.easyadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bumptech.glide.e;
import com.lxj.easyadapter.MultiItemTypeAdapter;
import com.lxj.easyadapter.ViewHolder;
import j4.b;
import java.util.List;
import o1.q;
import y2.a;
import y2.d;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MultiItemTypeAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public final List f1025a;
    public final SparseArray b;
    public final SparseArray c;
    public final q d;

    /* renamed from: e  reason: collision with root package name */
    public e f1026e;

    /* JADX WARN: Type inference failed for: r2v3, types: [o1.q, java.lang.Object] */
    public MultiItemTypeAdapter(List list) {
        b.c(list, "data");
        this.f1025a = list;
        this.b = new SparseArray();
        this.c = new SparseArray();
        ?? obj = new Object();
        obj.f3044a = new SparseArray();
        this.d = obj;
    }

    public final void a(ViewHolder viewHolder, Object obj, List list) {
        b.c(viewHolder, "holder");
        int adapterPosition = viewHolder.getAdapterPosition() - this.b.size();
        q qVar = this.d;
        qVar.getClass();
        SparseArray sparseArray = qVar.f3044a;
        if (sparseArray.size() > 0) {
            a aVar = (a) sparseArray.valueAt(0);
            aVar.getClass();
            EasyAdapter easyAdapter = aVar.f4258a;
            if (list != null && !list.isEmpty()) {
                easyAdapter.getClass();
                easyAdapter.c(viewHolder, obj, adapterPosition);
                return;
            }
            easyAdapter.c(viewHolder, obj, adapterPosition);
        }
    }

    public final boolean b(int i3) {
        SparseArray sparseArray = this.b;
        if (i3 >= ((getItemCount() - sparseArray.size()) - this.c.size()) + sparseArray.size()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.c.size() + this.b.size() + this.f1025a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i3) {
        boolean z3;
        SparseArray sparseArray = this.b;
        if (i3 < sparseArray.size()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return sparseArray.keyAt(i3);
        }
        if (b(i3)) {
            SparseArray sparseArray2 = this.c;
            return sparseArray2.keyAt((i3 - sparseArray.size()) - ((getItemCount() - sparseArray.size()) - sparseArray2.size()));
        }
        q qVar = this.d;
        if (qVar.f3044a.size() > 0) {
            this.f1025a.get(i3 - sparseArray.size());
            sparseArray.size();
            SparseArray sparseArray3 = qVar.f3044a;
            int size = sparseArray3.size() - 1;
            if (size < 0) {
                return 0;
            }
            ((a) sparseArray3.valueAt(size)).getClass();
            return sparseArray3.keyAt(size);
        }
        return super.getItemViewType(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        b.c(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        final d dVar = new d(this);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            final GridLayoutManager gridLayoutManager2 = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.lxj.easyadapter.WrapperUtils$onAttachedToRecyclerView$1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public final int getSpanSize(int i3) {
                    int spanSize;
                    GridLayoutManager.SpanSizeLookup spanSizeLookup2 = spanSizeLookup;
                    b.b(spanSizeLookup2, "spanSizeLookup");
                    Integer valueOf = Integer.valueOf(i3);
                    d dVar2 = d.this;
                    dVar2.getClass();
                    GridLayoutManager gridLayoutManager3 = (GridLayoutManager) gridLayoutManager2;
                    int intValue = valueOf.intValue();
                    b.c(gridLayoutManager3, "layoutManager");
                    MultiItemTypeAdapter multiItemTypeAdapter = dVar2.f4261a;
                    int itemViewType = multiItemTypeAdapter.getItemViewType(intValue);
                    if (multiItemTypeAdapter.b.get(itemViewType) != null) {
                        spanSize = gridLayoutManager3.getSpanCount();
                    } else if (multiItemTypeAdapter.c.get(itemViewType) != null) {
                        spanSize = gridLayoutManager3.getSpanCount();
                    } else {
                        spanSize = spanSizeLookup2.getSpanSize(intValue);
                    }
                    return Integer.valueOf(spanSize).intValue();
                }
            });
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(ViewHolder viewHolder, int i3) {
        ViewHolder viewHolder2 = viewHolder;
        b.c(viewHolder2, "holder");
        SparseArray sparseArray = this.b;
        if (i3 >= sparseArray.size() && !b(i3)) {
            a(viewHolder2, this.f1025a.get(i3 - sparseArray.size()), null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        b.c(viewGroup, "parent");
        SparseArray sparseArray = this.b;
        if (sparseArray.get(i3) != null) {
            int i5 = ViewHolder.c;
            Object obj = sparseArray.get(i3);
            b.a(obj);
            return new ViewHolder((View) obj);
        }
        SparseArray sparseArray2 = this.c;
        if (sparseArray2.get(i3) != null) {
            int i6 = ViewHolder.c;
            Object obj2 = sparseArray2.get(i3);
            b.a(obj2);
            return new ViewHolder((View) obj2);
        }
        Object obj3 = this.d.f3044a.get(i3);
        b.a(obj3);
        int i7 = ((a) obj3).f4258a.f1024f;
        int i8 = ViewHolder.c;
        Context context = viewGroup.getContext();
        b.b(context, "parent.context");
        View inflate = LayoutInflater.from(context).inflate(i7, viewGroup, false);
        b.b(inflate, "itemView");
        final ViewHolder viewHolder = new ViewHolder(inflate);
        View view = viewHolder.f1027a;
        b.c(view, "itemView");
        view.setOnClickListener(new View.OnClickListener() { // from class: y2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MultiItemTypeAdapter multiItemTypeAdapter = MultiItemTypeAdapter.this;
                j4.b.c(multiItemTypeAdapter, "this$0");
                ViewHolder viewHolder2 = viewHolder;
                j4.b.c(viewHolder2, "$viewHolder");
                if (multiItemTypeAdapter.f1026e != null) {
                    e eVar = multiItemTypeAdapter.f1026e;
                    j4.b.a(eVar);
                    j4.b.b(view2, "v");
                    eVar.e(viewHolder2.getAdapterPosition() - multiItemTypeAdapter.b.size());
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: y2.c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                MultiItemTypeAdapter multiItemTypeAdapter = MultiItemTypeAdapter.this;
                j4.b.c(multiItemTypeAdapter, "this$0");
                ViewHolder viewHolder2 = viewHolder;
                j4.b.c(viewHolder2, "$viewHolder");
                if (multiItemTypeAdapter.f1026e != null) {
                    viewHolder2.getAdapterPosition();
                    multiItemTypeAdapter.b.size();
                    j4.b.a(multiItemTypeAdapter.f1026e);
                    j4.b.b(view2, "v");
                    return false;
                }
                return false;
            }
        });
        return viewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams;
        ViewHolder viewHolder2 = viewHolder;
        b.c(viewHolder2, "holder");
        super.onViewAttachedToWindow(viewHolder2);
        int layoutPosition = viewHolder2.getLayoutPosition();
        if ((layoutPosition < this.b.size() || b(layoutPosition)) && (layoutParams = viewHolder2.itemView.getLayoutParams()) != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(ViewHolder viewHolder, int i3, List list) {
        ViewHolder viewHolder2 = viewHolder;
        b.c(viewHolder2, "holder");
        b.c(list, "payloads");
        SparseArray sparseArray = this.b;
        if (i3 >= sparseArray.size() && !b(i3)) {
            a(viewHolder2, this.f1025a.get(i3 - sparseArray.size()), list);
        }
    }
}
