package com.google.gson;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h extends s {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f505a;
    public final /* synthetic */ s b;

    public /* synthetic */ h(s sVar, int i3) {
        this.f505a = i3;
        this.b = sVar;
    }

    @Override // com.google.gson.s
    public final Object a(p2.a aVar) {
        switch (this.f505a) {
            case 0:
                return new AtomicLong(((Number) this.b.a(aVar)).longValue());
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.h()) {
                    arrayList.add(Long.valueOf(((Number) this.b.a(aVar)).longValue()));
                }
                aVar.e();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i3 = 0; i3 < size; i3++) {
                    atomicLongArray.set(i3, ((Long) arrayList.get(i3)).longValue());
                }
                return atomicLongArray;
            default:
                if (aVar.u() == 9) {
                    aVar.q();
                    return null;
                }
                return this.b.a(aVar);
        }
    }
}
