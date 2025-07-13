package j1;

import com.google.android.exoplayer2.Format;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements j0 {

    /* renamed from: a  reason: collision with root package name */
    public final j0 f2374a;
    public boolean b;
    public final /* synthetic */ d c;

    public c(d dVar, j0 j0Var) {
        this.c = dVar;
        this.f2374a = j0Var;
    }

    @Override // j1.j0
    public final void a() {
        this.f2374a.a();
    }

    @Override // j1.j0
    public final int c(j0.b bVar, m0.d dVar, boolean z3) {
        d dVar2 = this.c;
        if (dVar2.a()) {
            return -3;
        }
        if (this.b) {
            dVar.setFlags(4);
            return -4;
        }
        int c = this.f2374a.c(bVar, dVar, z3);
        if (c == -5) {
            Format format = (Format) bVar.d;
            format.getClass();
            int i3 = format.f325z;
            int i5 = format.f324y;
            if (i5 != 0 || i3 != 0) {
                if (dVar2.f2377e != Long.MIN_VALUE) {
                    i3 = 0;
                }
                bVar.d = format.f(i5, i3);
            }
            return -5;
        }
        long j2 = dVar2.f2377e;
        if (j2 != Long.MIN_VALUE && ((c == -4 && dVar.c >= j2) || (c == -3 && dVar2.s() == Long.MIN_VALUE))) {
            dVar.clear();
            dVar.setFlags(4);
            this.b = true;
            return -4;
        }
        return c;
    }

    @Override // j1.j0
    public final int g(long j2) {
        if (this.c.a()) {
            return -3;
        }
        return this.f2374a.g(j2);
    }

    @Override // j1.j0
    public final boolean isReady() {
        if (!this.c.a() && this.f2374a.isReady()) {
            return true;
        }
        return false;
    }
}
