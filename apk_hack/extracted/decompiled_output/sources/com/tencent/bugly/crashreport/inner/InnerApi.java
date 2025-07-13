package com.tencent.bugly.crashreport.inner;

import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.au;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class InnerApi {
    public static void postCocos2dxCrashAsync(int i3, String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            if (i3 != 5 && i3 != 6) {
                al.e("post cocos2d-x fail category illeagle: %d", Integer.valueOf(i3));
                return;
            }
            al.a("post cocos2d-x crash %s %s", str, str2);
            au.a(Thread.currentThread(), i3, str, str2, str3, null);
            return;
        }
        al.e("post cocos2d-x fail args null", new Object[0]);
    }

    public static void postH5CrashAsync(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (str != null && str2 != null && str3 != null) {
            al.a("post h5 crash %s %s", str, str2);
            au.a(thread, 8, str, str2, str3, map);
            return;
        }
        al.e("post h5 fail args null", new Object[0]);
    }

    public static void postU3dCrashAsync(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            al.e("post u3d fail args null", new Object[0]);
        }
        al.a("post u3d crash %s %s", str, str2);
        au.a(Thread.currentThread(), 4, str, str2, str3, null);
    }
}
