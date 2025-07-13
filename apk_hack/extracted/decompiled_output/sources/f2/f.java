package f2;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements e2.h {

    /* renamed from: a  reason: collision with root package name */
    public final b f1827a;
    public final e2.h b;
    public final e2.h c;
    public final b3.e d;

    public f(b bVar, e2.h hVar) {
        j3.b bVar2 = new j3.b(3);
        b3.e eVar = new b3.e(3, bVar);
        this.f1827a = bVar;
        this.b = hVar;
        this.c = bVar2;
        this.d = eVar;
    }

    @Override // e2.h
    public final e2.i createDataSource() {
        d dVar;
        e2.i createDataSource = this.b.createDataSource();
        e2.i createDataSource2 = this.c.createDataSource();
        b3.e eVar = this.d;
        if (eVar == null) {
            dVar = null;
        } else {
            dVar = new d((b) eVar.b);
        }
        return new e(this.f1827a, createDataSource, createDataSource2, dVar);
    }
}
