package x1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import s1.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends c {

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f3960p = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*");
    public static final Pattern q = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: n  reason: collision with root package name */
    public final StringBuilder f3961n = new StringBuilder();

    /* renamed from: o  reason: collision with root package name */
    public final ArrayList f3962o = new ArrayList();

    public static long i(Matcher matcher, int i3) {
        long parseLong = (Long.parseLong(matcher.group(i3 + 2)) * 60000) + (Long.parseLong(matcher.group(i3 + 1)) * 3600000);
        return (Long.parseLong(matcher.group(i3 + 4)) + (Long.parseLong(matcher.group(i3 + 3)) * 1000) + parseLong) * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x024f, code lost:
        r0 = new s1.b[r2.size()];
        r2.toArray(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0264, code lost:
        return new c1.b(24, r0, java.util.Arrays.copyOf(r3, r6), false);
     */
    @Override // s1.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final s1.e e(byte[] r23, int r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 690
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.a.e(byte[], int, boolean):s1.e");
    }
}
