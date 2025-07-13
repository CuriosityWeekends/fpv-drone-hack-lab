package u4;

import h4.c;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends AtomicBoolean implements i4.a {
    private static final long serialVersionUID = 3562861878281475070L;

    /* renamed from: a  reason: collision with root package name */
    public final c f3779a;
    public final b b;

    public a(c cVar, b bVar) {
        this.f3779a = cVar;
        this.b = bVar;
    }

    @Override // i4.a
    public final void dispose() {
        if (compareAndSet(false, true)) {
            this.b.i(this);
        }
    }
}
