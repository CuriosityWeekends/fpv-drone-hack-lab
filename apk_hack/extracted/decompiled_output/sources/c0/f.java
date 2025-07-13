package c0;

import java.util.concurrent.Executor;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f191a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f191a) {
            case 0:
                n.e().post(runnable);
                return;
            default:
                runnable.run();
                return;
        }
    }
}
