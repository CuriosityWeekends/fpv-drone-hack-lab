package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import t2.d0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p implements ComponentCallbacks2, v.f {

    /* renamed from: k  reason: collision with root package name */
    public static final y.e f286k;

    /* renamed from: a  reason: collision with root package name */
    public final b f287a;
    public final Context b;
    public final v.e c;
    public final j0.b d;

    /* renamed from: e  reason: collision with root package name */
    public final v.j f288e;

    /* renamed from: f  reason: collision with root package name */
    public final v.k f289f;

    /* renamed from: g  reason: collision with root package name */
    public final b3.d f290g;

    /* renamed from: h  reason: collision with root package name */
    public final v.a f291h;

    /* renamed from: i  reason: collision with root package name */
    public final CopyOnWriteArrayList f292i;

    /* renamed from: j  reason: collision with root package name */
    public y.e f293j;

    static {
        y.e eVar = (y.e) new y.a().c(Bitmap.class);
        eVar.f3993t = true;
        f286k = eVar;
        ((y.e) new y.a().c(GifDrawable.class)).f3993t = true;
        y.e eVar2 = (y.e) ((y.e) ((y.e) new y.a().d(i.m.c)).h()).l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [v.a, v.f] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [v.e] */
    /* JADX WARN: Type inference failed for: r9v10, types: [y.e, y.a] */
    public p(b bVar, v.e eVar, v.j jVar, Context context) {
        boolean z3;
        v.b bVar2;
        y.e eVar2;
        String str;
        j0.b bVar3 = new j0.b();
        d0 d0Var = bVar.f237g;
        this.f289f = new v.k();
        b3.d dVar = new b3.d(1, this);
        this.f290g = dVar;
        this.f287a = bVar;
        this.c = eVar;
        this.f288e = jVar;
        this.d = bVar3;
        this.b = context;
        Context applicationContext = context.getApplicationContext();
        c1.b bVar4 = new c1.b(1, this, bVar3);
        d0Var.getClass();
        if (ContextCompat.checkSelfPermission(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            if (z3) {
                str = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
            } else {
                str = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            }
            Log.d("ConnectivityMonitor", str);
        }
        if (z3) {
            bVar2 = new v.b(applicationContext, bVar4);
        } else {
            bVar2 = new Object();
        }
        this.f291h = bVar2;
        char[] cArr = c0.n.f199a;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            c0.n.e().post(dVar);
        } else {
            eVar.a(this);
        }
        eVar.a(bVar2);
        this.f292i = new CopyOnWriteArrayList(bVar.c.f244e);
        f fVar = bVar.c;
        synchronized (fVar) {
            try {
                if (fVar.f249j == null) {
                    fVar.d.getClass();
                    ?? aVar = new y.a();
                    aVar.f3993t = true;
                    fVar.f249j = aVar;
                }
                eVar2 = fVar.f249j;
            } catch (Throwable th) {
                throw th;
            }
        }
        m(eVar2);
        bVar.c(this);
    }

    @Override // v.f
    public final synchronized void i() {
        try {
            this.f289f.i();
            Iterator it = c0.n.d(this.f289f.f3790a).iterator();
            while (it.hasNext()) {
                j((z.d) it.next());
            }
            this.f289f.f3790a.clear();
            j0.b bVar = this.d;
            Iterator it2 = c0.n.d((Set) bVar.c).iterator();
            while (it2.hasNext()) {
                bVar.d((y.c) it2.next());
            }
            ((ArrayList) bVar.d).clear();
            this.c.b(this);
            this.c.b(this.f291h);
            c0.n.e().removeCallbacks(this.f290g);
            this.f287a.d(this);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void j(z.d dVar) {
        if (dVar == null) {
            return;
        }
        boolean n5 = n(dVar);
        y.c e5 = dVar.e();
        if (!n5) {
            b bVar = this.f287a;
            synchronized (bVar.f238h) {
                try {
                    Iterator it = bVar.f238h.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((p) it.next()).n(dVar)) {
                            }
                        } else if (e5 != null) {
                            dVar.d(null);
                            e5.clear();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public final synchronized void k() {
        j0.b bVar = this.d;
        bVar.b = true;
        Iterator it = c0.n.d((Set) bVar.c).iterator();
        while (it.hasNext()) {
            y.c cVar = (y.c) it.next();
            if (cVar.isRunning()) {
                cVar.pause();
                ((ArrayList) bVar.d).add(cVar);
            }
        }
    }

    public final synchronized void l() {
        j0.b bVar = this.d;
        bVar.b = false;
        Iterator it = c0.n.d((Set) bVar.c).iterator();
        while (it.hasNext()) {
            y.c cVar = (y.c) it.next();
            if (!cVar.i() && !cVar.isRunning()) {
                cVar.g();
            }
        }
        ((ArrayList) bVar.d).clear();
    }

    public final synchronized void m(y.e eVar) {
        y.e eVar2 = (y.e) eVar.clone();
        if (eVar2.f3993t && !eVar2.f3995v) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        eVar2.f3995v = true;
        eVar2.f3993t = true;
        this.f293j = eVar2;
    }

    public final synchronized boolean n(z.d dVar) {
        y.c e5 = dVar.e();
        if (e5 == null) {
            return true;
        }
        if (this.d.d(e5)) {
            this.f289f.f3790a.remove(dVar);
            dVar.d(null);
            return true;
        }
        return false;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // v.f
    public final synchronized void onStart() {
        l();
        this.f289f.onStart();
    }

    @Override // v.f
    public final synchronized void onStop() {
        k();
        this.f289f.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i3) {
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.d + ", treeNode=" + this.f288e + "}";
    }
}
