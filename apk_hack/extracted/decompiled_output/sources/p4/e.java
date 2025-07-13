package p4;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e extends AtomicReference implements h4.c {
    private static final long serialVersionUID = -7449079488798789337L;

    /* renamed from: a  reason: collision with root package name */
    public final h4.c f3235a;
    public final f b;

    public e(s4.a aVar, f fVar) {
        this.f3235a = aVar;
        this.b = fVar;
    }

    @Override // h4.c
    public final void a(i4.a aVar) {
        while (true) {
            i4.a aVar2 = (i4.a) get();
            if (aVar2 == l4.a.f2725a) {
                if (aVar != null) {
                    aVar.dispose();
                    return;
                }
                return;
            }
            while (!compareAndSet(aVar2, aVar)) {
                if (get() != aVar2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // h4.c
    public final void b(Throwable th) {
        this.b.dispose();
        this.f3235a.b(th);
    }

    @Override // h4.c
    public final void c(Object obj) {
        this.f3235a.c(obj);
    }

    @Override // h4.c
    public final void onComplete() {
        f fVar = this.b;
        fVar.f3239g = false;
        fVar.e();
    }
}
