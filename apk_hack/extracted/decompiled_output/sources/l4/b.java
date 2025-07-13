package l4;

import h4.c;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements n4.a {

    /* renamed from: a  reason: collision with root package name */
    public static final b f2726a;
    public static final /* synthetic */ b[] b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Enum, l4.b] */
    static {
        ?? r22 = new Enum("INSTANCE", 0);
        f2726a = r22;
        b = new b[]{r22, new Enum("NEVER", 1)};
    }

    public static void c(Throwable th, c cVar) {
        cVar.a(f2726a);
        cVar.b(th);
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) b.clone();
    }

    @Override // n4.d
    public final boolean a(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // n4.d
    public final Object b() {
        return null;
    }

    @Override // n4.a
    public final int d(int i3) {
        return 2;
    }

    @Override // n4.d
    public final boolean isEmpty() {
        return true;
    }

    @Override // n4.d
    public final void clear() {
    }

    @Override // i4.a
    public final void dispose() {
    }
}
