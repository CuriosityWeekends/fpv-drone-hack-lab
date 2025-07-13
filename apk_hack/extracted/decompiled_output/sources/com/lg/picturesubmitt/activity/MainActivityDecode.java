package com.lg.picturesubmitt.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.d;
import com.jaygoo.widget.VerticalRangeSeekBar;
import com.lg.picturesubmitt.MyApplication;
import com.lg.picturesubmitt.PictureAndVideoUtil;
import com.lg.picturesubmitt.activity.FileDirActivity;
import com.lg.picturesubmitt.activity.MainActivityDecode;
import com.lg.picturesubmitt.activity.MusicActivity;
import com.lg.picturesubmitt.model.MusicInfo;
import com.lg.picturesubmitt.widget.CustomButton;
import com.lg.picturesubmitt.widget.HTrimView;
import com.lg.picturesubmitt.widget.MyRockerView;
import com.lg.picturesubmitt.widget.TrackControlPaintView;
import com.lg.picturesubmitt.widget.TrackControlPaintViewJY;
import com.lg.picturesubmitt.widget.VTrimView;
import com.lg.picturesubmitt.widget.ZoomView;
import com.lg.picturesubmitt.widget.battery.BatteryView;
import com.lxj.xpopup.core.CenterPopupView;
import com.tencent.bugly.proguard.c0;
import com.zhouyou.view.seekbar.SignSeekBar;
import e4.a;
import edu.cmu.pocketsphinx.Config;
import edu.cmu.pocketsphinx.Decoder;
import edu.cmu.pocketsphinx.Hypothesis;
import edu.cmu.pocketsphinx.PocketSphinxJNI;
import edu.cmu.pocketsphinx.SphinxBaseJNI;
import f0.b;
import j0.s;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import s2.e;
import s2.h;
import s2.i;
import s2.j;
import s2.m;
import t2.k;
import t2.l;
import t2.n;
import t2.o;
import t2.q;
import t2.r;
import v2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MainActivityDecode extends BaseActivity implements a, s2.a, j, v2.a, c, e {
    public static final /* synthetic */ int M1 = 0;
    public CustomButton A;
    public CustomButton B;
    public int B0;
    public CustomButton C;
    public int C0;
    public byte[] C1;
    public CustomButton D;
    public int D0;
    public final k D1;
    public CustomButton E;
    public String E1;
    public CustomButton F;
    public int F1;
    public CustomButton G;
    public boolean G1;
    public CustomButton H;
    public v3.c H0;
    public int H1;
    public CustomButton I;
    public b I0;
    public int I1;
    public CustomButton J;
    public v2.b J0;
    public int J1;
    public TextView K;
    public BatteryView K0;
    public final r K1;
    public TextView L;
    public CheckBox L0;
    public int L1;
    public MyRockerView M;
    public CheckBox M0;
    public MyRockerView N;
    public CheckBox N0;
    public MyRockerView O;
    public CheckBox O0;
    public MyRockerView P;
    public CheckBox P0;
    public TrackControlPaintView Q;
    public CustomButton Q0;
    public TrackControlPaintViewJY R;
    public ImageView R0;
    public LinearLayout S;
    public MusicInfo S0;
    public LinearLayout T;
    public g3.e T0;
    public ImageView U;
    public ImageView V;
    public boolean V0;
    public ZoomView W;
    public RelativeLayout X;
    public c1.b X0;
    public VerticalRangeSeekBar Y;
    public Bitmap Z;

    /* renamed from: b0  reason: collision with root package name */
    public i f611b0;
    public PictureAndVideoUtil c;

    /* renamed from: c0  reason: collision with root package name */
    public h f613c0;

    /* renamed from: c1  reason: collision with root package name */
    public int f614c1;

    /* renamed from: f  reason: collision with root package name */
    public WifiManager f619f;

    /* renamed from: g  reason: collision with root package name */
    public VTrimView f622g;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f633k;

    /* renamed from: k0  reason: collision with root package name */
    public String f634k0;

    /* renamed from: l  reason: collision with root package name */
    public LinearLayout f636l;

    /* renamed from: l0  reason: collision with root package name */
    public String f637l0;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f639m;

    /* renamed from: m0  reason: collision with root package name */
    public ByteArrayOutputStream f640m0;

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f642n;

    /* renamed from: n0  reason: collision with root package name */
    public ArrayList f643n0;

    /* renamed from: o  reason: collision with root package name */
    public LinearLayout f645o;

    /* renamed from: o0  reason: collision with root package name */
    public ExecutorService f646o0;

    /* renamed from: p  reason: collision with root package name */
    public LinearLayout f648p;

    /* renamed from: p0  reason: collision with root package name */
    public ExecutorService f649p0;

    /* renamed from: p1  reason: collision with root package name */
    public Button f650p1;
    public ImageView q;

    /* renamed from: q0  reason: collision with root package name */
    public ExecutorService f651q0;

    /* renamed from: q1  reason: collision with root package name */
    public LinearLayout f652q1;

    /* renamed from: r  reason: collision with root package name */
    public CustomButton f653r;

    /* renamed from: r1  reason: collision with root package name */
    public RadioGroup f655r1;
    public CustomButton s;

    /* renamed from: s1  reason: collision with root package name */
    public RadioGroup f657s1;

    /* renamed from: t  reason: collision with root package name */
    public CustomButton f658t;

    /* renamed from: t1  reason: collision with root package name */
    public SignSeekBar f660t1;

    /* renamed from: u  reason: collision with root package name */
    public CustomButton f661u;

    /* renamed from: v  reason: collision with root package name */
    public CustomButton f664v;

    /* renamed from: v1  reason: collision with root package name */
    public e4.h f666v1;
    public CustomButton w;

    /* renamed from: x  reason: collision with root package name */
    public CustomButton f669x;

    /* renamed from: y  reason: collision with root package name */
    public CustomButton f672y;

    /* renamed from: z  reason: collision with root package name */
    public CustomButton f675z;
    public final m d = new m();

    /* renamed from: e  reason: collision with root package name */
    public boolean f616e = false;

    /* renamed from: h  reason: collision with root package name */
    public int f625h = 16;

    /* renamed from: i  reason: collision with root package name */
    public int f628i = 16;

    /* renamed from: j  reason: collision with root package name */
    public int f630j = 16;

    /* renamed from: d0  reason: collision with root package name */
    public final byte[] f615d0 = {-1, -40};

    /* renamed from: e0  reason: collision with root package name */
    public final byte[] f617e0 = {-1, -39};

    /* renamed from: f0  reason: collision with root package name */
    public volatile boolean f620f0 = true;

    /* renamed from: g0  reason: collision with root package name */
    public volatile boolean f623g0 = false;

    /* renamed from: h0  reason: collision with root package name */
    public volatile boolean f626h0 = false;

    /* renamed from: i0  reason: collision with root package name */
    public volatile boolean f629i0 = false;

    /* renamed from: j0  reason: collision with root package name */
    public volatile boolean f631j0 = false;

    /* renamed from: r0  reason: collision with root package name */
    public final byte[] f654r0 = new byte[14];

    /* renamed from: s0  reason: collision with root package name */
    public final byte[] f656s0 = new byte[26];

    /* renamed from: t0  reason: collision with root package name */
    public int f659t0 = 40;

    /* renamed from: u0  reason: collision with root package name */
    public boolean f662u0 = false;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f665v0 = false;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f667w0 = false;

    /* renamed from: x0  reason: collision with root package name */
    public boolean f670x0 = false;

    /* renamed from: y0  reason: collision with root package name */
    public boolean f673y0 = false;

    /* renamed from: z0  reason: collision with root package name */
    public int f676z0 = 128;
    public int A0 = 128;
    public boolean E0 = false;
    public int F0 = 0;
    public int G0 = 0;
    public boolean U0 = false;
    public boolean W0 = false;
    public boolean Y0 = false;
    public boolean Z0 = false;

    /* renamed from: a1  reason: collision with root package name */
    public boolean f610a1 = false;

    /* renamed from: b1  reason: collision with root package name */
    public boolean f612b1 = false;
    public volatile int d1 = 5780;

    /* renamed from: e1  reason: collision with root package name */
    public volatile int f618e1 = 2890;

    /* renamed from: f1  reason: collision with root package name */
    public volatile int f621f1 = 1920;

    /* renamed from: g1  reason: collision with root package name */
    public volatile int f624g1 = 1080;

    /* renamed from: h1  reason: collision with root package name */
    public volatile int f627h1 = 640;
    public volatile int i1 = 360;

    /* renamed from: j1  reason: collision with root package name */
    public volatile int f632j1 = 480;

    /* renamed from: k1  reason: collision with root package name */
    public volatile int f635k1 = 480;

    /* renamed from: l1  reason: collision with root package name */
    public volatile int f638l1 = 640;

    /* renamed from: m1  reason: collision with root package name */
    public volatile int f641m1 = 480;

    /* renamed from: n1  reason: collision with root package name */
    public boolean f644n1 = false;

    /* renamed from: o1  reason: collision with root package name */
    public boolean f647o1 = false;

    /* renamed from: u1  reason: collision with root package name */
    public boolean f663u1 = false;

    /* renamed from: w1  reason: collision with root package name */
    public boolean f668w1 = true;

    /* renamed from: x1  reason: collision with root package name */
    public volatile boolean f671x1 = true;

    /* renamed from: y1  reason: collision with root package name */
    public volatile boolean f674y1 = false;

    /* renamed from: z1  reason: collision with root package name */
    public final q f677z1 = new q(this, 1);
    public final s A1 = new s(this, 6);
    public boolean B1 = false;

    public MainActivityDecode() {
        new ByteArrayOutputStream();
        this.D1 = new k(1, this);
        this.F1 = 0;
        this.G1 = false;
        this.H1 = 0;
        new TreeMap();
        new HashMap();
        new TreeMap();
        new TreeMap();
        this.I1 = 0;
        this.J1 = 0;
        this.K1 = new r(0, this);
        this.L1 = 1;
    }

    public static void l(MainActivityDecode mainActivityDecode, File file) {
        String str;
        if (mainActivityDecode.f668w1) {
            str = "zh-cn-ptm";
        } else {
            str = "en-us-ptm";
        }
        e4.i a5 = e4.i.a();
        Config config = a5.f1762a;
        SphinxBaseJNI.Config_setFloat(config.f1763a, config, "-kws_threshold", 1.0E10f);
        SphinxBaseJNI.Config_setBoolean(config.f1763a, config, "-allphone_ci", true);
        a5.b("-hmm", new File(file, str).getPath());
        a5.b("-dict", new File(file, str.concat("/test.dic")).getPath());
        a5.b("-rawlogdir", file.getPath());
        e4.h hVar = new e4.h(config);
        mainActivityDecode.f666v1 = hVar;
        hVar.b(mainActivityDecode);
        mainActivityDecode.f666v1.a(new File(file, str.concat("/menu.gram")));
    }

    public static String u(int i3) {
        return (i3 & 255) + "." + ((i3 >> 8) & 255) + "." + ((i3 >> 16) & 255) + "." + ((i3 >> 24) & 255);
    }

    @Override // v2.a
    public final void a(int i3) {
        if (!v()) {
            y(getResources().getString(2131755085));
            return;
        }
        switch (i3) {
            case 1:
                this.E1 = "   低速模式";
                this.f659t0 = 40;
                o(this.f676z0, this.A0);
                break;
            case 2:
                this.E1 = "中速模式";
                this.f659t0 = 70;
                o(this.f676z0, this.A0);
                break;
            case 3:
                this.E1 = " 高速模式";
                this.f659t0 = 100;
                o(this.f676z0, this.A0);
                break;
            case 4:
                this.E1 = "重力感应 on";
                this.N.setGravity(true);
                this.f662u0 = true;
                break;
            case 5:
                this.E1 = "重力感应 off";
                this.N.setGravity(false);
                this.f662u0 = false;
                break;
            case 6:
                this.E1 = " 校准";
                byte[] bArr = this.f654r0;
                bArr[10] = (byte) (bArr[10] | 128);
                w("矫正");
                this.A1.sendEmptyMessageDelayed(5, 1000L);
                break;
            case 7:
                this.E1 = "  图片翻转";
                this.f620f0 = !this.f620f0;
                break;
        }
        y(this.E1);
    }

    @Override // s2.j
    public final void b(int i3, String str) {
        runOnUiThread(new l(this, i3, str, 1));
    }

    @Override // e4.a
    public final void d(Hypothesis hypothesis) {
        if (hypothesis != null) {
            String Hypothesis_hypstr_get = PocketSphinxJNI.Hypothesis_hypstr_get(hypothesis.f1765a, hypothesis);
            Log.i("MainActivityDecode", " onResult text=" + Hypothesis_hypstr_get);
            if (this.f670x0) {
                Hypothesis_hypstr_get.getClass();
                s sVar = this.A1;
                byte[] bArr = this.f654r0;
                byte[] bArr2 = this.f656s0;
                char c = 65535;
                switch (Hypothesis_hypstr_get.hashCode()) {
                    case -1881579439:
                        if (Hypothesis_hypstr_get.equals("RECORD")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1390363677:
                        if (Hypothesis_hypstr_get.equals("BACKWARD")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 69715:
                        if (Hypothesis_hypstr_get.equals("FLY")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 705355:
                        if (Hypothesis_hypstr_get.equals("右飞")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 777242:
                        if (Hypothesis_hypstr_get.equals("录像")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 784312:
                        if (Hypothesis_hypstr_get.equals("左飞")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 813114:
                        if (Hypothesis_hypstr_get.equals("拍照")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1161799:
                        if (Hypothesis_hypstr_get.equals("起飞")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1226640:
                        if (Hypothesis_hypstr_get.equals("降落")) {
                            c = '\b';
                            break;
                        }
                        break;
                    case 2329067:
                        if (Hypothesis_hypstr_get.equals("LAND")) {
                            c = '\t';
                            break;
                        }
                        break;
                    case 2332679:
                        if (Hypothesis_hypstr_get.equals("LEFT")) {
                            c = '\n';
                            break;
                        }
                        break;
                    case 21371647:
                        if (Hypothesis_hypstr_get.equals("向前进")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 21385603:
                        if (Hypothesis_hypstr_get.equals("向后退")) {
                            c = '\f';
                            break;
                        }
                        break;
                    case 40836773:
                        if (Hypothesis_hypstr_get.equals("FORWARD")) {
                            c = '\r';
                            break;
                        }
                        break;
                    case 76105234:
                        if (Hypothesis_hypstr_get.equals("PHOTO")) {
                            c = 14;
                            break;
                        }
                        break;
                    case 77974001:
                        if (Hypothesis_hypstr_get.equals("RIGHI")) {
                            c = 15;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                    case 4:
                        this.D.performClick();
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        return;
                    case 1:
                    case '\f':
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        if (this.f610a1) {
                            bArr2[8] = (byte) (bArr2[8] - 60);
                            Log.d("MainActivityDecode", "controlDataOpflow[8]=" + ((int) bArr2[8]));
                            w("mRightRocker");
                            return;
                        }
                        bArr[7] = (byte) (bArr[7] - 60);
                        Log.d("MainActivityDecode", "controlData[7]=" + ((int) bArr[7]));
                        w("mRightRocker");
                        if (this.f612b1) {
                            sVar.sendEmptyMessageDelayed(13, 5000L);
                            return;
                        }
                        return;
                    case 2:
                    case 7:
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        this.f669x.performClick();
                        return;
                    case 3:
                    case 15:
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        if (this.f610a1) {
                            bArr2[7] = (byte) (bArr2[7] + 60);
                            Log.d("MainActivityDecode", "controlDataOpflow[7]=" + ((int) bArr2[7]));
                            w("mRightRocker");
                            return;
                        }
                        bArr[6] = (byte) (bArr[6] + 60);
                        Log.d("MainActivityDecode", "controlData[6]=" + ((int) bArr[6]));
                        w("mRightRocker");
                        if (this.f612b1) {
                            sVar.sendEmptyMessageDelayed(14, 5000L);
                            return;
                        }
                        return;
                    case 5:
                    case '\n':
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        if (this.f610a1) {
                            bArr2[7] = (byte) (bArr2[7] - 60);
                            Log.d("MainActivityDecode", "controlDataOpflow[7]=" + ((int) bArr2[7]));
                            w("mRightRocker");
                            return;
                        }
                        bArr[6] = (byte) (bArr[6] - 60);
                        Log.d("MainActivityDecode", "controlData[6]=" + ((int) bArr[6]));
                        w("mRightRocker");
                        if (this.f612b1) {
                            sVar.sendEmptyMessageDelayed(14, 5000L);
                            return;
                        }
                        return;
                    case 6:
                    case 14:
                        this.s.performClick();
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        return;
                    case '\b':
                    case '\t':
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        this.f672y.performClick();
                        return;
                    case 11:
                    case '\r':
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        if (this.f610a1) {
                            bArr2[8] = (byte) (bArr2[8] + 60);
                            Log.d("MainActivityDecode", "controlDataOpflow[8]=" + ((int) bArr2[8]));
                            w("mRightRocker");
                            return;
                        }
                        bArr[7] = (byte) (bArr[7] + 60);
                        Log.d("MainActivityDecode", "controlData[6]x=" + ((int) bArr[7]));
                        w("mRightRocker");
                        if (this.f612b1) {
                            sVar.sendEmptyMessageDelayed(13, 5000L);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Override // s2.e
    public final void e(byte[] bArr, int i3) {
        Log.d("MainActivityDecode", "光流数据长度data=" + bArr.length + " length=" + i3);
        StringBuilder sb = new StringBuilder("收到光流data[0]=");
        sb.append((int) bArr[0]);
        sb.append(" data[1]=");
        sb.append((int) bArr[1]);
        sb.append(" data[2]=");
        sb.append((int) bArr[2]);
        sb.append(" data[3]=");
        sb.append((int) bArr[3]);
        sb.append(" data[4]=");
        sb.append((int) bArr[4]);
        sb.append(" data[5]=");
        sb.append((int) bArr[5]);
        sb.append(" data[6]=");
        sb.append((int) bArr[6]);
        sb.append(" data[7]=");
        sb.append((int) bArr[7]);
        sb.append(" data[8]=");
        a1.i.u(sb, bArr[8], "MainActivityDecode");
        if (!this.f663u1) {
            return;
        }
        runOnUiThread(new c0(9, this, bArr));
    }

    @Override // e4.a
    public final void f(Hypothesis hypothesis) {
        if (hypothesis == null) {
            return;
        }
        String Hypothesis_hypstr_get = PocketSphinxJNI.Hypothesis_hypstr_get(hypothesis.f1765a, hypothesis);
        this.f666v1.d();
        this.f666v1.c();
        Log.i("MainActivityDecode", " onPartialResult text=" + Hypothesis_hypstr_get);
    }

    @Override // e4.a
    public final void g() {
        Log.d("MainActivityDecode", "onBeginningOfSpeech");
    }

    @Override // v2.c
    public final void h() {
        if (!v()) {
            y(getResources().getString(2131755085));
            return;
        }
        if (this.f610a1) {
            byte[] bArr = this.f656s0;
            bArr[11] = (byte) (bArr[11] | 2);
        } else {
            byte[] bArr2 = this.f654r0;
            bArr2[10] = (byte) (bArr2[10] | 4);
        }
        w("btStop");
        this.A1.sendEmptyMessageDelayed(4, 1000L);
    }

    @Override // s2.a
    public final void j(byte[] bArr, int i3) {
        if (this.f646o0.isShutdown()) {
            return;
        }
        this.f646o0.execute(new l(this, bArr, i3, 2));
    }

    @Override // e4.a
    public final void k() {
        StringBuilder sb = new StringBuilder(" onEndOfSpeech recognizer.getSearchName()=");
        Decoder decoder = this.f666v1.f1759a;
        sb.append(PocketSphinxJNI.Decoder_getSearch(decoder.f1764a, decoder));
        Log.i("MainActivityDecode", sb.toString());
    }

    public final void m() {
        c1.b bVar = this.X0;
        boolean z3 = this.f620f0;
        SharedPreferences.Editor editor = (SharedPreferences.Editor) bVar.c;
        editor.putBoolean("isRotate", z3);
        editor.commit();
        e4.h hVar = this.f666v1;
        if (hVar != null) {
            if (hVar.e()) {
                Log.i("h", "Cancel recognition");
            }
            this.f666v1.c.release();
        }
        i iVar = this.f611b0;
        iVar.f3529l = true;
        iVar.d(false);
        this.f611b0.a();
        this.f613c0.a();
        Log.d("MainActivityDecode", " finish()");
        finish();
    }

    public final void n(int i3) {
        int i5;
        int v5;
        int i6 = this.f659t0;
        if (i6 != 40) {
            if (i6 == 70) {
                int i7 = this.f614c1;
                if (i7 != 2 && i7 != 9 && i7 != 11 && i7 != 14) {
                    if (i3 > 128) {
                        i3 = a1.i.c(i3, 128, 2, 128);
                    } else {
                        i3 = a1.i.y(128, i3, 2, 128);
                    }
                } else if (i3 > 128) {
                    i5 = ((i3 - 128) * 4) / 5;
                    i3 = i5 + 128;
                } else {
                    i3 = a1.i.d(128, i3, 4, 5, 128);
                }
            }
        } else {
            int i8 = this.f614c1;
            if (i8 != 2 && i8 != 9 && i8 != 11 && i8 != 14) {
                if (i3 > 128) {
                    i3 = a1.i.c(i3, 128, 3, 128);
                } else {
                    i3 = a1.i.y(128, i3, 3, 128);
                }
            } else if (i3 > 128) {
                i5 = ((i3 - 128) * 3) / 5;
                i3 = i5 + 128;
            } else {
                i3 = a1.i.d(128, i3, 3, 5, 128);
            }
        }
        int i9 = this.f630j;
        if (i9 < 16) {
            if (i3 < (16 - i9) * 2) {
                v5 = 0;
            } else {
                v5 = t2.h.b(16, i9, 2, i3);
            }
        } else if (255 - i3 < (i9 - 16) * 2) {
            v5 = 255;
        } else {
            v5 = a1.i.v(i9, 16, 2, i3);
        }
        if (this.f610a1) {
            this.f656s0[8] = (byte) v5;
            return;
        }
        this.f654r0[7] = (byte) v5;
    }

    public final void o(int i3, int i5) {
        int i6;
        int v5;
        int i7 = this.f659t0;
        if (i7 != 40) {
            if (i7 == 70) {
                int i8 = this.f614c1;
                if (i8 != 2 && i8 != 9 && i8 != 11 && i8 != 14) {
                    if (i3 > 128) {
                        i3 = a1.i.c(i3, 128, 2, 128);
                    } else {
                        i3 = a1.i.y(128, i3, 2, 128);
                    }
                    if (i5 > 128) {
                        i5 = a1.i.c(i5, 128, 2, 128);
                    } else {
                        i5 = a1.i.y(128, i5, 2, 128);
                    }
                } else {
                    if (i3 > 128) {
                        i3 = (((i3 - 128) * 4) / 5) + 128;
                    } else {
                        i3 = a1.i.d(128, i3, 4, 5, 128);
                    }
                    if (i5 > 128) {
                        i6 = ((i5 - 128) * 4) / 5;
                        i5 = i6 + 128;
                    } else {
                        i5 = a1.i.d(128, i5, 4, 5, 128);
                    }
                }
            }
        } else {
            int i9 = this.f614c1;
            if (i9 != 2 && i9 != 9 && i9 != 11 && i9 != 14) {
                if (i3 > 128) {
                    i3 = a1.i.c(i3, 128, 3, 128);
                } else {
                    i3 = a1.i.y(128, i3, 3, 128);
                }
                if (i5 > 128) {
                    i5 = a1.i.c(i5, 128, 3, 128);
                } else {
                    i5 = a1.i.y(128, i5, 3, 128);
                }
            } else {
                if (i3 > 128) {
                    i3 = (((i3 - 128) * 3) / 5) + 128;
                } else {
                    i3 = a1.i.d(128, i3, 3, 5, 128);
                }
                if (i5 > 128) {
                    i6 = ((i5 - 128) * 3) / 5;
                    i5 = i6 + 128;
                } else {
                    i5 = a1.i.d(128, i5, 3, 5, 128);
                }
            }
        }
        a1.i.x("speedValuex=", i3, "MainActivityDecode");
        int i10 = this.f630j;
        int i11 = 0;
        if (i10 < 16) {
            if (i5 < (16 - i10) * 2) {
                v5 = 0;
            } else {
                v5 = t2.h.b(16, i10, 2, i5);
            }
        } else if (255 - i5 < (i10 - 16) * 2) {
            v5 = 255;
        } else {
            v5 = a1.i.v(i10, 16, 2, i5);
        }
        int i12 = this.f628i;
        if (i12 < 16) {
            if (i3 >= (16 - i12) * 2) {
                i11 = t2.h.b(16, i12, 2, i3);
            }
        } else if (255 - i3 < (i12 - 16) * 2) {
            i11 = 255;
        } else {
            i11 = a1.i.v(i12, 16, 2, i3);
        }
        a1.i.x("adjustRx=", i11, "MainActivityDecode");
        if (this.f610a1) {
            byte[] bArr = this.f656s0;
            bArr[8] = (byte) v5;
            bArr[7] = (byte) i11;
            Log.d("MainActivityDecode", "controlDataOpflow[7]x=" + ((int) bArr[7]));
            w("mRightRocker");
            return;
        }
        byte b = (byte) v5;
        byte[] bArr2 = this.f654r0;
        bArr2[7] = b;
        bArr2[6] = (byte) i11;
        Log.d("MainActivityDecode", "controlData[6]x=" + ((int) bArr2[6]));
        w("mRightRocker");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i3, int i5, Intent intent) {
        super.onActivityResult(i3, i5, intent);
        if (i3 == 1 && i5 == 2) {
            MusicInfo musicInfo = (MusicInfo) intent.getParcelableExtra("MusicInfo");
            this.S0 = musicInfo;
            if (musicInfo != null && !TextUtils.isEmpty(musicInfo.path)) {
                this.R0.setVisibility(0);
                this.Q0.setBackground(getDrawable(2131558596));
                Log.d("MainActivityDecode", "已选:" + this.S0.toString());
                return;
            }
            this.Q0.setBackground(getDrawable(2131558595));
            this.R0.setVisibility(8);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [a1.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.f626h0) {
            ?? obj = new Object();
            obj.b = null;
            obj.f39a = com.bumptech.glide.e.a(this).widthPixels / 3;
            String string = getString(2131755392);
            String string2 = getString(2131755391);
            String string3 = getString(2131755385);
            String string4 = getString(2131755386);
            o oVar = new o(this, 1);
            ?? centerPopupView = new CenterPopupView(this);
            centerPopupView.F = false;
            centerPopupView.q = 0;
            centerPopupView.p();
            centerPopupView.f1084x = string;
            centerPopupView.f1085y = string2;
            centerPopupView.f1086z = null;
            centerPopupView.A = string3;
            centerPopupView.B = string4;
            centerPopupView.s = oVar;
            centerPopupView.F = false;
            centerPopupView.f1034a = obj;
            centerPopupView.o();
            return;
        }
        m();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a1.i.u(new StringBuilder("onConfigurationChanged  --"), configuration.orientation, "MainActivityDecode");
        if (configuration.orientation == 2) {
            this.I.setBackground(getDrawable(2131558413));
            this.f671x1 = true;
            if (this.P0.isChecked()) {
                if (this.V0) {
                    this.f645o.setVisibility(0);
                    this.O.setShow(true);
                    this.P.setShow(true);
                } else {
                    this.f642n.setVisibility(0);
                    this.M.setShow(true);
                    this.N.setShow(true);
                }
                this.f622g.setVisibility(0);
                this.f636l.setVisibility(0);
            }
        } else {
            this.I.setBackground(getDrawable(2131558414));
            this.f671x1 = false;
            if (this.P0.isChecked()) {
                if (this.V0) {
                    this.f645o.setVisibility(8);
                } else {
                    this.f642n.setVisibility(8);
                }
                this.f622g.setVisibility(4);
                this.f636l.setVisibility(4);
            }
        }
        x(this.f671x1);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d("MainActivityDecode", "onCreate");
        setContentView(2131427388);
        PictureAndVideoUtil pictureAndVideoUtil = PictureAndVideoUtil.getInstance();
        this.c = pictureAndVideoUtil;
        pictureAndVideoUtil.initFFmpeg();
        this.X0 = new c1.b(this, 22);
        Button button = (Button) findViewById(2131230876);
        this.f650p1 = button;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.f652q1 = (LinearLayout) findViewById(2131231110);
        SignSeekBar signSeekBar = (SignSeekBar) findViewById(2131231135);
        this.f660t1 = signSeekBar;
        signSeekBar.setOnProgressChangedListener(new o(this, 2));
        this.f655r1 = (RadioGroup) findViewById(2131231298);
        this.f657s1 = (RadioGroup) findViewById(2131231299);
        RadioButton radioButton = (RadioButton) findViewById(2131231274);
        RadioButton radioButton2 = (RadioButton) findViewById(2131231275);
        RadioButton radioButton3 = (RadioButton) findViewById(2131231276);
        RadioButton radioButton4 = (RadioButton) findViewById(2131231277);
        findViewById(2131230867).setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        findViewById(2131230880).setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        boolean t4 = this.X0.t("isShowOpticalFlowView");
        this.f663u1 = t4;
        if (t4) {
            this.f650p1.setVisibility(0);
        } else {
            this.f650p1.setVisibility(8);
            this.f652q1.setVisibility(8);
        }
        this.f620f0 = ((SharedPreferences) this.X0.b).getBoolean("isRotate", true);
        this.V0 = this.X0.t("isRightMode");
        Log.d("MainActivityDecode", "isRightMode=" + this.V0);
        this.f616e = true;
        h3.b.f().c(this);
        getWindow().addFlags(128);
        this.f619f = (WifiManager) getApplication().getApplicationContext().getSystemService("wifi");
        BatteryView batteryView = (BatteryView) findViewById(2131231125);
        this.K0 = batteryView;
        batteryView.setLevelHeight(50);
        this.K0.setVisibility(8);
        this.q = (ImageView) findViewById(2131231288);
        ((TextView) findViewById(2131231305)).setVisibility(8);
        ((TextView) findViewById(2131231096)).setVisibility(8);
        ((TextView) findViewById(2131231462)).setVisibility(8);
        ((TextView) findViewById(2131231475)).setVisibility(8);
        ((TextView) findViewById(2131231463)).setVisibility(8);
        CheckBox checkBox = (CheckBox) findViewById(2131230900);
        this.L0 = checkBox;
        checkBox.setOnCheckedChangeListener(this.K1);
        CheckBox checkBox2 = (CheckBox) findViewById(2131230905);
        this.P0 = checkBox2;
        checkBox2.setOnCheckedChangeListener(this.K1);
        this.R0 = (ImageView) findViewById(2131231085);
        CustomButton customButton = (CustomButton) findViewById(2131230860);
        this.Q0 = customButton;
        customButton.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CheckBox checkBox3 = (CheckBox) findViewById(2131230916);
        this.M0 = checkBox3;
        checkBox3.setOnCheckedChangeListener(this.K1);
        CheckBox checkBox4 = (CheckBox) findViewById(2131230901);
        this.N0 = checkBox4;
        checkBox4.setOnCheckedChangeListener(this.K1);
        CheckBox checkBox5 = (CheckBox) findViewById(2131230898);
        this.O0 = checkBox5;
        checkBox5.setOnCheckedChangeListener(this.K1);
        this.L0.setChecked(false);
        this.W = (ZoomView) findViewById(2131231153);
        this.U = (ImageView) findViewById(2131231081);
        this.V = (ImageView) findViewById(2131231082);
        this.X = (RelativeLayout) findViewById(2131231310);
        VerticalRangeSeekBar verticalRangeSeekBar = (VerticalRangeSeekBar) findViewById(2131231521);
        this.Y = verticalRangeSeekBar;
        verticalRangeSeekBar.setOnRangeChangedListener(new o(this, 4));
        if (getResources().getConfiguration().locale.getCountry().equals("CN")) {
            this.f668w1 = true;
        } else {
            this.f668w1 = false;
        }
        this.K = (TextView) findViewById(2131231485);
        this.L = (TextView) findViewById(2131231290);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131231289);
        this.f639m = linearLayout;
        linearLayout.setVisibility(4);
        this.f633k = (LinearLayout) findViewById(2131231130);
        this.f642n = (LinearLayout) findViewById(2131231313);
        this.f645o = (LinearLayout) findViewById(2131231314);
        this.f636l = (LinearLayout) findViewById(2131231209);
        CustomButton customButton2 = (CustomButton) findViewById(2131230836);
        this.C = customButton2;
        customButton2.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton3 = (CustomButton) findViewById(2131230874);
        this.B = customButton3;
        customButton3.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton4 = (CustomButton) findViewById(2131230875);
        this.A = customButton4;
        customButton4.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton5 = (CustomButton) findViewById(2131230848);
        this.J = customButton5;
        customButton5.setVisibility(4);
        this.J.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton6 = (CustomButton) findViewById(2131230881);
        this.f675z = customButton6;
        customButton6.setVisibility(4);
        this.f675z.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton7 = (CustomButton) findViewById(2131230861);
        this.I = customButton7;
        customButton7.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton8 = (CustomButton) findViewById(2131230852);
        this.f669x = customButton8;
        customButton8.setVisibility(4);
        this.f669x.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton9 = (CustomButton) findViewById(2131230851);
        this.f672y = customButton9;
        customButton9.setVisibility(4);
        this.f672y.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton10 = (CustomButton) findViewById(2131230846);
        this.f664v = customButton10;
        customButton10.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        ((HTrimView) findViewById(2131231456)).setOnTrimViewInterface(new n(this, 5));
        ((HTrimView) findViewById(2131231457)).setOnTrimViewInterface(new n(this, 6));
        VTrimView vTrimView = (VTrimView) findViewById(2131231458);
        this.f622g = vTrimView;
        vTrimView.setOnTrimViewInterface(new n(this, 7));
        CustomButton customButton11 = (CustomButton) findViewById(2131230839);
        this.w = customButton11;
        customButton11.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        TrackControlPaintViewJY trackControlPaintViewJY = (TrackControlPaintViewJY) findViewById(2131231152);
        this.R = trackControlPaintViewJY;
        trackControlPaintViewJY.setOnLocaListener(new n(this, 8));
        this.T = (LinearLayout) findViewById(2131231151);
        TrackControlPaintView trackControlPaintView = (TrackControlPaintView) findViewById(2131231149);
        this.Q = trackControlPaintView;
        trackControlPaintView.setOnLocaListener(new n(this, 9));
        this.S = (LinearLayout) findViewById(2131231150);
        this.f648p = (LinearLayout) findViewById(2131231111);
        CustomButton customButton12 = (CustomButton) findViewById(2131230877);
        this.G = customButton12;
        customButton12.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.N = (MyRockerView) findViewById(2131231132);
        this.P = (MyRockerView) findViewById(2131231133);
        this.M = (MyRockerView) findViewById(2131231128);
        this.O = (MyRockerView) findViewById(2131231129);
        this.N.setOnLocaListener(new n(this, 10));
        this.P.setOnLocaListener(new n(this, 11));
        this.M.setOnLocaListener(new n(this, 0));
        this.O.setOnLocaListener(new n(this, 1));
        this.f642n.setVisibility(8);
        this.f645o.setVisibility(8);
        this.f653r = (CustomButton) findViewById(2131230842);
        this.f661u = (CustomButton) findViewById(2131230849);
        this.f658t = (CustomButton) findViewById(2131230869);
        if (this.f620f0) {
            this.f658t.setBackground(getResources().getDrawable(2131558476));
        } else {
            this.f658t.setBackground(getResources().getDrawable(2131558477));
        }
        this.s = (CustomButton) findViewById(2131230838);
        this.D = (CustomButton) findViewById(2131230868);
        this.E = (CustomButton) findViewById(2131230859);
        this.F = (CustomButton) findViewById(2131230872);
        this.H = (CustomButton) findViewById(2131230879);
        this.f653r.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.f661u.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.f658t.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.H0 = new v3.c(this);
        String[] strArr = Build.VERSION.SDK_INT >= 33 ? new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"} : new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        p4.m a5 = d.a(this.s);
        v3.c cVar = this.H0;
        cVar.getClass();
        a5.d(new v3.b(cVar, strArr)).g(new o4.b(new n(this, 2)));
        p4.m a6 = d.a(this.D);
        v3.c cVar2 = this.H0;
        cVar2.getClass();
        a6.d(new v3.b(cVar2, strArr)).g(new o4.b(new n(this, 3)));
        this.E.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        p4.m a7 = d.a(this.H);
        v3.c cVar3 = this.H0;
        cVar3.getClass();
        a7.d(new v3.b(cVar3, new String[]{"android.permission.RECORD_AUDIO"})).g(new o4.b(new n(this, 4)));
        this.F.setOnClickListener(new View.OnClickListener(this) { // from class: t2.m
            public final /* synthetic */ MainActivityDecode b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                switch (r2) {
                    case 0:
                        MainActivityDecode mainActivityDecode = this.b;
                        if (mainActivityDecode.f626h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityDecode).widthPixels / 3;
                            String string = mainActivityDecode.getString(2131755392);
                            String string2 = mainActivityDecode.getString(2131755391);
                            String string3 = mainActivityDecode.getString(2131755385);
                            String string4 = mainActivityDecode.getString(2131755386);
                            o oVar = new o(mainActivityDecode, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityDecode);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = oVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityDecode.startActivityForResult(new Intent(mainActivityDecode, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i6 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode2 = this.b;
                        if (!mainActivityDecode2.v()) {
                            mainActivityDecode2.y(mainActivityDecode2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode2.f613c0.c(false);
                        boolean z3 = mainActivityDecode2.f610a1;
                        j0.s sVar = mainActivityDecode2.A1;
                        if (z3) {
                            byte[] bArr = mainActivityDecode2.f656s0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityDecode2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityDecode2.f654r0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityDecode2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityDecode mainActivityDecode3 = this.b;
                        if (mainActivityDecode3.f626h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityDecode3).widthPixels / 3;
                            String string5 = mainActivityDecode3.getString(2131755392);
                            String string6 = mainActivityDecode3.getString(2131755391);
                            String string7 = mainActivityDecode3.getString(2131755385);
                            String string8 = mainActivityDecode3.getString(2131755386);
                            o oVar2 = new o(mainActivityDecode3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityDecode3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = oVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityDecode3.m();
                        return;
                    case 3:
                        MainActivityDecode mainActivityDecode4 = this.b;
                        if (mainActivityDecode4.f626h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityDecode4).widthPixels / 3;
                            String string9 = mainActivityDecode4.getString(2131755392);
                            String string10 = mainActivityDecode4.getString(2131755391);
                            String string11 = mainActivityDecode4.getString(2131755385);
                            String string12 = mainActivityDecode4.getString(2131755386);
                            o oVar3 = new o(mainActivityDecode4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityDecode4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = oVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityDecode4.startActivity(new Intent(mainActivityDecode4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityDecode mainActivityDecode5 = this.b;
                        int i7 = MainActivityDecode.M1;
                        if (!mainActivityDecode5.v()) {
                            mainActivityDecode5.y(mainActivityDecode5.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode5.f620f0 = !mainActivityDecode5.f620f0;
                        if (mainActivityDecode5.f620f0) {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558476));
                            return;
                        } else {
                            mainActivityDecode5.f658t.setBackground(mainActivityDecode5.getResources().getDrawable(2131558477));
                            return;
                        }
                    case 5:
                        MainActivityDecode mainActivityDecode6 = this.b;
                        int i8 = MainActivityDecode.M1;
                        if (!mainActivityDecode6.v()) {
                            mainActivityDecode6.y(mainActivityDecode6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode6.f629i0) {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558534));
                        } else {
                            mainActivityDecode6.E.setBackground(mainActivityDecode6.getDrawable(2131558533));
                        }
                        mainActivityDecode6.f629i0 = !mainActivityDecode6.f629i0;
                        return;
                    case 6:
                        MainActivityDecode mainActivityDecode7 = this.b;
                        if (mainActivityDecode7.f673y0) {
                            mainActivityDecode7.y(mainActivityDecode7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityDecode7.f662u0) {
                            mainActivityDecode7.f662u0 = false;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(false);
                                mainActivityDecode7.P.setStopUI(false);
                                mainActivityDecode7.O.setStopUI(false);
                            } else {
                                mainActivityDecode7.N.setGravity(false);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityDecode7.O0.isChecked()) {
                            mainActivityDecode7.f662u0 = true;
                            if (mainActivityDecode7.V0) {
                                mainActivityDecode7.P.setGravity(true);
                                mainActivityDecode7.P.setStopUI(true);
                                mainActivityDecode7.O.setStopUI(true);
                            } else {
                                mainActivityDecode7.N.setGravity(true);
                            }
                            mainActivityDecode7.F.setBackground(mainActivityDecode7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityDecode7.y(mainActivityDecode7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i9 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode8 = this.b;
                        if (!mainActivityDecode8.v()) {
                            mainActivityDecode8.y(mainActivityDecode8.getResources().getString(2131755085));
                            return;
                        }
                        int i10 = mainActivityDecode8.f659t0;
                        if (i10 == 40) {
                            mainActivityDecode8.f659t0 = 70;
                            i3 = 2131558456;
                        } else if (i10 == 70) {
                            mainActivityDecode8.f659t0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i10 == 100) {
                                mainActivityDecode8.f659t0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityDecode8.B.setBackground(mainActivityDecode8.getDrawable(i3));
                        mainActivityDecode8.o(mainActivityDecode8.f676z0, mainActivityDecode8.A0);
                        return;
                    case 8:
                        this.b.I0.a();
                        return;
                    case 9:
                        int i11 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode9 = this.b;
                        if (!mainActivityDecode9.v()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityDecode9.O0.isChecked()) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityDecode9.f662u0) {
                            mainActivityDecode9.y(mainActivityDecode9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityDecode9.f610a1) {
                            mainActivityDecode9.f673y0 = true;
                            byte[] bArr3 = mainActivityDecode9.f656s0;
                            bArr3[11] = (byte) (bArr3[11] | 8);
                            mainActivityDecode9.w("isFanGun--isOpflow" + mainActivityDecode9.f610a1);
                            mainActivityDecode9.A1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityDecode9.f673y0) {
                            byte[] bArr4 = mainActivityDecode9.f654r0;
                            bArr4[10] = (byte) (bArr4[10] & (-9));
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558506));
                            mainActivityDecode9.f673y0 = false;
                            mainActivityDecode9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityDecode9.J.setBackground(mainActivityDecode9.getResources().getDrawable(2131558505));
                            mainActivityDecode9.f673y0 = true;
                            mainActivityDecode9.E0 = false;
                            return;
                        }
                    case 10:
                        int i12 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode10 = this.b;
                        if (!mainActivityDecode10.v()) {
                            mainActivityDecode10.y(mainActivityDecode10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityDecode10.f610a1) {
                            boolean z5 = mainActivityDecode10.f667w0;
                            byte[] bArr5 = mainActivityDecode10.f656s0;
                            if (z5) {
                                bArr5[12] = (byte) (bArr5[12] & (-2));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr5[12] = (byte) (bArr5[12] | 1);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityDecode10.f667w0;
                            byte[] bArr6 = mainActivityDecode10.f654r0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityDecode10.f675z.setBackground(mainActivityDecode10.getDrawable(2131558495));
                            }
                        }
                        mainActivityDecode10.f667w0 = !mainActivityDecode10.f667w0;
                        mainActivityDecode10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityDecode mainActivityDecode11 = this.b;
                        if (mainActivityDecode11.O0.isChecked()) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755167));
                            return;
                        } else if (mainActivityDecode11.f629i0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755169));
                            return;
                        } else if (mainActivityDecode11.f662u0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755168));
                            return;
                        } else if (mainActivityDecode11.f626h0) {
                            mainActivityDecode11.y(mainActivityDecode11.getString(2131755348));
                            return;
                        } else if (mainActivityDecode11.f671x1) {
                            if (mainActivityDecode11.getRequestedOrientation() != 1) {
                                mainActivityDecode11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityDecode11.getRequestedOrientation() != 0) {
                            mainActivityDecode11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i13 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode12 = this.b;
                        if (!mainActivityDecode12.v()) {
                            mainActivityDecode12.y(mainActivityDecode12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode12.f613c0.c(false);
                        boolean z7 = mainActivityDecode12.f610a1;
                        j0.s sVar2 = mainActivityDecode12.A1;
                        if (z7) {
                            byte[] bArr7 = mainActivityDecode12.f656s0;
                            bArr7[11] = (byte) (1 | bArr7[11]);
                            mainActivityDecode12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityDecode12.f654r0;
                        bArr8[10] = (byte) (1 | bArr8[10]);
                        mainActivityDecode12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i14 = MainActivityDecode.M1;
                        MainActivityDecode mainActivityDecode13 = this.b;
                        if (!mainActivityDecode13.v()) {
                            mainActivityDecode13.y(mainActivityDecode13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityDecode13.f613c0.c(false);
                        boolean z8 = mainActivityDecode13.f610a1;
                        j0.s sVar3 = mainActivityDecode13.A1;
                        if (z8) {
                            byte[] bArr9 = mainActivityDecode13.f656s0;
                            bArr9[11] = (byte) (1 | bArr9[11]);
                            mainActivityDecode13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityDecode13.f654r0;
                        bArr10[10] = (byte) (bArr10[10] | 2);
                        mainActivityDecode13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityDecode mainActivityDecode14 = this.b;
                        if (mainActivityDecode14.f665v0) {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558510));
                            mainActivityDecode14.f669x.setVisibility(4);
                            mainActivityDecode14.f672y.setVisibility(4);
                        } else {
                            mainActivityDecode14.f664v.setBackground(mainActivityDecode14.getDrawable(2131558509));
                            mainActivityDecode14.f669x.setVisibility(0);
                            mainActivityDecode14.f672y.setVisibility(0);
                        }
                        mainActivityDecode14.f665v0 = !mainActivityDecode14.f665v0;
                        return;
                    case 15:
                        MainActivityDecode mainActivityDecode15 = this.b;
                        if (mainActivityDecode15.f652q1.getVisibility() == 8) {
                            mainActivityDecode15.f652q1.setVisibility(0);
                            mainActivityDecode15.f650p1.setText("隐藏");
                            return;
                        }
                        mainActivityDecode15.f652q1.setVisibility(8);
                        mainActivityDecode15.f650p1.setText("显示");
                        return;
                    case 16:
                        this.b.f613c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityDecode mainActivityDecode16 = this.b;
                        int i15 = -1;
                        if (mainActivityDecode16.f655r1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityDecode16.f657s1.getCheckedRadioButtonId() != 2131231276) {
                            i15 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i15, " sensitive="), mainActivityDecode16.L1, "MainActivityDecode");
                        byte b = (byte) i5;
                        byte b5 = (byte) i15;
                        byte b6 = (byte) mainActivityDecode16.L1;
                        mainActivityDecode16.f613c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityDecode mainActivityDecode17 = this.b;
                        if (mainActivityDecode17.f626h0) {
                            mainActivityDecode17.y(mainActivityDecode17.getString(2131755348));
                            return;
                        } else if (mainActivityDecode17.W0) {
                            mainActivityDecode17.f611b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityDecode mainActivityDecode18 = this.b;
                        int ordinal = mainActivityDecode18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558631));
                                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558635));
                                    mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558634));
                                mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558633));
                            mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityDecode18.G.setBackground(mainActivityDecode18.getDrawable(2131558632));
                        mainActivityDecode18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.f640m0 = new ByteArrayOutputStream();
        this.f643n0 = new ArrayList();
        this.f646o0 = Executors.newSingleThreadExecutor();
        this.f651q0 = Executors.newSingleThreadExecutor();
        this.f649p0 = Executors.newFixedThreadPool(5);
        i iVar = new i(this, this, this, this);
        this.f611b0 = iVar;
        iVar.d(true);
        this.f611b0.c();
        Log.d("MainActivityDecode", "设备初始化默认已连接");
        this.f613c0 = new h();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        registerReceiver(this.D1, intentFilter);
        this.A.setVisibility(8);
        this.f633k.setVisibility(8);
        this.f622g.setVisibility(4);
        this.f636l.setVisibility(4);
        if (this.J0 == null) {
            v2.b bVar = new v2.b(this);
            this.J0 = bVar;
            bVar.d = this;
        }
        this.I0 = new b(this);
        b bVar2 = new b(this);
        this.I0 = bVar2;
        bVar2.c = this;
        if (!MyApplication.f541h) {
            g3.b.a(getApplicationContext(), new j3.a(25));
        }
        this.T0 = new g3.e(this, new o(this, 0));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.D1);
        this.f646o0.shutdown();
        this.f649p0.shutdown();
        this.f651q0.shutdown();
        e4.h hVar = this.f666v1;
        if (hVar != null) {
            if (hVar.e()) {
                Log.i("h", "Cancel recognition");
            }
            this.f666v1.c.release();
        }
        Log.d("MainActivityDecode", " onDestroy()");
    }

    @Override // e4.a
    public final void onError(Exception exc) {
        Log.i("MainActivityDecode", " onError getMessage=" + exc.getMessage());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.V0) {
            this.P.c();
        } else {
            this.N.c();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        Log.d("MainActivityDecode", "onStop");
        if (this.f626h0) {
            this.D.performClick();
        }
        if (this.V0) {
            this.P.e();
        } else {
            this.N.e();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        if (z3) {
            h3.b.f().b(this);
        }
        super.onWindowFocusChanged(z3);
    }

    public final void p(int i3) {
        int i5;
        int v5;
        int i6 = this.f659t0;
        if (i6 != 40) {
            if (i6 == 70) {
                int i7 = this.f614c1;
                if (i7 != 2 && i7 != 9 && i7 != 11 && i7 != 14) {
                    if (i3 > 128) {
                        i3 = a1.i.c(i3, 128, 2, 128);
                    } else {
                        i3 = a1.i.y(128, i3, 2, 128);
                    }
                } else if (i3 > 128) {
                    i5 = ((i3 - 128) * 4) / 5;
                    i3 = i5 + 128;
                } else {
                    i3 = a1.i.d(128, i3, 4, 5, 128);
                }
            }
        } else {
            int i8 = this.f614c1;
            if (i8 != 2 && i8 != 9 && i8 != 11 && i8 != 14) {
                if (i3 > 128) {
                    i3 = a1.i.c(i3, 128, 3, 128);
                } else {
                    i3 = a1.i.y(128, i3, 3, 128);
                }
            } else if (i3 > 128) {
                i5 = ((i3 - 128) * 3) / 5;
                i3 = i5 + 128;
            } else {
                i3 = a1.i.d(128, i3, 3, 5, 128);
            }
        }
        a1.i.x("speedValuex=", i3, "MainActivityDecode");
        int i9 = this.f628i;
        if (i9 < 16) {
            if (i3 < (16 - i9) * 2) {
                v5 = 0;
            } else {
                v5 = t2.h.b(16, i9, 2, i3);
            }
        } else if (255 - i3 < (i9 - 16) * 2) {
            v5 = 255;
        } else {
            v5 = a1.i.v(i9, 16, 2, i3);
        }
        a1.i.x("adjustRx=", v5, "MainActivityDecode");
        if (this.f610a1) {
            byte[] bArr = this.f656s0;
            bArr[7] = (byte) v5;
            a1.i.u(new StringBuilder("controlDataOpflow[7]x="), bArr[7], "MainActivityDecode");
            return;
        }
        byte[] bArr2 = this.f654r0;
        bArr2[6] = (byte) v5;
        a1.i.u(new StringBuilder("controlData[6]x="), bArr2[6], "MainActivityDecode");
    }

    public final void q(int i3) {
        int i5;
        this.A0 = i3;
        if (this.f610a1) {
            n(i3);
        } else if (this.f673y0) {
            if (this.F0 != 1) {
                boolean z3 = this.E0;
                byte[] bArr = this.f654r0;
                if (z3) {
                    bArr[10] = (byte) (bArr[10] | 8);
                    bArr[7] = (byte) this.C0;
                    Log.d("右杆y翻滚之后", "y--" + this.C0 + " originValue=" + i3);
                } else if (Math.abs(128 - i3) > 64) {
                    if (i3 > 128) {
                        i5 = 255;
                    } else {
                        i5 = 0;
                    }
                    this.E0 = true;
                    bArr[10] = (byte) (bArr[10] | 8);
                    bArr[7] = (byte) i5;
                    this.C0 = i5;
                    Log.d("右杆y触发翻滚时", "y--" + this.C0 + " originValue=" + i3);
                    this.F0 = 2;
                    this.A1.sendEmptyMessageDelayed(0, 600L);
                } else {
                    n(i3);
                }
            }
        } else if (!this.E0) {
            n(i3);
        }
    }

    public final void r(int i3) {
        int i5;
        this.f676z0 = i3;
        if (this.f610a1) {
            p(i3);
        } else if (this.f673y0) {
            if (this.F0 != 2) {
                boolean z3 = this.E0;
                byte[] bArr = this.f654r0;
                if (z3) {
                    bArr[10] = (byte) (bArr[10] | 8);
                    bArr[6] = (byte) this.B0;
                    Log.d("右杆x翻滚之后", "x--" + this.B0 + " originValue=" + i3);
                } else if (Math.abs(128 - i3) > 64) {
                    if (i3 > 128) {
                        i5 = 255;
                    } else {
                        i5 = 0;
                    }
                    this.E0 = true;
                    bArr[10] = (byte) (bArr[10] | 8);
                    bArr[6] = (byte) i5;
                    this.B0 = i5;
                    Log.d("右杆x触发翻滚时", "x--" + this.B0 + " originValue=" + i3);
                    this.F0 = 1;
                    this.A1.sendEmptyMessageDelayed(0, 600L);
                } else {
                    p(i3);
                }
            }
        } else if (!this.E0) {
            p(i3);
        }
    }

    public final void s(int i3) {
        if (this.f610a1) {
            this.f656s0[9] = (byte) i3;
            return;
        }
        byte[] bArr = this.f654r0;
        bArr[8] = (byte) i3;
        a1.i.u(new StringBuilder("data[y]="), bArr[8], "MainActivityDecode");
    }

    public final void t(int i3) {
        int v5;
        this.D0 = i3;
        int i5 = this.f625h;
        if (i5 < 16) {
            if (i3 < (16 - i5) * 2) {
                v5 = 0;
            } else {
                v5 = t2.h.b(16, i5, 2, i3);
            }
        } else if (255 - i3 < (i5 - 16) * 2) {
            v5 = 255;
        } else {
            v5 = a1.i.v(i5, 16, 2, i3);
        }
        if (this.f610a1) {
            byte[] bArr = this.f656s0;
            bArr[10] = (byte) v5;
            StringBuilder sb = new StringBuilder("发送控制油门");
            sb.append((int) bArr[9]);
            sb.append("转向");
            a1.i.u(sb, bArr[10], "MainActivityDecode");
            return;
        }
        this.f654r0[9] = (byte) v5;
    }

    public final boolean v() {
        String u5 = u(this.f619f.getConnectionInfo().getIpAddress());
        if (!u5.contains("192.168.28") && !u5.contains("192.168.25")) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r4v5 */
    public final void w(String str) {
        Log.d("MainActivityDecode谁发送", str);
        int i3 = 3;
        int i5 = 8;
        if (this.f610a1) {
            byte[] bArr = this.f656s0;
            byte b = bArr[7];
            while (i5 < 23) {
                i5++;
                b ^= bArr[i5];
            }
            bArr[23] = (byte) (b & 255);
            bArr[24] = -103;
            byte b5 = bArr[2];
            while (i3 < 25) {
                i3++;
                b5 ^= bArr[i3];
            }
            bArr[25] = (byte) (b5 & 255);
            if (this.f613c0 == null) {
                this.f613c0 = new h();
            }
            this.f613c0.d(bArr);
            StringBuilder sb = new StringBuilder("  controlDataOpflow[9]");
            sb.append((int) bArr[9]);
            sb.append("  controlDataOpflow[23]");
            a1.i.u(sb, bArr[23], "MainActivityDecode");
            return;
        }
        byte[] bArr2 = this.f654r0;
        byte b6 = bArr2[6];
        byte b7 = bArr2[7];
        byte b8 = bArr2[8];
        byte b9 = bArr2[9];
        byte b10 = bArr2[10];
        byte b11 = (byte) (((((b6 ^ b7) ^ b8) ^ b9) ^ b10) & 255);
        bArr2[11] = b11;
        bArr2[13] = (byte) ((((((((b6 ^ (((bArr2[3] ^ bArr2[2]) ^ bArr2[4]) ^ bArr2[5])) ^ b7) ^ b8) ^ b9) ^ b10) ^ b11) ^ bArr2[12]) & 255);
        if (this.f613c0 == null) {
            this.f613c0 = new h();
        }
        this.f613c0.d(bArr2);
        StringBuilder sb2 = new StringBuilder("  controlData[9]");
        sb2.append((int) bArr2[9]);
        sb2.append("  controlData[13]");
        a1.i.u(sb2, bArr2[13], "MainActivityDecode");
    }

    public final void x(boolean z3) {
        if (z3) {
            this.E.setVisibility(0);
            this.f658t.setVisibility(0);
            this.C.setVisibility(0);
            this.B.setVisibility(0);
            this.w.setVisibility(0);
            this.F.setVisibility(0);
            this.O0.setVisibility(0);
            this.J.setVisibility(0);
            return;
        }
        this.E.setVisibility(8);
        this.f658t.setVisibility(8);
        this.C.setVisibility(8);
        this.B.setVisibility(8);
        this.w.setVisibility(8);
        this.F.setVisibility(8);
        this.O0.setVisibility(8);
        this.J.setVisibility(8);
    }

    public final void y(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }
}
