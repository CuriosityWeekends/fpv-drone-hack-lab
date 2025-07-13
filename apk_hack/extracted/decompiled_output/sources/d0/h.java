package d0;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f1599a;

    public synchronized void a() {
        while (!this.f1599a) {
            wait();
        }
    }

    public synchronized void b() {
        this.f1599a = false;
    }

    public synchronized void c() {
        boolean z3 = this.f1599a;
        this.f1599a = true;
        if (!z3) {
            notify();
        }
    }

    public void d() {
        if (!this.f1599a) {
            return;
        }
        throw new IllegalStateException("Already released");
    }
}
