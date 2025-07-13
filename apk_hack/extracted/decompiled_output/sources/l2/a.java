package l2;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a  reason: collision with root package name */
    public final Type f2685a;

    public a(Type type) {
        this.f2685a = d.b(type);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof GenericArrayType) && d.e(this, (GenericArrayType) obj)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f2685a;
    }

    public final int hashCode() {
        return this.f2685a.hashCode();
    }

    public final String toString() {
        return d.j(this.f2685a) + "[]";
    }
}
