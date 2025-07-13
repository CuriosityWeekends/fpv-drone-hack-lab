package n1;

import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n extends m {

    /* renamed from: g  reason: collision with root package name */
    public final List f2941g;

    public n(i iVar, long j2, long j5, long j6, long j7, List list, List list2) {
        super(iVar, j2, j5, j6, j7, list);
        this.f2941g = list2;
    }

    @Override // n1.m
    public final int b(long j2) {
        return this.f2941g.size();
    }

    @Override // n1.m
    public final i d(long j2, l lVar) {
        return (i) this.f2941g.get((int) (j2 - this.d));
    }

    @Override // n1.m
    public final boolean e() {
        return true;
    }
}
