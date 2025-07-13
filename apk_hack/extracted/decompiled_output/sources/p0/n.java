package p0;

import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class n implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3115a = 1;
    public final long b;
    public final Object c;

    public n(long j2) {
        this(j2, 0L);
    }

    @Override // p0.r
    public final boolean e() {
        switch (this.f3115a) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // p0.r
    public final q g(long j2) {
        long j5;
        switch (this.f3115a) {
            case 0:
                g2.i iVar = (g2.i) this.c;
                iVar.f1931k.getClass();
                c1.b bVar = iVar.f1931k;
                long[] jArr = (long[]) bVar.b;
                int d = w.d(jArr, w.i((iVar.f1925e * j2) / 1000000, 0L, iVar.f1930j - 1), false);
                long j6 = 0;
                if (d == -1) {
                    j5 = 0;
                } else {
                    j5 = jArr[d];
                }
                long[] jArr2 = (long[]) bVar.c;
                if (d != -1) {
                    j6 = jArr2[d];
                }
                int i3 = iVar.f1925e;
                long j7 = (j5 * 1000000) / i3;
                long j8 = this.b;
                s sVar = new s(j7, j6 + j8);
                if (j7 != j2 && d != jArr.length - 1) {
                    int i5 = d + 1;
                    return new q(sVar, new s((jArr[i5] * 1000000) / i3, j8 + jArr2[i5]));
                }
                return new q(sVar, sVar);
            default:
                return (q) this.c;
        }
    }

    @Override // p0.r
    public final long i() {
        switch (this.f3115a) {
            case 0:
                return ((g2.i) this.c).c();
            default:
                return this.b;
        }
    }

    public n(g2.i iVar, long j2) {
        this.c = iVar;
        this.b = j2;
    }

    public n(long j2, long j5) {
        this.b = j2;
        s sVar = j5 == 0 ? s.c : new s(0L, j5);
        this.c = new q(sVar, sVar);
    }
}
