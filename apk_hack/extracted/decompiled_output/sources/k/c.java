package k;

import c0.n;
import java.util.ArrayDeque;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque f2486a;

    public c(int i3) {
        switch (i3) {
            case 1:
                char[] cArr = n.f199a;
                this.f2486a = new ArrayDeque(0);
                return;
            default:
                this.f2486a = new ArrayDeque();
                return;
        }
    }

    public b a() {
        b bVar;
        synchronized (this.f2486a) {
            bVar = (b) this.f2486a.poll();
        }
        if (bVar == null) {
            return new b();
        }
        return bVar;
    }

    public void b(b bVar) {
        synchronized (this.f2486a) {
            try {
                if (this.f2486a.size() < 10) {
                    this.f2486a.offer(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void c(f.c cVar) {
        cVar.b = null;
        cVar.c = null;
        this.f2486a.offer(cVar);
    }
}
