package com.tencent.bugly.proguard;

import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1504a;

    public /* synthetic */ k0(int i3) {
        this.f1504a = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1504a) {
            case 0:
                NativeCrashHandler.getInstance().unBlockSigquit(true);
                return;
            case 1:
                NativeCrashHandler.getInstance().unBlockSigquit(false);
                return;
            default:
                return;
        }
    }

    public String toString() {
        switch (this.f1504a) {
            case 2:
                return "EmptyRunnable";
            default:
                return super.toString();
        }
    }

    private final void a() {
    }
}
