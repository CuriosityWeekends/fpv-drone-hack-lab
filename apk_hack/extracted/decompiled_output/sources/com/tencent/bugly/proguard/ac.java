package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.List;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ac {

    /* renamed from: a  reason: collision with root package name */
    public static int f1257a = 1000;
    public static long b = 259200000;
    private static ac d;

    /* renamed from: i  reason: collision with root package name */
    private static String f1258i;
    public final ak c;

    /* renamed from: e  reason: collision with root package name */
    private final List<o> f1259e;

    /* renamed from: f  reason: collision with root package name */
    private final StrategyBean f1260f;

    /* renamed from: g  reason: collision with root package name */
    private StrategyBean f1261g = null;

    /* renamed from: h  reason: collision with root package name */
    private Context f1262h;

    private ac(Context context, List<o> list) {
        this.f1262h = context;
        if (aa.a(context) != null) {
            String str = aa.a(context).H;
            if ("oversea".equals(str)) {
                StrategyBean.f1182a = "https://astat.bugly.qcloud.com/rqd/async";
                StrategyBean.b = "https://astat.bugly.qcloud.com/rqd/async";
            } else if ("na_https".equals(str)) {
                StrategyBean.f1182a = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
                StrategyBean.b = "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
        }
        this.f1260f = new StrategyBean();
        this.f1259e = list;
        this.c = ak.a();
    }

    public static StrategyBean d() {
        byte[] bArr;
        List<y> a5 = w.a().a(2);
        if (a5 != null && a5.size() > 0 && (bArr = a5.get(0).f1547g) != null) {
            return (StrategyBean) ap.a(bArr, StrategyBean.CREATOR);
        }
        return null;
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.f1261g;
        if (strategyBean != null) {
            if (!ap.d(strategyBean.q)) {
                this.f1261g.q = StrategyBean.f1182a;
            }
            if (!ap.d(this.f1261g.f1195r)) {
                this.f1261g.f1195r = StrategyBean.b;
            }
            return this.f1261g;
        }
        if (!ap.b(f1258i) && ap.d(f1258i)) {
            StrategyBean strategyBean2 = this.f1260f;
            String str = f1258i;
            strategyBean2.q = str;
            strategyBean2.f1195r = str;
        }
        return this.f1260f;
    }

    public final synchronized boolean b() {
        return this.f1261g != null;
    }

    public static synchronized ac a(Context context, List<o> list) {
        ac acVar;
        synchronized (ac.class) {
            try {
                if (d == null) {
                    d = new ac(context, list);
                }
                acVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return acVar;
    }

    public static synchronized ac a() {
        ac acVar;
        synchronized (ac.class) {
            acVar = d;
        }
        return acVar;
    }

    public final void a(StrategyBean strategyBean, boolean z3) {
        al.c("[Strategy] Notify %s", s.class.getName());
        s.a(strategyBean, z3);
        for (o oVar : this.f1259e) {
            try {
                al.c("[Strategy] Notify %s", oVar.getClass().getName());
                oVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!ap.b(str) && ap.d(str)) {
            f1258i = str;
        } else {
            al.d("URL user set is invalid.", new Object[0]);
        }
    }

    public final void a(bt btVar) {
        int i3;
        if (btVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f1261g;
        if (strategyBean == null || btVar.f1461h != strategyBean.f1193o) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f1184f = btVar.f1457a;
            strategyBean2.f1186h = btVar.c;
            strategyBean2.f1185g = btVar.b;
            if (ap.b(f1258i) || !ap.d(f1258i)) {
                if (ap.d(btVar.d)) {
                    al.c("[Strategy] Upload url changes to %s", btVar.d);
                    strategyBean2.q = btVar.d;
                }
                if (ap.d(btVar.f1458e)) {
                    al.c("[Strategy] Exception upload url changes to %s", btVar.f1458e);
                    strategyBean2.f1195r = btVar.f1458e;
                }
            }
            bs bsVar = btVar.f1459f;
            if (bsVar != null && !ap.b(bsVar.f1453a)) {
                strategyBean2.s = btVar.f1459f.f1453a;
            }
            long j2 = btVar.f1461h;
            if (j2 != 0) {
                strategyBean2.f1193o = j2;
            }
            Map<String, String> map = btVar.f1460g;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = btVar.f1460g;
                strategyBean2.f1196t = map2;
                String str = map2.get("B11");
                strategyBean2.f1187i = str != null && str.equals("1");
                String str2 = btVar.f1460g.get("B3");
                if (str2 != null) {
                    strategyBean2.w = Long.parseLong(str2);
                }
                int i5 = btVar.f1465l;
                strategyBean2.f1194p = i5;
                strategyBean2.f1198v = i5;
                String str3 = btVar.f1460g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean2.f1197u = parseInt;
                        }
                    } catch (Exception e5) {
                        if (!al.a(e5)) {
                            e5.printStackTrace();
                        }
                    }
                }
                String str4 = btVar.f1460g.get("B25");
                strategyBean2.f1189k = str4 != null && str4.equals("1");
            }
            al.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f1184f), Boolean.valueOf(strategyBean2.f1186h), Boolean.valueOf(strategyBean2.f1185g), Boolean.valueOf(strategyBean2.f1187i), Boolean.valueOf(strategyBean2.f1188j), Boolean.valueOf(strategyBean2.f1191m), Boolean.valueOf(strategyBean2.f1192n), Long.valueOf(strategyBean2.f1194p), Boolean.valueOf(strategyBean2.f1189k), Long.valueOf(strategyBean2.f1193o));
            this.f1261g = strategyBean2;
            if (ap.d(btVar.d)) {
                i3 = 0;
            } else {
                i3 = 0;
                al.c("[Strategy] download url is null", new Object[0]);
                this.f1261g.q = "";
            }
            if (!ap.d(btVar.f1458e)) {
                al.c("[Strategy] download crashurl is null", new Object[i3]);
                this.f1261g.f1195r = "";
            }
            w.a().b(2);
            y yVar = new y();
            yVar.b = 2;
            yVar.f1544a = strategyBean2.d;
            yVar.f1545e = strategyBean2.f1183e;
            yVar.f1547g = ap.a(strategyBean2);
            w.a().a(yVar);
            a(strategyBean2, true);
        }
    }
}
