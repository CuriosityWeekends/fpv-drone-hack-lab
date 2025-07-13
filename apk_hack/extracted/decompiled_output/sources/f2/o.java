package f2;

import java.util.TreeSet;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final TreeSet f1844a = new TreeSet(new n(0));
    public long b;

    public final void a(b bVar, long j2) {
        while (this.b + j2 > IjkMediaMeta.AV_CH_STEREO_LEFT) {
            TreeSet treeSet = this.f1844a;
            if (!treeSet.isEmpty()) {
                try {
                    g gVar = (g) treeSet.first();
                    q qVar = (q) bVar;
                    synchronized (qVar) {
                        g2.b.h(!qVar.f1851h);
                        qVar.l(gVar);
                    }
                } catch (a unused) {
                }
            } else {
                return;
            }
        }
    }

    public final void b(b bVar, g gVar) {
        this.f1844a.add(gVar);
        this.b += gVar.c;
        a(bVar, 0L);
    }
}
