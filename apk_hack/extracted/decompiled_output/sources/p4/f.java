package p4;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f extends AtomicInteger implements h4.c, i4.a {
    private static final long serialVersionUID = 8828587559905699186L;

    /* renamed from: a  reason: collision with root package name */
    public final h4.c f3236a;
    public final k4.b b;
    public final e c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public n4.d f3237e;

    /* renamed from: f  reason: collision with root package name */
    public i4.a f3238f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f3239g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f3240h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f3241i;

    /* renamed from: j  reason: collision with root package name */
    public int f3242j;

    public f(s4.a aVar, int i3) {
        j3.a aVar2 = m4.a.f2871a;
        this.f3236a = aVar;
        this.b = aVar2;
        this.d = i3;
        this.c = new e(aVar, this);
    }

    @Override // h4.c
    public final void a(i4.a aVar) {
        if (l4.a.c(this.f3238f, aVar)) {
            this.f3238f = aVar;
            if (aVar instanceof n4.a) {
                n4.a aVar2 = (n4.a) aVar;
                int d = aVar2.d(3);
                if (d == 1) {
                    this.f3242j = d;
                    this.f3237e = aVar2;
                    this.f3241i = true;
                    this.f3236a.a(this);
                    e();
                    return;
                } else if (d == 2) {
                    this.f3242j = d;
                    this.f3237e = aVar2;
                    this.f3236a.a(this);
                    return;
                }
            }
            this.f3237e = new q4.b(this.d);
            this.f3236a.a(this);
        }
    }

    @Override // h4.c
    public final void b(Throwable th) {
        if (this.f3241i) {
            com.bumptech.glide.d.i(th);
            return;
        }
        this.f3241i = true;
        dispose();
        this.f3236a.b(th);
    }

    @Override // h4.c
    public final void c(Object obj) {
        if (this.f3241i) {
            return;
        }
        if (this.f3242j == 0) {
            this.f3237e.a(obj);
        }
        e();
    }

    @Override // i4.a
    public final void dispose() {
        this.f3240h = true;
        e eVar = this.c;
        eVar.getClass();
        l4.a.a(eVar);
        this.f3238f.dispose();
        if (getAndIncrement() == 0) {
            this.f3237e.clear();
        }
    }

    public final void e() {
        boolean z3;
        if (getAndIncrement() != 0) {
            return;
        }
        while (!this.f3240h) {
            if (!this.f3239g) {
                boolean z5 = this.f3241i;
                try {
                    Object b = this.f3237e.b();
                    if (b == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z5 && z3) {
                        this.f3240h = true;
                        this.f3236a.onComplete();
                        return;
                    } else if (!z3) {
                        try {
                            Object apply = this.b.apply(b);
                            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                            h4.b bVar = (h4.b) apply;
                            this.f3239g = true;
                            bVar.g(this.c);
                        } catch (Throwable th) {
                            com.bumptech.glide.c.l(th);
                            dispose();
                            this.f3237e.clear();
                            this.f3236a.b(th);
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    com.bumptech.glide.c.l(th2);
                    dispose();
                    this.f3237e.clear();
                    this.f3236a.b(th2);
                    return;
                }
            }
            if (decrementAndGet() == 0) {
                return;
            }
        }
        this.f3237e.clear();
    }

    @Override // h4.c
    public final void onComplete() {
        if (this.f3241i) {
            return;
        }
        this.f3241i = true;
        e();
    }
}
