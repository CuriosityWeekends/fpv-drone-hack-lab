package i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class m {
    public static final m b = new m(0);
    public static final m c = new m(1);
    public static final m d = new m(2);

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2114a;

    public /* synthetic */ m(int i3) {
        this.f2114a = i3;
    }

    public final boolean a() {
        switch (this.f2114a) {
            case 0:
                return false;
            case 1:
                return true;
            default:
                return true;
        }
    }

    public final boolean b() {
        switch (this.f2114a) {
            case 0:
                return false;
            case 1:
                return false;
            default:
                return true;
        }
    }

    public final boolean c(int i3) {
        switch (this.f2114a) {
            case 0:
                return false;
            case 1:
                return (i3 == 3 || i3 == 5) ? false : true;
            default:
                return i3 == 2;
        }
    }

    public final boolean d(int i3, int i5, boolean z3) {
        switch (this.f2114a) {
            case 0:
                return false;
            case 1:
                return false;
            default:
                return ((z3 && i3 == 3) || i3 == 1) && i5 == 2;
        }
    }
}
