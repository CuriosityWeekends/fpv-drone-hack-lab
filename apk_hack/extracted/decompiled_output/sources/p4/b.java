package p4;

import java.util.Collection;
import java.util.Objects;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements h4.c, i4.a {

    /* renamed from: a  reason: collision with root package name */
    public final h4.c f3228a;
    public final int b;
    public final k4.c c;
    public Collection d;

    /* renamed from: e  reason: collision with root package name */
    public int f3229e;

    /* renamed from: f  reason: collision with root package name */
    public i4.a f3230f;

    public b(h4.c cVar, int i3, k4.c cVar2) {
        this.f3228a = cVar;
        this.b = i3;
        this.c = cVar2;
    }

    @Override // h4.c
    public final void a(i4.a aVar) {
        if (l4.a.c(this.f3230f, aVar)) {
            this.f3230f = aVar;
            this.f3228a.a(this);
        }
    }

    @Override // h4.c
    public final void b(Throwable th) {
        this.d = null;
        this.f3228a.b(th);
    }

    @Override // h4.c
    public final void c(Object obj) {
        Collection collection = this.d;
        if (collection != null) {
            collection.add(obj);
            int i3 = this.f3229e + 1;
            this.f3229e = i3;
            if (i3 >= this.b) {
                this.f3228a.c(collection);
                this.f3229e = 0;
                e();
            }
        }
    }

    @Override // i4.a
    public final void dispose() {
        this.f3230f.dispose();
    }

    public final boolean e() {
        try {
            Object obj = this.c.get();
            Objects.requireNonNull(obj, "Empty buffer supplied");
            this.d = (Collection) obj;
            return true;
        } catch (Throwable th) {
            com.bumptech.glide.c.l(th);
            this.d = null;
            i4.a aVar = this.f3230f;
            h4.c cVar = this.f3228a;
            if (aVar == null) {
                l4.b.c(th, cVar);
                return false;
            }
            aVar.dispose();
            cVar.b(th);
            return false;
        }
    }

    @Override // h4.c
    public final void onComplete() {
        Collection collection = this.d;
        if (collection != null) {
            this.d = null;
            boolean isEmpty = collection.isEmpty();
            h4.c cVar = this.f3228a;
            if (!isEmpty) {
                cVar.c(collection);
            }
            cVar.onComplete();
        }
    }
}
