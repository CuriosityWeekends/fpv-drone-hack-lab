package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import java.lang.Thread;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class av implements Thread.UncaughtExceptionHandler {

    /* renamed from: h  reason: collision with root package name */
    private static String f1355h;

    /* renamed from: i  reason: collision with root package name */
    private static final Object f1356i = new Object();

    /* renamed from: a  reason: collision with root package name */
    protected final Context f1357a;
    protected final as b;
    protected final ac c;
    protected final aa d;

    /* renamed from: e  reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f1358e;

    /* renamed from: f  reason: collision with root package name */
    protected Thread.UncaughtExceptionHandler f1359f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f1360g = false;

    /* renamed from: j  reason: collision with root package name */
    private int f1361j;

    public av(Context context, as asVar, ac acVar, aa aaVar) {
        this.f1357a = context;
        this.b = asVar;
        this.c = acVar;
        this.d = aaVar;
    }

    private static void c() {
        al.e("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public final synchronized void a() {
        if (this.f1361j >= 10) {
            al.a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f1360g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (av.class.getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                al.a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f1359f = defaultUncaughtExceptionHandler;
                this.f1358e = defaultUncaughtExceptionHandler;
            } else {
                al.a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f1358e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f1361j++;
        al.a("registered java monitor: %s", toString());
    }

    public final synchronized void b() {
        this.f1360g = false;
        al.a("close java monitor!", new Object[0]);
        if ("bugly".equals(Thread.getDefaultUncaughtExceptionHandler().getClass().getName())) {
            al.a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f1358e);
            this.f1361j--;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f1356i) {
            a(thread, th, true, null, null, this.d.Q);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0111 A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:23:0x00fc, B:30:0x0109, B:35:0x0111, B:37:0x011f, B:38:0x0121), top: B:42:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011f A[Catch: all -> 0x0104, TryCatch #0 {all -> 0x0104, blocks: (B:23:0x00fc, B:30:0x0109, B:35:0x0111, B:37:0x011f, B:38:0x0121), top: B:42:0x00fc }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.tencent.bugly.crashreport.crash.CrashDetailBean b(java.lang.Thread r6, java.lang.Throwable r7, boolean r8, java.lang.String r9, byte[] r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.av.b(java.lang.Thread, java.lang.Throwable, boolean, java.lang.String, byte[], boolean):com.tencent.bugly.crashreport.crash.CrashDetailBean");
    }

    private static void a(CrashDetailBean crashDetailBean, Throwable th, boolean z3) {
        String a5;
        String name = th.getClass().getName();
        String a6 = a(th);
        al.e("stack frame :%d, has cause %b", Integer.valueOf(th.getStackTrace().length), Boolean.valueOf(th.getCause() != null));
        String str = "";
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 != null && th2 != th) {
            crashDetailBean.f1209n = th2.getClass().getName();
            crashDetailBean.f1210o = a(th2);
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.f1211p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(a6);
            sb.append("\n");
            sb.append(stackTraceElement);
            sb.append("\n......\nCaused by:\n");
            sb.append(crashDetailBean.f1209n);
            sb.append(":");
            sb.append(crashDetailBean.f1210o);
            sb.append("\n");
            a5 = a(th2, at.f1332h);
            sb.append(a5);
            crashDetailBean.q = sb.toString();
        } else {
            crashDetailBean.f1209n = name;
            if (at.a().i() && z3) {
                al.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
                str = " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]";
            }
            crashDetailBean.f1210o = a1.i.h(a6, str);
            crashDetailBean.f1211p = stackTraceElement;
            a5 = a(th, at.f1332h);
            crashDetailBean.q = a5;
        }
        crashDetailBean.f1214u = ap.c(crashDetailBean.q.getBytes());
        crashDetailBean.f1218z.put(crashDetailBean.B, a5);
    }

    private static boolean a(Thread thread) {
        synchronized (f1356i) {
            try {
                if (f1355h != null && thread.getName().equals(f1355h)) {
                    return true;
                }
                f1355h = thread.getName();
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(Thread thread, Throwable th, boolean z3, String str, byte[] bArr, boolean z5) {
        if (z3) {
            al.e("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (a(thread)) {
                al.a("this class has handled this exception", new Object[0]);
                if (this.f1359f != null) {
                    al.a("call system handler", new Object[0]);
                    this.f1359f.uncaughtException(thread, th);
                } else {
                    c();
                }
            }
        } else {
            al.e("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.f1360g) {
                al.c("Java crash handler is disable. Just return.", new Object[0]);
                if (z3) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f1358e;
                    if (uncaughtExceptionHandler != null && a(uncaughtExceptionHandler)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f1358e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f1359f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f1359f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.c.b()) {
                al.d("no remote but still store!", new Object[0]);
            }
            if (!this.c.c().f1184f && this.c.b()) {
                al.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                as.a(z3 ? "JAVA_CRASH" : "JAVA_CATCH", ap.a(), this.d.d, thread.getName(), ap.a(th), null);
                if (z3) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f1358e;
                    if (uncaughtExceptionHandler2 != null && a(uncaughtExceptionHandler2)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f1358e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f1359f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f1359f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean b = b(thread, th, z3, str, bArr, z5);
            if (b == null) {
                al.e("pkg crash datas fail!", new Object[0]);
                if (z3) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f1358e;
                    if (uncaughtExceptionHandler3 != null && a(uncaughtExceptionHandler3)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f1358e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.f1359f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f1359f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                        return;
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            as.a(z3 ? "JAVA_CRASH" : "JAVA_CATCH", ap.a(), this.d.d, thread.getName(), ap.a(th), b);
            if (!this.b.a(b, z3)) {
                this.b.b(b, z3);
            }
            if (z3) {
                this.b.a(b);
            }
            if (z3) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.f1358e;
                if (uncaughtExceptionHandler4 != null && a(uncaughtExceptionHandler4)) {
                    al.e("sys default last handle start!", new Object[0]);
                    this.f1358e.uncaughtException(thread, th);
                    al.e("sys default last handle end!", new Object[0]);
                } else if (this.f1359f != null) {
                    al.e("system handle start!", new Object[0]);
                    this.f1359f.uncaughtException(thread, th);
                    al.e("system handle end!", new Object[0]);
                } else {
                    al.e("crashreport last handle start!", new Object[0]);
                    c();
                    al.e("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!al.a(th2)) {
                    th2.printStackTrace();
                }
                if (z3) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.f1358e;
                    if (uncaughtExceptionHandler5 != null && a(uncaughtExceptionHandler5)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f1358e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                    } else if (this.f1359f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f1359f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z3) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.f1358e;
                    if (uncaughtExceptionHandler6 != null && a(uncaughtExceptionHandler6)) {
                        al.e("sys default last handle start!", new Object[0]);
                        this.f1358e.uncaughtException(thread, th);
                        al.e("sys default last handle end!", new Object[0]);
                    } else if (this.f1359f != null) {
                        al.e("system handle start!", new Object[0]);
                        this.f1359f.uncaughtException(thread, th);
                        al.e("system handle end!", new Object[0]);
                    } else {
                        al.e("crashreport last handle start!", new Object[0]);
                        c();
                        al.e("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    private static boolean a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        StackTraceElement[] stackTrace;
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z3 = strategyBean.f1184f;
            if (z3 != this.f1360g) {
                al.a("java changed to %b", Boolean.valueOf(z3));
                if (strategyBean.f1184f) {
                    a();
                    return;
                }
                b();
            }
        }
    }

    private static String a(Throwable th, int i3) {
        StackTraceElement[] stackTrace;
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i3 > 0 && sb.length() >= i3) {
                        sb.append("\n[Stack over limit size :" + i3 + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Throwable th2) {
            al.e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    private static String a(Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            return "";
        }
        if (message.length() <= 1000) {
            return message;
        }
        return message.substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}
