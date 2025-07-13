package c3;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f229a;
    public static final c b;
    public static final /* synthetic */ c[] c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, c3.c] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, c3.c] */
    static {
        ?? r42 = new Enum("Left", 0);
        f229a = r42;
        ?? r5 = new Enum("Right", 1);
        b = r5;
        c = new c[]{r42, r5, new Enum("Top", 2), new Enum("Bottom", 3)};
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) c.clone();
    }
}
