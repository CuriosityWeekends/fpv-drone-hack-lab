package n2;

import java.util.TimeZone;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f2948a = TimeZone.getTimeZone("UTC");

    public static boolean a(String str, int i3, char c) {
        if (i3 < str.length() && str.charAt(i3) == c) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date b(java.lang.String r18, java.text.ParsePosition r19) {
        /*
            Method dump skipped, instructions count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.a.b(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int c(int i3, int i5, String str) {
        int i6;
        int i7;
        if (i3 >= 0 && i5 <= str.length() && i3 <= i5) {
            if (i3 < i5) {
                i7 = i3 + 1;
                int digit = Character.digit(str.charAt(i3), 10);
                if (digit >= 0) {
                    i6 = -digit;
                } else {
                    throw new NumberFormatException("Invalid number: " + str.substring(i3, i5));
                }
            } else {
                i6 = 0;
                i7 = i3;
            }
            while (i7 < i5) {
                int i8 = i7 + 1;
                int digit2 = Character.digit(str.charAt(i7), 10);
                if (digit2 >= 0) {
                    i6 = (i6 * 10) - digit2;
                    i7 = i8;
                } else {
                    throw new NumberFormatException("Invalid number: " + str.substring(i3, i5));
                }
            }
            return -i6;
        }
        throw new NumberFormatException(str);
    }
}
