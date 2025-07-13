package com.chad.library.adapter.base;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b3.k;
import java.util.HashSet;
import java.util.LinkedHashSet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f300a;
    public final HashSet b;
    public final LinkedHashSet c;
    public final LinkedHashSet d;

    /* renamed from: e  reason: collision with root package name */
    public BaseQuickAdapter f301e;

    public BaseViewHolder(View view) {
        super(view);
        this.f300a = new SparseArray();
        this.c = new LinkedHashSet();
        this.d = new LinkedHashSet();
        this.b = new HashSet();
    }

    public final void a(int i3) {
        this.c.add(Integer.valueOf(i3));
        View b = b(i3);
        if (b != null) {
            if (!b.isClickable()) {
                b.setClickable(true);
            }
            b.setOnClickListener(new k(5, this));
        }
    }

    public final View b(int i3) {
        SparseArray sparseArray = this.f300a;
        View view = (View) sparseArray.get(i3);
        if (view == null) {
            View findViewById = this.itemView.findViewById(i3);
            sparseArray.put(i3, findViewById);
            return findViewById;
        }
        return view;
    }

    public final void c(int i3, boolean z3) {
        int i5;
        View b = b(i3);
        if (z3) {
            i5 = 0;
        } else {
            i5 = 4;
        }
        b.setVisibility(i5);
    }
}
