package t2;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.lg.picturesubmitt.activity.MainActivityNew;
import com.lg.picturesubmitt.model.MusicInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public final /* synthetic */ class u implements x2.h, k4.a, s2.f, x2.m, x2.k {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3717a;
    public final /* synthetic */ MainActivityNew b;

    public /* synthetic */ u(MainActivityNew mainActivityNew, int i3) {
        this.f3717a = i3;
        this.b = mainActivityNew;
    }

    @Override // x2.m, x2.k
    public void a(float f4, float f5) {
        MainActivityNew mainActivityNew = this.b;
        switch (this.f3717a) {
            case 8:
                int i3 = MainActivityNew.L1;
                mainActivityNew.getClass();
                Log.d("MainActivityNew", "轨迹坐标x=" + f4 + " ,y=" + f5);
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
                Log.d("MainActivityNew", "轨迹坐标x2=" + f6 + " ,y=" + f7);
                if (mainActivityNew.Z0) {
                    byte[] bArr = mainActivityNew.f722r0;
                    bArr[8] = (byte) f7;
                    bArr[7] = (byte) f6;
                    Log.d("MainActivityNew", "controlDataOpflow[7]x=" + ((int) bArr[7]));
                    mainActivityNew.w("mRightRocker");
                    return;
                }
                byte[] bArr2 = mainActivityNew.f719q0;
                bArr2[7] = (byte) f7;
                bArr2[6] = (byte) f6;
                Log.d("MainActivityNew", "controlData[6]x=" + ((int) bArr2[6]));
                mainActivityNew.w("mRightRocker");
                return;
            default:
                int i5 = MainActivityNew.L1;
                mainActivityNew.getClass();
                Log.d("MainActivityNew", "轨迹坐标x=" + f4 + " ,y=" + f5);
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
                Log.d("MainActivityNew", "轨迹坐标x2=" + f12 + " ,y=" + f14);
                if (mainActivityNew.Z0) {
                    byte[] bArr3 = mainActivityNew.f722r0;
                    bArr3[8] = (byte) f14;
                    bArr3[7] = (byte) f12;
                    Log.d("MainActivityNew", "controlDataOpflow[7]x=" + ((int) bArr3[7]));
                    mainActivityNew.w("mRightRocker");
                    return;
                }
                byte[] bArr4 = mainActivityNew.f719q0;
                bArr4[7] = (byte) f14;
                bArr4[6] = (byte) f12;
                Log.d("MainActivityNew", "controlData[6]x=" + ((int) bArr4[6]));
                mainActivityNew.w("mRightRocker");
                return;
        }
    }

    @Override // k4.a
    public void accept(Object obj) {
        switch (this.f3717a) {
            case 2:
                MainActivityNew mainActivityNew = this.b;
                int i3 = MainActivityNew.L1;
                mainActivityNew.getClass();
                if (((Boolean) obj).booleanValue()) {
                    if (!mainActivityNew.v()) {
                        mainActivityNew.y(mainActivityNew.getResources().getString(2131755085));
                        return;
                    }
                    com.bumptech.glide.c.i(mainActivityNew, 2131689495);
                    mainActivityNew.f688f0 = true;
                    return;
                }
                Toast.makeText(mainActivityNew, mainActivityNew.getString(2131755289), 1).show();
                return;
            case 3:
                MainActivityNew mainActivityNew2 = this.b;
                int i5 = MainActivityNew.L1;
                mainActivityNew2.getClass();
                if (((Boolean) obj).booleanValue()) {
                    if (!mainActivityNew2.f691g0 && !mainActivityNew2.v()) {
                        mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                        return;
                    } else if (mainActivityNew2.f691g0) {
                        mainActivityNew2.f707m.setVisibility(4);
                        mainActivityNew2.L.setText("00:00");
                        mainActivityNew2.f745z1.removeCallbacks(mainActivityNew2.f742y1);
                        mainActivityNew2.F0 = 0;
                        mainActivityNew2.f691g0 = false;
                        mainActivityNew2.D.setBackground(mainActivityNew2.getDrawable(2131558528));
                        mainActivityNew2.d.d();
                        MusicInfo musicInfo = mainActivityNew2.R0;
                        if (musicInfo != null && !TextUtils.isEmpty(musicInfo.path)) {
                            StringBuilder sb = new StringBuilder("musicPath=");
                            sb.append(mainActivityNew2.R0.path);
                            sb.append(" videoPath=");
                            sb.append(mainActivityNew2.b.c);
                            String str = File.separator;
                            sb.append(str);
                            sb.append("temp");
                            sb.append(mainActivityNew2.f702k0);
                            sb.append(" mp4Path=");
                            sb.append(mainActivityNew2.b.c);
                            sb.append(str);
                            sb.append(mainActivityNew2.f702k0);
                            Log.d("MainActivityNew", sb.toString());
                            mainActivityNew2.c.addMusic(mainActivityNew2.R0.path, mainActivityNew2.b.c + str + "temp" + mainActivityNew2.f702k0, mainActivityNew2.b.c + str + mainActivityNew2.f702k0);
                            j4.b.u(mainActivityNew2.b.c + str + "temp" + mainActivityNew2.f702k0);
                        }
                        j4.b.w(mainActivityNew2, true, mainActivityNew2.b.c + File.separator + mainActivityNew2.f702k0, mainActivityNew2.f702k0);
                        return;
                    } else {
                        mainActivityNew2.f707m.setVisibility(0);
                        mainActivityNew2.L.setText("00:00");
                        mainActivityNew2.f745z1.postDelayed(mainActivityNew2.f742y1, 500L);
                        mainActivityNew2.f691g0 = true;
                        mainActivityNew2.f702k0 = System.currentTimeMillis() + ".mp4";
                        mainActivityNew2.D.setBackground(mainActivityNew2.getDrawable(2131558527));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(mainActivityNew2.b.d);
                        String str2 = File.separator;
                        sb2.append(str2);
                        sb2.append(mainActivityNew2.f702k0.replace(".mp4", ".jpg"));
                        mainActivityNew2.f699j0 = sb2.toString();
                        mainActivityNew2.f697i0 = true;
                        MusicInfo musicInfo2 = mainActivityNew2.R0;
                        if (musicInfo2 != null && !TextUtils.isEmpty(musicInfo2.path)) {
                            if (mainActivityNew2.f712n1) {
                                mainActivityNew2.d.c(mainActivityNew2.f686e1, mainActivityNew2.f689f1, mainActivityNew2.b.c + str2 + "temp" + mainActivityNew2.f702k0);
                                return;
                            }
                            mainActivityNew2.d.c(mainActivityNew2.f703k1, mainActivityNew2.f706l1, mainActivityNew2.b.c + str2 + "temp" + mainActivityNew2.f702k0);
                            return;
                        } else if (mainActivityNew2.f712n1) {
                            mainActivityNew2.d.c(mainActivityNew2.f686e1, mainActivityNew2.f689f1, mainActivityNew2.b.c + str2 + mainActivityNew2.f702k0);
                            return;
                        } else {
                            mainActivityNew2.d.c(mainActivityNew2.f703k1, mainActivityNew2.f706l1, mainActivityNew2.b.c + str2 + mainActivityNew2.f702k0);
                            return;
                        }
                    }
                }
                Toast.makeText(mainActivityNew2, mainActivityNew2.getString(2131755289), 1).show();
                return;
            default:
                int i6 = MainActivityNew.L1;
                MainActivityNew mainActivityNew3 = this.b;
                mainActivityNew3.getClass();
                if (((Boolean) obj).booleanValue()) {
                    if (mainActivityNew3.f735w0) {
                        mainActivityNew3.f735w0 = false;
                        mainActivityNew3.f678a1 = false;
                        mainActivityNew3.K.setVisibility(8);
                        e4.h hVar = mainActivityNew3.f731u1;
                        if (hVar != null) {
                            hVar.d();
                        }
                        mainActivityNew3.H.setBackground(mainActivityNew3.getDrawable(2131558646));
                        return;
                    }
                    mainActivityNew3.f735w0 = true;
                    mainActivityNew3.K.setVisibility(0);
                    mainActivityNew3.H.setBackground(mainActivityNew3.getDrawable(2131558647));
                    e4.h hVar2 = mainActivityNew3.f731u1;
                    if (hVar2 == null) {
                        s sVar = new s(1);
                        sVar.b = new WeakReference(mainActivityNew3);
                        sVar.execute(new Void[0]);
                        return;
                    }
                    hVar2.c();
                    return;
                }
                Toast.makeText(mainActivityNew3, 2131755381, 1).show();
                return;
        }
    }

    @Override // x2.h
    public void b(int i3, int i5) {
        MainActivityNew mainActivityNew = this.b;
        switch (this.f3717a) {
            case 0:
                int i6 = MainActivityNew.L1;
                mainActivityNew.getClass();
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
                mainActivityNew.s(i8);
                mainActivityNew.t(i7);
                mainActivityNew.w("mLeftRocker");
                return;
            case 1:
                int i9 = MainActivityNew.L1;
                mainActivityNew.getClass();
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
                if (mainActivityNew.O.f954u) {
                    mainActivityNew.s(i11);
                    mainActivityNew.t(i10);
                    mainActivityNew.w("mLeftRockerR");
                    return;
                }
                mainActivityNew.q(i11);
                mainActivityNew.t(i10);
                mainActivityNew.w("mLeftRockerR");
                return;
            case 10:
                int i12 = MainActivityNew.L1;
                mainActivityNew.getClass();
                Log.d("MainActivityNew", "原始右杆mRightRockerx" + i3 + "y" + i5);
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
                mainActivityNew.r(i13);
                mainActivityNew.q(i14);
                mainActivityNew.w("mRightRocker");
                return;
            default:
                int i15 = MainActivityNew.L1;
                mainActivityNew.getClass();
                Log.d("MainActivityNew", "原始右杆mRightRockerRx" + i3 + "y" + i5);
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
                if (mainActivityNew.P.f954u) {
                    mainActivityNew.q(i17);
                    mainActivityNew.r(i16);
                    mainActivityNew.w("mRightRockerR1");
                    return;
                }
                mainActivityNew.r(i16);
                mainActivityNew.s(i17);
                mainActivityNew.w("mRightRockerR2");
                return;
        }
    }

    @Override // s2.f
    public void c(int i3) {
        int i5 = 255;
        MainActivityNew mainActivityNew = this.b;
        switch (this.f3717a) {
            case 5:
                int i6 = MainActivityNew.L1;
                if (!mainActivityNew.v()) {
                    mainActivityNew.y(mainActivityNew.getResources().getString(2131755085));
                    return;
                }
                mainActivityNew.f693h = i3;
                int i7 = mainActivityNew.C0;
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
                if (mainActivityNew.Z0) {
                    mainActivityNew.f722r0[10] = (byte) i5;
                } else {
                    mainActivityNew.f719q0[9] = (byte) i5;
                }
                mainActivityNew.w("mLeftRocker");
                return;
            case 6:
                int i10 = MainActivityNew.L1;
                if (!mainActivityNew.v()) {
                    mainActivityNew.y(mainActivityNew.getResources().getString(2131755085));
                    return;
                }
                mainActivityNew.f696i = i3;
                mainActivityNew.o(mainActivityNew.f741y0, mainActivityNew.f744z0);
                return;
            default:
                int i11 = MainActivityNew.L1;
                if (!mainActivityNew.v()) {
                    mainActivityNew.y(mainActivityNew.getResources().getString(2131755085));
                    return;
                }
                mainActivityNew.f698j = i3;
                mainActivityNew.o(mainActivityNew.f741y0, mainActivityNew.f744z0);
                return;
        }
    }
}
