package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ab {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayList<b0> f1256a;
    private static final Map<Integer, String> b;
    private static final String[] c;

    static {
        ArrayList<b0> arrayList = new ArrayList<>();
        arrayList.add(new b0(10));
        arrayList.add(new b0(4));
        arrayList.add(new b0(5));
        arrayList.add(new b0(11));
        arrayList.add(new b0(6));
        arrayList.add(new b0(7));
        arrayList.add(new b0(9));
        arrayList.add(new b0(3));
        arrayList.add(new b0(8));
        arrayList.add(new b0(0));
        arrayList.add(new b0(2));
        arrayList.add(new b0(1));
        f1256a = arrayList;
        HashMap hashMap = new HashMap();
        hashMap.put(1, "GPRS");
        hashMap.put(2, "EDGE");
        hashMap.put(3, "UMTS");
        hashMap.put(8, "HSDPA");
        hashMap.put(9, "HSUPA");
        hashMap.put(10, "HSPA");
        hashMap.put(4, "CDMA");
        hashMap.put(5, "EVDO_0");
        hashMap.put(6, "EVDO_A");
        hashMap.put(7, "1xRTT");
        hashMap.put(11, "iDen");
        hashMap.put(12, "EVDO_B");
        hashMap.put(13, "LTE");
        hashMap.put(14, "eHRPD");
        hashMap.put(15, "HSPA+");
        b = hashMap;
        c = new String[]{"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
    }

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return "fail";
            }
            return "fail";
        }
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return "fail";
            }
            return "fail";
        }
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (al.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String d() {
        try {
            return String.valueOf(System.getProperty("os.arch"));
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return "fail";
            }
            return "fail";
        }
    }

    public static long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long f() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        r0 = java.lang.Long.parseLong(r2.replaceAll("[^\\d]", ""));
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0036 -> B:33:0x0046). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long g() {
        /*
            r0 = 0
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3a
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = "/proc/self/status"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L3a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L2a
        L13:
            if (r2 == 0) goto L31
            java.lang.String r4 = "VmSize"
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L2c
            java.lang.String r4 = "[^\\d]"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.replaceAll(r4, r5)     // Catch: java.lang.Throwable -> L2a
            long r0 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L2a
            goto L31
        L2a:
            r2 = move-exception
            goto L3e
        L2c:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L2a
            goto L13
        L31:
            r3.close()     // Catch: java.lang.Throwable -> L35
            goto L46
        L35:
            r2 = move-exception
            r2.printStackTrace()
            goto L46
        L3a:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L3e:
            com.tencent.bugly.proguard.al.a(r2)     // Catch: java.lang.Throwable -> L4b
            if (r3 == 0) goto L46
            r3.close()     // Catch: java.lang.Throwable -> L35
        L46:
            r2 = 1024(0x400, double:5.06E-321)
            long r0 = r0 * r2
            return r0
        L4b:
            r0 = move-exception
            if (r3 == 0) goto L56
            r3.close()     // Catch: java.lang.Throwable -> L52
            goto L56
        L52:
            r1 = move-exception
            r1.printStackTrace()
        L56:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ab.g():long");
    }

    public static long h() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static long i() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            if (!al.a(e5)) {
                                e5.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                            return -1L;
                        } catch (IOException e6) {
                            if (!al.a(e6)) {
                                e6.printStackTrace();
                                return -1L;
                            }
                            return -1L;
                        }
                    }
                    long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                        if (!al.a(e7)) {
                            e7.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e8) {
                        if (!al.a(e8)) {
                            e8.printStackTrace();
                        }
                    }
                    return parseLong;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e9) {
                                if (!al.a(e9)) {
                                    e9.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                                return -2L;
                            } catch (IOException e10) {
                                if (!al.a(e10)) {
                                    e10.printStackTrace();
                                    return -2L;
                                }
                                return -2L;
                            }
                        }
                        return -2L;
                    } catch (Throwable th3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e11) {
                                if (!al.a(e11)) {
                                    e11.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e12) {
                                if (!al.a(e12)) {
                                    e12.printStackTrace();
                                }
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            fileReader = null;
            th = th5;
            bufferedReader = null;
        }
    }

    public static long j() {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 2048);
                try {
                    bufferedReader2.readLine();
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            if (!al.a(e5)) {
                                e5.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e6) {
                            if (!al.a(e6)) {
                                e6.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e7) {
                            if (!al.a(e7)) {
                                e7.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e8) {
                            if (!al.a(e8)) {
                                e8.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long parseLong2 = Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
                    Long.signum(parseLong2);
                    long j2 = (parseLong2 * 1024) + parseLong;
                    String readLine3 = bufferedReader2.readLine();
                    if (readLine3 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e9) {
                            if (!al.a(e9)) {
                                e9.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e10) {
                            if (!al.a(e10)) {
                                e10.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long parseLong3 = (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024) + j2;
                    try {
                        bufferedReader2.close();
                    } catch (IOException e11) {
                        if (!al.a(e11)) {
                            e11.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e12) {
                        if (!al.a(e12)) {
                            e12.printStackTrace();
                        }
                    }
                    return parseLong3;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        if (!al.a(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e13) {
                                if (!al.a(e13)) {
                                    e13.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                                return -2L;
                            } catch (IOException e14) {
                                if (!al.a(e14)) {
                                    e14.printStackTrace();
                                    return -2L;
                                }
                                return -2L;
                            }
                        }
                        return -2L;
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e15) {
                                if (!al.a(e15)) {
                                    e15.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e16) {
                                if (!al.a(e16)) {
                                    e16.printStackTrace();
                                }
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    public static long k() {
        if (!s()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return -2L;
            }
            return -2L;
        }
    }

    public static long l() {
        if (!s()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return -2L;
            }
            return -2L;
        }
    }

    public static String m() {
        return "";
    }

    public static String n() {
        Iterator<b0> it = f1256a.iterator();
        while (it.hasNext()) {
            String a5 = it.next().a();
            if (!TextUtils.isEmpty(a5)) {
                return a5;
            }
        }
        return null;
    }

    public static boolean o() {
        String str;
        String a5 = ap.a("ro.build.version.opporom");
        if (!ap.b(a5) && !a5.equals("fail")) {
            str = "Oppo/COLOROS/".concat(a5);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    public static boolean p() {
        String str;
        String a5 = ap.a("ro.vivo.os.build.display.id");
        if (!ap.b(a5) && !a5.equals("fail")) {
            str = "vivo/FUNTOUCH/".concat(a5);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    public static boolean q() {
        boolean z3;
        String[] strArr = c;
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (new File(strArr[i3]).exists()) {
                    z3 = true;
                    break;
                }
                i3++;
            } else {
                z3 = false;
                break;
            }
        }
        String str = Build.TAGS;
        if ((str == null || !str.contains("test-keys")) && !z3) {
            return false;
        }
        return true;
    }

    public static boolean r() {
        float maxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        float f4 = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        float f5 = maxMemory - f4;
        al.c("maxMemory : %f", Float.valueOf(maxMemory));
        al.c("totalMemory : %f", Float.valueOf(f4));
        al.c("freeMemory : %f", Float.valueOf(f5));
        if (f5 < 10.0f) {
            return true;
        }
        return false;
    }

    private static boolean s() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static String c(Context context) {
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        String str = "unknown";
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e5) {
            e = e5;
        }
        if (activeNetworkInfo == null) {
            return null;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            int networkType = telephonyManager.getNetworkType();
            String str2 = b.get(Integer.valueOf(networkType));
            if (str2 == null) {
                try {
                    str = "MOBILE(" + networkType + ")";
                } catch (Exception e6) {
                    e = e6;
                    str = str2;
                    if (!al.a(e)) {
                        e.printStackTrace();
                    }
                    return str;
                }
            } else {
                str = str2;
            }
        }
        return str;
    }

    public static String a(Context context) {
        if (context != null && context.getApplicationInfo() != null) {
            String str = context.getApplicationInfo().nativeLibraryDir;
            if (TextUtils.isEmpty(str)) {
                return "fail";
            }
            if (str.endsWith("arm")) {
                return "armeabi-v7a";
            }
            if (str.endsWith("arm64")) {
                return "arm64-v8a";
            }
            if (str.endsWith("x86")) {
                return "x86";
            }
            if (str.endsWith("x86_64")) {
                return "x86_64";
            }
        }
        return "fail";
    }

    public static long b(Context context) {
        long pss;
        ActivityManager activityManager;
        try {
            activityManager = (ActivityManager) context.getSystemService("activity");
        } catch (Throwable unused) {
            pss = Debug.getPss();
        }
        if (activityManager != null) {
            pss = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss();
            return pss * 1024;
        }
        return 0L;
    }
}
