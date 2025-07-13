package p1;

import android.net.Uri;
import android.os.SystemClock;
import e2.a0;
import e2.c0;
import e2.f0;
import e2.i0;
import e2.k0;
import e2.l;
import e2.z;
import j1.u;
import java.io.IOException;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements z, Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f3134a;
    public final f0 b = new f0("DefaultHlsPlaylistTracker:MediaPlaylist");
    public final i0 c;
    public g d;

    /* renamed from: e  reason: collision with root package name */
    public long f3135e;

    /* renamed from: f  reason: collision with root package name */
    public long f3136f;

    /* renamed from: g  reason: collision with root package name */
    public long f3137g;

    /* renamed from: h  reason: collision with root package name */
    public long f3138h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3139i;

    /* renamed from: j  reason: collision with root package name */
    public IOException f3140j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ b f3141k;

    public a(b bVar, Uri uri) {
        this.f3141k = bVar;
        this.f3134a = uri;
        this.c = new i0(bVar.f3143a.f2811a.createDataSource(), uri, 4, bVar.f3145f);
    }

    public final boolean a(long j2) {
        this.f3138h = SystemClock.elapsedRealtime() + j2;
        b bVar = this.f3141k;
        if (!this.f3134a.equals(bVar.f3151l)) {
            return false;
        }
        List list = bVar.f3150k.f3160e;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i3 = 0; i3 < size; i3++) {
            a aVar = (a) bVar.d.get(((d) list.get(i3)).f3156a);
            if (elapsedRealtime > aVar.f3138h) {
                bVar.f3151l = aVar.f3134a;
                aVar.b();
                return false;
            }
        }
        return true;
    }

    public final void b() {
        this.f3138h = 0L;
        if (!this.f3139i) {
            f0 f0Var = this.b;
            if (!f0Var.c() && !f0Var.b()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = this.f3137g;
                b bVar = this.f3141k;
                if (elapsedRealtime < j2) {
                    this.f3139i = true;
                    bVar.f3148i.postDelayed(this, j2 - elapsedRealtime);
                    return;
                }
                j3.a aVar = bVar.c;
                i0 i0Var = this.c;
                f0Var.e(i0Var, this, aVar.l(i0Var.b));
                bVar.f3146g.l(i0Var.f1688a, i0Var.b, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(p1.g r41, long r42) {
        /*
            Method dump skipped, instructions count: 741
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.a.c(p1.g, long):void");
    }

    @Override // e2.z
    public final void f(c0 c0Var, long j2, long j5, boolean z3) {
        i0 i0Var = (i0) c0Var;
        u uVar = this.f3141k.f3146g;
        l lVar = i0Var.f1688a;
        Uri uri = i0Var.c.c;
        uVar.d(4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    @Override // e2.z
    public final a0 k(c0 c0Var, long j2, long j5, IOException iOException, int i3) {
        boolean z3;
        boolean z5;
        a0 a0Var;
        i0 i0Var = (i0) c0Var;
        b bVar = this.f3141k;
        j3.a aVar = bVar.c;
        int i5 = i0Var.b;
        aVar.getClass();
        long k5 = j3.a.k(iOException);
        if (k5 != -9223372036854775807L) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!b.a(bVar, this.f3134a, k5) && z3) {
            z5 = false;
        } else {
            z5 = true;
        }
        if (z3) {
            z5 |= a(k5);
        }
        if (z5) {
            bVar.c.getClass();
            long m5 = j3.a.m(i3, iOException);
            if (m5 != -9223372036854775807L) {
                a0Var = new a0(0, m5);
            } else {
                a0Var = f0.f1685e;
            }
        } else {
            a0Var = f0.d;
        }
        u uVar = bVar.f3146g;
        k0 k0Var = i0Var.c;
        Uri uri = k0Var.c;
        uVar.j(4, j2, j5, k0Var.b, iOException, !a0Var.a());
        return a0Var;
    }

    @Override // e2.z
    public final void l(c0 c0Var, long j2, long j5) {
        i0 i0Var = (i0) c0Var;
        h hVar = (h) i0Var.f1689e;
        if (hVar instanceof g) {
            c((g) hVar, j5);
            u uVar = this.f3141k.f3146g;
            k0 k0Var = i0Var.c;
            Uri uri = k0Var.c;
            uVar.g(4, j2, j5, k0Var.b);
            return;
        }
        this.f3140j = new IOException("Loaded playlist has unexpected type.");
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3139i = false;
        b bVar = this.f3141k;
        j3.a aVar = bVar.c;
        i0 i0Var = this.c;
        this.b.e(i0Var, this, aVar.l(i0Var.b));
        bVar.f3146g.l(i0Var.f1688a, i0Var.b, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }
}
