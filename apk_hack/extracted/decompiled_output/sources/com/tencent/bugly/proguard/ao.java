package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ao {

    /* renamed from: a */
    public static boolean f1298a = true;
    public static boolean b = true;
    private static SimpleDateFormat c = null;
    private static int d = 30720;

    /* renamed from: e */
    private static StringBuilder f1299e = null;

    /* renamed from: f */
    private static StringBuilder f1300f = null;

    /* renamed from: g */
    private static boolean f1301g = false;

    /* renamed from: h */
    private static a f1302h = null;

    /* renamed from: i */
    private static String f1303i = null;

    /* renamed from: j */
    private static String f1304j = null;

    /* renamed from: k */
    private static Context f1305k = null;

    /* renamed from: l */
    private static String f1306l = null;

    /* renamed from: m */
    private static boolean f1307m = false;

    /* renamed from: n */
    private static boolean f1308n = false;

    /* renamed from: o */
    private static ExecutorService f1309o;

    /* renamed from: p */
    private static int f1310p;
    private static final Object q = new Object();

    static {
        try {
            c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            al.b(th.getCause());
        }
    }

    public static synchronized void a(Context context) {
        synchronized (ao.class) {
            if (f1307m || context == null || !b) {
                return;
            }
            try {
                f1309o = Executors.newSingleThreadExecutor();
                f1300f = new StringBuilder(0);
                f1299e = new StringBuilder(0);
                f1305k = context;
                f1303i = aa.a(context).d;
                f1304j = "";
                f1306l = f1305k.getFilesDir().getPath() + "/buglylog_" + f1303i + "_" + f1304j + ".txt";
                f1310p = Process.myPid();
            } catch (Throwable unused) {
            }
            f1307m = true;
        }
    }

    public static boolean d(String str, String str2, String str3) {
        q qVar;
        try {
            aa b5 = aa.b();
            if (b5 != null && (qVar = b5.N) != null) {
                return qVar.appendLogToNative(str, str2, str3);
            }
            return false;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static synchronized void e(String str, String str2, String str3) {
        synchronized (ao.class) {
            if (f1298a) {
                f(str, str2, str3);
            } else {
                g(str, str2, str3);
            }
        }
    }

    private static synchronized void f(String str, String str2, String str3) {
        synchronized (ao.class) {
            String a5 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                f1300f.append(a5);
                if (f1300f.length() >= d) {
                    StringBuilder sb = f1300f;
                    f1300f = sb.delete(0, sb.indexOf("\u0001\r\n") + 1);
                }
            }
        }
    }

    private static synchronized void g(String str, String str2, String str3) {
        synchronized (ao.class) {
            String a5 = a(str, str2, str3, Process.myTid());
            synchronized (q) {
                try {
                    f1300f.append(a5);
                } catch (Throwable unused) {
                }
                if (f1300f.length() <= d) {
                    return;
                }
                if (f1301g) {
                    return;
                }
                f1301g = true;
                a aVar = f1302h;
                if (aVar == null) {
                    f1302h = new a(f1306l);
                } else {
                    File file = aVar.b;
                    if (file == null || file.length() + f1300f.length() > f1302h.c) {
                        f1302h.a();
                    }
                }
                if (f1302h.a(f1300f.toString())) {
                    f1300f.setLength(0);
                    f1301g = false;
                }
            }
        }
    }

    private static String b() {
        q qVar;
        try {
            aa b5 = aa.b();
            if (b5 == null || (qVar = b5.N) == null) {
                return null;
            }
            return qVar.getLogFromNative();
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] c() {
        File file;
        if (b) {
            if (f1308n) {
                al.a("[LogUtil] Get user log from native.", new Object[0]);
                String b5 = b();
                if (b5 != null) {
                    al.a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(b5.length()));
                    return ap.a(b5, "BuglyNativeLog.txt");
                }
            }
            StringBuilder sb = new StringBuilder();
            synchronized (q) {
                try {
                    a aVar = f1302h;
                    if (aVar != null && aVar.f1311a && (file = aVar.b) != null && file.length() > 0) {
                        sb.append(ap.a(f1302h.b, 30720, true));
                    }
                    StringBuilder sb2 = f1300f;
                    if (sb2 != null && sb2.length() > 0) {
                        sb.append(f1300f.toString());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return ap.a(sb.toString(), "BuglyLog.txt");
        }
        return null;
    }

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public static class a {

        /* renamed from: a */
        boolean f1311a;
        File b;
        long c = 30720;
        private String d;

        /* renamed from: e */
        private long f1312e;

        public a(String str) {
            if (str != null && !str.equals("")) {
                this.d = str;
                this.f1311a = a();
            }
        }

        public final boolean a() {
            try {
                File file = new File(this.d);
                this.b = file;
                if (file.exists() && !this.b.delete()) {
                    this.f1311a = false;
                    return false;
                } else if (this.b.createNewFile()) {
                    return true;
                } else {
                    this.f1311a = false;
                    return false;
                }
            } catch (Throwable th) {
                al.a(th);
                this.f1311a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            byte[] bytes;
            if (!this.f1311a) {
                return false;
            }
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.b, true);
                try {
                    fileOutputStream2.write(str.getBytes("UTF-8"));
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    this.f1312e += bytes.length;
                    this.f1311a = true;
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        al.a(th);
                        this.f1311a = false;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static void a(int i3) {
        synchronized (q) {
            try {
                d = i3;
                if (i3 < 0) {
                    d = 0;
                } else if (i3 > 30720) {
                    d = 30720;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + ap.b(th));
    }

    public static synchronized void a(String str, String str2, String str3) {
        synchronized (ao.class) {
            if (f1307m && b) {
                try {
                    if (f1308n) {
                        f1309o.execute(new g0(str, str2, str3, 0));
                    } else {
                        f1309o.execute(new g0(str, str2, str3, 1));
                    }
                } catch (Exception e5) {
                    al.b(e5);
                }
            }
        }
    }

    private static String a(String str, String str2, String str3, long j2) {
        String date;
        f1299e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = c;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb = f1299e;
        sb.append(date);
        sb.append(" ");
        sb.append(f1310p);
        sb.append(" ");
        sb.append(j2);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str3);
        sb.append("\u0001\r\n");
        return f1299e.toString();
    }

    public static byte[] a() {
        if (f1298a) {
            if (b) {
                return ap.a(f1300f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return c();
    }
}
