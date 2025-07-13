package t2;

import android.content.Intent;
import android.util.Log;
import com.lg.picturesubmitt.activity.FileDirActivity;
import com.lg.picturesubmitt.activity.MainActivityRTSP;
import com.lg.picturesubmitt.activity.MusicActivity;
import com.lg.picturesubmitt.rtsp.JNIHandleInterface;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class c0 implements JNIHandleInterface, e3.b, d4.f, r2.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3687a;
    public final /* synthetic */ MainActivityRTSP b;

    public /* synthetic */ c0(MainActivityRTSP mainActivityRTSP, int i3) {
        this.f3687a = i3;
        this.b = mainActivityRTSP;
    }

    @Override // com.lg.picturesubmitt.rtsp.JNIHandleInterface
    public void PicAndVideo(int i3, int i5, int i6) {
        a1.i.u(a1.i.n("拍照esseninfor.DC=", i3, "摄像esseninfor.DV=", i5, "长度="), i6, "MainActivityRTSP");
        MainActivityRTSP mainActivityRTSP = this.b;
        if (i3 == 1 && mainActivityRTSP.d1 == 0) {
            mainActivityRTSP.f761g1.sendEmptyMessage(8);
        }
        mainActivityRTSP.d1 = i3;
        if (i5 == 1 && mainActivityRTSP.f755e1 == 0) {
            mainActivityRTSP.f761g1.sendEmptyMessage(9);
        }
        mainActivityRTSP.f755e1 = i5;
    }

    @Override // e3.b
    public void b() {
        switch (this.f3687a) {
            case 1:
                if (this.b.f763h0) {
                    this.b.D.performClick();
                }
                this.b.o();
                return;
            case 2:
            case 4:
            default:
                if (this.b.f763h0) {
                    this.b.D.performClick();
                }
                MainActivityRTSP mainActivityRTSP = this.b;
                mainActivityRTSP.getClass();
                mainActivityRTSP.startActivity(new Intent(mainActivityRTSP, FileDirActivity.class));
                return;
            case 3:
                if (this.b.f763h0) {
                    this.b.D.performClick();
                }
                this.b.startActivityForResult(new Intent(this.b, MusicActivity.class), 1);
                return;
            case 5:
                if (this.b.f763h0) {
                    this.b.D.performClick();
                }
                this.b.o();
                return;
        }
    }

    @Override // r2.a
    public void c(float f4, float f5) {
        float f6 = ((f4 / 100.0f) * 4.0f) + 1.0f;
        Log.d("MainActivityRTSP", "onRangeChanged--leftValue=" + f6 + "  rightValue=" + f5);
        this.b.f750c0.setScaleValue(f6);
    }

    @Override // d4.f
    public void d(int i3) {
        a1.i.x("sensitive--sensitive=", i3, "MainActivityRTSP");
        this.b.f775l1 = i3;
    }

    @Override // com.lg.picturesubmitt.rtsp.JNIHandleInterface
    public void GetData(int i3, String str) {
    }

    @Override // com.lg.picturesubmitt.rtsp.JNIHandleInterface
    public void errMsg(int i3, String str) {
    }
}
