package g0;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b3.d;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import java.util.HashSet;
import java.util.LinkedHashSet;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements GestureDetector.OnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f1900a;
    public final /* synthetic */ SimpleClickListener b;

    public a(SimpleClickListener simpleClickListener, RecyclerView recyclerView) {
        this.b = simpleClickListener;
        this.f1900a = recyclerView;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        SimpleClickListener simpleClickListener = this.b;
        simpleClickListener.d = true;
        simpleClickListener.f304f = this.f1900a.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        View view;
        RecyclerView recyclerView = this.f1900a;
        if (recyclerView.getScrollState() != 0) {
            return;
        }
        SimpleClickListener simpleClickListener = this.b;
        if (simpleClickListener.d && (view = simpleClickListener.f304f) != null) {
            view.performHapticFeedback(0);
            BaseViewHolder baseViewHolder = (BaseViewHolder) recyclerView.getChildViewHolder(simpleClickListener.f304f);
            if (!SimpleClickListener.a(simpleClickListener, baseViewHolder.getLayoutPosition())) {
                LinkedHashSet<Integer> linkedHashSet = baseViewHolder.d;
                HashSet hashSet = baseViewHolder.b;
                if (linkedHashSet != null && linkedHashSet.size() > 0) {
                    for (Integer num : linkedHashSet) {
                        View findViewById = simpleClickListener.f304f.findViewById(num.intValue());
                        if (SimpleClickListener.c(findViewById, motionEvent) && findViewById.isEnabled()) {
                            if (hashSet == null || !hashSet.contains(num)) {
                                SimpleClickListener.b(simpleClickListener, motionEvent, findViewById);
                                BaseQuickAdapter baseQuickAdapter = simpleClickListener.c;
                                int layoutPosition = baseViewHolder.getLayoutPosition();
                                simpleClickListener.c.getClass();
                                simpleClickListener.e(baseQuickAdapter, findViewById, layoutPosition);
                                findViewById.setPressed(true);
                                simpleClickListener.f303e = true;
                                return;
                            }
                            return;
                        }
                    }
                }
                BaseQuickAdapter baseQuickAdapter2 = simpleClickListener.c;
                View view2 = simpleClickListener.f304f;
                int layoutPosition2 = baseViewHolder.getLayoutPosition();
                simpleClickListener.c.getClass();
                simpleClickListener.g(baseQuickAdapter2, view2, layoutPosition2);
                SimpleClickListener.b(simpleClickListener, motionEvent, simpleClickListener.f304f);
                simpleClickListener.f304f.setPressed(true);
                if (linkedHashSet != null) {
                    for (Integer num2 : linkedHashSet) {
                        View findViewById2 = simpleClickListener.f304f.findViewById(num2.intValue());
                        if (findViewById2 != null) {
                            findViewById2.setPressed(false);
                        }
                    }
                }
                simpleClickListener.f303e = true;
            }
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
        SimpleClickListener simpleClickListener = this.b;
        if (simpleClickListener.d && simpleClickListener.f304f != null) {
            simpleClickListener.f303e = true;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        SimpleClickListener simpleClickListener = this.b;
        if (simpleClickListener.d && simpleClickListener.f304f != null) {
            RecyclerView recyclerView = this.f1900a;
            if (recyclerView.getScrollState() != 0) {
                return false;
            }
            View view = simpleClickListener.f304f;
            BaseViewHolder baseViewHolder = (BaseViewHolder) recyclerView.getChildViewHolder(view);
            if (SimpleClickListener.a(simpleClickListener, baseViewHolder.getLayoutPosition())) {
                return false;
            }
            LinkedHashSet<Integer> linkedHashSet = baseViewHolder.c;
            HashSet hashSet = baseViewHolder.b;
            if (linkedHashSet != null && linkedHashSet.size() > 0) {
                for (Integer num : linkedHashSet) {
                    View findViewById = view.findViewById(num.intValue());
                    if (findViewById != null) {
                        if (SimpleClickListener.c(findViewById, motionEvent) && findViewById.isEnabled()) {
                            if (hashSet != null && hashSet.contains(num)) {
                                return false;
                            }
                            SimpleClickListener.b(simpleClickListener, motionEvent, findViewById);
                            findViewById.setPressed(true);
                            BaseQuickAdapter baseQuickAdapter = simpleClickListener.c;
                            int layoutPosition = baseViewHolder.getLayoutPosition();
                            simpleClickListener.c.getClass();
                            simpleClickListener.d(baseQuickAdapter, findViewById, layoutPosition);
                            findViewById.postDelayed(new d(7, findViewById), 50L);
                            simpleClickListener.d = false;
                            simpleClickListener.f304f = null;
                            return true;
                        }
                        findViewById.setPressed(false);
                    }
                }
                SimpleClickListener.b(simpleClickListener, motionEvent, view);
                simpleClickListener.f304f.setPressed(true);
                for (Integer num2 : linkedHashSet) {
                    View findViewById2 = view.findViewById(num2.intValue());
                    if (findViewById2 != null) {
                        findViewById2.setPressed(false);
                    }
                }
                BaseQuickAdapter baseQuickAdapter2 = simpleClickListener.c;
                int layoutPosition2 = baseViewHolder.getLayoutPosition();
                simpleClickListener.c.getClass();
                simpleClickListener.f(baseQuickAdapter2, view, layoutPosition2);
            } else {
                SimpleClickListener.b(simpleClickListener, motionEvent, view);
                simpleClickListener.f304f.setPressed(true);
                if (linkedHashSet != null && linkedHashSet.size() > 0) {
                    for (Integer num3 : linkedHashSet) {
                        View findViewById3 = view.findViewById(num3.intValue());
                        if (findViewById3 != null) {
                            findViewById3.setPressed(false);
                        }
                    }
                }
                BaseQuickAdapter baseQuickAdapter3 = simpleClickListener.c;
                int layoutPosition3 = baseViewHolder.getLayoutPosition();
                simpleClickListener.c.getClass();
                simpleClickListener.f(baseQuickAdapter3, view, layoutPosition3);
            }
            if (view != null) {
                view.postDelayed(new d(7, view), 50L);
            }
            simpleClickListener.d = false;
            simpleClickListener.f304f = null;
        }
        return true;
    }
}
