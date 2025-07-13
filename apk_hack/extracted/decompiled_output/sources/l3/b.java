package l3;

import com.shuyu.gsyvideoplayer.utils.Debuger;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f2710a;
    public final /* synthetic */ d b;

    public /* synthetic */ b(d dVar, int i3) {
        this.f2710a = i3;
        this.b = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2710a) {
            case 0:
                d dVar = this.b;
                dVar.getClass();
                Debuger.printfError("cancelTimeOutBuffer");
                if (dVar.listener() != null) {
                    dVar.listener().onPrepared();
                    return;
                }
                return;
            case 1:
                d dVar2 = this.b;
                dVar2.getClass();
                Debuger.printfError("cancelTimeOutBuffer");
                if (dVar2.listener() != null) {
                    dVar2.listener().onAutoCompletion();
                    return;
                }
                return;
            case 2:
                d dVar3 = this.b;
                dVar3.getClass();
                Debuger.printfError("cancelTimeOutBuffer");
                if (dVar3.listener() != null) {
                    dVar3.listener().onSeekComplete();
                    return;
                }
                return;
            case 3:
                d dVar4 = this.b;
                if (dVar4.listener() != null) {
                    dVar4.listener().onVideoSizeChanged();
                    return;
                }
                return;
            default:
                d dVar5 = this.b;
                if (dVar5.d != null) {
                    Debuger.printfError("time out for error listener");
                    dVar5.listener().onError(-192, -192);
                    return;
                }
                return;
        }
    }
}
