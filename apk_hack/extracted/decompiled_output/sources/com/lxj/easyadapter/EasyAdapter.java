package com.lxj.easyadapter;

import android.util.SparseArray;
import j4.b;
import java.util.List;
import o1.q;
import y2.a;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class EasyAdapter<T> extends MultiItemTypeAdapter<T> {

    /* renamed from: f  reason: collision with root package name */
    public final int f1024f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EasyAdapter(List list, int i3) {
        super(list);
        b.c(list, "data");
        this.f1024f = i3;
        a aVar = new a(this);
        q qVar = this.d;
        qVar.getClass();
        SparseArray sparseArray = qVar.f3044a;
        sparseArray.put(sparseArray.size(), aVar);
    }

    public abstract void c(ViewHolder viewHolder, Object obj, int i3);
}
