package p4;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k extends a {
    public final k4.b b;
    public final boolean c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3258e;

    public k(h4.b bVar, k4.b bVar2, int i3, int i5) {
        super(bVar);
        this.b = bVar2;
        this.c = false;
        this.d = i3;
        this.f3258e = i5;
    }

    @Override // h4.b
    public final void h(h4.c cVar) {
        k4.b bVar = this.b;
        h4.b bVar2 = this.f3227a;
        if (j4.b.y(bVar2, cVar, bVar)) {
            return;
        }
        bVar2.g(new j(cVar, this.b, this.c, this.d, this.f3258e));
    }
}
