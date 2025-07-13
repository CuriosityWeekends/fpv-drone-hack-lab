package j0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a extends BroadcastReceiver implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final p0 f2204a;
    public final Handler b;
    public final /* synthetic */ b c;

    public a(b bVar, Handler handler, p0 p0Var) {
        this.c = bVar;
        this.b = handler;
        this.f2204a = p0Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.b.post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c.b) {
            this.f2204a.f2282a.c(false);
        }
    }
}
