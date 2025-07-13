package com.chad.library.adapter.base;

import a1.g;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import b3.k;
import com.chad.library.adapter.base.BaseViewHolder;
import f0.b;
import f0.c;
import h0.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import t2.p0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class BaseQuickAdapter<T, K extends BaseViewHolder> extends RecyclerView.Adapter<K> {

    /* renamed from: a  reason: collision with root package name */
    public final a f295a;
    public p0 b;
    public g c;
    public g d;

    /* renamed from: e  reason: collision with root package name */
    public Context f296e;

    /* renamed from: f  reason: collision with root package name */
    public final int f297f;

    /* renamed from: g  reason: collision with root package name */
    public LayoutInflater f298g;

    /* renamed from: h  reason: collision with root package name */
    public final List f299h;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, h0.a] */
    public BaseQuickAdapter(ArrayList arrayList, int i3) {
        ?? obj = new Object();
        obj.f1984a = 1;
        this.f295a = obj;
        new LinearInterpolator();
        this.f299h = arrayList == null ? new ArrayList() : arrayList;
        if (i3 != 0) {
            this.f297f = i3;
        }
    }

    public abstract void a(BaseViewHolder baseViewHolder, Object obj);

    public final BaseViewHolder b(View view) {
        BaseViewHolder baseViewHolder;
        BaseViewHolder baseViewHolder2;
        Type[] actualTypeArguments;
        BaseViewHolder baseViewHolder3 = null;
        Class cls = null;
        for (Class<?> cls2 = getClass(); cls == null && cls2 != null; cls2 = cls2.getSuperclass()) {
            Type genericSuperclass = cls2.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                for (Type type : ((ParameterizedType) genericSuperclass).getActualTypeArguments()) {
                    if (type instanceof Class) {
                        Class cls3 = (Class) type;
                        if (BaseViewHolder.class.isAssignableFrom(cls3)) {
                            cls = cls3;
                            break;
                        }
                    }
                }
            }
            cls = null;
        }
        if (cls == null) {
            baseViewHolder = new BaseViewHolder(view);
        } else {
            try {
                if (cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
                    Constructor<T> declaredConstructor = cls.getDeclaredConstructor(getClass(), View.class);
                    declaredConstructor.setAccessible(true);
                    baseViewHolder2 = (BaseViewHolder) declaredConstructor.newInstance(this, view);
                } else {
                    Constructor<T> declaredConstructor2 = cls.getDeclaredConstructor(View.class);
                    declaredConstructor2.setAccessible(true);
                    baseViewHolder2 = (BaseViewHolder) declaredConstructor2.newInstance(view);
                }
                baseViewHolder3 = baseViewHolder2;
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
            } catch (InstantiationException e6) {
                e6.printStackTrace();
            } catch (NoSuchMethodException e7) {
                e7.printStackTrace();
            } catch (InvocationTargetException e8) {
                e8.printStackTrace();
            }
            baseViewHolder = baseViewHolder3;
        }
        if (baseViewHolder == null) {
            return new BaseViewHolder(view);
        }
        return baseViewHolder;
    }

    public int c(int i3) {
        return super.getItemViewType(i3);
    }

    public boolean d(int i3) {
        return i3 == 1365 || i3 == 273 || i3 == 819 || i3 == 546;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: e */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i3) {
        int itemViewType = baseViewHolder.getItemViewType();
        Object obj = null;
        if (itemViewType != 0) {
            if (itemViewType != 273) {
                if (itemViewType != 546) {
                    if (itemViewType != 819 && itemViewType != 1365) {
                        List list = this.f299h;
                        if (i3 < list.size()) {
                            obj = list.get(i3);
                        }
                        a(baseViewHolder, obj);
                        return;
                    }
                    return;
                }
                int i5 = this.f295a.f1984a;
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            if (i5 == 4) {
                                baseViewHolder.c(e0.a.load_more_loading_view, false);
                                baseViewHolder.c(e0.a.load_more_load_fail_view, false);
                                int i6 = e0.a.load_more_load_end_view;
                                if (i6 != 0) {
                                    baseViewHolder.c(i6, true);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        baseViewHolder.c(e0.a.load_more_loading_view, false);
                        baseViewHolder.c(e0.a.load_more_load_fail_view, true);
                        int i7 = e0.a.load_more_load_end_view;
                        if (i7 != 0) {
                            baseViewHolder.c(i7, false);
                            return;
                        }
                        return;
                    }
                    baseViewHolder.c(e0.a.load_more_loading_view, true);
                    baseViewHolder.c(e0.a.load_more_load_fail_view, false);
                    int i8 = e0.a.load_more_load_end_view;
                    if (i8 != 0) {
                        baseViewHolder.c(i8, false);
                        return;
                    }
                    return;
                }
                baseViewHolder.c(e0.a.load_more_loading_view, false);
                baseViewHolder.c(e0.a.load_more_load_fail_view, false);
                int i9 = e0.a.load_more_load_end_view;
                if (i9 != 0) {
                    baseViewHolder.c(i9, false);
                    return;
                }
                return;
            }
            return;
        }
        List list2 = this.f299h;
        if (i3 < list2.size()) {
            obj = list2.get(i3);
        }
        a(baseViewHolder, obj);
    }

    public BaseViewHolder f(ViewGroup viewGroup, int i3) {
        return b(this.f298g.inflate(this.f297f, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f299h.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i3) {
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i3) {
        if (i3 < 0) {
            return 273;
        }
        int size = this.f299h.size();
        if (i3 < size) {
            return c(i3);
        }
        if (i3 - size < 0) {
            return 819;
        }
        return 546;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new f0.a(this, gridLayoutManager));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        BaseViewHolder b;
        View view;
        Context context = viewGroup.getContext();
        this.f296e = context;
        this.f298g = LayoutInflater.from(context);
        if (i3 != 273) {
            if (i3 != 546) {
                if (i3 != 819) {
                    if (i3 != 1365) {
                        b = f(viewGroup, i3);
                        if (b != null && (view = b.itemView) != null) {
                            if (this.b != null) {
                                view.setOnClickListener(new b(this, b));
                            }
                            if (this.c != null) {
                                view.setOnLongClickListener(new c(this, b));
                            }
                        }
                    } else {
                        b = b(null);
                    }
                } else {
                    b = b(null);
                }
            } else {
                this.f295a.getClass();
                b = b(this.f298g.inflate(e0.b.quick_view_load_more, viewGroup, false));
                b.itemView.setOnClickListener(new k(4, this));
            }
        } else {
            b = b(null);
        }
        b.f301e = this;
        return b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        BaseViewHolder baseViewHolder = (BaseViewHolder) viewHolder;
        super.onViewAttachedToWindow(baseViewHolder);
        int itemViewType = baseViewHolder.getItemViewType();
        if ((itemViewType == 1365 || itemViewType == 273 || itemViewType == 819 || itemViewType == 546) && (baseViewHolder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) baseViewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }
}
