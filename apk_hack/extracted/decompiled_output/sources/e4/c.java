package e4;

import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends d {
    public final Exception b;

    public c(h hVar, IOException iOException) {
        super(hVar);
        this.b = iOException;
    }

    @Override // e4.d
    public final void a(a aVar) {
        aVar.onError(this.b);
    }
}
