package f2;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.view.SurfaceHolder;
import com.lg.picturesubmitt.MjpegView;
import l0.u;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class p extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1845a = 2;
    public final Object b;
    public final /* synthetic */ Object c;

    public p(MjpegView mjpegView, SurfaceHolder surfaceHolder) {
        this.c = mjpegView;
        this.b = surfaceHolder;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        switch (this.f1845a) {
            case 0:
                synchronized (((q) this.c)) {
                    ((ConditionVariable) this.b).open();
                    q.a((q) this.c);
                    ((q) this.c).b.getClass();
                }
                return;
            case 1:
                u uVar = (u) this.c;
                AudioTrack audioTrack = (AudioTrack) this.b;
                try {
                    audioTrack.flush();
                    audioTrack.release();
                    return;
                } finally {
                    uVar.f2580g.open();
                }
            default:
                System.currentTimeMillis();
                new PorterDuffXfermode(PorterDuff.Mode.DST_OVER);
                new Paint();
                ((MjpegView) this.c).getClass();
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(q qVar, ConditionVariable conditionVariable) {
        super("SimpleCache.initialize()");
        this.c = qVar;
        this.b = conditionVariable;
    }

    public p(u uVar, AudioTrack audioTrack) {
        this.c = uVar;
        this.b = audioTrack;
    }
}
