package f2;

import java.io.File;
import java.util.regex.Pattern;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class r extends g {

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f1853g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f1854h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: i  reason: collision with root package name */
    public static final Pattern f1855i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0083, code lost:
        if (r1 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bf, code lost:
        if (r16.renameTo(r1) == false) goto L29;
     */
    /* JADX WARN: Type inference failed for: r0v7, types: [f2.g, f2.r] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static f2.r b(java.io.File r16, long r17, f2.k r19) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.r.b(java.io.File, long, f2.k):f2.r");
    }

    public static File c(File file, int i3, long j2, long j5) {
        return new File(file, i3 + "." + j2 + "." + j5 + ".v3.exo");
    }
}
