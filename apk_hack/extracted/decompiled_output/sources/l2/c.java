package l2;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements WildcardType, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a  reason: collision with root package name */
    public final Type f2687a;
    public final Type b;

    public c(Type[] typeArr, Type[] typeArr2) {
        boolean z3;
        boolean z5;
        if (typeArr2.length <= 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        d.c(z3);
        if (typeArr.length == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        d.c(z5);
        if (typeArr2.length == 1) {
            typeArr2[0].getClass();
            d.d(typeArr2[0]);
            d.c(typeArr[0] == Object.class);
            this.b = d.b(typeArr2[0]);
            this.f2687a = Object.class;
            return;
        }
        typeArr[0].getClass();
        d.d(typeArr[0]);
        this.b = null;
        this.f2687a = d.b(typeArr[0]);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof WildcardType) && d.e(this, (WildcardType) obj)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.b;
        return type != null ? new Type[]{type} : d.f2688a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f2687a};
    }

    public final int hashCode() {
        int i3;
        Type type = this.b;
        if (type != null) {
            i3 = type.hashCode() + 31;
        } else {
            i3 = 1;
        }
        return i3 ^ (this.f2687a.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.b;
        if (type != null) {
            return "? super " + d.j(type);
        }
        Type type2 = this.f2687a;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + d.j(type2);
    }
}
