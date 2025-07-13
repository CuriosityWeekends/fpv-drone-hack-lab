package p4;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d extends a {
    public final int b;
    public final int c;
    public final k4.c d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h4.b bVar, int i3, int i5) {
        super(bVar);
        r4.a aVar = r4.a.f3455a;
        this.b = i3;
        this.c = i5;
        this.d = aVar;
    }

    @Override // h4.b
    public final void h(h4.c cVar) {
        h4.b bVar = this.f3227a;
        k4.c cVar2 = this.d;
        int i3 = this.c;
        int i5 = this.b;
        if (i3 == i5) {
            b bVar2 = new b(cVar, i5, cVar2);
            if (bVar2.e()) {
                bVar.g(bVar2);
                return;
            }
            return;
        }
        bVar.g(new c(cVar, i5, i3, cVar2));
    }
}
