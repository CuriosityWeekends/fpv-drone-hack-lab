package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.ag;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class as {

    /* renamed from: a  reason: collision with root package name */
    public static int f1319a;

    /* renamed from: h  reason: collision with root package name */
    private static final Map<Integer, Pair<String, String>> f1320h;

    /* renamed from: i  reason: collision with root package name */
    private static final ArrayList<j0> f1321i;

    /* renamed from: j  reason: collision with root package name */
    private static final Map<Integer, Integer> f1322j;

    /* renamed from: k  reason: collision with root package name */
    private static final Map<Integer, String> f1323k;

    /* renamed from: l  reason: collision with root package name */
    private static final Map<Integer, String> f1324l;
    protected final Context b;
    protected final ai c;
    protected final w d;

    /* renamed from: e  reason: collision with root package name */
    protected final ac f1325e;

    /* renamed from: f  reason: collision with root package name */
    protected aw f1326f;

    /* renamed from: g  reason: collision with root package name */
    protected BuglyStrategy.a f1327g;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(3, new Pair("203", "103"));
        hashMap.put(7, new Pair("208", "108"));
        hashMap.put(0, new Pair("200", "100"));
        hashMap.put(1, new Pair("201", "101"));
        hashMap.put(2, new Pair("202", "102"));
        hashMap.put(4, new Pair("204", "104"));
        hashMap.put(6, new Pair("206", "106"));
        hashMap.put(5, new Pair("207", "107"));
        f1320h = hashMap;
        ArrayList<j0> arrayList = new ArrayList<>();
        arrayList.add(new j0(3, 0));
        arrayList.add(new j0(7, 1));
        arrayList.add(new j0(2, 2));
        arrayList.add(new j0(0, 3));
        arrayList.add(new j0(1, 6));
        arrayList.add(new j0(4, 7));
        arrayList.add(new j0(5, 4));
        arrayList.add(new j0(6, 5));
        f1321i = arrayList;
        HashMap hashMap2 = new HashMap();
        hashMap2.put(3, 4);
        hashMap2.put(7, 7);
        hashMap2.put(2, 1);
        hashMap2.put(0, 0);
        hashMap2.put(1, 2);
        hashMap2.put(4, 3);
        hashMap2.put(5, 5);
        hashMap2.put(6, 6);
        f1322j = hashMap2;
        HashMap hashMap3 = new HashMap();
        hashMap3.put(3, "BuglyAnrCrash");
        hashMap3.put(0, "BuglyJavaCrash");
        hashMap3.put(1, "BuglyNativeCrash");
        f1323k = hashMap3;
        HashMap hashMap4 = new HashMap();
        hashMap4.put(3, "BuglyAnrCrashReport");
        hashMap4.put(0, "BuglyJavaCrashReport");
        hashMap4.put(1, "BuglyNativeCrashReport");
        f1324l = hashMap4;
    }

    public as(Context context, ai aiVar, w wVar, ac acVar, BuglyStrategy.a aVar) {
        f1319a = 1004;
        this.b = context;
        this.c = aiVar;
        this.d = wVar;
        this.f1325e = acVar;
        this.f1327g = aVar;
        this.f1326f = null;
    }

    private static List<ar> a(List<ar> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (ar arVar : list) {
            if (arVar.d && arVar.b <= currentTimeMillis - 86400000) {
                arrayList.add(arVar);
            }
        }
        return arrayList;
    }

    private static void b(CrashDetailBean crashDetailBean, List<ar> list) {
        StringBuilder sb = new StringBuilder(64);
        for (ar arVar : list) {
            if (!arVar.f1317e && !arVar.d) {
                String str = crashDetailBean.s;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(arVar.b);
                if (!str.contains(sb2.toString())) {
                    crashDetailBean.f1213t++;
                    sb.append(arVar.b);
                    sb.append("\n");
                }
            }
        }
        crashDetailBean.s += sb.toString();
    }

    private static ContentValues c(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = crashDetailBean.f1199a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f1212r));
            contentValues.put("_s1", crashDetailBean.f1214u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.d ? 1 : 0));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.f1205j ? 1 : 0));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f1207l));
            contentValues.put("_dt", ap.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static void d(List<ar> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder l5 = a1.i.l("_id in (");
        for (ar arVar : list) {
            l5.append(arVar.f1316a);
            l5.append(",");
        }
        StringBuilder sb = new StringBuilder(l5.substring(0, l5.lastIndexOf(",")));
        sb.append(")");
        String sb2 = sb.toString();
        sb.setLength(0);
        try {
            al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb2)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void e(List<CrashDetailBean> list) {
        try {
            if (list.size() == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (CrashDetailBean crashDetailBean : list) {
                sb.append(" or _id = ");
                sb.append(crashDetailBean.f1199a);
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                sb2 = sb2.substring(4);
            }
            sb.setLength(0);
            al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb2)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private static void b(List<ar> list) {
        ag agVar;
        List<CrashDetailBean> c = c(list);
        if (c == null || c.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CrashDetailBean crashDetailBean : c) {
            String str = f1324l.get(Integer.valueOf(crashDetailBean.b));
            if (!TextUtils.isEmpty(str)) {
                al.c("find expired data,crashId:%s eventType:%s", crashDetailBean.c, str);
                arrayList.add(new ag.c(crashDetailBean.c, str, crashDetailBean.f1212r, false, 0L, "expired", null));
            }
        }
        agVar = ag.a.f1266a;
        agVar.a(arrayList);
    }

    private static CrashDetailBean a(List<ar> list, CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2;
        List<CrashDetailBean> c;
        if (list.isEmpty()) {
            return crashDetailBean;
        }
        ArrayList arrayList = new ArrayList(10);
        for (ar arVar : list) {
            if (arVar.f1317e) {
                arrayList.add(arVar);
            }
        }
        if (arrayList.isEmpty() || (c = c(arrayList)) == null || c.isEmpty()) {
            crashDetailBean2 = null;
        } else {
            Collections.sort(c);
            crashDetailBean2 = c.get(0);
            a(crashDetailBean2, c);
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f1205j = true;
            crashDetailBean.f1213t = 0;
            crashDetailBean.s = "";
            crashDetailBean2 = crashDetailBean;
        }
        b(crashDetailBean2, list);
        if (crashDetailBean2.f1212r != crashDetailBean.f1212r) {
            String str = crashDetailBean2.s;
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.f1212r);
            if (!str.contains(sb.toString())) {
                crashDetailBean2.f1213t++;
                crashDetailBean2.s += crashDetailBean.f1212r + "\n";
            }
        }
        return crashDetailBean2;
    }

    private static List<CrashDetailBean> c(List<ar> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder l5 = a1.i.l("_id in (");
        for (ar arVar : list) {
            l5.append(arVar.f1316a);
            l5.append(",");
        }
        if (l5.toString().contains(",")) {
            l5 = new StringBuilder(l5.substring(0, l5.lastIndexOf(",")));
        }
        l5.append(")");
        String sb = l5.toString();
        l5.setLength(0);
        try {
            cursor = w.a().a("t_cr", (String[]) null, sb);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                l5.append("_id in (");
                int i3 = 0;
                while (cursor.moveToNext()) {
                    CrashDetailBean a5 = a(cursor);
                    if (a5 != null) {
                        arrayList.add(a5);
                    } else {
                        l5.append(cursor.getLong(cursor.getColumnIndex("_id")));
                        l5.append(",");
                        i3++;
                    }
                }
                if (l5.toString().contains(",")) {
                    l5 = new StringBuilder(l5.substring(0, l5.lastIndexOf(",")));
                }
                l5.append(")");
                String sb2 = l5.toString();
                if (i3 > 0) {
                    al.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb2)));
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

    private static String e(CrashDetailBean crashDetailBean) {
        try {
            Pair<String, String> pair = f1320h.get(Integer.valueOf(crashDetailBean.b));
            if (pair == null) {
                al.e("crash type error! %d", Integer.valueOf(crashDetailBean.b));
                return "";
            } else if (crashDetailBean.f1205j) {
                return (String) pair.first;
            } else {
                return (String) pair.second;
            }
        } catch (Exception e5) {
            al.a(e5);
            return "";
        }
    }

    private boolean d(CrashDetailBean crashDetailBean) {
        String absolutePath;
        try {
            al.c("save eup logs", new Object[0]);
            aa b = aa.b();
            String str = "#--------\npackage:" + b.e() + "\nversion:" + b.f1247o + "\nsdk:" + b.f1240h + "\nprocess:" + crashDetailBean.A + "\ndate:" + ap.a(new Date(crashDetailBean.f1212r)) + "\ntype:" + crashDetailBean.f1209n + "\nmessage:" + crashDetailBean.f1210o + "\nstack:\n" + crashDetailBean.q + "\neupID:" + crashDetailBean.c + "\n";
            if (at.f1337m == null) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.b.getPackageName();
                } else {
                    absolutePath = null;
                }
            } else {
                File file = new File(at.f1337m);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                absolutePath = file.getAbsolutePath();
            }
            am.a(absolutePath + "/euplog.txt", str, at.f1338n);
            return true;
        } catch (Throwable th) {
            al.d("rqdp{  save error} %s", th.toString());
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final void b(CrashDetailBean crashDetailBean, boolean z3) {
        if (at.f1339o) {
            al.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, 3000L, z3, crashDetailBean.b == 7, z3);
            return;
        }
        al.a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    public final void b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues c = c(crashDetailBean);
        if (c != null) {
            long a5 = w.a().a("t_cr", c, (v) null);
            if (a5 >= 0) {
                al.c("insert %s success!", "t_cr");
                crashDetailBean.f1199a = a5;
            }
        }
        if (at.f1336l) {
            d(crashDetailBean);
        }
    }

    private static void a(CrashDetailBean crashDetailBean, List<CrashDetailBean> list) {
        String[] split;
        StringBuilder sb = new StringBuilder(128);
        for (int i3 = 1; i3 < list.size(); i3++) {
            String str = list.get(i3).s;
            if (str != null && (split = str.split("\n")) != null) {
                for (String str2 : split) {
                    if (!crashDetailBean.s.contains(str2)) {
                        crashDetailBean.f1213t++;
                        sb.append(str2);
                        sb.append("\n");
                    }
                }
            }
        }
        crashDetailBean.s += sb.toString();
    }

    private static ar b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ar arVar = new ar();
            arVar.f1316a = cursor.getLong(cursor.getColumnIndex("_id"));
            arVar.b = cursor.getLong(cursor.getColumnIndex("_tm"));
            arVar.c = cursor.getString(cursor.getColumnIndex("_s1"));
            arVar.d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            arVar.f1317e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            arVar.f1318f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return arVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0239 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0252  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(com.tencent.bugly.crashreport.crash.CrashDetailBean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 629
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.as.a(com.tencent.bugly.crashreport.crash.CrashDetailBean, boolean):boolean");
    }

    private static List<ar> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor a5 = w.a().a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, (String) null);
            if (a5 == null) {
                if (a5 != null) {
                    a5.close();
                }
                return null;
            }
            try {
                if (a5.getCount() <= 0) {
                    a5.close();
                    return arrayList;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("_id in (");
                int i3 = 0;
                while (a5.moveToNext()) {
                    ar b = b(a5);
                    if (b != null) {
                        arrayList.add(b);
                    } else {
                        sb.append(a5.getLong(a5.getColumnIndex("_id")));
                        sb.append(",");
                        i3++;
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String sb2 = sb.toString();
                sb.setLength(0);
                if (i3 > 0) {
                    al.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb2)));
                }
                a5.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = a5;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    return arrayList;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void c(ArrayList<bn> arrayList, String str) {
        if (ap.b(str)) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 1, "crashInfos.txt", str.getBytes("utf-8"));
            al.c("attach crash infos", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e5) {
            e5.printStackTrace();
            al.a(e5);
        }
    }

    private static void b(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "jniLog.txt", str.getBytes("utf-8")));
            } catch (Exception e5) {
                e5.printStackTrace();
                al.a(e5);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        String str;
        if (crashDetailBean.b == 1 && (str = crashDetailBean.f1215v) != null) {
            try {
                bn a5 = a("tomb.zip", context, str);
                if (a5 != null) {
                    al.c("attach tombs", new Object[0]);
                    arrayList.add(a5);
                }
            } catch (Exception e5) {
                al.a(e5);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            arrayList.add(new bn((byte) 1, "userExtraByteData", bArr));
            al.c("attach extraData", new Object[0]);
        } catch (Exception e5) {
            al.a(e5);
        }
    }

    private boolean b(CrashDetailBean crashDetailBean, List<ar> list, List<ar> list2) {
        boolean z3;
        int i3 = crashDetailBean.b;
        boolean z5 = i3 == 0 || i3 == 1;
        boolean z6 = i3 == 3;
        if (p.c) {
            z3 = false;
        } else {
            z3 = (z6 || z5) ? at.f1329e : true;
        }
        if (z3) {
            ArrayList arrayList = new ArrayList(10);
            if (!a(crashDetailBean, list, arrayList)) {
                try {
                    if (arrayList.size() >= at.d) {
                    }
                } catch (Exception e5) {
                    al.a(e5);
                    al.d("Failed to merge crash.", new Object[0]);
                }
                return false;
            }
            al.a("same crash occur too much do merged!", new Object[0]);
            CrashDetailBean a5 = a((List<ar>) arrayList, crashDetailBean);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ar arVar = (ar) it.next();
                if (arVar.f1316a != a5.f1199a) {
                    list2.add(arVar);
                }
            }
            b(a5);
            d(list2);
            al.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
            return true;
        }
        return false;
    }

    private static boolean a(String str) {
        String str2 = at.f1341r;
        if (str2 != null && !str2.isEmpty()) {
            try {
                al.c("Crash regular filter for crash stack is: %s", at.f1341r);
                if (Pattern.compile(at.f1341r).matcher(str).find()) {
                    al.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                    return true;
                }
            } catch (Exception e5) {
                al.a(e5);
                al.d("Failed to compile " + at.f1341r, new Object[0]);
            }
        }
        return false;
    }

    private static boolean a(CrashDetailBean crashDetailBean, List<ar> list, List<ar> list2) {
        boolean z3 = false;
        for (ar arVar : list) {
            if (crashDetailBean.f1214u.equals(arVar.c)) {
                if (arVar.f1317e) {
                    z3 = true;
                }
                list2.add(arVar);
            }
        }
        return z3;
    }

    public static List<CrashDetailBean> a() {
        StrategyBean c = ac.a().c();
        if (c == null) {
            al.d("have not synced remote!", new Object[0]);
            return null;
        } else if (!c.f1184f) {
            al.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            al.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long b = ap.b();
            List<ar> b5 = b();
            al.c("Size of crash list loaded from DB: %s", Integer.valueOf(b5.size()));
            if (b5.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(a(b5));
            b5.removeAll(arrayList);
            Iterator<ar> it = b5.iterator();
            while (it.hasNext()) {
                ar next = it.next();
                long j2 = next.b;
                if (j2 < b - at.f1334j) {
                    arrayList2.add(next);
                    it.remove();
                    arrayList.add(next);
                } else if (next.d) {
                    if (j2 >= currentTimeMillis - 86400000) {
                        it.remove();
                    } else if (!next.f1317e) {
                        it.remove();
                        arrayList.add(next);
                    }
                } else if (next.f1318f >= 3 && j2 < currentTimeMillis - 86400000) {
                    it.remove();
                    arrayList.add(next);
                }
            }
            b(arrayList2);
            if (arrayList.size() > 0) {
                d(arrayList);
            }
            ArrayList arrayList3 = new ArrayList();
            List<CrashDetailBean> c5 = c(b5);
            if (c5 != null && c5.size() > 0) {
                String str = aa.b().f1247o;
                Iterator<CrashDetailBean> it2 = c5.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean next2 = it2.next();
                    if (!str.equals(next2.f1201f)) {
                        it2.remove();
                        arrayList3.add(next2);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                e(arrayList3);
            }
            return c5;
        }
    }

    public final void a(CrashDetailBean crashDetailBean) {
        int i3 = crashDetailBean.b;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 3 && !at.a().k()) {
                    return;
                }
            } else if (!at.a().j()) {
                return;
            }
        } else if (!at.a().j()) {
            return;
        }
        if (this.f1326f != null) {
            al.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
        }
    }

    public final void a(List<CrashDetailBean> list, long j2, boolean z3, boolean z5, boolean z6) {
        if (!aa.a(this.b).f1238f) {
            al.d("warn: not upload process", new Object[0]);
            return;
        }
        ai aiVar = this.c;
        if (aiVar == null) {
            al.d("warn: upload manager is null", new Object[0]);
        } else if (!z6 && !aiVar.b(at.f1328a)) {
            al.d("warn: not crashHappen or not should upload", new Object[0]);
        } else {
            StrategyBean c = this.f1325e.c();
            if (!c.f1184f) {
                al.d("remote report is disable!", new Object[0]);
                al.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            } else if (list != null && list.size() != 0) {
                try {
                    String str = c.f1195r;
                    String str2 = StrategyBean.b;
                    bp a5 = a(this.b, list, aa.b());
                    if (a5 == null) {
                        al.d("create eupPkg fail!", new Object[0]);
                        return;
                    }
                    byte[] a6 = ae.a((m) a5);
                    if (a6 == null) {
                        al.d("send encode fail!", new Object[0]);
                        return;
                    }
                    bq a7 = ae.a(this.b, 830, a6);
                    if (a7 == null) {
                        al.d("request package is null.", new Object[0]);
                        return;
                    }
                    i0 i0Var = new i0(System.currentTimeMillis(), list, z3);
                    if (z3) {
                        this.c.a(f1319a, a7, str, str2, i0Var, j2, z5);
                    } else {
                        this.c.a(f1319a, a7, str, str2, i0Var, false);
                    }
                } catch (Throwable th) {
                    al.e("req cr error %s", th.toString());
                    if (al.b(th)) {
                        return;
                    }
                    th.printStackTrace();
                }
            } else {
                al.d("warn: crashList is null or crashList num is 0", new Object[0]);
            }
        }
    }

    public static void a(boolean z3, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            al.c("up finish update state %b", Boolean.valueOf(z3));
            for (CrashDetailBean crashDetailBean : list) {
                al.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.c, Integer.valueOf(crashDetailBean.f1207l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.f1205j));
                int i3 = crashDetailBean.f1207l + 1;
                crashDetailBean.f1207l = i3;
                crashDetailBean.d = z3;
                al.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.c, Integer.valueOf(i3), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.f1205j));
            }
            for (CrashDetailBean crashDetailBean2 : list) {
                at.a().a(crashDetailBean2);
            }
            al.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z3) {
            return;
        }
        al.b("[crash] upload fail.", new Object[0]);
    }

    private static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ap.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f1199a = j2;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static bo a(Context context, CrashDetailBean crashDetailBean, aa aaVar) {
        ArrayList<bl> arrayList = null;
        if (context != null && crashDetailBean != null && aaVar != null) {
            bo boVar = new bo();
            boVar.f1409a = e(crashDetailBean);
            boVar.b = crashDetailBean.f1212r;
            boVar.c = crashDetailBean.f1209n;
            boVar.d = crashDetailBean.f1210o;
            boVar.f1410e = crashDetailBean.f1211p;
            boVar.f1412g = crashDetailBean.q;
            boVar.f1413h = crashDetailBean.f1218z;
            boVar.f1414i = crashDetailBean.c;
            boVar.f1415j = null;
            boVar.f1417l = crashDetailBean.f1208m;
            boVar.f1418m = crashDetailBean.f1200e;
            boVar.f1411f = crashDetailBean.B;
            boVar.f1419n = null;
            Map<String, PlugInBean> map = crashDetailBean.f1203h;
            if (map != null && !map.isEmpty()) {
                arrayList = new ArrayList<>(crashDetailBean.f1203h.size());
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f1203h.entrySet()) {
                    bl blVar = new bl();
                    blVar.f1401a = entry.getValue().f1181a;
                    blVar.c = entry.getValue().c;
                    blVar.f1402e = entry.getValue().b;
                    arrayList.add(blVar);
                }
            }
            boVar.f1421p = arrayList;
            al.c("libInfo %s", boVar.f1420o);
            ArrayList<bn> arrayList2 = new ArrayList<>(20);
            a(arrayList2, crashDetailBean);
            a(arrayList2, crashDetailBean.w);
            b(arrayList2, crashDetailBean.f1216x);
            c(arrayList2, crashDetailBean.Z);
            a(arrayList2, crashDetailBean.aa, context);
            a(arrayList2, crashDetailBean.f1217y);
            a(arrayList2, crashDetailBean, context);
            b(arrayList2, crashDetailBean, context);
            a(arrayList2, aaVar.L);
            b(arrayList2, crashDetailBean.Y);
            boVar.q = arrayList2;
            if (crashDetailBean.f1205j) {
                boVar.f1416k = crashDetailBean.f1213t;
            }
            boVar.f1422r = a(crashDetailBean, aaVar);
            boVar.s = new HashMap();
            Map<String, String> map2 = crashDetailBean.S;
            if (map2 != null && map2.size() > 0) {
                boVar.s.putAll(crashDetailBean.S);
                al.a("setted message size %d", Integer.valueOf(boVar.s.size()));
            }
            Map<String, String> map3 = boVar.s;
            al.c("pss:" + crashDetailBean.I + " vss:" + crashDetailBean.J + " javaHeap:" + crashDetailBean.K, new Object[0]);
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.I);
            map3.put("SDK_UPLOAD_U1", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.J);
            map3.put("SDK_UPLOAD_U2", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.K);
            map3.put("SDK_UPLOAD_U3", sb3.toString());
            al.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", crashDetailBean.f1209n, crashDetailBean.c, aaVar.d(), Long.valueOf((crashDetailBean.f1212r - crashDetailBean.Q) / 1000), Boolean.valueOf(crashDetailBean.f1206k), Boolean.valueOf(crashDetailBean.R), Boolean.valueOf(crashDetailBean.f1205j), Boolean.valueOf(crashDetailBean.b == 1), Integer.valueOf(crashDetailBean.f1213t), crashDetailBean.s, Boolean.valueOf(crashDetailBean.d), Integer.valueOf(boVar.f1422r.size()));
            return boVar;
        }
        al.d("enExp args == null", new Object[0]);
        return null;
    }

    private static bp a(Context context, List<CrashDetailBean> list, aa aaVar) {
        if (context != null && list != null && list.size() != 0 && aaVar != null) {
            bp bpVar = new bp();
            bpVar.f1425a = new ArrayList<>();
            for (CrashDetailBean crashDetailBean : list) {
                bpVar.f1425a.add(a(context, crashDetailBean, aaVar));
            }
            return bpVar;
        }
        al.d("enEXPPkg args == null!", new Object[0]);
        return null;
    }

    private static bn a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            al.c("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!ap.a(file, file2)) {
                al.d("zip fail!", new Object[0]);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                al.c("read bytes :%d", Integer.valueOf(byteArray.length));
                bn bnVar = new bn((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    if (!al.a(e5)) {
                        e5.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    al.c("del tmp", new Object[0]);
                    file2.delete();
                }
                return bnVar;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            if (!al.a(e6)) {
                                e6.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        al.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e7) {
                            if (!al.a(e7)) {
                                e7.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        al.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th3;
                }
            }
        }
        al.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
        return null;
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        aa b = aa.b();
        if (b == null) {
            return;
        }
        al.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        al.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        al.e("# PKG NAME: %s", b.c);
        al.e("# APP VER: %s", b.f1247o);
        al.e("# SDK VER: %s", b.f1240h);
        al.e("# LAUNCH TIME: %s", ap.a(new Date(aa.b().f1236a)));
        al.e("# CRASH TYPE: %s", str);
        al.e("# CRASH TIME: %s", str2);
        al.e("# CRASH PROCESS: %s", str3);
        al.e("# CRASH FOREGROUND: %s", Boolean.valueOf(b.a()));
        al.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            al.e("# REPORT ID: %s", crashDetailBean.c);
            al.e("# CRASH DEVICE: %s %s", b.h(), b.r().booleanValue() ? "ROOTED" : "UNROOT");
            al.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            al.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!ap.b(crashDetailBean.O)) {
                al.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.O, crashDetailBean.N);
            } else if (crashDetailBean.b == 3) {
                if (crashDetailBean.T == null) {
                    str6 = "null";
                } else {
                    str6 = crashDetailBean.T.get("BUGLY_CR_01");
                }
                al.e("# EXCEPTION ANR MESSAGE:\n %s", str6);
            }
        }
        if (!ap.b(str5)) {
            al.e("# CRASH STACK: ", new Object[0]);
            al.e(str5, new Object[0]);
        }
        al.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    private static void a(CrashDetailBean crashDetailBean, Map<String, String> map) {
        String value;
        if (map != null && !map.isEmpty()) {
            crashDetailBean.S = new LinkedHashMap(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!ap.b(entry.getKey())) {
                    String key = entry.getKey();
                    if (key.length() > 100) {
                        key = key.substring(0, 100);
                        al.d("setted key length is over limit %d substring to %s", 100, key);
                    }
                    if (!ap.b(entry.getValue()) && entry.getValue().length() > 100000) {
                        value = entry.getValue().substring(entry.getValue().length() - BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                        al.d("setted %s value length is over limit %d substring", key, Integer.valueOf((int) BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH));
                    } else {
                        value = entry.getValue();
                    }
                    crashDetailBean.S.put(key, value);
                    al.a("add setted key %s value size:%d", key, Integer.valueOf(value.length()));
                }
            }
            return;
        }
        al.d("extra map is empty. CrashBean won't have userDatas.", new Object[0]);
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean) {
        String str;
        if (crashDetailBean.f1205j && (str = crashDetailBean.s) != null && str.length() > 0) {
            try {
                arrayList.add(new bn((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes("utf-8")));
            } catch (Exception e5) {
                e5.printStackTrace();
                al.a(e5);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "log.txt", str.getBytes("utf-8")));
            } catch (Exception e5) {
                e5.printStackTrace();
                al.a(e5);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str, Context context) {
        if (str != null) {
            try {
                bn a5 = a("backupRecord.zip", context, str);
                if (a5 != null) {
                    al.c("attach backup record", new Object[0]);
                    arrayList.add(a5);
                }
            } catch (Exception e5) {
                al.a(e5);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 2, "buglylog.zip", bArr);
            al.c("attach user log", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e5) {
            al.a(e5);
        }
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        bn a5;
        if (crashDetailBean.b != 3) {
            return;
        }
        al.c("crashBean.anrMessages:%s", crashDetailBean.T);
        try {
            Map<String, String> map = crashDetailBean.T;
            if (map != null && map.containsKey("BUGLY_CR_01")) {
                if (!TextUtils.isEmpty(crashDetailBean.T.get("BUGLY_CR_01"))) {
                    arrayList.add(new bn((byte) 1, "anrMessage.txt", crashDetailBean.T.get("BUGLY_CR_01").getBytes("utf-8")));
                    al.c("attach anr message", new Object[0]);
                }
                crashDetailBean.T.remove("BUGLY_CR_01");
            }
            String str = crashDetailBean.f1215v;
            if (str == null || (a5 = a("trace.zip", context, str)) == null) {
                return;
            }
            al.c("attach traces", new Object[0]);
            arrayList.add(a5);
        } catch (Exception e5) {
            e5.printStackTrace();
            al.a(e5);
        }
    }

    private static void a(ArrayList<bn> arrayList, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        try {
            arrayList.add(new bn((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
            al.c("attach pageTracingList", new Object[0]);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private static Map<String, String> a(CrashDetailBean crashDetailBean, aa aaVar) {
        HashMap hashMap = new HashMap(30);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.C);
            hashMap.put("A9", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.D);
            hashMap.put("A11", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.E);
            hashMap.put("A10", sb3.toString());
            hashMap.put("A23", crashDetailBean.f1201f);
            aaVar.getClass();
            hashMap.put("A7", "");
            hashMap.put("A6", aa.n());
            hashMap.put("A5", aaVar.m());
            hashMap.put("A22", aaVar.g());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(crashDetailBean.G);
            hashMap.put("A2", sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(crashDetailBean.F);
            hashMap.put("A1", sb5.toString());
            hashMap.put("A24", aaVar.f1243k);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.H);
            hashMap.put("A17", sb6.toString());
            hashMap.put("A25", aaVar.g());
            hashMap.put("A15", aaVar.q());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(aaVar.r());
            hashMap.put("A13", sb7.toString());
            hashMap.put("A34", crashDetailBean.A);
            if (aaVar.G != null) {
                hashMap.put("productIdentify", aaVar.G);
            }
            hashMap.put("A26", URLEncoder.encode(crashDetailBean.L, "utf-8"));
            if (crashDetailBean.b == 1) {
                hashMap.put("A27", crashDetailBean.O);
                hashMap.put("A28", crashDetailBean.N);
                StringBuilder sb8 = new StringBuilder();
                sb8.append(crashDetailBean.f1206k);
                hashMap.put("A29", sb8.toString());
            }
            hashMap.put("A30", crashDetailBean.P);
            StringBuilder sb9 = new StringBuilder();
            sb9.append(crashDetailBean.Q);
            hashMap.put("A18", sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append(true ^ crashDetailBean.R);
            hashMap.put("A36", sb10.toString());
            StringBuilder sb11 = new StringBuilder();
            sb11.append(aaVar.f1255z);
            hashMap.put("F02", sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(aaVar.A);
            hashMap.put("F03", sb12.toString());
            hashMap.put("F04", aaVar.d());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(aaVar.B);
            hashMap.put("F05", sb13.toString());
            hashMap.put("F06", aaVar.f1254y);
            hashMap.put("F08", aaVar.E);
            hashMap.put("F09", aaVar.F);
            StringBuilder sb14 = new StringBuilder();
            sb14.append(aaVar.C);
            hashMap.put("F10", sb14.toString());
            a(hashMap, crashDetailBean);
        } catch (Exception e5) {
            e5.printStackTrace();
            al.a(e5);
        }
        return hashMap;
    }

    private static void a(Map<String, String> map, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.U >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(crashDetailBean.U);
            map.put("C01", sb.toString());
        }
        if (crashDetailBean.V >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.V);
            map.put("C02", sb2.toString());
        }
        Map<String, String> map2 = crashDetailBean.W;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : crashDetailBean.W.entrySet()) {
                map.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = crashDetailBean.X;
        if (map3 == null || map3.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry2 : crashDetailBean.X.entrySet()) {
            map.put("C04_" + entry2.getKey(), entry2.getValue());
        }
    }

    public static /* synthetic */ void a(List list, boolean z3, long j2, String str, String str2) {
        ag agVar;
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CrashDetailBean crashDetailBean = (CrashDetailBean) it.next();
            String str3 = f1324l.get(Integer.valueOf(crashDetailBean.b));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new ag.c(crashDetailBean.c, str3, crashDetailBean.f1212r, z3, j2, str, str2));
            }
        }
        agVar = ag.a.f1266a;
        agVar.a(arrayList);
    }
}
