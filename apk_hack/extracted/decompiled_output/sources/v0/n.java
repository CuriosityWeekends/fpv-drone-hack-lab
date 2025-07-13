package v0;

import android.support.v4.media.session.PlaybackStateCompat;
import g2.w;
import java.io.IOException;
import java.util.ArrayDeque;
import p0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n implements p0.j, p0.r {

    /* renamed from: f  reason: collision with root package name */
    public int f3835f;

    /* renamed from: g  reason: collision with root package name */
    public int f3836g;

    /* renamed from: h  reason: collision with root package name */
    public long f3837h;

    /* renamed from: i  reason: collision with root package name */
    public int f3838i;

    /* renamed from: j  reason: collision with root package name */
    public c0.b f3839j;

    /* renamed from: l  reason: collision with root package name */
    public int f3841l;

    /* renamed from: m  reason: collision with root package name */
    public int f3842m;

    /* renamed from: n  reason: collision with root package name */
    public int f3843n;

    /* renamed from: o  reason: collision with root package name */
    public p0.k f3844o;

    /* renamed from: p  reason: collision with root package name */
    public m[] f3845p;
    public long[][] q;

    /* renamed from: r  reason: collision with root package name */
    public int f3846r;
    public long s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f3847t;
    public final c0.b d = new c0.b(16);

    /* renamed from: e  reason: collision with root package name */
    public final ArrayDeque f3834e = new ArrayDeque();

    /* renamed from: a  reason: collision with root package name */
    public final c0.b f3833a = new c0.b(g2.b.d);
    public final c0.b b = new c0.b(4);
    public final c0.b c = new c0.b();

    /* renamed from: k  reason: collision with root package name */
    public int f3840k = -1;

    @Override // p0.j
    public final void b(p0.k kVar) {
        this.f3844o = kVar;
    }

    @Override // p0.j
    public final void d(long j2, long j5) {
        this.f3834e.clear();
        this.f3838i = 0;
        this.f3840k = -1;
        this.f3841l = 0;
        this.f3842m = 0;
        this.f3843n = 0;
        if (j2 == 0) {
            this.f3835f = 0;
            this.f3838i = 0;
            return;
        }
        m[] mVarArr = this.f3845p;
        if (mVarArr != null) {
            for (m mVar : mVarArr) {
                s sVar = mVar.b;
                int d = w.d(sVar.f3875f, j5, false);
                while (true) {
                    if (d >= 0) {
                        if ((sVar.f3876g[d] & 1) != 0) {
                            break;
                        }
                        d--;
                    } else {
                        d = -1;
                        break;
                    }
                }
                if (d == -1) {
                    d = sVar.a(j5);
                }
                mVar.d = d;
            }
        }
    }

    @Override // p0.r
    public final boolean e() {
        return true;
    }

    @Override // p0.j
    public final boolean f(p0.g gVar) {
        return o.c(gVar, false);
    }

    @Override // p0.r
    public final p0.q g(long j2) {
        long j5;
        long j6;
        long j7;
        long j8;
        int[] iArr;
        long j9;
        int a5;
        n nVar = this;
        long j10 = j2;
        m[] mVarArr = nVar.f3845p;
        int length = mVarArr.length;
        p0.s sVar = p0.s.c;
        if (length == 0) {
            return new p0.q(sVar, sVar);
        }
        int i3 = nVar.f3846r;
        boolean z3 = false;
        if (i3 != -1) {
            s sVar2 = mVarArr[i3].b;
            int d = w.d(sVar2.f3875f, j10, false);
            while (true) {
                if (d >= 0) {
                    if ((sVar2.f3876g[d] & 1) != 0) {
                        break;
                    }
                    d--;
                } else {
                    d = -1;
                    break;
                }
            }
            if (d == -1) {
                d = sVar2.a(j10);
            }
            if (d == -1) {
                return new p0.q(sVar, sVar);
            }
            long[] jArr = sVar2.f3875f;
            long j11 = jArr[d];
            long[] jArr2 = sVar2.c;
            j5 = jArr2[d];
            if (j11 < j10 && d < sVar2.b - 1 && (a5 = sVar2.a(j10)) != -1 && a5 != d) {
                j9 = jArr[a5];
                j7 = jArr2[a5];
            } else {
                j9 = -9223372036854775807L;
                j7 = -1;
            }
            j6 = j9;
            j10 = j11;
        } else {
            j5 = Long.MAX_VALUE;
            j6 = -9223372036854775807L;
            j7 = -1;
        }
        long j12 = j5;
        int i5 = 0;
        while (true) {
            m[] mVarArr2 = nVar.f3845p;
            if (i5 >= mVarArr2.length) {
                break;
            }
            if (i5 != nVar.f3846r) {
                s sVar3 = mVarArr2[i5].b;
                int d5 = w.d(sVar3.f3875f, j10, z3);
                while (true) {
                    iArr = sVar3.f3876g;
                    if (d5 >= 0) {
                        if ((iArr[d5] & 1) != 0) {
                            break;
                        }
                        d5--;
                    } else {
                        d5 = -1;
                        break;
                    }
                }
                if (d5 == -1) {
                    d5 = sVar3.a(j10);
                }
                long[] jArr3 = sVar3.c;
                if (d5 == -1) {
                    j8 = j10;
                } else {
                    j8 = j10;
                    j12 = Math.min(jArr3[d5], j12);
                }
                if (j6 != -9223372036854775807L) {
                    int d6 = w.d(sVar3.f3875f, j6, false);
                    while (true) {
                        if (d6 >= 0) {
                            if ((iArr[d6] & 1) != 0) {
                                break;
                            }
                            d6--;
                        } else {
                            d6 = -1;
                            break;
                        }
                    }
                    if (d6 == -1) {
                        d6 = sVar3.a(j6);
                    }
                    if (d6 != -1) {
                        j7 = Math.min(jArr3[d6], j7);
                    }
                    i5++;
                    nVar = this;
                    j10 = j8;
                    z3 = false;
                }
            } else {
                j8 = j10;
            }
            i5++;
            nVar = this;
            j10 = j8;
            z3 = false;
        }
        p0.s sVar4 = new p0.s(j10, j12);
        if (j6 == -9223372036854775807L) {
            return new p0.q(sVar4, sVar4);
        }
        return new p0.q(sVar4, new p0.s(j6, j7));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v9 */
    @Override // p0.j
    public final int h(p0.g gVar, p0.m mVar) {
        int i3;
        boolean z3;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        while (true) {
            int i5 = this.f3835f;
            ArrayDeque arrayDeque = this.f3834e;
            c0.b bVar = this.c;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2) {
                        long j2 = gVar.d;
                        if (this.f3840k == -1) {
                            long j5 = Long.MAX_VALUE;
                            long j6 = Long.MAX_VALUE;
                            long j7 = Long.MAX_VALUE;
                            boolean z9 = true;
                            int i6 = 0;
                            boolean z10 = true;
                            int i7 = -1;
                            int i8 = -1;
                            while (true) {
                                m[] mVarArr = this.f3845p;
                                if (i6 >= mVarArr.length) {
                                    break;
                                }
                                m mVar2 = mVarArr[i6];
                                int i9 = mVar2.d;
                                s sVar = mVar2.b;
                                if (i9 != sVar.b) {
                                    long j8 = sVar.c[i9];
                                    long j9 = this.q[i6][i9];
                                    long j10 = j8 - j2;
                                    if (j10 >= 0 && j10 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                                        z3 = false;
                                    } else {
                                        z3 = true;
                                    }
                                    if ((!z3 && z9) || (z3 == z9 && j10 < j7)) {
                                        z9 = z3;
                                        j6 = j9;
                                        i8 = i6;
                                        j7 = j10;
                                    }
                                    if (j9 < j5) {
                                        z10 = z3;
                                        j5 = j9;
                                        i7 = i6;
                                    }
                                }
                                i6++;
                            }
                            if (j5 != Long.MAX_VALUE && z10 && j6 >= j5 + 10485760) {
                                i3 = i7;
                            } else {
                                i3 = i8;
                            }
                            this.f3840k = i3;
                            if (i3 == -1) {
                                return -1;
                            }
                        }
                        m mVar3 = this.f3845p[this.f3840k];
                        u uVar = mVar3.c;
                        int i10 = mVar3.d;
                        s sVar2 = mVar3.b;
                        long j11 = sVar2.c[i10];
                        int i11 = sVar2.d[i10];
                        long j12 = (j11 - j2) + this.f3841l;
                        if (j12 >= 0 && j12 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                            p pVar = mVar3.f3832a;
                            if (pVar.f3852g == 1) {
                                j12 += 8;
                                i11 -= 8;
                            }
                            gVar.h((int) j12);
                            int i12 = pVar.f3855j;
                            if (i12 != 0) {
                                c0.b bVar2 = this.b;
                                byte[] bArr = bVar2.f187a;
                                ?? r10 = 0;
                                bArr[0] = 0;
                                bArr[1] = 0;
                                bArr[2] = 0;
                                int i13 = 4 - i12;
                                while (this.f3842m < i11) {
                                    int i14 = this.f3843n;
                                    if (i14 == 0) {
                                        gVar.g(bArr, i13, i12, r10);
                                        this.f3841l += i12;
                                        bVar2.y(r10);
                                        int c = bVar2.c();
                                        if (c >= 0) {
                                            this.f3843n = c;
                                            c0.b bVar3 = this.f3833a;
                                            bVar3.y(r10);
                                            uVar.b(4, bVar3);
                                            this.f3842m += 4;
                                            i11 += i13;
                                        } else {
                                            throw new IOException("Invalid NAL length");
                                        }
                                    } else {
                                        int a5 = uVar.a(gVar, i14, r10);
                                        this.f3841l += a5;
                                        this.f3842m += a5;
                                        this.f3843n -= a5;
                                    }
                                    r10 = 0;
                                }
                            } else {
                                if ("audio/ac4".equals(pVar.f3851f.f311i)) {
                                    if (this.f3842m == 0) {
                                        l0.a.b(i11, bVar);
                                        uVar.b(7, bVar);
                                        this.f3842m += 7;
                                    }
                                    i11 += 7;
                                }
                                while (true) {
                                    int i15 = this.f3842m;
                                    if (i15 >= i11) {
                                        break;
                                    }
                                    int a6 = uVar.a(gVar, i11 - i15, false);
                                    this.f3841l += a6;
                                    this.f3842m += a6;
                                    this.f3843n -= a6;
                                }
                            }
                            uVar.c(sVar2.f3875f[i10], sVar2.f3876g[i10], i11, 0, null);
                            mVar3.d++;
                            this.f3840k = -1;
                            this.f3841l = 0;
                            this.f3842m = 0;
                            this.f3843n = 0;
                            return 0;
                        }
                        mVar.f3114a = j11;
                        return 1;
                    }
                    throw new IllegalStateException();
                }
                long j13 = this.f3837h;
                int i16 = this.f3838i;
                long j14 = j13 - i16;
                long j15 = gVar.d + j14;
                c0.b bVar4 = this.f3839j;
                if (bVar4 != null) {
                    gVar.g(bVar4.f187a, i16, (int) j14, false);
                    if (this.f3836g == 1718909296) {
                        c0.b bVar5 = this.f3839j;
                        bVar5.y(8);
                        if (bVar5.c() == 1903435808) {
                            z6 = true;
                            break;
                        }
                        bVar5.z(4);
                        while (bVar5.a() > 0) {
                            if (bVar5.c() == 1903435808) {
                                z6 = true;
                                break;
                            }
                        }
                        z6 = false;
                        this.f3847t = z6;
                    } else if (!arrayDeque.isEmpty()) {
                        ((a) arrayDeque.peek()).c.add(new b(this.f3836g, this.f3839j));
                    }
                } else if (j14 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    gVar.h((int) j14);
                } else {
                    mVar.f3114a = j15;
                    z5 = true;
                    j(j15);
                    if (z5 && this.f3835f != 2) {
                        return 1;
                    }
                }
                z5 = false;
                j(j15);
                if (z5) {
                    return 1;
                }
                continue;
            } else {
                int i17 = this.f3838i;
                c0.b bVar6 = this.d;
                if (i17 == 0) {
                    if (!gVar.g(bVar6.f187a, 0, 8, true)) {
                        return -1;
                    }
                    this.f3838i = 8;
                    bVar6.y(0);
                    this.f3837h = bVar6.o();
                    this.f3836g = bVar6.c();
                }
                long j16 = this.f3837h;
                if (j16 == 1) {
                    gVar.g(bVar6.f187a, 8, 8, false);
                    this.f3838i += 8;
                    this.f3837h = bVar6.r();
                } else if (j16 == 0) {
                    long j17 = gVar.c;
                    if (j17 == -1 && !arrayDeque.isEmpty()) {
                        j17 = ((a) arrayDeque.peek()).b;
                    }
                    if (j17 != -1) {
                        this.f3837h = (j17 - gVar.d) + this.f3838i;
                    }
                }
                long j18 = this.f3837h;
                int i18 = this.f3838i;
                long j19 = i18;
                int i19 = (j18 > j19 ? 1 : (j18 == j19 ? 0 : -1));
                if (i19 >= 0) {
                    int i20 = this.f3836g;
                    if (i20 != 1836019574 && i20 != 1953653099 && i20 != 1835297121 && i20 != 1835626086 && i20 != 1937007212 && i20 != 1701082227 && i20 != 1835365473) {
                        if (i20 != 1835296868 && i20 != 1836476516 && i20 != 1751411826 && i20 != 1937011556 && i20 != 1937011827 && i20 != 1937011571 && i20 != 1668576371 && i20 != 1701606260 && i20 != 1937011555 && i20 != 1937011578 && i20 != 1937013298 && i20 != 1937007471 && i20 != 1668232756 && i20 != 1953196132 && i20 != 1718909296 && i20 != 1969517665 && i20 != 1801812339 && i20 != 1768715124) {
                            this.f3839j = null;
                            this.f3835f = 1;
                        } else {
                            if (i18 == 8) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            g2.b.h(z7);
                            if (this.f3837h <= 2147483647L) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            g2.b.h(z8);
                            c0.b bVar7 = new c0.b((int) this.f3837h);
                            this.f3839j = bVar7;
                            System.arraycopy(bVar6.f187a, 0, bVar7.f187a, 0, 8);
                            this.f3835f = 1;
                        }
                    } else {
                        long j20 = (gVar.d + j18) - j19;
                        if (i19 != 0 && i20 == 1835365473) {
                            bVar.v(8);
                            gVar.d(bVar.f187a, 0, 8, false);
                            bVar.z(4);
                            if (bVar.c() == 1751411826) {
                                gVar.f3111f = 0;
                            } else {
                                gVar.h(4);
                            }
                        }
                        arrayDeque.push(new a(this.f3836g, j20));
                        if (this.f3837h == this.f3838i) {
                            j(j20);
                        } else {
                            this.f3835f = 0;
                            this.f3838i = 0;
                        }
                    }
                } else {
                    throw new IOException("Atom size less than header length (unsupported).");
                }
            }
        }
    }

    @Override // p0.r
    public final long i() {
        return this.s;
    }

    /* JADX WARN: Code restructure failed: missing block: B:528:0x0c82, code lost:
        r13 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:529:0x0c86, code lost:
        if (r13.f3835f == 2) goto L588;
     */
    /* JADX WARN: Code restructure failed: missing block: B:530:0x0c88, code lost:
        r13.f3835f = 0;
        r13.f3838i = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:531:0x0c8d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:598:?, code lost:
        return;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0623  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x064f  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x071c  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x077e  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0781  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x07a4  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x07be  */
    /* JADX WARN: Removed duplicated region for block: B:552:0x0a29 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:566:0x070f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:576:0x072b A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v78, types: [com.google.android.exoplayer2.metadata.id3.InternalFrame] */
    /* JADX WARN: Type inference failed for: r5v76, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v77 */
    /* JADX WARN: Type inference failed for: r5v85 */
    /* JADX WARN: Type inference failed for: r8v64, types: [com.google.android.exoplayer2.metadata.id3.CommentFrame] */
    /* JADX WARN: Type inference failed for: r8v80, types: [com.google.android.exoplayer2.metadata.id3.Id3Frame] */
    /* JADX WARN: Type inference failed for: r8v81, types: [com.google.android.exoplayer2.metadata.id3.Id3Frame] */
    /* JADX WARN: Type inference failed for: r8v88, types: [com.google.android.exoplayer2.metadata.id3.ApicFrame] */
    /* JADX WARN: Type inference failed for: r8v89, types: [com.google.android.exoplayer2.metadata.id3.Id3Frame] */
    /* JADX WARN: Type inference failed for: r8v90, types: [com.google.android.exoplayer2.metadata.id3.Id3Frame] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(long r68) {
        /*
            Method dump skipped, instructions count: 3214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.n.j(long):void");
    }
}
