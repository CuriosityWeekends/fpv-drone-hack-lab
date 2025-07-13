package com.lg.picturesubmitt.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.SoundPool;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import b3.d;
import com.jaygoo.widget.VerticalRangeSeekBar;
import com.lg.picturesubmitt.MyApplication;
import com.lg.picturesubmitt.PictureAndVideoUtil;
import com.lg.picturesubmitt.YuvUtil;
import com.lg.picturesubmitt.activity.FileDirActivity;
import com.lg.picturesubmitt.activity.MainActivityRTSP;
import com.lg.picturesubmitt.activity.MusicActivity;
import com.lg.picturesubmitt.model.MusicInfo;
import com.lg.picturesubmitt.rtsp.JNICMD;
import com.lg.picturesubmitt.widget.CustomButton;
import com.lg.picturesubmitt.widget.HTrimView;
import com.lg.picturesubmitt.widget.MyRockerView;
import com.lg.picturesubmitt.widget.TrackControlPaintView;
import com.lg.picturesubmitt.widget.VTrimView;
import com.lg.picturesubmitt.widget.ZoomView;
import com.lg.picturesubmitt.widget.battery.BatteryView;
import com.lxj.xpopup.core.CenterPopupView;
import com.rockcarry.fanplayer.MediaPlayer;
import com.showview.GLSurface;
import com.showview.MyGLRender;
import com.zhouyou.view.seekbar.SignSeekBar;
import e4.a;
import e4.h;
import e4.i;
import edu.cmu.pocketsphinx.Config;
import edu.cmu.pocketsphinx.Decoder;
import edu.cmu.pocketsphinx.Hypothesis;
import edu.cmu.pocketsphinx.PocketSphinxJNI;
import edu.cmu.pocketsphinx.SphinxBaseJNI;
import f0.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import s2.k;
import s2.l;
import s2.m;
import t2.a0;
import t2.c0;
import t2.e0;
import t2.r;
import t2.z;
import v2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MainActivityRTSP extends BaseActivity implements a, v2.a, c, MediaPlayer.Callback, k {

    /* renamed from: n1  reason: collision with root package name */
    public static final /* synthetic */ int f746n1 = 0;
    public CustomButton A;
    public CustomButton B;
    public CustomButton C;
    public CustomButton D;
    public v3.c D0;
    public CustomButton E;
    public b E0;
    public CustomButton F;
    public v2.b F0;
    public CustomButton G;
    public BatteryView G0;
    public CustomButton H;
    public CheckBox H0;
    public CustomButton I;
    public CheckBox I0;
    public CustomButton J;
    public CheckBox J0;
    public TextView K;
    public CheckBox K0;
    public TextView L;
    public CheckBox L0;
    public MyRockerView M;
    public CustomButton M0;
    public MyRockerView N;
    public ImageView N0;
    public MyRockerView O;
    public MusicInfo O0;
    public MyRockerView P;
    public long P0;
    public TrackControlPaintView Q;
    public boolean Q0;
    public LinearLayout R;
    public c1.b R0;
    public ImageView S;
    public Button W0;
    public l X;
    public LinearLayout X0;
    public String Y;
    public RadioGroup Y0;
    public String Z;
    public RadioGroup Z0;

    /* renamed from: a1  reason: collision with root package name */
    public h f747a1;

    /* renamed from: b0  reason: collision with root package name */
    public String f748b0;

    /* renamed from: c0  reason: collision with root package name */
    public ZoomView f750c0;

    /* renamed from: d0  reason: collision with root package name */
    public RelativeLayout f752d0;
    public int d1;

    /* renamed from: e0  reason: collision with root package name */
    public VerticalRangeSeekBar f754e0;

    /* renamed from: e1  reason: collision with root package name */
    public int f755e1;

    /* renamed from: f  reason: collision with root package name */
    public WifiManager f756f;

    /* renamed from: g  reason: collision with root package name */
    public VTrimView f759g;

    /* renamed from: j1  reason: collision with root package name */
    public String f769j1;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f770k;

    /* renamed from: k0  reason: collision with root package name */
    public ExecutorService f771k0;

    /* renamed from: k1  reason: collision with root package name */
    public final r f772k1;

    /* renamed from: l  reason: collision with root package name */
    public LinearLayout f773l;

    /* renamed from: l0  reason: collision with root package name */
    public ExecutorService f774l0;

    /* renamed from: l1  reason: collision with root package name */
    public int f775l1;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f776m;

    /* renamed from: m0  reason: collision with root package name */
    public ExecutorService f777m0;

    /* renamed from: m1  reason: collision with root package name */
    public final e0 f778m1;

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f779n;

    /* renamed from: o  reason: collision with root package name */
    public LinearLayout f781o;

    /* renamed from: p  reason: collision with root package name */
    public LinearLayout f783p;
    public ImageView q;

    /* renamed from: r  reason: collision with root package name */
    public CustomButton f786r;
    public CustomButton s;

    /* renamed from: t  reason: collision with root package name */
    public CustomButton f789t;

    /* renamed from: u  reason: collision with root package name */
    public CustomButton f791u;

    /* renamed from: v  reason: collision with root package name */
    public CustomButton f793v;
    public CustomButton w;

    /* renamed from: x  reason: collision with root package name */
    public CustomButton f796x;

    /* renamed from: x0  reason: collision with root package name */
    public int f797x0;

    /* renamed from: y  reason: collision with root package name */
    public CustomButton f798y;

    /* renamed from: y0  reason: collision with root package name */
    public int f799y0;

    /* renamed from: z  reason: collision with root package name */
    public CustomButton f800z;

    /* renamed from: z0  reason: collision with root package name */
    public int f801z0;
    public final JNICMD c = new JNICMD();
    public final PictureAndVideoUtil d = PictureAndVideoUtil.getInstance();

    /* renamed from: e  reason: collision with root package name */
    public final m f753e = new m();

    /* renamed from: h  reason: collision with root package name */
    public int f762h = 16;

    /* renamed from: i  reason: collision with root package name */
    public int f765i = 16;

    /* renamed from: j  reason: collision with root package name */
    public int f767j = 16;
    public GLSurface T = null;
    public MyGLRender U = null;
    public MediaPlayer V = null;
    public boolean W = false;

    /* renamed from: f0  reason: collision with root package name */
    public volatile boolean f757f0 = true;

    /* renamed from: g0  reason: collision with root package name */
    public volatile boolean f760g0 = false;

    /* renamed from: h0  reason: collision with root package name */
    public volatile boolean f763h0 = false;

    /* renamed from: i0  reason: collision with root package name */
    public volatile boolean f766i0 = false;

    /* renamed from: j0  reason: collision with root package name */
    public volatile boolean f768j0 = false;

    /* renamed from: n0  reason: collision with root package name */
    public final byte[] f780n0 = new byte[14];

    /* renamed from: o0  reason: collision with root package name */
    public final byte[] f782o0 = new byte[20];

    /* renamed from: p0  reason: collision with root package name */
    public int f784p0 = 40;

    /* renamed from: q0  reason: collision with root package name */
    public boolean f785q0 = false;

    /* renamed from: r0  reason: collision with root package name */
    public boolean f787r0 = false;

    /* renamed from: s0  reason: collision with root package name */
    public boolean f788s0 = false;

    /* renamed from: t0  reason: collision with root package name */
    public boolean f790t0 = false;

    /* renamed from: u0  reason: collision with root package name */
    public boolean f792u0 = false;

    /* renamed from: v0  reason: collision with root package name */
    public int f794v0 = 128;

    /* renamed from: w0  reason: collision with root package name */
    public int f795w0 = 128;
    public boolean A0 = false;
    public int B0 = 0;
    public int C0 = 0;
    public boolean S0 = false;
    public final boolean T0 = true;
    public int U0 = 1920;
    public int V0 = 1080;

    /* renamed from: b1  reason: collision with root package name */
    public boolean f749b1 = true;

    /* renamed from: c1  reason: collision with root package name */
    public volatile boolean f751c1 = true;

    /* renamed from: f1  reason: collision with root package name */
    public final d f758f1 = new d(14, this);

    /* renamed from: g1  reason: collision with root package name */
    public final e0 f761g1 = new e0(this, 1);

    /* renamed from: h1  reason: collision with root package name */
    public final c0 f764h1 = new c0(this, 0);
    public final t2.k i1 = new t2.k(3, this);

    public MainActivityRTSP() {
        new TreeMap();
        new HashMap();
        new TreeMap();
        new TreeMap();
        this.f772k1 = new r(2, this);
        this.f775l1 = 1;
        this.f778m1 = new e0(this, 0);
    }

    public static void l(MainActivityRTSP mainActivityRTSP, boolean z3) {
        byte[] bArr = mainActivityRTSP.f782o0;
        if (z3) {
            bArr[7] = (byte) (bArr[7] | 16);
        } else {
            bArr[7] = (byte) (bArr[7] & (-17));
        }
        mainActivityRTSP.A("舵机下行");
    }

    public static void m(MainActivityRTSP mainActivityRTSP, boolean z3) {
        byte[] bArr = mainActivityRTSP.f782o0;
        if (z3) {
            bArr[7] = (byte) (bArr[7] | 8);
        } else {
            bArr[7] = (byte) (bArr[7] & (-9));
        }
        mainActivityRTSP.A("舵机上行");
    }

    public static void n(MainActivityRTSP mainActivityRTSP, File file) {
        String str;
        if (mainActivityRTSP.f749b1) {
            str = "zh-cn-ptm";
        } else {
            str = "en-us-ptm";
        }
        i a5 = i.a();
        Config config = a5.f1762a;
        SphinxBaseJNI.Config_setFloat(config.f1763a, config, "-kws_threshold", 1.0E10f);
        SphinxBaseJNI.Config_setBoolean(config.f1763a, config, "-allphone_ci", true);
        a5.b("-hmm", new File(file, str).getPath());
        a5.b("-dict", new File(file, str.concat("/test.dic")).getPath());
        a5.b("-rawlogdir", file.getPath());
        h hVar = new h(config);
        mainActivityRTSP.f747a1 = hVar;
        hVar.b(mainActivityRTSP);
        mainActivityRTSP.f747a1.a(new File(file, str.concat("/menu.gram")));
    }

    public static String w(int i3) {
        return (i3 & 255) + "." + ((i3 >> 8) & 255) + "." + ((i3 >> 16) & 255) + "." + ((i3 >> 24) & 255);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final void A(String str) {
        Log.d("MainActivityRTSP谁发送", str);
        boolean z3 = this.T0;
        JNICMD jnicmd = this.c;
        int i3 = 3;
        if (z3) {
            byte[] bArr = this.f782o0;
            byte b = bArr[2];
            while (i3 < 18) {
                i3++;
                b ^= bArr[i3];
            }
            bArr[18] = (byte) (b & 255);
            bArr[19] = -103;
            jnicmd.updataData(bArr);
            return;
        }
        byte[] bArr2 = this.f780n0;
        byte b5 = bArr2[6];
        byte b6 = bArr2[7];
        byte b7 = bArr2[8];
        byte b8 = bArr2[9];
        byte b9 = bArr2[10];
        byte b10 = (byte) (((((b5 ^ b6) ^ b7) ^ b8) ^ b9) & 255);
        bArr2[11] = b10;
        bArr2[13] = (byte) ((((((((b5 ^ (((bArr2[3] ^ bArr2[2]) ^ bArr2[4]) ^ bArr2[5])) ^ b6) ^ b7) ^ b8) ^ b9) ^ b10) ^ bArr2[12]) & 255);
        jnicmd.updataData(bArr2);
        StringBuilder sb = new StringBuilder("  controlData[9]");
        sb.append((int) bArr2[9]);
        sb.append("  controlData[13]");
        a1.i.u(sb, bArr2[13], "MainActivityRTSP");
    }

    public final void B(boolean z3) {
        if (z3) {
            this.E.setVisibility(0);
            this.f789t.setVisibility(0);
            this.C.setVisibility(0);
            this.B.setVisibility(0);
            this.w.setVisibility(0);
            this.F.setVisibility(0);
            this.K0.setVisibility(0);
            this.J.setVisibility(0);
            return;
        }
        this.E.setVisibility(8);
        this.f789t.setVisibility(8);
        this.C.setVisibility(8);
        this.B.setVisibility(8);
        this.w.setVisibility(8);
        this.F.setVisibility(8);
        this.K0.setVisibility(8);
        this.J.setVisibility(8);
    }

    public final void C(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    @Override // v2.a
    public final void a(int i3) {
        if (!x()) {
            C(getResources().getString(2131755085));
            return;
        }
        switch (i3) {
            case 1:
                this.f769j1 = "   低速模式";
                this.f784p0 = 40;
                q(this.f794v0, this.f795w0);
                break;
            case 2:
                this.f769j1 = "中速模式";
                this.f784p0 = 70;
                q(this.f794v0, this.f795w0);
                break;
            case 3:
                this.f769j1 = " 高速模式";
                this.f784p0 = 100;
                q(this.f794v0, this.f795w0);
                break;
            case 4:
                this.f769j1 = "重力感应 on";
                this.N.setGravity(true);
                this.f785q0 = true;
                break;
            case 5:
                this.f769j1 = "重力感应 off";
                this.N.setGravity(false);
                this.f785q0 = false;
                break;
            case 6:
                this.f769j1 = " 校准";
                byte[] bArr = this.f780n0;
                bArr[10] = (byte) (bArr[10] | 128);
                A("矫正");
                this.f761g1.sendEmptyMessageDelayed(5, 1000L);
                break;
            case 7:
                this.f769j1 = "  图片翻转";
                this.f757f0 = !this.f757f0;
                break;
        }
        C(this.f769j1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // e4.a
    public final void d(Hypothesis hypothesis) {
        char c;
        if (hypothesis != null) {
            String Hypothesis_hypstr_get = PocketSphinxJNI.Hypothesis_hypstr_get(hypothesis.f1765a, hypothesis);
            Log.i("MainActivityRTSP", " onResult text=" + Hypothesis_hypstr_get);
            if (this.f790t0) {
                Hypothesis_hypstr_get.getClass();
                boolean z3 = this.T0;
                byte[] bArr = this.f780n0;
                byte[] bArr2 = this.f782o0;
                switch (Hypothesis_hypstr_get.hashCode()) {
                    case -1881579439:
                        if (Hypothesis_hypstr_get.equals("RECORD")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1390363677:
                        if (Hypothesis_hypstr_get.equals("BACKWARD")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 69715:
                        if (Hypothesis_hypstr_get.equals("FLY")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 705355:
                        if (Hypothesis_hypstr_get.equals("右飞")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 777242:
                        if (Hypothesis_hypstr_get.equals("录像")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 784312:
                        if (Hypothesis_hypstr_get.equals("左飞")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 813114:
                        if (Hypothesis_hypstr_get.equals("拍照")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1161799:
                        if (Hypothesis_hypstr_get.equals("起飞")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1226640:
                        if (Hypothesis_hypstr_get.equals("降落")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case 2329067:
                        if (Hypothesis_hypstr_get.equals("LAND")) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case 2332679:
                        if (Hypothesis_hypstr_get.equals("LEFT")) {
                            c = '\n';
                            break;
                        }
                        c = 65535;
                        break;
                    case 21371647:
                        if (Hypothesis_hypstr_get.equals("向前进")) {
                            c = 11;
                            break;
                        }
                        c = 65535;
                        break;
                    case 21385603:
                        if (Hypothesis_hypstr_get.equals("向后退")) {
                            c = '\f';
                            break;
                        }
                        c = 65535;
                        break;
                    case 40836773:
                        if (Hypothesis_hypstr_get.equals("FORWARD")) {
                            c = '\r';
                            break;
                        }
                        c = 65535;
                        break;
                    case 76105234:
                        if (Hypothesis_hypstr_get.equals("PHOTO")) {
                            c = 14;
                            break;
                        }
                        c = 65535;
                        break;
                    case 77974001:
                        if (Hypothesis_hypstr_get.equals("RIGHI")) {
                            c = 15;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
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
                        if (z3) {
                            bArr2[3] = (byte) (bArr2[3] - 60);
                            Log.d("MainActivityRTSP", "controlDataOpflow[3]=" + ((int) bArr2[3]));
                            A("mRightRocker");
                            return;
                        }
                        bArr[7] = (byte) (bArr[7] - 60);
                        Log.d("MainActivityRTSP", "controlData[7]=" + ((int) bArr[7]));
                        A("mRightRocker");
                        return;
                    case 2:
                    case 7:
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        this.f796x.performClick();
                        return;
                    case 3:
                    case 15:
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        if (z3) {
                            bArr2[2] = (byte) (bArr2[2] + 60);
                            Log.d("MainActivityRTSP", "controlDataOpflow[2]=" + ((int) bArr2[2]));
                            A("mRightRocker");
                            return;
                        }
                        bArr[6] = (byte) (bArr[6] + 60);
                        Log.d("MainActivityRTSP", "controlData[6]=" + ((int) bArr[6]));
                        A("mRightRocker");
                        return;
                    case 5:
                    case '\n':
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        if (z3) {
                            bArr2[2] = (byte) (bArr2[2] - 60);
                            Log.d("MainActivityRTSP", "controlDataOpflow[2]=" + ((int) bArr2[2]));
                            A("mRightRocker");
                            return;
                        }
                        bArr[6] = (byte) (bArr[6] - 60);
                        Log.d("MainActivityRTSP", "controlData[6]=" + ((int) bArr[6]));
                        A("mRightRocker");
                        return;
                    case 6:
                    case 14:
                        this.s.performClick();
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        return;
                    case '\b':
                    case '\t':
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        this.f798y.performClick();
                        return;
                    case 11:
                    case '\r':
                        Toast.makeText(getApplicationContext(), Hypothesis_hypstr_get, 0).show();
                        if (z3) {
                            bArr2[3] = (byte) (bArr2[3] + 60);
                            Log.d("MainActivityRTSP", "controlDataOpflow[3]=" + ((int) bArr2[3]));
                            A("mRightRocker");
                            return;
                        }
                        bArr[7] = (byte) (bArr[7] + 60);
                        Log.d("MainActivityRTSP", "controlData[6]x=" + ((int) bArr[7]));
                        A("mRightRocker");
                        return;
                    default:
                        return;
                }
            }
        }
    }

    @Override // e4.a
    public final void f(Hypothesis hypothesis) {
        if (hypothesis == null) {
            return;
        }
        String Hypothesis_hypstr_get = PocketSphinxJNI.Hypothesis_hypstr_get(hypothesis.f1765a, hypothesis);
        this.f747a1.d();
        this.f747a1.c();
        Log.i("MainActivityRTSP", " onPartialResult text=" + Hypothesis_hypstr_get);
    }

    @Override // e4.a
    public final void g() {
        Log.d("MainActivityRTSP", "onBeginningOfSpeech");
    }

    @Override // v2.c
    public final void h() {
        if (!x()) {
            C(getResources().getString(2131755085));
            return;
        }
        if (this.T0) {
            byte[] bArr = this.f782o0;
            bArr[6] = (byte) (bArr[6] | 2);
        } else {
            byte[] bArr2 = this.f780n0;
            bArr2[10] = (byte) (bArr2[10] | 4);
        }
        A("btStop");
        this.f761g1.sendEmptyMessageDelayed(4, 1000L);
    }

    @Override // e4.a
    public final void k() {
        StringBuilder sb = new StringBuilder(" onEndOfSpeech recognizer.getSearchName()=");
        Decoder decoder = this.f747a1.f1759a;
        sb.append(PocketSphinxJNI.Decoder_getSearch(decoder.f1764a, decoder));
        Log.i("MainActivityRTSP", sb.toString());
    }

    public final void o() {
        c1.b bVar = this.R0;
        boolean z3 = this.f757f0;
        SharedPreferences.Editor editor = (SharedPreferences.Editor) bVar.c;
        editor.putBoolean("isRotate", z3);
        editor.commit();
        h hVar = this.f747a1;
        if (hVar != null) {
            if (hVar.e()) {
                Log.i("h", "Cancel recognition");
            }
            this.f747a1.c.release();
        }
        MediaPlayer mediaPlayer = this.V;
        if (mediaPlayer != null) {
            mediaPlayer.close();
        }
        this.c.closeSocket();
        Log.d("MainActivityRTSP", " finish()");
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i3, int i5, Intent intent) {
        super.onActivityResult(i3, i5, intent);
        if (i3 == 1 && i5 == 2) {
            MusicInfo musicInfo = (MusicInfo) intent.getParcelableExtra("MusicInfo");
            this.O0 = musicInfo;
            if (musicInfo != null && !TextUtils.isEmpty(musicInfo.path)) {
                this.N0.setVisibility(0);
                this.M0.setBackground(getDrawable(2131558596));
                Log.d("MainActivityRTSP", "已选:" + this.O0.toString());
                return;
            }
            this.M0.setBackground(getDrawable(2131558595));
            this.N0.setVisibility(8);
        }
    }

    @Override // com.rockcarry.fanplayer.MediaPlayer.Callback
    public final void onAudioData(byte[] bArr, int i3, int i5) {
    }

    @Override // com.rockcarry.fanplayer.MediaPlayer.Callback
    public final void onAudioInit(int i3, int i5) {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [a1.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.f763h0) {
            ?? obj = new Object();
            obj.b = null;
            String string = getString(2131755392);
            String string2 = getString(2131755391);
            String string3 = getString(2131755385);
            String string4 = getString(2131755386);
            c0 c0Var = new c0(this, 1);
            ?? centerPopupView = new CenterPopupView(this);
            centerPopupView.F = false;
            centerPopupView.q = 0;
            centerPopupView.p();
            centerPopupView.f1084x = string;
            centerPopupView.f1085y = string2;
            centerPopupView.f1086z = null;
            centerPopupView.A = string3;
            centerPopupView.B = string4;
            centerPopupView.s = c0Var;
            centerPopupView.F = false;
            centerPopupView.f1034a = obj;
            centerPopupView.o();
            return;
        }
        o();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a1.i.u(new StringBuilder("onConfigurationChanged  --"), configuration.orientation, "MainActivityRTSP");
        if (configuration.orientation == 2) {
            this.I.setBackground(getDrawable(2131558413));
            this.f751c1 = true;
            if (this.L0.isChecked()) {
                if (this.Q0) {
                    this.f781o.setVisibility(0);
                    this.O.setShow(true);
                    this.P.setShow(true);
                } else {
                    this.f779n.setVisibility(0);
                    this.M.setShow(true);
                    this.N.setShow(true);
                }
                this.f759g.setVisibility(0);
                this.f773l.setVisibility(0);
            }
        } else {
            this.I.setBackground(getDrawable(2131558414));
            this.f751c1 = false;
            if (this.L0.isChecked()) {
                if (this.Q0) {
                    this.f781o.setVisibility(8);
                } else {
                    this.f779n.setVisibility(8);
                }
                this.f759g.setVisibility(4);
                this.f773l.setVisibility(4);
            }
        }
        B(this.f751c1);
    }

    /* JADX WARN: Type inference failed for: r2v100, types: [s2.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v53, types: [g3.a, java.lang.Object] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d("MainActivityRTSP", "onCreate");
        setContentView(2131427389);
        this.d.initFFmpeg();
        this.R0 = new c1.b(this, 22);
        Button button = (Button) findViewById(2131230876);
        this.W0 = button;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.X0 = (LinearLayout) findViewById(2131231110);
        ((SignSeekBar) findViewById(2131231135)).setOnProgressChangedListener(new c0(this, 2));
        this.Y0 = (RadioGroup) findViewById(2131231298);
        this.Z0 = (RadioGroup) findViewById(2131231299);
        RadioButton radioButton = (RadioButton) findViewById(2131231274);
        RadioButton radioButton2 = (RadioButton) findViewById(2131231275);
        RadioButton radioButton3 = (RadioButton) findViewById(2131231276);
        RadioButton radioButton4 = (RadioButton) findViewById(2131231277);
        findViewById(2131230867).setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        findViewById(2131230880).setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        if (this.R0.t("isShowOpticalFlowView")) {
            this.W0.setVisibility(0);
        } else {
            this.W0.setVisibility(8);
            this.X0.setVisibility(8);
        }
        this.f757f0 = ((SharedPreferences) this.R0.b).getBoolean("isRotate", true);
        this.Q0 = this.R0.t("isRightMode");
        Log.d("MainActivityRTSP", "isRightMode=" + this.Q0);
        h3.b.f().c(this);
        getWindow().addFlags(128);
        this.f756f = (WifiManager) getApplication().getApplicationContext().getSystemService("wifi");
        BatteryView batteryView = (BatteryView) findViewById(2131231125);
        this.G0 = batteryView;
        batteryView.setLevelHeight(50);
        this.G0.setVisibility(8);
        this.q = (ImageView) findViewById(2131231288);
        ((TextView) findViewById(2131231305)).setVisibility(8);
        ((TextView) findViewById(2131231096)).setVisibility(8);
        ((TextView) findViewById(2131231462)).setVisibility(8);
        ((TextView) findViewById(2131231475)).setVisibility(8);
        ((TextView) findViewById(2131231463)).setVisibility(8);
        CheckBox checkBox = (CheckBox) findViewById(2131230900);
        this.H0 = checkBox;
        checkBox.setOnCheckedChangeListener(this.f772k1);
        CheckBox checkBox2 = (CheckBox) findViewById(2131230905);
        this.L0 = checkBox2;
        checkBox2.setOnCheckedChangeListener(this.f772k1);
        this.N0 = (ImageView) findViewById(2131231085);
        CustomButton customButton = (CustomButton) findViewById(2131230860);
        this.M0 = customButton;
        customButton.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CheckBox checkBox3 = (CheckBox) findViewById(2131230916);
        this.I0 = checkBox3;
        checkBox3.setOnCheckedChangeListener(this.f772k1);
        CheckBox checkBox4 = (CheckBox) findViewById(2131230901);
        this.J0 = checkBox4;
        checkBox4.setOnCheckedChangeListener(this.f772k1);
        CheckBox checkBox5 = (CheckBox) findViewById(2131230898);
        this.K0 = checkBox5;
        checkBox5.setOnCheckedChangeListener(this.f772k1);
        this.H0.setChecked(false);
        this.f750c0 = (ZoomView) findViewById(2131231153);
        ?? obj = new Object();
        obj.f3530a = null;
        obj.d = false;
        obj.f3533g = new MediaCodec.BufferInfo();
        obj.f3530a = this;
        this.X = obj;
        GLSurface gLSurface = (GLSurface) findViewById(2131231250);
        this.T = gLSurface;
        MyGLRender myGLRender = new MyGLRender(gLSurface);
        this.U = myGLRender;
        this.T.setRenderer(myGLRender);
        this.W = true;
        Log.d("MainActivityRTSP", "mIsLive=" + this.W + " mUrl=rtsp://172.16.11.1/live/ch00_1");
        this.V = new MediaPlayer("rtsp://172.16.11.1/live/ch00_1", this.f778m1, "video_hwaccel=1;init_timeout=2000;auto_reconnect=2000;audio_bufpktn=4;video_bufpktn=1;rtsp_transport=1;video_thread_count=8;", this);
        this.S = (ImageView) findViewById(2131231081);
        ImageView imageView = (ImageView) findViewById(2131231082);
        this.f752d0 = (RelativeLayout) findViewById(2131231310);
        VerticalRangeSeekBar verticalRangeSeekBar = (VerticalRangeSeekBar) findViewById(2131231521);
        this.f754e0 = verticalRangeSeekBar;
        verticalRangeSeekBar.setOnRangeChangedListener(new c0(this, 4));
        if (getResources().getConfiguration().locale.getCountry().equals("CN")) {
            this.f749b1 = true;
        } else {
            this.f749b1 = false;
        }
        TextView textView = (TextView) findViewById(2131231482);
        this.K = (TextView) findViewById(2131231485);
        this.L = (TextView) findViewById(2131231290);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131231289);
        this.f776m = linearLayout;
        linearLayout.setVisibility(4);
        this.f770k = (LinearLayout) findViewById(2131231130);
        this.f779n = (LinearLayout) findViewById(2131231313);
        this.f781o = (LinearLayout) findViewById(2131231314);
        this.f773l = (LinearLayout) findViewById(2131231209);
        CustomButton customButton2 = (CustomButton) findViewById(2131230836);
        this.C = customButton2;
        customButton2.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton3 = (CustomButton) findViewById(2131230874);
        this.B = customButton3;
        customButton3.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton4 = (CustomButton) findViewById(2131230875);
        this.A = customButton4;
        customButton4.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton5 = (CustomButton) findViewById(2131230848);
        this.J = customButton5;
        customButton5.setVisibility(4);
        this.J.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton6 = (CustomButton) findViewById(2131230881);
        this.f800z = customButton6;
        customButton6.setVisibility(4);
        this.f800z.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton7 = (CustomButton) findViewById(2131230861);
        this.I = customButton7;
        customButton7.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton8 = (CustomButton) findViewById(2131230852);
        this.f796x = customButton8;
        customButton8.setVisibility(4);
        this.f796x.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton9 = (CustomButton) findViewById(2131230851);
        this.f798y = customButton9;
        customButton9.setVisibility(4);
        this.f798y.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        CustomButton customButton10 = (CustomButton) findViewById(2131230846);
        this.f793v = customButton10;
        customButton10.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        ((HTrimView) findViewById(2131231456)).setOnTrimViewInterface(new z(this, 4));
        ((HTrimView) findViewById(2131231457)).setOnTrimViewInterface(new z(this, 5));
        VTrimView vTrimView = (VTrimView) findViewById(2131231458);
        this.f759g = vTrimView;
        vTrimView.setOnTrimViewInterface(new z(this, 6));
        CustomButton customButton11 = (CustomButton) findViewById(2131230839);
        this.w = customButton11;
        customButton11.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        TrackControlPaintView trackControlPaintView = (TrackControlPaintView) findViewById(2131231149);
        this.Q = trackControlPaintView;
        trackControlPaintView.setOnLocaListener(new z(this, 7));
        this.R = (LinearLayout) findViewById(2131231150);
        this.f783p = (LinearLayout) findViewById(2131231111);
        CustomButton customButton12 = (CustomButton) findViewById(2131230877);
        this.G = customButton12;
        customButton12.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.N = (MyRockerView) findViewById(2131231132);
        this.P = (MyRockerView) findViewById(2131231133);
        this.M = (MyRockerView) findViewById(2131231128);
        this.O = (MyRockerView) findViewById(2131231129);
        this.N.setOnLocaListener(new z(this, 8));
        this.P.setOnLocaListener(new z(this, 9));
        this.M.setOnLocaListener(new z(this, 10));
        this.O.setOnLocaListener(new z(this, 0));
        this.f779n.setVisibility(8);
        this.f781o.setVisibility(8);
        this.f786r = (CustomButton) findViewById(2131230842);
        this.f791u = (CustomButton) findViewById(2131230849);
        this.f789t = (CustomButton) findViewById(2131230869);
        CustomButton customButton13 = (CustomButton) findViewById(2131230841);
        this.s = (CustomButton) findViewById(2131230838);
        this.D = (CustomButton) findViewById(2131230868);
        this.E = (CustomButton) findViewById(2131230859);
        this.F = (CustomButton) findViewById(2131230872);
        this.H = (CustomButton) findViewById(2131230879);
        this.f786r.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.f791u.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.f789t.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        this.D0 = new v3.c(this);
        String[] strArr = Build.VERSION.SDK_INT >= 33 ? new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"} : new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        p4.m a5 = com.bumptech.glide.d.a(this.s);
        v3.c cVar = this.D0;
        cVar.getClass();
        a5.d(new v3.b(cVar, strArr)).g(new o4.b(new z(this, 1)));
        p4.m a6 = com.bumptech.glide.d.a(this.D);
        v3.c cVar2 = this.D0;
        cVar2.getClass();
        a6.d(new v3.b(cVar2, strArr)).g(new o4.b(new z(this, 2)));
        this.E.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        p4.m a7 = com.bumptech.glide.d.a(this.H);
        v3.c cVar3 = this.D0;
        cVar3.getClass();
        a7.d(new v3.b(cVar3, new String[]{"android.permission.RECORD_AUDIO"})).g(new o4.b(new z(this, 3)));
        this.F.setOnClickListener(new View.OnClickListener(this) { // from class: t2.y
            public final /* synthetic */ MainActivityRTSP b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v10, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v7, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v3, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6 = 1;
                switch (r2) {
                    case 0:
                        MainActivityRTSP mainActivityRTSP = this.b;
                        if (mainActivityRTSP.f763h0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string = mainActivityRTSP.getString(2131755392);
                            String string2 = mainActivityRTSP.getString(2131755391);
                            String string3 = mainActivityRTSP.getString(2131755385);
                            String string4 = mainActivityRTSP.getString(2131755386);
                            c0 c0Var = new c0(mainActivityRTSP, 3);
                            ?? centerPopupView = new CenterPopupView(mainActivityRTSP);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = c0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj2;
                            centerPopupView.o();
                            return;
                        }
                        mainActivityRTSP.startActivityForResult(new Intent(mainActivityRTSP, MusicActivity.class), 1);
                        return;
                    case 1:
                        int i7 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP2 = this.b;
                        if (!mainActivityRTSP2.x()) {
                            mainActivityRTSP2.C(mainActivityRTSP2.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP2.c.setStopSendUdp(false);
                        e0 e0Var = mainActivityRTSP2.f761g1;
                        if (mainActivityRTSP2.T0) {
                            byte[] bArr = mainActivityRTSP2.f782o0;
                            bArr[6] = (byte) (bArr[6] | 4);
                            mainActivityRTSP2.A("矫正");
                            e0Var.sendEmptyMessageDelayed(5, 1000L);
                            return;
                        }
                        byte[] bArr2 = mainActivityRTSP2.f780n0;
                        bArr2[10] = (byte) (bArr2[10] | 128);
                        mainActivityRTSP2.A("矫正");
                        e0Var.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 2:
                        MainActivityRTSP mainActivityRTSP3 = this.b;
                        if (mainActivityRTSP3.f763h0) {
                            ?? obj22 = new Object();
                            obj22.b = null;
                            String string5 = mainActivityRTSP3.getString(2131755392);
                            String string6 = mainActivityRTSP3.getString(2131755391);
                            String string7 = mainActivityRTSP3.getString(2131755385);
                            String string8 = mainActivityRTSP3.getString(2131755386);
                            c0 c0Var2 = new c0(mainActivityRTSP3, 5);
                            ?? centerPopupView2 = new CenterPopupView(mainActivityRTSP3);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = c0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj22;
                            centerPopupView2.o();
                            return;
                        }
                        mainActivityRTSP3.o();
                        return;
                    case 3:
                        MainActivityRTSP mainActivityRTSP4 = this.b;
                        if (mainActivityRTSP4.f763h0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = mainActivityRTSP4.getString(2131755392);
                            String string10 = mainActivityRTSP4.getString(2131755391);
                            String string11 = mainActivityRTSP4.getString(2131755385);
                            String string12 = mainActivityRTSP4.getString(2131755386);
                            c0 c0Var3 = new c0(mainActivityRTSP4, 6);
                            ?? centerPopupView3 = new CenterPopupView(mainActivityRTSP4);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = c0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        mainActivityRTSP4.startActivity(new Intent(mainActivityRTSP4, FileDirActivity.class));
                        return;
                    case 4:
                        MainActivityRTSP mainActivityRTSP5 = this.b;
                        int i8 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP5.x()) {
                            mainActivityRTSP5.C(mainActivityRTSP5.getResources().getString(2131755085));
                            return;
                        } else {
                            mainActivityRTSP5.f757f0 = !mainActivityRTSP5.f757f0;
                            return;
                        }
                    case 5:
                        MainActivityRTSP mainActivityRTSP6 = this.b;
                        int i9 = MainActivityRTSP.f746n1;
                        if (!mainActivityRTSP6.x()) {
                            mainActivityRTSP6.C(mainActivityRTSP6.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP6.f766i0) {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558534));
                        } else {
                            mainActivityRTSP6.E.setBackground(mainActivityRTSP6.getDrawable(2131558533));
                        }
                        mainActivityRTSP6.f766i0 = !mainActivityRTSP6.f766i0;
                        return;
                    case 6:
                        MainActivityRTSP mainActivityRTSP7 = this.b;
                        if (mainActivityRTSP7.f792u0) {
                            mainActivityRTSP7.C(mainActivityRTSP7.getResources().getString(2131755320));
                            return;
                        } else if (mainActivityRTSP7.f785q0) {
                            mainActivityRTSP7.f785q0 = false;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(false);
                                mainActivityRTSP7.P.setStopUI(false);
                                mainActivityRTSP7.O.setStopUI(false);
                            } else {
                                mainActivityRTSP7.N.setGravity(false);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558468));
                            return;
                        } else if (!mainActivityRTSP7.K0.isChecked()) {
                            mainActivityRTSP7.f785q0 = true;
                            if (mainActivityRTSP7.Q0) {
                                mainActivityRTSP7.P.setGravity(true);
                                mainActivityRTSP7.P.setStopUI(true);
                                mainActivityRTSP7.O.setStopUI(true);
                            } else {
                                mainActivityRTSP7.N.setGravity(true);
                            }
                            mainActivityRTSP7.F.setBackground(mainActivityRTSP7.getDrawable(2131558469));
                            return;
                        } else {
                            mainActivityRTSP7.C(mainActivityRTSP7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i10 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP8 = this.b;
                        if (!mainActivityRTSP8.x()) {
                            mainActivityRTSP8.C(mainActivityRTSP8.getResources().getString(2131755085));
                            return;
                        }
                        int i11 = mainActivityRTSP8.f784p0;
                        if (i11 == 40) {
                            mainActivityRTSP8.f784p0 = 70;
                            i3 = 2131558456;
                        } else if (i11 == 70) {
                            mainActivityRTSP8.f784p0 = 100;
                            i3 = 2131558454;
                        } else {
                            if (i11 == 100) {
                                mainActivityRTSP8.f784p0 = 40;
                            }
                            i3 = 2131558455;
                        }
                        mainActivityRTSP8.B.setBackground(mainActivityRTSP8.getDrawable(i3));
                        mainActivityRTSP8.q(mainActivityRTSP8.f794v0, mainActivityRTSP8.f795w0);
                        return;
                    case 8:
                        this.b.E0.a();
                        return;
                    case 9:
                        int i12 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP9 = this.b;
                        if (!mainActivityRTSP9.x()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755085));
                            return;
                        } else if (mainActivityRTSP9.K0.isChecked()) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755166));
                            return;
                        } else if (mainActivityRTSP9.f785q0) {
                            mainActivityRTSP9.C(mainActivityRTSP9.getResources().getString(2131755183));
                            return;
                        } else {
                            boolean z3 = mainActivityRTSP9.T0;
                            if (z3) {
                                mainActivityRTSP9.f792u0 = true;
                                byte[] bArr3 = mainActivityRTSP9.f782o0;
                                bArr3[6] = (byte) (8 | bArr3[6]);
                                mainActivityRTSP9.A("isFanGun--isOpflow" + z3);
                                mainActivityRTSP9.f761g1.sendEmptyMessageDelayed(10, 1000L);
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                return;
                            } else if (mainActivityRTSP9.f792u0) {
                                byte[] bArr4 = mainActivityRTSP9.f780n0;
                                bArr4[10] = (byte) (bArr4[10] & (-9));
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558506));
                                mainActivityRTSP9.f792u0 = false;
                                mainActivityRTSP9.A("isFanGun--false");
                                return;
                            } else {
                                mainActivityRTSP9.J.setBackground(mainActivityRTSP9.getResources().getDrawable(2131558505));
                                mainActivityRTSP9.f792u0 = true;
                                mainActivityRTSP9.A0 = false;
                                return;
                            }
                        }
                    case 10:
                        int i13 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP10 = this.b;
                        if (!mainActivityRTSP10.x()) {
                            mainActivityRTSP10.C(mainActivityRTSP10.getResources().getString(2131755085));
                            return;
                        }
                        if (mainActivityRTSP10.T0) {
                            boolean z5 = mainActivityRTSP10.f788s0;
                            byte[] bArr5 = mainActivityRTSP10.f782o0;
                            if (z5) {
                                bArr5[7] = (byte) (bArr5[7] & (-2));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr5[7] = (byte) (bArr5[7] | 1);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        } else {
                            boolean z6 = mainActivityRTSP10.f788s0;
                            byte[] bArr6 = mainActivityRTSP10.f780n0;
                            if (z6) {
                                bArr6[10] = (byte) (bArr6[10] & (-17));
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558496));
                            } else {
                                bArr6[10] = (byte) (bArr6[10] | 16);
                                mainActivityRTSP10.f800z.setBackground(mainActivityRTSP10.getDrawable(2131558495));
                            }
                        }
                        mainActivityRTSP10.f788s0 = !mainActivityRTSP10.f788s0;
                        mainActivityRTSP10.A("btWuTou");
                        return;
                    case 11:
                        MainActivityRTSP mainActivityRTSP11 = this.b;
                        if (mainActivityRTSP11.K0.isChecked()) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755167));
                            return;
                        } else if (mainActivityRTSP11.f766i0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755169));
                            return;
                        } else if (mainActivityRTSP11.f785q0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755168));
                            return;
                        } else if (mainActivityRTSP11.f763h0) {
                            mainActivityRTSP11.C(mainActivityRTSP11.getString(2131755348));
                            return;
                        } else if (mainActivityRTSP11.f751c1) {
                            if (mainActivityRTSP11.getRequestedOrientation() != 1) {
                                mainActivityRTSP11.setRequestedOrientation(1);
                                return;
                            }
                            return;
                        } else if (mainActivityRTSP11.getRequestedOrientation() != 0) {
                            mainActivityRTSP11.setRequestedOrientation(0);
                            return;
                        } else {
                            return;
                        }
                    case 12:
                        int i14 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP12 = this.b;
                        if (!mainActivityRTSP12.x()) {
                            mainActivityRTSP12.C(mainActivityRTSP12.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP12.c.setStopSendUdp(false);
                        e0 e0Var2 = mainActivityRTSP12.f761g1;
                        if (mainActivityRTSP12.T0) {
                            byte[] bArr7 = mainActivityRTSP12.f782o0;
                            bArr7[7] = (byte) (bArr7[7] | 1);
                            mainActivityRTSP12.A("btFlyUp");
                            e0Var2.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr8 = mainActivityRTSP12.f780n0;
                        bArr8[10] = (byte) (bArr8[10] | 1);
                        mainActivityRTSP12.A("btFlyUp");
                        e0Var2.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 13:
                        int i15 = MainActivityRTSP.f746n1;
                        MainActivityRTSP mainActivityRTSP13 = this.b;
                        if (!mainActivityRTSP13.x()) {
                            mainActivityRTSP13.C(mainActivityRTSP13.getResources().getString(2131755085));
                            return;
                        }
                        mainActivityRTSP13.c.setStopSendUdp(false);
                        e0 e0Var3 = mainActivityRTSP13.f761g1;
                        if (mainActivityRTSP13.T0) {
                            byte[] bArr9 = mainActivityRTSP13.f782o0;
                            bArr9[6] = (byte) (bArr9[6] | 1);
                            mainActivityRTSP13.A("btFlyDown");
                            e0Var3.sendEmptyMessageDelayed(3, 1000L);
                            return;
                        }
                        byte[] bArr10 = mainActivityRTSP13.f780n0;
                        bArr10[10] = (byte) (2 | bArr10[10]);
                        mainActivityRTSP13.A("btFlyDown");
                        e0Var3.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 14:
                        MainActivityRTSP mainActivityRTSP14 = this.b;
                        if (mainActivityRTSP14.f787r0) {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558510));
                            mainActivityRTSP14.f796x.setVisibility(4);
                            mainActivityRTSP14.f798y.setVisibility(4);
                        } else {
                            mainActivityRTSP14.f793v.setBackground(mainActivityRTSP14.getDrawable(2131558509));
                            mainActivityRTSP14.f796x.setVisibility(0);
                            mainActivityRTSP14.f798y.setVisibility(0);
                        }
                        mainActivityRTSP14.f787r0 = !mainActivityRTSP14.f787r0;
                        return;
                    case 15:
                        MainActivityRTSP mainActivityRTSP15 = this.b;
                        if (mainActivityRTSP15.X0.getVisibility() == 8) {
                            mainActivityRTSP15.X0.setVisibility(0);
                            mainActivityRTSP15.W0.setText("隐藏");
                            return;
                        }
                        mainActivityRTSP15.X0.setVisibility(8);
                        mainActivityRTSP15.W0.setText("显示");
                        return;
                    case 16:
                        int i16 = MainActivityRTSP.f746n1;
                        this.b.getClass();
                        return;
                    case 17:
                        MainActivityRTSP mainActivityRTSP16 = this.b;
                        if (mainActivityRTSP16.Y0.getCheckedRadioButtonId() == 2131231274) {
                            i5 = -1;
                        } else {
                            i5 = 1;
                        }
                        if (mainActivityRTSP16.Z0.getCheckedRadioButtonId() == 2131231276) {
                            i6 = -1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i5, " dir_y=", i6, " sensitive="), mainActivityRTSP16.f775l1, "MainActivityRTSP");
                        return;
                    case 18:
                        MainActivityRTSP mainActivityRTSP17 = this.b;
                        if (mainActivityRTSP17.f763h0) {
                            mainActivityRTSP17.C(mainActivityRTSP17.getString(2131755348));
                            return;
                        }
                        return;
                    default:
                        MainActivityRTSP mainActivityRTSP18 = this.b;
                        int ordinal = mainActivityRTSP18.Q.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558631));
                                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558635));
                                    mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558634));
                                mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558633));
                            mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        mainActivityRTSP18.G.setBackground(mainActivityRTSP18.getDrawable(2131558632));
                        mainActivityRTSP18.Q.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                }
            }
        });
        ((CustomButton) findViewById(2131230844)).setOnTouchListener(new a0(this, 0));
        ((CustomButton) findViewById(2131230843)).setOnTouchListener(new a0(this, 1));
        new ByteArrayOutputStream();
        new ArrayList();
        this.f771k0 = Executors.newSingleThreadExecutor();
        this.f777m0 = Executors.newSingleThreadExecutor();
        this.f774l0 = Executors.newFixedThreadPool(5);
        Log.d("MainActivityRTSP", "设备初始化默认已连接");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        registerReceiver(this.i1, intentFilter);
        this.A.setVisibility(8);
        this.f770k.setVisibility(8);
        this.f759g.setVisibility(4);
        this.f773l.setVisibility(4);
        if (this.F0 == null) {
            v2.b bVar = new v2.b(this);
            this.F0 = bVar;
            bVar.d = this;
        }
        this.E0 = new b(this);
        b bVar2 = new b(this);
        this.E0 = bVar2;
        bVar2.c = this;
        if (!MyApplication.f541h) {
            g3.b.a(getApplicationContext(), new Object());
        }
        SoundPool soundPool = new SoundPool(100, 3, 0);
        soundPool.load(this, 2131689480, 0);
        soundPool.load(this, 2131689479, 0);
        ((ViewGroup) findViewById(16908290)).getChildAt(0);
        new Timer();
        new x2.i();
        View inflate = LayoutInflater.from(this).inflate(2131427487, (ViewGroup) null);
        ImageView imageView2 = (ImageView) inflate.findViewById(2131230952);
        PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setTouchable(false);
        popupWindow.setFocusable(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(3.0f, 1.0f, 3.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setRepeatCount(0);
        scaleAnimation.setFillAfter(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setRepeatCount(0);
        alphaAnimation.setFillAfter(true);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        c0 c0Var = this.f764h1;
        JNICMD jnicmd = this.c;
        jnicmd.SetActivityJNIHandleInterface(c0Var);
        jnicmd.initUDP(MyApplication.f542i);
        if (this.T0) {
            byte[] bArr = this.f782o0;
            bArr[0] = 102;
            bArr[1] = 20;
            bArr[2] = Byte.MIN_VALUE;
            bArr[3] = Byte.MIN_VALUE;
            bArr[4] = Byte.MIN_VALUE;
            bArr[5] = Byte.MIN_VALUE;
            bArr[6] = 0;
            bArr[7] = 0;
            MyApplication.f543j = 40;
            bArr[8] = 0;
            bArr[9] = 0;
            bArr[10] = 0;
            bArr[11] = 0;
            bArr[12] = 0;
            bArr[13] = 0;
            bArr[14] = 0;
            bArr[15] = 0;
            bArr[16] = 0;
            bArr[17] = 0;
            int i3 = -128;
            for (int i5 = 3; i5 < 18; i5++) {
                i3 ^= bArr[i5];
            }
            bArr[18] = (byte) (i3 & 255);
            bArr[19] = -103;
        } else {
            byte[] bArr2 = this.f780n0;
            bArr2[0] = -52;
            bArr2[1] = 90;
            bArr2[2] = 1;
            bArr2[3] = -125;
            bArr2[4] = 9;
            bArr2[5] = 102;
            bArr2[6] = Byte.MIN_VALUE;
            bArr2[7] = Byte.MIN_VALUE;
            bArr2[8] = Byte.MIN_VALUE;
            bArr2[9] = Byte.MIN_VALUE;
            bArr2[10] = 0;
            byte b = (byte) 0;
            bArr2[11] = b;
            bArr2[12] = -103;
            bArr2[13] = (byte) ((b ^ 116) & 255);
        }
        A("初始化");
    }

    @Override // com.rockcarry.fanplayer.MediaPlayer.Callback
    public final void onDecMediacodec(byte[] bArr, int i3, long j2) {
        MediaCodec mediaCodec;
        Log.d("MainActivityRTSP", "onMediacodec size" + i3 + " pts=" + j2);
        l lVar = this.X;
        if (lVar.d) {
            Log.d("mediacodecDecode", "mediacodecDecode: bytes.length=" + bArr.length + " isIframe=" + i3 + " stopShow=" + lVar.d);
            if (i3 == 1) {
                lVar.d = false;
            } else {
                return;
            }
        }
        if ((bArr[0] != 0 || bArr[1] != 0 || bArr[2] != 0 || bArr[3] != 1) && (mediaCodec = lVar.f3532f) != null) {
            try {
                if (lVar.f3533g != null) {
                    try {
                        int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(System.currentTimeMillis() * 1000);
                        if (dequeueInputBuffer >= 0) {
                            ByteBuffer inputBuffer = lVar.f3532f.getInputBuffer(dequeueInputBuffer);
                            inputBuffer.clear();
                            inputBuffer.put(bArr);
                            lVar.f3532f.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, System.currentTimeMillis() * 1000, 0);
                        }
                        int dequeueOutputBuffer = lVar.f3532f.dequeueOutputBuffer(lVar.f3533g, 1000L);
                        if (dequeueOutputBuffer != -3) {
                            if (dequeueOutputBuffer != -2) {
                                if (dequeueOutputBuffer != -1) {
                                    Log.d("mediacodecDecode", dequeueOutputBuffer + " default");
                                    long j5 = lVar.f3533g.presentationTimeUs;
                                    ((MainActivityRTSP) lVar.f3530a).y(com.bumptech.glide.c.d(lVar.f3532f.getOutputImage(dequeueOutputBuffer)), lVar.b, lVar.c);
                                    lVar.f3532f.releaseOutputBuffer(dequeueOutputBuffer, true);
                                    return;
                                }
                                Log.d("mediacodecDecode", dequeueOutputBuffer + " 解码当前帧超时");
                                lVar.d = true;
                                return;
                            }
                            Log.d("mediacodecDecode", dequeueOutputBuffer + " format changed");
                            return;
                        }
                        Log.d("mediacodecDecode", dequeueOutputBuffer + " output buffers changed");
                    } catch (IllegalStateException unused) {
                        Log.d("mediacodecDecode", "encodeCodec.dequeueInputBuffer ---IllegalStateException");
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                Log.e("mediacodecDecode", "mediacodecDecode--" + e5.getMessage());
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.i1);
        this.f771k0.shutdown();
        this.f774l0.shutdown();
        this.f777m0.shutdown();
        h hVar = this.f747a1;
        if (hVar != null) {
            if (hVar.e()) {
                Log.i("h", "Cancel recognition");
            }
            this.f747a1.c.release();
        }
        Log.d("MainActivityRTSP", " onDestroy()");
    }

    @Override // e4.a
    public final void onError(Exception exc) {
        Log.i("MainActivityRTSP", " onError getMessage=" + exc.getMessage());
    }

    @Override // com.rockcarry.fanplayer.MediaPlayer.Callback
    public final void onMediacodecInit(int i3, int i5, int i6, byte[] bArr, byte[] bArr2) {
        String str;
        StringBuilder n5 = a1.i.n("onMediacodecInit mimetype", i3, " width=", i5, " height=");
        n5.append(i6);
        n5.append(" csd0.size+");
        n5.append(bArr.length);
        n5.append(" csd1.size+");
        a1.i.u(n5, bArr2.length, "MainActivityRTSP");
        l lVar = this.X;
        lVar.b = i5;
        lVar.c = i6;
        if (i3 == 1) {
            str = "video/avc";
        } else if (i3 == 2) {
            str = "video/hevc";
        } else {
            str = "";
        }
        try {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i5, i6);
            lVar.f3531e = createVideoFormat;
            createVideoFormat.setInteger("width", i5);
            lVar.f3531e.setInteger("height", i6);
            lVar.f3531e.setLong("max-input-size", i5 * i6);
            lVar.f3531e.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
            lVar.f3531e.setByteBuffer("csd-1", ByteBuffer.wrap(bArr2));
            Log.d("mediacodecDecode", "mediaFormat==" + lVar.f3531e.toString());
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(str);
            lVar.f3532f = createDecoderByType;
            createDecoderByType.configure(lVar.f3531e, (Surface) null, (MediaCrypto) null, 0);
            lVar.f3532f.start();
        } catch (Exception e5) {
            e5.printStackTrace();
            Log.e("mediacodecDecode", "mediacodecInit--" + e5.getMessage());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.Q0) {
            this.P.c();
        } else {
            this.N.c();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        Log.d("MainActivityRTSP", "onStop");
        if (this.f763h0) {
            this.D.performClick();
        }
        if (this.Q0) {
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

    @Override // com.rockcarry.fanplayer.MediaPlayer.Callback
    public final void onWxSdkStreamCbk(byte[] bArr, int i3, boolean z3, int i5, int i6) {
    }

    public final void p(int i3) {
        int v5;
        int i5 = this.f784p0;
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
        int i6 = this.f767j;
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
        if (this.T0) {
            this.f782o0[3] = (byte) v5;
            return;
        }
        this.f780n0[7] = (byte) v5;
    }

    public final void q(int i3, int i5) {
        int v5;
        int i6 = this.f784p0;
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
        a1.i.x("speedValuex=", i3, "MainActivityRTSP");
        int i7 = this.f767j;
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
        int i9 = this.f765i;
        if (i9 < 16) {
            if (i3 >= (16 - i9) * 2) {
                i8 = t2.h.b(16, i9, 2, i3);
            }
        } else if (255 - i3 < (i9 - 16) * 2) {
            i8 = 255;
        } else {
            i8 = a1.i.v(i9, 16, 2, i3);
        }
        a1.i.x("adjustRx=", i8, "MainActivityRTSP");
        if (this.T0) {
            byte b = (byte) v5;
            byte[] bArr = this.f782o0;
            bArr[3] = b;
            bArr[2] = (byte) i8;
            Log.d("MainActivityRTSP", "controlDataOpflow[2]x=" + ((int) bArr[2]));
            A("mRightRocker");
            return;
        }
        byte[] bArr2 = this.f780n0;
        bArr2[7] = (byte) v5;
        bArr2[6] = (byte) i8;
        Log.d("MainActivityRTSP", "controlData[6]x=" + ((int) bArr2[6]));
        A("mRightRocker");
    }

    public final void r(int i3) {
        int v5;
        int i5 = this.f784p0;
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
        a1.i.x("speedValuex=", i3, "MainActivityRTSP");
        int i6 = this.f765i;
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
        a1.i.x("adjustRx=", v5, "MainActivityRTSP");
        if (this.T0) {
            byte[] bArr = this.f782o0;
            bArr[2] = (byte) v5;
            a1.i.u(new StringBuilder("controlDataOpflow[2]x="), bArr[2], "MainActivityRTSP");
            return;
        }
        byte[] bArr2 = this.f780n0;
        bArr2[6] = (byte) v5;
        a1.i.u(new StringBuilder("controlData[6]x="), bArr2[6], "MainActivityRTSP");
    }

    public final void s(int i3) {
        int i5;
        this.f795w0 = i3;
        if (this.T0) {
            p(i3);
        } else if (this.f792u0) {
            if (this.B0 != 1) {
                boolean z3 = this.A0;
                byte[] bArr = this.f780n0;
                if (z3) {
                    bArr[10] = (byte) (bArr[10] | 8);
                    bArr[7] = (byte) this.f799y0;
                    Log.d("右杆y翻滚之后", "y--" + this.f799y0 + " originValue=" + i3);
                } else if (Math.abs(128 - i3) > 64) {
                    if (i3 > 128) {
                        i5 = 255;
                    } else {
                        i5 = 0;
                    }
                    this.A0 = true;
                    bArr[10] = (byte) (bArr[10] | 8);
                    bArr[7] = (byte) i5;
                    this.f799y0 = i5;
                    Log.d("右杆y触发翻滚时", "y--" + this.f799y0 + " originValue=" + i3);
                    this.B0 = 2;
                    this.f761g1.sendEmptyMessageDelayed(0, 600L);
                } else {
                    p(i3);
                }
            }
        } else if (!this.A0) {
            p(i3);
        }
    }

    public final void t(int i3) {
        int i5;
        this.f794v0 = i3;
        if (this.T0) {
            r(i3);
        } else if (this.f792u0) {
            if (this.B0 != 2) {
                boolean z3 = this.A0;
                byte[] bArr = this.f780n0;
                if (z3) {
                    bArr[10] = (byte) (bArr[10] | 8);
                    bArr[6] = (byte) this.f797x0;
                    Log.d("右杆x翻滚之后", "x--" + this.f797x0 + " originValue=" + i3);
                } else if (Math.abs(128 - i3) > 64) {
                    if (i3 > 128) {
                        i5 = 255;
                    } else {
                        i5 = 0;
                    }
                    this.A0 = true;
                    bArr[10] = (byte) (bArr[10] | 8);
                    bArr[6] = (byte) i5;
                    this.f797x0 = i5;
                    Log.d("右杆x触发翻滚时", "x--" + this.f797x0 + " originValue=" + i3);
                    this.B0 = 1;
                    this.f761g1.sendEmptyMessageDelayed(0, 600L);
                } else {
                    r(i3);
                }
            }
        } else if (!this.A0) {
            r(i3);
        }
    }

    public final void u(int i3) {
        if (this.T0) {
            this.f782o0[4] = (byte) i3;
            return;
        }
        byte[] bArr = this.f780n0;
        bArr[8] = (byte) i3;
        a1.i.u(new StringBuilder("data[y]="), bArr[8], "MainActivityRTSP");
    }

    public final void v(int i3) {
        int v5;
        this.f801z0 = i3;
        int i5 = this.f762h;
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
        if (this.T0) {
            byte[] bArr = this.f782o0;
            bArr[5] = (byte) v5;
            StringBuilder sb = new StringBuilder("发送控制油门");
            sb.append((int) bArr[4]);
            sb.append("转向");
            a1.i.u(sb, bArr[5], "MainActivityRTSP");
            return;
        }
        this.f780n0[9] = (byte) v5;
    }

    public final boolean x() {
        if (w(this.f756f.getConnectionInfo().getIpAddress()).contains("172.16.11")) {
            return true;
        }
        return false;
    }

    public final void y(byte[] bArr, int i3, int i5) {
        StringBuilder n5 = a1.i.n("onVideoDecodeData width=", i3, " height=", i5, " bytes.size+");
        n5.append(bArr.length);
        Log.d("MainActivity", n5.toString());
        Log.d("MainActivity", "onVideoDecodeData耗时=" + (System.currentTimeMillis() - this.P0));
        this.P0 = System.currentTimeMillis();
        this.U.update(bArr, i3, i5);
        if (this.f768j0) {
            this.f768j0 = false;
            this.d.takeCapture(bArr, i3, i5, this.Z);
        }
        if (this.f763h0 || this.f760g0) {
            if (i3 == 1280 && i5 == 720) {
                this.U0 = 1920;
                this.V0 = 1080;
                this.P0 = System.currentTimeMillis();
                byte[] bArr2 = new byte[3110400];
                YuvUtil.yuvScaleI420(bArr, i3, i5, bArr2, 1920, 1080, 0);
                Log.d("MainActivity", "yuvScaleI420耗时=" + (System.currentTimeMillis() - this.P0));
                z(bArr2);
                return;
            }
            this.U0 = i3;
            this.V0 = i5;
            z(bArr);
        }
    }

    public final void z(byte[] bArr) {
        if (this.f763h0) {
            this.f753e.a(bArr);
        }
        if (this.f760g0) {
            this.f760g0 = false;
            PictureAndVideoUtil pictureAndVideoUtil = this.d;
            int i3 = this.U0;
            int i5 = this.V0;
            StringBuilder sb = new StringBuilder();
            sb.append(this.b.b);
            String str = File.separator;
            sb.append(str);
            sb.append(this.Y);
            boolean takeCapture = pictureAndVideoUtil.takeCapture(bArr, i3, i5, sb.toString());
            Log.d("MainActivity", "拍照result=" + takeCapture + "photoPath=" + this.b.b + str + this.Y);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.b.b);
            sb2.append(str);
            sb2.append(this.Y);
            j4.b.w(this, false, sb2.toString(), this.Y);
        }
    }
}
