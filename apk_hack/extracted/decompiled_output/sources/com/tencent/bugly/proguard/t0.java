package com.tencent.bugly.proguard;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class t0 implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Class cls;
        Class cls2;
        String name = activity.getClass().getName();
        cls = s.f1529l;
        if (cls != null) {
            cls2 = s.f1529l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        al.c(">>> %s onCreated <<<", name);
        aa b = aa.b();
        if (b != null) {
            b.L.add(s.a(name, "onCreated"));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Class cls;
        Class cls2;
        String name = activity.getClass().getName();
        cls = s.f1529l;
        if (cls != null) {
            cls2 = s.f1529l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        al.c(">>> %s onDestroyed <<<", name);
        aa b = aa.b();
        if (b != null) {
            b.L.add(s.a(name, "onDestroyed"));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Class cls;
        Class cls2;
        String name = activity.getClass().getName();
        cls = s.f1529l;
        if (cls != null) {
            cls2 = s.f1529l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        al.c(">>> %s onPaused <<<", name);
        aa b = aa.b();
        if (b == null) {
            return;
        }
        b.L.add(s.a(name, "onPaused"));
        long currentTimeMillis = System.currentTimeMillis();
        b.A = currentTimeMillis;
        b.B = currentTimeMillis - b.f1255z;
        long unused = s.f1525h = currentTimeMillis;
        if (b.B < 0) {
            b.B = 0L;
        }
        b.f1254y = "background";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Class cls;
        long j2;
        long j5;
        long j6;
        long j7;
        int i3;
        int i5;
        long j8;
        long j9;
        boolean z3;
        long j10;
        boolean z5;
        Class cls2;
        String name = activity.getClass().getName();
        cls = s.f1529l;
        if (cls != null) {
            cls2 = s.f1529l;
            if (!cls2.getName().equals(name)) {
                return;
            }
        }
        al.c(">>> %s onResumed <<<", name);
        aa b = aa.b();
        if (b == null) {
            return;
        }
        b.L.add(s.a(name, "onResumed"));
        b.f1254y = name;
        long currentTimeMillis = System.currentTimeMillis();
        b.f1255z = currentTimeMillis;
        j2 = s.f1526i;
        b.C = currentTimeMillis - j2;
        long j11 = b.f1255z;
        j5 = s.f1525h;
        long j12 = j11 - j5;
        j6 = s.f1523f;
        if (j12 > (j6 > 0 ? s.f1523f : s.f1522e)) {
            b.c();
            s.g();
            Long valueOf = Long.valueOf(j12 / 1000);
            j7 = s.f1522e;
            al.a("[session] launch app one times (app in background %d seconds and over %d seconds)", valueOf, Long.valueOf(j7 / 1000));
            i3 = s.f1524g;
            i5 = s.c;
            if (i3 % i5 == 0) {
                r rVar = s.b;
                z5 = s.f1530m;
                rVar.a(4, z5);
                return;
            }
            s.b.a(4, false);
            long currentTimeMillis2 = System.currentTimeMillis();
            j8 = s.f1527j;
            j9 = s.d;
            if (currentTimeMillis2 - j8 > j9) {
                long unused = s.f1527j = currentTimeMillis2;
                al.a("add a timer to upload hot start user info", new Object[0]);
                z3 = s.f1530m;
                if (z3) {
                    r rVar2 = s.b;
                    j10 = s.d;
                    ak.a().a(new r0(0, rVar2, null, true), j10);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        al.c(">>> %s onStart <<<", activity.getClass().getName());
        aa.b().a(activity.hashCode(), true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        al.c(">>> %s onStop <<<", activity.getClass().getName());
        aa.b().a(activity.hashCode(), false);
    }
}
