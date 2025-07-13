package g;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f1899a;
    public static final i b;
    public static final /* synthetic */ i[] c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [g.i, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v1, types: [g.i, java.lang.Enum] */
    static {
        ?? r22 = new Enum("SRGB", 0);
        f1899a = r22;
        ?? r32 = new Enum("DISPLAY_P3", 1);
        b = r32;
        c = new i[]{r22, r32};
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) c.clone();
    }
}
