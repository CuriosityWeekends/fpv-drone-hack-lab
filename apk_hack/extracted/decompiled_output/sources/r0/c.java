package r0;

import b3.e;
import com.bumptech.glide.d;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import g2.i;
import g2.w;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import p0.g;
import p0.j;
import p0.k;
import p0.m;
import p0.n;
import p0.r;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements j {
    public k d;

    /* renamed from: e  reason: collision with root package name */
    public u f3372e;

    /* renamed from: g  reason: collision with root package name */
    public Metadata f3374g;

    /* renamed from: h  reason: collision with root package name */
    public i f3375h;

    /* renamed from: i  reason: collision with root package name */
    public int f3376i;

    /* renamed from: j  reason: collision with root package name */
    public int f3377j;

    /* renamed from: k  reason: collision with root package name */
    public b f3378k;

    /* renamed from: l  reason: collision with root package name */
    public int f3379l;

    /* renamed from: m  reason: collision with root package name */
    public long f3380m;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f3371a = new byte[42];
    public final c0.b b = new c0.b(new byte[32768], 0);
    public final m c = new Object();

    /* renamed from: f  reason: collision with root package name */
    public int f3373f = 0;

    @Override // p0.j
    public final void b(k kVar) {
        this.d = kVar;
        this.f3372e = kVar.g(0, 1);
        kVar.c();
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        long j6 = 0;
        if (j2 == 0) {
            this.f3373f = 0;
        } else {
            b bVar = this.f3378k;
            if (bVar != null) {
                bVar.c(j5);
            }
        }
        if (j5 != 0) {
            j6 = -1;
        }
        this.f3380m = j6;
        this.f3379l = 0;
        this.b.u();
    }

    @Override // p0.j
    public final boolean f(g gVar) {
        Metadata F = new e(25).F(gVar, f1.b.b);
        if (F != null) {
            int length = F.f330a.length;
        }
        byte[] bArr = new byte[4];
        gVar.d(bArr, 0, 4, false);
        if (((bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8)) != 1716281667) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int, boolean] */
    @Override // p0.j
    public final int h(g gVar, m mVar) {
        byte[] bArr;
        Metadata metadata;
        i iVar;
        Metadata metadata2;
        r nVar;
        long j2;
        long j5;
        long j6;
        boolean z3;
        long j7;
        boolean z5;
        boolean z6;
        boolean z7 = true;
        int i3 = this.f3373f;
        ?? r5 = 0;
        if (i3 != 0) {
            byte[] bArr2 = this.f3371a;
            if (i3 != 1) {
                int i5 = 24;
                int i6 = 3;
                if (i3 != 2) {
                    int i7 = 7;
                    if (i3 != 3) {
                        long j8 = 0;
                        if (i3 != 4) {
                            if (i3 == 5) {
                                this.f3372e.getClass();
                                this.f3375h.getClass();
                                b bVar = this.f3378k;
                                if (bVar != null && bVar.c != null) {
                                    return bVar.b(gVar, mVar);
                                }
                                if (this.f3380m == -1) {
                                    i iVar2 = this.f3375h;
                                    gVar.f3111f = 0;
                                    gVar.a(1, false);
                                    byte[] bArr3 = new byte[1];
                                    gVar.d(bArr3, 0, 1, false);
                                    if ((bArr3[0] & 1) == 1) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    gVar.a(2, false);
                                    if (!z6) {
                                        i7 = 6;
                                    }
                                    c0.b bVar2 = new c0.b(i7);
                                    bVar2.x(j4.b.r(gVar, bVar2.f187a, 0, i7));
                                    gVar.f3111f = 0;
                                    try {
                                        long t4 = bVar2.t();
                                        if (!z6) {
                                            t4 *= iVar2.b;
                                        }
                                        j8 = t4;
                                    } catch (NumberFormatException unused) {
                                        z7 = false;
                                    }
                                    if (z7) {
                                        this.f3380m = j8;
                                        return 0;
                                    }
                                    throw new IOException();
                                }
                                c0.b bVar3 = this.b;
                                int i8 = bVar3.c;
                                if (i8 < 32768) {
                                    int e5 = gVar.e(bVar3.f187a, i8, 32768 - i8);
                                    if (e5 == -1) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (!z3) {
                                        bVar3.x(i8 + e5);
                                    } else if (bVar3.a() == 0) {
                                        i iVar3 = this.f3375h;
                                        int i9 = w.f1960a;
                                        this.f3372e.c((this.f3380m * 1000000) / iVar3.f1925e, 1, this.f3379l, 0, null);
                                        return -1;
                                    }
                                } else {
                                    z3 = false;
                                }
                                int i10 = bVar3.b;
                                int i11 = this.f3379l;
                                int i12 = this.f3376i;
                                if (i11 < i12) {
                                    bVar3.z(Math.min(i12 - i11, bVar3.a()));
                                }
                                this.f3375h.getClass();
                                int i13 = bVar3.b;
                                while (true) {
                                    int i14 = bVar3.c - 16;
                                    m mVar2 = this.c;
                                    if (i13 <= i14) {
                                        bVar3.y(i13);
                                        if (com.bumptech.glide.c.a(bVar3, this.f3375h, this.f3377j, mVar2)) {
                                            bVar3.y(i13);
                                            j7 = mVar2.f3114a;
                                            break;
                                        }
                                        i13++;
                                    } else {
                                        if (z3) {
                                            while (true) {
                                                int i15 = bVar3.c;
                                                if (i13 <= i15 - this.f3376i) {
                                                    bVar3.y(i13);
                                                    try {
                                                        z5 = com.bumptech.glide.c.a(bVar3, this.f3375h, this.f3377j, mVar2);
                                                    } catch (IndexOutOfBoundsException unused2) {
                                                        z5 = false;
                                                    }
                                                    if (bVar3.b > bVar3.c) {
                                                        z5 = false;
                                                    }
                                                    if (z5) {
                                                        bVar3.y(i13);
                                                        j7 = mVar2.f3114a;
                                                        break;
                                                    }
                                                    i13++;
                                                } else {
                                                    bVar3.y(i15);
                                                    break;
                                                }
                                            }
                                        } else {
                                            bVar3.y(i13);
                                        }
                                        j7 = -1;
                                    }
                                }
                                int i16 = bVar3.b - i10;
                                bVar3.y(i10);
                                this.f3372e.b(i16, bVar3);
                                int i17 = this.f3379l + i16;
                                this.f3379l = i17;
                                if (j7 != -1) {
                                    i iVar4 = this.f3375h;
                                    int i18 = w.f1960a;
                                    this.f3372e.c((this.f3380m * 1000000) / iVar4.f1925e, 1, i17, 0, null);
                                    this.f3379l = 0;
                                    this.f3380m = j7;
                                }
                                if (bVar3.a() >= 16) {
                                    return 0;
                                }
                                byte[] bArr4 = bVar3.f187a;
                                System.arraycopy(bArr4, bVar3.b, bArr4, 0, bVar3.a());
                                bVar3.v(bVar3.a());
                                return 0;
                            }
                            throw new IllegalStateException();
                        }
                        gVar.f3111f = 0;
                        byte[] bArr5 = new byte[2];
                        gVar.d(bArr5, 0, 2, false);
                        int i19 = (bArr5[1] & 255) | ((bArr5[0] & 255) << 8);
                        if ((i19 >> 2) == 16382) {
                            gVar.f3111f = 0;
                            this.f3377j = i19;
                            k kVar = this.d;
                            int i20 = w.f1960a;
                            long j9 = gVar.d;
                            this.f3375h.getClass();
                            i iVar5 = this.f3375h;
                            if (iVar5.f1931k != null) {
                                nVar = new n(iVar5, j9);
                            } else {
                                long j10 = gVar.c;
                                if (j10 != -1 && iVar5.f1930j > 0) {
                                    int i21 = this.f3377j;
                                    a1.g gVar2 = new a1.g(1, iVar5);
                                    a aVar = new a(iVar5, i21);
                                    long c = iVar5.c();
                                    int i22 = iVar5.c;
                                    int i23 = iVar5.d;
                                    if (i23 > 0) {
                                        j2 = j10;
                                        j6 = ((i23 + i22) / 2) + 1;
                                    } else {
                                        j2 = j10;
                                        int i24 = iVar5.b;
                                        int i25 = iVar5.f1924a;
                                        if (i25 == i24 && i25 > 0) {
                                            j5 = i25;
                                        } else {
                                            j5 = 4096;
                                        }
                                        j6 = (((j5 * iVar5.f1927g) * iVar5.f1928h) / 8) + 64;
                                    }
                                    b bVar4 = new b(gVar2, aVar, c, iVar5.f1930j, j9, j2, j6, Math.max(6, i22));
                                    this.f3378k = bVar4;
                                    nVar = bVar4.f3370a;
                                } else {
                                    nVar = new n(iVar5.c());
                                }
                            }
                            kVar.a(nVar);
                            this.f3373f = 5;
                            return 0;
                        }
                        gVar.f3111f = 0;
                        throw new IOException("First frame does not start with sync code.");
                    }
                    i iVar6 = this.f3375h;
                    boolean z8 = false;
                    while (!z8) {
                        gVar.f3111f = r5;
                        byte[] bArr6 = new byte[4];
                        g2.n nVar2 = new g2.n(bArr6, 4);
                        gVar.d(bArr6, r5, 4, r5);
                        boolean f4 = nVar2.f();
                        int g5 = nVar2.g(i7);
                        int g6 = nVar2.g(i5) + 4;
                        if (g5 == 0) {
                            byte[] bArr7 = new byte[38];
                            gVar.g(bArr7, r5, 38, r5);
                            iVar6 = new i(bArr7, 4);
                        } else if (iVar6 != null) {
                            if (g5 == i6) {
                                c0.b bVar5 = new c0.b(g6);
                                gVar.g(bVar5.f187a, r5, g6, r5);
                                iVar = new i(iVar6.f1924a, iVar6.b, iVar6.c, iVar6.d, iVar6.f1925e, iVar6.f1927g, iVar6.f1928h, iVar6.f1930j, d.k(bVar5), iVar6.f1932l);
                            } else {
                                Metadata metadata3 = iVar6.f1932l;
                                if (g5 == 4) {
                                    c0.b bVar6 = new c0.b(g6);
                                    gVar.g(bVar6.f187a, 0, g6, false);
                                    bVar6.z(4);
                                    Metadata a5 = i.a(Arrays.asList((String[]) com.bumptech.glide.e.f(bVar6, false, false).b), Collections.emptyList());
                                    if (metadata3 == null) {
                                        metadata2 = a5;
                                    } else {
                                        if (a5 != null) {
                                            Metadata.Entry[] entryArr = a5.f330a;
                                            if (entryArr.length != 0) {
                                                int i26 = w.f1960a;
                                                Metadata.Entry[] entryArr2 = metadata3.f330a;
                                                Object[] copyOf = Arrays.copyOf(entryArr2, entryArr2.length + entryArr.length);
                                                System.arraycopy(entryArr, 0, copyOf, entryArr2.length, entryArr.length);
                                                metadata3 = new Metadata((Metadata.Entry[]) copyOf);
                                            }
                                        }
                                        metadata2 = metadata3;
                                    }
                                    iVar = new i(iVar6.f1924a, iVar6.b, iVar6.c, iVar6.d, iVar6.f1925e, iVar6.f1927g, iVar6.f1928h, iVar6.f1930j, iVar6.f1931k, metadata2);
                                } else if (g5 == 6) {
                                    c0.b bVar7 = new c0.b(g6);
                                    gVar.g(bVar7.f187a, 0, g6, false);
                                    bVar7.z(4);
                                    int c5 = bVar7.c();
                                    String l5 = bVar7.l(bVar7.c(), Charset.forName("US-ASCII"));
                                    String k5 = bVar7.k(bVar7.c());
                                    int c6 = bVar7.c();
                                    int c7 = bVar7.c();
                                    int c8 = bVar7.c();
                                    int c9 = bVar7.c();
                                    int c10 = bVar7.c();
                                    byte[] bArr8 = new byte[c10];
                                    bVar7.b(bArr8, 0, c10);
                                    Metadata a6 = i.a(Collections.emptyList(), Collections.singletonList(new PictureFrame(c5, l5, k5, c6, c7, c8, c9, bArr8)));
                                    if (metadata3 == null) {
                                        metadata = a6;
                                    } else {
                                        if (a6 != null) {
                                            Metadata.Entry[] entryArr3 = a6.f330a;
                                            if (entryArr3.length != 0) {
                                                int i27 = w.f1960a;
                                                Metadata.Entry[] entryArr4 = metadata3.f330a;
                                                Object[] copyOf2 = Arrays.copyOf(entryArr4, entryArr4.length + entryArr3.length);
                                                System.arraycopy(entryArr3, 0, copyOf2, entryArr4.length, entryArr3.length);
                                                metadata3 = new Metadata((Metadata.Entry[]) copyOf2);
                                            }
                                        }
                                        metadata = metadata3;
                                    }
                                    iVar = new i(iVar6.f1924a, iVar6.b, iVar6.c, iVar6.d, iVar6.f1925e, iVar6.f1927g, iVar6.f1928h, iVar6.f1930j, iVar6.f1931k, metadata);
                                } else {
                                    gVar.h(g6);
                                }
                            }
                            iVar6 = iVar;
                        } else {
                            throw new IllegalArgumentException();
                        }
                        int i28 = w.f1960a;
                        this.f3375h = iVar6;
                        z8 = f4;
                        r5 = 0;
                        i5 = 24;
                        i6 = 3;
                        i7 = 7;
                    }
                    this.f3375h.getClass();
                    this.f3376i = Math.max(this.f3375h.c, 6);
                    u uVar = this.f3372e;
                    int i29 = w.f1960a;
                    uVar.d(this.f3375h.d(bArr2, this.f3374g));
                    this.f3373f = 4;
                    return 0;
                }
                gVar.g(new byte[4], 0, 4, false);
                if ((((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16) | ((bArr[0] & 255) << 24) | (bArr[3] & 255)) == 1716281667) {
                    this.f3373f = 3;
                    return 0;
                }
                throw new IOException("Failed to read FLAC stream marker.");
            }
            gVar.d(bArr2, 0, bArr2.length, false);
            gVar.f3111f = 0;
            this.f3373f = 2;
            return 0;
        }
        gVar.f3111f = 0;
        long c11 = gVar.c();
        Metadata metadata4 = null;
        Metadata F = new e(25).F(gVar, null);
        if (F != null && F.f330a.length != 0) {
            metadata4 = F;
        }
        gVar.h((int) (gVar.c() - c11));
        this.f3374g = metadata4;
        this.f3373f = 1;
        return 0;
    }
}
