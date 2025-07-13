package j1;

import android.os.Handler;
import android.util.Pair;
import j0.u0;
import java.util.HashMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k extends a {

    /* renamed from: g  reason: collision with root package name */
    public Handler f2442g;

    /* renamed from: h  reason: collision with root package name */
    public e2.m0 f2443h;

    /* renamed from: i  reason: collision with root package name */
    public final p f2444i;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f2441f = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public final int f2445j = Integer.MAX_VALUE;

    /* renamed from: k  reason: collision with root package name */
    public final HashMap f2446k = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    public final HashMap f2447l = new HashMap();

    public k(a aVar) {
        this.f2444i = aVar;
    }

    @Override // j1.p
    public final m a(n nVar, e2.m mVar, long j2) {
        n nVar2;
        int i3 = this.f2445j;
        p pVar = this.f2444i;
        if (i3 == Integer.MAX_VALUE) {
            return pVar.a(nVar, mVar, j2);
        }
        Object obj = nVar.f2454a;
        Object obj2 = ((Pair) obj).second;
        if (obj.equals(obj2)) {
            nVar2 = nVar;
        } else {
            nVar2 = new n(obj2, nVar.b, nVar.c, nVar.d, nVar.f2455e);
        }
        this.f2446k.put(nVar2, nVar);
        m a5 = pVar.a(nVar2, mVar, j2);
        this.f2447l.put(a5, nVar2);
        return a5;
    }

    @Override // j1.p
    public final void b() {
        for (f fVar : this.f2441f.values()) {
            fVar.f2410a.b();
        }
    }

    @Override // j1.p
    public final void c(m mVar) {
        this.f2444i.c(mVar);
        n nVar = (n) this.f2447l.remove(mVar);
        if (nVar != null) {
            this.f2446k.remove(nVar);
        }
    }

    @Override // j1.a
    public final void g() {
        for (f fVar : this.f2441f.values()) {
            ((a) fVar.f2410a).e(fVar.b);
        }
    }

    @Override // j1.a
    public final void i() {
        for (f fVar : this.f2441f.values()) {
            ((a) fVar.f2410a).h(fVar.b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [j1.o, j1.e] */
    @Override // j1.a
    public final void m(e2.m0 m0Var) {
        this.f2443h = m0Var;
        this.f2442g = new Handler();
        HashMap hashMap = this.f2441f;
        g2.b.e(!hashMap.containsKey(null));
        ?? r12 = new o() { // from class: j1.e
            public final /* synthetic */ Object b = null;

            @Override // j1.o
            public final void a(p pVar, u0 u0Var) {
                u0 iVar;
                k kVar = k.this;
                kVar.getClass();
                Void r02 = (Void) this.b;
                int i3 = kVar.f2445j;
                if (i3 != Integer.MAX_VALUE) {
                    iVar = new j(u0Var, i3);
                } else {
                    iVar = new i(u0Var);
                }
                kVar.n(iVar);
            }
        };
        i.b bVar = new i.b(this);
        p pVar = this.f2444i;
        hashMap.put(null, new f(pVar, r12, bVar));
        Handler handler = this.f2442g;
        handler.getClass();
        a aVar = (a) pVar;
        u uVar = aVar.c;
        uVar.getClass();
        uVar.c.add(new t(handler, bVar));
        aVar.j(r12, this.f2443h);
        if (!(!this.b.isEmpty())) {
            aVar.e(r12);
        }
    }

    @Override // j1.a
    public final void p() {
        HashMap hashMap = this.f2441f;
        for (f fVar : hashMap.values()) {
            ((a) fVar.f2410a).o(fVar.b);
            ((a) fVar.f2410a).q(fVar.c);
        }
        hashMap.clear();
    }
}
