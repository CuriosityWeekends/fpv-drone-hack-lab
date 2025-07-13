package pl.droidsonroids.gif;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b extends s {
    public final /* synthetic */ int b;
    public final /* synthetic */ c c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, c cVar2, int i3) {
        super(cVar2);
        this.c = cVar;
        this.b = i3;
    }

    @Override // pl.droidsonroids.gif.s
    public final void a() {
        c cVar = this.c;
        cVar.f3285g.u(cVar.f3284f, this.b);
        this.f3310a.f3291m.sendEmptyMessageAtTime(-1, 0L);
    }
}
