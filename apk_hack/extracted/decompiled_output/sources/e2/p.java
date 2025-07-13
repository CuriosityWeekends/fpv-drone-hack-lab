package e2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p extends BroadcastReceiver {
    public static p c;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f1715a = new Handler(Looper.getMainLooper());
    public final ArrayList b = new ArrayList();

    public static void c(q qVar) {
        int m5;
        int i3;
        Map map = q.f1716n;
        synchronized (qVar) {
            try {
                Context context = qVar.f1720a;
                if (context == null) {
                    m5 = 0;
                } else {
                    m5 = g2.w.m(context);
                }
                if (qVar.f1725i != m5) {
                    qVar.f1725i = m5;
                    if (m5 != 1 && m5 != 0 && m5 != 8) {
                        SparseArray sparseArray = qVar.b;
                        Long l5 = (Long) sparseArray.get(m5);
                        if (l5 == null) {
                            l5 = (Long) sparseArray.get(0);
                        }
                        if (l5 == null) {
                            l5 = 1000000L;
                        }
                        qVar.f1728l = l5.longValue();
                        qVar.f1721e.getClass();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        if (qVar.f1722f > 0) {
                            i3 = (int) (elapsedRealtime - qVar.f1723g);
                        } else {
                            i3 = 0;
                        }
                        qVar.a(i3, qVar.f1724h, qVar.f1728l);
                        qVar.f1723g = elapsedRealtime;
                        qVar.f1724h = 0L;
                        qVar.f1727k = 0L;
                        qVar.f1726j = 0L;
                        g2.r rVar = qVar.d;
                        rVar.b.clear();
                        rVar.d = -1;
                        rVar.f1952e = 0;
                        rVar.f1953f = 0;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void a(q qVar) {
        b();
        this.b.add(new WeakReference(qVar));
        this.f1715a.post(new d2.h(1, this, qVar));
    }

    public final void b() {
        ArrayList arrayList = this.b;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((q) ((WeakReference) arrayList.get(size)).get()) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        if (isInitialStickyBroadcast()) {
            return;
        }
        b();
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            q qVar = (q) ((WeakReference) this.b.get(i3)).get();
            if (qVar != null) {
                c(qVar);
            }
        }
    }
}
