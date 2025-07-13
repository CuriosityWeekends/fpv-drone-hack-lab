package c3;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f225a;
    public static final a b;
    public static final a c;
    public static final a d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ a[] f226e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Enum, c3.a] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, c3.a] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Enum, c3.a] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, c3.a] */
    static {
        ?? r42 = new Enum("DragToUp", 0);
        f225a = r42;
        ?? r5 = new Enum("DragToBottom", 1);
        b = r5;
        ?? r6 = new Enum("DragToLeft", 2);
        c = r6;
        ?? r7 = new Enum("DragToRight", 3);
        d = r7;
        f226e = new a[]{r42, r5, r6, r7};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f226e.clone();
    }
}
