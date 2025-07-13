package w0;

import g2.w;
import p0.q;
import p0.r;
import p0.s;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f3901a;

    public a(b bVar) {
        this.f3901a = bVar;
    }

    @Override // p0.r
    public final boolean e() {
        return true;
    }

    @Override // p0.r
    public final q g(long j2) {
        b bVar = this.f3901a;
        long j5 = bVar.c;
        long j6 = bVar.b;
        s sVar = new s(j2, w.i(((((j5 - j6) * ((bVar.d.f3927i * j2) / 1000000)) / bVar.f3904f) + j6) - 30000, j6, j5 - 1));
        return new q(sVar, sVar);
    }

    @Override // p0.r
    public final long i() {
        b bVar = this.f3901a;
        return (bVar.f3904f * 1000000) / bVar.d.f3927i;
    }
}
