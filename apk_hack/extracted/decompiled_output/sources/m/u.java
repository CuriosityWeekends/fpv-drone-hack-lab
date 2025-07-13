package m;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class u implements com.bumptech.glide.load.data.e, com.bumptech.glide.load.data.d {

    /* renamed from: a  reason: collision with root package name */
    public final List f2751a;
    public final Pools.Pool b;
    public int c;
    public com.bumptech.glide.j d;

    /* renamed from: e  reason: collision with root package name */
    public com.bumptech.glide.load.data.d f2752e;

    /* renamed from: f  reason: collision with root package name */
    public List f2753f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2754g;

    public u(ArrayList arrayList, Pools.Pool pool) {
        this.b = pool;
        if (!arrayList.isEmpty()) {
            this.f2751a = arrayList;
            this.c = 0;
            return;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        return ((com.bumptech.glide.load.data.e) this.f2751a.get(0)).a();
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        List list = this.f2753f;
        if (list != null) {
            this.b.release(list);
        }
        this.f2753f = null;
        for (com.bumptech.glide.load.data.e eVar : this.f2751a) {
            eVar.b();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void c(com.bumptech.glide.j jVar, com.bumptech.glide.load.data.d dVar) {
        this.d = jVar;
        this.f2752e = dVar;
        this.f2753f = (List) this.b.acquire();
        ((com.bumptech.glide.load.data.e) this.f2751a.get(this.c)).c(jVar, this);
        if (this.f2754g) {
            cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.f2754g = true;
        for (com.bumptech.glide.load.data.e eVar : this.f2751a) {
            eVar.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(Exception exc) {
        List list = this.f2753f;
        c0.g.c(list, "Argument must not be null");
        list.add(exc);
        e();
    }

    public final void e() {
        if (this.f2754g) {
            return;
        }
        if (this.c < this.f2751a.size() - 1) {
            this.c++;
            c(this.d, this.f2752e);
            return;
        }
        c0.g.b(this.f2753f);
        this.f2752e.d(new i.c0("Fetch failed", new ArrayList(this.f2753f)));
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(Object obj) {
        if (obj != null) {
            this.f2752e.f(obj);
        } else {
            e();
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final int getDataSource() {
        return ((com.bumptech.glide.load.data.e) this.f2751a.get(0)).getDataSource();
    }
}
