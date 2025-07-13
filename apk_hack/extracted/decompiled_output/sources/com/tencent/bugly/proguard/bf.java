package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final Handler f1392a;
    long d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1393e;

    /* renamed from: f  reason: collision with root package name */
    private final List<ba> f1394f = new LinkedList();
    long b = 5000;

    /* renamed from: g  reason: collision with root package name */
    private final long f1395g = 5000;
    boolean c = true;

    public bf(Handler handler, String str) {
        this.f1392a = handler;
        this.f1393e = str;
    }

    private Thread e() {
        return this.f1392a.getLooper().getThread();
    }

    public final boolean a() {
        if (!this.c && SystemClock.uptimeMillis() >= this.d + this.b) {
            return true;
        }
        return false;
    }

    public final long b() {
        return SystemClock.uptimeMillis() - this.d;
    }

    public final List<ba> c() {
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f1394f) {
            try {
                arrayList = new ArrayList(this.f1394f.size());
                for (int i3 = 0; i3 < this.f1394f.size(); i3++) {
                    ba baVar = this.f1394f.get(i3);
                    if (!baVar.f1380e && currentTimeMillis - baVar.b < 200000) {
                        arrayList.add(baVar);
                        baVar.f1380e = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final void d() {
        StringBuilder sb = new StringBuilder(1024);
        long nanoTime = System.nanoTime();
        try {
            StackTraceElement[] stackTrace = e().getStackTrace();
            if (stackTrace.length == 0) {
                sb.append("Thread does not have stack trace.\n");
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement);
                    sb.append("\n");
                }
            }
        } catch (SecurityException e5) {
            sb.append("getStackTrace() encountered:\n");
            sb.append(e5.getMessage());
            sb.append("\n");
            al.a(e5);
        }
        long nanoTime2 = System.nanoTime();
        ba baVar = new ba(sb.toString(), System.currentTimeMillis());
        baVar.d = nanoTime2 - nanoTime;
        String name = e().getName();
        if (name == null) {
            name = "";
        }
        baVar.f1379a = name;
        synchronized (this.f1394f) {
            while (this.f1394f.size() >= 32) {
                try {
                    this.f1394f.remove(0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.f1394f.add(baVar);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c = true;
        this.b = this.f1395g;
    }
}
