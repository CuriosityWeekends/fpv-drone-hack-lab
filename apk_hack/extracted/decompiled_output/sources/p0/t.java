package p0;

import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final int f3130a;
    public final byte[] b;
    public final int c;
    public final int d;

    public t(int i3, int i5, byte[] bArr, int i6) {
        this.f3130a = i3;
        this.b = bArr;
        this.c = i5;
        this.d = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        if (this.f3130a == tVar.f3130a && this.c == tVar.c && this.d == tVar.d && Arrays.equals(this.b, tVar.b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.b) + (this.f3130a * 31)) * 31) + this.c) * 31) + this.d;
    }
}
