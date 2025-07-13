package l2;

import java.lang.reflect.Method;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class n extends d {
    public final /* synthetic */ Method b;
    public final /* synthetic */ Object c;

    public n(Method method, Object obj) {
        this.b = method;
        this.c = obj;
    }

    @Override // l2.d
    public final Object h(Class cls) {
        d.a(cls);
        return this.b.invoke(this.c, cls);
    }
}
