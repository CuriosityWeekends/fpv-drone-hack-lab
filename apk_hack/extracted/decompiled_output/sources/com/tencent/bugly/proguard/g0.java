package com.tencent.bugly.proguard;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1498a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public /* synthetic */ g0(String str, String str2, String str3, int i3) {
        this.f1498a = i3;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1498a) {
            case 0:
                ao.b(this.b, this.c, this.d);
                return;
            default:
                ao.c(this.b, this.c, this.d);
                return;
        }
    }
}
