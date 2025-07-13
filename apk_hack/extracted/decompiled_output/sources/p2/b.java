package p2;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class b implements Closeable, Flushable {

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f3221h = new String[128];

    /* renamed from: a  reason: collision with root package name */
    public final Writer f3222a;
    public int[] b = new int[32];
    public int c = 0;
    public final String d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3223e;

    /* renamed from: f  reason: collision with root package name */
    public String f3224f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3225g;

    static {
        for (int i3 = 0; i3 <= 31; i3++) {
            f3221h[i3] = String.format("\\u%04x", Integer.valueOf(i3));
        }
        String[] strArr = f3221h;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        j(6);
        this.d = ":";
        this.f3225g = true;
        if (writer != null) {
            this.f3222a = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    public final void a() {
        int i3 = i();
        if (i3 != 1) {
            Writer writer = this.f3222a;
            if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 != 6) {
                        if (i3 == 7) {
                            if (!this.f3223e) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                    this.b[this.c - 1] = 7;
                    return;
                }
                writer.append((CharSequence) this.d);
                this.b[this.c - 1] = 5;
                return;
            }
            writer.append(',');
            return;
        }
        this.b[this.c - 1] = 2;
    }

    public void b() {
        o();
        a();
        j(1);
        this.f3222a.write("[");
    }

    public void c() {
        o();
        a();
        j(3);
        this.f3222a.write("{");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3222a.close();
        int i3 = this.c;
        if (i3 <= 1 && (i3 != 1 || this.b[i3 - 1] == 7)) {
            this.c = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public final void d(int i3, int i5, String str) {
        int i6 = i();
        if (i6 != i5 && i6 != i3) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f3224f == null) {
            this.c--;
            this.f3222a.write(str);
            return;
        }
        throw new IllegalStateException("Dangling name: " + this.f3224f);
    }

    public void e() {
        d(1, 2, "]");
    }

    public void f() {
        d(3, 5, "}");
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.c != 0) {
            this.f3222a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public void g(String str) {
        if (str != null) {
            if (this.f3224f == null) {
                if (this.c != 0) {
                    this.f3224f = str;
                    return;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public b h() {
        if (this.f3224f != null) {
            if (this.f3225g) {
                o();
            } else {
                this.f3224f = null;
                return this;
            }
        }
        a();
        this.f3222a.write("null");
        return this;
    }

    public final int i() {
        int i3 = this.c;
        if (i3 != 0) {
            return this.b[i3 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void j(int i3) {
        int i5 = this.c;
        int[] iArr = this.b;
        if (i5 == iArr.length) {
            int[] iArr2 = new int[i5 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            this.b = iArr2;
        }
        int[] iArr3 = this.b;
        int i6 = this.c;
        this.c = i6 + 1;
        iArr3[i6] = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String[] r0 = p2.b.f3221h
            java.io.Writer r1 = r8.f3222a
            java.lang.String r2 = "\""
            r1.write(r2)
            int r3 = r9.length()
            r4 = 0
            r5 = 0
        Lf:
            if (r4 >= r3) goto L3a
            char r6 = r9.charAt(r4)
            r7 = 128(0x80, float:1.8E-43)
            if (r6 >= r7) goto L1e
            r6 = r0[r6]
            if (r6 != 0) goto L2b
            goto L37
        L1e:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L25
            java.lang.String r6 = "\\u2028"
            goto L2b
        L25:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L37
            java.lang.String r6 = "\\u2029"
        L2b:
            if (r5 >= r4) goto L32
            int r7 = r4 - r5
            r1.write(r9, r5, r7)
        L32:
            r1.write(r6)
            int r5 = r4 + 1
        L37:
            int r4 = r4 + 1
            goto Lf
        L3a:
            if (r5 >= r3) goto L40
            int r3 = r3 - r5
            r1.write(r9, r5, r3)
        L40:
            r1.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.b.k(java.lang.String):void");
    }

    public void l(Number number) {
        if (number == null) {
            h();
            return;
        }
        o();
        String obj = number.toString();
        if (!this.f3223e && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        a();
        this.f3222a.append((CharSequence) obj);
    }

    public void m(String str) {
        if (str == null) {
            h();
            return;
        }
        o();
        a();
        k(str);
    }

    public void n(boolean z3) {
        String str;
        o();
        a();
        if (z3) {
            str = "true";
        } else {
            str = "false";
        }
        this.f3222a.write(str);
    }

    public final void o() {
        if (this.f3224f != null) {
            int i3 = i();
            if (i3 == 5) {
                this.f3222a.write(44);
            } else if (i3 != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            this.b[this.c - 1] = 4;
            k(this.f3224f);
            this.f3224f = null;
        }
    }
}
