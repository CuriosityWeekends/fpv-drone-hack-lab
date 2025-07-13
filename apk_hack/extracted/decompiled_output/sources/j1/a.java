package j1;

import android.os.Looper;
import j0.u0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class a implements p {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f2369a = new ArrayList(1);
    public final HashSet b = new HashSet(1);
    public final u c = new u(new CopyOnWriteArrayList(), 0, null, 0);
    public Looper d;

    /* renamed from: e  reason: collision with root package name */
    public u0 f2370e;

    public final u d(n nVar) {
        return new u(this.c.c, 0, nVar, 0L);
    }

    public final void e(o oVar) {
        HashSet hashSet = this.b;
        boolean z3 = !hashSet.isEmpty();
        hashSet.remove(oVar);
        if (z3 && hashSet.isEmpty()) {
            g();
        }
    }

    public final void h(o oVar) {
        this.d.getClass();
        HashSet hashSet = this.b;
        boolean isEmpty = hashSet.isEmpty();
        hashSet.add(oVar);
        if (isEmpty) {
            i();
        }
    }

    public final void j(o oVar, e2.m0 m0Var) {
        boolean z3;
        Looper myLooper = Looper.myLooper();
        Looper looper = this.d;
        if (looper != null && looper != myLooper) {
            z3 = false;
        } else {
            z3 = true;
        }
        g2.b.e(z3);
        u0 u0Var = this.f2370e;
        this.f2369a.add(oVar);
        if (this.d == null) {
            this.d = myLooper;
            this.b.add(oVar);
            m(m0Var);
        } else if (u0Var != null) {
            h(oVar);
            oVar.a(this, u0Var);
        }
    }

    public abstract void m(e2.m0 m0Var);

    public final void n(u0 u0Var) {
        this.f2370e = u0Var;
        Iterator it = this.f2369a.iterator();
        while (it.hasNext()) {
            ((o) it.next()).a(this, u0Var);
        }
    }

    public final void o(o oVar) {
        ArrayList arrayList = this.f2369a;
        arrayList.remove(oVar);
        if (arrayList.isEmpty()) {
            this.d = null;
            this.f2370e = null;
            this.b.clear();
            p();
            return;
        }
        e(oVar);
    }

    public abstract void p();

    public final void q(x xVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.c.c;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            if (tVar.b == xVar) {
                copyOnWriteArrayList.remove(tVar);
            }
        }
    }

    public void g() {
    }

    public void i() {
    }
}
