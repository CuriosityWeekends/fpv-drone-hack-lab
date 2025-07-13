package t2;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract /* synthetic */ class h {
    public static /* synthetic */ boolean a(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return false;
        }
        if (i3 == 4 || i3 == 5) {
            return true;
        }
        throw null;
    }

    public static int b(int i3, int i5, int i6, int i7) {
        return i7 - ((i3 - i5) * i6);
    }
}
