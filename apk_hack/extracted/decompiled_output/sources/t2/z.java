package t2;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.lg.picturesubmitt.activity.MainActivityRTSP;
import com.lg.picturesubmitt.model.MusicInfo;
import java.io.File;
import java.lang.ref.WeakReference;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class z implements x2.h, k4.a, s2.f, x2.k {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3722a;
    public final /* synthetic */ MainActivityRTSP b;

    public /* synthetic */ z(MainActivityRTSP mainActivityRTSP, int i3) {
        this.f3722a = i3;
        this.b = mainActivityRTSP;
    }

    @Override // x2.k
    public void a(float f4, float f5) {
        int i3 = MainActivityRTSP.f746n1;
        MainActivityRTSP mainActivityRTSP = this.b;
        mainActivityRTSP.getClass();
        Log.d("MainActivityRTSP", "轨迹坐标x=" + f4 + " ,y=" + f5);
        float f6 = f4 + 128.0f;
        float f7 = f5 + 128.0f;
        if (f6 < 0.0f) {
            f6 = 0.0f;
        }
        float f8 = 255.0f;
        if (f6 > 255.0f) {
            f6 = 255.0f;
        }
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        if (f7 <= 255.0f) {
            f8 = f7;
        }
        if (mainActivityRTSP.T0) {
            byte[] bArr = mainActivityRTSP.f782o0;
            bArr[3] = (byte) f8;
            bArr[2] = (byte) f6;
            Log.d("MainActivityRTSP", "controlDataOpflow[2]x=" + ((int) bArr[2]));
            mainActivityRTSP.A("mRightRocker");
            return;
        }
        byte[] bArr2 = mainActivityRTSP.f780n0;
        bArr2[7] = (byte) f8;
        bArr2[6] = (byte) f6;
        Log.d("MainActivityRTSP", "controlData[6]x=" + ((int) bArr2[6]));
        mainActivityRTSP.A("mRightRocker");
    }

    @Override // k4.a
    public void accept(Object obj) {
        switch (this.f3722a) {
            case 1:
                MainActivityRTSP mainActivityRTSP = this.b;
                int i3 = MainActivityRTSP.f746n1;
                mainActivityRTSP.getClass();
                if (((Boolean) obj).booleanValue()) {
                    if (!mainActivityRTSP.x()) {
                        mainActivityRTSP.C(mainActivityRTSP.getResources().getString(2131755085));
                        return;
                    }
                    com.bumptech.glide.c.i(mainActivityRTSP, 2131689495);
                    mainActivityRTSP.Y = System.currentTimeMillis() + ".jpg";
                    mainActivityRTSP.f760g0 = true;
                    return;
                }
                Toast.makeText(mainActivityRTSP, mainActivityRTSP.getString(2131755289), 1).show();
                return;
            case 2:
                MainActivityRTSP mainActivityRTSP2 = this.b;
                int i5 = MainActivityRTSP.f746n1;
                mainActivityRTSP2.getClass();
                if (((Boolean) obj).booleanValue()) {
                    if (!mainActivityRTSP2.x()) {
                        mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                        return;
                    } else if (mainActivityRTSP2.f763h0) {
                        mainActivityRTSP2.f776m.setVisibility(4);
                        mainActivityRTSP2.L.setText("00:00");
                        mainActivityRTSP2.f761g1.removeCallbacks(mainActivityRTSP2.f758f1);
                        mainActivityRTSP2.C0 = 0;
                        mainActivityRTSP2.f763h0 = false;
                        mainActivityRTSP2.D.setBackground(mainActivityRTSP2.getDrawable(2131558528));
                        mainActivityRTSP2.f753e.d();
                        MusicInfo musicInfo = mainActivityRTSP2.O0;
                        if (musicInfo != null && !TextUtils.isEmpty(musicInfo.path)) {
                            StringBuilder sb = new StringBuilder("musicPath=");
                            sb.append(mainActivityRTSP2.O0.path);
                            sb.append(" videoPath=");
                            sb.append(mainActivityRTSP2.b.c);
                            String str = File.separator;
                            sb.append(str);
                            sb.append("temp");
                            sb.append(mainActivityRTSP2.f748b0);
                            sb.append(" mp4Path=");
                            sb.append(mainActivityRTSP2.b.c);
                            sb.append(str);
                            sb.append(mainActivityRTSP2.f748b0);
                            Log.d("MainActivityRTSP", sb.toString());
                            mainActivityRTSP2.d.addMusic(mainActivityRTSP2.O0.path, mainActivityRTSP2.b.c + str + "temp" + mainActivityRTSP2.f748b0, mainActivityRTSP2.b.c + str + mainActivityRTSP2.f748b0);
                            j4.b.u(mainActivityRTSP2.b.c + str + "temp" + mainActivityRTSP2.f748b0);
                        }
                        j4.b.w(mainActivityRTSP2, true, mainActivityRTSP2.b.c + File.separator + mainActivityRTSP2.f748b0, mainActivityRTSP2.f748b0);
                        return;
                    } else {
                        mainActivityRTSP2.f776m.setVisibility(0);
                        mainActivityRTSP2.L.setText("00:00");
                        mainActivityRTSP2.f761g1.postDelayed(mainActivityRTSP2.f758f1, 500L);
                        mainActivityRTSP2.f763h0 = true;
                        String str2 = System.currentTimeMillis() + "";
                        mainActivityRTSP2.f748b0 = a1.i.h(str2, ".mp4");
                        mainActivityRTSP2.D.setBackground(mainActivityRTSP2.getDrawable(2131558527));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(mainActivityRTSP2.b.d);
                        String str3 = File.separator;
                        sb2.append(str3);
                        sb2.append(str2);
                        sb2.append(".jpg");
                        mainActivityRTSP2.Z = sb2.toString();
                        mainActivityRTSP2.f768j0 = true;
                        MusicInfo musicInfo2 = mainActivityRTSP2.O0;
                        if (musicInfo2 != null && !TextUtils.isEmpty(musicInfo2.path)) {
                            mainActivityRTSP2.f753e.c(mainActivityRTSP2.U0, mainActivityRTSP2.V0, mainActivityRTSP2.b.c + str3 + "temp" + mainActivityRTSP2.f748b0);
                            return;
                        }
                        mainActivityRTSP2.f753e.c(mainActivityRTSP2.U0, mainActivityRTSP2.V0, mainActivityRTSP2.b.c + str3 + mainActivityRTSP2.f748b0);
                        return;
                    }
                }
                Toast.makeText(mainActivityRTSP2, mainActivityRTSP2.getString(2131755289), 1).show();
                return;
            default:
                int i6 = MainActivityRTSP.f746n1;
                MainActivityRTSP mainActivityRTSP3 = this.b;
                mainActivityRTSP3.getClass();
                if (((Boolean) obj).booleanValue()) {
                    if (mainActivityRTSP3.f790t0) {
                        mainActivityRTSP3.f790t0 = false;
                        mainActivityRTSP3.K.setVisibility(8);
                        e4.h hVar = mainActivityRTSP3.f747a1;
                        if (hVar != null) {
                            hVar.d();
                        }
                        mainActivityRTSP3.H.setBackground(mainActivityRTSP3.getDrawable(2131558646));
                        return;
                    }
                    mainActivityRTSP3.f790t0 = true;
                    mainActivityRTSP3.K.setVisibility(0);
                    mainActivityRTSP3.H.setBackground(mainActivityRTSP3.getDrawable(2131558647));
                    e4.h hVar2 = mainActivityRTSP3.f747a1;
                    if (hVar2 == null) {
                        s sVar = new s(2);
                        sVar.b = new WeakReference(mainActivityRTSP3);
                        sVar.execute(new Void[0]);
                        return;
                    }
                    hVar2.c();
                    return;
                }
                Toast.makeText(mainActivityRTSP3, 2131755381, 1).show();
                return;
        }
    }

    @Override // x2.h
    public void b(int i3, int i5) {
        MainActivityRTSP mainActivityRTSP = this.b;
        switch (this.f3722a) {
            case 0:
                int i6 = MainActivityRTSP.f746n1;
                mainActivityRTSP.getClass();
                if (i3 <= -127) {
                    i3 = -128;
                } else if (i3 >= 127) {
                    i3 = 127;
                }
                if (i5 <= -126) {
                    i5 = -128;
                } else if (i5 >= 127) {
                    i5 = 127;
                }
                int i7 = i3 + 128;
                int i8 = i5 + 128;
                a1.i.s("x--", i7, "y--", i8, "左杆加128mLeftRockerR");
                if (mainActivityRTSP.O.f954u) {
                    mainActivityRTSP.u(i8);
                    mainActivityRTSP.v(i7);
                    mainActivityRTSP.A("mLeftRockerR");
                    return;
                }
                mainActivityRTSP.s(i8);
                mainActivityRTSP.v(i7);
                mainActivityRTSP.A("mLeftRockerR");
                return;
            case 8:
                int i9 = MainActivityRTSP.f746n1;
                mainActivityRTSP.getClass();
                Log.d("MainActivityRTSP", "原始右杆mRightRockerx" + i3 + "y" + i5);
                if (i3 <= -127) {
                    i3 = -128;
                } else if (i3 >= 127) {
                    i3 = 127;
                }
                if (i5 <= -126) {
                    i5 = -128;
                } else if (i5 >= 127) {
                    i5 = 127;
                }
                int i10 = i3 + 128;
                int i11 = i5 + 128;
                a1.i.s("x--", i10, "y--", i11, "右杆加128");
                mainActivityRTSP.t(i10);
                mainActivityRTSP.s(i11);
                mainActivityRTSP.A("mRightRocker");
                return;
            case 9:
                int i12 = MainActivityRTSP.f746n1;
                mainActivityRTSP.getClass();
                Log.d("MainActivityRTSP", "原始右杆mRightRockerRx" + i3 + "y" + i5);
                if (i3 <= -127) {
                    i3 = -128;
                } else if (i3 >= 127) {
                    i3 = 127;
                }
                if (i5 <= -126) {
                    i5 = -128;
                } else if (i5 >= 127) {
                    i5 = 127;
                }
                int i13 = i3 + 128;
                int i14 = i5 + 128;
                a1.i.s("x--", i13, "y--", i14, "右杆加128");
                if (mainActivityRTSP.P.f954u) {
                    mainActivityRTSP.s(i14);
                    mainActivityRTSP.t(i13);
                    mainActivityRTSP.A("mRightRockerR1");
                    return;
                }
                mainActivityRTSP.t(i13);
                mainActivityRTSP.u(i14);
                mainActivityRTSP.A("mRightRockerR2");
                return;
            default:
                int i15 = MainActivityRTSP.f746n1;
                mainActivityRTSP.getClass();
                if (i3 <= -127) {
                    i3 = -128;
                } else if (i3 >= 127) {
                    i3 = 127;
                }
                if (i5 <= -126) {
                    i5 = -128;
                } else if (i5 >= 127) {
                    i5 = 127;
                }
                int i16 = i3 + 128;
                int i17 = i5 + 128;
                a1.i.s("x--", i16, "y--", i17, "左杆加128mLeftRocker");
                mainActivityRTSP.u(i17);
                mainActivityRTSP.v(i16);
                mainActivityRTSP.A("mLeftRocker");
                return;
        }
    }

    @Override // s2.f
    public void c(int i3) {
        int i5 = 255;
        MainActivityRTSP mainActivityRTSP = this.b;
        switch (this.f3722a) {
            case 4:
                int i6 = MainActivityRTSP.f746n1;
                if (!mainActivityRTSP.x()) {
                    mainActivityRTSP.C(mainActivityRTSP.getResources().getString(2131755085));
                    return;
                }
                mainActivityRTSP.f762h = i3;
                int i7 = mainActivityRTSP.f801z0;
                if (i3 < 16) {
                    int i8 = (16 - i3) * 2;
                    if (i7 < i8) {
                        i5 = 0;
                    } else {
                        i5 = i7 - i8;
                    }
                } else {
                    int i9 = (i3 - 16) * 2;
                    if (255 - i7 >= i9) {
                        i5 = i9 + i7;
                    }
                }
                if (mainActivityRTSP.T0) {
                    mainActivityRTSP.f782o0[5] = (byte) i5;
                } else {
                    mainActivityRTSP.f780n0[9] = (byte) i5;
                }
                mainActivityRTSP.A("mLeftRocker");
                return;
            case 5:
                int i10 = MainActivityRTSP.f746n1;
                if (!mainActivityRTSP.x()) {
                    mainActivityRTSP.C(mainActivityRTSP.getResources().getString(2131755085));
                    return;
                }
                mainActivityRTSP.f765i = i3;
                mainActivityRTSP.q(mainActivityRTSP.f794v0, mainActivityRTSP.f795w0);
                return;
            default:
                int i11 = MainActivityRTSP.f746n1;
                if (!mainActivityRTSP.x()) {
                    mainActivityRTSP.C(mainActivityRTSP.getResources().getString(2131755085));
                    return;
                }
                mainActivityRTSP.f767j = i3;
                mainActivityRTSP.q(mainActivityRTSP.f794v0, mainActivityRTSP.f795w0);
                return;
        }
    }
}
