package j1;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final int f2464a;
    public final n b;
    public final CopyOnWriteArrayList c;
    public final long d;

    public u(CopyOnWriteArrayList copyOnWriteArrayList, int i3, n nVar, long j2) {
        this.c = copyOnWriteArrayList;
        this.f2464a = i3;
        this.b = nVar;
        this.d = j2;
    }

    public static void p(Handler handler, Runnable runnable) {
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public final long a(long j2) {
        long b = j0.i.b(j2);
        if (b == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.d + b;
    }

    public final void b(int i3, Format format, int i5, Object obj, long j2) {
        c(new w(1, i3, format, i5, obj, a(j2), -9223372036854775807L));
    }

    public final void c(w wVar) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            p(tVar.f2463a, new q(this, tVar.b, wVar, 3));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, j1.v] */
    public final void d(int i3, int i5, Format format, int i6, Object obj, long j2, long j5) {
        e(new Object(), new w(i3, i5, format, i6, obj, a(j2), a(j5)));
    }

    public final void e(v vVar, w wVar) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            p(tVar.f2463a, new s(this, tVar.b, vVar, wVar, 2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, j1.v] */
    public final void f(int i3, int i5, Format format, int i6, Object obj, long j2, long j5) {
        h(new Object(), new w(i3, i5, format, i6, obj, a(j2), a(j5)));
    }

    public final void g(int i3, long j2, long j5, long j6) {
        f(i3, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public final void h(v vVar, w wVar) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            p(tVar.f2463a, new s(this, tVar.b, vVar, wVar, 0));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, j1.v] */
    public final void i(int i3, int i5, Format format, int i6, Object obj, long j2, long j5, IOException iOException, boolean z3) {
        k(new Object(), new w(i3, i5, format, i6, obj, a(j2), a(j5)), iOException, z3);
    }

    public final void j(int i3, long j2, long j5, long j6, IOException iOException, boolean z3) {
        i(i3, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z3);
    }

    public final void k(final v vVar, final w wVar, final IOException iOException, final boolean z3) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            final x xVar = tVar.b;
            p(tVar.f2463a, new Runnable() { // from class: j1.r
                @Override // java.lang.Runnable
                public final void run() {
                    u uVar = u.this;
                    xVar.onLoadError(uVar.f2464a, uVar.b, vVar, wVar, iOException, z3);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, j1.v] */
    public final void l(e2.l lVar, int i3, int i5, Format format, int i6, Object obj, long j2, long j5) {
        Uri uri = lVar.f1694a;
        Collections.emptyMap();
        m(new Object(), new w(i3, i5, format, i6, obj, a(j2), a(j5)));
    }

    public final void m(v vVar, w wVar) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            p(tVar.f2463a, new s(this, tVar.b, vVar, wVar, 1));
        }
    }

    public final void n() {
        n nVar = this.b;
        nVar.getClass();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            p(tVar.f2463a, new q(this, tVar.b, nVar, 2));
        }
    }

    public final void o() {
        n nVar = this.b;
        nVar.getClass();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            p(tVar.f2463a, new q(this, tVar.b, nVar, 0));
        }
    }

    public final void q() {
        n nVar = this.b;
        nVar.getClass();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            p(tVar.f2463a, new q(this, tVar.b, nVar, 1));
        }
    }

    public final void r(w wVar) {
        n nVar = this.b;
        nVar.getClass();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            p(tVar.f2463a, new s(this, tVar.b, nVar, wVar, 3));
        }
    }
}
