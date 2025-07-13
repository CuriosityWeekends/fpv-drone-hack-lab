package com.google.gson;

import java.math.BigInteger;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class q extends l {
    public static final Class[] b = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: a  reason: collision with root package name */
    public Object f512a;

    public static boolean c(q qVar) {
        Object obj = qVar.f512a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if (!(number instanceof BigInteger) && !(number instanceof Long) && !(number instanceof Integer) && !(number instanceof Short) && !(number instanceof Byte)) {
            return false;
        }
        return true;
    }

    public final Number a() {
        Object obj = this.f512a;
        if (obj instanceof String) {
            return new l2.g((String) obj);
        }
        return (Number) obj;
    }

    public final String b() {
        Object obj = this.f512a;
        if (obj instanceof Number) {
            return a().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        return (String) obj;
    }

    public final void d(Object obj) {
        boolean z3;
        if (obj instanceof Character) {
            this.f512a = String.valueOf(((Character) obj).charValue());
            return;
        }
        if (!(obj instanceof Number) && !(obj instanceof String)) {
            Class<?> cls = obj.getClass();
            Class[] clsArr = b;
            z3 = false;
            for (int i3 = 0; i3 < 16; i3++) {
                if (!clsArr[i3].isAssignableFrom(cls)) {
                }
            }
            l2.d.c(z3);
            this.f512a = obj;
        }
        z3 = true;
        l2.d.c(z3);
        this.f512a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f512a == null) {
            if (qVar.f512a == null) {
                return true;
            }
            return false;
        } else if (c(this) && c(qVar)) {
            if (a().longValue() == qVar.a().longValue()) {
                return true;
            }
            return false;
        } else {
            Object obj2 = this.f512a;
            if ((obj2 instanceof Number) && (qVar.f512a instanceof Number)) {
                double doubleValue = a().doubleValue();
                double doubleValue2 = qVar.a().doubleValue();
                if (doubleValue == doubleValue2) {
                    return true;
                }
                if (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2)) {
                    return true;
                }
                return false;
            }
            return obj2.equals(qVar.f512a);
        }
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (this.f512a == null) {
            return 31;
        }
        if (c(this)) {
            doubleToLongBits = a().longValue();
        } else {
            Object obj = this.f512a;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(a().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }
}
