package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.collection.ArrayMap;
import i.s;
import java.util.List;
import java.util.Map;
import t2.b0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f extends ContextWrapper {

    /* renamed from: k  reason: collision with root package name */
    public static final a f242k;

    /* renamed from: a  reason: collision with root package name */
    public final j.g f243a;
    public final m b;
    public final b0 c;
    public final j3.b d;

    /* renamed from: e  reason: collision with root package name */
    public final List f244e;

    /* renamed from: f  reason: collision with root package name */
    public final Map f245f;

    /* renamed from: g  reason: collision with root package name */
    public final s f246g;

    /* renamed from: h  reason: collision with root package name */
    public final h f247h;

    /* renamed from: i  reason: collision with root package name */
    public final int f248i;

    /* renamed from: j  reason: collision with root package name */
    public y.e f249j;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bumptech.glide.a, java.lang.Object] */
    static {
        ?? obj = new Object();
        obj.f231a = a0.b.f0a;
        f242k = obj;
    }

    public f(Context context, j.g gVar, m mVar, b0 b0Var, j3.b bVar, ArrayMap arrayMap, List list, s sVar, h hVar) {
        super(context.getApplicationContext());
        this.f243a = gVar;
        this.b = mVar;
        this.c = b0Var;
        this.d = bVar;
        this.f244e = list;
        this.f245f = arrayMap;
        this.f246g = sVar;
        this.f247h = hVar;
        this.f248i = 4;
    }
}
