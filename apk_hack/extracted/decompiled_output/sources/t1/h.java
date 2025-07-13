package t1;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import s1.i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class h implements s1.f {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayDeque f3681a = new ArrayDeque();
    public final ArrayDeque b;
    public final PriorityQueue c;
    public g d;

    /* renamed from: e  reason: collision with root package name */
    public long f3682e;

    /* renamed from: f  reason: collision with root package name */
    public long f3683f;

    public h() {
        for (int i3 = 0; i3 < 10; i3++) {
            this.f3681a.add(new m0.d(1));
        }
        this.b = new ArrayDeque();
        for (int i5 = 0; i5 < 2; i5++) {
            this.b.add(new s1.d(this, 1));
        }
        this.c = new PriorityQueue();
    }

    @Override // s1.f
    public final void a(long j2) {
        this.f3682e = j2;
    }

    @Override // m0.b
    public final void b(Object obj) {
        boolean z3;
        i iVar = (i) obj;
        if (iVar == this.d) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.e(z3);
        if (iVar.isDecodeOnly()) {
            g gVar = this.d;
            gVar.clear();
            this.f3681a.add(gVar);
        } else {
            g gVar2 = this.d;
            long j2 = this.f3683f;
            this.f3683f = 1 + j2;
            gVar2.f3680g = j2;
            this.c.add(gVar2);
        }
        this.d = null;
    }

    @Override // m0.b
    public final Object c() {
        ArrayDeque arrayDeque = this.b;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        while (true) {
            PriorityQueue priorityQueue = this.c;
            if (priorityQueue.isEmpty() || ((g) priorityQueue.peek()).c > this.f3682e) {
                return null;
            }
            g gVar = (g) priorityQueue.poll();
            boolean isEndOfStream = gVar.isEndOfStream();
            ArrayDeque arrayDeque2 = this.f3681a;
            if (isEndOfStream) {
                s1.d dVar = (s1.d) arrayDeque.pollFirst();
                dVar.addFlag(4);
                gVar.clear();
                arrayDeque2.add(gVar);
                return dVar;
            }
            f(gVar);
            if (g()) {
                a2.c e5 = e();
                if (!gVar.isDecodeOnly()) {
                    s1.d dVar2 = (s1.d) arrayDeque.pollFirst();
                    long j2 = gVar.c;
                    dVar2.timeUs = j2;
                    dVar2.f3502a = e5;
                    dVar2.b = j2;
                    gVar.clear();
                    arrayDeque2.add(gVar);
                    return dVar2;
                }
            }
            gVar.clear();
            arrayDeque2.add(gVar);
        }
    }

    @Override // m0.b
    public final Object d() {
        boolean z3;
        if (this.d == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.h(z3);
        ArrayDeque arrayDeque = this.f3681a;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        g gVar = (g) arrayDeque.pollFirst();
        this.d = gVar;
        return gVar;
    }

    public abstract a2.c e();

    public abstract void f(g gVar);

    @Override // m0.b
    public void flush() {
        ArrayDeque arrayDeque;
        this.f3683f = 0L;
        this.f3682e = 0L;
        while (true) {
            PriorityQueue priorityQueue = this.c;
            boolean isEmpty = priorityQueue.isEmpty();
            arrayDeque = this.f3681a;
            if (isEmpty) {
                break;
            }
            g gVar = (g) priorityQueue.poll();
            gVar.clear();
            arrayDeque.add(gVar);
        }
        g gVar2 = this.d;
        if (gVar2 != null) {
            gVar2.clear();
            arrayDeque.add(gVar2);
            this.d = null;
        }
    }

    public abstract boolean g();

    @Override // m0.b
    public void release() {
    }
}
