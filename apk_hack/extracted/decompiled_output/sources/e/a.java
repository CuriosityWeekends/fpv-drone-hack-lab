package e;

import java.util.concurrent.Callable;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f1649a;

    public a(e eVar) {
        this.f1649a = eVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (this.f1649a) {
            try {
                e eVar = this.f1649a;
                if (eVar.f1660i != null) {
                    eVar.n();
                    if (this.f1649a.g()) {
                        this.f1649a.l();
                        this.f1649a.f1662k = 0;
                    }
                    return null;
                }
                return null;
            } finally {
            }
        }
    }
}
