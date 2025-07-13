package n1;

import g2.w;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class m extends r {
    public final long d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2939e;

    /* renamed from: f  reason: collision with root package name */
    public final List f2940f;

    public m(i iVar, long j2, long j5, long j6, long j7, List list) {
        super(iVar, j2, j5);
        this.d = j6;
        this.f2939e = j7;
        this.f2940f = list;
    }

    public abstract int b(long j2);

    public final long c(long j2) {
        long j5;
        long j6 = this.d;
        List list = this.f2940f;
        if (list != null) {
            j5 = ((p) list.get((int) (j2 - j6))).f2945a - this.c;
        } else {
            j5 = (j2 - j6) * this.f2939e;
        }
        return w.B(j5, 1000000L, this.b);
    }

    public abstract i d(long j2, l lVar);

    public boolean e() {
        if (this.f2940f != null) {
            return true;
        }
        return false;
    }
}
