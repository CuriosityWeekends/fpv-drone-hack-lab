package y0;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a0 implements p0.j {

    /* renamed from: a  reason: collision with root package name */
    public final int f4027a;
    public final List b;
    public final c0.b c;
    public final SparseIntArray d;

    /* renamed from: e  reason: collision with root package name */
    public final h2.c f4028e;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray f4029f;

    /* renamed from: g  reason: collision with root package name */
    public final SparseBooleanArray f4030g;

    /* renamed from: h  reason: collision with root package name */
    public final SparseBooleanArray f4031h;

    /* renamed from: i  reason: collision with root package name */
    public final t f4032i;

    /* renamed from: j  reason: collision with root package name */
    public r0.b f4033j;

    /* renamed from: k  reason: collision with root package name */
    public p0.k f4034k;

    /* renamed from: l  reason: collision with root package name */
    public int f4035l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f4036m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f4037n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f4038o;

    /* renamed from: p  reason: collision with root package name */
    public d0 f4039p;
    public int q;

    /* renamed from: r  reason: collision with root package name */
    public int f4040r;

    public a0(int i3, g2.u uVar, h2.c cVar) {
        this.f4028e = cVar;
        this.f4027a = i3;
        if (i3 != 1 && i3 != 2) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(uVar);
        } else {
            this.b = Collections.singletonList(uVar);
        }
        this.c = new c0.b(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.f4030g = sparseBooleanArray;
        this.f4031h = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.f4029f = sparseArray;
        this.d = new SparseIntArray();
        this.f4032i = new t(1);
        this.f4040r = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i5 = 0; i5 < size; i5++) {
            sparseArray.put(sparseArray2.keyAt(i5), sparseArray2.valueAt(i5));
        }
        sparseArray.put(0, new x(new c1.b(this)));
        this.f4039p = null;
    }

    @Override // p0.j
    public final void b(p0.k kVar) {
        this.f4034k = kVar;
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        boolean z3;
        r0.b bVar;
        if (this.f4027a != 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.h(z3);
        int size = this.b.size();
        for (int i3 = 0; i3 < size; i3++) {
            g2.u uVar = (g2.u) this.b.get(i3);
            if (uVar.c() == -9223372036854775807L || (uVar.c() != 0 && uVar.f1958a != j5)) {
                uVar.c = -9223372036854775807L;
                uVar.d(j5);
            }
        }
        if (j5 != 0 && (bVar = this.f4033j) != null) {
            bVar.c(j5);
        }
        this.c.u();
        this.d.clear();
        for (int i5 = 0; i5 < this.f4029f.size(); i5++) {
            ((d0) this.f4029f.valueAt(i5)).b();
        }
        this.q = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        r1 = r1 + 1;
     */
    @Override // p0.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(p0.g r7) {
        /*
            r6 = this;
            c0.b r0 = r6.c
            byte[] r0 = r0.f187a
            r1 = 940(0x3ac, float:1.317E-42)
            r2 = 0
            r7.d(r0, r2, r1, r2)
            r1 = 0
        Lb:
            r3 = 188(0xbc, float:2.63E-43)
            if (r1 >= r3) goto L27
            r3 = 0
        L10:
            r4 = 5
            if (r3 >= r4) goto L22
            int r4 = r3 * 188
            int r4 = r4 + r1
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L1f
            int r1 = r1 + 1
            goto Lb
        L1f:
            int r3 = r3 + 1
            goto L10
        L22:
            r7.h(r1)
            r7 = 1
            return r7
        L27:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.a0.f(p0.g):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    @Override // p0.j
    public final int h(p0.g gVar, p0.m mVar) {
        long j2;
        int i3;
        int i5;
        ?? r5;
        int i6;
        int i7;
        boolean z3;
        d0 d0Var;
        int i8;
        boolean z5;
        long j5;
        int i9;
        long j6;
        boolean z6 = this.f4036m;
        long j7 = gVar.c;
        int i10 = this.f4027a;
        if (z6) {
            t tVar = this.f4032i;
            if (j7 != -1 && i10 != 2 && !tVar.d) {
                int i11 = this.f4040r;
                if (i11 <= 0) {
                    tVar.a(gVar);
                    return 0;
                }
                boolean z7 = tVar.f4202f;
                c0.b bVar = tVar.c;
                if (!z7) {
                    int min = (int) Math.min(112800L, j7);
                    long j8 = j7 - min;
                    if (gVar.d != j8) {
                        mVar.f3114a = j8;
                        i9 = 1;
                    } else {
                        bVar.v(min);
                        gVar.f3111f = 0;
                        gVar.d(bVar.f187a, 0, min, false);
                        int i12 = bVar.b;
                        int i13 = bVar.c - 1;
                        while (true) {
                            if (i13 >= i12) {
                                if (bVar.f187a[i13] == 71) {
                                    long j9 = com.bumptech.glide.d.j(bVar, i13, i11);
                                    if (j9 != -9223372036854775807L) {
                                        j6 = j9;
                                        break;
                                    }
                                }
                                i13--;
                            } else {
                                j6 = -9223372036854775807L;
                                break;
                            }
                        }
                        tVar.f4204h = j6;
                        tVar.f4202f = true;
                        i9 = 0;
                    }
                } else if (tVar.f4204h == -9223372036854775807L) {
                    tVar.a(gVar);
                    return 0;
                } else if (!tVar.f4201e) {
                    int min2 = (int) Math.min(112800L, j7);
                    long j10 = 0;
                    if (gVar.d != j10) {
                        mVar.f3114a = j10;
                        i9 = 1;
                    } else {
                        bVar.v(min2);
                        gVar.f3111f = 0;
                        gVar.d(bVar.f187a, 0, min2, false);
                        int i14 = bVar.b;
                        int i15 = bVar.c;
                        while (true) {
                            if (i14 < i15) {
                                if (bVar.f187a[i14] == 71) {
                                    long j11 = com.bumptech.glide.d.j(bVar, i14, i11);
                                    if (j11 != -9223372036854775807L) {
                                        j5 = j11;
                                        break;
                                    }
                                }
                                i14++;
                            } else {
                                j5 = -9223372036854775807L;
                                break;
                            }
                        }
                        tVar.f4203g = j5;
                        tVar.f4201e = true;
                        i9 = 0;
                    }
                } else {
                    long j12 = tVar.f4203g;
                    if (j12 == -9223372036854775807L) {
                        tVar.a(gVar);
                        return 0;
                    }
                    g2.u uVar = tVar.b;
                    tVar.f4205i = uVar.b(tVar.f4204h) - uVar.b(j12);
                    tVar.a(gVar);
                    return 0;
                }
                return i9;
            }
            if (!this.f4037n) {
                this.f4037n = true;
                long j13 = tVar.f4205i;
                if (j13 != -9223372036854775807L) {
                    i5 = 2;
                    z5 = false;
                    j2 = j7;
                    i3 = i10;
                    r0.b bVar2 = new r0.b(new j3.a(22), new r0.a(this.f4040r, tVar.b), j13, j13 + 1, 0L, j2, 188L, 940);
                    this.f4033j = bVar2;
                    this.f4034k.a(bVar2.f3370a);
                } else {
                    j2 = j7;
                    i3 = i10;
                    i5 = 2;
                    z5 = false;
                    this.f4034k.a(new p0.n(j13));
                }
            } else {
                j2 = j7;
                i3 = i10;
                i5 = 2;
                z5 = false;
            }
            if (this.f4038o) {
                this.f4038o = z5;
                d(0L, 0L);
                if (gVar.d != 0) {
                    mVar.f3114a = 0L;
                    return 1;
                }
            }
            r0.b bVar3 = this.f4033j;
            r5 = z5;
            if (bVar3 != null) {
                r5 = z5;
                if (bVar3.c != null) {
                    return bVar3.b(gVar, mVar);
                }
            }
        } else {
            j2 = j7;
            i3 = i10;
            i5 = 2;
            r5 = 0;
        }
        c0.b bVar4 = this.c;
        byte[] bArr = bVar4.f187a;
        if (9400 - bVar4.b < 188) {
            int a5 = bVar4.a();
            if (a5 > 0) {
                System.arraycopy(bArr, bVar4.b, bArr, r5, a5);
            }
            bVar4.w(bArr, a5);
        }
        while (bVar4.a() < 188) {
            int i16 = bVar4.c;
            int e5 = gVar.e(bArr, i16, 9400 - i16);
            if (e5 == -1) {
                return -1;
            }
            bVar4.x(i16 + e5);
        }
        int i17 = bVar4.b;
        int i18 = bVar4.c;
        byte[] bArr2 = bVar4.f187a;
        int i19 = i17;
        while (i19 < i18 && bArr2[i19] != 71) {
            i19++;
        }
        bVar4.y(i19);
        int i20 = i19 + 188;
        if (i20 > i18) {
            int i21 = (i19 - i17) + this.q;
            this.q = i21;
            i6 = i3;
            if (i6 == i5 && i21 > 376) {
                throw new IOException("Cannot find sync byte. Most likely not a Transport Stream.");
            }
        } else {
            i6 = i3;
            this.q = r5;
        }
        int i22 = bVar4.c;
        if (i20 > i22) {
            return r5;
        }
        int c = bVar4.c();
        if ((8388608 & c) != 0) {
            bVar4.y(i20);
            return r5;
        }
        if ((4194304 & c) != 0) {
            i7 = 1;
        } else {
            i7 = 0;
        }
        int i23 = (2096896 & c) >> 8;
        if ((c & 32) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((c & 16) != 0) {
            d0Var = (d0) this.f4029f.get(i23);
        } else {
            d0Var = null;
        }
        if (d0Var == null) {
            bVar4.y(i20);
            return r5;
        }
        if (i6 != i5) {
            int i24 = c & 15;
            SparseIntArray sparseIntArray = this.d;
            int i25 = sparseIntArray.get(i23, i24 - 1);
            sparseIntArray.put(i23, i24);
            if (i25 == i24) {
                bVar4.y(i20);
                return r5;
            } else if (i24 != ((i25 + 1) & 15)) {
                d0Var.b();
            }
        }
        if (z3) {
            int n5 = bVar4.n();
            if ((bVar4.n() & 64) != 0) {
                i8 = 2;
            } else {
                i8 = 0;
            }
            i7 |= i8;
            bVar4.z(n5 - 1);
        }
        boolean z8 = this.f4036m;
        if (i6 == i5 || z8 || !this.f4031h.get(i23, r5)) {
            bVar4.x(i20);
            d0Var.a(i7, bVar4);
            bVar4.x(i22);
        }
        if (i6 != i5 && !z8 && this.f4036m && j2 != -1) {
            this.f4038o = true;
        }
        bVar4.y(i20);
        return r5;
    }
}
