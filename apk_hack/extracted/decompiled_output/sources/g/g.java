package g;

import android.text.TextUtils;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g {

    /* renamed from: e  reason: collision with root package name */
    public static final j3.b f1897e = new j3.b(4);

    /* renamed from: a  reason: collision with root package name */
    public final Object f1898a;
    public final f b;
    public final String c;
    public volatile byte[] d;

    public g(String str, Object obj, f fVar) {
        if (!TextUtils.isEmpty(str)) {
            this.c = str;
            this.f1898a = obj;
            this.b = fVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static g a(Object obj, String str) {
        return new g(str, obj, f1897e);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.c.equals(((g) obj).c);
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final String toString() {
        return a1.i.k(new StringBuilder("Option{key='"), this.c, "'}");
    }
}
