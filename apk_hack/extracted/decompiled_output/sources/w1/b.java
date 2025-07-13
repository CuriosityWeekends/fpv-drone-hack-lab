package w1;

import android.text.TextUtils;
import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final int f3940a;
    public final int b;
    public final int c;
    public final int d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3941e;

    public b(int i3, int i5, int i6, int i7, int i8) {
        this.f3940a = i3;
        this.b = i5;
        this.c = i6;
        this.d = i7;
        this.f3941e = i8;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static b a(String str) {
        char c;
        g2.b.e(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), ",");
        int i3 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        for (int i8 = 0; i8 < split.length; i8++) {
            String E = w.E(split[i8].trim());
            E.getClass();
            switch (E.hashCode()) {
                case 100571:
                    if (E.equals("end")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3556653:
                    if (E.equals("text")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 109757538:
                    if (E.equals("start")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 109780401:
                    if (E.equals("style")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    i5 = i8;
                    break;
                case 1:
                    i7 = i8;
                    break;
                case 2:
                    i3 = i8;
                    break;
                case 3:
                    i6 = i8;
                    break;
            }
        }
        if (i3 != -1 && i5 != -1) {
            return new b(i3, i5, i6, i7, split.length);
        }
        return null;
    }
}
