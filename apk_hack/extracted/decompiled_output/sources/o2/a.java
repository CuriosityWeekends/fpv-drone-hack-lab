package o2;

import java.lang.reflect.Type;
import l2.d;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Class f3050a;
    public final Type b;
    public final int c;

    public a(Type type) {
        type.getClass();
        Type b = d.b(type);
        this.b = b;
        this.f3050a = d.g(b);
        this.c = b.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            if (d.e(this.b, ((a) obj).b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return d.j(this.b);
    }
}
