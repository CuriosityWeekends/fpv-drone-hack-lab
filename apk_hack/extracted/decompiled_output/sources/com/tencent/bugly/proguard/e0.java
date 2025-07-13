package com.tencent.bugly.proguard;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e0 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1485a;

    public /* synthetic */ e0(int i3) {
        this.f1485a = i3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger;
        switch (this.f1485a) {
            case 0:
                Thread thread = new Thread(runnable);
                StringBuilder sb = new StringBuilder("BuglyThread-");
                atomicInteger = ak.f1295a;
                sb.append(atomicInteger.getAndIncrement());
                thread.setName(sb.toString());
                return thread;
            default:
                return new Thread(new b3.d(8, runnable), "glide-active-resources");
        }
    }
}
