package h2;

import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2034a;
    public final /* synthetic */ c1.b b;
    public final /* synthetic */ m0.c c;

    public /* synthetic */ q(c1.b bVar, m0.c cVar, int i3) {
        this.f2034a = i3;
        this.b = bVar;
        this.c = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2034a) {
            case 0:
                c1.b bVar = this.b;
                m0.c cVar = this.c;
                bVar.getClass();
                synchronized (cVar) {
                }
                int i3 = w.f1960a;
                ((s) bVar.c).onVideoDisabled(cVar);
                return;
            default:
                c1.b bVar2 = this.b;
                bVar2.getClass();
                int i5 = w.f1960a;
                ((s) bVar2.c).onVideoEnabled(this.c);
                return;
        }
    }
}
