package b0;

import c0.g;
import g.e;
import java.security.MessageDigest;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements e {
    public final Object b;

    public b(Object obj) {
        g.c(obj, "Argument must not be null");
        this.b = obj;
    }

    @Override // g.e
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(e.f1896a));
    }

    @Override // g.e
    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.b.equals(((b) obj).b);
        }
        return false;
    }

    @Override // g.e
    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.b + '}';
    }
}
