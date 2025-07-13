package y0;

import android.util.SparseArray;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class v implements p0.j {

    /* renamed from: e  reason: collision with root package name */
    public boolean f4211e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4212f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4213g;

    /* renamed from: h  reason: collision with root package name */
    public long f4214h;

    /* renamed from: i  reason: collision with root package name */
    public r0.b f4215i;

    /* renamed from: j  reason: collision with root package name */
    public p0.k f4216j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f4217k;

    /* renamed from: a  reason: collision with root package name */
    public final g2.u f4210a = new g2.u(0);
    public final c0.b c = new c0.b(4096);
    public final SparseArray b = new SparseArray();
    public final t d = new t(0);

    @Override // p0.j
    public final void b(p0.k kVar) {
        this.f4216j = kVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r6 != r8) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038 A[LOOP:0: B:14:0x0030->B:16:0x0038, LOOP_END] */
    @Override // p0.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(long r6, long r8) {
        /*
            r5 = this;
            g2.u r6 = r5.f4210a
            long r6 = r6.c()
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 != 0) goto L10
            goto L1e
        L10:
            g2.u r6 = r5.f4210a
            long r6 = r6.f1958a
            r2 = 0
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 == 0) goto L27
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 == 0) goto L27
        L1e:
            g2.u r6 = r5.f4210a
            r6.c = r0
            g2.u r6 = r5.f4210a
            r6.d(r8)
        L27:
            r0.b r6 = r5.f4215i
            if (r6 == 0) goto L2e
            r6.c(r8)
        L2e:
            r6 = 0
            r7 = 0
        L30:
            android.util.SparseArray r8 = r5.b
            int r8 = r8.size()
            if (r7 >= r8) goto L4a
            android.util.SparseArray r8 = r5.b
            java.lang.Object r8 = r8.valueAt(r7)
            y0.u r8 = (y0.u) r8
            r8.f4208f = r6
            y0.h r8 = r8.f4206a
            r8.b()
            int r7 = r7 + 1
            goto L30
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.v.d(long, long):void");
    }

    @Override // p0.j
    public final boolean f(p0.g gVar) {
        byte[] bArr = new byte[14];
        gVar.d(bArr, 0, 14, false);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        gVar.a(bArr[13] & 7, false);
        gVar.d(bArr, 0, 3, false);
        if (1 != (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0210  */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // p0.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(p0.g r27, p0.m r28) {
        /*
            Method dump skipped, instructions count: 775
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.v.h(p0.g, p0.m):int");
    }
}
