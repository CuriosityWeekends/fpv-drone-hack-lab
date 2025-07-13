package com.lg.picturesubmitt.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.wifi.WifiManager;
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
import c1.b;
import com.bumptech.glide.d;
import com.jaygoo.widget.VerticalRangeSeekBar;
import com.lg.picturesubmitt.MyApplication;
import com.lg.picturesubmitt.PictureAndVideoUtil;
import com.lg.picturesubmitt.TrinityProtocolUtil;
import com.lg.picturesubmitt.activity.FileDirActivity;
import com.lg.picturesubmitt.activity.MusicActivity;
import com.lg.picturesubmitt.activity.TrinityActivity;
import com.lg.picturesubmitt.model.MusicInfo;
import com.lg.picturesubmitt.widget.CustomButton;
import com.lg.picturesubmitt.widget.CustomButtonFun;
import com.lg.picturesubmitt.widget.HTrimView;
import com.lg.picturesubmitt.widget.MyRockerView;
import com.lg.picturesubmitt.widget.TrackControlPaintView;
import com.lg.picturesubmitt.widget.VTrimView;
import com.lg.picturesubmitt.widget.ZoomView;
import com.lg.picturesubmitt.widget.battery.BatteryView;
import com.lxj.xpopup.core.CenterPopupView;
import com.tencent.bugly.proguard.l0;
import com.zhouyou.view.seekbar.SignSeekBar;
import e4.a;
import edu.cmu.pocketsphinx.Hypothesis;
import edu.cmu.pocketsphinx.PocketSphinxJNI;
import j0.s;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p4.m;
import s2.e;
import s2.i;
import s2.j;
import t2.h;
import t2.j0;
import t2.k;
import t2.k0;
import t2.l;
import t2.m0;
import t2.n0;
import t2.r;
import v2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class TrinityActivity extends BaseActivity implements a, s2.a, j, v2.a, c, e {

    /* renamed from: v1  reason: collision with root package name */
    public static final /* synthetic */ int f816v1 = 0;
    public CustomButton A;
    public BatteryView A0;
    public CustomButton B;
    public CheckBox B0;
    public CustomButton C;
    public CheckBox C0;
    public CustomButton D;
    public CheckBox D0;
    public CustomButton E;
    public CustomButton E0;
    public CustomButtonFun F;
    public ImageView F0;
    public TextView G;
    public MusicInfo G0;
    public TextView H;
    public g3.e H0;
    public MyRockerView I;
    public MyRockerView J;
    public boolean J0;
    public MyRockerView K;
    public MyRockerView L;
    public b L0;
    public TrackControlPaintView M;
    public LinearLayout N;
    public ImageView O;
    public int O0;
    public ImageView P;
    public ZoomView Q;
    public RelativeLayout R;
    public VerticalRangeSeekBar S;
    public Bitmap T;
    public i U;
    public Button V0;
    public Button W0;
    public LinearLayout X0;
    public LinearLayout Y0;
    public RadioGroup Z0;

    /* renamed from: a1  reason: collision with root package name */
    public RadioGroup f817a1;

    /* renamed from: b1  reason: collision with root package name */
    public SignSeekBar f819b1;
    public com.google.gson.j d1;

    /* renamed from: e  reason: collision with root package name */
    public WifiManager f823e;

    /* renamed from: f  reason: collision with root package name */
    public VTrimView f826f;

    /* renamed from: f0  reason: collision with root package name */
    public String f827f0;

    /* renamed from: g0  reason: collision with root package name */
    public String f830g0;

    /* renamed from: h0  reason: collision with root package name */
    public ByteArrayOutputStream f833h0;

    /* renamed from: i0  reason: collision with root package name */
    public ArrayList f836i0;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f837j;

    /* renamed from: j0  reason: collision with root package name */
    public ExecutorService f838j0;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f840k;

    /* renamed from: k0  reason: collision with root package name */
    public ExecutorService f841k0;

    /* renamed from: k1  reason: collision with root package name */
    public boolean f842k1;

    /* renamed from: l  reason: collision with root package name */
    public LinearLayout f843l;

    /* renamed from: l0  reason: collision with root package name */
    public ExecutorService f844l0;

    /* renamed from: l1  reason: collision with root package name */
    public byte[] f845l1;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f846m;

    /* renamed from: m1  reason: collision with root package name */
    public final k f848m1;

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f849n;

    /* renamed from: n1  reason: collision with root package name */
    public String f851n1;

    /* renamed from: o  reason: collision with root package name */
    public LinearLayout f852o;

    /* renamed from: o1  reason: collision with root package name */
    public int f854o1;

    /* renamed from: p  reason: collision with root package name */
    public ImageView f855p;

    /* renamed from: p1  reason: collision with root package name */
    public boolean f857p1;
    public Button q;

    /* renamed from: q1  reason: collision with root package name */
    public int f859q1;

    /* renamed from: r  reason: collision with root package name */
    public CustomButton f860r;

    /* renamed from: r1  reason: collision with root package name */
    public int f862r1;
    public CustomButton s;

    /* renamed from: s1  reason: collision with root package name */
    public int f864s1;

    /* renamed from: t  reason: collision with root package name */
    public CustomButton f865t;

    /* renamed from: t1  reason: collision with root package name */
    public final r f867t1;

    /* renamed from: u  reason: collision with root package name */
    public CustomButton f868u;

    /* renamed from: u1  reason: collision with root package name */
    public int f870u1;

    /* renamed from: v  reason: collision with root package name */
    public CustomButton f871v;

    /* renamed from: v0  reason: collision with root package name */
    public int f872v0;
    public CustomButton w;

    /* renamed from: x  reason: collision with root package name */
    public CustomButton f874x;

    /* renamed from: x0  reason: collision with root package name */
    public v3.c f875x0;

    /* renamed from: y  reason: collision with root package name */
    public CustomButton f876y;

    /* renamed from: y0  reason: collision with root package name */
    public f0.b f877y0;

    /* renamed from: z  reason: collision with root package name */
    public CustomButton f878z;

    /* renamed from: z0  reason: collision with root package name */
    public v2.b f879z0;
    public final PictureAndVideoUtil c = PictureAndVideoUtil.getInstance();
    public final TrinityProtocolUtil d = TrinityProtocolUtil.getInstance();

    /* renamed from: g  reason: collision with root package name */
    public int f829g = 16;

    /* renamed from: h  reason: collision with root package name */
    public int f832h = 16;

    /* renamed from: i  reason: collision with root package name */
    public int f835i = 16;
    public int V = 640;
    public int W = 480;
    public final byte[] X = {-1, -40};
    public final byte[] Y = {-1, -39};
    public volatile boolean Z = true;

    /* renamed from: b0  reason: collision with root package name */
    public volatile boolean f818b0 = false;

    /* renamed from: c0  reason: collision with root package name */
    public volatile boolean f820c0 = false;

    /* renamed from: d0  reason: collision with root package name */
    public volatile boolean f822d0 = false;

    /* renamed from: e0  reason: collision with root package name */
    public volatile boolean f824e0 = false;

    /* renamed from: m0  reason: collision with root package name */
    public final byte[] f847m0 = new byte[21];

    /* renamed from: n0  reason: collision with root package name */
    public final byte[] f850n0 = new byte[12];

    /* renamed from: o0  reason: collision with root package name */
    public int f853o0 = 40;

    /* renamed from: p0  reason: collision with root package name */
    public int f856p0 = 0;

    /* renamed from: q0  reason: collision with root package name */
    public boolean f858q0 = false;

    /* renamed from: r0  reason: collision with root package name */
    public boolean f861r0 = false;

    /* renamed from: s0  reason: collision with root package name */
    public boolean f863s0 = false;

    /* renamed from: t0  reason: collision with root package name */
    public int f866t0 = 128;

    /* renamed from: u0  reason: collision with root package name */
    public int f869u0 = 128;

    /* renamed from: w0  reason: collision with root package name */
    public int f873w0 = 0;
    public boolean I0 = false;
    public boolean K0 = false;
    public boolean M0 = false;
    public boolean N0 = false;
    public int P0 = 5780;
    public int Q0 = 2890;
    public int R0 = 1920;
    public int S0 = 1080;
    public boolean T0 = false;
    public boolean U0 = false;

    /* renamed from: c1  reason: collision with root package name */
    public boolean f821c1 = false;

    /* renamed from: e1  reason: collision with root package name */
    public final ExecutorService f825e1 = Executors.newSingleThreadExecutor();

    /* renamed from: f1  reason: collision with root package name */
    public boolean f828f1 = true;

    /* renamed from: g1  reason: collision with root package name */
    public boolean f831g1 = false;

    /* renamed from: h1  reason: collision with root package name */
    public final int f834h1 = 20;
    public final m0 i1 = new m0(this, 1);

    /* renamed from: j1  reason: collision with root package name */
    public final s f839j1 = new s(this, 9);

    public TrinityActivity() {
        new Paint();
        this.f842k1 = false;
        new ByteArrayOutputStream();
        this.f848m1 = new k(4, this);
        this.f854o1 = 0;
        this.f857p1 = false;
        this.f859q1 = 0;
        new TreeMap();
        new HashMap();
        new TreeMap();
        new TreeMap();
        this.f862r1 = 0;
        this.f864s1 = 0;
        this.f867t1 = new r(4, this);
        this.f870u1 = 1;
    }

    public static String q(int i3) {
        return (i3 & 255) + "." + ((i3 >> 8) & 255) + "." + ((i3 >> 16) & 255) + "." + ((i3 >> 24) & 255);
    }

    @Override // v2.a
    public final void a(int i3) {
        if (!r()) {
            t(getResources().getString(2131755085));
            return;
        }
        switch (i3) {
            case 1:
                this.f851n1 = "   低速模式";
                this.f853o0 = 40;
                m(this.f866t0, this.f869u0);
                break;
            case 2:
                this.f851n1 = "中速模式";
                this.f853o0 = 70;
                m(this.f866t0, this.f869u0);
                break;
            case 3:
                this.f851n1 = " 高速模式";
                this.f853o0 = 100;
                m(this.f866t0, this.f869u0);
                break;
            case 4:
                this.f851n1 = "重力感应 on";
                this.J.setGravity(true);
                this.f858q0 = true;
                break;
            case 5:
                this.f851n1 = "重力感应 off";
                this.J.setGravity(false);
                this.f858q0 = false;
                break;
            case 6:
                this.f851n1 = " 校准";
                byte[] bArr = this.f847m0;
                bArr[10] = (byte) (bArr[10] | 128);
                s("矫正");
                this.f839j1.sendEmptyMessageDelayed(5, 1000L);
                break;
            case 7:
                this.f851n1 = "  图片翻转";
                this.Z = !this.Z;
                break;
        }
        t(this.f851n1);
    }

    @Override // s2.j
    public final void b(int i3, String str) {
        runOnUiThread(new l(this, i3, str, 5));
    }

    @Override // e4.a
    public final void d(Hypothesis hypothesis) {
    }

    @Override // s2.e
    public final void e(byte[] bArr, int i3) {
        ExecutorService executorService = this.f825e1;
        if (!executorService.isShutdown()) {
            executorService.execute(new n0(this, bArr, i3, 1));
        }
    }

    @Override // e4.a
    public final void f(Hypothesis hypothesis) {
        if (hypothesis == null) {
            return;
        }
        PocketSphinxJNI.Hypothesis_hypstr_get(hypothesis.f1765a, hypothesis);
        throw null;
    }

    @Override // e4.a
    public final void g() {
        Log.d("TrinityActivity", "onBeginningOfSpeech");
    }

    @Override // v2.c
    public final void h() {
        if (!r()) {
            t(getResources().getString(2131755085));
            return;
        }
        this.f847m0[14] = 1;
        s("btStop");
        this.f839j1.sendEmptyMessageDelayed(4, 1000L);
    }

    @Override // s2.a
    public final void j(byte[] bArr, int i3) {
        if (this.f838j0.isShutdown()) {
            return;
        }
        this.f838j0.execute(new n0(this, bArr, i3, 0));
    }

    @Override // e4.a
    public final void k() {
        throw null;
    }

    public final void l() {
        this.f825e1.shutdown();
        this.f828f1 = false;
        this.f831g1 = true;
        b bVar = this.L0;
        boolean z3 = this.Z;
        SharedPreferences.Editor editor = (SharedPreferences.Editor) bVar.c;
        editor.putBoolean("isRotate", z3);
        editor.commit();
        i iVar = this.U;
        iVar.f3529l = true;
        iVar.d(false);
        this.U.a();
        this.d.closeUDPSocket();
        Log.d("TrinityActivity", " finish()");
        finish();
    }

    public final void m(int i3, int i5) {
        int i6;
        int v5;
        int i7 = this.f853o0;
        if (i7 != 40) {
            if (i7 == 70) {
                if (this.O0 == 2) {
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
                } else {
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
            }
        } else if (this.O0 == 2) {
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
        a1.i.x("speedValuex=", i3, "TrinityActivity");
        int i8 = this.f835i;
        int i9 = 255;
        if (i8 < 16) {
            if (i5 < (16 - i8) * 2) {
                v5 = 0;
            } else {
                v5 = h.b(16, i8, 2, i5);
            }
        } else if (255 - i5 < (i8 - 16) * 2) {
            v5 = 255;
        } else {
            v5 = a1.i.v(i8, 16, 2, i5);
        }
        int i10 = this.f832h;
        if (i10 < 16) {
            if (i3 < (16 - i10) * 2) {
                i9 = 0;
            } else {
                i9 = h.b(16, i10, 2, i3);
            }
        } else if (255 - i3 >= (i10 - 16) * 2) {
            i9 = a1.i.v(i10, 16, 2, i3);
        }
        a1.i.x("adjustRx=", i9, "TrinityActivity");
        byte[] bArr = this.f847m0;
        bArr[1] = (byte) v5;
        bArr[0] = (byte) i9;
        Log.d("TrinityActivity", "controlData[6]x=" + ((int) bArr[6]));
        s("mRightRocker");
    }

    public final void n(int i3) {
        int i5;
        int i6;
        this.f869u0 = i3;
        int i7 = this.f853o0;
        if (i7 != 40) {
            if (i7 == 70) {
                if (this.O0 == 2) {
                    if (i3 > 128) {
                        i5 = ((i3 - 128) * 4) / 5;
                        i3 = i5 + 128;
                    } else {
                        i3 = a1.i.d(128, i3, 4, 5, 128);
                    }
                } else if (i3 > 128) {
                    i3 = a1.i.c(i3, 128, 2, 128);
                } else {
                    i3 = a1.i.y(128, i3, 2, 128);
                }
            }
        } else if (this.O0 == 2) {
            if (i3 > 128) {
                i5 = ((i3 - 128) * 3) / 5;
                i3 = i5 + 128;
            } else {
                i3 = a1.i.d(128, i3, 3, 5, 128);
            }
        } else if (i3 > 128) {
            i3 = a1.i.c(i3, 128, 3, 128);
        } else {
            i3 = a1.i.y(128, i3, 3, 128);
        }
        int i8 = this.f835i;
        if (i8 < 16) {
            int i9 = (16 - i8) * 2;
            if (i3 < i9) {
                i6 = 0;
            } else {
                i6 = i3 - i9;
            }
        } else {
            int i10 = (i8 - 16) * 2;
            if (255 - i3 < i10) {
                i6 = 255;
            } else {
                i6 = i3 + i10;
            }
        }
        this.f847m0[1] = (byte) i6;
    }

    public final void o(int i3) {
        int i5;
        int i6;
        this.f866t0 = i3;
        int i7 = this.f853o0;
        if (i7 != 40) {
            if (i7 == 70) {
                if (this.O0 == 2) {
                    if (i3 > 128) {
                        i5 = ((i3 - 128) * 4) / 5;
                        i3 = i5 + 128;
                    } else {
                        i3 = a1.i.d(128, i3, 4, 5, 128);
                    }
                } else if (i3 > 128) {
                    i3 = a1.i.c(i3, 128, 2, 128);
                } else {
                    i3 = a1.i.y(128, i3, 2, 128);
                }
            }
        } else if (this.O0 == 2) {
            if (i3 > 128) {
                i5 = ((i3 - 128) * 3) / 5;
                i3 = i5 + 128;
            } else {
                i3 = a1.i.d(128, i3, 3, 5, 128);
            }
        } else if (i3 > 128) {
            i3 = a1.i.c(i3, 128, 3, 128);
        } else {
            i3 = a1.i.y(128, i3, 3, 128);
        }
        a1.i.x("speedValuex=", i3, "TrinityActivity");
        int i8 = this.f832h;
        if (i8 < 16) {
            int i9 = (16 - i8) * 2;
            if (i3 < i9) {
                i6 = 0;
            } else {
                i6 = i3 - i9;
            }
        } else {
            int i10 = (i8 - 16) * 2;
            if (255 - i3 < i10) {
                i6 = 255;
            } else {
                i6 = i3 + i10;
            }
        }
        a1.i.x("adjustRx=", i6, "TrinityActivity");
        this.f847m0[0] = (byte) i6;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i3, int i5, Intent intent) {
        super.onActivityResult(i3, i5, intent);
        if (i3 == 1 && i5 == 2) {
            MusicInfo musicInfo = (MusicInfo) intent.getParcelableExtra("MusicInfo");
            this.G0 = musicInfo;
            if (musicInfo != null && !TextUtils.isEmpty(musicInfo.path)) {
                this.F0.setVisibility(0);
                this.E0.setBackground(getDrawable(2131558596));
                Log.d("TrinityActivity", "已选:" + this.G0.toString());
                return;
            }
            this.E0.setBackground(getDrawable(2131558595));
            this.F0.setVisibility(8);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [a1.m, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.f820c0) {
            ?? obj = new Object();
            obj.b = null;
            String string = getString(2131755392);
            String string2 = getString(2131755391);
            String string3 = getString(2131755385);
            String string4 = getString(2131755386);
            k0 k0Var = new k0(this, 1);
            ?? centerPopupView = new CenterPopupView(this);
            centerPopupView.F = false;
            centerPopupView.q = 0;
            centerPopupView.p();
            centerPopupView.f1084x = string;
            centerPopupView.f1085y = string2;
            centerPopupView.f1086z = null;
            centerPopupView.A = string3;
            centerPopupView.B = string4;
            centerPopupView.s = k0Var;
            centerPopupView.F = false;
            centerPopupView.f1034a = obj;
            centerPopupView.o();
            return;
        }
        l();
    }

    /* JADX WARN: Type inference failed for: r0v321, types: [g3.a, java.lang.Object] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d("TrinityActivity", "onCreate");
        setContentView(2131427385);
        this.c.initFFmpeg();
        this.L0 = new b(this, 22);
        Button button = (Button) findViewById(2131230876);
        this.V0 = button;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i3 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i3 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i3));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        this.Y0 = (LinearLayout) findViewById(2131231406);
        Button button2 = (Button) findViewById(2131230862);
        this.W0 = button2;
        button2.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i3 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i3 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i3));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        this.X0 = (LinearLayout) findViewById(2131231110);
        SignSeekBar signSeekBar = (SignSeekBar) findViewById(2131231135);
        this.f819b1 = signSeekBar;
        signSeekBar.setOnProgressChangedListener(new k0(this, 2));
        this.Z0 = (RadioGroup) findViewById(2131231298);
        this.f817a1 = (RadioGroup) findViewById(2131231299);
        RadioButton radioButton = (RadioButton) findViewById(2131231274);
        RadioButton radioButton2 = (RadioButton) findViewById(2131231275);
        RadioButton radioButton3 = (RadioButton) findViewById(2131231276);
        RadioButton radioButton4 = (RadioButton) findViewById(2131231277);
        findViewById(2131230867).setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i3 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i3 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i3));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        findViewById(2131230880).setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i3 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i3 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i3));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        boolean t4 = this.L0.t("isShowOpticalFlowView");
        this.f821c1 = t4;
        int i3 = 0;
        if (t4) {
            this.V0.setVisibility(0);
            this.W0.setVisibility(0);
        } else {
            this.W0.setVisibility(8);
            this.V0.setVisibility(8);
            this.X0.setVisibility(8);
        }
        ((SignSeekBar) findViewById(2131231144)).setOnProgressChangedListener(new k0(this, 3));
        ((SignSeekBar) findViewById(2131231143)).setOnProgressChangedListener(new k0(this, 4));
        ((SignSeekBar) findViewById(2131231142)).setOnProgressChangedListener(new k0(this, 5));
        ((SignSeekBar) findViewById(2131231141)).setOnProgressChangedListener(new k0(this, 6));
        ((SignSeekBar) findViewById(2131231140)).setOnProgressChangedListener(new k0(this, 7));
        ((SignSeekBar) findViewById(2131231139)).setOnProgressChangedListener(new k0(this, 8));
        ((SignSeekBar) findViewById(2131231147)).setOnProgressChangedListener(new k0(this, 9));
        ((SignSeekBar) findViewById(2131231146)).setOnProgressChangedListener(new k0(this, 10));
        ((SignSeekBar) findViewById(2131231145)).setOnProgressChangedListener(new k0(this, 11));
        ((SignSeekBar) findViewById(2131231138)).setOnProgressChangedListener(new k0(this, 12));
        ((SignSeekBar) findViewById(2131231137)).setOnProgressChangedListener(new k0(this, 13));
        ((SignSeekBar) findViewById(2131231136)).setOnProgressChangedListener(new k0(this, 14));
        ((Button) findViewById(2131230863)).setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        this.Z = this.L0.t("isRotate");
        this.J0 = this.L0.t("isRightMode");
        Log.d("TrinityActivity", "isRightMode=" + this.J0);
        this.d1 = new com.google.gson.j();
        h3.b.f().c(this);
        getWindow().addFlags(128);
        this.f823e = (WifiManager) getApplication().getApplicationContext().getSystemService("wifi");
        com.bumptech.glide.e.a(this);
        com.bumptech.glide.e.a(this);
        BatteryView batteryView = (BatteryView) findViewById(2131231125);
        this.A0 = batteryView;
        batteryView.setLevelHeight(50);
        this.A0.setVisibility(8);
        this.f855p = (ImageView) findViewById(2131231288);
        ((TextView) findViewById(2131231305)).setVisibility(8);
        ((TextView) findViewById(2131231096)).setVisibility(8);
        ((TextView) findViewById(2131231462)).setVisibility(8);
        ((TextView) findViewById(2131231475)).setVisibility(8);
        ((TextView) findViewById(2131231463)).setVisibility(8);
        CheckBox checkBox = (CheckBox) findViewById(2131230900);
        this.B0 = checkBox;
        checkBox.setOnCheckedChangeListener(this.f867t1);
        this.F0 = (ImageView) findViewById(2131231085);
        CustomButton customButton = (CustomButton) findViewById(2131230860);
        this.E0 = customButton;
        customButton.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        CheckBox checkBox2 = (CheckBox) findViewById(2131230916);
        this.C0 = checkBox2;
        checkBox2.setOnCheckedChangeListener(this.f867t1);
        ((CheckBox) findViewById(2131230901)).setOnCheckedChangeListener(this.f867t1);
        CheckBox checkBox3 = (CheckBox) findViewById(2131230898);
        this.D0 = checkBox3;
        checkBox3.setOnCheckedChangeListener(this.f867t1);
        this.B0.setChecked(false);
        this.Q = (ZoomView) findViewById(2131231153);
        this.O = (ImageView) findViewById(2131231081);
        this.P = (ImageView) findViewById(2131231082);
        this.R = (RelativeLayout) findViewById(2131231310);
        VerticalRangeSeekBar verticalRangeSeekBar = (VerticalRangeSeekBar) findViewById(2131231521);
        this.S = verticalRangeSeekBar;
        verticalRangeSeekBar.setOnRangeChangedListener(new k0(this, 16));
        getResources().getConfiguration().locale.getCountry().equals("CN");
        this.G = (TextView) findViewById(2131231485);
        this.H = (TextView) findViewById(2131231290);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131231289);
        this.f843l = linearLayout;
        linearLayout.setVisibility(4);
        this.f837j = (LinearLayout) findViewById(2131231130);
        this.f846m = (LinearLayout) findViewById(2131231313);
        this.f849n = (LinearLayout) findViewById(2131231314);
        this.f840k = (LinearLayout) findViewById(2131231209);
        ((CustomButton) findViewById(2131230836)).setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        CustomButton customButton2 = (CustomButton) findViewById(2131230874);
        this.f878z = customButton2;
        customButton2.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        CustomButton customButton3 = (CustomButton) findViewById(2131230875);
        this.f876y = customButton3;
        customButton3.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        CustomButtonFun customButtonFun = (CustomButtonFun) findViewById(2131230848);
        this.F = customButtonFun;
        customButtonFun.setVisibility(4);
        this.F.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        CustomButton customButton4 = (CustomButton) findViewById(2131230881);
        this.f874x = customButton4;
        customButton4.setVisibility(4);
        this.f874x.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        CustomButton customButton5 = (CustomButton) findViewById(2131230852);
        this.f871v = customButton5;
        customButton5.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        CustomButton customButton6 = (CustomButton) findViewById(2131230851);
        this.w = customButton6;
        customButton6.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        CustomButton customButton7 = (CustomButton) findViewById(2131230846);
        ((HTrimView) findViewById(2131231456)).setOnTrimViewInterface(new j0(this, 3));
        ((HTrimView) findViewById(2131231457)).setOnTrimViewInterface(new j0(this, 4));
        VTrimView vTrimView = (VTrimView) findViewById(2131231458);
        this.f826f = vTrimView;
        vTrimView.setOnTrimViewInterface(new j0(this, 2));
        findViewById(2131230839).setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        TrackControlPaintView trackControlPaintView = (TrackControlPaintView) findViewById(2131231149);
        this.M = trackControlPaintView;
        trackControlPaintView.setOnLocaListener(new j0(this, 5));
        this.N = (LinearLayout) findViewById(2131231150);
        this.f852o = (LinearLayout) findViewById(2131231111);
        CustomButton customButton8 = (CustomButton) findViewById(2131230877);
        this.D = customButton8;
        customButton8.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        this.J = (MyRockerView) findViewById(2131231132);
        this.L = (MyRockerView) findViewById(2131231133);
        this.I = (MyRockerView) findViewById(2131231128);
        this.K = (MyRockerView) findViewById(2131231129);
        this.J.setOnLocaListener(new j0(this, 6));
        this.L.setOnLocaListener(new j0(this, 7));
        this.I.setOnLocaListener(new j0(this, 8));
        this.K.setOnLocaListener(new j0(this, 9));
        if (this.J0) {
            this.L.setDG(true);
        } else {
            this.I.setDG(true);
        }
        this.f846m.setVisibility(8);
        this.f849n.setVisibility(8);
        this.f860r = (CustomButton) findViewById(2131230842);
        this.f868u = (CustomButton) findViewById(2131230849);
        this.f865t = (CustomButton) findViewById(2131230869);
        this.q = (Button) findViewById(2131230856);
        CustomButton customButton9 = (CustomButton) findViewById(2131230841);
        this.s = (CustomButton) findViewById(2131230838);
        this.A = (CustomButton) findViewById(2131230868);
        this.B = (CustomButton) findViewById(2131230859);
        this.C = (CustomButton) findViewById(2131230872);
        this.E = (CustomButton) findViewById(2131230879);
        this.f860r.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        this.f868u.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        this.f865t.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        this.q.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        this.f875x0 = new v3.c(this);
        m a5 = d.a(this.s);
        v3.c cVar = this.f875x0;
        cVar.getClass();
        a5.d(new v3.b(cVar, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"})).g(new o4.b(new j0(this, 0)));
        m a6 = d.a(this.A);
        v3.c cVar2 = this.f875x0;
        cVar2.getClass();
        a6.d(new v3.b(cVar2, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"})).g(new o4.b(new j0(this, 1)));
        this.B.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        this.C.setOnClickListener(new View.OnClickListener(this) { // from class: t2.i0
            public final /* synthetic */ TrinityActivity b;

            {
                this.b = this;
            }

            /* JADX WARN: Type inference failed for: r2v1, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v109, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v4, types: [a1.m, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r9v2, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v4, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            /* JADX WARN: Type inference failed for: r9v6, types: [com.lxj.xpopup.impl.ConfirmPopupView, com.lxj.xpopup.core.BasePopupView, com.lxj.xpopup.core.CenterPopupView] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32;
                int i5;
                int i6;
                switch (r2) {
                    case 0:
                        TrinityActivity trinityActivity = this.b;
                        if (trinityActivity.f820c0) {
                            ?? obj = new Object();
                            obj.b = null;
                            String string = trinityActivity.getString(2131755392);
                            String string2 = trinityActivity.getString(2131755391);
                            String string3 = trinityActivity.getString(2131755385);
                            String string4 = trinityActivity.getString(2131755386);
                            k0 k0Var = new k0(trinityActivity, 15);
                            ?? centerPopupView = new CenterPopupView(trinityActivity);
                            centerPopupView.F = false;
                            centerPopupView.q = 0;
                            centerPopupView.p();
                            centerPopupView.f1084x = string;
                            centerPopupView.f1085y = string2;
                            centerPopupView.f1086z = null;
                            centerPopupView.A = string3;
                            centerPopupView.B = string4;
                            centerPopupView.s = k0Var;
                            centerPopupView.F = false;
                            centerPopupView.f1034a = obj;
                            centerPopupView.o();
                            return;
                        }
                        trinityActivity.startActivityForResult(new Intent(trinityActivity, MusicActivity.class), 1);
                        return;
                    case 1:
                        TrinityActivity trinityActivity2 = this.b;
                        if (trinityActivity2.f820c0) {
                            ?? obj2 = new Object();
                            obj2.b = null;
                            String string5 = trinityActivity2.getString(2131755392);
                            String string6 = trinityActivity2.getString(2131755391);
                            String string7 = trinityActivity2.getString(2131755385);
                            String string8 = trinityActivity2.getString(2131755386);
                            k0 k0Var2 = new k0(trinityActivity2, 18);
                            ?? centerPopupView2 = new CenterPopupView(trinityActivity2);
                            centerPopupView2.F = false;
                            centerPopupView2.q = 0;
                            centerPopupView2.p();
                            centerPopupView2.f1084x = string5;
                            centerPopupView2.f1085y = string6;
                            centerPopupView2.f1086z = null;
                            centerPopupView2.A = string7;
                            centerPopupView2.B = string8;
                            centerPopupView2.s = k0Var2;
                            centerPopupView2.F = false;
                            centerPopupView2.f1034a = obj2;
                            centerPopupView2.o();
                            return;
                        }
                        trinityActivity2.startActivity(new Intent(trinityActivity2, FileDirActivity.class));
                        return;
                    case 2:
                        int i7 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity3 = this.b;
                        if (!trinityActivity3.r()) {
                            trinityActivity3.t(trinityActivity3.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity3.f847m0[9] = 1;
                        trinityActivity3.s("矫正");
                        trinityActivity3.f839j1.sendEmptyMessageDelayed(5, 1000L);
                        return;
                    case 3:
                        TrinityActivity trinityActivity4 = this.b;
                        int i8 = TrinityActivity.f816v1;
                        if (!trinityActivity4.r()) {
                            trinityActivity4.t(trinityActivity4.getResources().getString(2131755085));
                            return;
                        } else {
                            trinityActivity4.Z = true ^ trinityActivity4.Z;
                            return;
                        }
                    case 4:
                        TrinityActivity trinityActivity5 = this.b;
                        if (!trinityActivity5.D0.isChecked()) {
                            int i9 = trinityActivity5.f856p0;
                            if (i9 == 0) {
                                trinityActivity5.f856p0 = 1;
                                trinityActivity5.f876y.setVisibility(0);
                                trinityActivity5.f837j.setVisibility(0);
                                if (trinityActivity5.J0) {
                                    trinityActivity5.f849n.setVisibility(0);
                                    trinityActivity5.K.setShow(true);
                                    trinityActivity5.L.setShow(true);
                                } else {
                                    trinityActivity5.f846m.setVisibility(0);
                                    trinityActivity5.I.setShow(true);
                                    trinityActivity5.J.setShow(true);
                                }
                                trinityActivity5.f826f.setVisibility(0);
                                trinityActivity5.f840k.setVisibility(0);
                                trinityActivity5.f874x.setVisibility(0);
                                trinityActivity5.F.setVisibility(0);
                                i32 = 2131558501;
                            } else {
                                if (i9 == 1) {
                                    trinityActivity5.f856p0 = 0;
                                    if (trinityActivity5.f858q0) {
                                        trinityActivity5.f858q0 = false;
                                        if (trinityActivity5.J0) {
                                            trinityActivity5.L.setGravity(false);
                                            trinityActivity5.L.setStopUI(false);
                                            trinityActivity5.K.setStopUI(false);
                                        } else {
                                            trinityActivity5.J.setGravity(false);
                                        }
                                        trinityActivity5.C.setBackground(trinityActivity5.getDrawable(2131558468));
                                    }
                                    trinityActivity5.f876y.setVisibility(8);
                                    trinityActivity5.f837j.setVisibility(8);
                                    if (trinityActivity5.J0) {
                                        trinityActivity5.f849n.setVisibility(8);
                                    } else {
                                        trinityActivity5.f846m.setVisibility(8);
                                    }
                                    trinityActivity5.f826f.setVisibility(4);
                                    trinityActivity5.f840k.setVisibility(4);
                                    trinityActivity5.f874x.setVisibility(4);
                                    trinityActivity5.F.setVisibility(4);
                                    trinityActivity5.f871v.setVisibility(4);
                                    trinityActivity5.w.setVisibility(4);
                                }
                                i32 = 2131558502;
                            }
                            trinityActivity5.q.setBackground(trinityActivity5.getDrawable(i32));
                            return;
                        }
                        return;
                    case 5:
                        TrinityActivity trinityActivity6 = this.b;
                        int i10 = TrinityActivity.f816v1;
                        if (!trinityActivity6.r()) {
                            trinityActivity6.t(trinityActivity6.getResources().getString(2131755085));
                            return;
                        }
                        if (trinityActivity6.f822d0) {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558534));
                        } else {
                            trinityActivity6.B.setBackground(trinityActivity6.getDrawable(2131558533));
                        }
                        trinityActivity6.f822d0 = true ^ trinityActivity6.f822d0;
                        return;
                    case 6:
                        TrinityActivity trinityActivity7 = this.b;
                        if (trinityActivity7.f858q0) {
                            trinityActivity7.f858q0 = false;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(false);
                                trinityActivity7.L.setStopUI(false);
                                trinityActivity7.K.setStopUI(false);
                            } else {
                                trinityActivity7.J.setGravity(false);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558468));
                            return;
                        } else if (!trinityActivity7.D0.isChecked()) {
                            trinityActivity7.f858q0 = true;
                            if (trinityActivity7.J0) {
                                trinityActivity7.L.setGravity(true);
                                trinityActivity7.L.setStopUI(true);
                                trinityActivity7.K.setStopUI(true);
                            } else {
                                trinityActivity7.J.setGravity(true);
                            }
                            trinityActivity7.C.setBackground(trinityActivity7.getDrawable(2131558469));
                            return;
                        } else {
                            trinityActivity7.t(trinityActivity7.getString(2131755359));
                            return;
                        }
                    case 7:
                        int i11 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity8 = this.b;
                        if (!trinityActivity8.r()) {
                            trinityActivity8.t(trinityActivity8.getResources().getString(2131755085));
                            return;
                        }
                        int i12 = trinityActivity8.f853o0;
                        if (i12 == 40) {
                            trinityActivity8.f853o0 = 70;
                            i5 = 2131558456;
                        } else if (i12 == 70) {
                            trinityActivity8.f853o0 = 100;
                            i5 = 2131558454;
                        } else {
                            if (i12 == 100) {
                                trinityActivity8.f853o0 = 40;
                            }
                            i5 = 2131558455;
                        }
                        trinityActivity8.f878z.setBackground(trinityActivity8.getDrawable(i5));
                        trinityActivity8.m(trinityActivity8.f866t0, trinityActivity8.f869u0);
                        return;
                    case 8:
                        this.b.f877y0.a();
                        return;
                    case 9:
                        int i13 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity9 = this.b;
                        if (!trinityActivity9.r()) {
                            trinityActivity9.t(trinityActivity9.getResources().getString(2131755085));
                            return;
                        }
                        boolean z3 = trinityActivity9.f863s0;
                        byte[] bArr = trinityActivity9.f847m0;
                        if (z3) {
                            bArr[8] = 0;
                            trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558506));
                            trinityActivity9.f863s0 = false;
                            trinityActivity9.s("isFanGun--false");
                            return;
                        }
                        bArr[8] = 1;
                        trinityActivity9.F.setBackground(trinityActivity9.getResources().getDrawable(2131558505));
                        trinityActivity9.f863s0 = true;
                        return;
                    case 10:
                        int i14 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity10 = this.b;
                        if (!trinityActivity10.r()) {
                            trinityActivity10.t(trinityActivity10.getResources().getString(2131755085));
                            return;
                        }
                        boolean z5 = trinityActivity10.f861r0;
                        byte[] bArr2 = trinityActivity10.f847m0;
                        if (z5) {
                            bArr2[7] = 0;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558496));
                        } else {
                            bArr2[7] = 1;
                            trinityActivity10.f874x.setBackground(trinityActivity10.getDrawable(2131558495));
                        }
                        trinityActivity10.f861r0 = true ^ trinityActivity10.f861r0;
                        trinityActivity10.s("btWuTou");
                        return;
                    case 11:
                        int i15 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity11 = this.b;
                        if (!trinityActivity11.r()) {
                            trinityActivity11.t(trinityActivity11.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity11.f847m0[11] = 1;
                        trinityActivity11.s("btFlyUp");
                        trinityActivity11.f839j1.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 12:
                        int i16 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity12 = this.b;
                        if (!trinityActivity12.r()) {
                            trinityActivity12.t(trinityActivity12.getResources().getString(2131755085));
                            return;
                        }
                        trinityActivity12.f847m0[12] = 1;
                        trinityActivity12.s("btFlyDown");
                        trinityActivity12.f839j1.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 13:
                        TrinityActivity trinityActivity13 = this.b;
                        if (trinityActivity13.X0.getVisibility() == 8) {
                            trinityActivity13.X0.setVisibility(0);
                            trinityActivity13.V0.setText("光流属性隐藏");
                            return;
                        }
                        trinityActivity13.X0.setVisibility(8);
                        trinityActivity13.V0.setText("光流属性显示");
                        return;
                    case 14:
                        TrinityActivity trinityActivity14 = this.b;
                        if (trinityActivity14.Y0.getVisibility() == 8) {
                            trinityActivity14.Y0.setVisibility(0);
                            trinityActivity14.W0.setText("PID隐藏");
                            return;
                        }
                        trinityActivity14.Y0.setVisibility(8);
                        trinityActivity14.W0.setText("PID显示");
                        return;
                    case 15:
                        this.b.d.sendOpticalFlowDataCMD(false, new byte[]{-52, 90, 1, -121, 1, (byte) 135});
                        return;
                    case 16:
                        TrinityActivity trinityActivity15 = this.b;
                        int i17 = -1;
                        if (trinityActivity15.Z0.getCheckedRadioButtonId() == 2131231274) {
                            i6 = -1;
                        } else {
                            i6 = 1;
                        }
                        if (trinityActivity15.f817a1.getCheckedRadioButtonId() != 2131231276) {
                            i17 = 1;
                        }
                        a1.i.u(a1.i.n("dir_x=", i6, " dir_y=", i17, " sensitive="), trinityActivity15.f870u1, "TrinityActivity");
                        byte b = (byte) i6;
                        byte b5 = (byte) i17;
                        byte b6 = (byte) trinityActivity15.f870u1;
                        trinityActivity15.d.sendOpticalFlowDataCMD(true, new byte[]{-52, 90, 1, -122, 4, b, b5, b6, (byte) (((((-125) ^ b) ^ b5) ^ b6) & 255)});
                        return;
                    case 17:
                        TrinityActivity trinityActivity16 = this.b;
                        if (trinityActivity16.f820c0) {
                            trinityActivity16.t(trinityActivity16.getString(2131755348));
                            return;
                        } else if (trinityActivity16.K0) {
                            trinityActivity16.U.e();
                            return;
                        } else {
                            return;
                        }
                    case 18:
                        int i18 = TrinityActivity.f816v1;
                        TrinityActivity trinityActivity17 = this.b;
                        trinityActivity17.getClass();
                        new Thread(new m0(trinityActivity17, 2)).start();
                        return;
                    case 19:
                        TrinityActivity trinityActivity18 = this.b;
                        int ordinal = trinityActivity18.M.getTrackControlGrade().ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal != 2) {
                                    if (ordinal != 3) {
                                        if (ordinal == 4) {
                                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558631));
                                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE1);
                                            return;
                                        }
                                        return;
                                    }
                                    trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558635));
                                    trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE5);
                                    return;
                                }
                                trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558634));
                                trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE4);
                                return;
                            }
                            trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558633));
                            trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE3);
                            return;
                        }
                        trinityActivity18.D.setBackground(trinityActivity18.getDrawable(2131558632));
                        trinityActivity18.M.setTrackControlGrade(x2.l.CONTROL_RANGE_GRADE2);
                        return;
                    default:
                        TrinityActivity trinityActivity19 = this.b;
                        if (trinityActivity19.f820c0) {
                            ?? obj3 = new Object();
                            obj3.b = null;
                            String string9 = trinityActivity19.getString(2131755392);
                            String string10 = trinityActivity19.getString(2131755391);
                            String string11 = trinityActivity19.getString(2131755385);
                            String string12 = trinityActivity19.getString(2131755386);
                            k0 k0Var3 = new k0(trinityActivity19, 17);
                            ?? centerPopupView3 = new CenterPopupView(trinityActivity19);
                            centerPopupView3.F = false;
                            centerPopupView3.q = 0;
                            centerPopupView3.p();
                            centerPopupView3.f1084x = string9;
                            centerPopupView3.f1085y = string10;
                            centerPopupView3.f1086z = null;
                            centerPopupView3.A = string11;
                            centerPopupView3.B = string12;
                            centerPopupView3.s = k0Var3;
                            centerPopupView3.F = false;
                            centerPopupView3.f1034a = obj3;
                            centerPopupView3.o();
                            return;
                        }
                        trinityActivity19.l();
                        return;
                }
            }
        });
        this.f833h0 = new ByteArrayOutputStream();
        this.f836i0 = new ArrayList();
        this.f838j0 = Executors.newSingleThreadExecutor();
        this.f844l0 = Executors.newSingleThreadExecutor();
        this.f841k0 = Executors.newFixedThreadPool(5);
        byte[] bArr = this.f847m0;
        bArr[0] = Byte.MIN_VALUE;
        bArr[1] = Byte.MIN_VALUE;
        bArr[2] = Byte.MIN_VALUE;
        bArr[3] = Byte.MIN_VALUE;
        bArr[4] = 32;
        bArr[5] = 32;
        bArr[6] = 0;
        bArr[7] = 0;
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
        bArr[18] = 0;
        bArr[19] = 0;
        bArr[20] = 0;
        while (true) {
            byte[] bArr2 = this.f850n0;
            if (i3 >= bArr2.length) {
                break;
            }
            bArr2[i3] = 1;
            i3++;
        }
        i iVar = new i(this, this, this, this);
        this.U = iVar;
        iVar.d(true);
        this.U.c();
        Log.d("TrinityActivity", "设备初始化默认已连接");
        this.d.initUDPSocket(MyApplication.f542i);
        new l0(4, this).start();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        registerReceiver(this.f848m1, intentFilter);
        this.f876y.setVisibility(8);
        this.f837j.setVisibility(8);
        this.f826f.setVisibility(4);
        this.f840k.setVisibility(4);
        if (this.f879z0 == null) {
            v2.b bVar = new v2.b(this);
            this.f879z0 = bVar;
            bVar.d = this;
        }
        this.f877y0 = new f0.b(this);
        f0.b bVar2 = new f0.b(this);
        this.f877y0 = bVar2;
        bVar2.c = this;
        if (!MyApplication.f541h) {
            g3.b.a(getApplicationContext(), new Object());
        }
        this.H0 = new g3.e(this, new k0(this, 0));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f848m1);
        this.f838j0.shutdown();
        this.f841k0.shutdown();
        this.f844l0.shutdown();
        Log.d("TrinityActivity", " onDestroy()");
    }

    @Override // e4.a
    public final void onError(Exception exc) {
        Log.i("TrinityActivity", " onError getMessage=" + exc.getMessage());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.J0) {
            this.L.c();
        } else {
            this.J.c();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        Log.d("TrinityActivity", "onStop");
        if (this.f820c0) {
            this.A.performClick();
        }
        if (this.J0) {
            this.L.e();
        } else {
            this.J.e();
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
        this.f872v0 = i3;
        int i5 = this.f829g;
        if (i5 < 16) {
            if (i3 < (16 - i5) * 2) {
                v5 = 0;
            } else {
                v5 = h.b(16, i5, 2, i3);
            }
        } else if (255 - i3 < (i5 - 16) * 2) {
            v5 = 255;
        } else {
            v5 = a1.i.v(i5, 16, 2, i3);
        }
        this.f847m0[3] = (byte) v5;
    }

    public final boolean r() {
        if (q(this.f823e.getConnectionInfo().getIpAddress()).contains("192.168.27")) {
            return true;
        }
        return false;
    }

    public final void s(String str) {
        Log.d("TrinityActivity谁发送", str);
    }

    public final void t(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }
}
