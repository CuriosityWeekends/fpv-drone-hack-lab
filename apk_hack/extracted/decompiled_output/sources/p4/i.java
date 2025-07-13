package p4;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i extends AtomicReference implements h4.c {
    private static final long serialVersionUID = -4606175640614850599L;

    /* renamed from: a  reason: collision with root package name */
    public final j f3244a;
    public volatile boolean b;
    public volatile n4.d c;
    public int d;

    public i(j jVar) {
        this.f3244a = jVar;
    }

    @Override // h4.c
    public final void a(i4.a aVar) {
        if (l4.a.b(this, aVar) && (aVar instanceof n4.a)) {
            n4.a aVar2 = (n4.a) aVar;
            int d = aVar2.d(7);
            if (d == 1) {
                this.d = d;
                this.c = aVar2;
                this.b = true;
                this.f3244a.g();
            } else if (d == 2) {
                this.d = d;
                this.c = aVar2;
            }
        }
    }

    @Override // h4.c
    public final void b(Throwable th) {
        if (this.f3244a.f3250h.a(th)) {
            j jVar = this.f3244a;
            if (!jVar.c) {
                jVar.f();
            }
            this.b = true;
            this.f3244a.g();
        }
    }

    @Override // h4.c
    public final void c(Object obj) {
        if (this.d == 0) {
            j jVar = this.f3244a;
            if (jVar.get() == 0 && jVar.compareAndSet(0, 1)) {
                jVar.f3246a.c(obj);
                if (jVar.decrementAndGet() == 0) {
                    return;
                }
            } else {
                n4.d dVar = this.c;
                if (dVar == null) {
                    dVar = new q4.b(jVar.f3247e);
                    this.c = dVar;
                }
                dVar.a(obj);
                if (jVar.getAndIncrement() != 0) {
                    return;
                }
            }
            jVar.h();
            return;
        }
        this.f3244a.g();
    }

    @Override // h4.c
    public final void onComplete() {
        this.b = true;
        this.f3244a.g();
    }
}
