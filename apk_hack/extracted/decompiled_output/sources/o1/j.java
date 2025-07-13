package o1;

import android.net.Uri;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import e2.m0;
import j0.o0;
import j1.k0;
import j1.l0;
import j1.u;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j implements j1.m, k0 {

    /* renamed from: a  reason: collision with root package name */
    public final h f2991a;
    public final p1.b b;
    public final m1.k c;
    public final m0 d;

    /* renamed from: e  reason: collision with root package name */
    public final n0.b f2992e;

    /* renamed from: f  reason: collision with root package name */
    public final j3.a f2993f;

    /* renamed from: g  reason: collision with root package name */
    public final u f2994g;

    /* renamed from: h  reason: collision with root package name */
    public final e2.m f2995h;

    /* renamed from: i  reason: collision with root package name */
    public final IdentityHashMap f2996i;

    /* renamed from: j  reason: collision with root package name */
    public final q f2997j;

    /* renamed from: k  reason: collision with root package name */
    public final j3.a f2998k;

    /* renamed from: m  reason: collision with root package name */
    public final int f3000m;

    /* renamed from: o  reason: collision with root package name */
    public j1.l f3002o;

    /* renamed from: p  reason: collision with root package name */
    public int f3003p;
    public TrackGroupArray q;

    /* renamed from: r  reason: collision with root package name */
    public p[] f3004r;
    public p[] s;

    /* renamed from: t  reason: collision with root package name */
    public b3.e f3005t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f3006u;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f2999l = false;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f3001n = false;

    /* JADX WARN: Type inference failed for: r2v3, types: [o1.q, java.lang.Object] */
    public j(b bVar, p1.b bVar2, m1.k kVar, m0 m0Var, n0.b bVar3, j3.a aVar, u uVar, e2.m mVar, j3.a aVar2, int i3) {
        this.f2991a = bVar;
        this.b = bVar2;
        this.c = kVar;
        this.d = m0Var;
        this.f2992e = bVar3;
        this.f2993f = aVar;
        this.f2994g = uVar;
        this.f2995h = mVar;
        this.f2998k = aVar2;
        this.f3000m = i3;
        aVar2.getClass();
        this.f3005t = new b3.e(10, new l0[0]);
        this.f2996i = new IdentityHashMap();
        ?? obj = new Object();
        obj.f3044a = new SparseArray();
        this.f2997j = obj;
        this.f3004r = new p[0];
        this.s = new p[0];
        uVar.n();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.Format f(com.google.android.exoplayer2.Format r22, com.google.android.exoplayer2.Format r23, boolean r24) {
        /*
            r0 = r22
            r1 = r23
            r2 = -1
            if (r1 == 0) goto L21
            java.lang.String r3 = r1.f308f
            com.google.android.exoplayer2.metadata.Metadata r4 = r1.f309g
            int r5 = r1.f322v
            int r6 = r1.c
            int r7 = r1.d
            java.lang.String r8 = r1.A
            java.lang.String r1 = r1.b
        L15:
            r10 = r1
            r13 = r3
            r14 = r4
            r16 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            goto L44
        L21:
            java.lang.String r1 = r0.f308f
            r3 = 1
            java.lang.String r3 = g2.w.l(r3, r1)
            com.google.android.exoplayer2.metadata.Metadata r4 = r0.f309g
            if (r24 == 0) goto L37
            int r5 = r0.f322v
            int r6 = r0.c
            int r7 = r0.d
            java.lang.String r8 = r0.A
            java.lang.String r1 = r0.b
            goto L15
        L37:
            r6 = 0
            r8 = 0
            r13 = r3
            r14 = r4
            r10 = r8
            r21 = r10
            r16 = -1
            r19 = 0
            r20 = 0
        L44:
            java.lang.String r12 = g2.k.b(r13)
            if (r24 == 0) goto L4e
            int r2 = r0.f307e
            r15 = r2
            goto L4f
        L4e:
            r15 = -1
        L4f:
            java.lang.String r9 = r0.f306a
            r18 = 0
            java.lang.String r11 = r0.f310h
            r17 = -1
            com.google.android.exoplayer2.Format r0 = com.google.android.exoplayer2.Format.i(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.j.f(com.google.android.exoplayer2.Format, com.google.android.exoplayer2.Format, boolean):com.google.android.exoplayer2.Format");
    }

    @Override // j1.l0
    public final void A(long j2) {
        this.f3005t.A(j2);
    }

    public final p a(int i3, Uri[] uriArr, Format[] formatArr, Format format, List list, Map map, long j2) {
        return new p(i3, this, new f(this.f2991a, this.b, uriArr, formatArr, this.c, this.d, this.f2997j, list), map, this.f2995h, j2, format, this.f2992e, this.f2993f, this.f2994g, this.f3000m);
    }

    @Override // j1.l0
    public final boolean d() {
        return this.f3005t.d();
    }

    @Override // j1.k0
    public final void e(l0 l0Var) {
        p pVar = (p) l0Var;
        this.f3002o.e(this);
    }

    public final void g() {
        p[] pVarArr;
        p[] pVarArr2;
        int i3 = this.f3003p - 1;
        this.f3003p = i3;
        if (i3 > 0) {
            return;
        }
        int i5 = 0;
        for (p pVar : this.f3004r) {
            pVar.m();
            i5 += pVar.F.f385a;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i5];
        int i6 = 0;
        for (p pVar2 : this.f3004r) {
            pVar2.m();
            int i7 = pVar2.F.f385a;
            int i8 = 0;
            while (i8 < i7) {
                pVar2.m();
                trackGroupArr[i6] = pVar2.F.b[i8];
                i8++;
                i6++;
            }
        }
        this.q = new TrackGroupArray(trackGroupArr);
        this.f3002o.c(this);
    }

    @Override // j1.l0
    public final long i() {
        return this.f3005t.i();
    }

    @Override // j1.m
    public final long j() {
        if (!this.f3006u) {
            this.f2994g.q();
            this.f3006u = true;
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    @Override // j1.m
    public final TrackGroupArray o() {
        TrackGroupArray trackGroupArray = this.q;
        trackGroupArray.getClass();
        return trackGroupArray;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0114, code lost:
        if (r2[r10] == 1) goto L62;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0389 A[LOOP:9: B:135:0x0381->B:137:0x0389, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03d3 A[EDGE_INSN: B:171:0x03d3->B:138:0x03d3 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0225  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v47, types: [java.util.HashMap] */
    @Override // j1.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(j1.l r38, long r39) {
        /*
            Method dump skipped, instructions count: 1037
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.j.q(j1.l, long):void");
    }

    @Override // j1.l0
    public final long s() {
        return this.f3005t.s();
    }

    @Override // j1.m
    public final void t() {
        p[] pVarArr;
        for (p pVar : this.f3004r) {
            pVar.D();
            if (pVar.Q && !pVar.A) {
                throw new IOException("Loading finished before preparation is complete.");
            }
        }
    }

    @Override // j1.m
    public final void u(long j2, boolean z3) {
        p[] pVarArr;
        for (p pVar : this.s) {
            if (pVar.f3043z && !pVar.B()) {
                int length = pVar.s.length;
                for (int i3 = 0; i3 < length; i3++) {
                    pVar.s[i3].i(j2, z3, pVar.K[i3]);
                }
            }
        }
    }

    @Override // j1.m
    public final long w(long j2) {
        p[] pVarArr = this.s;
        if (pVarArr.length > 0) {
            boolean G = pVarArr[0].G(j2, false);
            int i3 = 1;
            while (true) {
                p[] pVarArr2 = this.s;
                if (i3 >= pVarArr2.length) {
                    break;
                }
                pVarArr2[i3].G(j2, G);
                i3++;
            }
            if (G) {
                this.f2997j.f3044a.clear();
            }
        }
        return j2;
    }

    @Override // j1.l0
    public final boolean y(long j2) {
        p[] pVarArr;
        if (this.q == null) {
            for (p pVar : this.f3004r) {
                if (!pVar.A) {
                    pVar.y(pVar.M);
                }
            }
            return false;
        }
        return this.f3005t.y(j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x01e5, code lost:
        if (r10.c[r10.c()] != r5.f2965h.c(r0.c)) goto L176;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01f6  */
    @Override // j1.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long z(b2.n[] r27, boolean[] r28, j1.j0[] r29, boolean[] r30, long r31) {
        /*
            Method dump skipped, instructions count: 696
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.j.z(b2.n[], boolean[], j1.j0[], boolean[], long):long");
    }

    @Override // j1.m
    public final long b(long j2, o0 o0Var) {
        return j2;
    }
}
