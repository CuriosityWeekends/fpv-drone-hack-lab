package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1513a = true;
    public static List<o> b = new ArrayList();
    public static boolean c;
    private static w d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f1514e;

    private static boolean a(aa aaVar) {
        List<String> list = aaVar.f1252v;
        return list != null && list.contains("bugly");
    }

    public static synchronized void a(Context context) {
        synchronized (p.class) {
            a(context, null);
        }
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (p.class) {
            if (f1514e) {
                al.d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(al.b, "[init] context of init() is null, check it.");
            } else {
                aa a5 = aa.a(context);
                if (a(a5)) {
                    f1513a = false;
                    return;
                }
                String e5 = a5.e();
                if (e5 == null) {
                    Log.e(al.b, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
                } else {
                    a(context, e5, a5.D, buglyStrategy);
                }
            }
        }
    }

    public static synchronized void a(Context context, String str, boolean z3, BuglyStrategy buglyStrategy) {
        byte[] bArr;
        synchronized (p.class) {
            if (f1514e) {
                al.d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(al.b, "[init] context is null, check it.");
            } else if (str == null) {
                Log.e(al.b, "init arg 'crashReportAppID' should not be null!");
            } else {
                f1514e = true;
                if (z3) {
                    c = true;
                    al.c = true;
                    al.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                    al.e("--------------------------------------------------------------------------------------------", new Object[0]);
                    al.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                    al.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                    al.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                    al.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                    al.e("--------------------------------------------------------------------------------------------", new Object[0]);
                    al.b("[init] Open debug mode of Bugly.", new Object[0]);
                }
                al.a(" crash report start initializing...", new Object[0]);
                al.b("[init] Bugly start initializing...", new Object[0]);
                al.a("[init] Bugly complete version: v%s", "4.1.9.3");
                Context a5 = ap.a(context);
                aa a6 = aa.a(a5);
                a6.o();
                ao.a(a5);
                d = w.a(a5, b);
                ai.a(a5);
                ac.a(a5, b);
                u a7 = u.a(a5);
                if (a(a6)) {
                    f1513a = false;
                    return;
                }
                a6.f1249r = str;
                a6.b("APP_ID", str);
                al.a("[param] Set APP ID:%s", str);
                if (buglyStrategy != null) {
                    String appVersion = buglyStrategy.getAppVersion();
                    if (!TextUtils.isEmpty(appVersion)) {
                        if (appVersion.length() > 100) {
                            String substring = appVersion.substring(0, 100);
                            al.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                            appVersion = substring;
                        }
                        a6.f1247o = appVersion;
                        al.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
                    }
                    try {
                        if (buglyStrategy.isReplaceOldChannel()) {
                            String appChannel = buglyStrategy.getAppChannel();
                            if (!TextUtils.isEmpty(appChannel)) {
                                if (appChannel.length() > 100) {
                                    String substring2 = appChannel.substring(0, 100);
                                    al.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                                    appChannel = substring2;
                                }
                                d.a(556, "app_channel", appChannel.getBytes(), false);
                                a6.s = appChannel;
                            }
                        } else {
                            Map<String, byte[]> a8 = d.a(556, (v) null);
                            if (a8 != null && (bArr = a8.get("app_channel")) != null) {
                                a6.s = new String(bArr);
                            }
                        }
                        al.a("[param] Set App channel: %s", a6.s);
                    } catch (Exception e5) {
                        if (c) {
                            e5.printStackTrace();
                        }
                    }
                    String appPackageName = buglyStrategy.getAppPackageName();
                    if (!TextUtils.isEmpty(appPackageName)) {
                        if (appPackageName.length() > 100) {
                            String substring3 = appPackageName.substring(0, 100);
                            al.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                            appPackageName = substring3;
                        }
                        a6.c = appPackageName;
                        al.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
                    }
                    String deviceID = buglyStrategy.getDeviceID();
                    if (deviceID != null) {
                        if (deviceID.length() > 100) {
                            String substring4 = deviceID.substring(0, 100);
                            al.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                            deviceID = substring4;
                        }
                        a6.a(deviceID);
                        al.a("[param] Set device ID: %s", deviceID);
                    }
                    String deviceModel = buglyStrategy.getDeviceModel();
                    if (deviceModel != null) {
                        a6.b(deviceModel);
                        al.a("[param] Set device model: %s", deviceModel);
                    }
                    a6.f1238f = buglyStrategy.isUploadProcess();
                    ao.b = buglyStrategy.isBuglyLogUpload();
                }
                for (int i3 = 0; i3 < b.size(); i3++) {
                    if (a7.b(b.get(i3).id)) {
                        b.get(i3).init(a5, z3, buglyStrategy);
                    }
                }
                s.a(a5, buglyStrategy);
                long appReportDelay = buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L;
                final ac a9 = ac.a();
                a9.c.a(new Thread() { // from class: com.tencent.bugly.proguard.ac.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        try {
                            Map<String, byte[]> a10 = w.a().a(ac.f1257a, (v) null);
                            if (a10 != null) {
                                byte[] bArr2 = a10.get("device");
                                byte[] bArr3 = a10.get("gateway");
                                if (bArr2 != null) {
                                    aa.a(ac.this.f1262h).d(new String(bArr2));
                                }
                                if (bArr3 != null) {
                                    aa.a(ac.this.f1262h).c(new String(bArr3));
                                }
                            }
                            ac.this.f1261g = ac.d();
                            if (ac.this.f1261g != null) {
                                if (ap.b(ac.f1258i) || !ap.d(ac.f1258i)) {
                                    ac.this.f1261g.q = StrategyBean.f1182a;
                                    ac.this.f1261g.f1195r = StrategyBean.b;
                                } else {
                                    ac.this.f1261g.q = ac.f1258i;
                                    ac.this.f1261g.f1195r = ac.f1258i;
                                }
                            }
                        } catch (Throwable th) {
                            if (!al.a(th)) {
                                th.printStackTrace();
                            }
                        }
                        ac acVar = ac.this;
                        acVar.a(acVar.f1261g, false);
                    }
                }, appReportDelay);
                al.b("[init] Bugly initialization finished.", new Object[0]);
            }
        }
    }

    public static synchronized void a(o oVar) {
        synchronized (p.class) {
            if (!b.contains(oVar)) {
                b.add(oVar);
            }
        }
    }
}
