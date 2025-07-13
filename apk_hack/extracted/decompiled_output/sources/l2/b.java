package l2;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements ParameterizedType, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a  reason: collision with root package name */
    public final Type f2686a;
    public final Type b;
    public final Type[] c;

    public b(Type type, Type type2, Type... typeArr) {
        Type b;
        boolean z3;
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            boolean z5 = true;
            if (!Modifier.isStatic(cls.getModifiers()) && cls.getEnclosingClass() != null) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (type == null && !z3) {
                z5 = false;
            }
            d.c(z5);
        }
        if (type == null) {
            b = null;
        } else {
            b = d.b(type);
        }
        this.f2686a = b;
        this.b = d.b(type2);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.c = typeArr2;
        int length = typeArr2.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.c[i3].getClass();
            d.d(this.c[i3]);
            Type[] typeArr3 = this.c;
            typeArr3[i3] = d.b(typeArr3[i3]);
        }
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ParameterizedType) && d.e(this, (ParameterizedType) obj)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.c.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f2686a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.b;
    }

    public final int hashCode() {
        int i3;
        int hashCode = Arrays.hashCode(this.c) ^ this.b.hashCode();
        Type type = this.f2686a;
        if (type != null) {
            i3 = type.hashCode();
        } else {
            i3 = 0;
        }
        return hashCode ^ i3;
    }

    public final String toString() {
        Type[] typeArr = this.c;
        int length = typeArr.length;
        Type type = this.b;
        if (length == 0) {
            return d.j(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(d.j(type));
        sb.append("<");
        sb.append(d.j(typeArr[0]));
        for (int i3 = 1; i3 < length; i3++) {
            sb.append(", ");
            sb.append(d.j(typeArr[i3]));
        }
        sb.append(">");
        return sb.toString();
    }
}
