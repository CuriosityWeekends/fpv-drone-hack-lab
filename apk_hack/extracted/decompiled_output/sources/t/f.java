package t;

import android.os.Handler;
import android.os.Message;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class f implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f3556a;

    public f(g gVar) {
        this.f3556a = gVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i3 = message.what;
        g gVar = this.f3556a;
        if (i3 == 1) {
            gVar.b((d) message.obj);
            return true;
        } else if (i3 == 2) {
            gVar.d.j((d) message.obj);
            return false;
        } else {
            return false;
        }
    }
}
