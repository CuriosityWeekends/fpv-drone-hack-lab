package o4;

import com.bumptech.glide.d;
import h4.c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends AtomicReference implements c, i4.a {
    private static final long serialVersionUID = -7251123623727029452L;

    /* renamed from: a  reason: collision with root package name */
    public final k4.a f3055a;
    public final k4.a b;
    public final j3.a c;
    public final k4.a d;

    public b(k4.a aVar) {
        j3.b bVar = m4.a.f2872e;
        j3.a aVar2 = m4.a.c;
        j3.b bVar2 = m4.a.d;
        this.f3055a = aVar;
        this.b = bVar;
        this.c = aVar2;
        this.d = bVar2;
    }

    @Override // h4.c
    public final void a(i4.a aVar) {
        if (l4.a.b(this, aVar)) {
            try {
                this.d.accept(this);
            } catch (Throwable th) {
                com.bumptech.glide.c.l(th);
                aVar.dispose();
                b(th);
            }
        }
    }

    @Override // h4.c
    public final void b(Throwable th) {
        Object obj = get();
        l4.a aVar = l4.a.f2725a;
        if (obj == aVar) {
            d.i(th);
            return;
        }
        lazySet(aVar);
        try {
            this.b.accept(th);
        } catch (Throwable th2) {
            com.bumptech.glide.c.l(th2);
            d.i(new j4.c(th, th2));
        }
    }

    @Override // h4.c
    public final void c(Object obj) {
        if (get() != l4.a.f2725a) {
            try {
                this.f3055a.accept(obj);
            } catch (Throwable th) {
                com.bumptech.glide.c.l(th);
                ((i4.a) get()).dispose();
                b(th);
            }
        }
    }

    @Override // i4.a
    public final void dispose() {
        l4.a.a(this);
    }

    @Override // h4.c
    public final void onComplete() {
        Object obj = get();
        l4.a aVar = l4.a.f2725a;
        if (obj != aVar) {
            lazySet(aVar);
            try {
                this.c.getClass();
            } catch (Throwable th) {
                com.bumptech.glide.c.l(th);
                d.i(th);
            }
        }
    }
}
