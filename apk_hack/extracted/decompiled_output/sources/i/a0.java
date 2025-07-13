package i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a0 implements g0 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2041a;
    public final boolean b;
    public final g0 c;
    public final z d;

    /* renamed from: e  reason: collision with root package name */
    public final g.e f2042e;

    /* renamed from: f  reason: collision with root package name */
    public int f2043f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2044g;

    public a0(g0 g0Var, boolean z3, boolean z5, g.e eVar, z zVar) {
        c0.g.c(g0Var, "Argument must not be null");
        this.c = g0Var;
        this.f2041a = z3;
        this.b = z5;
        this.f2042e = eVar;
        c0.g.c(zVar, "Argument must not be null");
        this.d = zVar;
    }

    @Override // i.g0
    public final Class a() {
        return this.c.a();
    }

    public final synchronized void b() {
        if (!this.f2044g) {
            this.f2043f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    public final void c() {
        boolean z3;
        synchronized (this) {
            int i3 = this.f2043f;
            if (i3 > 0) {
                z3 = true;
                int i5 = i3 - 1;
                this.f2043f = i5;
                if (i5 != 0) {
                    z3 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z3) {
            ((s) this.d).f(this.f2042e, this);
        }
    }

    @Override // i.g0
    public final Object get() {
        return this.c.get();
    }

    @Override // i.g0
    public final int getSize() {
        return this.c.getSize();
    }

    @Override // i.g0
    public final synchronized void recycle() {
        if (this.f2043f <= 0) {
            if (!this.f2044g) {
                this.f2044g = true;
                if (this.b) {
                    this.c.recycle();
                }
            } else {
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f2041a + ", listener=" + this.d + ", key=" + this.f2042e + ", acquired=" + this.f2043f + ", isRecycled=" + this.f2044g + ", resource=" + this.c + '}';
    }
}
