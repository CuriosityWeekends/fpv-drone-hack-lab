package n1;

import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j extends l implements m1.i {

    /* renamed from: f  reason: collision with root package name */
    public final m f2933f;

    public j(Format format, String str, m mVar, ArrayList arrayList) {
        super(format, str, mVar, arrayList);
        this.f2933f = mVar;
    }

    @Override // m1.i
    public final long a(long j2) {
        return this.f2933f.c(j2);
    }

    @Override // n1.l
    public final String b() {
        return null;
    }

    @Override // m1.i
    public final long c(long j2, long j5) {
        long j6;
        m mVar = this.f2933f;
        long b = mVar.b(j5);
        long j7 = mVar.d;
        if (b != 0) {
            if (mVar.f2940f == null) {
                j6 = (j2 / ((mVar.f2939e * 1000000) / mVar.b)) + j7;
                if (j6 >= j7) {
                    if (b != -1) {
                        return Math.min(j6, (j7 + b) - 1);
                    }
                } else {
                    return j7;
                }
            } else {
                long j8 = (b + j7) - 1;
                j6 = j7;
                while (j6 <= j8) {
                    long j9 = ((j8 - j6) / 2) + j6;
                    int i3 = (mVar.c(j9) > j2 ? 1 : (mVar.c(j9) == j2 ? 0 : -1));
                    if (i3 < 0) {
                        j6 = j9 + 1;
                    } else if (i3 > 0) {
                        j8 = j9 - 1;
                    } else {
                        return j9;
                    }
                }
                if (j6 != j7) {
                    return j8;
                }
            }
            return j6;
        }
        return j7;
    }

    @Override // m1.i
    public final long e(long j2, long j5) {
        m mVar = this.f2933f;
        long j6 = mVar.b;
        long j7 = mVar.d;
        List list = mVar.f2940f;
        if (list != null) {
            return (((p) list.get((int) (j2 - j7))).b * 1000000) / j6;
        }
        int b = mVar.b(j5);
        if (b != -1 && j2 == (j7 + b) - 1) {
            return j5 - mVar.c(j2);
        }
        return (mVar.f2939e * 1000000) / j6;
    }

    @Override // n1.l
    public final i f() {
        return null;
    }

    @Override // m1.i
    public final i l(long j2) {
        return this.f2933f.d(j2, this);
    }

    @Override // m1.i
    public final boolean p() {
        return this.f2933f.e();
    }

    @Override // m1.i
    public final long r() {
        return this.f2933f.d;
    }

    @Override // m1.i
    public final int v(long j2) {
        return this.f2933f.b(j2);
    }

    @Override // n1.l
    public final m1.i d() {
        return this;
    }
}
