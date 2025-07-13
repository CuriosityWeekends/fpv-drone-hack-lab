package n1;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final long f2932a;
    public final long b;
    public final String c;
    public int d;

    public i(long j2, long j5, String str) {
        this.c = str == null ? "" : str;
        this.f2932a = j2;
        this.b = j5;
    }

    public final i a(i iVar, String str) {
        long j2;
        long j5;
        long j6;
        String x3 = g2.b.x(str, this.c);
        if (iVar == null || !x3.equals(g2.b.x(str, iVar.c))) {
            return null;
        }
        long j7 = iVar.b;
        long j8 = this.b;
        if (j8 != -1) {
            long j9 = this.f2932a;
            if (j9 + j8 == iVar.f2932a) {
                if (j7 == -1) {
                    j6 = -1;
                } else {
                    j6 = j8 + j7;
                }
                return new i(j9, j6, x3);
            }
            j2 = -1;
        } else {
            j2 = -1;
        }
        if (j7 != j2) {
            long j10 = iVar.f2932a;
            if (j10 + j7 == this.f2932a) {
                if (j8 == -1) {
                    j5 = -1;
                } else {
                    j5 = j7 + j8;
                }
                return new i(j10, j5, x3);
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f2932a == iVar.f2932a && this.b == iVar.b && this.c.equals(iVar.c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.d == 0) {
            this.d = this.c.hashCode() + ((((527 + ((int) this.f2932a)) * 31) + ((int) this.b)) * 31);
        }
        return this.d;
    }

    public final String toString() {
        return "RangedUri(referenceUri=" + this.c + ", start=" + this.f2932a + ", length=" + this.b + ")";
    }
}
