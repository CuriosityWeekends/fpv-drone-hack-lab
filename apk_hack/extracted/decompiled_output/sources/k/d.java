package k;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d implements a {
    public final File b;

    /* renamed from: e  reason: collision with root package name */
    public e.e f2488e;
    public final c1.b d = new c1.b(11);
    public final long c = 262144000;

    /* renamed from: a  reason: collision with root package name */
    public final i f2487a = new i();

    public d(File file) {
        this.b = file;
    }

    public final synchronized e.e a() {
        try {
            if (this.f2488e == null) {
                this.f2488e = e.e.h(this.b, this.c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f2488e;
    }

    @Override // k.a
    public final File d(g.e eVar) {
        String b = this.f2487a.b(eVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b + " for for Key: " + eVar);
        }
        try {
            b3.e f4 = a().f(b);
            if (f4 == null) {
                return null;
            }
            return ((File[]) f4.b)[0];
        } catch (IOException e5) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e5);
            return null;
        }
    }

    @Override // k.a
    public final void e(g.e eVar, i.b bVar) {
        b bVar2;
        e.e a5;
        boolean z3;
        String b = this.f2487a.b(eVar);
        c1.b bVar3 = this.d;
        synchronized (bVar3) {
            try {
                bVar2 = (b) ((HashMap) bVar3.b).get(b);
                if (bVar2 == null) {
                    bVar2 = ((c) bVar3.c).a();
                    ((HashMap) bVar3.b).put(b, bVar2);
                }
                bVar2.b++;
            } finally {
            }
        }
        bVar2.f2485a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b + " for for Key: " + eVar);
            }
            try {
                a5 = a();
            } catch (IOException e5) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e5);
                }
            }
            if (a5.f(b) != null) {
                return;
            }
            e.c d = a5.d(b);
            if (d != null) {
                try {
                    if (((g.b) bVar.b).k(bVar.c, d.c(), (g.h) bVar.d)) {
                        e.e.a((e.e) d.d, d, true);
                        d.f1650a = true;
                    }
                    if (!z3) {
                        try {
                            d.a();
                        } catch (IOException unused) {
                        }
                    }
                    return;
                } finally {
                    if (!d.f1650a) {
                        try {
                            d.a();
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: ".concat(b));
        } finally {
            this.d.w(b);
        }
    }
}
