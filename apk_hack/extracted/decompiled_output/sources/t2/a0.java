package t2;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.lg.picturesubmitt.activity.BaseActivity;
import com.lg.picturesubmitt.activity.FFMPEGPlayActivity;
import com.lg.picturesubmitt.activity.MainActivityRTSP;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class a0 implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3685a;
    public final /* synthetic */ BaseActivity b;

    public /* synthetic */ a0(BaseActivity baseActivity, int i3) {
        this.f3685a = i3;
        this.b = baseActivity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        BaseActivity baseActivity = this.b;
        switch (this.f3685a) {
            case 0:
                int action = motionEvent.getAction();
                MainActivityRTSP mainActivityRTSP = (MainActivityRTSP) baseActivity;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            Log.d("MainActivityRTSP", "ACTION_MOVE");
                        }
                    } else {
                        Log.d("MainActivityRTSP", "ACTION_UP");
                        MainActivityRTSP.m(mainActivityRTSP, false);
                    }
                } else {
                    Log.d("MainActivityRTSP", "ACTION_DOWN");
                    MainActivityRTSP.m(mainActivityRTSP, true);
                }
                return false;
            case 1:
                int action2 = motionEvent.getAction();
                MainActivityRTSP mainActivityRTSP2 = (MainActivityRTSP) baseActivity;
                if (action2 != 0) {
                    if (action2 != 1) {
                        if (action2 == 2) {
                            Log.d("MainActivityRTSP", "ACTION_MOVE");
                        }
                    } else {
                        Log.d("MainActivityRTSP", "ACTION_UP");
                        MainActivityRTSP.l(mainActivityRTSP2, false);
                    }
                } else {
                    Log.d("MainActivityRTSP", "ACTION_DOWN");
                    MainActivityRTSP.l(mainActivityRTSP2, true);
                }
                return false;
            default:
                int i3 = FFMPEGPlayActivity.f549n;
                FFMPEGPlayActivity fFMPEGPlayActivity = (FFMPEGPlayActivity) baseActivity;
                a1.i.u(new StringBuilder("onTouch--"), fFMPEGPlayActivity.f557l, "FFMPEGPlayActivity");
                if (fFMPEGPlayActivity.f557l == 1) {
                    if (fFMPEGPlayActivity.f551f.getVisibility() == 8) {
                        fFMPEGPlayActivity.f558m.sendEmptyMessage(3);
                    } else {
                        fFMPEGPlayActivity.f558m.sendEmptyMessage(2);
                    }
                } else {
                    fFMPEGPlayActivity.f558m.sendEmptyMessage(3);
                }
                return false;
        }
    }
}
