package m;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e0 implements q {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* renamed from: a  reason: collision with root package name */
    public final d0 f2735a;

    public e0(d0 d0Var) {
        this.f2735a = d0Var;
    }

    @Override // m.q
    public final p a(Object obj, int i3, int i5, g.h hVar) {
        Uri uri = (Uri) obj;
        return new p(new b0.b(uri), this.f2735a.a(uri));
    }

    @Override // m.q
    public final boolean b(Object obj) {
        return b.contains(((Uri) obj).getScheme());
    }
}
