package b2;

import android.text.TextUtils;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f142a;
    public final int b;
    public final String c;

    public e(int i3, int i5, String str) {
        this.f142a = i3;
        this.b = i5;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f142a == eVar.f142a && this.b == eVar.b && TextUtils.equals(this.c, eVar.c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        int i5 = ((this.f142a * 31) + this.b) * 31;
        String str = this.c;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return i5 + i3;
    }
}
