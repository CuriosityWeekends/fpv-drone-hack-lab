package t1;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e {
    public static final int[] A;
    public static final boolean[] B;
    public static final int[] C;
    public static final int[] D;
    public static final int[] E;
    public static final int[] F;
    public static final int w = c(2, 2, 2, 0);

    /* renamed from: x  reason: collision with root package name */
    public static final int f3651x;

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f3652y;

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f3653z;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f3654a = new ArrayList();
    public final SpannableStringBuilder b = new SpannableStringBuilder();
    public boolean c;
    public boolean d;

    /* renamed from: e  reason: collision with root package name */
    public int f3655e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3656f;

    /* renamed from: g  reason: collision with root package name */
    public int f3657g;

    /* renamed from: h  reason: collision with root package name */
    public int f3658h;

    /* renamed from: i  reason: collision with root package name */
    public int f3659i;

    /* renamed from: j  reason: collision with root package name */
    public int f3660j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3661k;

    /* renamed from: l  reason: collision with root package name */
    public int f3662l;

    /* renamed from: m  reason: collision with root package name */
    public int f3663m;

    /* renamed from: n  reason: collision with root package name */
    public int f3664n;

    /* renamed from: o  reason: collision with root package name */
    public int f3665o;

    /* renamed from: p  reason: collision with root package name */
    public int f3666p;
    public int q;

    /* renamed from: r  reason: collision with root package name */
    public int f3667r;
    public int s;

    /* renamed from: t  reason: collision with root package name */
    public int f3668t;

    /* renamed from: u  reason: collision with root package name */
    public int f3669u;

    /* renamed from: v  reason: collision with root package name */
    public int f3670v;

    static {
        int c = c(0, 0, 0, 0);
        f3651x = c;
        int c5 = c(0, 0, 0, 3);
        f3652y = new int[]{0, 0, 0, 0, 0, 2, 0};
        f3653z = new int[]{0, 0, 0, 0, 0, 0, 2};
        A = new int[]{3, 3, 3, 3, 3, 3, 1};
        B = new boolean[]{false, false, false, true, true, true, false};
        C = new int[]{c, c5, c, c, c5, c, c};
        D = new int[]{0, 1, 2, 3, 4, 3, 4};
        E = new int[]{0, 0, 0, 0, 0, 3, 3};
        F = new int[]{c, c, c, c, c, c5, c5};
    }

    public e() {
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(int r4, int r5, int r6, int r7) {
        /*
            r0 = 4
            g2.b.g(r4, r0)
            g2.b.g(r5, r0)
            g2.b.g(r6, r0)
            g2.b.g(r7, r0)
            r0 = 0
            r1 = 1
            r2 = 255(0xff, float:3.57E-43)
            if (r7 == 0) goto L1b
            if (r7 == r1) goto L1b
            r3 = 2
            if (r7 == r3) goto L20
            r3 = 3
            if (r7 == r3) goto L1e
        L1b:
            r7 = 255(0xff, float:3.57E-43)
            goto L22
        L1e:
            r7 = 0
            goto L22
        L20:
            r7 = 127(0x7f, float:1.78E-43)
        L22:
            if (r4 <= r1) goto L27
            r4 = 255(0xff, float:3.57E-43)
            goto L28
        L27:
            r4 = 0
        L28:
            if (r5 <= r1) goto L2d
            r5 = 255(0xff, float:3.57E-43)
            goto L2e
        L2d:
            r5 = 0
        L2e:
            if (r6 <= r1) goto L32
            r0 = 255(0xff, float:3.57E-43)
        L32:
            int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.e.c(int, int, int, int):int");
    }

    public final void a(char c) {
        SpannableStringBuilder spannableStringBuilder = this.b;
        if (c == '\n') {
            ArrayList arrayList = this.f3654a;
            arrayList.add(b());
            spannableStringBuilder.clear();
            if (this.f3666p != -1) {
                this.f3666p = 0;
            }
            if (this.q != -1) {
                this.q = 0;
            }
            if (this.f3667r != -1) {
                this.f3667r = 0;
            }
            if (this.f3668t != -1) {
                this.f3668t = 0;
            }
            while (true) {
                if ((this.f3661k && arrayList.size() >= this.f3660j) || arrayList.size() >= 15) {
                    arrayList.remove(0);
                } else {
                    return;
                }
            }
        } else {
            spannableStringBuilder.append(c);
        }
    }

    public final SpannableString b() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.b);
        int length = spannableStringBuilder.length();
        if (length > 0) {
            if (this.f3666p != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f3666p, length, 33);
            }
            if (this.q != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.q, length, 33);
            }
            if (this.f3667r != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.s), this.f3667r, length, 33);
            }
            if (this.f3668t != -1) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f3669u), this.f3668t, length, 33);
            }
        }
        return new SpannableString(spannableStringBuilder);
    }

    public final void d() {
        this.f3654a.clear();
        this.b.clear();
        this.f3666p = -1;
        this.q = -1;
        this.f3667r = -1;
        this.f3668t = -1;
        this.f3670v = 0;
        this.c = false;
        this.d = false;
        this.f3655e = 4;
        this.f3656f = false;
        this.f3657g = 0;
        this.f3658h = 0;
        this.f3659i = 0;
        this.f3660j = 15;
        this.f3661k = true;
        this.f3662l = 0;
        this.f3663m = 0;
        this.f3664n = 0;
        int i3 = f3651x;
        this.f3665o = i3;
        this.s = w;
        this.f3669u = i3;
    }

    public final void e(boolean z3, boolean z5) {
        int i3 = this.f3666p;
        SpannableStringBuilder spannableStringBuilder = this.b;
        if (i3 != -1) {
            if (!z3) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f3666p, spannableStringBuilder.length(), 33);
                this.f3666p = -1;
            }
        } else if (z3) {
            this.f3666p = spannableStringBuilder.length();
        }
        if (this.q != -1) {
            if (!z5) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.q, spannableStringBuilder.length(), 33);
                this.q = -1;
            }
        } else if (z5) {
            this.q = spannableStringBuilder.length();
        }
    }

    public final void f(int i3, int i5) {
        int i6 = this.f3667r;
        SpannableStringBuilder spannableStringBuilder = this.b;
        if (i6 != -1 && this.s != i3) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.s), this.f3667r, spannableStringBuilder.length(), 33);
        }
        if (i3 != w) {
            this.f3667r = spannableStringBuilder.length();
            this.s = i3;
        }
        if (this.f3668t != -1 && this.f3669u != i5) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f3669u), this.f3668t, spannableStringBuilder.length(), 33);
        }
        if (i5 != f3651x) {
            this.f3668t = spannableStringBuilder.length();
            this.f3669u = i5;
        }
    }
}
