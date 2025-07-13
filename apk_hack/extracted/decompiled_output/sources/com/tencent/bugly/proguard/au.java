package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class au {

    /* renamed from: a */
    private static au f1353a;
    private ac b;
    private aa c;
    private as d;

    /* renamed from: e */
    private Context f1354e;

    private au(Context context) {
        at a5 = at.a();
        if (a5 == null) {
            return;
        }
        this.b = ac.a();
        this.c = aa.a(context);
        this.d = a5.s;
        this.f1354e = context;
        ak.a().a(new b3.d(4, this));
    }

    public static au a(Context context) {
        if (f1353a == null) {
            f1353a = new au(context);
        }
        return f1353a;
    }

    public static void a(Thread thread, int i3, String str, String str2, String str3, Map<String, String> map) {
        ak.a().a(new m0(thread, i3, str, str2, str3, map));
    }

    public static /* synthetic */ void a(au auVar) {
        al.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            auVar.c.getClass();
            ap.a(cls, "sdkPackageName", "com.tencent.bugly");
            al.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            al.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    public static /* synthetic */ void a(au auVar, Thread thread, int i3, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i3 == 4) {
            str4 = "Unity";
        } else if (i3 == 5 || i3 == 6) {
            str4 = "Cocos";
        } else if (i3 != 8) {
            al.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i3));
            return;
        } else {
            str4 = "H5";
        }
        al.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!auVar.b.b()) {
                al.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c = auVar.b.c();
            if (!c.f1184f && auVar.b.b()) {
                al.e("[ExtraCrashManager] Crash report was closed by remote. Will not upload to Bugly , print local for helpful!", new Object[0]);
                String a5 = ap.a();
                String str6 = auVar.c.d;
                String name = currentThread.getName();
                as.a(str4, a5, str6, name, str + "\n" + str2 + "\n" + str3, null);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i3 != 5 && i3 != 6) {
                if (i3 == 8 && !c.f1190l) {
                    al.e("[ExtraCrashManager] %s report is disabled.", str4);
                    al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (!c.f1189k) {
                al.e("[ExtraCrashManager] %s report is disabled.", str4);
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i5 = i3 != 8 ? i3 : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = auVar.c.k();
            crashDetailBean.G = auVar.c.j();
            crashDetailBean.H = auVar.c.l();
            crashDetailBean.I = ab.b(auVar.f1354e);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.b = i5;
            crashDetailBean.f1200e = auVar.c.g();
            aa aaVar = auVar.c;
            crashDetailBean.f1201f = aaVar.f1247o;
            crashDetailBean.f1202g = aaVar.q();
            crashDetailBean.f1208m = auVar.c.f();
            crashDetailBean.f1209n = String.valueOf(str);
            crashDetailBean.f1210o = String.valueOf(str2);
            String str7 = "";
            if (str3 == null) {
                str5 = "";
            } else {
                String[] split = str3.split("\n");
                if (split.length > 0) {
                    str7 = split[0];
                }
                str5 = str3;
            }
            crashDetailBean.f1211p = str7;
            crashDetailBean.q = str5;
            crashDetailBean.f1212r = System.currentTimeMillis();
            crashDetailBean.f1214u = ap.c(crashDetailBean.q.getBytes());
            crashDetailBean.f1218z = ap.a(auVar.c.Q, at.f1332h);
            crashDetailBean.A = auVar.c.d;
            crashDetailBean.B = currentThread.getName() + "(" + currentThread.getId() + ")";
            crashDetailBean.L = auVar.c.s();
            crashDetailBean.f1203h = auVar.c.p();
            aa aaVar2 = auVar.c;
            crashDetailBean.Q = aaVar2.f1236a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.U = auVar.c.z();
            aa aaVar3 = auVar.c;
            crashDetailBean.V = aaVar3.f1253x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = auVar.c.y();
            crashDetailBean.f1217y = ao.a();
            if (crashDetailBean.S == null) {
                crashDetailBean.S = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.S.putAll(map);
            }
            String a6 = ap.a();
            String str8 = auVar.c.d;
            String name2 = currentThread.getName();
            as.a(str4, a6, str8, name2, str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!auVar.d.a(crashDetailBean, !at.a().C)) {
                auVar.d.b(crashDetailBean, false);
            }
            al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                al.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }
}
