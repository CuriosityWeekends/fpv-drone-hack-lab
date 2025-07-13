package p4;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends AtomicBoolean implements h4.c, i4.a {
    private static final long serialVersionUID = -8223395059921494546L;

    /* renamed from: a  reason: collision with root package name */
    public final h4.c f3231a;
    public final int b;
    public final int c;
    public final k4.c d;

    /* renamed from: e  reason: collision with root package name */
    public i4.a f3232e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayDeque f3233f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    public long f3234g;

    public c(h4.c cVar, int i3, int i5, k4.c cVar2) {
        this.f3231a = cVar;
        this.b = i3;
        this.c = i5;
        this.d = cVar2;
    }

    @Override // h4.c
    public final void a(i4.a aVar) {
        if (l4.a.c(this.f3232e, aVar)) {
            this.f3232e = aVar;
            this.f3231a.a(this);
        }
    }

    @Override // h4.c
    public final void b(Throwable th) {
        this.f3233f.clear();
        this.f3231a.b(th);
    }

    @Override // h4.c
    public final void c(Object obj) {
        long j2 = this.f3234g;
        this.f3234g = 1 + j2;
        h4.c cVar = this.f3231a;
        ArrayDeque arrayDeque = this.f3233f;
        if (j2 % this.c == 0) {
            try {
                Object obj2 = this.d.get();
                if (obj2 != null) {
                    r4.c cVar2 = r4.d.f3456a;
                    arrayDeque.offer((Collection) obj2);
                } else {
                    throw r4.d.a("The bufferSupplier returned a null Collection.");
                }
            } catch (Throwable th) {
                com.bumptech.glide.c.l(th);
                arrayDeque.clear();
                this.f3232e.dispose();
                cVar.b(th);
                return;
            }
        }
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            Collection collection = (Collection) it.next();
            collection.add(obj);
            if (this.b <= collection.size()) {
                it.remove();
                cVar.c(collection);
            }
        }
    }

    @Override // i4.a
    public final void dispose() {
        this.f3232e.dispose();
    }

    @Override // h4.c
    public final void onComplete() {
        while (true) {
            ArrayDeque arrayDeque = this.f3233f;
            boolean isEmpty = arrayDeque.isEmpty();
            h4.c cVar = this.f3231a;
            if (!isEmpty) {
                cVar.c(arrayDeque.poll());
            } else {
                cVar.onComplete();
                return;
            }
        }
    }
}
