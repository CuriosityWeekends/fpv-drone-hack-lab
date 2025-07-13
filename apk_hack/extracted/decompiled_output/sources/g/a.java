package g;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f1895a;
    public static final a b;
    public static final a c;
    public static final /* synthetic */ a[] d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Enum, g.a] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, g.a] */
    static {
        ?? r22 = new Enum("PREFER_ARGB_8888", 0);
        f1895a = r22;
        ?? r32 = new Enum("PREFER_RGB_565", 1);
        b = r32;
        d = new a[]{r22, r32};
        c = r22;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) d.clone();
    }
}
