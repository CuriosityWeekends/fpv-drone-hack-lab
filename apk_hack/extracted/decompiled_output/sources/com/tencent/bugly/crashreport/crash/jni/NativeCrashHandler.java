package com.tencent.bugly.crashreport.crash.jni;

import a1.i;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.as;
import com.tencent.bugly.proguard.at;
import com.tencent.bugly.proguard.bd;
import com.tencent.bugly.proguard.be;
import com.tencent.bugly.proguard.q;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class NativeCrashHandler implements q {

    /* renamed from: a  reason: collision with root package name */
    static String f1224a = null;
    private static NativeCrashHandler b = null;
    private static int c = 1;

    /* renamed from: n  reason: collision with root package name */
    private static boolean f1225n = true;
    private final Context d;

    /* renamed from: e  reason: collision with root package name */
    private final aa f1226e;

    /* renamed from: f  reason: collision with root package name */
    private final ak f1227f;

    /* renamed from: g  reason: collision with root package name */
    private NativeExceptionHandler f1228g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f1229h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1230i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1231j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1232k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1233l = false;

    /* renamed from: m  reason: collision with root package name */
    private as f1234m;

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, aa aaVar, as asVar, ak akVar, boolean z3, String str) {
        this.d = ap.a(context);
        if (ap.b(f1224a)) {
            try {
                if (ap.b(str)) {
                    str = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable unused) {
                str = i.i("/data/data/", aa.a(context).c, "/app_bugly");
            }
            f1224a = str;
        }
        this.f1234m = asVar;
        this.f1226e = aaVar;
        this.f1227f = akVar;
        this.f1229h = z3;
        this.f1228g = new bd(context, aaVar, asVar, ac.a());
    }

    public static synchronized String getDumpFilePath() {
        String str;
        synchronized (NativeCrashHandler.class) {
            str = f1224a;
        }
        return str;
    }

    public static synchronized NativeCrashHandler getInstance(Context context, aa aaVar, as asVar, ac acVar, ak akVar, boolean z3, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            try {
                if (b == null) {
                    b = new NativeCrashHandler(context, aaVar, asVar, akVar, z3, str);
                }
                nativeCrashHandler = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeCrashHandler;
    }

    private native String getProperties(String str);

    private native String getSoCpuAbi();

    public static boolean isShouldHandleInJava() {
        return f1225n;
    }

    public static synchronized void setDumpFilePath(String str) {
        synchronized (NativeCrashHandler.class) {
            f1224a = str;
        }
    }

    public static void setShouldHandleInJava(boolean z3) {
        f1225n = z3;
        NativeCrashHandler nativeCrashHandler = b;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, String.valueOf(z3));
        }
    }

    @Override // com.tencent.bugly.proguard.q
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f1230i || this.f1231j) && str != null && str2 != null && str3 != null) {
            try {
                if (this.f1231j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f1227f.a(new a(this));
    }

    public void disableCatchAnrTrace() {
        c = 1;
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        c |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    @Override // com.tencent.bugly.proguard.q
    public String getLogFromNative() {
        if (!this.f1230i && !this.f1231j) {
            return null;
        }
        try {
            if (this.f1231j) {
                return getNativeLog();
            }
            return (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f1228g;
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            al.d("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public String getSystemProperty(String str) {
        if (!this.f1231j && !this.f1230i) {
            return "fail";
        }
        return getProperties(str);
    }

    public boolean isEnableCatchAnrTrace() {
        if ((c & 2) == 2) {
            return true;
        }
        return false;
    }

    public synchronized boolean isUserOpened() {
        return this.f1233l;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        boolean z3;
        if (strategyBean != null) {
            try {
                boolean z5 = strategyBean.f1184f;
                if (z5 != this.f1232k) {
                    al.d("server native changed to %b", Boolean.valueOf(z5));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (ac.a().c().f1184f && this.f1233l) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 != this.f1232k) {
            al.a("native changed to %b", Boolean.valueOf(z3));
            b(z3);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f1230i || this.f1231j) && str != null && str2 != null) {
            try {
                if (this.f1231j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z3, int i3);

    public void removeEmptyNativeRecordFiles() {
        be.c(f1224a);
    }

    public native String removeNativeKeyValue(String str);

    public void resendSigquit() {
        a(20, "");
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public native void setNativeInfo(int i3, String str);

    @Override // com.tencent.bugly.proguard.q
    public boolean setNativeIsAppForeground(boolean z3) {
        String str;
        if (z3) {
            str = "true";
        } else {
            str = "false";
        }
        return a(14, str);
    }

    public boolean setNativeLaunchTime(long j2) {
        try {
            return a(15, String.valueOf(j2));
        } catch (NumberFormatException e5) {
            if (!al.a(e5)) {
                e5.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z3) {
        try {
            c(z3);
            boolean isUserOpened = isUserOpened();
            ac a5 = ac.a();
            if (a5 != null) {
                if (isUserOpened && a5.c().f1184f) {
                    isUserOpened = true;
                } else {
                    isUserOpened = false;
                }
            }
            if (isUserOpened != this.f1232k) {
                al.a("native changed to %b", Boolean.valueOf(isUserOpened));
                b(isUserOpened);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void startNativeMonitor() {
        try {
            if (!this.f1231j && !this.f1230i) {
                boolean z3 = !ap.b(this.f1226e.f1250t);
                if (at.b) {
                    String str = "Bugly_Native";
                    if (z3) {
                        str = this.f1226e.f1250t;
                    }
                    boolean a5 = a(str, z3);
                    this.f1231j = a5;
                    if (!a5 && !z3) {
                        this.f1230i = a("NativeRQD", false);
                    }
                } else {
                    String str2 = "Bugly_Native";
                    aa aaVar = this.f1226e;
                    String str3 = aaVar.f1250t;
                    if (!z3) {
                        aaVar.getClass();
                    } else {
                        str2 = str3;
                    }
                    this.f1231j = a(str2, z3);
                }
                if (!this.f1231j && !this.f1230i) {
                    return;
                }
                a(this.f1229h);
                setNativeAppVersion(this.f1226e.f1247o);
                setNativeAppChannel(this.f1226e.s);
                setNativeAppPackage(this.f1226e.c);
                setNativeUserId(this.f1226e.f());
                setNativeIsAppForeground(this.f1226e.a());
                setNativeLaunchTime(this.f1226e.f1236a);
                return;
            }
            a(this.f1229h);
        } catch (Throwable th) {
            throw th;
        }
    }

    public native void testCrash();

    public void testNativeCrash() {
        if (!this.f1231j) {
            al.d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public void unBlockSigquit(boolean z3) {
        if (z3) {
            a(21, "true");
        } else {
            a(21, "false");
        }
    }

    public native String unregist();

    private synchronized void c() {
        if (!this.f1232k) {
            al.d("[Native] Native crash report has already unregistered.", new Object[0]);
        } else if (unregist() != null) {
            al.a("[Native] Successfully closed native crash report.", new Object[0]);
            this.f1232k = false;
        } else {
            ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.f1232k = false;
            al.a("[Native] Successfully closed native crash report.", new Object[0]);
        }
    }

    private synchronized void b(boolean z3) {
        if (z3) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    private synchronized void a(boolean z3) {
        if (this.f1232k) {
            al.d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.f1231j) {
            String regist = regist(f1224a, z3, c);
            if (regist != null) {
                al.a("[Native] Native Crash Report enable.", new Object[0]);
                this.f1226e.f1251u = regist;
                String concat = "-".concat(regist);
                if (!at.b && !this.f1226e.f1240h.contains(concat)) {
                    aa aaVar = this.f1226e;
                    aaVar.f1240h = aaVar.f1240h.concat("-").concat(this.f1226e.f1251u);
                }
                al.a("comInfo.sdkVersion %s", this.f1226e.f1240h);
                this.f1232k = true;
                String runningCpuAbi = getRunningCpuAbi();
                if (!TextUtils.isEmpty(runningCpuAbi)) {
                    this.f1226e.e(runningCpuAbi);
                }
                return;
            }
        } else if (this.f1230i) {
            try {
                Class cls = Integer.TYPE;
                String str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", new Class[]{String.class, String.class, cls, cls}, new Object[]{f1224a, ab.d(), Integer.valueOf(z3 ? 1 : 5), 1});
                if (str == null) {
                    String d = ab.d();
                    aa.b();
                    str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", new Class[]{String.class, String.class, cls}, new Object[]{f1224a, d, Integer.valueOf(aa.B())});
                }
                if (str != null) {
                    this.f1232k = true;
                    this.f1226e.f1251u = str;
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", new Class[]{cls}, new Object[]{Integer.valueOf(z3 ? 1 : 5)});
                    String runningCpuAbi2 = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi2)) {
                        this.f1226e.e(runningCpuAbi2);
                    }
                    return;
                }
            } catch (Throwable unused) {
            }
        }
        this.f1231j = false;
        this.f1230i = false;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = b;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z3, boolean z5, boolean z6) {
        a(16, String.valueOf(z3));
        a(17, String.valueOf(z5));
        a(18, String.valueOf(z6));
        testNativeCrash();
    }

    private synchronized void c(boolean z3) {
        if (this.f1233l != z3) {
            al.a("user change native %b", Boolean.valueOf(z3));
            this.f1233l = z3;
        }
    }

    private static boolean a(String str, boolean z3) {
        boolean z5;
        try {
            al.a("[Native] Trying to load so: %s", str);
            if (z3) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                al.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z5 = true;
                al.d(th.getMessage(), new Object[0]);
                al.d("[Native] Failed to load so: %s", str);
                return z5;
            }
        } catch (Throwable th2) {
            th = th2;
            z5 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i3, String str) {
        if (this.f1231j) {
            try {
                setNativeInfo(i3, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                return false;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }
}
