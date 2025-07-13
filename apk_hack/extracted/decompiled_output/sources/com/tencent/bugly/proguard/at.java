package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class at {
    private static at D = null;

    /* renamed from: a */
    public static int f1328a = 0;
    public static boolean b = false;
    public static int d = 2;

    /* renamed from: e */
    public static boolean f1329e = false;

    /* renamed from: f */
    public static int f1330f = 20480;

    /* renamed from: g */
    public static int f1331g = 3000;

    /* renamed from: h */
    public static int f1332h = 20480;

    /* renamed from: i */
    public static long f1333i = 209715200;

    /* renamed from: j */
    public static long f1334j = 604800000;

    /* renamed from: k */
    public static String f1335k = null;

    /* renamed from: l */
    public static boolean f1336l = false;

    /* renamed from: m */
    public static String f1337m = null;

    /* renamed from: n */
    public static int f1338n = 5000;

    /* renamed from: o */
    public static boolean f1339o = true;

    /* renamed from: p */
    public static boolean f1340p = false;
    public static String q;

    /* renamed from: r */
    public static String f1341r;
    public Boolean A;
    public int B = 31;
    public boolean C = false;
    public final Context c;
    public final as s;

    /* renamed from: t */
    public final av f1342t;

    /* renamed from: u */
    public final NativeCrashHandler f1343u;

    /* renamed from: v */
    public final ac f1344v;
    public final ak w;

    /* renamed from: x */
    public final ay f1345x;

    /* renamed from: y */
    public BuglyStrategy.a f1346y;

    /* renamed from: z */
    public aw f1347z;

    private at(Context context, ak akVar, boolean z3, BuglyStrategy.a aVar) {
        f1328a = 1004;
        Context a5 = ap.a(context);
        this.c = a5;
        ac a6 = ac.a();
        this.f1344v = a6;
        this.w = akVar;
        this.f1346y = aVar;
        this.f1347z = null;
        as asVar = new as(a5, ai.a(), w.a(), a6, aVar);
        this.s = asVar;
        aa a7 = aa.a(a5);
        this.f1342t = new av(a5, asVar, a6, a7);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(a5, a7, asVar, a6, akVar, z3, null);
        this.f1343u = nativeCrashHandler;
        a7.N = nativeCrashHandler;
        if (ay.f1366f == null) {
            ay.f1366f = new ay(a5, a6, a7, akVar, asVar);
        }
        this.f1345x = ay.f1366f;
    }

    public final synchronized void c() {
        this.f1342t.b();
        d();
        g();
    }

    public final void d() {
        this.f1343u.setUserOpened(false);
    }

    public final void e() {
        this.f1343u.setUserOpened(true);
    }

    public final void f() {
        new Handler(Looper.getMainLooper()).post(new k0(0));
        this.f1345x.b(true);
    }

    public final void g() {
        new Handler(Looper.getMainLooper()).post(new k0(1));
        this.f1345x.b(false);
    }

    public final synchronized void h() {
        int i3 = 0;
        while (true) {
            int i5 = i3 + 1;
            if (i3 < 30) {
                try {
                    al.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i5));
                    ap.b(5000L);
                    i3 = i5;
                } catch (Throwable th) {
                    if (!al.a(th)) {
                        th.printStackTrace();
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final boolean i() {
        return this.f1345x.f1367a.get();
    }

    public final boolean j() {
        if ((this.B & 16) > 0) {
            return true;
        }
        return false;
    }

    public final boolean k() {
        if ((this.B & 8) > 0) {
            return true;
        }
        return false;
    }

    public static synchronized at a(Context context, boolean z3, BuglyStrategy.a aVar) {
        at atVar;
        synchronized (at.class) {
            try {
                if (D == null) {
                    D = new at(context, ak.a(), z3, aVar);
                }
                atVar = D;
            } catch (Throwable th) {
                throw th;
            }
        }
        return atVar;
    }

    public final synchronized void b() {
        this.f1342t.a();
        e();
        f();
    }

    public static synchronized at a() {
        at atVar;
        synchronized (at.class) {
            atVar = D;
        }
        return atVar;
    }

    public final synchronized void a(boolean z3, boolean z5, boolean z6) {
        this.f1343u.testNativeCrash(z3, z5, z6);
    }

    public final void a(CrashDetailBean crashDetailBean) {
        this.s.b(crashDetailBean);
    }

    public final void a(long j2) {
        ak.a().a(new l0(0, this), j2);
    }
}
