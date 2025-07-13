package k1;

import android.net.Uri;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a {
    public final int[] b = new int[0];

    /* renamed from: a  reason: collision with root package name */
    public final Uri[] f2500a = new Uri[0];
    public final long[] c = new long[0];

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (Arrays.equals(this.f2500a, aVar.f2500a) && Arrays.equals(this.b, aVar.b) && Arrays.equals(this.c, aVar.c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.b);
        return Arrays.hashCode(this.c) + ((hashCode + (((-31) + Arrays.hashCode(this.f2500a)) * 31)) * 31);
    }
}
