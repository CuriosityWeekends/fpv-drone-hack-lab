package w1;

import a1.i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f3943a;
    public final int b;

    public d(String str, int i3) {
        this.f3943a = str;
        this.b = i3;
    }

    public static int a(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            switch (parseInt) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        i.t("Ignoring unknown alignment: ", str, "SsaStyle");
        return -1;
    }
}
