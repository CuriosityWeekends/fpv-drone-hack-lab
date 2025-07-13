package i;

import com.bumptech.glide.util.CachedHashCodeArrayMap;
import java.security.MessageDigest;
import java.util.Map;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class y implements g.e {
    public final Object b;
    public final int c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final Class f2151e;

    /* renamed from: f  reason: collision with root package name */
    public final Class f2152f;

    /* renamed from: g  reason: collision with root package name */
    public final g.e f2153g;

    /* renamed from: h  reason: collision with root package name */
    public final Map f2154h;

    /* renamed from: i  reason: collision with root package name */
    public final g.h f2155i;

    /* renamed from: j  reason: collision with root package name */
    public int f2156j;

    public y(Object obj, g.e eVar, int i3, int i5, CachedHashCodeArrayMap cachedHashCodeArrayMap, Class cls, Class cls2, g.h hVar) {
        c0.g.c(obj, "Argument must not be null");
        this.b = obj;
        c0.g.c(eVar, "Signature must not be null");
        this.f2153g = eVar;
        this.c = i3;
        this.d = i5;
        c0.g.c(cachedHashCodeArrayMap, "Argument must not be null");
        this.f2154h = cachedHashCodeArrayMap;
        c0.g.c(cls, "Resource class must not be null");
        this.f2151e = cls;
        c0.g.c(cls2, "Transcode class must not be null");
        this.f2152f = cls2;
        c0.g.c(hVar, "Argument must not be null");
        this.f2155i = hVar;
    }

    @Override // g.e
    public final void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // g.e
    public final boolean equals(Object obj) {
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (!this.b.equals(yVar.b) || !this.f2153g.equals(yVar.f2153g) || this.d != yVar.d || this.c != yVar.c || !this.f2154h.equals(yVar.f2154h) || !this.f2151e.equals(yVar.f2151e) || !this.f2152f.equals(yVar.f2152f) || !this.f2155i.equals(yVar.f2155i)) {
            return false;
        }
        return true;
    }

    @Override // g.e
    public final int hashCode() {
        if (this.f2156j == 0) {
            int hashCode = this.b.hashCode();
            this.f2156j = hashCode;
            int hashCode2 = ((((this.f2153g.hashCode() + (hashCode * 31)) * 31) + this.c) * 31) + this.d;
            this.f2156j = hashCode2;
            int hashCode3 = this.f2154h.hashCode() + (hashCode2 * 31);
            this.f2156j = hashCode3;
            int hashCode4 = this.f2151e.hashCode() + (hashCode3 * 31);
            this.f2156j = hashCode4;
            int hashCode5 = this.f2152f.hashCode() + (hashCode4 * 31);
            this.f2156j = hashCode5;
            this.f2156j = this.f2155i.b.hashCode() + (hashCode5 * 31);
        }
        return this.f2156j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.f2151e + ", transcodeClass=" + this.f2152f + ", signature=" + this.f2153g + ", hashCode=" + this.f2156j + ", transformations=" + this.f2154h + ", options=" + this.f2155i + '}';
    }
}
