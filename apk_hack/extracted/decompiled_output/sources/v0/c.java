package v0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f3791a;

    public c(int i3) {
        this.f3791a = i3;
    }

    public static String a(int i3) {
        return "" + ((char) ((i3 >> 24) & 255)) + ((char) ((i3 >> 16) & 255)) + ((char) ((i3 >> 8) & 255)) + ((char) (i3 & 255));
    }

    public static int b(int i3) {
        return (i3 >> 24) & 255;
    }

    public String toString() {
        return a(this.f3791a);
    }
}
