package a2;

import java.util.regex.Pattern;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a {
    public static final Pattern c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: a  reason: collision with root package name */
    public final c0.b f49a = new c0.b();
    public final StringBuilder b = new StringBuilder();

    public static String a(c0.b bVar, StringBuilder sb) {
        boolean z3 = false;
        sb.setLength(0);
        int i3 = bVar.b;
        int i5 = bVar.c;
        while (i3 < i5 && !z3) {
            char c5 = (char) bVar.f187a[i3];
            if ((c5 < 'A' || c5 > 'Z') && ((c5 < 'a' || c5 > 'z') && ((c5 < '0' || c5 > '9') && c5 != '#' && c5 != '-' && c5 != '.' && c5 != '_'))) {
                z3 = true;
            } else {
                i3++;
                sb.append(c5);
            }
        }
        bVar.z(i3 - bVar.b);
        return sb.toString();
    }

    public static String b(c0.b bVar, StringBuilder sb) {
        c(bVar);
        if (bVar.a() == 0) {
            return null;
        }
        String a5 = a(bVar, sb);
        if (!"".equals(a5)) {
            return a5;
        }
        return "" + ((char) bVar.n());
    }

    public static void c(c0.b bVar) {
        while (true) {
            for (boolean z3 = true; bVar.a() > 0 && z3; z3 = false) {
                int i3 = bVar.b;
                byte[] bArr = bVar.f187a;
                byte b = bArr[i3];
                char c5 = (char) b;
                if (c5 != '\t' && c5 != '\n' && c5 != '\f' && c5 != '\r' && c5 != ' ') {
                    int i5 = bVar.c;
                    int i6 = i3 + 2;
                    if (i6 <= i5) {
                        int i7 = i3 + 1;
                        if (b == 47 && bArr[i7] == 42) {
                            while (true) {
                                int i8 = i6 + 1;
                                if (i8 >= i5) {
                                    break;
                                } else if (((char) bArr[i6]) == '*' && ((char) bArr[i8]) == '/') {
                                    i6 += 2;
                                    i5 = i6;
                                } else {
                                    i6 = i8;
                                }
                            }
                            bVar.z(i5 - bVar.b);
                        }
                    }
                } else {
                    bVar.z(1);
                }
            }
            return;
        }
    }
}
