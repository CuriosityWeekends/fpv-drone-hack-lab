package y;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h implements d, c {

    /* renamed from: a  reason: collision with root package name */
    public final d f4022a;
    public final Object b;
    public volatile c c;
    public volatile c d;

    /* renamed from: e  reason: collision with root package name */
    public int f4023e = 3;

    /* renamed from: f  reason: collision with root package name */
    public int f4024f = 3;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4025g;

    public h(Object obj, d dVar) {
        this.b = obj;
        this.f4022a = dVar;
    }

    @Override // y.d, y.c
    public final boolean a() {
        boolean z3;
        synchronized (this.b) {
            try {
                if (!this.d.a() && !this.c.a()) {
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
        synchronized (this.b) {
            try {
                if (!cVar.equals(this.c)) {
                    this.f4024f = 5;
                    return;
                }
                this.f4023e = 5;
                d dVar = this.f4022a;
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
        synchronized (this.b) {
            try {
                d dVar = this.f4022a;
                if ((dVar == null || dVar.c(this)) && cVar.equals(this.c) && this.f4023e != 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            } finally {
            }
        }
        return z3;
    }

    @Override // y.c
    public final void clear() {
        synchronized (this.b) {
            this.f4025g = false;
            this.f4023e = 3;
            this.f4024f = 3;
            this.d.clear();
            this.c.clear();
        }
    }

    @Override // y.d
    public final boolean d(c cVar) {
        boolean z3;
        synchronized (this.b) {
            try {
                d dVar = this.f4022a;
                if ((dVar == null || dVar.d(this)) && cVar.equals(this.c) && !a()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            } finally {
            }
        }
        return z3;
    }

    @Override // y.c
    public final boolean e() {
        boolean z3;
        synchronized (this.b) {
            if (this.f4023e == 3) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    @Override // y.d
    public final void f(c cVar) {
        synchronized (this.b) {
            try {
                if (cVar.equals(this.d)) {
                    this.f4024f = 4;
                    return;
                }
                this.f4023e = 4;
                d dVar = this.f4022a;
                if (dVar != null) {
                    dVar.f(this);
                }
                if (!t2.h.a(this.f4024f)) {
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y.c
    public final void g() {
        synchronized (this.b) {
            try {
                this.f4025g = true;
                if (this.f4023e != 4 && this.f4024f != 1) {
                    this.f4024f = 1;
                    this.d.g();
                }
                if (this.f4025g && this.f4023e != 1) {
                    this.f4023e = 1;
                    this.c.g();
                }
                this.f4025g = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y.d
    public final d getRoot() {
        d dVar;
        synchronized (this.b) {
            try {
                d dVar2 = this.f4022a;
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
        synchronized (this.b) {
            try {
                d dVar = this.f4022a;
                if ((dVar != null && !dVar.h(this)) || (!cVar.equals(this.c) && this.f4023e == 4)) {
                    z3 = false;
                }
                z3 = true;
            } finally {
            }
        }
        return z3;
    }

    @Override // y.c
    public final boolean i() {
        boolean z3;
        synchronized (this.b) {
            if (this.f4023e == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    @Override // y.c
    public final boolean isRunning() {
        boolean z3;
        synchronized (this.b) {
            z3 = true;
            if (this.f4023e != 1) {
                z3 = false;
            }
        }
        return z3;
    }

    @Override // y.c
    public final boolean j(c cVar) {
        if (!(cVar instanceof h)) {
            return false;
        }
        h hVar = (h) cVar;
        if (this.c == null) {
            if (hVar.c != null) {
                return false;
            }
        } else if (!this.c.j(hVar.c)) {
            return false;
        }
        if (this.d == null) {
            if (hVar.d != null) {
                return false;
            }
        } else if (!this.d.j(hVar.d)) {
            return false;
        }
        return true;
    }

    @Override // y.c
    public final void pause() {
        synchronized (this.b) {
            try {
                if (!t2.h.a(this.f4024f)) {
                    this.f4024f = 2;
                    this.d.pause();
                }
                if (!t2.h.a(this.f4023e)) {
                    this.f4023e = 2;
                    this.c.pause();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
