package j1;

import java.io.IOException;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface x {
    void onDownstreamFormatChanged(int i3, n nVar, w wVar);

    void onLoadCanceled(int i3, n nVar, v vVar, w wVar);

    void onLoadCompleted(int i3, n nVar, v vVar, w wVar);

    void onLoadError(int i3, n nVar, v vVar, w wVar, IOException iOException, boolean z3);

    void onLoadStarted(int i3, n nVar, v vVar, w wVar);

    void onMediaPeriodCreated(int i3, n nVar);

    void onMediaPeriodReleased(int i3, n nVar);

    void onReadingStarted(int i3, n nVar);

    void onUpstreamDiscarded(int i3, n nVar, w wVar);
}
