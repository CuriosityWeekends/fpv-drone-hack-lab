package com.lg.picturesubmitt.activity;

import android.content.Intent;
import android.content.IntentFilter;
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
import com.lg.picturesubmitt.activity.MainActivityNew;
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
import t2.r;
import t2.u;
import t2.v;
import t2.x;
import v2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MainActivityNew extends BaseActivity implements a, s2.a, j, v2.a, c, e {
    public static final /* synthetic */ int L1 = 0;
    public CustomButton A;
    public int A0;
    public CustomButton B;
    public int B0;
    public byte[] B1;
    public CustomButton C;
    public int C0;
    public final k C1;
    public CustomButton D;
    public String D1;
    public CustomButton E;
    public int E1;
    public CustomButton F;
    public boolean F1;
    public CustomButton G;
    public v3.c G0;
    public int G1;
    public CustomButton H;
    public b H0;
    public int H1;
    public CustomButton I;
    public v2.b I0;
    public int I1;
    public CustomButton J;
    public BatteryView J0;
    public final r J1;
    public TextView K;
    public CheckBox K0;
    public int K1;
    public TextView L;
    public CheckBox L0;
    public MyRockerView M;
    public CheckBox M0;
    public MyRockerView N;
    public CheckBox N0;
    public MyRockerView O;
    public CheckBox O0;
    public MyRockerView P;
    public CustomButton P0;
    public TrackControlPaintView Q;
    public ImageView Q0;
    public TrackControlPaintViewJY R;
    public MusicInfo R0;
    public LinearLayout S;
    public g3.e S0;
    public LinearLayout T;
    public ImageView U;
    public boolean U0;
    public ImageView V;
    public ZoomView W;
    public c1.b W0;
    public RelativeLayout X;
    public VerticalRangeSeekBar Y;
    public Bitmap Z;

    /* renamed from: b0  reason: collision with root package name */
    public i f679b0;

    /* renamed from: b1  reason: collision with root package name */
    public int f680b1;
    public PictureAndVideoUtil c;

    /* renamed from: c0  reason: collision with root package name */
    public h f681c0;

    /* renamed from: f  reason: collision with root package name */
    public WifiManager f687f;

    /* renamed from: g  reason: collision with root package name */
    public VTrimView f690g;

    /* renamed from: j0  reason: collision with root package name */
    public String f699j0;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f701k;

    /* renamed from: k0  reason: collision with root package name */
    public String f702k0;

    /* renamed from: l  reason: collision with root package name */
    public LinearLayout f704l;

    /* renamed from: l0  reason: collision with root package name */
    public ByteArrayOutputStream f705l0;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f707m;

    /* renamed from: m0  reason: collision with root package name */
    public ArrayList f708m0;

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f710n;

    /* renamed from: n0  reason: collision with root package name */
    public ExecutorService f711n0;

    /* renamed from: o  reason: collision with root package name */
    public LinearLayout f713o;

    /* renamed from: o0  reason: collision with root package name */
    public ExecutorService f714o0;

    /* renamed from: o1  reason: collision with root package name */
    public Button f715o1;

    /* renamed from: p  reason: collision with root package name */
    public LinearLayout f716p;

    /* renamed from: p0  reason: collision with root package name */
    public ExecutorService f717p0;

    /* renamed from: p1  reason: collision with root package name */
    public LinearLayout f718p1;
    public ImageView q;

    /* renamed from: q1  reason: collision with root package name */
    public RadioGroup f720q1;

    /* renamed from: r  reason: collision with root package name */
    public CustomButton f721r;

    /* renamed from: r1  reason: collision with root package name */
    public RadioGroup f723r1;
    public CustomButton s;

    /* renamed from: s1  reason: collision with root package name */
    public SignSeekBar f725s1;

    /* renamed from: t  reason: collision with root package name */
    public CustomButton f726t;

    /* renamed from: u  reason: collision with root package name */
    public CustomButton f729u;

    /* renamed from: u1  reason: collision with root package name */
    public e4.h f731u1;

    /* renamed from: v  reason: collision with root package name */
    public CustomButton f732v;
    public CustomButton w;

    /* renamed from: x  reason: collision with root package name */
    public CustomButton f737x;

    /* renamed from: y  reason: collision with root package name */
    public CustomButton f740y;

    /* renamed from: z  reason: collision with root package name */
    public CustomButton f743z;
    public final m d = new m();

    /* renamed from: e  reason: collision with root package name */
    public boolean f684e = false;

    /* renamed from: h  reason: collision with root package name */
    public int f693h = 16;

    /* renamed from: i  reason: collision with root package name */
    public int f696i = 16;

    /* renamed from: j  reason: collision with root package name */
    public int f698j = 16;

    /* renamed from: d0  reason: collision with root package name */
    public final byte[] f683d0 = {-1, -40};

    /* renamed from: e0  reason: collision with root package name */
    public final byte[] f685e0 = {-1, -39};

    /* renamed from: f0  reason: collision with root package name */
    public volatile boolean f688f0 = false;

    /* renamed from: g0  reason: collision with root package name */
    public volatile boolean f691g0 = false;

    /* renamed from: h0  reason: collision with root package name */
    public volatile boolean f694h0 = false;

    /* renamed from: i0  reason: collision with root package name */
    public volatile boolean f697i0 = false;

    /* renamed from: q0  reason: collision with root package name */
    public final byte[] f719q0 = new byte[14];

    /* renamed from: r0  reason: collision with root package name */
    public final byte[] f722r0 = new byte[26];

    /* renamed from: s0  reason: collision with root package name */
    public int f724s0 = 40;

    /* renamed from: t0  reason: collision with root package name */
    public boolean f727t0 = false;

    /* renamed from: u0  reason: collision with root package name */
    public boolean f730u0 = false;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f733v0 = false;

    /* renamed from: w0  reason: collision with root package name */
    public boolean f735w0 = false;

    /* renamed from: x0  reason: collision with root package name */
    public boolean f738x0 = false;

    /* renamed from: y0  reason: collision with root package name */
    public int f741y0 = 128;

    /* renamed from: z0  reason: collision with root package name */
    public int f744z0 = 128;
    public boolean D0 = false;
    public int E0 = 0;
    public int F0 = 0;
    public boolean T0 = false;
    public boolean V0 = false;
    public boolean X0 = false;
    public boolean Y0 = false;
    public boolean Z0 = false;

    /* renamed from: a1  reason: collision with root package name */
    public boolean f678a1 = false;

    /* renamed from: c1  reason: collision with root package name */
    public volatile int f682c1 = 5780;
    public volatile int d1 = 2890;

    /* renamed from: e1  reason: collision with root package name */
    public volatile int f686e1 = 1920;

    /* renamed from: f1  reason: collision with root package name */
    public volatile int f689f1 = 1080;

    /* renamed from: g1  reason: collision with root package name */
    public volatile int f692g1 = 640;

    /* renamed from: h1  reason: collision with root package name */
    public volatile int f695h1 = 360;
    public volatile int i1 = 480;

    /* renamed from: j1  reason: collision with root package name */
    public volatile int f700j1 = 480;

    /* renamed from: k1  reason: collision with root package name */
    public volatile int f703k1 = 640;

    /* renamed from: l1  reason: collision with root package name */
    public volatile int f706l1 = 480;

    /* renamed from: m1  reason: collision with root package name */
    public boolean f709m1 = false;

    /* renamed from: n1  reason: collision with root package name */
    public boolean f712n1 = false;

    /* renamed from: t1  reason: collision with root package name */
    public boolean f728t1 = false;

    /* renamed from: v1  reason: collision with root package name */
    public boolean f734v1 = true;

    /* renamed from: w1  reason: collision with root package name */
    public volatile boolean f736w1 = true;

    /* renamed from: x1  reason: collision with root package name */
    public volatile boolean f739x1 = false;

    /* renamed from: y1  reason: collision with root package name */
    public final x f742y1 = new x(this, 1);

    /* renamed from: z1  reason: collision with root package name */
    public final s f745z1 = new s(this, 7);
    public boolean A1 = false;

    public MainActivityNew() {
        new ByteArrayOutputStream();
        this.C1 = new k(2, this);
        this.E1 = 0;
        this.F1 = false;
        this.G1 = 0;
        new TreeMap();
        new HashMap();
        new TreeMap();
        new TreeMap();
        this.H1 = 0;
        this.I1 = 0;
        this.J1 = new r(1, this);
        this.K1 = 1;
    }

    public static void l(MainActivityNew mainActivityNew, File file) {
        String str;
        if (mainActivityNew.f734v1) {
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
        mainActivityNew.f731u1 = hVar;
        hVar.b(mainActivityNew);
        mainActivityNew.f731u1.a(new File(file, str.concat("/menu.gram")));
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
                this.D1 = "   低速模式";
                this.f724s0 = 40;
                o(this.f741y0, this.f744z0);
                break;
            case 2:
                this.D1 = "中速模式";
                this.f724s0 = 70;
                o(this.f741y0, this.f744z0);
                break;
            case 3:
                this.D1 = " 高速模式";
                this.f724s0 = 100;
                o(this.f741y0, this.f744z0);
                break;
            case 4:
                this.D1 = "重力感应 on";
                this.N.setGravity(true);
                this.f727t0 = true;
                break;
            case 5:
                this.D1 = "重力感应 off";
                this.N.setGravity(false);
                this.f727t0 = false;
                break;
            case 6:
                this.D1 = " 校准";
                byte[] bArr = this.f719q0;
                bArr[10] = (byte) (bArr[10] | 128);
                w("矫正");
                this.f745z1.sendEmptyMessageDelayed(5, 1000L);
                break;
            case 7:
                this.D1 = "  图片翻转";
                break;
        }
        y(this.D1);
    }

    @Override // s2.j
    public final void b(int i3, String str) {
        runOnUiThread(new l(this, i3, str, 3));
    }

    @Override // e4.a
    public final void d(Hypothesis hypothesis) {
        if (hypothesis != null) {
            String Hypothesis_hypstr_get = PocketSphinxJNI.Hypothesis_hypstr_get(hypothesis.f1765a, hypothesis);
            Log.i("MainActivityNew", " onResult text=" + Hypothesis_hypstr_get);
            if (this.f735w0) {
                Hypothesis_hypstr_get.getClass();
                s sVar = this.f745z1;
                byte[] bArr = this.f719q0;
                byte[] bArr2 = this.f722r0;
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
                        if (this.Z0) {
                            bArr2[8] = (byte) (bArr2[8] - 60);
                            Log.d("MainActivityNew", "controlDataOpflow[8]=" + ((int) bArr2[8]));
                            w("mRightRocker");
                            return;
                        }
                        bArr[7] = (byte) (bArr[7] - 60);
                        Log.d("MainActivityNew", "controlData[7]=" + ((int) bArr[7]));
                        w("mRightRocker");
                        if (this.f678a1) {
                            sVar.sendEmptyMessageDelayed(13, 5000L);
                            return;
                        }
                        return;
                    case 2:
                    case 7:
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        this.f737x.performClick();
                        return;
                    case 3:
                    case 15:
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        if (this.Z0) {
                            bArr2[7] = (byte) (bArr2[7] + 60);
                            Log.d("MainActivityNew", "controlDataOpflow[7]=" + ((int) bArr2[7]));
                            w("mRightRocker");
                            return;
                        }
                        bArr[6] = (byte) (bArr[6] + 60);
                        Log.d("MainActivityNew", "controlData[6]=" + ((int) bArr[6]));
                        w("mRightRocker");
                        if (this.f678a1) {
                            sVar.sendEmptyMessageDelayed(14, 5000L);
                            return;
                        }
                        return;
                    case 5:
                    case '\n':
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        if (this.Z0) {
                            bArr2[7] = (byte) (bArr2[7] - 60);
                            Log.d("MainActivityNew", "controlDataOpflow[7]=" + ((int) bArr2[7]));
                            w("mRightRocker");
                            return;
                        }
                        bArr[6] = (byte) (bArr[6] - 60);
                        Log.d("MainActivityNew", "controlData[6]=" + ((int) bArr[6]));
                        w("mRightRocker");
                        if (this.f678a1) {
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
                        this.f740y.performClick();
                        return;
                    case 11:
                    case '\r':
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        if (this.Z0) {
                            bArr2[8] = (byte) (bArr2[8] + 60);
                            Log.d("MainActivityNew", "controlDataOpflow[8]=" + ((int) bArr2[8]));
                            w("mRightRocker");
                            return;
                        }
                        bArr[7] = (byte) (bArr[7] + 60);
                        Log.d("MainActivityNew", "controlData[6]x=" + ((int) bArr[7]));
                        w("mRightRocker");
                        if (this.f678a1) {
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
        Log.d("MainActivityNew", "光流数据长度data=" + bArr.length + " length=" + i3);
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
        a1.i.u(sb, bArr[8], "MainActivityNew");
        if (!this.f728t1) {
            return;
        }
        runOnUiThread(new c0(10, this, bArr));
    }

    @Override // e4.a
    public final void f(Hypothesis hypothesis) {
        if (hypothesis == null) {
            return;
        }
        String Hypothesis_hypstr_get = PocketSphinxJNI.Hypothesis_hypstr_get(hypothesis.f1765a, hypothesis);
        this.f731u1.d();
        this.f731u1.c();
        Log.i("MainActivityNew", " onPartialResult text=" + Hypothesis_hypstr_get);
    }

    @Override // e4.a
    public final void g() {
        Log.d("MainActivityNew", "onBeginningOfSpeech");
    }

    @Override // v2.c
    public final void h() {
        if (!v()) {
            y(getResources().getString(2131755085));
            return;
        }
        if (this.Z0) {
            byte[] bArr = this.f722r0;
            bArr[11] = (byte) (bArr[11] | 2);
        } else {
            byte[] bArr2 = this.f719q0;
            bArr2[10] = (byte) (bArr2[10] | 4);
        }
        w("btStop");
        this.f745z1.sendEmptyMessageDelayed(4, 1000L);
    }

    @Override // s2.a
    public final void j(byte[] bArr, int i3) {
        if (this.f711n0.isShutdown()) {
            return;
        }
        this.f711n0.execute(new l(this, bArr, i3, 4));
    }

    @Override // e4.a
    public final void k() {
        StringBuilder sb = new StringBuilder(" onEndOfSpeech recognizer.getSearchName()=");
        Decoder decoder = this.f731u1.f1759a;
        sb.append(PocketSphinxJNI.Decoder_getSearch(decoder.f1764a, decoder));
        Log.i("MainActivityNew", sb.toString());
    }

    public final void m() {
        e4.h hVar = this.f731u1;
        if (hVar != null) {
            if (hVar.e()) {
                Log.i("h", "Cancel recognition");
            }
            this.f731u1.c.release();
        }
        i iVar = this.f679b0;
        iVar.f3529l = true;
        iVar.d(false);
        this.f679b0.a();
        this.f681c0.a();
        Log.d("MainActivityNew", " finish()");
        finish();
    }

    public final void n(int i3) {
        int v5;
        int i5 = this.f724s0;
        if (i5 != 40) {
            if (i5 == 70) {
                if (i3 > 128) {
                    i3 = a1.i.c(i3, 128, 2, 128);
                } else {
                    i3 = a1.i.y(128, i3, 2, 128);
                }
            }
        } else if (i3 > 128) {
            i3 = a1.i.c(i3, 128, 3, 128);
        } else {
            i3 = a1.i.y(128, i3, 3, 128);
        }
        int i6 = this.f698j;
        if (i6 < 16) {
            if (i3 < (16 - i6) * 2) {
                v5 = 0;
            } else {
                v5 = t2.h.b(16, i6, 2, i3);
            }
        } else if (255 - i3 < (i6 - 16) * 2) {
            v5 = 255;
        } else {
            v5 = a1.i.v(i6, 16, 2, i3);
        }
        if (this.Z0) {
            this.f722r0[8] = (byte) v5;
            return;
        }
        this.f719q0[7] = (byte) v5;
    }

    public final void o(int i3, int i5) {
        int v5;
        int i6 = this.f724s0;
        if (i6 != 40) {
            if (i6 == 70) {
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
            }
        } else {
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
        }
        a1.i.x("speedValuex=", i3, "MainActivityNew");
        int i7 = this.f698j;
        int i8 = 0;
        if (i7 < 16) {
            if (i5 < (16 - i7) * 2) {
                v5 = 0;
            } else {
                v5 = t2.h.b(16, i7, 2, i5);
            }
        } else if (255 - i5 < (i7 - 16) * 2) {
            v5 = 255;
        } else {
            v5 = a1.i.v(i7, 16, 2, i5);
        }
        int i9 = this.f696i;
        if (i9 < 16) {
            if (i3 >= (16 - i9) * 2) {
                i8 = t2.h.b(16, i9, 2, i3);
            }
        } else if (255 - i3 < (i9 - 16) * 2) {
            i8 = 255;
        } else {
            i8 = a1.i.v(i9, 16, 2, i3);
        }
        a1.i.x("adjustRx=", i8, "MainActivityNew");
        if (this.Z0) {
            byte[] bArr = this.f722r0;
            bArr[8] = (byte) v5;
            bArr[7] = (byte) i8;
            Log.d("MainActivityNew", "controlDataOpflow[7]x=" + ((int) bArr[7]));
            w("mRightRocker");
            return;
        }
        byte b = (byte) v5;
        byte[] bArr2 = this.f719q0;
        bArr2[7] = b;
        bArr2[6] = (byte) i8;
        Log.d("MainActivityNew", "controlData[6]x=" + ((int) bArr2[6]));
        w("mRightRocker");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i3, int i5, Intent intent) {
        super.onActivityResult(i3, i5, intent);
        if (i3 == 1 && i5 == 2) {
            MusicInfo musicInfo = (MusicInfo) intent.getParcelableExtra("MusicInfo");
            this.R0 = musicInfo;
            if (musicInfo != null && !TextUtils.isEmpty(musicInfo.path)) {
                this.Q0.setVisibility(0);
                this.P0.setBackground(getDrawable(2131558596));
                Log.d("MainActivityNew", "已选:" + this.R0.toString());
                return;
            }
            this.P0.setBackground(getDrawable(2131558595));
            this.Q0.setVisibility(8);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [a1.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.f691g0) {
            ?? obj = new Object();
            obj.b = null;
            obj.f39a = com.bumptech.glide.e.a(this).widthPixels / 3;
            String string = getString(2131755392);
            String string2 = getString(2131755391);
            String string3 = getString(2131755385);
            String string4 = getString(2131755386);
            v vVar = new v(this, 1);
            ?? centerPopupView = new CenterPopupView(this);
            centerPopupView.F = false;
            centerPopupView.q = 0;
            centerPopupView.p();
            centerPopupView.f1084x = string;
            centerPopupView.f1085y = string2;
            centerPopupView.f1086z = null;
            centerPopupView.A = string3;
            centerPopupView.B = string4;
            centerPopupView.s = vVar;
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
        a1.i.u(new StringBuilder("onConfigurationChanged  --"), configuration.orientation, "MainActivityNew");
        if (configuration.orientation == 2) {
            this.I.setBackground(getDrawable(2131558413));
            this.f736w1 = true;
            if (this.O0.isChecked()) {
                if (this.U0) {
                    this.f713o.setVisibility(0);
                    this.O.setShow(true);
                    this.P.setShow(true);
                } else {
                    this.f710n.setVisibility(0);
                    this.M.setShow(true);
                    this.N.setShow(true);
                }
                this.f690g.setVisibility(0);
                this.f704l.setVisibility(0);
            }
        } else {
            this.I.setBackground(getDrawable(2131558414));
            this.f736w1 = false;
            if (this.O0.isChecked()) {
                if (this.U0) {
                    this.f713o.setVisibility(8);
                } else {
                    this.f710n.setVisibility(8);
                }
                this.f690g.setVisibility(4);
                this.f704l.setVisibility(4);
            }
        }
        x(this.f736w1);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d("MainActivityNew", "onCreate");
        setContentView(2131427378);
        PictureAndVideoUtil pictureAndVideoUtil = PictureAndVideoUtil.getInstance();
        this.c = pictureAndVideoUtil;
        pictureAndVideoUtil.initFFmpeg();
        this.W0 = new c1.b(this, 22);
        Button button = (Button) findViewById(2131230876);
        this.f715o1 = button;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.f718p1 = (LinearLayout) findViewById(2131231110);
        SignSeekBar signSeekBar = (SignSeekBar) findViewById(2131231135);
        this.f725s1 = signSeekBar;
        signSeekBar.setOnProgressChangedListener(new v(this, 2));
        this.f720q1 = (RadioGroup) findViewById(2131231298);
        this.f723r1 = (RadioGroup) findViewById(2131231299);
        RadioButton radioButton = (RadioButton) findViewById(2131231274);
        RadioButton radioButton2 = (RadioButton) findViewById(2131231275);
        RadioButton radioButton3 = (RadioButton) findViewById(2131231276);
        RadioButton radioButton4 = (RadioButton) findViewById(2131231277);
        findViewById(2131230867).setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        findViewById(2131230880).setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        boolean t4 = this.W0.t("isShowOpticalFlowView");
        this.f728t1 = t4;
        if (t4) {
            this.f715o1.setVisibility(0);
        } else {
            this.f715o1.setVisibility(8);
            this.f718p1.setVisibility(8);
        }
        this.U0 = this.W0.t("isRightMode");
        Log.d("MainActivityNew", "isRightMode=" + this.U0);
        this.f684e = true;
        h3.b.f().c(this);
        getWindow().addFlags(128);
        this.f687f = (WifiManager) getApplication().getApplicationContext().getSystemService("wifi");
        BatteryView batteryView = (BatteryView) findViewById(2131231125);
        this.J0 = batteryView;
        batteryView.setLevelHeight(50);
        this.J0.setVisibility(8);
        this.q = (ImageView) findViewById(2131231288);
        ((TextView) findViewById(2131231305)).setVisibility(8);
        ((TextView) findViewById(2131231096)).setVisibility(8);
        ((TextView) findViewById(2131231462)).setVisibility(8);
        ((TextView) findViewById(2131231475)).setVisibility(8);
        ((TextView) findViewById(2131231463)).setVisibility(8);
        CheckBox checkBox = (CheckBox) findViewById(2131230900);
        this.K0 = checkBox;
        r rVar = this.J1;
        checkBox.setOnCheckedChangeListener(rVar);
        CheckBox checkBox2 = (CheckBox) findViewById(2131230905);
        this.O0 = checkBox2;
        checkBox2.setOnCheckedChangeListener(rVar);
        this.Q0 = (ImageView) findViewById(2131231085);
        CustomButton customButton = (CustomButton) findViewById(2131230860);
        this.P0 = customButton;
        customButton.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CheckBox checkBox3 = (CheckBox) findViewById(2131230916);
        this.L0 = checkBox3;
        checkBox3.setOnCheckedChangeListener(rVar);
        CheckBox checkBox4 = (CheckBox) findViewById(2131230901);
        this.M0 = checkBox4;
        checkBox4.setOnCheckedChangeListener(rVar);
        CheckBox checkBox5 = (CheckBox) findViewById(2131230898);
        this.N0 = checkBox5;
        checkBox5.setOnCheckedChangeListener(rVar);
        this.K0.setChecked(false);
        this.W = (ZoomView) findViewById(2131231153);
        this.U = (ImageView) findViewById(2131231081);
        this.V = (ImageView) findViewById(2131231082);
        this.X = (RelativeLayout) findViewById(2131231310);
        VerticalRangeSeekBar verticalRangeSeekBar = (VerticalRangeSeekBar) findViewById(2131231521);
        this.Y = verticalRangeSeekBar;
        verticalRangeSeekBar.setOnRangeChangedListener(new v(this, 4));
        if (getResources().getConfiguration().locale.getCountry().equals("CN")) {
            this.f734v1 = true;
        } else {
            this.f734v1 = false;
        }
        this.K = (TextView) findViewById(2131231485);
        this.L = (TextView) findViewById(2131231290);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131231289);
        this.f707m = linearLayout;
        linearLayout.setVisibility(4);
        this.f701k = (LinearLayout) findViewById(2131231130);
        this.f710n = (LinearLayout) findViewById(2131231313);
        this.f713o = (LinearLayout) findViewById(2131231314);
        this.f704l = (LinearLayout) findViewById(2131231209);
        CustomButton customButton2 = (CustomButton) findViewById(2131230836);
        this.C = customButton2;
        customButton2.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton3 = (CustomButton) findViewById(2131230874);
        this.B = customButton3;
        customButton3.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton4 = (CustomButton) findViewById(2131230875);
        this.A = customButton4;
        customButton4.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton5 = (CustomButton) findViewById(2131230848);
        this.J = customButton5;
        customButton5.setVisibility(4);
        this.J.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton6 = (CustomButton) findViewById(2131230881);
        this.f743z = customButton6;
        customButton6.setVisibility(4);
        this.f743z.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton7 = (CustomButton) findViewById(2131230861);
        this.I = customButton7;
        customButton7.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton8 = (CustomButton) findViewById(2131230852);
        this.f737x = customButton8;
        customButton8.setVisibility(4);
        this.f737x.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton9 = (CustomButton) findViewById(2131230851);
        this.f740y = customButton9;
        customButton9.setVisibility(4);
        this.f740y.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton10 = (CustomButton) findViewById(2131230846);
        this.f732v = customButton10;
        customButton10.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        ((HTrimView) findViewById(2131231456)).setOnTrimViewInterface(new u(this, 5));
        ((HTrimView) findViewById(2131231457)).setOnTrimViewInterface(new u(this, 6));
        VTrimView vTrimView = (VTrimView) findViewById(2131231458);
        this.f690g = vTrimView;
        vTrimView.setOnTrimViewInterface(new u(this, 7));
        CustomButton customButton11 = (CustomButton) findViewById(2131230839);
        this.w = customButton11;
        customButton11.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        TrackControlPaintViewJY trackControlPaintViewJY = (TrackControlPaintViewJY) findViewById(2131231152);
        this.R = trackControlPaintViewJY;
        trackControlPaintViewJY.setOnLocaListener(new u(this, 8));
        this.T = (LinearLayout) findViewById(2131231151);
        TrackControlPaintView trackControlPaintView = (TrackControlPaintView) findViewById(2131231149);
        this.Q = trackControlPaintView;
        trackControlPaintView.setOnLocaListener(new u(this, 9));
        this.S = (LinearLayout) findViewById(2131231150);
        this.f716p = (LinearLayout) findViewById(2131231111);
        CustomButton customButton12 = (CustomButton) findViewById(2131230877);
        this.G = customButton12;
        customButton12.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.N = (MyRockerView) findViewById(2131231132);
        this.P = (MyRockerView) findViewById(2131231133);
        this.M = (MyRockerView) findViewById(2131231128);
        this.O = (MyRockerView) findViewById(2131231129);
        this.N.setOnLocaListener(new u(this, 10));
        this.P.setOnLocaListener(new u(this, 11));
        this.M.setOnLocaListener(new u(this, 0));
        this.O.setOnLocaListener(new u(this, 1));
        this.f710n.setVisibility(8);
        this.f713o.setVisibility(8);
        this.f721r = (CustomButton) findViewById(2131230842);
        this.f729u = (CustomButton) findViewById(2131230849);
        this.f726t = (CustomButton) findViewById(2131230869);
        this.s = (CustomButton) findViewById(2131230838);
        this.D = (CustomButton) findViewById(2131230868);
        this.E = (CustomButton) findViewById(2131230859);
        this.F = (CustomButton) findViewById(2131230872);
        this.H = (CustomButton) findViewById(2131230879);
        this.f721r.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.f729u.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.f726t.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.G0 = new v3.c(this);
        String[] strArr = Build.VERSION.SDK_INT >= 33 ? new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"} : new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        p4.m a5 = d.a(this.s);
        v3.c cVar = this.G0;
        cVar.getClass();
        a5.d(new v3.b(cVar, strArr)).g(new o4.b(new u(this, 2)));
        p4.m a6 = d.a(this.D);
        v3.c cVar2 = this.G0;
        cVar2.getClass();
        a6.d(new v3.b(cVar2, strArr)).g(new o4.b(new u(this, 3)));
        this.E.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        p4.m a7 = d.a(this.H);
        v3.c cVar3 = this.G0;
        cVar3.getClass();
        a7.d(new v3.b(cVar3, new String[]{"android.permission.RECORD_AUDIO"})).g(new o4.b(new u(this, 4)));
        this.F.setOnClickListener(new View.OnClickListener(this) { // from class: t2.t
            public final /* synthetic */ MainActivityNew b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v12, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v15, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r4v14, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        MainActivityNew mainActivityNew = this.b;
                        if (mainActivityNew.f691g0) {
                            ?? obj = new Object();
                            obj.b = null;
                            obj.f39a = com.bumptech.glide.e.a(mainActivityNew).widthPixels / 3;
                            String string = mainActivityNew.getString(2131755392);
                            String string2 = mainActivityNew.getString(2131755391);
                            String string3 = mainActivityNew.getString(2131755385);
                            String string4 = mainActivityNew.getString(2131755386);
                            v vVar = new v(mainActivityNew, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityNew);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = vVar;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityNew.startActivityForResult(new Intent(mainActivityNew, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew2 = this.b;
                        if (!mainActivityNew2.v()) {
                            mainActivityNew2.y(mainActivityNew2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew2.f681c0.c(false);
                        boolean z3 = mainActivityNew2.Z0;
                        j0.s sVar = mainActivityNew2.f745z1;
                        if (z3) {
                            byte[] bArr = mainActivityNew2.f722r0;
                            bArr[11] = (byte) (4 | bArr[11]);
                            mainActivityNew2.w("矫正");
                            sVar.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityNew2.f719q0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityNew2.w("矫正");
                        sVar.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityNew mainActivityNew3 = this.b;
                        if (mainActivityNew3.f691g0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            obj2.f39a = com.bumptech.glide.e.a(mainActivityNew3).widthPixels / 3;
                            String string5 = mainActivityNew3.getString(2131755392);
                            String string6 = mainActivityNew3.getString(2131755391);
                            String string7 = mainActivityNew3.getString(2131755385);
                            String string8 = mainActivityNew3.getString(2131755386);
                            v vVar2 = new v(mainActivityNew3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityNew3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = vVar2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityNew3.m();
                        return;
                    case 3:
                        MainActivityNew mainActivityNew4 = this.b;
                        if (mainActivityNew4.f691g0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            obj3.f39a = com.bumptech.glide.e.a(mainActivityNew4).widthPixels / 3;
                            String string9 = mainActivityNew4.getString(2131755392);
                            String string10 = mainActivityNew4.getString(2131755391);
                            String string11 = mainActivityNew4.getString(2131755385);
                            String string12 = mainActivityNew4.getString(2131755386);
                            v vVar3 = new v(mainActivityNew4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityNew4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = vVar3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityNew4.startActivity(new Intent(mainActivityNew4, FileDirActivity.class));
                        return;
                    case 4:
                        int i8 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew5 = this.b;
                        if (!mainActivityNew5.v()) {
                            mainActivityNew5.y(mainActivityNew5.getResources().getString(2131755085));
                            return;
                        }
                        s2.i iVar = mainActivityNew5.f679b0;
                        byte[] bArr3 = {-52, 90, 1, -119, 1, -119};
                        if (iVar.b == null) {
                            iVar.b();
                        }
                        if (iVar.b == null) {
                            Toast.makeText(iVar.c, "sendIMG_CMD通道异常，请关闭页面后重试", 0).show();
                            return;
                        } else {
                            new Thread(new com.tencent.bugly.proguard.c0(7, iVar, bArr3)).start();
                            return;
                        }
                    case 5:
                        MainActivityNew mainActivityNew6 = this.b;
                        int i9 = MainActivityNew.L1;
                        if (!mainActivityNew6.v()) {
                            mainActivityNew6.y(mainActivityNew6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew6.f694h0) {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558534));
                        } else {
                            mainActivityNew6.E.setBackground(mainActivityNew6.getDrawable(2131558533));
                        }
                        mainActivityNew6.f694h0 = !mainActivityNew6.f694h0;
                        return;
                    case 6:
                        MainActivityNew mainActivityNew7 = this.b;
                        if (mainActivityNew7.f738x0) {
                            mainActivityNew7.y(mainActivityNew7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityNew7.f727t0) {
                            mainActivityNew7.f727t0 = false;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(false);
                                mainActivityNew7.P.setStopUI(false);
                                mainActivityNew7.O.setStopUI(false);
                            } else {
                                mainActivityNew7.N.setGravity(false);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityNew7.N0.isChecked()) {
                            mainActivityNew7.f727t0 = true;
                            if (mainActivityNew7.U0) {
                                mainActivityNew7.P.setGravity(true);
                                mainActivityNew7.P.setStopUI(true);
                                mainActivityNew7.O.setStopUI(true);
                            } else {
                                mainActivityNew7.N.setGravity(true);
                            }
                            mainActivityNew7.F.setBackground(mainActivityNew7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityNew7.y(mainActivityNew7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew8 = this.b;
                        if (!mainActivityNew8.v()) {
                            mainActivityNew8.y(mainActivityNew8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityNew8.f724s0;
                        if (i11 == 40) {
                            mainActivityNew8.f724s0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityNew8.f724s0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityNew8.f724s0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityNew8.B.setBackground(mainActivityNew8.getDrawable(i3));
                        mainActivityNew8.o(mainActivityNew8.f741y0, mainActivityNew8.f744z0);
                        return;
                    case 8:
                        this.b.H0.a();
                        return;
                    case 9:
                        int i12 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew9 = this.b;
                        if (!mainActivityNew9.v()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityNew9.N0.isChecked()) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityNew9.f727t0) {
                            mainActivityNew9.y(mainActivityNew9.getResources().getString(2131755183));
                            return;
                        } else if (mainActivityNew9.Z0) {
                            mainActivityNew9.f738x0 = true;
                            byte[] bArr4 = mainActivityNew9.f722r0;
                            bArr4[11] = (byte) (bArr4[11] | 8);
                            mainActivityNew9.w("isFanGun--isOpflow" + mainActivityNew9.Z0);
                            mainActivityNew9.f745z1.sendEmptyMessageDelayed(10, 1000L);
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            return;
                        } else if (mainActivityNew9.f738x0) {
                            byte[] bArr5 = mainActivityNew9.f719q0;
                            bArr5[10] = (byte) (bArr5[10] & (-9));
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558506));
                            mainActivityNew9.f738x0 = false;
                            mainActivityNew9.w("isFanGun--false");
                            return;
                        } else {
                            mainActivityNew9.J.setBackground(mainActivityNew9.getResources().getDrawable(2131558505));
                            mainActivityNew9.f738x0 = true;
                            mainActivityNew9.D0 = false;
                            return;
                        }
                    case 10:
                        int i13 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew10 = this.b;
                        if (!mainActivityNew10.v()) {
                            mainActivityNew10.y(mainActivityNew10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityNew10.Z0) {
                            boolean z5 = mainActivityNew10.f733v0;
                            byte[] bArr6 = mainActivityNew10.f722r0;
                            if (z5) {
                                bArr6[12] = (byte) (bArr6[12] & (-2));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr6[12] = (byte) (bArr6[12] | 1);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityNew10.f733v0;
                            byte[] bArr7 = mainActivityNew10.f719q0;
                            if (z6) {
                                bArr7[10] = (byte) (bArr7[10] & (-17));
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558496));
                            } else {
                                bArr7[10] = (byte) (bArr7[10] | 16);
                                mainActivityNew10.f743z.setBackground(mainActivityNew10.getDrawable(2131558495));
                            }
                        }
                        mainActivityNew10.f733v0 = !mainActivityNew10.f733v0;
                        mainActivityNew10.w("btWuTou");
                        return;
                    case 11:
                        MainActivityNew mainActivityNew11 = this.b;
                        if (mainActivityNew11.N0.isChecked()) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755167));
                            return;
                        } else if (mainActivityNew11.f694h0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755169));
                            return;
                        } else if (mainActivityNew11.f727t0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755168));
                            return;
                        } else if (mainActivityNew11.f691g0) {
                            mainActivityNew11.y(mainActivityNew11.getString(2131755348));
                            return;
                        } else if (mainActivityNew11.f736w1) {
                            if (mainActivityNew11.getRequestedOrientation() != 1) {
                                mainActivityNew11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityNew11.getRequestedOrientation() != 0) {
                            mainActivityNew11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew12 = this.b;
                        if (!mainActivityNew12.v()) {
                            mainActivityNew12.y(mainActivityNew12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew12.f681c0.c(false);
                        boolean z7 = mainActivityNew12.Z0;
                        j0.s sVar2 = mainActivityNew12.f745z1;
                        if (z7) {
                            byte[] bArr8 = mainActivityNew12.f722r0;
                            bArr8[11] = (byte) (bArr8[11] | 1);
                            mainActivityNew12.w("btFlyUp");
                            sVar2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr9 = mainActivityNew12.f719q0;
                        bArr9[10] = (byte) (bArr9[10] | 1);
                        mainActivityNew12.w("btFlyUp");
                        sVar2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityNew.L1;
                        MainActivityNew mainActivityNew13 = this.b;
                        if (!mainActivityNew13.v()) {
                            mainActivityNew13.y(mainActivityNew13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityNew13.f681c0.c(false);
                        boolean z8 = mainActivityNew13.Z0;
                        j0.s sVar3 = mainActivityNew13.f745z1;
                        if (z8) {
                            byte[] bArr10 = mainActivityNew13.f722r0;
                            bArr10[11] = (byte) (bArr10[11] | 1);
                            mainActivityNew13.w("btFlyDown");
                            sVar3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr11 = mainActivityNew13.f719q0;
                        bArr11[10] = (byte) (bArr11[10] | 2);
                        mainActivityNew13.w("btFlyDown");
                        sVar3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityNew mainActivityNew14 = this.b;
                        if (mainActivityNew14.f730u0) {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558510));
                            mainActivityNew14.f737x.setVisibility(4);
                            mainActivityNew14.f740y.setVisibility(4);
                        } else {
                            mainActivityNew14.f732v.setBackground(mainActivityNew14.getDrawable(2131558509));
                            mainActivityNew14.f737x.setVisibility(0);
                            mainActivityNew14.f740y.setVisibility(0);
                        }
                        mainActivityNew14.f730u0 = !mainActivityNew14.f730u0;
                        return;
                    case 15:
                        MainActivityNew mainActivityNew15 = this.b;
                        if (mainActivityNew15.f718p1.getVisibility() == 8) {
                            mainActivityNew15.f718p1.setVisibility(0);
                            mainActivityNew15.f715o1.setText("隐藏");
                            return;
                        }
                        mainActivityNew15.f718p1.setVisibility(8);
                        mainActivityNew15.f715o1.setText("显示");
                        return;
                    case 16:
                        this.b.f681c0.b(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 17:
                        MainActivityNew mainActivityNew16 = this.b;
                        if (mainActivityNew16.f720q1.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityNew16.f723r1.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityNew16.K1, "MainActivityNew");
                        byte b = (byte) i5;
                        byte b5 = (byte) i6;
                        byte b6 = (byte) mainActivityNew16.K1;
                        mainActivityNew16.f681c0.b(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 18:
                        MainActivityNew mainActivityNew17 = this.b;
                        if (mainActivityNew17.f691g0) {
                            mainActivityNew17.y(mainActivityNew17.getString(2131755348));
                            return;
                        } else if (mainActivityNew17.V0) {
                            mainActivityNew17.f679b0.e();
                            return;
                        } else {
                            return;
                        }
                    default:
                        MainActivityNew mainActivityNew18 = this.b;
                        int ordinal = mainActivityNew18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558631));
                                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558635));
                                    mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558634));
                                mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558633));
                            mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityNew18.G.setBackground(mainActivityNew18.getDrawable(2131558632));
                        mainActivityNew18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.f705l0 = new ByteArrayOutputStream();
        this.f708m0 = new ArrayList();
        this.f711n0 = Executors.newSingleThreadExecutor();
        this.f717p0 = Executors.newSingleThreadExecutor();
        this.f714o0 = Executors.newFixedThreadPool(5);
        i iVar = new i(this, this, this, this);
        this.f679b0 = iVar;
        iVar.d(true);
        this.f679b0.c();
        Log.d("MainActivityNew", "设备初始化默认已连接");
        this.f681c0 = new h();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        registerReceiver(this.C1, intentFilter);
        this.A.setVisibility(8);
        this.f701k.setVisibility(8);
        this.f690g.setVisibility(4);
        this.f704l.setVisibility(4);
        if (this.I0 == null) {
            v2.b bVar = new v2.b(this);
            this.I0 = bVar;
            bVar.d = this;
        }
        this.H0 = new b(this);
        b bVar2 = new b(this);
        this.H0 = bVar2;
        bVar2.c = this;
        if (!MyApplication.f541h) {
            g3.b.a(getApplicationContext(), new j3.b(27));
        }
        this.S0 = new g3.e(this, new v(this, 0));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.C1);
        this.f711n0.shutdown();
        this.f714o0.shutdown();
        this.f717p0.shutdown();
        e4.h hVar = this.f731u1;
        if (hVar != null) {
            if (hVar.e()) {
                Log.i("h", "Cancel recognition");
            }
            this.f731u1.c.release();
        }
        Log.d("MainActivityNew", " onDestroy()");
    }

    @Override // e4.a
    public final void onError(Exception exc) {
        Log.i("MainActivityNew", " onError getMessage=" + exc.getMessage());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.U0) {
            this.P.c();
        } else {
            this.N.c();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        Log.d("MainActivityNew", "onStop");
        if (this.f691g0) {
            this.D.performClick();
        }
        if (this.U0) {
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
        int v5;
        int i5 = this.f724s0;
        if (i5 != 40) {
            if (i5 == 70) {
                if (i3 > 128) {
                    i3 = a1.i.c(i3, 128, 2, 128);
                } else {
                    i3 = a1.i.y(128, i3, 2, 128);
                }
            }
        } else if (i3 > 128) {
            i3 = a1.i.c(i3, 128, 3, 128);
        } else {
            i3 = a1.i.y(128, i3, 3, 128);
        }
        a1.i.x("speedValuex=", i3, "MainActivityNew");
        int i6 = this.f696i;
        if (i6 < 16) {
            if (i3 < (16 - i6) * 2) {
                v5 = 0;
            } else {
                v5 = t2.h.b(16, i6, 2, i3);
            }
        } else if (255 - i3 < (i6 - 16) * 2) {
            v5 = 255;
        } else {
            v5 = a1.i.v(i6, 16, 2, i3);
        }
        a1.i.x("adjustRx=", v5, "MainActivityNew");
        if (this.Z0) {
            byte[] bArr = this.f722r0;
            bArr[7] = (byte) v5;
            a1.i.u(new StringBuilder("controlDataOpflow[7]x="), bArr[7], "MainActivityNew");
            return;
        }
        byte[] bArr2 = this.f719q0;
        bArr2[6] = (byte) v5;
        a1.i.u(new StringBuilder("controlData[6]x="), bArr2[6], "MainActivityNew");
    }

    public final void q(int i3) {
        int i5;
        this.f744z0 = i3;
        if (this.Z0) {
            n(i3);
        } else if (this.f738x0) {
            if (this.E0 != 1) {
                boolean z3 = this.D0;
                byte[] bArr = this.f719q0;
                if (z3) {
                    bArr[10] = (byte) (bArr[10] | 8);
                    bArr[7] = (byte) this.B0;
                    Log.d("右杆y翻滚之后", "y--" + this.B0 + " originValue=" + i3);
                } else if (Math.abs(128 - i3) > 64) {
                    if (i3 > 128) {
                        i5 = 255;
                    } else {
                        i5 = 0;
                    }
                    this.D0 = true;
                    bArr[10] = (byte) (bArr[10] | 8);
                    bArr[7] = (byte) i5;
                    this.B0 = i5;
                    Log.d("右杆y触发翻滚时", "y--" + this.B0 + " originValue=" + i3);
                    this.E0 = 2;
                    this.f745z1.sendEmptyMessageDelayed(0, 600L);
                } else {
                    n(i3);
                }
            }
        } else if (!this.D0) {
            n(i3);
        }
    }

    public final void r(int i3) {
        int i5;
        this.f741y0 = i3;
        if (this.Z0) {
            p(i3);
        } else if (this.f738x0) {
            if (this.E0 != 2) {
                boolean z3 = this.D0;
                byte[] bArr = this.f719q0;
                if (z3) {
                    bArr[10] = (byte) (bArr[10] | 8);
                    bArr[6] = (byte) this.A0;
                    Log.d("右杆x翻滚之后", "x--" + this.A0 + " originValue=" + i3);
                } else if (Math.abs(128 - i3) > 64) {
                    if (i3 > 128) {
                        i5 = 255;
                    } else {
                        i5 = 0;
                    }
                    this.D0 = true;
                    bArr[10] = (byte) (bArr[10] | 8);
                    bArr[6] = (byte) i5;
                    this.A0 = i5;
                    Log.d("右杆x触发翻滚时", "x--" + this.A0 + " originValue=" + i3);
                    this.E0 = 1;
                    this.f745z1.sendEmptyMessageDelayed(0, 600L);
                } else {
                    p(i3);
                }
            }
        } else if (!this.D0) {
            p(i3);
        }
    }

    public final void s(int i3) {
        if (this.Z0) {
            this.f722r0[9] = (byte) i3;
            return;
        }
        byte[] bArr = this.f719q0;
        bArr[8] = (byte) i3;
        a1.i.u(new StringBuilder("data[y]="), bArr[8], "MainActivityNew");
    }

    public final void t(int i3) {
        int v5;
        this.C0 = i3;
        int i5 = this.f693h;
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
        if (this.Z0) {
            byte[] bArr = this.f722r0;
            bArr[10] = (byte) v5;
            StringBuilder sb = new StringBuilder("发送控制油门");
            sb.append((int) bArr[9]);
            sb.append("转向");
            a1.i.u(sb, bArr[10], "MainActivityNew");
            return;
        }
        this.f719q0[9] = (byte) v5;
    }

    public final boolean v() {
        String u5 = u(this.f687f.getConnectionInfo().getIpAddress());
        if (!u5.contains("192.168.24") && !u5.contains("192.168.26")) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r4v5 */
    public final void w(String str) {
        Log.d("MainActivityNew谁发送", str);
        int i3 = 3;
        int i5 = 8;
        if (this.Z0) {
            byte[] bArr = this.f722r0;
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
            if (this.f681c0 == null) {
                this.f681c0 = new h();
            }
            this.f681c0.d(bArr);
            StringBuilder sb = new StringBuilder("  controlDataOpflow[9]");
            sb.append((int) bArr[9]);
            sb.append("  controlDataOpflow[23]");
            a1.i.u(sb, bArr[23], "MainActivityNew");
            return;
        }
        byte[] bArr2 = this.f719q0;
        byte b6 = bArr2[6];
        byte b7 = bArr2[7];
        byte b8 = bArr2[8];
        byte b9 = bArr2[9];
        byte b10 = bArr2[10];
        byte b11 = (byte) (((((b6 ^ b7) ^ b8) ^ b9) ^ b10) & 255);
        bArr2[11] = b11;
        bArr2[13] = (byte) ((((((((b6 ^ (((bArr2[3] ^ bArr2[2]) ^ bArr2[4]) ^ bArr2[5])) ^ b7) ^ b8) ^ b9) ^ b10) ^ b11) ^ bArr2[12]) & 255);
        if (this.f681c0 == null) {
            this.f681c0 = new h();
        }
        this.f681c0.d(bArr2);
        StringBuilder sb2 = new StringBuilder("  controlData[9]");
        sb2.append((int) bArr2[9]);
        sb2.append("  controlData[13]");
        a1.i.u(sb2, bArr2[13], "MainActivityNew");
    }

    public final void x(boolean z3) {
        if (z3) {
            this.E.setVisibility(0);
            this.f726t.setVisibility(0);
            this.C.setVisibility(0);
            this.B.setVisibility(0);
            this.w.setVisibility(0);
            this.F.setVisibility(0);
            this.N0.setVisibility(0);
            this.J.setVisibility(0);
            return;
        }
        this.E.setVisibility(8);
        this.f726t.setVisibility(8);
        this.C.setVisibility(8);
        this.B.setVisibility(8);
        this.w.setVisibility(8);
        this.F.setVisibility(8);
        this.N0.setVisibility(8);
        this.J.setVisibility(8);
    }

    public final void y(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }
}
