package v0;

import java.nio.ByteBuffer;
import java.util.UUID;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f3848a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153};

    public static byte[] a(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int i3;
        int i5;
        if (bArr != null) {
            i3 = bArr.length;
        } else {
            i3 = 0;
        }
        int i6 = i3 + 32;
        if (uuidArr != null) {
            i6 += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i6);
        allocate.putInt(i6);
        allocate.putInt(1886614376);
        if (uuidArr != null) {
            i5 = 16777216;
        } else {
            i5 = 0;
        }
        allocate.putInt(i5);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr != null && bArr.length != 0) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.UUID b(byte[] r9) {
        /*
            c0.b r0 = new c0.b
            r0.<init>(r9)
            int r9 = r0.c
            r1 = 32
            r2 = 0
            if (r9 >= r1) goto Le
        Lc:
            r9 = r2
            goto L6a
        Le:
            r9 = 0
            r0.y(r9)
            int r1 = r0.c()
            int r3 = r0.a()
            int r3 = r3 + 4
            if (r1 == r3) goto L1f
            goto Lc
        L1f:
            int r1 = r0.c()
            r3 = 1886614376(0x70737368, float:3.013775E29)
            if (r1 == r3) goto L29
            goto Lc
        L29:
            int r1 = r0.c()
            int r1 = v0.c.b(r1)
            r3 = 1
            if (r1 <= r3) goto L3c
            java.lang.String r9 = "Unsupported pssh version: "
            java.lang.String r0 = "PsshAtomUtil"
            a1.i.r(r9, r1, r0)
            goto Lc
        L3c:
            java.util.UUID r4 = new java.util.UUID
            long r5 = r0.h()
            long r7 = r0.h()
            r4.<init>(r5, r7)
            if (r1 != r3) goto L54
            int r1 = r0.q()
            int r1 = r1 * 16
            r0.z(r1)
        L54:
            int r1 = r0.q()
            int r3 = r0.a()
            if (r1 == r3) goto L5f
            goto Lc
        L5f:
            byte[] r3 = new byte[r1]
            r0.b(r3, r9, r1)
            t2.p0 r9 = new t2.p0
            r0 = 3
            r9.<init>(r0, r4)
        L6a:
            if (r9 != 0) goto L6d
            return r2
        L6d:
            java.lang.Object r9 = r9.b
            java.util.UUID r9 = (java.util.UUID) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.o.b(byte[]):java.util.UUID");
    }

    public static boolean c(p0.g gVar, boolean z3) {
        boolean z5;
        boolean z6;
        int i3;
        long j2 = gVar.c;
        long j5 = 4096;
        long j6 = -1;
        int i5 = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
        if (i5 != 0 && j2 <= 4096) {
            j5 = j2;
        }
        int i6 = (int) j5;
        c0.b bVar = new c0.b(64);
        boolean z7 = false;
        int i7 = 0;
        boolean z8 = false;
        while (i7 < i6) {
            bVar.v(8);
            gVar.d(bVar.f187a, z7 ? 1 : 0, 8, z7);
            long o5 = bVar.o();
            int c = bVar.c();
            if (o5 == 1) {
                gVar.d(bVar.f187a, 8, 8, z7);
                bVar.x(16);
                o5 = bVar.h();
                i3 = 16;
            } else {
                if (o5 == 0 && j2 != j6) {
                    o5 = (j2 - gVar.c()) + 8;
                }
                i3 = 8;
            }
            long j7 = i3;
            if (o5 < j7) {
                return z7;
            }
            i7 += i3;
            if (c == 1836019574) {
                i6 += (int) o5;
                if (i5 != 0 && i6 > j2) {
                    i6 = (int) j2;
                }
                j6 = -1;
            } else if (c == 1836019558 || c == 1836475768) {
                z5 = true;
                z6 = true;
                break;
            } else {
                int i8 = i5;
                if ((i7 + o5) - j7 >= i6) {
                    break;
                }
                int i9 = (int) (o5 - j7);
                i7 += i9;
                if (c == 1718909296) {
                    if (i9 < 8) {
                        return false;
                    }
                    bVar.v(i9);
                    gVar.d(bVar.f187a, 0, i9, false);
                    int i10 = i9 / 4;
                    for (int i11 = 0; i11 < i10; i11++) {
                        if (i11 == 1) {
                            bVar.z(4);
                        } else {
                            int c5 = bVar.c();
                            if ((c5 >>> 8) != 3368816) {
                                int[] iArr = f3848a;
                                for (int i12 = 0; i12 < 26; i12++) {
                                    if (iArr[i12] != c5) {
                                    }
                                }
                                continue;
                            }
                            z8 = true;
                            break;
                        }
                    }
                    if (!z8) {
                        return false;
                    }
                } else if (i9 != 0) {
                    gVar.a(i9, false);
                }
                i5 = i8;
                j6 = -1;
                z7 = false;
            }
        }
        z5 = true;
        z6 = false;
        if (!z8 || z3 != z6) {
            return false;
        }
        return z5;
    }
}
