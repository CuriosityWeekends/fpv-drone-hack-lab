package e4;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends d {
    public final boolean b;

    public b(h hVar, boolean z3) {
        super(hVar);
        this.b = z3;
    }

    @Override // e4.d
    public final void a(a aVar) {
        if (this.b) {
            aVar.g();
        } else {
            aVar.k();
        }
    }
}
