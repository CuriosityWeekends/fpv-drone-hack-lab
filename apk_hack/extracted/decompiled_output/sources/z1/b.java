package z1;

import java.util.Collections;
import java.util.List;
import s1.e;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements e {
    public static final b b = new b();

    /* renamed from: a  reason: collision with root package name */
    public final List f4294a;

    public b(s1.b bVar) {
        this.f4294a = Collections.singletonList(bVar);
    }

    @Override // s1.e
    public final int b(long j2) {
        if (j2 < 0) {
            return 0;
        }
        return -1;
    }

    @Override // s1.e
    public final long e(int i3) {
        boolean z3;
        if (i3 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        g2.b.e(z3);
        return 0L;
    }

    @Override // s1.e
    public final List i(long j2) {
        if (j2 >= 0) {
            return this.f4294a;
        }
        return Collections.emptyList();
    }

    @Override // s1.e
    public final int n() {
        return 1;
    }

    public b() {
        this.f4294a = Collections.emptyList();
    }
}
