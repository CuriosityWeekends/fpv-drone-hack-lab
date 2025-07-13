package i;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l0 implements g, f {

    /* renamed from: a  reason: collision with root package name */
    public final h f2110a;
    public final f b;
    public int c;
    public d d;

    /* renamed from: e  reason: collision with root package name */
    public Object f2111e;

    /* renamed from: f  reason: collision with root package name */
    public volatile m.p f2112f;

    /* renamed from: g  reason: collision with root package name */
    public e f2113g;

    public l0(h hVar, f fVar) {
        this.f2110a = hVar;
        this.b = fVar;
    }

    @Override // i.f
    public final void a() {
        throw new UnsupportedOperationException();
    }

    @Override // i.f
    public final void b(g.e eVar, Object obj, com.bumptech.glide.load.data.e eVar2, int i3, g.e eVar3) {
        this.b.b(eVar, obj, eVar2, this.f2112f.c.getDataSource(), eVar);
    }

    @Override // i.g
    public final boolean c() {
        Object obj = this.f2111e;
        if (obj != null) {
            this.f2111e = null;
            int i3 = c0.h.b;
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            try {
                g.b d = this.f2110a.d(obj);
                b bVar = new b(d, obj, this.f2110a.f2064i, 1);
                g.e eVar = this.f2112f.f2748a;
                h hVar = this.f2110a;
                this.f2113g = new e(eVar, hVar.f2069n);
                hVar.f2063h.a().e(this.f2113g, bVar);
                if (Log.isLoggable("SourceGenerator", 2)) {
                    Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f2113g + ", data: " + obj + ", encoder: " + d + ", duration: " + c0.h.a(elapsedRealtimeNanos));
                }
                this.f2112f.c.b();
                this.d = new d(Collections.singletonList(this.f2112f.f2748a), this.f2110a, this);
            } catch (Throwable th) {
                this.f2112f.c.b();
                throw th;
            }
        }
        d dVar = this.d;
        if (dVar != null && dVar.c()) {
            return true;
        }
        this.d = null;
        this.f2112f = null;
        boolean z3 = false;
        while (!z3 && this.c < this.f2110a.b().size()) {
            ArrayList b = this.f2110a.b();
            int i5 = this.c;
            this.c = i5 + 1;
            this.f2112f = (m.p) b.get(i5);
            if (this.f2112f != null && (this.f2110a.f2071p.c(this.f2112f.c.getDataSource()) || this.f2110a.c(this.f2112f.c.a()) != null)) {
                this.f2112f.c.c(this.f2110a.f2070o, new c1.b(8, this, this.f2112f));
                z3 = true;
            }
        }
        return z3;
    }

    @Override // i.g
    public final void cancel() {
        m.p pVar = this.f2112f;
        if (pVar != null) {
            pVar.c.cancel();
        }
    }

    @Override // i.f
    public final void d(g.e eVar, Exception exc, com.bumptech.glide.load.data.e eVar2, int i3) {
        this.b.d(eVar, exc, eVar2, this.f2112f.c.getDataSource());
    }
}
