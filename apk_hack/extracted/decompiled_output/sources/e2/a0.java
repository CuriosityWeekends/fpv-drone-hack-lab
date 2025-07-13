package e2;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f1672a;
    public final long b;

    public /* synthetic */ a0(int i3, long j2) {
        this.f1672a = i3;
        this.b = j2;
    }

    public static a0 b(p0.g gVar, c0.b bVar) {
        gVar.d(bVar.f187a, 0, 8, false);
        bVar.y(0);
        return new a0(bVar.c(), bVar.f());
    }

    public boolean a() {
        int i3 = this.f1672a;
        if (i3 == 0 || i3 == 1) {
            return true;
        }
        return false;
    }
}
