package e2;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class e implements i {
    @Nullable
    private l dataSpec;
    private final boolean isNetwork;
    private int listenerCount;
    private final ArrayList<m0> listeners = new ArrayList<>(1);

    public e(boolean z3) {
        this.isNetwork = z3;
    }

    @Override // e2.i
    public final void addTransferListener(m0 m0Var) {
        if (!this.listeners.contains(m0Var)) {
            this.listeners.add(m0Var);
            this.listenerCount++;
        }
    }

    public final void bytesTransferred(int i3) {
        int i5 = g2.w.f1960a;
        for (int i6 = 0; i6 < this.listenerCount; i6++) {
            boolean z3 = this.isNetwork;
            q qVar = (q) this.listeners.get(i6);
            synchronized (qVar) {
                if (z3) {
                    qVar.f1724h += i3;
                }
            }
        }
    }

    @Override // e2.i
    public Map getResponseHeaders() {
        return Collections.emptyMap();
    }

    public final void transferEnded() {
        boolean z3;
        int i3 = g2.w.f1960a;
        for (int i5 = 0; i5 < this.listenerCount; i5++) {
            boolean z5 = this.isNetwork;
            q qVar = (q) this.listeners.get(i5);
            synchronized (qVar) {
                if (z5) {
                    try {
                        if (qVar.f1722f > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        g2.b.h(z3);
                        qVar.f1721e.getClass();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        int i6 = (int) (elapsedRealtime - qVar.f1723g);
                        qVar.f1726j += i6;
                        long j2 = qVar.f1727k;
                        long j5 = qVar.f1724h;
                        qVar.f1727k = j2 + j5;
                        if (i6 > 0) {
                            qVar.d.a((((float) j5) * 8000.0f) / i6, (int) Math.sqrt(j5));
                            if (qVar.f1726j < 2000) {
                                if (qVar.f1727k >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                                }
                                qVar.a(i6, qVar.f1724h, qVar.f1728l);
                                qVar.f1723g = elapsedRealtime;
                                qVar.f1724h = 0L;
                            }
                            qVar.f1728l = qVar.d.b();
                            qVar.a(i6, qVar.f1724h, qVar.f1728l);
                            qVar.f1723g = elapsedRealtime;
                            qVar.f1724h = 0L;
                        }
                        qVar.f1722f--;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        this.dataSpec = null;
    }

    public final void transferInitializing(l lVar) {
        for (int i3 = 0; i3 < this.listenerCount; i3++) {
            this.listeners.get(i3).getClass();
        }
    }

    public final void transferStarted(l lVar) {
        this.dataSpec = lVar;
        for (int i3 = 0; i3 < this.listenerCount; i3++) {
            boolean z3 = this.isNetwork;
            q qVar = (q) this.listeners.get(i3);
            synchronized (qVar) {
                if (z3) {
                    try {
                        if (qVar.f1722f == 0) {
                            qVar.f1721e.getClass();
                            qVar.f1723g = SystemClock.elapsedRealtime();
                        }
                        qVar.f1722f++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }
}
