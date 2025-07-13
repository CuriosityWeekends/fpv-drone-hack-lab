package com.tencent.bugly.proguard;

import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i0 implements ah {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f1500a;
    public final /* synthetic */ List b;
    public final /* synthetic */ boolean c;

    public i0(long j2, List list, boolean z3) {
        this.f1500a = j2;
        this.b = list;
        this.c = z3;
    }

    @Override // com.tencent.bugly.proguard.ah
    public final void a(boolean z3, String str) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis() - this.f1500a;
        if (this.c) {
            str2 = "realtime";
        } else {
            str2 = "cache";
        }
        as.a(this.b, z3, currentTimeMillis, str2, str);
        as.a(z3, this.b);
    }
}
