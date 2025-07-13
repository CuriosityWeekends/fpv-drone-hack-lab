package p4;

import android.os.Looper;
import android.view.View;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m extends h4.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3261a;
    public final Object b;

    public /* synthetic */ m(int i3, Object obj) {
        this.f3261a = i3;
        this.b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.concurrent.atomic.AtomicReference, i4.a] */
    @Override // h4.b
    public final void h(h4.c cVar) {
        boolean equals;
        switch (this.f3261a) {
            case 0:
                Object[] objArr = (Object[]) this.b;
                l lVar = new l(cVar, objArr);
                cVar.a(lVar);
                if (!lVar.d) {
                    int length = objArr.length;
                    for (int i3 = 0; i3 < length && !lVar.f3260e; i3++) {
                        Object obj = objArr[i3];
                        if (obj == null) {
                            h4.c cVar2 = lVar.f3259a;
                            cVar2.b(new NullPointerException("The element at index " + i3 + " is null"));
                            return;
                        }
                        lVar.f3259a.c(obj);
                    }
                    if (!lVar.f3260e) {
                        lVar.f3259a.onComplete();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                try {
                    Iterator it = ((Iterable) this.b).iterator();
                    try {
                        if (!it.hasNext()) {
                            cVar.a(l4.b.f2726a);
                            cVar.onComplete();
                            return;
                        }
                        n nVar = new n(cVar, it);
                        cVar.a(nVar);
                        if (!nVar.d) {
                            while (!nVar.c) {
                                try {
                                    Object next = nVar.b.next();
                                    Objects.requireNonNull(next, "The iterator returned a null value");
                                    nVar.f3262a.c(next);
                                    if (!nVar.c) {
                                        try {
                                            if (!nVar.b.hasNext()) {
                                                if (!nVar.c) {
                                                    nVar.f3262a.onComplete();
                                                    return;
                                                }
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            com.bumptech.glide.c.l(th);
                                            nVar.f3262a.b(th);
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    com.bumptech.glide.c.l(th2);
                                    nVar.f3262a.b(th2);
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        com.bumptech.glide.c.l(th3);
                        l4.b.c(th3, cVar);
                        return;
                    }
                } catch (Throwable th4) {
                    com.bumptech.glide.c.l(th4);
                    l4.b.c(th4, cVar);
                    return;
                }
            default:
                j4.b.d(cVar, "observer");
                Looper myLooper = Looper.myLooper();
                Looper mainLooper = Looper.getMainLooper();
                if (myLooper == null) {
                    if (mainLooper == null) {
                        equals = true;
                    } else {
                        equals = false;
                    }
                } else {
                    equals = myLooper.equals(mainLooper);
                }
                if (!equals) {
                    cVar.a(new AtomicReference(m4.a.b));
                    StringBuilder sb = new StringBuilder("Expected to be called on the main thread but was ");
                    Thread currentThread = Thread.currentThread();
                    if (currentThread != null) {
                        sb.append(currentThread.getName());
                        cVar.b(new IllegalStateException(sb.toString()));
                        return;
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("Thread.currentThread() must not be null");
                    j4.b.v(illegalStateException);
                    throw illegalStateException;
                }
                View view = (View) this.b;
                q2.a aVar = new q2.a(view, cVar);
                cVar.a(aVar);
                view.setOnClickListener(aVar);
                return;
        }
    }

    public m(View view) {
        this.f3261a = 2;
        j4.b.d(view, "view");
        this.b = view;
    }
}
