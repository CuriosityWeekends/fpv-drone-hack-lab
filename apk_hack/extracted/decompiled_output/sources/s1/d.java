package s1;

import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d extends m0.e implements e {

    /* renamed from: a  reason: collision with root package name */
    public e f3502a;
    public long b;
    public final /* synthetic */ int c;
    public final f d;

    public /* synthetic */ d(f fVar, int i3) {
        this.c = i3;
        this.d = fVar;
    }

    @Override // s1.e
    public final int b(long j2) {
        e eVar = this.f3502a;
        eVar.getClass();
        return eVar.b(j2 - this.b);
    }

    @Override // m0.a
    public final void clear() {
        super.clear();
        this.f3502a = null;
    }

    @Override // s1.e
    public final long e(int i3) {
        e eVar = this.f3502a;
        eVar.getClass();
        return eVar.e(i3) + this.b;
    }

    @Override // s1.e
    public final List i(long j2) {
        e eVar = this.f3502a;
        eVar.getClass();
        return eVar.i(j2 - this.b);
    }

    @Override // s1.e
    public final int n() {
        e eVar = this.f3502a;
        eVar.getClass();
        return eVar.n();
    }

    @Override // m0.e
    public final void release() {
        switch (this.c) {
            case 0:
                ((c) this.d).h(this);
                return;
            default:
                t1.h hVar = (t1.h) this.d;
                hVar.getClass();
                clear();
                hVar.b.add(this);
                return;
        }
    }
}
