package j;

import android.graphics.Bitmap;
import c0.n;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l implements j {

    /* renamed from: a  reason: collision with root package name */
    public final f f2198a;
    public int b;
    public Bitmap.Config c;

    public l(f fVar) {
        this.f2198a = fVar;
    }

    @Override // j.j
    public final void a() {
        this.f2198a.C(this);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.b != lVar.b || !n.a(this.c, lVar.c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i3;
        int i5 = this.b * 31;
        Bitmap.Config config = this.c;
        if (config != null) {
            i3 = config.hashCode();
        } else {
            i3 = 0;
        }
        return i5 + i3;
    }

    public final String toString() {
        return m.c(this.b, this.c);
    }
}
