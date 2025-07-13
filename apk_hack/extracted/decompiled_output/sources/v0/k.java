package v0;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class k implements p0.j {
    public static final byte[] I = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final Format J = Format.n(Long.MAX_VALUE, null, "application/x-emsg");
    public int A;
    public int B;
    public int C;
    public boolean D;
    public p0.k E;
    public u[] F;
    public u[] G;
    public boolean H;

    /* renamed from: a  reason: collision with root package name */
    public final int f3811a;
    public final p b;
    public final List c;
    public final SparseArray d;

    /* renamed from: e  reason: collision with root package name */
    public final c0.b f3812e;

    /* renamed from: f  reason: collision with root package name */
    public final c0.b f3813f;

    /* renamed from: g  reason: collision with root package name */
    public final c0.b f3814g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f3815h;

    /* renamed from: i  reason: collision with root package name */
    public final c0.b f3816i;

    /* renamed from: j  reason: collision with root package name */
    public final g2.u f3817j;

    /* renamed from: k  reason: collision with root package name */
    public final c1.b f3818k;

    /* renamed from: l  reason: collision with root package name */
    public final c0.b f3819l;

    /* renamed from: m  reason: collision with root package name */
    public final ArrayDeque f3820m;

    /* renamed from: n  reason: collision with root package name */
    public final ArrayDeque f3821n;

    /* renamed from: o  reason: collision with root package name */
    public final u f3822o;

    /* renamed from: p  reason: collision with root package name */
    public int f3823p;
    public int q;

    /* renamed from: r  reason: collision with root package name */
    public long f3824r;
    public int s;

    /* renamed from: t  reason: collision with root package name */
    public c0.b f3825t;

    /* renamed from: u  reason: collision with root package name */
    public long f3826u;

    /* renamed from: v  reason: collision with root package name */
    public int f3827v;
    public long w;

    /* renamed from: x  reason: collision with root package name */
    public long f3828x;

    /* renamed from: y  reason: collision with root package name */
    public long f3829y;

    /* renamed from: z  reason: collision with root package name */
    public j f3830z;

    public k(int i3, g2.u uVar, p pVar, List list, u uVar2) {
        int i5;
        if (pVar != null) {
            i5 = 8;
        } else {
            i5 = 0;
        }
        this.f3811a = i3 | i5;
        this.f3817j = uVar;
        this.b = pVar;
        this.c = Collections.unmodifiableList(list);
        this.f3822o = uVar2;
        this.f3818k = new c1.b(0);
        this.f3819l = new c0.b(16);
        this.f3812e = new c0.b(g2.b.d);
        this.f3813f = new c0.b(5);
        this.f3814g = new c0.b();
        byte[] bArr = new byte[16];
        this.f3815h = bArr;
        this.f3816i = new c0.b(bArr);
        this.f3820m = new ArrayDeque();
        this.f3821n = new ArrayDeque();
        this.d = new SparseArray();
        this.f3828x = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.f3829y = -9223372036854775807L;
        this.f3823p = 0;
        this.s = 0;
    }

    public static DrmInitData a(ArrayList arrayList) {
        int size = arrayList.size();
        ArrayList arrayList2 = null;
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = (b) arrayList.get(i3);
            if (bVar.f3791a == 1886614376) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] bArr = bVar.b.f187a;
                UUID b = o.b(bArr);
                if (b == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList2.add(new DrmInitData.SchemeData(b, null, "video/mp4", bArr));
                }
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        return new DrmInitData(null, false, (DrmInitData.SchemeData[]) arrayList2.toArray(new DrmInitData.SchemeData[0]));
    }

    public static void e(c0.b bVar, int i3, r rVar) {
        boolean z3;
        bVar.y(i3 + 8);
        int c = bVar.c();
        if ((c & 1) == 0) {
            if ((c & 2) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            int q = bVar.q();
            if (q == rVar.f3860e) {
                Arrays.fill(rVar.f3868m, 0, q, z3);
                int a5 = bVar.a();
                c0.b bVar2 = rVar.f3871p;
                if (bVar2 == null || bVar2.c < a5) {
                    rVar.f3871p = new c0.b(a5);
                }
                rVar.f3870o = a5;
                rVar.f3867l = true;
                rVar.q = true;
                bVar.b(rVar.f3871p.f187a, 0, a5);
                rVar.f3871p.y(0);
                rVar.q = false;
                return;
            }
            StringBuilder m5 = a1.i.m("Length mismatch: ", q, ", ");
            m5.append(rVar.f3860e);
            throw new IOException(m5.toString());
        }
        throw new IOException("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    @Override // p0.j
    public final void b(p0.k kVar) {
        this.E = kVar;
        p pVar = this.b;
        if (pVar != null) {
            j jVar = new j(kVar.g(0, pVar.b));
            jVar.b(pVar, new h(0, 0, 0, 0));
            this.d.put(0, jVar);
            c();
            this.E.c();
        }
    }

    public final void c() {
        int i3;
        u[] uVarArr = this.F;
        SparseArray sparseArray = this.d;
        if (uVarArr == null) {
            u[] uVarArr2 = new u[2];
            this.F = uVarArr2;
            u uVar = this.f3822o;
            if (uVar != null) {
                uVarArr2[0] = uVar;
                i3 = 1;
            } else {
                i3 = 0;
            }
            if ((this.f3811a & 4) != 0) {
                uVarArr2[i3] = this.E.g(sparseArray.size(), 4);
                i3++;
            }
            u[] uVarArr3 = (u[]) Arrays.copyOf(this.F, i3);
            this.F = uVarArr3;
            for (u uVar2 : uVarArr3) {
                uVar2.d(J);
            }
        }
        if (this.G == null) {
            List list = this.c;
            this.G = new u[list.size()];
            for (int i5 = 0; i5 < this.G.length; i5++) {
                u g5 = this.E.g(sparseArray.size() + 1 + i5, 3);
                g5.d((Format) list.get(i5));
                this.G[i5] = g5;
            }
        }
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        SparseArray sparseArray = this.d;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((j) sparseArray.valueAt(i3)).e();
        }
        this.f3821n.clear();
        this.f3827v = 0;
        this.w = j5;
        this.f3820m.clear();
        this.f3823p = 0;
        this.s = 0;
    }

    @Override // p0.j
    public final boolean f(p0.g gVar) {
        return o.c(gVar, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:341:0x073a, code lost:
        r6 = r0;
        r6.f3823p = 0;
        r6.s = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0740, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0634  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(long r55) {
        /*
            Method dump skipped, instructions count: 1857
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.k.g(long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0250, code lost:
        if (r3 == null) goto L359;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0252, code lost:
        r25 = r1 | true;
        r28 = r3.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x025c, code lost:
        r25 = r1;
        r28 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0260, code lost:
        r2.c(r14, r25, r30.A, 0, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0271, code lost:
        if (r12.isEmpty() != false) goto L353;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0273, code lost:
        r1 = (v0.i) r12.removeFirst();
        r30.f3827v -= r1.b;
        r2 = r1.f3802a + r14;
        r4 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0285, code lost:
        if (r29 == null) goto L348;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0287, code lost:
        r2 = r4.a(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x028b, code lost:
        r13 = r30.F;
        r11 = r13.length;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x028f, code lost:
        if (r10 >= r11) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0291, code lost:
        r13[r10].c(r2, 1, r1.b, r30.f3827v, null);
        r10 = r10 + 1;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02b1, code lost:
        r29 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02ba, code lost:
        if (r30.f3830z.c() != false) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02bc, code lost:
        r30.f3830z = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02bf, code lost:
        r30.f3823p = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0089, code lost:
        r2 = r30.f3830z;
        r3 = r2.b.f3863h;
        r4 = r2.f3805f;
        r3 = r3[r4];
        r30.A = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
        if (r4 >= r2.f3808i) goto L292;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0099, code lost:
        r31.h(r3);
        r1 = r30.f3830z;
        r2 = r1.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a2, code lost:
        if (r2 != null) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:?, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a5, code lost:
        r3 = r1.b;
        r4 = r3.f3871p;
        r2 = r2.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ab, code lost:
        if (r2 == 0) goto L282;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ad, code lost:
        r4.z(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b0, code lost:
        r1 = r1.f3805f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b4, code lost:
        if (r3.f3867l == false) goto L287;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ba, code lost:
        if (r3.f3868m[r1] == false) goto L287;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bc, code lost:
        r4.z(r4.s() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cb, code lost:
        if (r30.f3830z.c() != false) goto L290;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00cd, code lost:
        r30.f3830z = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cf, code lost:
        r30.f3823p = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d2, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00da, code lost:
        if (r2.d.f3852g != 1) goto L295;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00dc, code lost:
        r30.A = r3 - 8;
        r31.h(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f2, code lost:
        if ("audio/ac4".equals(r30.f3830z.d.f3851f.f311i) == false) goto L365;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f4, code lost:
        r30.B = r30.f3830z.d(r30.A, 7);
        r2 = r30.A;
        r3 = r30.f3816i;
        l0.a.b(r2, r3);
        r30.f3830z.f3803a.b(7, r3);
        r30.B += 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0113, code lost:
        r30.B = r30.f3830z.d(r30.A, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x011d, code lost:
        r30.A += r30.B;
        r30.f3823p = 4;
        r30.C = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0129, code lost:
        r2 = r30.f3830z;
        r3 = r2.b;
        r4 = r2.d;
        r6 = r2.f3805f;
        r14 = (r3.f3865j[r6] + r3.f3864i[r6]) * 1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x013f, code lost:
        if (r13 == null) goto L302;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0141, code lost:
        r14 = r13.a(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0145, code lost:
        r8 = r4.f3855j;
        r2 = r2.f3803a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0149, code lost:
        if (r8 == 0) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x014b, code lost:
        r9 = r30.f3813f;
        r11 = r9.f187a;
        r11[0] = 0;
        r11[1] = 0;
        r11[2] = 0;
        r10 = r8 + 1;
        r8 = 4 - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0163, code lost:
        if (r30.B >= r30.A) goto L337;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0165, code lost:
        r5 = r30.C;
        r29 = r13;
        r13 = r4.f3851f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016d, code lost:
        if (r5 != 0) goto L331;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x016f, code lost:
        r16 = r4;
        r31.g(r11, r8, r10, false);
        r9.y(0);
        r5 = r9.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x017d, code lost:
        if (r5 < 1) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x017f, code lost:
        r30.C = r5 - 1;
        r5 = r30.f3812e;
        r5.y(0);
        r2.b(4, r5);
        r2.b(1, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0194, code lost:
        if (r30.G.length <= 0) goto L327;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0196, code lost:
        r5 = r13.f311i;
        r13 = r11[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01a0, code lost:
        if ("video/avc".equals(r5) == false) goto L326;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01a2, code lost:
        r17 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a7, code lost:
        if ((r13 & 31) == 6) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01aa, code lost:
        r17 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01b1, code lost:
        if ("video/hevc".equals(r5) == false) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b9, code lost:
        if (((r13 & 126) >> 1) != 39) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01bb, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01bd, code lost:
        r17 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01c0, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01c1, code lost:
        r30.D = r4;
        r30.B += 5;
        r30.A += r8;
        r4 = r16;
        r9 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01d2, code lost:
        r13 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01dd, code lost:
        throw new java.io.IOException("Invalid NAL length");
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01de, code lost:
        r16 = r4;
        r17 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01e5, code lost:
        if (r30.D == false) goto L336;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01e7, code lost:
        r4 = r30.f3814g;
        r4.v(r5);
        r18 = r8;
        r31.g(r4.f187a, 0, r30.C, false);
        r2.b(r30.C, r4);
        r5 = r30.C;
        r8 = g2.b.z(r4.f187a, r4.c);
        r4.y("video/hevc".equals(r13.f311i) ? 1 : 0);
        r4.x(r8);
        com.bumptech.glide.c.b(r14, r4, r30.G);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0217, code lost:
        r18 = r8;
        r5 = r2.a(r31, r5, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x021e, code lost:
        r30.B += r5;
        r30.C -= r5;
        r4 = r16;
        r9 = r17;
        r8 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x022f, code lost:
        r29 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0232, code lost:
        r29 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0234, code lost:
        r4 = r30.B;
        r5 = r30.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0238, code lost:
        if (r4 >= r5) goto L364;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x023a, code lost:
        r30.B += r2.a(r31, r5 - r4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0246, code lost:
        r1 = r3.f3866k[r6];
        r3 = r30.f3830z.a();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v0 */
    /* JADX WARN: Type inference failed for: r25v1, types: [int] */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r2v2, types: [p0.u] */
    /* JADX WARN: Type inference failed for: r4v35 */
    @Override // p0.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int h(p0.g r31, p0.m r32) {
        /*
            Method dump skipped, instructions count: 1773
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.k.h(p0.g, p0.m):int");
    }
}
