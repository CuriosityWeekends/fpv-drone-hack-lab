package l1;

import j1.i0;
import j1.j0;
import j1.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements j0 {

    /* renamed from: a  reason: collision with root package name */
    public final g f2651a;
    public final i0 b;
    public final int c;
    public boolean d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ g f2652e;

    public e(g gVar, g gVar2, i0 i0Var, int i3) {
        this.f2652e = gVar;
        this.f2651a = gVar2;
        this.b = i0Var;
        this.c = i3;
    }

    public final void b() {
        if (!this.d) {
            g gVar = this.f2652e;
            u uVar = gVar.f2656g;
            int[] iArr = gVar.b;
            int i3 = this.c;
            uVar.b(iArr[i3], gVar.c[i3], 0, null, gVar.s);
            this.d = true;
        }
    }

    @Override // j1.j0
    public final int c(j0.b bVar, m0.d dVar, boolean z3) {
        g gVar = this.f2652e;
        if (gVar.p()) {
            return -3;
        }
        b();
        return this.b.y(bVar, dVar, z3, gVar.f2669v, gVar.f2668u);
    }

    @Override // j1.j0
    public final int g(long j2) {
        g gVar = this.f2652e;
        if (gVar.p()) {
            return 0;
        }
        b();
        boolean z3 = gVar.f2669v;
        i0 i0Var = this.b;
        if (z3 && j2 > i0Var.o()) {
            return i0Var.f();
        }
        return i0Var.e(j2);
    }

    @Override // j1.j0
    public final boolean isReady() {
        g gVar = this.f2652e;
        if (!gVar.p() && this.b.u(gVar.f2669v)) {
            return true;
        }
        return false;
    }

    @Override // j1.j0
    public final void a() {
    }
}
