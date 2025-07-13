package e2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b0 extends Handler implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final int f1673a;
    public final c0 b;
    public final long c;
    public z d;

    /* renamed from: e  reason: collision with root package name */
    public IOException f1674e;

    /* renamed from: f  reason: collision with root package name */
    public int f1675f;

    /* renamed from: g  reason: collision with root package name */
    public volatile Thread f1676g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f1677h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f1678i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ f0 f1679j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(f0 f0Var, Looper looper, c0 c0Var, z zVar, int i3, long j2) {
        super(looper);
        this.f1679j = f0Var;
        this.b = c0Var;
        this.d = zVar;
        this.f1673a = i3;
        this.c = j2;
    }

    public final void a(boolean z3) {
        this.f1678i = z3;
        this.f1674e = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z3) {
                sendEmptyMessage(1);
            }
        } else {
            this.f1677h = true;
            this.b.b();
            Thread thread = this.f1676g;
            if (thread != null) {
                thread.interrupt();
            }
        }
        if (z3) {
            this.f1679j.b = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            z zVar = this.d;
            zVar.getClass();
            zVar.f(this.b, elapsedRealtime, elapsedRealtime - this.c, true);
            this.d = null;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f1678i) {
            return;
        }
        int i3 = message.what;
        if (i3 == 0) {
            this.f1674e = null;
            f0 f0Var = this.f1679j;
            b0 b0Var = (b0) f0Var.b;
            b0Var.getClass();
            ((ExecutorService) f0Var.f1686a).execute(b0Var);
        } else if (i3 != 4) {
            this.f1679j.b = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = elapsedRealtime - this.c;
            z zVar = this.d;
            zVar.getClass();
            if (this.f1677h) {
                zVar.f(this.b, elapsedRealtime, j2, false);
                return;
            }
            int i5 = message.what;
            boolean z3 = true;
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        IOException iOException = (IOException) message.obj;
                        this.f1674e = iOException;
                        int i6 = this.f1675f + 1;
                        this.f1675f = i6;
                        a0 k5 = zVar.k(this.b, elapsedRealtime, j2, iOException, i6);
                        int i7 = k5.f1672a;
                        if (i7 == 3) {
                            this.f1679j.c = this.f1674e;
                            return;
                        } else if (i7 != 2) {
                            if (i7 == 1) {
                                this.f1675f = 1;
                            }
                            long j5 = k5.b;
                            if (j5 == -9223372036854775807L) {
                                j5 = Math.min((this.f1675f - 1) * 1000, 5000);
                            }
                            f0 f0Var2 = this.f1679j;
                            if (((b0) f0Var2.b) != null) {
                                z3 = false;
                            }
                            g2.b.h(z3);
                            f0Var2.b = this;
                            if (j5 > 0) {
                                sendEmptyMessageDelayed(0, j5);
                                return;
                            }
                            this.f1674e = null;
                            ((ExecutorService) f0Var2.f1686a).execute(this);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                try {
                    zVar.l(this.b, elapsedRealtime, j2);
                    return;
                } catch (RuntimeException e5) {
                    Log.e("LoadTask", "Unexpected exception handling load completed", e5);
                    this.f1679j.c = new e0(e5);
                    return;
                }
            }
            zVar.f(this.b, elapsedRealtime, j2, false);
        } else {
            throw ((Error) message.obj);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f1676g = Thread.currentThread();
            if (!this.f1677h) {
                g2.b.b("load:".concat(this.b.getClass().getSimpleName()));
                try {
                    this.b.a();
                    g2.b.m();
                } catch (Throwable th) {
                    g2.b.m();
                    throw th;
                }
            }
            if (!this.f1678i) {
                sendEmptyMessage(2);
            }
        } catch (IOException e5) {
            if (!this.f1678i) {
                obtainMessage(3, e5).sendToTarget();
            }
        } catch (InterruptedException unused) {
            g2.b.h(this.f1677h);
            if (!this.f1678i) {
                sendEmptyMessage(2);
            }
        } catch (Exception e6) {
            Log.e("LoadTask", "Unexpected exception loading stream", e6);
            if (!this.f1678i) {
                obtainMessage(3, new e0(e6)).sendToTarget();
            }
        } catch (OutOfMemoryError e7) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e7);
            if (!this.f1678i) {
                obtainMessage(3, new e0(e7)).sendToTarget();
            }
        } catch (Error e8) {
            Log.e("LoadTask", "Unexpected error loading stream", e8);
            if (!this.f1678i) {
                obtainMessage(4, e8).sendToTarget();
            }
            throw e8;
        }
    }
}
