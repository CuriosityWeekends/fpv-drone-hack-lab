package l2;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h implements Iterator {

    /* renamed from: a  reason: collision with root package name */
    public j f2693a;
    public j b = null;
    public int c;
    public final /* synthetic */ k d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f2694e;

    public h(k kVar, int i3) {
        this.f2694e = i3;
        this.d = kVar;
        this.f2693a = kVar.f2703e.d;
        this.c = kVar.d;
    }

    public final Object a() {
        return b();
    }

    public final j b() {
        j jVar = this.f2693a;
        k kVar = this.d;
        if (jVar != kVar.f2703e) {
            if (kVar.d == this.c) {
                this.f2693a = jVar.d;
                this.b = jVar;
                return jVar;
            }
            throw new ConcurrentModificationException();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f2693a != this.d.f2703e) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.f2694e) {
            case 1:
                return b().f2698f;
            default:
                return a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        j jVar = this.b;
        if (jVar != null) {
            k kVar = this.d;
            kVar.c(jVar, true);
            this.b = null;
            this.c = kVar.d;
            return;
        }
        throw new IllegalStateException();
    }
}
