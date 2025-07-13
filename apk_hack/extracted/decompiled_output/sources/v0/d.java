package v0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f3792a;
    public int b;
    public int c;
    public long d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f3793e;

    /* renamed from: f  reason: collision with root package name */
    public final c0.b f3794f;

    /* renamed from: g  reason: collision with root package name */
    public final c0.b f3795g;

    /* renamed from: h  reason: collision with root package name */
    public int f3796h;

    /* renamed from: i  reason: collision with root package name */
    public int f3797i;

    public d(c0.b bVar, c0.b bVar2, boolean z3) {
        this.f3795g = bVar;
        this.f3794f = bVar2;
        this.f3793e = z3;
        bVar2.y(12);
        this.f3792a = bVar2.q();
        bVar.y(12);
        this.f3797i = bVar.q();
        if (bVar.c() == 1) {
            this.b = -1;
            return;
        }
        throw new IllegalStateException("first_chunk must be 1");
    }

    public final boolean a() {
        long o5;
        int i3;
        int i5 = this.b + 1;
        this.b = i5;
        if (i5 == this.f3792a) {
            return false;
        }
        boolean z3 = this.f3793e;
        c0.b bVar = this.f3794f;
        if (z3) {
            o5 = bVar.r();
        } else {
            o5 = bVar.o();
        }
        this.d = o5;
        if (this.b == this.f3796h) {
            c0.b bVar2 = this.f3795g;
            this.c = bVar2.q();
            bVar2.z(4);
            int i6 = this.f3797i - 1;
            this.f3797i = i6;
            if (i6 > 0) {
                i3 = bVar2.q() - 1;
            } else {
                i3 = -1;
            }
            this.f3796h = i3;
        }
        return true;
    }
}
