package com.tencent.bugly.proguard;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class q0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1517a;
    public final /* synthetic */ r b;

    public /* synthetic */ q0(r rVar, int i3) {
        this.f1517a = i3;
        this.b = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1517a) {
            case 0:
                try {
                    this.b.a(false);
                    return;
                } catch (Throwable th) {
                    al.a(th);
                    return;
                }
            default:
                long currentTimeMillis = System.currentTimeMillis();
                r rVar = this.b;
                if (currentTimeMillis < rVar.b) {
                    ak.a().a(new q0(rVar, 1), (rVar.b - currentTimeMillis) + 5000);
                    return;
                }
                rVar.a(3, false);
                rVar.a();
                return;
        }
    }
}
