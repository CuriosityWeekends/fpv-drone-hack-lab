package com.lg.picturesubmitt.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import c1.b;
import com.bumptech.glide.d;
import com.lg.picturesubmitt.activity.ControlActivity;
import com.lg.picturesubmitt.activity.SplashActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import p4.m;
import t2.g0;
import t2.h0;
import v3.c;
/* loaded from: /home/j/curio/fpv-drone-hack-lab/apk_hack/extracted/classes.dex */
public class SplashActivity extends BaseActivity {

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ int f811i = 0;
    public WifiManager c;
    public c d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f812e;

    /* renamed from: g  reason: collision with root package name */
    public b f814g;

    /* renamed from: f  reason: collision with root package name */
    public boolean f813f = false;

    /* renamed from: h  reason: collision with root package name */
    public int f815h = 0;

    public static void l(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                new File(str2).mkdirs();
                for (String str3 : list) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    String str4 = File.separator;
                    sb.append(str4);
                    sb.append(str3);
                    l(context, sb.toString(), str2 + str4 + str3);
                }
                return;
            }
            File file = new File(str2);
            if (!file.exists()) {
                InputStream open = context.getAssets().open(str);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        open.close();
                        fileOutputStream.close();
                        return;
                    }
                }
            } else {
                Log.d("SplashActivity", "音乐已存在:" + str2);
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(2131427384);
        h3.b.f().c(this);
        this.d = new c(this);
        this.c = (WifiManager) getApplication().getApplicationContext().getSystemService("wifi");
        TextView textView = (TextView) findViewById(2131231484);
        this.f812e = textView;
        StringBuilder sb = new StringBuilder(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        try {
            str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "";
        }
        sb.append(str);
        textView.setText(sb.toString());
        this.f812e.setOnClickListener(new View.OnClickListener(this) { // from class: t2.f0
            public final /* synthetic */ SplashActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashActivity splashActivity = this.b;
                switch (r2) {
                    case 0:
                        int i3 = splashActivity.f815h + 1;
                        splashActivity.f815h = i3;
                        if (i3 >= 5) {
                            if (splashActivity.f813f) {
                                splashActivity.f813f = false;
                                Toast.makeText(splashActivity, "已关闭参数设置", 0).show();
                            } else {
                                splashActivity.f813f = true;
                                Toast.makeText(splashActivity, "已开启参数设置", 0).show();
                            }
                            c1.b bVar = splashActivity.f814g;
                            boolean z3 = splashActivity.f813f;
                            SharedPreferences.Editor editor = (SharedPreferences.Editor) bVar.c;
                            editor.putBoolean("isShowOpticalFlowView", z3);
                            editor.commit();
                            splashActivity.f815h = 0;
                        }
                        a1.i.u(new StringBuilder("numClick="), splashActivity.f815h, "SplashActivity");
                        return;
                    default:
                        int i5 = SplashActivity.f811i;
                        splashActivity.getClass();
                        splashActivity.startActivity(new Intent(splashActivity, ControlActivity.class));
                        return;
                }
            }
        });
        findViewById(2131230873).setOnClickListener(new h0(this, 0));
        findViewById(2131230865).setOnClickListener(new h0(this, 1));
        b bVar = new b(this, 22);
        this.f814g = bVar;
        this.f813f = bVar.t("isShowOpticalFlowView");
        m a5 = d.a(findViewById(2131230835));
        c cVar = this.d;
        cVar.getClass();
        a5.d(new v3.b(cVar, new String[]{"android.permission.ACCESS_FINE_LOCATION"})).g(new o4.b(new g0(this, 0)));
        findViewById(2131230855).setOnClickListener(new View.OnClickListener(this) { // from class: t2.f0
            public final /* synthetic */ SplashActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashActivity splashActivity = this.b;
                switch (r2) {
                    case 0:
                        int i3 = splashActivity.f815h + 1;
                        splashActivity.f815h = i3;
                        if (i3 >= 5) {
                            if (splashActivity.f813f) {
                                splashActivity.f813f = false;
                                Toast.makeText(splashActivity, "已关闭参数设置", 0).show();
                            } else {
                                splashActivity.f813f = true;
                                Toast.makeText(splashActivity, "已开启参数设置", 0).show();
                            }
                            c1.b bVar2 = splashActivity.f814g;
                            boolean z3 = splashActivity.f813f;
                            SharedPreferences.Editor editor = (SharedPreferences.Editor) bVar2.c;
                            editor.putBoolean("isShowOpticalFlowView", z3);
                            editor.commit();
                            splashActivity.f815h = 0;
                        }
                        a1.i.u(new StringBuilder("numClick="), splashActivity.f815h, "SplashActivity");
                        return;
                    default:
                        int i5 = SplashActivity.f811i;
                        splashActivity.getClass();
                        splashActivity.startActivity(new Intent(splashActivity, ControlActivity.class));
                        return;
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        Log.d("SplashActivity", "onResume");
        String[] strArr = Build.VERSION.SDK_INT >= 33 ? new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO", "android.permission.ACCESS_FINE_LOCATION"} : new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION"};
        c cVar = this.d;
        cVar.getClass();
        h4.b.f(c.b).d(new v3.b(cVar, strArr)).g(new o4.b(new g0(this, 1)));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z3) {
        if (z3) {
            h3.b.f().b(this);
        }
        super.onWindowFocusChanged(z3);
    }
}
