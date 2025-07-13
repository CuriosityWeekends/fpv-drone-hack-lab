package a2;

import g2.w;
import java.io.IOException;
import java.util.regex.Pattern;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f80a = Pattern.compile("^NOTE([ \t].*)?$");

    public static boolean a(c0.b bVar) {
        String d = bVar.d();
        if (d != null && d.startsWith("WEBVTT")) {
            return true;
        }
        return false;
    }

    public static float b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long c(String str) {
        int i3 = w.f1960a;
        String[] split = str.split("\\.", 2);
        long j2 = 0;
        for (String str2 : split[0].split(":", -1)) {
            j2 = (j2 * 60) + Long.parseLong(str2);
        }
        long j5 = j2 * 1000;
        if (split.length == 2) {
            j5 += Long.parseLong(split[1]);
        }
        return j5 * 1000;
    }

    public static void d(c0.b bVar) {
        int i3 = bVar.b;
        if (a(bVar)) {
            return;
        }
        bVar.y(i3);
        throw new IOException("Expected WEBVTT. Got " + bVar.d());
    }
}
