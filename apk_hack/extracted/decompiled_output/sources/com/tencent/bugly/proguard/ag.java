package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ag {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleDateFormat f1265a;
    private final ad b;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final ag f1266a = new ag((byte) 0);
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        String f1267a;
        public long b;
        public String c;

        public final String toString() {
            StringBuilder sb = new StringBuilder("SLAData{uuid='");
            sb.append(this.f1267a);
            sb.append("', time=");
            sb.append(this.b);
            sb.append(", data='");
            return a1.i.k(sb, this.c, "'}");
        }
    }

    public /* synthetic */ ag(byte b5) {
        this();
    }

    public static void c(List<b> list) {
        if (list != null && !list.isEmpty()) {
            al.c("sla batch report list size:%s", Integer.valueOf(list.size()));
            if (list.size() > 30) {
                list = list.subList(0, 29);
            }
            ArrayList arrayList = new ArrayList();
            for (b bVar : list) {
                arrayList.add(bVar.c);
            }
            Pair<Integer, String> a5 = ad.a(arrayList);
            al.c("sla batch report result, rspCode:%s rspMsg:%s", a5.first, a5.second);
            if (((Integer) a5.first).intValue() == 200) {
                d(list);
                return;
            }
            return;
        }
        al.c("sla batch report data is empty", new Object[0]);
    }

    public static void d(List<b> list) {
        if (list != null && !list.isEmpty()) {
            al.c("sla batch delete list size:%s", Integer.valueOf(list.size()));
            try {
                String str = "_id in (" + a(",", list) + ")";
                al.c("sla batch delete where:%s", str);
                w.a().a("t_sla", str);
                return;
            } catch (Throwable th) {
                al.b(th);
                return;
            }
        }
        al.c("sla batch delete list is null", new Object[0]);
    }

    private static void e(List<b> list) {
        for (b bVar : list) {
            al.c("sla save id:%s time:%s msg:%s", bVar.f1267a, Long.valueOf(bVar.b), bVar.c);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", bVar.f1267a);
                contentValues.put("_tm", Long.valueOf(bVar.b));
                contentValues.put("_dt", bVar.c);
                w.a().a("t_sla", contentValues, (v) null);
            } catch (Throwable th) {
                al.b(th);
            }
        }
    }

    public final void a(List<c> list) {
        if (list != null && !list.isEmpty()) {
            al.c("sla batch report event size:%s", Integer.valueOf(list.size()));
            ArrayList arrayList = new ArrayList();
            for (c cVar : list) {
                b b5 = b(cVar);
                if (b5 != null) {
                    arrayList.add(b5);
                }
            }
            e(arrayList);
            b(arrayList);
            return;
        }
        al.d("sla batch report event is null", new Object[0]);
    }

    public final void b(List<b> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ak.a().a(new b3.d(3, list));
        } else {
            c(list);
        }
    }

    private ag() {
        this.f1265a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.b = new ad();
    }

    private b b(c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.b)) {
            aa b5 = aa.b();
            if (b5 == null) {
                al.d("sla convert failed because ComInfoManager is null", new Object[0]);
                return null;
            }
            StringBuilder sb = new StringBuilder("&app_version=");
            sb.append(b5.f1247o);
            sb.append("&app_name=");
            sb.append(b5.q);
            sb.append("&app_bundle_id=");
            sb.append(b5.c);
            sb.append("&client_type=android&user_id=");
            sb.append(b5.f());
            sb.append("&sdk_version=");
            sb.append(b5.f1240h);
            sb.append("&event_code=");
            sb.append(cVar.b);
            sb.append("&event_result=");
            sb.append(cVar.d ? 1 : 0);
            sb.append("&event_time=");
            sb.append(this.f1265a.format(new Date(cVar.c)));
            sb.append("&event_cost=");
            sb.append(cVar.f1269e);
            sb.append("&device_id=");
            sb.append(b5.g());
            sb.append("&debug=");
            sb.append(b5.D ? 1 : 0);
            sb.append("&param_0=");
            sb.append(cVar.f1270f);
            sb.append("&param_1=");
            sb.append(cVar.f1268a);
            sb.append("&param_2=");
            sb.append(b5.M ? "rqd" : "ext");
            sb.append("&param_4=");
            sb.append(b5.e());
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(cVar.f1271g)) {
                StringBuilder o5 = a1.i.o(sb2, "&param_3=");
                o5.append(cVar.f1271g);
                sb2 = o5.toString();
            }
            al.c("sla convert eventId:%s eventType:%s, eventTime:%s success:%s cost:%s from:%s uploadMsg:", cVar.f1268a, cVar.b, Long.valueOf(cVar.c), Boolean.valueOf(cVar.d), Long.valueOf(cVar.f1269e), cVar.f1270f, cVar.f1271g);
            b bVar = new b();
            bVar.f1267a = cVar.f1268a + "-" + cVar.b;
            bVar.b = cVar.c;
            bVar.c = sb2;
            return bVar;
        }
        al.d("sla convert event is null", new Object[0]);
        return null;
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        String f1268a;
        String b;
        long c;
        boolean d;

        /* renamed from: e  reason: collision with root package name */
        long f1269e;

        /* renamed from: f  reason: collision with root package name */
        String f1270f;

        /* renamed from: g  reason: collision with root package name */
        String f1271g;

        public c(String str, String str2, long j2, boolean z3, long j5, String str3, String str4) {
            this.f1268a = str;
            this.b = str2;
            this.c = j2;
            this.d = z3;
            this.f1269e = j5;
            this.f1270f = str3;
            this.f1271g = str4;
        }

        public c() {
        }
    }

    private static String a(String str, Iterable<b> iterable) {
        Iterator<b> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder("'");
        sb.append(it.next().f1267a);
        sb.append("'");
        while (it.hasNext()) {
            sb.append(str);
            sb.append("'");
            sb.append(it.next().f1267a);
            sb.append("'");
        }
        return sb.toString();
    }

    public static List<b> a() {
        Cursor a5 = w.a().a("t_sla", new String[]{"_id", "_tm", "_dt"}, (String) null, "_tm", "30");
        if (a5 == null) {
            return null;
        }
        if (a5.getCount() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (a5.moveToNext()) {
            try {
                b bVar = new b();
                bVar.f1267a = a5.getString(a5.getColumnIndex("_id"));
                bVar.b = a5.getLong(a5.getColumnIndex("_tm"));
                bVar.c = a5.getString(a5.getColumnIndex("_dt"));
                al.c(bVar.toString(), new Object[0]);
                arrayList.add(bVar);
            } catch (Throwable th) {
                try {
                    al.b(th);
                } finally {
                    a5.close();
                }
            }
        }
        return arrayList;
    }

    public final void a(c cVar) {
        if (TextUtils.isEmpty(cVar.b)) {
            al.d("sla report event is null", new Object[0]);
            return;
        }
        al.c("sla report single event", new Object[0]);
        a(Collections.singletonList(cVar));
    }
}
