package p4;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p extends AtomicInteger implements n4.a, Runnable {
    private static final long serialVersionUID = 3880992722410194083L;

    /* renamed from: a  reason: collision with root package name */
    public final h4.c f3266a;
    public final Object b;

    public p(h4.c cVar, Object obj) {
        this.f3266a = cVar;
        this.b = obj;
    }

    @Override // n4.d
    public final boolean a(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // n4.d
    public final Object b() {
        if (get() == 1) {
            lazySet(3);
            return this.b;
        }
        return null;
    }

    @Override // n4.d
    public final void clear() {
        lazySet(3);
    }

    @Override // n4.a
    public final int d(int i3) {
        lazySet(1);
        return 1;
    }

    @Override // i4.a
    public final void dispose() {
        set(3);
    }

    @Override // n4.d
    public final boolean isEmpty() {
        if (get() != 1) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (get() == 0 && compareAndSet(0, 2)) {
            Object obj = this.b;
            h4.c cVar = this.f3266a;
            cVar.c(obj);
            if (get() == 2) {
                lazySet(3);
                cVar.onComplete();
            }
        }
    }
}
