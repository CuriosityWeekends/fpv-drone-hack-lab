package g;

import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h implements e {
    public final CachedHashCodeArrayMap b = new CachedHashCodeArrayMap();

    @Override // g.e
    public final void b(MessageDigest messageDigest) {
        for (int i3 = 0; i3 < this.b.size(); i3++) {
            g gVar = (g) this.b.keyAt(i3);
            Object valueAt = this.b.valueAt(i3);
            f fVar = gVar.b;
            if (gVar.d == null) {
                gVar.d = gVar.c.getBytes(e.f1896a);
            }
            fVar.c(gVar.d, valueAt, messageDigest);
        }
    }

    public final Object c(g gVar) {
        CachedHashCodeArrayMap cachedHashCodeArrayMap = this.b;
        if (cachedHashCodeArrayMap.containsKey(gVar)) {
            return cachedHashCodeArrayMap.get(gVar);
        }
        return gVar.f1898a;
    }

    @Override // g.e
    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            return this.b.equals(((h) obj).b);
        }
        return false;
    }

    @Override // g.e
    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.b + '}';
    }
}
