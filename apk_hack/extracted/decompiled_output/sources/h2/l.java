package h2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import g2.w;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class l implements Choreographer.FrameCallback, Handler.Callback {

    /* renamed from: e  reason: collision with root package name */
    public static final l f2020e = new l();

    /* renamed from: a  reason: collision with root package name */
    public volatile long f2021a = -9223372036854775807L;
    public final Handler b;
    public Choreographer c;
    public int d;

    public l() {
        HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        int i3 = w.f1960a;
        Handler handler = new Handler(looper, this);
        this.b = handler;
        handler.sendEmptyMessage(0);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j2) {
        this.f2021a = j2;
        this.c.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return false;
                }
                int i5 = this.d - 1;
                this.d = i5;
                if (i5 == 0) {
                    this.c.removeFrameCallback(this);
                    this.f2021a = -9223372036854775807L;
                }
                return true;
            }
            int i6 = this.d + 1;
            this.d = i6;
            if (i6 == 1) {
                this.c.postFrameCallback(this);
            }
            return true;
        }
        this.c = Choreographer.getInstance();
        return true;
    }
}
