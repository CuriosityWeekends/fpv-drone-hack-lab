package v0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    public final c0.b f3798a;
    public final int b;
    public final int c;
    public int d;

    /* renamed from: e  reason: collision with root package name */
    public int f3799e;

    public f(b bVar) {
        c0.b bVar2 = bVar.b;
        this.f3798a = bVar2;
        bVar2.y(12);
        this.c = bVar2.q() & 255;
        this.b = bVar2.q();
    }

    @Override // v0.e
    public final boolean a() {
        return false;
    }

    @Override // v0.e
    public final int b() {
        return this.b;
    }

    @Override // v0.e
    public final int c() {
        c0.b bVar = this.f3798a;
        int i3 = this.c;
        if (i3 == 8) {
            return bVar.n();
        }
        if (i3 == 16) {
            return bVar.s();
        }
        int i5 = this.d;
        this.d = i5 + 1;
        if (i5 % 2 == 0) {
            int n5 = bVar.n();
            this.f3799e = n5;
            return (n5 & 240) >> 4;
        }
        return this.f3799e & 15;
    }
}
