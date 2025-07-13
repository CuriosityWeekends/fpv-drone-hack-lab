package j0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h0 {

    /* renamed from: e  reason: collision with root package name */
    public static final h0 f2254e = new h0(1.0f, 1.0f, false);

    /* renamed from: a  reason: collision with root package name */
    public final float f2255a;
    public final float b;
    public final boolean c;
    public final int d;

    public h0(float f4, float f5, boolean z3) {
        boolean z5;
        if (f4 > 0.0f) {
            z5 = true;
        } else {
            z5 = false;
        }
        g2.b.e(z5);
        g2.b.e(f5 > 0.0f);
        this.f2255a = f4;
        this.b = f5;
        this.c = z3;
        this.d = Math.round(f4 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h0.class != obj.getClass()) {
            return false;
        }
        h0 h0Var = (h0) obj;
        if (this.f2255a == h0Var.f2255a && this.b == h0Var.b && this.c == h0Var.c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.b) + ((Float.floatToRawIntBits(this.f2255a) + 527) * 31)) * 31) + (this.c ? 1 : 0);
    }
}
