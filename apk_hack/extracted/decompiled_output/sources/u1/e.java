package u1;

import android.util.SparseArray;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements v0.e {

    /* renamed from: a  reason: collision with root package name */
    public final int f3752a;
    public final int b;
    public final Object c;

    public e(int i3, int i5, SparseArray sparseArray) {
        this.f3752a = i3;
        this.b = i5;
        this.c = sparseArray;
    }

    @Override // v0.e
    public boolean a() {
        if (this.f3752a != 0) {
            return true;
        }
        return false;
    }

    @Override // v0.e
    public int b() {
        return this.b;
    }

    @Override // v0.e
    public int c() {
        int i3 = this.f3752a;
        if (i3 == 0) {
            return ((c0.b) this.c).q();
        }
        return i3;
    }

    public e(v0.b bVar) {
        c0.b bVar2 = bVar.b;
        this.c = bVar2;
        bVar2.y(12);
        this.f3752a = bVar2.q();
        this.b = bVar2.q();
    }
}
