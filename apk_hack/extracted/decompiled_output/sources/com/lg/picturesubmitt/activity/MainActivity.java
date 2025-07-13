package com.lg.picturesubmitt.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import b3.d;
import com.lg.picturesubmitt.activity.FileDirActivity;
import com.lg.picturesubmitt.activity.MainActivity;
import com.lg.picturesubmitt.widget.CustomButton;
import com.lg.picturesubmitt.widget.CustomButtonFun;
import com.lg.picturesubmitt.widget.HTrimView;
import com.lg.picturesubmitt.widget.MyRockerView;
import com.lg.picturesubmitt.widget.VTrimView;
import com.lg.picturesubmitt.widget.battery.BatteryView;
import f0.b;
import j0.s;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p4.m;
import s2.a;
import s2.e;
import s2.h;
import s2.i;
import s2.j;
import t2.g;
import t2.k;
import t2.l;
import v2.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class MainActivity extends BaseActivity implements a, j, v2.a, c, e {
    public static final /* synthetic */ int J0 = 0;
    public CustomButton A;
    public BatteryView A0;
    public CustomButton B;
    public CustomButton C;
    public Button D;
    public Canvas D0;
    public CustomButtonFun E;
    public TextView F;
    public MyRockerView G;
    public MyRockerView H;
    public String H0;
    public SurfaceView I;
    public int I0;
    public Bitmap J;
    public Bitmap K;
    public i L;
    public h M;
    public int N;
    public int O;
    public SurfaceHolder R;

    /* renamed from: b0  reason: collision with root package name */
    public String f566b0;

    /* renamed from: c0  reason: collision with root package name */
    public ByteArrayOutputStream f567c0;

    /* renamed from: d0  reason: collision with root package name */
    public ExecutorService f568d0;

    /* renamed from: e  reason: collision with root package name */
    public WifiManager f569e;

    /* renamed from: e0  reason: collision with root package name */
    public ExecutorService f570e0;

    /* renamed from: f  reason: collision with root package name */
    public VTrimView f571f;

    /* renamed from: f0  reason: collision with root package name */
    public ExecutorService f572f0;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f579j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f581k;

    /* renamed from: l  reason: collision with root package name */
    public LinearLayout f583l;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f585m;

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f587n;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f589o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f591p;
    public TextView q;

    /* renamed from: q0  reason: collision with root package name */
    public int f593q0;

    /* renamed from: r  reason: collision with root package name */
    public TextView f594r;

    /* renamed from: r0  reason: collision with root package name */
    public int f595r0;
    public CustomButton s;

    /* renamed from: s0  reason: collision with root package name */
    public int f596s0;

    /* renamed from: t  reason: collision with root package name */
    public CustomButton f597t;

    /* renamed from: u  reason: collision with root package name */
    public CustomButton f599u;

    /* renamed from: v  reason: collision with root package name */
    public CustomButton f601v;

    /* renamed from: v0  reason: collision with root package name */
    public v3.c f602v0;
    public CustomButton w;

    /* renamed from: w0  reason: collision with root package name */
    public b f603w0;

    /* renamed from: x  reason: collision with root package name */
    public CustomButton f604x;

    /* renamed from: x0  reason: collision with root package name */
    public v2.b f605x0;

    /* renamed from: y  reason: collision with root package name */
    public CustomButton f606y;

    /* renamed from: z  reason: collision with root package name */
    public CustomButton f608z;
    public boolean c = false;
    public int d = 1;

    /* renamed from: g  reason: collision with root package name */
    public int f573g = 16;

    /* renamed from: h  reason: collision with root package name */
    public int f575h = 16;

    /* renamed from: i  reason: collision with root package name */
    public int f577i = 16;
    public final byte[] P = {-1, -40};
    public final byte[] Q = {-1, -39};
    public boolean S = false;
    public boolean T = false;
    public boolean U = false;
    public boolean V = false;
    public boolean W = false;
    public boolean X = false;
    public boolean Y = false;
    public boolean Z = false;

    /* renamed from: g0  reason: collision with root package name */
    public final byte[] f574g0 = new byte[8];

    /* renamed from: h0  reason: collision with root package name */
    public int f576h0 = 40;

    /* renamed from: i0  reason: collision with root package name */
    public int f578i0 = 0;

    /* renamed from: j0  reason: collision with root package name */
    public boolean f580j0 = false;

    /* renamed from: k0  reason: collision with root package name */
    public boolean f582k0 = false;

    /* renamed from: l0  reason: collision with root package name */
    public boolean f584l0 = false;

    /* renamed from: m0  reason: collision with root package name */
    public boolean f586m0 = false;

    /* renamed from: n0  reason: collision with root package name */
    public boolean f588n0 = false;

    /* renamed from: o0  reason: collision with root package name */
    public int f590o0 = 128;

    /* renamed from: p0  reason: collision with root package name */
    public int f592p0 = 128;

    /* renamed from: t0  reason: collision with root package name */
    public boolean f598t0 = false;

    /* renamed from: u0  reason: collision with root package name */
    public int f600u0 = 0;

    /* renamed from: y0  reason: collision with root package name */
    public boolean f607y0 = false;

    /* renamed from: z0  reason: collision with root package name */
    public boolean f609z0 = false;
    public final d B0 = new d(13, this);
    public final s C0 = new s(this, 5);
    public final Paint E0 = new Paint();
    public boolean F0 = false;
    public final k G0 = new k(0, this);

    public static Bitmap l(MainActivity mainActivity, Bitmap bitmap) {
        mainActivity.getClass();
        if (bitmap == null) {
            return null;
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        Matrix matrix = new Matrix();
        matrix.postScale(960 / width, 720 / height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
            return createBitmap;
        }
        return createBitmap;
    }

    @Override // v2.a
    public final void a(int i3) {
        switch (i3) {
            case 1:
                this.H0 = "   低速模式";
                this.f576h0 = 40;
                n(this.f590o0, this.f592p0);
                break;
            case 2:
                this.H0 = "中速模式";
                this.f576h0 = 70;
                n(this.f590o0, this.f592p0);
                break;
            case 3:
                this.H0 = " 高速模式";
                this.f576h0 = 100;
                n(this.f590o0, this.f592p0);
                break;
            case 4:
                this.H0 = "重力感应 on";
                this.H.setGravity(true);
                this.f582k0 = true;
                break;
            case 5:
                this.H0 = "重力感应 off";
                this.H.setGravity(false);
                this.f582k0 = false;
                break;
            case 6:
                this.H0 = " 校准";
                byte[] bArr = this.f574g0;
                bArr[5] = (byte) (bArr[5] | 128);
                p("矫正");
                this.C0.sendEmptyMessageDelayed(5, 1000L);
                break;
            case 7:
                this.H0 = "  图片翻转";
                this.S = !this.S;
                break;
        }
        q(this.H0);
    }

    @Override // s2.j
    public final void b(int i3, String str) {
        runOnUiThread(new l(this, i3, str, 0));
    }

    @Override // s2.e
    public final void e(byte[] bArr, int i3) {
        StringBuilder sb = new StringBuilder("data[0]-->");
        sb.append((int) bArr[0]);
        sb.append("data[1]-->");
        sb.append((int) bArr[1]);
        sb.append("data[2]-->");
        sb.append((int) bArr[2]);
        sb.append("data[3]-->");
        sb.append((int) bArr[3]);
        sb.append("data[7]-->");
        a1.i.u(sb, bArr[7], "MainActivity");
        byte b = bArr[0];
        if (b == 102 && bArr[7] == -103) {
            if ((bArr[3] & 4) == 4) {
                this.f580j0 = true;
                Log.d("MainActivity", "禁止翻滚--");
            } else {
                this.f580j0 = false;
                Log.d("MainActivity", "允许翻滚");
            }
            runOnUiThread(new t2.i(this, bArr, 1));
        } else if (b == -86 && bArr[1] == 2 && bArr[7] == -69) {
            this.M.c(true);
            this.C0.sendEmptyMessage(7);
        }
    }

    @Override // v2.c
    public final void h() {
        int i3 = this.d;
        byte[] bArr = this.f574g0;
        if (i3 != 1) {
            if (i3 == 2) {
                bArr[5] = (byte) (bArr[5] | 8);
            }
        } else {
            bArr[5] = (byte) (bArr[5] | 4);
        }
        p("btStop");
        this.C0.sendEmptyMessageDelayed(4, 1000L);
    }

    @Override // s2.a
    public final void j(byte[] bArr, int i3) {
        this.d = bArr[3];
        this.C0.sendEmptyMessage(1);
        if (this.U) {
            return;
        }
        this.f568d0.execute(new t2.i(this, bArr, 0));
    }

    public final int m(byte[] bArr) {
        if (bArr.length != 2) {
            return 0;
        }
        return (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    public final void n(int i3, int i5) {
        int v5;
        int i6 = this.f576h0;
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
        a1.i.x("speedValuex=", i3, "MainActivity");
        int i7 = this.f577i;
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
        int i9 = this.f575h;
        if (i9 < 16) {
            if (i3 >= (16 - i9) * 2) {
                i8 = t2.h.b(16, i9, 2, i3);
            }
        } else if (255 - i3 < (i9 - 16) * 2) {
            i8 = 255;
        } else {
            i8 = a1.i.v(i9, 16, 2, i3);
        }
        a1.i.x("adjustRx=", i8, "MainActivity");
        byte b = (byte) v5;
        byte[] bArr = this.f574g0;
        bArr[2] = b;
        bArr[1] = (byte) i8;
        Log.d("MainActivity", " controlData[1]x=" + ((int) bArr[1]));
        p("mRightRocker");
    }

    public final void o() {
        this.f583l.setVisibility(4);
        this.F.setText("00:00");
        this.C0.removeCallbacks(this.B0);
        this.f600u0 = 0;
    }

    /* JADX WARN: Type inference failed for: r1v136, types: [java.lang.Object, s2.i] */
    /* JADX WARN: Type inference failed for: r1v141, types: [java.lang.Object, s2.h] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131427388);
        this.c = true;
        h3.b.f().c(this);
        getWindow().addFlags(128);
        this.f569e = (WifiManager) getApplication().getApplicationContext().getSystemService("wifi");
        this.O = com.bumptech.glide.e.a(this).heightPixels;
        this.N = com.bumptech.glide.e.a(this).widthPixels;
        BatteryView batteryView = (BatteryView) findViewById(2131231125);
        this.A0 = batteryView;
        batteryView.setLevelHeight(50);
        this.A0.setVisibility(8);
        this.f589o = (ImageView) findViewById(2131231288);
        ((TextView) findViewById(2131231305)).setVisibility(8);
        ((TextView) findViewById(2131231096)).setVisibility(8);
        TextView textView = (TextView) findViewById(2131231462);
        this.f591p = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) findViewById(2131231475);
        this.q = textView2;
        textView2.setVisibility(8);
        TextView textView3 = (TextView) findViewById(2131231463);
        this.f594r = textView3;
        textView3.setVisibility(8);
        this.F = (TextView) findViewById(2131231290);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131231289);
        this.f583l = linearLayout;
        linearLayout.setVisibility(4);
        this.f579j = (LinearLayout) findViewById(2131231130);
        this.f587n = (LinearLayout) findViewById(2131231443);
        this.f585m = (LinearLayout) findViewById(2131231313);
        this.f581k = (LinearLayout) findViewById(2131231209);
        CustomButton customButton = (CustomButton) findViewById(2131230875);
        this.f608z = customButton;
        customButton.setOnClickListener(new View.OnClickListener(this) { // from class: t2.f
            public final /* synthetic */ MainActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                long blockSize;
                MainActivity mainActivity = this.b;
                switch (r2) {
                    case 0:
                        if (mainActivity.f580j0) {
                            mainActivity.q("电量低于60%，无法翻滚");
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            return;
                        }
                        int i5 = mainActivity.d;
                        byte[] bArr = mainActivity.f574g0;
                        if (i5 != 1) {
                            if (i5 == 2) {
                                if (mainActivity.f588n0) {
                                    byte b = (byte) (bArr[5] & (-2));
                                    bArr[5] = b;
                                    bArr[5] = (byte) (b & (-65));
                                    mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                                    mainActivity.f588n0 = false;
                                    mainActivity.p("isFanGun--false");
                                    return;
                                }
                                byte b5 = (byte) (bArr[5] | 1);
                                bArr[5] = b5;
                                bArr[5] = (byte) (b5 | 64);
                                mainActivity.f588n0 = true;
                                mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                                mainActivity.p("isFanGun--true");
                                return;
                            }
                            return;
                        } else if (mainActivity.f588n0) {
                            bArr[5] = (byte) (bArr[5] & (-9));
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            mainActivity.f588n0 = false;
                            mainActivity.p("isFanGun--false");
                            return;
                        } else {
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                            mainActivity.f588n0 = true;
                            mainActivity.f598t0 = false;
                            return;
                        }
                    case 1:
                        int i6 = mainActivity.d;
                        byte[] bArr2 = mainActivity.f574g0;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                if (mainActivity.f586m0) {
                                    bArr2[5] = (byte) (bArr2[5] & (-33));
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                                } else {
                                    bArr2[5] = (byte) (bArr2[5] | 32);
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                                }
                            }
                        } else if (mainActivity.f586m0) {
                            bArr2[5] = (byte) (bArr2[5] & (-17));
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                        } else {
                            bArr2[5] = (byte) (bArr2[5] | 16);
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                        }
                        mainActivity.f586m0 = !mainActivity.f586m0;
                        mainActivity.p("btWuTou");
                        return;
                    case 2:
                        int i7 = mainActivity.d;
                        byte[] bArr3 = mainActivity.f574g0;
                        if (i7 != 1) {
                            if (i7 == 2) {
                                bArr3[5] = (byte) (bArr3[5] | 2);
                            }
                        } else {
                            bArr3[5] = (byte) (bArr3[5] | 1);
                        }
                        mainActivity.p("btFlyUp");
                        mainActivity.C0.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 3:
                        int i8 = mainActivity.d;
                        byte[] bArr4 = mainActivity.f574g0;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                bArr4[5] = (byte) (bArr4[5] | 4);
                            }
                        } else {
                            bArr4[5] = (byte) (bArr4[5] | 2);
                        }
                        mainActivity.p("btFlyDown");
                        mainActivity.C0.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 4:
                        boolean z3 = mainActivity.f584l0;
                        byte[] bArr5 = mainActivity.f574g0;
                        if (z3) {
                            bArr5[5] = (byte) (bArr5[5] & (-65));
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558507));
                            mainActivity.w.setVisibility(8);
                            mainActivity.f604x.setVisibility(8);
                            mainActivity.G.setDG(false);
                        } else {
                            bArr5[5] = (byte) (bArr5[5] | 64);
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558508));
                            mainActivity.w.setVisibility(0);
                            mainActivity.f604x.setVisibility(0);
                            mainActivity.G.setDG(true);
                        }
                        mainActivity.f584l0 = !mainActivity.f584l0;
                        mainActivity.p("btDingGao");
                        return;
                    case 5:
                        mainActivity.f603w0.a();
                        return;
                    case 6:
                        s2.i iVar = mainActivity.L;
                        iVar.f3529l = true;
                        iVar.d(false);
                        mainActivity.M.a();
                        Log.d("MainActivity", " finish()");
                        mainActivity.finish();
                        return;
                    case 7:
                        int i9 = MainActivity.J0;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity, FileDirActivity.class));
                        return;
                    case 8:
                        int i10 = mainActivity.f578i0;
                        if (i10 == 0) {
                            mainActivity.f578i0 = 2;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(false);
                            MyRockerView myRockerView = mainActivity.H;
                            if (!myRockerView.s) {
                                myRockerView.setShow(false);
                            }
                            mainActivity.p("改变值");
                            mainActivity.M.c(false);
                            int i11 = mainActivity.d;
                            if (i11 != 1) {
                                if (i11 != 2) {
                                    i3 = 2131558498;
                                } else {
                                    throw null;
                                }
                            } else {
                                mainActivity.f601v.setVisibility(0);
                                throw null;
                            }
                        } else if (i10 == 2) {
                            mainActivity.f578i0 = 3;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(0);
                            mainActivity.f581k.setVisibility(0);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(true);
                            mainActivity.H.setShow(true);
                            mainActivity.M.c(false);
                            int i12 = mainActivity.d;
                            if (i12 != 1) {
                                if (i12 != 2) {
                                    i3 = 2131558499;
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else if (i10 == 3) {
                            mainActivity.f578i0 = 0;
                            if (mainActivity.f582k0) {
                                mainActivity.f582k0 = false;
                                mainActivity.H.setGravity(false);
                                mainActivity.C.setBackground(mainActivity.getDrawable(2131558468));
                            }
                            mainActivity.f608z.setVisibility(8);
                            mainActivity.f579j.setVisibility(8);
                            mainActivity.f585m.setVisibility(4);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(4);
                            throw null;
                        } else {
                            i3 = 2131558497;
                        }
                        mainActivity.D.setBackground(mainActivity.getDrawable(i3));
                        return;
                    case 9:
                        if (mainActivity.W) {
                            mainActivity.o();
                            mainActivity.W = false;
                            mainActivity.X = false;
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558525));
                            return;
                        }
                        if (!Environment.getExternalStorageState().equals("mounted")) {
                            blockSize = 0;
                        } else {
                            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                            statFs.getBlockCount();
                            long availableBlocks = statFs.getAvailableBlocks();
                            statFs.getFreeBlocks();
                            blockSize = ((availableBlocks * statFs.getBlockSize()) / 1024) / 1024;
                        }
                        if (blockSize > 100) {
                            mainActivity.f583l.setVisibility(0);
                            mainActivity.F.setText("00:00");
                            mainActivity.C0.postDelayed(mainActivity.B0, 500L);
                            mainActivity.W = true;
                            mainActivity.X = true;
                            mainActivity.Z = true;
                            mainActivity.f566b0 = System.currentTimeMillis() + ".mp4";
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558526));
                            return;
                        }
                        Toast.makeText(mainActivity, mainActivity.getString(2131755349), 1).show();
                        return;
                    default:
                        if (mainActivity.Y) {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558531));
                        } else {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558532));
                        }
                        mainActivity.Y = !mainActivity.Y;
                        return;
                }
            }
        });
        CustomButtonFun customButtonFun = (CustomButtonFun) findViewById(2131230848);
        this.E = customButtonFun;
        customButtonFun.setVisibility(4);
        this.E.setOnClickListener(new View.OnClickListener(this) { // from class: t2.f
            public final /* synthetic */ MainActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                long blockSize;
                MainActivity mainActivity = this.b;
                switch (r2) {
                    case 0:
                        if (mainActivity.f580j0) {
                            mainActivity.q("电量低于60%，无法翻滚");
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            return;
                        }
                        int i5 = mainActivity.d;
                        byte[] bArr = mainActivity.f574g0;
                        if (i5 != 1) {
                            if (i5 == 2) {
                                if (mainActivity.f588n0) {
                                    byte b = (byte) (bArr[5] & (-2));
                                    bArr[5] = b;
                                    bArr[5] = (byte) (b & (-65));
                                    mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                                    mainActivity.f588n0 = false;
                                    mainActivity.p("isFanGun--false");
                                    return;
                                }
                                byte b5 = (byte) (bArr[5] | 1);
                                bArr[5] = b5;
                                bArr[5] = (byte) (b5 | 64);
                                mainActivity.f588n0 = true;
                                mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                                mainActivity.p("isFanGun--true");
                                return;
                            }
                            return;
                        } else if (mainActivity.f588n0) {
                            bArr[5] = (byte) (bArr[5] & (-9));
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            mainActivity.f588n0 = false;
                            mainActivity.p("isFanGun--false");
                            return;
                        } else {
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                            mainActivity.f588n0 = true;
                            mainActivity.f598t0 = false;
                            return;
                        }
                    case 1:
                        int i6 = mainActivity.d;
                        byte[] bArr2 = mainActivity.f574g0;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                if (mainActivity.f586m0) {
                                    bArr2[5] = (byte) (bArr2[5] & (-33));
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                                } else {
                                    bArr2[5] = (byte) (bArr2[5] | 32);
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                                }
                            }
                        } else if (mainActivity.f586m0) {
                            bArr2[5] = (byte) (bArr2[5] & (-17));
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                        } else {
                            bArr2[5] = (byte) (bArr2[5] | 16);
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                        }
                        mainActivity.f586m0 = !mainActivity.f586m0;
                        mainActivity.p("btWuTou");
                        return;
                    case 2:
                        int i7 = mainActivity.d;
                        byte[] bArr3 = mainActivity.f574g0;
                        if (i7 != 1) {
                            if (i7 == 2) {
                                bArr3[5] = (byte) (bArr3[5] | 2);
                            }
                        } else {
                            bArr3[5] = (byte) (bArr3[5] | 1);
                        }
                        mainActivity.p("btFlyUp");
                        mainActivity.C0.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 3:
                        int i8 = mainActivity.d;
                        byte[] bArr4 = mainActivity.f574g0;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                bArr4[5] = (byte) (bArr4[5] | 4);
                            }
                        } else {
                            bArr4[5] = (byte) (bArr4[5] | 2);
                        }
                        mainActivity.p("btFlyDown");
                        mainActivity.C0.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 4:
                        boolean z3 = mainActivity.f584l0;
                        byte[] bArr5 = mainActivity.f574g0;
                        if (z3) {
                            bArr5[5] = (byte) (bArr5[5] & (-65));
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558507));
                            mainActivity.w.setVisibility(8);
                            mainActivity.f604x.setVisibility(8);
                            mainActivity.G.setDG(false);
                        } else {
                            bArr5[5] = (byte) (bArr5[5] | 64);
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558508));
                            mainActivity.w.setVisibility(0);
                            mainActivity.f604x.setVisibility(0);
                            mainActivity.G.setDG(true);
                        }
                        mainActivity.f584l0 = !mainActivity.f584l0;
                        mainActivity.p("btDingGao");
                        return;
                    case 5:
                        mainActivity.f603w0.a();
                        return;
                    case 6:
                        s2.i iVar = mainActivity.L;
                        iVar.f3529l = true;
                        iVar.d(false);
                        mainActivity.M.a();
                        Log.d("MainActivity", " finish()");
                        mainActivity.finish();
                        return;
                    case 7:
                        int i9 = MainActivity.J0;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity, FileDirActivity.class));
                        return;
                    case 8:
                        int i10 = mainActivity.f578i0;
                        if (i10 == 0) {
                            mainActivity.f578i0 = 2;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(false);
                            MyRockerView myRockerView = mainActivity.H;
                            if (!myRockerView.s) {
                                myRockerView.setShow(false);
                            }
                            mainActivity.p("改变值");
                            mainActivity.M.c(false);
                            int i11 = mainActivity.d;
                            if (i11 != 1) {
                                if (i11 != 2) {
                                    i3 = 2131558498;
                                } else {
                                    throw null;
                                }
                            } else {
                                mainActivity.f601v.setVisibility(0);
                                throw null;
                            }
                        } else if (i10 == 2) {
                            mainActivity.f578i0 = 3;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(0);
                            mainActivity.f581k.setVisibility(0);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(true);
                            mainActivity.H.setShow(true);
                            mainActivity.M.c(false);
                            int i12 = mainActivity.d;
                            if (i12 != 1) {
                                if (i12 != 2) {
                                    i3 = 2131558499;
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else if (i10 == 3) {
                            mainActivity.f578i0 = 0;
                            if (mainActivity.f582k0) {
                                mainActivity.f582k0 = false;
                                mainActivity.H.setGravity(false);
                                mainActivity.C.setBackground(mainActivity.getDrawable(2131558468));
                            }
                            mainActivity.f608z.setVisibility(8);
                            mainActivity.f579j.setVisibility(8);
                            mainActivity.f585m.setVisibility(4);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(4);
                            throw null;
                        } else {
                            i3 = 2131558497;
                        }
                        mainActivity.D.setBackground(mainActivity.getDrawable(i3));
                        return;
                    case 9:
                        if (mainActivity.W) {
                            mainActivity.o();
                            mainActivity.W = false;
                            mainActivity.X = false;
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558525));
                            return;
                        }
                        if (!Environment.getExternalStorageState().equals("mounted")) {
                            blockSize = 0;
                        } else {
                            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                            statFs.getBlockCount();
                            long availableBlocks = statFs.getAvailableBlocks();
                            statFs.getFreeBlocks();
                            blockSize = ((availableBlocks * statFs.getBlockSize()) / 1024) / 1024;
                        }
                        if (blockSize > 100) {
                            mainActivity.f583l.setVisibility(0);
                            mainActivity.F.setText("00:00");
                            mainActivity.C0.postDelayed(mainActivity.B0, 500L);
                            mainActivity.W = true;
                            mainActivity.X = true;
                            mainActivity.Z = true;
                            mainActivity.f566b0 = System.currentTimeMillis() + ".mp4";
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558526));
                            return;
                        }
                        Toast.makeText(mainActivity, mainActivity.getString(2131755349), 1).show();
                        return;
                    default:
                        if (mainActivity.Y) {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558531));
                        } else {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558532));
                        }
                        mainActivity.Y = !mainActivity.Y;
                        return;
                }
            }
        });
        CustomButton customButton2 = (CustomButton) findViewById(2131230881);
        this.f606y = customButton2;
        customButton2.setVisibility(4);
        this.f606y.setOnClickListener(new View.OnClickListener(this) { // from class: t2.f
            public final /* synthetic */ MainActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                long blockSize;
                MainActivity mainActivity = this.b;
                switch (r2) {
                    case 0:
                        if (mainActivity.f580j0) {
                            mainActivity.q("电量低于60%，无法翻滚");
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            return;
                        }
                        int i5 = mainActivity.d;
                        byte[] bArr = mainActivity.f574g0;
                        if (i5 != 1) {
                            if (i5 == 2) {
                                if (mainActivity.f588n0) {
                                    byte b = (byte) (bArr[5] & (-2));
                                    bArr[5] = b;
                                    bArr[5] = (byte) (b & (-65));
                                    mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                                    mainActivity.f588n0 = false;
                                    mainActivity.p("isFanGun--false");
                                    return;
                                }
                                byte b5 = (byte) (bArr[5] | 1);
                                bArr[5] = b5;
                                bArr[5] = (byte) (b5 | 64);
                                mainActivity.f588n0 = true;
                                mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                                mainActivity.p("isFanGun--true");
                                return;
                            }
                            return;
                        } else if (mainActivity.f588n0) {
                            bArr[5] = (byte) (bArr[5] & (-9));
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            mainActivity.f588n0 = false;
                            mainActivity.p("isFanGun--false");
                            return;
                        } else {
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                            mainActivity.f588n0 = true;
                            mainActivity.f598t0 = false;
                            return;
                        }
                    case 1:
                        int i6 = mainActivity.d;
                        byte[] bArr2 = mainActivity.f574g0;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                if (mainActivity.f586m0) {
                                    bArr2[5] = (byte) (bArr2[5] & (-33));
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                                } else {
                                    bArr2[5] = (byte) (bArr2[5] | 32);
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                                }
                            }
                        } else if (mainActivity.f586m0) {
                            bArr2[5] = (byte) (bArr2[5] & (-17));
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                        } else {
                            bArr2[5] = (byte) (bArr2[5] | 16);
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                        }
                        mainActivity.f586m0 = !mainActivity.f586m0;
                        mainActivity.p("btWuTou");
                        return;
                    case 2:
                        int i7 = mainActivity.d;
                        byte[] bArr3 = mainActivity.f574g0;
                        if (i7 != 1) {
                            if (i7 == 2) {
                                bArr3[5] = (byte) (bArr3[5] | 2);
                            }
                        } else {
                            bArr3[5] = (byte) (bArr3[5] | 1);
                        }
                        mainActivity.p("btFlyUp");
                        mainActivity.C0.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 3:
                        int i8 = mainActivity.d;
                        byte[] bArr4 = mainActivity.f574g0;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                bArr4[5] = (byte) (bArr4[5] | 4);
                            }
                        } else {
                            bArr4[5] = (byte) (bArr4[5] | 2);
                        }
                        mainActivity.p("btFlyDown");
                        mainActivity.C0.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 4:
                        boolean z3 = mainActivity.f584l0;
                        byte[] bArr5 = mainActivity.f574g0;
                        if (z3) {
                            bArr5[5] = (byte) (bArr5[5] & (-65));
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558507));
                            mainActivity.w.setVisibility(8);
                            mainActivity.f604x.setVisibility(8);
                            mainActivity.G.setDG(false);
                        } else {
                            bArr5[5] = (byte) (bArr5[5] | 64);
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558508));
                            mainActivity.w.setVisibility(0);
                            mainActivity.f604x.setVisibility(0);
                            mainActivity.G.setDG(true);
                        }
                        mainActivity.f584l0 = !mainActivity.f584l0;
                        mainActivity.p("btDingGao");
                        return;
                    case 5:
                        mainActivity.f603w0.a();
                        return;
                    case 6:
                        s2.i iVar = mainActivity.L;
                        iVar.f3529l = true;
                        iVar.d(false);
                        mainActivity.M.a();
                        Log.d("MainActivity", " finish()");
                        mainActivity.finish();
                        return;
                    case 7:
                        int i9 = MainActivity.J0;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity, FileDirActivity.class));
                        return;
                    case 8:
                        int i10 = mainActivity.f578i0;
                        if (i10 == 0) {
                            mainActivity.f578i0 = 2;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(false);
                            MyRockerView myRockerView = mainActivity.H;
                            if (!myRockerView.s) {
                                myRockerView.setShow(false);
                            }
                            mainActivity.p("改变值");
                            mainActivity.M.c(false);
                            int i11 = mainActivity.d;
                            if (i11 != 1) {
                                if (i11 != 2) {
                                    i3 = 2131558498;
                                } else {
                                    throw null;
                                }
                            } else {
                                mainActivity.f601v.setVisibility(0);
                                throw null;
                            }
                        } else if (i10 == 2) {
                            mainActivity.f578i0 = 3;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(0);
                            mainActivity.f581k.setVisibility(0);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(true);
                            mainActivity.H.setShow(true);
                            mainActivity.M.c(false);
                            int i12 = mainActivity.d;
                            if (i12 != 1) {
                                if (i12 != 2) {
                                    i3 = 2131558499;
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else if (i10 == 3) {
                            mainActivity.f578i0 = 0;
                            if (mainActivity.f582k0) {
                                mainActivity.f582k0 = false;
                                mainActivity.H.setGravity(false);
                                mainActivity.C.setBackground(mainActivity.getDrawable(2131558468));
                            }
                            mainActivity.f608z.setVisibility(8);
                            mainActivity.f579j.setVisibility(8);
                            mainActivity.f585m.setVisibility(4);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(4);
                            throw null;
                        } else {
                            i3 = 2131558497;
                        }
                        mainActivity.D.setBackground(mainActivity.getDrawable(i3));
                        return;
                    case 9:
                        if (mainActivity.W) {
                            mainActivity.o();
                            mainActivity.W = false;
                            mainActivity.X = false;
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558525));
                            return;
                        }
                        if (!Environment.getExternalStorageState().equals("mounted")) {
                            blockSize = 0;
                        } else {
                            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                            statFs.getBlockCount();
                            long availableBlocks = statFs.getAvailableBlocks();
                            statFs.getFreeBlocks();
                            blockSize = ((availableBlocks * statFs.getBlockSize()) / 1024) / 1024;
                        }
                        if (blockSize > 100) {
                            mainActivity.f583l.setVisibility(0);
                            mainActivity.F.setText("00:00");
                            mainActivity.C0.postDelayed(mainActivity.B0, 500L);
                            mainActivity.W = true;
                            mainActivity.X = true;
                            mainActivity.Z = true;
                            mainActivity.f566b0 = System.currentTimeMillis() + ".mp4";
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558526));
                            return;
                        }
                        Toast.makeText(mainActivity, mainActivity.getString(2131755349), 1).show();
                        return;
                    default:
                        if (mainActivity.Y) {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558531));
                        } else {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558532));
                        }
                        mainActivity.Y = !mainActivity.Y;
                        return;
                }
            }
        });
        CustomButton customButton3 = (CustomButton) findViewById(2131230852);
        this.w = customButton3;
        customButton3.setVisibility(8);
        this.w.setOnClickListener(new View.OnClickListener(this) { // from class: t2.f
            public final /* synthetic */ MainActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                long blockSize;
                MainActivity mainActivity = this.b;
                switch (r2) {
                    case 0:
                        if (mainActivity.f580j0) {
                            mainActivity.q("电量低于60%，无法翻滚");
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            return;
                        }
                        int i5 = mainActivity.d;
                        byte[] bArr = mainActivity.f574g0;
                        if (i5 != 1) {
                            if (i5 == 2) {
                                if (mainActivity.f588n0) {
                                    byte b = (byte) (bArr[5] & (-2));
                                    bArr[5] = b;
                                    bArr[5] = (byte) (b & (-65));
                                    mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                                    mainActivity.f588n0 = false;
                                    mainActivity.p("isFanGun--false");
                                    return;
                                }
                                byte b5 = (byte) (bArr[5] | 1);
                                bArr[5] = b5;
                                bArr[5] = (byte) (b5 | 64);
                                mainActivity.f588n0 = true;
                                mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                                mainActivity.p("isFanGun--true");
                                return;
                            }
                            return;
                        } else if (mainActivity.f588n0) {
                            bArr[5] = (byte) (bArr[5] & (-9));
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            mainActivity.f588n0 = false;
                            mainActivity.p("isFanGun--false");
                            return;
                        } else {
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                            mainActivity.f588n0 = true;
                            mainActivity.f598t0 = false;
                            return;
                        }
                    case 1:
                        int i6 = mainActivity.d;
                        byte[] bArr2 = mainActivity.f574g0;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                if (mainActivity.f586m0) {
                                    bArr2[5] = (byte) (bArr2[5] & (-33));
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                                } else {
                                    bArr2[5] = (byte) (bArr2[5] | 32);
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                                }
                            }
                        } else if (mainActivity.f586m0) {
                            bArr2[5] = (byte) (bArr2[5] & (-17));
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                        } else {
                            bArr2[5] = (byte) (bArr2[5] | 16);
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                        }
                        mainActivity.f586m0 = !mainActivity.f586m0;
                        mainActivity.p("btWuTou");
                        return;
                    case 2:
                        int i7 = mainActivity.d;
                        byte[] bArr3 = mainActivity.f574g0;
                        if (i7 != 1) {
                            if (i7 == 2) {
                                bArr3[5] = (byte) (bArr3[5] | 2);
                            }
                        } else {
                            bArr3[5] = (byte) (bArr3[5] | 1);
                        }
                        mainActivity.p("btFlyUp");
                        mainActivity.C0.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 3:
                        int i8 = mainActivity.d;
                        byte[] bArr4 = mainActivity.f574g0;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                bArr4[5] = (byte) (bArr4[5] | 4);
                            }
                        } else {
                            bArr4[5] = (byte) (bArr4[5] | 2);
                        }
                        mainActivity.p("btFlyDown");
                        mainActivity.C0.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 4:
                        boolean z3 = mainActivity.f584l0;
                        byte[] bArr5 = mainActivity.f574g0;
                        if (z3) {
                            bArr5[5] = (byte) (bArr5[5] & (-65));
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558507));
                            mainActivity.w.setVisibility(8);
                            mainActivity.f604x.setVisibility(8);
                            mainActivity.G.setDG(false);
                        } else {
                            bArr5[5] = (byte) (bArr5[5] | 64);
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558508));
                            mainActivity.w.setVisibility(0);
                            mainActivity.f604x.setVisibility(0);
                            mainActivity.G.setDG(true);
                        }
                        mainActivity.f584l0 = !mainActivity.f584l0;
                        mainActivity.p("btDingGao");
                        return;
                    case 5:
                        mainActivity.f603w0.a();
                        return;
                    case 6:
                        s2.i iVar = mainActivity.L;
                        iVar.f3529l = true;
                        iVar.d(false);
                        mainActivity.M.a();
                        Log.d("MainActivity", " finish()");
                        mainActivity.finish();
                        return;
                    case 7:
                        int i9 = MainActivity.J0;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity, FileDirActivity.class));
                        return;
                    case 8:
                        int i10 = mainActivity.f578i0;
                        if (i10 == 0) {
                            mainActivity.f578i0 = 2;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(false);
                            MyRockerView myRockerView = mainActivity.H;
                            if (!myRockerView.s) {
                                myRockerView.setShow(false);
                            }
                            mainActivity.p("改变值");
                            mainActivity.M.c(false);
                            int i11 = mainActivity.d;
                            if (i11 != 1) {
                                if (i11 != 2) {
                                    i3 = 2131558498;
                                } else {
                                    throw null;
                                }
                            } else {
                                mainActivity.f601v.setVisibility(0);
                                throw null;
                            }
                        } else if (i10 == 2) {
                            mainActivity.f578i0 = 3;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(0);
                            mainActivity.f581k.setVisibility(0);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(true);
                            mainActivity.H.setShow(true);
                            mainActivity.M.c(false);
                            int i12 = mainActivity.d;
                            if (i12 != 1) {
                                if (i12 != 2) {
                                    i3 = 2131558499;
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else if (i10 == 3) {
                            mainActivity.f578i0 = 0;
                            if (mainActivity.f582k0) {
                                mainActivity.f582k0 = false;
                                mainActivity.H.setGravity(false);
                                mainActivity.C.setBackground(mainActivity.getDrawable(2131558468));
                            }
                            mainActivity.f608z.setVisibility(8);
                            mainActivity.f579j.setVisibility(8);
                            mainActivity.f585m.setVisibility(4);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(4);
                            throw null;
                        } else {
                            i3 = 2131558497;
                        }
                        mainActivity.D.setBackground(mainActivity.getDrawable(i3));
                        return;
                    case 9:
                        if (mainActivity.W) {
                            mainActivity.o();
                            mainActivity.W = false;
                            mainActivity.X = false;
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558525));
                            return;
                        }
                        if (!Environment.getExternalStorageState().equals("mounted")) {
                            blockSize = 0;
                        } else {
                            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                            statFs.getBlockCount();
                            long availableBlocks = statFs.getAvailableBlocks();
                            statFs.getFreeBlocks();
                            blockSize = ((availableBlocks * statFs.getBlockSize()) / 1024) / 1024;
                        }
                        if (blockSize > 100) {
                            mainActivity.f583l.setVisibility(0);
                            mainActivity.F.setText("00:00");
                            mainActivity.C0.postDelayed(mainActivity.B0, 500L);
                            mainActivity.W = true;
                            mainActivity.X = true;
                            mainActivity.Z = true;
                            mainActivity.f566b0 = System.currentTimeMillis() + ".mp4";
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558526));
                            return;
                        }
                        Toast.makeText(mainActivity, mainActivity.getString(2131755349), 1).show();
                        return;
                    default:
                        if (mainActivity.Y) {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558531));
                        } else {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558532));
                        }
                        mainActivity.Y = !mainActivity.Y;
                        return;
                }
            }
        });
        CustomButton customButton4 = (CustomButton) findViewById(2131230851);
        this.f604x = customButton4;
        customButton4.setVisibility(8);
        this.f604x.setOnClickListener(new View.OnClickListener(this) { // from class: t2.f
            public final /* synthetic */ MainActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                long blockSize;
                MainActivity mainActivity = this.b;
                switch (r2) {
                    case 0:
                        if (mainActivity.f580j0) {
                            mainActivity.q("电量低于60%，无法翻滚");
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            return;
                        }
                        int i5 = mainActivity.d;
                        byte[] bArr = mainActivity.f574g0;
                        if (i5 != 1) {
                            if (i5 == 2) {
                                if (mainActivity.f588n0) {
                                    byte b = (byte) (bArr[5] & (-2));
                                    bArr[5] = b;
                                    bArr[5] = (byte) (b & (-65));
                                    mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                                    mainActivity.f588n0 = false;
                                    mainActivity.p("isFanGun--false");
                                    return;
                                }
                                byte b5 = (byte) (bArr[5] | 1);
                                bArr[5] = b5;
                                bArr[5] = (byte) (b5 | 64);
                                mainActivity.f588n0 = true;
                                mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                                mainActivity.p("isFanGun--true");
                                return;
                            }
                            return;
                        } else if (mainActivity.f588n0) {
                            bArr[5] = (byte) (bArr[5] & (-9));
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            mainActivity.f588n0 = false;
                            mainActivity.p("isFanGun--false");
                            return;
                        } else {
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                            mainActivity.f588n0 = true;
                            mainActivity.f598t0 = false;
                            return;
                        }
                    case 1:
                        int i6 = mainActivity.d;
                        byte[] bArr2 = mainActivity.f574g0;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                if (mainActivity.f586m0) {
                                    bArr2[5] = (byte) (bArr2[5] & (-33));
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                                } else {
                                    bArr2[5] = (byte) (bArr2[5] | 32);
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                                }
                            }
                        } else if (mainActivity.f586m0) {
                            bArr2[5] = (byte) (bArr2[5] & (-17));
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                        } else {
                            bArr2[5] = (byte) (bArr2[5] | 16);
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                        }
                        mainActivity.f586m0 = !mainActivity.f586m0;
                        mainActivity.p("btWuTou");
                        return;
                    case 2:
                        int i7 = mainActivity.d;
                        byte[] bArr3 = mainActivity.f574g0;
                        if (i7 != 1) {
                            if (i7 == 2) {
                                bArr3[5] = (byte) (bArr3[5] | 2);
                            }
                        } else {
                            bArr3[5] = (byte) (bArr3[5] | 1);
                        }
                        mainActivity.p("btFlyUp");
                        mainActivity.C0.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 3:
                        int i8 = mainActivity.d;
                        byte[] bArr4 = mainActivity.f574g0;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                bArr4[5] = (byte) (bArr4[5] | 4);
                            }
                        } else {
                            bArr4[5] = (byte) (bArr4[5] | 2);
                        }
                        mainActivity.p("btFlyDown");
                        mainActivity.C0.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 4:
                        boolean z3 = mainActivity.f584l0;
                        byte[] bArr5 = mainActivity.f574g0;
                        if (z3) {
                            bArr5[5] = (byte) (bArr5[5] & (-65));
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558507));
                            mainActivity.w.setVisibility(8);
                            mainActivity.f604x.setVisibility(8);
                            mainActivity.G.setDG(false);
                        } else {
                            bArr5[5] = (byte) (bArr5[5] | 64);
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558508));
                            mainActivity.w.setVisibility(0);
                            mainActivity.f604x.setVisibility(0);
                            mainActivity.G.setDG(true);
                        }
                        mainActivity.f584l0 = !mainActivity.f584l0;
                        mainActivity.p("btDingGao");
                        return;
                    case 5:
                        mainActivity.f603w0.a();
                        return;
                    case 6:
                        s2.i iVar = mainActivity.L;
                        iVar.f3529l = true;
                        iVar.d(false);
                        mainActivity.M.a();
                        Log.d("MainActivity", " finish()");
                        mainActivity.finish();
                        return;
                    case 7:
                        int i9 = MainActivity.J0;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity, FileDirActivity.class));
                        return;
                    case 8:
                        int i10 = mainActivity.f578i0;
                        if (i10 == 0) {
                            mainActivity.f578i0 = 2;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(false);
                            MyRockerView myRockerView = mainActivity.H;
                            if (!myRockerView.s) {
                                myRockerView.setShow(false);
                            }
                            mainActivity.p("改变值");
                            mainActivity.M.c(false);
                            int i11 = mainActivity.d;
                            if (i11 != 1) {
                                if (i11 != 2) {
                                    i3 = 2131558498;
                                } else {
                                    throw null;
                                }
                            } else {
                                mainActivity.f601v.setVisibility(0);
                                throw null;
                            }
                        } else if (i10 == 2) {
                            mainActivity.f578i0 = 3;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(0);
                            mainActivity.f581k.setVisibility(0);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(true);
                            mainActivity.H.setShow(true);
                            mainActivity.M.c(false);
                            int i12 = mainActivity.d;
                            if (i12 != 1) {
                                if (i12 != 2) {
                                    i3 = 2131558499;
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else if (i10 == 3) {
                            mainActivity.f578i0 = 0;
                            if (mainActivity.f582k0) {
                                mainActivity.f582k0 = false;
                                mainActivity.H.setGravity(false);
                                mainActivity.C.setBackground(mainActivity.getDrawable(2131558468));
                            }
                            mainActivity.f608z.setVisibility(8);
                            mainActivity.f579j.setVisibility(8);
                            mainActivity.f585m.setVisibility(4);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(4);
                            throw null;
                        } else {
                            i3 = 2131558497;
                        }
                        mainActivity.D.setBackground(mainActivity.getDrawable(i3));
                        return;
                    case 9:
                        if (mainActivity.W) {
                            mainActivity.o();
                            mainActivity.W = false;
                            mainActivity.X = false;
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558525));
                            return;
                        }
                        if (!Environment.getExternalStorageState().equals("mounted")) {
                            blockSize = 0;
                        } else {
                            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                            statFs.getBlockCount();
                            long availableBlocks = statFs.getAvailableBlocks();
                            statFs.getFreeBlocks();
                            blockSize = ((availableBlocks * statFs.getBlockSize()) / 1024) / 1024;
                        }
                        if (blockSize > 100) {
                            mainActivity.f583l.setVisibility(0);
                            mainActivity.F.setText("00:00");
                            mainActivity.C0.postDelayed(mainActivity.B0, 500L);
                            mainActivity.W = true;
                            mainActivity.X = true;
                            mainActivity.Z = true;
                            mainActivity.f566b0 = System.currentTimeMillis() + ".mp4";
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558526));
                            return;
                        }
                        Toast.makeText(mainActivity, mainActivity.getString(2131755349), 1).show();
                        return;
                    default:
                        if (mainActivity.Y) {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558531));
                        } else {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558532));
                        }
                        mainActivity.Y = !mainActivity.Y;
                        return;
                }
            }
        });
        CustomButton customButton5 = (CustomButton) findViewById(2131230846);
        this.f601v = customButton5;
        customButton5.setOnClickListener(new View.OnClickListener(this) { // from class: t2.f
            public final /* synthetic */ MainActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                long blockSize;
                MainActivity mainActivity = this.b;
                switch (r2) {
                    case 0:
                        if (mainActivity.f580j0) {
                            mainActivity.q("电量低于60%，无法翻滚");
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            return;
                        }
                        int i5 = mainActivity.d;
                        byte[] bArr = mainActivity.f574g0;
                        if (i5 != 1) {
                            if (i5 == 2) {
                                if (mainActivity.f588n0) {
                                    byte b = (byte) (bArr[5] & (-2));
                                    bArr[5] = b;
                                    bArr[5] = (byte) (b & (-65));
                                    mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                                    mainActivity.f588n0 = false;
                                    mainActivity.p("isFanGun--false");
                                    return;
                                }
                                byte b5 = (byte) (bArr[5] | 1);
                                bArr[5] = b5;
                                bArr[5] = (byte) (b5 | 64);
                                mainActivity.f588n0 = true;
                                mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                                mainActivity.p("isFanGun--true");
                                return;
                            }
                            return;
                        } else if (mainActivity.f588n0) {
                            bArr[5] = (byte) (bArr[5] & (-9));
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            mainActivity.f588n0 = false;
                            mainActivity.p("isFanGun--false");
                            return;
                        } else {
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                            mainActivity.f588n0 = true;
                            mainActivity.f598t0 = false;
                            return;
                        }
                    case 1:
                        int i6 = mainActivity.d;
                        byte[] bArr2 = mainActivity.f574g0;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                if (mainActivity.f586m0) {
                                    bArr2[5] = (byte) (bArr2[5] & (-33));
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                                } else {
                                    bArr2[5] = (byte) (bArr2[5] | 32);
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                                }
                            }
                        } else if (mainActivity.f586m0) {
                            bArr2[5] = (byte) (bArr2[5] & (-17));
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                        } else {
                            bArr2[5] = (byte) (bArr2[5] | 16);
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                        }
                        mainActivity.f586m0 = !mainActivity.f586m0;
                        mainActivity.p("btWuTou");
                        return;
                    case 2:
                        int i7 = mainActivity.d;
                        byte[] bArr3 = mainActivity.f574g0;
                        if (i7 != 1) {
                            if (i7 == 2) {
                                bArr3[5] = (byte) (bArr3[5] | 2);
                            }
                        } else {
                            bArr3[5] = (byte) (bArr3[5] | 1);
                        }
                        mainActivity.p("btFlyUp");
                        mainActivity.C0.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 3:
                        int i8 = mainActivity.d;
                        byte[] bArr4 = mainActivity.f574g0;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                bArr4[5] = (byte) (bArr4[5] | 4);
                            }
                        } else {
                            bArr4[5] = (byte) (bArr4[5] | 2);
                        }
                        mainActivity.p("btFlyDown");
                        mainActivity.C0.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 4:
                        boolean z3 = mainActivity.f584l0;
                        byte[] bArr5 = mainActivity.f574g0;
                        if (z3) {
                            bArr5[5] = (byte) (bArr5[5] & (-65));
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558507));
                            mainActivity.w.setVisibility(8);
                            mainActivity.f604x.setVisibility(8);
                            mainActivity.G.setDG(false);
                        } else {
                            bArr5[5] = (byte) (bArr5[5] | 64);
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558508));
                            mainActivity.w.setVisibility(0);
                            mainActivity.f604x.setVisibility(0);
                            mainActivity.G.setDG(true);
                        }
                        mainActivity.f584l0 = !mainActivity.f584l0;
                        mainActivity.p("btDingGao");
                        return;
                    case 5:
                        mainActivity.f603w0.a();
                        return;
                    case 6:
                        s2.i iVar = mainActivity.L;
                        iVar.f3529l = true;
                        iVar.d(false);
                        mainActivity.M.a();
                        Log.d("MainActivity", " finish()");
                        mainActivity.finish();
                        return;
                    case 7:
                        int i9 = MainActivity.J0;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity, FileDirActivity.class));
                        return;
                    case 8:
                        int i10 = mainActivity.f578i0;
                        if (i10 == 0) {
                            mainActivity.f578i0 = 2;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(false);
                            MyRockerView myRockerView = mainActivity.H;
                            if (!myRockerView.s) {
                                myRockerView.setShow(false);
                            }
                            mainActivity.p("改变值");
                            mainActivity.M.c(false);
                            int i11 = mainActivity.d;
                            if (i11 != 1) {
                                if (i11 != 2) {
                                    i3 = 2131558498;
                                } else {
                                    throw null;
                                }
                            } else {
                                mainActivity.f601v.setVisibility(0);
                                throw null;
                            }
                        } else if (i10 == 2) {
                            mainActivity.f578i0 = 3;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(0);
                            mainActivity.f581k.setVisibility(0);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(true);
                            mainActivity.H.setShow(true);
                            mainActivity.M.c(false);
                            int i12 = mainActivity.d;
                            if (i12 != 1) {
                                if (i12 != 2) {
                                    i3 = 2131558499;
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else if (i10 == 3) {
                            mainActivity.f578i0 = 0;
                            if (mainActivity.f582k0) {
                                mainActivity.f582k0 = false;
                                mainActivity.H.setGravity(false);
                                mainActivity.C.setBackground(mainActivity.getDrawable(2131558468));
                            }
                            mainActivity.f608z.setVisibility(8);
                            mainActivity.f579j.setVisibility(8);
                            mainActivity.f585m.setVisibility(4);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(4);
                            throw null;
                        } else {
                            i3 = 2131558497;
                        }
                        mainActivity.D.setBackground(mainActivity.getDrawable(i3));
                        return;
                    case 9:
                        if (mainActivity.W) {
                            mainActivity.o();
                            mainActivity.W = false;
                            mainActivity.X = false;
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558525));
                            return;
                        }
                        if (!Environment.getExternalStorageState().equals("mounted")) {
                            blockSize = 0;
                        } else {
                            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                            statFs.getBlockCount();
                            long availableBlocks = statFs.getAvailableBlocks();
                            statFs.getFreeBlocks();
                            blockSize = ((availableBlocks * statFs.getBlockSize()) / 1024) / 1024;
                        }
                        if (blockSize > 100) {
                            mainActivity.f583l.setVisibility(0);
                            mainActivity.F.setText("00:00");
                            mainActivity.C0.postDelayed(mainActivity.B0, 500L);
                            mainActivity.W = true;
                            mainActivity.X = true;
                            mainActivity.Z = true;
                            mainActivity.f566b0 = System.currentTimeMillis() + ".mp4";
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558526));
                            return;
                        }
                        Toast.makeText(mainActivity, mainActivity.getString(2131755349), 1).show();
                        return;
                    default:
                        if (mainActivity.Y) {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558531));
                        } else {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558532));
                        }
                        mainActivity.Y = !mainActivity.Y;
                        return;
                }
            }
        });
        ((HTrimView) findViewById(2131231456)).setOnTrimViewInterface(new g(this, 0));
        ((HTrimView) findViewById(2131231457)).setOnTrimViewInterface(new g(this, 1));
        VTrimView vTrimView = (VTrimView) findViewById(2131231458);
        this.f571f = vTrimView;
        vTrimView.setOnTrimViewInterface(new g(this, 2));
        this.H = (MyRockerView) findViewById(2131231132);
        this.G = (MyRockerView) findViewById(2131231128);
        this.H.setOnLocaListener(new g(this, 3));
        this.G.setOnLocaListener(new g(this, 4));
        this.s = (CustomButton) findViewById(2131230842);
        this.f599u = (CustomButton) findViewById(2131230849);
        CustomButton customButton6 = (CustomButton) findViewById(2131230869);
        this.D = (Button) findViewById(2131230856);
        CustomButton customButton7 = (CustomButton) findViewById(2131230841);
        this.f597t = (CustomButton) findViewById(2131230838);
        this.A = (CustomButton) findViewById(2131230868);
        this.B = (CustomButton) findViewById(2131230859);
        this.C = (CustomButton) findViewById(2131230872);
        SurfaceView surfaceView = (SurfaceView) findViewById(2131231148);
        this.I = surfaceView;
        SurfaceHolder holder = surfaceView.getHolder();
        this.R = holder;
        holder.addCallback(new t2.j(this));
        this.s.setOnClickListener(new View.OnClickListener(this) { // from class: t2.f
            public final /* synthetic */ MainActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                long blockSize;
                MainActivity mainActivity = this.b;
                switch (r2) {
                    case 0:
                        if (mainActivity.f580j0) {
                            mainActivity.q("电量低于60%，无法翻滚");
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            return;
                        }
                        int i5 = mainActivity.d;
                        byte[] bArr = mainActivity.f574g0;
                        if (i5 != 1) {
                            if (i5 == 2) {
                                if (mainActivity.f588n0) {
                                    byte b = (byte) (bArr[5] & (-2));
                                    bArr[5] = b;
                                    bArr[5] = (byte) (b & (-65));
                                    mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                                    mainActivity.f588n0 = false;
                                    mainActivity.p("isFanGun--false");
                                    return;
                                }
                                byte b5 = (byte) (bArr[5] | 1);
                                bArr[5] = b5;
                                bArr[5] = (byte) (b5 | 64);
                                mainActivity.f588n0 = true;
                                mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                                mainActivity.p("isFanGun--true");
                                return;
                            }
                            return;
                        } else if (mainActivity.f588n0) {
                            bArr[5] = (byte) (bArr[5] & (-9));
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            mainActivity.f588n0 = false;
                            mainActivity.p("isFanGun--false");
                            return;
                        } else {
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                            mainActivity.f588n0 = true;
                            mainActivity.f598t0 = false;
                            return;
                        }
                    case 1:
                        int i6 = mainActivity.d;
                        byte[] bArr2 = mainActivity.f574g0;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                if (mainActivity.f586m0) {
                                    bArr2[5] = (byte) (bArr2[5] & (-33));
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                                } else {
                                    bArr2[5] = (byte) (bArr2[5] | 32);
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                                }
                            }
                        } else if (mainActivity.f586m0) {
                            bArr2[5] = (byte) (bArr2[5] & (-17));
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                        } else {
                            bArr2[5] = (byte) (bArr2[5] | 16);
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                        }
                        mainActivity.f586m0 = !mainActivity.f586m0;
                        mainActivity.p("btWuTou");
                        return;
                    case 2:
                        int i7 = mainActivity.d;
                        byte[] bArr3 = mainActivity.f574g0;
                        if (i7 != 1) {
                            if (i7 == 2) {
                                bArr3[5] = (byte) (bArr3[5] | 2);
                            }
                        } else {
                            bArr3[5] = (byte) (bArr3[5] | 1);
                        }
                        mainActivity.p("btFlyUp");
                        mainActivity.C0.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 3:
                        int i8 = mainActivity.d;
                        byte[] bArr4 = mainActivity.f574g0;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                bArr4[5] = (byte) (bArr4[5] | 4);
                            }
                        } else {
                            bArr4[5] = (byte) (bArr4[5] | 2);
                        }
                        mainActivity.p("btFlyDown");
                        mainActivity.C0.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 4:
                        boolean z3 = mainActivity.f584l0;
                        byte[] bArr5 = mainActivity.f574g0;
                        if (z3) {
                            bArr5[5] = (byte) (bArr5[5] & (-65));
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558507));
                            mainActivity.w.setVisibility(8);
                            mainActivity.f604x.setVisibility(8);
                            mainActivity.G.setDG(false);
                        } else {
                            bArr5[5] = (byte) (bArr5[5] | 64);
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558508));
                            mainActivity.w.setVisibility(0);
                            mainActivity.f604x.setVisibility(0);
                            mainActivity.G.setDG(true);
                        }
                        mainActivity.f584l0 = !mainActivity.f584l0;
                        mainActivity.p("btDingGao");
                        return;
                    case 5:
                        mainActivity.f603w0.a();
                        return;
                    case 6:
                        s2.i iVar = mainActivity.L;
                        iVar.f3529l = true;
                        iVar.d(false);
                        mainActivity.M.a();
                        Log.d("MainActivity", " finish()");
                        mainActivity.finish();
                        return;
                    case 7:
                        int i9 = MainActivity.J0;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity, FileDirActivity.class));
                        return;
                    case 8:
                        int i10 = mainActivity.f578i0;
                        if (i10 == 0) {
                            mainActivity.f578i0 = 2;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(false);
                            MyRockerView myRockerView = mainActivity.H;
                            if (!myRockerView.s) {
                                myRockerView.setShow(false);
                            }
                            mainActivity.p("改变值");
                            mainActivity.M.c(false);
                            int i11 = mainActivity.d;
                            if (i11 != 1) {
                                if (i11 != 2) {
                                    i3 = 2131558498;
                                } else {
                                    throw null;
                                }
                            } else {
                                mainActivity.f601v.setVisibility(0);
                                throw null;
                            }
                        } else if (i10 == 2) {
                            mainActivity.f578i0 = 3;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(0);
                            mainActivity.f581k.setVisibility(0);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(true);
                            mainActivity.H.setShow(true);
                            mainActivity.M.c(false);
                            int i12 = mainActivity.d;
                            if (i12 != 1) {
                                if (i12 != 2) {
                                    i3 = 2131558499;
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else if (i10 == 3) {
                            mainActivity.f578i0 = 0;
                            if (mainActivity.f582k0) {
                                mainActivity.f582k0 = false;
                                mainActivity.H.setGravity(false);
                                mainActivity.C.setBackground(mainActivity.getDrawable(2131558468));
                            }
                            mainActivity.f608z.setVisibility(8);
                            mainActivity.f579j.setVisibility(8);
                            mainActivity.f585m.setVisibility(4);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(4);
                            throw null;
                        } else {
                            i3 = 2131558497;
                        }
                        mainActivity.D.setBackground(mainActivity.getDrawable(i3));
                        return;
                    case 9:
                        if (mainActivity.W) {
                            mainActivity.o();
                            mainActivity.W = false;
                            mainActivity.X = false;
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558525));
                            return;
                        }
                        if (!Environment.getExternalStorageState().equals("mounted")) {
                            blockSize = 0;
                        } else {
                            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                            statFs.getBlockCount();
                            long availableBlocks = statFs.getAvailableBlocks();
                            statFs.getFreeBlocks();
                            blockSize = ((availableBlocks * statFs.getBlockSize()) / 1024) / 1024;
                        }
                        if (blockSize > 100) {
                            mainActivity.f583l.setVisibility(0);
                            mainActivity.F.setText("00:00");
                            mainActivity.C0.postDelayed(mainActivity.B0, 500L);
                            mainActivity.W = true;
                            mainActivity.X = true;
                            mainActivity.Z = true;
                            mainActivity.f566b0 = System.currentTimeMillis() + ".mp4";
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558526));
                            return;
                        }
                        Toast.makeText(mainActivity, mainActivity.getString(2131755349), 1).show();
                        return;
                    default:
                        if (mainActivity.Y) {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558531));
                        } else {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558532));
                        }
                        mainActivity.Y = !mainActivity.Y;
                        return;
                }
            }
        });
        this.f599u.setOnClickListener(new View.OnClickListener(this) { // from class: t2.f
            public final /* synthetic */ MainActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                long blockSize;
                MainActivity mainActivity = this.b;
                switch (r2) {
                    case 0:
                        if (mainActivity.f580j0) {
                            mainActivity.q("电量低于60%，无法翻滚");
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            return;
                        }
                        int i5 = mainActivity.d;
                        byte[] bArr = mainActivity.f574g0;
                        if (i5 != 1) {
                            if (i5 == 2) {
                                if (mainActivity.f588n0) {
                                    byte b = (byte) (bArr[5] & (-2));
                                    bArr[5] = b;
                                    bArr[5] = (byte) (b & (-65));
                                    mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                                    mainActivity.f588n0 = false;
                                    mainActivity.p("isFanGun--false");
                                    return;
                                }
                                byte b5 = (byte) (bArr[5] | 1);
                                bArr[5] = b5;
                                bArr[5] = (byte) (b5 | 64);
                                mainActivity.f588n0 = true;
                                mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                                mainActivity.p("isFanGun--true");
                                return;
                            }
                            return;
                        } else if (mainActivity.f588n0) {
                            bArr[5] = (byte) (bArr[5] & (-9));
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            mainActivity.f588n0 = false;
                            mainActivity.p("isFanGun--false");
                            return;
                        } else {
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                            mainActivity.f588n0 = true;
                            mainActivity.f598t0 = false;
                            return;
                        }
                    case 1:
                        int i6 = mainActivity.d;
                        byte[] bArr2 = mainActivity.f574g0;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                if (mainActivity.f586m0) {
                                    bArr2[5] = (byte) (bArr2[5] & (-33));
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                                } else {
                                    bArr2[5] = (byte) (bArr2[5] | 32);
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                                }
                            }
                        } else if (mainActivity.f586m0) {
                            bArr2[5] = (byte) (bArr2[5] & (-17));
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                        } else {
                            bArr2[5] = (byte) (bArr2[5] | 16);
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                        }
                        mainActivity.f586m0 = !mainActivity.f586m0;
                        mainActivity.p("btWuTou");
                        return;
                    case 2:
                        int i7 = mainActivity.d;
                        byte[] bArr3 = mainActivity.f574g0;
                        if (i7 != 1) {
                            if (i7 == 2) {
                                bArr3[5] = (byte) (bArr3[5] | 2);
                            }
                        } else {
                            bArr3[5] = (byte) (bArr3[5] | 1);
                        }
                        mainActivity.p("btFlyUp");
                        mainActivity.C0.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 3:
                        int i8 = mainActivity.d;
                        byte[] bArr4 = mainActivity.f574g0;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                bArr4[5] = (byte) (bArr4[5] | 4);
                            }
                        } else {
                            bArr4[5] = (byte) (bArr4[5] | 2);
                        }
                        mainActivity.p("btFlyDown");
                        mainActivity.C0.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 4:
                        boolean z3 = mainActivity.f584l0;
                        byte[] bArr5 = mainActivity.f574g0;
                        if (z3) {
                            bArr5[5] = (byte) (bArr5[5] & (-65));
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558507));
                            mainActivity.w.setVisibility(8);
                            mainActivity.f604x.setVisibility(8);
                            mainActivity.G.setDG(false);
                        } else {
                            bArr5[5] = (byte) (bArr5[5] | 64);
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558508));
                            mainActivity.w.setVisibility(0);
                            mainActivity.f604x.setVisibility(0);
                            mainActivity.G.setDG(true);
                        }
                        mainActivity.f584l0 = !mainActivity.f584l0;
                        mainActivity.p("btDingGao");
                        return;
                    case 5:
                        mainActivity.f603w0.a();
                        return;
                    case 6:
                        s2.i iVar = mainActivity.L;
                        iVar.f3529l = true;
                        iVar.d(false);
                        mainActivity.M.a();
                        Log.d("MainActivity", " finish()");
                        mainActivity.finish();
                        return;
                    case 7:
                        int i9 = MainActivity.J0;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity, FileDirActivity.class));
                        return;
                    case 8:
                        int i10 = mainActivity.f578i0;
                        if (i10 == 0) {
                            mainActivity.f578i0 = 2;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(false);
                            MyRockerView myRockerView = mainActivity.H;
                            if (!myRockerView.s) {
                                myRockerView.setShow(false);
                            }
                            mainActivity.p("改变值");
                            mainActivity.M.c(false);
                            int i11 = mainActivity.d;
                            if (i11 != 1) {
                                if (i11 != 2) {
                                    i3 = 2131558498;
                                } else {
                                    throw null;
                                }
                            } else {
                                mainActivity.f601v.setVisibility(0);
                                throw null;
                            }
                        } else if (i10 == 2) {
                            mainActivity.f578i0 = 3;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(0);
                            mainActivity.f581k.setVisibility(0);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(true);
                            mainActivity.H.setShow(true);
                            mainActivity.M.c(false);
                            int i12 = mainActivity.d;
                            if (i12 != 1) {
                                if (i12 != 2) {
                                    i3 = 2131558499;
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else if (i10 == 3) {
                            mainActivity.f578i0 = 0;
                            if (mainActivity.f582k0) {
                                mainActivity.f582k0 = false;
                                mainActivity.H.setGravity(false);
                                mainActivity.C.setBackground(mainActivity.getDrawable(2131558468));
                            }
                            mainActivity.f608z.setVisibility(8);
                            mainActivity.f579j.setVisibility(8);
                            mainActivity.f585m.setVisibility(4);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(4);
                            throw null;
                        } else {
                            i3 = 2131558497;
                        }
                        mainActivity.D.setBackground(mainActivity.getDrawable(i3));
                        return;
                    case 9:
                        if (mainActivity.W) {
                            mainActivity.o();
                            mainActivity.W = false;
                            mainActivity.X = false;
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558525));
                            return;
                        }
                        if (!Environment.getExternalStorageState().equals("mounted")) {
                            blockSize = 0;
                        } else {
                            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                            statFs.getBlockCount();
                            long availableBlocks = statFs.getAvailableBlocks();
                            statFs.getFreeBlocks();
                            blockSize = ((availableBlocks * statFs.getBlockSize()) / 1024) / 1024;
                        }
                        if (blockSize > 100) {
                            mainActivity.f583l.setVisibility(0);
                            mainActivity.F.setText("00:00");
                            mainActivity.C0.postDelayed(mainActivity.B0, 500L);
                            mainActivity.W = true;
                            mainActivity.X = true;
                            mainActivity.Z = true;
                            mainActivity.f566b0 = System.currentTimeMillis() + ".mp4";
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558526));
                            return;
                        }
                        Toast.makeText(mainActivity, mainActivity.getString(2131755349), 1).show();
                        return;
                    default:
                        if (mainActivity.Y) {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558531));
                        } else {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558532));
                        }
                        mainActivity.Y = !mainActivity.Y;
                        return;
                }
            }
        });
        this.D.setOnClickListener(new View.OnClickListener(this) { // from class: t2.f
            public final /* synthetic */ MainActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                long blockSize;
                MainActivity mainActivity = this.b;
                switch (r2) {
                    case 0:
                        if (mainActivity.f580j0) {
                            mainActivity.q("电量低于60%，无法翻滚");
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            return;
                        }
                        int i5 = mainActivity.d;
                        byte[] bArr = mainActivity.f574g0;
                        if (i5 != 1) {
                            if (i5 == 2) {
                                if (mainActivity.f588n0) {
                                    byte b = (byte) (bArr[5] & (-2));
                                    bArr[5] = b;
                                    bArr[5] = (byte) (b & (-65));
                                    mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                                    mainActivity.f588n0 = false;
                                    mainActivity.p("isFanGun--false");
                                    return;
                                }
                                byte b5 = (byte) (bArr[5] | 1);
                                bArr[5] = b5;
                                bArr[5] = (byte) (b5 | 64);
                                mainActivity.f588n0 = true;
                                mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                                mainActivity.p("isFanGun--true");
                                return;
                            }
                            return;
                        } else if (mainActivity.f588n0) {
                            bArr[5] = (byte) (bArr[5] & (-9));
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            mainActivity.f588n0 = false;
                            mainActivity.p("isFanGun--false");
                            return;
                        } else {
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                            mainActivity.f588n0 = true;
                            mainActivity.f598t0 = false;
                            return;
                        }
                    case 1:
                        int i6 = mainActivity.d;
                        byte[] bArr2 = mainActivity.f574g0;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                if (mainActivity.f586m0) {
                                    bArr2[5] = (byte) (bArr2[5] & (-33));
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                                } else {
                                    bArr2[5] = (byte) (bArr2[5] | 32);
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                                }
                            }
                        } else if (mainActivity.f586m0) {
                            bArr2[5] = (byte) (bArr2[5] & (-17));
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                        } else {
                            bArr2[5] = (byte) (bArr2[5] | 16);
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                        }
                        mainActivity.f586m0 = !mainActivity.f586m0;
                        mainActivity.p("btWuTou");
                        return;
                    case 2:
                        int i7 = mainActivity.d;
                        byte[] bArr3 = mainActivity.f574g0;
                        if (i7 != 1) {
                            if (i7 == 2) {
                                bArr3[5] = (byte) (bArr3[5] | 2);
                            }
                        } else {
                            bArr3[5] = (byte) (bArr3[5] | 1);
                        }
                        mainActivity.p("btFlyUp");
                        mainActivity.C0.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 3:
                        int i8 = mainActivity.d;
                        byte[] bArr4 = mainActivity.f574g0;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                bArr4[5] = (byte) (bArr4[5] | 4);
                            }
                        } else {
                            bArr4[5] = (byte) (bArr4[5] | 2);
                        }
                        mainActivity.p("btFlyDown");
                        mainActivity.C0.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 4:
                        boolean z3 = mainActivity.f584l0;
                        byte[] bArr5 = mainActivity.f574g0;
                        if (z3) {
                            bArr5[5] = (byte) (bArr5[5] & (-65));
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558507));
                            mainActivity.w.setVisibility(8);
                            mainActivity.f604x.setVisibility(8);
                            mainActivity.G.setDG(false);
                        } else {
                            bArr5[5] = (byte) (bArr5[5] | 64);
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558508));
                            mainActivity.w.setVisibility(0);
                            mainActivity.f604x.setVisibility(0);
                            mainActivity.G.setDG(true);
                        }
                        mainActivity.f584l0 = !mainActivity.f584l0;
                        mainActivity.p("btDingGao");
                        return;
                    case 5:
                        mainActivity.f603w0.a();
                        return;
                    case 6:
                        s2.i iVar = mainActivity.L;
                        iVar.f3529l = true;
                        iVar.d(false);
                        mainActivity.M.a();
                        Log.d("MainActivity", " finish()");
                        mainActivity.finish();
                        return;
                    case 7:
                        int i9 = MainActivity.J0;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity, FileDirActivity.class));
                        return;
                    case 8:
                        int i10 = mainActivity.f578i0;
                        if (i10 == 0) {
                            mainActivity.f578i0 = 2;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(false);
                            MyRockerView myRockerView = mainActivity.H;
                            if (!myRockerView.s) {
                                myRockerView.setShow(false);
                            }
                            mainActivity.p("改变值");
                            mainActivity.M.c(false);
                            int i11 = mainActivity.d;
                            if (i11 != 1) {
                                if (i11 != 2) {
                                    i3 = 2131558498;
                                } else {
                                    throw null;
                                }
                            } else {
                                mainActivity.f601v.setVisibility(0);
                                throw null;
                            }
                        } else if (i10 == 2) {
                            mainActivity.f578i0 = 3;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(0);
                            mainActivity.f581k.setVisibility(0);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(true);
                            mainActivity.H.setShow(true);
                            mainActivity.M.c(false);
                            int i12 = mainActivity.d;
                            if (i12 != 1) {
                                if (i12 != 2) {
                                    i3 = 2131558499;
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else if (i10 == 3) {
                            mainActivity.f578i0 = 0;
                            if (mainActivity.f582k0) {
                                mainActivity.f582k0 = false;
                                mainActivity.H.setGravity(false);
                                mainActivity.C.setBackground(mainActivity.getDrawable(2131558468));
                            }
                            mainActivity.f608z.setVisibility(8);
                            mainActivity.f579j.setVisibility(8);
                            mainActivity.f585m.setVisibility(4);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(4);
                            throw null;
                        } else {
                            i3 = 2131558497;
                        }
                        mainActivity.D.setBackground(mainActivity.getDrawable(i3));
                        return;
                    case 9:
                        if (mainActivity.W) {
                            mainActivity.o();
                            mainActivity.W = false;
                            mainActivity.X = false;
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558525));
                            return;
                        }
                        if (!Environment.getExternalStorageState().equals("mounted")) {
                            blockSize = 0;
                        } else {
                            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                            statFs.getBlockCount();
                            long availableBlocks = statFs.getAvailableBlocks();
                            statFs.getFreeBlocks();
                            blockSize = ((availableBlocks * statFs.getBlockSize()) / 1024) / 1024;
                        }
                        if (blockSize > 100) {
                            mainActivity.f583l.setVisibility(0);
                            mainActivity.F.setText("00:00");
                            mainActivity.C0.postDelayed(mainActivity.B0, 500L);
                            mainActivity.W = true;
                            mainActivity.X = true;
                            mainActivity.Z = true;
                            mainActivity.f566b0 = System.currentTimeMillis() + ".mp4";
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558526));
                            return;
                        }
                        Toast.makeText(mainActivity, mainActivity.getString(2131755349), 1).show();
                        return;
                    default:
                        if (mainActivity.Y) {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558531));
                        } else {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558532));
                        }
                        mainActivity.Y = !mainActivity.Y;
                        return;
                }
            }
        });
        this.f602v0 = new v3.c(this);
        m a5 = com.bumptech.glide.d.a(this.f597t);
        v3.c cVar = this.f602v0;
        cVar.getClass();
        a5.d(new v3.b(cVar, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"})).g(new o4.b(new g(this, 5)));
        this.A.setOnClickListener(new View.OnClickListener(this) { // from class: t2.f
            public final /* synthetic */ MainActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                long blockSize;
                MainActivity mainActivity = this.b;
                switch (r2) {
                    case 0:
                        if (mainActivity.f580j0) {
                            mainActivity.q("电量低于60%，无法翻滚");
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            return;
                        }
                        int i5 = mainActivity.d;
                        byte[] bArr = mainActivity.f574g0;
                        if (i5 != 1) {
                            if (i5 == 2) {
                                if (mainActivity.f588n0) {
                                    byte b = (byte) (bArr[5] & (-2));
                                    bArr[5] = b;
                                    bArr[5] = (byte) (b & (-65));
                                    mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                                    mainActivity.f588n0 = false;
                                    mainActivity.p("isFanGun--false");
                                    return;
                                }
                                byte b5 = (byte) (bArr[5] | 1);
                                bArr[5] = b5;
                                bArr[5] = (byte) (b5 | 64);
                                mainActivity.f588n0 = true;
                                mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                                mainActivity.p("isFanGun--true");
                                return;
                            }
                            return;
                        } else if (mainActivity.f588n0) {
                            bArr[5] = (byte) (bArr[5] & (-9));
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            mainActivity.f588n0 = false;
                            mainActivity.p("isFanGun--false");
                            return;
                        } else {
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                            mainActivity.f588n0 = true;
                            mainActivity.f598t0 = false;
                            return;
                        }
                    case 1:
                        int i6 = mainActivity.d;
                        byte[] bArr2 = mainActivity.f574g0;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                if (mainActivity.f586m0) {
                                    bArr2[5] = (byte) (bArr2[5] & (-33));
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                                } else {
                                    bArr2[5] = (byte) (bArr2[5] | 32);
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                                }
                            }
                        } else if (mainActivity.f586m0) {
                            bArr2[5] = (byte) (bArr2[5] & (-17));
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                        } else {
                            bArr2[5] = (byte) (bArr2[5] | 16);
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                        }
                        mainActivity.f586m0 = !mainActivity.f586m0;
                        mainActivity.p("btWuTou");
                        return;
                    case 2:
                        int i7 = mainActivity.d;
                        byte[] bArr3 = mainActivity.f574g0;
                        if (i7 != 1) {
                            if (i7 == 2) {
                                bArr3[5] = (byte) (bArr3[5] | 2);
                            }
                        } else {
                            bArr3[5] = (byte) (bArr3[5] | 1);
                        }
                        mainActivity.p("btFlyUp");
                        mainActivity.C0.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 3:
                        int i8 = mainActivity.d;
                        byte[] bArr4 = mainActivity.f574g0;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                bArr4[5] = (byte) (bArr4[5] | 4);
                            }
                        } else {
                            bArr4[5] = (byte) (bArr4[5] | 2);
                        }
                        mainActivity.p("btFlyDown");
                        mainActivity.C0.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 4:
                        boolean z3 = mainActivity.f584l0;
                        byte[] bArr5 = mainActivity.f574g0;
                        if (z3) {
                            bArr5[5] = (byte) (bArr5[5] & (-65));
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558507));
                            mainActivity.w.setVisibility(8);
                            mainActivity.f604x.setVisibility(8);
                            mainActivity.G.setDG(false);
                        } else {
                            bArr5[5] = (byte) (bArr5[5] | 64);
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558508));
                            mainActivity.w.setVisibility(0);
                            mainActivity.f604x.setVisibility(0);
                            mainActivity.G.setDG(true);
                        }
                        mainActivity.f584l0 = !mainActivity.f584l0;
                        mainActivity.p("btDingGao");
                        return;
                    case 5:
                        mainActivity.f603w0.a();
                        return;
                    case 6:
                        s2.i iVar = mainActivity.L;
                        iVar.f3529l = true;
                        iVar.d(false);
                        mainActivity.M.a();
                        Log.d("MainActivity", " finish()");
                        mainActivity.finish();
                        return;
                    case 7:
                        int i9 = MainActivity.J0;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity, FileDirActivity.class));
                        return;
                    case 8:
                        int i10 = mainActivity.f578i0;
                        if (i10 == 0) {
                            mainActivity.f578i0 = 2;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(false);
                            MyRockerView myRockerView = mainActivity.H;
                            if (!myRockerView.s) {
                                myRockerView.setShow(false);
                            }
                            mainActivity.p("改变值");
                            mainActivity.M.c(false);
                            int i11 = mainActivity.d;
                            if (i11 != 1) {
                                if (i11 != 2) {
                                    i3 = 2131558498;
                                } else {
                                    throw null;
                                }
                            } else {
                                mainActivity.f601v.setVisibility(0);
                                throw null;
                            }
                        } else if (i10 == 2) {
                            mainActivity.f578i0 = 3;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(0);
                            mainActivity.f581k.setVisibility(0);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(true);
                            mainActivity.H.setShow(true);
                            mainActivity.M.c(false);
                            int i12 = mainActivity.d;
                            if (i12 != 1) {
                                if (i12 != 2) {
                                    i3 = 2131558499;
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else if (i10 == 3) {
                            mainActivity.f578i0 = 0;
                            if (mainActivity.f582k0) {
                                mainActivity.f582k0 = false;
                                mainActivity.H.setGravity(false);
                                mainActivity.C.setBackground(mainActivity.getDrawable(2131558468));
                            }
                            mainActivity.f608z.setVisibility(8);
                            mainActivity.f579j.setVisibility(8);
                            mainActivity.f585m.setVisibility(4);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(4);
                            throw null;
                        } else {
                            i3 = 2131558497;
                        }
                        mainActivity.D.setBackground(mainActivity.getDrawable(i3));
                        return;
                    case 9:
                        if (mainActivity.W) {
                            mainActivity.o();
                            mainActivity.W = false;
                            mainActivity.X = false;
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558525));
                            return;
                        }
                        if (!Environment.getExternalStorageState().equals("mounted")) {
                            blockSize = 0;
                        } else {
                            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                            statFs.getBlockCount();
                            long availableBlocks = statFs.getAvailableBlocks();
                            statFs.getFreeBlocks();
                            blockSize = ((availableBlocks * statFs.getBlockSize()) / 1024) / 1024;
                        }
                        if (blockSize > 100) {
                            mainActivity.f583l.setVisibility(0);
                            mainActivity.F.setText("00:00");
                            mainActivity.C0.postDelayed(mainActivity.B0, 500L);
                            mainActivity.W = true;
                            mainActivity.X = true;
                            mainActivity.Z = true;
                            mainActivity.f566b0 = System.currentTimeMillis() + ".mp4";
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558526));
                            return;
                        }
                        Toast.makeText(mainActivity, mainActivity.getString(2131755349), 1).show();
                        return;
                    default:
                        if (mainActivity.Y) {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558531));
                        } else {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558532));
                        }
                        mainActivity.Y = !mainActivity.Y;
                        return;
                }
            }
        });
        this.B.setOnClickListener(new View.OnClickListener(this) { // from class: t2.f
            public final /* synthetic */ MainActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3;
                long blockSize;
                MainActivity mainActivity = this.b;
                switch (r2) {
                    case 0:
                        if (mainActivity.f580j0) {
                            mainActivity.q("电量低于60%，无法翻滚");
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            return;
                        }
                        int i5 = mainActivity.d;
                        byte[] bArr = mainActivity.f574g0;
                        if (i5 != 1) {
                            if (i5 == 2) {
                                if (mainActivity.f588n0) {
                                    byte b = (byte) (bArr[5] & (-2));
                                    bArr[5] = b;
                                    bArr[5] = (byte) (b & (-65));
                                    mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                                    mainActivity.f588n0 = false;
                                    mainActivity.p("isFanGun--false");
                                    return;
                                }
                                byte b5 = (byte) (bArr[5] | 1);
                                bArr[5] = b5;
                                bArr[5] = (byte) (b5 | 64);
                                mainActivity.f588n0 = true;
                                mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                                mainActivity.p("isFanGun--true");
                                return;
                            }
                            return;
                        } else if (mainActivity.f588n0) {
                            bArr[5] = (byte) (bArr[5] & (-9));
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558503));
                            mainActivity.f588n0 = false;
                            mainActivity.p("isFanGun--false");
                            return;
                        } else {
                            mainActivity.E.setBackground(mainActivity.getResources().getDrawable(2131558504));
                            mainActivity.f588n0 = true;
                            mainActivity.f598t0 = false;
                            return;
                        }
                    case 1:
                        int i6 = mainActivity.d;
                        byte[] bArr2 = mainActivity.f574g0;
                        if (i6 != 1) {
                            if (i6 == 2) {
                                if (mainActivity.f586m0) {
                                    bArr2[5] = (byte) (bArr2[5] & (-33));
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                                } else {
                                    bArr2[5] = (byte) (bArr2[5] | 32);
                                    mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                                }
                            }
                        } else if (mainActivity.f586m0) {
                            bArr2[5] = (byte) (bArr2[5] & (-17));
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558493));
                        } else {
                            bArr2[5] = (byte) (bArr2[5] | 16);
                            mainActivity.f606y.setBackground(mainActivity.getDrawable(2131558494));
                        }
                        mainActivity.f586m0 = !mainActivity.f586m0;
                        mainActivity.p("btWuTou");
                        return;
                    case 2:
                        int i7 = mainActivity.d;
                        byte[] bArr3 = mainActivity.f574g0;
                        if (i7 != 1) {
                            if (i7 == 2) {
                                bArr3[5] = (byte) (bArr3[5] | 2);
                            }
                        } else {
                            bArr3[5] = (byte) (bArr3[5] | 1);
                        }
                        mainActivity.p("btFlyUp");
                        mainActivity.C0.sendEmptyMessageDelayed(3, 1000L);
                        return;
                    case 3:
                        int i8 = mainActivity.d;
                        byte[] bArr4 = mainActivity.f574g0;
                        if (i8 != 1) {
                            if (i8 == 2) {
                                bArr4[5] = (byte) (bArr4[5] | 4);
                            }
                        } else {
                            bArr4[5] = (byte) (bArr4[5] | 2);
                        }
                        mainActivity.p("btFlyDown");
                        mainActivity.C0.sendEmptyMessageDelayed(6, 1000L);
                        return;
                    case 4:
                        boolean z3 = mainActivity.f584l0;
                        byte[] bArr5 = mainActivity.f574g0;
                        if (z3) {
                            bArr5[5] = (byte) (bArr5[5] & (-65));
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558507));
                            mainActivity.w.setVisibility(8);
                            mainActivity.f604x.setVisibility(8);
                            mainActivity.G.setDG(false);
                        } else {
                            bArr5[5] = (byte) (bArr5[5] | 64);
                            mainActivity.f601v.setBackground(mainActivity.getDrawable(2131558508));
                            mainActivity.w.setVisibility(0);
                            mainActivity.f604x.setVisibility(0);
                            mainActivity.G.setDG(true);
                        }
                        mainActivity.f584l0 = !mainActivity.f584l0;
                        mainActivity.p("btDingGao");
                        return;
                    case 5:
                        mainActivity.f603w0.a();
                        return;
                    case 6:
                        s2.i iVar = mainActivity.L;
                        iVar.f3529l = true;
                        iVar.d(false);
                        mainActivity.M.a();
                        Log.d("MainActivity", " finish()");
                        mainActivity.finish();
                        return;
                    case 7:
                        int i9 = MainActivity.J0;
                        mainActivity.getClass();
                        mainActivity.startActivity(new Intent(mainActivity, FileDirActivity.class));
                        return;
                    case 8:
                        int i10 = mainActivity.f578i0;
                        if (i10 == 0) {
                            mainActivity.f578i0 = 2;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(false);
                            MyRockerView myRockerView = mainActivity.H;
                            if (!myRockerView.s) {
                                myRockerView.setShow(false);
                            }
                            mainActivity.p("改变值");
                            mainActivity.M.c(false);
                            int i11 = mainActivity.d;
                            if (i11 != 1) {
                                if (i11 != 2) {
                                    i3 = 2131558498;
                                } else {
                                    throw null;
                                }
                            } else {
                                mainActivity.f601v.setVisibility(0);
                                throw null;
                            }
                        } else if (i10 == 2) {
                            mainActivity.f578i0 = 3;
                            mainActivity.f608z.setVisibility(0);
                            mainActivity.f579j.setVisibility(0);
                            mainActivity.f585m.setVisibility(0);
                            mainActivity.f571f.setVisibility(0);
                            mainActivity.f581k.setVisibility(0);
                            mainActivity.f606y.setVisibility(0);
                            mainActivity.E.setVisibility(0);
                            mainActivity.f587n.setVisibility(0);
                            mainActivity.G.setShow(true);
                            mainActivity.H.setShow(true);
                            mainActivity.M.c(false);
                            int i12 = mainActivity.d;
                            if (i12 != 1) {
                                if (i12 != 2) {
                                    i3 = 2131558499;
                                } else {
                                    throw null;
                                }
                            } else {
                                throw null;
                            }
                        } else if (i10 == 3) {
                            mainActivity.f578i0 = 0;
                            if (mainActivity.f582k0) {
                                mainActivity.f582k0 = false;
                                mainActivity.H.setGravity(false);
                                mainActivity.C.setBackground(mainActivity.getDrawable(2131558468));
                            }
                            mainActivity.f608z.setVisibility(8);
                            mainActivity.f579j.setVisibility(8);
                            mainActivity.f585m.setVisibility(4);
                            mainActivity.f571f.setVisibility(4);
                            mainActivity.f581k.setVisibility(4);
                            mainActivity.f606y.setVisibility(4);
                            throw null;
                        } else {
                            i3 = 2131558497;
                        }
                        mainActivity.D.setBackground(mainActivity.getDrawable(i3));
                        return;
                    case 9:
                        if (mainActivity.W) {
                            mainActivity.o();
                            mainActivity.W = false;
                            mainActivity.X = false;
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558525));
                            return;
                        }
                        if (!Environment.getExternalStorageState().equals("mounted")) {
                            blockSize = 0;
                        } else {
                            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                            statFs.getBlockCount();
                            long availableBlocks = statFs.getAvailableBlocks();
                            statFs.getFreeBlocks();
                            blockSize = ((availableBlocks * statFs.getBlockSize()) / 1024) / 1024;
                        }
                        if (blockSize > 100) {
                            mainActivity.f583l.setVisibility(0);
                            mainActivity.F.setText("00:00");
                            mainActivity.C0.postDelayed(mainActivity.B0, 500L);
                            mainActivity.W = true;
                            mainActivity.X = true;
                            mainActivity.Z = true;
                            mainActivity.f566b0 = System.currentTimeMillis() + ".mp4";
                            mainActivity.A.setBackground(mainActivity.getDrawable(2131558526));
                            return;
                        }
                        Toast.makeText(mainActivity, mainActivity.getString(2131755349), 1).show();
                        return;
                    default:
                        if (mainActivity.Y) {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558531));
                        } else {
                            mainActivity.B.setBackground(mainActivity.getDrawable(2131558532));
                        }
                        mainActivity.Y = !mainActivity.Y;
                        return;
                }
            }
        });
        this.f567c0 = new ByteArrayOutputStream();
        this.f568d0 = Executors.newSingleThreadExecutor();
        this.f572f0 = Executors.newSingleThreadExecutor();
        this.f570e0 = Executors.newFixedThreadPool(5);
        Executors.newSingleThreadExecutor();
        int i3 = this.d;
        byte[] bArr = this.f574g0;
        if (i3 != 1) {
            if (i3 == 2) {
                bArr[0] = -52;
                bArr[1] = Byte.MIN_VALUE;
                bArr[2] = Byte.MIN_VALUE;
                bArr[3] = Byte.MIN_VALUE;
                bArr[4] = Byte.MIN_VALUE;
                bArr[5] = 0;
                bArr[6] = (byte) 0;
                bArr[7] = 51;
            }
        } else {
            bArr[0] = 102;
            bArr[1] = Byte.MIN_VALUE;
            bArr[2] = Byte.MIN_VALUE;
            bArr[3] = Byte.MIN_VALUE;
            bArr[4] = Byte.MIN_VALUE;
            bArr[5] = 0;
            bArr[6] = (byte) 0;
            bArr[7] = -103;
        }
        ?? obj = new Object();
        obj.b = null;
        obj.d = null;
        obj.f3525h = false;
        obj.f3526i = 0;
        obj.f3527j = 0;
        this.L = obj;
        this.I.setVisibility(0);
        this.L.d(true);
        this.L.c();
        Log.d("MainActivity", "设备初始化默认已连接");
        ?? obj2 = new Object();
        obj2.b = null;
        obj2.c = null;
        obj2.f3518e = true;
        obj2.f3519f = new byte[]{-52, 90, 1, -125, 9, 102, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, Byte.MIN_VALUE, 0, 0, -103, 0};
        this.M = obj2;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        registerReceiver(this.G0, intentFilter);
        this.f608z.setVisibility(8);
        this.f579j.setVisibility(8);
        this.f585m.setVisibility(8);
        this.f571f.setVisibility(4);
        this.f581k.setVisibility(4);
        if (this.f605x0 == null) {
            v2.b bVar = new v2.b(this);
            this.f605x0 = bVar;
            bVar.d = this;
        }
        b bVar2 = new b(this);
        this.f603w0 = bVar2;
        bVar2.c = this;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (this.W) {
            o();
            this.W = false;
            this.X = false;
            this.A.setBackground(getDrawable(2131558525));
        }
        unregisterReceiver(this.G0);
        this.f568d0.shutdown();
        this.f570e0.shutdown();
        this.f572f0.shutdown();
        if (this.R != null) {
            this.R = null;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        this.H.c();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        this.U = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        this.H.e();
        this.U = true;
        if (this.W) {
            o();
            this.W = false;
            this.X = false;
            this.A.setBackground(getDrawable(2131558525));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        if (z3) {
            h3.b.f().b(this);
        }
        super.onWindowFocusChanged(z3);
    }

    public final void p(String str) {
        Log.d("MainActivity谁发送", str);
        byte[] bArr = this.f574g0;
        bArr[6] = (byte) (((((bArr[1] ^ bArr[2]) ^ bArr[3]) ^ bArr[4]) ^ bArr[5]) & 255);
        this.M.d(bArr);
    }

    public final void q(String str) {
        Toast.makeText(this, str, 0).show();
    }
}
