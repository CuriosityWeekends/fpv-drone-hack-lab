package l0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class x extends q {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0083 A[LOOP:3: B:25:0x0083->B:26:0x0085, LOOP_START, PHI: r0 
      PHI: (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:13:0x0032, B:26:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // l0.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(java.nio.ByteBuffer r9) {
        /*
            r8 = this;
            int r0 = r9.position()
            int r1 = r9.limit()
            int r2 = r1 - r0
            l0.d r3 = r8.b
            int r3 = r3.c
            r4 = 3
            r5 = 805306368(0x30000000, float:4.656613E-10)
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            r7 = 268435456(0x10000000, float:2.524355E-29)
            if (r3 == r4) goto L28
            if (r3 == r7) goto L2a
            if (r3 == r6) goto L26
            if (r3 != r5) goto L20
            int r2 = r2 / 2
            goto L2a
        L20:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L26:
            int r2 = r2 / 3
        L28:
            int r2 = r2 * 2
        L2a:
            java.nio.ByteBuffer r2 = r8.j(r2)
            l0.d r3 = r8.b
            int r3 = r3.c
            if (r3 == r4) goto L83
            if (r3 == r7) goto L6e
            if (r3 == r6) goto L57
            if (r3 != r5) goto L51
        L3a:
            if (r0 >= r1) goto L98
            int r3 = r0 + 2
            byte r3 = r9.get(r3)
            r2.put(r3)
            int r3 = r0 + 3
            byte r3 = r9.get(r3)
            r2.put(r3)
            int r0 = r0 + 4
            goto L3a
        L51:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L57:
            if (r0 >= r1) goto L98
            int r3 = r0 + 1
            byte r3 = r9.get(r3)
            r2.put(r3)
            int r3 = r0 + 2
            byte r3 = r9.get(r3)
            r2.put(r3)
            int r0 = r0 + 3
            goto L57
        L6e:
            if (r0 >= r1) goto L98
            int r3 = r0 + 1
            byte r3 = r9.get(r3)
            r2.put(r3)
            byte r3 = r9.get(r0)
            r2.put(r3)
            int r0 = r0 + 2
            goto L6e
        L83:
            if (r0 >= r1) goto L98
            r3 = 0
            r2.put(r3)
            byte r3 = r9.get(r0)
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 + (-128)
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 1
            goto L83
        L98:
            int r0 = r9.limit()
            r9.position(r0)
            r2.flip()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.x.e(java.nio.ByteBuffer):void");
    }

    @Override // l0.q
    public final d f(d dVar) {
        int i3 = dVar.c;
        if (i3 != 3 && i3 != 2 && i3 != 268435456 && i3 != 536870912 && i3 != 805306368) {
            throw new e(dVar);
        }
        if (i3 != 2) {
            return new d(dVar.f2534a, dVar.b, 2);
        }
        return d.f2533e;
    }
}
