package l1;

import com.google.android.exoplayer2.Format;
import e2.k0;
import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j extends b {

    /* renamed from: m  reason: collision with root package name */
    public static final p0.m f2675m = new Object();

    /* renamed from: i  reason: collision with root package name */
    public final d f2676i;

    /* renamed from: j  reason: collision with root package name */
    public c1.b f2677j;

    /* renamed from: k  reason: collision with root package name */
    public long f2678k;

    /* renamed from: l  reason: collision with root package name */
    public volatile boolean f2679l;

    public j(e2.i iVar, e2.l lVar, Format format, int i3, Object obj, d dVar) {
        super(iVar, lVar, 2, format, i3, obj, -9223372036854775807L, -9223372036854775807L);
        this.f2676i = dVar;
    }

    @Override // e2.c0
    public final void a() {
        if (this.f2678k == 0) {
            this.f2676i.b(this.f2677j, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            e2.l b = this.f2637a.b(this.f2678k);
            k0 k0Var = this.f2641h;
            p0.g gVar = new p0.g(k0Var, b.f1695e, k0Var.open(b));
            p0.j jVar = this.f2676i.f2645a;
            boolean z3 = false;
            int i3 = 0;
            while (i3 == 0 && !this.f2679l) {
                i3 = jVar.h(gVar, f2675m);
            }
            if (i3 != 1) {
                z3 = true;
            }
            g2.b.h(z3);
            this.f2678k = gVar.d - this.f2637a.f1695e;
        } finally {
            w.f(this.f2641h);
        }
    }

    @Override // e2.c0
    public final void b() {
        this.f2679l = true;
    }
}
