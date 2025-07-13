package i;

import android.os.Handler;
import android.os.Message;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class j0 implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            ((g0) message.obj).recycle();
            return true;
        }
        return false;
    }
}
