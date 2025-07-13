package w0;

import a2.l;
import android.util.Log;
import com.google.android.exoplayer2.Format;
import g2.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import p0.v;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j extends i {

    /* renamed from: n  reason: collision with root package name */
    public l f3932n;

    /* renamed from: o  reason: collision with root package name */
    public int f3933o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f3934p;
    public v q;

    /* renamed from: r  reason: collision with root package name */
    public b3.e f3935r;

    @Override // w0.i
    public final void a(long j2) {
        boolean z3;
        this.f3925g = j2;
        int i3 = 0;
        if (j2 != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f3934p = z3;
        v vVar = this.q;
        if (vVar != null) {
            i3 = vVar.d;
        }
        this.f3933o = i3;
    }

    @Override // w0.i
    public final long b(c0.b bVar) {
        int i3;
        int i5 = 0;
        byte b = bVar.f187a[0];
        if ((b & 1) == 1) {
            return -1L;
        }
        l lVar = this.f3932n;
        boolean z3 = ((g2.d[]) lVar.d)[(b >> 1) & (255 >>> (8 - lVar.f81a))].f1918a;
        v vVar = (v) lVar.b;
        if (!z3) {
            i3 = vVar.d;
        } else {
            i3 = vVar.f3132e;
        }
        if (this.f3934p) {
            i5 = (this.f3933o + i3) / 4;
        }
        long j2 = i5;
        bVar.x(bVar.c + 4);
        byte[] bArr = bVar.f187a;
        int i6 = bVar.c;
        bArr[i6 - 4] = (byte) (j2 & 255);
        bArr[i6 - 3] = (byte) ((j2 >>> 8) & 255);
        bArr[i6 - 2] = (byte) ((j2 >>> 16) & 255);
        bArr[i6 - 1] = (byte) ((j2 >>> 24) & 255);
        this.f3934p = true;
        this.f3933o = i3;
        return j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Object, g2.d] */
    @Override // w0.i
    public final boolean c(c0.b bVar, long j2, c1.b bVar2) {
        int i3;
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        if (this.f3932n != null) {
            return false;
        }
        l lVar = null;
        if (this.q == null) {
            com.bumptech.glide.e.i(1, bVar, false);
            bVar.f();
            int n5 = bVar.n();
            long f4 = bVar.f();
            bVar.e();
            int e5 = bVar.e();
            bVar.e();
            int n6 = bVar.n();
            bVar.n();
            this.q = new v(n5, f4, e5, (int) Math.pow(2.0d, n6 & 15), (int) Math.pow(2.0d, (n6 & 240) >> 4), Arrays.copyOf(bVar.f187a, bVar.c));
        } else if (this.f3935r == null) {
            this.f3935r = com.bumptech.glide.e.f(bVar, true, true);
        } else {
            int i9 = bVar.c;
            byte[] bArr = new byte[i9];
            System.arraycopy(bVar.f187a, 0, bArr, 0, i9);
            int i10 = this.q.f3131a;
            int i11 = 5;
            com.bumptech.glide.e.i(5, bVar, false);
            int n7 = bVar.n() + 1;
            n nVar = new n(bVar.f187a);
            nVar.o(bVar.b * 8);
            int i12 = 0;
            while (true) {
                int i13 = 16;
                if (i12 < n7) {
                    if (nVar.g(24) == 5653314) {
                        int g5 = nVar.g(16);
                        int g6 = nVar.g(24);
                        long[] jArr = new long[g6];
                        long j5 = 0;
                        if (!nVar.f()) {
                            boolean f5 = nVar.f();
                            while (i8 < g6) {
                                if (f5) {
                                    if (nVar.f()) {
                                        i7 = g5;
                                        jArr[i8] = nVar.g(i11) + 1;
                                    } else {
                                        i7 = g5;
                                        jArr[i8] = 0;
                                    }
                                } else {
                                    i7 = g5;
                                    jArr[i8] = nVar.g(i11) + 1;
                                }
                                i8++;
                                g5 = i7;
                            }
                            i6 = g5;
                        } else {
                            i6 = g5;
                            int g7 = nVar.g(i11) + 1;
                            int i14 = 0;
                            while (i14 < g6) {
                                int g8 = nVar.g(com.bumptech.glide.e.d(g6 - i14));
                                int i15 = 0;
                                while (i15 < g8 && i14 < g6) {
                                    jArr[i14] = g7;
                                    i14++;
                                    i15++;
                                    n7 = n7;
                                }
                                g7++;
                                n7 = n7;
                            }
                        }
                        int i16 = n7;
                        int g9 = nVar.g(4);
                        if (g9 <= 2) {
                            if (g9 == 1 || g9 == 2) {
                                nVar.o(32);
                                nVar.o(32);
                                int g10 = nVar.g(4) + 1;
                                nVar.o(1);
                                if (g9 == 1) {
                                    if (i6 != 0) {
                                        j5 = (long) Math.floor(Math.pow(g6, 1.0d / i6));
                                    }
                                } else {
                                    j5 = g6 * i6;
                                }
                                nVar.o((int) (g10 * j5));
                            }
                            i12++;
                            n7 = i16;
                            i8 = 0;
                            i11 = 5;
                        } else {
                            throw new IOException(a1.i.e(g9, "lookup type greater than 2 not decodable: "));
                        }
                    } else {
                        throw new IOException("expected code book to start with [0x56, 0x43, 0x42] at " + ((nVar.d * 8) + nVar.f1946e));
                    }
                } else {
                    int i17 = 6;
                    int g11 = nVar.g(6) + 1;
                    for (int i18 = 0; i18 < g11; i18++) {
                        if (nVar.g(16) != 0) {
                            throw new IOException("placeholder of time domain transforms not zeroed out");
                        }
                    }
                    int g12 = nVar.g(6) + 1;
                    int i19 = 0;
                    while (true) {
                        int i20 = 3;
                        if (i19 < g12) {
                            int g13 = nVar.g(i13);
                            if (g13 != 0) {
                                if (g13 == 1) {
                                    int g14 = nVar.g(5);
                                    int[] iArr = new int[g14];
                                    int i21 = -1;
                                    for (int i22 = 0; i22 < g14; i22++) {
                                        int g15 = nVar.g(4);
                                        iArr[i22] = g15;
                                        if (g15 > i21) {
                                            i21 = g15;
                                        }
                                    }
                                    int i23 = i21 + 1;
                                    int[] iArr2 = new int[i23];
                                    int i24 = 0;
                                    while (i24 < i23) {
                                        iArr2[i24] = nVar.g(i20) + 1;
                                        int g16 = nVar.g(2);
                                        int i25 = 8;
                                        if (g16 > 0) {
                                            nVar.o(8);
                                        }
                                        int i26 = 0;
                                        while (i26 < (1 << g16)) {
                                            nVar.o(i25);
                                            i26++;
                                            i25 = 8;
                                        }
                                        i24++;
                                        i20 = 3;
                                    }
                                    nVar.o(2);
                                    int g17 = nVar.g(4);
                                    int i27 = 0;
                                    int i28 = 0;
                                    for (int i29 = 0; i29 < g14; i29++) {
                                        i27 += iArr2[iArr[i29]];
                                        while (i28 < i27) {
                                            nVar.o(g17);
                                            i28++;
                                        }
                                    }
                                } else {
                                    throw new IOException(a1.i.e(g13, "floor type greater than 1 not decodable: "));
                                }
                            } else {
                                int i30 = 8;
                                nVar.o(8);
                                nVar.o(16);
                                nVar.o(16);
                                nVar.o(6);
                                nVar.o(8);
                                int g18 = nVar.g(4) + 1;
                                int i31 = 0;
                                while (i31 < g18) {
                                    nVar.o(i30);
                                    i31++;
                                    i30 = 8;
                                }
                            }
                            i19++;
                            i17 = 6;
                            i13 = 16;
                        } else {
                            int g19 = nVar.g(i17) + 1;
                            int i32 = 0;
                            while (i32 < g19) {
                                if (nVar.g(16) <= 2) {
                                    nVar.o(24);
                                    nVar.o(24);
                                    nVar.o(24);
                                    int g20 = nVar.g(i17) + 1;
                                    int i33 = 8;
                                    nVar.o(8);
                                    int[] iArr3 = new int[g20];
                                    for (int i34 = 0; i34 < g20; i34++) {
                                        int g21 = nVar.g(3);
                                        if (nVar.f()) {
                                            i5 = nVar.g(5);
                                        } else {
                                            i5 = 0;
                                        }
                                        iArr3[i34] = (i5 * 8) + g21;
                                    }
                                    int i35 = 0;
                                    while (i35 < g20) {
                                        int i36 = 0;
                                        while (i36 < i33) {
                                            if ((iArr3[i35] & (1 << i36)) != 0) {
                                                nVar.o(i33);
                                            }
                                            i36++;
                                            i33 = 8;
                                        }
                                        i35++;
                                        i33 = 8;
                                    }
                                    i32++;
                                    i17 = 6;
                                } else {
                                    throw new IOException("residueType greater than 2 is not decodable");
                                }
                            }
                            int g22 = nVar.g(i17) + 1;
                            for (int i37 = 0; i37 < g22; i37++) {
                                int g23 = nVar.g(16);
                                if (g23 != 0) {
                                    Log.e("VorbisUtil", "mapping type other than 0 not supported: " + g23);
                                } else {
                                    if (nVar.f()) {
                                        i3 = nVar.g(4) + 1;
                                    } else {
                                        i3 = 1;
                                    }
                                    if (nVar.f()) {
                                        int g24 = nVar.g(8) + 1;
                                        for (int i38 = 0; i38 < g24; i38++) {
                                            int i39 = i10 - 1;
                                            nVar.o(com.bumptech.glide.e.d(i39));
                                            nVar.o(com.bumptech.glide.e.d(i39));
                                        }
                                    }
                                    if (nVar.g(2) == 0) {
                                        if (i3 > 1) {
                                            for (int i40 = 0; i40 < i10; i40++) {
                                                nVar.o(4);
                                            }
                                        }
                                        for (int i41 = 0; i41 < i3; i41++) {
                                            nVar.o(8);
                                            nVar.o(8);
                                            nVar.o(8);
                                        }
                                    } else {
                                        throw new IOException("to reserved bits must be zero after mapping coupling steps");
                                    }
                                }
                            }
                            int g25 = nVar.g(6);
                            int i42 = g25 + 1;
                            g2.d[] dVarArr = new g2.d[i42];
                            for (int i43 = 0; i43 < i42; i43++) {
                                boolean f6 = nVar.f();
                                nVar.g(16);
                                nVar.g(16);
                                nVar.g(8);
                                ?? obj = new Object();
                                obj.f1918a = f6;
                                dVarArr[i43] = obj;
                            }
                            if (nVar.f()) {
                                lVar = new l(this.q, bArr, dVarArr, com.bumptech.glide.e.d(g25));
                            } else {
                                throw new IOException("framing bit after modes not set as expected");
                            }
                        }
                    }
                }
            }
        }
        this.f3932n = lVar;
        if (lVar == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(((v) this.f3932n.b).f3133f);
        arrayList.add((byte[]) this.f3932n.c);
        v vVar = (v) this.f3932n.b;
        bVar2.b = Format.k(null, "audio/vorbis", vVar.c, -1, vVar.f3131a, (int) vVar.b, -1, arrayList, null, 0, null);
        return true;
    }

    @Override // w0.i
    public final void d(boolean z3) {
        super.d(z3);
        if (z3) {
            this.f3932n = null;
            this.q = null;
            this.f3935r = null;
        }
        this.f3933o = 0;
        this.f3934p = false;
    }
}
