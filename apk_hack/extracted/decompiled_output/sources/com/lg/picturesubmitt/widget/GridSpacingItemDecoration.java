package com.lg.picturesubmitt.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    public int f910a;
    public int b;
    public boolean c;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i3 = this.f910a;
        int i5 = childAdapterPosition % i3;
        boolean z3 = this.c;
        int i6 = this.b;
        if (z3) {
            rect.left = i6 - ((i5 * i6) / i3);
            rect.right = ((i5 + 1) * i6) / i3;
            if (childAdapterPosition < i3) {
                rect.top = i6;
            }
            rect.bottom = i6;
            return;
        }
        rect.left = (i5 * i6) / i3;
        rect.right = i6 - (((i5 + 1) * i6) / i3);
        if (childAdapterPosition >= i3) {
            rect.top = i6;
        }
    }
}
