package l2;

import java.util.AbstractSet;
import java.util.Iterator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i extends AbstractSet {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2695a;
    public final /* synthetic */ k b;

    public /* synthetic */ i(k kVar, int i3) {
        this.f2695a = i3;
        this.b = kVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f2695a) {
            case 0:
                this.b.clear();
                return;
            default:
                this.b.clear();
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean contains(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r4.f2695a
            switch(r0) {
                case 0: goto Lc;
                default: goto L5;
            }
        L5:
            l2.k r0 = r4.b
            boolean r5 = r0.containsKey(r5)
            return r5
        Lc:
            boolean r0 = r5 instanceof java.util.Map.Entry
            r1 = 0
            if (r0 == 0) goto L3c
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            l2.k r0 = r4.b
            r0.getClass()
            java.lang.Object r2 = r5.getKey()
            r3 = 0
            if (r2 == 0) goto L25
            l2.j r0 = r0.a(r2, r1)     // Catch: java.lang.ClassCastException -> L24
            goto L26
        L24:
        L25:
            r0 = r3
        L26:
            if (r0 == 0) goto L39
            java.lang.Object r2 = r0.f2699g
            java.lang.Object r5 = r5.getValue()
            if (r2 == r5) goto L38
            if (r2 == 0) goto L39
            boolean r5 = r2.equals(r5)
            if (r5 == 0) goto L39
        L38:
            r3 = r0
        L39:
            if (r3 == 0) goto L3c
            r1 = 1
        L3c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.i.contains(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f2695a) {
            case 0:
                return new h(this.b, 0);
            default:
                return new h(this.b, 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean remove(java.lang.Object r6) {
        /*
            r5 = this;
            int r0 = r5.f2695a
            switch(r0) {
                case 0: goto L1e;
                default: goto L5;
            }
        L5:
            l2.k r0 = r5.b
            r0.getClass()
            r1 = 0
            r2 = 0
            if (r6 == 0) goto L14
            l2.j r2 = r0.a(r6, r1)     // Catch: java.lang.ClassCastException -> L13
            goto L14
        L13:
        L14:
            r6 = 1
            if (r2 == 0) goto L1a
            r0.c(r2, r6)
        L1a:
            if (r2 == 0) goto L1d
            r1 = 1
        L1d:
            return r1
        L1e:
            boolean r0 = r6 instanceof java.util.Map.Entry
            r1 = 0
            if (r0 != 0) goto L24
            goto L53
        L24:
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            l2.k r0 = r5.b
            r0.getClass()
            java.lang.Object r2 = r6.getKey()
            r3 = 0
            if (r2 == 0) goto L38
            l2.j r2 = r0.a(r2, r1)     // Catch: java.lang.ClassCastException -> L37
            goto L39
        L37:
        L38:
            r2 = r3
        L39:
            if (r2 == 0) goto L4c
            java.lang.Object r4 = r2.f2699g
            java.lang.Object r6 = r6.getValue()
            if (r4 == r6) goto L4b
            if (r4 == 0) goto L4c
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L4c
        L4b:
            r3 = r2
        L4c:
            if (r3 != 0) goto L4f
            goto L53
        L4f:
            r1 = 1
            r0.c(r3, r1)
        L53:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.i.remove(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f2695a) {
            case 0:
                return this.b.c;
            default:
                return this.b.c;
        }
    }
}
