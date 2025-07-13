package n;

import b3.e;
import com.bumptech.glide.load.data.l;
import g.g;
import g.h;
import java.util.ArrayDeque;
import m.f;
import m.n;
import m.o;
import m.p;
import m.q;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements q {
    public static final g b = g.a(2500, "com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout");

    /* renamed from: a  reason: collision with root package name */
    public final e f2901a;

    public a(e eVar) {
        this.f2901a = eVar;
    }

    @Override // m.q
    public final p a(Object obj, int i3, int i5, h hVar) {
        f fVar = (f) obj;
        e eVar = this.f2901a;
        if (eVar != null) {
            o a5 = o.a(fVar);
            n nVar = (n) eVar.b;
            Object d = nVar.d(a5);
            ArrayDeque arrayDeque = o.d;
            synchronized (arrayDeque) {
                arrayDeque.offer(a5);
            }
            f fVar2 = (f) d;
            if (fVar2 == null) {
                nVar.g(o.a(fVar), fVar);
            } else {
                fVar = fVar2;
            }
        }
        return new p(fVar, new l(fVar, ((Integer) hVar.c(b)).intValue()));
    }

    @Override // m.q
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        f fVar = (f) obj;
        return true;
    }
}
