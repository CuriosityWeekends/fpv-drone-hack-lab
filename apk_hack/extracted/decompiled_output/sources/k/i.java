package k;

import c0.j;
import c0.n;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final j f2492a = new j(1000);
    public final d0.d b = d0.g.a(10, new j3.a(10));

    public final String a(g.e eVar) {
        String str;
        h hVar = (h) this.b.acquire();
        try {
            eVar.b(hVar.f2491a);
            byte[] digest = hVar.f2491a.digest();
            char[] cArr = n.b;
            synchronized (cArr) {
                for (int i3 = 0; i3 < digest.length; i3++) {
                    byte b = digest[i3];
                    int i5 = i3 * 2;
                    char[] cArr2 = n.f199a;
                    cArr[i5] = cArr2[(b & 255) >>> 4];
                    cArr[i5 + 1] = cArr2[b & 15];
                }
                str = new String(cArr);
            }
            return str;
        } finally {
            this.b.release(hVar);
        }
    }

    public final String b(g.e eVar) {
        String str;
        synchronized (this.f2492a) {
            str = (String) this.f2492a.d(eVar);
        }
        if (str == null) {
            str = a(eVar);
        }
        synchronized (this.f2492a) {
            this.f2492a.g(eVar, str);
        }
        return str;
    }
}
