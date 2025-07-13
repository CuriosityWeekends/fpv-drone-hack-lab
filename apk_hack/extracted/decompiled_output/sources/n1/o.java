package n1;

import com.google.android.exoplayer2.Format;
import g2.w;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o extends m {

    /* renamed from: g  reason: collision with root package name */
    public final a2.l f2942g;

    /* renamed from: h  reason: collision with root package name */
    public final a2.l f2943h;

    /* renamed from: i  reason: collision with root package name */
    public final long f2944i;

    public o(i iVar, long j2, long j5, long j6, long j7, long j8, List list, a2.l lVar, a2.l lVar2) {
        super(iVar, j2, j5, j6, j8, list);
        this.f2942g = lVar;
        this.f2943h = lVar2;
        this.f2944i = j7;
    }

    @Override // n1.r
    public final i a(l lVar) {
        a2.l lVar2 = this.f2942g;
        if (lVar2 != null) {
            Format format = lVar.f2937a;
            return new i(0L, -1L, lVar2.a(format.f306a, 0L, format.f307e, 0L));
        }
        return this.f2947a;
    }

    @Override // n1.m
    public final int b(long j2) {
        List list = this.f2940f;
        if (list != null) {
            return list.size();
        }
        long j5 = this.f2944i;
        if (j5 != -1) {
            return (int) ((j5 - this.d) + 1);
        }
        if (j2 != -9223372036854775807L) {
            long j6 = (this.f2939e * 1000000) / this.b;
            int i3 = w.f1960a;
            return (int) (((j2 + j6) - 1) / j6);
        }
        return -1;
    }

    @Override // n1.m
    public final i d(long j2, l lVar) {
        long j5;
        long j6 = this.d;
        List list = this.f2940f;
        if (list != null) {
            j5 = ((p) list.get((int) (j2 - j6))).f2945a;
        } else {
            j5 = (j2 - j6) * this.f2939e;
        }
        long j7 = j5;
        Format format = lVar.f2937a;
        return new i(0L, -1L, this.f2943h.a(format.f306a, j2, format.f307e, j7));
    }
}
