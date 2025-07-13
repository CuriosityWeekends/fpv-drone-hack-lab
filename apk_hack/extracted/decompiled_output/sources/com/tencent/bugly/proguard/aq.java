package com.tencent.bugly.proguard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class aq extends BroadcastReceiver {
    private static aq d;
    private Context b;
    private String c;

    /* renamed from: e */
    private boolean f1315e = true;

    /* renamed from: a */
    private IntentFilter f1314a = new IntentFilter();

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized aq a() {
        aq aqVar;
        synchronized (aq.class) {
            try {
                if (d == null) {
                    d = new aq();
                }
                aqVar = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aqVar;
    }

    public final synchronized void b(Context context) {
        try {
            al.a(aq.class, "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.b = context;
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final synchronized void a(String str) {
        try {
            if (!this.f1314a.hasAction(str)) {
                this.f1314a.addAction(str);
            }
            al.c("add action %s", str);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(Context context) {
        this.b = context;
        ap.a(new c0(1, this, this));
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f1315e) {
                    this.f1315e = false;
                    return true;
                }
                String c = ab.c(this.b);
                al.c("is Connect BC ".concat(String.valueOf(c)), new Object[0]);
                al.a("network %s changed to %s", this.c, String.valueOf(c));
                if (c == null) {
                    this.c = null;
                    return true;
                }
                String str = this.c;
                this.c = c;
                long currentTimeMillis = System.currentTimeMillis();
                ac a5 = ac.a();
                ai a6 = ai.a();
                aa a7 = aa.a(context);
                if (a5 != null && a6 != null && a7 != null) {
                    if (!c.equals(str) && currentTimeMillis - a6.a(at.f1328a) > 30000) {
                        al.a("try to upload crash on network changed.", new Object[0]);
                        at a8 = at.a();
                        if (a8 != null) {
                            a8.a(0L);
                        }
                        al.a("try to upload userinfo on network changed.", new Object[0]);
                        s.b.b();
                    }
                    return true;
                }
                al.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
