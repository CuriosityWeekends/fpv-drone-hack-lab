package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler;
import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class bd implements NativeExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1390a;
    private final as b;
    private final aa c;
    private final ac d;

    public bd(Context context, aa aaVar, as asVar, ac acVar) {
        this.f1390a = context;
        this.b = asVar;
        this.c = aaVar;
        this.d = acVar;
    }

    private static Map<String, String> a(String[] strArr) {
        int length;
        if (strArr == null) {
            length = 1;
        } else {
            length = strArr.length;
        }
        HashMap hashMap = new HashMap(length);
        if (strArr != null) {
            for (int i3 = 0; i3 < strArr.length; i3++) {
                String str = strArr[i3];
                if (str != null) {
                    al.a("Extra message[%d]: %s", Integer.valueOf(i3), str);
                    String[] split = str.split("=");
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    } else {
                        al.d("bad extraMsg %s", str);
                    }
                }
            }
        } else {
            al.c("not found extraMsg", new Object[0]);
        }
        return hashMap;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final boolean getAndUpdateAnrState() {
        if (ay.a() == null) {
            return false;
        }
        ay a5 = ay.a();
        if (a5.f1367a.get()) {
            al.c("anr is processing, return", new Object[0]);
            return false;
        }
        ActivityManager activityManager = a5.b;
        if (!z.a(activityManager) && az.a(activityManager, 0L) != null) {
            if (a5.a(System.currentTimeMillis())) {
                return false;
            }
            return a5.a(true);
        }
        al.c("proc is not in anr, wait next check", new Object[0]);
        return false;
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final void handleNativeException(int i3, int i5, long j2, long j5, String str, String str2, String str3, String str4, int i6, String str5, int i7, int i8, int i9, String str6, String str7) {
        al.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i3, i5, j2, j5, str, str2, str3, str4, i6, str5, i7, i8, i9, str6, str7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:4:0x0017, B:8:0x003b, B:10:0x004d, B:12:0x0055, B:14:0x0061, B:16:0x006d, B:19:0x0074, B:22:0x0083, B:24:0x00a1, B:26:0x00d4, B:28:0x00f7, B:29:0x00fe, B:32:0x010a, B:34:0x0112, B:42:0x015a, B:43:0x015e, B:45:0x0168, B:25:0x00bf, B:21:0x0080), top: B:76:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bf A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:4:0x0017, B:8:0x003b, B:10:0x004d, B:12:0x0055, B:14:0x0061, B:16:0x006d, B:19:0x0074, B:22:0x0083, B:24:0x00a1, B:26:0x00d4, B:28:0x00f7, B:29:0x00fe, B:32:0x010a, B:34:0x0112, B:42:0x015a, B:43:0x015e, B:45:0x0168, B:25:0x00bf, B:21:0x0080), top: B:76:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f7 A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:4:0x0017, B:8:0x003b, B:10:0x004d, B:12:0x0055, B:14:0x0061, B:16:0x006d, B:19:0x0074, B:22:0x0083, B:24:0x00a1, B:26:0x00d4, B:28:0x00f7, B:29:0x00fe, B:32:0x010a, B:34:0x0112, B:42:0x015a, B:43:0x015e, B:45:0x0168, B:25:0x00bf, B:21:0x0080), top: B:76:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ab A[Catch: all -> 0x01b4, TryCatch #1 {all -> 0x01b4, blocks: (B:49:0x01a5, B:51:0x01ab, B:55:0x01b9), top: B:77:0x01a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b9 A[Catch: all -> 0x01b4, TRY_LEAVE, TryCatch #1 {all -> 0x01b4, blocks: (B:49:0x01a5, B:51:0x01ab, B:55:0x01b9), top: B:77:0x01a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void handleNativeException2(int r28, int r29, long r30, long r32, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, int r38, java.lang.String r39, int r40, int r41, int r42, java.lang.String r43, java.lang.String r44, java.lang.String[] r45) {
        /*
            Method dump skipped, instructions count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.bd.handleNativeException2(int, int, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, int, int, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    @Override // com.tencent.bugly.crashreport.crash.jni.NativeExceptionHandler
    public final CrashDetailBean packageCrashDatas(String str, String str2, long j2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z3, boolean z5) {
        int i3;
        String str12;
        int indexOf;
        boolean i5 = at.a().i();
        if (i5) {
            al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.f1200e = this.c.g();
        aa aaVar = this.c;
        crashDetailBean.f1201f = aaVar.f1247o;
        crashDetailBean.f1202g = aaVar.q();
        crashDetailBean.f1208m = this.c.f();
        crashDetailBean.f1209n = str3;
        crashDetailBean.f1210o = i5 ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.f1211p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.q = str13;
        crashDetailBean.f1212r = j2;
        crashDetailBean.f1214u = ap.c(str13.getBytes());
        crashDetailBean.A = str;
        crashDetailBean.B = str2;
        crashDetailBean.L = this.c.s();
        crashDetailBean.f1203h = this.c.p();
        crashDetailBean.f1204i = this.c.A();
        crashDetailBean.f1215v = str8;
        String dumpFilePath = NativeCrashHandler.getInstance() != null ? NativeCrashHandler.getDumpFilePath() : null;
        String a5 = be.a(dumpFilePath, str8);
        if (!ap.b(a5)) {
            crashDetailBean.Z = a5;
        }
        crashDetailBean.aa = be.b(dumpFilePath);
        crashDetailBean.w = be.a(str9, at.f1330f, at.f1335k, at.f1340p);
        crashDetailBean.f1216x = be.a(str10, at.f1330f, null, true);
        crashDetailBean.N = str7;
        crashDetailBean.O = str6;
        crashDetailBean.P = str11;
        crashDetailBean.F = this.c.k();
        crashDetailBean.G = this.c.j();
        crashDetailBean.H = this.c.l();
        crashDetailBean.I = ab.b(this.f1390a);
        crashDetailBean.J = ab.g();
        crashDetailBean.K = ab.h();
        if (z3) {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.f1217y = ao.a();
            aa aaVar2 = this.c;
            crashDetailBean.Q = aaVar2.f1236a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.f1218z = ap.a(this.c.Q, at.f1332h);
            int indexOf2 = crashDetailBean.q.indexOf("java:\n");
            if (indexOf2 > 0 && (i3 = indexOf2 + 6) < crashDetailBean.q.length()) {
                String str14 = crashDetailBean.q;
                String substring = str14.substring(i3, str14.length() - 1);
                if (substring.length() > 0 && crashDetailBean.f1218z.containsKey(crashDetailBean.B) && (indexOf = (str12 = crashDetailBean.f1218z.get(crashDetailBean.B)).indexOf(substring)) > 0) {
                    String substring2 = str12.substring(indexOf);
                    crashDetailBean.f1218z.put(crashDetailBean.B, substring2);
                    crashDetailBean.q = crashDetailBean.q.substring(0, i3);
                    crashDetailBean.q = a1.i.k(new StringBuilder(), crashDetailBean.q, substring2);
                }
            }
            if (str == null) {
                crashDetailBean.A = this.c.d;
            }
            crashDetailBean.U = this.c.z();
            aa aaVar3 = this.c;
            crashDetailBean.V = aaVar3.f1253x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = this.c.y();
        } else {
            crashDetailBean.C = -1L;
            crashDetailBean.D = -1L;
            crashDetailBean.E = -1L;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.Q = -1L;
            crashDetailBean.U = -1;
            crashDetailBean.V = -1;
            crashDetailBean.W = map;
            crashDetailBean.X = this.c.y();
            crashDetailBean.f1218z = null;
            if (str == null) {
                crashDetailBean.A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f1217y = bArr;
            }
        }
        return crashDetailBean;
    }
}
