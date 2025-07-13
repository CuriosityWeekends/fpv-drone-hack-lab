package com.tencent.bugly.proguard;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class s0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final long f1531a;
    public final /* synthetic */ r b;

    public s0(r rVar, long j2) {
        this.b = rVar;
        this.f1531a = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r rVar = this.b;
        rVar.b();
        rVar.a(this.f1531a);
    }
}
