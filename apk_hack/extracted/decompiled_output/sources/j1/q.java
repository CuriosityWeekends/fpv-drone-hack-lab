package j1;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2457a;
    public final /* synthetic */ u b;
    public final /* synthetic */ x c;
    public final /* synthetic */ Object d;

    public /* synthetic */ q(u uVar, x xVar, Object obj, int i3) {
        this.f2457a = i3;
        this.b = uVar;
        this.c = xVar;
        this.d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2457a) {
            case 0:
                this.c.onMediaPeriodReleased(this.b.f2464a, (n) this.d);
                return;
            case 1:
                this.c.onReadingStarted(this.b.f2464a, (n) this.d);
                return;
            case 2:
                this.c.onMediaPeriodCreated(this.b.f2464a, (n) this.d);
                return;
            default:
                u uVar = this.b;
                this.c.onDownstreamFormatChanged(uVar.f2464a, uVar.b, (w) this.d);
                return;
        }
    }
}
