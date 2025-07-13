package e2;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f0 implements g0, h {
    public static final a0 d = new a0(2, -9223372036854775807L);

    /* renamed from: e  reason: collision with root package name */
    public static final a0 f1685e = new a0(3, -9223372036854775807L);

    /* renamed from: a  reason: collision with root package name */
    public final Object f1686a;
    public Object b;
    public Object c;

    public f0(Context context, q qVar, h hVar) {
        this.f1686a = context.getApplicationContext();
        this.b = qVar;
        this.c = hVar;
    }

    @Override // e2.g0
    public void a() {
        IOException iOException;
        IOException iOException2 = (IOException) this.c;
        if (iOException2 == null) {
            b0 b0Var = (b0) this.b;
            if (b0Var != null && (iOException = b0Var.f1674e) != null && b0Var.f1675f > b0Var.f1673a) {
                throw iOException;
            }
            return;
        }
        throw iOException2;
    }

    public boolean b() {
        if (((IOException) this.c) != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (((b0) this.b) != null) {
            return true;
        }
        return false;
    }

    @Override // e2.h
    public i createDataSource() {
        r rVar = new r((Context) this.f1686a, ((h) this.c).createDataSource());
        m0 m0Var = (m0) this.b;
        if (m0Var != null) {
            rVar.addTransferListener(m0Var);
        }
        return rVar;
    }

    public void d(d0 d0Var) {
        b0 b0Var = (b0) this.b;
        if (b0Var != null) {
            b0Var.a(true);
        }
        ExecutorService executorService = (ExecutorService) this.f1686a;
        if (d0Var != null) {
            executorService.execute(new b3.d(6, d0Var));
        }
        executorService.shutdown();
    }

    public long e(c0 c0Var, z zVar, int i3) {
        boolean z3;
        Looper myLooper = Looper.myLooper();
        g2.b.i(myLooper);
        this.c = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        b0 b0Var = new b0(this, myLooper, c0Var, zVar, i3, elapsedRealtime);
        if (((b0) this.b) == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.h(z3);
        this.b = b0Var;
        b0Var.f1674e = null;
        ((ExecutorService) this.f1686a).execute(b0Var);
        return elapsedRealtime;
    }

    public f0(final String str) {
        int i3 = g2.w.f1960a;
        this.f1686a = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: g2.v
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, str);
            }
        });
    }
}
