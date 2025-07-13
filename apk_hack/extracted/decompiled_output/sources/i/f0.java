package i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f0 implements g0, d0.e {

    /* renamed from: e  reason: collision with root package name */
    public static final d0.d f2057e = d0.g.a(20, new j3.b(6));

    /* renamed from: a  reason: collision with root package name */
    public final d0.h f2058a = new Object();
    public g0 b;
    public boolean c;
    public boolean d;

    @Override // i.g0
    public final Class a() {
        return this.b.a();
    }

    public final synchronized void b() {
        this.f2058a.d();
        if (this.c) {
            this.c = false;
            if (this.d) {
                recycle();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @Override // d0.e
    public final d0.h c() {
        return this.f2058a;
    }

    @Override // i.g0
    public final Object get() {
        return this.b.get();
    }

    @Override // i.g0
    public final int getSize() {
        return this.b.getSize();
    }

    @Override // i.g0
    public final synchronized void recycle() {
        this.f2058a.d();
        this.d = true;
        if (!this.c) {
            this.b.recycle();
            this.b = null;
            f2057e.release(this);
        }
    }
}
