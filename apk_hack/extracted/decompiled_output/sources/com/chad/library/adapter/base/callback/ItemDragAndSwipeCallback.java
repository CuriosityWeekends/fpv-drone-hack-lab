package com.chad.library.adapter.base.callback;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import e0.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class ItemDragAndSwipeCallback extends ItemTouchHelper.Callback {
    public static boolean a(RecyclerView.ViewHolder viewHolder) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType != 273 && itemViewType != 546 && itemViewType != 819 && itemViewType != 1365) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (a(viewHolder)) {
            return;
        }
        View view = viewHolder.itemView;
        int i3 = a.BaseQuickAdapter_dragging_support;
        if (view.getTag(i3) != null && ((Boolean) viewHolder.itemView.getTag(i3)).booleanValue()) {
            throw null;
        }
        View view2 = viewHolder.itemView;
        int i5 = a.BaseQuickAdapter_swiping_support;
        if (view2.getTag(i5) != null && ((Boolean) viewHolder.itemView.getTag(i5)).booleanValue()) {
            throw null;
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
        return 0.0f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (a(viewHolder)) {
            return ItemTouchHelper.Callback.makeMovementFlags(0, 0);
        }
        return ItemTouchHelper.Callback.makeMovementFlags(0, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return 0.0f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isItemViewSwipeEnabled() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f4, float f5, int i3, boolean z3) {
        super.onChildDrawOver(canvas, recyclerView, viewHolder, f4, f5, i3, z3);
        if (i3 == 1 && !a(viewHolder)) {
            View view = viewHolder.itemView;
            canvas.save();
            if (f4 > 0.0f) {
                canvas.clipRect(view.getLeft(), view.getTop(), view.getLeft() + f4, view.getBottom());
                canvas.translate(view.getLeft(), view.getTop());
            } else {
                canvas.clipRect(view.getRight() + f4, view.getTop(), view.getRight(), view.getBottom());
                canvas.translate(view.getRight() + f4, view.getTop());
            }
            throw null;
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        if (viewHolder.getItemViewType() == viewHolder2.getItemViewType()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i3, RecyclerView.ViewHolder viewHolder2, int i5, int i6, int i7) {
        super.onMoved(recyclerView, viewHolder, i3, viewHolder2, i5, i6, i7);
        throw null;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i3) {
        if (i3 == 2 && !a(viewHolder)) {
            throw null;
        }
        if (i3 == 1 && !a(viewHolder)) {
            throw null;
        }
        super.onSelectedChanged(viewHolder, i3);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSwiped(RecyclerView.ViewHolder viewHolder, int i3) {
        if (a(viewHolder)) {
            return;
        }
        throw null;
    }
}
