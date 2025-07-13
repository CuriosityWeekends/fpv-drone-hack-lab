package b2;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import g2.w;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i extends l {

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f157e = new int[0];
    public final j3.a c;
    public final AtomicReference d;

    public i() {
        j3.a aVar = new j3.a(1);
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = DefaultTrackSelector$Parameters.B;
        this.c = aVar;
        this.d = new AtomicReference(defaultTrackSelector$Parameters);
    }

    public static int a(int i3, int i5) {
        if (i3 > i5) {
            return 1;
        }
        if (i5 > i3) {
            return -1;
        }
        return 0;
    }

    public static int b(int i3, int i5) {
        if (i3 == -1) {
            if (i5 != -1) {
                return -1;
            }
            return 0;
        } else if (i5 == -1) {
            return 1;
        } else {
            return i3 - i5;
        }
    }

    public static int c(Format format, String str, boolean z3) {
        if (!TextUtils.isEmpty(str) && str.equals(format.A)) {
            return 4;
        }
        String h5 = h(str);
        String h6 = h(format.A);
        if (h6 != null && h5 != null) {
            if (!h6.startsWith(h5) && !h5.startsWith(h6)) {
                int i3 = w.f1960a;
                if (!h6.split("-", 2)[0].equals(h5.split("-", 2)[0])) {
                    return 0;
                }
                return 2;
            }
            return 3;
        } else if (!z3 || h6 != null) {
            return 0;
        } else {
            return 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList d(com.google.android.exoplayer2.source.TrackGroup r16, int r17, int r18, boolean r19) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r0.f384a
            r3.<init>(r4)
            r4 = 0
            r5 = 0
        Lf:
            int r6 = r0.f384a
            if (r5 >= r6) goto L1d
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r3.add(r6)
            int r5 = r5 + 1
            goto Lf
        L1d:
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == r5) goto Laf
            if (r2 != r5) goto L26
            goto Laf
        L26:
            r7 = 0
            r8 = 2147483647(0x7fffffff, float:NaN)
        L2a:
            r9 = 1
            com.google.android.exoplayer2.Format[] r10 = r0.b
            if (r7 >= r6) goto L82
            r10 = r10[r7]
            int r11 = r10.f316n
            if (r11 <= 0) goto L7f
            int r12 = r10.f317o
            if (r12 <= 0) goto L7f
            if (r19 == 0) goto L49
            if (r11 <= r12) goto L3f
            r13 = 1
            goto L40
        L3f:
            r13 = 0
        L40:
            if (r1 <= r2) goto L43
            goto L44
        L43:
            r9 = 0
        L44:
            if (r13 == r9) goto L49
            r9 = r1
            r13 = r2
            goto L4b
        L49:
            r13 = r1
            r9 = r2
        L4b:
            int r14 = r11 * r9
            int r15 = r12 * r13
            if (r14 < r15) goto L5b
            android.graphics.Point r9 = new android.graphics.Point
            int r11 = g2.w.e(r15, r11)
            r9.<init>(r13, r11)
            goto L65
        L5b:
            android.graphics.Point r11 = new android.graphics.Point
            int r13 = g2.w.e(r14, r12)
            r11.<init>(r13, r9)
            r9 = r11
        L65:
            int r10 = r10.f316n
            int r11 = r10 * r12
            int r13 = r9.x
            float r13 = (float) r13
            r14 = 1065017672(0x3f7ae148, float:0.98)
            float r13 = r13 * r14
            int r13 = (int) r13
            if (r10 < r13) goto L7f
            int r9 = r9.y
            float r9 = (float) r9
            float r9 = r9 * r14
            int r9 = (int) r9
            if (r12 < r9) goto L7f
            if (r11 >= r8) goto L7f
            r8 = r11
        L7f:
            int r7 = r7 + 1
            goto L2a
        L82:
            if (r8 == r5) goto Laf
            int r0 = r3.size()
            int r0 = r0 - r9
        L89:
            if (r0 < 0) goto Laf
            java.lang.Object r1 = r3.get(r0)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r1 = r10[r1]
            int r2 = r1.f316n
            r4 = -1
            if (r2 == r4) goto La4
            int r1 = r1.f317o
            if (r1 != r4) goto La1
            goto La4
        La1:
            int r2 = r2 * r1
            goto La5
        La4:
            r2 = -1
        La5:
            if (r2 == r4) goto La9
            if (r2 <= r8) goto Lac
        La9:
            r3.remove(r0)
        Lac:
            int r0 = r0 + (-1)
            goto L89
        Laf:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.i.d(com.google.android.exoplayer2.source.TrackGroup, int, int, boolean):java.util.ArrayList");
    }

    public static boolean e(int i3, boolean z3) {
        int i5 = i3 & 7;
        if (i5 != 4 && (!z3 || i5 != 3)) {
            return false;
        }
        return true;
    }

    public static boolean f(Format format, int i3, e eVar, int i5, boolean z3, boolean z5, boolean z6) {
        int i6;
        String str;
        int i7;
        if (!e(i3, false)) {
            return false;
        }
        int i8 = format.f307e;
        if (i8 != -1 && i8 > i5) {
            return false;
        }
        if (!z6 && ((i7 = format.f322v) == -1 || i7 != eVar.f142a)) {
            return false;
        }
        if (!z3 && ((str = format.f311i) == null || !TextUtils.equals(str, eVar.c))) {
            return false;
        }
        if (!z5 && ((i6 = format.w) == -1 || i6 != eVar.b)) {
            return false;
        }
        return true;
    }

    public static boolean g(Format format, String str, int i3, int i5, int i6, int i7, int i8, int i9) {
        if (!e(i3, false) || (i3 & i5) == 0) {
            return false;
        }
        if (str != null && !w.a(format.f311i, str)) {
            return false;
        }
        int i10 = format.f316n;
        if (i10 != -1 && i10 > i6) {
            return false;
        }
        int i11 = format.f317o;
        if (i11 != -1 && i11 > i7) {
            return false;
        }
        float f4 = format.f318p;
        if (f4 != -1.0f && f4 > i8) {
            return false;
        }
        int i12 = format.f307e;
        if (i12 != -1 && i12 > i9) {
            return false;
        }
        return true;
    }

    public static String h(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }
}
