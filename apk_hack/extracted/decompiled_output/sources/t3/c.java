package t3;

import android.view.Surface;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public interface c {
    void onSurfaceAvailable(Surface surface);

    boolean onSurfaceDestroyed(Surface surface);

    void onSurfaceSizeChanged(Surface surface, int i3, int i5);

    void onSurfaceUpdated(Surface surface);
}
