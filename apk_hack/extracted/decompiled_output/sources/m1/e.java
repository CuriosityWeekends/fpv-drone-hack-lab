package m1;

import android.net.Uri;
import android.util.Log;
import e2.a0;
import e2.c0;
import e2.f0;
import e2.g0;
import e2.i0;
import e2.k0;
import e2.z;
import g2.w;
import j1.u;
import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements z, g0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2789a;
    public final /* synthetic */ h b;

    public /* synthetic */ e(h hVar, int i3) {
        this.f2789a = i3;
        this.b = hVar;
    }

    @Override // e2.g0
    public void a() {
        h hVar = this.b;
        hVar.f2808y.a();
        e2.b bVar = hVar.A;
        if (bVar == null) {
            return;
        }
        throw bVar;
    }

    @Override // e2.z
    public void f(c0 c0Var, long j2, long j5, boolean z3) {
        switch (this.f2789a) {
            case 1:
                i0 i0Var = (i0) c0Var;
                h hVar = this.b;
                hVar.getClass();
                e2.l lVar = i0Var.f1688a;
                Uri uri = i0Var.c.c;
                hVar.f2800n.d(i0Var.b, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
                return;
            default:
                i0 i0Var2 = (i0) c0Var;
                h hVar2 = this.b;
                hVar2.getClass();
                e2.l lVar2 = i0Var2.f1688a;
                Uri uri2 = i0Var2.c.c;
                hVar2.f2800n.d(i0Var2.b, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
                return;
        }
    }

    @Override // e2.z
    public a0 k(c0 c0Var, long j2, long j5, IOException iOException, int i3) {
        a0 a0Var;
        switch (this.f2789a) {
            case 1:
                i0 i0Var = (i0) c0Var;
                h hVar = this.b;
                hVar.f2797k.getClass();
                long m5 = j3.a.m(i3, iOException);
                if (m5 == -9223372036854775807L) {
                    a0Var = f0.f1685e;
                } else {
                    a0Var = new a0(0, m5);
                }
                e2.l lVar = i0Var.f1688a;
                k0 k0Var = i0Var.c;
                Uri uri = k0Var.c;
                hVar.f2800n.j(i0Var.b, j2, j5, k0Var.b, iOException, !a0Var.a());
                return a0Var;
            default:
                i0 i0Var2 = (i0) c0Var;
                h hVar2 = this.b;
                hVar2.getClass();
                e2.l lVar2 = i0Var2.f1688a;
                k0 k0Var2 = i0Var2.c;
                Uri uri2 = k0Var2.c;
                hVar2.f2800n.j(i0Var2.b, j2, j5, k0Var2.b, iOException, true);
                Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
                hVar2.r(true);
                return f0.d;
        }
    }

    /* JADX WARN: Type inference failed for: r0v23, types: [java.io.IOException, e2.b] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, e2.h0] */
    @Override // e2.z
    public void l(c0 c0Var, long j2, long j5) {
        int size;
        com.lxj.xpopup.util.a aVar;
        switch (this.f2789a) {
            case 1:
                i0 i0Var = (i0) c0Var;
                h hVar = this.b;
                u uVar = hVar.f2800n;
                e2.l lVar = i0Var.f1688a;
                k0 k0Var = i0Var.c;
                Uri uri = k0Var.c;
                uVar.g(i0Var.b, j2, j5, k0Var.b);
                n1.b bVar = (n1.b) i0Var.f1689e;
                n1.b bVar2 = hVar.E;
                if (bVar2 == null) {
                    size = 0;
                } else {
                    size = bVar2.f2922j.size();
                }
                long j6 = bVar.a(0).b;
                int i3 = 0;
                while (i3 < size && hVar.E.a(i3).b < j6) {
                    i3++;
                }
                if (bVar.c) {
                    if (size - i3 > bVar.f2922j.size()) {
                        Log.w("DashMediaSource", "Loaded out of sync manifest");
                    } else {
                        long j7 = hVar.K;
                        if (j7 != -9223372036854775807L && bVar.f2919g * 1000 <= j7) {
                            Log.w("DashMediaSource", "Loaded stale dynamic manifest: " + bVar.f2919g + ", " + hVar.K);
                        } else {
                            hVar.J = 0;
                        }
                    }
                    int i5 = hVar.J;
                    hVar.J = i5 + 1;
                    if (i5 < hVar.f2797k.l(i0Var.b)) {
                        hVar.B.postDelayed(hVar.s, Math.min((hVar.J - 1) * 1000, 5000));
                        return;
                    } else {
                        hVar.A = new IOException();
                        return;
                    }
                }
                hVar.E = bVar;
                hVar.F &= bVar.c;
                hVar.G = j2 - j5;
                hVar.H = j2;
                if (bVar.f2921i != null) {
                    synchronized (hVar.q) {
                        try {
                            if (i0Var.f1688a.f1694a == hVar.D) {
                                hVar.D = hVar.E.f2921i;
                            }
                        } finally {
                        }
                    }
                }
                if (size == 0) {
                    n1.b bVar3 = hVar.E;
                    if (bVar3.c && (aVar = bVar3.f2920h) != null) {
                        String str = aVar.b;
                        if (!w.a(str, "urn:mpeg:dash:utc:direct:2014") && !w.a(str, "urn:mpeg:dash:utc:direct:2012")) {
                            if (!w.a(str, "urn:mpeg:dash:utc:http-iso:2014") && !w.a(str, "urn:mpeg:dash:utc:http-iso:2012")) {
                                if (!w.a(str, "urn:mpeg:dash:utc:http-xsdate:2014") && !w.a(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
                                    Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", new IOException("Unsupported UTC timing scheme"));
                                    hVar.r(true);
                                    return;
                                }
                                i0 i0Var2 = new i0(hVar.f2807x, Uri.parse(aVar.c), 5, new j3.b(15));
                                hVar.f2808y.e(i0Var2, new e(hVar, 3), 1);
                                hVar.f2800n.l(i0Var2.f1688a, i0Var2.b, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
                                return;
                            }
                            i0 i0Var3 = new i0(hVar.f2807x, Uri.parse(aVar.c), 5, new Object());
                            hVar.f2808y.e(i0Var3, new e(hVar, 3), 1);
                            hVar.f2800n.l(i0Var3.f1688a, i0Var3.b, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
                            return;
                        }
                        try {
                            hVar.I = w.y(aVar.c) - hVar.H;
                            hVar.r(true);
                            return;
                        } catch (j0.f0 e5) {
                            Log.e("DashMediaSource", "Failed to resolve UtcTiming element.", e5);
                            hVar.r(true);
                            return;
                        }
                    }
                    hVar.r(true);
                    return;
                }
                hVar.L += i3;
                hVar.r(true);
                return;
            default:
                i0 i0Var4 = (i0) c0Var;
                h hVar2 = this.b;
                u uVar2 = hVar2.f2800n;
                e2.l lVar2 = i0Var4.f1688a;
                k0 k0Var2 = i0Var4.c;
                Uri uri2 = k0Var2.c;
                uVar2.g(i0Var4.b, j2, j5, k0Var2.b);
                hVar2.I = ((Long) i0Var4.f1689e).longValue() - j2;
                hVar2.r(true);
                return;
        }
    }
}
