package t1;

import s1.i;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class g extends i implements Comparable {

    /* renamed from: g  reason: collision with root package name */
    public long f3680g;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        g gVar = (g) obj;
        if (isEndOfStream() != gVar.isEndOfStream()) {
            if (!isEndOfStream()) {
                return -1;
            }
        } else {
            long j2 = this.c - gVar.c;
            if (j2 == 0) {
                j2 = this.f3680g - gVar.f3680g;
                if (j2 == 0) {
                    return 0;
                }
            }
            if (j2 <= 0) {
                return -1;
            }
        }
        return 1;
    }
}
