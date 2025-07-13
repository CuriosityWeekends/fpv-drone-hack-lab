package y;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements d, c {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3999a;
    public final d b;
    public volatile c c;
    public volatile c d;

    /* renamed from: e  reason: collision with root package name */
    public int f4000e = 3;

    /* renamed from: f  reason: collision with root package name */
    public int f4001f = 3;

    public b(Object obj, d dVar) {
        this.f3999a = obj;
        this.b = dVar;
    }

    @Override // y.d, y.c
    public final boolean a() {
        boolean z3;
        synchronized (this.f3999a) {
            try {
                if (!this.c.a() && !this.d.a()) {
                    z3 = false;
                }
                z3 = true;
            } finally {
            }
        }
        return z3;
    }

    @Override // y.d
    public final void b(c cVar) {
        synchronized (this.f3999a) {
            try {
                if (!cVar.equals(this.d)) {
                    this.f4000e = 5;
                    if (this.f4001f != 1) {
                        this.f4001f = 1;
                        this.d.g();
                    }
                    return;
                }
                this.f4001f = 5;
                d dVar = this.b;
                if (dVar != null) {
                    dVar.b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y.d
    public final boolean c(c cVar) {
        boolean z3;
        synchronized (this.f3999a) {
            d dVar = this.b;
            if ((dVar == null || dVar.c(this)) && k(cVar)) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    @Override // y.c
    public final void clear() {
        synchronized (this.f3999a) {
            try {
                this.f4000e = 3;
                this.c.clear();
                if (this.f4001f != 3) {
                    this.f4001f = 3;
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y.d
    public final boolean d(c cVar) {
        boolean z3;
        synchronized (this.f3999a) {
            d dVar = this.b;
            if ((dVar == null || dVar.d(this)) && k(cVar)) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    @Override // y.c
    public final boolean e() {
        boolean z3;
        synchronized (this.f3999a) {
            try {
                if (this.f4000e == 3 && this.f4001f == 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            } finally {
            }
        }
        return z3;
    }

    @Override // y.d
    public final void f(c cVar) {
        synchronized (this.f3999a) {
            try {
                if (cVar.equals(this.c)) {
                    this.f4000e = 4;
                } else if (cVar.equals(this.d)) {
                    this.f4001f = 4;
                }
                d dVar = this.b;
                if (dVar != null) {
                    dVar.f(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y.c
    public final void g() {
        synchronized (this.f3999a) {
            try {
                if (this.f4000e != 1) {
                    this.f4000e = 1;
                    this.c.g();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y.d
    public final d getRoot() {
        d dVar;
        synchronized (this.f3999a) {
            try {
                d dVar2 = this.b;
                if (dVar2 != null) {
                    dVar = dVar2.getRoot();
                } else {
                    dVar = this;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    @Override // y.d
    public final boolean h(c cVar) {
        boolean z3;
        synchronized (this.f3999a) {
            d dVar = this.b;
            if ((dVar == null || dVar.h(this)) && k(cVar)) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    @Override // y.c
    public final boolean i() {
        boolean z3;
        synchronized (this.f3999a) {
            try {
                if (this.f4000e != 4 && this.f4001f != 4) {
                    z3 = false;
                }
                z3 = true;
            } finally {
            }
        }
        return z3;
    }

    @Override // y.c
    public final boolean isRunning() {
        boolean z3;
        synchronized (this.f3999a) {
            try {
                z3 = true;
                if (this.f4000e != 1 && this.f4001f != 1) {
                    z3 = false;
                }
            } finally {
            }
        }
        return z3;
    }

    @Override // y.c
    public final boolean j(c cVar) {
        if (!(cVar instanceof b)) {
            return false;
        }
        b bVar = (b) cVar;
        if (!this.c.j(bVar.c) || !this.d.j(bVar.d)) {
            return false;
        }
        return true;
    }

    public final boolean k(c cVar) {
        if (!cVar.equals(this.c) && (this.f4000e != 5 || !cVar.equals(this.d))) {
            return false;
        }
        return true;
    }

    @Override // y.c
    public final void pause() {
        synchronized (this.f3999a) {
            try {
                if (this.f4000e == 1) {
                    this.f4000e = 2;
                    this.c.pause();
                }
                if (this.f4001f == 1) {
                    this.f4001f = 2;
                    this.d.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
