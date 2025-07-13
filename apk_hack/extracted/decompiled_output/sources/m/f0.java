package m;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f0 implements q {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a  reason: collision with root package name */
    public final q f2740a;

    public f0(q qVar) {
        this.f2740a = qVar;
    }

    @Override // m.q
    public final p a(Object obj, int i3, int i5, g.h hVar) {
        return this.f2740a.a(new f(((Uri) obj).toString()), i3, i5, hVar);
    }

    @Override // m.q
    public final boolean b(Object obj) {
        return b.contains(((Uri) obj).getScheme());
    }
}
