package l2;

import java.math.BigDecimal;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g extends Number {

    /* renamed from: a  reason: collision with root package name */
    public final String f2692a;

    public g(String str) {
        this.f2692a = str;
    }

    private Object writeReplace() {
        return new BigDecimal(this.f2692a);
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f2692a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        String str = ((g) obj).f2692a;
        String str2 = this.f2692a;
        if (str2 == str || str2.equals(str)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f2692a);
    }

    public final int hashCode() {
        return this.f2692a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f2692a;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f2692a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return new BigDecimal(str).longValue();
        }
    }

    public final String toString() {
        return this.f2692a;
    }
}
