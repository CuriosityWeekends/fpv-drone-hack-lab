package a1;

import android.text.TextUtils;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final String f38a;
    public final boolean b;
    public final boolean c;

    public j(String str, boolean z3, boolean z5) {
        this.f38a = str;
        this.b = z3;
        this.c = z5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != j.class) {
            return false;
        }
        j jVar = (j) obj;
        if (TextUtils.equals(this.f38a, jVar.f38a) && this.b == jVar.b && this.c == jVar.c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        int hashCode = (this.f38a.hashCode() + 31) * 31;
        int i5 = 1237;
        if (this.b) {
            i3 = 1231;
        } else {
            i3 = 1237;
        }
        int i6 = (hashCode + i3) * 31;
        if (this.c) {
            i5 = 1231;
        }
        return i6 + i5;
    }
}
