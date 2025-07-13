package j0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l implements g2.j {

    /* renamed from: a  reason: collision with root package name */
    public final g2.s f2266a;
    public final y b;
    public h c;
    public g2.j d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2267e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2268f;

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, g2.s] */
    public l(y yVar) {
        this.b = yVar;
        g2.t tVar = g2.t.f1957a;
        ?? obj = new Object();
        obj.d = tVar;
        obj.f1956e = h0.f2254e;
        this.f2266a = obj;
        this.f2267e = true;
    }

    @Override // g2.j
    public final h0 a() {
        g2.j jVar = this.d;
        if (jVar != null) {
            return jVar.a();
        }
        return (h0) this.f2266a.f1956e;
    }

    @Override // g2.j
    public final void b(h0 h0Var) {
        g2.j jVar = this.d;
        if (jVar != null) {
            jVar.b(h0Var);
            h0Var = this.d.a();
        }
        this.f2266a.b(h0Var);
    }

    @Override // g2.j
    public final long c() {
        if (this.f2267e) {
            return this.f2266a.c();
        }
        return this.d.c();
    }
}
