package com.tencent.bugly.proguard;

import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Thread f1507a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f1508e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Map f1509f;

    public m0(Thread thread, int i3, String str, String str2, String str3, Map map) {
        this.f1507a = thread;
        this.b = i3;
        this.c = str;
        this.d = str2;
        this.f1508e = str3;
        this.f1509f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        au auVar;
        au auVar2;
        try {
            auVar = au.f1353a;
            if (auVar != null) {
                auVar2 = au.f1353a;
                au.a(auVar2, this.f1507a, this.b, this.c, this.d, this.f1508e, this.f1509f);
                return;
            }
            al.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
        } catch (Throwable th) {
            if (!al.b(th)) {
                th.printStackTrace();
            }
            al.e("[ExtraCrashManager] Crash error %s %s %s", this.c, this.d, this.f1508e);
        }
    }
}
