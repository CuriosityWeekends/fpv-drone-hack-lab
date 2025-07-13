package i;

import java.security.MessageDigest;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e implements g.e {
    public final g.e b;
    public final g.e c;

    public e(g.e eVar, g.e eVar2) {
        this.b = eVar;
        this.c = eVar2;
    }

    @Override // g.e
    public final void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
        this.c.b(messageDigest);
    }

    @Override // g.e
    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.b.equals(eVar.b) || !this.c.equals(eVar.c)) {
            return false;
        }
        return true;
    }

    @Override // g.e
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.c + '}';
    }
}
