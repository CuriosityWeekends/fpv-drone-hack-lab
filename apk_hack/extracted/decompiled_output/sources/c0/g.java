package c0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final f f192a = new f(0);
    public static final f b = new f(1);

    public static void a(String str, boolean z3) {
        if (z3) {
            return;
        }
        throw new IllegalArgumentException(str);
    }

    public static void b(Object obj) {
        c(obj, "Argument must not be null");
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new NullPointerException(str);
    }
}
