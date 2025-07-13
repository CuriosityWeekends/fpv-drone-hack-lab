package r4;

import java.util.ArrayList;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements k4.c, k4.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3455a;
    public static final /* synthetic */ a[] b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [r4.a, java.lang.Enum] */
    static {
        ?? r12 = new Enum("INSTANCE", 0);
        f3455a = r12;
        b = new a[]{r12};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) b.clone();
    }

    @Override // k4.b
    public final Object apply(Object obj) {
        return new ArrayList();
    }

    @Override // k4.c
    public final Object get() {
        return new ArrayList();
    }
}
