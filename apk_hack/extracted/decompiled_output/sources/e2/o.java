package e2;

import android.content.Context;
import android.util.SparseArray;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1713a;
    public final SparseArray b;
    public final int c;
    public final g2.t d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f1714e;

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public o(android.content.Context r11) {
        /*
            r10 = this;
            r10.<init>()
            if (r11 != 0) goto L7
            r0 = 0
            goto Lb
        L7:
            android.content.Context r0 = r11.getApplicationContext()
        Lb:
            r10.f1713a = r0
            int r0 = g2.w.f1960a
            if (r11 == 0) goto L2f
            java.lang.String r0 = "phone"
            java.lang.Object r11 = r11.getSystemService(r0)
            android.telephony.TelephonyManager r11 = (android.telephony.TelephonyManager) r11
            if (r11 == 0) goto L2f
            java.lang.String r11 = r11.getNetworkCountryIso()
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L2f
            if (r11 != 0) goto L28
            goto L40
        L28:
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r11 = r11.toUpperCase(r0)
            goto L40
        L2f:
            java.util.Locale r11 = java.util.Locale.getDefault()
            java.lang.String r11 = r11.getCountry()
            if (r11 != 0) goto L3a
            goto L40
        L3a:
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r11 = r11.toUpperCase(r0)
        L40:
            java.util.Map r0 = e2.q.f1716n
            java.lang.Object r11 = r0.get(r11)
            int[] r11 = (int[]) r11
            r0 = 1
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 0
            if (r11 != 0) goto L59
            int[] r11 = new int[r1]
            r11[r4] = r3
            r11[r0] = r3
            r11[r3] = r3
            r11[r2] = r3
        L59:
            android.util.SparseArray r5 = new android.util.SparseArray
            r6 = 6
            r5.<init>(r6)
            r6 = 1000000(0xf4240, double:4.940656E-318)
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r5.append(r4, r6)
            long[] r6 = e2.q.f1717o
            r7 = r11[r4]
            r7 = r6[r7]
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r5.append(r3, r7)
            long[] r7 = e2.q.f1718p
            r8 = r11[r0]
            r8 = r7[r8]
            java.lang.Long r7 = java.lang.Long.valueOf(r8)
            r5.append(r2, r7)
            long[] r7 = e2.q.q
            r3 = r11[r3]
            r8 = r7[r3]
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            r5.append(r1, r3)
            long[] r1 = e2.q.f1719r
            r2 = r11[r2]
            r2 = r1[r2]
            java.lang.Long r1 = java.lang.Long.valueOf(r2)
            r2 = 5
            r5.append(r2, r1)
            r1 = r11[r4]
            r1 = r6[r1]
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r2 = 7
            r5.append(r2, r1)
            r11 = r11[r4]
            r1 = r6[r11]
            java.lang.Long r11 = java.lang.Long.valueOf(r1)
            r1 = 9
            r5.append(r1, r11)
            r10.b = r5
            r11 = 2000(0x7d0, float:2.803E-42)
            r10.c = r11
            g2.t r11 = g2.t.f1957a
            r10.d = r11
            r10.f1714e = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.o.<init>(android.content.Context):void");
    }

    public final q a() {
        return new q(this.f1713a, this.b, this.c, this.d, this.f1714e);
    }
}
