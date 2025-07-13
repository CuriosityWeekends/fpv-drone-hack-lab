package f2;

import java.util.Comparator;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class n implements Comparator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1843a;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f1843a) {
            case 0:
                g gVar = (g) obj;
                g gVar2 = (g) obj2;
                long j2 = gVar.f1830f;
                long j5 = gVar2.f1830f;
                if (j2 - j5 == 0) {
                    return gVar.compareTo(gVar2);
                }
                if (j2 < j5) {
                    return -1;
                }
                return 1;
            case 1:
                return ((g2.q) obj).f1948a - ((g2.q) obj2).f1948a;
            default:
                return Float.compare(((g2.q) obj).c, ((g2.q) obj2).c);
        }
    }
}
