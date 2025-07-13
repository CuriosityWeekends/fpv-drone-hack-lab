package t2;

import android.view.View;
import com.lg.picturesubmitt.activity.FFMPEGPlayActivity;
import java.util.TimerTask;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3686a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(int i3, Object obj) {
        this.f3686a = i3;
        this.b = obj;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Object obj = this.b;
        switch (this.f3686a) {
            case 0:
                FFMPEGPlayActivity fFMPEGPlayActivity = (FFMPEGPlayActivity) obj;
                fFMPEGPlayActivity.f557l = fFMPEGPlayActivity.f550e.getStatus();
                int i3 = FFMPEGPlayActivity.f549n;
                a1.i.u(new StringBuilder("timer:isPlaying="), fFMPEGPlayActivity.f557l, "FFMPEGPlayActivity");
                if (fFMPEGPlayActivity.f557l == 4) {
                    fFMPEGPlayActivity.f558m.sendEmptyMessage(1);
                    return;
                }
                return;
            default:
                ((View) ((com.lxj.xpopup.util.e) ((com.tencent.bugly.proguard.d0) obj).c).c).post(new b3.d(19, this));
                return;
        }
    }
}
