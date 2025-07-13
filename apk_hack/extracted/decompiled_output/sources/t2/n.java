package t2;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.lg.picturesubmitt.activity.MainActivityDecode;
import com.lg.picturesubmitt.model.MusicInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class n implements x2.h, k4.a, s2.f, x2.m, x2.k {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3707a;
    public final /* synthetic */ MainActivityDecode b;

    public /* synthetic */ n(MainActivityDecode mainActivityDecode, int i3) {
        this.f3707a = i3;
        this.b = mainActivityDecode;
    }

    @Override // x2.m, x2.k
    public void a(float f4, float f5) {
        MainActivityDecode mainActivityDecode = this.b;
        switch (this.f3707a) {
            case 8:
                int i3 = MainActivityDecode.M1;
                mainActivityDecode.getClass();
                Log.d("MainActivityDecode", "轨迹坐标x=" + f4 + " ,y=" + f5);
                float f6 = f4 + 128.0f;
                float f7 = f5 + 128.0f;
                float f8 = (float) 112;
                if (f6 < f8 || f6 >= ((float) IjkMediaMeta.FF_PROFILE_H264_HIGH_444)) {
                    if (f6 < f8) {
                        f6 = f8;
                    }
                    float f9 = (float) IjkMediaMeta.FF_PROFILE_H264_HIGH_444;
                    if (f6 > f9) {
                        f6 = f9;
                    }
                }
                float f10 = 109;
                if (f7 < f10 || f7 >= 147) {
                    if (f7 < f10) {
                        f7 = f10;
                    }
                    float f11 = 147;
                    if (f7 > f11) {
                        f7 = f11;
                    }
                }
                Log.d("MainActivityDecode", "轨迹坐标x2=" + f6 + " ,y=" + f7);
                if (mainActivityDecode.f610a1) {
                    byte[] bArr = mainActivityDecode.f656s0;
                    bArr[8] = (byte) f7;
                    bArr[7] = (byte) f6;
                    Log.d("MainActivityDecode", "controlDataOpflow[7]x=" + ((int) bArr[7]));
                    mainActivityDecode.w("mRightRocker");
                    return;
                }
                byte[] bArr2 = mainActivityDecode.f654r0;
                bArr2[7] = (byte) f7;
                bArr2[6] = (byte) f6;
                Log.d("MainActivityDecode", "controlData[6]x=" + ((int) bArr2[6]));
                mainActivityDecode.w("mRightRocker");
                return;
            default:
                int i5 = MainActivityDecode.M1;
                mainActivityDecode.getClass();
                Log.d("MainActivityDecode", "轨迹坐标x=" + f4 + " ,y=" + f5);
                float f12 = f4 + 128.0f;
                float f13 = f5 + 128.0f;
                if (f12 < 0.0f) {
                    f12 = 0.0f;
                }
                float f14 = 255.0f;
                if (f12 > 255.0f) {
                    f12 = 255.0f;
                }
                if (f13 < 0.0f) {
                    f13 = 0.0f;
                }
                if (f13 <= 255.0f) {
                    f14 = f13;
                }
                Log.d("MainActivityDecode", "轨迹坐标x2=" + f12 + " ,y=" + f14);
                if (mainActivityDecode.f610a1) {
                    byte[] bArr3 = mainActivityDecode.f656s0;
                    bArr3[8] = (byte) f14;
                    bArr3[7] = (byte) f12;
                    Log.d("MainActivityDecode", "controlDataOpflow[7]x=" + ((int) bArr3[7]));
                    mainActivityDecode.w("mRightRocker");
                    return;
                }
                byte[] bArr4 = mainActivityDecode.f654r0;
                bArr4[7] = (byte) f14;
                bArr4[6] = (byte) f12;
                Log.d("MainActivityDecode", "controlData[6]x=" + ((int) bArr4[6]));
                mainActivityDecode.w("mRightRocker");
                return;
        }
    }

    @Override // k4.a
    public void accept(Object obj) {
        switch (this.f3707a) {
            case 2:
                MainActivityDecode mainActivityDecode = this.b;
                int i3 = MainActivityDecode.M1;
                mainActivityDecode.getClass();
                if (((Boolean) obj).booleanValue()) {
                    if (!mainActivityDecode.v()) {
                        mainActivityDecode.y(mainActivityDecode.getResources().getString(2131755085));
                        return;
                    }
                    com.bumptech.glide.c.i(mainActivityDecode, 2131689495);
                    mainActivityDecode.f623g0 = true;
                    return;
                }
                Toast.makeText(mainActivityDecode, mainActivityDecode.getString(2131755289), 1).show();
                return;
            case 3:
                MainActivityDecode mainActivityDecode2 = this.b;
                int i5 = MainActivityDecode.M1;
                mainActivityDecode2.getClass();
                if (((Boolean) obj).booleanValue()) {
                    if (!mainActivityDecode2.f626h0 && !mainActivityDecode2.v()) {
                        mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                        return;
                    } else if (mainActivityDecode2.f626h0) {
                        mainActivityDecode2.f639m.setVisibility(4);
                        mainActivityDecode2.L.setText("00:00");
                        mainActivityDecode2.A1.removeCallbacks(mainActivityDecode2.f677z1);
                        mainActivityDecode2.G0 = 0;
                        mainActivityDecode2.f626h0 = false;
                        mainActivityDecode2.D.setBackground(mainActivityDecode2.getDrawable(2131558528));
                        mainActivityDecode2.d.d();
                        MusicInfo musicInfo = mainActivityDecode2.S0;
                        if (musicInfo != null && !TextUtils.isEmpty(musicInfo.path)) {
                            StringBuilder sb = new StringBuilder("musicPath=");
                            sb.append(mainActivityDecode2.S0.path);
                            sb.append(" videoPath=");
                            sb.append(mainActivityDecode2.b.c);
                            String str = File.separator;
                            sb.append(str);
                            sb.append("temp");
                            sb.append(mainActivityDecode2.f637l0);
                            sb.append(" mp4Path=");
                            sb.append(mainActivityDecode2.b.c);
                            sb.append(str);
                            sb.append(mainActivityDecode2.f637l0);
                            Log.d("MainActivityDecode", sb.toString());
                            mainActivityDecode2.c.addMusic(mainActivityDecode2.S0.path, mainActivityDecode2.b.c + str + "temp" + mainActivityDecode2.f637l0, mainActivityDecode2.b.c + str + mainActivityDecode2.f637l0);
                            j4.b.u(mainActivityDecode2.b.c + str + "temp" + mainActivityDecode2.f637l0);
                        }
                        j4.b.w(mainActivityDecode2, true, mainActivityDecode2.b.c + File.separator + mainActivityDecode2.f637l0, mainActivityDecode2.f637l0);
                        return;
                    } else {
                        mainActivityDecode2.f639m.setVisibility(0);
                        mainActivityDecode2.L.setText("00:00");
                        mainActivityDecode2.A1.postDelayed(mainActivityDecode2.f677z1, 500L);
                        mainActivityDecode2.f626h0 = true;
                        mainActivityDecode2.f637l0 = System.currentTimeMillis() + ".mp4";
                        mainActivityDecode2.D.setBackground(mainActivityDecode2.getDrawable(2131558527));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(mainActivityDecode2.b.d);
                        String str2 = File.separator;
                        sb2.append(str2);
                        sb2.append(mainActivityDecode2.f637l0.replace(".mp4", ".jpg"));
                        mainActivityDecode2.f634k0 = sb2.toString();
                        mainActivityDecode2.f631j0 = true;
                        MusicInfo musicInfo2 = mainActivityDecode2.S0;
                        if (musicInfo2 != null && !TextUtils.isEmpty(musicInfo2.path)) {
                            if (mainActivityDecode2.f647o1) {
                                mainActivityDecode2.d.c(mainActivityDecode2.f621f1, mainActivityDecode2.f624g1, mainActivityDecode2.b.c + str2 + "temp" + mainActivityDecode2.f637l0);
                                return;
                            }
                            mainActivityDecode2.d.c(mainActivityDecode2.f638l1, mainActivityDecode2.f641m1, mainActivityDecode2.b.c + str2 + "temp" + mainActivityDecode2.f637l0);
                            return;
                        } else if (mainActivityDecode2.f647o1) {
                            mainActivityDecode2.d.c(mainActivityDecode2.f621f1, mainActivityDecode2.f624g1, mainActivityDecode2.b.c + str2 + mainActivityDecode2.f637l0);
                            return;
                        } else {
                            mainActivityDecode2.d.c(mainActivityDecode2.f638l1, mainActivityDecode2.f641m1, mainActivityDecode2.b.c + str2 + mainActivityDecode2.f637l0);
                            return;
                        }
                    }
                }
                Toast.makeText(mainActivityDecode2, mainActivityDecode2.getString(2131755289), 1).show();
                return;
            default:
                int i6 = MainActivityDecode.M1;
                MainActivityDecode mainActivityDecode3 = this.b;
                mainActivityDecode3.getClass();
                if (((Boolean) obj).booleanValue()) {
                    if (mainActivityDecode3.f670x0) {
                        mainActivityDecode3.f670x0 = false;
                        mainActivityDecode3.f612b1 = false;
                        mainActivityDecode3.K.setVisibility(8);
                        e4.h hVar = mainActivityDecode3.f666v1;
                        if (hVar != null) {
                            hVar.d();
                        }
                        mainActivityDecode3.H.setBackground(mainActivityDecode3.getDrawable(2131558646));
                        return;
                    }
                    mainActivityDecode3.f670x0 = true;
                    mainActivityDecode3.K.setVisibility(0);
                    mainActivityDecode3.H.setBackground(mainActivityDecode3.getDrawable(2131558647));
                    e4.h hVar2 = mainActivityDecode3.f666v1;
                    if (hVar2 == null) {
                        s sVar = new s(0);
                        sVar.b = new WeakReference(mainActivityDecode3);
                        sVar.execute(new Void[0]);
                        return;
                    }
                    hVar2.c();
                    return;
                }
                Toast.makeText(mainActivityDecode3, 2131755381, 1).show();
                return;
        }
    }

    @Override // x2.h
    public void b(int i3, int i5) {
        MainActivityDecode mainActivityDecode = this.b;
        switch (this.f3707a) {
            case 0:
                int i6 = MainActivityDecode.M1;
                mainActivityDecode.getClass();
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
                a1.i.s("x--", i7, "y--", i8, "左杆加128mLeftRocker");
                mainActivityDecode.s(i8);
                mainActivityDecode.t(i7);
                mainActivityDecode.w("mLeftRocker");
                return;
            case 1:
                int i9 = MainActivityDecode.M1;
                mainActivityDecode.getClass();
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
                a1.i.s("x--", i10, "y--", i11, "左杆加128mLeftRockerR");
                if (mainActivityDecode.O.f954u) {
                    mainActivityDecode.s(i11);
                    mainActivityDecode.t(i10);
                    mainActivityDecode.w("mLeftRockerR");
                    return;
                }
                mainActivityDecode.q(i11);
                mainActivityDecode.t(i10);
                mainActivityDecode.w("mLeftRockerR");
                return;
            case 10:
                int i12 = MainActivityDecode.M1;
                mainActivityDecode.getClass();
                Log.d("MainActivityDecode", "原始右杆mRightRockerx" + i3 + "y" + i5);
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
                mainActivityDecode.r(i13);
                mainActivityDecode.q(i14);
                mainActivityDecode.w("mRightRocker");
                return;
            default:
                int i15 = MainActivityDecode.M1;
                mainActivityDecode.getClass();
                Log.d("MainActivityDecode", "原始右杆mRightRockerRx" + i3 + "y" + i5);
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
                a1.i.s("x--", i16, "y--", i17, "右杆加128");
                if (mainActivityDecode.P.f954u) {
                    mainActivityDecode.q(i17);
                    mainActivityDecode.r(i16);
                    mainActivityDecode.w("mRightRockerR1");
                    return;
                }
                mainActivityDecode.r(i16);
                mainActivityDecode.s(i17);
                mainActivityDecode.w("mRightRockerR2");
                return;
        }
    }

    @Override // s2.f
    public void c(int i3) {
        int i5 = 255;
        MainActivityDecode mainActivityDecode = this.b;
        switch (this.f3707a) {
            case 5:
                int i6 = MainActivityDecode.M1;
                if (!mainActivityDecode.v()) {
                    mainActivityDecode.y(mainActivityDecode.getResources().getString(2131755085));
                    return;
                }
                mainActivityDecode.f625h = i3;
                int i7 = mainActivityDecode.D0;
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
                if (mainActivityDecode.f610a1) {
                    mainActivityDecode.f656s0[10] = (byte) i5;
                } else {
                    mainActivityDecode.f654r0[9] = (byte) i5;
                }
                mainActivityDecode.w("mLeftRocker");
                return;
            case 6:
                int i10 = MainActivityDecode.M1;
                if (!mainActivityDecode.v()) {
                    mainActivityDecode.y(mainActivityDecode.getResources().getString(2131755085));
                    return;
                }
                mainActivityDecode.f628i = i3;
                mainActivityDecode.o(mainActivityDecode.f676z0, mainActivityDecode.A0);
                return;
            default:
                int i11 = MainActivityDecode.M1;
                if (!mainActivityDecode.v()) {
                    mainActivityDecode.y(mainActivityDecode.getResources().getString(2131755085));
                    return;
                }
                mainActivityDecode.f630j = i3;
                mainActivityDecode.o(mainActivityDecode.f676z0, mainActivityDecode.A0);
                return;
        }
    }
}
