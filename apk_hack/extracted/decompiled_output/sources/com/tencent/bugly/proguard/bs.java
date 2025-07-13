package com.tencent.bugly.proguard;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class bs extends m implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public String f1453a = "";
    public String b = "";

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i3) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f1453a, 0);
        lVar.a(this.b, 1);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f1453a = kVar.b(0, true);
        this.b = kVar.b(1, true);
    }
}
