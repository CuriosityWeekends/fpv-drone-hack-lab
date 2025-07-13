package l3;

import com.shuyu.gsyvideoplayer.utils.Debuger;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2711a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ d d;

    public /* synthetic */ c(d dVar, int i3, int i5, int i6) {
        this.f2711a = i6;
        this.d = dVar;
        this.b = i3;
        this.c = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2711a) {
            case 0:
                d dVar = this.d;
                dVar.getClass();
                Debuger.printfError("cancelTimeOutBuffer");
                if (dVar.listener() != null) {
                    dVar.listener().onError(this.b, this.c);
                    return;
                }
                return;
            default:
                d dVar2 = this.d;
                dVar2.getClass();
                if (dVar2.listener() != null) {
                    dVar2.listener().onInfo(this.b, this.c);
                    return;
                }
                return;
        }
    }
}
