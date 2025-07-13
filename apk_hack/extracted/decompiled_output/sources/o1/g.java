package o1;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g implements v.e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2975a;
    public boolean b;
    public final Object c;

    public g() {
        this.c = Collections.newSetFromMap(new WeakHashMap());
    }

    @Override // v.e
    public void a(v.f fVar) {
        ((Set) this.c).add(fVar);
        if (this.b) {
            fVar.i();
        } else if (this.f2975a) {
            fVar.onStart();
        } else {
            fVar.onStop();
        }
    }

    @Override // v.e
    public void b(v.f fVar) {
        ((Set) this.c).remove(fVar);
    }

    public g(p0.j jVar, boolean z3, boolean z5) {
        this.c = jVar;
        this.f2975a = z3;
        this.b = z5;
    }
}
