package p2;

import a1.i;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class a implements Closeable {

    /* renamed from: p  reason: collision with root package name */
    public static final char[] f3208p = ")]}'\n".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    public final Reader f3209a;

    /* renamed from: i  reason: collision with root package name */
    public long f3214i;

    /* renamed from: j  reason: collision with root package name */
    public int f3215j;

    /* renamed from: k  reason: collision with root package name */
    public String f3216k;

    /* renamed from: l  reason: collision with root package name */
    public int[] f3217l;

    /* renamed from: n  reason: collision with root package name */
    public String[] f3219n;

    /* renamed from: o  reason: collision with root package name */
    public int[] f3220o;
    public boolean b = false;
    public final char[] c = new char[1024];
    public int d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f3210e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f3211f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f3212g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f3213h = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f3218m = 1;

    static {
        j3.a.c = new j3.a(23);
    }

    public a(StringReader stringReader) {
        int[] iArr = new int[32];
        this.f3217l = iArr;
        iArr[0] = 6;
        this.f3219n = new String[32];
        this.f3220o = new int[32];
        this.f3209a = stringReader;
    }

    public final void A(String str) {
        StringBuilder l5 = i.l(str);
        l5.append(j());
        throw new IOException(l5.toString());
    }

    public final void a() {
        int i3 = this.f3213h;
        if (i3 == 0) {
            i3 = d();
        }
        if (i3 == 3) {
            v(1);
            this.f3220o[this.f3218m - 1] = 0;
            this.f3213h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + i.B(u()) + j());
    }

    public final void b() {
        int i3 = this.f3213h;
        if (i3 == 0) {
            i3 = d();
        }
        if (i3 == 1) {
            v(3);
            this.f3213h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + i.B(u()) + j());
    }

    public final void c() {
        if (this.b) {
            return;
        }
        A("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f3213h = 0;
        this.f3217l[0] = 8;
        this.f3218m = 1;
        this.f3209a.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x0203, code lost:
        if (i(r1) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0205, code lost:
        if (r5 != 2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0207, code lost:
        if (r9 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x020d, code lost:
        if (r10 != Long.MIN_VALUE) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x020f, code lost:
        if (r16 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0213, code lost:
        if (r10 != 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0215, code lost:
        if (r16 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0217, code lost:
        if (r16 == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x021a, code lost:
        r10 = -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x021b, code lost:
        r20.f3214i = r10;
        r20.d += r7;
        r14 = 15;
        r20.f3213h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0227, code lost:
        if (r5 == 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x022a, code lost:
        if (r5 == 4) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x022d, code lost:
        if (r5 != 7) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x022f, code lost:
        r20.f3215j = r7;
        r14 = 16;
        r20.f3213h = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x016c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0264 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d() {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.a.d():int");
    }

    public final void e() {
        int i3 = this.f3213h;
        if (i3 == 0) {
            i3 = d();
        }
        if (i3 == 4) {
            int i5 = this.f3218m;
            this.f3218m = i5 - 1;
            int[] iArr = this.f3220o;
            int i6 = i5 - 2;
            iArr[i6] = iArr[i6] + 1;
            this.f3213h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + i.B(u()) + j());
    }

    public final void f() {
        int i3 = this.f3213h;
        if (i3 == 0) {
            i3 = d();
        }
        if (i3 == 2) {
            int i5 = this.f3218m;
            int i6 = i5 - 1;
            this.f3218m = i6;
            this.f3219n[i6] = null;
            int[] iArr = this.f3220o;
            int i7 = i5 - 2;
            iArr[i7] = iArr[i7] + 1;
            this.f3213h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + i.B(u()) + j());
    }

    public final boolean g(int i3) {
        int i5;
        int i6;
        int i7 = this.f3212g;
        int i8 = this.d;
        this.f3212g = i7 - i8;
        int i9 = this.f3210e;
        char[] cArr = this.c;
        if (i9 != i8) {
            int i10 = i9 - i8;
            this.f3210e = i10;
            System.arraycopy(cArr, i8, cArr, 0, i10);
        } else {
            this.f3210e = 0;
        }
        this.d = 0;
        do {
            int i11 = this.f3210e;
            int read = this.f3209a.read(cArr, i11, cArr.length - i11);
            if (read == -1) {
                return false;
            }
            i5 = this.f3210e + read;
            this.f3210e = i5;
            if (this.f3211f == 0 && (i6 = this.f3212g) == 0 && i5 > 0 && cArr[0] == 65279) {
                this.d++;
                this.f3212g = i6 + 1;
                i3++;
                continue;
            }
        } while (i5 < i3);
        return true;
    }

    public final boolean h() {
        int i3 = this.f3213h;
        if (i3 == 0) {
            i3 = d();
        }
        if (i3 != 2 && i3 != 4) {
            return true;
        }
        return false;
    }

    public final boolean i(char c) {
        if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
            if (c != '#') {
                if (c != ',') {
                    if (c != '/' && c != '=') {
                        if (c != '{' && c != '}' && c != ':') {
                            if (c != ';') {
                                switch (c) {
                                    case '[':
                                    case ']':
                                        return false;
                                    case '\\':
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
            c();
            return false;
        }
        return false;
    }

    public final String j() {
        StringBuilder n5 = i.n(" at line ", this.f3211f + 1, " column ", (this.d - this.f3212g) + 1, " path ");
        StringBuilder sb = new StringBuilder("$");
        int i3 = this.f3218m;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = this.f3217l[i5];
            if (i6 != 1 && i6 != 2) {
                if (i6 == 3 || i6 == 4 || i6 == 5) {
                    sb.append('.');
                    String str = this.f3219n[i5];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            } else {
                sb.append('[');
                sb.append(this.f3220o[i5]);
                sb.append(']');
            }
        }
        n5.append(sb.toString());
        return n5.toString();
    }

    public final boolean k() {
        int i3 = this.f3213h;
        if (i3 == 0) {
            i3 = d();
        }
        if (i3 == 5) {
            this.f3213h = 0;
            int[] iArr = this.f3220o;
            int i5 = this.f3218m - 1;
            iArr[i5] = iArr[i5] + 1;
            return true;
        } else if (i3 == 6) {
            this.f3213h = 0;
            int[] iArr2 = this.f3220o;
            int i6 = this.f3218m - 1;
            iArr2[i6] = iArr2[i6] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + i.B(u()) + j());
        }
    }

    public final double l() {
        char c;
        int i3 = this.f3213h;
        if (i3 == 0) {
            i3 = d();
        }
        if (i3 == 15) {
            this.f3213h = 0;
            int[] iArr = this.f3220o;
            int i5 = this.f3218m - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.f3214i;
        }
        if (i3 == 16) {
            this.f3216k = new String(this.c, this.d, this.f3215j);
            this.d += this.f3215j;
        } else if (i3 != 8 && i3 != 9) {
            if (i3 == 10) {
                this.f3216k = t();
            } else if (i3 != 11) {
                throw new IllegalStateException("Expected a double but was " + i.B(u()) + j());
            }
        } else {
            if (i3 == 8) {
                c = '\'';
            } else {
                c = '\"';
            }
            this.f3216k = r(c);
        }
        this.f3213h = 11;
        double parseDouble = Double.parseDouble(this.f3216k);
        if (!this.b && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new IOException("JSON forbids NaN and infinities: " + parseDouble + j());
        }
        this.f3216k = null;
        this.f3213h = 0;
        int[] iArr2 = this.f3220o;
        int i6 = this.f3218m - 1;
        iArr2[i6] = iArr2[i6] + 1;
        return parseDouble;
    }

    public final int m() {
        char c;
        int i3 = this.f3213h;
        if (i3 == 0) {
            i3 = d();
        }
        if (i3 == 15) {
            long j2 = this.f3214i;
            int i5 = (int) j2;
            if (j2 == i5) {
                this.f3213h = 0;
                int[] iArr = this.f3220o;
                int i6 = this.f3218m - 1;
                iArr[i6] = iArr[i6] + 1;
                return i5;
            }
            throw new NumberFormatException("Expected an int but was " + this.f3214i + j());
        }
        if (i3 == 16) {
            this.f3216k = new String(this.c, this.d, this.f3215j);
            this.d += this.f3215j;
        } else if (i3 != 8 && i3 != 9 && i3 != 10) {
            throw new IllegalStateException("Expected an int but was " + i.B(u()) + j());
        } else {
            if (i3 == 10) {
                this.f3216k = t();
            } else {
                if (i3 == 8) {
                    c = '\'';
                } else {
                    c = '\"';
                }
                this.f3216k = r(c);
            }
            try {
                int parseInt = Integer.parseInt(this.f3216k);
                this.f3213h = 0;
                int[] iArr2 = this.f3220o;
                int i7 = this.f3218m - 1;
                iArr2[i7] = iArr2[i7] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3213h = 11;
        double parseDouble = Double.parseDouble(this.f3216k);
        int i8 = (int) parseDouble;
        if (i8 == parseDouble) {
            this.f3216k = null;
            this.f3213h = 0;
            int[] iArr3 = this.f3220o;
            int i9 = this.f3218m - 1;
            iArr3[i9] = iArr3[i9] + 1;
            return i8;
        }
        throw new NumberFormatException("Expected an int but was " + this.f3216k + j());
    }

    public final long n() {
        char c;
        int i3 = this.f3213h;
        if (i3 == 0) {
            i3 = d();
        }
        if (i3 == 15) {
            this.f3213h = 0;
            int[] iArr = this.f3220o;
            int i5 = this.f3218m - 1;
            iArr[i5] = iArr[i5] + 1;
            return this.f3214i;
        }
        if (i3 == 16) {
            this.f3216k = new String(this.c, this.d, this.f3215j);
            this.d += this.f3215j;
        } else if (i3 != 8 && i3 != 9 && i3 != 10) {
            throw new IllegalStateException("Expected a long but was " + i.B(u()) + j());
        } else {
            if (i3 == 10) {
                this.f3216k = t();
            } else {
                if (i3 == 8) {
                    c = '\'';
                } else {
                    c = '\"';
                }
                this.f3216k = r(c);
            }
            try {
                long parseLong = Long.parseLong(this.f3216k);
                this.f3213h = 0;
                int[] iArr2 = this.f3220o;
                int i6 = this.f3218m - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3213h = 11;
        double parseDouble = Double.parseDouble(this.f3216k);
        long j2 = (long) parseDouble;
        if (j2 == parseDouble) {
            this.f3216k = null;
            this.f3213h = 0;
            int[] iArr3 = this.f3220o;
            int i7 = this.f3218m - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.f3216k + j());
    }

    public final String o() {
        String r5;
        int i3 = this.f3213h;
        if (i3 == 0) {
            i3 = d();
        }
        if (i3 == 14) {
            r5 = t();
        } else if (i3 == 12) {
            r5 = r('\'');
        } else if (i3 == 13) {
            r5 = r('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + i.B(u()) + j());
        }
        this.f3213h = 0;
        this.f3219n[this.f3218m - 1] = r5;
        return r5;
    }

    public final int p(boolean z3) {
        int i3 = this.d;
        int i5 = this.f3210e;
        while (true) {
            if (i3 == i5) {
                this.d = i3;
                if (!g(1)) {
                    if (!z3) {
                        return -1;
                    }
                    throw new EOFException("End of input" + j());
                }
                i3 = this.d;
                i5 = this.f3210e;
            }
            int i6 = i3 + 1;
            char[] cArr = this.c;
            char c = cArr[i3];
            if (c == '\n') {
                this.f3211f++;
                this.f3212g = i6;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.d = i6;
                    if (i6 == i5) {
                        this.d = i3;
                        boolean g5 = g(2);
                        this.d++;
                        if (!g5) {
                            return c;
                        }
                    }
                    c();
                    int i7 = this.d;
                    char c5 = cArr[i7];
                    if (c5 != '*') {
                        if (c5 != '/') {
                            return c;
                        }
                        this.d = i7 + 1;
                        y();
                        i3 = this.d;
                        i5 = this.f3210e;
                    } else {
                        this.d = i7 + 1;
                        while (true) {
                            if (this.d + 2 > this.f3210e && !g(2)) {
                                A("Unterminated comment");
                                throw null;
                            }
                            int i8 = this.d;
                            if (cArr[i8] == '\n') {
                                this.f3211f++;
                                this.f3212g = i8 + 1;
                            } else {
                                for (int i9 = 0; i9 < 2; i9++) {
                                    if (cArr[this.d + i9] != "*/".charAt(i9)) {
                                        break;
                                    }
                                }
                                i3 = this.d + 2;
                                i5 = this.f3210e;
                                break;
                            }
                            this.d++;
                        }
                    }
                } else if (c == '#') {
                    this.d = i6;
                    c();
                    y();
                    i3 = this.d;
                    i5 = this.f3210e;
                } else {
                    this.d = i6;
                    return c;
                }
            }
            i3 = i6;
        }
    }

    public final void q() {
        int i3 = this.f3213h;
        if (i3 == 0) {
            i3 = d();
        }
        if (i3 == 7) {
            this.f3213h = 0;
            int[] iArr = this.f3220o;
            int i5 = this.f3218m - 1;
            iArr[i5] = iArr[i5] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + i.B(u()) + j());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
        r10.d = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
        if (r1 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
        r1.append(r7, r3, r2 - r3);
        r10.d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String r(char r11) {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r10.d
            int r3 = r10.f3210e
        L6:
            r4 = r3
            r3 = r2
        L8:
            r5 = 1
            r6 = 16
            char[] r7 = r10.c
            if (r2 >= r4) goto L5b
            int r8 = r2 + 1
            char r2 = r7[r2]
            if (r2 != r11) goto L29
            r10.d = r8
            int r8 = r8 - r3
            int r8 = r8 - r5
            if (r1 != 0) goto L21
            java.lang.String r11 = new java.lang.String
            r11.<init>(r7, r3, r8)
            return r11
        L21:
            r1.append(r7, r3, r8)
            java.lang.String r11 = r1.toString()
            return r11
        L29:
            r9 = 92
            if (r2 != r9) goto L4e
            r10.d = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L3f
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r6)
            r1.<init>(r4)
        L3f:
            r1.append(r7, r3, r2)
            char r2 = r10.w()
            r1.append(r2)
            int r2 = r10.d
            int r3 = r10.f3210e
            goto L6
        L4e:
            r6 = 10
            if (r2 != r6) goto L59
            int r2 = r10.f3211f
            int r2 = r2 + r5
            r10.f3211f = r2
            r10.f3212g = r8
        L59:
            r2 = r8
            goto L8
        L5b:
            if (r1 != 0) goto L6b
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r6)
            r4.<init>(r1)
            r1 = r4
        L6b:
            int r4 = r2 - r3
            r1.append(r7, r3, r4)
            r10.d = r2
            boolean r2 = r10.g(r5)
            if (r2 == 0) goto L79
            goto L2
        L79:
            java.lang.String r11 = "Unterminated string"
            r10.A(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.a.r(char):java.lang.String");
    }

    public final String s() {
        String str;
        int i3 = this.f3213h;
        if (i3 == 0) {
            i3 = d();
        }
        if (i3 == 10) {
            str = t();
        } else if (i3 == 8) {
            str = r('\'');
        } else if (i3 == 9) {
            str = r('\"');
        } else if (i3 == 11) {
            str = this.f3216k;
            this.f3216k = null;
        } else if (i3 == 15) {
            str = Long.toString(this.f3214i);
        } else if (i3 == 16) {
            str = new String(this.c, this.d, this.f3215j);
            this.d += this.f3215j;
        } else {
            throw new IllegalStateException("Expected a string but was " + i.B(u()) + j());
        }
        this.f3213h = 0;
        int[] iArr = this.f3220o;
        int i5 = this.f3218m - 1;
        iArr[i5] = iArr[i5] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        c();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String t() {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r7.d
            int r4 = r3 + r2
            int r5 = r7.f3210e
            char[] r6 = r7.c
            if (r4 >= r5) goto L4e
            int r3 = r3 + r2
            char r3 = r6[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L4a;
                case 93: goto L5a;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r7.c()
            goto L5a
        L4e:
            int r3 = r6.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r7.g(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r1 = r2
            goto L7a
        L5c:
            if (r0 != 0) goto L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L69:
            int r3 = r7.d
            r0.append(r6, r3, r2)
            int r3 = r7.d
            int r3 = r3 + r2
            r7.d = r3
            r2 = 1
            boolean r2 = r7.g(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L84
            java.lang.String r0 = new java.lang.String
            int r2 = r7.d
            r0.<init>(r6, r2, r1)
            goto L8d
        L84:
            int r2 = r7.d
            r0.append(r6, r2, r1)
            java.lang.String r0 = r0.toString()
        L8d:
            int r2 = r7.d
            int r2 = r2 + r1
            r7.d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.a.t():java.lang.String");
    }

    public final String toString() {
        return a.class.getSimpleName() + j();
    }

    public final int u() {
        int i3 = this.f3213h;
        if (i3 == 0) {
            i3 = d();
        }
        switch (i3) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            case 17:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final void v(int i3) {
        int i5 = this.f3218m;
        int[] iArr = this.f3217l;
        if (i5 == iArr.length) {
            int i6 = i5 * 2;
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            String[] strArr = new String[i6];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            System.arraycopy(this.f3220o, 0, iArr3, 0, this.f3218m);
            System.arraycopy(this.f3219n, 0, strArr, 0, this.f3218m);
            this.f3217l = iArr2;
            this.f3220o = iArr3;
            this.f3219n = strArr;
        }
        int[] iArr4 = this.f3217l;
        int i7 = this.f3218m;
        this.f3218m = i7 + 1;
        iArr4[i7] = i3;
    }

    public final char w() {
        int i3;
        if (this.d == this.f3210e && !g(1)) {
            A("Unterminated escape sequence");
            throw null;
        }
        int i5 = this.d;
        int i6 = i5 + 1;
        this.d = i6;
        char[] cArr = this.c;
        char c = cArr[i5];
        if (c != '\n') {
            if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
                if (c != 'b') {
                    if (c != 'f') {
                        if (c == 'n') {
                            return '\n';
                        }
                        if (c != 'r') {
                            if (c != 't') {
                                if (c == 'u') {
                                    if (i5 + 5 > this.f3210e && !g(4)) {
                                        A("Unterminated escape sequence");
                                        throw null;
                                    }
                                    int i7 = this.d;
                                    int i8 = i7 + 4;
                                    char c5 = 0;
                                    while (i7 < i8) {
                                        char c6 = cArr[i7];
                                        char c7 = (char) (c5 << 4);
                                        if (c6 >= '0' && c6 <= '9') {
                                            i3 = c6 - '0';
                                        } else if (c6 >= 'a' && c6 <= 'f') {
                                            i3 = c6 - 'W';
                                        } else if (c6 >= 'A' && c6 <= 'F') {
                                            i3 = c6 - '7';
                                        } else {
                                            throw new NumberFormatException("\\u".concat(new String(cArr, this.d, 4)));
                                        }
                                        c5 = (char) (i3 + c7);
                                        i7++;
                                    }
                                    this.d += 4;
                                    return c5;
                                }
                                A("Invalid escape sequence");
                                throw null;
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\f';
                }
                return '\b';
            }
        } else {
            this.f3211f++;
            this.f3212g = i6;
        }
        return c;
    }

    public final void x(char c) {
        do {
            int i3 = this.d;
            int i5 = this.f3210e;
            while (i3 < i5) {
                int i6 = i3 + 1;
                char c5 = this.c[i3];
                if (c5 == c) {
                    this.d = i6;
                    return;
                } else if (c5 == '\\') {
                    this.d = i6;
                    w();
                    i3 = this.d;
                    i5 = this.f3210e;
                } else {
                    if (c5 == '\n') {
                        this.f3211f++;
                        this.f3212g = i6;
                    }
                    i3 = i6;
                }
            }
            this.d = i3;
        } while (g(1));
        A("Unterminated string");
        throw null;
    }

    public final void y() {
        char c;
        do {
            if (this.d < this.f3210e || g(1)) {
                int i3 = this.d;
                int i5 = i3 + 1;
                this.d = i5;
                c = this.c[i3];
                if (c == '\n') {
                    this.f3211f++;
                    this.f3212g = i5;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    public final void z() {
        int i3 = 0;
        do {
            int i5 = this.f3213h;
            if (i5 == 0) {
                i5 = d();
            }
            if (i5 == 3) {
                v(1);
            } else if (i5 == 1) {
                v(3);
            } else {
                if (i5 == 4) {
                    this.f3218m--;
                } else if (i5 == 2) {
                    this.f3218m--;
                } else {
                    if (i5 != 14 && i5 != 10) {
                        if (i5 != 8 && i5 != 12) {
                            if (i5 != 9 && i5 != 13) {
                                if (i5 == 16) {
                                    this.d += this.f3215j;
                                }
                            } else {
                                x('\"');
                            }
                        } else {
                            x('\'');
                        }
                    } else {
                        do {
                            int i6 = 0;
                            while (true) {
                                int i7 = this.d + i6;
                                if (i7 < this.f3210e) {
                                    char c = this.c[i7];
                                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                                        if (c != '#') {
                                            if (c != ',') {
                                                if (c != '/' && c != '=') {
                                                    if (c != '{' && c != '}' && c != ':') {
                                                        if (c != ';') {
                                                            switch (c) {
                                                                case '[':
                                                                case ']':
                                                                    break;
                                                                case '\\':
                                                                    break;
                                                                default:
                                                                    i6++;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    this.d = i7;
                                }
                            }
                            c();
                            this.d += i6;
                        } while (g(1));
                    }
                    this.f3213h = 0;
                }
                i3--;
                this.f3213h = 0;
            }
            i3++;
            this.f3213h = 0;
        } while (i3 != 0);
        int[] iArr = this.f3220o;
        int i8 = this.f3218m;
        int i9 = i8 - 1;
        iArr[i9] = iArr[i9] + 1;
        this.f3219n[i8 - 1] = "null";
    }
}
