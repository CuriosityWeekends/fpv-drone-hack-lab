package p4;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o extends h4.b implements n4.b {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3265a;

    public o(Object obj) {
        this.f3265a = obj;
    }

    @Override // k4.c
    public final Object get() {
        return this.f3265a;
    }

    @Override // h4.b
    public final void h(h4.c cVar) {
        p pVar = new p(cVar, this.f3265a);
        cVar.a(pVar);
        pVar.run();
    }
}
