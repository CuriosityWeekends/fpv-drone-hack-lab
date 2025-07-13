package com.tencent.bugly.proguard;

import android.util.Log;
import java.util.Locale;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class al {

    /* renamed from: a  reason: collision with root package name */
    public static String f1296a = "CrashReportInfo";
    public static String b = "CrashReport";
    public static boolean c = false;

    private static boolean a(int i3, String str, Object... objArr) {
        if (c) {
            if (str == null) {
                str = "null";
            } else if (objArr != null && objArr.length != 0) {
                str = String.format(Locale.US, str, objArr);
            }
            if (i3 == 0) {
                Log.i(b, str);
                return true;
            } else if (i3 == 1) {
                Log.d(b, str);
                return true;
            } else if (i3 == 2) {
                Log.w(b, str);
                return true;
            } else if (i3 == 3) {
                Log.e(b, str);
                return true;
            } else if (i3 != 5) {
                return false;
            } else {
                Log.i(f1296a, str);
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str, Object... objArr) {
        return a(5, str, objArr);
    }

    public static boolean c(String str, Object... objArr) {
        return a(1, str, objArr);
    }

    public static boolean d(String str, Object... objArr) {
        return a(2, str, objArr);
    }

    public static boolean e(String str, Object... objArr) {
        return a(3, str, objArr);
    }

    public static boolean b(Throwable th) {
        return a(3, th);
    }

    private static boolean a(int i3, Throwable th) {
        if (c) {
            return a(i3, ap.a(th), new Object[0]);
        }
        return false;
    }

    public static boolean a(String str, Object... objArr) {
        return a(0, str, objArr);
    }

    public static boolean a(Class cls, String str, Object... objArr) {
        Locale locale = Locale.US;
        String simpleName = cls.getSimpleName();
        return a(0, "[" + simpleName + "] " + str, objArr);
    }

    public static boolean a(Throwable th) {
        return a(2, th);
    }
}
