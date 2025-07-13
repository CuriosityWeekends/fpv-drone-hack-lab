package i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2128a;
    public final y.f b;
    public final /* synthetic */ w c;

    public /* synthetic */ t(w wVar, y.f fVar, int i3) {
        this.f2128a = i3;
        this.c = wVar;
        this.b = fVar;
    }

    private final void a() {
        y.g gVar = (y.g) this.b;
        gVar.b.d();
        synchronized (gVar.c) {
            synchronized (this.c) {
                v vVar = this.c.f2132a;
                y.f fVar = this.b;
                vVar.getClass();
                if (vVar.f2130a.contains(new u(fVar, c0.g.b))) {
                    w wVar = this.c;
                    y.f fVar2 = this.b;
                    wVar.getClass();
                    try {
                        ((y.g) fVar2).h(wVar.f2146t, 5);
                    } catch (Throwable th) {
                        throw new c(th);
                    }
                }
                this.c.d();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2128a) {
            case 0:
                a();
                return;
            default:
                y.g gVar = (y.g) this.b;
                gVar.b.d();
                synchronized (gVar.c) {
                    synchronized (this.c) {
                        v vVar = this.c.f2132a;
                        y.f fVar = this.b;
                        vVar.getClass();
                        if (vVar.f2130a.contains(new u(fVar, c0.g.b))) {
                            this.c.f2148v.b();
                            w wVar = this.c;
                            y.f fVar2 = this.b;
                            wVar.getClass();
                            ((y.g) fVar2).k(wVar.f2148v, wVar.f2145r, wVar.f2150y);
                            this.c.j(this.b);
                        }
                        this.c.d();
                    }
                }
                return;
        }
    }
}
