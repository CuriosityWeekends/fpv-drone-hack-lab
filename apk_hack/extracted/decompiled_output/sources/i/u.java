package i;

import java.util.concurrent.Executor;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public final y.f f2129a;
    public final Executor b;

    public u(y.f fVar, Executor executor) {
        this.f2129a = fVar;
        this.b = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof u) {
            return this.f2129a.equals(((u) obj).f2129a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2129a.hashCode();
    }
}
