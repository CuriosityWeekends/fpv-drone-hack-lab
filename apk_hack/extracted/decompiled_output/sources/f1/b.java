package f1;

import a1.f;
import b1.d;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import g2.n;
import g2.w;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements b1.b {
    public static final f b = new f(2);

    /* renamed from: a  reason: collision with root package name */
    public final f f1802a;

    public b(f fVar) {
        this.f1802a = fVar;
    }

    public static ApicFrame c(c0.b bVar, int i3, int i5) {
        int t4;
        String E;
        byte[] copyOfRange;
        int n5 = bVar.n();
        String q = q(n5);
        int i6 = i3 - 1;
        byte[] bArr = new byte[i6];
        bVar.b(bArr, 0, i6);
        if (i5 == 2) {
            E = "image/" + w.E(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(E)) {
                E = "image/jpeg";
            }
            t4 = 2;
        } else {
            t4 = t(bArr, 0);
            E = w.E(new String(bArr, 0, t4, "ISO-8859-1"));
            if (E.indexOf(47) == -1) {
                E = "image/".concat(E);
            }
        }
        int i7 = bArr[t4 + 1] & 255;
        int i8 = t4 + 2;
        int s = s(bArr, i8, n5);
        String str = new String(bArr, i8, s - i8, q);
        int p5 = p(n5) + s;
        if (i6 <= p5) {
            copyOfRange = w.f1962f;
        } else {
            copyOfRange = Arrays.copyOfRange(bArr, p5, i6);
        }
        return new ApicFrame(E, str, i7, copyOfRange);
    }

    public static ChapterFrame d(c0.b bVar, int i3, int i5, boolean z3, int i6, f fVar) {
        long j2;
        long j5;
        int i7 = bVar.b;
        int t4 = t(bVar.f187a, i7);
        String str = new String(bVar.f187a, i7, t4 - i7, "ISO-8859-1");
        bVar.y(t4 + 1);
        int c = bVar.c();
        int c5 = bVar.c();
        long o5 = bVar.o();
        if (o5 == 4294967295L) {
            j2 = -1;
        } else {
            j2 = o5;
        }
        long o6 = bVar.o();
        if (o6 == 4294967295L) {
            j5 = -1;
        } else {
            j5 = o6;
        }
        ArrayList arrayList = new ArrayList();
        int i8 = i7 + i3;
        while (bVar.b < i8) {
            Id3Frame g5 = g(i5, bVar, z3, i6, fVar);
            if (g5 != null) {
                arrayList.add(g5);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, c, c5, j2, j5, id3FrameArr);
    }

    public static ChapterTocFrame e(c0.b bVar, int i3, int i5, boolean z3, int i6, f fVar) {
        boolean z5;
        boolean z6;
        int i7 = bVar.b;
        int t4 = t(bVar.f187a, i7);
        String str = new String(bVar.f187a, i7, t4 - i7, "ISO-8859-1");
        bVar.y(t4 + 1);
        int n5 = bVar.n();
        if ((n5 & 2) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if ((n5 & 1) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        int n6 = bVar.n();
        String[] strArr = new String[n6];
        for (int i8 = 0; i8 < n6; i8++) {
            int i9 = bVar.b;
            int t5 = t(bVar.f187a, i9);
            strArr[i8] = new String(bVar.f187a, i9, t5 - i9, "ISO-8859-1");
            bVar.y(t5 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i10 = i7 + i3;
        while (bVar.b < i10) {
            Id3Frame g5 = g(i5, bVar, z3, i6, fVar);
            if (g5 != null) {
                arrayList.add(g5);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z5, z6, strArr, id3FrameArr);
    }

    public static CommentFrame f(int i3, c0.b bVar) {
        if (i3 < 4) {
            return null;
        }
        int n5 = bVar.n();
        String q = q(n5);
        byte[] bArr = new byte[3];
        bVar.b(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i5 = i3 - 4;
        byte[] bArr2 = new byte[i5];
        bVar.b(bArr2, 0, i5);
        int s = s(bArr2, 0, n5);
        String str2 = new String(bArr2, 0, s, q);
        int p5 = p(n5) + s;
        return new CommentFrame(str, str2, k(bArr2, p5, s(bArr2, p5, n5), q));
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x0185, code lost:
        if (r14 == 67) goto L108;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.exoplayer2.metadata.id3.Id3Frame g(int r19, c0.b r20, boolean r21, int r22, a1.f r23) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.b.g(int, c0.b, boolean, int, a1.f):com.google.android.exoplayer2.metadata.id3.Id3Frame");
    }

    public static GeobFrame h(int i3, c0.b bVar) {
        byte[] copyOfRange;
        int n5 = bVar.n();
        String q = q(n5);
        int i5 = i3 - 1;
        byte[] bArr = new byte[i5];
        bVar.b(bArr, 0, i5);
        int t4 = t(bArr, 0);
        String str = new String(bArr, 0, t4, "ISO-8859-1");
        int i6 = t4 + 1;
        int s = s(bArr, i6, n5);
        String k5 = k(bArr, i6, s, q);
        int p5 = p(n5) + s;
        int s5 = s(bArr, p5, n5);
        String k6 = k(bArr, p5, s5, q);
        int p6 = p(n5) + s5;
        if (i5 <= p6) {
            copyOfRange = w.f1962f;
        } else {
            copyOfRange = Arrays.copyOfRange(bArr, p6, i5);
        }
        return new GeobFrame(str, k5, k6, copyOfRange);
    }

    public static MlltFrame i(int i3, c0.b bVar) {
        int s = bVar.s();
        int p5 = bVar.p();
        int p6 = bVar.p();
        int n5 = bVar.n();
        int n6 = bVar.n();
        n nVar = new n();
        nVar.k(bVar.f187a, bVar.c);
        nVar.l(bVar.b * 8);
        int i5 = ((i3 - 10) * 8) / (n5 + n6);
        int[] iArr = new int[i5];
        int[] iArr2 = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            int g5 = nVar.g(n5);
            int g6 = nVar.g(n6);
            iArr[i6] = g5;
            iArr2[i6] = g6;
        }
        return new MlltFrame(s, p5, iArr, iArr2, p6);
    }

    public static PrivFrame j(int i3, c0.b bVar) {
        byte[] copyOfRange;
        byte[] bArr = new byte[i3];
        bVar.b(bArr, 0, i3);
        int t4 = t(bArr, 0);
        String str = new String(bArr, 0, t4, "ISO-8859-1");
        int i5 = t4 + 1;
        if (i3 <= i5) {
            copyOfRange = w.f1962f;
        } else {
            copyOfRange = Arrays.copyOfRange(bArr, i5, i3);
        }
        return new PrivFrame(copyOfRange, str);
    }

    public static String k(byte[] bArr, int i3, int i5, String str) {
        if (i5 > i3 && i5 <= bArr.length) {
            return new String(bArr, i3, i5 - i3, str);
        }
        return "";
    }

    public static TextInformationFrame l(int i3, c0.b bVar, String str) {
        if (i3 < 1) {
            return null;
        }
        int n5 = bVar.n();
        String q = q(n5);
        int i5 = i3 - 1;
        byte[] bArr = new byte[i5];
        bVar.b(bArr, 0, i5);
        return new TextInformationFrame(str, null, new String(bArr, 0, s(bArr, 0, n5), q));
    }

    public static TextInformationFrame m(int i3, c0.b bVar) {
        if (i3 < 1) {
            return null;
        }
        int n5 = bVar.n();
        String q = q(n5);
        int i5 = i3 - 1;
        byte[] bArr = new byte[i5];
        bVar.b(bArr, 0, i5);
        int s = s(bArr, 0, n5);
        String str = new String(bArr, 0, s, q);
        int p5 = p(n5) + s;
        return new TextInformationFrame("TXXX", str, k(bArr, p5, s(bArr, p5, n5), q));
    }

    public static UrlLinkFrame n(int i3, c0.b bVar, String str) {
        byte[] bArr = new byte[i3];
        bVar.b(bArr, 0, i3);
        return new UrlLinkFrame(str, null, new String(bArr, 0, t(bArr, 0), "ISO-8859-1"));
    }

    public static UrlLinkFrame o(int i3, c0.b bVar) {
        if (i3 < 1) {
            return null;
        }
        int n5 = bVar.n();
        String q = q(n5);
        int i5 = i3 - 1;
        byte[] bArr = new byte[i5];
        bVar.b(bArr, 0, i5);
        int s = s(bArr, 0, n5);
        String str = new String(bArr, 0, s, q);
        int p5 = p(n5) + s;
        return new UrlLinkFrame("WXXX", str, k(bArr, p5, t(bArr, p5), "ISO-8859-1"));
    }

    public static int p(int i3) {
        if (i3 != 0 && i3 != 3) {
            return 2;
        }
        return 1;
    }

    public static String q(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "ISO-8859-1";
                }
                return "UTF-8";
            }
            return "UTF-16BE";
        }
        return "UTF-16";
    }

    public static String r(int i3, int i5, int i6, int i7, int i8) {
        if (i3 == 2) {
            return String.format(Locale.US, "%c%c%c", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
        }
        return String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
    }

    public static int s(byte[] bArr, int i3, int i5) {
        int t4 = t(bArr, i3);
        if (i5 != 0 && i5 != 3) {
            while (t4 < bArr.length - 1) {
                if (t4 % 2 == 0 && bArr[t4 + 1] == 0) {
                    return t4;
                }
                t4 = t(bArr, t4 + 1);
            }
            return bArr.length;
        }
        return t4;
    }

    public static int t(byte[] bArr, int i3) {
        while (i3 < bArr.length) {
            if (bArr[i3] == 0) {
                return i3;
            }
            i3++;
        }
        return bArr.length;
    }

    public static int u(int i3, c0.b bVar) {
        byte[] bArr = bVar.f187a;
        int i5 = bVar.b;
        int i6 = i5;
        while (true) {
            int i7 = i6 + 1;
            if (i7 < i5 + i3) {
                if ((bArr[i6] & 255) == 255 && bArr[i7] == 0) {
                    System.arraycopy(bArr, i6 + 2, bArr, i7, (i3 - (i6 - i5)) - 2);
                    i3--;
                }
                i6 = i7;
            } else {
                return i3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0077, code lost:
        if ((r10 & 1) != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0085, code lost:
        if ((r10 & 128) != 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean v(c0.b r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.b
        L6:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> L20
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Laa
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L23
            int r7 = r18.c()     // Catch: java.lang.Throwable -> L20
            long r8 = r18.o()     // Catch: java.lang.Throwable -> L20
            int r10 = r18.s()     // Catch: java.lang.Throwable -> L20
            goto L2d
        L20:
            r0 = move-exception
            goto Lae
        L23:
            int r7 = r18.p()     // Catch: java.lang.Throwable -> L20
            int r8 = r18.p()     // Catch: java.lang.Throwable -> L20
            long r8 = (long) r8
            r10 = 0
        L2d:
            r11 = 0
            if (r7 != 0) goto L3b
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3b
            if (r10 != 0) goto L3b
            r1.y(r2)
            return r4
        L3b:
            r7 = 4
            if (r0 != r7) goto L6c
            if (r21 != 0) goto L6c
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L4c
            r1.y(r2)
            return r6
        L4c:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6c:
            if (r0 != r7) goto L7a
            r3 = r10 & 64
            if (r3 == 0) goto L74
            r3 = 1
            goto L75
        L74:
            r3 = 0
        L75:
            r7 = r10 & 1
            if (r7 == 0) goto L89
            goto L8a
        L7a:
            if (r0 != r3) goto L88
            r3 = r10 & 32
            if (r3 == 0) goto L82
            r3 = 1
            goto L83
        L82:
            r3 = 0
        L83:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L89
            goto L8a
        L88:
            r3 = 0
        L89:
            r4 = 0
        L8a:
            if (r4 == 0) goto L8e
            int r3 = r3 + 4
        L8e:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L97
            r1.y(r2)
            return r6
        L97:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> L20
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto La4
            r1.y(r2)
            return r6
        La4:
            int r3 = (int) r8
            r1.z(r3)     // Catch: java.lang.Throwable -> L20
            goto L6
        Laa:
            r1.y(r2)
            return r4
        Lae:
            r1.y(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.b.v(c0.b, int, int, boolean):boolean");
    }

    @Override // b1.b
    public final Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.b;
        byteBuffer.getClass();
        return b(byteBuffer.array(), byteBuffer.limit());
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.exoplayer2.metadata.Metadata b(byte[] r13, int r14) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.b.b(byte[], int):com.google.android.exoplayer2.metadata.Metadata");
    }
}
