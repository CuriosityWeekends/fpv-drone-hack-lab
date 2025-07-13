package r1;

import com.google.android.exoplayer2.Format;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f extends d {

    /* renamed from: e  reason: collision with root package name */
    public Format f3394e;

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0076, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList l(java.lang.String r12) {
        /*
            r0 = 4
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            boolean r2 = android.text.TextUtils.isEmpty(r12)
            if (r2 != 0) goto Lba
            int r2 = g2.w.f1960a
            int r2 = r12.length()
            int r2 = r2 / 2
            byte[] r3 = new byte[r2]
            r4 = 0
            r5 = 0
        L18:
            if (r5 >= r2) goto L38
            int r6 = r5 * 2
            char r7 = r12.charAt(r6)
            r8 = 16
            int r7 = java.lang.Character.digit(r7, r8)
            int r7 = r7 << r0
            int r6 = r6 + 1
            char r6 = r12.charAt(r6)
            int r6 = java.lang.Character.digit(r6, r8)
            int r6 = r6 + r7
            byte r6 = (byte) r6
            r3[r5] = r6
            int r5 = r5 + 1
            goto L18
        L38:
            if (r2 > r0) goto L3b
            goto L46
        L3b:
            r12 = 0
        L3c:
            byte[] r5 = g2.b.f1913a
            if (r12 >= r0) goto L4c
            r6 = r3[r12]
            r5 = r5[r12]
            if (r6 == r5) goto L49
        L46:
            r12 = 0
            goto Lb1
        L49:
            int r12 = r12 + 1
            goto L3c
        L4c:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r6 = 0
        L52:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r12.add(r7)
            int r6 = r6 + r0
            int r7 = r2 + (-4)
        L5c:
            r8 = -1
            if (r6 > r7) goto L75
            int r9 = r2 - r6
            if (r9 > r0) goto L64
            goto L6f
        L64:
            r9 = 0
        L65:
            if (r9 >= r0) goto L76
            int r10 = r6 + r9
            r10 = r3[r10]
            r11 = r5[r9]
            if (r10 == r11) goto L72
        L6f:
            int r6 = r6 + 1
            goto L5c
        L72:
            int r9 = r9 + 1
            goto L65
        L75:
            r6 = -1
        L76:
            if (r6 != r8) goto L52
            int r0 = r12.size()
            byte[][] r0 = new byte[r0]
            r5 = 0
        L7f:
            int r6 = r12.size()
            if (r5 >= r6) goto Lb0
            java.lang.Object r6 = r12.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            int r7 = r12.size()
            int r7 = r7 + (-1)
            if (r5 >= r7) goto La4
            int r7 = r5 + 1
            java.lang.Object r7 = r12.get(r7)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            goto La5
        La4:
            r7 = r2
        La5:
            int r7 = r7 - r6
            byte[] r8 = new byte[r7]
            java.lang.System.arraycopy(r3, r6, r8, r4, r7)
            r0[r5] = r8
            int r5 = r5 + 1
            goto L7f
        Lb0:
            r12 = r0
        Lb1:
            if (r12 != 0) goto Lb7
            r1.add(r3)
            goto Lba
        Lb7:
            java.util.Collections.addAll(r1, r12)
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.f.l(java.lang.String):java.util.ArrayList");
    }

    @Override // r1.d
    public final Object b() {
        return this.f3394e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011b  */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.util.List] */
    @Override // r1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(org.xmlpull.v1.XmlPullParser r20) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.f.j(org.xmlpull.v1.XmlPullParser):void");
    }
}
