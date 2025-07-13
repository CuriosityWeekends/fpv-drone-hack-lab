package i4;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends b {
    private static final long serialVersionUID = -8219729196779211169L;

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        boolean z3;
        StringBuilder sb = new StringBuilder("RunnableDisposable(disposed=");
        if (get() == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        sb.append(z3);
        sb.append(", ");
        sb.append(get());
        sb.append(")");
        return sb.toString();
    }
}
