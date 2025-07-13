package e;

import java.io.File;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f1651a;
    public final long[] b;
    public final File[] c;
    public final File[] d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1652e;

    /* renamed from: f  reason: collision with root package name */
    public c f1653f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ e f1654g;

    public d(e eVar, String str) {
        this.f1654g = eVar;
        this.f1651a = str;
        int i3 = eVar.f1658g;
        this.b = new long[i3];
        this.c = new File[i3];
        this.d = new File[i3];
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i5 = 0; i5 < eVar.f1658g; i5++) {
            sb.append(i5);
            File[] fileArr = this.c;
            String sb2 = sb.toString();
            File file = eVar.f1655a;
            fileArr[i5] = new File(file, sb2);
            sb.append(".tmp");
            this.d[i5] = new File(file, sb.toString());
            sb.setLength(length);
        }
    }

    public final String a() {
        long[] jArr;
        StringBuilder sb = new StringBuilder();
        for (long j2 : this.b) {
            sb.append(' ');
            sb.append(j2);
        }
        return sb.toString();
    }
}
