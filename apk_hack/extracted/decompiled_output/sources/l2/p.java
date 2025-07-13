package l2;

import java.lang.reflect.Method;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p extends d {
    public final /* synthetic */ Method b;

    public p(Method method) {
        this.b = method;
    }

    @Override // l2.d
    public final Object h(Class cls) {
        d.a(cls);
        return this.b.invoke(null, cls, Object.class);
    }
}
