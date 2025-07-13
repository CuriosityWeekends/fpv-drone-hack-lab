package l2;

import java.lang.reflect.Method;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o extends d {
    public final /* synthetic */ Method b;
    public final /* synthetic */ int c;

    public o(int i3, Method method) {
        this.b = method;
        this.c = i3;
    }

    @Override // l2.d
    public final Object h(Class cls) {
        d.a(cls);
        return this.b.invoke(null, cls, Integer.valueOf(this.c));
    }
}
