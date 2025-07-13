package n1;

import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f2927a;
    public final String b;
    public final String c;

    public e(String str, String str2, String str3) {
        this.f2927a = str;
        this.b = str2;
        this.c = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (w.a(this.f2927a, eVar.f2927a) && w.a(this.b, eVar.b) && w.a(this.c, eVar.c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        int hashCode = this.f2927a.hashCode() * 31;
        int i5 = 0;
        String str = this.b;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (hashCode + i3) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i5 = str2.hashCode();
        }
        return i6 + i5;
    }
}
