package f2;

import java.io.File;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class g implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    public final String f1828a;
    public final long b;
    public final long c;
    public final boolean d;

    /* renamed from: e  reason: collision with root package name */
    public final File f1829e;

    /* renamed from: f  reason: collision with root package name */
    public final long f1830f;

    public g(String str, long j2, long j5, long j6, File file) {
        boolean z3;
        this.f1828a = str;
        this.b = j2;
        this.c = j5;
        if (file != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.d = z3;
        this.f1829e = file;
        this.f1830f = j6;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public final int compareTo(g gVar) {
        String str = gVar.f1828a;
        String str2 = this.f1828a;
        if (!str2.equals(str)) {
            return str2.compareTo(gVar.f1828a);
        }
        int i3 = ((this.b - gVar.b) > 0L ? 1 : ((this.b - gVar.b) == 0L ? 0 : -1));
        if (i3 == 0) {
            return 0;
        }
        if (i3 < 0) {
            return -1;
        }
        return 1;
    }
}
