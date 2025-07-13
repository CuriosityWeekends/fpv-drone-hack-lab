package l4;

import com.bumptech.glide.d;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements i4.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f2725a;
    public static final /* synthetic */ a[] b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Enum, l4.a] */
    static {
        ?? r12 = new Enum("DISPOSED", 0);
        f2725a = r12;
        b = new a[]{r12};
    }

    public static void a(AtomicReference atomicReference) {
        i4.a aVar;
        i4.a aVar2 = (i4.a) atomicReference.get();
        a aVar3 = f2725a;
        if (aVar2 != aVar3 && (aVar = (i4.a) atomicReference.getAndSet(aVar3)) != aVar3 && aVar != null) {
            aVar.dispose();
        }
    }

    public static boolean b(AtomicReference atomicReference, i4.a aVar) {
        Objects.requireNonNull(aVar, "d is null");
        while (!atomicReference.compareAndSet(null, aVar)) {
            if (atomicReference.get() != null) {
                aVar.dispose();
                if (atomicReference.get() != f2725a) {
                    d.i(new IllegalStateException("Disposable already set!"));
                    return false;
                }
                return false;
            }
        }
        return true;
    }

    public static boolean c(i4.a aVar, i4.a aVar2) {
        if (aVar2 == null) {
            d.i(new NullPointerException("next is null"));
            return false;
        } else if (aVar != null) {
            aVar2.dispose();
            d.i(new IllegalStateException("Disposable already set!"));
            return false;
        } else {
            return true;
        }
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) b.clone();
    }

    @Override // i4.a
    public final void dispose() {
    }
}
