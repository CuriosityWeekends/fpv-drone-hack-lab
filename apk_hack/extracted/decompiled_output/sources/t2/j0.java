package t2;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.lg.picturesubmitt.PictureAndVideoUtil;
import com.lg.picturesubmitt.activity.TrinityActivity;
import com.lg.picturesubmitt.model.MusicInfo;
import java.io.File;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class j0 implements k4.a, s2.f, x2.k, x2.h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3700a;
    public final /* synthetic */ TrinityActivity b;

    public /* synthetic */ j0(TrinityActivity trinityActivity, int i3) {
        this.f3700a = i3;
        this.b = trinityActivity;
    }

    @Override // x2.k
    public void a(float f4, float f5) {
        int i3 = TrinityActivity.f816v1;
        TrinityActivity trinityActivity = this.b;
        trinityActivity.getClass();
        Log.d("TrinityActivity", "轨迹坐标x=" + f4 + " ,y=" + f5);
        byte[] bArr = trinityActivity.f847m0;
        bArr[1] = (byte) ((int) (f5 + 128.0f));
        bArr[0] = (byte) ((int) (f4 + 128.0f));
        Log.d("TrinityActivity", "controlData[6]x=" + ((int) bArr[6]));
        trinityActivity.s("mRightRocker");
    }

    @Override // k4.a
    public void accept(Object obj) {
        switch (this.f3700a) {
            case 0:
                TrinityActivity trinityActivity = this.b;
                int i3 = TrinityActivity.f816v1;
                trinityActivity.getClass();
                if (((Boolean) obj).booleanValue()) {
                    if (!trinityActivity.r()) {
                        trinityActivity.t(trinityActivity.getResources().getString(2131755085));
                        return;
                    }
                    com.bumptech.glide.c.i(trinityActivity, 2131689495);
                    trinityActivity.f818b0 = true;
                    return;
                }
                Toast.makeText(trinityActivity, trinityActivity.getString(2131755289), 1).show();
                return;
            default:
                TrinityActivity trinityActivity2 = this.b;
                int i5 = TrinityActivity.f816v1;
                trinityActivity2.getClass();
                if (((Boolean) obj).booleanValue()) {
                    if (!trinityActivity2.r()) {
                        trinityActivity2.t(trinityActivity2.getResources().getString(2131755085));
                        return;
                    } else if (trinityActivity2.f820c0) {
                        trinityActivity2.f843l.setVisibility(4);
                        trinityActivity2.H.setText("00:00");
                        trinityActivity2.f839j1.removeCallbacks(trinityActivity2.i1);
                        trinityActivity2.f873w0 = 0;
                        trinityActivity2.f820c0 = false;
                        trinityActivity2.A.setBackground(trinityActivity2.getDrawable(2131558528));
                        trinityActivity2.c.stopRecode();
                        MusicInfo musicInfo = trinityActivity2.G0;
                        if (musicInfo != null && !TextUtils.isEmpty(musicInfo.path)) {
                            PictureAndVideoUtil pictureAndVideoUtil = trinityActivity2.c;
                            String str = trinityActivity2.G0.path;
                            StringBuilder sb = new StringBuilder();
                            sb.append(trinityActivity2.b.c);
                            String str2 = File.separator;
                            sb.append(str2);
                            sb.append("temp");
                            sb.append(trinityActivity2.f830g0);
                            String sb2 = sb.toString();
                            pictureAndVideoUtil.addMusic(str, sb2, trinityActivity2.b.c + str2 + trinityActivity2.f830g0);
                            j4.b.u(trinityActivity2.b.c + str2 + "temp" + trinityActivity2.f830g0);
                        }
                        j4.b.w(trinityActivity2, true, trinityActivity2.b.c + File.separator + trinityActivity2.f830g0, trinityActivity2.f830g0);
                        return;
                    } else {
                        trinityActivity2.f843l.setVisibility(0);
                        trinityActivity2.H.setText("00:00");
                        trinityActivity2.f839j1.postDelayed(trinityActivity2.i1, 500L);
                        trinityActivity2.f820c0 = true;
                        trinityActivity2.f830g0 = System.currentTimeMillis() + ".mp4";
                        trinityActivity2.A.setBackground(trinityActivity2.getDrawable(2131558527));
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(trinityActivity2.b.d);
                        String str3 = File.separator;
                        sb3.append(str3);
                        sb3.append(trinityActivity2.f830g0.replace(".mp4", ".jpg"));
                        trinityActivity2.f827f0 = sb3.toString();
                        trinityActivity2.f824e0 = true;
                        MusicInfo musicInfo2 = trinityActivity2.G0;
                        if (musicInfo2 != null && !TextUtils.isEmpty(musicInfo2.path)) {
                            if (trinityActivity2.U0) {
                                PictureAndVideoUtil pictureAndVideoUtil2 = trinityActivity2.c;
                                pictureAndVideoUtil2.startRecode(trinityActivity2.b.c + str3 + "temp" + trinityActivity2.f830g0, trinityActivity2.R0, trinityActivity2.S0, trinityActivity2.f834h1);
                                return;
                            }
                            PictureAndVideoUtil pictureAndVideoUtil3 = trinityActivity2.c;
                            pictureAndVideoUtil3.startRecode(trinityActivity2.b.c + str3 + "temp" + trinityActivity2.f830g0, trinityActivity2.V, trinityActivity2.W, trinityActivity2.f834h1);
                            return;
                        } else if (trinityActivity2.U0) {
                            PictureAndVideoUtil pictureAndVideoUtil4 = trinityActivity2.c;
                            pictureAndVideoUtil4.startRecode(trinityActivity2.b.c + str3 + trinityActivity2.f830g0, trinityActivity2.R0, trinityActivity2.S0, trinityActivity2.f834h1);
                            return;
                        } else {
                            PictureAndVideoUtil pictureAndVideoUtil5 = trinityActivity2.c;
                            pictureAndVideoUtil5.startRecode(trinityActivity2.b.c + str3 + trinityActivity2.f830g0, trinityActivity2.V, trinityActivity2.W, trinityActivity2.f834h1);
                            return;
                        }
                    }
                }
                Toast.makeText(trinityActivity2, trinityActivity2.getString(2131755289), 1).show();
                return;
        }
    }

    @Override // x2.h
    public void b(int i3, int i5) {
        int i6 = i3;
        int i7 = 127;
        TrinityActivity trinityActivity = this.b;
        switch (this.f3700a) {
            case 6:
                int i8 = TrinityActivity.f816v1;
                trinityActivity.getClass();
                Log.d("TrinityActivity原始右杆", "x" + i6 + "y" + i5);
                if (i6 <= -127) {
                    i6 = -128;
                } else if (i6 >= 127) {
                    i6 = 127;
                }
                if (i5 <= -126) {
                    i7 = -128;
                } else if (i5 < 127) {
                    i7 = i5;
                }
                int i9 = i6 + 128;
                int i10 = i7 + 128;
                a1.i.s("x--", i9, "y--", i10, "右杆加128");
                trinityActivity.o(i9);
                trinityActivity.n(i10);
                trinityActivity.s("mRightRocker");
                return;
            case 7:
                int i11 = TrinityActivity.f816v1;
                trinityActivity.getClass();
                Log.d("TrinityActivity原始右杆", "x" + i6 + "y" + i5);
                if (i6 <= -127) {
                    i6 = -128;
                } else if (i6 >= 127) {
                    i6 = 127;
                }
                if (i5 <= -126) {
                    i7 = -128;
                } else if (i5 < 127) {
                    i7 = i5;
                }
                int i12 = i6 + 128;
                int i13 = i7 + 128;
                a1.i.s("x--", i12, "y--", i13, "右杆加128");
                if (trinityActivity.L.f954u) {
                    trinityActivity.n(i13);
                    trinityActivity.o(i12);
                    trinityActivity.s("mLeftRocker");
                    return;
                }
                trinityActivity.o(i12);
                trinityActivity.f847m0[2] = (byte) i13;
                trinityActivity.s("mRightRockerR");
                return;
            case 8:
                int i14 = TrinityActivity.f816v1;
                trinityActivity.getClass();
                if (i6 <= -127) {
                    i6 = -128;
                } else if (i6 >= 127) {
                    i6 = 127;
                }
                if (i5 <= -126) {
                    i7 = -128;
                } else if (i5 < 127) {
                    i7 = i5;
                }
                int i15 = i6 + 128;
                int i16 = i7 + 128;
                a1.i.s("x--", i15, "y--", i16, "左杆加128");
                trinityActivity.f847m0[2] = (byte) i16;
                trinityActivity.p(i15);
                trinityActivity.s("mLeftRocker");
                return;
            default:
                int i17 = TrinityActivity.f816v1;
                trinityActivity.getClass();
                if (i6 <= -127) {
                    i6 = -128;
                } else if (i6 >= 127) {
                    i6 = 127;
                }
                if (i5 <= -126) {
                    i7 = -128;
                } else if (i5 < 127) {
                    i7 = i5;
                }
                int i18 = i6 + 128;
                int i19 = i7 + 128;
                a1.i.s("x--", i18, "y--", i19, "左杆加128");
                trinityActivity.n(i19);
                trinityActivity.p(i18);
                trinityActivity.s("mLeftRockerR");
                return;
        }
    }

    @Override // s2.f
    public void c(int i3) {
        int i5 = 255;
        TrinityActivity trinityActivity = this.b;
        switch (this.f3700a) {
            case 2:
                int i6 = TrinityActivity.f816v1;
                if (!trinityActivity.r()) {
                    trinityActivity.t(trinityActivity.getResources().getString(2131755085));
                    return;
                }
                trinityActivity.f835i = i3;
                trinityActivity.m(trinityActivity.f866t0, trinityActivity.f869u0);
                return;
            case 3:
                int i7 = TrinityActivity.f816v1;
                if (!trinityActivity.r()) {
                    trinityActivity.t(trinityActivity.getResources().getString(2131755085));
                    return;
                }
                trinityActivity.f829g = i3;
                int i8 = trinityActivity.f872v0;
                if (i3 < 16) {
                    int i9 = (16 - i3) * 2;
                    if (i8 < i9) {
                        i5 = 0;
                    } else {
                        i5 = i8 - i9;
                    }
                } else {
                    int i10 = (i3 - 16) * 2;
                    if (255 - i8 >= i10) {
                        i5 = i10 + i8;
                    }
                }
                trinityActivity.f847m0[3] = (byte) i5;
                trinityActivity.s("mLeftRocker");
                return;
            default:
                int i11 = TrinityActivity.f816v1;
                if (!trinityActivity.r()) {
                    trinityActivity.t(trinityActivity.getResources().getString(2131755085));
                    return;
                }
                trinityActivity.f832h = i3;
                trinityActivity.m(trinityActivity.f866t0, trinityActivity.f869u0);
                return;
        }
    }
}
