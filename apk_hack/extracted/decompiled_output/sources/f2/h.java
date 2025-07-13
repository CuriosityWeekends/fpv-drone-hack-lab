package f2;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final a1.f f1831a = new a1.f(4);

    public static void a(b bVar, String str) {
        q qVar = (q) bVar;
        for (g gVar : qVar.f(str)) {
            try {
                synchronized (qVar) {
                    g2.b.h(!qVar.f1851h);
                    qVar.l(gVar);
                }
            } catch (a unused) {
            }
        }
    }
}
