package com.tencent.bugly.proguard;

import android.os.FileObserver;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n0 extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1511a = 0;
    public final /* synthetic */ ay b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(ay ayVar) {
        super("/data/anr/", 8);
        this.b = ayVar;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i3, String str) {
        ay ayVar = this.b;
        switch (this.f1511a) {
            case 0:
                if (str != null) {
                    String concat = "/data/anr/".concat(str);
                    al.d("watching file %s", concat);
                    if (!concat.contains("trace")) {
                        al.d("not anr file %s", concat);
                        return;
                    } else {
                        ayVar.d.a(new c0(2, this, concat));
                        return;
                    }
                }
                return;
            default:
                if (str != null) {
                    al.d("observe file, dir:%s fileName:%s", ayVar.f1368e, str);
                    if (str.startsWith("manual_bugly_trace_") && str.endsWith(".txt")) {
                        if (!ayVar.f1367a.get()) {
                            al.c("proc is not in anr, just ignore", new Object[0]);
                            return;
                        } else if (ayVar.c.a()) {
                            al.c("Found foreground anr, resend sigquit immediately.", new Object[0]);
                            NativeCrashHandler.getInstance().resendSigquit();
                            long a5 = am.a(str, "manual_bugly_trace_", ".txt");
                            ayVar.a(a5, ayVar.f1368e + "/" + str);
                            al.c("Finish handling one anr.", new Object[0]);
                            return;
                        } else {
                            al.c("Found background anr, resend sigquit later.", new Object[0]);
                            long a6 = am.a(str, "manual_bugly_trace_", ".txt");
                            ayVar.a(a6, ayVar.f1368e + "/" + str);
                            al.c("Finish handling one anr, now resend sigquit.", new Object[0]);
                            NativeCrashHandler.getInstance().resendSigquit();
                            return;
                        }
                    }
                    al.c("not manual trace file, ignore.", new Object[0]);
                    return;
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(ay ayVar, String str) {
        super(str, 8);
        this.b = ayVar;
    }
}
