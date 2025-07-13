package com.lxj.easyadapter;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int c = 0;

    /* renamed from: a  reason: collision with root package name */
    public final View f1027a;
    public final SparseArray b;

    public ViewHolder(View view) {
        super(view);
        this.f1027a = view;
        this.b = new SparseArray();
    }

    public final View a(int i3) {
        SparseArray sparseArray = this.b;
        View view = (View) sparseArray.get(i3);
        if (view == null) {
            view = this.f1027a.findViewById(i3);
            sparseArray.put(i3, view);
        }
        if (view != null) {
            return view;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of com.lxj.easyadapter.ViewHolder.getView");
    }

    public final View b(int i3) {
        SparseArray sparseArray = this.b;
        View view = (View) sparseArray.get(i3);
        if (view == null) {
            view = this.f1027a.findViewById(i3);
            sparseArray.put(i3, view);
        }
        if (!(view instanceof View)) {
            return null;
        }
        return view;
    }
}
