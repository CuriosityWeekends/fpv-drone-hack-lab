package n1;

import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final String f2930a;
    public final String b;
    public final String c;
    public final String d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2931e;

    public h(String str, String str2, String str3, String str4, String str5) {
        this.f2930a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.f2931e = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (w.a(this.f2930a, hVar.f2930a) && w.a(this.b, hVar.b) && w.a(this.c, hVar.c) && w.a(this.d, hVar.d) && w.a(this.f2931e, hVar.f2931e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i3;
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        String str = this.f2930a;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i9 = (527 + i3) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i5 = str2.hashCode();
        } else {
            i5 = 0;
        }
        int i10 = (i9 + i5) * 31;
        String str3 = this.c;
        if (str3 != null) {
            i6 = str3.hashCode();
        } else {
            i6 = 0;
        }
        int i11 = (i10 + i6) * 31;
        String str4 = this.d;
        if (str4 != null) {
            i7 = str4.hashCode();
        } else {
            i7 = 0;
        }
        int i12 = (i11 + i7) * 31;
        String str5 = this.f2931e;
        if (str5 != null) {
            i8 = str5.hashCode();
        }
        return i12 + i8;
    }
}
