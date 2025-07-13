package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class ai {
    private static ai b;

    /* renamed from: a  reason: collision with root package name */
    public ah f1272a;
    private final Context d;

    /* renamed from: f  reason: collision with root package name */
    private long f1274f;

    /* renamed from: g  reason: collision with root package name */
    private long f1275g;

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, Long> f1273e = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f1276h = new LinkedBlockingQueue<>();

    /* renamed from: i  reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f1277i = new LinkedBlockingQueue<>();

    /* renamed from: j  reason: collision with root package name */
    private final Object f1278j = new Object();

    /* renamed from: k  reason: collision with root package name */
    private long f1279k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f1280l = 0;
    private final w c = w.a();

    private ai(Context context) {
        this.d = context;
    }

    public static /* synthetic */ int b(ai aiVar) {
        int i3 = aiVar.f1280l - 1;
        aiVar.f1280l = i3;
        return i3;
    }

    public static synchronized ai a(Context context) {
        ai aiVar;
        synchronized (ai.class) {
            try {
                if (b == null) {
                    b = new ai(context);
                }
                aiVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aiVar;
    }

    public final boolean b(int i3) {
        if (p.c) {
            al.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - a(i3);
        al.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i3));
        if (currentTimeMillis < 30000) {
            al.a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
            return false;
        }
        return true;
    }

    public static synchronized ai a() {
        ai aiVar;
        synchronized (ai.class) {
            aiVar = b;
        }
        return aiVar;
    }

    public final void a(int i3, bq bqVar, String str, String str2, ah ahVar, long j2, boolean z3) {
        try {
            try {
                a(new aj(this.d, i3, bqVar.f1431g, ae.a((Object) bqVar), str, str2, ahVar, z3), true, true, j2);
            } catch (Throwable th) {
                th = th;
                if (al.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void b() {
        ak a5 = ak.a();
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.f1278j) {
            try {
                al.c("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                int size = this.f1276h.size();
                int size2 = this.f1277i.size();
                if (size == 0 && size2 == 0) {
                    al.c("[UploadManager] There is no upload task in queue.", new Object[0]);
                    return;
                }
                size2 = (a5 == null || !a5.c()) ? 0 : 0;
                a(this.f1276h, linkedBlockingQueue, size);
                a(this.f1277i, linkedBlockingQueue2, size2);
                a(size, linkedBlockingQueue);
                if (size2 > 0) {
                    al.c("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                }
                ak a6 = ak.a();
                if (a6 != null) {
                    a6.a(new d0(size2, linkedBlockingQueue2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void a(int i3, int i5, byte[] bArr, String str, String str2, ah ahVar, boolean z3) {
        try {
            try {
                a(new aj(this.d, i3, i5, bArr, str, str2, ahVar, 0, 0, false), z3, false, 0L);
            } catch (Throwable th) {
                th = th;
                if (al.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void a(int i3, bq bqVar, String str, String str2, ah ahVar, boolean z3) {
        a(i3, bqVar.f1431g, ae.a((Object) bqVar), str, str2, ahVar, z3);
    }

    public final long a(boolean z3) {
        long j2;
        long b5 = ap.b();
        int i3 = z3 ? 5 : 3;
        List<y> a5 = this.c.a(i3);
        if (a5 != null && a5.size() > 0) {
            j2 = 0;
            try {
                y yVar = a5.get(0);
                if (yVar.f1545e >= b5) {
                    j2 = ap.d(yVar.f1547g);
                    if (i3 == 3) {
                        this.f1274f = j2;
                    } else {
                        this.f1275g = j2;
                    }
                    a5.remove(yVar);
                }
            } catch (Throwable th) {
                al.a(th);
            }
            if (a5.size() > 0) {
                this.c.a(a5);
            }
        } else {
            j2 = z3 ? this.f1275g : this.f1274f;
        }
        al.c("[UploadManager] Local network consume: %d KB", Long.valueOf(j2 / 1024));
        return j2;
    }

    public final synchronized void a(long j2, boolean z3) {
        int i3 = z3 ? 5 : 3;
        try {
            y yVar = new y();
            yVar.b = i3;
            yVar.f1545e = ap.b();
            yVar.c = "";
            yVar.d = "";
            yVar.f1547g = ap.c(j2);
            this.c.b(i3);
            this.c.a(yVar);
            if (z3) {
                this.f1275g = j2;
            } else {
                this.f1274f = j2;
            }
            al.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j2 / 1024));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void a(int i3, long j2) {
        if (i3 >= 0) {
            this.f1273e.put(Integer.valueOf(i3), Long.valueOf(j2));
            y yVar = new y();
            yVar.b = i3;
            yVar.f1545e = j2;
            yVar.c = "";
            yVar.d = "";
            yVar.f1547g = new byte[0];
            this.c.b(i3);
            this.c.a(yVar);
            al.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i3), ap.a(j2));
            return;
        }
        al.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i3));
    }

    public final synchronized long a(int i3) {
        if (i3 >= 0) {
            Long l5 = this.f1273e.get(Integer.valueOf(i3));
            if (l5 != null) {
                return l5.longValue();
            }
        } else {
            al.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i3));
        }
        return 0L;
    }

    private static void a(LinkedBlockingQueue<Runnable> linkedBlockingQueue, LinkedBlockingQueue<Runnable> linkedBlockingQueue2, int i3) {
        for (int i5 = 0; i5 < i3; i5++) {
            Runnable peek = linkedBlockingQueue.peek();
            if (peek == null) {
                return;
            }
            try {
                linkedBlockingQueue2.put(peek);
                linkedBlockingQueue.poll();
            } catch (Throwable th) {
                al.e("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
            }
        }
    }

    private void a(int i3, LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        ak a5 = ak.a();
        if (i3 > 0) {
            al.c("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(i3), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        }
        for (int i5 = 0; i5 < i3; i5++) {
            Runnable poll = linkedBlockingQueue.poll();
            if (poll == null) {
                return;
            }
            synchronized (this.f1278j) {
                try {
                    if (this.f1280l >= 2 && a5 != null) {
                        a5.a(poll);
                    } else {
                        al.a("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                        if (ap.a(new c0(0, this, poll), "BUGLY_ASYNC_UPLOAD") != null) {
                            synchronized (this.f1278j) {
                                this.f1280l++;
                            }
                        } else {
                            al.d("[UploadManager] Failed to start a thread to execute asynchronous upload task,will try again next time.", new Object[0]);
                            a(poll, true);
                        }
                    }
                } finally {
                }
            }
        }
    }

    private boolean a(Runnable runnable, boolean z3) {
        if (runnable == null) {
            al.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            al.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f1278j) {
                if (z3) {
                    this.f1276h.put(runnable);
                } else {
                    this.f1277i.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            al.e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, long j2) {
        if (runnable == null) {
            al.d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        al.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a5 = ap.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a5 == null) {
            al.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a5.join(j2);
        } catch (Throwable th) {
            al.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            a(runnable, true);
            b();
        }
    }

    private void a(Runnable runnable, boolean z3, boolean z5, long j2) {
        al.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z5) {
            a(runnable, j2);
            return;
        }
        a(runnable, z3);
        b();
    }
}
