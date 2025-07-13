package u4;

import h4.c;
import java.util.concurrent.atomic.AtomicReference;
import r4.d;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends h4.b implements c {
    public static final a[] c = new a[0];
    public static final a[] d = new a[0];

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference f3780a = new AtomicReference(d);
    public Throwable b;

    @Override // h4.c
    public final void a(i4.a aVar) {
        if (this.f3780a.get() == c) {
            aVar.dispose();
        }
    }

    @Override // h4.c
    public final void b(Throwable th) {
        if (th != null) {
            r4.c cVar = d.f3456a;
            AtomicReference atomicReference = this.f3780a;
            Object obj = atomicReference.get();
            Object obj2 = c;
            if (obj == obj2) {
                com.bumptech.glide.d.i(th);
                return;
            }
            this.b = th;
            a[] aVarArr = (a[]) atomicReference.getAndSet(obj2);
            for (a aVar : aVarArr) {
                if (aVar.get()) {
                    com.bumptech.glide.d.i(th);
                } else {
                    aVar.f3779a.b(th);
                }
            }
            return;
        }
        throw d.a("onError called with a null Throwable.");
    }

    @Override // h4.c
    public final void c(Object obj) {
        a[] aVarArr;
        if (obj != null) {
            r4.c cVar = d.f3456a;
            for (a aVar : (a[]) this.f3780a.get()) {
                if (!aVar.get()) {
                    aVar.f3779a.c(obj);
                }
            }
            return;
        }
        throw d.a("onNext called with a null value.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h4.b
    public final void h(c cVar) {
        a aVar = new a(cVar, this);
        cVar.a(aVar);
        while (true) {
            AtomicReference atomicReference = this.f3780a;
            a[] aVarArr = (a[]) atomicReference.get();
            if (aVarArr == c) {
                Throwable th = this.b;
                if (th != null) {
                    cVar.b(th);
                    return;
                } else {
                    cVar.onComplete();
                    return;
                }
            }
            int length = aVarArr.length;
            a[] aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
            while (!atomicReference.compareAndSet(aVarArr, aVarArr2)) {
                if (atomicReference.get() != aVarArr) {
                    break;
                }
            }
            if (aVar.get()) {
                i(aVar);
                return;
            }
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(a aVar) {
        a[] aVarArr;
        while (true) {
            AtomicReference atomicReference = this.f3780a;
            a[] aVarArr2 = (a[]) atomicReference.get();
            if (aVarArr2 != c && aVarArr2 != (aVarArr = d)) {
                int length = aVarArr2.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        if (aVarArr2[i3] == aVar) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 < 0) {
                    return;
                }
                if (length != 1) {
                    aVarArr = new a[length - 1];
                    System.arraycopy(aVarArr2, 0, aVarArr, 0, i3);
                    System.arraycopy(aVarArr2, i3 + 1, aVarArr, i3, (length - i3) - 1);
                }
                while (!atomicReference.compareAndSet(aVarArr2, aVarArr)) {
                    if (atomicReference.get() != aVarArr2) {
                        break;
                    }
                }
                return;
            }
            return;
        }
    }

    @Override // h4.c
    public final void onComplete() {
        AtomicReference atomicReference = this.f3780a;
        Object obj = atomicReference.get();
        Object obj2 = c;
        if (obj == obj2) {
            return;
        }
        a[] aVarArr = (a[]) atomicReference.getAndSet(obj2);
        for (a aVar : aVarArr) {
            if (!aVar.get()) {
                aVar.f3779a.onComplete();
            }
        }
    }
}
