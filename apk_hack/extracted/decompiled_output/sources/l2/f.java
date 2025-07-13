package l2;

import com.google.gson.s;
import com.google.gson.t;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements t, Cloneable {
    public static final f c;

    /* renamed from: a  reason: collision with root package name */
    public List f2691a;
    public List b;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, l2.f] */
    static {
        ?? obj = new Object();
        obj.f2691a = Collections.emptyList();
        obj.b = Collections.emptyList();
        c = obj;
    }

    @Override // com.google.gson.t
    public final s a(com.google.gson.j jVar, o2.a aVar) {
        Class cls = aVar.f3050a;
        boolean b = b(cls, true);
        boolean b5 = b(cls, false);
        if (!b && !b5) {
            return null;
        }
        return new e(this, b5, b, jVar, aVar);
    }

    public final boolean b(Class cls, boolean z3) {
        List list;
        if (!Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return true;
        }
        if (z3) {
            list = this.f2691a;
        } else {
            list = this.b;
        }
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        com.bumptech.glide.i.a(it.next());
        throw null;
    }

    public final Object clone() {
        try {
            return (f) super.clone();
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }
}
