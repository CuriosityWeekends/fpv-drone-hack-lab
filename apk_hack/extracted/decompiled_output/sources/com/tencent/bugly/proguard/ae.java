package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ae {
    public static bu a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        bu buVar = new bu();
        buVar.f1467a = userInfoBean.f1168e;
        buVar.f1468e = userInfoBean.f1173j;
        buVar.d = userInfoBean.c;
        buVar.c = userInfoBean.d;
        buVar.f1471h = userInfoBean.f1178o == 1;
        int i3 = userInfoBean.b;
        if (i3 == 1) {
            buVar.b = (byte) 1;
        } else if (i3 == 2) {
            buVar.b = (byte) 4;
        } else if (i3 == 3) {
            buVar.b = (byte) 2;
        } else if (i3 == 4) {
            buVar.b = (byte) 3;
        } else if (i3 == 8) {
            buVar.b = (byte) 8;
        } else if (i3 < 10 || i3 >= 20) {
            al.e("unknown uinfo type %d ", Integer.valueOf(i3));
            return null;
        } else {
            buVar.b = (byte) i3;
        }
        HashMap hashMap = new HashMap();
        buVar.f1469f = hashMap;
        if (userInfoBean.f1179p >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(userInfoBean.f1179p);
            hashMap.put("C01", sb.toString());
        }
        if (userInfoBean.q >= 0) {
            Map<String, String> map = buVar.f1469f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.q);
            map.put("C02", sb2.toString());
        }
        Map<String, String> map2 = userInfoBean.f1180r;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f1180r.entrySet()) {
                Map<String, String> map3 = buVar.f1469f;
                map3.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map4 = userInfoBean.s;
        if (map4 != null && map4.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                Map<String, String> map5 = buVar.f1469f;
                map5.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map6 = buVar.f1469f;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(!userInfoBean.f1175l);
        map6.put("A36", sb3.toString());
        Map<String, String> map7 = buVar.f1469f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(userInfoBean.f1170g);
        map7.put("F02", sb4.toString());
        Map<String, String> map8 = buVar.f1469f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.f1171h);
        map8.put("F03", sb5.toString());
        Map<String, String> map9 = buVar.f1469f;
        map9.put("F04", userInfoBean.f1173j);
        Map<String, String> map10 = buVar.f1469f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.f1172i);
        map10.put("F05", sb6.toString());
        Map<String, String> map11 = buVar.f1469f;
        map11.put("F06", userInfoBean.f1176m);
        Map<String, String> map12 = buVar.f1469f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.f1174k);
        map12.put("F10", sb7.toString());
        al.c("summary type %d vm:%d", Byte.valueOf(buVar.b), Integer.valueOf(buVar.f1469f.size()));
        return buVar;
    }

    public static <T extends m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                k kVar = new k(bArr);
                kVar.a("utf-8");
                newInstance.a(kVar);
                return newInstance;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static bq a(Context context, int i3, byte[] bArr) {
        String str;
        aa b = aa.b();
        StrategyBean c = ac.a().c();
        if (b != null && c != null) {
            try {
                bq bqVar = new bq();
                synchronized (b) {
                    bqVar.f1428a = b.b;
                    bqVar.b = b.e();
                    bqVar.c = b.c;
                    bqVar.d = b.f1247o;
                    bqVar.f1429e = b.s;
                    bqVar.f1430f = b.f1240h;
                    bqVar.f1431g = i3;
                    if (bArr == null) {
                        bArr = "".getBytes();
                    }
                    bqVar.f1432h = bArr;
                    bqVar.f1433i = b.h();
                    bqVar.f1434j = b.f1243k;
                    bqVar.f1435k = new HashMap();
                    bqVar.f1436l = b.d();
                    bqVar.f1437m = c.f1193o;
                    bqVar.f1439o = b.g();
                    bqVar.f1440p = ab.c(context);
                    bqVar.q = System.currentTimeMillis();
                    bqVar.s = b.i();
                    bqVar.f1444v = b.g();
                    bqVar.w = bqVar.f1440p;
                    bqVar.f1438n = "com.tencent.bugly";
                    Map<String, String> map = bqVar.f1435k;
                    map.put("A26", b.s());
                    Map<String, String> map2 = bqVar.f1435k;
                    StringBuilder sb = new StringBuilder();
                    sb.append(aa.C());
                    map2.put("A62", sb.toString());
                    Map<String, String> map3 = bqVar.f1435k;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(aa.D());
                    map3.put("A63", sb2.toString());
                    Map<String, String> map4 = bqVar.f1435k;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(b.J);
                    map4.put("F11", sb3.toString());
                    Map<String, String> map5 = bqVar.f1435k;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(b.I);
                    map5.put("F12", sb4.toString());
                    Map<String, String> map6 = bqVar.f1435k;
                    map6.put("D3", b.q);
                    List<o> list = p.b;
                    if (list != null) {
                        for (o oVar : list) {
                            String str2 = oVar.versionKey;
                            if (str2 != null && (str = oVar.version) != null) {
                                bqVar.f1435k.put(str2, str);
                            }
                        }
                    }
                    bqVar.f1435k.put("G15", ap.d("G15", ""));
                    bqVar.f1435k.put("G10", ap.d("G10", ""));
                    bqVar.f1435k.put("D4", ap.d("D4", "0"));
                }
                Map<String, String> x3 = b.x();
                if (x3 != null) {
                    for (Map.Entry<String, String> entry : x3.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getValue())) {
                            bqVar.f1435k.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                return bqVar;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        al.e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    public static byte[] a(Object obj) {
        try {
            e eVar = new e();
            eVar.b();
            eVar.a("utf-8");
            eVar.c();
            eVar.b("RqdServer");
            eVar.c("sync");
            eVar.a("detail", obj);
            return eVar.a();
        } catch (Throwable th) {
            if (al.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static br a(byte[] bArr) {
        if (bArr != null) {
            try {
                e eVar = new e();
                eVar.b();
                eVar.a("utf-8");
                eVar.a(bArr);
                Object b = eVar.b("detail", new br());
                if (br.class.isInstance(b)) {
                    return (br) br.class.cast(b);
                }
                return null;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(m mVar) {
        try {
            l lVar = new l();
            lVar.a("utf-8");
            mVar.a(lVar);
            byte[] bArr = new byte[lVar.f1505a.position()];
            System.arraycopy(lVar.f1505a.array(), 0, bArr, 0, lVar.f1505a.position());
            return bArr;
        } catch (Throwable th) {
            if (al.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
