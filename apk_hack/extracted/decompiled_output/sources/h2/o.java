package h2;

import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c1.b f2031a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ float f2032e;

    public /* synthetic */ o(c1.b bVar, int i3, int i5, int i6, float f4) {
        this.f2031a = bVar;
        this.b = i3;
        this.c = i5;
        this.d = i6;
        this.f2032e = f4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c1.b bVar = this.f2031a;
        bVar.getClass();
        int i3 = w.f1960a;
        ((s) bVar.c).onVideoSizeChanged(this.b, this.c, this.d, this.f2032e);
    }
}
