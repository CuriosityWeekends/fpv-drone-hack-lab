package p4;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j extends AtomicInteger implements i4.a, h4.c {

    /* renamed from: p  reason: collision with root package name */
    public static final i[] f3245p = new i[0];
    public static final i[] q = new i[0];
    private static final long serialVersionUID = -2117620485640801370L;

    /* renamed from: a  reason: collision with root package name */
    public final h4.c f3246a;
    public final k4.b b;
    public final boolean c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3247e;

    /* renamed from: f  reason: collision with root package name */
    public volatile n4.c f3248f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f3249g;

    /* renamed from: h  reason: collision with root package name */
    public final r4.b f3250h = new AtomicReference();

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f3251i;

    /* renamed from: j  reason: collision with root package name */
    public final AtomicReference f3252j;

    /* renamed from: k  reason: collision with root package name */
    public i4.a f3253k;

    /* renamed from: l  reason: collision with root package name */
    public long f3254l;

    /* renamed from: m  reason: collision with root package name */
    public int f3255m;

    /* renamed from: n  reason: collision with root package name */
    public final ArrayDeque f3256n;

    /* renamed from: o  reason: collision with root package name */
    public int f3257o;

    /* JADX WARN: Type inference failed for: r0v0, types: [r4.b, java.util.concurrent.atomic.AtomicReference] */
    public j(h4.c cVar, k4.b bVar, boolean z3, int i3, int i5) {
        this.f3246a = cVar;
        this.b = bVar;
        this.c = z3;
        this.d = i3;
        this.f3247e = i5;
        if (i3 != Integer.MAX_VALUE) {
            this.f3256n = new ArrayDeque(i3);
        }
        this.f3252j = new AtomicReference(f3245p);
    }

    @Override // h4.c
    public final void a(i4.a aVar) {
        if (l4.a.c(this.f3253k, aVar)) {
            this.f3253k = aVar;
            this.f3246a.a(this);
        }
    }

    @Override // h4.c
    public final void b(Throwable th) {
        if (this.f3249g) {
            com.bumptech.glide.d.i(th);
        } else if (this.f3250h.a(th)) {
            this.f3249g = true;
            g();
        }
    }

    @Override // h4.c
    public final void c(Object obj) {
        if (this.f3249g) {
            return;
        }
        try {
            Object apply = this.b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
            h4.b bVar = (h4.b) apply;
            if (this.d != Integer.MAX_VALUE) {
                synchronized (this) {
                    try {
                        int i3 = this.f3257o;
                        if (i3 == this.d) {
                            this.f3256n.offer(bVar);
                            return;
                        }
                        this.f3257o = i3 + 1;
                    } finally {
                    }
                }
            }
            j(bVar);
        } catch (Throwable th) {
            com.bumptech.glide.c.l(th);
            this.f3253k.dispose();
            b(th);
        }
    }

    @Override // i4.a
    public final void dispose() {
        this.f3251i = true;
        if (f()) {
            r4.b bVar = this.f3250h;
            bVar.getClass();
            r4.c cVar = r4.d.f3456a;
            Throwable th = (Throwable) bVar.get();
            r4.c cVar2 = r4.d.f3456a;
            if (th != cVar2) {
                th = (Throwable) bVar.getAndSet(cVar2);
            }
            if (th != null && th != cVar2) {
                com.bumptech.glide.d.i(th);
            }
        }
    }

    public final boolean e() {
        if (this.f3251i) {
            return true;
        }
        Throwable th = (Throwable) this.f3250h.get();
        if (!this.c && th != null) {
            f();
            this.f3250h.b(this.f3246a);
            return true;
        }
        return false;
    }

    public final boolean f() {
        this.f3253k.dispose();
        AtomicReference atomicReference = this.f3252j;
        i[] iVarArr = q;
        i[] iVarArr2 = (i[]) atomicReference.getAndSet(iVarArr);
        if (iVarArr2 == iVarArr) {
            return false;
        }
        for (i iVar : iVarArr2) {
            iVar.getClass();
            l4.a.a(iVar);
        }
        return true;
    }

    public final void g() {
        if (getAndIncrement() == 0) {
            h();
        }
    }

    public final void h() {
        int i3;
        h4.c cVar = this.f3246a;
        int i5 = 1;
        while (!e()) {
            n4.c cVar2 = this.f3248f;
            int i6 = 0;
            if (cVar2 != null) {
                while (!e()) {
                    Object b = cVar2.b();
                    if (b != null) {
                        cVar.c(b);
                        i6++;
                    }
                }
                return;
            }
            if (i6 != 0) {
                if (this.d != Integer.MAX_VALUE) {
                    k(i6);
                }
            } else {
                boolean z3 = this.f3249g;
                n4.c cVar3 = this.f3248f;
                i[] iVarArr = (i[]) this.f3252j.get();
                int length = iVarArr.length;
                if (this.d != Integer.MAX_VALUE) {
                    synchronized (this) {
                        i3 = this.f3256n.size();
                    }
                } else {
                    i3 = 0;
                }
                if (z3 && ((cVar3 == null || cVar3.isEmpty()) && length == 0 && i3 == 0)) {
                    this.f3250h.b(this.f3246a);
                    return;
                }
                if (length != 0) {
                    int min = Math.min(length - 1, this.f3255m);
                    for (int i7 = 0; i7 < length; i7++) {
                        if (e()) {
                            return;
                        }
                        i iVar = iVarArr[min];
                        n4.d dVar = iVar.c;
                        if (dVar != null) {
                            while (true) {
                                try {
                                    Object b5 = dVar.b();
                                    if (b5 == null) {
                                        break;
                                    }
                                    cVar.c(b5);
                                    if (e()) {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    com.bumptech.glide.c.l(th);
                                    l4.a.a(iVar);
                                    this.f3250h.a(th);
                                    if (e()) {
                                        return;
                                    }
                                    i(iVar);
                                    i6++;
                                    min++;
                                    if (min != length) {
                                    }
                                }
                            }
                        }
                        boolean z5 = iVar.b;
                        n4.d dVar2 = iVar.c;
                        if (z5 && (dVar2 == null || dVar2.isEmpty())) {
                            i(iVar);
                            i6++;
                        }
                        min++;
                        if (min != length) {
                        }
                        min = 0;
                    }
                    this.f3255m = min;
                }
                if (i6 != 0) {
                    if (this.d != Integer.MAX_VALUE) {
                        k(i6);
                    }
                } else {
                    i5 = addAndGet(-i5);
                    if (i5 == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(i iVar) {
        i[] iVarArr;
        while (true) {
            AtomicReference atomicReference = this.f3252j;
            i[] iVarArr2 = (i[]) atomicReference.get();
            int length = iVarArr2.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (iVarArr2[i3] == iVar) {
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
            if (length == 1) {
                iVarArr = f3245p;
            } else {
                i[] iVarArr3 = new i[length - 1];
                System.arraycopy(iVarArr2, 0, iVarArr3, 0, i3);
                System.arraycopy(iVarArr2, i3 + 1, iVarArr3, i3, (length - i3) - 1);
                iVarArr = iVarArr3;
            }
            while (!atomicReference.compareAndSet(iVarArr2, iVarArr)) {
                if (atomicReference.get() != iVarArr2) {
                    break;
                }
            }
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (decrementAndGet() == 0) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(h4.b r7) {
        /*
            r6 = this;
        L0:
            boolean r0 = r7 instanceof k4.c
            r1 = 0
            if (r0 == 0) goto L7e
            k4.c r7 = (k4.c) r7
            r0 = 1
            r2 = 2147483647(0x7fffffff, float:NaN)
            java.lang.Object r7 = r7.get()     // Catch: java.lang.Throwable -> L51
            if (r7 != 0) goto L12
            goto L5d
        L12:
            int r3 = r6.get()
            if (r3 != 0) goto L2a
            boolean r3 = r6.compareAndSet(r1, r0)
            if (r3 == 0) goto L2a
            h4.c r3 = r6.f3246a
            r3.c(r7)
            int r7 = r6.decrementAndGet()
            if (r7 != 0) goto L4d
            goto L5d
        L2a:
            n4.c r3 = r6.f3248f
            if (r3 != 0) goto L43
            int r3 = r6.d
            if (r3 != r2) goto L3a
            q4.b r3 = new q4.b
            int r4 = r6.f3247e
            r3.<init>(r4)
            goto L41
        L3a:
            q4.a r3 = new q4.a
            int r4 = r6.d
            r3.<init>(r4)
        L41:
            r6.f3248f = r3
        L43:
            r3.a(r7)
            int r7 = r6.getAndIncrement()
            if (r7 == 0) goto L4d
            goto Lad
        L4d:
            r6.h()
            goto L5d
        L51:
            r7 = move-exception
            com.bumptech.glide.c.l(r7)
            r4.b r3 = r6.f3250h
            r3.a(r7)
            r6.g()
        L5d:
            int r7 = r6.d
            if (r7 == r2) goto Lad
            monitor-enter(r6)
            java.util.ArrayDeque r7 = r6.f3256n     // Catch: java.lang.Throwable -> L73
            java.lang.Object r7 = r7.poll()     // Catch: java.lang.Throwable -> L73
            h4.b r7 = (h4.b) r7     // Catch: java.lang.Throwable -> L73
            if (r7 != 0) goto L75
            int r1 = r6.f3257o     // Catch: java.lang.Throwable -> L73
            int r1 = r1 - r0
            r6.f3257o = r1     // Catch: java.lang.Throwable -> L73
            r1 = 1
            goto L75
        L73:
            r7 = move-exception
            goto L7c
        L75:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L73
            if (r1 == 0) goto L0
            r6.g()
            goto Lad
        L7c:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L73
            throw r7
        L7e:
            p4.i r0 = new p4.i
            long r2 = r6.f3254l
            r4 = 1
            long r2 = r2 + r4
            r6.f3254l = r2
            r0.<init>(r6)
        L8a:
            java.util.concurrent.atomic.AtomicReference r2 = r6.f3252j
            java.lang.Object r3 = r2.get()
            p4.i[] r3 = (p4.i[]) r3
            p4.i[] r4 = p4.j.q
            if (r3 != r4) goto L9a
            l4.a.a(r0)
            goto Lad
        L9a:
            int r4 = r3.length
            int r5 = r4 + 1
            p4.i[] r5 = new p4.i[r5]
            java.lang.System.arraycopy(r3, r1, r5, r1, r4)
            r5[r4] = r0
        La4:
            boolean r4 = r2.compareAndSet(r3, r5)
            if (r4 == 0) goto Lae
            r7.g(r0)
        Lad:
            return
        Lae:
            java.lang.Object r4 = r2.get()
            if (r4 == r3) goto La4
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: p4.j.j(h4.b):void");
    }

    public final void k(int i3) {
        while (true) {
            int i5 = i3 - 1;
            if (i3 != 0) {
                synchronized (this) {
                    try {
                        h4.b bVar = (h4.b) this.f3256n.poll();
                        if (bVar == null) {
                            this.f3257o--;
                        } else {
                            j(bVar);
                        }
                    } finally {
                    }
                }
                i3 = i5;
            } else {
                return;
            }
        }
    }

    @Override // h4.c
    public final void onComplete() {
        if (this.f3249g) {
            return;
        }
        this.f3249g = true;
        g();
    }
}
