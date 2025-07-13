package k1;

import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final b f2501e = new b(new long[0]);

    /* renamed from: a  reason: collision with root package name */
    public final int f2502a;
    public final long[] b;
    public final a[] c;
    public final long d;

    public b(long... jArr) {
        int length = jArr.length;
        this.f2502a = length;
        this.b = Arrays.copyOf(jArr, length);
        this.c = new a[length];
        for (int i3 = 0; i3 < length; i3++) {
            this.c[i3] = new a();
        }
        this.d = -9223372036854775807L;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f2502a == bVar.f2502a && this.d == bVar.d && Arrays.equals(this.b, bVar.b) && Arrays.equals(this.c, bVar.c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.b);
        return Arrays.hashCode(this.c) + ((hashCode + (((((this.f2502a * 31) + ((int) 0)) * 31) + ((int) this.d)) * 31)) * 31);
    }
}
