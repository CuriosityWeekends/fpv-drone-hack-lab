package i;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i0 implements g.e {

    /* renamed from: j  reason: collision with root package name */
    public static final c0.j f2080j = new c0.j(50);
    public final j.g b;
    public final g.e c;
    public final g.e d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2081e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2082f;

    /* renamed from: g  reason: collision with root package name */
    public final Class f2083g;

    /* renamed from: h  reason: collision with root package name */
    public final g.h f2084h;

    /* renamed from: i  reason: collision with root package name */
    public final g.l f2085i;

    public i0(j.g gVar, g.e eVar, g.e eVar2, int i3, int i5, g.l lVar, Class cls, g.h hVar) {
        this.b = gVar;
        this.c = eVar;
        this.d = eVar2;
        this.f2081e = i3;
        this.f2082f = i5;
        this.f2085i = lVar;
        this.f2083g = cls;
        this.f2084h = hVar;
    }

    @Override // g.e
    public final void b(MessageDigest messageDigest) {
        Object f4;
        j.g gVar = this.b;
        synchronized (gVar) {
            j.f fVar = gVar.b;
            j.j jVar = (j.j) ((ArrayDeque) fVar.f2183a).poll();
            if (jVar == null) {
                jVar = fVar.D();
            }
            j.e eVar = (j.e) jVar;
            eVar.b = 8;
            eVar.c = byte[].class;
            f4 = gVar.f(eVar, byte[].class);
        }
        byte[] bArr = (byte[]) f4;
        ByteBuffer.wrap(bArr).putInt(this.f2081e).putInt(this.f2082f).array();
        this.d.b(messageDigest);
        this.c.b(messageDigest);
        messageDigest.update(bArr);
        g.l lVar = this.f2085i;
        if (lVar != null) {
            lVar.b(messageDigest);
        }
        this.f2084h.b(messageDigest);
        c0.j jVar2 = f2080j;
        Class cls = this.f2083g;
        byte[] bArr2 = (byte[]) jVar2.d(cls);
        if (bArr2 == null) {
            bArr2 = cls.getName().getBytes(g.e.f1896a);
            jVar2.g(cls, bArr2);
        }
        messageDigest.update(bArr2);
        this.b.h(bArr);
    }

    @Override // g.e
    public final boolean equals(Object obj) {
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        if (this.f2082f != i0Var.f2082f || this.f2081e != i0Var.f2081e || !c0.n.a(this.f2085i, i0Var.f2085i) || !this.f2083g.equals(i0Var.f2083g) || !this.c.equals(i0Var.c) || !this.d.equals(i0Var.d) || !this.f2084h.equals(i0Var.f2084h)) {
            return false;
        }
        return true;
    }

    @Override // g.e
    public final int hashCode() {
        int hashCode = ((((this.d.hashCode() + (this.c.hashCode() * 31)) * 31) + this.f2081e) * 31) + this.f2082f;
        g.l lVar = this.f2085i;
        if (lVar != null) {
            hashCode = (hashCode * 31) + lVar.hashCode();
        }
        int hashCode2 = this.f2083g.hashCode();
        return this.f2084h.b.hashCode() + ((hashCode2 + (hashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.d + ", width=" + this.f2081e + ", height=" + this.f2082f + ", decodedResourceClass=" + this.f2083g + ", transformation='" + this.f2085i + "', options=" + this.f2084h + '}';
    }
}
