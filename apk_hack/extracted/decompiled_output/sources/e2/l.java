package e2;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f1694a;
    public final int b;
    public final byte[] c;
    public final Map d;

    /* renamed from: e  reason: collision with root package name */
    public final long f1695e;

    /* renamed from: f  reason: collision with root package name */
    public final long f1696f;

    /* renamed from: g  reason: collision with root package name */
    public final long f1697g;

    /* renamed from: h  reason: collision with root package name */
    public final String f1698h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1699i;

    public l(Uri uri, int i3) {
        this(uri, 0L, 0L, -1L, null, i3);
    }

    public static String a(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return "HEAD";
                }
                throw new AssertionError(i3);
            }
            return "POST";
        }
        return "GET";
    }

    public final l b(long j2) {
        long j5 = this.f1697g;
        long j6 = -1;
        if (j5 != -1) {
            j6 = j5 - j2;
        }
        return c(j2, j6);
    }

    public final l c(long j2, long j5) {
        if (j2 == 0 && this.f1697g == j5) {
            return this;
        }
        int i3 = this.f1699i;
        Map map = this.d;
        return new l(this.f1694a, this.b, this.c, this.f1695e + j2, this.f1696f + j2, j5, this.f1698h, i3, map);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DataSpec[");
        sb.append(a(this.b));
        sb.append(" ");
        sb.append(this.f1694a);
        sb.append(", ");
        sb.append(Arrays.toString(this.c));
        sb.append(", ");
        sb.append(this.f1695e);
        sb.append(", ");
        sb.append(this.f1696f);
        sb.append(", ");
        sb.append(this.f1697g);
        sb.append(", ");
        sb.append(this.f1698h);
        sb.append(", ");
        return a1.i.j(sb, this.f1699i, "]");
    }

    public l(Uri uri, long j2, long j5, long j6, String str, int i3) {
        this(uri, 1, null, j2, j5, j6, str, i3, Collections.emptyMap());
    }

    public l(Uri uri, int i3, byte[] bArr, long j2, long j5, long j6, String str, int i5, Map map) {
        byte[] bArr2 = bArr;
        boolean z3 = false;
        g2.b.e(j2 >= 0);
        g2.b.e(j5 >= 0);
        g2.b.e((j6 > 0 || j6 == -1) ? true : true);
        this.f1694a = uri;
        this.b = i3;
        this.c = (bArr2 == null || bArr2.length == 0) ? null : null;
        this.f1695e = j2;
        this.f1696f = j5;
        this.f1697g = j6;
        this.f1698h = str;
        this.f1699i = i5;
        this.d = Collections.unmodifiableMap(new HashMap(map));
    }
}
