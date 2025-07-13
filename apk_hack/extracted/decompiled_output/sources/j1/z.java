package j1;

import android.net.Uri;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class z implements e2.c0 {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f2470a;
    public final e2.k0 b;
    public final c1.b c;
    public final p0.k d;

    /* renamed from: e  reason: collision with root package name */
    public final g2.d f2471e;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f2473g;

    /* renamed from: i  reason: collision with root package name */
    public long f2475i;

    /* renamed from: j  reason: collision with root package name */
    public e2.l f2476j;

    /* renamed from: l  reason: collision with root package name */
    public i0 f2478l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f2479m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ d0 f2480n;

    /* renamed from: f  reason: collision with root package name */
    public final p0.m f2472f = new Object();

    /* renamed from: h  reason: collision with root package name */
    public boolean f2474h = true;

    /* renamed from: k  reason: collision with root package name */
    public long f2477k = -1;

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, p0.m] */
    public z(d0 d0Var, Uri uri, e2.i iVar, c1.b bVar, p0.k kVar, g2.d dVar) {
        this.f2480n = d0Var;
        this.f2470a = uri;
        this.b = new e2.k0(iVar);
        this.c = bVar;
        this.d = kVar;
        this.f2471e = dVar;
        this.f2476j = new e2.l(uri, 1, null, 0L, 0L, -1L, d0Var.f2382h, 6, d0.M);
    }

    @Override // e2.c0
    public final void a() {
        int i3;
        p0.g gVar;
        long j2;
        e2.i iVar;
        p0.g gVar2;
        int i5;
        int i6 = 0;
        while (i6 == 0 && !this.f2473g) {
            try {
                long j5 = this.f2472f.f3114a;
                j2 = j5;
                e2.l lVar = new e2.l(this.f2470a, 1, null, j5, j5, -1L, this.f2480n.f2382h, 6, d0.M);
                this.f2476j = lVar;
                long open = this.b.open(lVar);
                this.f2477k = open;
                if (open != -1) {
                    this.f2477k = open + j2;
                }
                this.b.f1693a.getUri().getClass();
                this.f2480n.f2391r = IcyHeaders.c(this.b.f1693a.getResponseHeaders());
                e2.k0 k0Var = this.b;
                IcyHeaders icyHeaders = this.f2480n.f2391r;
                if (icyHeaders != null && (i5 = icyHeaders.f353f) != -1) {
                    iVar = new h(k0Var, i5, this);
                    d0 d0Var = this.f2480n;
                    d0Var.getClass();
                    i0 x3 = d0Var.x(new c0(0, true));
                    this.f2478l = x3;
                    x3.d(d0.N);
                } else {
                    iVar = k0Var;
                }
                gVar2 = new p0.g(iVar, j2, this.f2477k);
            } catch (Throwable th) {
                th = th;
                i3 = 1;
                gVar = null;
            }
            try {
                p0.j y3 = this.c.y(gVar2, this.d);
                if (this.f2480n.f2391r != null && (y3 instanceof u0.c)) {
                    ((u0.c) y3).f3737k = true;
                }
                if (this.f2474h) {
                    y3.d(j2, this.f2475i);
                    this.f2474h = false;
                }
                while (true) {
                    long j6 = j2;
                    while (i6 == 0 && !this.f2473g) {
                        g2.d dVar = this.f2471e;
                        synchronized (dVar) {
                            while (!dVar.f1918a) {
                                dVar.wait();
                            }
                        }
                        i6 = y3.h(gVar2, this.f2472f);
                        j2 = gVar2.d;
                        if (j2 > this.f2480n.f2383i + j6) {
                            break;
                        }
                    }
                    this.f2471e.a();
                    d0 d0Var2 = this.f2480n;
                    d0Var2.f2389o.post(d0Var2.f2388n);
                }
                if (i6 == 1) {
                    i6 = 0;
                } else {
                    this.f2472f.f3114a = gVar2.d;
                }
                g2.w.f(this.b);
            } catch (Throwable th2) {
                th = th2;
                gVar = gVar2;
                i3 = 1;
                if (i6 != i3 && gVar != null) {
                    this.f2472f.f3114a = gVar.d;
                }
                g2.w.f(this.b);
                throw th;
            }
        }
    }

    @Override // e2.c0
    public final void b() {
        this.f2473g = true;
    }
}
