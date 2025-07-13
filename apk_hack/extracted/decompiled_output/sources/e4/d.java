package e4;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public abstract class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f1756a;

    public d(h hVar) {
        this.f1756a = hVar;
    }

    public abstract void a(a aVar);

    @Override // java.lang.Runnable
    public final void run() {
        for (a aVar : (a[]) this.f1756a.f1761f.toArray(new a[0])) {
            a(aVar);
        }
    }
}
