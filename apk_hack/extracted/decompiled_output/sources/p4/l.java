package p4;

import java.util.Objects;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l extends o4.a {

    /* renamed from: a  reason: collision with root package name */
    public final h4.c f3259a;
    public final Object[] b;
    public int c;
    public boolean d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f3260e;

    public l(h4.c cVar, Object[] objArr) {
        this.f3259a = cVar;
        this.b = objArr;
    }

    @Override // n4.d
    public final Object b() {
        int i3 = this.c;
        Object[] objArr = this.b;
        if (i3 != objArr.length) {
            this.c = i3 + 1;
            Object obj = objArr[i3];
            Objects.requireNonNull(obj, "The array element is null");
            return obj;
        }
        return null;
    }

    @Override // n4.d
    public final void clear() {
        this.c = this.b.length;
    }

    @Override // n4.a
    public final int d(int i3) {
        this.d = true;
        return 1;
    }

    @Override // i4.a
    public final void dispose() {
        this.f3260e = true;
    }

    @Override // n4.d
    public final boolean isEmpty() {
        if (this.c == this.b.length) {
            return true;
        }
        return false;
    }
}
