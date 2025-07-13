package b2;

import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final int f166a;
    public final n[] b;
    public int c;

    public o(n... nVarArr) {
        this.b = nVarArr;
        this.f166a = nVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            return Arrays.equals(this.b, ((o) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        if (this.c == 0) {
            this.c = 527 + Arrays.hashCode(this.b);
        }
        return this.c;
    }
}
