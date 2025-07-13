package com.tencent.bugly.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ay {

    /* renamed from: f */
    public static ay f1366f;
    public final ActivityManager b;
    final aa c;
    final ak d;

    /* renamed from: e */
    String f1368e;

    /* renamed from: g */
    private final Context f1369g;

    /* renamed from: h */
    private final ac f1370h;

    /* renamed from: i */
    private final as f1371i;

    /* renamed from: k */
    private FileObserver f1373k;

    /* renamed from: m */
    private bg f1375m;

    /* renamed from: n */
    private int f1376n;

    /* renamed from: a */
    public final AtomicBoolean f1367a = new AtomicBoolean(false);

    /* renamed from: j */
    private final Object f1372j = new Object();

    /* renamed from: l */
    private boolean f1374l = true;

    /* renamed from: o */
    private long f1377o = 0;

    public ay(Context context, ac acVar, aa aaVar, ak akVar, as asVar) {
        Context a5 = ap.a(context);
        this.f1369g = a5;
        this.b = (ActivityManager) a5.getSystemService("activity");
        if (ap.b(NativeCrashHandler.getDumpFilePath())) {
            this.f1368e = context.getDir("bugly", 0).getAbsolutePath();
        } else {
            this.f1368e = NativeCrashHandler.getDumpFilePath();
        }
        this.c = aaVar;
        this.d = akVar;
        this.f1370h = acVar;
        this.f1371i = asVar;
    }

    private synchronized void c() {
        if (e()) {
            al.d("start when started!", new Object[0]);
            return;
        }
        n0 n0Var = new n0(this);
        this.f1373k = n0Var;
        n0Var.startWatching();
        al.a("start anr monitor!", new Object[0]);
        this.d.a(new o0(this, 0));
    }

    private synchronized void d() {
        if (!e()) {
            al.d("close when closed!", new Object[0]);
            return;
        }
        this.f1373k.stopWatching();
        this.f1373k = null;
        al.d("close anr monitor!", new Object[0]);
    }

    private synchronized boolean e() {
        if (this.f1373k != null) {
            return true;
        }
        return false;
    }

    private synchronized boolean f() {
        return this.f1374l;
    }

    private synchronized void g() {
        if (e()) {
            al.d("start when started!", new Object[0]);
        } else if (TextUtils.isEmpty(this.f1368e)) {
        } else {
            synchronized (this.f1372j) {
                bg bgVar = this.f1375m;
                if (bgVar != null) {
                    if (!bgVar.isAlive()) {
                    }
                }
                bg bgVar2 = new bg();
                this.f1375m = bgVar2;
                boolean z3 = this.c.S;
                bgVar2.b = z3;
                al.c("set record stack trace enable:".concat(String.valueOf(z3)), new Object[0]);
                bg bgVar3 = this.f1375m;
                StringBuilder sb = new StringBuilder("Bugly-ThreadMonitor");
                int i3 = this.f1376n;
                this.f1376n = i3 + 1;
                sb.append(i3);
                bgVar3.setName(sb.toString());
                this.f1375m.b();
            }
            n0 n0Var = new n0(this, this.f1368e);
            this.f1373k = n0Var;
            n0Var.startWatching();
            al.a("startWatchingPrivateAnrDir! dumFilePath is %s", this.f1368e);
            this.d.a(new o0(this, 1));
        }
    }

    private synchronized void h() {
        if (!e()) {
            al.d("close when closed!", new Object[0]);
            return;
        }
        synchronized (this.f1372j) {
            bg bgVar = this.f1375m;
            if (bgVar != null) {
                bgVar.a();
                this.f1375m = null;
            }
        }
        al.a("stopWatchingPrivateAnrDir", new Object[0]);
        this.f1373k.stopWatching();
        this.f1373k = null;
        al.d("close anr monitor!", new Object[0]);
    }

    public final void b(boolean z3) {
        d(z3);
        boolean f4 = f();
        ac a5 = ac.a();
        if (a5 != null) {
            f4 = f4 && a5.c().f1184f;
        }
        if (f4 != e()) {
            al.a("anr changed to %b", Boolean.valueOf(f4));
            c(f4);
        }
    }

    public static synchronized ay a() {
        ay ayVar;
        synchronized (ay.class) {
            ayVar = f1366f;
        }
        return ayVar;
    }

    private CrashDetailBean a(ax axVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = this.c.k();
            crashDetailBean.G = this.c.j();
            crashDetailBean.H = this.c.l();
            crashDetailBean.I = ab.b(this.f1369g);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.b = 3;
            crashDetailBean.f1200e = this.c.g();
            aa aaVar = this.c;
            crashDetailBean.f1201f = aaVar.f1247o;
            crashDetailBean.f1202g = aaVar.q();
            crashDetailBean.f1208m = this.c.f();
            crashDetailBean.f1209n = "ANR_EXCEPTION";
            crashDetailBean.f1210o = axVar.f1364f;
            crashDetailBean.q = axVar.f1365g;
            HashMap hashMap = new HashMap();
            crashDetailBean.T = hashMap;
            hashMap.put("BUGLY_CR_01", axVar.f1363e);
            String str = crashDetailBean.q;
            int indexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.f1211p = indexOf > 0 ? crashDetailBean.q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.f1212r = axVar.c;
            String str2 = crashDetailBean.q;
            if (str2 != null) {
                crashDetailBean.f1214u = ap.c(str2.getBytes());
            }
            crashDetailBean.f1218z = axVar.b;
            crashDetailBean.A = axVar.f1362a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.L = this.c.s();
            crashDetailBean.f1203h = this.c.p();
            crashDetailBean.f1204i = this.c.A();
            crashDetailBean.f1215v = axVar.d;
            aa aaVar2 = this.c;
            crashDetailBean.P = aaVar2.f1251u;
            crashDetailBean.Q = aaVar2.f1236a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.U = this.c.z();
            aa aaVar3 = this.c;
            crashDetailBean.V = aaVar3.f1253x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = this.c.y();
            crashDetailBean.f1217y = ao.a();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    public final synchronized void b() {
        al.d("customer decides whether to open or close.", new Object[0]);
    }

    private synchronized void d(boolean z3) {
        if (this.f1374l != z3) {
            al.a("user change anr %b", Boolean.valueOf(z3));
            this.f1374l = z3;
        }
    }

    private synchronized void c(boolean z3) {
        if (z3) {
            g();
        } else {
            h();
        }
    }

    private static boolean a(String str, String str2, String str3) {
        Map<String, String[]> map;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo != null && (map = readTargetDumpInfo.d) != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder(1024);
            String[] strArr = readTargetDumpInfo.d.get("main");
            if (strArr != null && strArr.length >= 3) {
                sb.append("\"main\" tid=");
                sb.append(strArr[2]);
                sb.append(" :\n");
                sb.append(strArr[0]);
                sb.append("\n");
                sb.append(strArr[1]);
                sb.append("\n\n");
            }
            for (Map.Entry<String, String[]> entry : readTargetDumpInfo.d.entrySet()) {
                if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                    sb.append("\"");
                    sb.append(entry.getKey());
                    sb.append("\" tid=");
                    sb.append(entry.getValue()[2]);
                    sb.append(" :\n");
                    sb.append(entry.getValue()[0]);
                    sb.append("\n");
                    sb.append(entry.getValue()[1]);
                    sb.append("\n\n");
                }
            }
            return am.a(str2, sb.toString(), sb.length() * 2);
        }
        al.e("not found trace dump for %s", str3);
        return false;
    }

    private static String a(List<ba> list, long j2) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder(4096);
            sb.append("\n>>>>> 以下为anr过程中主线程堆栈记录，可根据堆栈出现次数推测在该堆栈阻塞的时间，出现次数越多对anr贡献越大，越可能是造成anr的原因 >>>>>\n\n>>>>> Thread Stack Traces Records Start >>>>>\n");
            for (int i3 = 0; i3 < list.size(); i3++) {
                ba baVar = list.get(i3);
                sb.append("Thread name:");
                sb.append(baVar.f1379a);
                sb.append("\n");
                long j5 = baVar.b - j2;
                String str = j5 <= 0 ? "before " : "after ";
                sb.append("Got ");
                sb.append(str);
                sb.append("anr:");
                sb.append(Math.abs(j5));
                sb.append("ms\n");
                sb.append(baVar.c);
                sb.append("\n");
                if (sb.length() * 2 >= 101376) {
                    break;
                }
            }
            sb.append("\n<<<<< Thread Stack Traces Records End <<<<<\n");
            return sb.toString();
        }
        return "main thread stack not enable";
    }

    public final boolean a(boolean z3) {
        boolean compareAndSet = this.f1367a.compareAndSet(!z3, z3);
        al.c("tryChangeAnrState to %s, success:%s", Boolean.valueOf(z3), Boolean.valueOf(compareAndSet));
        return compareAndSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0070 A[Catch: all -> 0x005c, TryCatch #3 {all -> 0x005c, blocks: (B:96:0x0008, B:97:0x0017, B:104:0x002d, B:106:0x004d, B:108:0x0053, B:115:0x0060, B:118:0x0070, B:121:0x0081, B:124:0x008c, B:126:0x00a9, B:127:0x00ad, B:131:0x00c9, B:133:0x00fc, B:136:0x0109, B:138:0x0132, B:140:0x0160, B:141:0x0162, B:150:0x0174, B:151:0x0185, B:156:0x0195, B:158:0x01a8, B:160:0x01b7, B:162:0x01d9, B:163:0x01de, B:164:0x01e5, B:159:0x01b0, B:139:0x014a, B:155:0x018e, B:130:0x00c5, B:119:0x0079, B:165:0x01e6, B:167:0x01ea, B:170:0x01f9, B:98:0x0018, B:100:0x001c, B:103:0x002c, B:142:0x0163, B:144:0x0167, B:148:0x0171), top: B:185:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0081 A[Catch: all -> 0x005c, TRY_LEAVE, TryCatch #3 {all -> 0x005c, blocks: (B:96:0x0008, B:97:0x0017, B:104:0x002d, B:106:0x004d, B:108:0x0053, B:115:0x0060, B:118:0x0070, B:121:0x0081, B:124:0x008c, B:126:0x00a9, B:127:0x00ad, B:131:0x00c9, B:133:0x00fc, B:136:0x0109, B:138:0x0132, B:140:0x0160, B:141:0x0162, B:150:0x0174, B:151:0x0185, B:156:0x0195, B:158:0x01a8, B:160:0x01b7, B:162:0x01d9, B:163:0x01de, B:164:0x01e5, B:159:0x01b0, B:139:0x014a, B:155:0x018e, B:130:0x00c5, B:119:0x0079, B:165:0x01e6, B:167:0x01ea, B:170:0x01f9, B:98:0x0018, B:100:0x001c, B:103:0x002c, B:142:0x0163, B:144:0x0167, B:148:0x0171), top: B:185:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x008c A[Catch: all -> 0x005c, TRY_ENTER, TryCatch #3 {all -> 0x005c, blocks: (B:96:0x0008, B:97:0x0017, B:104:0x002d, B:106:0x004d, B:108:0x0053, B:115:0x0060, B:118:0x0070, B:121:0x0081, B:124:0x008c, B:126:0x00a9, B:127:0x00ad, B:131:0x00c9, B:133:0x00fc, B:136:0x0109, B:138:0x0132, B:140:0x0160, B:141:0x0162, B:150:0x0174, B:151:0x0185, B:156:0x0195, B:158:0x01a8, B:160:0x01b7, B:162:0x01d9, B:163:0x01de, B:164:0x01e5, B:159:0x01b0, B:139:0x014a, B:155:0x018e, B:130:0x00c5, B:119:0x0079, B:165:0x01e6, B:167:0x01ea, B:170:0x01f9, B:98:0x0018, B:100:0x001c, B:103:0x002c, B:142:0x0163, B:144:0x0167, B:148:0x0171), top: B:185:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01a8 A[Catch: all -> 0x005c, TryCatch #3 {all -> 0x005c, blocks: (B:96:0x0008, B:97:0x0017, B:104:0x002d, B:106:0x004d, B:108:0x0053, B:115:0x0060, B:118:0x0070, B:121:0x0081, B:124:0x008c, B:126:0x00a9, B:127:0x00ad, B:131:0x00c9, B:133:0x00fc, B:136:0x0109, B:138:0x0132, B:140:0x0160, B:141:0x0162, B:150:0x0174, B:151:0x0185, B:156:0x0195, B:158:0x01a8, B:160:0x01b7, B:162:0x01d9, B:163:0x01de, B:164:0x01e5, B:159:0x01b0, B:139:0x014a, B:155:0x018e, B:130:0x00c5, B:119:0x0079, B:165:0x01e6, B:167:0x01ea, B:170:0x01f9, B:98:0x0018, B:100:0x001c, B:103:0x002c, B:142:0x0163, B:144:0x0167, B:148:0x0171), top: B:185:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01b0 A[Catch: all -> 0x005c, TryCatch #3 {all -> 0x005c, blocks: (B:96:0x0008, B:97:0x0017, B:104:0x002d, B:106:0x004d, B:108:0x0053, B:115:0x0060, B:118:0x0070, B:121:0x0081, B:124:0x008c, B:126:0x00a9, B:127:0x00ad, B:131:0x00c9, B:133:0x00fc, B:136:0x0109, B:138:0x0132, B:140:0x0160, B:141:0x0162, B:150:0x0174, B:151:0x0185, B:156:0x0195, B:158:0x01a8, B:160:0x01b7, B:162:0x01d9, B:163:0x01de, B:164:0x01e5, B:159:0x01b0, B:139:0x014a, B:155:0x018e, B:130:0x00c5, B:119:0x0079, B:165:0x01e6, B:167:0x01ea, B:170:0x01f9, B:98:0x0018, B:100:0x001c, B:103:0x002c, B:142:0x0163, B:144:0x0167, B:148:0x0171), top: B:185:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01d9 A[Catch: all -> 0x005c, TryCatch #3 {all -> 0x005c, blocks: (B:96:0x0008, B:97:0x0017, B:104:0x002d, B:106:0x004d, B:108:0x0053, B:115:0x0060, B:118:0x0070, B:121:0x0081, B:124:0x008c, B:126:0x00a9, B:127:0x00ad, B:131:0x00c9, B:133:0x00fc, B:136:0x0109, B:138:0x0132, B:140:0x0160, B:141:0x0162, B:150:0x0174, B:151:0x0185, B:156:0x0195, B:158:0x01a8, B:160:0x01b7, B:162:0x01d9, B:163:0x01de, B:164:0x01e5, B:159:0x01b0, B:139:0x014a, B:155:0x018e, B:130:0x00c5, B:119:0x0079, B:165:0x01e6, B:167:0x01ea, B:170:0x01f9, B:98:0x0018, B:100:0x001c, B:103:0x002c, B:142:0x0163, B:144:0x0167, B:148:0x0171), top: B:185:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01e6 A[Catch: all -> 0x01f7, TRY_ENTER, TryCatch #3 {all -> 0x005c, blocks: (B:96:0x0008, B:97:0x0017, B:104:0x002d, B:106:0x004d, B:108:0x0053, B:115:0x0060, B:118:0x0070, B:121:0x0081, B:124:0x008c, B:126:0x00a9, B:127:0x00ad, B:131:0x00c9, B:133:0x00fc, B:136:0x0109, B:138:0x0132, B:140:0x0160, B:141:0x0162, B:150:0x0174, B:151:0x0185, B:156:0x0195, B:158:0x01a8, B:160:0x01b7, B:162:0x01d9, B:163:0x01de, B:164:0x01e5, B:159:0x01b0, B:139:0x014a, B:155:0x018e, B:130:0x00c5, B:119:0x0079, B:165:0x01e6, B:167:0x01ea, B:170:0x01f9, B:98:0x0018, B:100:0x001c, B:103:0x002c, B:142:0x0163, B:144:0x0167, B:148:0x0171), top: B:185:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(long r23, java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ay.a(long, java.lang.String):void");
    }

    public final boolean a(long j2) {
        if (Math.abs(j2 - this.f1377o) < 10000) {
            al.d("should not process ANR too Fre in %dms", 10000);
            return true;
        }
        this.f1377o = j2;
        return false;
    }

    public static /* synthetic */ void a(ay ayVar) {
        long currentTimeMillis = (System.currentTimeMillis() + at.f1334j) - ap.b();
        am.a(ayVar.f1368e, "bugly_trace_", ".txt", currentTimeMillis);
        am.a(ayVar.f1368e, "manual_bugly_trace_", ".txt", currentTimeMillis);
        am.a(ayVar.f1368e, "main_stack_record_", ".txt", currentTimeMillis);
        am.a(ayVar.f1368e, "main_stack_record_", ".txt.merged", currentTimeMillis);
    }
}
