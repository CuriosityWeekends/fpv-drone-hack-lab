package p4;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g extends a {
    public final int b;

    public g(h4.b bVar, int i3) {
        super(bVar);
        this.b = Math.max(8, i3);
    }

    @Override // h4.b
    public final void h(h4.c cVar) {
        j3.a aVar = m4.a.f2871a;
        h4.b bVar = this.f3227a;
        if (j4.b.y(bVar, cVar, aVar)) {
            return;
        }
        bVar.g(new f(new s4.a(cVar), this.b));
    }
}
