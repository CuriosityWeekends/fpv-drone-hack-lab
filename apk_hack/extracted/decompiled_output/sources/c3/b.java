package c3;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f227a;
    public static final b b;
    public static final b c;
    public static final b d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ b[] f228e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, c3.b] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, c3.b] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, c3.b] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, c3.b] */
    static {
        ?? r42 = new Enum("Open", 0);
        f227a = r42;
        ?? r5 = new Enum("Close", 1);
        b = r5;
        ?? r6 = new Enum("Opening", 2);
        c = r6;
        ?? r7 = new Enum("Closing", 3);
        d = r7;
        f228e = new b[]{r42, r5, r6, r7};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f228e.clone();
    }
}
