package j0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public g0 f2346a;
    public int b;
    public boolean c;
    public int d;

    public final void a(int i3) {
        boolean z3 = true;
        if (this.c && this.d != 4) {
            if (i3 != 4) {
                z3 = false;
            }
            g2.b.e(z3);
            return;
        }
        this.c = true;
        this.d = i3;
    }
}
