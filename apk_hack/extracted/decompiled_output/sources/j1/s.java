package j1;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2461a;
    public final /* synthetic */ u b;
    public final /* synthetic */ x c;
    public final /* synthetic */ Object d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ w f2462e;

    public /* synthetic */ s(u uVar, x xVar, Object obj, w wVar, int i3) {
        this.f2461a = i3;
        this.b = uVar;
        this.c = xVar;
        this.d = obj;
        this.f2462e = wVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2461a) {
            case 0:
                u uVar = this.b;
                this.c.onLoadCompleted(uVar.f2464a, uVar.b, (v) this.d, this.f2462e);
                return;
            case 1:
                u uVar2 = this.b;
                this.c.onLoadStarted(uVar2.f2464a, uVar2.b, (v) this.d, this.f2462e);
                return;
            case 2:
                u uVar3 = this.b;
                this.c.onLoadCanceled(uVar3.f2464a, uVar3.b, (v) this.d, this.f2462e);
                return;
            default:
                this.c.onUpstreamDiscarded(this.b.f2464a, (n) this.d, this.f2462e);
                return;
        }
    }
}
