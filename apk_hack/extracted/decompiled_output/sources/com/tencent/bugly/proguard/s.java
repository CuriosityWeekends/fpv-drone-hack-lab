package com.tencent.bugly.proguard;

import android.app.Application;
import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class s {

    /* renamed from: a */
    public static boolean f1521a = false;
    public static r b = null;
    private static int c = 10;
    private static long d = 300000;

    /* renamed from: e */
    private static long f1522e = 30000;

    /* renamed from: f */
    private static long f1523f = 0;

    /* renamed from: g */
    private static int f1524g = 0;

    /* renamed from: h */
    private static long f1525h = 0;

    /* renamed from: i */
    private static long f1526i = 0;

    /* renamed from: j */
    private static long f1527j = 0;

    /* renamed from: k */
    private static Application.ActivityLifecycleCallbacks f1528k = null;

    /* renamed from: l */
    private static Class<?> f1529l = null;

    /* renamed from: m */
    private static boolean f1530m = true;

    public static void a(Context context, BuglyStrategy buglyStrategy) {
        long j2;
        if (f1521a) {
            return;
        }
        boolean z3 = aa.a(context).f1238f;
        f1530m = z3;
        b = new r(context, z3);
        f1521a = true;
        if (buglyStrategy != null) {
            f1529l = buglyStrategy.getUserInfoActivity();
            j2 = buglyStrategy.getAppReportDelay();
        } else {
            j2 = 0;
        }
        if (j2 <= 0) {
            c(context, buglyStrategy);
        } else {
            ak.a().a(new c0(3, context, buglyStrategy, false), j2);
        }
    }

    public static /* synthetic */ int g() {
        int i3 = f1524g;
        f1524g = i3 + 1;
        return i3;
    }

    /* JADX WARN: Type inference failed for: r13v10, types: [android.app.Application$ActivityLifecycleCallbacks, java.lang.Object] */
    public static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean z3;
        boolean z5;
        if (buglyStrategy != null) {
            z5 = buglyStrategy.recordUserInfoOnceADay();
            z3 = buglyStrategy.isEnableUserInfo();
        } else {
            z3 = true;
            z5 = false;
        }
        if (z5) {
            aa a5 = aa.a(context);
            List<UserInfoBean> a6 = r.a(a5.d);
            if (a6 != null) {
                for (int i3 = 0; i3 < a6.size(); i3++) {
                    UserInfoBean userInfoBean = a6.get(i3);
                    if (userInfoBean.f1177n.equals(a5.f1247o) && userInfoBean.b == 1) {
                        long b5 = ap.b();
                        if (b5 <= 0) {
                            break;
                        } else if (userInfoBean.f1168e >= b5) {
                            if (userInfoBean.f1169f <= 0) {
                                b.b();
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            z3 = false;
        }
        aa b6 = aa.b();
        if (b6 != null && z.a()) {
            b6.a(0, true);
        }
        if (z3) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (f1528k == null) {
                        f1528k = new Object();
                    }
                    application.registerActivityLifecycleCallbacks(f1528k);
                } catch (Exception e5) {
                    if (!al.a(e5)) {
                        e5.printStackTrace();
                    }
                }
            }
        }
        if (f1530m) {
            f1526i = System.currentTimeMillis();
            b.a(1, false);
            al.a("[session] launch app, new start", new Object[0]);
            b.a();
            b.a(21600000L);
        }
    }

    public static void a(long j2) {
        if (j2 < 0) {
            j2 = ac.a().c().f1194p;
        }
        f1523f = j2;
    }

    public static void a(StrategyBean strategyBean, boolean z3) {
        r rVar = b;
        if (rVar != null && !z3) {
            rVar.b();
        }
        if (strategyBean == null) {
            return;
        }
        long j2 = strategyBean.f1194p;
        if (j2 > 0) {
            f1522e = j2;
        }
        int i3 = strategyBean.f1197u;
        if (i3 > 0) {
            c = i3;
        }
        long j5 = strategyBean.f1198v;
        if (j5 > 0) {
            d = j5;
        }
    }

    public static void a() {
        r rVar = b;
        if (rVar != null) {
            rVar.a(2, false);
        }
    }

    public static void a(Context context) {
        if (!f1521a || context == null) {
            return;
        }
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application != null) {
            try {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f1528k;
                if (activityLifecycleCallbacks != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
            } catch (Exception e5) {
                if (!al.a(e5)) {
                    e5.printStackTrace();
                }
            }
        }
        f1521a = false;
    }

    public static /* synthetic */ String a(String str, String str2) {
        return ap.a() + "  " + str + "  " + str2 + "\n";
    }
}
