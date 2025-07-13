package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import androidx.core.view.PointerIconCompat;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r {

    /* renamed from: e */
    private static boolean f1518e = true;

    /* renamed from: a */
    private Context f1519a;
    private long b;
    private int c;
    private boolean d;

    public r(Context context, boolean z3) {
        this.f1519a = context;
        this.d = z3;
    }

    private static void b(List<UserInfoBean> list, List<UserInfoBean> list2) {
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            UserInfoBean next = it.next();
            if (next.f1169f != -1) {
                it.remove();
                if (next.f1168e < ap.b()) {
                    list2.add(next);
                }
            }
        }
    }

    public final void a(int i3, boolean z3) {
        ac a5 = ac.a();
        if (a5 != null && !a5.c().f1185g && i3 != 1 && i3 != 3) {
            al.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i3 == 1 || i3 == 3) {
            this.c++;
        }
        aa a6 = aa.a(this.f1519a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.b = i3;
        userInfoBean.c = a6.d;
        userInfoBean.d = a6.f();
        userInfoBean.f1168e = System.currentTimeMillis();
        userInfoBean.f1169f = -1L;
        userInfoBean.f1177n = a6.f1247o;
        userInfoBean.f1178o = i3 == 1 ? 1 : 0;
        userInfoBean.f1175l = a6.a();
        userInfoBean.f1176m = a6.f1254y;
        userInfoBean.f1170g = a6.f1255z;
        userInfoBean.f1171h = a6.A;
        userInfoBean.f1172i = a6.B;
        userInfoBean.f1174k = a6.C;
        userInfoBean.f1180r = a6.t();
        userInfoBean.s = a6.y();
        userInfoBean.f1179p = a6.z();
        userInfoBean.q = a6.f1253x;
        ak.a().a(new r0(0, this, userInfoBean, z3), 0L);
    }

    public final void b() {
        ak a5 = ak.a();
        if (a5 != null) {
            a5.a(new q0(this, 0));
        }
    }

    private static void b(List<UserInfoBean> list) {
        if (list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < list.size() && i3 < 50; i3++) {
            sb.append(" or _id = ");
            sb.append(list.get(i3).f1167a);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(4);
        }
        sb.setLength(0);
        try {
            al.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", sb2)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static ContentValues b(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = userInfoBean.f1167a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f1168e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f1169f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.c);
            contentValues.put("_dt", ap.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final void a(long j2) {
        ak.a().a(new s0(this, j2), j2);
    }

    public final void a() {
        this.b = ap.b() + 86400000;
        ak.a().a(new q0(this, 1), (this.b - System.currentTimeMillis()) + 5000);
    }

    private boolean b(boolean z3) {
        boolean z5 = true;
        if (f1518e) {
            File file = new File(this.f1519a.getFilesDir(), "bugly_last_us_up_tm");
            long currentTimeMillis = System.currentTimeMillis();
            if (z3) {
                am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                return true;
            }
            if (!file.exists()) {
                am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
            } else {
                BufferedReader a5 = ap.a(file);
                if (a5 != null) {
                    try {
                        long longValue = Long.valueOf(a5.readLine().trim()).longValue();
                        if (currentTimeMillis >= longValue && currentTimeMillis - longValue <= 86400000 && currentTimeMillis - longValue < 300000) {
                            z5 = false;
                        }
                        am.a(file, String.valueOf(currentTimeMillis), 1024L, false);
                    }
                }
                if (a5 != null) {
                    a5.close();
                }
            }
            return z5;
        }
        return true;
    }

    private static void a(List<UserInfoBean> list, List<UserInfoBean> list2) {
        int size = list.size() - 20;
        if (size > 0) {
            int i3 = 0;
            while (i3 < list.size() - 1) {
                int i5 = i3 + 1;
                for (int i6 = i5; i6 < list.size(); i6++) {
                    if (list.get(i3).f1168e > list.get(i6).f1168e) {
                        list.set(i3, list.get(i6));
                        list.set(i6, list.get(i3));
                    }
                }
                i3 = i5;
            }
            for (int i7 = 0; i7 < size; i7++) {
                list2.add(list.get(i7));
            }
        }
    }

    private static int a(List<UserInfoBean> list) {
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        int i5 = 0;
        for (UserInfoBean userInfoBean : list) {
            if (userInfoBean.f1168e > currentTimeMillis - 600000 && ((i3 = userInfoBean.b) == 1 || i3 == 4 || i3 == 3)) {
                i5++;
            }
        }
        return i5;
    }

    private void a(List<UserInfoBean> list, boolean z3) {
        aa b;
        if (!b(z3)) {
            long currentTimeMillis = System.currentTimeMillis();
            for (UserInfoBean userInfoBean : list) {
                userInfoBean.f1169f = currentTimeMillis;
                a(userInfoBean, true);
            }
            al.d("uploadCheck failed", new Object[0]);
            return;
        }
        int i3 = this.c == 1 ? 1 : 2;
        bv bvVar = null;
        if (list != null && list.size() != 0 && (b = aa.b()) != null) {
            b.o();
            bv bvVar2 = new bv();
            bvVar2.b = b.d;
            bvVar2.c = b.g();
            ArrayList<bu> arrayList = new ArrayList<>();
            for (UserInfoBean userInfoBean2 : list) {
                bu a5 = ae.a(userInfoBean2);
                if (a5 != null) {
                    arrayList.add(a5);
                }
            }
            bvVar2.d = arrayList;
            HashMap hashMap = new HashMap();
            bvVar2.f1475e = hashMap;
            hashMap.put("A7", "");
            Map<String, String> map = bvVar2.f1475e;
            map.put("A6", aa.n());
            Map<String, String> map2 = bvVar2.f1475e;
            map2.put("A5", b.m());
            Map<String, String> map3 = bvVar2.f1475e;
            StringBuilder sb = new StringBuilder();
            sb.append(b.k());
            map3.put("A2", sb.toString());
            Map<String, String> map4 = bvVar2.f1475e;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b.k());
            map4.put("A1", sb2.toString());
            Map<String, String> map5 = bvVar2.f1475e;
            map5.put("A24", b.f1243k);
            Map<String, String> map6 = bvVar2.f1475e;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(b.l());
            map6.put("A17", sb3.toString());
            Map<String, String> map7 = bvVar2.f1475e;
            map7.put("A15", b.q());
            Map<String, String> map8 = bvVar2.f1475e;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(b.r());
            map8.put("A13", sb4.toString());
            Map<String, String> map9 = bvVar2.f1475e;
            map9.put("F08", b.E);
            Map<String, String> map10 = bvVar2.f1475e;
            map10.put("F09", b.F);
            Map<String, String> y3 = b.y();
            if (y3 != null && y3.size() > 0) {
                for (Map.Entry<String, String> entry : y3.entrySet()) {
                    Map<String, String> map11 = bvVar2.f1475e;
                    map11.put("C04_" + entry.getKey(), entry.getValue());
                }
            }
            if (i3 == 1) {
                bvVar2.f1474a = (byte) 1;
            } else if (i3 != 2) {
                al.e("unknown up type %d ", Integer.valueOf(i3));
            } else {
                bvVar2.f1474a = (byte) 2;
            }
            bvVar = bvVar2;
        }
        if (bvVar == null) {
            al.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
            return;
        }
        byte[] a6 = ae.a((m) bvVar);
        if (a6 == null) {
            al.d("[UserInfo] Failed to encode data.", new Object[0]);
            return;
        }
        bq a7 = ae.a(this.f1519a, 840, a6);
        if (a7 == null) {
            al.d("[UserInfo] Request package is null.", new Object[0]);
            return;
        }
        c1.b bVar = new c1.b(2, this, list);
        ai.a().a(PointerIconCompat.TYPE_CONTEXT_MENU, a7, ac.a().c().q, StrategyBean.f1182a, bVar, this.c == 1);
    }

    public void a(UserInfoBean userInfoBean, boolean z3) {
        List<UserInfoBean> a5;
        if (userInfoBean == null) {
            return;
        }
        if (!z3 && userInfoBean.b != 1 && (a5 = a(aa.a(this.f1519a).d)) != null && a5.size() >= 20) {
            al.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a5.size()));
            return;
        }
        long a6 = w.a().a("t_ui", b(userInfoBean), (v) null);
        if (a6 >= 0) {
            al.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a6));
            userInfoBean.f1167a = a6;
        }
    }

    public static List<UserInfoBean> a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (ap.b(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = w.a().a("t_ui", (String[]) null, str2);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean a5 = a(cursor);
                    if (a5 != null) {
                        arrayList.add(a5);
                    } else {
                        long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
                        sb.append(" or _id = ");
                        sb.append(j2);
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    al.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(w.a().a("t_ui", sb2.substring(4))));
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) ap.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f1167a = j2;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0064 A[Catch: all -> 0x0026, TryCatch #0 {, blocks: (B:48:0x0003, B:51:0x0008, B:54:0x000f, B:57:0x0016, B:59:0x001c, B:65:0x0028, B:67:0x003b, B:69:0x0049, B:72:0x005e, B:74:0x0064, B:76:0x0069, B:79:0x0070, B:82:0x0086, B:70:0x0058), top: B:87:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(boolean r8) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            monitor-enter(r7)
            boolean r2 = r7.d     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto L8
            goto L24
        L8:
            com.tencent.bugly.proguard.ai r2 = com.tencent.bugly.proguard.ai.a()     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto Lf
            goto L24
        Lf:
            com.tencent.bugly.proguard.ac r3 = com.tencent.bugly.proguard.ac.a()     // Catch: java.lang.Throwable -> L26
            if (r3 != 0) goto L16
            goto L24
        L16:
            boolean r3 = r3.b()     // Catch: java.lang.Throwable -> L26
            if (r3 == 0) goto L28
            r3 = 1001(0x3e9, float:1.403E-42)
            boolean r2 = r2.b(r3)     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto L28
        L24:
            monitor-exit(r7)
            return
        L26:
            r8 = move-exception
            goto L8f
        L28:
            android.content.Context r2 = r7.f1519a     // Catch: java.lang.Throwable -> L26
            com.tencent.bugly.proguard.aa r2 = com.tencent.bugly.proguard.aa.a(r2)     // Catch: java.lang.Throwable -> L26
            java.lang.String r2 = r2.d     // Catch: java.lang.Throwable -> L26
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L26
            r3.<init>()     // Catch: java.lang.Throwable -> L26
            java.util.List r2 = a(r2)     // Catch: java.lang.Throwable -> L26
            if (r2 == 0) goto L58
            a(r2, r3)     // Catch: java.lang.Throwable -> L26
            b(r2, r3)     // Catch: java.lang.Throwable -> L26
            int r4 = a(r2)     // Catch: java.lang.Throwable -> L26
            r5 = 15
            if (r4 <= r5) goto L5d
            java.lang.String r5 = "[UserInfo] Upload user info too many times in 10 min: %d"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L26
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L26
            r6[r1] = r4     // Catch: java.lang.Throwable -> L26
            com.tencent.bugly.proguard.al.d(r5, r6)     // Catch: java.lang.Throwable -> L26
            r4 = 0
            goto L5e
        L58:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L26
            r2.<init>()     // Catch: java.lang.Throwable -> L26
        L5d:
            r4 = 1
        L5e:
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L26
            if (r5 <= 0) goto L67
            b(r3)     // Catch: java.lang.Throwable -> L26
        L67:
            if (r4 == 0) goto L86
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L26
            if (r3 != 0) goto L70
            goto L86
        L70:
            java.lang.String r3 = "[UserInfo] Upload user info(size: %d)"
            int r4 = r2.size()     // Catch: java.lang.Throwable -> L26
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L26
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L26
            r0[r1] = r4     // Catch: java.lang.Throwable -> L26
            com.tencent.bugly.proguard.al.c(r3, r0)     // Catch: java.lang.Throwable -> L26
            r7.a(r2, r8)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r7)
            return
        L86:
            java.lang.String r8 = "[UserInfo] There is no user info in local database."
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L26
            com.tencent.bugly.proguard.al.c(r8, r0)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r7)
            return
        L8f:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.r.a(boolean):void");
    }

    public static /* synthetic */ void a(UserInfoBean userInfoBean) {
        aa b;
        if (userInfoBean == null || (b = aa.b()) == null) {
            return;
        }
        userInfoBean.f1173j = b.d();
    }
}
