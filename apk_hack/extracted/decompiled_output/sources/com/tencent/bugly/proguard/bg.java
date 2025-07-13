package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class bg extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public bf f1396a;

    /* renamed from: g  reason: collision with root package name */
    private a f1399g;
    private boolean c = false;
    private boolean d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1397e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f1398f = 1;
    public boolean b = true;

    /* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
    public interface a {
    }

    public final boolean a() {
        this.c = true;
        if (isAlive()) {
            try {
                interrupt();
            } catch (Exception e5) {
                al.b(e5);
            }
            al.d("MainHandlerChecker is reset to null.", new Object[0]);
            this.f1396a = null;
            return true;
        }
        return false;
    }

    public final boolean b() {
        Handler handler = new Handler(Looper.getMainLooper());
        bf bfVar = this.f1396a;
        if (bfVar != null) {
            bfVar.b = 5000L;
        } else {
            this.f1396a = new bf(handler, handler.getLooper().getThread().getName());
        }
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e5) {
            al.b(e5);
            return false;
        }
    }

    public final synchronized void c() {
        this.d = false;
        al.c("Record stack trace is disabled.", new Object[0]);
    }

    public final synchronized void d() {
        this.f1397e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0073, code lost:
        r2.d();
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
        L4:
            boolean r2 = r10.c
            if (r2 != 0) goto L9c
            com.tencent.bugly.proguard.bf r2 = r10.f1396a     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r3 = 0
            if (r2 != 0) goto L1b
            java.lang.String r2 = "Main handler checker is null. Stop thread monitor."
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            com.tencent.bugly.proguard.al.c(r2, r3)     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            return
        L15:
            r2 = move-exception
            goto L92
        L18:
            r2 = move-exception
            goto L97
        L1b:
            boolean r4 = r2.c     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            if (r4 == 0) goto L2c
            r2.c = r3     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            long r4 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r2.d = r4     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            android.os.Handler r4 = r2.f1392a     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r4.post(r2)     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
        L2c:
            r10.a(r2)     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            boolean r4 = r10.b     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            if (r4 == 0) goto L71
            boolean r4 = r10.d     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            if (r4 != 0) goto L38
            goto L71
        L38:
            long r4 = r2.b()     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r6 = 1510(0x5e6, double:7.46E-321)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L71
            r6 = 199990(0x30d36, double:9.8808E-319)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L4a
            goto L71
        L4a:
            r6 = 5010(0x1392, double:2.4753E-320)
            r8 = 1
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 > 0) goto L5c
            r10.f1398f = r8     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            java.lang.String r4 = "timeSinceMsgSent in [2s, 5s], record stack"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            com.tencent.bugly.proguard.al.c(r4, r3)     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r3 = 1
            goto L71
        L5c:
            int r4 = r10.f1398f     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            int r5 = r4 + 1
            r10.f1398f = r5     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r4 = r4 & r5
            if (r4 != 0) goto L66
            goto L67
        L66:
            r8 = 0
        L67:
            if (r8 == 0) goto L70
            java.lang.String r4 = "timeSinceMsgSent in (5s, 200s), should record stack:true"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            com.tencent.bugly.proguard.al.c(r4, r3)     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
        L70:
            r3 = r8
        L71:
            if (r3 == 0) goto L76
            r2.d()     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
        L76:
            com.tencent.bugly.proguard.bg$a r3 = r10.f1399g     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            if (r3 == 0) goto L84
            boolean r3 = r10.d     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            if (r3 == 0) goto L84
            r2.a()     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            r2.b()     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
        L84:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            long r2 = r2 - r0
            r4 = 500(0x1f4, double:2.47E-321)
            long r2 = r2 % r4
            long r4 = r4 - r2
            com.tencent.bugly.proguard.ap.b(r4)     // Catch: java.lang.OutOfMemoryError -> L15 java.lang.Exception -> L18
            goto L4
        L92:
            com.tencent.bugly.proguard.al.b(r2)
            goto L4
        L97:
            com.tencent.bugly.proguard.al.b(r2)
            goto L4
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.bg.run():void");
    }

    private synchronized void a(bf bfVar) {
        if (this.d) {
            return;
        }
        if (this.f1397e && !bfVar.a()) {
            al.c("Restart getting main stack trace.", new Object[0]);
            this.d = true;
            this.f1397e = false;
        }
    }
}
