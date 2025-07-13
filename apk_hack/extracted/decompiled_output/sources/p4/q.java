package p4;

import java.util.Objects;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class q extends h4.b {

    /* renamed from: a  reason: collision with root package name */
    public final Object f3267a;
    public final k4.b b;

    public q(Object obj, k4.b bVar) {
        this.f3267a = obj;
        this.b = bVar;
    }

    @Override // h4.b
    public final void h(h4.c cVar) {
        try {
            Object apply = this.b.apply(this.f3267a);
            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
            h4.b bVar = (h4.b) apply;
            if (bVar instanceof k4.c) {
                try {
                    Object obj = ((k4.c) bVar).get();
                    if (obj == null) {
                        cVar.a(l4.b.f2726a);
                        cVar.onComplete();
                        return;
                    }
                    p pVar = new p(cVar, obj);
                    cVar.a(pVar);
                    pVar.run();
                    return;
                } catch (Throwable th) {
                    com.bumptech.glide.c.l(th);
                    l4.b.c(th, cVar);
                    return;
                }
            }
            bVar.g(cVar);
        } catch (Throwable th2) {
            com.bumptech.glide.c.l(th2);
            l4.b.c(th2, cVar);
        }
    }
}
