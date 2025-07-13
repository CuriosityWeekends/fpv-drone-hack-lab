package t2;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.lg.picturesubmitt.activity.MainActivityRTSP;
import com.rockcarry.fanplayer.MediaPlayer;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final class e0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3691a;
    public final /* synthetic */ MainActivityRTSP b;

    public /* synthetic */ e0(MainActivityRTSP mainActivityRTSP, int i3) {
        this.f3691a = i3;
        this.b = mainActivityRTSP;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        MainActivityRTSP mainActivityRTSP = this.b;
        switch (this.f3691a) {
            case 0:
                a1.i.u(new StringBuilder("nHandler msg.what="), message.what, "MainActivityRTSP");
                switch (message.what) {
                    case MediaPlayer.MSG_STREAM_CONNECTED /* 1129202516 */:
                        mainActivityRTSP.S.setVisibility(4);
                        mainActivityRTSP.getClass();
                        Log.d("MainActivityRTSP", "MediaPlayer.MSG_STREAM_CONNECTED");
                        return;
                    case MediaPlayer.MSG_STREAM_DISCONNECT /* 1145656131 */:
                        mainActivityRTSP.S.setVisibility(0);
                        mainActivityRTSP.getClass();
                        Log.d("MainActivityRTSP", "MediaPlayer.MSG_STREAM_DISCONNECT");
                        return;
                    case MediaPlayer.MSG_OPEN_FAILED /* 1178683724 */:
                        Log.d("MainActivityRTSP", "MediaPlayer.MSG_OPEN_FAILED");
                        int i3 = MainActivityRTSP.f746n1;
                        mainActivityRTSP.getClass();
                        mainActivityRTSP.S.setVisibility(0);
                        mainActivityRTSP.T.setVisibility(4);
                        return;
                    case MediaPlayer.MSG_OPEN_DONE /* 1330660686 */:
                        Log.d("MainActivityRTSP", "MediaPlayer.MSG_OPEN_DONE");
                        int i5 = MainActivityRTSP.f746n1;
                        mainActivityRTSP.getClass();
                        mainActivityRTSP.S.setVisibility(4);
                        mainActivityRTSP.T.setVisibility(0);
                        if (mainActivityRTSP.V != null) {
                            mainActivityRTSP.getClass();
                            Log.d("MainActivityRTSP", "testPlayerPlay play=true");
                            MediaPlayer mediaPlayer = mainActivityRTSP.V;
                            if (mediaPlayer != null) {
                                mediaPlayer.play();
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            default:
                super.handleMessage(message);
                int i6 = message.what;
                if (i6 != 13) {
                    if (i6 != 14) {
                        if (i6 != 1888) {
                            switch (i6) {
                                case 0:
                                    mainActivityRTSP.B0 = 0;
                                    Log.d("触发翻滚关闭", "128+128");
                                    mainActivityRTSP.f792u0 = false;
                                    byte[] bArr = mainActivityRTSP.f780n0;
                                    bArr[10] = (byte) (bArr[10] & (-9));
                                    bArr[7] = Byte.MIN_VALUE;
                                    bArr[6] = Byte.MIN_VALUE;
                                    mainActivityRTSP.A("isFanGun--false");
                                    mainActivityRTSP.J.setBackground(mainActivityRTSP.getResources().getDrawable(2131558506));
                                    mainActivityRTSP.A0 = false;
                                    return;
                                case 1:
                                    mainActivityRTSP.S.setVisibility(0);
                                    return;
                                case 2:
                                    mainActivityRTSP.S.setVisibility(0);
                                    return;
                                case 3:
                                    if (mainActivityRTSP.T0) {
                                        byte[] bArr2 = mainActivityRTSP.f782o0;
                                        bArr2[6] = (byte) (bArr2[6] & (-2));
                                        mainActivityRTSP.A("一键起飞置0");
                                        return;
                                    }
                                    byte[] bArr3 = mainActivityRTSP.f780n0;
                                    bArr3[10] = (byte) (bArr3[10] & (-2));
                                    mainActivityRTSP.A("一键起飞置0");
                                    return;
                                case 4:
                                    if (mainActivityRTSP.T0) {
                                        byte[] bArr4 = mainActivityRTSP.f782o0;
                                        bArr4[6] = (byte) (bArr4[6] & (-3));
                                        mainActivityRTSP.A("急停");
                                        return;
                                    }
                                    byte[] bArr5 = mainActivityRTSP.f780n0;
                                    bArr5[10] = (byte) (bArr5[10] & (-5));
                                    mainActivityRTSP.A("急停");
                                    return;
                                case 5:
                                    if (mainActivityRTSP.T0) {
                                        byte[] bArr6 = mainActivityRTSP.f782o0;
                                        bArr6[6] = (byte) (bArr6[6] & (-5));
                                        mainActivityRTSP.A("校准");
                                        return;
                                    }
                                    byte[] bArr7 = mainActivityRTSP.f780n0;
                                    bArr7[10] = (byte) (bArr7[10] & (-129));
                                    mainActivityRTSP.A("校准");
                                    return;
                                case 6:
                                    byte[] bArr8 = mainActivityRTSP.f780n0;
                                    bArr8[10] = (byte) (bArr8[10] & (-3));
                                    mainActivityRTSP.A("一键降落置0");
                                    return;
                                case 7:
                                    mainActivityRTSP.C("与飞控建立udp连接");
                                    return;
                                case 8:
                                    mainActivityRTSP.s.performClick();
                                    return;
                                case 9:
                                    mainActivityRTSP.D.performClick();
                                    return;
                                case 10:
                                    byte[] bArr9 = mainActivityRTSP.f782o0;
                                    bArr9[6] = (byte) (bArr9[6] & (-9));
                                    mainActivityRTSP.A("一键降落置0");
                                    mainActivityRTSP.f792u0 = false;
                                    mainActivityRTSP.J.setBackground(mainActivityRTSP.getResources().getDrawable(2131558506));
                                    return;
                                case 11:
                                    if (!mainActivityRTSP.L0.isChecked()) {
                                        mainActivityRTSP.H.setVisibility(8);
                                    } else {
                                        mainActivityRTSP.H.setVisibility(0);
                                    }
                                    mainActivityRTSP.I.setVisibility(8);
                                    return;
                                default:
                                    return;
                            }
                        }
                        Toast makeText = Toast.makeText(mainActivityRTSP, "数据加载成功，开始播放！！！！", 1);
                        makeText.setGravity(17, 0, 0);
                        makeText.show();
                        return;
                    }
                    mainActivityRTSP.f780n0[6] = Byte.MIN_VALUE;
                    mainActivityRTSP.A("mRightRocker");
                    return;
                }
                mainActivityRTSP.f780n0[7] = Byte.MIN_VALUE;
                mainActivityRTSP.A("mRightRocker");
                return;
        }
    }
}
