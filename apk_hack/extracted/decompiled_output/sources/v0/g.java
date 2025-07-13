package v0;

import android.util.Pair;
import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3800a = w.r("OpusHead");

    public static Pair a(int i3, c0.b bVar) {
        bVar.y(i3 + 12);
        bVar.z(1);
        b(bVar);
        bVar.z(2);
        int n5 = bVar.n();
        if ((n5 & 128) != 0) {
            bVar.z(2);
        }
        if ((n5 & 64) != 0) {
            bVar.z(bVar.s());
        }
        if ((n5 & 32) != 0) {
            bVar.z(2);
        }
        bVar.z(1);
        b(bVar);
        String c = g2.k.c(bVar.n());
        if (!"audio/mpeg".equals(c) && !"audio/vnd.dts".equals(c) && !"audio/vnd.dts.hd".equals(c)) {
            bVar.z(12);
            bVar.z(1);
            int b = b(bVar);
            byte[] bArr = new byte[b];
            bVar.b(bArr, 0, b);
            return Pair.create(c, bArr);
        }
        return Pair.create(c, null);
    }

    public static int b(c0.b bVar) {
        int n5 = bVar.n();
        int i3 = n5 & 127;
        while ((n5 & 128) == 128) {
            n5 = bVar.n();
            i3 = (i3 << 7) | (n5 & 127);
        }
        return i3;
    }

    public static Pair c(c0.b bVar, int i3, int i5) {
        boolean z3;
        boolean z5;
        boolean z6;
        Integer num;
        q qVar;
        Pair create;
        int i6;
        int i7;
        boolean z7;
        byte[] bArr;
        int i8 = bVar.b;
        while (i8 - i3 < i5) {
            bVar.y(i8);
            int c = bVar.c();
            boolean z8 = false;
            if (c > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            g2.b.d("childAtomSize should be positive", z3);
            if (bVar.c() == 1936289382) {
                int i9 = i8 + 8;
                int i10 = -1;
                int i11 = 0;
                String str = null;
                Integer num2 = null;
                while (i9 - i8 < c) {
                    bVar.y(i9);
                    int c5 = bVar.c();
                    int c6 = bVar.c();
                    if (c6 == 1718775137) {
                        num2 = Integer.valueOf(bVar.c());
                    } else if (c6 == 1935894637) {
                        bVar.z(4);
                        str = bVar.k(4);
                    } else if (c6 == 1935894633) {
                        i10 = i9;
                        i11 = c5;
                    }
                    i9 += c5;
                }
                if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
                    create = null;
                } else {
                    if (num2 != null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    g2.b.d("frma atom is mandatory", z5);
                    if (i10 != -1) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    g2.b.d("schi atom is mandatory", z6);
                    int i12 = i10 + 8;
                    while (true) {
                        if (i12 - i10 < i11) {
                            bVar.y(i12);
                            int c7 = bVar.c();
                            if (bVar.c() == 1952804451) {
                                int b = c.b(bVar.c());
                                bVar.z(1);
                                if (b == 0) {
                                    bVar.z(1);
                                    i6 = 0;
                                    i7 = 0;
                                } else {
                                    int n5 = bVar.n();
                                    i6 = n5 & 15;
                                    i7 = (n5 & 240) >> 4;
                                }
                                if (bVar.n() == 1) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                int n6 = bVar.n();
                                byte[] bArr2 = new byte[16];
                                bVar.b(bArr2, 0, 16);
                                if (z7 && n6 == 0) {
                                    int n7 = bVar.n();
                                    byte[] bArr3 = new byte[n7];
                                    bVar.b(bArr3, 0, n7);
                                    bArr = bArr3;
                                } else {
                                    bArr = null;
                                }
                                num = num2;
                                qVar = new q(z7, str, n6, bArr2, i7, i6, bArr);
                            } else {
                                i12 += c7;
                            }
                        } else {
                            num = num2;
                            qVar = null;
                            break;
                        }
                    }
                    if (qVar != null) {
                        z8 = true;
                    }
                    g2.b.d("tenc atom is mandatory", z8);
                    create = Pair.create(num, qVar);
                }
                if (create != null) {
                    return create;
                }
            }
            i8 += c;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x009e, code lost:
        if (r5 == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a0, code lost:
        r5 = -9223372036854775807L;
     */
    /* JADX WARN: Removed duplicated region for block: B:278:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0709  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x093b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static v0.p d(v0.a r55, v0.b r56, long r57, com.google.android.exoplayer2.drm.DrmInitData r59, boolean r60, boolean r61) {
        /*
            Method dump skipped, instructions count: 2623
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.g.d(v0.a, v0.b, long, com.google.android.exoplayer2.drm.DrmInitData, boolean, boolean):v0.p");
    }
}
