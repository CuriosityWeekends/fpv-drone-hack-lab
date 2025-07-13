package s4;

import com.bumptech.glide.d;
import h4.c;
import r4.e;
import r4.f;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements c, i4.a {

    /* renamed from: a  reason: collision with root package name */
    public final c f3545a;
    public i4.a b;
    public boolean c;
    public r0.a d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f3546e;

    public a(c cVar) {
        this.f3545a = cVar;
    }

    @Override // h4.c
    public final void a(i4.a aVar) {
        if (l4.a.c(this.b, aVar)) {
            this.b = aVar;
            this.f3545a.a(this);
        }
    }

    @Override // h4.c
    public final void b(Throwable th) {
        if (this.f3546e) {
            d.i(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z3 = true;
                if (!this.f3546e) {
                    if (this.c) {
                        this.f3546e = true;
                        r0.a aVar = this.d;
                        if (aVar == null) {
                            aVar = new r0.a();
                            this.d = aVar;
                        }
                        ((Object[]) aVar.c)[0] = new e(th);
                        return;
                    }
                    this.f3546e = true;
                    this.c = true;
                    z3 = false;
                }
                if (z3) {
                    d.i(th);
                } else {
                    this.f3545a.b(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // h4.c
    public final void c(Object obj) {
        if (this.f3546e) {
            return;
        }
        if (obj == null) {
            this.b.dispose();
            b(r4.d.a("onNext called with a null value."));
            return;
        }
        synchronized (this) {
            try {
                if (this.f3546e) {
                    return;
                }
                if (this.c) {
                    r0.a aVar = this.d;
                    if (aVar == null) {
                        aVar = new r0.a();
                        this.d = aVar;
                    }
                    aVar.a(obj);
                    return;
                }
                this.c = true;
                this.f3545a.c(obj);
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // i4.a
    public final void dispose() {
        this.f3546e = true;
        this.b.dispose();
    }

    public final void e() {
        Object obj;
        while (true) {
            synchronized (this) {
                try {
                    r0.a aVar = this.d;
                    if (aVar == null) {
                        this.c = false;
                        return;
                    }
                    this.d = null;
                    c cVar = this.f3545a;
                    for (Object[] objArr = (Object[]) aVar.c; objArr != null; objArr = (Object[]) objArr[4]) {
                        for (int i3 = 0; i3 < 4 && (obj = objArr[i3]) != null; i3++) {
                            if (obj == f.f3458a) {
                                cVar.onComplete();
                                return;
                            } else if (obj instanceof e) {
                                cVar.b(((e) obj).f3457a);
                                return;
                            } else {
                                cVar.c(obj);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // h4.c
    public final void onComplete() {
        if (this.f3546e) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f3546e) {
                    return;
                }
                if (this.c) {
                    r0.a aVar = this.d;
                    if (aVar == null) {
                        aVar = new r0.a();
                        this.d = aVar;
                    }
                    aVar.a(f.f3458a);
                    return;
                }
                this.f3546e = true;
                this.c = true;
                this.f3545a.onComplete();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
