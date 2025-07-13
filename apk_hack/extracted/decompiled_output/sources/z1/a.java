package z1;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import g2.w;
import java.nio.charset.Charset;
import java.util.List;
import s1.c;
import s1.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends c {

    /* renamed from: n  reason: collision with root package name */
    public final c0.b f4289n = new c0.b();

    /* renamed from: o  reason: collision with root package name */
    public final boolean f4290o;

    /* renamed from: p  reason: collision with root package name */
    public final int f4291p;
    public final int q;

    /* renamed from: r  reason: collision with root package name */
    public final String f4292r;
    public final float s;

    /* renamed from: t  reason: collision with root package name */
    public final int f4293t;

    public a(List list) {
        if (list != null && list.size() == 1 && (((byte[]) list.get(0)).length == 48 || ((byte[]) list.get(0)).length == 53)) {
            byte[] bArr = (byte[]) list.get(0);
            this.f4291p = bArr[24];
            this.q = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.f4292r = "Serif".equals(w.k(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
            int i3 = bArr[25] * 20;
            this.f4293t = i3;
            boolean z3 = (bArr[0] & 32) != 0;
            this.f4290o = z3;
            if (z3) {
                float f4 = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i3;
                this.s = f4;
                this.s = Math.max(0.0f, Math.min(f4, 0.95f));
                return;
            }
            this.s = 0.85f;
            return;
        }
        this.f4291p = 0;
        this.q = -1;
        this.f4292r = "sans-serif";
        this.f4290o = false;
        this.s = 0.85f;
    }

    public static void i(SpannableStringBuilder spannableStringBuilder, int i3, int i5, int i6, int i7, int i8) {
        if (i3 != i5) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i3 >>> 8) | ((i3 & 255) << 24)), i6, i7, i8 | 33);
        }
    }

    public static void j(SpannableStringBuilder spannableStringBuilder, int i3, int i5, int i6, int i7, int i8) {
        boolean z3;
        boolean z5;
        if (i3 != i5) {
            int i9 = i8 | 33;
            boolean z6 = true;
            if ((i3 & 1) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((i3 & 2) != 0) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z3) {
                if (z5) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i6, i7, i9);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i6, i7, i9);
                }
            } else if (z5) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i6, i7, i9);
            }
            if ((i3 & 4) == 0) {
                z6 = false;
            }
            if (z6) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i6, i7, i9);
            }
            if (!z6 && !z3 && !z5) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i6, i7, i9);
            }
        }
    }

    @Override // s1.c
    public final e e(byte[] bArr, int i3, boolean z3) {
        String l5;
        c0.b bVar = this.f4289n;
        bVar.w(bArr, i3);
        if (bVar.a() >= 2) {
            int s = bVar.s();
            if (s == 0) {
                l5 = "";
            } else {
                if (bVar.a() >= 2) {
                    byte[] bArr2 = bVar.f187a;
                    int i5 = bVar.b;
                    char c = (char) ((bArr2[i5 + 1] & 255) | ((bArr2[i5] & 255) << 8));
                    if (c == 65279 || c == 65534) {
                        l5 = bVar.l(s, Charset.forName("UTF-16"));
                    }
                }
                l5 = bVar.l(s, Charset.forName("UTF-8"));
            }
            if (l5.isEmpty()) {
                return b.b;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(l5);
            j(spannableStringBuilder, this.f4291p, 0, 0, spannableStringBuilder.length(), 16711680);
            i(spannableStringBuilder, this.q, -1, 0, spannableStringBuilder.length(), 16711680);
            int length = spannableStringBuilder.length();
            String str = this.f4292r;
            if (str != "sans-serif") {
                spannableStringBuilder.setSpan(new TypefaceSpan(str), 0, length, 16711713);
            }
            float f4 = this.s;
            while (bVar.a() >= 8) {
                int i6 = bVar.b;
                int c5 = bVar.c();
                int c6 = bVar.c();
                if (c6 == 1937013100) {
                    if (bVar.a() >= 2) {
                        int i7 = 0;
                        for (int s5 = bVar.s(); i7 < s5; s5 = s5) {
                            if (bVar.a() >= 12) {
                                int s6 = bVar.s();
                                int s7 = bVar.s();
                                bVar.z(2);
                                int n5 = bVar.n();
                                bVar.z(1);
                                int c7 = bVar.c();
                                j(spannableStringBuilder, n5, this.f4291p, s6, s7, 0);
                                i(spannableStringBuilder, c7, this.q, s6, s7, 0);
                                i7++;
                            } else {
                                throw new Exception("Unexpected subtitle format.");
                            }
                        }
                        continue;
                    } else {
                        throw new Exception("Unexpected subtitle format.");
                    }
                } else if (c6 == 1952608120 && this.f4290o) {
                    if (bVar.a() >= 2) {
                        float s8 = bVar.s() / this.f4293t;
                        int i8 = w.f1960a;
                        f4 = Math.max(0.0f, Math.min(s8, 0.95f));
                    } else {
                        throw new Exception("Unexpected subtitle format.");
                    }
                }
                bVar.y(i6 + c5);
            }
            return new b(new s1.b(spannableStringBuilder, null, f4, 0, 0, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f));
        }
        throw new Exception("Unexpected subtitle format.");
    }
}
