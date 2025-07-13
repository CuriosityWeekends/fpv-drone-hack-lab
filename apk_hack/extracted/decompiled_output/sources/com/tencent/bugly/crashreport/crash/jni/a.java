package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import b2.c;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.be;
import java.io.File;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NativeCrashHandler f1235a;

    public a(NativeCrashHandler nativeCrashHandler) {
        this.f1235a = nativeCrashHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        boolean z3;
        Context context2;
        String str;
        NativeExceptionHandler nativeExceptionHandler;
        Context context3;
        as asVar;
        String str2;
        as asVar2;
        NativeCrashHandler nativeCrashHandler = this.f1235a;
        context = nativeCrashHandler.d;
        if (ap.a(context, "native_record_lock")) {
            z3 = NativeCrashHandler.f1225n;
            if (!z3) {
                nativeCrashHandler.a(999, "false");
            }
            context2 = nativeCrashHandler.d;
            str = NativeCrashHandler.f1224a;
            nativeExceptionHandler = nativeCrashHandler.f1228g;
            CrashDetailBean a5 = be.a(context2, str, nativeExceptionHandler);
            if (a5 != null) {
                al.a("[Native] Get crash from native record.", new Object[0]);
                asVar = nativeCrashHandler.f1234m;
                if (!asVar.a(a5, true)) {
                    asVar2 = nativeCrashHandler.f1234m;
                    asVar2.b(a5, false);
                }
                str2 = NativeCrashHandler.f1224a;
                be.a(false, str2);
            }
            long b = ap.b() - at.f1334j;
            long b5 = ap.b() + 86400000;
            File file = new File(NativeCrashHandler.f1224a);
            if (file.exists() && file.isDirectory()) {
                try {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new c(1));
                        long j2 = 0;
                        int i3 = 0;
                        int i5 = 0;
                        for (File file2 : listFiles) {
                            long lastModified = file2.lastModified();
                            j2 += file2.length();
                            if (lastModified >= b && lastModified < b5 && j2 < at.f1333i) {
                            }
                            al.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i3++;
                            if (file2.delete()) {
                                i5++;
                            }
                        }
                        al.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i3), Integer.valueOf(i5));
                    }
                } catch (Throwable th) {
                    al.a(th);
                }
            }
            context3 = nativeCrashHandler.d;
            ap.b(context3, "native_record_lock");
            return;
        }
        al.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
    }
}
