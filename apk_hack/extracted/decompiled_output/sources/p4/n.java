package p4;

import java.util.Iterator;
import java.util.Objects;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n extends o4.a {

    /* renamed from: a  reason: collision with root package name */
    public final h4.c f3262a;
    public final Iterator b;
    public volatile boolean c;
    public boolean d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3263e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3264f;

    public n(h4.c cVar, Iterator it) {
        this.f3262a = cVar;
        this.b = it;
    }

    @Override // n4.d
    public final Object b() {
        if (this.f3263e) {
            return null;
        }
        boolean z3 = this.f3264f;
        Iterator it = this.b;
        if (z3) {
            if (!it.hasNext()) {
                this.f3263e = true;
                return null;
            }
        } else {
            this.f3264f = true;
        }
        Object next = it.next();
        Objects.requireNonNull(next, "The iterator returned a null value");
        return next;
    }

    @Override // n4.d
    public final void clear() {
        this.f3263e = true;
    }

    @Override // n4.a
    public final int d(int i3) {
        this.d = true;
        return 1;
    }

    @Override // i4.a
    public final void dispose() {
        this.c = true;
    }

    @Override // n4.d
    public final boolean isEmpty() {
        return this.f3263e;
    }
}
