package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class az {
    public static ActivityManager.ProcessErrorStateInfo a(ActivityManager activityManager, long j2) {
        if (activityManager == null) {
            al.c("get anr state, ActivityManager is null", new Object[0]);
            return null;
        }
        al.c("get anr state, timeout:%d", Long.valueOf(j2));
        long j5 = j2 / 500;
        int i3 = 0;
        while (true) {
            ActivityManager.ProcessErrorStateInfo a5 = a(activityManager.getProcessesInErrorState());
            if (a5 == null) {
                al.c("found proc state is null", new Object[0]);
            } else {
                int i5 = a5.condition;
                if (i5 == 2) {
                    al.c("found proc state is anr! proc:%s", a5.processName);
                    return a5;
                } else if (i5 == 1) {
                    al.c("found proc state is crashed!", new Object[0]);
                    return null;
                }
            }
            int i6 = i3 + 1;
            if (i3 < j5) {
                al.c("try the %s times:", Integer.valueOf(i6));
                ap.b(500L);
                i3 = i6;
            } else {
                return a("Find process anr, but unable to get anr message.");
            }
        }
    }

    private static ActivityManager.ProcessErrorStateInfo a(List<ActivityManager.ProcessErrorStateInfo> list) {
        if (list != null && !list.isEmpty()) {
            int myPid = Process.myPid();
            for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : list) {
                if (processErrorStateInfo.pid == myPid) {
                    if (TextUtils.isEmpty(processErrorStateInfo.longMsg)) {
                        return null;
                    }
                    al.c("found current proc in the error state", new Object[0]);
                    return processErrorStateInfo;
                }
            }
            al.c("current proc not in the error state", new Object[0]);
            return null;
        }
        al.c("error state info list is null", new Object[0]);
        return null;
    }

    private static ActivityManager.ProcessErrorStateInfo a(String str) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = new ActivityManager.ProcessErrorStateInfo();
        processErrorStateInfo.pid = Process.myPid();
        processErrorStateInfo.processName = z.a(Process.myPid());
        processErrorStateInfo.shortMsg = str;
        return processErrorStateInfo;
    }
}
