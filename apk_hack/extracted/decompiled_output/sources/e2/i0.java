package e2;

import android.net.Uri;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i0 implements c0 {

    /* renamed from: a  reason: collision with root package name */
    public final l f1688a;
    public final int b;
    public final k0 c;
    public final h0 d;

    /* renamed from: e  reason: collision with root package name */
    public volatile Object f1689e;

    public i0(i iVar, Uri uri, int i3, h0 h0Var) {
        l lVar = new l(uri, 1);
        this.c = new k0(iVar);
        this.f1688a = lVar;
        this.b = i3;
        this.d = h0Var;
    }

    @Override // e2.c0
    public final void a() {
        this.c.b = 0L;
        k kVar = new k(this.c, this.f1688a);
        try {
            kVar.a();
            Uri uri = this.c.f1693a.getUri();
            uri.getClass();
            this.f1689e = this.d.f(uri, kVar);
        } finally {
            g2.w.g(kVar);
        }
    }

    @Override // e2.c0
    public final void b() {
    }
}
