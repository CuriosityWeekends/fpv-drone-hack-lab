package com.chad.library.adapter.base.listener;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import g0.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class SimpleClickListener implements RecyclerView.OnItemTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public GestureDetectorCompat f302a;
    public RecyclerView b;
    public BaseQuickAdapter c;
    public boolean d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f303e = false;

    /* renamed from: f  reason: collision with root package name */
    public View f304f = null;

    public static boolean a(SimpleClickListener simpleClickListener, int i3) {
        if (simpleClickListener.c == null) {
            RecyclerView recyclerView = simpleClickListener.b;
            if (recyclerView == null) {
                return false;
            }
            simpleClickListener.c = (BaseQuickAdapter) recyclerView.getAdapter();
        }
        int itemViewType = simpleClickListener.c.getItemViewType(i3);
        if (itemViewType != 1365 && itemViewType != 273 && itemViewType != 819 && itemViewType != 546) {
            return false;
        }
        return true;
    }

    public static void b(SimpleClickListener simpleClickListener, MotionEvent motionEvent, View view) {
        simpleClickListener.getClass();
        if (view != null && view.getBackground() != null) {
            view.getBackground().setHotspot(motionEvent.getRawX(), motionEvent.getY() - view.getY());
        }
    }

    public static boolean c(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        if (view != null && view.isShown()) {
            view.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i5 = iArr[1];
            if (motionEvent.getRawX() >= i3 && motionEvent.getRawX() <= view.getWidth() + i3 && motionEvent.getRawY() >= i5 && motionEvent.getRawY() <= view.getHeight() + i5) {
                return true;
            }
        }
        return false;
    }

    public abstract void d(BaseQuickAdapter baseQuickAdapter, View view, int i3);

    public abstract void e(BaseQuickAdapter baseQuickAdapter, View view, int i3);

    public abstract void f(BaseQuickAdapter baseQuickAdapter, View view, int i3);

    public abstract void g(BaseQuickAdapter baseQuickAdapter, View view, int i3);

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        BaseViewHolder baseViewHolder;
        int itemViewType;
        RecyclerView recyclerView2 = this.b;
        if (recyclerView2 == null) {
            this.b = recyclerView;
            this.c = (BaseQuickAdapter) recyclerView.getAdapter();
            this.f302a = new GestureDetectorCompat(this.b.getContext(), new a(this, this.b));
        } else if (recyclerView2 != recyclerView) {
            this.b = recyclerView;
            this.c = (BaseQuickAdapter) recyclerView.getAdapter();
            this.f302a = new GestureDetectorCompat(this.b.getContext(), new a(this, this.b));
        }
        if (!this.f302a.onTouchEvent(motionEvent) && motionEvent.getActionMasked() == 1 && this.f303e) {
            View view = this.f304f;
            if (view != null && ((baseViewHolder = (BaseViewHolder) this.b.getChildViewHolder(view)) == null || ((itemViewType = baseViewHolder.getItemViewType()) != 1365 && itemViewType != 273 && itemViewType != 819 && itemViewType != 546))) {
                this.f304f.setPressed(false);
            }
            this.f303e = false;
            this.d = false;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean z3) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f302a.onTouchEvent(motionEvent);
    }
}
