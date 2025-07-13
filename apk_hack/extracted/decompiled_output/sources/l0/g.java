package l0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2536a;
    public final /* synthetic */ c1.b b;
    public final /* synthetic */ m0.c c;

    public /* synthetic */ g(c1.b bVar, m0.c cVar, int i3) {
        this.f2536a = i3;
        this.b = bVar;
        this.c = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2536a) {
            case 0:
                c1.b bVar = this.b;
                bVar.getClass();
                int i3 = g2.w.f1960a;
                ((i) bVar.c).onAudioEnabled(this.c);
                return;
            default:
                c1.b bVar2 = this.b;
                m0.c cVar = this.c;
                bVar2.getClass();
                synchronized (cVar) {
                }
                int i5 = g2.w.f1960a;
                ((i) bVar2.c).onAudioDisabled(cVar);
                return;
        }
    }
}
